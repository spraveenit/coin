package com.praveen.denominations;

import com.praveen.denominations.model.Balance;
import com.praveen.denominations.model.Denomination;

import java.util.HashMap;
import java.util.Map;

/**
 * Currency class represents a particular type
 * of currency and its available denominations.
 * The class includes method to retrieve given
 * balance in minimum denominations
 */
public abstract class Currency {

    private String country;
    private String name;
    private Map<Integer, Denomination> availableDenominations;

    public Currency(String country, String name, Map<Integer, Denomination> availableDenominations) {
        this.country = country;
        this.name = name;
        this.availableDenominations = availableDenominations;
    }

    public String getCountry() {
        return country;
    }

    public String getName() {
        return name;
    }

    public Map<Integer, Denomination> getAvailableDenominations() {
        return availableDenominations;
    }

    /**
     * @param balance
     * @return Representation of balance in denominations
     * of the given currency and its count to match
     * the balance
     */
    public Balance denominateBalanceToMinimumCurrency(int balance) {

        Map<Integer, Balance> memo = createBalanceDenominationMemoMap();

        //find denominations set for each sub problem from 0 till the value of balance and store it in memo for reuse
        for (int subBalance = 1; subBalance <= balance; subBalance++) {

            //loop through all the available denomination to find solution set to sub problem
            for (Denomination denomination : availableDenominations.values()) {

                //check and add if selected denomination can be part of solution set
                if (subBalance >= denomination.getValue()) {

                    //check if there is already a solution set for remaining balance after deducting denomination
                    Balance remainingSubBalanceResult = memo.get(subBalance - denomination.getValue());

                    Balance existingSubBalanceResult = memo.get(subBalance);
                    //check if new solution set has minimal count compared to existing solution set for the subBalance and overwrite it to the memo
                    if (existingSubBalanceResult == null || isDenominationCountMinimum(remainingSubBalanceResult, existingSubBalanceResult)) {

                        Balance newSubBalanceResult = createBalanceFrom(remainingSubBalanceResult);

                        if (newSubBalanceResult.getChangeMap().containsKey(denomination)) {
                            int val = newSubBalanceResult.getChangeMap().get(denomination) + 1;
                            newSubBalanceResult.getChangeMap().put(denomination, val);
                        } else {
                            newSubBalanceResult.getChangeMap().put(denomination, 1);
                        }
                        memo.put(subBalance, newSubBalanceResult);
                    }
                }
            }
        }
        return memo.get(balance);
    }

    /**
     * check if new solution set has minimal count compared
     * to existing solution set for the subBalance and
     * overwrite it to the memo
     *
     * @param remainingSubBalanceResult
     * @param existingSubBalanceResult
     * @return
     */
    private boolean isDenominationCountMinimum(Balance remainingSubBalanceResult, Balance existingSubBalanceResult) {
        return remainingSubBalanceResult != null && getCountOfDenominations(remainingSubBalanceResult) + 1 < getCountOfDenominations(existingSubBalanceResult);
    }

    /**
     * make a new Balance object from remainingSubBalanceResult
     * so that it is not overwritten
     *
     * @param subResult
     * @return
     */
    private Balance createBalanceFrom(Balance subResult) {
        if(subResult !=null) {
            return Balance.builder().changeMap(new HashMap<>(subResult.getChangeMap())).build();
        }else{
            return Balance.builder().changeMap(new HashMap<>()).build();
        }
    }

    /**
     * Get count of denominations by summing the counts
     * @param subResult
     * @return
     */
    private int getCountOfDenominations(Balance subResult) {
        return subResult.getChangeMap().values().stream().mapToInt(Integer::intValue).sum();
    }

    /**
     * creates memo map for storing results of sub problems
     * with key as input and value holding the result
     *
     * @return Map with key as integer balance and
     * value as Balance object representing map of denomination,count
     */
    private Map<Integer, Balance> createBalanceDenominationMemoMap() {

        Map<Integer, Balance> memo = new HashMap<>();
        //Add initial values
        //empty Balance for balance 0
        memo.put(0, Balance.builder().changeMap(new HashMap<>()).build());
        return memo;
    }
}

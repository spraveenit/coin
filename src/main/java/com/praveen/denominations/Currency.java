package com.praveen.denominations;

import com.praveen.denominations.model.Denomination;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *  Currency class represents a particular type
 *  of currency and its available denominations.
 *  The class includes method to retrieve given
 *  balance in minimum denominations
 */
public abstract class Currency {

    private String country;
    private String name;
    private Map<Integer,Denomination> availableDenominations;

    public Currency(String country, String name, Map<Integer,Denomination> availableDenominations) {
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

    public Map<Integer,Denomination> getAvailableDenominations() {
        return availableDenominations;
    }

    /**
     *
     * @param balance
     * @return Representation of balance in denominations
     * of the given currency and its count to match
     * the balance
     */
    public Map<Denomination,Integer> denominateBalanceToMinimumCurrency(int balance){

        Map<Integer,Map<Denomination,Integer>> memo = new HashMap<>();

        memo.put(0, new HashMap<>());

        for(int i=1;i<=balance;i++){

            for(Denomination j:availableDenominations.values()) {
                if(i >= j.getValue()) {
                    Map<Denomination, Integer> subResult = memo.get(i - j.getValue());
                    if(memo.get(i) == null || (subResult != null && subResult.values().stream().mapToInt(Integer::intValue).sum() + 1 < memo.get(i).values().stream().mapToInt(Integer::intValue).sum())){
                        Map<Denomination, Integer> iResult = new HashMap(subResult);
                        if(iResult.containsKey(j)){
                            int val = iResult.get(j)+1;
                            iResult.put(j, val);
                        }else{
                            iResult.put(j,1);
                        }
                        memo.put(i,iResult);
                    }
                }
            }
        }
        return memo.get(balance);
    }
}

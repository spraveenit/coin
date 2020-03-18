package com.praveen.denominations;

import com.praveen.denominations.model.Balance;
import org.junit.Assert;
import org.junit.Test;

public class INRTest {

    @Test
    public void shouldReturn5AsMinDenominationsCountFor87INR(){
        //given
        INR subject = new INR();

        //when
        Balance result = subject.denominateBalanceToMinimumCurrency(87);

        //then
        Assert.assertEquals(5, result.getChangeMap().values().stream().mapToInt(Integer::intValue).sum());
        Assert.assertEquals(1, result.getChangeMap().get(subject.getAvailableDenominations().get(50)).intValue());
        Assert.assertEquals(1, result.getChangeMap().get(subject.getAvailableDenominations().get(25)).intValue());
        Assert.assertEquals(1, result.getChangeMap().get(subject.getAvailableDenominations().get(10)).intValue());
        Assert.assertEquals(2, result.getChangeMap().get(subject.getAvailableDenominations().get(1)).intValue());
    }

    @Test
    public void shouldReturn6AsMinDenominationsCountFor287INR(){
        //given
        INR subject = new INR();

        //when
        Balance result = subject.denominateBalanceToMinimumCurrency(287);

        //then
        Assert.assertEquals(7, result.getChangeMap().values().stream().mapToInt(Integer::intValue).sum());
        Assert.assertEquals(2, result.getChangeMap().get(subject.getAvailableDenominations().get(100)).intValue());
        Assert.assertEquals(1, result.getChangeMap().get(subject.getAvailableDenominations().get(50)).intValue());
        Assert.assertEquals(1, result.getChangeMap().get(subject.getAvailableDenominations().get(25)).intValue());
        Assert.assertEquals(1, result.getChangeMap().get(subject.getAvailableDenominations().get(10)).intValue());
        Assert.assertEquals(2, result.getChangeMap().get(subject.getAvailableDenominations().get(1)).intValue());
    }

}
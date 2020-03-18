package com.praveen.denominations;

import com.praveen.denominations.model.Balance;
import com.praveen.denominations.model.Denomination;
import org.junit.Assert;
import org.junit.Test;

import java.util.Map;

public class USDTest {

    @Test
    public void shouldReturn5AsMinDenominationsCountFor87USD(){
        //given
        USD subject = new USD();

        //when
        Balance result = subject.denominateBalanceToMinimumCurrency(87);

        //then
        Assert.assertEquals(6, result.getChangeMap().values().stream().mapToInt(Integer::intValue).sum());
        Assert.assertEquals(3, result.getChangeMap().get(subject.getAvailableDenominations().get(25)).intValue());
        Assert.assertEquals(1, result.getChangeMap().get(subject.getAvailableDenominations().get(10)).intValue());
        Assert.assertEquals(2, result.getChangeMap().get(subject.getAvailableDenominations().get(1)).intValue());
    }

    @Test
    public void shouldReturn6AsMinDenominationsCountFor287USD(){
        //given
        USD subject = new USD();

        //when
        Balance result = subject.denominateBalanceToMinimumCurrency(287);

        //then
        Assert.assertEquals(7, result.getChangeMap().values().stream().mapToInt(Integer::intValue).sum());
        Assert.assertEquals(1, result.getChangeMap().get(subject.getAvailableDenominations().get(200)).intValue());
        Assert.assertEquals(3, result.getChangeMap().get(subject.getAvailableDenominations().get(25)).intValue());
        Assert.assertEquals(1, result.getChangeMap().get(subject.getAvailableDenominations().get(10)).intValue());
        Assert.assertEquals(2, result.getChangeMap().get(subject.getAvailableDenominations().get(1)).intValue());
    }
}
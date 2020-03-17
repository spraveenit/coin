package com.praveen.denominations;

import com.praveen.denominations.model.Denomination;
import org.junit.Assert;
import org.junit.Test;

import java.util.Map;

public class INRTest {

    @Test
    public void shouldReturn5AsMinDenominationsCountFor87INR(){
        //given
        INR subject = new INR();

        //when
        Map<Denomination, Integer> result = subject.denominateBalanceToMinimumCurrency(87);

        //then
        Assert.assertEquals(5, result.values().stream().mapToInt(Integer::intValue).sum());
        Assert.assertEquals(1, result.get(subject.getAvailableDenominations().get(50)).intValue());
        Assert.assertEquals(1, result.get(subject.getAvailableDenominations().get(25)).intValue());
        Assert.assertEquals(1, result.get(subject.getAvailableDenominations().get(10)).intValue());
        Assert.assertEquals(2, result.get(subject.getAvailableDenominations().get(1)).intValue());
    }

    @Test
    public void shouldReturn6AsMinDenominationsCountFor287INR(){
        //given
        INR subject = new INR();

        //when
        Map<Denomination, Integer> result = subject.denominateBalanceToMinimumCurrency(287);

        //then
        Assert.assertEquals(7, result.values().stream().mapToInt(Integer::intValue).sum());
        Assert.assertEquals(2, result.get(subject.getAvailableDenominations().get(100)).intValue());
        Assert.assertEquals(1, result.get(subject.getAvailableDenominations().get(50)).intValue());
        Assert.assertEquals(1, result.get(subject.getAvailableDenominations().get(25)).intValue());
        Assert.assertEquals(1, result.get(subject.getAvailableDenominations().get(10)).intValue());
        Assert.assertEquals(2, result.get(subject.getAvailableDenominations().get(1)).intValue());
    }

}
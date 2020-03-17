package com.praveen.denominations;

import com.praveen.denominations.model.Denomination;

import java.util.HashMap;
import java.util.Map;

/**
 * This class represents INR Currency
 * and its denominations
 */
public class INR extends Currency{

    public INR() {
        super("INDIA","INR", initINRDenominations());
    }

    private static Map<Integer,Denomination> initINRDenominations() {
        return new HashMap<Integer,Denomination>(){{
            put(1,Denomination.builder().name("1 paise").type(Denomination.Type.COIN).value(1).build());
            put(5,Denomination.builder().name("5 paise").type(Denomination.Type.COIN).value(5).build());
            put(10,Denomination.builder().name("10 paise").type(Denomination.Type.COIN).value(10).build());
            put(20,Denomination.builder().name("20 paise").type(Denomination.Type.COIN).value(20).build());
            put(25,Denomination.builder().name("25 paise").type(Denomination.Type.COIN).value(25).build());
            put(50,Denomination.builder().name("50 paise").type(Denomination.Type.COIN).value(50).build());
            put(100,Denomination.builder().name("1 rupee").type(Denomination.Type.COIN).value(100).build());
            put(500,Denomination.builder().name("5 rupee").type(Denomination.Type.COIN).value(500).build());
            put(1000,Denomination.builder().name("10 rupee").type(Denomination.Type.NOTE).value(1000).build());
            put(5000,Denomination.builder().name("50 rupee").type(Denomination.Type.NOTE).value(5000).build());
            put(10000,Denomination.builder().name("100 rupee").type(Denomination.Type.NOTE).value(10000).build());
            put(20000,Denomination.builder().name("200 rupee").type(Denomination.Type.NOTE).value(20000).build());
            put(50000,Denomination.builder().name("500 rupee").type(Denomination.Type.NOTE).value(50000).build());
            put(200000,Denomination.builder().name("2000 rupee").type(Denomination.Type.NOTE).value(200000).build());
        }};
    }
}

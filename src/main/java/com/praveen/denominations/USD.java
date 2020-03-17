package com.praveen.denominations;

import com.praveen.denominations.model.Denomination;

import java.util.HashMap;
import java.util.Map;

/**
 * This class represents USD currency
 * and its denominations
 */
public class USD extends Currency{

    public USD() {
        super("USA","USD", initINRDenominations());
    }

    private static Map<Integer,Denomination> initINRDenominations() {
        return new HashMap<Integer,Denomination>(){{
            put(1,Denomination.builder().name("Penny").type(Denomination.Type.COIN).value(1).build());
            put(10,Denomination.builder().name("Dime").type(Denomination.Type.COIN).value(10).build());
            put(25,Denomination.builder().name("Quarters").type(Denomination.Type.COIN).value(25).build());
            put(100,Denomination.builder().name("Dollar").type(Denomination.Type.COIN).value(100).build());
            put(200,Denomination.builder().name("2 Dollar").type(Denomination.Type.COIN).value(200).build());
            put(500,Denomination.builder().name("5 Dollar").type(Denomination.Type.COIN).value(500).build());
            put(1000,Denomination.builder().name("10 Dollar").type(Denomination.Type.COIN).value(1000).build());
            put(2000,Denomination.builder().name("20 Dollar").type(Denomination.Type.COIN).value(2000).build());
            put(5000,Denomination.builder().name("50 Dollar").type(Denomination.Type.COIN).value(5000).build());
            put(10000,Denomination.builder().name("100 Dollar").type(Denomination.Type.COIN).value(10000).build());
        }};
    }
}

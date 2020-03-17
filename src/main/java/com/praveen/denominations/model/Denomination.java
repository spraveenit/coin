package com.praveen.denominations.model;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class Denomination {

    private String name;
    private int value;
    private Type type;

    public enum Type{
        COIN,
        NOTE
    }
}

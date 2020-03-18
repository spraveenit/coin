package com.praveen.denominations.model;

import lombok.Builder;
import lombok.Data;

import java.util.List;
import java.util.Map;

/**
 * This class represents list of denomination,count
 */
@Builder
@Data
public class Balance {

    private Map<Denomination,Integer> changeMap;

}

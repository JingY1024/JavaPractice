package edu.nyu.cs9053.homework7;


import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ReubenSandwichTest {

    @Test
    public void testGetSandwich() {
        assertEquals("breadpastramibread", new ReubenSandwich("pastrami", "bread").getSandwich());
    }

}

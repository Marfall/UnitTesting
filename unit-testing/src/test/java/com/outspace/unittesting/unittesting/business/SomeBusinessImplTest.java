package com.outspace.unittesting.unittesting.business;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SomeBusinessImplTest {

    @Test
    public void calculateSum() {
        SomeBusinessImpl business = new SomeBusinessImpl();
        int actualResult = business.calculateSum(new int[] {1, 2, 3});
        int expectResult = 6;
        assertEquals(expectResult, actualResult);
    }

    @Test
    public void calculateSum_empty() {
        SomeBusinessImpl business = new SomeBusinessImpl();
        int actualResult = business.calculateSum(new int[] {});
        int expectResult = 0;
        assertEquals(expectResult, actualResult);
    }

    @Test
    public void calculateSum_oneValue() {
        SomeBusinessImpl business = new SomeBusinessImpl();
        int actualResult = business.calculateSum(new int[] {5});
        int expectResult = 5;
        assertEquals(expectResult, actualResult);
    }
}
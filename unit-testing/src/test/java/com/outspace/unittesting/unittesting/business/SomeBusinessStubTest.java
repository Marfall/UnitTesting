package com.outspace.unittesting.unittesting.business;

import com.outspace.unittesting.unittesting.data.SomeDataService;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SomeDataServiceStub implements SomeDataService {
    @Override
    public int[] retrieveAllData() {
        return new int[] {1 ,2, 3};
    }
}

class SomeDataServiceStubEmpty implements  SomeDataService {
    @Override
    public int[] retrieveAllData() {
        return new int[0];
    }
}

class SomeDataServiceStubOneValue implements SomeDataService {
    @Override
    public int[] retrieveAllData() {
        return new int[] {5};
    }
}

class SomeBusinessStubTest {

    @Test
    public void calculateSumUsingDataService_basic() {
        SomeBusinessImpl business = new SomeBusinessImpl();
        business.setSomeDataService(new SomeDataServiceStub());

        int actualResult = business.calculateSumUsingDataService();
        int expectResult = 6;
        assertEquals(expectResult, actualResult);
    }

    @Test
    public void calculateSum_empty() {
        SomeBusinessImpl business = new SomeBusinessImpl();
        business.setSomeDataService(new SomeDataServiceStubEmpty());
        int actualResult = business.calculateSumUsingDataService();
        int expectResult = 0;
        assertEquals(expectResult, actualResult);
    }

    @Test
    public void calculateSum_oneValue() {
        SomeBusinessImpl business = new SomeBusinessImpl();
        business.setSomeDataService(new SomeDataServiceStubOneValue());

        int actualResult = business.calculateSumUsingDataService();
        int expectResult = 5;
        assertEquals(expectResult, actualResult);
    }
}
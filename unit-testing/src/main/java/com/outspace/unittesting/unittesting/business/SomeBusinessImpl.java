package com.outspace.unittesting.unittesting.business;

import com.outspace.unittesting.unittesting.data.SomeDataService;

public class SomeBusinessImpl {

    SomeDataService someDataService;

    public int calculateSum(int[] data) {
        int sum = 0;
        for (int value:data) {
            sum += value;
        }
        return sum;
    }

    public int calculateSumUsingDataService() {
        int sum = 0;
        int[] data = someDataService.retrieveAllData();
        for (int value:data) {
            sum += value;
        }
        return sum;
    }

    public void setSomeDataService(SomeDataService someDataService) {
        this.someDataService = someDataService;
    }
}

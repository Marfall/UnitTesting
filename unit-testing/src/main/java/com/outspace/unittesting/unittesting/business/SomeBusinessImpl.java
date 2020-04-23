package com.outspace.unittesting.unittesting.business;

import com.outspace.unittesting.unittesting.data.SomeDataService;

import java.util.Arrays;
import java.util.OptionalInt;

public class SomeBusinessImpl {

    SomeDataService someDataService;

    public int calculateSum(int[] data) {
        // 1,2,3,4,5 => 1+2+3+4+5
        return Arrays.stream(data).reduce(Integer::sum).orElse(0);
    }

    public int calculateSumUsingDataService() {
        int sum = 0;
        int[] data = someDataService.retrieveAllData();
        return Arrays.stream(data)
                .reduce(Integer::sum).orElse(0);
    }

    public void setSomeDataService(SomeDataService someDataService) {
        this.someDataService = someDataService;
    }
}

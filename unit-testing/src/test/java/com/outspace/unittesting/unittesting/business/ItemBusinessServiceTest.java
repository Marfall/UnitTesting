package com.outspace.unittesting.unittesting.business;

import com.outspace.unittesting.unittesting.data.ItemRepository;
import com.outspace.unittesting.unittesting.model.Item;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(SpringExtension.class)
class ItemBusinessServiceTest {

    @InjectMocks
    private ItemBusinessService business;

    @Mock
    private ItemRepository repository;

    @Test
    public void calculateSumUsingDataService_basic() {
        when(repository.findAll()).thenReturn(
                Arrays.asList(new Item(2, "Item2", 10, 10),
                        new Item(3, "Item3", 20, 20)));

        List<Item> items = business.retrieveAllItems();
        System.out.println(items);
        System.out.println(items.get(0));
        System.out.println(items.get(1));
        assertEquals(100, items.get(0).getValue());
        assertEquals(400, items.get(1).getValue());
    }
}
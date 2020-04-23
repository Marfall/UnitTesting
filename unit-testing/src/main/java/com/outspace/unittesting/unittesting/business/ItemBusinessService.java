package com.outspace.unittesting.unittesting.business;

import com.outspace.unittesting.unittesting.data.ItemRepository;
import com.outspace.unittesting.unittesting.model.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemBusinessService {

    @Autowired
    private ItemRepository repository;

    public Item retrieveHardcodedItem() {
        return new Item(1, "Ball", 10,100);
    }

    public List<Item> retrieveAllItems() {
        List<Item> items =  repository.findAll();
        for(Item item : items) {
            item.setValue(item.getPrice() * item.getQuantity());
        }
        return items;
    }
}

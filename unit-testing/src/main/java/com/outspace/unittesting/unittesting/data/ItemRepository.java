package com.outspace.unittesting.unittesting.data;

import com.outspace.unittesting.unittesting.model.Item;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemRepository extends JpaRepository<Item, Integer> {
}

package com.uob.service;

import com.uob.model.Item;

import java.util.List;

public interface ItemService {
    Item addItem(Item item);
    Item updateItem(Item item);
    List<Item> getAllItem();
    Item getItemId(long itemId);
    void deleteItem(long itemId);
}

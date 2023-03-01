package com.uob.service;

import com.uob.exception.ResourceNotFoundException;
import com.uob.model.Item;
import com.uob.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class ItemServiceImplementation implements ItemService{
    @Autowired
    private ItemRepository itemRepository;

    @Override
    public Item addItem(Item item) {
        return itemRepository.save(item);
    }

    @Override
    public Item updateItem(Item item) {

        Optional<Item> item_db = this.itemRepository.findById(item.getId());

        if(item_db.isPresent()){
           Item itemUpdate = item_db.get();
           itemUpdate.setId(item.getId());
           itemUpdate.setName(item.getName());
           itemUpdate.setSize(item.getSize());
           itemUpdate.setPrice(item.getPrice());
           itemRepository.save(itemUpdate);
           return itemUpdate;
        }else {
            throw new ResourceNotFoundException("Record not found with id : " + item.getId());
        }
    }

    @Override
    public List<Item> getAllItem() {
        return this.itemRepository.findAll();
    }

    @Override
    public Item getItemId(long itemId) {

        Optional<Item> item_db = this.itemRepository.findById(itemId);

        if(item_db.isPresent()){
            return item_db.get();
        }
        else {
            throw new ResourceNotFoundException("Record not found with id : " + itemId);
        }
    }

    @Override
    public void deleteItem(long itemId) {
        Optional<Item> item_db = this.itemRepository.findById(itemId);

        if(item_db.isPresent()){
            this.itemRepository.delete(item_db.get());
        }
        else {
            throw new ResourceNotFoundException("Record not found with id : " + itemId);
        }
    }
}

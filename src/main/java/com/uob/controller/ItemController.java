package com.uob.controller;

import com.uob.model.Item;
import com.uob.service.ItemService;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:8081")
@RestController
@RequestMapping("/api")
public class ItemController {

    @Autowired
    private ItemService itemService;

    @GetMapping("/items")
    public ResponseEntity <List<Item>> getAllItem(){
        return ResponseEntity.ok().body(itemService.getAllItem());

    }

    @GetMapping("/items/{id}")
    public ResponseEntity <Item> getItemId(@PathVariable long id){
        return ResponseEntity.ok().body(itemService.getItemId(id));
    }

    @PutMapping("/items/{id}")
    public ResponseEntity <Item> updateItem(@PathVariable long id, @RequestBody Item item){
        item.setId(id);
        return ResponseEntity.ok().body(itemService.updateItem(item));
    }

    @PostMapping("/items")
    public ResponseEntity <Item> addItem(@RequestBody Item item){
        return ResponseEntity.ok().body(itemService.addItem(item));
    }

    @DeleteMapping("/products/{id}")
    public HttpStatus deleteItem(@PathVariable long id) {
        this.itemService.deleteItem(id);
        return HttpStatus.OK;
    }

}

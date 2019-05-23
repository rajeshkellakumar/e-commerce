package com.omnicuris.ecommerce.ecommerce.controller;

import com.omnicuris.ecommerce.ecommerce.entity.Item;
import com.omnicuris.ecommerce.ecommerce.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/items")
public class ItemController {

    @Autowired
    private ItemService itemService;

    @PostMapping()
    public Item createItem(@Valid @RequestBody Item item){
        return itemService.createItme(item);
    }

    @PutMapping("{id}")
    public ResponseEntity updateItem(@PathVariable(value = "id") Long id,@Valid @RequestBody Item item){
        itemService.updateItem(id,item);
        return ResponseEntity.ok().body("Updated Successfully");
    }

    @DeleteMapping("{id}")
    public ResponseEntity deleteItem(@PathVariable(value = "id") Long id) {
        itemService.deleteItemById(id);
        return ResponseEntity.ok().body("deleted Successfully");
    }

    @GetMapping("{id}")
    public Item getItemId(@PathVariable(value = "id") Long id){
        return itemService.getItemById(id);
    }

    @GetMapping()
    public List<Item> getItems(){
        return itemService.getAllItems();
    }

}

package com.omnicuris.ecommerce.ecommerce.service;

import com.omnicuris.ecommerce.ecommerce.entity.Item;
import com.omnicuris.ecommerce.ecommerce.exception.ItemNotFoundException;
import com.omnicuris.ecommerce.ecommerce.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ItemService {

    @Autowired
    private ItemRepository itemRepository;

    public Item createItme(Item item){
        return saveItem(item);
    }

    public void updateItem(Long id,Item item){
        Item newItem = itemRepository.findById(id)
                .orElseThrow(()->new ItemNotFoundException("No item exists with the id: "+id.toString()));
        newItem.setItemName(item.getItemName());
        newItem.setItemDesc(item.getItemDesc());
        newItem.setItemPrice(item.getItemPrice());
        newItem.setAvailableQty(item.getAvailableQty());
        saveItem(newItem);
    }

    public void deleteItemById(Long id){
        Item item = itemRepository.findById(id)
                .orElseThrow(()->new ItemNotFoundException("No item exists with the id: "+id.toString()));
        itemRepository.delete(item);
    }

    public Item getItemById(Long id){
        return itemRepository.findById(id)
                .orElseThrow(()->new ItemNotFoundException("No item exists with the id: "+id.toString()));
    }

    public List<Item> getAllItems(){
        return itemRepository.findAll();
    }

    public Item saveItem(Item item){
        return itemRepository.save(item);
    }
}

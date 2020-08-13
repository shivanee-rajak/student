package com.dxctraining.service;

import com.dxctraining.dao.ItemDao;
import com.dxctraining.entities.Item;
import com.dxctraining.exceptions.InvalidArgumentException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Service
public class ItemServiceImpl implements ItemService{

    @Autowired
    private ItemDao dao;

    @Override
    public Item findItem(int id) {
        Item item= dao.findItem(id);
         return item;
     }
    
    @Override
    public Item save(Item item) {
        validate(item);
        item=dao.save(item);
        return item;
    }

    

    @Override
    public Item update(Item item) {
        validate(item);
        item=dao.update(item);
        return item;
    }

   

    @Override
    public void remove(int id) {
       dao.removeItem(id);
    }

    public void validate(Object itm){
        if(itm==null){
            throw new InvalidArgumentException("field not found");
        }
    }
}

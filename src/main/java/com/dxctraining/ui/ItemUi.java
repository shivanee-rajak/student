package com.dxctraining.ui;

import com.dxctraining.entities.Item;
import com.dxctraining.exceptions.ItemNotFoundException;
import com.dxctraining.exceptions.InvalidArgumentException;
import com.dxctraining.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class ItemUi {
    @Autowired
    private ItemService service;


    @PostConstruct
    public void runUi(){
        try {
        	Item item1=new Item(1,"pencil");
            Item item2=new Item(2,"book");
            Item item3=new Item(3,"soda");
            int id1=item1.getId();
            int id2=item2.getId();
            int id3=item3.getId();
            Item fetcheditem1=service.findItem(id1);
            Item fetcheditem2=service.findItem(id2);
            Item fetcheditem3=service.findItem(id2);
            
            System.out.println("The item is"+fetcheditem1.getId()+"  "+"The name is"+fetcheditem1.getName());
            System.out.println("The item is"+fetcheditem2.getId()+"  "+"The name is"+fetcheditem2.getName());
            System.out.println("The item is"+fetcheditem3.getId()+"  "+"The name is"+fetcheditem3.getName());
            
        }catch (ItemNotFoundException e){
            e.printStackTrace();
        }

    }



}

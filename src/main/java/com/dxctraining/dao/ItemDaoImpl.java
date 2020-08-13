package com.dxctraining.dao;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import com.dxctraining.entities.Item;
import com.dxctraining.exceptions.ItemNotFoundException;

public class ItemDaoImpl implements ItemDao{
    
	@PersistenceContext
	private EntityManager entityManager;
	
	
	@Override
	public Item findItem(int id) {
		  Item item=entityManager.find(Item.class,id);
	        if(item==null)
	        {
	            throw new ItemNotFoundException("Item not found");

	        }
	        return item;
	}

	
	@Override
	public Item update(Item item) {
		 return entityManager.merge(item);
	       
	}

	@Override
    public Item save(Item item) {
        entityManager.persist(item);
        return item;
    }
  
	
	
	
	@Override
	public void removeItem(int id) {
	     entityManager.remove((entityManager.find(Item.class,id)));
		
	}


	

	
	}
	
	
	


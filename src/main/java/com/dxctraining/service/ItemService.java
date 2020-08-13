package com.dxctraining.service;

import com.dxctraining.entities.Item;

public interface ItemService {
    Item findItem(int id);

    Item update(Item employee);

    Item save(Item employee);

    void remove(int id);
}

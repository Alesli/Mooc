package com.example.service;

import com.example.entity.Item;

import java.util.List;

public interface ItemService {

    Item findOne(Long itemId);

    List<Item> findAllFromLesson(Long lessonId);

    Item save(Item item);

    Item update(Item item);

    void delete(Long itemId);
}

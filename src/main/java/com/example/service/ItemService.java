package com.example.service;

import com.example.entity.Item;

import java.util.List;

public interface ItemService {

    Item findOneFromLesson(Long lessonItemId, Long lessonId);

    List<Item> findAllFromLesson(Long lessonId);

    Item save(Item item);

    Item update(Long lessonId, Item item);

    boolean delete(Long id);
}

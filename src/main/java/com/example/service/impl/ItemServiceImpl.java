package com.example.service.impl;

import com.example.entity.Item;
import com.example.service.ItemService;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class ItemServiceImpl implements ItemService {
    @Override
    public Item findOne(Long itemId) {
        return null;
    }

    @Override
    public List<Item> findAllFromLesson(Long lessonId) {
        return null;
    }

    @Override
    public Item save(Item item) {
        return null;
    }

    @Override
    public Item update(Item item) {
        return null;
    }

    @Override
    public boolean delete(Long id) {
        return false;
    }
}

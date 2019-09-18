package com.example.service.impl;

import com.example.entity.Item;
import com.example.repository.ItemRepository;
import com.example.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class ItemServiceImpl implements ItemService {

    @Autowired
    private ItemRepository itemRepository;

    @Override
    public Item findOne(Long itemId) {
        return itemRepository.getOne(itemId);
    }

    @Override
    public List<Item> findAllFromLesson(Long lessonId) {
        return Optional.ofNullable(itemRepository.findAllByLessonId(lessonId)).orElse(null);
    }

    @Override
    public Item save(Item item) {
        return itemRepository.save(item);
    }

    @Override
    public Item update(Item item) {
        return null;
    }

    @Override
    public void delete(Long itemId) {
        itemRepository.deleteById(itemId);
    }
}

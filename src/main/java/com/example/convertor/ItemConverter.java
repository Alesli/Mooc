package com.example.convertor;

import com.example.dto.ItemDto;
import com.example.entity.Item;
import org.springframework.stereotype.Component;

@Component
public class ItemConverter {

    public ItemDto getItemDto(Item item) {

        ItemDto itemDto = new ItemDto();
        itemDto.setId(item.getId());
        itemDto.setName(item.getName());

        return itemDto;
    }

    public Item getItem(ItemDto itemDto) {

        Item item = new Item();
        item.setId(itemDto.getId());
        item.setName(itemDto.getName());

        return item;
    }
}

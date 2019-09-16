package com.example.controller.management;

import com.example.Convertor.ItemConverter;
import com.example.dto.ItemDto;
import com.example.entity.Item;
import com.example.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/management")
public class ManageItemController {

    @Autowired
    private ItemService itemService;
    @Autowired
    private ItemConverter itemConverter;

    //    http://localhost:8080/api/management/item
    @PutMapping("/item")
    public ItemDto updateItem(@RequestBody ItemDto lessonDto) {
        Item result = itemService.update(
                itemConverter.getItem(lessonDto));
        return itemConverter.getItemDto(result);
    }

    //    http://localhost:8080/api/management/item
    @PostMapping("/item")
    public ItemDto createItem(@RequestBody ItemDto lessonDto) {
        Item result = itemService.save(
                itemConverter.getItem(lessonDto));
        return itemConverter.getItemDto(result);
    }

    //    http://localhost:8080/api/management/item/{itemId}
    @DeleteMapping("/item/{itemId}")
    public void deleteItem(@PathVariable() Long itemId) {
        itemService.delete(itemId);
    }
}

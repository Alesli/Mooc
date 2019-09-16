package com.example.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class LessonDto {

    private Long id;
    private String name;
    private String description;
    private List<ItemDto> itemDtoList;
}

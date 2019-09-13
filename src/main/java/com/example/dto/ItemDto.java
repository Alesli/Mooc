package com.example.dto;

import com.example.entity.Lesson;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ItemDto {

    private Long id;
    private Lesson lesson;
    private String name;
    private String description;
}

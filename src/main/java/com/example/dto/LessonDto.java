package com.example.dto;

import com.example.entity.Unit;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class LessonDto {

    private Long id;
    private Unit unit;
    private String name;
    private String description;
}

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
public class UnitTreeDto {

    private Long id;
    private String name;
    private List<LessonTreeDto> lessonTreeDtoList;
}

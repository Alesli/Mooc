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
public class CourseTreeDto {

    private Long id;
    private String name;
    private List<UnitTreeDto> unitTreeDtoList;
}

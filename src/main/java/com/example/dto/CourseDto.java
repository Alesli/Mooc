package com.example.dto;

import com.example.entity.Unit;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class CourseDto {

    private Long id;
    private String name;
    private String description;
    private String language;
    private Integer durationHours;
    private List<Unit> unitList;
}

package com.example.dto;

import com.example.entity.Course;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class UnitDto {

    private Long id;
    private Course course;
    private String name;
    private String description;
    private Integer durationHours;
}

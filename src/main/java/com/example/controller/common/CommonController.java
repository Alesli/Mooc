package com.example.controller.common;

import com.example.convertor.CourseConverter;
import com.example.dto.CourseDto;
import com.example.entity.Course;
import com.example.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/common")
public class CommonController {

    @Autowired
    private CourseService courseService;

    @Autowired
    private CourseConverter courseConverter;

    //    http://localhost:8080/api/common/courses
    @GetMapping("/courses")
    public List<CourseDto> findAll() {
        List<Course> result = courseService.findAll();
        return result.stream()
                .map(courseConverter::getCourseDto)
                .collect(Collectors.toList());
    }

}

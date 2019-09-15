package com.example.controller.management;

import com.example.Convertor.CourseConverter;
import com.example.dto.CourseDto;
import com.example.entity.Course;
import com.example.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/management")
public class ManageCourseController {

    @Autowired
    private CourseService courseService;
    @Autowired
    private CourseConverter courseConverter;

    //    http://localhost:8080/api/management/course/{courseId}
    @PutMapping("/course/{courseId}")
    public CourseDto updateCourse(@PathVariable() Long courseId) {
        Course course = courseService.findOneById(courseId);
        Course result = courseService.update(course);
        return courseConverter.getCourseDto(result);
    }

    //    http://localhost:8080/api/management/course
    @PostMapping("/course")
    public CourseDto register(@RequestBody CourseDto courseDto) {
        Course course = courseConverter.getCourse(courseDto);
        Course result = courseService.save(course);
        return courseConverter.getCourseDto(result);
    }

    //    http://localhost:8080/api/management/course/{courseId}
    @DeleteMapping("/course/{courseId}")
    public void removeCourse(@PathVariable() Long courseId) {
        courseService.delete(courseId);
    }
}

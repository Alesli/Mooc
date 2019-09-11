package com.example.controller;

import com.example.entity.Course;
import com.example.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/course")
public class CourseController {

    @Autowired
    private CourseService courseService;

    //    http://localhost:8080/api/course/findById/{courseId}
    @GetMapping("/findById/{courseId}")
    public ResponseEntity<Course> findOneBookById(@PathVariable("courseId") Long courseId) {
        Course result = courseService.findOneById(courseId);
        return result == null ?
                new ResponseEntity<>(HttpStatus.NO_CONTENT) :
                new ResponseEntity<>(result, HttpStatus.OK);
    }

    //    http://localhost:8080/api/course/findAll
    @GetMapping("/findAll")
    public ResponseEntity<List<Course>> findAll() {
        List<Course> result = courseService.findAll();
        return result == null ?
                new ResponseEntity<>(HttpStatus.NO_CONTENT) :
                new ResponseEntity<>(result, HttpStatus.OK);
    }

    //    http://localhost:8080/api/course/update
    @PutMapping("/update")
    public ResponseEntity<Course> updateCourse(@RequestBody Course course) {
        Course result = courseService.update(course);
        return result == null ?
                new ResponseEntity<>(HttpStatus.NO_CONTENT) :
                new ResponseEntity<>(result, HttpStatus.OK);
    }

    //    http://localhost:8080/api/course/remove/{courseId}
    @GetMapping("/remove/{courseId}")
    public ResponseEntity removeCourse(@PathVariable("courseId") Long courseId) {
        courseService.delete(courseId);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}

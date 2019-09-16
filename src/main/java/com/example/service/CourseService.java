package com.example.service;

import com.example.entity.Course;

import java.util.List;

public interface CourseService {

    Course findOneById(Long courseId);

    List<Course> findAll();

    List<Course> findAllFromUserId(Long userId);

    Course save(Course course);

    Course update(Course course);

    void delete(Long courseId);
}

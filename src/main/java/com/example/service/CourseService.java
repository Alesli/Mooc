package com.example.service;

import com.example.entity.Course;

import java.util.List;

public interface CourseService {

    Course findOneById(Long id);

    List<Course> findAll();

    Course save(Course course);

    Course update(Course course);

    boolean delete(Long id);
}

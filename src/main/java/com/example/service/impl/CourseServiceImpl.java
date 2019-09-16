package com.example.service.impl;

import com.example.entity.Course;
import com.example.repository.CourseRepository;
import com.example.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class CourseServiceImpl implements CourseService {

    @Autowired
    private CourseRepository courseRepository;

    @Override
    public Course findOneById(Long courseId) {
        return courseRepository.getOne(courseId);
    }

    @Override
    public List<Course> findAll() {
        return null;
    }

    @Override
    public List<Course> findAllFromUserId(Long userId) {
        return null;
    }

    @Override
    public Course save(Course course) {
        return courseRepository.save(course);
    }

    @Override
    public Course update(Course course) {
        return null;
    }

    @Override
    public void delete(Long courseId) {
        courseRepository.deleteById(courseId);
    }
}

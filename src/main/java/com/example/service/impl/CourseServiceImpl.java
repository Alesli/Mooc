package com.example.service.impl;

import com.example.entity.Course;
import com.example.service.CourseService;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class CourseServiceImpl implements CourseService {
    @Override
    public Course findOneById(Long id) {
        return null;
    }

    @Override
    public List<Course> findAll() {
        return null;
    }

    @Override
    public Course save(Course course) {
        return null;
    }

    @Override
    public Course update(Course course) {
        return null;
    }

    @Override
    public boolean delete(Long id) {
        return false;
    }
}

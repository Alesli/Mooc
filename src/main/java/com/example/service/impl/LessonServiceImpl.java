package com.example.service.impl;

import com.example.entity.Lesson;
import com.example.service.LessonService;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class LessonServiceImpl implements LessonService {
    @Override
    public Lesson findOneFromUnit(Long lessonId, Long unitId) {
        return null;
    }

    @Override
    public List<Lesson> findAllFromUnit(Long unitId) {
        return null;
    }

    @Override
    public Lesson save(Lesson lesson) {
        return null;
    }

    @Override
    public Lesson update(Long unitId, Lesson lesson) {
        return null;
    }

    @Override
    public boolean delete(Long id) {
        return false;
    }
}

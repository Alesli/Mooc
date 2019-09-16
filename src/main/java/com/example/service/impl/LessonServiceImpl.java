package com.example.service.impl;

import com.example.entity.Lesson;
import com.example.repository.LessonRepository;
import com.example.service.LessonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class LessonServiceImpl implements LessonService {

    @Autowired
    private LessonRepository lessonRepository;

    @Override
    public Lesson findOne(Long unitId) {
        return lessonRepository.getOne(unitId);
    }

    @Override
    public List<Lesson> findAllFromUnit(Long unitId) {
        return null;
    }

    @Override
    public Lesson save(Lesson lesson) {
        return lessonRepository.save(lesson);
    }

    @Override
    public Lesson update(Lesson lesson) {
        return null;
    }

    @Override
    public void delete(Long lessonId) {
      lessonRepository.deleteById(lessonId);
    }
}

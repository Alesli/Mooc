package com.example.service;

import com.example.entity.Lesson;

import java.util.List;

public interface LessonService {

    Lesson findOneFromUnit(Long lessonId, Long unitId);

    List<Lesson> findAllFromUnit(Long unitId);

    Lesson save(Lesson lesson);

    Lesson update(Long unitId, Lesson lesson);

    boolean delete(Long id);
}

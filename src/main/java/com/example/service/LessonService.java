package com.example.service;

import com.example.entity.Lesson;

import java.util.List;

public interface LessonService {

    Lesson findOne(Long lessonId);

    List<Lesson> findAllFromUnit(Long unitId);

    Lesson save(Lesson lesson);

    Lesson update(Lesson lesson);

    void delete(Long lessonId);
}

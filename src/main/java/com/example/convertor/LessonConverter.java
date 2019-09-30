package com.example.convertor;

import com.example.dto.LessonDto;
import com.example.dto.LessonTreeDto;
import com.example.entity.Lesson;
import org.springframework.stereotype.Component;

@Component
public class LessonConverter {

    public LessonDto getLessonDto(Lesson lesson) {

        LessonDto lessonDto = new LessonDto();
        lessonDto.setId(lesson.getId());
        lessonDto.setName(lesson.getName());
        lessonDto.setDescription(lesson.getDescription());

        return lessonDto;
    }

    public LessonTreeDto getLessonItemsDto(Lesson lesson) {

        LessonTreeDto lessonTreeDto = new LessonTreeDto();
        lessonTreeDto.setId(lesson.getId());
        lessonTreeDto.setName(lesson.getName());

        return lessonTreeDto;
    }

    public Lesson getLesson(LessonDto lessonDto) {

        Lesson lesson = new Lesson();
        lesson.setId(lessonDto.getId());
        lesson.setName(lessonDto.getName());
        lesson.setDescription(lessonDto.getDescription());

        return lesson;
    }
}

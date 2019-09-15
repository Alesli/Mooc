package com.example.Convertor;

import com.example.dto.LessonDto;
import com.example.dto.LessonWithItemsDto;
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

    public LessonWithItemsDto getLessonItemsDto(Lesson lesson) {

        LessonWithItemsDto lessonWithItemsDto = new LessonWithItemsDto();
        lessonWithItemsDto.setId(lesson.getId());
        lessonWithItemsDto.setName(lesson.getName());

        return lessonWithItemsDto;
    }

    public Lesson getLesson(LessonDto lessonDto) {

        Lesson lesson = new Lesson();
        lesson.setId(lessonDto.getId());
        lesson.setName(lessonDto.getName());
        lesson.setDescription(lessonDto.getDescription());

        return lesson;
    }
}

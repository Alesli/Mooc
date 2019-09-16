package com.example.controller.management;

import com.example.Convertor.LessonConverter;
import com.example.dto.LessonDto;
import com.example.entity.Lesson;
import com.example.service.LessonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/management")
public class ManageLessonController {

    @Autowired
    private LessonService lessonService;
    @Autowired
    private LessonConverter lessonConverter;

    //    http://localhost:8080/api/management/lesson
    @PutMapping("/lesson")
    public LessonDto updateLesson(@RequestBody LessonDto lessonDto) {
        Lesson result = lessonService.update(
                lessonConverter.getLesson(lessonDto));
        return lessonConverter.getLessonDto(result);
    }

    //    http://localhost:8080/api/management/lesson
    @PostMapping("/lesson")
    public LessonDto createLesson(@RequestBody LessonDto lessonDto) {
        Lesson result = lessonService.save(
                lessonConverter.getLesson(lessonDto));
        return lessonConverter.getLessonDto(result);
    }

    //    http://localhost:8080/api/management/lesson/{lessonId}
    @DeleteMapping("/lesson/{lessonId}")
    public void deleteLesson(@PathVariable() Long lessonId) {
        lessonService.delete(lessonId);
    }
}

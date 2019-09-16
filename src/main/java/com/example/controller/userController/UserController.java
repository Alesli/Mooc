package com.example.controller.userController;

import com.example.Convertor.CourseConverter;
import com.example.Convertor.LessonConverter;
import com.example.Convertor.UnitConverter;
import com.example.dto.CourseDto;
import com.example.dto.CourseWithUnitsDto;
import com.example.dto.UnitDto;
import com.example.dto.UnitWithLessonsDto;
import com.example.entity.Course;
import com.example.entity.Lesson;
import com.example.entity.Unit;
import com.example.service.CourseService;
import com.example.service.LessonService;
import com.example.service.UnitService;
import com.example.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/user")
public class UserController {

    @Autowired
    private CourseService courseService;
    @Autowired
    private UnitService unitService;
    @Autowired
    private LessonConverter lessonConverter;

    @Autowired
    private CourseConverter courseConverter;
    @Autowired
    private UnitConverter unitConverter;
    @Autowired
    private LessonService lessonService;

    //    http://localhost:8080/api/user/{courseId}/tree
    @GetMapping("/course/{courseId}")
    public CourseWithUnitsDto findOneCourseById(@PathVariable("courseId") Long courseId) {
        Course course = courseService.findOneById(courseId);
        CourseWithUnitsDto courseDto = courseConverter.getCourseUnitsDto(course);
        List<Unit> units = unitService.findAllFromCourse(courseId);

        courseDto.setUnitWithLessonsDtoList(units.stream()
                .map(unitConverter::getUnitLessonsDto)
                .collect(Collectors.toList()));
        return courseDto;
    }

    //     http://localhost:8080/api/user/unit/{unitId}
    @GetMapping("/unit/{unitId}")
    public UnitDto findOneUnit(@PathVariable() Long unitId) {
        Unit unit = unitService.findOne(unitId);
        UnitDto unitDto = unitConverter.getUnitDto(unit);
        List<Lesson> lessons = lessonService.findAllFromUnit(unitId);

        unitDto.setLessonDtoList(lessons.stream()
        .map(lessonConverter::getLessonDto)
        .collect(Collectors.toList()));
        return unitDto;
    }
}

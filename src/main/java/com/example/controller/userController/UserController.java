package com.example.controller.userController;

import com.example.Convertor.CourseConverter;
import com.example.Convertor.UnitConverter;
import com.example.dto.CourseDto;
import com.example.dto.CourseWithUnitsDto;
import com.example.dto.UnitWithLessonsDto;
import com.example.entity.Course;
import com.example.entity.Unit;
import com.example.service.CourseService;
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
    private CourseConverter courseConverter;
    @Autowired
    private UnitConverter unitConverter;

    //    http://localhost:8080/api/user/{courseId}/tree
    @GetMapping("/course/{courseId}")
    public CourseWithUnitsDto findOneCourseById(@PathVariable("courseId") Long courseId) {
        Course course = courseService.findOneById(courseId);
        CourseWithUnitsDto courseDto = courseConverter.getCourseUnitsDto(course);
        List<Unit> unit = unitService.findAllFromCourse(courseId);

        courseDto.setUnitWithLessonsDtoList(unit.stream()
                .map(unitConverter::getUnitLessonsDto)
                .collect(Collectors.toList()));
        return courseDto;
    }
}

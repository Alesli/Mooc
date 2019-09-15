package com.example.Convertor;

import com.example.dto.CourseDto;
import com.example.dto.CourseWithUnitsDto;
import com.example.entity.Course;
import org.springframework.stereotype.Component;

@Component
public class CourseConverter {

    public CourseDto getCourseDto(Course course) {

        CourseDto courseDto = new CourseDto();
        courseDto.setId(course.getId());
        courseDto.setName(course.getName());
        courseDto.setDescription(course.getDescription());
        courseDto.setLanguage(course.getLanguage());
        courseDto.setDurationHours(course.getDurationHours());

        return courseDto;
    }

    public CourseWithUnitsDto getCourseUnitsDto(Course course) {

        CourseWithUnitsDto courseWithUnitsDto = new CourseWithUnitsDto();
        courseWithUnitsDto.setId(course.getId());
        courseWithUnitsDto.setName(course.getName());

        return courseWithUnitsDto;
    }

    public Course getCourse(CourseDto courseDto) {

        Course course = new Course();
        course.setId(courseDto.getId());
        course.setName(courseDto.getName());
        course.setDescription(courseDto.getDescription());
        course.setLanguage(courseDto.getLanguage());
        course.setDurationHours(courseDto.getDurationHours());

        return course;
    }
}

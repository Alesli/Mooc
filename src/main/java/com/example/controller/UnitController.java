package com.example.controller;

import com.example.entity.Unit;
import com.example.service.UnitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/unit")
public class UnitController {

    @Autowired
    private UnitService unitService;

    //    http://localhost:8080/api/unit/findOneFromCourse/{courseId}/{courseId}
    @GetMapping("/findById/{courseId}/{courseId}")
    public Unit findOneFromCourse(@PathVariable("courseId") Long unitId,
                                                  @PathVariable("courseId") Long courseId) {

        return unitService.findOneFromCourse(unitId, courseId);
    }

    //    http://localhost:8080/api/unit/findAll/{courseId}
    @GetMapping("/findAll/{courseId}")
    public List<Unit> findAllFromCourse(@PathVariable("courseId") Long courseId) {

        return unitService.findAllFromCourse(courseId);
    }

    //    http://localhost:8080/api/unit/update/{courseId}
    @PutMapping("/update/{courseId}")
    public Unit updateUnit(@PathVariable("courseId") Long courseId,
                                           @RequestBody Unit unit) {
        return unitService.update(courseId, unit);
    }

    //    http://localhost:8080/api/unit/remove/{unitId}
    @GetMapping("/remove/{courseId}/{courseId}")
    public Boolean removeUnit(@PathVariable("courseId") Long unitId) {

        return unitService.delete(unitId);
    }
}

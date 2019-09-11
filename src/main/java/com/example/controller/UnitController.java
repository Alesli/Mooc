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
    public ResponseEntity<Unit> findOneFromCourse(@PathVariable("courseId") Long unitId,
                                                  @PathVariable("courseId") Long courseId) {
        Unit result = unitService.findOneFromCourse(unitId, courseId);
        return result == null ?
                new ResponseEntity<>(HttpStatus.NO_CONTENT) :
                new ResponseEntity<>(result, HttpStatus.OK);
    }

    //    http://localhost:8080/api/unit/findAll/{courseId}
    @GetMapping("/findAll/{courseId}")
    public ResponseEntity<List<Unit>> findAllFromCourse(@PathVariable("courseId") Long courseId) {
        List<Unit> result = unitService.findAllFromCourse(courseId);
        return result == null ?
                new ResponseEntity<>(HttpStatus.NO_CONTENT) :
                new ResponseEntity<>(result, HttpStatus.OK);
    }

    //    http://localhost:8080/api/unit/update/{courseId}
    @PutMapping("/update/{courseId}")
    public ResponseEntity<Unit> updateUnit(@PathVariable("courseId") Long courseId,
                                           @RequestBody Unit unit) {
        Unit result = unitService.update(courseId, unit);
        return result == null ?
                new ResponseEntity<>(HttpStatus.NO_CONTENT) :
                new ResponseEntity<>(result, HttpStatus.OK);
    }

    //    http://localhost:8080/api/unit/remove/{courseId}/{courseId}
    @GetMapping("/remove/{courseId}/{courseId}")
    public ResponseEntity removeUnit(@PathVariable("courseId") Long unitId,
                                     @PathVariable("courseId") Long courseId) {
        unitService.delete(unitId, courseId);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}

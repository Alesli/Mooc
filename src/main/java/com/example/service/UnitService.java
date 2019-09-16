package com.example.service;

import com.example.entity.Unit;

import java.util.List;

public interface UnitService {

    Unit findOne(Long unitId);

    List<Unit> findAllFromCourse(Long courseId);

    Unit save(Unit unit);

    Unit update(Unit unit);

    void delete(Long unitId);
}

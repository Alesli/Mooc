package com.example.service;

import com.example.entity.Unit;

import java.util.List;

public interface UnitService {

    Unit findOneFromCourse(Long unitId, Long courseId);

    List<Unit> findAllFromCourse(Long courseId);

    Unit save(Unit unit);

    Unit update(Long courseId, Unit unit);

    boolean delete(Long id);
}

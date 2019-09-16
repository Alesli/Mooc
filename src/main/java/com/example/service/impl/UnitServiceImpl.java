package com.example.service.impl;

import com.example.entity.Unit;
import com.example.service.UnitService;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class UnitServiceImpl implements UnitService {
    @Override
    public Unit findOne(Long unitId) {
        return null;
    }

    @Override
    public List<Unit> findAllFromCourse(Long courseId) {
        return null;
    }

    @Override
    public Unit save(Unit unit) {
        return null;
    }

    @Override
    public Unit update(Unit unit) {
        return null;
    }

    @Override
    public boolean delete(Long unitId) {
        return false;
    }
}

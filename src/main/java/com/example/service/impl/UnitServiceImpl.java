package com.example.service.impl;

import com.example.entity.Unit;
import com.example.repository.UnitRepository;
import com.example.service.UnitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class UnitServiceImpl implements UnitService {

    @Autowired
    private UnitRepository unitRepository;

    @Override
    public Unit findOne(Long unitId) {
        return unitRepository.getOne(unitId);
    }

    @Override
    public List<Unit> findAllFromCourse(Long courseId) {
        return null;
    }

    @Override
    public Unit save(Unit unit) {
        return unitRepository.save(unit);
    }

    @Override
    public Unit update(Unit unit) {
        return null;
    }

    @Override
    public void delete(Long unitId) {
        unitRepository.deleteById(unitId);
    }
}

package com.example.convertor;

import com.example.dto.UnitDto;
import com.example.dto.UnitWithLessonsDto;
import com.example.entity.Unit;
import org.springframework.stereotype.Component;

@Component
public class UnitConverter {

    public UnitDto getUnitDto(Unit unit) {

        UnitDto unitDto = new UnitDto();
        unitDto.setId(unit.getId());
        unitDto.setName(unit.getName());
        unitDto.setDescription(unit.getDescription());
        unitDto.setDurationHours(unit.getDurationHours());

        return unitDto;
    }

    public UnitWithLessonsDto getUnitLessonsDto(Unit unit) {

        UnitWithLessonsDto unitWithLessonsDto = new UnitWithLessonsDto();
        unitWithLessonsDto.setId(unit.getId());
        unitWithLessonsDto.setName(unit.getName());

        return unitWithLessonsDto;
    }

    public Unit getUnit(UnitDto unitDto) {

        Unit unit = new Unit();
        unit.setId(unitDto.getId());
        unit.setName(unitDto.getName());
        unit.setDescription(unitDto.getDescription());
        unit.setDurationHours(unitDto.getDurationHours());

        return unit;
    }
}

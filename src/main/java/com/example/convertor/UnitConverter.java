package com.example.convertor;

import com.example.dto.UnitDto;
import com.example.dto.UnitTreeDto;
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

    public UnitTreeDto getUnitLessonsDto(Unit unit) {

        UnitTreeDto unitTreeDto = new UnitTreeDto();
        unitTreeDto.setId(unit.getId());
        unitTreeDto.setName(unit.getName());

        return unitTreeDto;
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

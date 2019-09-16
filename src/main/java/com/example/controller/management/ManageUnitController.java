package com.example.controller.management;

import com.example.Convertor.UnitConverter;
import com.example.dto.UnitDto;
import com.example.entity.Unit;
import com.example.service.UnitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/management")
public class ManageUnitController {

    @Autowired
    private UnitService unitService;
    @Autowired
    private UnitConverter unitConverter;

    //    http://localhost:8080/api/management/unit
    @PostMapping("/unit")
    public UnitDto createUnit(@RequestBody UnitDto unitDto) {
        Unit result = unitService.save(unitConverter.getUnit(unitDto));
        return unitConverter.getUnitDto(result);
    }

    //    http://localhost:8080/api/management/unit
    @PutMapping("/unit")
    public UnitDto updateUnit(@RequestBody UnitDto unitDto) {
        Unit result = unitService.update(unitConverter.getUnit(unitDto));
        return unitConverter.getUnitDto(result);
    }

    //    http://localhost:8080/api/management/unit/{unitId}
    @GetMapping("/unit/{unitId}")
    public void removeUnit(@PathVariable() Long unitId) {
        unitService.delete(unitId);
    }
}

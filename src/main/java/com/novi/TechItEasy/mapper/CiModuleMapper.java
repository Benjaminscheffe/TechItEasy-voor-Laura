package com.novi.TechItEasy.mapper;

import com.novi.TechItEasy.dto.CiModuleRequestDto;
import com.novi.TechItEasy.dto.CiModuleResponseDto;
import com.novi.TechItEasy.model.CiModule;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CiModuleMapper {
    public CiModule toEntity(CiModuleRequestDto ciModuleRequestDto) {
        CiModule ciModule = new CiModule(ciModuleRequestDto.name, ciModuleRequestDto.type);

        return ciModule;
    }

    public CiModuleResponseDto toResponseDto(CiModule cimodule) {
        CiModuleResponseDto ciModuleDto = new CiModuleResponseDto();
        ciModuleDto.id = cimodule.getId();
        ciModuleDto.name = cimodule.getName();
        ciModuleDto.type = cimodule.getType();

        return ciModuleDto;
    }
}

package com.novi.TechItEasy.mapper;

import com.novi.TechItEasy.dto.TelevisionRequestDto;
import com.novi.TechItEasy.dto.TelevisionResponseDto;
import com.novi.TechItEasy.model.Television;
import org.springframework.stereotype.Component;

@Component
public class TelevisionMapper {
    public Television toEntity(TelevisionRequestDto televisionRequestDto) {
        Television television = new Television(televisionRequestDto.type, televisionRequestDto.brand);

        return television;
    }

    public TelevisionResponseDto toResponseDto(Television television) {
        TelevisionResponseDto televisionDto = new TelevisionResponseDto();
        televisionDto.id = television.getId();
        televisionDto.type = television.getType();
        televisionDto.brand = television.getBrand();
        televisionDto.remoteControllerId = television.getRemoteController().getId();
        televisionDto.ciModuleId = television.getCiModule().getId();

        return televisionDto;
    }
}

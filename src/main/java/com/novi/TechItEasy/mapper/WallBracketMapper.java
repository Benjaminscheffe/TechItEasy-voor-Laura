package com.novi.TechItEasy.mapper;

import com.novi.TechItEasy.dto.WallBracketRequestDto;
import com.novi.TechItEasy.dto.WallBracketResponseDto;
import com.novi.TechItEasy.model.WallBracket;
import org.springframework.stereotype.Component;

@Component
public class WallBracketMapper {
    public WallBracket toEntity(WallBracketRequestDto wallBracketRequestDto) {
        WallBracket wallBracket = new WallBracket(wallBracketRequestDto.name, wallBracketRequestDto.size);

        return wallBracket;
    }

    public WallBracketResponseDto toResponseDto(WallBracket wallBracket) {
        WallBracketResponseDto wallBracketResponseDto = new WallBracketResponseDto();

        wallBracketResponseDto.id = wallBracket.getId();
        wallBracketResponseDto.name = wallBracket.getName();
        wallBracketResponseDto.size = wallBracket.getSize();

        return wallBracketResponseDto;
    }

}

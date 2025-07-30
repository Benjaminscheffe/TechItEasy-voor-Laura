package com.novi.TechItEasy.service;

import com.novi.TechItEasy.dto.WallBracketRequestDto;
import com.novi.TechItEasy.dto.WallBracketResponseDto;
import com.novi.TechItEasy.exception.RecordNotFoundException;
import com.novi.TechItEasy.mapper.WallBracketMapper;
import com.novi.TechItEasy.model.WallBracket;
import com.novi.TechItEasy.repository.WallBracketRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class WallBracketService {

    private final WallBracketRepository repos;
    private final WallBracketMapper mapper;

    public WallBracketService(WallBracketRepository repos, WallBracketMapper mapper) {
        this.repos = repos;
        this.mapper = mapper;
    }

    public List<WallBracketResponseDto> getAllWallBrackets() {
        List<WallBracket> wallBracketList = repos.findAll();
        List<WallBracketResponseDto> wallBracketDtoList = new ArrayList<>();

        for(WallBracket wb : wallBracketList) {
            WallBracketResponseDto wbDto = mapper.toResponseDto(wb);
            wallBracketDtoList.add(wbDto);
        }

        return wallBracketDtoList;
    }

    public WallBracketResponseDto getWallBracket(Long id) {
        Optional<WallBracket> wallBracket = repos.findById(id);

        if (wallBracket.isEmpty()) {
            throw new RecordNotFoundException("No Wallbracket found with id " + id) ;
        } else {
            return mapper.toResponseDto(wallBracket.get());
        }
    }

    public WallBracketResponseDto saveWallBracket(WallBracketRequestDto wallBracketRequestDto) {
        WallBracket wallBracket = mapper.toEntity(wallBracketRequestDto);

        repos.save(wallBracket);

        WallBracketResponseDto dto = mapper.toResponseDto(wallBracket);

        return dto;
    }

    public void deleteWallBracket(Long id) {
        repos.deleteById(id);
    }
}

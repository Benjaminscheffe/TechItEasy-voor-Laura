package com.novi.TechItEasy.service;

import com.novi.TechItEasy.dto.CiModuleRequestDto;
import com.novi.TechItEasy.exception.RecordNotFoundException;
import com.novi.TechItEasy.mapper.CiModuleMapper;
import com.novi.TechItEasy.dto.CiModuleResponseDto;
import com.novi.TechItEasy.model.CiModule;
import com.novi.TechItEasy.repository.CiModuleRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CiModuleService {

    private final CiModuleRepository repos;
    private final CiModuleMapper mapper;


    public CiModuleService(CiModuleRepository repos, CiModuleMapper mapper) {
        this.repos = repos;
        this.mapper = mapper;
    }

    public List<CiModuleResponseDto> getCiModules() {
        List<CiModule> ciModuleList = repos.findAll();
        List<CiModuleResponseDto> ciModuleDtoList = new ArrayList<>();

        for(CiModule cimodule : ciModuleList) {
            CiModuleResponseDto dto = mapper.toResponseDto(cimodule);
            ciModuleDtoList.add(dto);
        }

        return ciModuleDtoList;
    }

    public CiModuleResponseDto getCiModule(Long id) {
        Optional<CiModule> ciModule = repos.findById(id);

        if (ciModule.isEmpty()) {
            throw new RecordNotFoundException("No CiModule found with id " + id);
        } else {
            return mapper.toResponseDto(ciModule.get());
        }
    }

    public CiModuleResponseDto saveCiModule(CiModuleRequestDto ciModuleRequestDto) {
        CiModule ciModule = mapper.toEntity(ciModuleRequestDto);

        repos.save(ciModule);

        CiModuleResponseDto dto = mapper.toResponseDto(ciModule);

        return dto;
    }

    public void deleteCiModule(Long id) {
        repos.deleteById(id);
    }

}

package com.novi.TechItEasy.service;

import com.novi.TechItEasy.dto.TelevisionRequestDto;
import com.novi.TechItEasy.dto.TelevisionResponseDto;
import com.novi.TechItEasy.exception.RecordNotFoundException;
import com.novi.TechItEasy.mapper.TelevisionMapper;
import com.novi.TechItEasy.model.CiModule;
import com.novi.TechItEasy.model.RemoteController;
import com.novi.TechItEasy.model.Television;
import com.novi.TechItEasy.repository.CiModuleRepository;
import com.novi.TechItEasy.repository.RemoteControllerRepository;
import com.novi.TechItEasy.repository.TelevisionRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class TelevisionService {

    private final TelevisionRepository repos;
    private final TelevisionMapper mapper;
    private final RemoteControllerRepository remoteControllerRepository;
    private final CiModuleRepository ciModuleRepository;

    public TelevisionService(TelevisionRepository repos, TelevisionMapper mapper, RemoteControllerRepository remoteControllerRepository, CiModuleRepository ciModuleRepository) {
        this.repos = repos;
        this.mapper = mapper;
        this.remoteControllerRepository = remoteControllerRepository;
        this.ciModuleRepository = ciModuleRepository;
    }

    public List<TelevisionResponseDto> getTelevisions() {

        List<Television> tvList = repos.findAll();
        List<TelevisionResponseDto> tvDtoList = new ArrayList<>();

        for(Television tv : tvList) {
            TelevisionResponseDto dto = mapper.toResponseDto(tv);
            tvDtoList.add(dto);
        }

        return tvDtoList;
    }

    public TelevisionResponseDto getTelevision(Long id) {
//        Television television= repos.findById(id).orElseThrow(() -> new RecordNotFoundException("Televison " + id + " not found"));
//
//        return mapper.toResponseDto(television);

        Optional<Television> television = repos.findById(id);
        
        if (television.isEmpty()){
            throw new RecordNotFoundException("No television found with id: " + id );
        } else {
            return mapper.toResponseDto(television.get());
        }    
    }

    public TelevisionResponseDto saveTelevision(TelevisionRequestDto televisionRequestDto){
        Television television = mapper.toEntity(televisionRequestDto);

        repos.save(television);

        TelevisionResponseDto dto = mapper.toResponseDto(television);

        return dto;
    }

    public void deleteTelevision(Long id) {
        repos.deleteById(id);
    }

    public TelevisionResponseDto updateTelevision(Long id, TelevisionRequestDto newTelevision) {
        Optional<Television> televisionOptional = repos.findById(id);

        if (televisionOptional.isEmpty()) {
            throw new RecordNotFoundException("Television not found with id " + id);
        } else {
            Television television1 = televisionOptional.get();

            television1.setBrand(newTelevision.getBrand());
            television1.setType(newTelevision.getType());

            Television returnTelevision = repos.save(television1);

            return mapper.toResponseDto(returnTelevision);
        }
    }
    
    public List<TelevisionResponseDto> getTelevisionsByBrand(String brand) {
        List<Television> tvList = repos.findAllTelevisionsByBrandEqualsIgnoreCase(brand);
        List<TelevisionResponseDto> tvDtoList = new ArrayList<>();

        for(Television tv : tvList) {
            TelevisionResponseDto tvDto = mapper.toResponseDto(tv);
            tvDtoList.add(tvDto);
        }

        return tvDtoList;
    }

    public void assignRemoteControllerToTelevision(Long id, Long remoteControllerId) {
        Optional<Television> optionalTelevision = repos.findById(id);
        Optional<RemoteController> optionalRemoteController = remoteControllerRepository.findById(remoteControllerId);

        if(optionalTelevision.isPresent() && optionalRemoteController.isPresent()) {
            Television television = optionalTelevision.get();
            RemoteController remotecontroller = optionalRemoteController.get();

            // Television owner dus daarin moet het gezet/gesaved worden
            television.setRemoteController(remotecontroller);

            repos.save(television);
        } else {
            throw new RecordNotFoundException();
        }
    }

    public void assignCiModuleToTelevision(Long id, Long ciModuleId) {
        Optional<Television> optionalTelevision = repos.findById(id);
        Optional<CiModule> optionalCiModule = ciModuleRepository.findById(ciModuleId);

        if(optionalTelevision.isPresent() && optionalCiModule.isPresent()) {
            Television television = optionalTelevision.get();
            CiModule ciModule = optionalCiModule.get();

            television.setCiModule(ciModule);

            repos.save(television);

        } else {
            throw new RecordNotFoundException();
        }
    }
    
}

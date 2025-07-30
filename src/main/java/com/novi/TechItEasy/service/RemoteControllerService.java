package com.novi.TechItEasy.service;

import com.novi.TechItEasy.dto.RemoteControllerRequestDto;
import com.novi.TechItEasy.dto.RemoteControllerResponseDto;
import com.novi.TechItEasy.exception.RecordNotFoundException;
import com.novi.TechItEasy.mapper.RemoteControllerMapper;
import com.novi.TechItEasy.model.RemoteController;
import com.novi.TechItEasy.model.Television;
import com.novi.TechItEasy.repository.RemoteControllerRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class RemoteControllerService {

    private final RemoteControllerRepository repos;
    private final RemoteControllerMapper mapper;

    public RemoteControllerService(RemoteControllerRepository repos, RemoteControllerMapper mapper) {
        this.repos = repos;
        this.mapper = mapper;
    }

    public List<RemoteControllerResponseDto> getAllRemoteControllers() {
        List<RemoteController> remoteControllerList = repos.findAll();
        List<RemoteControllerResponseDto> remoteControllerDtoList = new ArrayList<>();

        for(RemoteController rc : remoteControllerList) {
            RemoteControllerResponseDto dto = mapper.toResponseDto(rc);
            remoteControllerDtoList.add(dto);
        }

        return remoteControllerDtoList;
    }

    public RemoteControllerResponseDto getRemoteController(Long id) {
        Optional<RemoteController> remoteController = repos.findById(id);

        if (remoteController.isEmpty()) {
            throw new RecordNotFoundException("No remotecontroller found with id " + id);
        } else {
            return mapper.toResponseDto(remoteController.get());
        }
    }

    public RemoteControllerResponseDto saveRemoteController(RemoteControllerRequestDto remoteControllerRequestDto) {
        RemoteController remoteController = mapper.toEntity(remoteControllerRequestDto);

        repos.save(remoteController);

        RemoteControllerResponseDto dto = mapper.toResponseDto(remoteController);

        return dto;
    }

    public void deleteRemoteController(Long id) {
        repos.deleteById(id);
    }

}

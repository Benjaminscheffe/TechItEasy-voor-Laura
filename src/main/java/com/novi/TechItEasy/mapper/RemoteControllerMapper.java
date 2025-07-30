package com.novi.TechItEasy.mapper;

import com.novi.TechItEasy.dto.*;
import com.novi.TechItEasy.model.RemoteController;
import com.novi.TechItEasy.model.Television;
import org.springframework.stereotype.Component;

@Component
public class RemoteControllerMapper {
    public RemoteController toEntity(RemoteControllerRequestDto remoteControllerRequestDto) {
        RemoteController remoteController = new RemoteController(remoteControllerRequestDto.name, remoteControllerRequestDto.brand);

        return remoteController;
    }

    public RemoteControllerResponseDto toResponseDto(RemoteController remotecontroller) {
        RemoteControllerResponseDto remoteControllerDto = new RemoteControllerResponseDto();
        remoteControllerDto.id = remotecontroller.getId();
        remoteControllerDto.name = remotecontroller.getName();
        remoteControllerDto.brand = remotecontroller.getBrand();
        if (remotecontroller.getTelevision() != null) {
            remoteControllerDto.television = new TelevisionIdBrandDto(remotecontroller.getTelevision().getId(), remotecontroller.getTelevision().getBrand());
        }

        return remoteControllerDto;
    }
}

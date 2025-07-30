package com.novi.TechItEasy.controller;

import com.novi.TechItEasy.dto.RemoteControllerRequestDto;
import com.novi.TechItEasy.dto.RemoteControllerResponseDto;
import com.novi.TechItEasy.service.RemoteControllerService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/remotecontrollers")
public class RemoteControllerController {

    private final RemoteControllerService service;

    public RemoteControllerController(RemoteControllerService service) {
        this.service = service;
    }


    @GetMapping
    public ResponseEntity<List<RemoteControllerResponseDto>> getAllRemoteControllers() {
        List<RemoteControllerResponseDto> remotecontrollers = service.getAllRemoteControllers();

        return ResponseEntity.ok().body(remotecontrollers);
    }

    @GetMapping("/{id}")
    public ResponseEntity<RemoteControllerResponseDto> getRemoteController(@PathVariable("id") Long id) {
        RemoteControllerResponseDto remoteController = service.getRemoteController(id);

        return ResponseEntity.ok().body(remoteController);
    }

    @PostMapping
    public ResponseEntity<RemoteControllerResponseDto> addRemoteController(@RequestBody RemoteControllerRequestDto remoteControllerRequestDto) {
        RemoteControllerResponseDto dto = service.saveRemoteController(remoteControllerRequestDto);

        return ResponseEntity.created(null).body(dto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteRemoteController(@PathVariable("id") Long id) {
        service.deleteRemoteController(id);

        return ResponseEntity.noContent().build();
    }
}

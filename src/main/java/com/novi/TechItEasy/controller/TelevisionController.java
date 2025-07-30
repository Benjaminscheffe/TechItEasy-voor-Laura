package com.novi.TechItEasy.controller;

import com.novi.TechItEasy.dto.TelevisionRequestDto;
import com.novi.TechItEasy.dto.TelevisionResponseDto;
import com.novi.TechItEasy.service.TelevisionService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/televisions")
public class TelevisionController {

    private final TelevisionService service;

    public TelevisionController(TelevisionService service){
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<TelevisionResponseDto>> getAllTelevision(@RequestParam(value = "brand", required = false) String brand) {
        List<TelevisionResponseDto> televisions;

       if (brand == null) {
           televisions = service.getTelevisions();
        } else {
            televisions = service.getTelevisionsByBrand(brand);
        }

        return ResponseEntity.ok().body(televisions);
    }

    @GetMapping("/{id}")
    public ResponseEntity<TelevisionResponseDto> getTelevision(@PathVariable("id") Long id) {

        TelevisionResponseDto television = service.getTelevision(id);
           return ResponseEntity.ok().body(television);
    }

    @PostMapping
    public ResponseEntity<TelevisionResponseDto> addTelevision(@RequestBody TelevisionRequestDto televisionRequestDto) {
       TelevisionResponseDto dto = service.saveTelevision(televisionRequestDto);

        return ResponseEntity.created(null).body(dto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteTelevision(@PathVariable("id") Long id) {

        service.deleteTelevision(id);
        //Return een 204 status
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<TelevisionResponseDto> updateTelevision(@PathVariable Long id, @RequestBody TelevisionRequestDto newTelevision) {

        TelevisionResponseDto dto = service.updateTelevision(id, newTelevision);
        // Return een 204 status
        return ResponseEntity.ok().body(dto);
    }

    @PutMapping("/{id}/remotecontroller/{remoteId}")
    public void assignRemoteControllerToTelevision(@PathVariable("id") Long id, @PathVariable Long remoteId) {
        service.assignRemoteControllerToTelevision(id, remoteId);
    }
}

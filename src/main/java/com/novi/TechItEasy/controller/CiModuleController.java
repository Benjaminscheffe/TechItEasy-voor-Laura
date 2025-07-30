package com.novi.TechItEasy.controller;

import com.novi.TechItEasy.dto.CiModuleRequestDto;
import com.novi.TechItEasy.dto.CiModuleResponseDto;
import com.novi.TechItEasy.service.CiModuleService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/cimodules")
public class CiModuleController {
    
    private final CiModuleService service;
    
    public CiModuleController(CiModuleService service) {
        this.service = service;
    }
    
    @GetMapping
    public ResponseEntity<List<CiModuleResponseDto>> getAllCiModules() {
        List<CiModuleResponseDto> cimodules = service.getCiModules();
        
        return ResponseEntity.ok().body(cimodules);
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<CiModuleResponseDto> getCiModule(@PathVariable("id") Long id) {
        CiModuleResponseDto ciModule = service.getCiModule(id);
        
        return ResponseEntity.ok().body(ciModule);
    }

    @PostMapping
    public ResponseEntity<CiModuleResponseDto> createCiModule(@RequestBody CiModuleRequestDto ciModuleRequestDto) {
        CiModuleResponseDto dto = service.saveCiModule(ciModuleRequestDto);

        return ResponseEntity.created(null).body(dto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteCiModule(@PathVariable("id") Long id) {
        service.deleteCiModule(id);

        return ResponseEntity.noContent().build();
    }
}

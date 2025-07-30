package com.novi.TechItEasy.controller;

import com.novi.TechItEasy.dto.WallBracketRequestDto;
import com.novi.TechItEasy.dto.WallBracketResponseDto;
import com.novi.TechItEasy.model.WallBracket;
import com.novi.TechItEasy.repository.WallBracketRepository;
import com.novi.TechItEasy.service.WallBracketService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/wallbrackets")
public class WallBracketController {

    private final WallBracketService service;

    public WallBracketController(WallBracketService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<WallBracketResponseDto>> getAllWallBrackets() {
        List<WallBracketResponseDto> wallBrackets = service.getAllWallBrackets();

        return ResponseEntity.ok().body(wallBrackets);
    }

    @GetMapping("/{id}")
    public ResponseEntity<WallBracketResponseDto> getWallBracket(@RequestParam("id") Long id) {
        WallBracketResponseDto wallBracket = service.getWallBracket(id);

        return ResponseEntity.ok().body(wallBracket);
    }

    @PostMapping
    public ResponseEntity<WallBracketResponseDto> createWallBracket(@RequestBody WallBracketRequestDto wallBracketRequestDto) {
        WallBracketResponseDto dto = service.saveWallBracket(wallBracketRequestDto);

        return ResponseEntity.created(null).body(dto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteWallBracket(@PathVariable("id") Long id) {
        service.deleteWallBracket(id);

        return ResponseEntity.noContent().build();

    }
}

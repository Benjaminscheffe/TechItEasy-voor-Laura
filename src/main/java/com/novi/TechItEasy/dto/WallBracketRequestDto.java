package com.novi.TechItEasy.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class WallBracketRequestDto {

    @NotBlank
    @Size(min= 3, max = 20)
    public String name;

    @NotBlank
    public Number size;

    public Number getSize() {
        return size;
    }

    public void setSize(Number size) {
        this.size = size;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

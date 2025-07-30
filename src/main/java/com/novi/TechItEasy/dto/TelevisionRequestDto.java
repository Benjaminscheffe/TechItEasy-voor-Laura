package com.novi.TechItEasy.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class TelevisionRequestDto {

    @NotBlank
    @Size(min=3, max=20)
    public String type;

    @NotBlank
    public String brand;

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}

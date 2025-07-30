package com.novi.TechItEasy.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class RemoteControllerRequestDto {

    @NotBlank
    @Size(min=3, max=20)
    public String name;

    @NotBlank
    public String brand;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }
}

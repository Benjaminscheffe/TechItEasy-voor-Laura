package com.novi.TechItEasy.model;

import jakarta.persistence.*;

@Entity
@Table(name = "remotecontrollers")
public class RemoteController {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String brand;

    @OneToOne(mappedBy = "remoteController")
    Television television;

    public RemoteController(
            String name,
            String brand) {
        this.name = name;
        this.brand = brand;
    }

    public Television getTelevision() {
        return television;
    }

    public void setTelevision(Television television) {
        this.television = television;
    }

    public RemoteController() {}

    public Long getId() {
        return id;
    }

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



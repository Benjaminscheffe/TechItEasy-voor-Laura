package com.novi.TechItEasy.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "televisions")
public class Television {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String type;
    private String brand;

    @OneToOne
    RemoteController remoteController;

    @ManyToOne
    @JoinColumn(name = "ci_module_id")
    CiModule ciModule;

    @ManyToMany
    @JoinTable(
            name = "television_wallbrackets",
            joinColumns = @JoinColumn(name = "wallbracket_id"),
            inverseJoinColumns = @JoinColumn(name = "television_id")
    )
    List<WallBracket> wallBrackets;

    public CiModule getCiModule() {
        return ciModule;
    }

    public void setCiModule(CiModule ciModule) {
        this.ciModule = ciModule;
    }

    public RemoteController getRemoteController() {
        return remoteController;
    }

    public void setRemoteController(RemoteController remoteController) {
        this.remoteController = remoteController;
    }

    public Television() {}

    public Television(
            String type,
            String brand) {
        this.type = type;
        this.brand = brand;
    }

    public Long getId() {
        return id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

}



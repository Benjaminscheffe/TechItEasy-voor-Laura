package com.novi.TechItEasy.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "cimodules")
public class CiModule {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String type;

    @OneToMany(mappedBy = "ciModule")
    List<Television> televisions;

    public List<Television> getTelevisions() {
        return televisions;
    }

    public void setTelevisions(List<Television> televisions) {
        this.televisions = televisions;
    }

    public CiModule(String name, String type) {
        this.name = name;
        this.type = type;
    }

    public CiModule() {}

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}

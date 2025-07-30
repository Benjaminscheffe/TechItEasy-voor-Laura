package com.novi.TechItEasy.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "wallbrackets")
public class WallBracket {
    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private Number size;

    @ManyToMany(mappedBy = "wallBrackets")
    List<Television> televisions;

    public WallBracket() {}

    public WallBracket(
            String name,
            Number size) {
        this.name = name;
        this.size = size;
    }

    public Long getId() {
        return id;
    }

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

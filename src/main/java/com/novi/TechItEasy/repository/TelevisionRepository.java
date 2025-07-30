package com.novi.TechItEasy.repository;

import com.novi.TechItEasy.model.Television;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface TelevisionRepository extends JpaRepository<Television, Long> {

    List<Television> findAllTelevisionsByBrandEqualsIgnoreCase(String brand);
}

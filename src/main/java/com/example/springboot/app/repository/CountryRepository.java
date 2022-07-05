package com.example.springboot.app.repository;

import com.example.springboot.app.model.Country;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CountryRepository extends JpaRepository <Country, Long> {
    // Con @Repository le indico los metodos principales select, create, update, delete
}

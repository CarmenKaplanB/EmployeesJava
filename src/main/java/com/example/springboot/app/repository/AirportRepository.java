package com.example.springboot.app.repository;

import com.example.springboot.app.model.Airport;
import com.example.springboot.app.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AirportRepository extends JpaRepository <Airport, Long> {
    // Con @Repository le indico los metodos principales select, create, update, delete
}

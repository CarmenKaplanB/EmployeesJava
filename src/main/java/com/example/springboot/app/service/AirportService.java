package com.example.springboot.app.service;

import com.example.springboot.app.model.Airport;
import com.example.springboot.app.model.Employee;

import java.util.List;

public interface AirportService {

    Airport createAirport(Airport airport);

    Airport updateAirport(Airport airport);

    List<Airport> getAllAirport();

    Airport getAirportById(long airportId);

    void deleteAirport(long airportId);
}

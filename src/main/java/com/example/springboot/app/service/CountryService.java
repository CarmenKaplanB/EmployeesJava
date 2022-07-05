package com.example.springboot.app.service;

import com.example.springboot.app.model.Country;

import java.util.List;

public interface CountryService {
    Country createCountry(Country country);

    Country updateCountry(Country country);

    List<Country> getAllCountry();

    Country getCountryById(long countryId);

    void deleteCountry(long countryId);
}

package com.example.graphqlspring.service;


import com.example.graphqlspring.model.Country;

import java.util.List;

public interface ICountryService {

	Country saveCountry(Country country);

	Country getCountryById(Long id);

	void deleteCountryById(Long id);

	List<Country> findAll();

	List<Country> findByName(String name);
}

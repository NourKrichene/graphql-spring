package com.example.graphqlspring.service;


import com.example.graphqlspring.model.City;

import java.util.List;

public interface ICityService {

	City saveCity(City city);

	City getCityById(Long id);

	void deleteCityById(Long id);

	List<City> findAll();

	List<City> findByName(String name);
}

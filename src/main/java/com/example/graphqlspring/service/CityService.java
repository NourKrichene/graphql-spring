package com.example.graphqlspring.service;

import java.util.List;

import com.example.graphqlspring.model.City;
import com.example.graphqlspring.repository.CityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



@Service
public class CityService implements ICityService {

	@Autowired
	private CityRepository cityRepository;

	@Override
	public List<City> findAll() {
		return cityRepository.findAll();
	}

	@Override
	public List<City> findByName(String name) {
		return cityRepository.findByName(name);
	}

	@Override
	public City saveCity(City city) {
		return cityRepository.save(city);
	}

	@Override
	public City getCityById(Long id) {
		return cityRepository.findById(id).orElse(null);
	}

	@Override
	public void deleteCityById(Long id) {
		cityRepository.deleteById(id);
	}

}

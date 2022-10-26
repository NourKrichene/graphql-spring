package com.example.graphqlspring.service;

import java.util.List;

import com.example.graphqlspring.model.Country;
import com.example.graphqlspring.repository.CountryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



@Service
public class CountryService implements ICountryService {

	@Autowired
	private CountryRepository countryRepository;

	@Override
	public Country saveCountry(Country country) {
		return countryRepository.save(country);
	}

	@Override
	public Country getCountryById(Long id) {
		return countryRepository.findById(id).get();
	}

	@Override
	public void deleteCountryById(Long id) {
		countryRepository.deleteById(id);

	}

	@Override
	public List<Country> findAll() {
		return countryRepository.findAll();
	}

	@Override
	public List<Country> findByName(String name) {
		return countryRepository.findByName(name);
	}

}

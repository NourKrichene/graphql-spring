package com.example.graphqlspring.repository;

import java.util.List;

import com.example.graphqlspring.model.City;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;



@Repository
public interface CityRepository extends CrudRepository<City, Long> {

	@Override
	List<City> findAll();

	List<City> findByName(String name);
}
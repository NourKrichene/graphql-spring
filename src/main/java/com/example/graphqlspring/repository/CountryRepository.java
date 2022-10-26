package com.example.graphqlspring.repository;

import java.util.List;

import com.example.graphqlspring.model.Country;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface CountryRepository extends CrudRepository<Country, Long> {

	@Override
	List<Country> findAll();

	List<Country> findByName(String name);
}
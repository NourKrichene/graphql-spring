package com.example.graphqlspring.controller;

import com.example.graphqlspring.model.City;
import com.example.graphqlspring.service.ICityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;


@Controller
public class CityController {
    @Autowired
    private ICityService cityService;

	@QueryMapping
	public City city(@Argument Long id) {
		return cityService.getCityById(id);
	}

	@QueryMapping
	public List<City> allCities() {
		return cityService.findAll();
	}

	@QueryMapping
	public List<City> citiesByName(@Argument String name) {
		return cityService.findByName(name);
	}

    @MutationMapping
    public City addCity(@Argument String name, @Argument int population) {
        City city = new City();
        city.setName(name);
        city.setPopulation(population);
        return cityService.saveCity(city);
    }

    @MutationMapping
    public String deleteCity(@Argument Long id) {
        cityService.deleteCityById(id);
        return "City deleted";
    }

}

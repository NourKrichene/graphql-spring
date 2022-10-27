package com.example.graphqlspring.controller;

import com.example.graphqlspring.model.City;
import com.example.graphqlspring.model.Country;
import com.example.graphqlspring.service.ICityService;
import com.example.graphqlspring.service.ICountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;


@Controller
public class CountryController {
    @Autowired
    private ICountryService countryService;
    @Autowired
    private ICityService cityService;

    @QueryMapping
    public Country country(@Argument Long id) {
        return countryService.getCountryById(id);
    }

    @QueryMapping
    public List<Country> allCountries() {
        return countryService.findAll();
    }

    @QueryMapping
    public List<Country> countriesByName(@Argument String name) {
        return countryService.findByName(name);
    }

    @MutationMapping
    public Country addCountry(@Argument String name, @Argument String language) {
        Country country = new Country();
        country.setName(name);
        country.setLanguage(language);
        countryService.saveCountry(country);
        return country;
    }

    @MutationMapping
    public Country createCountry(@Argument Country country) {
        countryService.saveCountry(country);
        return country;
    }

    @MutationMapping
    public Country addCountryWithCapital(@Argument String name, @Argument String language, City capital) {
        Country country = new Country();
        country.setName(name);
        country.setLanguage(language);
        country = countryService.saveCountry(country);
        City city = cityService.getCityById(capital.getId());
        if (city != null) {
            country.setCapital(city);
        } else {
            country.setCapital(cityService.saveCity(capital));
        }
        return countryService.saveCountry(country);
    }

    @MutationMapping
    public String deleteCountry(@Argument Long id) {
        countryService.deleteCountryById(id);
        return "Country deleted";
    }

    @MutationMapping
    public Country setCapital(@Argument Long countryId, @Argument Long cityId) {
        Country country = countryService.getCountryById(countryId);
        country.setCapital(cityService.getCityById(cityId));
        return countryService.saveCountry(country);
    }

}

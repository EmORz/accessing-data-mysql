package com.example.accessingdatamysql;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
//@RequestMapping("/countries")
public class CountryController {

    @Autowired
    private CountryRepository countryRepository;

    @PostMapping("/add")
    public void addCountry(@RequestParam BigInteger id, @RequestParam String name, @RequestParam int population) {
        Country country = new Country();
        country.setId(id);
        country.setName(name);
        country.setPopulation(population);
        countryRepository.save(country);
    }

    @GetMapping("/get")
    public Iterable<Country> getAllCountries(Model model) {
        Iterable<Country> countries = countryRepository.findAll();
        return countries;
        //        List<Country> countriesList = new ArrayList<>();
//        countries.forEach(countriesList::add);
//
//        model.addAttribute("countries", countriesList);
//        return "countries";
    }

}

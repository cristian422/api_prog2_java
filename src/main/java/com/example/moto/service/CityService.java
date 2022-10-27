package com.example.moto.service;

import com.example.moto.model.City;
import com.example.moto.model.CityDto;
import com.example.moto.model.Node;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
@Data
public class CityService {
    private List<City> cities;


    public CityService() {
        cities = new ArrayList<>();
        cities.add(new City("001", "Manizales"));
        cities.add(new City("002", "Bogota"));
        cities.add(new City("003", "Medellin"));
    }

    public String addCity(City city) {

        for (City city1 : cities) {
            if (city1.getCode().equals(city.getCode())) {
                return "ya existe la ciudad";
            }
        }
        cities.add(city);
        return "ciudad Agregada";
    }




}


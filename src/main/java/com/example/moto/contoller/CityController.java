package com.example.moto.contoller;


import com.example.moto.model.City;
import com.example.moto.model.CityDto;
import com.example.moto.model.KidsByCitiesDTO;
import com.example.moto.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path="city")
public class CityController {
    @Autowired
    private CityService cityController;

    @GetMapping
    public List<City> getCities(){
        return cityController.getCities();
    }

    @PostMapping
    public String addCity(@RequestBody City city){
        return cityController.addCity(city);
    }


}

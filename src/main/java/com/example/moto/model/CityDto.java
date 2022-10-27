package com.example.moto.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CityDto {
    private String city;
    private char gender;
    private int quuantity;
}

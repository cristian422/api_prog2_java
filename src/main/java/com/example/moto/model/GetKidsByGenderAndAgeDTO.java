package com.example.moto.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data

public class GetKidsByGenderAndAgeDTO {
    private char gender;
    private int age;
}

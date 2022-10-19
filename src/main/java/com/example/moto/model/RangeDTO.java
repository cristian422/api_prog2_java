package com.example.moto.model;


import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor//todos los argumentos necesarios
@Data
public class RangeDTO {
    int rangestart;
    int rangeend;
    int quantity;
}

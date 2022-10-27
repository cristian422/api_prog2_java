package com.example.moto.model;


import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor//exige que al momento de crear el objeto ingrese todos los atributos
@Data//crea get y set
public class Kid {
    private String identification;//identuficador unico de cada niño
    private String name;//nombre del niño pueden existir niños que se llamen igual
    private byte age;//edad del niño
    private char gender;//genero del niño solo se usan H para hombre y M para mujer //para python validar en kid---if age in data

    private byte numBrothers;
    private City city;
}

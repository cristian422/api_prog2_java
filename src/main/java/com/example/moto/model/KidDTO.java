package com.example.moto.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
//es una clase especial ya que se usa para eliminar posr posicion y eliminar
//se unen el entero y un kid para que sea mas facil de leer y de manejar
public class KidDTO {
    int position;//posicion
    Kid dataKid;//un objeto de tipo kid

}

package com.example.moto.service;

import com.example.moto.model.*;
import lombok.Data;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Data

public class ListaDEService {
    public ListaDE listaDE;


    //lista
    public ListaDEService(){
        listaDE=new ListaDE();
        listaDE.addDE(new Kid("12358794", "andres", (byte) 2, 'M'));
        listaDE.addDE(new Kid("789523146", "luis", (byte) 12, 'M'));
        listaDE.addDE(new Kid("85246","andrea",(byte) 2,'M'));
        listaDE.addDE(new Kid("741963546813","daniela",(byte) 5,'H'));
        listaDE.addDE(new Kid("468791","jero",(byte) 9,'H'));

    }
    //devuelve una lista de kid
    public List<Kid> getList(){
        return listaDE.getList();
    }
    //regresa una string estrada un kid
    public String addDE(Kid kid){
        return listaDE.addDE(kid);
    }
    //agrega inicio
    public String addToStart(Kid kid){
        listaDE.addToStart(kid);
        return "Se agrego";
    }
    //invierte la lista
    public String invert(){
        return listaDE.invert();
    }
    public String swap(){
        return listaDE.swap();
    }
    public String addByposition(KidDTO kidDTO){
        return listaDE.addByPosition(kidDTO);
    }
    public String deletByPosition(int i){
        return listaDE.deletByPosition(i);
    }
    public String deleteByLetterAndAge(DeletByLetterAndAgeDTO deletByLetterAndAgeDTO){
        return listaDE.deleteByLetterAndAge(deletByLetterAndAgeDTO);
    }
    public  String deletByData(String identification){
        return listaDE.deletByData(identification);
    }
    public String mixByGender(){
        return listaDE.mixByGender();
    }
    public String firstgender(){
        return listaDE.firstgender();
    }
    //regresa una lista de los rangos se muetran en formato json
    public List<RangeDTO> Range(){

        List <RangeDTO> range=new ArrayList<>();
        range.add(new RangeDTO(1,2,listaDE.rageAge(1,2)));
        range.add(new RangeDTO(5,9,listaDE.rageAge(5,9)));
        range.add(new RangeDTO(10,14,listaDE.rageAge(10,14)));
        range.add(new RangeDTO(15,18,listaDE.rageAge(15,18)));
        //  List<RangebyageDTO ranges=new ArrayList();
        //ranges.add(new RangebyageDTO(rangestart rangeEnd quantity)
        return range;
    }
}

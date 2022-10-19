package com.example.moto.service;

import com.example.moto.model.*;
import lombok.Data;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
@Data

public class ListSEService {
    private ListaSE list;//un print despues de esta linea sale null

    //lista
    public ListSEService() {
        list = new ListaSE();//un print despues de esta linea sale la direccion de memoria donde se guarda el objeto
        list.add(new Kid("12358794", "andres", (byte) 2, 'M'));
        list.add(new Kid("789523146", "luis", (byte) 12, 'M'));
        list.add(new Kid("85246","estiven",(byte) 2,'M'));
        list.add(new Kid("741963546813","daniel",(byte) 3,'H'));
        list.add(new Kid("468791","jero",(byte) 9,'H'));
    }



    public String add(Kid kid){

        return list.add(kid);
    }

    public String addFirst(Kid kid){
        list.addFirst(kid);
        return "se agrego al final :)";//me regresa que si se pudo en un string
    }

    public String firstAndLast(){
        list.firstAndLast();
        return "the list was changed";
    }
    public  String reverseList(){
        list.reverseList();
        return "lista revertida";
    }
    public String maleAndFemal(){
        list.maleAndFemal();
        return "primero hombres despues mujeres";
    }
    public String deletposition(int i){
        list.deletposition(i);
        return "eliminado";
    }

    public String delet3YearsKids(){
        list.delet3YearsKids();
        return "eliminados";
    }
    public int count(){

        return list.count();
    }
    public String addByposition(KidDTO kidDTO){

        if (kidDTO.getPosition()<= list.getSize()+1){
            list.addByposition(kidDTO);
            return "agregado en la posicion: ";
        }
         return "no se pudo agregar";
    }
    public String less7years(){
        list.less7years();
        return "menores he iguales a 7";
    }

    public String genderintercalate(){
        list.genderIntercalate();
        return "listo";
    }
    public String deletByLetterAndAge(DeletByLetterAndAgeDTO deletByLetterAndAgeDTO){
        list.deletByLetterAndAge(deletByLetterAndAgeDTO);
        return "listo";
    }
    public String intercalateEvenAndOdd(){
        list.intercalateEvenAndOdd();
        return "Listo";
    }
    public List<RangeDTO> Range(){

        //se crea la lista de tipo rage
        List <RangeDTO> range=new ArrayList<>();
        //para agregar a la lista se necesitan el inicial, el fianl y la catidad
        //para la cantidad se llama al metodo range en el modelo
        range.add(new RangeDTO(1,2,list.kidsByrange(1,2)));
        range.add(new RangeDTO(5,9,list.kidsByrange(5,9)));
        range.add(new RangeDTO(10,14,list.kidsByrange(10,14)));
        range.add(new RangeDTO(15,18,list.kidsByrange(15,18)));
        //  List<RangebyageDTO ranges=new ArrayList();
        //ranges.add(new RangebyageDTO(rangestart rangeEnd quantity)
        return range;
    }

}






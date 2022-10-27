package com.example.moto.contoller;

import com.example.moto.model.*;
import lombok.NoArgsConstructor;


import com.example.moto.service.ListSEService;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path="listse")
public class ListSEController {
    @Autowired
    private ListSEService listSEService;

    @GetMapping//vamos a pedir la lista de niños por el get
    public Node getList(){
        return listSEService.getList().getHead();
    }

   // @GetMapping(path ="append/{identification}/{name}/{age}/{gender}")
    //public Node append(@PathVariable String identification,@PathVariable String name, @PathVariable byte age,@PathVariable char gender){
      //  Kid newkid=new Kid(identification,name,age,gender);
       // listSEService.getList().add(newkid);
        //return listSEService.getList().getHead();
    //}
    @PostMapping   //es el primer metodo para agregar un kid por el post
    public String addKid(@RequestBody Kid kid){
        return  listSEService.add(kid);//llamamos al metodo en el service y le damos el niño a ingresar

    }
    @PostMapping(path = "add/first")//direcion de la url
    public String addKidFirst(@RequestBody Kid kid){//public ,el tipo de dato a devolver ,nombre del metodo ,si va a ingresar algo por el body del postman lo coloca

        return listSEService.addFirst(kid);//aca se esta llamndo al metodo que esta en el service que dentro llama al metodoque esta en el modelo
    }

    @PostMapping(path = "addbyposition")//añadir por posicion POST
    public String addByposition(@RequestBody KidDTO kidDTO){//le vamos a ingresa un objeto en json por el body del post
            return listSEService.addByposition(kidDTO);

    }

    @PostMapping(path = "delet3yearskids")//eliminar niños de 3 años
    public String delet3YearsKids(){
        return listSEService.delet3YearsKids();
    }


    @PostMapping(path = "firstandlast")//intercambiar el primero y el ultimo
    public String first_AndLast(){
        listSEService.firstAndLast();
        return "listo :)"; //retornamos una strig que me dice que ya termino
    }
    @PostMapping(path = "reverselist")//invierte la lista [1,2,3,4]....[4,3,2,1]
    public String reverseList(){
        listSEService.reverseList();
        return "listo";
    }
    @PostMapping(path = "maleandfemale")//deja primero a los hombres despues a las mujeres
    public String maleAndFemal(){
        listSEService.maleAndFemal();
        return "Listo";
    }

    @PostMapping(path = "count")//cuenta cuantos niños hay en la lista
    public int count(){
        return (int)listSEService.count();
    }

    @PostMapping(path = "less7years")//elimina niños menores a 7 años
    public String less7years(){
        return listSEService.less7years();
    }


    @PostMapping(path = "deletposition")//elimina por posicion
    //se le ingresa el numero de la posicion que se desea eliminar
    public String deletposition(@RequestBody int i){
       return listSEService.deletposition(i);
    }

    @PostMapping(path ="genderintercalate")//intercalar generos
    public String genderIntercalate(){
        return listSEService.genderintercalate();
    }

    @PostMapping(path = "deletByLetterAndAge")//eliminar por letra inicial del nombre y la edad
    //en el body del post se debe mandar un objeto deletByLetterAndAgeDTO el cual contiene la letra y la edad
    public String deletByLetterAndAge(@RequestBody DeletByLetterAndAgeDTO deletByLetterAndAgeDTO){
        return listSEService.deletByLetterAndAge(deletByLetterAndAgeDTO);
    }
    @PostMapping(path = "Range")//me trae una lista en formato json con la cantidad y rangos de edad
    public List<RangeDTO>Range(){
        return listSEService.Range();
    }

    @PostMapping(path = "intercalateEvenAndOdd")//intercala pares e inpares
    public  String intercalateEvenAndOdd(){
        return listSEService.intercalateEvenAndOdd();
    }

    @PostMapping(path = "GetKidsByGenderAndAge")
    public List<Kid> GetKidsByGenderAndAge(@RequestBody GetKidsByGenderAndAgeDTO getKidsByGenderAndAgeDTO){
        return listSEService.GetKidsByGenderAndAge(getKidsByGenderAndAgeDTO.getGender(),getKidsByGenderAndAgeDTO.getAge());
    }

    @PostMapping(path = "informationbycities")
    public List<CityDto> InformationByCities(){return listSEService.InformationByCities();}
    @PostMapping(path = "kidsbycities")
    public int kidbyCities(@RequestBody KidsByCitiesDTO kidsByCitiesDTO){return listSEService.KidsByCities(kidsByCitiesDTO.getCity(),kidsByCitiesDTO.getGender());}


    @PostMapping(path = "promhermanos")
    public float PromHermanos(@RequestBody String name){
        return listSEService.PromHermanos(name);
    }


//public List<RangebyageDTO>
    //List<RangebyageDTO ranges=new ArrayList();
    //ranges.add(new RangebyageDTO(rangestart rangeEnd quantity)
}

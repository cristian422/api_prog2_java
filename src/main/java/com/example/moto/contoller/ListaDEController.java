package com.example.moto.contoller;

import com.example.moto.model.DeletByLetterAndAgeDTO;
import com.example.moto.model.Kid;
import com.example.moto.model.KidDTO;
import com.example.moto.model.RangeDTO;
import com.example.moto.service.ListaDEService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "ListDE")
public class ListaDEController {
    //la mayor diferencia con SE es que los nodos de DE tienen previos
    @Autowired
    private ListaDEService listaDEService;

    @GetMapping//no se puede obtener los niños de la misma forma que en DE
    //ya que entrariamos en un bucle por lo que toca sacar la informacion de cada niño
    //y pasarlo a una lista y esta es la que se muestra
    public List<Kid> getList() {
        return listaDEService.getList();
    }

    @PostMapping(path = "addDE")//agregar niños en DE
    public String addDE(@RequestBody Kid kid) {
        return listaDEService.addDE(kid);
    }

    @PostMapping(path = "addToStart")//agregar al inicion en DE
    //igualmente se envia un kid por el body del post
    public String addToStart(@RequestBody Kid kid) {
        return listaDEService.addToStart(kid);
    }

    @PostMapping(path = "invert")//invertir lista
    public String invert(){
        return listaDEService.invert();
    }

    @PostMapping(path = "swap")//cambiar al primero y al ultimo en DE
    public String swap(){
        return listaDEService.swap();
    }

    @PostMapping(path = "addbyposition")//agregar por posicion
    //ingresamos igual que en SE un kidDTO por el body del post
    public String addByPosition(@RequestBody KidDTO kidDTO){
        return listaDEService.addByposition(kidDTO);
    }

    @PostMapping(path = "deletbyposition")//elimina por posicion
    //ingresamos la posicion del kid que queremos eliminar
    public  String deletByPosition(@RequestBody int i){
        return listaDEService.deletByPosition(i);
    }

    @PostMapping(path = "deletebyletterandage")//eliminar por letra inicial del nombre y edad
    //se deben cumplir las dos conciones para poder ser eliminado
    public  String deleteByLetterAndAge(@RequestBody DeletByLetterAndAgeDTO deletByLetterAndAgeDTO){
        return listaDEService.deleteByLetterAndAge(deletByLetterAndAgeDTO);
    }

    @PostMapping(path = "deletbydata")
    public String deletByData(@RequestBody String identification){
        return listaDEService.deletByData(identification);
    }

    @PostMapping(path = "mixbygender")//intercalamos por el genero
    public String mixByGender(){
        return listaDEService.mixByGender();
    }

    @PostMapping(path = "firstgender")//primero un genero en este caso se escogio a los hombres de primero
    public String firstgender(){
        return listaDEService.firstgender();
    }

    @PostMapping(path = "range")//muestra los ranfos y las cantidades de niños que tenemos en esos rangos
    public List<RangeDTO> range(){
        return listaDEService.Range();
    }
}

package com.example.moto.service;

import com.example.moto.contoller.CityController;
import com.example.moto.model.*;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;


@Service
@Data

public class ListSEService {
    private ListaSE list;//un print despues de esta linea sale null

    @Autowired
    private CityService cities;

    //lista
    public ListSEService() {
        list = new ListaSE();//un print despues de esta linea sale la direccion de memoria donde se guarda el objeto
        list.add(new Kid("12358794", "andres", (byte) 2, 'M',(byte) 2,new City("001","Manizales") ));
        list.add(new Kid("789523146", "luis", (byte) 12, 'M',(byte) 0,new City("002","Bogota")));
        list.add(new Kid("85246","estiven",(byte) 2,'M',(byte) 3,new City("003","Medellin")));
        list.add(new Kid("741963546813","daniel",(byte) 3,'H',(byte) 1,new City("002","Bogota")));
        list.add(new Kid("468791","jero",(byte) 9,'M',(byte) 4,new City("003","Medellin")));
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
    public List<Kid> GetKidsByGenderAndAge(char gender,int age){
        return list.GetKidsByGenderAndAge(gender, age);
    }
    public List<CityDto> InformationByCities() {
        ArrayList information = new ArrayList<CityDto>();


        for (City city : this.cities.getCities()) {
            int num = KidsByCities(city.getName(),'H');
            CityDto ciudad=new CityDto(city.getName(),'H',num);
            information.add(ciudad);

            int cantidadMujeres=KidsByCities(city.getName(),'M');
            CityDto ciudadMujeres=new CityDto(city.getName(),'M',cantidadMujeres);
            information.add(ciudadMujeres);
            //InformationByCities().add(new CityDto());**/
        }
        return information;
    }

    //metodo que me dice cuantos niños hay por ciudad
    //parametros de entrada codigo de la ciudad
    //genero de la cantidad de los niños
    public int KidsByCities(String name, char gender) {
        int cantidad = 0;//inicia el contador en cero de los niños
        Node temporal = this.list.getHead();//creamos un temporal y empieza en la cabeza


        while (temporal != null) {//temporal recorre toda la lista
            //se tienen que cumplir las doscondiciones el genero y la ciudad
            if (Objects.equals(temporal.getData().getCity().getName(), name)   && temporal.getData().getGender() == gender) {
                cantidad = cantidad + 1;//agregamos uno al contador
            }
            temporal = temporal.getNext();//temporal pasa a siguiente
        }
        return cantidad;//retorna la cantidad
    }
    public float PromHermanos(String name){

        int contado=0;
        float promhermanos;
        int numhermanos=0;
        Node temporal=this.list.getHead();
        while (temporal!=null){
            if (temporal.getData().getNumBrothers()>0 && temporal.getData().getCity().getName().compareTo(name)==0){
                System.out.println("entro");
                contado=contado+1;
                numhermanos=numhermanos+temporal.getData().getNumBrothers();
            }
            temporal=temporal.getNext();
        }
        System.out.println(numhermanos);
        if (numhermanos!=0){
            promhermanos=numhermanos/contado;
        }else {return 0.0F;}


        return promhermanos;
    }



}






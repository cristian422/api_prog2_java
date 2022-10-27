package com.example.moto.model;


import com.example.moto.service.CityService;
import com.example.moto.service.ListSEService;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor

public class ListaSE {
    private Node head;
    private int size;


    //metodo agregar al final
    public String add(Kid kid) {
        //se verifica que se ingrese los datos del niño
        switch (check(kid)){
            case 0:return "genero no permitido solo H para hombre o M para Mujer";
            case 1:return "Numero de identificacion ya existente";
            case 2:return "Edad invalida";
            case 3:if (head == null) {
                head = new Node(kid);
            } else {
                Node temp = head;
                while (temp.getNext() != null) {
                    temp = temp.getNext();
                }
                //Ayudante esta en el ultimo
                Node newNode = new Node(kid);
                temp.setNext(newNode);//se guarda el nuevo niño
                size++;//se le suma al tamaño de la lista
                return "el niño se agrego";
            }

        }

        return "no paso nada";
    }





    //metodo agregar de primero o en la head
    public void addFirst(Kid kid) {
        if (head == null) {//la cabeza no esta vacia
            head = new Node(kid);
        } else {
            Node newNode = new Node(kid);//creamos un nuevo nodo
            newNode.setNext(head);//cuardamos en el siguiente la cabeza
            head = newNode;//cambiamos de cabeza
        }
    }

    //metodo conta
    public int count(){
        if (head.getData()==null) {//si la cabeza esta vacia
            return 0;
        }
        Node temp= head;//temporal inicia en la cabeza
        int counter= 1;
        while (temp.getNext()!= null) {//mientras el siguiente diferente de null
            counter += 1;//contador aumenta
            temp = temp.getNext();//temporal igual al siguiente
        }

        return counter;//regresa el contador
    }


    //intercalar por genero
    public void genderIntercalate() {
        Node temp = this.head;
        ListaSE lista=new ListaSE();//nueva lista

        //iniciamos posiciones hombres y mujeres
        int pocitionH=1;
        int pocitionM=2;
        while (temp!=null){//recorre hasta el final de la lista
            KidDTO newKidDTO=new KidDTO(pocitionH,temp.getData());
            //creamos un kid con los datos de temp
            Kid newkid=new Kid(newKidDTO.dataKid.getIdentification(),newKidDTO.dataKid.getName(),newKidDTO.dataKid.getAge(),newKidDTO.dataKid.getGender(),newKidDTO.dataKid.getNumBrothers(), newKidDTO.dataKid.getCity());
            if(temp.getData().getGender()=='H'){//para genero hombre

                if (newKidDTO.getPosition()>lista.size+1){//posicion mayor al tamaño
                    lista.addFirst(newkid);//agregamos de primero
                }else {
                    lista.addByposition(newKidDTO);//agregamos en la posicion
                }
                pocitionH=pocitionH+2;//sumamos dos
            }

            if(temp.getData().getGender()=='M'){//si el genero es mujer


                if(newKidDTO.getPosition()>lista.size+1){
                    lista.add(newkid);
                }else {
                    lista.addByposition(newKidDTO);
                }


                pocitionM=pocitionM+2;
            }
            temp=temp.getNext();//temporal pasa a ser el siguiente
        }


        this.head=lista.head;
    }
    //intercar par en inpar
    public void intercalateEvenAndOdd(){//intercar par en inpar
        Node temp = this.head;
        ListaSE lista=new ListaSE();//nueva lista
        //posiciones hombre y mujeres
        int pocitionH=1;
        int pocitionM=2;
        while (temp!=null){//leer toda la lista
            KidDTO newKidDTO=new KidDTO(pocitionH,temp.getData());
            Kid newkid=new Kid(newKidDTO.dataKid.getIdentification(),newKidDTO.dataKid.getName(),newKidDTO.dataKid.getAge(),newKidDTO.dataKid.getGender(),newKidDTO.dataKid.getNumBrothers(), newKidDTO.dataKid.getCity());
            int variable=Math.floorMod( temp.getData().getAge(),2);
            //si es igual a cero es que es par
            if(variable==0){
                System.out.println("entro");
                if (newKidDTO.getPosition()>lista.size+1){
                    lista.addFirst(newkid);
                }else {
                    lista.addByposition(newKidDTO);
                }
                pocitionH=pocitionH+2;//sumamos dos
            }else {
                //es un inpar
                if(newKidDTO.getPosition()>lista.size+1){
                    lista.add(newkid);
                }else {
                    lista.addByposition(newKidDTO);
                }

                pocitionM=pocitionM+2;

            }
            temp=temp.getNext();//temporal pasa al siguiente

        }

        head=lista.head;//cambiamos de head
    }

    //intercambiar primero y ultimo
    public  void firstAndLast() {
        Node temp = this.head;
        ListaSE newList=new ListaSE();//nueva lista
        //mientras el siguiente del siguiente diferente de null
        //se quedara en el penultimo
        while (temp.getNext().getNext() != null) {
            temp = temp.getNext();//pasa a ser el siguiente
            newList.add(temp.getData());//agregamos al final
        }
        newList.addFirst(temp.getNext().getData());//agregamos de primero
        newList.add(head.getData());//agregamos al fial
        head=newList.head;//cambiar de cabeza

    }

    //invierte la lista del ultimo al primero
    public void reverseList(){

        ListaSE reversa=new ListaSE();//nueva lista
        Node temp=head;//inicia en la head
        while (temp.getNext() !=null){//se queda en el ultimo
            reversa.addFirst(temp.getData());//agrega de primero el dato
            temp=temp.getNext();//pasa a ser el siguiente
        }
        reversa.addFirst(temp.getData());//agrega al inico al ultimo
        head=reversa.head;//cambiamos de cabeza

    }

    //primerp hombres despues mujeres
    public void maleAndFemal(){
        ListaSE newList=new ListaSE();//nueva lista
        Node temp=head;
        while (temp.getNext()!=null){//se queda en el ultimo
            if (temp.getData().getGender()=='H'){//en el caso que sea hombre
                newList.addFirst(temp.getData());//agrego primero
            }else {
                newList.add(temp.getData());//agrego final
            }
            temp=temp.getNext();//paso al siguiente
        }
        if (temp.getData().getGender()=='M'){//en el caso que sea mujer
            newList.addFirst(temp.getData());//agrego primero
        }else {
            newList.add(temp.getData());//agrego final
        }
        temp=temp.getNext();//paso al siguiente

        head=newList.head;//cambiar de cabeza
    }

    //eliminar por posicion entrada la posicion a eliminar
    public  void deletposition(int i){
        Node temp=this.head;//temporal inicia en la cabeza
        int contador=1;//inica contador en uno
        if (i==1){
            head=temp.getNext();//cabeza pasa a ser el siguiente
        }
        while (contador<i){//mientras sea menor a la posicion


            temp=temp.getNext();//pasa a ser el siguiente
            contador=contador+1;//aumenta en uno

        }
        if (contador==i-1){//se queda uno antes de la posicion
            temp.setNext(temp.getNext().getNext());//guarda en el siguiente al que le sigue del que se va a eliminar
        }
        size--;//se reduce en uno la lista

    }

    //agregar por posicion entrada un dto con un kid y una posicion
    public void addByposition(KidDTO kidDTO){
        Node temp=this.head;
        int contador=1;
        //creamos un niño con los datos del dto
            Kid newkid = new Kid(kidDTO.dataKid.getIdentification(), kidDTO.dataKid.getName(), kidDTO.dataKid.getAge(), kidDTO.dataKid.getGender(),kidDTO.dataKid.getNumBrothers(), kidDTO.dataKid.getCity());
            Node newKid = new Node(newkid);//ingresamos al niño en un nodo
            if (kidDTO.position == 1) {
                newKid.setNext(temp);//niño queda en la primero posicion
                head = newKid;
            }
            while (contador < kidDTO.position) {//queda en una posicion antes


                temp = temp.getNext();//pasa a ser el siguiente
                contador = contador + 1;//aumenta uno el contador
            }
        if (contador == kidDTO.position - 1) {
            newKid.setNext(temp.getNext());//guardamos al niño en la posicion
            temp.setNext(newKid);
        }
            size++;//aumneta en uno el tamaño

    }


    //deja solo a los menore de 7
    public void less7years(){
        ListaSE newlist=new ListaSE();//nueva lista
        Node temp=head;
        for (int i = 0; i < size; i++) {//desde 0 hasta el tamaño de la lista
            if (temp.getData().getAge()<=7){//tiene que ser menor o igual a 7
                newlist.add(temp.getData());//guardo al final
            }
            temp=temp.getNext();//pasa al siguiente
        }
        head=newlist.head;//cambiar de head
    }


    public int check(Kid kid) {
        Node temp=this.head;

        //verificacion gender correcto
        if (kid.getGender() != 'H' && kid.getGender() != 'M') {
            return 0;
        }
        //""""""verificacion que no hayan indentificaciones iguales


       while(temp!=null) {
            System.out.println(temp.getData().getIdentification());
            if (temp.getData().getIdentification()==kid.getIdentification()){
                return 1;
            }
            temp=temp.getNext();
        }

        //verificacion edad
        if(kid.getAge()<0){
            return 2;

        }
        return 3;

    }

    //elimian menore de 3 años
    public  void delet3YearsKids(){
        Node temp=head;
        ListaSE newlist=new ListaSE();//nueva lista
        if (head.getData().getAge()<3){
            head=temp.getNext();
        }

        while (temp.getNext()!=null){//se queda en el ultimo
            if (temp.getData().getAge()>=3){//si es mayor o igual a 3 los agrega en una nueva lista
                newlist.add(temp.getData());
            }

            temp=temp.getNext();//pasa a ser el siguiente
        }
        if (temp.getData().getAge()>=3){
            newlist.add(temp.getData());
        }
        head=newlist.head;//cambiar de head

    }

    //eliminar por letra y edad
    public void deletByLetterAndAge(DeletByLetterAndAgeDTO deletByLetterAndAgeDTO){
        Node temp=head;
        ListaSE newlist=new ListaSE();//nueva lista

        while (temp!=null) {//lee toda la lista
            char letra=temp.getData().getName().charAt(0);//nos da el caracter inicial del nombre
            //si ninguna de las dos se cumple no se agrega
            if (letra!=deletByLetterAndAgeDTO.letra || temp.getData().getAge()!=deletByLetterAndAgeDTO.age){
                newlist.add(temp.getData());
                newlist.size++;
            }
            temp=temp.getNext();//pasa al siguiente

        }
        head=newlist.head;//cambiar de head
    }

    //rango
    public  int kidsByrange(int rangeInicial,int rangeFinal){
        Node temp=head;
        int contador=0;
        while (temp!=null){//leer toda la lista
            //se deben cumplir las dos condiciones
            if(temp.getData().getAge()>=rangeInicial && temp.getData().getAge()<=rangeFinal){
                contador=contador+1;//aumenta en uno el contador
            }
            temp=temp.getNext();
        }
        return contador;//devuelve la cantidad
    }
    public List<Kid> GetKidsByGenderAndAge(char gender,int age){
        List newList=new ArrayList<Kid>();
        if (this.head!=null){

            Node temp=this.head;
            while (temp!=null) {
                if (temp.getData().getGender() == gender) {
                    if (temp.getData().getAge() >= age) {
                        if (temp.getData().getNumBrothers() > 0) {
                            newList.add(temp.getData());
                        }
                    }

                }
                temp=temp.getNext();
            }


        }
        return newList;
    }




}



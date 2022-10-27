package com.example.moto.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor//me indica que no son necesarios que tenga todos los argumentos para crear un objeto de este tipo
@Data
//clase de la lista DE
public class ListaDE {
    //head es el inicial de la lista, el primero
    private NodeDE head;

    //tamaño de la lista
    private int size;


    //metodo el cual me devuelve la lista de kid
    public List<Kid> getList() {
        //creamos un ayudante de tipo NodeDE
        //igualamos el temp a la head
        NodeDE temp = head;
        //creamos una lista que va a guardar objetos de tipo kid
        List<Kid> list = new ArrayList<>();
        //verificamos que la cabeza si contenga algo
        // ya que si es null no se hace nada
        //si la cabeza es diferente de null
        if (head != null) {
            //mientras el ayudante sea diferente de null
            while (temp != null) {
                //agregamos a la lista los datos que contiene el ayudante o temporal
                list.add(temp.getData());
                //el temporal pasa a ser su siguiente
                temp = temp.getNext();
            }


        }
        //retornamos la lista
        return list;
    }
    //metodo que agrega al final
    //se le manda como entrada un objeto de tipo kid el cual es el que se va a añadir
    public String addDE (Kid kid) {
        //si la lista esta vacia simplemente se agrega a la cabeza
        if (head == null) {
            //guardamos al kid en un nodo DE y lo guardamos en la head
            head = new NodeDE(kid, null, null);
        } else {//en caso que la cabeza si contenga alfo
            NodeDE temp = head;//creamos un temporal y lo igualamos a la cabeza
            while (temp.getNext() != null) {//mientras que el siguiente del temporal sea diferente a null
                temp = temp.getNext();//temporal pasa a ser el seguiente

            }
            //Ayudante esta en el ultimo
            //guardamos al kid en un nodo DE
            NodeDE newNode = new NodeDE(kid, null, temp);
            //guardamos al nuevo nodo en el siguiente del temporal
            temp.setNext(newNode);
            //le sumamos uno al tamaño de la lista por el nuevo que se añadio
            size++;


        }//retornamos un mensaje que nos dice que si se pudo añadir al niño
        return "el niño se agrego";
    }

    //metodo que agrega al inicio
    //se le debe de mandar un objeto de tipo kid
    public void addToStart(Kid kid){
        //guardamos al niño en un nodo DE
        NodeDE newNode=new NodeDE(kid);
        //verificamos que la cabeza no este vacia
        // ya que en ese caso el nuevo ya llegaria a ser el primero
        if (this.head==null){
            //guardamos al nuevo nodoDE en la cabeza
            head=newNode;
        }else {
            //primero conectamos la cabeza con el siguiente
            newNode.setNext(this.head);
            //aseguramos que el nuevo tenga su previus
            newNode.setPrevius(null);
            //le decimo que el nuevo head va a se el nuevoNodeDE
            head=newNode;
        }
        //sumamos uno al tamaño
        size++;

    }

    //metodo que invierte la lista
    public String invert(){
        //creamos una nueva listaDE
        ListaDE neWListDE=new ListaDE();
        //verificamos que el tamaño de la lista sea mayor a 0
        // y menor a uno ya que en ese caso no se invierte
        if (size>0 && size<1){

        }else {
            //creamos un temporal de tipo NodeDE y lo igualamos a la ca beza
            NodeDE temporal=head;
            while (temporal!=null){//mientras que el temporal sea diferente de null se va a hacer lo siguiente
                //temporal!=null permite que me recorra toda la lista
                neWListDE.addToStart(temporal.getData());//los va a ir ingresando de primero
                temporal=temporal.getNext();//el temporal pasa a ser su siguiente
            }
        }
        //la cabeza igual a la cabeza de la nueva lista
        this.setHead(neWListDE.head);
        return "se revirtio";
    }

    //intercambia al primero y ultimo
    public  String swap(){
        //crea un temporal de tipo nodeDE
        NodeDE temporal=head;//igualamos a la cabeza
        ListaDE newList=new ListaDE();//creamos una nueva lista DE
        while (temporal.getNext().getNext()!=null){//mientras que temporal siguiente sieguiente sea diferente a null
            newList.addDE(temporal.getData());//agregamos los datos del temporal en la nueva lista
            temporal=temporal.getNext();//temporal pasa a ser su siguiente
        }
        //el temporal se para justo en el penultimo
        newList.addToStart(temporal.getNext().getData());//agregamos al inicio a los datos del temporal sigioente que seria el ultimo
        newList.addDE(this.head.getData());//agregamos al final la cabeza
        this.head=newList.head;//la cabeza de la nueva lista se convierte en la cabeza de la principal

        return "Se cambio";
    }

    //metodo agregar por posicion
    public String addByPosition(KidDTO kidDTO){//de entrada se el manda un objeto de tipo kiddto
        NodeDE temp=this.head;//creamos un temporal de nodeDE
        int contador=1;//iniciamos un contador en uno
        //creamos un kid de los datos del kidDTO
        Kid Newkid = new Kid(kidDTO.dataKid.getIdentification(), kidDTO.dataKid.getName(), kidDTO.dataKid.getAge(), kidDTO.dataKid.getGender(),kidDTO.dataKid.getNumBrothers(),kidDTO.dataKid.getCity());
        NodeDE newKid = new NodeDE(Newkid);//ingresamos el kid en un nodoDE
        if (kidDTO.position == 1) {//si la posicion del DTO es igual a 1 se ingresa de primero
            newKid.setNext(temp);//guardamos al temporal en el set del nuevo nodo
            newKid.setPrevius(null);//le decimos que su previo es null
            head = newKid;//la nueva cabeza pasa a ser el nuevokid
        }
        while (contador < kidDTO.position) {//mientras el contador sea menor a la posicion ingresada
            //hace que se quede en una posicion antes

            if (contador == kidDTO.position - 1) {//contador igual a la posicion menos uno verifica que si este en una posicion antes
                newKid.setNext(temp.getNext());//gaurdamos en el siguente del nuevo al siguiente del temporal
                newKid.setPrevius(temp);//gardamos en el anterior del nuevo al temporal
                temp.setNext(newKid);//guarda al siguiente del temporal al nuevo
                temp.getNext().setPrevius(newKid);//guardamos al siguiente del temporal su previo el nuevo
            }
            temp = temp.getNext();//el temporal pasa a ser el siguiente
            contador = contador + 1;//contador aumenta en uno

        }
        size++;//sumamos uno al tamaño
        return "agregado ";
    }

    //metodo elimina por posicion
    public String deletByPosition(int i){//se el ingresa de entrada la posicion del dato a eliminar
        //creamos un temporal de tipo NodeDE
        NodeDE temp=this.head;//igualamos el temporal a la head
        int contador=1;//iniciamos el contador en uno
        if (i==1){//si la posicion ingresada es la primera
            head=temp.getNext();//la cabeza pasa a ser el siguiente del temporal
            head.setPrevius(null);//el anterior del head queda null
        }
        while (contador<i){//hace que llegue a una posicion antes de la indicada
            if (contador==i-1){
                temp.setNext(temp.getNext().getNext());//el siguente del temporal pasa a ser siguiente siguiente
                temp.getNext().getNext().setPrevius(temp);//guardamos en el previo del siguiente siguiente al temporal
            }
            temp=temp.getNext();//el temporal pasa a ser su siguiente
            contador=contador+1;//contador aumenta en uno

        }
        size--;//contrario al size++ en este caso el tamaño se reduce uno
        return "eliminado";
    }

    //eliminar por letra y edad
    public String deleteByLetterAndAge(DeletByLetterAndAgeDTO deletByLetterAndAgeDTO){
        NodeDE temp=head;//igualamos el temporal a la head
        ListaDE newlist=new ListaDE();//creamos una nueva lista DE

        while (temp!=null) {//hace que me recorra toda la lista

            char letra=temp.getData().getName().charAt(0);//de los datos obtiene el nombre
            //el nombre es una string y obtiene el primer caracter

            //si la letra es diferente a la ingresada o diferente a la edad
            if (letra!=deletByLetterAndAgeDTO.letra || temp.getData().getAge()!=deletByLetterAndAgeDTO.age){
                newlist.addDE(temp.getData());//agregamos en la nueva lista
                newlist.size++;//sumamos uno en la nueva lista
            }
            temp=temp.getNext();//temporal pasa a ser su siguiente

        }
        this.head=newlist.head;//la head de la nueva lista pasa a ser la head principal
        return "eliminado";
    }


    //eliminar por dato el dato es el identificador unico de cada niño
    public String deletByData(String identification){
        NodeDE temp=head;//creamos un temporal tipo NodeDE y lo igualamos a la head
        ListaDE newlist=new ListaDE();//creamos una nueva lista DE

        while (temp!=null) {//temporal debe recorrer toda la lista

            if (identification!=temp.getData().getIdentification()){//identificador diferente al que contiene el dato
                newlist.addDE(temp.getData());//agregamos en la nueva lista
                newlist.size++;//sumamos uno en la nueva lista
            }
            temp=temp.getNext();//temporal pasa a ser su siguiente

        }
        head=newlist.head;//head de la nueva lista pasa a ser la head de la princiapal
        return "eliminado";
    }

    //metodo que intercala dependiendo del genero
    public String mixByGender(){
        NodeDE temp = this.head;//creamos un nodo DE
        ListaDE lista=new ListaDE();//se crea una nueva lista DE

        int pocitionH=1;//posicion para hombre comienza en uno
        int pocitionM=2;//posicion para mujeres inicia en 2
        while (temp!=null){//se recorre toda la lista
            KidDTO newKidDTO=new KidDTO(pocitionH,temp.getData());//creamos un dto kis con la posicion y el dato del temporal
            //creanos un nuevo niño con los datos del dto
            Kid newkid=new Kid(newKidDTO.dataKid.getIdentification(),newKidDTO.dataKid.getName(),newKidDTO.dataKid.getAge(),newKidDTO.dataKid.getGender(),newKidDTO.dataKid.getNumBrothers(), newKidDTO.dataKid.getCity());
            if(temp.getData().getGender()=='H'){//en el caso que sea un hombre

                if (newKidDTO.getPosition()>lista.size+1){//si la posicion es mayor al tamaño de la lista lo agrega al final
                    lista.addDE(newkid);//agrega al fianl
                }else {
                    lista.addByPosition(newKidDTO);//sino lo agrega en la posicion
                }
                pocitionH=pocitionH+2;//sumamos dos a la posicion de hombre
            }

            if(temp.getData().getGender()=='M'){//en el caso que sea una mujer


                if(newKidDTO.getPosition()>lista.size+1){//si la posicion es mayor al tamaño de la lista lo agrega al final
                    lista.addDE(newkid);
                }else {
                    lista.addByPosition(newKidDTO);//sino lo agrega en la posicion
                }


                pocitionM=pocitionM+2;//sumamos dos a la posicion de hombre
            }
            size++;//aumentamos el tamaño de la lista
            temp=temp.getNext();//temporal pasa al siguiente
        }


        this.head=lista.head;//se cambia de head al de la nueva lista
        return "listo";
    }

    //primero un genero despues el otro en este caso va a ser primero los hombres
    public String firstgender(){
        ListaDE newList=new ListaDE();//creamos una lista DE
        NodeDE temp=head;//creamos un ayudante de tipo nodeDE y lo igualamos a la cabeza
        int contador=0;//el contador inicia en cero
        while (contador<=this.size){//mientras que el contador sea menor o igual al tamaño
            if (temp.getData().getGender()=='H'){//si el genero del tado es H para hombre
                newList.addToStart(temp.getData());//lo guarda de primero en la lista
            }else {
                newList.addDE(temp.getData());//en caso contrario lo agrega al final
            }
            temp=temp.getNext();//temporal pasa a ser su siguiente
            contador++;//contador aumenta en uno
        }
        head=newList.head;//la cabeza pasa a ser el de la clase
        return "listo";
    }

    //obtener los rangos de edades y las cantidades
    public int rageAge(int rangeInicial,int rangeFinal){//de entrada se manda el rango inicial y el rango final
        NodeDE temp=head;//creamos un temporal de tipo nodeDE y lo igualamos a la head
        int contador=0;//contador inicia en cero
        while (temp!=null){//temporal diferente de null para que corra toda la lista
            if(temp.getData().getAge()>=rangeInicial && temp.getData().getAge()<=rangeFinal){//se deben de cumplir las dos condiciones para contar
                contador=contador+1;//contador se le suma uno
            }
            temp=temp.getNext();//temporal pasa a ser su siguiente
        }
        return contador;//retorna el contador
    }
}

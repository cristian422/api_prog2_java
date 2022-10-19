package com.example.moto.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data

public class Node {
    private Kid data;
    private Node next;


    //se necesita un kid para crear
    public Node(Kid data){;
            this.data=data;

    }

}

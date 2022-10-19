package com.example.moto.model;


import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class NodeDE {
    private Kid data;
    private NodeDE next;
    private NodeDE previus;

    //se necesita un kid
    public NodeDE(Kid data){;
        this.data=data;

    }
}

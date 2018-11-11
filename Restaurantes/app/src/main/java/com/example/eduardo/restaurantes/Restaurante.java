package com.example.eduardo.restaurantes;

import java.io.Serializable;

public class Restaurante implements Serializable{
    String nombre, desc, dir, ciudad, tel;
    int imageRest;

    public Restaurante(String nombre, String desc, String dir, String ciudad, String tel, int imageRest){
        this.nombre = nombre;
        this.desc = desc;
        this.dir = dir;
        this.ciudad = ciudad;
        this.tel = tel;
        this.imageRest = imageRest;



    }

}

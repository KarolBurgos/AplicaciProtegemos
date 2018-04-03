package com.example.co.com.revistaprotegemos.appprotegemos.webserviceplanes.models;

import android.util.Log;

/**
 * Created by ASPIRE VX15 on 20/02/2018.
 */

public class Planes {
    private int id;
   private String titulo;
    private String descripcion;
    private String img;

    public Planes(int id, String titulo, String descripcion, String img) {
        super();
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.img=img;
        this.id=id;
    }


    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getImg() {
        return img;
    }



    public void setImg(String img) {
        this.img = img;
    }

    public int getId() {
        return id;
    }

    public  String getidString(){
        return Integer.toString(id);
    }

    public void setId(int id) {
        this.id = id;
    }
}


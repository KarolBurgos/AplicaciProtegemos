package com.example.co.com.revistaprotegemos.appprotegemos.webserviceplanes.models;

import android.util.Log;

/**
 * Created by ASPIRE VX15 on 20/02/2018.
 */

public class Planes {
    private int number;
   private String titulo;
    private String descripcion;
    private String img;

    public Planes(String titulo, String descripcion, String img) {
        super();
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.img=img;
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


}


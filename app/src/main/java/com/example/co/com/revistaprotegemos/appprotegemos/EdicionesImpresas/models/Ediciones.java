package com.example.co.com.revistaprotegemos.appprotegemos.EdicionesImpresas.models;

/**
 * Created by ASPIRE VX15 on 20/04/2018.
 */

public class Ediciones {
    private String id;
    private int img;
    private String descripcion;

    public Ediciones(String id,String descripcion) {
        this.id = id;
        this.descripcion = descripcion;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getImg() {
        return img;
    }

    public void setImg(int img) {
        this.img = img;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}

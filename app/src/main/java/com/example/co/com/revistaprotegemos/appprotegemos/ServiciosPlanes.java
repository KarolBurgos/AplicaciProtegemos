package com.example.co.com.revistaprotegemos.appprotegemos;

/**
 * Created by ASPIRE VX15 on 25/03/2018.
 */

public class ServiciosPlanes {
    private int id_servicios,id_planes;
    private String titulo,descripcion,img;

    public int getId_servicios() {
        return id_servicios;
    }

    public void setId_servicios(int id_servicios) {
        this.id_servicios = id_servicios;
    }

    public int getId_planes() {
        return id_planes;
    }

    public void setId_planes(int id_planes) {
        this.id_planes = id_planes;
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

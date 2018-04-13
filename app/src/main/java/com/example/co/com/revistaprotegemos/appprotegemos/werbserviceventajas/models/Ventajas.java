package com.example.co.com.revistaprotegemos.appprotegemos.werbserviceventajas.models;

/**
 * Created by ASPIRE VX15 on 13/04/2018.
 */

public class Ventajas {

    private int id_ventajas,id_planes;
    private String titulo,descripcion;


    public Ventajas(int id_ventajas, int id_planes, String titulo, String descripcion) {
        this.id_ventajas = id_ventajas;
        this.id_planes = id_planes;
        this.titulo = titulo;
        this.descripcion = descripcion;
    }

    public int getId_ventajas() {
        return id_ventajas;
    }

    public void setId_ventajas(int id_ventajas) {
        this.id_ventajas = id_ventajas;
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
}

package com.example.co.com.revistaprotegemos.appprotegemos.webserviceiniciojornadas.models2;

/**
 * Created by ASPIRE VX15 on 27/02/2018.
 */
public class Pautas {

    private String lugar;
    private String descripcion;

    /**
     * No args constructor for use in serialization
     *
     */
    public Pautas() {
    }

    /**
     *
     * @param lugar
     * @param descripcion
     */
    public Pautas(String lugar, String descripcion) {
        super();
        this.lugar = lugar;
        this.descripcion = descripcion;
    }

    public String getLugar() {
        return lugar;
    }

    public void setLugar(String lugar) {
        this.lugar = lugar;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }


}
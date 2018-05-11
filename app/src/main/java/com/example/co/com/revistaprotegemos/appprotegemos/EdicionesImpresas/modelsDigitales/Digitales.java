package com.example.co.com.revistaprotegemos.appprotegemos.EdicionesImpresas.modelsDigitales;

/**
 * Created by ASPIRE VX15 on 11/05/2018.
 */

public class Digitales {

    private String id;
    private String descripcion;

    public Digitales(String id, String descripcion) {
        this.id = id;
        this.descripcion = descripcion;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}

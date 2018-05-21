package com.example.co.com.revistaprotegemos.appprotegemos.AdaptadorRevistaPrueba.modelsDigitales;

/**
 * Created by ASPIRE VX15 on 20/05/2018.
 */

public class ImpresasPrueba {

    private int id;
    private String img;
    private String descripcion;

    public ImpresasPrueba(int id, String img, String descripcion) {
        this.id = id;
        this.img = img;
        this.descripcion = descripcion;
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

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}

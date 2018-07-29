package com.anevents.listapaises;

public class Paises {

    private String Nombre;
    private String Descripcion;

    private String capital;
    private String poblacion;
    private String imagen;

    public Paises(){

    }

    public Paises(String nombre, String descripcion,  String capital, String poblacion, String imagen) {
        Nombre = nombre;
        Descripcion = descripcion;
        this.capital = capital;
        this.poblacion = poblacion;
        this.imagen = imagen;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String nombre) {
        Nombre = nombre;
    }

    public String getDescripcion() {
        return Descripcion;
    }

    public void setDescripcion(String descripcion) {
        Descripcion = descripcion;
    }


    public String getCapital() {
        return capital;
    }

    public void setCapital(String capital) {
        this.capital = capital;
    }

    public String getPoblacion() {
        return poblacion;
    }

    public void setPoblacion(String poblacion) {
        this.poblacion = poblacion;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }



}

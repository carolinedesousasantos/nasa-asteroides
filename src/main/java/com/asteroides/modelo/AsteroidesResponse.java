package com.asteroides.modelo;

public class AsteroidesResponse {

    private String nombre;
    private String diametro;
    private String velocidad;
    private String fecha;
    private String planeta;

    public AsteroidesResponse(String nombre, String diametro, String velocidad, String fecha, String planeta) {
        this.nombre = nombre;
        this.diametro = diametro;
        this.velocidad = velocidad;
        this.fecha = fecha;
        this.planeta = planeta;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDiametro() {
        return diametro;
    }

    public void setDiametro(String diametro) {
        this.diametro = diametro;
    }

    public String getVelocidad() {
        return velocidad;
    }

    public void setVelocidad(String velocidad) {
        this.velocidad = velocidad;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getPlaneta() {
        return planeta;
    }

    public void setPlaneta(String planeta) {
        this.planeta = planeta;
    }
}

package org.elias.transferible;


import org.elias.modelo.Pilotos;

import java.util.List;

public class TransferibleEquipos {


    private  Integer id;

    private String nombre;

    private  String pais;

    private String jefeEquipo;


    private String motor;


    // @Column(name = "imagen_url")
    // private Text imagenUrl;

    private String descripcion;

    /*
    private List<Pilotos> pilotos;

    // Getters y setters
    public List<Pilotos> getPilotos() {
        return pilotos;
    }

    public void setPilotos(List<Pilotos> pilotos) {
        this.pilotos = pilotos;
    }
*/

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public String getMotor() {
        return motor;
    }

    public void setMotor(String motor) {
        this.motor = motor;
    }

    public String getJefeEquipo() {
        return jefeEquipo;
    }

    public void setJefeEquipo(String jefeEquipo) {
        this.jefeEquipo = jefeEquipo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}

package com.example.laboratorio03;

import java.io.Serializable;

public class Postulante implements Serializable{
    String dni;
    String nombres;
    String apellidos;
    String fecha;
    String colegio;
    String carrera;


    public Postulante(String _dni, String _nombres, String _apellidos, String _fecha, String _colegio, String _carrera  ){
        dni = _dni;
        nombres = _nombres;
        apellidos = _apellidos;
        fecha = _fecha;
        colegio = _colegio;
        carrera = _carrera;
    }

    public String getDni() {
        return dni;
    }

    public String getNombres() {
        return nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public String getFecha() {
        return fecha;
    }

    public String getColegio() {
        return colegio;
    }

    public String getCarrera() {
        return carrera;
    }

}

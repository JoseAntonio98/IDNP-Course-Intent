package com.example.laboratorio03;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;


public class PostulantRegisterActivity extends AppCompatActivity {

    EditText dni, nombres, apellidos , fecha, colegio , carrera;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_postulant_register);
    }

    public void crearPostulante(){
        dni = findViewById(R.id.dniRegistro);
        nombres = findViewById(R.id.nombresRegistro);
        apellidos = findViewById(R.id.apellidosRegistro);
        fecha = findViewById(R.id.dateRegistro);
        colegio = findViewById(R.id.colegioRegistro);
        carrera = findViewById(R.id.carreraRegistro);

        System.out.println("DNI");


    }

}
package com.example.laboratorio03;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class PostulantRegisterActivity extends AppCompatActivity {

    EditText dni, nombres, apellidos , fecha, colegio , carrera;
    Button btnRegister;
    Postulante p1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_postulant_register);

        btnRegister = findViewById(R.id.botonRegistrar);
        dni = findViewById(R.id.dniRegistro);
        nombres = findViewById(R.id.nombresRegistro);
        apellidos = findViewById(R.id.apellidosRegistro);
        fecha = findViewById(R.id.TextViewFechaNac);
        colegio = findViewById(R.id.colegioRegistro);
        carrera = findViewById(R.id.carreraRegistro);

        btnRegister.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick (View view) {

                String dniT = dni.getText().toString();
                String apeM = apellidos.getText().toString();
                String nomb = nombres.getText().toString();
                String fchN = fecha.getText().toString();
                String colg = colegio.getText().toString();
                String carr = carrera.getText().toString();

                if (!dniT.isEmpty() && !apeM.isEmpty() && !nomb.isEmpty() && !fchN.isEmpty() && !colg.isEmpty() && !carr.isEmpty())
                {
                    p1 = new Postulante( dniT, apeM, nomb, fchN, colg, carr);
                    Toast.makeText(PostulantRegisterActivity.this, "Registro Exitoso", Toast.LENGTH_SHORT).show();
                    Intent data = new Intent(PostulantRegisterActivity.this, MenuActivity.class);
                    data.putExtra("pNew", p1);
                    setResult(RESULT_OK, data);
                    finish();
                }
                else {
                    Toast.makeText(PostulantRegisterActivity.this, "Verifique los datos puestos", Toast.LENGTH_SHORT).show();
                }

            }
        });


    }

}
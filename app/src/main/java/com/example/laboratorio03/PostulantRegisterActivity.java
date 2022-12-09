package com.example.laboratorio03;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectOutputStream;
import java.nio.charset.StandardCharsets;


public class PostulantRegisterActivity extends AppCompatActivity {

    EditText dni, nombres, apellidos , fecha, colegio , carrera;
    Button btnRegister;
    Postulante p1;
    Context context;
    private static final String FILE_NAME = "postulante_file";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_postulant_register);
        context= getApplicationContext();
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

                    WritePostulante(dniT,apeM,nomb,fchN,colg,carr);
                    setResult(RESULT_OK, data);
                    finish();
                }
                else {
                    Toast.makeText(PostulantRegisterActivity.this, "Verifique los datos puestos", Toast.LENGTH_SHORT).show();

                }
            }
        });
    }

    public void WritePostulante(String dni,String nombres, String apellidos, String fecha, String colegio , String carrera ){
        try(FileOutputStream fos = context.openFileOutput(FILE_NAME, MODE_APPEND)){
            fos.write((dni+"\n").getBytes());
            fos.write((nombres+"\n").getBytes());
            fos.write((apellidos+"\n").getBytes());
            fos.write((fecha+"\n").getBytes());
            fos.write((colegio+"\n").getBytes());
            fos.write((carrera+"\n").getBytes());
        }catch (FileNotFoundException e){
            e.printStackTrace();
        }
        catch (IOException e ){
            e.printStackTrace();
        }
    }
    public String ReadPostulante(){
        StringBuilder sb = new StringBuilder();
        String userName = "";
        try {
            FileInputStream fis = context.openFileInput(FILE_NAME);
            InputStreamReader inputStreamReader = new InputStreamReader(fis, StandardCharsets.UTF_8);
            BufferedReader br = new BufferedReader(inputStreamReader);
            String line = br.readLine();
            while(line != null){
                sb.append(line);
            }
        } catch (FileNotFoundException e){
            e.printStackTrace();
        } catch ( IOException e){
            e.printStackTrace();
        } finally {
            userName = sb.toString();
        }
        return userName.replace("\n","").replace("\r","");
    }

}
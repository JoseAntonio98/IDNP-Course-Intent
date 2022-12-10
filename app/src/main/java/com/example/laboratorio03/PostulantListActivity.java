package com.example.laboratorio03;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

import java.util.ArrayList;

public class PostulantListActivity extends AppCompatActivity {

    Bundle bundle;
    ArrayList<Postulante> listaP;
    ArrayList<String> strings;
    RecyclerView recycler;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_postulant_list);

        bundle = getIntent().getBundleExtra("listaB");
        listaP = (ArrayList<Postulante>) bundle.getSerializable("listaP");
        recycler = (RecyclerView) findViewById(R.id.recyclerId);
        recycler.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));

        strings = new ArrayList<String>();
        for (Postulante pCurrent : listaP) {
            strings.add("\nPOSTULANTE: \n\t\tDNI : " + pCurrent.getDni()
                    + " \n\t\tNombre y Apellido: " + pCurrent.getNombres() + " "
                    + pCurrent.getApellidos() + " \n\t\tFecha: " + pCurrent.getFecha()
                    + " \n\t\tColegio: " + pCurrent.getColegio()
                    + " \n\t\tCarrera: " + pCurrent.getCarrera());
        }

        AdapterDatos adapter = new AdapterDatos(strings); //mandando lista postulantes a adapter
        recycler.setAdapter(adapter);
    }
}
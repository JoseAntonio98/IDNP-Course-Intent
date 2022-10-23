package com.example.laboratorio03;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class PostulantInfoActivity extends AppCompatActivity {

    Bundle bundle;
    ArrayList<Postulante> listaP;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_postulant_info);

        bundle = getIntent().getBundleExtra("listaB");
        listaP = (ArrayList<Postulante>) bundle.getSerializable("listaP");

        Button btnSearch = findViewById(R.id.buttonSearchDNI);
        EditText searchTerm = findViewById(R.id.editTextTextSearchDNI);

        TextView dniT = findViewById(R.id.textViewDNI);
        TextView nomT = findViewById(R.id.textViewNom);
        TextView apeT = findViewById(R.id.textViewApe);
        TextView fechT = findViewById(R.id.textViewFecha);
        TextView colT = findViewById(R.id.textViewColg);
        TextView carrT = findViewById(R.id.textViewCarr);

        btnSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!listaP.isEmpty()){
                    if (!searchTerm.getText().toString().isEmpty()) {
                        for (Postulante pCurrent : listaP) {
                            if (pCurrent.getDni().equals(searchTerm.getText().toString())) {
                                Toast.makeText(PostulantInfoActivity.this, "Se encontro el postulante", Toast.LENGTH_SHORT).show();
                                dniT.setText(pCurrent.getDni());
                                nomT.setText(pCurrent.getNombres());
                                apeT.setText(pCurrent.getApellidos());
                                fechT.setText(pCurrent.getFecha());
                                colT.setText(pCurrent.getColegio());
                                carrT.setText(pCurrent.getCarrera());
                                break;
                            } else {
                                Toast.makeText(PostulantInfoActivity.this, "No se encuentra al postulante", Toast.LENGTH_SHORT).show();
                            }
                        }
                    }
                    else {
                        Toast.makeText(PostulantInfoActivity.this, "Ingrese un DNI", Toast.LENGTH_SHORT).show();
                    }
                }
                else {
                    Toast.makeText(PostulantInfoActivity.this, "La lista de postulantes esta vacía", Toast.LENGTH_SHORT).show();
                }
            }
        });



    }
}
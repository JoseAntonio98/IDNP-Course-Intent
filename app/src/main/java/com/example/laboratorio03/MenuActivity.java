package com.example.laboratorio03;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContract;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MenuActivity extends AppCompatActivity {

    ArrayList<Postulante> listaPostulante;
    ActivityResultLauncher<Intent> actResLauncher;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        listaPostulante = new ArrayList<Postulante>();

        actResLauncher = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new ActivityResultCallback<ActivityResult>() {
            @Override
            public void onActivityResult(ActivityResult result) {
                if (result.getResultCode() == RESULT_OK && result.getData() != null){
                    Bundle bundle = result.getData().getExtras();
                    Postulante pNew = (Postulante) bundle.getSerializable("pNew");
                    listaPostulante.add(pNew);
                }
            }
        });

    }

    public void goToPostulanteInfoActivity(View view) {
        Bundle bundle = new Bundle();
        bundle.putSerializable("listaP", listaPostulante);
        Intent InfoIntent = new Intent(this, PostulantInfoActivity.class);
        InfoIntent.putExtra("listaB", bundle);
        startActivity(InfoIntent);
    }

    public void goToPostulanteRegistroActivity(View view) {
        Intent RegistroIntent = new Intent(this, PostulantRegisterActivity.class);
        actResLauncher.launch(RegistroIntent);
    }

    public void goToListaPostulantesActivity(View view) {
        Bundle bundle = new Bundle();
        bundle.putSerializable("listaP", listaPostulante);
        Intent ListaIntent = new Intent(this, PostulantListActivity.class);
        ListaIntent.putExtra("listaB", bundle);
        startActivity(ListaIntent);
    }
}

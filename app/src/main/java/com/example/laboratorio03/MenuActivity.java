package com.example.laboratorio03;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MenuActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
    }

    public void goToPostulanteInfoActivity(View view) {
        Intent InfoIntent = new Intent(this, PostulantInfoActivity.class);
        startActivity(InfoIntent);
    }

    public void goToPostulanteRegistroActivity(View view) {
        Intent RegistroIntent = new Intent(this, PostulantRegisterActivity.class);
        startActivity(RegistroIntent);
    }
}

package com.jhoerperez.workouttracker;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class ConfiguraDias extends AppCompatActivity {

    Button lunes;
    Button martes;
    Button miercoles;
    Button jueves;
    Button viernes;
    Button sabado;
    Button domingo;

    public static final String KEY_DIA = "dia";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_configura_dias);
        Log.d(String.valueOf(R.string.workout), "Activity dias iniciando");
        lunes = findViewById(R.id.btnlunes);
        martes = findViewById(R.id.btnmartes);
        miercoles = findViewById(R.id.btnmiercoles);
        jueves = findViewById(R.id.btnjueves);
        viernes = findViewById(R.id.btnviernes);
        sabado = findViewById(R.id.btnsabado);
        domingo = findViewById(R.id.btndomingo);
        Intent intent = new Intent(ConfiguraDias.this, EjerciciosMaster.class);

        lunes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent.putExtra(KEY_DIA,"lunes");
                startActivity(intent);
            }
        });

        martes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent.putExtra(KEY_DIA,"martes");
                startActivity(intent);
            }
        });

        miercoles.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent.putExtra(KEY_DIA,"miercoles");
                startActivity(intent);
            }
        });

        jueves.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent.putExtra(KEY_DIA,"jueves");
                startActivity(intent);
            }
        });

        viernes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent.putExtra(KEY_DIA,"viernes");
                startActivity(intent);
            }
        });

        sabado.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent.putExtra(KEY_DIA,"sabado");
                startActivity(intent);
            }
        });

        domingo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent.putExtra(KEY_DIA,"domingo");
                startActivity(intent);
            }
        });
    }

}
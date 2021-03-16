package com.jhoerperez.workouttracker;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class EjerciciosMaster extends AppCompatActivity {

    ImageButton brazo;
    ImageButton abs;
    ImageButton pecho;
    ImageButton espalda;
    ImageButton pierna;
    ImageButton cardio;

    public static final String KEY_EJERCICIO = "Ejercicio";  //Clave para el intent para la siguiente activity
    public static final String KEY_DIA = "dia";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ejercicios_master);

        brazo = findViewById(R.id.btnBrazo);
        abs = findViewById(R.id.btnTorso);
        pecho = findViewById(R.id.btnPecho);
        espalda = findViewById(R.id.btnEspalda);
        pierna = findViewById(R.id.btnPierna);
        cardio = findViewById(R.id.btnCardio);

        Bundle extras = getIntent().getExtras();
        String dia = extras.getString(ConfiguraDias.KEY_DIA);

        Intent elegirEjercicio = new Intent(EjerciciosMaster.this, ElegirEjercicio.class);
        elegirEjercicio.putExtra(KEY_DIA,dia);
        //Se crean los click listeners para todos los botones y se le pone un extra dependiendo del boton
        brazo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                elegirEjercicio.putExtra(KEY_EJERCICIO,"brazo");
                startActivity(elegirEjercicio);
            }
        });

        abs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                elegirEjercicio.putExtra(KEY_EJERCICIO,"abs");
                startActivity(elegirEjercicio);
            }
        });

        pecho.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                elegirEjercicio.putExtra(KEY_EJERCICIO,"pecho");
                startActivity(elegirEjercicio);
            }
        });

        espalda.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                elegirEjercicio.putExtra(KEY_EJERCICIO,"espalda");
                startActivity(elegirEjercicio);
            }
        });

        pierna.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                elegirEjercicio.putExtra(KEY_EJERCICIO,"pierna");
                startActivity(elegirEjercicio);
            }
        });

        cardio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                elegirEjercicio.putExtra(KEY_EJERCICIO,"cardio");
                startActivity(elegirEjercicio);
            }
        });
    }
}
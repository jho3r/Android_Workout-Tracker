package com.jhoerperez.workouttracker;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

public class InicioEntreno extends AppCompatActivity {

    ImageButton btnPausa;
    TextView tvTitulo;
    TextView tvEjercicio;
    TextView tvReps;
    boolean play;
    int dia;
    int series;
    int reps;
    String[] listDia;
    String[] listReps;
    int i;
    int s;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inicio_entreno);

        Bundle extras = getIntent().getExtras();
        dia = extras.getInt(MainActivity.KEY_DIA);
        series = extras.getInt(MainActivity.KEY_SERIES);
        reps = extras.getInt(MainActivity.KEY_REPS);

        listDia = getResources().getStringArray(dia);
        listReps = getResources().getStringArray(reps);

        play = true;
        tvTitulo = findViewById(R.id.tvTitulo);
        btnPausa = findViewById(R.id.btnPause);
        tvEjercicio = findViewById(R.id.tvEjercicio);
        tvReps = findViewById(R.id.tvConteo);

        i=0;
        s=1;
        tvTitulo.setText("Serie " + s);
        tvEjercicio.setText(listDia[i]);
        tvReps.setText(listReps[i]);
        i++;

        btnPausa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                if (play==true){
//                    Log.d("Workout","Cambiando resource a play");
//                    play=false;
//                    btnPausa.setImageResource(R.drawable.play);
//                }else{
//                    Log.d("Workout","Cambiando resource a pause");
//                    play=true;
//                    btnPausa.setImageResource(R.drawable.pause);
//                }
                avanza();
            }
        });


    }

    private void avanza(){
        i++;
        if(s<=series){
            if(i<listDia.length){
                tvEjercicio.setText(listDia[i]);
                tvReps.setText(listReps[i]);
            }else{
                i=0;
                s++;
                tvTitulo.setText("Serie " + s);
                tvEjercicio.setText(listDia[i]);
                tvReps.setText(listReps[i]);
            }
        }
        if(s>series){
            tvTitulo.setText("Done");
            btnPausa.setVisibility(View.INVISIBLE);
            tvEjercicio.setVisibility(View.INVISIBLE);
            tvReps.setVisibility(View.INVISIBLE);
        }
    }
}
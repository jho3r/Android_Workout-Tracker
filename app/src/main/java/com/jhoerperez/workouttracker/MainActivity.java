package com.jhoerperez.workouttracker;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    public static final String KEY_PREFERENCES = "Iniciado";
    public static final String PREFS = "prefs";
    public static final String KEY_DIA = "dia";
    public static final String KEY_REPS = "reps";
    public static final String KEY_SERIES = "series";
    private int dia;
    private int repeticiones;
    private int series;
    private int[] listSeries;

    Button comenzar;
    Button btnConfigurar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnConfigurar = findViewById(R.id.btnConfigurar);
        comenzar = findViewById(R.id.btnGo);
        listSeries = getResources().getIntArray(R.array.Series);

        SharedPreferences prefs = getSharedPreferences(PREFS, MODE_PRIVATE);
        int iniciado = prefs.getInt(KEY_PREFERENCES, 0);
        Log.d("Workout", "iniciado es igual a:" + iniciado);
        if (iniciado == 0){
            confDias();
        }

        comenzar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Calendar calendar = Calendar.getInstance();
                int day = calendar.get(Calendar.DAY_OF_WEEK);
                series = listSeries[day];
                switch (day){
                    case(1):
                        dia = R.array.domingo;
                        repeticiones = R.array.domingorep;
                        break;
                    case(2):
                        dia = R.array.lunes;
                        repeticiones = R.array.lunesrep;
                        break;
                    case(3):
                        dia = R.array.martes;
                        repeticiones = R.array.martesrep;
                        break;
                    case(4):
                        dia = R.array.miercoles;
                        repeticiones = R.array.miercolesrep;
                        break;
                    case(5):
                        dia = R.array.jueves;
                        repeticiones = R.array.juevesrep;
                        break;
                    case(6):
                        dia = R.array.viernes;
                        repeticiones = R.array.viernesrep;
                        break;
                    case(7):
                        dia = R.array.sabado;
                        repeticiones = R.array.sabadorep;
                        break;
                }
                Log.d("Workout","tenemos el dia y las reps");
                Intent intent = new Intent(MainActivity.this,InicioEntreno.class);
                intent.putExtra(KEY_DIA,dia);
                intent.putExtra(KEY_SERIES,series);
                intent.putExtra(KEY_REPS,repeticiones);
                startActivity(intent);
            }
        });

        btnConfigurar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this,ConfiguraDias.class));
            }
        });
    }

    private void confDias(){
        Log.d("Workout", "Mostrando alerta");
        new AlertDialog.Builder(this)
                .setTitle(R.string.tituloAlert)
                .setMessage(R.string.mensageAlert)
                .setPositiveButton(R.string.btnPositivo, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        SharedPreferences prefs = getSharedPreferences(PREFS, MODE_PRIVATE);
                        prefs.edit().putInt(KEY_PREFERENCES,1).apply();
                        Intent dias = new Intent(MainActivity.this, ConfiguraDias.class);
                        startActivity(dias);
                    }
                })
                .setIcon(R.drawable.trainer)
                .setCancelable(false)
                .show();

    }
}


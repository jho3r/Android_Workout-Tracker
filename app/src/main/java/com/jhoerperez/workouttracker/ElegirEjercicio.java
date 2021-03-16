package com.jhoerperez.workouttracker;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.icu.text.CaseMap;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Switch;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.JsonHttpResponseHandler;
import com.loopj.android.http.RequestParams;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import cz.msebera.android.httpclient.Header;

public class ElegirEjercicio extends AppCompatActivity {

    String dia;
    String cuerpo;
    RecyclerView rvEjercicios; //añadimos el recicler view
    int a;
    public static final String URLGET = "https://api.backendless.com/5CC61233-2256-0118-FF68-5B3569B7D200/36AD23EC-2D32-4F7E-8EA8-6BC4CE91C638/data/Ejercicios";
    String[] ejercicios;

    //https://www.musculacion.net/
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_elegir_ejercicio);
        //Recupero los datos put extra del anterior intent
        Bundle extras = getIntent().getExtras();
        dia = extras.getString(EjerciciosMaster.KEY_DIA);
        cuerpo = extras.getString(EjerciciosMaster.KEY_EJERCICIO);

        switch (cuerpo){
            case "brazo":
                ejercicios = getResources().getStringArray(R.array.brazo);
                break;
            case "abs":
                ejercicios = getResources().getStringArray(R.array.abs);
                break;
            case "espalda":
                ejercicios = getResources().getStringArray(R.array.espalda);
                break;
            case "pecho":
                ejercicios = getResources().getStringArray(R.array.pecho);
                break;
            case "pierna":
                ejercicios = getResources().getStringArray(R.array.pierna);
                break;
            case "cardio":
                ejercicios = getResources().getStringArray(R.array.cardio);
                break;
        }

        Log.d("Workout", "Dia " + dia + " parte " + cuerpo);
        rvEjercicios = findViewById(R.id.rvEjercicio);
        //En este punto llamo a mi clase adaptador anteriormente creada
        EjercicioAdapter myAdapter = new EjercicioAdapter(this, ejercicios);
        //Le asignamos el adaptador
        rvEjercicios.setAdapter(myAdapter);
        rvEjercicios.setLayoutManager(new GridLayoutManager(this,2));

    }
}
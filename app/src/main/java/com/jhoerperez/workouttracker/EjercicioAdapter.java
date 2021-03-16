package com.jhoerperez.workouttracker;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class EjercicioAdapter extends RecyclerView.Adapter<EjercicioAdapter.MyViewHolder> {

    String[] data1;
    Context context;

    //Constructor para la clase adaptador
    public  EjercicioAdapter(Context ct, String[] s1){
        context = ct;
        data1 = s1;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.row,parent,false);
        return new MyViewHolder(view);
    }

    //myviewholder se esta comunicando con bind entonces ponemos los textos aqui
    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.tv1.setText(data1[position]);
    }

    //Este metodo debe devolver el tamaño del list
    @Override
    public int getItemCount() {
        return data1.length;
    }

    //inner class para el holder con su respectivo constructor
    public class MyViewHolder extends RecyclerView.ViewHolder{

        TextView tv1;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            tv1 = itemView.findViewById(R.id.tv1);
        }
    }
}

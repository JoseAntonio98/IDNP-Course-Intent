package com.example.laboratorio03;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class AdapterDatos extends RecyclerView.Adapter<AdapterDatos.ViewHolderDatos> {

    ArrayList<String> listPostulant;

    public AdapterDatos(ArrayList<String> listPostulant) {
        this.listPostulant = listPostulant;
    }

    @Override
    public ViewHolderDatos onCreateViewHolder(ViewGroup parent, int viewType) { //enlazar adapter con itemlist
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_list, null, false);
        return new ViewHolderDatos(view);
    }

    @Override
    public void onBindViewHolder(AdapterDatos.ViewHolderDatos holder, int position) { //establecer comunicacion entre adapter y viewholderdatos
        holder.dato.setText((CharSequence) listPostulant.get(position));
    }

    @Override
    public int getItemCount() { //retorna tamaño lista postulantes
        return listPostulant.size();
    }

    public class ViewHolderDatos extends RecyclerView.ViewHolder {
        TextView dato;

        public ViewHolderDatos(View itemView) {
            super(itemView);
            dato = (TextView) itemView.findViewById(R.id.idDato);
        }

        public void asignarDatos(String postulante) {
            dato.setText((CharSequence) postulante);
        }
    }
}


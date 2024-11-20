package com.example.proyectojava_ud2.Adaptadores;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.proyectojava_ud2.Modelos.Cancion;
import com.example.proyectojava_ud2.R;

import java.util.List;

public class RecyclerAdapterCancion extends RecyclerView.Adapter<RecyclerAdapterCancion.RecyclerHolderCancion> {

    private List<Cancion> listaCanciones;
    private Context contexto;

    public RecyclerAdapterCancion(List<Cancion> listaCanciones, Context contexto) {
        this.listaCanciones = listaCanciones;
        this.contexto = contexto;
    }

    @NonNull
    @Override
    public RecyclerHolderCancion onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.plantilla_cancion, parent, false);
        RecyclerHolderCancion recyclerHolder = new RecyclerHolderCancion(view);
        return recyclerHolder;
    }


    @Override
    public void onBindViewHolder(@NonNull RecyclerHolderCancion holder, int position) {
        Cancion c = listaCanciones.get(position);
        holder.txt_titulo_cancion.setText(c.getTitulo_cancion());
        holder.txt_integrantes_cancion.setText(c.getIntegrantes());
        holder.txt_duracion_cancion.setText(c.getMinutos() + ":" + c.getSegundos());
        holder.img_cancion.setImageResource(c.getImagenID_cancion());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Intent.ACTION_VIEW, Uri.parse(c.getAlbum().getLink()));
                contexto.startActivity(i);
            }
        });
    }


    @Override
    public int getItemCount() {
        return listaCanciones != null ? listaCanciones.size() : 0;
    }

    public static class RecyclerHolderCancion extends RecyclerView.ViewHolder {

        ImageView img_cancion;
        TextView txt_titulo_cancion;
        TextView txt_integrantes_cancion;
        TextView txt_duracion_cancion;

        public RecyclerHolderCancion(@NonNull View itemView) {
            super(itemView);
            img_cancion = itemView.findViewById(R.id.img_cancion);
            txt_titulo_cancion = itemView.findViewById(R.id.txt_titulo_cancion);
            txt_integrantes_cancion = itemView.findViewById(R.id.txt_integrantes_cancion);
            txt_duracion_cancion = itemView.findViewById(R.id.txt_duracion_cancion);
        }
    }
}

package com.example.proyectojava_ud2.Adaptadores;

import static com.example.proyectojava_ud2.Vistas.Detalle.DESCRIPCION_ID;
import static com.example.proyectojava_ud2.Vistas.Detalle.IMG_ID;
import static com.example.proyectojava_ud2.Vistas.Detalle.TITULO_ID;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.view.ActionMode;
import androidx.recyclerview.widget.RecyclerView;

import com.example.proyectojava_ud2.Vistas.Detalle;
import com.example.proyectojava_ud2.Modelos.Album;
import com.example.proyectojava_ud2.R;

import java.util.List;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.RecyclerHolder> {

    private List<Album> listaAlbum;
    private ActionMode menuActionMode;
    private int posicion = -1;
    private Context contexto;

    public RecyclerAdapter(List<Album> listaAlbum) {
        this.listaAlbum = listaAlbum;
    }

    @NonNull
    @Override
    public RecyclerHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.plantilla_lista, parent, false);
        RecyclerHolder recyclerHolder = new RecyclerHolder(view);
        contexto = parent.getContext();
        return recyclerHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerAdapter.RecyclerHolder holder, int position) {
        Album a = listaAlbum.get(position);
        holder.txt_titulo.setText(a.getTitulo());
        holder.txt_descripcion.setText(a.getDescripcion());
        holder.img_album.setImageResource(a.getImagenID());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i;
                i = new Intent(contexto, Detalle.class);
                i.putExtra(TITULO_ID, holder.txt_titulo.getText());
                i.putExtra(DESCRIPCION_ID, a.getDescripcion_extra());
                i.putExtra(IMG_ID, a.getImagenID());
                contexto.startActivity(i);
            }
        });

        holder.itemView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                if (menuActionMode == null) {
                    posicion = holder.getAdapterPosition();
                    menuActionMode = ((AppCompatActivity) contexto).startSupportActionMode(menuActionCallBack);
                }
                return true;
            }
        });
    }

    @Override
    public int getItemCount() {
        return listaAlbum.size();
    }

    private ActionMode.Callback menuActionCallBack = new ActionMode.Callback() {
        @Override
        public boolean onCreateActionMode(ActionMode mode, Menu menu) {
            mode.getMenuInflater().inflate(R.menu.menu_action, menu);
            mode.setTitle("Opciones ---> ");
            return true;
        }

        @Override
        public boolean onPrepareActionMode(ActionMode mode, Menu menu) {
            return false;
        }

        @Override
        public boolean onActionItemClicked(ActionMode mode, MenuItem item) {
            if (item.getItemId() == R.id.item_eliminar) {
                AlertDialog alertDialog = createAlertDialog(mode);
                alertDialog.show();
            }
            return true;
        }

        @Override
        public void onDestroyActionMode(ActionMode mode) {
            menuActionMode = null;
        }
    };

    public AlertDialog createAlertDialog(ActionMode mode){
        AlertDialog.Builder builder = new AlertDialog.Builder(contexto);
        builder.setMessage("¿Estás seguro de eliminar el Álbum?")
                .setTitle("Confirmación");
        builder.setPositiveButton("BORRAR", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                listaAlbum.remove(posicion);
                notifyItemRemoved(posicion);
                notifyItemRangeChanged(posicion, listaAlbum.size());
                mode.finish();
                Toast.makeText(contexto, "Álbum eliminado correctamente.", Toast.LENGTH_SHORT).show();
            }
        });

       builder.setNegativeButton("CANCELAR", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Toast.makeText(contexto, "Has cancelado, tus Álbumes están a salvo (de momento)", Toast.LENGTH_SHORT).show();
                mode.finish();
            }
        });
        return builder.create();
    }

    public class RecyclerHolder extends RecyclerView.ViewHolder {
        ImageView img_album;
        TextView txt_titulo;
        TextView txt_descripcion;

        public RecyclerHolder(@NonNull View itemView) {
            super(itemView);
            img_album = itemView.findViewById(R.id.img_album);
            txt_titulo = itemView.findViewById(R.id.txt_titulo);
            txt_descripcion = itemView.findViewById(R.id.txt_descripcion);
        }
    }
}

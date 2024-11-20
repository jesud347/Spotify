package com.example.proyectojava_ud2.Vistas;

import android.content.Intent;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.proyectojava_ud2.Adaptadores.RecyclerAdapterCancion;
import com.example.proyectojava_ud2.Utilidades.Datos;
import com.example.proyectojava_ud2.R;

public class Detalle extends AppCompatActivity {

    RecyclerView recyclerView;
    RecyclerAdapterCancion recyclerAdapter;

    private ImageView img_detalle;
    private TextView txt_titulo_detalle;
    private TextView txt_descripcion_detalle;

    public static final String TITULO_ID = "Titulo";
    public static final String DESCRIPCION_ID = "Descripcion";
    public static final String IMG_ID = "Imagen";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_detalle);

        this.img_detalle = (ImageView) findViewById(R.id.img_detalle);
        this.txt_titulo_detalle = (TextView) findViewById(R.id.txt_titulo_detalle);
        this.txt_descripcion_detalle = (TextView) findViewById(R.id.txt_descripcion_detalle);

        Intent i = getIntent();
        txt_titulo_detalle.setText(i.getStringExtra(TITULO_ID));
        txt_descripcion_detalle.setText(i.getStringExtra(DESCRIPCION_ID));
        img_detalle.setImageResource(i.getIntExtra(IMG_ID, 0));

        txt_descripcion_detalle.setMovementMethod(new ScrollingMovementMethod());

        recyclerView = (RecyclerView) findViewById(R.id.recyclerViewCancion);
        recyclerAdapter = new RecyclerAdapterCancion(Datos.getListaCanciones((String) txt_titulo_detalle.getText()), this);

        LinearLayoutManager layoutManager = new LinearLayoutManager(this);

        recyclerView.setAdapter(recyclerAdapter);
        recyclerView.setLayoutManager(layoutManager);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}
package com.example.proyectojava_ud2.Controladores;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.proyectojava_ud2.R;
import com.example.proyectojava_ud2.Vistas.Lista;
import com.example.proyectojava_ud2.Vistas.Registro;

public class MainActivity extends AppCompatActivity {

    private Button bt_registro;
    private Button bt_lista;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        this.bt_registro = (Button) findViewById(R.id.bt_registro);
        this.bt_lista = (Button) findViewById(R.id.bt_lista);

        this.bt_registro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, "Has Seleccionado Registro", Toast.LENGTH_SHORT).show();
                Intent i;
                i = new Intent(MainActivity.this, Registro.class);
                startActivity(i);
            }
        });

        this.bt_lista.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, "Has Seleccionado Lista", Toast.LENGTH_SHORT).show();
                Intent i;
                i = new Intent(MainActivity.this, Lista.class);
                startActivity(i);
            }
        });

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}
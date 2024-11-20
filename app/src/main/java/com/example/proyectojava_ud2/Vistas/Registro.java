package com.example.proyectojava_ud2.Vistas;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.proyectojava_ud2.R;

public class Registro extends AppCompatActivity {

    private EditText editText_nombre;
    private EditText editText_email;
    private EditText editText_edad;
    private Button bt_registro;

    private String nombre;
    private String email;
    private String edadString;
    private int edad;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.registro);

        this.editText_nombre = (EditText) findViewById(R.id.editText_nombre);
        this.editText_email = (EditText) findViewById(R.id.editText_email);
        this.editText_edad = (EditText) findViewById(R.id.editText_edad);
        this.bt_registro = (Button) findViewById(R.id.bt_registro);

        this.bt_registro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                nombre = editText_nombre.getText().toString();
                email = editText_email.getText().toString();
                edadString = editText_edad.getText().toString();

                try{
                    edad = Integer.parseInt(edadString);
                }catch (NumberFormatException e){
                    Toast.makeText(Registro.this, "Porfavor rellena todos los campos", Toast.LENGTH_SHORT).show();
                    return;
                }
                if(nombre.isEmpty() || email.isEmpty()){
                    Toast.makeText(Registro.this, "Porfavor rellena todos los campos", Toast.LENGTH_SHORT).show();
                }else if (edad <  18){
                    Toast.makeText(Registro.this, "La edad debe ser +18", Toast.LENGTH_LONG).show();
                }else{
                    Toast.makeText(Registro.this, "Registrado con exito", Toast.LENGTH_LONG).show();
                    finish();
                }
            }
        });

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}
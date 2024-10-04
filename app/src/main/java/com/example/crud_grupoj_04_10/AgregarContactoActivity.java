package com.example.crud_grupoj_04_10;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class AgregarContactoActivity extends AppCompatActivity {

    private EditText editTextNombre, editTextTelefono;
    private Button buttonAgregar;
    private ContactosCrud contactosCrud;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_agregar_contactos);

        editTextNombre = findViewById(R.id.editTextNombre);
        editTextTelefono = findViewById(R.id.editTextTelefono);
        buttonAgregar = findViewById(R.id.buttonAgregar);
        contactosCrud = new ContactosCrud();

        buttonAgregar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                agregarContacto();
            }
        });
    }

    private void agregarContacto() {
        String nombre = editTextNombre.getText().toString();
        String telefono = editTextTelefono.getText().toString();

        if (!nombre.isEmpty() && !telefono.isEmpty()) {
            if (contactosCrud.agregarContacto(nombre, telefono)) {
                Toast.makeText(this, "Contacto agregado", Toast.LENGTH_SHORT).show();
                finish();
            } else {
                Toast.makeText(this, "Error al agregar contacto", Toast.LENGTH_SHORT).show();
            }
        } else {
            Toast.makeText(this, "Por favor, completa todos los campos", Toast.LENGTH_SHORT).show();
        }
    }
}

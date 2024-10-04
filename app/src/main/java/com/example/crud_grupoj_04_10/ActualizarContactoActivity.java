package com.example.crud_grupoj_04_10;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class ActualizarContactoActivity extends AppCompatActivity {

    private EditText editTextNombre, editTextTelefono;
    private Button buttonActualizar;
    private ContactosCrud contactosCrud;
    private int idContacto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_actualizar_contacto);

        editTextNombre = findViewById(R.id.editTextNombre);
        editTextTelefono = findViewById(R.id.editTextTelefono);
        buttonActualizar = findViewById(R.id.buttonActualizar);
        contactosCrud = new ContactosCrud();

        Intent intent = getIntent();
        idContacto = intent.getIntExtra("ID_CONTACTO", -1);
        String nombre = intent.getStringExtra("NOMBRE");
        String telefono = intent.getStringExtra("TELEFONO");

        editTextNombre.setText(nombre);
        editTextTelefono.setText(telefono);

        buttonActualizar.setOnClickListener(v -> actualizarContacto());
    }

    private void actualizarContacto() {
        String nombre = editTextNombre.getText().toString();
        String telefono = editTextTelefono.getText().toString();

        if (!nombre.isEmpty() && !telefono.isEmpty()) {
            // Asegúrate de llamar al método correcto
            if (contactosCrud.actualizarContacto(idContacto, nombre, telefono)) {  // Cambiado a "actualizarContacto"
                Toast.makeText(this, "Contacto actualizado", Toast.LENGTH_SHORT).show();
                finish();
            } else {
                Toast.makeText(this, "Error al actualizar contacto", Toast.LENGTH_SHORT).show();
            }
        } else {
            Toast.makeText(this, "Por favor, completa todos los campos", Toast.LENGTH_SHORT).show();
        }
    }
}

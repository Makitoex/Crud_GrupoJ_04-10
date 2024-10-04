package com.example.crud_grupoj_04_10;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class VistaListaDeContactos extends AppCompatActivity {

    private ListView listViewContactos;
    private ContactoAdapter contactoAdapter;
    private ContactosCrud contactosCrud;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vista_lista_de_contactos);

        listViewContactos = findViewById(R.id.listViewContactos);
        contactosCrud = new ContactosCrud();

        cargarContactos();

        listViewContactos.setOnItemClickListener((AdapterView<?> parent, View view, int position, long id) -> {
            ContactosGETSET contacto = contactoAdapter.getItem(position);
            Intent intent = new Intent(VistaListaDeContactos.this, ActualizarContactoActivity.class);
            intent.putExtra("ID_CONTACTO", contacto.getId());
            intent.putExtra("NOMBRE", contacto.getName());
            intent.putExtra("TELEFONO", contacto.getPhoneNumber());
            startActivity(intent);
        });
    }

    private void cargarContactos() {
        ArrayList<ContactosGETSET> contactos = contactosCrud.getContacts();
        contactoAdapter = new ContactoAdapter(this, contactos);
        listViewContactos.setAdapter(contactoAdapter);
    }
}

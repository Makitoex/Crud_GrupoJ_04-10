package com.example.crud_grupoj_04_10;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

public class ContactoAdapter extends ArrayAdapter<ContactosGETSET> {
    private ContactosCrud contactosCrud;  // Declarar contactosCrud

    public ContactoAdapter(Context context, List<ContactosGETSET> contactos) {
        super(context, 0, contactos);
        contactosCrud = new ContactosCrud();  // Inicializar contactosCrud
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ContactosGETSET contacto = getItem(position);

        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(android.R.layout.simple_list_item_2, parent, false);
        }

        TextView text1 = convertView.findViewById(android.R.id.text1);
        TextView text2 = convertView.findViewById(android.R.id.text2);
        Button buttonEliminar = new Button(getContext());
        buttonEliminar.setText("Eliminar");

        text1.setText(contacto.getName());
        text2.setText(contacto.getPhoneNumber());

        // Configurar el botón para eliminar contacto
        buttonEliminar.setOnClickListener(v -> {
            if (contactosCrud.eliminarContacto(contacto.getId())) {  // Asegúrate de que se elimina correctamente
                remove(contacto);
                notifyDataSetChanged();
                Toast.makeText(getContext(), "Contacto eliminado", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(getContext(), "Error al eliminar contacto", Toast.LENGTH_SHORT).show();
            }
        });

        // Agregar el botón a un layout, usando un LinearLayout
        LinearLayout layout = new LinearLayout(getContext());
        layout.setOrientation(LinearLayout.VERTICAL);
        layout.addView(text1);
        layout.addView(text2);
        layout.addView(buttonEliminar);

        return layout;  // Devuelve el layout con los elementos
    }
}


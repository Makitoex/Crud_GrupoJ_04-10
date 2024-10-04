package com.example.crud_grupoj_04_10;

public class ContactosGETSET {
    private int id;
    private String nombre;
    private String telefono;

    public ContactosGETSET(int id, String nombre, String telefono) {
        this.id = id;
        this.nombre = nombre;
        this.telefono = telefono;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return nombre;
    }

    public void setName(String nombre) {
        this.nombre = nombre;
    }

    public String getPhoneNumber() {
        return telefono;
    }

    public void setPhoneNumber(String telefono) {
        this.telefono = telefono;
    }
}

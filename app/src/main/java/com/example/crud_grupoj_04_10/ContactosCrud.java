package com.example.crud_grupoj_04_10;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ContactosCrud {

    public boolean agregarContacto(String nombre, String telefono) {
        try (Connection conexion = DBconexion.getConnection()) {
            String query = "INSERT INTO Contactos (Nombre, Telefono) VALUES (?, ?)";
            PreparedStatement statement = conexion.prepareStatement(query);
            statement.setString(1, nombre);
            statement.setString(2, telefono);
            return statement.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public ArrayList<ContactosGETSET> getContacts() {
        ArrayList<ContactosGETSET> contacts = new ArrayList<>();
        try (Connection connection = DBconexion.getConnection()) {
            String query = "SELECT * FROM Contactos";
            PreparedStatement statement = connection.prepareStatement(query);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("Id");
                String nombre = resultSet.getString("Nombre");
                String telefono = resultSet.getString("Telefono");
                contacts.add(new ContactosGETSET(id, nombre, telefono));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return contacts;
    }

    public boolean actualizarContacto(int id, String name, String phoneNumber) {
        try (Connection connection = DBconexion.getConnection()) {
            String query = "UPDATE Contactos SET Nombre = ?, Telefono = ? WHERE Id = ?";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, name);
            statement.setString(2, phoneNumber);
            statement.setInt(3, id);
            return statement.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean eliminarContacto(int id) {
        try (Connection connection = DBconexion.getConnection()) {
            String query = "DELETE FROM Contactos WHERE Id = ?";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setInt(1, id);
            return statement.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}

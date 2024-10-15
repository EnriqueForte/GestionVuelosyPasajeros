package com.vuelos.dao.aerolineas;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.vuelos.aerolineas.Aerolinea;
import com.vuelos.db.DBConnection;

public class AerolineaDAO {
	
    public void insertarAerolinea(Aerolinea aerolinea) {
        String sql = "INSERT INTO aerolineas (nombre, codigo) VALUES (?, ?)";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, aerolinea.getNombre());
            stmt.setString(2, aerolinea.getCodigo());

            stmt.executeUpdate();
            System.out.println("Aerolínea insertada correctamente.");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    // Método para obtener todas las aerolíneas
    public List<Aerolinea> obtenerAerolineas() {
        List<Aerolinea> aerolineas = new ArrayList<>();
        String sql = "SELECT ID, nombre, codigo FROM aerolineas"; // Incluye el campo "codigo"

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                // Crear un objeto Aerolinea y añadirlo a la lista
                Aerolinea aerolinea = new Aerolinea();               
                aerolinea.setNombre(rs.getString("nombre"));
                aerolinea.setCodigo(rs.getString("codigo")); // Asignar el código
                aerolineas.add(aerolinea);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return aerolineas; // Retornar la lista de aerolíneas
    }
}



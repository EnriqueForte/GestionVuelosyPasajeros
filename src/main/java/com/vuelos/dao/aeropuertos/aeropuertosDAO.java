package com.vuelos.dao.aeropuertos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.vuelos.aeropuertos.Aeropuerto;
import com.vuelos.db.DBConnection;

public class aeropuertosDAO {  // Cambio de nombre a mayúscula
	
    // Método para obtener aeropuertos por país
	public static List<Aeropuerto> obtenerAeropuertosPorPais(String pais) throws SQLException {
		List<Aeropuerto> aeropuertos = new ArrayList<>();
		String sql = "SELECT id, nombre, codigo, ciudad, pais FROM aeropuertos WHERE pais = ?";
		
		try (Connection conn = DBConnection.getConnection();
				PreparedStatement stmt = conn.prepareStatement(sql)) {
			stmt.setString(1, pais);  // Establecemos el país en la consulta
			
			try (ResultSet rs = stmt.executeQuery()) {
				while (rs.next()) {
					Aeropuerto aeropuerto = new Aeropuerto();
					aeropuerto.setId(rs.getInt("id"));
					aeropuerto.setNombre(rs.getString("nombre"));
					aeropuerto.setCodigo(rs.getString("codigo"));
					aeropuerto.setCiudad(rs.getString("ciudad"));
					aeropuertos.add(aeropuerto);
				}
			}
		}
		return aeropuertos;
	}

    // Método para insertar un aeropuerto
	public void insertarAeropuerto(Aeropuerto aeropuertos) {
		String sql = "INSERT INTO aeropuertos (nombre, codigo, ciudad, pais) VALUES (?, ?, ?, ?)";
		
		try (Connection conn = DBConnection.getConnection();
	             PreparedStatement stmt = conn.prepareStatement(sql)) {

	            stmt.setString(1, aeropuertos.getNombre());
	            stmt.setString(2, aeropuertos.getCodigo());
	            stmt.setString(3, aeropuertos.getCiudad());
	            stmt.setString(4, aeropuertos.getPais());

	            stmt.executeUpdate();
	            System.out.println("Aeropuerto insertado correctamente.");

	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }
}
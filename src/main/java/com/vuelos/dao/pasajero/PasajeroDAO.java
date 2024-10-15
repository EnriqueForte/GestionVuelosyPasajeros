package com.vuelos.dao.pasajero;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.vuelos.db.DBConnection;
import com.vuelos.model.pasajero;

public class PasajeroDAO {
	//Insertar pasajeros
	public void insertarPasajero(pasajero pasajero) {
		String sql = "INSERT INTO pasajeros (nombre, apellido, fechaNacimiento, tipoDocumentoId, numeroDocumento,email, telefono)"
				   + "VALUES (?,?,?,?,?,?,?);";
				  
		try (Connection conn = DBConnection.getConnection();
				PreparedStatement stmt = conn.prepareStatement(sql)){
            stmt.setString(1, pasajero.getNombre());
            stmt.setString(2, pasajero.getApellido());
            stmt.setString(3, pasajero.getFechaNacimiento());
            stmt.setInt(4, pasajero.getTipoDocumentoId());
            stmt.setString(5, pasajero.getNumeroDocumento());
            stmt.setString(6, pasajero.getEmail());
            stmt.setString(7, pasajero.getTelefono());
            

            stmt.executeUpdate();            
		}catch (SQLException e) {
			e.printStackTrace();
		}
}
	//Consulta de pasajeros
	public List<pasajero> obtenerTodosLosPasajeros(){
		List<pasajero> pasajeros = new ArrayList<>();
		String sql = "SELECT * FROM pasajeros";
	
		try (Connection conn = DBConnection.getConnection();
			PreparedStatement stmt = conn.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery()){
		
			while (rs.next()) {
			 pasajero pasajero = new pasajero();
	            pasajero.setId(rs.getInt("id"));
	            pasajero.setNombre(rs.getString("nombre"));
	            pasajero.setApellido(rs.getString("apellido"));
	            pasajero.setFechaNacimiento(rs.getString("fechaNacimiento"));
	            pasajero.setTipoDocumentoId(rs.getInt("tipoDocumentoId"));
	            pasajero.setNumeroDocumento(rs.getString("numeroDocumento"));
	            pasajero.setEmail(rs.getString("email"));
	            pasajero.setTelefono(rs.getString("telefono"));
	            pasajeros.add(pasajero);
			}

    } catch (SQLException e) {
        e.printStackTrace();
    	}

	return pasajeros;
	
	}
	
	 // Eliminar pasajero por ID
    public void eliminarPasajeroPorId(int id) {
        String sql = "DELETE FROM pasajeros WHERE id = ?";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)){

            stmt.setInt(1, id); // Asignar el ID al parámetro de la consulta
            int filasAfectadas = stmt.executeUpdate();

            if (filasAfectadas > 0) {
                System.out.println("Pasajero eliminado exitosamente.");
            } else {
                System.out.println("No se encontró ningún pasajero con el ID proporcionado.");
            }

        } catch (SQLException e) {
        	e.printStackTrace();
    	}
    }
	   // Método para buscar pasajeros por número de documento
    public static List<pasajero> buscarPasajerosPorDocumento(String numeroDocumento) {
        List<pasajero> pasajeros = new ArrayList<>();
        String sql = "SELECT p.id, p.nombre, p.apellido, p.numeroDocumento, td.descripcion AS tipoDocumento "
                   + "FROM pasajeros p "
                   + "JOIN tipo_documento td ON p.tipoDocumentoId = td.id "
                   + "WHERE p.numeroDocumento LIKE ?";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)){

            stmt.setString(1, "%" + numeroDocumento + "%");
            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    pasajero pasajero = new pasajero();
                    pasajero.setId(rs.getInt("id"));
                    pasajero.setNombre(rs.getString("nombre"));
                    pasajero.setApellido(rs.getString("apellido"));
                    pasajero.setNumeroDocumento(rs.getString("numeroDocumento"));
                    pasajero.setTipoDocumento(rs.getString("tipoDocumento"));
                    pasajeros.add(pasajero);
                }
            }

        } catch (SQLException e) {
        	e.printStackTrace();
        }

        return pasajeros;
    }
}
package com.vuelos.dao.nacionalidad;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.vuelos.db.DBConnection;
import com.vuelos.nacionalidad.Nacionalidad;

public class NacionalidadDAO {
	
	//Obtener todas las nacionalidades
	public static List<Nacionalidad>obtenerTodasLasNacionalidades() throws SQLException{
		List<Nacionalidad> lista = new ArrayList<>();
		String sql = "SELECT id, nombre FROM nacionalidades ORDER BY nombre ASC";
		
		try (Connection conn = DBConnection.getConnection();
				PreparedStatement stmt = conn.prepareStatement(sql);
				ResultSet rs = stmt.executeQuery()) {
			
			while (rs.next()) {
				Nacionalidad nacionalidad = new Nacionalidad(
						rs.getInt("id"),
						rs.getString("nombre")
					);
				lista.add(nacionalidad);
			}
		}
		
		return lista;
	}

}

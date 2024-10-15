package com.vuelos.dao.vuelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.vuelos.db.DBConnection;
import com.vuelos.vuelo.Vuelo;

public class VueloDAO {
	
	public void insertarVuelo(Vuelo vuelo) {
        String sql = "INSERT INTO vuelos (aerolinea_id, codigo_vuelo, aeropuerto_origen_id, aeropuerto_destino_id, fecha_vuelo, hora_salida, hora_llegada) VALUES (?, ?, ?, ?, ?, ?, ?)";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, vuelo.getAerolinea_id());
            stmt.setString(2, vuelo.getCodigo_vuelo());
            stmt.setInt(3, vuelo.getAeropuerto_origen_id());
            stmt.setInt(4, vuelo.getAeropuerto_destino_id());
            stmt.setString(5, vuelo.getFecha_vuelo());
            stmt.setString(6, vuelo.getHora_salida());
            stmt.setString(7, vuelo.getHora_llegada());

            stmt.executeUpdate();
            System.out.println("Vuelo insertado correctamente.");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
	
	// Método para listar todos los vuelos
    public List<Vuelo> listarVuelos() {
        List<Vuelo> vuelos = new ArrayList<>();
        String sql = "SELECT v.id, v.codigo_vuelo, v.fecha_vuelo, v.hora_salida, v.hora_llegada, "
                   + "a.nombre AS nombre_aerolinea, "
                   + "ao.nombre AS nombre_aeropuerto_origen, "
                   + "ad.nombre AS nombre_aeropuerto_destino "
                   + "FROM vuelos v "
                   + "INNER JOIN aerolineas a ON v.aerolinea_id = a.id "
                   + "INNER JOIN aeropuertos ao ON v.aeropuerto_origen_id = ao.id "
                   + "INNER JOIN aeropuertos ad ON v.aeropuerto_destino_id = ad.id";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                Vuelo vuelo = new Vuelo();

                vuelo.setId(rs.getInt("id"));
                vuelo.setCodigo_vuelo(rs.getString("codigo_vuelo"));
                vuelo.setFecha_vuelo(rs.getString("fecha_vuelo"));
                vuelo.setHora_salida(rs.getString("hora_salida"));
                vuelo.setHora_llegada(rs.getString("hora_llegada"));
                vuelo.setNombreAerolinea(rs.getString("nombre_aerolinea"));
                vuelo.setNombreAeropuertoOrigen(rs.getString("nombre_aeropuerto_origen"));
                vuelo.setNombreAeropuertoDestino(rs.getString("nombre_aeropuerto_destino"));

                vuelos.add(vuelo);
            }

        } catch (SQLException e) {
            e.printStackTrace();
            // Considera usar logging en lugar de printStackTrace()
        }

        return vuelos;
    }
	
	
}

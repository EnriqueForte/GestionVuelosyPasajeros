package com.vuelos.dao.viajes;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.util.ArrayList;
import java.util.List;

import com.vuelos.db.DBConnection;
import com.vuelos.viajes.Viaje;

public class ViajeDAO {
	
	public void insertarViaje(Viaje viaje) {
        String sql = "INSERT INTO viajes (pasajero_id, vuelo_id, asiento, fecha_reserva) VALUES (?, ?, ?, ?)";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, viaje.getPasajeroId());
            stmt.setInt(2, viaje.getVueloId());
            stmt.setString(3, viaje.getAsiento());
            stmt.setString(4, viaje.getFechaReserva());

            stmt.executeUpdate();
            System.out.println("Viaje insertado correctamente.");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

	public List<Viaje> obtenerViajesPorDocumento(String numeroDocumento) throws SQLException {
	    List<Viaje> viajes = new ArrayList<>();
	    String sql = "SELECT v.id AS viaje_id, " +
	                 "p.nombre AS pasajero_nombre, " +
	                 "p.apellido AS pasajero_apellido, " +
	                 "p.fechaNacimiento AS pasajero_fecha_nacimiento, " +
	                 "p.numeroDocumento AS pasajero_documento_numero, " +
	                 "td.descripcion AS pasajero_tipo_documento, " +
	                 "p.email AS pasajero_email, " +
	                 "p.telefono AS pasajero_telefono, " +
	                 "vu.codigo_vuelo AS vuelo_codigo, " +
	                 "vu.fecha_vuelo AS vuelo_fecha, " +
	                 "vu.hora_salida AS vuelo_hora_salida, " +
	                 "vu.hora_llegada AS vuelo_hora_llegada, " +
	                 "ao.nombre AS aeropuerto_origen, " +
	                 "ad.nombre AS aeropuerto_destino, " +
	                 "a.nombre AS aerolinea_nombre, " +
	                 "v.asiento AS asiento, " +
	                 "v.fecha_reserva AS fecha_reserva, " +
	                 "v.vuelo_id AS vuelo_id, " +
	                 "v.pasajero_id AS pasajero_id " +
	                 "FROM viajes v " +
	                 "JOIN pasajeros p ON v.pasajero_id = p.id " +
	                 "JOIN vuelos vu ON v.vuelo_id = vu.id " +
	                 "JOIN tipo_documento td ON p.tipoDocumentoId = td.id " +
	                 "JOIN aeropuertos ao ON vu.aeropuerto_origen_id = ao.id " +
	                 "JOIN aeropuertos ad ON vu.aeropuerto_destino_id = ad.id " +
	                 "JOIN aerolineas a ON vu.aerolinea_id = a.id " +
	                 "WHERE p.numeroDocumento = ?"; // Cambiado a numeroDocumento

	    try (Connection conn = DBConnection.getConnection();
	         PreparedStatement stmt = conn.prepareStatement(sql)) {

	        stmt.setString(1, numeroDocumento); // Asignar como String

	        try (ResultSet rs = stmt.executeQuery()) {
	            while (rs.next()) {
	                Viaje viaje = new Viaje();
	                viaje.setId(rs.getInt("viaje_id"));
	                viaje.setPasajeroNombre(rs.getString("pasajero_nombre"));
	                viaje.setPasajeroApellido(rs.getString("pasajero_apellido"));
	                viaje.setFechaNacimiento(rs.getString("pasajero_fecha_nacimiento"));
	                viaje.setPasajeronumeroDocumento(rs.getString("pasajero_documento_numero"));
	                viaje.setPasajeroTipoDocumento(rs.getString("pasajero_tipo_documento"));
	                viaje.setEmailPasajero(rs.getString("pasajero_email"));
	                viaje.setTelefonoPasajero(rs.getString("pasajero_telefono"));
	                viaje.setVueloCodigo(rs.getString("vuelo_codigo"));

	                // Manejo de vuelo_fecha
	                Date sqlVueloFecha = rs.getDate("vuelo_fecha");
	                if (sqlVueloFecha != null) {
	                    viaje.setVueloFecha(sqlVueloFecha.toString());
	                } else {
	                    viaje.setVueloFecha("N/A");
	                }

	                // Manejo de hora_salida
	                Time sqlHoraSalida = rs.getTime("vuelo_hora_salida");
	                if (sqlHoraSalida != null) {
	                    viaje.setHoraSalida(sqlHoraSalida.toString());
	                } else {
	                    viaje.setHoraSalida("N/A");
	                }

	                // Manejo de hora_llegada
	                Time sqlHoraLlegada = rs.getTime("vuelo_hora_llegada");
	                if (sqlHoraLlegada != null) {
	                    viaje.setHoraLlegada(sqlHoraLlegada.toString());
	                } else {
	                    viaje.setHoraLlegada("N/A");
	                }

	                viaje.setAeropuertoOrigen(rs.getString("aeropuerto_origen"));
	                viaje.setAeropuertoDestino(rs.getString("aeropuerto_destino"));
	                viaje.setAerolineaNombre(rs.getString("aerolinea_nombre"));
	                viaje.setAsiento(rs.getString("asiento"));
	                viaje.setFechaReserva(rs.getString("fecha_reserva") != null ? rs.getString("fecha_reserva") : "N/A");
	                viaje.setVueloId(rs.getInt("vuelo_id"));
	                viaje.setPasajeroId(rs.getInt("pasajero_id"));

	                viajes.add(viaje);
	            }
	        }
	    }

	    return viajes;  
	}
	
	// **Nuevo Método: listarViajes()**
    public List<Viaje> listarViajes() throws SQLException {
        List<Viaje> viajes = new ArrayList<>();
        String sql = "SELECT v.id AS viaje_id, " +
                     "p.nombre AS pasajero_nombre, " +
                     "p.apellido AS pasajero_apellido, " +
                     "p.fechaNacimiento AS pasajero_fecha_nacimiento, " +
                     "p.numeroDocumento AS pasajero_documento_numero, " +
                     "td.descripcion AS pasajero_tipo_documento, " +
                     "p.email AS pasajero_email, " +
                     "p.telefono AS pasajero_telefono, " +
                     "vu.codigo_vuelo AS vuelo_codigo, " +
                     "vu.fecha_vuelo AS vuelo_fecha, " +
                     "vu.hora_salida AS vuelo_hora_salida, " +
                     "vu.hora_llegada AS vuelo_hora_llegada, " +
                     "ao.nombre AS aeropuerto_origen, " +
                     "ad.nombre AS aeropuerto_destino, " +
                     "a.nombre AS aerolinea_nombre, " +
                     "v.asiento AS asiento, " +
                     "v.fecha_reserva AS fecha_reserva, " +
                     "v.vuelo_id AS vuelo_id, " +
                     "v.pasajero_id AS pasajero_id " +
                     "FROM viajes v " +
                     "JOIN pasajeros p ON v.pasajero_id = p.id " +
                     "JOIN vuelos vu ON v.vuelo_id = vu.id " +
                     "JOIN tipo_documento td ON p.tipoDocumentoId = td.id " +
                     "JOIN aeropuertos ao ON vu.aeropuerto_origen_id = ao.id " +
                     "JOIN aeropuertos ad ON vu.aeropuerto_destino_id = ad.id " +
                     "JOIN aerolineas a ON vu.aerolinea_id = a.id";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                Viaje viaje = new Viaje();
                viaje.setId(rs.getInt("viaje_id"));
                viaje.setPasajeroNombre(rs.getString("pasajero_nombre"));
                viaje.setPasajeroApellido(rs.getString("pasajero_apellido"));
                viaje.setFechaNacimiento(rs.getString("pasajero_fecha_nacimiento"));
                viaje.setPasajeronumeroDocumento(rs.getString("pasajero_documento_numero"));
                viaje.setPasajeroTipoDocumento(rs.getString("pasajero_tipo_documento"));
                viaje.setEmailPasajero(rs.getString("pasajero_email"));
                viaje.setTelefonoPasajero(rs.getString("pasajero_telefono"));
                viaje.setVueloCodigo(rs.getString("vuelo_codigo"));

                // Manejo de vuelo_fecha
                Date sqlVueloFecha = rs.getDate("vuelo_fecha");
                if (sqlVueloFecha != null) {
                    viaje.setVueloFecha(sqlVueloFecha.toString());
                } else {
                    viaje.setVueloFecha("N/A");
                }

                // Manejo de hora_salida
                Time sqlHoraSalida = rs.getTime("vuelo_hora_salida");
                if (sqlHoraSalida != null) {
                    viaje.setHoraSalida(sqlHoraSalida.toString());
                } else {
                    viaje.setHoraSalida("N/A");
                }

                // Manejo de hora_llegada
                Time sqlHoraLlegada = rs.getTime("vuelo_hora_llegada");
                if (sqlHoraLlegada != null) {
                    viaje.setHoraLlegada(sqlHoraLlegada.toString());
                } else {
                    viaje.setHoraLlegada("N/A");
                }

                viaje.setAeropuertoOrigen(rs.getString("aeropuerto_origen"));
                viaje.setAeropuertoDestino(rs.getString("aeropuerto_destino"));
                viaje.setAerolineaNombre(rs.getString("aerolinea_nombre"));
                viaje.setAsiento(rs.getString("asiento"));
                viaje.setFechaReserva(rs.getString("fecha_reserva") != null ? rs.getString("fecha_reserva") : "N/A");
                viaje.setVueloId(rs.getInt("vuelo_id"));
                viaje.setPasajeroId(rs.getInt("pasajero_id"));

                viajes.add(viaje);
            }
        }

        return viajes;
    }

}

	    

	        
	

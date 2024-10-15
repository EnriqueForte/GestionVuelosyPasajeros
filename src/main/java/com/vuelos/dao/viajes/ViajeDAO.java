package com.vuelos.dao.viajes;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
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

	public List<Viaje> listarViajes() throws SQLException{
		List<Viaje> viajes = new ArrayList<>();
		//Consulta SQL para obtener detalles del vuelo
		String sql = "SELECT v.id AS viaje_id, p.id AS pasajero_id, p.nombre AS pasajero_nombre, "
		           + "p.numeroDocumento AS pasajero_documento_numero, td.descripcion AS pasajero_tipo_documento, "
		           + "vu.id AS vuelo_id, vu.codigo_vuelo AS vuelo_codigo, vu.fecha_vuelo AS vuelo_fecha, "
		           + "vu.hora_salida AS vuelo_hora_salida, vu.hora_llegada AS vuelo_hora_llegada, "
		           + "v.asiento AS asiento "
		           + "FROM viajes v "
		           + "JOIN pasajeros p ON v.pasajero_id = p.id "
		           + "JOIN vuelos vu ON v.vuelo_id = vu.id "
		           + "JOIN tipo_documento td ON p.tipoDocumentoId = td.id";
		
		try (Connection conn = DBConnection.getConnection();
			PreparedStatement stmt = conn.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery()){
			//Recorrer resultados obtenidos
			while (rs.next()) {
				Viaje viaje = new Viaje();
				
				//Asignar a cada columna obtenida de la consulta al objeto `Viaje`
	            viaje.setId(rs.getInt("viaje_id"));
	            viaje.setPasajeroId(rs.getInt("pasajero_id"));
	            viaje.setPasajeroNombre(rs.getString("pasajero_nombre"));  // Añadir nombre del pasajero
	            viaje.setPasajeroTipoDocumento(rs.getString("pasajero_tipo_documento"));  // Tipo de documento
	            viaje.setPasajeronumeroDocumento(rs.getString("pasajero_documento_numero"));  // Documento del pasajero	            
	            viaje.setVueloId(rs.getInt("vuelo_id"));
	            viaje.setVueloCodigo(rs.getString("vuelo_codigo"));  // Código del vuelo
	            viaje.setFechaReserva(rs.getDate("vuelo_fecha").toString());  // Fecha del vuelo
	            viaje.setAsiento(rs.getString("asiento"));
	            
	            //Añadir el objeto Viaje a la lista viajes
	            viajes.add(viaje);
			}
		}return viajes;
	}
	public List<Viaje> obtenerViajesPorDocumento(String numeroDocumento) throws SQLException {
	    List<Viaje> viajes = new ArrayList<>();
	    String sql = "SELECT v.id AS viaje_id, p.nombre AS pasajero_nombre, p.apellido AS pasajero_apellido, "
	               + "p.numeroDocumento AS pasajero_documento_numero, td.descripcion AS pasajero_tipo_documento, "
	               + "vu.codigo_vuelo AS vuelo_codigo, vu.fecha_vuelo AS vuelo_fecha, "
	               + "vu.hora_salida AS vuelo_hora_salida, vu.hora_llegada AS vuelo_hora_llegada, "
	               + "ao.nombre AS aeropuerto_origen, ad.nombre AS aeropuerto_destino, "
	               + "a.nombre AS aerolinea_nombre, "
	               + "v.asiento AS asiento "
	               + "FROM viajes v "
	               + "JOIN pasajeros p ON v.pasajero_id = p.id "
	               + "JOIN vuelos vu ON v.vuelo_id = vu.id "
	               + "JOIN tipo_documento td ON p.tipoDocumentoId = td.id "
	               + "JOIN aeropuertos ao ON vu.aeropuerto_origen_id = ao.id "
	               + "JOIN aeropuertos ad ON vu.aeropuerto_destino_id = ad.id "
	               + "JOIN aerolineas a ON vu.aerolinea_id = a.id "
	               + "WHERE p.numeroDocumento = ?";

	    try (Connection conn = DBConnection.getConnection();
	         PreparedStatement stmt = conn.prepareStatement(sql)) {

	        stmt.setString(1, numeroDocumento);

	        try (ResultSet rs = stmt.executeQuery()) {
	            while (rs.next()) {
	                Viaje viaje = new Viaje();
	                viaje.setId(rs.getInt("viaje_id"));
	                viaje.setPasajeroNombre(rs.getString("pasajero_nombre"));
	                viaje.setPasajeroApellido(rs.getString("pasajero_apellido"));
	                viaje.setPasajeronumeroDocumento(rs.getString("pasajero_documento_numero"));
	                viaje.setPasajeroTipoDocumento(rs.getString("pasajero_tipo_documento"));
	                viaje.setVueloCodigo(rs.getString("vuelo_codigo"));
	                viaje.setVueloFecha(rs.getDate("vuelo_fecha")); 
	                viaje.setHoraSalida(rs.getTime("vuelo_hora_salida"));
	                viaje.setHoraLlegada(rs.getTime("vuelo_hora_llegada"));
	                viaje.setAeropuertoOrigen(rs.getString("aeropuerto_origen"));
	                viaje.setAeropuertoDestino(rs.getString("aeropuerto_destino"));
	                viaje.setAerolineaNombre(rs.getString("aerolinea_nombre"));
	                viaje.setAsiento(rs.getString("asiento"));
	                viajes.add(viaje);
	            }
	        }
	    }
	    return viajes;
	}
	    
    }
	

	        
	

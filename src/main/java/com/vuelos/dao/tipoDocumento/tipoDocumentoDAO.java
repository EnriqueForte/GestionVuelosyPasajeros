package com.vuelos.dao.tipoDocumento;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.vuelos.db.DBConnection;
import com.vuelos.tipoDocumento.tipoDocumento;

public class tipoDocumentoDAO {
	
	public void insertarTipoDocumento(tipoDocumento tipoDocumento) {
        String sql = "INSERT INTO tipo_documento (descripcion) VALUES (?)";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, tipoDocumento.getDescripcion());

            stmt.executeUpdate();
            System.out.println("Tipo de documento insertado correctamente.");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

// Método para obtener todos los tipos de documento
	
public List<tipoDocumento> obtenerTodosLosTipos() {
    List<tipoDocumento> tiposDocumentos = new ArrayList<>();
    String sql = "SELECT * FROM tipo_documento";

    try (Connection conn = DBConnection.getConnection();
         PreparedStatement stmt = conn.prepareStatement(sql);
         ResultSet rs = stmt.executeQuery()) {

        // Recorremos los resultados y creamos objetos TipoDocumento
        while (rs.next()) {
            tipoDocumento tipoDocumento = new tipoDocumento();
            tipoDocumento.setId(rs.getInt("id"));
            tipoDocumento.setDescripcion(rs.getString("descripcion"));
            tiposDocumentos.add(tipoDocumento);
        }

    } catch (SQLException e) {
        e.printStackTrace();
    }

    return tiposDocumentos;
  }

//Método para obtener asignar automaticamente el id segun tabla
public tipoDocumento obtenerPorNombre(String nombre) {
    tipoDocumento tipoDocumento = null;
    String sql = "SELECT * FROM tipo_documento WHERE descripcion = ?";

    try (Connection conn = DBConnection.getConnection();
         PreparedStatement stmt = conn.prepareStatement(sql)) {
        
        stmt.setString(1, nombre);
        ResultSet rs = stmt.executeQuery();

        if (rs.next()) {
            tipoDocumento = new tipoDocumento();
            tipoDocumento.setId(rs.getInt("id"));
            tipoDocumento.setDescripcion(rs.getString("descripcion"));
        }

    } catch (SQLException e) {
        e.printStackTrace();
    }

    return tipoDocumento;
  }
}
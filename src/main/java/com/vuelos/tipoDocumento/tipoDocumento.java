package com.vuelos.tipoDocumento;

public class tipoDocumento {
    private int id;
    private String descripcion;

    // Constructor sin argumentos
    public tipoDocumento() {}

    // Constructor con parámetros
    public tipoDocumento(int id, String descripcion) {
        this.id = id;
        this.descripcion = descripcion;
    }

    // Getter y Setter para 'id'
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    // Getter y Setter para 'descripcion'
    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) { // 
        this.descripcion = descripcion;
    }

    // Método toString para mostrar la descripción en el ComboBox
    @Override
    public String toString() {
        return descripcion;
    }
}
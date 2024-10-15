package com.vuelos.vuelo;

public class Vuelo {
    private int id;
    private String aerolinea_id;
    private String codigo_vuelo;
    private int aeropuerto_origen_id;
    private int aeropuerto_destino_id;
    private String fecha_vuelo;
    private String hora_salida;
    private String hora_llegada;
    private String NombreAerolinea;
    private String NombreAeropuertoOrigen;
    private String NombreAeropuertoDestino;

    // Constructor
    public Vuelo() {}
    
    //Getters y Setters

	public String getAerolinea_id() {
		return aerolinea_id;
	}

	public void setAerolinea_id(String string) {
		this.aerolinea_id = string;
	}

	public String getCodigo_vuelo() {
		return codigo_vuelo;
	}

	public void setCodigo_vuelo(String codigo_vuelo) {
		this.codigo_vuelo = codigo_vuelo;
	}

	public int getAeropuerto_origen_id() {
		return aeropuerto_origen_id;
	}

	public void setAeropuerto_origen_id(int aeropuerto_origen_id) {
		this.aeropuerto_origen_id = aeropuerto_origen_id;
	}

	public int getAeropuerto_destino_id() {
		return aeropuerto_destino_id;
	}

	public void setAeropuerto_destino_id(int aeropuerto_destino_id) {
		this.aeropuerto_destino_id = aeropuerto_destino_id;
	}

	public String getFecha_vuelo() {
		return fecha_vuelo;
	}

	public void setFecha_vuelo(String fecha_vuelo) {
		this.fecha_vuelo = fecha_vuelo;
	}

	public String getHora_salida() {
		return hora_salida;
	}

	public void setHora_salida(String hora_salida) {
		this.hora_salida = hora_salida;
	}

	public String getHora_llegada() {
		return hora_llegada;
	}

	public void setHora_llegada(String hora_llegada) {
		this.hora_llegada = hora_llegada;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombreAerolinea() {
		return NombreAerolinea;
	}

	public void setNombreAerolinea(String nombreAerolinea) {
		NombreAerolinea = nombreAerolinea;
	}

	public String getNombreAeropuertoOrigen() {
		return NombreAeropuertoOrigen;
	}

	public void setNombreAeropuertoOrigen(String nombreAeropuertoOrigen) {
		NombreAeropuertoOrigen = nombreAeropuertoOrigen;
	}

	public String getNombreAeropuertoDestino() {
		return NombreAeropuertoDestino;
	}

	public void setNombreAeropuertoDestino(String nombreAeropuertoDestino) {
		NombreAeropuertoDestino = nombreAeropuertoDestino;
	}
	
	 // Método toString para mostrar en ComboBox
    @Override
    public String toString() {
        return codigo_vuelo + " - " + NombreAerolinea + " | " + NombreAeropuertoOrigen + " -> " + NombreAeropuertoDestino + " | " + fecha_vuelo;
    }



}

package com.vuelos.viajes;

import java.sql.Date;
import java.sql.Time;

public class Viaje {
	private int id;
    private int pasajeroId;
    private String pasajeroNombre;
    private String pasajeroApellido;
    private String PasajeroDocumentoId;
    private String PasajeroTipoDocumento;
    private String PasajeronumeroDocumento;
    private String VueloCodigo;
    private Date VueloFecha;
    private Time HoraSalida;
    private Time HoraLlegada;
    private String AeropuertoOrigen;
    private String AeropuertoDestino;
    private String AerolineaNombre;
    
    	
    private int vueloId;
    private String asiento;    
    private String fechaReserva;
    
    // Constructor
    public Viaje() {}
    
    //Getters y Setters
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}	
	public int getVueloId() {
		return vueloId;
	}
	public void setVueloId(int vueloId) {
		this.vueloId = vueloId;
	}
	public String getFechaReserva() {
		return fechaReserva;
	}
	public void setFechaReserva(String fechaReserva) {
		this.fechaReserva = fechaReserva;
	}
	public String getAsiento() {
		return asiento;
	}
	public void setAsiento(String asiento) {
		this.asiento = asiento;
	}

	public int getPasajeroId() {
		return pasajeroId;
	}

	public void setPasajeroId(int pasajeroId) {
		this.pasajeroId = pasajeroId;
	}

	public String getPasajeroNombre() {
		return pasajeroNombre;
	}

	public void setPasajeroNombre(String pasajeroNombre) {
		this.pasajeroNombre = pasajeroNombre;
	}

	public String getPasajeroDocumentoId() {
		return PasajeroDocumentoId;
	}

	public void setPasajeroDocumentoId(String pasajeroDocumentoId) {
		PasajeroDocumentoId = pasajeroDocumentoId;
	}

	public String getPasajeroTipoDocumento() {
		return PasajeroTipoDocumento;
	}

	public void setPasajeroTipoDocumento(String pasajeroTipoDocumento) {
		PasajeroTipoDocumento = pasajeroTipoDocumento;
	}

	public String getVueloCodigo() {
		return VueloCodigo;
	}

	public void setVueloCodigo(String vueloCodigo) {
		VueloCodigo = vueloCodigo;	}

	public String getPasajeronumeroDocumento() {
		return PasajeronumeroDocumento;
	}

	public void setPasajeronumeroDocumento(String pasajeronumeroDocumento) {
		PasajeronumeroDocumento = pasajeronumeroDocumento;
	}

	public String getPasajeroApellido() {
		return pasajeroApellido;
	}

	public void setPasajeroApellido(String pasajeroApellido) {
		this.pasajeroApellido = pasajeroApellido;
	}

	public Date getVueloFecha() {
		return VueloFecha;
	}

	public void setVueloFecha(Date vueloFecha) {
		VueloFecha = vueloFecha;
	}

	public Time getHoraSalida() {
		return HoraSalida;
	}

	public void setHoraSalida(Time time) {
		HoraSalida = time;
	}

	public Time getHoraLlegada() {
		return HoraLlegada;
	}

	public void setHoraLlegada(Time horaLlegada) {
		HoraLlegada = horaLlegada;
	}

	public String getAeropuertoOrigen() {
		return AeropuertoOrigen;
	}

	public void setAeropuertoOrigen(String aeropuertoOrigen) {
		AeropuertoOrigen = aeropuertoOrigen;
	}


	public String getAerolineaNombre() {
		return AerolineaNombre;
	}

	public void setAerolineaNombre(String aerolineaNombre) {
		AerolineaNombre = aerolineaNombre;
	}

	public String getAeropuertoDestino() {
		return AeropuertoDestino;
	}

	public void setAeropuertoDestino(String aeropuertoDestino) {
		AeropuertoDestino = aeropuertoDestino;
	}


	

}

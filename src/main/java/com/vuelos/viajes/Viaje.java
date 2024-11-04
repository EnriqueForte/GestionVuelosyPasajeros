package com.vuelos.viajes;

public class Viaje {
    private int id;
    private String pasajeroNombre;
    private String pasajeroApellido;
    private String fechaNacimiento;
    private String pasajeronumeroDocumento;
    private String pasajeroTipoDocumento;
    private String emailPasajero;
    private String telefonoPasajero;
    private String NacionalidadPasajero;
    private String vueloCodigo;
    private String vueloFecha;
    private String horaSalida;
    private String horaLlegada;
    private String aeropuertoOrigen;
    private String aeropuertoDestino;
    private String aerolineaNombre;
    private String asiento;
    private String fechaReserva;
    private int vueloId;
    private int pasajeroId;

    // Getters y Setters

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getPasajeroNombre() { return pasajeroNombre; }
    public void setPasajeroNombre(String pasajeroNombre) { this.pasajeroNombre = pasajeroNombre; }

    public String getPasajeroApellido() { return pasajeroApellido; }
    public void setPasajeroApellido(String pasajeroApellido) { this.pasajeroApellido = pasajeroApellido; }

    public String getFechaNacimiento() { return fechaNacimiento; }
    public void setFechaNacimiento(String fechaNacimiento) { this.fechaNacimiento = fechaNacimiento; }

    public String getPasajeronumeroDocumento() { return pasajeronumeroDocumento; }
    public void setPasajeronumeroDocumento(String pasajeronumeroDocumento) { this.pasajeronumeroDocumento = pasajeronumeroDocumento; }

    public String getPasajeroTipoDocumento() { return pasajeroTipoDocumento; }
    public void setPasajeroTipoDocumento(String pasajeroTipoDocumento) { this.pasajeroTipoDocumento = pasajeroTipoDocumento; }

    public String getEmailPasajero() { return emailPasajero; }
    public void setEmailPasajero(String emailPasajero) { this.emailPasajero = emailPasajero; }

    public String getTelefonoPasajero() { return telefonoPasajero; }
    public void setTelefonoPasajero(String telefonoPasajero) { this.telefonoPasajero = telefonoPasajero; }

    public String getVueloCodigo() { return vueloCodigo; }
    public void setVueloCodigo(String vueloCodigo) { this.vueloCodigo = vueloCodigo; }

    public String getVueloFecha() { return vueloFecha; }
    public void setVueloFecha(String vueloFecha) { this.vueloFecha = vueloFecha; }

    public String getHoraSalida() { return horaSalida; }
    public void setHoraSalida(String horaSalida) { this.horaSalida = horaSalida; }

    public String getHoraLlegada() { return horaLlegada; }
    public void setHoraLlegada(String horaLlegada) { this.horaLlegada = horaLlegada; }

    public String getAeropuertoOrigen() { return aeropuertoOrigen; }
    public void setAeropuertoOrigen(String aeropuertoOrigen) { this.aeropuertoOrigen = aeropuertoOrigen; }

    public String getAeropuertoDestino() { return aeropuertoDestino; }
    public void setAeropuertoDestino(String aeropuertoDestino) { this.aeropuertoDestino = aeropuertoDestino; }

    public String getAerolineaNombre() { return aerolineaNombre; }
    public void setAerolineaNombre(String aerolineaNombre) { this.aerolineaNombre = aerolineaNombre; }

    public String getAsiento() { return asiento; }
    public void setAsiento(String asiento) { this.asiento = asiento; }

    public String getFechaReserva() { return fechaReserva; }
    public void setFechaReserva(String fechaReserva) { this.fechaReserva = fechaReserva; }

    public int getVueloId() { return vueloId; }
    public void setVueloId(int vueloId) { this.vueloId = vueloId; }
	
    public int getPasajeroId() {return pasajeroId;}
	public void setPasajeroId(int pasajeroId) {
		this.pasajeroId = pasajeroId;
	}
	public String getNacionalidadPasajero() {
		return NacionalidadPasajero;
	}
	public void setNacionalidadPasajero(String nacionalidadPasajero) {
		NacionalidadPasajero = nacionalidadPasajero;
	}

	
}


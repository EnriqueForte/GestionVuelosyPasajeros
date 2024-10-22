package com.vuelos.model;

import javafx.beans.property.SimpleStringProperty;

public class PasajeroViaje {
    private final SimpleStringProperty nombrePasajero;
    private final SimpleStringProperty apellidoPasajero;
    private final SimpleStringProperty fechaNacimientoPasajero;
    private final SimpleStringProperty vueloFecha;
    private final SimpleStringProperty pasajeroTipoDocumento;
    private final SimpleStringProperty numeroDocumentoPasajero;
    private final SimpleStringProperty emailPasajero; // Nueva propiedad
    private final SimpleStringProperty telefonoPasajero; // Nueva propiedad
    private final SimpleStringProperty vueloCodigo;
    private final SimpleStringProperty aerolineaNombre;
    private final SimpleStringProperty aeropuertoOrigen;
    private final SimpleStringProperty aeropuertoDestino;
    private final SimpleStringProperty asiento;
    private final SimpleStringProperty fechaReserva;

    public PasajeroViaje(String nombrePasajero, String apellidoPasajero, String fechaNacimientoPasajero, String vueloFecha,
                         String pasajeroTipoDocumento, String numeroDocumentoPasajero, String emailPasajero,
                         String telefonoPasajero, String vueloCodigo,
                         String aerolineaNombre, String aeropuertoOrigen, String aeropuertoDestino,
                         String asiento, String fechaReserva) {
        this.nombrePasajero = new SimpleStringProperty(nombrePasajero != null ? nombrePasajero : "N/A");
        this.apellidoPasajero = new SimpleStringProperty(apellidoPasajero != null ? apellidoPasajero : "N/A");
        this.fechaNacimientoPasajero = new SimpleStringProperty(fechaNacimientoPasajero != null ? fechaNacimientoPasajero : "N/A");
        this.vueloFecha = new SimpleStringProperty(vueloFecha != null ? vueloFecha : "N/A");
        this.pasajeroTipoDocumento = new SimpleStringProperty(pasajeroTipoDocumento != null ? pasajeroTipoDocumento : "N/A");
        this.numeroDocumentoPasajero = new SimpleStringProperty(numeroDocumentoPasajero != null ? numeroDocumentoPasajero : "N/A");
        this.emailPasajero = new SimpleStringProperty(emailPasajero != null ? emailPasajero : "N/A");
        this.telefonoPasajero = new SimpleStringProperty(telefonoPasajero != null ? telefonoPasajero : "N/A");
        this.vueloCodigo = new SimpleStringProperty(vueloCodigo != null ? vueloCodigo : "N/A");
        this.aerolineaNombre = new SimpleStringProperty(aerolineaNombre != null ? aerolineaNombre : "N/A");
        this.aeropuertoOrigen = new SimpleStringProperty(aeropuertoOrigen != null ? aeropuertoOrigen : "N/A");
        this.aeropuertoDestino = new SimpleStringProperty(aeropuertoDestino != null ? aeropuertoDestino : "N/A");
        this.asiento = new SimpleStringProperty(asiento != null ? asiento : "N/A");
        this.fechaReserva = new SimpleStringProperty(fechaReserva != null ? fechaReserva : "N/A");
    }

    // Getters para las propiedades

    public String getNombrePasajero() { return nombrePasajero.get(); }
    public SimpleStringProperty nombrePasajeroProperty() { return nombrePasajero; }

    public String getApellidoPasajero() { return apellidoPasajero.get(); }
    public SimpleStringProperty apellidoPasajeroProperty() { return apellidoPasajero; }

    public String getVueloFecha() { return vueloFecha.get(); }
    public SimpleStringProperty vueloFechaProperty() { return vueloFecha; }

    public String getPasajeroTipoDocumento() { return pasajeroTipoDocumento.get(); }
    public SimpleStringProperty pasajeroTipoDocumentoProperty() { return pasajeroTipoDocumento; }

    public String getNumeroDocumentoPasajero() { return numeroDocumentoPasajero.get(); }
    public SimpleStringProperty numeroDocumentoPasajeroProperty() { return numeroDocumentoPasajero; }

    public String getEmailPasajero() { return emailPasajero.get(); }
    public SimpleStringProperty emailPasajeroProperty() { return emailPasajero; }

    public String getTelefonoPasajero() { return telefonoPasajero.get(); }
    public SimpleStringProperty telefonoPasajeroProperty() { return telefonoPasajero; }

    public String getVueloCodigo() { return vueloCodigo.get(); }
    public SimpleStringProperty vueloCodigoProperty() { return vueloCodigo; }

    public String getAerolineaNombre() { return aerolineaNombre.get(); }
    public SimpleStringProperty aerolineaNombreProperty() { return aerolineaNombre; }

    public String getAeropuertoOrigen() { return aeropuertoOrigen.get(); }
    public SimpleStringProperty aeropuertoOrigenProperty() { return aeropuertoOrigen; }

    public String getAeropuertoDestino() { return aeropuertoDestino.get(); }
    public SimpleStringProperty aeropuertoDestinoProperty() { return aeropuertoDestino; }

    public String getAsiento() { return asiento.get(); }
    public SimpleStringProperty asientoProperty() { return asiento; }

    public String getFechaReserva() { return fechaReserva.get(); }
    public SimpleStringProperty fechaReservaProperty() { return fechaReserva; }

    public String getFechaNacimiento() { return fechaNacimientoPasajero.get(); }
    public SimpleStringProperty fechaNacimientoPasajeroProperty() { 
        return fechaNacimientoPasajero;
    }
}


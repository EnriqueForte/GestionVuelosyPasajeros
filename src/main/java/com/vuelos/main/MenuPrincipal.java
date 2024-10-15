package com.vuelos.main;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import com.vuelos.aerolineas.Aerolinea;
import com.vuelos.aeropuertos.Aeropuerto;
import com.vuelos.dao.aerolineas.AerolineaDAO;
import com.vuelos.dao.aeropuertos.aeropuertosDAO;
import com.vuelos.dao.pasajero.PasajeroDAO;
import com.vuelos.dao.tipoDocumento.tipoDocumentoDAO;
import com.vuelos.dao.viajes.ViajeDAO;
import com.vuelos.dao.vuelo.VueloDAO;
import com.vuelos.db.DBConnection;
import com.vuelos.model.pasajero;
import com.vuelos.tipoDocumento.tipoDocumento;
import com.vuelos.viajes.Viaje;
import com.vuelos.vuelo.Vuelo;

public class MenuPrincipal {
	
    public static void main(String[] args) throws SQLException {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Seleccione una opción:");
            System.out.println("1. Insertar Pasajero");
            System.out.println("2. Insertar Aeropuerto");
            System.out.println("3. Insertar Aerolínea");
            System.out.println("4. Insertar Tipo de Documento");
            System.out.println("5. Insertar Vuelo");
            System.out.println("6. Insertar Viaje");
            System.out.println("7. Lista de Pasajeros");
            System.out.println("8. Eliminar Pasajero");
            System.out.println("9. Lista de Viajes Totales BBDD");
            System.out.println("10.Lista de Viajes Por Documento");
            System.out.println("0. Salir");

            int opcion = scanner.nextInt();
            scanner.nextLine();  // Limpiar buffer

            switch (opcion) {
                case 1:
                	insertarPasajero(scanner); 
                    break;
                case 2:
                    insertarAeropuerto(scanner);
                    break;
                case 3:
                    insertarAerolinea(scanner);
                    break;
                case 4:
                    insertarTipoDocumento(scanner);
                    break;
                case 5:
                    insertarVuelo(scanner);
                    break;
                case 6:
                    insertarViaje(scanner);
                    break;
                case 7:
                	listarPasajeros();
                	break;
                case 8:
                	eliminarPasajero(scanner);
                	break;
                case 9:
                	listarViajes();
                case 10:
                	obtenerViajesPorDocumento(scanner);
                case 0:
                    System.out.println("Saliendo...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Opción no válida.");
            }
        }
    }

    private static void insertarPasajero(Scanner scanner) {
        pasajero pasajero = new pasajero();
        PasajeroDAO pasajeroDAO = new PasajeroDAO();
        tipoDocumentoDAO tipoDocumentoDAO = new tipoDocumentoDAO();
        
        
        // Mostrar tipos de documento disponibles
        System.out.println("Tipos de documento disponibles:");
        List<tipoDocumento> tiposDocumentos = tipoDocumentoDAO.obtenerTodosLosTipos();
        for (tipoDocumento tipo : tiposDocumentos) {
            System.out.println(tipo.getDescripcion());
        }

        tipoDocumento tipoSeleccionado = null;
        // Bucle para solicitar que el usuario ingrese un nombre de tipo de documento válido
        while (tipoSeleccionado == null) {
            // Permitir que el usuario ingrese el nombre del tipo de documento
            System.out.println("Ingrese el nombre del tipo de documento:");
            String nombreTipoDocumento = scanner.nextLine();

            // Buscar el tipo de documento por nombre
            tipoSeleccionado = tipoDocumentoDAO.obtenerPorNombre(nombreTipoDocumento);

            if (tipoSeleccionado == null) {
                System.out.println("Tipo de documento no válido. Intente de nuevo.");
            }
        }

        // Asignar el ID del tipo de documento correctamente identificado
        pasajero.setTipoDocumentoId(tipoSeleccionado.getId());
        
        //Datos del pasajero

        System.out.println("Nombre del pasajero:");
        pasajero.setNombre(scanner.nextLine());

        System.out.println("Apellido del pasajero:");
        pasajero.setApellido(scanner.nextLine());

        System.out.println("Fecha de nacimiento (YYYY-MM-DD):");
        pasajero.setFechaNacimiento(scanner.nextLine());

        System.out.println("Número de documento:");
        pasajero.setNumeroDocumento(scanner.nextLine());

        System.out.println("Email del pasajero:");
        pasajero.setEmail(scanner.nextLine());

        System.out.println("Teléfono del pasajero:");
        pasajero.setTelefono(scanner.nextLine());

        pasajeroDAO.insertarPasajero(pasajero);
        System.out.println("Pasajero insertado con éxito.");       
    }
    
    //Metodo para listar los pasajeros
    private static void listarPasajeros() {
    	PasajeroDAO pasajeroDAO = new PasajeroDAO();
    	List<pasajero> pasajeros = pasajeroDAO.obtenerTodosLosPasajeros();
	
    	if (pasajeros.isEmpty()) {
		System.out.println("No hay pasajeros registrados");
    		}else {
    			System.out.println("Listado de Pasajeros:");
	    			for (pasajero pasajero : pasajeros) {
			            System.out.println("ID: " + pasajero.getId());
			            System.out.println("Nombre: " + pasajero.getNombre());
			            System.out.println("Apellido: " + pasajero.getApellido());
			            System.out.println("Fecha de Nacimiento: " + pasajero.getFechaNacimiento());
			            System.out.println("Tipo de Documento ID: " + pasajero.getTipoDocumentoId());
			            System.out.println("Número de Documento: " + pasajero.getNumeroDocumento());
			            System.out.println("Email: " + pasajero.getEmail());
			            System.out.println("Teléfono: " + pasajero.getTelefono());
			            System.out.println("---------------------------");            
		}
	}
}
	//Método Borrar pasajero por ID
    private static void eliminarPasajero(Scanner scanner) {
    	PasajeroDAO pasajeroDAO = new PasajeroDAO();
    	
    	//Listar pasajeros antes de eliminar
    	listarPasajeros();
    	
    	System.out.println("Ingrese el ID del pasajero que desea eliminar:");
    	int id = scanner.nextInt();
    	
    	pasajeroDAO.eliminarPasajeroPorId(id);
    	
    }


    private static void insertarAeropuerto(Scanner scanner) {
        Aeropuerto aeropuertos = new Aeropuerto();
        aeropuertosDAO aeropuertoDAO = new aeropuertosDAO();

        System.out.println("Nombre del aeropuerto:");
        aeropuertos.setNombre(scanner.nextLine());

        System.out.println("Código del aeropuerto (por ejemplo, 'LAX'):");
        aeropuertos.setCodigo(scanner.nextLine());

        System.out.println("Ciudad del aeropuerto:");
        aeropuertos.setCiudad(scanner.nextLine());

        System.out.println("País del aeropuerto:");
        aeropuertos.setPais(scanner.nextLine());

        aeropuertoDAO.insertarAeropuerto(aeropuertos);
        System.out.println("Aeropuerto insertado con éxito.");
    }   

    private static void insertarAerolinea(Scanner scanner) {
        Aerolinea aerolinea = new Aerolinea();
        AerolineaDAO aerolineaDAO = new AerolineaDAO();

        System.out.println("Nombre de la aerolínea:");
        aerolinea.setNombre(scanner.nextLine());

        System.out.println("Código de la aerolínea:");
        aerolinea.setCodigo(scanner.nextLine());

        aerolineaDAO.insertarAerolinea(aerolinea);
        System.out.println("Aerolínea insertada con éxito.");
    }
    
    public static void mostrarAerolíneas() throws SQLException {
    	Connection conn = DBConnection.getConnection(); // Tu método para obtener la conexión
    	String sql = "SELECT ID, nombre, codigo FROM aerolineas"; // Consulta SQL

    	try {
    	    PreparedStatement stmt = conn.prepareStatement(sql); // Preparar la sentencia
    	    ResultSet rs = stmt.executeQuery(); // Ejecutar la consulta

    	    // Mostrar los resultados
    	    while (rs.next()) {
    	        System.out.println(rs.getInt("ID") + ": " + rs.getString("nombre")+ " (Código: " + rs.getString("codigo") + ")");
    	    }

    	    // Cerrar los recursos
    	    rs.close();
    	    stmt.close();
    	    conn.close();
    	} catch (SQLException e) {
    	    e.printStackTrace();}
    }


    private static void insertarTipoDocumento(Scanner scanner) {
        tipoDocumento tipoDocumento = new tipoDocumento();
        tipoDocumentoDAO tipoDocumentoDAO = new tipoDocumentoDAO();

        System.out.println("Nombre del tipo de documento:");
        tipoDocumento.setDescripcion(scanner.nextLine());

        tipoDocumentoDAO.insertarTipoDocumento(tipoDocumento);
        System.out.println("Tipo de documento insertado con éxito.");
    }

    private static void insertarVuelo(Scanner scanner) throws SQLException {
    	
    	    Vuelo vuelo = new Vuelo();
    	    VueloDAO vueloDAO = new VueloDAO();
    	    
    	    // Mostrar aerolíneas disponibles
    	    mostrarAerolíneas();

    	    System.out.println("ID de la aerolínea:");
    	    vuelo.setAerolinea_id(scanner.nextLine());
    	    
    	    System.out.println("Código del vuelo (por ejemplo, 'AA123'):");
    	    vuelo.setCodigo_vuelo(scanner.nextLine());

    	    // Pedir y validar aeropuerto de origen
    	    List<Aeropuerto> aeropuertosOrigen;
    	    while (true) {
    	        System.out.println("Ingrese el país para filtrar aeropuertos de origen:");
    	        String paisOrigen = scanner.nextLine();
    	        aeropuertosOrigen = aeropuertosDAO.obtenerAeropuertosPorPais(paisOrigen);

    	        if (!aeropuertosOrigen.isEmpty()) {
    	            // Mostrar los aeropuertos de origen filtrados
    	            System.out.println("Aeropuertos disponibles en " + paisOrigen + ":");
    	            for (Aeropuerto aeropuerto : aeropuertosOrigen) {
    	                System.out.println(aeropuerto.getId() + ": " + aeropuerto.getNombre() + " (Código: " + aeropuerto.getCodigo() + ")");
    	            }
    	            break;  // Si hay aeropuertos, salir del bucle
    	        } else {
    	            System.out.println("No se encontraron aeropuertos en el país seleccionado. Inténtelo nuevamente.");
    	        }
    	    }

    	    // Seleccionar aeropuerto de origen
    	    System.out.println("ID del aeropuerto de origen:");
    	    vuelo.setAeropuerto_origen_id(scanner.nextInt());
    	    scanner.nextLine();  // Limpiar buffer

    	    // Pedir y validar aeropuerto de destino
    	    List<Aeropuerto> aeropuertosDestino;
    	    while (true) {
    	        System.out.println("Ingrese el país para filtrar aeropuertos de destino:");
    	        String paisDestino = scanner.nextLine();
    	        aeropuertosDestino = aeropuertosDAO.obtenerAeropuertosPorPais(paisDestino);

    	        if (!aeropuertosDestino.isEmpty()) {
    	            // Mostrar los aeropuertos de destino filtrados
    	            System.out.println("Aeropuertos disponibles en " + paisDestino + ":");
    	            for (Aeropuerto aeropuerto : aeropuertosDestino) {
    	                System.out.println(aeropuerto.getId() + ": " + aeropuerto.getNombre() + " (Código: " + aeropuerto.getCodigo() + ")");
    	            }
    	            break;  // Si hay aeropuertos, salir del bucle
    	        } else {
    	            System.out.println("No se encontraron aeropuertos en el país seleccionado. Inténtelo nuevamente.");
    	        }
    	    }

    	    // Seleccionar aeropuerto de destino con validación para evitar que sea el mismo que el origen
    	    while (true) {
    	        System.out.println("ID del aeropuerto de destino:");
    	        int aeropuertoDestinoId = scanner.nextInt();
    	        scanner.nextLine();  // Limpiar buffer

    	        // Verificar que el aeropuerto de destino no sea igual al de origen
    	        if (aeropuertoDestinoId != vuelo.getAeropuerto_origen_id()) {
    	            vuelo.setAeropuerto_destino_id(aeropuertoDestinoId);
    	            break; // Salir del bucle si los IDs son diferentes
    	        } else {
    	            System.out.println("El aeropuerto de destino no puede ser el mismo que el de origen. Intente de nuevo.");
    	        }
    	    }

    	    // Ingreso de fecha y horas del vuelo
    	    System.out.println("Fecha del vuelo (YYYY-MM-DD):");
    	    vuelo.setFecha_vuelo(scanner.nextLine());

    	    System.out.println("Hora de salida (HH:MM:SS):");
    	    vuelo.setHora_salida(scanner.nextLine());

    	    System.out.println("Hora de llegada (HH:MM:SS):");
    	    vuelo.setHora_llegada(scanner.nextLine());

    	    // Insertar vuelo
    	    vueloDAO.insertarVuelo(vuelo);
    	    System.out.println("Vuelo insertado con éxito.");
    	}

        
      
    private static void insertarViaje(Scanner scanner) {
        Viaje viaje = new Viaje();
        ViajeDAO viajeDAO = new ViajeDAO();
    	//Listar pasajeros antes de insertar        
    	listarPasajeros();
    	System.out.println();

        System.out.println("Id del pasajero:");
        viaje.setPasajeroId(scanner.nextInt());
        scanner.nextLine();  // Limpiar buffer

        System.out.println("ID del vuelo:");
        viaje.setVueloId(scanner.nextInt());
        scanner.nextLine();  // Limpiar buffer

        System.out.println("Asiento (por ejemplo, 12A):");
        viaje.setAsiento(scanner.nextLine());

        System.out.println("Fecha de reserva (YYYY-MM-DD):");
        viaje.setFechaReserva(scanner.nextLine());

        viajeDAO.insertarViaje(viaje);
        System.out.println("Viaje insertado con éxito.");
    }
    
    //Listado de viajes
    public static void listarViajes() {
        ViajeDAO viajeDAO = new ViajeDAO();  // Crear una instancia del DAO
        try {
            List<Viaje> viajes = viajeDAO.listarViajes();  // Llamar al método DAO
            
            // Mostrar los resultados de la lista de viajes
            System.out.println("Viajes Registrados en la BBDD: ");
            System.out.println("-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*");
            for (Viaje viaje : viajes) {
                System.out.println("ID del Viaje: " + viaje.getId());
                System.out.println("Pasajero ID: " + viaje.getPasajeroId());
                System.out.println("Nombre del Pasajero: " + viaje.getPasajeroNombre());  // Añadir getter para nombre               
                System.out.println("Tipo de Documento: " + viaje.getPasajeroTipoDocumento()); // Mostrar tipo de documento
                System.out.println("Número de Documento: " + viaje.getPasajeronumeroDocumento());
                System.out.println("Vuelo ID: " + viaje.getVueloId());
                System.out.println("Código del Vuelo: " + viaje.getVueloCodigo());  // Añadir getter para código
                System.out.println("Fecha del Vuelo: " + viaje.getFechaReserva());
                System.out.println("Asiento: " + viaje.getAsiento());
                System.out.println("-------------------------");
            }
        } catch (SQLException e) {
            System.out.println("Error al listar los viajes: " + e.getMessage());
        }
    }
    
    //Listado de viajes por documento
    private static void obtenerViajesPorDocumento(Scanner scanner) throws SQLException {
        ViajeDAO viajeDAO = new ViajeDAO();
        String numeroDocumento;
        
        while(true) {
        	System.out.println("Ingrese el número de documento o escriba 'salir' para finalizar:");
            numeroDocumento = scanner.nextLine();
            
         // Si el usuario escribe "salir", se sale del bucle"
            if (numeroDocumento.equalsIgnoreCase("salir")) {
            	System.out.println("Saliendo de la consulta viajes por documento");
            	break;
           	}   
                
        List<Viaje> viajes = viajeDAO.obtenerViajesPorDocumento(numeroDocumento);
        
        if (viajes.isEmpty()) {
            System.out.println("No se encontraron viajes para el documento ingresado.");
        } else {
            for (Viaje viaje : viajes) {
                System.out.println("ID del Viaje: " + viaje.getId());
                System.out.println("Nombre del Pasajero: " + viaje.getPasajeroNombre());
                System.out.println("Apellido del Pasajero: " + viaje.getPasajeroApellido()); // Nuevo
                System.out.println("Tipo de Documento: " + viaje.getPasajeroTipoDocumento());
                System.out.println("Número de Documento: " + viaje.getPasajeronumeroDocumento());
                System.out.println("Código del Vuelo: " + viaje.getVueloCodigo());
                System.out.println("Fecha del Vuelo: " + viaje.getVueloFecha());
                System.out.println("Hora de Salida: " + viaje.getHoraSalida()); // Nuevo
                System.out.println("Hora de Llegada: " + viaje.getHoraLlegada()); // Nuevo
                System.out.println("Aeropuerto de Origen: " + viaje.getAeropuertoOrigen()); // Nuevo
                System.out.println("Aeropuerto de Destino: " + viaje.getAeropuertoDestino()); // Nuevo
                System.out.println("Aerolínea: " + viaje.getAerolineaNombre()); // Nuevo
                System.out.println("Asiento: " + viaje.getAsiento());
                System.out.println("--------------------------");
            }
        }
        
        System.out.println(); //salto para mejor legibilidad
    }
  }
}

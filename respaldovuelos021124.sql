-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 02-11-2024 a las 19:12:33
-- Versión del servidor: 10.4.32-MariaDB
-- Versión de PHP: 8.0.30

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `vuelos`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `aerolineas`
--

CREATE TABLE `aerolineas` (
  `id` int(11) NOT NULL,
  `nombre` varchar(50) NOT NULL,
  `codigo` varchar(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `aerolineas`
--

INSERT INTO `aerolineas` (`id`, `nombre`, `codigo`) VALUES
(1, 'Aerolineas Argentinas', 'AR'),
(2, 'Iberia', 'IB'),
(3, 'Volotea', 'V7'),
(4, 'LATAM Airlines Argentina', '4M');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `aeropuertos`
--

CREATE TABLE `aeropuertos` (
  `id` int(11) NOT NULL,
  `nombre` varchar(75) DEFAULT NULL,
  `codigo` varchar(4) DEFAULT NULL,
  `ciudad` varchar(35) DEFAULT NULL,
  `pais` varchar(22) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;

--
-- Volcado de datos para la tabla `aeropuertos`
--

INSERT INTO `aeropuertos` (`id`, `nombre`, `codigo`, `ciudad`, `pais`) VALUES
(1, 'Aeropuerto de Jalalabad', 'JAA', 'Jalalabad', 'Afganistán'),
(2, 'Aeropuerto de Jersey', 'JER', 'Saint Helier', 'Reino Unido'),
(3, 'Aeropuerto Internacional John F. Kennedy', 'JFK', 'Nueva York', 'Estados Unidos'),
(4, 'Aeropuerto Nacional de Kálimnos', 'JKL', 'Pothia (en)', 'Grecia'),
(5, 'Aeropuerto de Jessore', 'JSR', 'Jessore (en)', 'Bangladés'),
(6, 'Aeropuerto Internacional Gobernador Horacio Guzmán', 'JUJ', 'San Salvador de Jujuy', 'Argentina'),
(7, 'Aeropuerto de Albacete', 'ABC', 'Albacete', 'España'),
(8, 'Base Aérea de Los Llanos', 'ABC', 'Albacete', 'España'),
(9, 'Aeropuerto de Lanzarote César Manrique', 'ACE', 'Lanzarote', 'España'),
(10, 'Aeroparque Jorge Newbery', 'AEP', 'Buenos Aires', 'Argentina'),
(11, 'Aeropuerto Internacional Suboficial Ayudante Santiago Germano', 'AFA', 'San Rafael', 'Argentina'),
(12, 'Aeropuerto de Málaga-Costa del Sol', 'AGP', 'Málaga', 'España'),
(13, 'Aeropuerto de Alicante-Elche Miguel Hernández', 'ALC', 'Alicante', 'España'),
(14, 'Aeropuerto de Ámsterdam-Schiphol', 'AMS', 'Ámsterdam', 'Países Bajos'),
(15, 'Aeropuerto Internacional Rick Husband de Amarillo', 'AMA', 'Amarillo', 'Estados Unidos'),
(16, 'Aeropuerto Andrés Sabella', 'ANF', 'Antofagasta', 'Chile'),
(17, 'Aeropuerto Internacional de Paso de los Libres', 'AOL', 'Paso de los Libres', 'Argentina'),
(18, 'Aeropuerto Internacional Chacalluta', 'ARI', 'Arica', 'Chile'),
(19, 'Aeropuerto de Estocolmo-Arlanda', 'ARN', 'Estocolmo', 'Suecia'),
(20, 'Aeropuerto Internacional Silvio Pettirossi', 'ASU', 'Asunción', 'Paraguay'),
(21, 'Aeropuerto Internacional Eleftherios Venizelos', 'ATH', 'Atenas', 'Grecia'),
(22, 'Aeropuerto Internacional Reina Beatrix', 'AUA', 'Oranjestad', 'Países Bajos'),
(23, 'Aeródromo Balmaceda', 'BBA', 'Balmaceda', 'Chile'),
(24, 'Aeropuerto de Barcelona-El Prat', 'BCN', 'Barcelona', 'España'),
(25, 'Aeropuerto Comandante Espora', 'BHI', 'Bahía Blanca', 'Argentina'),
(26, 'Aeropuerto de Bamiyán', 'BIN', 'Bamiyán', 'Afganistán'),
(27, 'Aeropuerto de Bilbao', 'BIO', 'Bilbao', 'España'),
(28, 'Aeropuerto de Badajoz', 'BJZ', 'Badajoz, Cáceres y Alto Alentejo', 'España'),
(29, 'Aeropuerto de Burdeos-Mérignac', 'BOD', 'Burdeos', 'Francia'),
(30, 'Aeropuerto Internacional El Dorado', 'BOG', 'Bogotá', 'Colombia'),
(31, 'Base Aérea de Bagram', 'BPM', 'Bagram', 'Afganistán'),
(32, 'Aeropuerto Internacional Teniente Luis Candelaria', 'BRC', 'San Carlos de Bariloche', 'Argentina'),
(33, 'Aeropuerto de Basilea-Mulhouse-Friburgo', 'BSL​', 'Basilea, Mulhouse, Friburgo', 'Francia'),
(34, 'Aeropuerto de Bost', 'BST', 'Lashkar Gah', 'Afganistán'),
(35, 'Aeropuerto de Budapest-Ferenc Liszt', 'BUD', 'Budapest', 'Hungría'),
(36, 'Base Aérea de Beja', 'BYJ', 'Beja', 'Portugal'),
(37, 'Aeropuerto Internacional de Kabul', 'KBL', 'Kabul', 'Afganistán'),
(38, 'Aeropuerto Internacional de Kandahar', 'KDH', 'Kandahar', 'Afganistán'),
(39, 'Aeropuerto Internacional de Keflavík', 'KEF', 'Reikiavik', 'Islandia'),
(40, 'Aeropuerto de Kaliningrado-Jrabrovo', 'KGD', 'Kaliningrado', 'Rusia'),
(41, 'Aeropuerto Internacional Quatro de Fevereiro', 'LAD', 'Luanda', 'Angola'),
(42, 'Aeropuerto Internacional Harry Reid', 'LAS', 'Las Vegas', 'Estados Unidos'),
(43, 'Aeropuerto Internacional de Los Ángeles', 'LAX', 'Los Ángeles', 'Estados Unidos'),
(44, 'Aeropuerto Internacional Golosón', 'LCE', 'La Ceiba', 'Honduras'),
(45, 'Aeropuerto de Almería', 'LEI', 'Almería', 'España'),
(46, 'Aeropuerto de Andorra-La Seu', 'LEU', 'Seo de Urgel, Andorra la Vieja​', 'España'),
(47, 'Aeropuerto de Lieja', 'LGG', 'Lieja', 'Bélgica'),
(48, 'Aeropuerto Internacional Comodoro Ricardo Salomón', 'LGS', 'Malargüe', 'Argentina'),
(49, 'Aeropuerto de Gatwick', 'LGW', 'Londres', 'Reino Unido'),
(50, 'Aeropuerto de Heathrow', 'LHR', 'Londres', 'Reino Unido'),
(51, 'Aeropuerto Internacional Jorge Chávez', 'LIM', 'Callao​, Lima', 'Perú'),
(52, 'Aeropuerto de Guanacaste', 'LIR', 'Guanacaste', 'Costa Rica'),
(53, 'Aeropuerto de Portela', 'LIS', 'Lisboa', 'Portugal'),
(54, 'Aeropuerto de Londres-Luton', 'LTN', 'Londres', 'Reino Unido'),
(55, 'Aeropuerto Brigadier Mayor César Raúl Ojeda', 'LUQ', 'Ciudad de San Luis', 'Argentina'),
(56, 'Aeropuerto Adolfo Suárez Madrid-Barajas', 'MAD', 'Madrid', 'España'),
(57, 'Aeropuerto de Monte Caseros', 'MCS', 'Monte Caseros', 'Argentina'),
(58, 'Aeropuerto Internacional José María Cordova', 'MDE', 'Rionegro, Medellín', 'Colombia'),
(59, 'Aeropuerto Internacional Astor Piazzolla', 'MDQ', 'Mar del Plata', 'Argentina'),
(60, 'Aeropuerto Internacional de Carrasco', 'MVD', 'Montevideo', 'Uruguay'),
(61, 'Aeropuerto Internacional Gobernador Francisco Gabrielli', 'MDZ', 'Ciudad de Mendoza', 'Argentina'),
(62, 'Aeropuerto de Manta', 'MEC', 'Manta', 'Ecuador'),
(63, 'Aeropuerto Internacional Augusto C. Sandino', 'MGA', 'Managua', 'Nicaragua'),
(64, 'Aeropuerto Internacional Mariano Escobedo', 'MTY', 'Monterrey', 'México'),
(65, 'Aeropuerto Internacional Benito Juárez', 'MEX', 'Ciudad de México', 'México'),
(66, 'Aeropuerto del Iberá', 'MDX', 'Mercedes', 'Argentina'),
(67, 'Aeropuerto Internacional de Macao', 'MFM', 'Ciudad de Macao', 'China'),
(68, 'Aeropuerto Internacional de Miami', 'MIA', 'Miami', 'Estados Unidos'),
(69, 'Aeropuerto Urbano Charles B. Wheeler', 'MKC', 'Kansas City', 'Estados Unidos'),
(70, 'Aeropuerto de Basilea-Mulhouse-Friburgo', 'MLH​', 'Basilea, Mulhouse, Friburgo', 'Francia'),
(71, 'Aeropuerto de Melilla', 'MLN', 'Melilla', 'España'),
(72, 'Base Aérea de Monte Agradable', 'MPN', 'Isla Soledad', 'Reino Unido​'),
(73, 'Aeropuerto Internacional de Múnich-Franz Josef Strauss', 'MUC', 'Munich', 'Alemania'),
(74, 'Aeropuerto de Milán-Malpensa', 'MXP', 'Milán', 'Italia'),
(75, 'Aeropuerto de Mazar-e Sarif', 'MZR', 'Mazar-e Sarif', 'Afganistán'),
(76, 'Orlando International Airport', 'MCO', 'Orlando', 'Estados Unidos'),
(77, 'Aeropuerto de Nápoles-Capodichino', 'NAP', 'Nápoles', 'Italia'),
(78, 'Aeropuerto de Nicosia', 'NIC', 'Nicosia', 'Chipre​'),
(79, 'Aeropuerto Internacional Felipe Ángeles', 'NLU', 'Ciudad de México', 'México'),
(80, 'Aeropuerto de la Isla Norfolk (en)', 'NLK', 'Kingston', 'Australia'),
(81, 'Aeropuerto Internacional de Narita Jasiko', 'NRT', 'Área del Gran Tokio', 'Japón'),
(82, 'Aeropuerto de Francisco Sá Carneiro', 'OPO', 'Oporto', 'Portugal'),
(83, 'Aero Club Orán', 'ORA', 'San Ramón de la Nueva Orán', 'Argentina'),
(84, 'Aeropuerto Internacional O\'Hare', 'ORD', 'Chicago', 'Estados Unidos'),
(85, 'Aeropuerto de Cork', 'ORK', 'Cork', 'Irlanda'),
(86, 'Aeropuerto de París-Orly', 'ORY', 'París', 'Francia'),
(87, 'Aeropuerto Dr. Diego Nicolás Díaz Colodrero', 'OYA', 'Goya', 'Argentina'),
(88, 'Aeropuerto Internacional La Tierra de Dios', 'PBR', 'Puerto Barrios', 'Guatemala'),
(89, 'Aeropuerto Internacional de Punta del Este', 'PDP', 'Maldonado y Punta del Este', 'Uruguay'),
(90, 'Aeropuerto João Paulo II', 'PDL', 'Isla de São Miguel', 'Portugal'),
(91, 'Aeropuerto Internacional de Filadelfia', 'PHL', 'Filadelfia', 'Estados Unidos'),
(92, 'Aeropuerto de Pico', 'PIX', 'Isla del Pico', 'Portugal'),
(93, 'Aeropuerto Doctor Fuster', 'PJC', 'Pedro Juan Caballero (Paraguay)', 'Paraguay'),
(94, 'Aeropuerto de Pamplona', 'PNA', 'Noáin', 'España'),
(95, 'Aeropuerto General Justo José de Urquiza', 'PRA', 'Paraná', 'Argentina'),
(96, 'Aeropuerto de Presidencia Roque Sáenz Peña', 'PRQ', 'Presidencia Roque Sáenz Peña', 'Argentina'),
(97, 'Aeropuerto de Puerto Argentino/Stanley', 'PSY', 'Puerto Argentino/Stanley', 'Reino Unido'),
(98, 'Aeropuerto Internacional de Tocumen', 'PTY', 'Ciudad de Panamá', 'Panamá'),
(99, 'Aeropuerto Internacional de Punta Cana', 'PUJ', 'Punta Cana', 'República Dominicana'),
(100, 'Aeropuerto Internacional Presidente Carlos Ibáñez del Campo', 'PUQ', 'Punta Arenas', 'Chile'),
(101, 'Aeropuerto de Porto Santo', 'PXO', 'Isla de Porto Santo', 'Portugal'),
(102, 'Aeropuerto Internacional de Györ-Pér', 'QGY', 'Györ', 'Hungría'),
(103, 'Aeródromo de la Independencia', 'QRC', 'Rancagua', 'Chile'),
(104, 'Aeropuerto de Sabadell', 'QSA', 'Sabadell', 'España'),
(105, 'Aeropuerto de Marrakech-Menara', 'RAK', 'Marrakech', 'Marruecos'),
(106, 'Aeropuerto de Rabat-Salé', 'RBA', 'Rabat', 'Marruecos'),
(107, 'Aeropuerto Internacional de Resistencia', 'RES', 'Ciudad de Resistencia', 'Argentina'),
(108, 'Aeropuerto de Reus', 'REU', 'Reus, Tarragona', 'España'),
(109, 'Aeropuerto Internacional de Reynosa', 'REX', 'Reynosa', 'Mexico'),
(110, 'Aeropuerto Internacional Gob. Ramón Trejo Noel', 'RGA', 'Río Grande', 'Argentina'),
(111, 'Aeropuerto Internacional Termas de Río Hondo', 'RHD', 'Termas de Río Hondo', 'Argentina'),
(112, 'Aeropuerto Internacional Valle del Conlara', 'RLO', 'Merlo', 'Argentina'),
(113, 'Aeropuerto Internacional de la Región de Murcia', 'RMU', 'Región de Murcia', 'España'),
(114, 'Aeropuerto Internacional Rosario Islas Malvinas', 'ROS', 'Rosario', 'Argentina'),
(115, 'Aeropuerto Sir Gaëtan Duval', 'RRG', 'Rodrigues', 'Mauricio'),
(116, 'Aeropuerto de Santa Rosa', 'RSA', 'Ciudad de Santa Rosa', 'Argentina'),
(117, 'Aeropuerto Internacional Juan Manuel Gálvez', 'RTB', 'Roatán, Islas de la Bahía', 'Honduras'),
(118, 'Aeropuerto Internacional Rey Khalid', 'RUH', 'Riad', 'Arabia Saudita'),
(119, 'Aeropuerto Internacional de El Salvador San Óscar Arnulfo Romero y Galdámez', 'SAL', 'San Salvador', 'El Salvador'),
(120, 'Aeropuerto Internacional Ramon Villeda Morales', 'SAP', 'San Pedro Sula', 'Honduras'),
(121, 'Aeropuerto Internacional de Sibiu', 'SBZ', 'Sibiu', 'Rumania'),
(122, 'Aeropuerto Internacional Antonio Maceo y Grajales', 'SCU', 'Santiago de Cuba', 'Cuba'),
(123, 'Aeropuerto Internacional Arturo Merino Benítez', 'SCL', 'Santiago de Chile', 'Chile'),
(124, 'Aeropuerto Vicecomodoro Ángel de la Paz Aragonés', 'SDE', 'Ciudad de Santiago del Estero', 'Argentina'),
(125, 'Aeropuerto Internacional José Francisco Peña Gómez', 'SDQ', 'Santo Domingo', 'República Dominicana'),
(126, 'Aeropuerto Internacional de Sacramento', 'SFM', 'Sacramento', 'Estados Unidos'),
(127, 'Aeropuerto de Sauce Viejo', 'SFN', 'Sauce Viejo', 'Argentina'),
(128, 'Aeropuerto Interenacional de San Francisco', 'SFO', 'San Francisco', 'Estados Unidos'),
(129, 'Aeropuerto Internacional de Singapur-Changi', 'SIN', 'Singapur', 'Singapur'),
(130, 'Aeropuerto Internacional Juan Santamaría', 'SJO', 'San José', 'Costa Rica'),
(131, 'Aeropuerto de São Jorge', 'SJZ', 'Isla de São Jorge', 'Portugal'),
(132, 'Aeropuerto Internacional Macedonia', 'SKG', 'Tesalónica', 'Grecia'),
(133, 'Aeropuerto Internacional de Salta Martín Miguel de Güemes', 'SLA', 'Ciudad de Salta', 'Argentina'),
(134, 'Aeropuerto de Salamanca', 'SLM', 'Salamanca', 'España'),
(135, 'Aeropuerto de Santa Maria', 'SMA', 'Isla de Santa Maria', 'Portugal'),
(136, 'Aeropuerto Internacional Abel Santamaría', 'SNU', 'Santa Clara', 'Cuba'),
(137, 'Aeropuerto Internacional de Lamezia Terme', 'SUF', 'Lamezia Terme', 'Italia'),
(138, 'Aeropuerto Internacional de Moscú-Sheremétievo', 'SVO', 'Moscú', 'Rusia'),
(139, 'Aeropuerto de Sevilla', 'SVQ', 'Sevilla', 'España'),
(140, 'Aeropuerto de Estrasburgo', 'SXB', 'Estrasburgo', 'Francia'),
(141, 'Aeropuerto Internacional Kingsford Smith', 'SYD', 'Sídney', 'Australia'),
(142, 'Aeropuerto de Lajes', 'TER', 'Isla Terceira', 'Portugal'),
(143, 'Aeródromo de Teruel', 'TEV', 'Teruel', 'España'),
(144, 'Aeropuerto de Tenerife Norte', 'TFN', 'Tenerife', 'España'),
(145, 'Aeropuerto de Tenerife Sur', 'TFS', 'Tenerife', 'España'),
(146, 'Aeropuerto de Podgorica', 'TGD', 'Montenegro', 'Montenegro'),
(147, 'Aeropuerto de Toncontín', 'TGU', 'Tegucigalpa', 'Honduras'),
(148, 'Aeropuerto de Berlín-Tempelhof', 'THF', 'Berlín', 'Alemania'),
(149, 'Aeropuerto de Toulouse Blagnac', 'TLS', 'Toulouse', 'Francia'),
(150, 'Aeropuerto Internacional Ben Gurión', 'TLV', 'Tel Aviv', 'Israel'),
(151, 'Aeropuerto Internacional de Taiwán Taoyuan', 'TPE', 'Taipéi', 'Taiwán​'),
(152, 'Aeropuerto de Trieste - Friuli Venezia Giulia', 'TRS', 'Trieste', 'Italia'),
(153, 'Aeropuerto Internacional de Astaná', 'TSE', 'Astaná', 'Kazajistán'),
(154, 'Aeropuerto General Enrique Mosconi/Tartagal', 'TTG', 'Tartagal', 'Argentina'),
(155, 'Aeropuerto Internacional de Túnez-Cartago', 'TUN', 'Túnez', 'Túnez'),
(156, 'Aeropuerto de Turku', 'TUR', 'Turku', 'Finlandia'),
(157, 'Aeropuerto Internacional Ing. Ambrosio Taravella', 'COR', 'Córdoba', 'Argentina'),
(158, 'Aeropuerto de Castellon', 'CDT', 'Castellon', 'España'),
(159, 'Aeropuerto Internacional de Jardines del Rey', 'CCC', 'Cayo Coco', 'Cuba'),
(160, 'Aeropuerto Carriel Sur', 'CCP', 'Concepción', 'Chile'),
(161, 'Aeropuerto Internacional de Maiquetía Simón Bolívar', 'CCS', 'Caracas', 'Venezuela'),
(162, 'Aeropuerto de París-Charles de Gaulle', 'CDG', 'París', 'Francia'),
(163, 'Aeropuerto Internacional de Colonia/Bonn Konrad Adenauer', 'CGN', 'Colonia, Bonn', 'Alemania'),
(164, 'Aeropuerto Internacional Bonilla Aragón', 'CLO', 'Cali', 'Colombia'),
(165, 'Aeropuerto Clorinda', 'CLX', 'Clorinda', 'Argentina'),
(166, 'Aeropuerto Internacional Mohammed V', 'CMN', 'Casablanca', 'Marruecos'),
(167, 'Aeropuerto Internacional Doctor Fernando Piragine Niveyro', 'CNQ', 'Ciudad de Corrientes', 'Argentina'),
(168, 'Aeropuerto Comodoro Pierrestegui', 'COC', 'Concordia', 'Argentina'),
(169, 'Aeropuerto de Ciudad Real', 'CQM', 'La Mancha', 'España'),
(170, 'Aeropuerto Coronel Felipe Varela', 'CTC', 'San Fernando del Valle de Catamarca', 'Argentina'),
(171, 'Aeropuerto Internacional Mariscal Lamar', 'CUE', 'Cuenca', 'Ecuador'),
(172, 'Aeropuerto Internacional General Roberto Fierro Villalobos', 'CUU', 'Chihuahua', 'México'),
(173, 'Aeropuerto de Corvo', 'CVU', 'Isla de Corvo', 'Portugal'),
(174, 'Aeropuerto Internacional Afonso Pena', 'CWB', 'Curitiba', 'Brasil'),
(175, 'Aeropuerto Internacional Mariscal Sucre', 'UIO', 'Tababela', 'Ecuador'),
(176, 'Aeropuerto Internacional Malvinas Argentinas', 'USH', 'Ushuaia', 'Argentina'),
(177, 'Aeropuerto de Curuzú Cuatiá', 'UZU', 'Curuzú Cuatiá', 'Argentina'),
(178, 'Aeropuerto de Viracopos', 'VCP', 'Sao Paulo', 'Brasil'),
(179, 'Aeropuerto Vitória da Conquista Glauber Rocha', 'VDC', 'Bahia', 'Brasil'),
(180, 'Aeropuerto Gobernador Edgardo Castello', 'VDM', 'Viedma', 'Argentina'),
(181, 'Aeropuerto de Viena-Schwechat', 'VIE', 'Viena', 'Austria'),
(182, 'Aeropuerto Internacional de Moscú-Vnúkovo', 'VKO', 'Moscú', '| Rusia'),
(183, 'Aeropuerto de Valencia', 'VLC', 'Manises', 'España'),
(184, 'Aeropuerto de Vigo', 'VGO', 'Vigo', 'España'),
(185, 'Aeropuerto de Villanubla', 'VLL', 'Valladolid', 'España'),
(186, 'Aeropuerto de Villa Reynolds', 'VME', 'Villa Mercedes', 'Argentina'),
(187, 'Aeropuerto Internacional Viru Viru', 'VVI', 'Santa Cruz de la Sierra', 'Bolivia'),
(188, 'Aeropuerto Internacional de Wellington', 'WLG', 'Wellington', 'Nueva Zelanda'),
(189, 'Aeropuerto de Jerez', 'XRY', 'Jerez', 'España'),
(190, 'Aeropuerto Internacional de Comayagua', 'XPL', 'Comayagua', 'Honduras'),
(191, 'Aeropuerto de Iqaluit', 'YFB', 'Iqaluit', 'Canadá'),
(192, 'Aeropuerto de Montreal-Saint Hubert', 'YHU', 'Montreal', 'Canadá'),
(193, 'Aeropuerto Internacional de Halifax-Stanfield', 'YHZ', 'Halifax', 'Canadá'),
(194, 'Aeropuerto Internacional de Ottawa', 'YOW', 'Ottawa', 'Canadá'),
(195, 'Aeropuerto Internacional Jean-Lesage de Quebec', 'YQB', 'Quebec', 'Canadá'),
(196, 'Aeropuerto de Resolute Bay', 'YRB', 'Resolute', 'Canadá'),
(197, 'Aeropuerto Internacional Pierre Elliott Trudeau', 'YUL', 'Montreal', 'Canadá'),
(198, 'Aeropuerto de Qikiqtarjuaq', 'YVM', 'Qikiqtarjuaq (en)', 'Canadá'),
(199, 'Aeropuerto Internacional de Vancouver', 'YVR', 'Vancouver', 'Canadá'),
(200, 'Aeropuerto Internacional James Armstrong Richardson', 'YWG', 'Winnipeg', 'Canadá'),
(201, 'Aeropuerto de Mont-Joli', 'YYY', 'Mont-Joli', 'Canadá'),
(202, 'Aeropuerto Internacional Toronto Pearson', 'YYZ', 'Toronto', 'Canadá'),
(203, 'Aeropuerto de Zagreb-Pleso', 'ZAG', 'Zagreb', 'Croacia'),
(204, 'Aeropuerto de Zaragoza', 'ZAZ', 'Zaragoza', 'España'),
(205, 'Aeropuerto Internacional James M. Cox-Dayton', '', 'Dayton', 'Estados Unidos'),
(206, 'Aeropuerto Internacional de Yerba-Zarzis', '', 'Yerba (Túnez)', 'Túnez'),
(207, 'Aeropuerto Internacional de Moscú-Domodédovo', '', 'Moscú', 'Rusia'),
(208, 'Aeropuerto Internacional Hamad', '', 'Doha', 'Catar'),
(209, 'Aeropuerto Internacional de Dubái', '', 'Dubái', 'Emiratos Árabes Unidos'),
(210, 'Aeropuerto de Basilea-Mulhouse-Friburgo', 'EAP​', 'Basilea, Mulhouse, Friburgo', 'Francia'),
(211, 'Aeropuerto de Edimburgo', 'EDI', 'Edimburgo', 'Reino Unido'),
(212, 'Aeropuerto Regional del Condado de Eagle', 'EGE', 'Eagle-Vail', 'Estados Unidos'),
(213, 'Aeropuerto de Eindhoven', 'EIN', 'Eindhoven', 'Países Bajos'),
(214, 'Aeropuerto El Palomar', 'EPA', 'Área metropolitana de Buenos Aires', 'Argentina'),
(215, 'Aeródromo Ricardo García Posada', 'ESR', 'El Salvador (Chile)', 'Chile'),
(216, 'Aeropuerto Internacional Ministro Pistarini', 'EZE', 'Ezeiza', 'Argentina'),
(217, 'Aeropuerto Teniente Amín Ayub González', 'ENO', 'Encarnacion (Paraguay)', 'Paraguay'),
(218, 'Aeropuerto Enrique Olaya Herrera', 'EOH', 'Medellín, Colombia', 'Colombia'),
(219, 'Aeropuerto de Faro', 'FAO', 'Faro', 'Portugal'),
(220, 'Aeropuerto de Fayzabad', 'FBD', 'Fayzabad', 'Afganistán'),
(221, 'Aeropuerto de Roma-Fiumicino', 'FCO', 'Roma', 'Italia'),
(222, 'Aeropuerto Internacional de San Fernando', 'FDO', 'San Fernando', 'Argentina'),
(223, 'Aeropuerto de Florencia', 'FLR', 'Florencia', 'Italia'),
(224, 'Aeropuerto de Flores', 'FLW', 'Isla de Flores', 'Portugal'),
(225, 'Aeropuerto Internacional de Formosa', 'FMA', 'Ciudad de Formosa', 'Argentina'),
(226, 'Aeropuerto Internacional Cristiano Ronaldo', 'FNC', 'Funchal', 'Portugal'),
(227, 'Aeropuerto de Fráncfort del Meno', 'FRA', 'Fráncfort del Meno', 'Alemania'),
(228, 'Aeropuerto Internacional Mundo Maya', 'FRS', 'Santa Elena de la Cruz', 'Guatemala'),
(229, 'Aeropuerto Internacional Pinto Martins', 'FOR', 'Fortaleza', 'Brasil'),
(230, 'Aeropuerto Internacional Comandante Armando Tola', 'FTE', 'El Calafate', 'Argentina'),
(231, 'Aeropuerto Internacional de Funafuti', 'FUN', 'Funafuti', 'Tuvalu'),
(232, 'Aeropuerto Internacional de Guadalajara', 'GDL', 'Guadalajara, Jalisco', 'México'),
(233, 'Aeropuerto de Gualeguaychú', 'GHU', 'Gualeguaychú', 'Argentina'),
(234, 'Aeropuerto de Gibraltar', 'GIB', 'Gibraltar', 'Reino Unido'),
(235, 'Aeropuerto de General Pico', 'GPO', 'General Pico', 'Argentina'),
(236, 'Aeropuerto Internacional de São Paulo-Guarulhos', 'GRU', 'São Paulo', 'Brasil'),
(237, 'Aeropuerto de Graciosa', 'GRW', 'Isla Graciosa', 'Portugal'),
(238, 'Aeropuerto de Granada', 'GRX', 'Granada', 'España'),
(239, 'Aeropuerto Internacional La Aurora', 'GUA', 'Ciudad de Guatemala', 'Guatemala'),
(240, 'Aeropuerto Internacional Jose Joaquin de Olmedo', 'GYE', 'Guayaquil', 'Ecuador'),
(241, 'Aeropuerto de Hannover', 'HAJ', 'Hannover', 'Alemania'),
(242, 'Aeropuerto de Hamburgo', 'HAM', 'Hamburgo', 'Alemania'),
(243, 'Aeropuerto Internacional José Martí', 'HAV', 'La Habana', 'Cuba'),
(244, 'Aeropuerto de Hubli', 'HBX', 'Hubballi, Dharwad', 'India'),
(245, 'Aeropuerto de Herat', 'HEA', 'Herat', 'Afganistán'),
(246, 'Aeropuerto de Helsinki-Vantaa', 'HEL', 'Helsinki', 'Finlandia'),
(247, 'Aeropuerto de Heligoland', 'HGL', 'Heligoland', 'Alemania'),
(248, 'Aeropuerto de Fráncfort-Hahn', 'HHN', 'Fráncfort​', 'Alemania'),
(249, 'Aeropuerto Internacional de Honiara', 'HIR', 'Honiara', 'Islas Salomón'),
(250, 'Aeropuerto Internacional de Hong Kong', 'HKG', 'Hong Kong', 'China'),
(251, 'Aeropuerto Internacional General Ignacio Pesqueira García', 'HMO', 'Hermosillo', 'México'),
(252, 'Aeropuerto Internacional de Haneda', 'HND', 'Tokio', 'Japón'),
(253, 'Aeropuerto Internacional Frank País', 'HOG', 'Holguín', 'Cuba'),
(254, 'Aeropuerto de Horta', 'HOR', 'Isla de Faial', 'Portugal'),
(255, 'Aeropuerto Internacional de Honolulu', 'HNL', 'Honolulu', 'Estados Unidos'),
(256, 'Aeropuerto William P. Hobby', 'HOU', 'Houston', 'Estados Unidos'),
(257, 'Aeropuerto Internacional Bahías de Huatulco', 'HUX', 'Huatulco, Oaxaca', 'México'),
(258, 'Aeropuerto de Ibiza', 'IBZ', 'Ibiza', 'España'),
(259, 'Aeropuerto Internacional de Incheon', 'ICN', 'Incheon, Seúl​', 'Corea del Sur'),
(260, 'Aeropuerto Internacional de Puerto Iguazú', 'IGR', 'Puerto Iguazú', 'Argentina'),
(261, 'Aeropuerto de Inverness', 'INV', 'Inverness', 'Reino Unido'),
(262, 'Aeropuerto Internacional Mataveri', 'IPC', 'Isla de Pascua', 'Chile'),
(263, 'Aeropuerto Internacional Diego Aracena', 'IQQ', 'Iquique', 'Chile'),
(264, 'Aeropuerto Capitán Vicente Almandos Almonacid', 'IRJ', 'Ciudad de La Rioja', 'Argentina'),
(265, 'Aeropuerto Internacional Atatürk', 'IST', 'Estambul', 'Turquía'),
(266, 'Aeropuerto de Ivalo', 'IVL', 'Ivalo', 'Finlandia');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `nacionalidades`
--

CREATE TABLE `nacionalidades` (
  `id` int(11) NOT NULL,
  `nombre` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `nacionalidades`
--

INSERT INTO `nacionalidades` (`id`, `nombre`) VALUES
(802, 'Afganistán'),
(803, 'Albania'),
(804, 'Alemania'),
(805, 'Andorra'),
(806, 'Angola'),
(807, 'Antigua y Barbuda'),
(808, 'Arabia Saudita'),
(809, 'Argelia'),
(810, 'Argentina'),
(811, 'Armenia'),
(812, 'Australia'),
(813, 'Austria'),
(814, 'Azerbaiyán'),
(815, 'Bahamas'),
(816, 'Bangladés'),
(817, 'Barbados'),
(818, 'Baréin'),
(819, 'Bélgica'),
(820, 'Belice'),
(821, 'Benín'),
(822, 'Bielorrusia'),
(823, 'Birmania'),
(824, 'Bolivia'),
(825, 'Bosnia y Herzegovina'),
(826, 'Botsuana'),
(827, 'Brasil'),
(828, 'Brunéi'),
(829, 'Bulgaria'),
(830, 'Burkina Faso'),
(831, 'Burundi'),
(832, 'Bután'),
(833, 'Cabo Verde'),
(834, 'Camboya'),
(835, 'Camerún'),
(836, 'Canadá'),
(837, 'Catar'),
(838, 'Chad'),
(839, 'Chile'),
(840, 'China'),
(841, 'Chipre'),
(842, 'Ciudad del Vaticano'),
(843, 'Colombia'),
(844, 'Comoras'),
(845, 'Corea del Norte'),
(846, 'Corea del Sur'),
(847, 'Costa de Marfil'),
(848, 'Costa Rica'),
(849, 'Croacia'),
(850, 'Cuba'),
(851, 'Dinamarca'),
(852, 'Dominica'),
(853, 'Ecuador'),
(854, 'Egipto'),
(855, 'El Salvador'),
(856, 'Emiratos Árabes Unidos'),
(857, 'Eritrea'),
(858, 'Eslovaquia'),
(859, 'Eslovenia'),
(860, 'España'),
(861, 'Estados Unidos'),
(862, 'Estonia'),
(863, 'Etiopía'),
(864, 'Filipinas'),
(865, 'Finlandia'),
(866, 'Fiyi'),
(867, 'Francia'),
(868, 'Gabón'),
(869, 'Gambia'),
(870, 'Georgia'),
(871, 'Ghana'),
(872, 'Granada'),
(873, 'Grecia'),
(874, 'Guatemala'),
(876, 'Guinea'),
(877, 'Guinea ecuatorial'),
(878, 'Guinea-Bisáu'),
(875, 'Guyana'),
(879, 'Haití'),
(880, 'Honduras'),
(881, 'Hungría'),
(882, 'India'),
(883, 'Indonesia'),
(884, 'Irak'),
(885, 'Irán'),
(886, 'Irlanda'),
(887, 'Islandia'),
(888, 'Islas Marshall'),
(889, 'Islas Salomón'),
(890, 'Israel'),
(891, 'Italia'),
(892, 'Jamaica'),
(893, 'Japón'),
(894, 'Jordania'),
(895, 'Kazajistán'),
(896, 'Kenia'),
(897, 'Kirguistán'),
(898, 'Kiribati'),
(899, 'Kuwait'),
(900, 'Laos'),
(901, 'Lesoto'),
(902, 'Letonia'),
(903, 'Líbano'),
(904, 'Liberia'),
(905, 'Libia'),
(906, 'Liechtenstein'),
(907, 'Lituania'),
(908, 'Luxemburgo'),
(909, 'Macedonia del Norte'),
(910, 'Madagascar'),
(911, 'Malasia'),
(912, 'Malaui'),
(913, 'Maldivas'),
(914, 'Malí'),
(915, 'Malta'),
(916, 'Marruecos'),
(917, 'Mauricio'),
(918, 'Mauritania'),
(919, 'México'),
(920, 'Micronesia'),
(921, 'Moldavia'),
(922, 'Mónaco'),
(923, 'Mongolia'),
(924, 'Montenegro'),
(925, 'Mozambique'),
(926, 'Namibia'),
(927, 'Nauru'),
(928, 'Nepal'),
(929, 'Nicaragua'),
(930, 'Níger'),
(931, 'Nigeria'),
(932, 'Noruega'),
(933, 'Nueva Zelanda'),
(934, 'Omán'),
(935, 'Países Bajos'),
(936, 'Pakistán'),
(937, 'Palaos'),
(938, 'Panamá'),
(939, 'Papúa Nueva Guinea'),
(940, 'Paraguay'),
(941, 'Perú'),
(942, 'Polonia'),
(943, 'Portugal'),
(944, 'Reino Unido'),
(945, 'República Centroafricana'),
(946, 'República Checa'),
(947, 'República del Congo'),
(948, 'República Democrática del Congo'),
(949, 'República Dominicana'),
(950, 'Ruanda'),
(951, 'Rumanía'),
(952, 'Rusia'),
(953, 'Samoa'),
(954, 'San Cristóbal y Nieves'),
(955, 'San Marino'),
(956, 'San Vicente y las Granadinas'),
(957, 'Santa Lucía'),
(958, 'Santo Tomé y Príncipe'),
(959, 'Senegal'),
(960, 'Serbia'),
(961, 'Seychelles'),
(962, 'Sierra Leona'),
(963, 'Singapur'),
(964, 'Siria'),
(965, 'Somalia'),
(966, 'Sri Lanka'),
(967, 'Suazilandia'),
(968, 'Sudáfrica'),
(969, 'Sudán'),
(970, 'Sudán del Sur'),
(971, 'Suecia'),
(972, 'Suiza'),
(973, 'Surinam'),
(974, 'Tailandia'),
(975, 'Tanzania'),
(976, 'Tayikistán'),
(977, 'Timor Oriental'),
(978, 'Togo'),
(979, 'Tonga'),
(980, 'Trinidad y Tobago'),
(981, 'Túnez'),
(982, 'Turkmenistán'),
(983, 'Turquía'),
(984, 'Tuvalu'),
(985, 'Ucrania'),
(986, 'Uganda'),
(987, 'Uruguay'),
(988, 'Uzbekistán'),
(989, 'Vanuatu'),
(990, 'Venezuela'),
(991, 'Vietnam'),
(992, 'Yemen'),
(993, 'Yibuti'),
(994, 'Zambia'),
(995, 'Zimbabue');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `pasajeros`
--

CREATE TABLE `pasajeros` (
  `id` int(11) NOT NULL,
  `nombre` varchar(50) NOT NULL,
  `apellido` varchar(50) NOT NULL,
  `fechaNacimiento` varchar(50) NOT NULL,
  `tipoDocumentoId` int(11) NOT NULL,
  `numeroDocumento` varchar(20) NOT NULL,
  `email` varchar(100) NOT NULL,
  `telefono` varchar(20) NOT NULL,
  `nacionalidad_id` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `pasajeros`
--

INSERT INTO `pasajeros` (`id`, `nombre`, `apellido`, `fechaNacimiento`, `tipoDocumentoId`, `numeroDocumento`, `email`, `telefono`, `nacionalidad_id`) VALUES
(1, 'ENRIQUE ALFONSO', 'FORTE', '1983-10-20', 3, 'Y0161819M', 'elquique3@hotmail.com', '617083052', 987),
(2, 'DIEGO ROQUE', 'CARRILLO BONAZZOLA', '2006-06-01', 1, '74000111Q', 'diego@gmail.com', '600555444', 860),
(3, 'CECILIA ROBERTA', 'BONAZZOLA LOPEZ', '1980-01-08', 1, '35555888J', 'ccil18@hotmail.com', '609879921', 860),
(4, 'CARINA', 'LOPEZ', '1960-02-11', 2, 'PA555111222', 'carinalopez@gmail.com', '555444666', 810);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tipo_documento`
--

CREATE TABLE `tipo_documento` (
  `id` int(11) NOT NULL,
  `descripcion` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `tipo_documento`
--

INSERT INTO `tipo_documento` (`id`, `descripcion`) VALUES
(1, 'DNI'),
(2, 'Pasaporte'),
(3, 'NIE'),
(4, 'Cédula de Identidad');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `viajes`
--

CREATE TABLE `viajes` (
  `id` int(11) NOT NULL,
  `pasajero_id` int(11) NOT NULL,
  `vuelo_id` int(11) NOT NULL,
  `asiento` varchar(5) NOT NULL,
  `fecha_reserva` varchar(15) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `viajes`
--

INSERT INTO `viajes` (`id`, `pasajero_id`, `vuelo_id`, `asiento`, `fecha_reserva`) VALUES
(1, 1, 2, '12A', '2024-10-02'),
(2, 1, 4, '14A', '2024-10-01'),
(3, 1, 3, '19B', '2024-10-04'),
(4, 4, 2, '10A', '2024-10-01');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `vuelos`
--

CREATE TABLE `vuelos` (
  `id` int(11) NOT NULL,
  `aerolinea_id` int(11) NOT NULL,
  `codigo_vuelo` varchar(20) NOT NULL,
  `aeropuerto_origen_id` int(11) NOT NULL,
  `aeropuerto_destino_id` int(11) NOT NULL,
  `fecha_vuelo` varchar(20) NOT NULL,
  `hora_salida` varchar(20) NOT NULL,
  `hora_llegada` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `vuelos`
--

INSERT INTO `vuelos` (`id`, `aerolinea_id`, `codigo_vuelo`, `aeropuerto_origen_id`, `aeropuerto_destino_id`, `fecha_vuelo`, `hora_salida`, `hora_llegada`) VALUES
(2, 1, 'AA158', 56, 216, '2024-10-15', '23:59:00', '06:55:00'),
(3, 1, 'AA154', 216, 56, '2024-10-31', '13:00:00', '06:55:00'),
(4, 2, 'IB255', 56, 60, '2024-10-19', '23:55:00', '08:10:00'),
(5, 3, 'V125', 204, 50, '2024-10-19', '15:00:00', '16:30:00');

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `aerolineas`
--
ALTER TABLE `aerolineas`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `codigo` (`codigo`);

--
-- Indices de la tabla `aeropuertos`
--
ALTER TABLE `aeropuertos`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `nacionalidades`
--
ALTER TABLE `nacionalidades`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `nombre` (`nombre`);

--
-- Indices de la tabla `pasajeros`
--
ALTER TABLE `pasajeros`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `numeroDocumento` (`numeroDocumento`),
  ADD UNIQUE KEY `email` (`email`),
  ADD KEY `tipoDocumentoId` (`tipoDocumentoId`),
  ADD KEY `fk_nacionalidad` (`nacionalidad_id`);

--
-- Indices de la tabla `tipo_documento`
--
ALTER TABLE `tipo_documento`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `viajes`
--
ALTER TABLE `viajes`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `unique_vuelo_asiento` (`vuelo_id`,`asiento`),
  ADD KEY `pasajero_id` (`pasajero_id`);

--
-- Indices de la tabla `vuelos`
--
ALTER TABLE `vuelos`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `codigo_vuelo` (`codigo_vuelo`),
  ADD KEY `aerolinea_id` (`aerolinea_id`),
  ADD KEY `vuelos_ibfk_2` (`aeropuerto_origen_id`),
  ADD KEY `vuelos_ibfk_3` (`aeropuerto_destino_id`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `aerolineas`
--
ALTER TABLE `aerolineas`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT de la tabla `aeropuertos`
--
ALTER TABLE `aeropuertos`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=267;

--
-- AUTO_INCREMENT de la tabla `nacionalidades`
--
ALTER TABLE `nacionalidades`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=996;

--
-- AUTO_INCREMENT de la tabla `pasajeros`
--
ALTER TABLE `pasajeros`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT de la tabla `tipo_documento`
--
ALTER TABLE `tipo_documento`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT de la tabla `viajes`
--
ALTER TABLE `viajes`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT de la tabla `vuelos`
--
ALTER TABLE `vuelos`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `pasajeros`
--
ALTER TABLE `pasajeros`
  ADD CONSTRAINT `fk_nacionalidad` FOREIGN KEY (`nacionalidad_id`) REFERENCES `nacionalidades` (`id`),
  ADD CONSTRAINT `pasajeros_ibfk_1` FOREIGN KEY (`tipoDocumentoId`) REFERENCES `tipo_documento` (`id`) ON UPDATE CASCADE;

--
-- Filtros para la tabla `viajes`
--
ALTER TABLE `viajes`
  ADD CONSTRAINT `viajes_ibfk_1` FOREIGN KEY (`pasajero_id`) REFERENCES `pasajeros` (`id`) ON UPDATE CASCADE,
  ADD CONSTRAINT `viajes_ibfk_2` FOREIGN KEY (`vuelo_id`) REFERENCES `vuelos` (`id`) ON UPDATE CASCADE;

--
-- Filtros para la tabla `vuelos`
--
ALTER TABLE `vuelos`
  ADD CONSTRAINT `vuelos_ibfk_1` FOREIGN KEY (`aerolinea_id`) REFERENCES `aerolineas` (`id`) ON UPDATE CASCADE,
  ADD CONSTRAINT `vuelos_ibfk_2` FOREIGN KEY (`aeropuerto_origen_id`) REFERENCES `aeropuertos` (`id`) ON UPDATE CASCADE,
  ADD CONSTRAINT `vuelos_ibfk_3` FOREIGN KEY (`aeropuerto_destino_id`) REFERENCES `aeropuertos` (`id`) ON UPDATE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;

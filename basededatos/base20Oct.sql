-- MySQL dump 10.13  Distrib 8.0.43, for Linux (x86_64)
--
-- Host: localhost    Database: tpIntegrador
-- ------------------------------------------------------
-- Server version	8.0.43-0ubuntu0.24.04.2

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `auto`
--

DROP TABLE IF EXISTS `auto`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `auto` (
  `id` int NOT NULL AUTO_INCREMENT,
  `marca` varchar(100) NOT NULL,
  `modelo` varchar(100) NOT NULL,
  `anio` int NOT NULL,
  `precio_por_dia` decimal(10,2) NOT NULL,
  `tipo` enum('DEPORTIVO','SUV','SEDAN','CLASICO','COUPE','CONVERTIBLE') NOT NULL,
  `disponible` tinyint(1) DEFAULT '1',
  `descripcion` text,
  `imagen1` varchar(255) DEFAULT NULL,
  `imagen2` varchar(255) DEFAULT NULL,
  `imagen3` varchar(255) DEFAULT NULL,
  `imagen4` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `auto`
--

LOCK TABLES `auto` WRITE;
/*!40000 ALTER TABLE `auto` DISABLE KEYS */;
INSERT INTO `auto` VALUES (1,'Lamborghini','Urus',2020,200.00,'SUV',1,'El Lamborghini Urus es un super SUV que combina un diseño deportivo y agresivo con la funcionalidad de un vehículo utilitario. Cuenta con un motor V8 biturbo de 4 litros y, en las versiones más recientes como el Urus SE, un sistema híbrido que aumenta su potencia y le otorga autonomía eléctrica. Entre sus características destacan una alta velocidad máxima, una aceleración muy rápida y un interior inspirado en la aviación con alta tecnología.','/Front/Catalogo/imagenes/lamborghini-urus-1.jpg','/Front/Catalogo/imagenes/lamborghini-urus-2.jpg','/Front/Catalogo/imagenes/lamborghini-urus-3.jpg','/Front/Catalogo/imagenes/lamborghini-urus-4.jpg'),(2,'Ferrari','Roma',2023,450.00,'DEPORTIVO',1,'El Ferrari Roma representa la elegancia atemporal del gran turismo romano con un diseño sofisticado. Motor V8 turbo de 3.9 litros que entrega 620 CV, caja de cambios de doble embrague de 8 velocidades y sistema de control de derrape Side Slip Control 6.0. Interior lujoso con pantallas digitales y acabados en cuero premium.','/Front/Catalogo/imagenes/ferrari-roma-1.jpg','/Front/Catalogo/imagenes/ferrari-roma-2.jpg','/Front/Catalogo/imagenes/ferrari-roma-3.jpg','/Front/Catalogo/imagenes/ferrari-roma-4.jpg'),(3,'Porsche','911 Turbo S',2024,420.00,'COUPE',1,'El Porsche 911 Turbo S redefine el rendimiento con su motor bóxer de 3.8 litros biturbo que genera 650 CV. Aceleración de 0 a 100 km/h en 2.7 segundos, tracción integral Porsche Traction Management y sistema de suspensión adaptativa. Diseño icónico combinado con tecnología de vanguardia.','/Front/Catalogo/imagenes/porsche-911-1.jpg','/Front/Catalogo/imagenes/porsche-911-2.jpg','/Front/Catalogo/imagenes/porsche-911-3.jpg','/Front/Catalogo/imagenes/porsche-911-4.jpg'),(4,'Mercedes-Benz','Clase S 580',2024,320.00,'SEDAN',1,'La máxima expresión del lujo automotriz alemán. Motor V8 biturbo de 4.0 litros con sistema híbrido leve EQ Boost, suspensión Magic Body Control, pantallas MBUX de realidad aumentada y sistema de sonido Burmester 4D. Asientos con masaje y climatización individual.','/Front/Catalogo/imagenes/mercedes-s-1.jpg','/Front/Catalogo/imagenes/mercedes-s-2.jpg','/Front/Catalogo/imagenes/mercedes-s-3.jpg','/Front/Catalogo/imagenes/mercedes-s-4.jpg'),(5,'Ford','Mustang Shelby GT500',2022,280.00,'CLASICO',1,'El muscle car americano más potente de la historia. Supercharged V8 de 5.2 litros que produce 760 CV, transmisión automática de doble embrague de 7 velocidades y aerodinámica avanzada. Herencia clásica con tecnología moderna, perfecto para amantes de los muscle cars.','/Front/Catalogo/imagenes/ford-mustang-1.jpg','/Front/Catalogo/imagenes/ford-mustang-2.jpg','/Front/Catalogo/imagenes/ford-mustang-3.jpg','/Front/Catalogo/imagenes/ford-mustang-4.jpg'),(6,'McLaren','720S Spider',2023,520.00,'CONVERTIBLE',1,'Superdeportivo convertible con techo retráctil de carbono. Motor V8 twin-turbo de 4.0 litros que desarrolla 720 CV, chasis de fibra de carbono Monocage II y aceleración de 0 a 100 km/h en 2.9 segundos. Experiencia de conducción al aire libre sin comprometer el rendimiento.','/Front/Catalogo/imagenes/mclaren-720s-1.jpg','/Front/Catalogo/imagenes/mclaren-720s-2.jpg','/Front/Catalogo/imagenes/mclaren-720s-3.jpg','/Front/Catalogo/imagenes/mclaren-720s-4.jpg'),(7,'BMW','X6 M Competition',2023,380.00,'SUV',0,'SUV coupé de alto rendimiento con motor V8 biturbo de 4.4 litros que genera 625 CV. Transmisión M Steptronic de 8 velocidades, tracción integral M xDrive y suspensión adaptativa M. Diseño agresivo con líneas coupé y amplio espacio interior.','/Front/Catalogo/imagenes/bmw-x6-1.jpg','/Front/Catalogo/imagenes/bmw-x6-2.jpg','/Front/Catalogo/imagenes/bmw-x6-3.jpg','/Front/Catalogo/imagenes/bmw-x6-4.jpg'),(8,'Audi','R8 V10 Performance',2023,480.00,'DEPORTIVO',1,'Superdeportivo con motor V10 atmosférico de 5.2 litros que produce 620 CV. Tracción integral quattro, chasis de aluminio y fibra de carbono, y sistema de escape deportivo. Sonido característico V10 y líneas de diseño inspiradas en el R8 LMS de competición.','/Front/Catalogo/imagenes/audi-r8-1.jpg','/Front/Catalogo/imagenes/audi-r8-2.jpg','/Front/Catalogo/imagenes/audi-r8-3.jpg','/Front/Catalogo/imagenes/audi-r8-4.jpg'),(9,'Lexus','LC 500',2024,350.00,'COUPE',1,'Gran turismo de lujo con motor V8 atmosférico de 5.0 litros y 477 CV. Diseño inspirado en el concept car LF-LC, interior con acabados artesanales y tecnología avanzada. Combinación perfecta entre rendimiento deportivo y confort de largo recorrido.','/Front/Catalogo/imagenes/lexus-lc-1.jpg','/Front/Catalogo/imagenes/lexus-lc-2.jpg','/Front/Catalogo/imagenes/lexus-lc-3.jpg','/Front/Catalogo/imagenes/lexus-lc-4.jpg'),(10,'Aston Martin','DB11 Volante',2023,430.00,'CONVERTIBLE',1,'Elegante convertible británico con motor V8 biturbo de 4.0 litros y 528 CV. Techo de lona que se recoge en 16 segundos hasta 50 km/h, chasis de aluminio y interior de lujo artesanal. Herencia de gran turismo con carácter deportivo y sofisticación exclusiva.','/Front/Catalogo/imagenes/aston-db11-1.jpg','/Front/Catalogo/imagenes/aston-db11-2.jpg','/Front/Catalogo/imagenes/aston-db11-3.jpg','/Front/Catalogo/imagenes/aston-db11-4.jpg');
/*!40000 ALTER TABLE `auto` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `cliente`
--

DROP TABLE IF EXISTS `cliente`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `cliente` (
  `id` int NOT NULL AUTO_INCREMENT,
  `nombre` varchar(100) NOT NULL,
  `apellido` varchar(100) NOT NULL,
  `telefono` varchar(20) DEFAULT NULL,
  `dni` varchar(20) NOT NULL,
  `direccion` varchar(255) DEFAULT NULL,
  `usuario` varchar(50) NOT NULL,
  `contrasena` varchar(255) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `dni` (`dni`),
  UNIQUE KEY `usuario` (`usuario`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cliente`
--

LOCK TABLES `cliente` WRITE;
/*!40000 ALTER TABLE `cliente` DISABLE KEYS */;
/*!40000 ALTER TABLE `cliente` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `garages`
--

DROP TABLE IF EXISTS `garages`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `garages` (
  `id_garage` int NOT NULL AUTO_INCREMENT,
  `nombre` varchar(100) NOT NULL,
  `ubicacion` varchar(150) DEFAULT NULL,
  `cantidad_lugares` int DEFAULT NULL,
  `pisos` int DEFAULT '1',
  PRIMARY KEY (`id_garage`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `garages`
--

LOCK TABLES `garages` WRITE;
/*!40000 ALTER TABLE `garages` DISABLE KEYS */;
/*!40000 ALTER TABLE `garages` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `lugares`
--

DROP TABLE IF EXISTS `lugares`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `lugares` (
  `id_lugar` int NOT NULL AUTO_INCREMENT,
  `id_garage` int NOT NULL,
  `numero_lugar` int NOT NULL,
  `tipo` enum('auto','moto','premium') DEFAULT 'auto',
  `piso` int DEFAULT '1',
  `estado` enum('disponible','ocupado','reservado','inactivo') DEFAULT 'disponible',
  `precio` int DEFAULT NULL,
  PRIMARY KEY (`id_lugar`),
  KEY `id_garage` (`id_garage`),
  CONSTRAINT `lugares_ibfk_1` FOREIGN KEY (`id_garage`) REFERENCES `garages` (`id_garage`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `lugares`
--

LOCK TABLES `lugares` WRITE;
/*!40000 ALTER TABLE `lugares` DISABLE KEYS */;
/*!40000 ALTER TABLE `lugares` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `pago`
--

DROP TABLE IF EXISTS `pago`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `pago` (
  `id` int NOT NULL AUTO_INCREMENT,
  `id_reserva` int NOT NULL,
  `monto` decimal(10,2) NOT NULL,
  `fecha` datetime DEFAULT CURRENT_TIMESTAMP,
  `metodo` enum('EFECTIVO','TARJETA','TRANSFERENCIA') NOT NULL,
  `estado` enum('PENDIENTE','COMPLETADO','RECHAZADO') DEFAULT 'PENDIENTE',
  PRIMARY KEY (`id`),
  KEY `id_reserva` (`id_reserva`),
  CONSTRAINT `pago_ibfk_1` FOREIGN KEY (`id_reserva`) REFERENCES `reserva` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pago`
--

LOCK TABLES `pago` WRITE;
/*!40000 ALTER TABLE `pago` DISABLE KEYS */;
/*!40000 ALTER TABLE `pago` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `resenia`
--

DROP TABLE IF EXISTS `resenia`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `resenia` (
  `id` int NOT NULL AUTO_INCREMENT,
  `id_cliente` int NOT NULL,
  `id_auto` int NOT NULL,
  `calificacion` int DEFAULT NULL,
  `comentario` text,
  `fecha` datetime DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  KEY `id_cliente` (`id_cliente`),
  KEY `id_auto` (`id_auto`),
  CONSTRAINT `resenia_ibfk_1` FOREIGN KEY (`id_cliente`) REFERENCES `cliente` (`id`),
  CONSTRAINT `resenia_ibfk_2` FOREIGN KEY (`id_auto`) REFERENCES `auto` (`id`),
  CONSTRAINT `resenia_chk_1` CHECK ((`calificacion` between 1 and 5))
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `resenia`
--

LOCK TABLES `resenia` WRITE;
/*!40000 ALTER TABLE `resenia` DISABLE KEYS */;
/*!40000 ALTER TABLE `resenia` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `reserva`
--

DROP TABLE IF EXISTS `reserva`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `reserva` (
  `id` int NOT NULL AUTO_INCREMENT,
  `id_cliente` int NOT NULL,
  `id_auto` int NOT NULL,
  `fecha_inicio` date NOT NULL,
  `fecha_fin` date NOT NULL,
  `estado` enum('PENDIENTE','CONFIRMADA','CANCELADA','FINALIZADA') DEFAULT 'PENDIENTE',
  `total` decimal(10,2) NOT NULL,
  `metodo_pago` enum('EFECTIVO','TARJETA','TRANSFERENCIA') DEFAULT 'TARJETA',
  PRIMARY KEY (`id`),
  KEY `id_cliente` (`id_cliente`),
  KEY `id_auto` (`id_auto`),
  CONSTRAINT `reserva_ibfk_1` FOREIGN KEY (`id_cliente`) REFERENCES `cliente` (`id`),
  CONSTRAINT `reserva_ibfk_2` FOREIGN KEY (`id_auto`) REFERENCES `auto` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `reserva`
--

LOCK TABLES `reserva` WRITE;
/*!40000 ALTER TABLE `reserva` DISABLE KEYS */;
/*!40000 ALTER TABLE `reserva` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `reservasGaraje`
--

DROP TABLE IF EXISTS `reservasGaraje`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `reservasGaraje` (
  `id_reserva` int NOT NULL AUTO_INCREMENT,
  `id_cliente` int NOT NULL,
  `id_lugar` int NOT NULL,
  `fecha_reserva` datetime DEFAULT CURRENT_TIMESTAMP,
  `fecha_inicio` datetime NOT NULL,
  `fecha_fin` datetime NOT NULL,
  `duracion` int GENERATED ALWAYS AS (timestampdiff(HOUR,`fecha_inicio`,`fecha_fin`)) STORED,
  `estado` enum('pendiente','activa','finalizada','cancelada') DEFAULT 'pendiente',
  PRIMARY KEY (`id_reserva`),
  KEY `id_cliente` (`id_cliente`),
  KEY `id_lugar` (`id_lugar`),
  CONSTRAINT `reservasGaraje_ibfk_1` FOREIGN KEY (`id_cliente`) REFERENCES `cliente` (`id`),
  CONSTRAINT `reservasGaraje_ibfk_2` FOREIGN KEY (`id_lugar`) REFERENCES `lugares` (`id_lugar`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `reservasGaraje`
--

LOCK TABLES `reservasGaraje` WRITE;
/*!40000 ALTER TABLE `reservasGaraje` DISABLE KEYS */;
/*!40000 ALTER TABLE `reservasGaraje` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `reservas_garaje`
--

DROP TABLE IF EXISTS `reservas_garaje`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `reservas_garaje` (
  `id_reserva` int NOT NULL AUTO_INCREMENT,
  `duracion` int DEFAULT NULL,
  `estado` enum('activa','cancelada','finalizada','pendiente') DEFAULT NULL,
  `fecha_fin` datetime(6) DEFAULT NULL,
  `fecha_inicio` datetime(6) DEFAULT NULL,
  `fecha_reserva` datetime(6) DEFAULT NULL,
  `id_cliente` int NOT NULL,
  `id_lugar` int NOT NULL,
  PRIMARY KEY (`id_reserva`),
  KEY `FKhepg02vkivc1awksxfhp5eakm` (`id_cliente`),
  KEY `FK3t5m1tjtbwqekt4ibl8eomc3l` (`id_lugar`),
  CONSTRAINT `FK3t5m1tjtbwqekt4ibl8eomc3l` FOREIGN KEY (`id_lugar`) REFERENCES `lugares` (`id_lugar`),
  CONSTRAINT `FKhepg02vkivc1awksxfhp5eakm` FOREIGN KEY (`id_cliente`) REFERENCES `cliente` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `reservas_garaje`
--

LOCK TABLES `reservas_garaje` WRITE;
/*!40000 ALTER TABLE `reservas_garaje` DISABLE KEYS */;
/*!40000 ALTER TABLE `reservas_garaje` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sucursal`
--

DROP TABLE IF EXISTS `sucursal`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `sucursal` (
  `id` int NOT NULL AUTO_INCREMENT,
  `nombre` varchar(100) NOT NULL,
  `direccion` varchar(255) NOT NULL,
  `ciudad` varchar(100) DEFAULT NULL,
  `telefono` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sucursal`
--

LOCK TABLES `sucursal` WRITE;
/*!40000 ALTER TABLE `sucursal` DISABLE KEYS */;
/*!40000 ALTER TABLE `sucursal` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2025-11-03  9:34:18

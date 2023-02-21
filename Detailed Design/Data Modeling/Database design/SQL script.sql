-- MySQL dump 10.13  Distrib 8.0.29, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: testcap
-- ------------------------------------------------------
-- Server version	8.0.29

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
-- Table structure for table `bike`
--

DROP TABLE IF EXISTS `bike`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `bike` (
  `id` int NOT NULL,
  `bikeValue` int DEFAULT NULL,
  `isBeingUsed` smallint DEFAULT NULL,
  `licence_plate` varchar(100) DEFAULT NULL,
  `bike_image_url` text,
  `brand` varchar(100) DEFAULT NULL,
  `bike_type_id` int NOT NULL,
  `dock_id` int NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_Bike_0` (`bike_type_id`),
  KEY `FK_Bike_1` (`dock_id`),
  CONSTRAINT `FK_Bike_0` FOREIGN KEY (`bike_type_id`) REFERENCES `bike_type` (`id`),
  CONSTRAINT `FK_Bike_1` FOREIGN KEY (`dock_id`) REFERENCES `dock` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `bike`
--

LOCK TABLES `bike` WRITE;
/*!40000 ALTER TABLE `bike` DISABLE KEYS */;
INSERT INTO `bike` VALUES (1,300000,0,'dasd213','https://th.bing.com/th/id/OIP.i0dGRzUqa33uB-_67OtirQHaD2?w=307&h=180&c=7&r=0&o=5&dpr=1.6&pid=1.7&fbclid=IwAR3JvkXtPbxF4hbGSK6N_aNbJhd9MIdLoLCmeIdvLihvOgQbh_x1sUaIbaQ','HEDSPI',3,1),(2,400000,0,'ads1234','https://th.bing.com/th/id/OIP.ZTW5Xt5f8tTeCuUn9-7e4QHaE7?w=292&h=194&c=7&r=0&o=5&dpr=1.6&pid=1.7&fbclid=IwAR03iNRWTwc7TJuid6Tyngt57loMjVK58kOg5S10gYVpttyn4hTt3UAx7ik','HEDSPI',2,2),(3,400000,0,'fdsg','https://th.bing.com/th/id/OIP.NbDC4NbkTqXtpby7VHXyWgHaFM?w=257&h=180&c=7&r=0&o=5&dpr=1.6&pid=1.7&fbclid=IwAR1OFv8dyRf7vSpOeZ64fLAGnxEDexOKdC_WqkJYszvt63kosURiIthNIuw','HEDSPI',1,3),(4,400000,0,'gsd1243','https://th.bing.com/th/id/OIP.i0dGRzUqa33uB-_67OtirQHaD2?w=307&h=180&c=7&r=0&o=5&dpr=1.6&pid=1.7&fbclid=IwAR3JvkXtPbxF4hbGSK6N_aNbJhd9MIdLoLCmeIdvLihvOgQbh_x1sUaIbaQ','HEDSPI',3,1),(5,400000,1,'234esfr','https://th.bing.com/th/id/OIP.ZTW5Xt5f8tTeCuUn9-7e4QHaE7?w=292&h=194&c=7&r=0&o=5&dpr=1.6&pid=1.7&fbclid=IwAR03iNRWTwc7TJuid6Tyngt57loMjVK58kOg5S10gYVpttyn4hTt3UAx7ik','HEDSPI',2,2),(6,400000,0,'wdst6','https://th.bing.com/th/id/OIP.NbDC4NbkTqXtpby7VHXyWgHaFM?w=257&h=180&c=7&r=0&o=5&dpr=1.6&pid=1.7&fbclid=IwAR1OFv8dyRf7vSpOeZ64fLAGnxEDexOKdC_WqkJYszvt63kosURiIthNIuw','HEDSPI',1,3),(7,400000,0,'346egsdf','https://th.bing.com/th/id/OIP.i0dGRzUqa33uB-_67OtirQHaD2?w=307&h=180&c=7&r=0&o=5&dpr=1.6&pid=1.7&fbclid=IwAR3JvkXtPbxF4hbGSK6N_aNbJhd9MIdLoLCmeIdvLihvOgQbh_x1sUaIbaQ','HEDSPI',3,1),(8,400000,0,'sdgety456','https://th.bing.com/th/id/OIP.ZTW5Xt5f8tTeCuUn9-7e4QHaE7?w=292&h=194&c=7&r=0&o=5&dpr=1.6&pid=1.7&fbclid=IwAR03iNRWTwc7TJuid6Tyngt57loMjVK58kOg5S10gYVpttyn4hTt3UAx7ik','HEDSPI',2,2),(9,400000,0,'65623fdsfwr','https://th.bing.com/th/id/OIP.NbDC4NbkTqXtpby7VHXyWgHaFM?w=257&h=180&c=7&r=0&o=5&dpr=1.6&pid=1.7&fbclid=IwAR1OFv8dyRf7vSpOeZ64fLAGnxEDexOKdC_WqkJYszvt63kosURiIthNIuw','HEDSPI',1,3),(10,400000,0,'fd23r32','https://th.bing.com/th/id/OIP.i0dGRzUqa33uB-_67OtirQHaD2?w=307&h=180&c=7&r=0&o=5&dpr=1.6&pid=1.7&fbclid=IwAR3JvkXtPbxF4hbGSK6N_aNbJhd9MIdLoLCmeIdvLihvOgQbh_x1sUaIbaQ','HEDSPI',3,1),(11,400000,0,'f432ff','https://th.bing.com/th/id/OIP.ZTW5Xt5f8tTeCuUn9-7e4QHaE7?w=292&h=194&c=7&r=0&o=5&dpr=1.6&pid=1.7&fbclid=IwAR03iNRWTwc7TJuid6Tyngt57loMjVK58kOg5S10gYVpttyn4hTt3UAx7ik','HEDSPI',2,2),(12,400000,0,'fwef2','https://th.bing.com/th/id/OIP.NbDC4NbkTqXtpby7VHXyWgHaFM?w=257&h=180&c=7&r=0&o=5&dpr=1.6&pid=1.7&fbclid=IwAR1OFv8dyRf7vSpOeZ64fLAGnxEDexOKdC_WqkJYszvt63kosURiIthNIuw','HEDSPI',1,3),(13,400000,0,'fewr','https://th.bing.com/th/id/OIP.i0dGRzUqa33uB-_67OtirQHaD2?w=307&h=180&c=7&r=0&o=5&dpr=1.6&pid=1.7&fbclid=IwAR3JvkXtPbxF4hbGSK6N_aNbJhd9MIdLoLCmeIdvLihvOgQbh_x1sUaIbaQ','HEDSPI',3,1),(14,400000,0,'23s','https://th.bing.com/th/id/OIP.ZTW5Xt5f8tTeCuUn9-7e4QHaE7?w=292&h=194&c=7&r=0&o=5&dpr=1.6&pid=1.7&fbclid=IwAR03iNRWTwc7TJuid6Tyngt57loMjVK58kOg5S10gYVpttyn4hTt3UAx7ik','HEDSPI',2,2),(15,400000,0,'fsdg4','https://th.bing.com/th/id/OIP.NbDC4NbkTqXtpby7VHXyWgHaFM?w=257&h=180&c=7&r=0&o=5&dpr=1.6&pid=1.7&fbclid=IwAR1OFv8dyRf7vSpOeZ64fLAGnxEDexOKdC_WqkJYszvt63kosURiIthNIuw','HEDSPI',1,3);
/*!40000 ALTER TABLE `bike` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `bike_type`
--

DROP TABLE IF EXISTS `bike_type`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `bike_type` (
  `id` int NOT NULL,
  `name` varchar(45) DEFAULT NULL,
  `value` smallint DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `bike_type`
--

LOCK TABLES `bike_type` WRITE;
/*!40000 ALTER TABLE `bike_type` DISABLE KEYS */;
INSERT INTO `bike_type` VALUES (1,'standard bicycle',1),(2,'standard e bike',2),(3,'twin bike',3);
/*!40000 ALTER TABLE `bike_type` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `dock`
--

DROP TABLE IF EXISTS `dock`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `dock` (
  `id` int NOT NULL,
  `name` varchar(45) DEFAULT NULL,
  `dockArea` float DEFAULT NULL,
  `address` varchar(100) DEFAULT NULL,
  `dock_image_url` text,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `dock`
--

LOCK TABLES `dock` WRITE;
/*!40000 ALTER TABLE `dock` DISABLE KEYS */;
INSERT INTO `dock` VALUES (1,'LANG HA',1000,'Lang Ha, Ha Noi','https://th.bing.com/th/id/OIP.DfcFX9B00Y6I5Uw9Ckx5TQHaE8?w=288&h=192&c=7&r=0&o=5&dpr=1.6&pid=1.7&fbclid=IwAR0_LME57QWeJYPn1wvs_yI5lQd3PdnlZSUpy6ElbS3rl7-WbduUkpNl8rw'),(2,'TRAN DAI NGHIA',1000,'Tran Dai Nghia, Ha Noi','https://th.bing.com/th/id/OIP.DfcFX9B00Y6I5Uw9Ckx5TQHaE8?w=288&h=192&c=7&r=0&o=5&dpr=1.6&pid=1.7&fbclid=IwAR0_LME57QWeJYPn1wvs_yI5lQd3PdnlZSUpy6ElbS3rl7-WbduUkpNl8rw'),(3,'DAI LA',5000,'Dai La, Ha Noi','https://th.bing.com/th/id/OIP.DfcFX9B00Y6I5Uw9Ckx5TQHaE8?w=288&h=192&c=7&r=0&o=5&dpr=1.6&pid=1.7&fbclid=IwAR0_LME57QWeJYPn1wvs_yI5lQd3PdnlZSUpy6ElbS3rl7-WbduUkpNl8rw');
/*!40000 ALTER TABLE `dock` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `dock_empty_point`
--

DROP TABLE IF EXISTS `dock_empty_point`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `dock_empty_point` (
  `id` int NOT NULL,
  `empty_points` int DEFAULT NULL,
  `max_available_points` int DEFAULT NULL,
  `dock_id` int NOT NULL,
  `bike_type_id` int NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_dock_empty_point_0` (`dock_id`),
  KEY `FK_dock_empty_point_1` (`bike_type_id`),
  CONSTRAINT `FK_dock_empty_point_0` FOREIGN KEY (`dock_id`) REFERENCES `dock` (`id`),
  CONSTRAINT `FK_dock_empty_point_1` FOREIGN KEY (`bike_type_id`) REFERENCES `bike_type` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `dock_empty_point`
--

LOCK TABLES `dock_empty_point` WRITE;
/*!40000 ALTER TABLE `dock_empty_point` DISABLE KEYS */;
INSERT INTO `dock_empty_point` VALUES (1,5,15,1,1),(2,4,15,1,2),(3,6,15,1,3),(4,5,15,2,1),(5,12,15,2,2),(6,5,15,2,3),(7,5,15,3,1),(8,5,15,3,2),(9,5,15,3,3);
/*!40000 ALTER TABLE `dock_empty_point` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `rental_bike_code`
--

DROP TABLE IF EXISTS `rental_bike_code`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `rental_bike_code` (
  `id` int NOT NULL,
  `bar_code` varchar(100) DEFAULT NULL,
  `bike_id` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_rental_bike_code_0` (`bike_id`),
  CONSTRAINT `FK_rental_bike_code_0` FOREIGN KEY (`bike_id`) REFERENCES `bike` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `rental_bike_code`
--

LOCK TABLES `rental_bike_code` WRITE;
/*!40000 ALTER TABLE `rental_bike_code` DISABLE KEYS */;
INSERT INTO `rental_bike_code` VALUES (1,'zbepnroeIxOhqtWR49GW',1),(2,'jaIZumibige7nIf5IVrv',2),(3,'eMG0sgm0fQHmPsguv5MT',3),(4,'bnjMnhoiyMo6uhJJ4tPr',4),(5,'cpVmZNFyl4t5Dvff1FI2',5),(6,'jR4DbUYAxvWMRdJIsshu',6),(7,'UqbjXeTbAkfEiSyvGKZJ',7),(8,'DK8XHOJSDUy1nbSnWEaP',8),(9,'A4E4yALvs1ohHegjdytn',9),(10,'H3DCXpy90iOdrxOiXhkp',10),(11,'StNaPQrUKmkmW1mBEA9I',11),(12,'xomypd63SzE13JPvkqe1',12),(13,'pVFnnOt4gbSPu8tUCHuM',13),(14,'Ea5oa7x4zr01uOeyqyZq',14),(15,'VEysloo9x2dNzmLmSH04',15);
/*!40000 ALTER TABLE `rental_bike_code` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `standard_e_bike_attribute`
--

DROP TABLE IF EXISTS `standard_e_bike_attribute`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `standard_e_bike_attribute` (
  `id` int NOT NULL,
  `name` varchar(100) DEFAULT NULL,
  `value` text,
  `bike_id` int NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_standard_e_bike_attribute_0` (`bike_id`),
  CONSTRAINT `FK_standard_e_bike_attribute_0` FOREIGN KEY (`bike_id`) REFERENCES `bike` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `standard_e_bike_attribute`
--

LOCK TABLES `standard_e_bike_attribute` WRITE;
/*!40000 ALTER TABLE `standard_e_bike_attribute` DISABLE KEYS */;
INSERT INTO `standard_e_bike_attribute` VALUES (1,'batery percent','100',2),(2,'batery percent','100',5),(3,'batery percent','100',8),(4,'batery percent','100',11),(5,'batery percent','100',14);
/*!40000 ALTER TABLE `standard_e_bike_attribute` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `transaction`
--

DROP TABLE IF EXISTS `transaction`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `transaction` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(45) DEFAULT NULL,
  `code` varchar(100) DEFAULT NULL,
  `time` date DEFAULT NULL,
  `content` varchar(100) DEFAULT NULL,
  `amount` int DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=57 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `transaction`
--

LOCK TABLES `transaction` WRITE;
/*!40000 ALTER TABLE `transaction` DISABLE KEYS */;
INSERT INTO `transaction` VALUES (1,'Group5','123456','2023-02-06','Process to payment',160000),(2,'Group5','123456','2023-02-06','Process to payment',160000),(3,'Group5','123456','2023-02-06','Process to payment',160000),(4,'Group5','123456','2023-02-06','Process to payment',160000),(5,'Group5','123456','2023-02-06','Process to payment',160000),(6,'Group5','123456','2023-02-06','Process to payment',160000),(7,'Group5','123456','2023-02-07','Process to payment',160000),(8,'Group5','123456','2023-02-07','Process to payment',160000),(9,'Group5','123456','2023-02-08','Process to payment',160000),(10,'Group5','123456','2023-02-08','Process to payment',-150000),(11,'Group5','123456','2023-02-08','Process to payment',160000),(12,'Group5','123456','2023-02-08','Process to payment',160000),(13,'Group5','123456','2023-02-08','Process to payment',160000),(14,'Group5','123456','2023-02-08','Process to payment',160000),(15,'Group5','123456','2023-02-08','Process to payment',160000),(16,'Group5','123456','2023-02-08','Process to payment',160000),(17,'Group5','123456','2023-02-08','Process to payment',160000),(18,'Group5','123456','2023-02-08','Process to payment',550000),(19,'Group5','123456','2023-02-08','Process to payment',-540000),(20,'Group5','123456','2023-02-08','Process to payment',550000),(21,'Group5','123456','2023-02-08','Process to payment',700000),(22,'Group5','123456','2023-02-08','Process to payment',-690000),(23,'Group5','123456','2023-02-08','Process to payment',700000),(24,'Group5','123456','2023-02-08','Process to payment',-690000),(25,'Group5','123456','2023-02-08','Process to payment',700000),(26,'Group5','123456','2023-02-08','Process to payment',700000),(27,'Group5','123456','2023-02-08','Process to payment',-685000),(28,'Group5','123456','2023-02-08','Process to payment',700000),(29,'Group5','123456','2023-02-08','Process to payment',-685000),(30,'Group5','123456','2023-02-08','Process to payment',700000),(31,'Group5','123456','2023-02-08','Process to payment',-685000),(32,'Group5','123456','2023-02-08','Process to payment',700000),(33,'Group5','123456','2023-02-08','Process to payment',-685000),(34,'Group5','123456','2023-02-08','Process to payment',700000),(35,'Group5','123456','2023-02-08','Process to payment',-685000),(36,'Group5','123456','2023-02-19','Process to payment',700000),(37,'Group5','123456','2023-02-19','Process to payment',400000),(38,'Group5','123456','2023-02-19','Process to payment',700000),(39,'Group5','123456','2023-02-19','Process to payment',400000),(40,'Group5','123456','2023-02-19','Process to payment',400000),(41,'Group5','123456','2023-02-19','Process to payment',-390000),(42,'Group5','123456','2023-02-19','Process to payment',550000),(43,'Group5','123456','2023-02-19','Process to payment',-535000),(44,'Group5','123456','2023-02-19','Process to payment',550000),(45,'Group5','123456','2023-02-19','Process to payment',-535000),(46,'Group5','123456','2023-02-19','Process to payment',550000),(47,'Group5','123456','2023-02-19','Process to payment',-535000),(48,'Group5','123456','2023-02-19','Process to payment',550000),(49,'Group5','123456','2023-02-19','Process to payment',700000),(50,'Group5','123456','2023-02-19','Process to payment',700000),(51,'Group5','123456','2023-02-19','Process to payment',700000),(52,'Group5','123456','2023-02-19','Process to payment',-685000),(53,'Group5','123456','2023-02-19','Process to payment',700000),(54,'Group5','123456','2023-02-19','Process to payment',700000),(55,'Group5','123456','2023-02-19','Process to payment',700000),(56,'Group5','123456','2023-02-19','Process to payment',700000);
/*!40000 ALTER TABLE `transaction` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `twin_bike_attribute`
--

DROP TABLE IF EXISTS `twin_bike_attribute`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `twin_bike_attribute` (
  `id` int NOT NULL,
  `name` varchar(100) DEFAULT NULL,
  `value` text,
  `bike_id` int NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_twin_bike_attribute_0` (`bike_id`),
  CONSTRAINT `FK_twin_bike_attribute_0` FOREIGN KEY (`bike_id`) REFERENCES `bike` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `twin_bike_attribute`
--

LOCK TABLES `twin_bike_attribute` WRITE;
/*!40000 ALTER TABLE `twin_bike_attribute` DISABLE KEYS */;
/*!40000 ALTER TABLE `twin_bike_attribute` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-02-19 23:08:17

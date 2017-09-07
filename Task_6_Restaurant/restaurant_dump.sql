-- MySQL dump 10.13  Distrib 5.7.17, for Win64 (x86_64)
--
-- Host: localhost    Database: restaurant
-- ------------------------------------------------------
-- Server version	8.0.1-dmr-log

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `appetizers`
--

DROP TABLE IF EXISTS `appetizers`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `appetizers` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL,
  `description` varchar(255) NOT NULL,
  `price` decimal(10,2) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=20 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `appetizers`
--

LOCK TABLES `appetizers` WRITE;
/*!40000 ALTER TABLE `appetizers` DISABLE KEYS */;
INSERT INTO `appetizers` VALUES (1,'Consome','clear soup',2.50),(2,'Sopa de picadillo','boiled egg and ham in a clear soup',4.00),(3,'Sopa de marisco','seafood soup',4.00),(4,'Sopa de esparragos','asparagus soup',4.00),(5,'Callos','tripe',4.00),(6,'Gazpacho con huevo y jamon','cold tomato soup with egg/ham',4.00),(7,'Ensalada mixta','mixed salad (per person)',3.00),(8,'Ensalada de la casa','house salad (more variation)',4.00),(9,'Aguacate con gambas','avocado and prawns',6.50),(10,'Coctel de gambas','prawn cocktail',6.50),(11,'Esparragos con mayonesa','asparagus and mayonnaise',6.50),(12,'Revuelto con patatas','scrambled egg and chips',3.00),(13,'Tortilla Francesa','plain omelet',3.00),(14,'Tortilla de gambas','prawns omelet',4.00),(15,'Tortilla de jamon','ham omelet',4.00),(16,'Tortilla de patatas','Spanish deep potato omelet',4.00),(17,'Lomo, huevo y patatas','pork loin, fried egg, and chips',8.00),(18,'Revuelto de esparragos','scrambled egg with asparagus',8.00),(19,'Revuelto de champiñones','scrambled egg with mushrooms',8.00);
/*!40000 ALTER TABLE `appetizers` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `beverages`
--

DROP TABLE IF EXISTS `beverages`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `beverages` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL,
  `description` varchar(255) NOT NULL,
  `price` decimal(10,2) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `beverages`
--

LOCK TABLES `beverages` WRITE;
/*!40000 ALTER TABLE `beverages` DISABLE KEYS */;
INSERT INTO `beverages` VALUES (1,'Café solo','small espresso',1.25),(2,'Café doble','double espresso',2.00),(3,'Café con leche','coffee with milk',1.50),(4,'Te','tea',1.25),(5,'Te con limon','tea with a slice of lemon',1.35),(6,'Infusion de tila','lime flower herbal tea',1.50),(7,'Infusion de manzanilla','chamomile herbal tea',1.50),(8,'Infusion de poleo-menta','mint herbal tea',1.50),(9,'Chocolate caliente','hot chocolate',2.50),(10,'Batido de fresa','strawberry milkshake',2.00),(11,'Batido de chocolate','chocolate milkshake ',2.00),(12,'Batido de vainilla','vanilla milkshake',2.00),(13,'Zumo de piña','pineapple juice',1.50),(14,'Zumo de naranja','orange juice',1.00),(15,'Zumo de melocoton','peach juice ',1.50),(16,'Zumo de manzana','apple juice',1.00),(17,'Coca-cola','Coca-cola',2.50),(18,'Pepsi','Pepsi',2.50);
/*!40000 ALTER TABLE `beverages` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `desserts`
--

DROP TABLE IF EXISTS `desserts`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `desserts` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL,
  `description` varchar(255) NOT NULL,
  `price` decimal(10,2) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `desserts`
--

LOCK TABLES `desserts` WRITE;
/*!40000 ALTER TABLE `desserts` DISABLE KEYS */;
INSERT INTO `desserts` VALUES (1,'Arroz con leche casero','homemade rice pudding, chilled',1.50),(2,'Natillas caseras','homemade egg custard, served chilled',1.50),(3,'Tarta al whisky','whiskey cake',2.50),(4,'Nata con nueces','cream with walnuts',3.50),(5,'Crema Catalana','similar to crème brûlée',3.50),(6,'Flan','crème caramel',1.50),(7,'Tocino de cielo','egg yolk/syrup dessert',2.00),(8,'Tocino de cielo con nata','egg yolk/syrup dessert with cream',2.50),(9,'Flan con nata','crème caramel with cream',2.50),(10,'Fruta del tiempo','fruit of the season',1.00),(11,'Piña en almibar','pineapple in syrup',1.50),(12,'Melocoton en almibar','peaches in syrup',1.50),(13,'Helados','ice-cream',2.00),(14,'Tarta de pasteleria','sweet pastries',2.00),(15,'Fresas','strawberries',2.50),(16,'Fresas con nata','strawberries with cream',3.50),(17,'Pijama','chocolate covered ice-cream',5.00);
/*!40000 ALTER TABLE `desserts` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `fish`
--

DROP TABLE IF EXISTS `fish`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `fish` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL,
  `description` varchar(255) NOT NULL,
  `price` decimal(10,2) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `fish`
--

LOCK TABLES `fish` WRITE;
/*!40000 ALTER TABLE `fish` DISABLE KEYS */;
INSERT INTO `fish` VALUES (1,'Puntillitas','baby squids',8.00),(2,'Calamares a la plancha','grilled squids',8.00),(3,'Calamares fritos','ried squids',8.00),(4,'Rosada','red hake',8.00),(5,'Boquerones','fried anchovies',8.00),(6,'Jurelitos','horse mackerel',8.00),(7,'Pez espada','swordfish',10.00),(8,'Lenguado','sole',10.00),(9,'Langostinos','prawns (grilled/boiled)',10.00);
/*!40000 ALTER TABLE `fish` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `meat`
--

DROP TABLE IF EXISTS `meat`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `meat` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL,
  `description` varchar(255) NOT NULL,
  `price` decimal(10,2) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `meat`
--

LOCK TABLES `meat` WRITE;
/*!40000 ALTER TABLE `meat` DISABLE KEYS */;
INSERT INTO `meat` VALUES (1,'Pechuga de pollo','chicken breast',8.00),(2,'Carne con tomate','pork chunks in tomato sauce',8.00),(3,'Filetitos','pork fillet, (+itos - small)',8.00),(4,'Alitas','chicken wings',8.00),(5,'Codornices a la plancha','grilled quails',3.00),(6,'Codornices ajillo','grilled quails in garlic',4.00),(7,'Solomillo a la plancha','grilled sirloin steak (pork/beef)',10.00),(8,'Solomillo pimienta','sirloin steak in spiced pepper',12.00),(9,'Entrecot a la plancha','grilled rib steak',12.00),(10,'Entrecot pimienta','rib steak in spicy pepper',12.00),(11,'Filete ternera','veal steak',10.00),(12,'Chuleta de cordero','lamb chops',10.00),(13,'Cordero a la caldereta','lamb stew',10.00);
/*!40000 ALTER TABLE `meat` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `orders`
--

DROP TABLE IF EXISTS `orders`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `orders` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL,
  `price` decimal(10,2) NOT NULL,
  `client` varchar(255) NOT NULL,
  `timestamp` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `orders`
--

LOCK TABLES `orders` WRITE;
/*!40000 ALTER TABLE `orders` DISABLE KEYS */;
INSERT INTO `orders` VALUES (1,'Gazpacho con huevo y jamon',4.00,'Vitalik94','2017-09-07 18:53:17'),(2,'Pez espada',10.00,'Vitalik94','2017-09-07 18:53:17'),(3,'Langostinos',10.00,'Vitalik94','2017-09-07 18:53:17'),(4,'Alitas',8.00,'Vitalik94','2017-09-07 18:53:17'),(5,'Piña en almibar',1.50,'Vitalik94','2017-09-07 18:53:17'),(6,'Zumo de naranja',1.00,'Vitalik94','2017-09-07 18:53:17');
/*!40000 ALTER TABLE `orders` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2017-09-07 22:51:03

-- MySQL dump 10.13  Distrib 5.7.9, for Win64 (x86_64)
--
-- Host: localhost    Database: online_blood_bank_system
-- ------------------------------------------------------
-- Server version	5.7.10-log

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
-- Table structure for table `blood_request`
--

DROP TABLE IF EXISTS `blood_request`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `blood_request` (
  `req_us_id` bigint(11) NOT NULL AUTO_INCREMENT,
  `req_us_blood_group` varchar(5) NOT NULL,
  `req_us_state` varchar(50) NOT NULL,
  `req_us_area` varchar(50) NOT NULL,
  `req_us_pin_code` int(6) NOT NULL,
  `req_us_contact_number` varchar(10) NOT NULL,
  `req_us_id_fk` int(11) NOT NULL,
  PRIMARY KEY (`req_us_id`),
  KEY `req_us_id_fk` (`req_us_id_fk`),
  CONSTRAINT `blood_request_ibfk_1` FOREIGN KEY (`req_us_id_fk`) REFERENCES `user` (`us_id`)
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `blood_request`
--

LOCK TABLES `blood_request` WRITE;
/*!40000 ALTER TABLE `blood_request` DISABLE KEYS */;
INSERT INTO `blood_request` VALUES (3,'AB-','TamilNadu','Jamil',777476,'9911911119',1),(4,'B-','Andhra','Jamil',777777,'9922911119',2),(16,'O+','Andaman and Nicobar Islands','Andaman and Nicobar Islands',123332,'1234554321',7);
/*!40000 ALTER TABLE `blood_request` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `donor`
--

DROP TABLE IF EXISTS `donor`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `donor` (
  `do_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `do_blood_group` varchar(45) NOT NULL,
  `do_state` varchar(45) NOT NULL,
  `do_area` varchar(45) NOT NULL,
  `do_pin_code` int(6) NOT NULL,
  `do_contact_number` varchar(10) NOT NULL,
  `do_us_id` int(11) NOT NULL,
  PRIMARY KEY (`do_id`),
  KEY `fk_donor_user1_idx` (`do_us_id`),
  CONSTRAINT `fk_donor_user1` FOREIGN KEY (`do_us_id`) REFERENCES `user` (`us_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=48 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `donor`
--

LOCK TABLES `donor` WRITE;
/*!40000 ALTER TABLE `donor` DISABLE KEYS */;
INSERT INTO `donor` VALUES (1,'AB+','Karnataka','Mysore',777666,'2233445566',2),(2,'B-','Karnataka','Bangalore',777666,'1112223334',1),(47,'B+','Bihar','Bihar',144456,'1111111111',7);
/*!40000 ALTER TABLE `donor` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `hospital_booking`
--

DROP TABLE IF EXISTS `hospital_booking`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `hospital_booking` (
  `hb_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `hb_name` varchar(15) NOT NULL,
  `hb_city` varchar(15) NOT NULL,
  `hb_time` varchar(15) NOT NULL,
  `hb_date` date NOT NULL,
  `hb_do_id` bigint(20) NOT NULL,
  PRIMARY KEY (`hb_id`),
  KEY `fk_hospital_booking_donor1_idx` (`hb_do_id`),
  CONSTRAINT `fk_hospital_booking_donor1` FOREIGN KEY (`hb_do_id`) REFERENCES `donor` (`do_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=28 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `hospital_booking`
--

LOCK TABLES `hospital_booking` WRITE;
/*!40000 ALTER TABLE `hospital_booking` DISABLE KEYS */;
INSERT INTO `hospital_booking` VALUES (1,'Apollo','Bangalore','9 to 10','2019-12-02',1),(2,'Apollo','Bangalore','9 to 10','2019-01-11',2),(27,'Apollo','Mysore','9 to 10','2018-12-02',47);
/*!40000 ALTER TABLE `hospital_booking` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `hospital_feedback`
--

DROP TABLE IF EXISTS `hospital_feedback`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `hospital_feedback` (
  `hf_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `hf_name` varchar(15) NOT NULL,
  `hf_city` varchar(15) NOT NULL,
  `hf_feedback` varchar(500) NOT NULL,
  PRIMARY KEY (`hf_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `hospital_feedback`
--

LOCK TABLES `hospital_feedback` WRITE;
/*!40000 ALTER TABLE `hospital_feedback` DISABLE KEYS */;
/*!40000 ALTER TABLE `hospital_feedback` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `role`
--

DROP TABLE IF EXISTS `role`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `role` (
  `ro_id` int(11) NOT NULL,
  `ro_name` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`ro_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `role`
--

LOCK TABLES `role` WRITE;
/*!40000 ALTER TABLE `role` DISABLE KEYS */;
INSERT INTO `role` VALUES (1,'USER'),(2,'ADMIN');
/*!40000 ALTER TABLE `role` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user` (
  `us_id` int(11) NOT NULL AUTO_INCREMENT,
  `us_user_name` varchar(50) DEFAULT NULL,
  `us_first_name` varchar(50) DEFAULT NULL,
  `us_last_name` varchar(50) DEFAULT NULL,
  `us_age` int(3) DEFAULT NULL,
  `us_gender` varchar(10) DEFAULT NULL,
  `us_contact_number` varchar(10) DEFAULT NULL,
  `us_email` varchar(50) NOT NULL,
  `us_password` varchar(70) DEFAULT NULL,
  `us_weight` int(5) DEFAULT NULL,
  `us_state` varchar(50) DEFAULT NULL,
  `us_area` varchar(50) DEFAULT NULL,
  `us_pincode` int(6) DEFAULT NULL,
  `us_blood_group` varchar(5) DEFAULT NULL,
  PRIMARY KEY (`us_id`),
  UNIQUE KEY `us_email` (`us_email`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (1,'testuser','test','user',22,'male','1234567890','mail@mail.com','$2a$10$oitvo8RhOAb3B3uthz0EU.8zk1yHExabQdlFoGRPLZGV8kMurj976',70,'Andhra Pradesh','Tirupathi',517501,'O+'),(2,'realuser','real','user',11,'male','2234567890','maila@mail.com','$2a$10$oitvo8RhOAb3B3uthz0EU.8zk1yHExabQdlFoGRPLZGV8kMurj976',60,'Andhra Pradesh','Tirupathi',517501,'B+'),(3,'unrealuser','real','user',11,'male','3234567890','amaila@mail.com','$2a$10$4KMZJrNXdQpiSZvFbAy7gediDaqZWjmOYyP8UVGILh3tSML9sfQ6C',60,'Andhra Pradesh','Tirupathi',517501,'B+'),(4,'asdf','real','user',23,'male','1234567890','no@no.com','$2a$10$7IIEVC4LFEkJ/C5rICMlr.NoNfeekDTOpfNfdVa9Y0N0FLZ.72vA.',82,'Goa','Panaji',123456,'AB-'),(5,'asdfas','real','user',23,'male','1234567890','noas@no.com','$2a$10$r259VIrNBstBTP6t4aZAlu4UMf1OzUag5RMcOfXnfHaNuWUoRvhfm',82,'Goa','Panaji',123456,'AB-'),(6,'lolki','test','user',22,'male','1234567890','jammail@mail.com','$2a$10$lWnC5rcL35OGKki93VLfReVQ16e0OrlRYbwB033VRRBislzFD5PLy',70,'Andhra Pradesh','Tirupathi',517501,'O+'),(7,'thor','qw','qw',33,'male','2222222222','qw@w.com','$2a$10$kiPwQPVtAMiNbc13htb6F.j7pqivQ4ZE4mo25rwm36yfPczS6EWcK',77,'JH','BR',333333,'A+');
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user_role`
--

DROP TABLE IF EXISTS `user_role`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user_role` (
  `ur_id` int(11) NOT NULL AUTO_INCREMENT,
  `ur_us_id` int(11) NOT NULL,
  `ur_ro_id` int(11) NOT NULL,
  PRIMARY KEY (`ur_id`),
  KEY `fk_user_role_user_idx` (`ur_us_id`),
  KEY `fk_user_role_role1_idx` (`ur_ro_id`),
  CONSTRAINT `fk_user_role_role1` FOREIGN KEY (`ur_ro_id`) REFERENCES `role` (`ro_id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_user_role_user` FOREIGN KEY (`ur_us_id`) REFERENCES `user` (`us_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user_role`
--

LOCK TABLES `user_role` WRITE;
/*!40000 ALTER TABLE `user_role` DISABLE KEYS */;
INSERT INTO `user_role` VALUES (1,1,1),(2,3,1),(3,4,1),(4,5,1),(5,6,1),(6,7,1);
/*!40000 ALTER TABLE `user_role` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2019-12-04 12:00:42

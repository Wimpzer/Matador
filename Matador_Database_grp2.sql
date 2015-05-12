CREATE DATABASE  IF NOT EXISTS `matador` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `matador`;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user` (
  `usernumber` int(2) NOT NULL,
  `userName` varchar(45) DEFAULT NULL,
  `currentPosition` int(2) DEFAULT NULL,
  `balance` int(11) DEFAULT NULL,
  PRIMARY KEY (`usernumber`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `street`
--

DROP TABLE IF EXISTS `street`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `street` (
  `fieldNumber` int(2) NOT NULL,
  `ownerNumber` int(2) DEFAULT NULL,
  `houseAmount` int(1) DEFAULT NULL,
  `hotelAmount` int(1) DEFAULT NULL,
  PRIMARY KEY (`fieldNumber`),
  KEY `userNumber_idx` (`ownerNumber`),
  CONSTRAINT `fk_StreetUser` FOREIGN KEY (`ownerNumber`) REFERENCES `user` (`usernumber`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `shipping`
--

DROP TABLE IF EXISTS `shipping`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `shipping` (
  `fieldNumber` int(2) NOT NULL,
  `ownerNumber` int(2) DEFAULT NULL,
  PRIMARY KEY (`fieldNumber`),
  KEY `fk_ShippingUser_idx` (`ownerNumber`),
  CONSTRAINT `fk_ShippingUser` FOREIGN KEY (`ownerNumber`) REFERENCES `user` (`usernumber`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `brewery`
--

DROP TABLE IF EXISTS `brewery`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `brewery` (
  `fieldNumber` int(2) NOT NULL,
  `ownerNumber` int(2) DEFAULT NULL,
  PRIMARY KEY (`fieldNumber`),
  KEY `fk_BreweryUser_idx` (`ownerNumber`),
  CONSTRAINT `fk_BreweryUser` FOREIGN KEY (`ownerNumber`) REFERENCES `user` (`usernumber`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `controller`
--

DROP TABLE IF EXISTS `controller`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `controller` (
  `userTurn` int(11) NOT NULL,
  PRIMARY KEY (`userTurn`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;




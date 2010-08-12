-- MySQL Administrator dump 1.4
--
-- ------------------------------------------------------
-- Server version	5.1.37-1ubuntu5.4


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;


--
-- Create schema InfoCompany2
--

CREATE DATABASE IF NOT EXISTS InfoCompany2;
USE InfoCompany2;

--
-- Definition of table `InfoCompany2`.`Comment`
--

DROP TABLE IF EXISTS `InfoCompany2`.`Comment`;
CREATE TABLE  `InfoCompany2`.`Comment` (
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  `Text` varchar(255) DEFAULT NULL,
  `AbuseCount` int(11) DEFAULT NULL,
  `Date` date DEFAULT NULL,
  `UserId` int(11) NOT NULL,
  `CriticId` int(11) NOT NULL,
  PRIMARY KEY (`Id`),
  KEY `FK9BDE863FEA076F71` (`CriticId`),
  KEY `FK9BDE863FFFDF1FDF` (`UserId`)
) ENGINE=MyISAM AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `InfoCompany2`.`Comment`
--

/*!40000 ALTER TABLE `Comment` DISABLE KEYS */;
LOCK TABLES `Comment` WRITE;
INSERT INTO `InfoCompany2`.`Comment` VALUES  (2,'esta company es barata',0,'2010-08-11',2,2),
 (3,'esta company es barata',0,'2010-08-11',3,3);
UNLOCK TABLES;
/*!40000 ALTER TABLE `Comment` ENABLE KEYS */;


--
-- Definition of table `InfoCompany2`.`Company`
--

DROP TABLE IF EXISTS `InfoCompany2`.`Company`;
CREATE TABLE  `InfoCompany2`.`Company` (
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  `Version` int(11) NOT NULL,
  `Name` varchar(50) NOT NULL,
  `Industry` varchar(255) NOT NULL,
  PRIMARY KEY (`Id`)
) ENGINE=MyISAM AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `InfoCompany2`.`Company`
--

/*!40000 ALTER TABLE `Company` DISABLE KEYS */;
LOCK TABLES `Company` WRITE;
INSERT INTO `InfoCompany2`.`Company` VALUES  (2,0,'Finnegans','IT'),
 (3,0,'Finnegans','IT');
UNLOCK TABLES;
/*!40000 ALTER TABLE `Company` ENABLE KEYS */;


--
-- Definition of table `InfoCompany2`.`Country`
--

DROP TABLE IF EXISTS `InfoCompany2`.`Country`;
CREATE TABLE  `InfoCompany2`.`Country` (
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  `Name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`Id`)
) ENGINE=MyISAM AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `InfoCompany2`.`Country`
--

/*!40000 ALTER TABLE `Country` DISABLE KEYS */;
LOCK TABLES `Country` WRITE;
INSERT INTO `InfoCompany2`.`Country` VALUES  (2,'Chile'),
 (1,'Argentina');
UNLOCK TABLES;
/*!40000 ALTER TABLE `Country` ENABLE KEYS */;


--
-- Definition of table `InfoCompany2`.`Critic`
--

DROP TABLE IF EXISTS `InfoCompany2`.`Critic`;
CREATE TABLE  `InfoCompany2`.`Critic` (
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  `Version` int(11) NOT NULL,
  `Salary` int(11) DEFAULT NULL,
  `UserId` int(11) NOT NULL,
  `Country` varchar(255) DEFAULT NULL,
  `State` varchar(255) DEFAULT NULL,
  `industry` varchar(255) DEFAULT NULL,
  `job` varchar(255) DEFAULT NULL,
  `CompanyId` int(11) NOT NULL,
  PRIMARY KEY (`Id`),
  KEY `FK78CCA494E6B4EA27` (`CompanyId`),
  KEY `FK78CCA494FFDF1FDF` (`UserId`)
) ENGINE=MyISAM AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `InfoCompany2`.`Critic`
--

/*!40000 ALTER TABLE `Critic` DISABLE KEYS */;
LOCK TABLES `Critic` WRITE;
INSERT INTO `InfoCompany2`.`Critic` VALUES  (2,0,2800,2,'Argentina','Cordoba','IT','Programador Sr',2),
 (3,0,2800,3,'Argentina','Cordoba','IT','Programador Sr',3);
UNLOCK TABLES;
/*!40000 ALTER TABLE `Critic` ENABLE KEYS */;


--
-- Definition of table `InfoCompany2`.`CriticItem`
--

DROP TABLE IF EXISTS `InfoCompany2`.`CriticItem`;
CREATE TABLE  `InfoCompany2`.`CriticItem` (
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  `Tag` varchar(255) DEFAULT NULL,
  `Score` int(11) DEFAULT NULL,
  `CriticId` int(11) NOT NULL,
  PRIMARY KEY (`Id`),
  KEY `FK422329C7EA076F71` (`CriticId`)
) ENGINE=MyISAM AUTO_INCREMENT=7 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `InfoCompany2`.`CriticItem`
--

/*!40000 ALTER TABLE `CriticItem` DISABLE KEYS */;
LOCK TABLES `CriticItem` WRITE;
INSERT INTO `InfoCompany2`.`CriticItem` VALUES  (1,'Beneficios',10,2),
 (2,'Ambiente',4,2),
 (3,'Beneficios',10,3),
 (4,'Ambiente',4,3);
UNLOCK TABLES;
/*!40000 ALTER TABLE `CriticItem` ENABLE KEYS */;


--
-- Definition of table `InfoCompany2`.`Industry`
--

DROP TABLE IF EXISTS `InfoCompany2`.`Industry`;
CREATE TABLE  `InfoCompany2`.`Industry` (
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`Id`)
) ENGINE=MyISAM AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `InfoCompany2`.`Industry`
--

/*!40000 ALTER TABLE `Industry` DISABLE KEYS */;
LOCK TABLES `Industry` WRITE;
INSERT INTO `InfoCompany2`.`Industry` VALUES  (3,'Contruccion'),
 (2,'Farmaceutica'),
 (1,'IT');
UNLOCK TABLES;
/*!40000 ALTER TABLE `Industry` ENABLE KEYS */;


--
-- Definition of table `InfoCompany2`.`Item`
--

DROP TABLE IF EXISTS `InfoCompany2`.`Item`;
CREATE TABLE  `InfoCompany2`.`Item` (
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  `Name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`Id`)
) ENGINE=MyISAM AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `InfoCompany2`.`Item`
--

/*!40000 ALTER TABLE `Item` DISABLE KEYS */;
LOCK TABLES `Item` WRITE;
INSERT INTO `InfoCompany2`.`Item` VALUES  (4,'Beneficios'),
 (1,'Ambiente');
UNLOCK TABLES;
/*!40000 ALTER TABLE `Item` ENABLE KEYS */;


--
-- Definition of table `InfoCompany2`.`Job`
--

DROP TABLE IF EXISTS `InfoCompany2`.`Job`;
CREATE TABLE  `InfoCompany2`.`Job` (
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  `Name` varchar(255) DEFAULT NULL,
  `IndustryId` int(11) NOT NULL,
  PRIMARY KEY (`Id`),
  KEY `FK1239DC14DEC45` (`IndustryId`)
) ENGINE=MyISAM AUTO_INCREMENT=7 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `InfoCompany2`.`Job`
--

/*!40000 ALTER TABLE `Job` DISABLE KEYS */;
LOCK TABLES `Job` WRITE;
INSERT INTO `InfoCompany2`.`Job` VALUES  (6,'Capataz',0),
 (5,'Arquitecto',3),
 (4,'Supervisor',2),
 (3,'Analista de calidad',2),
 (2,'Programador Sr',1),
 (1,'Programador Jr',1);
UNLOCK TABLES;
/*!40000 ALTER TABLE `Job` ENABLE KEYS */;


--
-- Definition of table `InfoCompany2`.`State`
--

DROP TABLE IF EXISTS `InfoCompany2`.`State`;
CREATE TABLE  `InfoCompany2`.`State` (
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  `Name` varchar(255) DEFAULT NULL,
  `CountryId` int(11) NOT NULL,
  PRIMARY KEY (`Id`),
  KEY `FK4C7D4718BFABE19` (`CountryId`)
) ENGINE=MyISAM AUTO_INCREMENT=6 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `InfoCompany2`.`State`
--

/*!40000 ALTER TABLE `State` DISABLE KEYS */;
LOCK TABLES `State` WRITE;
INSERT INTO `InfoCompany2`.`State` VALUES  (5,'Valparaiso',2),
 (2,'Cordoba',1),
 (3,'Mendoza',1),
 (1,'Buenos Aires',1),
 (4,'Santiago de Chile',2);
UNLOCK TABLES;
/*!40000 ALTER TABLE `State` ENABLE KEYS */;


--
-- Definition of table `InfoCompany2`.`User`
--

DROP TABLE IF EXISTS `InfoCompany2`.`User`;
CREATE TABLE  `InfoCompany2`.`User` (
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  `Version` int(11) NOT NULL,
  `UserName` varchar(10) NOT NULL,
  `Password` varchar(20) NOT NULL,
  `Email` varchar(30) NOT NULL,
  `Reputation` int(11) DEFAULT NULL,
  `BirthdayYear` int(11) DEFAULT NULL,
  `IndustryName` varchar(255) DEFAULT NULL,
  `JobName` varchar(255) DEFAULT NULL,
  `Country` varchar(255) DEFAULT NULL,
  `State` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`Id`)
) ENGINE=MyISAM AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `InfoCompany2`.`User`
--

/*!40000 ALTER TABLE `User` DISABLE KEYS */;
LOCK TABLES `User` WRITE;
INSERT INTO `InfoCompany2`.`User` VALUES  (2,0,'nsuarez','password','nsuarez@hotmail.com',0,1984,'IT','Programador Sr','Argentina','Cordoba'),
 (3,0,'nsuarez','password','nsuarez@hotmail.com',0,1984,'IT','Programador Sr','Argentina','Cordoba');
UNLOCK TABLES;
/*!40000 ALTER TABLE `User` ENABLE KEYS */;




/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;

create database pos_jakarta_ee;

use pos_jakarta_ee;

DROP TABLE IF EXISTS `Customer`;

CREATE TABLE `Customer` (
  `id` varchar(30) NOT NULL,
  `name` varchar(40) DEFAULT NULL,
  `address` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

DROP TABLE IF EXISTS `Item`;

CREATE TABLE `Item` (
  `code` varchar(255) NOT NULL,
  `description` varchar(255) DEFAULT NULL,
  `qtyOnHand` int(10) DEFAULT NULL,
  `unitPrice` decimal(10,2) DEFAULT NULL,
  PRIMARY KEY (`code`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

DROP TABLE IF EXISTS `Orders`;

CREATE TABLE `Orders` (
  `oid` varchar(255) NOT NULL,
  `date` date DEFAULT NULL,
  `customerID` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`oid`),
  KEY `customerID` (`customerID`),
  CONSTRAINT `Orders_ibfk_1` FOREIGN KEY (`customerID`) REFERENCES `Customer` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

DROP TABLE IF EXISTS `OrderDetails`;

CREATE TABLE `OrderDetails` (
  `oid` varchar(255) NOT NULL,
  `itemCode` varchar(255) NOT NULL,
  `qty` int(10) DEFAULT NULL,
  `unitPrice` decimal(10,2) DEFAULT NULL,
  PRIMARY KEY (`oid`,`itemCode`),
  KEY `itemCode` (`itemCode`),
  CONSTRAINT `OrderDetails_ibfk_1` FOREIGN KEY (`oid`) REFERENCES `Orders` (`oid`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `OrderDetails_ibfk_2` FOREIGN KEY (`itemCode`) REFERENCES `Item` (`code`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

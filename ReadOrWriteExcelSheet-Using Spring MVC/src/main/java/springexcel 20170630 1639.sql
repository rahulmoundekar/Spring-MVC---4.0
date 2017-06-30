-- MySQL Administrator dump 1.4
--
-- ------------------------------------------------------
-- Server version	5.5.15


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;


--
-- Create schema springexcelsheet
--

CREATE DATABASE IF NOT EXISTS springexcelsheet;
USE springexcelsheet;

--
-- Definition of table `storedata`
--

DROP TABLE IF EXISTS `storedata`;
CREATE TABLE `storedata` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `actualHrs` varchar(255) DEFAULT NULL,
  `allocatedHrs` varchar(255) DEFAULT NULL,
  `assignedTask` varchar(255) DEFAULT NULL,
  `extraHrs` varchar(255) DEFAULT NULL,
  `projectName` varchar(255) DEFAULT NULL,
  `remark` varchar(255) DEFAULT NULL,
  `taskDate` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `storedata`
--

/*!40000 ALTER TABLE `storedata` DISABLE KEYS */;
INSERT INTO `storedata` (`id`,`actualHrs`,`allocatedHrs`,`assignedTask`,`extraHrs`,`projectName`,`remark`,`taskDate`) VALUES 
 (1,'0','8','retrieve employee List','Completed on Time','1','','8');
/*!40000 ALTER TABLE `storedata` ENABLE KEYS */;


--
-- Definition of table `uploaditem`
--

DROP TABLE IF EXISTS `uploaditem`;
CREATE TABLE `uploaditem` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `file` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `uploaditem`
--

/*!40000 ALTER TABLE `uploaditem` DISABLE KEYS */;
/*!40000 ALTER TABLE `uploaditem` ENABLE KEYS */;




/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;

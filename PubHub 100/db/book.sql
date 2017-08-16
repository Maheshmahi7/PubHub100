/*
SQLyog Ultimate v12.09 (32 bit)
MySQL - 5.6.10 : Database - pubhub
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`pubhub` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `pubhub`;

/*Table structure for table `book_tags` */

DROP TABLE IF EXISTS `book_tags`;

CREATE TABLE `book_tags` (
  `isbn_13` varchar(13) NOT NULL,
  `tag_name` varchar(50) NOT NULL,
  UNIQUE KEY `ISBN_13` (`isbn_13`,`tag_name`),
  CONSTRAINT `FK_ISBN_13` FOREIGN KEY (`isbn_13`) REFERENCES `books` (`isbn_13`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `book_tags` */

insert  into `book_tags`(`isbn_13`,`tag_name`) values ('1111111111111','Adventure'),('2222222222222','Biography'),('2222222222222','Fiction'),('3333333333333','Adventure'),('3333333333333','Animation Story'),('3333333333333','FairyTale');

/*Table structure for table `books` */

DROP TABLE IF EXISTS `books`;

CREATE TABLE `books` (
  `isbn_13` varchar(13) NOT NULL,
  `title` varchar(100) DEFAULT NULL,
  `author` varchar(80) DEFAULT NULL,
  `publish_date` date DEFAULT NULL,
  `price` decimal(6,2) DEFAULT NULL,
  `content` text,
  PRIMARY KEY (`isbn_13`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `books` */

insert  into `books`(`isbn_13`,`title`,`author`,`publish_date`,`price`,`content`) values ('1111111111111','The Adventures of Steve','Russell Barron','2017-08-13','123.50',NULL),('2222222222222','The Bio-graphy of Avatar','Aston','2017-08-14','150.00',NULL),('3333333333333','Nightinggale','Billy','2017-08-14','100.00',NULL);

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

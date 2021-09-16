/*
SQLyog Ultimate v13.1.1 (64 bit)
MySQL - 5.6.51 : Database - book
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`book` /*!40100 DEFAULT CHARACTER SET utf8mb4 */;

USE `book`;

/*Table structure for table `t_book` */

DROP TABLE IF EXISTS `t_book`;

CREATE TABLE `t_book` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) NOT NULL,
  `author` varchar(50) NOT NULL,
  `price` decimal(11,2) NOT NULL,
  `sales` int(11) NOT NULL,
  `stock` int(11) NOT NULL,
  `img_path` varchar(200) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8mb4;

/*Data for the table `t_book` */

insert  into `t_book`(`id`,`name`,`author`,`price`,`sales`,`stock`,`img_path`) values 
(1,'风月宝鉴','假宝玉',10.00,551,117,'static/img/default.jpg'),
(2,'数据结构与算法','沈从文',78.50,20,-1,'static/img/default.jpg'),
(3,'富婆通讯录','龙伍',68.00,99999,52,'static/img/default.jpg'),
(5,'C++编程思想','刚哥',45.50,18,91,'static/img/default.jpg'),
(6,'蛋炒饭','周星星',9.90,12,53,'static/img/default.jpg'),
(7,'赌神','龙伍',66.50,125,535,'static/img/default.jpg'),
(8,'Java编程思想1','阳哥',99.50,47,36,'static/img/default.jpg'),
(9,'JavaScript从入门到精通','婷姐',9.90,85,95,'static/img/default.jpg'),
(10,'cocos2d-x游戏编程入门','国哥',49.00,52,62,'static/img/default.jpg'),
(11,'C语言程序设计','谭浩强',28.00,52,74,'static/img/default.jpg'),
(12,'Lua语言程序设计','雷丰阳',51.50,48,82,'static/img/default.jpg'),
(13,'西游记','罗贯中',12.00,19,9999,'static/img/default.jpg'),
(14,'水浒传','华仔',33.05,22,88,'static/img/default.jpg'),
(15,'操作系统原理','刘优',133.05,122,188,'static/img/default.jpg'),
(17,'UNIX高级环境编程','乐天',99.15,210,810,'static/img/default.jpg'),
(18,'javaScript高级编程','国哥',69.15,210,810,'static/img/default.jpg'),
(19,'大话设计模式','国哥',89.15,20,10,'static/img/default.jpg'),
(20,'人月神话1','刚哥',88.15,20,80,'static/img/default.jpg');

/*Table structure for table `t_order` */

DROP TABLE IF EXISTS `t_order`;

CREATE TABLE `t_order` (
  `order_id` varchar(50) NOT NULL,
  `create_time` datetime NOT NULL,
  `total_money` decimal(11,2) NOT NULL,
  `status` int(11) NOT NULL DEFAULT '0',
  `user_id` int(11) NOT NULL,
  PRIMARY KEY (`order_id`),
  KEY `user_id` (`user_id`),
  CONSTRAINT `t_order_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `t_user` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

/*Data for the table `t_order` */

/*Table structure for table `t_order_item` */

DROP TABLE IF EXISTS `t_order_item`;

CREATE TABLE `t_order_item` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(30) NOT NULL,
  `price` decimal(11,2) DEFAULT NULL,
  `total_money` decimal(11,2) DEFAULT NULL,
  `count` int(11) NOT NULL,
  `order_id` varchar(50) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `order_id` (`order_id`),
  CONSTRAINT `t_order_item_ibfk_1` FOREIGN KEY (`order_id`) REFERENCES `t_order` (`order_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

/*Data for the table `t_order_item` */

/*Table structure for table `t_user` */

DROP TABLE IF EXISTS `t_user`;

CREATE TABLE `t_user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(50) NOT NULL,
  `password` varchar(32) NOT NULL,
  `email` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `username` (`username`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8mb4;

/*Data for the table `t_user` */

insert  into `t_user`(`id`,`username`,`password`,`email`) values 
(1,'张','123456','wzg168@qq.com'),
(2,'admin','123456','admin@zzf.com'),
(3,'段誉','77889','duanyu@qq.com'),
(4,'zhang','12345','aaa@qq.com'),
(5,'liyishan','123456','liyishan@qq.com'),
(6,'llllll','111111','12@qq.com'),
(7,'admin123','123456','zzz@qq.com'),
(8,'admin123456','123456','aad@qq.com'),
(9,'rootroot','123456','root@zzf.com'),
(10,'zhongzifeng','123456','123@qq.com'),
(11,'admin1','123456','123@qq.com'),
(12,'pinpin','123456','pin@xiaoxiang.com'),
(13,'pinpin2','123456','pin@xiaoxiang.com'),
(14,'zhongzif','12345','zzf@qq.com'),
(15,'admin12345','123456','123@qq.com');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

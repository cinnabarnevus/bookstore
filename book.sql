
CREATE DATABASE /*!32312 IF NOT EXISTS*/`book` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `book`;

CREATE TABLE `bookinfo` (
  `id` int(11) NOT NULL,
  `name` varchar(20) DEFAULT NULL,
  `author` varchar(20) DEFAULT NULL,
  `price` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
CREATE TABLE `t_book` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(100) DEFAULT NULL,
  `price` decimal(11,2) DEFAULT NULL,
  `author` varchar(100) DEFAULT NULL,
  `sales` int(11) DEFAULT NULL,
  `stock` int(11) DEFAULT NULL,
  `img_path` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=23 DEFAULT CHARSET=utf8;

CREATE TABLE `t_user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(20) NOT NULL,
  `password` varchar(32) NOT NULL,
  `email` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `username` (`username`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

CREATE TABLE `userinfo` (
  `id` int(11) NOT NULL,
  `name` varchar(20) DEFAULT NULL,
  `pwd` varchar(20) DEFAULT NULL,
  `age` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
CREATE TABLE `t_order` (
  `order_id` varchar(50) NOT NULL,
  `create_time` datetime DEFAULT NULL,
  `price` decimal(11,2) DEFAULT NULL,
  `status` int(11) DEFAULT NULL,
  `user_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`order_id`),
  KEY `user_id` (`user_id`),
  CONSTRAINT `t_order_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `t_user` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `t_order_item` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(100) DEFAULT NULL,
  `count` int(11) DEFAULT NULL,
  `price` decimal(11,2) DEFAULT NULL,
  `total_price` decimal(11,2) DEFAULT NULL,
  `order_id` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `order_id` (`order_id`),
  CONSTRAINT `t_order_item_ibfk_1` FOREIGN KEY (`order_id`) REFERENCES `t_order` (`order_id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;


CREATE TABLE `tb_books` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(100) DEFAULT NULL,
  `price` decimal(11,2) DEFAULT NULL,
  `author` varchar(100) DEFAULT NULL,
  `bookcount` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=25 DEFAULT CHARSET=utf8;

insert  into `bookinfo`(`id`,`name`,`author`,`price`) values (1,'c语言','作者1',30),(2,'R语言','作者2',40),(3,'T语言','作者2',40);
insert  into `t_book`(`id`,`name`,`price`,`author`,`sales`,`stock`,`img_path`) values (2,'数据结构与算法','78.50','严敏君',6,13,'static/img/default.jpg'),(4,'新的书名','16.00','新的作者',1002,48,'static/img/default.jpg'),(5,'C++编程思想','45.50','刚哥',16,93,'static/img/default.jpg'),(6,'蛋炒饭','9.90','周星星',12,53,'static/img/default.jpg'),(7,'赌神','66.50','龙伍',125,535,'static/img/default.jpg'),(8,'Java编程思想','99.50','阳哥',47,36,'static/img/default.jpg'),(9,'JavaScript从入门到精通','9.90','婷姐',85,95,'static/img/default.jpg'),(10,'cocos2d-x游戏编程入门','49.00','国哥',52,62,'static/img/default.jpg'),(11,'C语言程序设计','28.00','谭浩强',52,74,'static/img/default.jpg'),(12,'Lua语言程序设计','51.50','雷丰阳',48,82,'static/img/default.jpg'),(13,'西游记','12.00','罗贯中',19,9999,'static/img/default.jpg'),(14,'水浒传','33.05','华仔',22,88,'static/img/default.jpg'),(15,'操作系统原理','133.05','刘优',122,188,'static/img/default.jpg'),(16,'数据结构 java版','173.15','封大神',21,81,'static/img/default.jpg'),(17,'UNIX高级环境编程','99.15','乐天',210,810,'static/img/default.jpg'),(18,'javaScript高级编程','69.15','国哥',210,810,'static/img/default.jpg'),(19,'大话设计模式','89.15','国哥',20,10,'static/img/default.jpg'),(20,'人月神话','88.15','刚哥',20,80,'static/img/default.jpg'),(21,'gg','23.00','张三',4,9,'static/img/default.jpg'),(22,'gg','23.00','李四',3,10,'static/img/default.jpg');
insert  into `t_order`(`order_id`,`create_time`,`price`,`status`,`user_id`) values ('16526075376571','2022-05-15 17:38:57','71.40',0,1),('16526076488311','2022-05-15 17:40:48','61.50',0,1),('16526077358481','2022-05-15 17:42:15','61.50',0,1),('16526077531511','2022-05-15 17:42:33','0.00',0,1),('16526112798921','2022-05-15 18:41:19','84.50',0,1);
insert  into `t_order_item`(`id`,`name`,`count`,`price`,`total_price`,`order_id`) values (1,'新的书名',1,'16.00','16.00','16526077358481'),(2,'C++编程思想',1,'45.50','45.50','16526077358481'),(3,'新的书名',1,'16.00','16.00','16526112798921'),(4,'C++编程思想',1,'45.50','45.50','16526112798921'),(5,'gg',1,'23.00','23.00','16526112798921');
insert  into `t_user`(`id`,`username`,`password`,`email`) values (1,'admin','admin','admin@atguigu.com'),(2,'aa','aaa','aaaa'),(3,'q','q','qqq@qq.com'),(4,'qqqqq','qqqqq','qqqq@qq.com'),(5,'aaaaa','aaaaa','aaaa@qq.com');
insert  into `tb_books`(`id`,`name`,`price`,`author`,`bookcount`) values (1,'java从入门到放弃','80.00','国哥',9),(2,'数据结构与算法','78.50','严敏君',13),(4,'木虚肉盖饭','16.00','小胖',50),(5,'C++编程思想','45.50','刚哥',95),(6,'蛋炒饭','9.90','周星星',52),(7,'赌神','66.50','龙伍',535),(8,'Java编程思想','99.50','阳哥',36),(9,'JavaScript从入门到精通','9.90','婷姐',90),(10,'cocos2d-x游戏编程入门','49.00','国哥',62),(12,'Lua语言程序设计','51.50','雷丰阳',-19),(13,'西游记','12.00','罗贯中',9996),(14,'水浒传','33.05','华仔',88),(15,'操作系统原理','133.05','刘优',183),(16,'数据结构 java版','173.15','封大神',81),(17,'UNIX高级环境编程','99.15','乐天',810),(18,'javaScript高级编程','69.15','国哥',810),(19,'大话设计模式','89.15','国哥',10),(23,'新书1','34.00','李四',10),(24,'新书','23.00','张三',10);
insert  into `userinfo`(`id`,`name`,`pwd`,`age`) values (1,'admin','admin',10),(2,NULL,NULL,NULL),(10,'zhangsan','123',20),(11,'lisi','456',30);

CREATE DATABASE `social_api` /*!40100 DEFAULT CHARACTER SET latin1 */;

CREATE TABLE `activities` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `type` int(11) NOT NULL,
  `app_id` varchar(8) NOT NULL,
  `product_id` varchar(45) NOT NULL,
  `user_id` varchar(45) NOT NULL,
  `timestamp` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  KEY `ref_id_app_idx` (`app_id`),
  CONSTRAINT `ref_id_application` FOREIGN KEY (`app_id`) REFERENCES `applications` (`id`) ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=58 DEFAULT CHARSET=utf8;


CREATE TABLE `applications` (
  `id` varchar(8) NOT NULL,
  `user_id` varchar(45) NOT NULL,
  `description` varchar(45) DEFAULT NULL,
  `creation_date` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  UNIQUE KEY `ID_UNIQUE` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `comments` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `activity_id` int(11) NOT NULL,
  `content` text,
  `note` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `ref_activity_id_idx` (`activity_id`),
  CONSTRAINT `ref_activity_id` FOREIGN KEY (`activity_id`) REFERENCES `activities` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8;

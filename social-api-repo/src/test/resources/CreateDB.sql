/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;

-- Export de la structure de table social_api. applications
CREATE TABLE IF NOT EXISTS `applications` (
  `id` varchar(8) NOT NULL,
  `user_id` varchar(45) NOT NULL,
  `description` varchar(45) DEFAULT NULL,
  `creation_date` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  UNIQUE KEY `ID_UNIQUE` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*!40000 ALTER TABLE `applications` DISABLE KEYS */;
INSERT INTO `applications` (`id`, `user_id`, `description`, `creation_date`) VALUES
	('APP-1', 'qing.liang-ext@amundi.com', 'A sample application for test', '2016-05-23 00:00:00'),
	('APP-2', 'qing.liang-ext@amundi.com', 'Another sample application for test', '2016-05-22 00:00:00'),
	('APP-3', 'prenom.nom@amundi.com', 'Yet another sample application for test', '2016-05-22 00:00:00');
/*!40000 ALTER TABLE `applications` ENABLE KEYS */;

-- Export de la structure de table social_api. activities
CREATE TABLE IF NOT EXISTS `activities` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `type` int(11) NOT NULL,
  `app_id` varchar(8) NOT NULL,
  `product_id` varchar(45) NOT NULL,
  `user_id` varchar(45) NOT NULL,
  `timestamp` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  FOREIGN KEY (`app_id`) REFERENCES `applications` (`id`) ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=58 DEFAULT CHARSET=utf8;

/*!40000 ALTER TABLE `activities` DISABLE KEYS */;
INSERT INTO `activities` (`id`, `type`, `app_id`, `product_id`, `user_id`, `timestamp`) VALUES
	(2, 1, 'APP-1', 'DGC-002', 'qing.liang-ext@amundi.com', '2016-05-17 15:22:00'),
	(3, 1, 'APP-1', 'DGC-004', 'prenom.nom@amundi.com', '2016-05-17 17:11:56'),
	(7, 1, 'APP-2', 'ALTO-001', 'prenom.nom@amundi.com', '2016-05-17 17:22:02'),
	(8, 1, 'APP-2', 'ALTO-001', 'prenom.nom@amundi.com', '2016-05-17 17:57:03'),
	(9, 2, 'APP-1', 'DGC-001', 'qing.liang-ext@amundi.com', '2016-05-17 18:44:01'),
	(10, 2, 'APP-1', 'DGC-001', 'prenom.nom@amundi.com', '2016-05-17 18:44:01'),
	(11, 3, 'APP-1', 'DGC-001', 'qing.liang-ext@amundi.com', '2016-05-17 18:44:01'),
	(16, 1, 'APP-1', 'DGC-003', 'qing.liang-ext@amundi.com', '2016-05-20 11:22:34'),
	(17, 1, 'APP-1', 'DGC-004', 'qing.liang-ext@amundi.com', '2016-05-20 11:22:41'),
	(19, 1, 'APP-1', 'DGC-006', 'qing.liang-ext@amundi.com', '2016-05-20 11:22:57'),
	(21, 1, 'APP-1', 'DGC-005', 'qing.liang-ext@amundi.com', '2016-05-20 15:22:21'),
	(22, 3, 'APP-1', 'DGC-005', 'qing.liang-ext@amundi.com', '2016-05-20 15:27:34'),
	(23, 3, 'APP-1', 'DGC-002', 'qing.liang-ext@amundi.com', '2016-05-20 15:27:43'),
	(24, 3, 'APP-1', 'DGC-003', 'qing.liang-ext@amundi.com', '2016-05-20 15:27:45'),
	(25, 3, 'APP-1', 'DGC-004', 'qing.liang-ext@amundi.com', '2016-05-20 15:27:48'),
	(26, 3, 'APP-1', 'DGC-006', 'qing.liang-ext@amundi.com', '2016-05-20 15:28:10'),
	(30, 1, 'APP-1', 'DGC-001', 'qing.liang-ext@amundi.com', '2016-05-26 15:13:49'),
	(39, 1, 'APP-1', 'DGC-009', 'qing.liang-ext@amundi.com', '2016-05-27 11:37:07'),
	(41, 1, 'APP-1', 'DGC-010', 'qing.liang-ext@amundi.com', '2016-05-27 12:09:01'),
	(43, 2, 'APP-1', 'DGC-010', 'qing.liang-ext@amundi.com', '2016-05-27 14:04:05'),
	(44, 2, 'APP-1', 'DGC-010', 'qing.liang-ext@amundi.com', '2016-05-27 14:09:06'),
	(45, 2, 'APP-1', 'DGC-010', 'qing.liang-ext@amundi.com', '2016-05-27 14:10:25'),
	(46, 2, 'APP-1', 'DGC-011', 'qing.liang-ext@amundi.com', '2016-05-27 14:10:35'),
	(47, 2, 'APP-1', 'DGC-011', 'qing.liang-ext@amundi.com', '2016-05-27 14:27:01'),
	(50, 4, 'APP-1', 'DGC-011', 'qing.liang-ext@amundi.com', '2016-05-27 15:26:15'),
	(51, 4, 'APP-1', 'DGC-011', 'qing.liang@amundi.com', '2016-05-27 16:40:03'),
	(52, 4, 'APP-1', 'DGC-010', 'qing.liang-ext@amundi.com', '2016-05-30 12:38:42'),
	(53, 2, 'APP-1', 'DGC-011', 'qing.liang-ext@amundi.com', '2016-05-30 12:38:42'),
	(54, 4, 'APP-1', 'DGC-010', 'qing.liang-ext@amundi.com', '2016-06-02 11:35:34'),
	(55, 2, 'APP-1', 'DGC-011', 'qing.liang-ext@amundi.com', '2016-06-02 11:35:34'),
	(56, 4, 'APP-1', 'DGC-010', 'qing.liang-ext@amundi.com', '2016-06-02 12:41:20'),
	(57, 2, 'APP-1', 'DGC-011', 'qing.liang-ext@amundi.com', '2016-06-02 12:41:20');
/*!40000 ALTER TABLE `activities` ENABLE KEYS */;

-- Export de la structure de table social_api. comments
CREATE TABLE IF NOT EXISTS `comments` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `activity_id` int(11) NOT NULL,
  `content` text,
  `note` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  FOREIGN KEY (`activity_id`) REFERENCES `activities` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8;

/*!40000 ALTER TABLE `comments` DISABLE KEYS */;
INSERT INTO `comments` (`id`, `activity_id`, `content`, `note`) VALUES
	(13, 50, 'a test content', 2),
	(14, 51, 'a text', 5),
	(15, 56, 'a test content', 2);
/*!40000 ALTER TABLE `comments` ENABLE KEYS */;
/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;

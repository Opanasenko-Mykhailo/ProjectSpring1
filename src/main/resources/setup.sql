CREATE DATABASE IF NOT EXISTS `springDB` /*!40100 DEFAULT CHARACTER SET utf8mb4 */;
USE `springDB`;
DROP TABLE IF EXISTS `task`;
/*!40101 SET @saved_cs_client = @character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `task` (
                        `id` int(11) NOT NULL AUTO_INCREMENT,
                        `description` varchar(100) NOT NULL,
                        `status` int(11) NOT NULL,
                        PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8mb4;
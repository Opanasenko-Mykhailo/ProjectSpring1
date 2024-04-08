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
INSERT INTO `task` (`description`, `status`) VALUES
                                                 ('Task 1', 1),
                                                 ('Task 2', 0),
                                                 ('Task 3', 1),
                                                 ('Task 4', 0),
                                                 ('Task 5', 1),
                                                 ('Task 6', 0),
                                                 ('Task 7', 1),
                                                 ('Task 8', 0),
                                                 ('Task 9', 1),
                                                 ('Task 10', 0),
                                                 ('Task 11', 1),
                                                 ('Task 12', 0),
                                                 ('Task 13', 1),
                                                 ('Task 14', 0),
                                                 ('Task 15', 1),
                                                 ('Task 16', 0),
                                                 ('Task 17', 1),
                                                 ('Task 18', 0),
                                                 ('Task 19', 1),
                                                 ('Task 20', 0);

-- hsqldb
-- DROP TABLE people IF EXISTS;
-- CREATE TABLE people  (
--     person_id BIGINT IDENTITY NOT NULL PRIMARY KEY,
--     first_name VARCHAR(20),
--     last_name VARCHAR(20)
-- );

-- mysql 不能有 IDENTITY，要改为AUTO_INCREMENT自增长
DROP TABLE IF EXISTS `people`;
CREATE TABLE `people` (
  `person_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `first_name` varchar(20) COLLATE utf8_bin DEFAULT NULL,
  `last_name` varchar(20) COLLATE utf8_bin DEFAULT NULL,
  PRIMARY KEY (`person_id`)
) /*!50100 TABLESPACE `innodb_system` */ ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

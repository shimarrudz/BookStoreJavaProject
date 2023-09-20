-- --------------------------------------------------------
-- Servidor:                     127.0.0.1
-- Versão do servidor:           10.6.7-MariaDB - mariadb.org binary distribution
-- OS do Servidor:               Win64
-- HeidiSQL Versão:              11.3.0.6295
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;


-- Copiando estrutura do banco de dados para bookstore-benezinho-2tdspr
CREATE DATABASE IF NOT EXISTS `bookstore-benezinho-2tdspr` /*!40100 DEFAULT CHARACTER SET utf8mb3 */;
USE `bookstore-benezinho-2tdspr`;

-- Copiando estrutura para tabela bookstore-benezinho-2tdspr.sq_author
CREATE TABLE IF NOT EXISTS `sq_author` (
  `next_not_cached_value` bigint(21) NOT NULL,
  `minimum_value` bigint(21) NOT NULL,
  `maximum_value` bigint(21) NOT NULL,
  `start_value` bigint(21) NOT NULL COMMENT 'start value when sequences is created or value if RESTART is used',
  `increment` bigint(21) NOT NULL COMMENT 'increment value',
  `cache_size` bigint(21) unsigned NOT NULL,
  `cycle_option` tinyint(1) unsigned NOT NULL COMMENT '0 if no cycles are allowed, 1 if the sequence should begin a new cycle when maximum_value is passed',
  `cycle_count` bigint(21) NOT NULL COMMENT 'How many cycles have been done'
) ENGINE=InnoDB SEQUENCE=1;

-- Copiando dados para a tabela bookstore-benezinho-2tdspr.sq_author: ~1 rows (aproximadamente)
/*!40000 ALTER TABLE `sq_author` DISABLE KEYS */;
INSERT IGNORE INTO `sq_author` (`next_not_cached_value`, `minimum_value`, `maximum_value`, `start_value`, `increment`, `cache_size`, `cycle_option`, `cycle_count`) VALUES
	(50001, 1, 9223372036854775806, 1, 50, 1000, 0, 0);
/*!40000 ALTER TABLE `sq_author` ENABLE KEYS */;

-- Copiando estrutura para tabela bookstore-benezinho-2tdspr.sq_book
CREATE TABLE IF NOT EXISTS `sq_book` (
  `next_not_cached_value` bigint(21) NOT NULL,
  `minimum_value` bigint(21) NOT NULL,
  `maximum_value` bigint(21) NOT NULL,
  `start_value` bigint(21) NOT NULL COMMENT 'start value when sequences is created or value if RESTART is used',
  `increment` bigint(21) NOT NULL COMMENT 'increment value',
  `cache_size` bigint(21) unsigned NOT NULL,
  `cycle_option` tinyint(1) unsigned NOT NULL COMMENT '0 if no cycles are allowed, 1 if the sequence should begin a new cycle when maximum_value is passed',
  `cycle_count` bigint(21) NOT NULL COMMENT 'How many cycles have been done'
) ENGINE=InnoDB SEQUENCE=1;

-- Copiando dados para a tabela bookstore-benezinho-2tdspr.sq_book: ~1 rows (aproximadamente)
/*!40000 ALTER TABLE `sq_book` DISABLE KEYS */;
INSERT IGNORE INTO `sq_book` (`next_not_cached_value`, `minimum_value`, `maximum_value`, `start_value`, `increment`, `cache_size`, `cycle_option`, `cycle_count`) VALUES
	(50001, 1, 9223372036854775806, 1, 50, 1000, 0, 0);
/*!40000 ALTER TABLE `sq_book` ENABLE KEYS */;

-- Copiando estrutura para tabela bookstore-benezinho-2tdspr.sq_pessoa
CREATE TABLE IF NOT EXISTS `sq_pessoa` (
  `next_not_cached_value` bigint(21) NOT NULL,
  `minimum_value` bigint(21) NOT NULL,
  `maximum_value` bigint(21) NOT NULL,
  `start_value` bigint(21) NOT NULL COMMENT 'start value when sequences is created or value if RESTART is used',
  `increment` bigint(21) NOT NULL COMMENT 'increment value',
  `cache_size` bigint(21) unsigned NOT NULL,
  `cycle_option` tinyint(1) unsigned NOT NULL COMMENT '0 if no cycles are allowed, 1 if the sequence should begin a new cycle when maximum_value is passed',
  `cycle_count` bigint(21) NOT NULL COMMENT 'How many cycles have been done'
) ENGINE=InnoDB SEQUENCE=1;

-- Copiando dados para a tabela bookstore-benezinho-2tdspr.sq_pessoa: ~1 rows (aproximadamente)
/*!40000 ALTER TABLE `sq_pessoa` DISABLE KEYS */;
INSERT IGNORE INTO `sq_pessoa` (`next_not_cached_value`, `minimum_value`, `maximum_value`, `start_value`, `increment`, `cache_size`, `cycle_option`, `cycle_count`) VALUES
	(100001, 1, 9223372036854775806, 1, 50, 1000, 0, 0);
/*!40000 ALTER TABLE `sq_pessoa` ENABLE KEYS */;

-- Copiando estrutura para tabela bookstore-benezinho-2tdspr.sq_user
CREATE TABLE IF NOT EXISTS `sq_user` (
  `next_not_cached_value` bigint(21) NOT NULL,
  `minimum_value` bigint(21) NOT NULL,
  `maximum_value` bigint(21) NOT NULL,
  `start_value` bigint(21) NOT NULL COMMENT 'start value when sequences is created or value if RESTART is used',
  `increment` bigint(21) NOT NULL COMMENT 'increment value',
  `cache_size` bigint(21) unsigned NOT NULL,
  `cycle_option` tinyint(1) unsigned NOT NULL COMMENT '0 if no cycles are allowed, 1 if the sequence should begin a new cycle when maximum_value is passed',
  `cycle_count` bigint(21) NOT NULL COMMENT 'How many cycles have been done'
) ENGINE=InnoDB SEQUENCE=1;

-- Copiando dados para a tabela bookstore-benezinho-2tdspr.sq_user: ~1 rows (aproximadamente)
/*!40000 ALTER TABLE `sq_user` DISABLE KEYS */;
INSERT IGNORE INTO `sq_user` (`next_not_cached_value`, `minimum_value`, `maximum_value`, `start_value`, `increment`, `cache_size`, `cycle_option`, `cycle_count`) VALUES
	(1, 1, 9223372036854775806, 1, 50, 1000, 0, 0);
/*!40000 ALTER TABLE `sq_user` ENABLE KEYS */;

-- Copiando estrutura para tabela bookstore-benezinho-2tdspr.tb_author
CREATE TABLE IF NOT EXISTS `tb_author` (
  `ID_AUTHOR` bigint(20) NOT NULL,
  `pessoa` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`ID_AUTHOR`),
  KEY `FK_AUTHOR_PESSOA` (`pessoa`),
  CONSTRAINT `FK_AUTHOR_PESSOA` FOREIGN KEY (`pessoa`) REFERENCES `tb_pf` (`ID_PESSOA`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;

-- Copiando dados para a tabela bookstore-benezinho-2tdspr.tb_author: ~0 rows (aproximadamente)
/*!40000 ALTER TABLE `tb_author` DISABLE KEYS */;
INSERT IGNORE INTO `tb_author` (`ID_AUTHOR`, `pessoa`) VALUES
	(1, 2),
	(2, 3);
/*!40000 ALTER TABLE `tb_author` ENABLE KEYS */;

-- Copiando estrutura para tabela bookstore-benezinho-2tdspr.tb_book
CREATE TABLE IF NOT EXISTS `tb_book` (
  `ID_BOOK` bigint(20) NOT NULL,
  `ISBN_BOOK` varchar(255) NOT NULL,
  `DT_LAUNCH` datetime(6) DEFAULT NULL,
  `NM_BOOK` varchar(255) NOT NULL,
  PRIMARY KEY (`ID_BOOK`),
  UNIQUE KEY `UK_ISBN_BOOK` (`ISBN_BOOK`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;

-- Copiando dados para a tabela bookstore-benezinho-2tdspr.tb_book: ~0 rows (aproximadamente)
/*!40000 ALTER TABLE `tb_book` DISABLE KEYS */;
INSERT IGNORE INTO `tb_book` (`ID_BOOK`, `ISBN_BOOK`, `DT_LAUNCH`, `NM_BOOK`) VALUES
	(1, 'b6b88720-c1ce-4a72-badc-c2ddeb4cabfb', '2023-09-15 22:36:27.208418', 'Memórias de Benezinho');
/*!40000 ALTER TABLE `tb_book` ENABLE KEYS */;

-- Copiando estrutura para tabela bookstore-benezinho-2tdspr.tb_book_author
CREATE TABLE IF NOT EXISTS `tb_book_author` (
  `BOOK` bigint(20) NOT NULL,
  `AUTHOR` bigint(20) NOT NULL,
  PRIMARY KEY (`BOOK`,`AUTHOR`),
  KEY `FK_AUTHOR_BOOK` (`AUTHOR`),
  CONSTRAINT `FK_AUTHOR_BOOK` FOREIGN KEY (`AUTHOR`) REFERENCES `tb_author` (`ID_AUTHOR`),
  CONSTRAINT `FK_BOOK_AUTHOR` FOREIGN KEY (`BOOK`) REFERENCES `tb_book` (`ID_BOOK`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;

-- Copiando dados para a tabela bookstore-benezinho-2tdspr.tb_book_author: ~0 rows (aproximadamente)
/*!40000 ALTER TABLE `tb_book_author` DISABLE KEYS */;
INSERT IGNORE INTO `tb_book_author` (`BOOK`, `AUTHOR`) VALUES
	(1, 1),
	(1, 2);
/*!40000 ALTER TABLE `tb_book_author` ENABLE KEYS */;

-- Copiando estrutura para tabela bookstore-benezinho-2tdspr.tb_pessoa
CREATE TABLE IF NOT EXISTS `tb_pessoa` (
  `TP_PESSOA` varchar(31) NOT NULL,
  `ID_PESSOA` bigint(20) NOT NULL,
  `DT_NASCIMENTO` date DEFAULT NULL,
  `NM_PESSOA` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`ID_PESSOA`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;

-- Copiando dados para a tabela bookstore-benezinho-2tdspr.tb_pessoa: ~5 rows (aproximadamente)
/*!40000 ALTER TABLE `tb_pessoa` DISABLE KEYS */;
INSERT IGNORE INTO `tb_pessoa` (`TP_PESSOA`, `ID_PESSOA`, `DT_NASCIMENTO`, `NM_PESSOA`) VALUES
	('PJ', 1, '2018-09-15', 'Holding Benezinho SA'),
	('PF', 2, '1977-03-08', 'Benefrancis do Nascimento'),
	('PF', 3, '2006-09-15', 'Vinicius Cruzeiro Barbosa'),
	('PF', 49952, '2000-05-15', 'Bruno Sudré do Nascimento'),
	('PF', 50002, '2000-05-15', 'Bruno Sudré do Nascimento'),
	('PF', 50052, '2000-05-15', 'Bruno Sudré do Nascimento');
/*!40000 ALTER TABLE `tb_pessoa` ENABLE KEYS */;

-- Copiando estrutura para tabela bookstore-benezinho-2tdspr.tb_pf
CREATE TABLE IF NOT EXISTS `tb_pf` (
  `NR_CPF` varchar(255) NOT NULL,
  `ID_PESSOA` bigint(20) NOT NULL,
  PRIMARY KEY (`ID_PESSOA`),
  UNIQUE KEY `UK_PF_CPF` (`NR_CPF`),
  CONSTRAINT `FKo14w6uw4ru9105ls0g72jayei` FOREIGN KEY (`ID_PESSOA`) REFERENCES `tb_pessoa` (`ID_PESSOA`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;

-- Copiando dados para a tabela bookstore-benezinho-2tdspr.tb_pf: ~4 rows (aproximadamente)
/*!40000 ALTER TABLE `tb_pf` DISABLE KEYS */;
INSERT IGNORE INTO `tb_pf` (`NR_CPF`, `ID_PESSOA`) VALUES
	('131231321', 3),
	('212132132', 50052),
	('213124164', 2),
	('213132132', 50002),
	('231546535', 49952);
/*!40000 ALTER TABLE `tb_pf` ENABLE KEYS */;

-- Copiando estrutura para tabela bookstore-benezinho-2tdspr.tb_pj
CREATE TABLE IF NOT EXISTS `tb_pj` (
  `NR_CNPJ` varchar(255) DEFAULT NULL,
  `ID_PESSOA` bigint(20) NOT NULL,
  PRIMARY KEY (`ID_PESSOA`),
  UNIQUE KEY `UK_PJ_CNPJ` (`NR_CNPJ`),
  CONSTRAINT `FK2f1f5uwwiv1xqrn1dxg9r5mqm` FOREIGN KEY (`ID_PESSOA`) REFERENCES `tb_pessoa` (`ID_PESSOA`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;

-- Copiando dados para a tabela bookstore-benezinho-2tdspr.tb_pj: ~0 rows (aproximadamente)
/*!40000 ALTER TABLE `tb_pj` DISABLE KEYS */;
INSERT IGNORE INTO `tb_pj` (`NR_CNPJ`, `ID_PESSOA`) VALUES
	('12313213/0001-21', 1);
/*!40000 ALTER TABLE `tb_pj` ENABLE KEYS */;

-- Copiando estrutura para tabela bookstore-benezinho-2tdspr.tb_user
CREATE TABLE IF NOT EXISTS `tb_user` (
  `id` bigint(20) NOT NULL,
  `USER_PASSWORD` varchar(255) NOT NULL,
  `USER_EMAIL` varchar(255) NOT NULL,
  `PESSOA` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK_USER_EMAIL` (`USER_EMAIL`),
  KEY `FK_USER_PESSOA` (`PESSOA`),
  CONSTRAINT `FK_USER_PESSOA` FOREIGN KEY (`PESSOA`) REFERENCES `tb_pessoa` (`ID_PESSOA`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;

-- Copiando dados para a tabela bookstore-benezinho-2tdspr.tb_user: ~1 rows (aproximadamente)
/*!40000 ALTER TABLE `tb_user` DISABLE KEYS */;
INSERT IGNORE INTO `tb_user` (`id`, `USER_PASSWORD`, `USER_EMAIL`, `PESSOA`) VALUES
	(1, '$2a$10$YHNjErKI5lLElWr9T0HW2.QGVrYOe2II4AShtKpmzfLIqSU0p5eJG', 'benefrancis@gmail.com', 2);
/*!40000 ALTER TABLE `tb_user` ENABLE KEYS */;

-- Copiando estrutura para tabela bookstore-benezinho-2tdspr.usuario_authorities
CREATE TABLE IF NOT EXISTS `usuario_authorities` (
  `Usuario_id` bigint(20) NOT NULL,
  `authority` varchar(255) DEFAULT NULL,
  KEY `FKpvv7v9t020cw8ig9hu63w0g1m` (`Usuario_id`),
  CONSTRAINT `FKpvv7v9t020cw8ig9hu63w0g1m` FOREIGN KEY (`Usuario_id`) REFERENCES `tb_user` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;

-- Copiando dados para a tabela bookstore-benezinho-2tdspr.usuario_authorities: ~3 rows (aproximadamente)
/*!40000 ALTER TABLE `usuario_authorities` DISABLE KEYS */;
INSERT IGNORE INTO `usuario_authorities` (`Usuario_id`, `authority`) VALUES
	(1, 'ADMIN'),
	(1, 'USER'),
	(1, 'LEITURA');
/*!40000 ALTER TABLE `usuario_authorities` ENABLE KEYS */;

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IFNULL(@OLD_FOREIGN_KEY_CHECKS, 1) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40111 SET SQL_NOTES=IFNULL(@OLD_SQL_NOTES, 1) */;

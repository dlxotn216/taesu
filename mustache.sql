-- --------------------------------------------------------
-- 호스트:                          127.0.0.1
-- 서버 버전:                        5.7.14-log - MySQL Community Server (GPL)
-- 서버 OS:                        Win64
-- HeidiSQL 버전:                  9.4.0.5125
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;


-- mustache 데이터베이스 구조 내보내기
CREATE DATABASE IF NOT EXISTS `mustache` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `mustache`;

-- 테이블 mustache.account 구조 내보내기
CREATE TABLE IF NOT EXISTS `account` (
  `USER_ID` varchar(50) NOT NULL,
  `PASSWD` varchar(100) NOT NULL,
  `USER_NAME` varchar(50) NOT NULL,
  `USER_EMAIL` varchar(50) NOT NULL,
  `REQUEST_DATE` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `PERMIT_DATE` timestamp NULL DEFAULT NULL,
  `PERMIT` varchar(50) NOT NULL DEFAULT 'N',
  PRIMARY KEY (`USER_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- 테이블 데이터 mustache.account:~4 rows (대략적) 내보내기
DELETE FROM `account`;
/*!40000 ALTER TABLE `account` DISABLE KEYS */;
INSERT INTO `account` (`USER_ID`, `PASSWD`, `USER_NAME`, `USER_EMAIL`, `REQUEST_DATE`, `PERMIT_DATE`, `PERMIT`) VALUES
	('admin', '$2a$10$lpM5KsqX.77a9u7h7kIdOu/v3Yd0lrJ/qEKo2hWRpuv09JCC.zTgO', 'Admin', 'admin@admin.com', '2016-12-02 10:45:40', '2016-12-02 10:45:42', 'Y'),
	('master', '$2a$10$H.cWkkCj5.Q6gvBBXYG9WeilqPny0uc04GBq.uD.5WKZt2CkcFRye', 'Masetr', 'master@master.com', '2016-12-01 17:55:45', NULL, 'Y'),
	('testuser', '$2a$10$zmxEt4Nrh9PnimkSWcnCYeS9Biw0RREV3j6jjvSlh6BKv1UK55CZq', 'aefaf', 'afeawf@aef.com', '2016-12-02 15:52:55', '2016-12-02 15:52:57', 'Y'),
	('user', '$2a$10$DrOzIayGWgOPdErcKRks5uQ5TL2oDshcUcKgCJz20kH1Gr.DeolzC', 'UserName', 'user@user.com', '2016-12-02 15:48:31', '2016-12-02 15:48:33', 'Y');
/*!40000 ALTER TABLE `account` ENABLE KEYS */;

-- 테이블 mustache.account_authority_mapping 구조 내보내기
CREATE TABLE IF NOT EXISTS `account_authority_mapping` (
  `MAPPING_ID` int(11) NOT NULL AUTO_INCREMENT,
  `USER_ID` varchar(50) NOT NULL,
  `AUTH_NAME` varchar(50) NOT NULL,
  PRIMARY KEY (`MAPPING_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8;

-- 테이블 데이터 mustache.account_authority_mapping:~4 rows (대략적) 내보내기
DELETE FROM `account_authority_mapping`;
/*!40000 ALTER TABLE `account_authority_mapping` DISABLE KEYS */;
INSERT INTO `account_authority_mapping` (`MAPPING_ID`, `USER_ID`, `AUTH_NAME`) VALUES
	(1, 'master', 'ROLE_MASTER'),
	(2, 'admin', 'ROLE_ADMIN'),
	(3, 'user', 'ROLE_USER'),
	(12, 'testuser', 'ROLE_USER');
/*!40000 ALTER TABLE `account_authority_mapping` ENABLE KEYS */;

-- 테이블 mustache.authority 구조 내보내기
CREATE TABLE IF NOT EXISTS `authority` (
  `AUTH_NAME` varchar(50) NOT NULL,
  `DESCRIPTION` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`AUTH_NAME`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- 테이블 데이터 mustache.authority:~4 rows (대략적) 내보내기
DELETE FROM `authority`;
/*!40000 ALTER TABLE `authority` DISABLE KEYS */;
INSERT INTO `authority` (`AUTH_NAME`, `DESCRIPTION`) VALUES
	('ROLE_ADMIN', '관리자'),
	('ROLE_ANONYMOUS', 'ANONYMOUS'),
	('ROLE_MASTER', '마스터'),
	('ROLE_USER', '일반 사용자');
/*!40000 ALTER TABLE `authority` ENABLE KEYS */;

-- 테이블 mustache.fb_account 구조 내보내기
CREATE TABLE IF NOT EXISTS `fb_account` (
  `FB_ACCOUNT_ID` int(11) NOT NULL AUTO_INCREMENT,
  `REG_USER_ID` varchar(50) NOT NULL,
  `FB_USER_ID` varchar(50) NOT NULL,
  `FB_USER_NAME` varchar(50) NOT NULL,
  `REG_DATE` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`FB_ACCOUNT_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

-- 테이블 데이터 mustache.fb_account:~3 rows (대략적) 내보내기
DELETE FROM `fb_account`;
/*!40000 ALTER TABLE `fb_account` DISABLE KEYS */;
INSERT INTO `fb_account` (`FB_ACCOUNT_ID`, `REG_USER_ID`, `FB_USER_ID`, `FB_USER_NAME`, `REG_DATE`) VALUES
	(1, 'admin', 'test', 'test', '2016-12-02 10:18:15'),
	(2, 'admin', '1', '1', '2016-12-02 14:22:35'),
	(5, 'admin', '1233', '122', '2016-12-02 14:34:35');
/*!40000 ALTER TABLE `fb_account` ENABLE KEYS */;

-- 테이블 mustache.intro 구조 내보내기
CREATE TABLE IF NOT EXISTS `intro` (
  `INTRO_DOMAIN` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- 테이블 데이터 mustache.intro:~0 rows (대략적) 내보내기
DELETE FROM `intro`;
/*!40000 ALTER TABLE `intro` DISABLE KEYS */;
INSERT INTO `intro` (`INTRO_DOMAIN`) VALUES
	('http://localhost:8080/intro');
/*!40000 ALTER TABLE `intro` ENABLE KEYS */;

-- 테이블 mustache.movie 구조 내보내기
CREATE TABLE IF NOT EXISTS `movie` (
  `MOVIE_ID` int(11) NOT NULL AUTO_INCREMENT,
  `FB_ACCOUNT_ID` int(11) NOT NULL DEFAULT '0',
  `REG_USER_ID` varchar(50) NOT NULL DEFAULT '0',
  `MOVIE_NAME` varchar(50) NOT NULL,
  `REG_DATE` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`MOVIE_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8;

-- 테이블 데이터 mustache.movie:~2 rows (대략적) 내보내기
DELETE FROM `movie`;
/*!40000 ALTER TABLE `movie` DISABLE KEYS */;
INSERT INTO `movie` (`MOVIE_ID`, `FB_ACCOUNT_ID`, `REG_USER_ID`, `MOVIE_NAME`, `REG_DATE`) VALUES
	(11, 1, 'master', 'MOVIE_TEST_1', '2016-12-02 14:11:57'),
	(12, 1, 'master', 'MOVIE_TEST_2', '2016-12-02 14:12:12');
/*!40000 ALTER TABLE `movie` ENABLE KEYS */;

-- 테이블 mustache.movie_link 구조 내보내기
CREATE TABLE IF NOT EXISTS `movie_link` (
  `MOVIE_LINK_ID` int(11) NOT NULL AUTO_INCREMENT,
  `MOVIE_ID` int(11) NOT NULL,
  `MOVIE_URL` varchar(255) NOT NULL,
  PRIMARY KEY (`MOVIE_LINK_ID`),
  KEY `FK_movie_link_movie` (`MOVIE_ID`),
  CONSTRAINT `FK_movie_link_movie` FOREIGN KEY (`MOVIE_ID`) REFERENCES `movie` (`MOVIE_ID`) ON DELETE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=37 DEFAULT CHARSET=utf8;

-- 테이블 데이터 mustache.movie_link:~8 rows (대략적) 내보내기
DELETE FROM `movie_link`;
/*!40000 ALTER TABLE `movie_link` DISABLE KEYS */;
INSERT INTO `movie_link` (`MOVIE_LINK_ID`, `MOVIE_ID`, `MOVIE_URL`) VALUES
	(25, 11, '1'),
	(26, 11, '2'),
	(27, 11, '3'),
	(28, 11, '4'),
	(33, 12, '11'),
	(34, 12, '22'),
	(35, 12, '33'),
	(36, 12, '44');
/*!40000 ALTER TABLE `movie_link` ENABLE KEYS */;

-- 테이블 mustache.movie_visit 구조 내보내기
CREATE TABLE IF NOT EXISTS `movie_visit` (
  `MOVIE_ID` int(11) NOT NULL,
  `VISIT_ID` varchar(50) NOT NULL,
  `VISIT_DATE` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  KEY `FK_movie_visit_movie` (`MOVIE_ID`),
  CONSTRAINT `FK_movie_visit_movie` FOREIGN KEY (`MOVIE_ID`) REFERENCES `movie` (`MOVIE_ID`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- 테이블 데이터 mustache.movie_visit:~0 rows (대략적) 내보내기
DELETE FROM `movie_visit`;
/*!40000 ALTER TABLE `movie_visit` DISABLE KEYS */;
/*!40000 ALTER TABLE `movie_visit` ENABLE KEYS */;

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;

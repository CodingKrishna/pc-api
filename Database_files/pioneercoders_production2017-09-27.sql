-- MySQL Administrator dump 1.4
--
-- ------------------------------------------------------
-- Server version	5.5.24


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;


--
-- Create schema pioneercoders_production
--

CREATE DATABASE IF NOT EXISTS pioneercoders_production;
USE pioneercoders_production;

--
-- Definition of table `answers_mst_tbl`
--

DROP TABLE IF EXISTS `answers_mst_tbl`;
CREATE TABLE `answers_mst_tbl` (
  `ID` bigint(20) NOT NULL AUTO_INCREMENT,
  `ANSWER` varchar(255) DEFAULT NULL,
  `QUESTION_ID` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=44 DEFAULT CHARSET=utf8;

--
-- Dumping data for table `answers_mst_tbl`
--

/*!40000 ALTER TABLE `answers_mst_tbl` DISABLE KEYS */;
INSERT INTO `answers_mst_tbl` (`ID`,`ANSWER`,`QUESTION_ID`) VALUES 
 (1,'<strong>',1),
 (2,'id',2),
 (3,'text-decoration',3),
 (4,'word-spacing',4),
 (5,'clear',5),
 (6,'both a and b',6),
 (7,'p {color:red;text-align:center;}',7),
 (8,'border',8),
 (9,'background-image',9),
 (10,'body {background-image:url(\'paper.gif\');}',10),
 (11,'textarea tag',11),
 (12,'<SUP>',12),
 (13,'Used to separate cell walls from their contents.',13),
 (14,'li tag',14),
 (15,'face',15),
 (16,'To logically divide the document',16),
 (17,'Using height and width',17),
 (18,'Line break',18),
 (19,'Transfer files to and from an Internet Server',19),
 (20,'<hr>',20),
 (21,'jdk',21),
 (22,'oak',22),
 (23,'object oriented',23),
 (24,'java development kit',24),
 (25,'both a and b',25),
 (26,'Sun',26),
 (27,'.java',27),
 (28,'Static Binding',28),
 (29,'serializable',29),
 (30,'Finally',30),
 (31,'Compile fail due to error on line no 9',31),
 (32,'0 false 0',32),
 (33,'Compile Error',33),
 (34,'A a = new B();',34),
 (35,'Compilation fails with an error at line 4',35),
 (36,'run-test run-test',36),
 (37,'Runtime Exception',37),
 (38,'java.util.ArrayList',38),
 (39,'Value-A Value-A\r\n',39),
 (40,'true',40),
 (41,NULL,41),
 (42,NULL,42),
 (43,'csss',43);
/*!40000 ALTER TABLE `answers_mst_tbl` ENABLE KEYS */;


--
-- Definition of table `batch_timing_trn_tbl`
--

DROP TABLE IF EXISTS `batch_timing_trn_tbl`;
CREATE TABLE `batch_timing_trn_tbl` (
  `ID` bigint(20) NOT NULL AUTO_INCREMENT,
  `DESCRIPTION` varchar(255) DEFAULT NULL,
  `IMGPATH` varchar(255) DEFAULT NULL,
  `BATCH_START_DATE` datetime DEFAULT NULL,
  `TIMINGS` varchar(255) DEFAULT NULL,
  `TRAINER_NAME` varchar(255) DEFAULT NULL,
  `COURSE_ID` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`ID`),
  KEY `FK4A68015F4B4B8118` (`COURSE_ID`),
  CONSTRAINT `FK4A68015F4B4B8118` FOREIGN KEY (`COURSE_ID`) REFERENCES `course_mst_tbl` (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=40 DEFAULT CHARSET=utf8;

--
-- Dumping data for table `batch_timing_trn_tbl`
--

/*!40000 ALTER TABLE `batch_timing_trn_tbl` DISABLE KEYS */;
INSERT INTO `batch_timing_trn_tbl` (`ID`,`DESCRIPTION`,`IMGPATH`,`BATCH_START_DATE`,`TIMINGS`,`TRAINER_NAME`,`COURSE_ID`) VALUES 
 (1,'demo class on HTML by',NULL,'2017-05-01 00:00:00','9.00am to 11.00am','Bhaskar',1),
 (2,'Gust lecture on HTML by ',NULL,'2017-05-03 00:00:00','12.00am to 2.00pm','Hari Krishna',1),
 (3,'Live project demo by ',NULL,'2017-05-05 00:00:00','9.00am to 11.00am','Bhaskar',1),
 (4,'demo class on CSS3 by ',NULL,'2017-05-07 00:00:00','7.00am to 10.00am','Hari Krishna',2),
 (5,'Gust lectue on CSS3 by',NULL,'2017-05-08 00:00:00','6.00pm to 8.00pm','Hari krishna',2),
 (6,'Live project demo by ',NULL,'2017-05-09 00:00:00','10.00am to 2.00pm ','Hari Krishna',2),
 (7,'demo class Java Script by ',NULL,'2017-05-10 00:00:00','10.00am to 12.00pm','Bhaskar',3),
 (8,'Gust lecture on Javascript by',NULL,'2017-05-10 00:00:00','2.00pm to 5.00pm','Bhaskar',3),
 (9,'Live project demo by ',NULL,'2017-05-10 00:00:00','8.00am to 1.00pm','Bhaskar',3),
 (10,'demo class  by',NULL,'2017-05-12 00:00:00','9.00am to 12.00pm','Sanjay',4),
 (11,'Gust lecture on AngularJS by',NULL,'2017-05-12 00:00:00','2.00pm to 4.00pm','Sanjay',4),
 (12,'Live project demo by',NULL,'2017-05-13 00:00:00','3.00pm to 6.00pm','Sanjay',4),
 (13,'demo class by ',NULL,'2017-05-16 00:00:00','8.00am to 10.30am','Bhaskar',5),
 (14,'Gust lecture on JAVA by',NULL,'2017-05-17 00:00:00','10.00am to 12.30pm','Bhaskar',5),
 (15,'Live project demo by',NULL,'2017-05-18 00:00:00','6.00pm to 8.30pm','Bhaskar',5),
 (16,'demo class by',NULL,'2017-05-20 00:00:00','8.00am to 10.00am','Mani',6),
 (17,'Gust lecture on Jdbc Servlets & Jsp by',NULL,'2017-05-21 00:00:00','8.00am to 10.30am ','Mani',6),
 (18,'Live project by',NULL,'2017-05-22 00:00:00','8.00am to 12.00pm','Mani',6),
 (19,'demo class by',NULL,'2017-05-23 00:00:00','10.00am to 12.00pm','Bhaskar',7),
 (20,'Gust lecture on Spring by',NULL,'2017-05-24 00:00:00','8.00am to 10.30am ','Bhaskar',7),
 (21,'Live project by',NULL,'2017-05-24 00:00:00','3.00pm to 5.30pm','Bhaskar',7),
 (22,'demo class by ',NULL,'2017-05-24 00:00:00','7.00pm to 9.30pm ','Hari Krishna',8),
 (23,'Gust lecture on Hibernate',NULL,'2017-05-26 00:00:00','8.00am to 10.00am','Hari Krishna',8),
 (24,'Live project by',NULL,'2017-05-27 00:00:00','7.30pm to 9.30pm','Hari Krishna',8),
 (25,'demo class by',NULL,'2017-05-28 00:00:00','8.00am to 10.00am','Bhaskar',9),
 (26,'Gust lecture on Spring by',NULL,'2017-05-28 00:00:00','6.00pm to 8.00pm','Bhaskar',9),
 (27,'Live porject by',NULL,'2017-05-29 00:00:00','7.00am to 10.00am','Bhaskar',9),
 (28,'demo class by',NULL,'2017-05-30 00:00:00','7.00am to 10.00am','Bhaskar',10),
 (29,'Gust lecture on Android',NULL,'2017-06-03 00:00:00','7.00am to 11.00am','Bhaskar',10),
 (30,'Live project by',NULL,'2017-06-03 00:00:00','6.00am to 8.00am','Bhaskar',10),
 (31,'demo class by ',NULL,'2017-06-04 00:00:00','6.00am to 8.00am','Bhaskar',12),
 (32,'Gust lecture on SQL & PL/SQL',NULL,'2017-06-05 00:00:00','9.00pm to 11.00pm','Bhaskar',12),
 (33,'Live project by',NULL,'2017-06-06 00:00:00','6.00am to 8.00am','Bhaskar',12),
 (34,'demo class by',NULL,'2017-06-07 00:00:00','9.00am to 11.00am','Bhaskar',14),
 (35,'Gust lecture on IOS',NULL,'2017-06-08 00:00:00','5.00pm to 7.00pm','Bhaskar',14),
 (36,'Live project by',NULL,'2017-06-09 00:00:00','6.00pm to 8.00pm','Bhaskar',14),
 (38,'demo class by ',NULL,'2017-06-10 00:00:00','6.00am to 8.00am','Bhaskar',11),
 (39,'Gust lecture on English',NULL,'2017-06-11 00:00:00','9.00am to 11.00am','Bhaskar',11);
/*!40000 ALTER TABLE `batch_timing_trn_tbl` ENABLE KEYS */;


--
-- Definition of table `city_mst_tbl`
--

DROP TABLE IF EXISTS `city_mst_tbl`;
CREATE TABLE `city_mst_tbl` (
  `ID` bigint(20) NOT NULL AUTO_INCREMENT,
  `CITY_NAME` varchar(255) DEFAULT NULL,
  `STATE_ID` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`ID`),
  KEY `FK_rfk9tcvrtabneayyn8gdqqmjp` (`STATE_ID`),
  CONSTRAINT `FK_rfk9tcvrtabneayyn8gdqqmjp` FOREIGN KEY (`STATE_ID`) REFERENCES `state_mst_tbl` (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

--
-- Dumping data for table `city_mst_tbl`
--

/*!40000 ALTER TABLE `city_mst_tbl` DISABLE KEYS */;
INSERT INTO `city_mst_tbl` (`ID`,`CITY_NAME`,`STATE_ID`) VALUES 
 (1,'Bangalore',1),
 (2,'Mysore',1),
 (3,'Hyderabad',2),
 (4,'Vijayawada',2),
 (5,'Mumbai',3),
 (6,'Pune',3);
/*!40000 ALTER TABLE `city_mst_tbl` ENABLE KEYS */;


--
-- Definition of table `coding_test_qtn_assign_to_user_trn_bl`
--

DROP TABLE IF EXISTS `coding_test_qtn_assign_to_user_trn_bl`;
CREATE TABLE `coding_test_qtn_assign_to_user_trn_bl` (
  `ID` bigint(20) NOT NULL AUTO_INCREMENT,
  `QUESTION_ID` bigint(20) DEFAULT NULL,
  `USER_ID` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`ID`),
  KEY `FK_jpvnoyhevcv7hmk6xt30u3cos` (`QUESTION_ID`),
  KEY `FK_sgiq1ur90mc17hak8thrto1vl` (`USER_ID`),
  CONSTRAINT `FK_sgiq1ur90mc17hak8thrto1vl` FOREIGN KEY (`USER_ID`) REFERENCES `user_mst_tbl` (`ID`),
  CONSTRAINT `FK_jpvnoyhevcv7hmk6xt30u3cos` FOREIGN KEY (`QUESTION_ID`) REFERENCES `coding_test_qtn_tbl` (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `coding_test_qtn_assign_to_user_trn_bl`
--

/*!40000 ALTER TABLE `coding_test_qtn_assign_to_user_trn_bl` DISABLE KEYS */;
/*!40000 ALTER TABLE `coding_test_qtn_assign_to_user_trn_bl` ENABLE KEYS */;


--
-- Definition of table `coding_test_qtn_tbl`
--

DROP TABLE IF EXISTS `coding_test_qtn_tbl`;
CREATE TABLE `coding_test_qtn_tbl` (
  `ID` bigint(20) NOT NULL AUTO_INCREMENT,
  `IMG_PATH` varchar(255) DEFAULT NULL,
  `LANGUAGE` varchar(255) DEFAULT NULL,
  `POINTS` bigint(20) DEFAULT NULL,
  `QUESTION_DESC` varchar(255) DEFAULT NULL,
  `SAMPLE_CODE` varchar(255) DEFAULT NULL,
  `TEST_CASES` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

--
-- Dumping data for table `coding_test_qtn_tbl`
--

/*!40000 ALTER TABLE `coding_test_qtn_tbl` DISABLE KEYS */;
INSERT INTO `coding_test_qtn_tbl` (`ID`,`IMG_PATH`,`LANGUAGE`,`POINTS`,`QUESTION_DESC`,`SAMPLE_CODE`,`TEST_CASES`) VALUES 
 (1,NULL,NULL,NULL,'kjhkjk',NULL,'[{\"input\":\"kjhkjh\",\"output\":\"kjhkjh\"},{\"input\":\"kljklj\",\"output\":\"jjhnh\"}]'),
 (2,NULL,NULL,NULL,'klkjlkj',NULL,'[{\"input\":\",mkjlkj\",\"output\":\"lkjlkj\"},{\"input\":\"kljlkj\",\"output\":\"lkjlkj\"}]'),
 (3,NULL,'JAVA',NULL,'jkjjh',NULL,'[{\"input\":\"hjkh\",\"output\":\"jhkjhkjh\",\"points\":\"jhjkh\"}]');
/*!40000 ALTER TABLE `coding_test_qtn_tbl` ENABLE KEYS */;


--
-- Definition of table `codingtest_results_mst_tbl`
--

DROP TABLE IF EXISTS `codingtest_results_mst_tbl`;
CREATE TABLE `codingtest_results_mst_tbl` (
  `ID` bigint(20) NOT NULL AUTO_INCREMENT,
  `POINTS` bigint(20) DEFAULT NULL,
  `QUESTION_ID` bigint(20) DEFAULT NULL,
  `USER_ID` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`ID`),
  KEY `FK_3jbc020k9okl020k97gfa2ygh` (`QUESTION_ID`),
  KEY `FK_i5d0wwnyq5u2ug74gvtuisk5b` (`USER_ID`),
  CONSTRAINT `FK_i5d0wwnyq5u2ug74gvtuisk5b` FOREIGN KEY (`USER_ID`) REFERENCES `user_mst_tbl` (`ID`),
  CONSTRAINT `FK_3jbc020k9okl020k97gfa2ygh` FOREIGN KEY (`QUESTION_ID`) REFERENCES `coding_test_qtn_tbl` (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `codingtest_results_mst_tbl`
--

/*!40000 ALTER TABLE `codingtest_results_mst_tbl` DISABLE KEYS */;
/*!40000 ALTER TABLE `codingtest_results_mst_tbl` ENABLE KEYS */;


--
-- Definition of table `company_mst_tbl`
--

DROP TABLE IF EXISTS `company_mst_tbl`;
CREATE TABLE `company_mst_tbl` (
  `ID` bigint(20) NOT NULL AUTO_INCREMENT,
  `COMPANY_NAME` varchar(255) DEFAULT NULL,
  `URL_PATH` varchar(255) DEFAULT NULL,
  `EMAIL_ID` varchar(255) DEFAULT NULL,
  `LOGO` varchar(255) DEFAULT NULL,
  `PHONE_NO` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

--
-- Dumping data for table `company_mst_tbl`
--

/*!40000 ALTER TABLE `company_mst_tbl` DISABLE KEYS */;
INSERT INTO `company_mst_tbl` (`ID`,`COMPANY_NAME`,`URL_PATH`,`EMAIL_ID`,`LOGO`,`PHONE_NO`) VALUES 
 (1,'tech','www.tech.com','venkatsai9573@gmail.com','tech.undefined','9909890989'),
 (2,'cgi','www.cgi.com','ayyappapalivela96@gmail.com','cgi.undefined','9080980790');
/*!40000 ALTER TABLE `company_mst_tbl` ENABLE KEYS */;


--
-- Definition of table `contactus_mst_tbl`
--

DROP TABLE IF EXISTS `contactus_mst_tbl`;
CREATE TABLE `contactus_mst_tbl` (
  `ID` bigint(20) NOT NULL AUTO_INCREMENT,
  `COMMENTS` longtext,
  `CREATED_ON` datetime DEFAULT NULL,
  `EMAIL_ID` varchar(255) DEFAULT NULL,
  `MOBILE_NO` varchar(255) DEFAULT NULL,
  `NAME` varchar(255) DEFAULT NULL,
  `STATUS` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;

--
-- Dumping data for table `contactus_mst_tbl`
--

/*!40000 ALTER TABLE `contactus_mst_tbl` DISABLE KEYS */;
INSERT INTO `contactus_mst_tbl` (`ID`,`COMMENTS`,`CREATED_ON`,`EMAIL_ID`,`MOBILE_NO`,`NAME`,`STATUS`) VALUES 
 (1,'Online test','2017-06-22 00:00:00','surya4454@gmail.com','9676087686','Surya Prakash','ACTIVE'),
 (4,'Am looking for a job','2017-06-22 00:00:00','sindhu4sep94@gmail.com','9108702524','Sindhu Kumari','ACTIVE'),
 (5,'Need info on IOS and Android training','2017-06-29 00:00:00','shanthi_2k21@rediffmail.com','9449830582','Shanthi','ACTIVE'),
 (6,'testing of pc','2017-07-27 00:00:00','muppansettiraja@gmail.com','9492444346','raja','ACTIVE'),
 (7,'gfhgfh','2017-07-27 00:00:00','fghgfh','ghgfh','fhgh','ACTIVE'),
 (8,'Fresher','2017-07-29 00:00:00','Jayalakshmibagali94@gmail.com','9482430794','Jayalakshmi','ACTIVE'),
 (9,'Fresher','2017-07-29 00:00:00','Jayalakshmibagali94@gmail.com','9482430794','Jayalakshmi','ACTIVE');
/*!40000 ALTER TABLE `contactus_mst_tbl` ENABLE KEYS */;


--
-- Definition of table `country_mst_tbl`
--

DROP TABLE IF EXISTS `country_mst_tbl`;
CREATE TABLE `country_mst_tbl` (
  `Id` bigint(20) NOT NULL AUTO_INCREMENT,
  `COUNTRY_NAME` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`Id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

--
-- Dumping data for table `country_mst_tbl`
--

/*!40000 ALTER TABLE `country_mst_tbl` DISABLE KEYS */;
INSERT INTO `country_mst_tbl` (`Id`,`COUNTRY_NAME`) VALUES 
 (1,'INDIA');
/*!40000 ALTER TABLE `country_mst_tbl` ENABLE KEYS */;


--
-- Definition of table `course_mst_tbl`
--

DROP TABLE IF EXISTS `course_mst_tbl`;
CREATE TABLE `course_mst_tbl` (
  `ID` bigint(20) NOT NULL AUTO_INCREMENT,
  `CATEGORY` varchar(255) DEFAULT NULL,
  `COURSE_NAME` varchar(255) DEFAULT NULL,
  `COURSE_START_DATE` datetime DEFAULT NULL,
  `DESC_PATH` varchar(255) DEFAULT NULL,
  `IMAGE_PATH` varchar(255) DEFAULT NULL,
  `IS_FEATURED_COURSE` bit(1) DEFAULT NULL,
  `PRICE` float DEFAULT NULL,
  `SHORT_DESC` longtext,
  `SORT_INDEX` int(11) DEFAULT NULL,
  `STATUS` varchar(255) DEFAULT NULL,
  `COURSE_DURATION` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8;

--
-- Dumping data for table `course_mst_tbl`
--

/*!40000 ALTER TABLE `course_mst_tbl` DISABLE KEYS */;
INSERT INTO `course_mst_tbl` (`ID`,`CATEGORY`,`COURSE_NAME`,`COURSE_START_DATE`,`DESC_PATH`,`IMAGE_PATH`,`IS_FEATURED_COURSE`,`PRICE`,`SHORT_DESC`,`SORT_INDEX`,`STATUS`,`COURSE_DURATION`) VALUES 
 (1,'UI','HTML5','2017-06-20 18:00:03','HTML5/course_description.html','resources/img/traininglogs/html_training_logo.png',NULL,5000,'Complete  HTML5 Course with Sample Application.',1,'Active',NULL),
 (2,'UI','CSS3','2017-06-23 19:00:03','CSS3/course_description.html','resources/img/traininglogs/css-training-logo.png',NULL,5000,'Complete  CSS3 Course with Sample Application.',2,'Active',NULL),
 (3,'UI','JAVA SCRIPT','2017-06-28 18:30:03','JS/course_description.html','resources/img/traininglogs/javascript_logo.png',NULL,5000,'Complete  JavaScript Course with Sample Application.',3,'Active',NULL),
 (4,'UI','ANGULARJS','2017-06-30 10:00:03','ANGULARJS/course_description.html','resources/img/traininglogs/angularjs_training_logo.jpg',0x01,10000,'Complete Angular JS Course with Sample Application.',4,'Active',NULL),
 (5,'JAVA','JAVA','2017-07-18 09:00:00','JAVA/course_description.html','resources/img/traininglogs/corejava_logo.png',0x01,5000,'Complete JAVA Course with Sample Application.',5,'Active',NULL),
 (6,'JAVA','SERVLET, JSP AND JDBC','2017-07-10 09:30:03','SERVLET_JSP_AND_JDBC/course_description.html','resources/img/traininglogs/java_logo.png',0x01,10000,'Complete Servlet,JSP and JDBC Course with Sample Application.',6,'Active',NULL),
 (7,'JAVA','SPRING','2017-07-08 17:40:03','SPRING/course_description.html','resources/img/traininglogs/spring_logo.png',NULL,5000,'Complete Spring Course with Sample Application.',7,'Active',NULL),
 (8,'JAVA','HIBERNATE','2017-07-28 17:40:03','HIBERNATE/course_description.html','resources/img/traininglogs/hibernate_logo.png',NULL,5000,'Complete Hibernate Course with Sample Application.',8,'Active',NULL),
 (9,'JAVA','SPRING & HIBERNATE','2017-07-18 17:30:00','SPRING_HIBERNATE/course_description.html','resources/img/traininglogs/spring&hibernet_logo.jpg',0x01,10000,'Complete Spring and hibernate Course with Sample Application.',9,'Active',NULL),
 (10,'MOBILE','ANDROID','2017-07-20 17:40:03','ANDROID/course_description.html','resources/img/traininglogs/android_logo.png',NULL,10000,'Complete Android Course with Sample Application.',10,'Active',NULL),
 (11,'OTHER','English','2017-07-16 17:40:03','ENGLISH/course_description.html','resources/img/traininglogs/englishgrammar_logo.png',NULL,0,'English',14,'Active',NULL),
 (12,'DBMS','DATABASE','2017-07-05 17:40:03','DATABASE/course_description.html','resources/img/traininglogs/sql.jpg',NULL,10000,'SQL and PL/SQL',11,'Active',NULL),
 (13,'DBMA','DBA','2017-07-25 17:40:03','DBMA/course_description.html','resources/img/traininglogs/dba.png',NULL,10000,'DBA',12,'InActive',NULL),
 (14,'MOBILE','IOS','2017-07-16 17:40:03','IOS/course_description.html','resources/img/traininglogs/ios.png',NULL,8000,'IOS',13,'Active',NULL),
 (15,NULL,'',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL);
/*!40000 ALTER TABLE `course_mst_tbl` ENABLE KEYS */;


--
-- Definition of table `courses_payments_trn_tbl`
--

DROP TABLE IF EXISTS `courses_payments_trn_tbl`;
CREATE TABLE `courses_payments_trn_tbl` (
  `ID` bigint(20) NOT NULL AUTO_INCREMENT,
  `CREATED_ON` datetime DEFAULT NULL,
  `PAID_AMOUNT` varchar(255) DEFAULT NULL,
  `RECEIVED_BY` varchar(255) DEFAULT NULL,
  `USER_ID` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`ID`),
  KEY `FKCE6DB74437B641D8` (`USER_ID`),
  CONSTRAINT `FKCE6DB74437B641D8` FOREIGN KEY (`USER_ID`) REFERENCES `user_mst_tbl` (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8;

--
-- Dumping data for table `courses_payments_trn_tbl`
--

/*!40000 ALTER TABLE `courses_payments_trn_tbl` DISABLE KEYS */;
INSERT INTO `courses_payments_trn_tbl` (`ID`,`CREATED_ON`,`PAID_AMOUNT`,`RECEIVED_BY`,`USER_ID`) VALUES 
 (1,'2017-06-20 00:00:00','5000','online transation',153),
 (2,'2017-07-15 00:00:00','3000','Online Transaction',154),
 (3,'2017-07-27 00:00:00','10000','raju',260),
 (4,'2017-07-27 00:00:00','10000','raju',260),
 (5,'2017-07-27 00:00:00','1000','raju',260),
 (6,'2017-07-27 00:00:00','1000','raju',260),
 (7,'2017-07-27 00:00:00','50000','raju',260),
 (8,'2017-07-27 00:00:00','50000','raju',260),
 (9,'2017-07-29 00:00:00','2000','raju',260),
 (10,'2017-08-03 00:00:00','1000','online',260),
 (11,'2017-08-07 00:00:00','5000','sai',262),
 (12,'2017-08-07 00:00:00','50000','sai',262);
/*!40000 ALTER TABLE `courses_payments_trn_tbl` ENABLE KEYS */;


--
-- Definition of table `evaluation_trn_tbl`
--

DROP TABLE IF EXISTS `evaluation_trn_tbl`;
CREATE TABLE `evaluation_trn_tbl` (
  `ID` bigint(20) NOT NULL AUTO_INCREMENT,
  `ACCOMLISHMENTS` longtext,
  `APPLICATIONS` longtext,
  `CREATED_ON` datetime DEFAULT NULL,
  `GAMES` longtext,
  `MOBILE_APPS` longtext,
  `STATUS` varchar(255) DEFAULT NULL,
  `STRENGTHS` longtext,
  `USER_ID` bigint(20) DEFAULT NULL,
  `WEAKNESS` longtext,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

--
-- Dumping data for table `evaluation_trn_tbl`
--

/*!40000 ALTER TABLE `evaluation_trn_tbl` DISABLE KEYS */;
INSERT INTO `evaluation_trn_tbl` (`ID`,`ACCOMLISHMENTS`,`APPLICATIONS`,`CREATED_ON`,`GAMES`,`MOBILE_APPS`,`STATUS`,`STRENGTHS`,`USER_ID`,`WEAKNESS`) VALUES 
 (1,'[{\"standard\":\"IX\",\"desc\":\"<h3>Quiz Results</h3>\"},{\"standard\":\"X\",\"desc\":\"<h3>Quiz Results</h3>\"},{\"standard\":\"XI\",\"desc\":\"<h3>Quiz Results</h3>\"},{\"standard\":\"XII\",\"desc\":\"<h3>Quiz Results</h3>\"},{\"standard\":\"GRAD\",\"desc\":\"<h3>Quiz Results</h3>\"}]','[{\"appUrls\":\"qrwerqwe\"},{\"appUrls\":\"sdfasdfa\"},{\"appUrls\":\"<h3>Quiz Results</h3>\"},{\"appUrls\":\"<h3>Quiz Results</h3>\"},{\"appUrls\":\"<h3>Quiz Results</h3>\"},{\"appUrls\":\"<h3>Quiz Results</h3>\"},{\"appUrls\":\"<h3>Quiz Results</h3>\"},{\"appUrls\":\"<h3>Quiz Results</h3>\"},{\"appUrls\":\"<h3>Quiz Results</h3>\"},{\"appUrls\":\"<h3>Quiz Results</h3>\"}]','2017-02-28 00:00:00','[{\"game\":\"<h3>Quiz Results</h3>\"},{\"game\":\"<h3>Quiz Results</h3>\"},{\"game\":\"<h3>Quiz Results</h3>\"},{\"game\":\"<h3>Quiz Results</h3>\"},{\"game\":\"<h3>Quiz Results</h3>\"},{\"game\":\"<h3>Quiz Results</h3>\"},{\"game\":\"<h3>Quiz Results</h3>\"},{\"game\":\"<h3>Quiz Results</h3>\"},{\"game\":\"<h3>Quiz Results</h3>\"},{\"game\":\"<h3>Quiz Results</h3>\"}]','[{\"mobileApp\":\"<h3>Quiz Results</h3>\"},{\"mobileApp\":\"<h3>Quiz Results</h3>\"},{\"mobileApp\":\"<h3>Quiz Results</h3>\"},{\"mobileApp\":\"<h3>Quiz Results</h3>\"},{\"mobileApp\":\"<h3>Quiz Results</h3>\"},{\"mobileApp\":\"<h3>Quiz Results</h3>\"},{\"mobileApp\":\"<h3>Quiz Results</h3>\"},{\"mobileApp\":\"<h3>Quiz Results</h3>\"},{\"mobileApp\":\"<h3>Quiz Results</h3>\"},{\"mobileApp\":\"<h3>Quiz Results</h3>\"}]','ACTIVE','Programming Skills,Analytical Skills,Presentation Skills,Reading and Comprehension Skills',4,'<h3>Quiz Results</h3>'),
 (2,'[{\"standard\":\"IX\",\"desc\":\"topper in college leve;\"},{\"standard\":\"X\",\"desc\":\"topper in school  level\"},{\"standard\":\"XI\",\"desc\":\"\"},{\"standard\":\"XII\",\"desc\":\"topper in school level\"},{\"standard\":\"GRAD\",\"desc\":\"\"}]','[{\"appUrls\":\"\"}]','2017-07-26 00:00:00','[{\"game\":\"\"}]','[{\"mobileApp\":\"\"}]','ACTIVE','',148,''),
 (3,'[{\"standard\":\"IX\",\"desc\":\"\"},{\"standard\":\"X\",\"desc\":\"\"},{\"standard\":\"XI\",\"desc\":\"\"},{\"standard\":\"XII\",\"desc\":\"\"},{\"standard\":\"GRAD\",\"desc\":\"\"}]','[{\"appUrls\":\"www.google.com\"},{\"appUrls\":\"www.redbus.com\"},{\"appUrls\":\"www.youtube.com\"},{\"appUrls\":\"www.fb.com\"},{\"appUrls\":\"www.pioneercoders.com\"},{\"appUrls\":\"www.w3schools.com\"},{\"appUrls\":\"www.cricbuzz.com\"},{\"appUrls\":\"www.flipkart.com\"},{\"appUrls\":\"www.ebay.in\"},{\"appUrls\":\"www.bookmyshow.com\"}]','2017-07-27 00:00:00','[{\"game\":\"\"}]','[{\"mobileApp\":\"flipkart\"},{\"mobileApp\":\"paytm\"},{\"mobileApp\":\"redbus\"},{\"mobileApp\":\"irctc\"},{\"mobileApp\":\"googlemaps\"},{\"mobileApp\":\"uber\"},{\"mobileApp\":\"whatsapp\"},{\"mobileApp\":\"snapdeal\"},{\"mobileApp\":\"truecaller\"},{\"mobileApp\":\"tubemate\"}]','ACTIVE','Programming Skills,Analytical Skills,Presentation Skills,Reading and Comprehension Skills,Others',211,'');
/*!40000 ALTER TABLE `evaluation_trn_tbl` ENABLE KEYS */;


--
-- Definition of table `eventparticipants_trn_tbl`
--

DROP TABLE IF EXISTS `eventparticipants_trn_tbl`;
CREATE TABLE `eventparticipants_trn_tbl` (
  `ID` bigint(20) NOT NULL AUTO_INCREMENT,
  `EVENT_ID` bigint(20) DEFAULT NULL,
  `USER_ID` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`ID`),
  KEY `FK32A178AADCF434B7` (`EVENT_ID`),
  KEY `FK32A178AA37B641D8` (`USER_ID`),
  CONSTRAINT `FK32A178AA37B641D8` FOREIGN KEY (`USER_ID`) REFERENCES `user_mst_tbl` (`ID`),
  CONSTRAINT `FK32A178AADCF434B7` FOREIGN KEY (`EVENT_ID`) REFERENCES `events_tbl` (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

--
-- Dumping data for table `eventparticipants_trn_tbl`
--

/*!40000 ALTER TABLE `eventparticipants_trn_tbl` DISABLE KEYS */;
INSERT INTO `eventparticipants_trn_tbl` (`ID`,`EVENT_ID`,`USER_ID`) VALUES 
 (3,1,20),
 (4,2,20);
/*!40000 ALTER TABLE `eventparticipants_trn_tbl` ENABLE KEYS */;


--
-- Definition of table `events_tbl`
--

DROP TABLE IF EXISTS `events_tbl`;
CREATE TABLE `events_tbl` (
  `ID` bigint(20) NOT NULL AUTO_INCREMENT,
  `EVENT_DATE` datetime DEFAULT NULL,
  `EVENT_DESCRIPTION` varchar(255) DEFAULT NULL,
  `EVENT_NAME` varchar(255) DEFAULT NULL,
  `ORGANISED_BY` varchar(255) DEFAULT NULL,
  `IMAGE_PATH` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

--
-- Dumping data for table `events_tbl`
--

/*!40000 ALTER TABLE `events_tbl` DISABLE KEYS */;
INSERT INTO `events_tbl` (`ID`,`EVENT_DATE`,`EVENT_DESCRIPTION`,`EVENT_NAME`,`ORGANISED_BY`,`IMAGE_PATH`) VALUES 
 (1,'2017-06-08 00:00:00','In the AngularJS Workshop we will cover the topics, angular introduction, built-in directives,filters,controller,services and ui-routing. will create real time project','AngularJS Workshop','Pioneer Coders','resources/img/angularjs-workshop.jpg'),
 (2,'2017-07-20 00:00:00','We will discuss about basics of android development.','Android Workshop','Pioneer Coders','resources/img/android-img.jpg'),
 (3,'2017-06-20 16:00:13','Workshop on career Enhancement','Career Enhancment','Pioneer Coders','resources/img/workshop on career.jpg');
/*!40000 ALTER TABLE `events_tbl` ENABLE KEYS */;


--
-- Definition of table `exam_mst_tbl`
--

DROP TABLE IF EXISTS `exam_mst_tbl`;
CREATE TABLE `exam_mst_tbl` (
  `ID` bigint(20) NOT NULL AUTO_INCREMENT,
  `ANSWER` varchar(255) DEFAULT NULL,
  `IS_ANSWERED` bit(1) DEFAULT NULL,
  `QUESTION_ID` bigint(20) DEFAULT NULL,
  `PERSIONAL_ID` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`ID`),
  KEY `FK62A4EF6DAE7C8DBE` (`QUESTION_ID`),
  KEY `FK62A4EF6DC4E0F66` (`PERSIONAL_ID`),
  CONSTRAINT `FK62A4EF6DAE7C8DBE` FOREIGN KEY (`QUESTION_ID`) REFERENCES `question_mst_tbl` (`ID`),
  CONSTRAINT `FK62A4EF6DC4E0F66` FOREIGN KEY (`PERSIONAL_ID`) REFERENCES `user_mst_tbl` (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=2612 DEFAULT CHARSET=utf8;

--
-- Dumping data for table `exam_mst_tbl`
--

/*!40000 ALTER TABLE `exam_mst_tbl` DISABLE KEYS */;
INSERT INTO `exam_mst_tbl` (`ID`,`ANSWER`,`IS_ANSWERED`,`QUESTION_ID`,`PERSIONAL_ID`) VALUES 
 (1,' 0.0',0x01,30,144),
 (2,'apple',0x01,22,144),
 (3,'jdk',0x01,21,144),
 (4,'java development kit',0x01,24,144),
 (5,'.java',0x01,27,144),
 (6,'Dynamic Binding',0x01,28,144),
 (7,'Sun',0x01,26,144),
 (8,'serializable',0x01,29,144),
 (9,'object oriented',0x01,23,144),
 (10,'both a and b',0x01,25,144),
 (31,'object oriented',0x01,23,20),
 (32,'Static Binding',0x01,28,20),
 (33,'Compilation',0x01,25,20),
 (34,'Oracle',0x01,26,20),
 (35,'serializable',0x01,29,20),
 (36,'jdk',0x01,21,20),
 (37,'.java',0x01,27,20),
 (38,'oak',0x01,22,20),
 (39,'java development kit',0x01,24,20),
 (40,' Finally',0x01,30,20),
 (321,'Dynamic Binding',0x01,28,145),
 (322,' Finally',0x01,30,145),
 (323,'Compilation',0x01,25,145),
 (324,'object oriented',0x01,23,145),
 (325,'serializable',0x01,29,145),
 (326,'oak',0x01,22,145),
 (327,'jdk',0x01,21,145),
 (328,'java development kit',0x01,24,145),
 (329,'.java',0x01,27,145),
 (330,'Sun',0x01,26,145),
 (331,'tbl-border',0x01,8,20),
 (332,'<strong>',0x01,1,20),
 (333,'body {background-image:url(paper.gif);}',0x01,10,20),
 (334,'h2 {font-size:200px;}',0x01,6,20),
 (335,'text-transformation',0x01,3,20),
 (336,'-class',0x01,2,20),
 (337,'word-spacing',0x01,4,20),
 (338,'clear',0x01,5,20),
 (339,'backg-image',0x01,9,20),
 (340,'p {color:red;text-align:center}',0x01,7,20),
 (351,'ls tag',0x01,14,20),
 (352,'Used to separate cell walls from their contents.',0x01,13,20),
 (353,'Using resize attribute',0x01,17,20),
 (354,NULL,0x00,16,20),
 (355,'<hr>',0x01,20,20),
 (356,'textarea tag',0x01,11,20),
 (357,'Connecting to the internet',0x01,19,20),
 (358,'font',0x01,15,20),
 (359,'Paragraph break',0x01,18,20),
 (360,'<SUB>',0x01,12,20),
 (361,'Space',0x01,18,129),
 (362,'<hr>',0x01,20,129),
 (363,'font',0x01,15,129),
 (364,'ol tag',0x01,14,129),
 (365,'Both a and b above',0x01,13,129),
 (366,'Transfer files to and from an Internet Server',0x01,19,129),
 (367,'Both b and c',0x01,11,129),
 (368,'Using size attribute',0x01,17,129),
 (369,'<SUP>',0x01,12,129),
 (370,'To provide space between tables',0x01,16,129),
 (371,'.java',0x01,27,129),
 (372,'Value-A Name-B',0x01,39,129),
 (373,'Cat',0x01,33,129),
 (374,'A a = new A(String s);',0x01,34,129),
 (375,'Compilation fails',0x01,30,129),
 (376,'object oriented',0x01,23,129),
 (377,'cloneable',0x01,29,129),
 (378,'Sun',0x01,26,129),
 (379,'both a and b',0x01,25,129),
 (380,'22',0x01,35,129),
 (381,NULL,0x00,11,152),
 (382,NULL,0x00,16,152),
 (383,NULL,0x00,17,152),
 (384,NULL,0x00,19,152),
 (385,NULL,0x00,20,152),
 (386,NULL,0x00,15,152),
 (387,NULL,0x00,14,152),
 (388,NULL,0x00,13,152),
 (389,NULL,0x00,12,152),
 (390,NULL,0x00,18,152),
 (391,'body {background-image:url(\'paper.gif\')}',0x01,10,157),
 (392,'-id',0x01,2,157),
 (393,'both and b',0x01,5,157),
 (394,'both a and b',0x01,6,157),
 (395,'Both b and c',0x01,4,157),
 (396,'border',0x01,8,157),
 (397,'p {color:red;text-align:center}',0x01,7,157),
 (398,'<strong>',0x01,1,157),
 (399,'background-img',0x01,9,157),
 (400,'text-trans',0x01,3,157),
 (401,'<P>',0x01,12,157),
 (402,'To logically divide the document',0x01,16,157),
 (403,'Using height and width',0x01,17,157),
 (404,'Both b and c',0x01,11,157),
 (405,'<line direction=\"horizontal\">',0x01,20,157),
 (406,'Both a and b above',0x01,13,157),
 (407,'font',0x01,15,157),
 (408,'Transfer files to and from an Internet Server',0x01,19,157),
 (409,'list tag',0x01,14,157),
 (410,'Line break',0x01,18,157),
 (411,'.java',0x01,27,157),
 (412,'both a and b',0x01,25,157),
 (413,'Sun',0x01,26,157),
 (414,'serializable',0x01,29,157),
 (415,'java development kit',0x01,24,157),
 (416,'Cat',0x01,33,157),
 (417,'jdk',0x01,21,157),
 (418,'A a = new B();',0x01,34,157),
 (419,NULL,0x00,39,157),
 (420,'object oriented',0x01,23,157),
 (481,'Java only',0x01,22,161),
 (482,'Value-A Value-A',0x01,39,161),
 (483,'both a and b',0x01,25,161),
 (484,'Static Binding',0x01,28,161),
 (485,'jdk',0x01,21,161),
 (486,'The code runs with no output.l',0x01,30,161),
 (487,'object oriented',0x01,23,161),
 (488,'none of the above',0x01,29,161),
 (489,NULL,0x00,24,161),
 (490,'Sun',0x01,26,161),
 (491,'textml tag',0x01,11,161),
 (492,'<SUP>',0x01,12,161),
 (493,'fontname',0x01,15,161),
 (494,'ls tag',0x01,14,161),
 (495,'<hr>',0x01,20,161),
 (496,'Using height and width',0x01,17,161),
 (497,'To logically divide the document',0x01,16,161),
 (498,'Line break',0x01,18,161),
 (499,'Used to separate cell walls from their contents.',0x01,13,161),
 (500,'Connecting to the internet',0x01,19,161),
 (501,'<strong>',0x01,1,161),
 (502,'background-img',0x01,9,161),
 (503,'text-transformation',0x01,3,161),
 (504,'h2 {font-size:200%;}',0x01,6,161),
 (505,'p {color:red;text-align:center};',0x01,7,161),
 (506,'clear',0x01,5,161),
 (507,'body {background-image:url(\'paper.gif\');}',0x01,10,161),
 (508,NULL,0x00,8,161),
 (509,NULL,0x00,4,161),
 (510,NULL,0x00,2,161),
 (511,'serializable',0x01,29,164),
 (512,'Sun',0x01,26,164),
 (513,'.java',0x01,27,164),
 (514,' Finally',0x01,30,164),
 (515,'Cat',0x01,33,164),
 (516,'object oriented',0x01,23,164),
 (517,'Static Binding',0x01,28,164),
 (518,'Compile error',0x01,37,164),
 (519,'A a = new A(String s);',0x01,34,164),
 (520,'Name-B Name-C',0x01,39,164),
 (521,NULL,0x00,11,164),
 (522,NULL,0x00,15,164),
 (523,NULL,0x00,20,164),
 (524,NULL,0x00,16,164),
 (525,NULL,0x00,13,164),
 (526,NULL,0x00,14,164),
 (527,NULL,0x00,19,164),
 (528,NULL,0x00,18,164),
 (529,NULL,0x00,17,164),
 (530,NULL,0x00,12,164),
 (531,'Compilation fails with an error at line 4\r\n',0x01,40,163),
 (532,'Runtime Exception',0x01,37,163),
 (533,'Oracle',0x01,26,163),
 (534,'oak',0x01,22,163),
 (535,'java.util.ArrayList',0x01,38,163),
 (536,NULL,0x00,39,163),
 (537,'object oriented',0x01,23,163),
 (538,'Compile fail due to error on line no 8',0x01,31,163),
 (539,'Animal',0x01,33,163),
 (540,'interpretation',0x01,25,163),
 (541,'<SUP>',0x01,12,163),
 (542,'Line break',0x01,18,163),
 (543,'ol tag',0x01,14,163),
 (544,'Transfer files to and from an Internet Server',0x01,19,163),
 (545,'Both b and c',0x01,11,163),
 (546,NULL,0x00,17,163),
 (547,NULL,0x00,20,163),
 (548,NULL,0x00,13,163),
 (549,NULL,0x00,15,163),
 (550,NULL,0x00,16,163),
 (551,'clear',0x01,5,164),
 (552,'table-border',0x01,8,164),
 (553,'background-image',0x01,9,164),
 (554,'p {color:red;text-align:center;}',0x01,7,164),
 (555,'body {background-image:url(\'paper.gif\');}',0x01,10,164),
 (556,'-id',0x01,2,164),
 (557,'text-decoration',0x01,3,164),
 (558,'<strong>',0x01,1,164),
 (559,'h2 {font-size:200px;}',0x01,6,164),
 (560,'word-spacing',0x01,4,164),
 (561,'word-spacing',0x01,4,163),
 (562,'cleared',0x01,5,163),
 (563,'tb-border',0x01,8,163),
 (564,'background-img',0x01,9,163),
 (565,'-id',0x01,2,163),
 (566,'text-decoration',0x01,3,163),
 (567,'<strong>',0x01,1,163),
 (568,'body {background-image:url(\'paper.gif\')}',0x01,10,163),
 (569,'p {color:red;text-align:center;}',0x01,7,163),
 (570,'both a and b',0x01,6,163),
 (571,'A a = new B();',0x01,34,165),
 (572,' Finally',0x01,30,165),
 (573,'java development kit',0x01,24,165),
 (574,'both a and b',0x01,25,165),
 (575,'Static Binding',0x01,28,165),
 (576,'true',0x01,40,165),
 (577,'Compilation fails due to an error on line 4',0x01,36,165),
 (578,'oak',0x01,22,165),
 (579,'7 9',0x01,37,165),
 (580,'Sun',0x01,26,165),
 (581,'body {background-image:url(paper.gif);}',0x01,10,165),
 (582,NULL,0x00,7,165),
 (583,'border',0x01,8,165),
 (584,'<strong>',0x01,1,165),
 (585,'word-spacing',0x01,4,165),
 (586,'background-image',0x01,9,165),
 (587,'clear',0x01,5,165),
 (588,'text-decoration',0x01,3,165),
 (589,'-id',0x01,2,165),
 (590,'h2 {font-size:200px;}',0x01,6,165),
 (591,'jdk',0x01,21,168),
 (592,'oak',0x01,22,168),
 (593,'java development kit',0x01,24,168),
 (594,'Value-A Name-C',0x01,39,168),
 (595,'.java',0x01,27,168),
 (596,'An exception is thrown at runtime.',0x01,30,168),
 (597,'Compile error - static variable must be initialized before use. ',0x01,32,168),
 (598,'Runtime Exception',0x01,37,168),
 (599,'Cat',0x01,33,168),
 (600,'object oriented',0x01,23,168),
 (601,'<SUP>',0x01,12,168),
 (602,NULL,0x00,20,168),
 (603,NULL,0x00,15,168),
 (604,NULL,0x00,11,168),
 (605,NULL,0x00,16,168),
 (606,NULL,0x00,18,168),
 (607,NULL,0x00,17,168),
 (608,NULL,0x00,14,168),
 (609,NULL,0x00,19,168),
 (610,NULL,0x00,13,168),
 (611,'both a and b',0x01,6,168),
 (612,'body {background-image:url(\'paper.gif\')};',0x01,10,168),
 (613,'-id',0x01,2,168),
 (614,'<strong>',0x01,1,168),
 (615,'background-image',0x01,9,168),
 (616,'table-border',0x01,8,168),
 (617,'p {color:red;text-align:center};',0x01,7,168),
 (618,'word-space',0x01,4,168),
 (619,'text-decoration',0x01,3,168),
 (620,'clear',0x01,5,168),
 (621,'Animal',0x01,33,169),
 (622,'oak',0x01,22,169),
 (623,'Name-B Name-C',0x01,39,169),
 (624,'java.util.Vector',0x01,38,169),
 (625,'serializable',0x01,29,169),
 (626,'Both of the above',0x01,28,169),
 (627,'Sun',0x01,26,169),
 (628,'22',0x01,35,169),
 (629,'7 9',0x01,37,169),
 (630,' Finally',0x01,30,169),
 (631,'<SUP>',0x01,12,169),
 (632,'Transfer files to and from an Internet Server',0x01,19,169),
 (633,'Line break',0x01,18,169),
 (634,'Used to provide width to a cell',0x01,13,169),
 (635,'Using rs attribute',0x01,17,169),
 (636,'font',0x01,15,169),
 (637,'list tag',0x01,14,169),
 (638,'To logically divide the document',0x01,16,169),
 (639,'Both b and c',0x01,11,169),
 (640,'<line>',0x01,20,169),
 (641,'-id',0x01,2,169),
 (642,'both and b',0x01,5,169),
 (643,'text-trans',0x01,3,169),
 (644,'h2 {font-size:200px;}',0x01,6,169),
 (645,'p {color:red;text-align:center;}',0x01,7,169),
 (646,'tb-border',0x01,8,169),
 (647,'<dar>',0x01,1,169),
 (648,'word-space',0x01,4,169),
 (649,'background-img',0x01,9,169),
 (650,'body {background-image:url(\'paper.gif\')}',0x01,10,169),
 (651,'Value-A Value-A',0x01,39,170),
 (652,'Animal',0x01,33,170),
 (653,'both a and b',0x01,25,170),
 (654,'50',0x01,35,170),
 (655,'Sun',0x01,26,170),
 (656,'.java',0x01,27,170),
 (657,'Compilation fails with an error at line 3',0x01,40,170),
 (658,'A a = new B();',0x01,34,170),
 (659,'java.util.ArrayList',0x01,38,170),
 (660,NULL,0x00,22,170),
 (661,'Compilation fails with an error at line 4',0x01,35,167),
 (662,'oak',0x01,22,167),
 (663,'true',0x01,40,167),
 (664,'run-test run-test',0x01,36,167),
 (665,'java development kit',0x01,24,167),
 (666,'Compile fail due to error on line no 9',0x01,31,167),
 (667,' Finally',0x01,30,167),
 (668,'A a = new B(5);',0x01,34,167),
 (669,'both a and b',0x01,25,167),
 (670,'.java',0x01,27,167),
 (671,'<hr>',0x01,20,170),
 (672,'face',0x01,15,170),
 (673,'Line break',0x01,18,170),
 (674,'textarea tag',0x01,11,170),
 (675,'<SUP>',0x01,12,170),
 (676,'li tag',0x01,14,170),
 (677,'Transfer files to and from an Internet Server',0x01,19,170),
 (678,'Used to set space between cells',0x01,13,170),
 (679,'To logically divide the document',0x01,16,170),
 (680,'Using height and width',0x01,17,170),
 (681,'Used to separate cell walls from their contents.',0x01,13,167),
 (682,'To logically divide the document',0x01,16,167),
 (683,'li tag',0x01,14,167),
 (684,'Line break',0x01,18,167),
 (685,'<SUP>',0x01,12,167),
 (686,'Using height and width',0x01,17,167),
 (687,'Transfer files to and from an Internet Server',0x01,19,167),
 (688,'font',0x01,15,167),
 (689,'textarea tag',0x01,11,167),
 (690,'<hr>',0x01,20,167),
 (691,'background-image',0x01,9,170),
 (692,'text-decoration',0x01,3,170),
 (693,'both a and b',0x01,6,170),
 (694,'body {background-image:url(\'paper.gif\');}',0x01,10,170),
 (695,'p {color:red;text-align:center;}',0x01,7,170),
 (696,'<strong>',0x01,1,170),
 (697,'word-spacing',0x01,4,170),
 (698,'border',0x01,8,170),
 (699,'clear',0x01,5,170),
 (700,'-id',0x01,2,170),
 (701,'text-decoration',0x01,3,167),
 (702,'both and b',0x01,5,167),
 (703,'background-image',0x01,9,167),
 (704,'<strong>',0x01,1,167),
 (705,'border',0x01,8,167),
 (706,'both a and b',0x01,6,167),
 (707,'p {color:red;text-align:center;}',0x01,7,167),
 (708,'Both b and c',0x01,4,167),
 (709,'body {background-image:url(\'paper.gif\');}',0x01,10,167),
 (710,'-id',0x01,2,167),
 (711,'Compilation fails with an error at line 4',0x01,35,171),
 (712,'java.util.ArrayList',0x01,38,171),
 (713,'A a = new B(5);',0x01,34,171),
 (714,'0 false 0',0x01,32,171),
 (715,'Sun',0x01,26,171),
 (716,'oak',0x01,22,171),
 (717,' Finally',0x01,30,171),
 (718,'true',0x01,40,171),
 (719,'object oriented',0x01,23,171),
 (720,'run-test run-test',0x01,36,171),
 (721,'li tag',0x01,14,171),
 (722,'textarea tag',0x01,11,171),
 (723,'<SUP>',0x01,12,171),
 (724,'Using height and width',0x01,17,171),
 (725,'Line break',0x01,18,171),
 (726,'Transfer files to and from an Internet Server',0x01,19,171),
 (727,'To logically divide the document',0x01,16,171),
 (728,'face',0x01,15,171),
 (729,'Used to separate cell walls from their contents.',0x01,13,171),
 (730,'<hr>',0x01,20,171),
 (731,'border',0x01,8,171),
 (732,'Both b and c',0x01,4,171),
 (733,'body {background-image:url(\'paper.gif\');}',0x01,10,171),
 (734,'<strong>',0x01,1,171),
 (735,'clear',0x01,5,171),
 (736,'both a and b',0x01,6,171),
 (737,'background-image',0x01,9,171),
 (738,'p {color:red;text-align:center;}',0x01,7,171),
 (739,'text-decoration',0x01,3,171),
 (740,'-id',0x01,2,171),
 (741,'A a = new B();',0x01,34,172),
 (742,'true',0x01,40,172),
 (743,'java.util.ArrayList',0x01,38,172),
 (744,' Finally',0x01,30,172),
 (745,'Sun',0x01,26,172),
 (746,'Static Binding',0x01,28,172),
 (747,'java development kit',0x01,24,172),
 (748,'Compile fail due to error on line no 8',0x01,31,172),
 (749,'oak',0x01,22,172),
 (750,'Animal Cat',0x01,33,172),
 (751,'Using resize attribute',0x01,17,172),
 (752,NULL,0x00,14,172),
 (753,NULL,0x00,15,172),
 (754,NULL,0x00,18,172),
 (755,NULL,0x00,11,172),
 (756,NULL,0x00,12,172),
 (757,NULL,0x00,16,172),
 (758,NULL,0x00,20,172),
 (759,NULL,0x00,19,172),
 (760,NULL,0x00,13,172),
 (761,'table-border',0x01,8,172),
 (762,'backg-img',0x01,9,172),
 (763,'float',0x01,5,172),
 (764,'body {background-image:url(\'paper.gif\')};',0x01,10,172),
 (765,'p (color:red;text-align:center;)',0x01,7,172),
 (766,'space',0x01,4,172),
 (767,'<strong>',0x01,1,172),
 (768,'h2 {font-size:200%;}',0x01,6,172),
 (769,'text-decoration',0x01,3,172),
 (770,'text',0x01,2,172),
 (771,'.java',0x01,27,176),
 (772,'Name-B Name-C',0x01,39,176),
 (773,'object oriented',0x01,23,176),
 (774,'oak',0x01,22,176),
 (775,'java.util.ArrayList',0x01,38,176),
 (776,'jdk',0x01,21,176),
 (777,'serializable',0x01,29,176),
 (778,'both a and b',0x01,25,176),
 (779,'15\r\n',0x01,31,176),
 (780,' Finally',0x01,30,176),
 (811,'Used to separate cell walls from their contents.',0x01,13,176),
 (812,'<SUP>',0x01,12,176),
 (813,'li tag',0x01,14,176),
 (814,'textarea tag',0x01,11,176),
 (815,'Line break',0x01,18,176),
 (816,'face',0x01,15,176),
 (817,'To logically divide the document',0x01,16,176),
 (818,'Using height and width',0x01,17,176),
 (819,'Transfer files to and from an Internet Server',0x01,19,176),
 (820,'<hr>',0x01,20,176),
 (821,'both a and b',0x01,6,176),
 (822,'<strong>',0x01,1,176),
 (823,'body {background-image:url(\'paper.gif\');}',0x01,10,176),
 (824,'background-image',0x01,9,176),
 (825,'clear',0x01,5,176),
 (826,'word-spacing',0x01,4,176),
 (827,'-id',0x01,2,176),
 (828,'p {color:red;text-align:center;}',0x01,7,176),
 (829,'border',0x01,8,176),
 (830,'text-decoration',0x01,3,176),
 (831,'Runtime Exception',0x01,37,179),
 (832,'Compile error - static variable must be initialized before use. ',0x01,32,179),
 (833,'A a = new A(String s);',0x01,34,179),
 (834,'jdk',0x01,21,179),
 (835,'Value-A Name-C',0x01,39,179),
 (836,'Compilation fails',0x01,30,179),
 (837,'both a and b',0x01,25,179),
 (838,NULL,0x00,31,179),
 (839,'Oracle',0x01,26,179),
 (840,'50',0x01,35,179),
 (841,'java development kit',0x01,24,177),
 (842,'run-test run-test',0x01,36,177),
 (843,'50',0x01,35,177),
 (844,'Compile error',0x01,37,177),
 (845,'interpretation',0x01,25,177),
 (846,'object oriented',0x01,23,177),
 (847,'oak',0x01,22,177),
 (848,'jdk',0x01,21,177),
 (849,'Cat',0x01,33,177),
 (850,'serializable',0x01,29,177),
 (851,'face',0x01,15,179),
 (852,'To provide space between tables',0x01,16,179),
 (853,'li tag',0x01,14,179),
 (854,'textarea tag',0x01,11,179),
 (855,'<hr>',0x01,20,179),
 (856,'Line break',0x01,18,179),
 (857,'Used to set space between cells',0x01,13,179),
 (858,'Using height and width',0x01,17,179),
 (859,'Transfer files to and from an Internet Server',0x01,19,179),
 (860,'<SUP>',0x01,12,179),
 (861,'<SUP>',0x01,12,177),
 (862,'font',0x01,15,177),
 (863,'Using height and width',0x01,17,177),
 (864,'Used to separate cell walls from their contents.',0x01,13,177),
 (865,'Transfer files to and from an Internet Server',0x01,19,177),
 (866,'To provide space between tables',0x01,16,177),
 (867,'textarea tag',0x01,11,177),
 (868,'<hr>',0x01,20,177),
 (869,'Line break',0x01,18,177),
 (870,'ol tag',0x01,14,177),
 (871,'p {color:red;text-align:center};',0x01,7,177),
 (872,NULL,0x00,10,177),
 (873,NULL,0x00,1,177),
 (874,NULL,0x00,9,177),
 (875,NULL,0x00,5,177),
 (876,NULL,0x00,8,177),
 (877,NULL,0x00,3,177),
 (878,NULL,0x00,2,177),
 (879,NULL,0x00,4,177),
 (880,NULL,0x00,6,177),
 (881,'clear',0x01,5,179),
 (882,'word-spacing',0x01,4,179),
 (883,'h2 {font-size:200px;}',0x01,6,179),
 (884,'p {color:red;text-align:center;}',0x01,7,179),
 (885,'background-image',0x01,9,179),
 (886,'-id',0x01,2,179),
 (887,'<strong>',0x01,1,179),
 (888,'text-decoration',0x01,3,179),
 (889,'border',0x01,8,179),
 (890,'body {background-image:url(\'paper.gif\');}',0x01,10,179),
 (891,'Sun',0x01,26,182),
 (892,'java.util.Vector',0x01,38,182),
 (893,'Compile error - static variable must be initialized before use. ',0x01,32,182),
 (894,'jdk',0x01,22,182),
 (895,'Compilation fails with an error at line 4',0x01,35,182),
 (896,'both a and b',0x01,25,182),
 (897,'java development kit',0x01,24,182),
 (898,'cloneable',0x01,29,182),
 (899,'.java',0x01,27,182),
 (900,'Compilation fails with an error at line 3',0x01,40,182),
 (901,'Transfer files to and from an Internet Server',0x01,19,182),
 (902,'<SUP>',0x01,12,182),
 (903,'fn',0x01,15,182),
 (904,'Both a and b above',0x01,13,182),
 (905,'Paragraph break',0x01,18,182),
 (906,'text tag',0x01,11,182),
 (907,'To logically divide the paragraphs',0x01,16,182),
 (908,'ls tag',0x01,14,182),
 (909,'<line direction=\"horizontal\">',0x01,20,182),
 (910,'Using height and width',0x01,17,182),
 (911,'<strong>',0x01,1,182),
 (912,'Both b and c',0x01,4,182),
 (913,'both a and b',0x01,6,182),
 (914,'background-img',0x01,9,182),
 (915,'text-decoration',0x01,3,182),
 (916,'p {color:red;text-align:center}',0x01,7,182),
 (917,'tb-border',0x01,8,182),
 (918,'float',0x01,5,182),
 (919,'-id',0x01,2,182),
 (920,'body {background-image:url(\'paper.gif\')}',0x01,10,182),
 (931,'Compile fail due to error on line no 9',0x01,31,185),
 (932,'Compilation fails with an error at line 3',0x01,40,185),
 (933,'Runtime Exception',0x01,37,185),
 (934,'Both of the above',0x01,28,185),
 (935,'both a and b',0x01,25,185),
 (936,'Compilation fails due to an error on line 4',0x01,36,185),
 (937,'The code runs with no output.l',0x01,30,185),
 (938,'Sun',0x01,26,185),
 (939,'cloneable',0x01,29,185),
 (940,'All of the above\r\n',0x01,34,185),
 (941,'jdk',0x01,21,187),
 (942,'both a and b',0x01,25,187),
 (943,'Compile fail due to error on line no 9',0x01,31,187),
 (944,'Compilation fails with an error at line 4',0x01,35,187),
 (945,'Compile error',0x01,37,187),
 (946,'oak',0x01,22,187),
 (947,'Compilation fails due to an error on line 7\r\n',0x01,36,187),
 (948,'true',0x01,40,187),
 (949,'java development kit',0x01,24,187),
 (950,'Sun',0x01,26,187),
 (951,'font',0x01,15,187),
 (952,'<SUP>',0x01,12,187),
 (953,'To logically divide the paragraphs',0x01,16,187),
 (954,'Using height and width',0x01,17,187),
 (955,'li tag',0x01,14,187),
 (956,'Transfer files to and from an Internet Server',0x01,19,187),
 (957,'Used to separate cell walls from their contents.',0x01,13,187),
 (958,'<line direction=\"horizontal\">',0x01,20,187),
 (959,NULL,0x00,11,187),
 (960,NULL,0x00,18,187),
 (961,'serializable',0x01,29,181),
 (962,'object oriented',0x01,23,181),
 (963,'Sun',0x01,26,181),
 (964,'Compile fail due to error on line no 8',0x01,31,181),
 (965,'Compile error - static variable must be initialized before use. ',0x01,32,181),
 (966,'The code runs with no output.l',0x01,30,181),
 (967,'Compile Error',0x01,33,181),
 (968,'oak',0x01,22,181),
 (969,'Value-A Value-A',0x01,39,181),
 (970,'A a = new A(String s);',0x01,34,181),
 (971,'text-decoration',0x01,3,187),
 (972,'both a and b',0x01,6,187),
 (973,'table-border',0x01,8,187),
 (974,'<strong>',0x01,1,187),
 (975,'word-spacing',0x01,4,187),
 (976,'clear',0x01,5,187),
 (977,'body {background-image:url(\'paper.gif\');}',0x01,10,187),
 (978,'-id',0x01,2,187),
 (979,'p {color:red;text-align:center};',0x01,7,187),
 (980,'background-image',0x01,9,187),
 (981,'Using height and width',0x01,17,181),
 (982,'<line direction=\"horizontal\">',0x01,20,181),
 (983,'To logically divide the paragraphs',0x01,16,181),
 (984,'Transfer files to and from an Internet Server',0x01,19,181),
 (985,'Line break',0x01,18,181),
 (986,'textarea tag',0x01,11,181),
 (987,'li tag',0x01,14,181),
 (988,NULL,0x00,13,181),
 (989,'font',0x01,15,181),
 (990,'<SUB>',0x01,12,181),
 (991,'Using height and width',0x01,17,181),
 (992,'<line direction=\"horizontal\">',0x01,20,181),
 (993,'To logically divide the paragraphs',0x01,16,181),
 (994,'Transfer files to and from an Internet Server',0x01,19,181),
 (995,'Line break',0x01,18,181),
 (996,'textarea tag',0x01,11,181),
 (997,'li tag',0x01,14,181),
 (998,NULL,0x00,13,181),
 (999,'font',0x01,15,181),
 (1000,'<SUB>',0x01,12,181),
 (1001,'Using height and width',0x01,17,181),
 (1002,'<line direction=\"horizontal\">',0x01,20,181),
 (1003,'To logically divide the paragraphs',0x01,16,181),
 (1004,'Transfer files to and from an Internet Server',0x01,19,181),
 (1005,'Line break',0x01,18,181),
 (1006,'textarea tag',0x01,11,181),
 (1007,'li tag',0x01,14,181),
 (1008,NULL,0x00,13,181),
 (1009,'font',0x01,15,181),
 (1010,'<SUB>',0x01,12,181),
 (1011,'Using height and width',0x01,17,181),
 (1012,'<line direction=\"horizontal\">',0x01,20,181),
 (1013,'To logically divide the paragraphs',0x01,16,181),
 (1014,'Transfer files to and from an Internet Server',0x01,19,181),
 (1015,'Line break',0x01,18,181),
 (1016,'textarea tag',0x01,11,181),
 (1017,'li tag',0x01,14,181),
 (1018,NULL,0x00,13,181),
 (1019,'font',0x01,15,181),
 (1020,'<SUB>',0x01,12,181),
 (1021,'Using height and width',0x01,17,181),
 (1022,'<line direction=\"horizontal\">',0x01,20,181),
 (1023,'To logically divide the paragraphs',0x01,16,181),
 (1024,'Transfer files to and from an Internet Server',0x01,19,181),
 (1025,'Line break',0x01,18,181),
 (1026,'textarea tag',0x01,11,181),
 (1027,'li tag',0x01,14,181),
 (1028,NULL,0x00,13,181),
 (1029,'font',0x01,15,181),
 (1030,'<SUB>',0x01,12,181),
 (1031,'Using height and width',0x01,17,181),
 (1032,'<line direction=\"horizontal\">',0x01,20,181),
 (1033,'To logically divide the paragraphs',0x01,16,181),
 (1034,'Transfer files to and from an Internet Server',0x01,19,181),
 (1035,'Line break',0x01,18,181),
 (1036,'textarea tag',0x01,11,181),
 (1037,'li tag',0x01,14,181),
 (1038,NULL,0x00,13,181),
 (1039,'font',0x01,15,181),
 (1040,'<SUB>',0x01,12,181),
 (1041,'Using height and width',0x01,17,181),
 (1042,'<line direction=\"horizontal\">',0x01,20,181),
 (1043,'To logically divide the paragraphs',0x01,16,181),
 (1044,'Transfer files to and from an Internet Server',0x01,19,181),
 (1045,'Line break',0x01,18,181),
 (1046,'textarea tag',0x01,11,181),
 (1047,'li tag',0x01,14,181),
 (1048,NULL,0x00,13,181),
 (1049,'font',0x01,15,181),
 (1050,'<SUB>',0x01,12,181),
 (1071,'body {background-image:url(\'paper.gif\')}',0x01,10,181),
 (1072,'p {color:red;text-align:center}',0x01,7,181),
 (1073,'background-image',0x01,9,181),
 (1074,'Both b and c',0x01,4,181),
 (1075,'text-transformation',0x01,3,181),
 (1076,'-id',0x01,2,181),
 (1077,'table-border',0x01,8,181),
 (1078,'float',0x01,5,181),
 (1079,'<strong>',0x01,1,181),
 (1080,'h2 {font-size:200px;}',0x01,6,181),
 (1081,'Compilation',0x01,25,189),
 (1082,'Compile fail due to error on line no 9',0x01,31,189),
 (1083,'jdk',0x01,21,189),
 (1084,'22',0x01,35,189),
 (1085,'Animal Cat',0x01,33,189),
 (1086,'serializable',0x01,29,189),
 (1087,'java.util.ArrayList',0x01,38,189),
 (1088,'object oriented',0x01,23,189),
 (1089,'Compile error',0x01,37,189),
 (1090,'Static Binding',0x01,28,189),
 (1091,'<hr>',0x01,20,189),
 (1092,'To logically divide the document',0x01,16,189),
 (1093,'Transfer files to and from an Internet Server',0x01,19,189),
 (1094,'Used to separate cell walls from their contents.',0x01,13,189),
 (1095,'textarea tag',0x01,11,189),
 (1096,'face',0x01,15,189),
 (1097,'Line break',0x01,18,189),
 (1098,'Using height and width',0x01,17,189),
 (1099,'ls tag',0x01,14,189),
 (1100,'<SUP>',0x01,12,189),
 (1101,'h2 {font-size:200px;}',0x01,6,189),
 (1102,'p {color:red;text-align:center;}',0x01,7,189),
 (1103,'-id',0x01,2,189),
 (1104,'clear',0x01,5,189),
 (1105,'border',0x01,8,189),
 (1106,'<strong>',0x01,1,189),
 (1107,'background-img',0x01,9,189),
 (1108,'text-decoration',0x01,3,189),
 (1109,'word-spacing',0x01,4,189),
 (1110,'body {background-image:url(\'paper.gif\');}',0x01,10,189),
 (1111,'jdk',0x01,21,191),
 (1112,'Compile error - static variable must be initialized before use. ',0x01,32,191),
 (1113,'Compilation fails with an error at line 4\r\n',0x01,40,191),
 (1114,'serializable',0x01,29,191),
 (1115,'Oracle',0x01,26,191),
 (1116,'15\r\n',0x01,31,191),
 (1117,'Name-B Name-C',0x01,39,191),
 (1118,'7 9',0x01,37,191),
 (1119,'An exception is thrown at runtime.',0x01,30,191),
 (1120,'All of the above\r\n',0x01,34,191),
 (1121,'Static Binding',0x01,28,192),
 (1122,'Sun',0x01,26,192),
 (1123,'Compile Error',0x01,33,192),
 (1124,NULL,0x00,36,192),
 (1125,NULL,0x00,35,192),
 (1126,NULL,0x00,39,192),
 (1127,NULL,0x00,37,192),
 (1128,'Compile fail due to error on line no 9',0x01,31,192),
 (1129,' Finally',0x01,30,192),
 (1130,'java.util.ArrayList',0x01,38,192),
 (1131,'object oriented',0x01,23,193),
 (1132,'oak',0x01,22,193),
 (1133,NULL,0x00,37,193),
 (1134,'A a = new B();',0x01,34,193),
 (1135,'java development kit',0x01,24,193),
 (1136,'15\r\n',0x01,31,193),
 (1137,'.java',0x01,27,193),
 (1138,'java.util.ArrayList',0x01,38,193),
 (1139,'serializable',0x01,29,193),
 (1140,'22',0x01,35,193),
 (1141,'Transfer files to and from an Internet Server',0x01,19,193),
 (1142,'textarea tag',0x01,11,193),
 (1143,'<SUP>',0x01,12,193),
 (1144,'Using size attribute',0x01,17,193),
 (1145,'face',0x01,15,193),
 (1146,'Used to separate cell walls from their contents.',0x01,13,193),
 (1147,'To logically divide the document',0x01,16,193),
 (1148,'<hr>',0x01,20,193),
 (1149,'li tag',0x01,14,193),
 (1150,'Line break',0x01,18,193),
 (1151,'border',0x01,8,193),
 (1152,'h2 {font-size:200px;}',0x01,6,193),
 (1153,'word-spacing',0x01,4,193),
 (1154,'bit',0x01,2,193),
 (1155,'<strong>',0x01,1,193),
 (1156,NULL,0x00,10,193),
 (1157,NULL,0x00,7,193),
 (1158,NULL,0x00,5,193),
 (1159,NULL,0x00,3,193),
 (1160,NULL,0x00,9,193),
 (1161,'object oriented',0x01,23,195),
 (1162,'Sun',0x01,26,195),
 (1163,'jdk',0x01,21,195),
 (1164,'Compile fail due to error on line no 9',0x01,31,195),
 (1165,'Static Binding',0x01,28,195),
 (1166,'true',0x01,40,195),
 (1167,'0 false 0',0x01,32,195),
 (1168,'Runtime Exception',0x01,37,195),
 (1169,'both a and b',0x01,25,195),
 (1170,'oak',0x01,22,195),
 (1171,'0 true 0',0x01,32,194),
 (1172,'Sun',0x01,26,194),
 (1173,'Name-B Name-C',0x01,39,194),
 (1174,'both a and b',0x01,25,194),
 (1175,'serializable',0x01,29,194),
 (1176,' Finally',0x01,30,194),
 (1177,'oak',0x01,22,194),
 (1178,'50',0x01,35,194),
 (1179,'Runtime Exception',0x01,37,194),
 (1180,'true',0x01,40,194),
 (1181,'Used to set space between cells',0x01,13,194),
 (1182,'li tag',0x01,14,194),
 (1183,'Using height and width',0x01,17,194),
 (1184,'font',0x01,15,194),
 (1185,'<hr>',0x01,20,194),
 (1186,'<SUP>',0x01,12,194),
 (1187,'Line break',0x01,18,194),
 (1188,'textarea tag',0x01,11,194),
 (1189,'To logically divide the document',0x01,16,194),
 (1190,'Transfer files to and from an Internet Server',0x01,19,194),
 (1191,'<strong>',0x01,1,194),
 (1192,'float',0x01,5,194),
 (1193,'background-image',0x01,9,194),
 (1194,'h2 {font-size:200px;}',0x01,6,194),
 (1195,'word-spacing',0x01,4,194),
 (1196,'body {background-image:url(\'paper.gif\');}',0x01,10,194),
 (1197,'-id',0x01,2,194),
 (1198,'p {color:red;text-align:center;}',0x01,7,194),
 (1199,'text-transformation',0x01,3,194),
 (1200,'border',0x01,8,194),
 (1201,' Finally',0x01,30,198),
 (1202,'run-test',0x01,36,198),
 (1203,'Value-A Name-B',0x01,39,198),
 (1204,'object oriented',0x01,23,198),
 (1205,'jdk',0x01,21,198),
 (1206,'Compile fail due to error on line no 9',0x01,31,198),
 (1207,'Animal Cat',0x01,33,198),
 (1208,'A a = new B();',0x01,34,198),
 (1209,'java development kit',0x01,24,198),
 (1210,'Static Binding',0x01,28,198),
 (1211,'To logically divide the document',0x01,16,198),
 (1212,'Transfer files to and from an Internet Server',0x01,19,198),
 (1213,'textarea tag',0x01,11,198),
 (1214,'Using height and width',0x01,17,198),
 (1215,'<hr>',0x01,20,198),
 (1216,'font',0x01,15,198),
 (1217,NULL,0x00,12,198),
 (1218,NULL,0x00,13,198),
 (1219,NULL,0x00,18,198),
 (1220,NULL,0x00,14,198),
 (1221,'background-image',0x01,9,198),
 (1222,'text-decoration',0x01,3,198),
 (1223,'p {color:red;text-align:center;}',0x01,7,198),
 (1224,'border',0x01,8,198),
 (1225,'<strong>',0x01,1,198),
 (1226,'both and b',0x01,5,198),
 (1227,'text',0x01,2,198),
 (1228,'h2 {font-size:200%;}',0x01,6,198),
 (1229,'word-spacing',0x01,4,198),
 (1230,'body {background-image:url(\'paper.gif\')};',0x01,10,198),
 (1231,'Compilation fails with an error at line 4\r\n',0x01,40,199),
 (1232,'oak',0x01,22,199),
 (1233,'22',0x01,35,199),
 (1234,'.java',0x01,27,199),
 (1235,'serializable',0x01,29,199),
 (1236,'Compilation fails due to an error on line 4',0x01,36,199),
 (1237,'Animal',0x01,33,199),
 (1238,'Compile fail due to error on line no 9',0x01,31,199),
 (1239,'interpretation',0x01,25,199),
 (1240,'java.util.Vector',0x01,38,199),
 (1241,'cloneable',0x01,29,196),
 (1242,'object oriented',0x01,23,196),
 (1243,'Compilation fails due to an error on line 4',0x01,36,196),
 (1244,'Dynamic Binding',0x01,28,196),
 (1245,'oak',0x01,22,196),
 (1246,'Compilation fails with an error at line 4',0x01,35,196),
 (1247,'java deployment kit',0x01,24,196),
 (1248,'.java',0x01,27,196),
 (1249,'Cat',0x01,33,196),
 (1250,'0 false 0',0x01,32,196),
 (1251,'textarea tag',0x01,11,196),
 (1252,'<hr>',0x01,20,196),
 (1253,'Connecting to the internet',0x01,19,196),
 (1254,'Line break',0x01,18,196),
 (1255,'fn',0x01,15,196),
 (1256,'li tag',0x01,14,196),
 (1257,'To provide space between tables',0x01,16,196),
 (1258,'<P>',0x01,12,196),
 (1259,'Using size attribute',0x01,17,196),
 (1260,'Used to provide width to a cell',0x01,13,196),
 (1261,'body {background-image:url(\'paper.gif\')};',0x01,10,196),
 (1262,'backg-img',0x01,9,196),
 (1263,'p {color:red;text-align:center}',0x01,7,196),
 (1264,'<dar>',0x01,1,196),
 (1265,'text',0x01,2,196),
 (1266,'word-space',0x01,4,196),
 (1267,'tb-border',0x01,8,196),
 (1268,'clear',0x01,5,196),
 (1269,'h2 {font-size:200;}',0x01,6,196),
 (1270,'text-deco',0x01,3,196),
 (1271,'<P>',0x01,12,191),
 (1272,'Using height and width',0x01,17,191),
 (1273,'Line break',0x01,18,191),
 (1274,'font',0x01,15,191),
 (1275,'Transfer files to and from an Internet Server',0x01,19,191),
 (1276,'Both a and b above',0x01,13,191),
 (1277,'To logically divide the document',0x01,16,191),
 (1278,'<hr>',0x01,20,191),
 (1279,'Both b and c',0x01,11,191),
 (1280,'ol tag',0x01,14,191),
 (1281,'The code runs with no output.l',0x01,30,200),
 (1282,'22',0x01,35,200),
 (1283,'Value-A Name-B',0x01,39,200),
 (1284,'Runtime Exception',0x01,37,200),
 (1285,'All of the above\r\n',0x01,34,200),
 (1286,'run-test run-test',0x01,36,200),
 (1287,'0 false 0',0x01,32,200),
 (1288,'both a and b',0x01,25,200),
 (1289,'java development kit',0x01,24,200),
 (1290,'true',0x01,40,200),
 (1291,'<strong>',0x01,1,191),
 (1292,'-id',0x01,2,191),
 (1293,'p {color:red;text-align:center;}',0x01,7,191),
 (1294,'background-img',0x01,9,191),
 (1295,'table-border',0x01,8,191),
 (1296,'word-spacing',0x01,4,191),
 (1297,'clear',0x01,5,191),
 (1298,'both a and b',0x01,6,191),
 (1299,'text-decoration',0x01,3,191),
 (1300,'body {background-image:url(\'paper.gif\');}',0x01,10,191),
 (1301,'<P>',0x01,12,200),
 (1302,'Used to set space between cells',0x01,13,200),
 (1303,'Transfer files to and from an Internet Server',0x01,19,200),
 (1304,'li tag',0x01,14,200),
 (1305,'<hr>',0x01,20,200),
 (1306,'Using height and width',0x01,17,200),
 (1307,'Both b and c',0x01,11,200),
 (1308,'font',0x01,15,200),
 (1309,'To logically divide the paragraphs',0x01,16,200),
 (1310,'Line break',0x01,18,200),
 (1311,'-class',0x01,2,200),
 (1312,'h2 {font-size:200px;}',0x01,6,200),
 (1313,'table-border',0x01,8,200),
 (1314,'p {color:red;text-align:center};',0x01,7,200),
 (1315,'text-transformation',0x01,3,200),
 (1316,'Both b and c',0x01,4,200),
 (1317,'clear',0x01,5,200),
 (1318,'<black>',0x01,1,200),
 (1319,'body {background-image:url(\'paper.gif\')};',0x01,10,200),
 (1320,'background-image',0x01,9,200),
 (1321,'java.util.ArrayList',0x01,38,201),
 (1322,'A a = new A(String s);',0x01,34,201),
 (1323,'object oriented',0x01,23,201),
 (1324,'Compilation fails with an error at line 4',0x01,35,201),
 (1325,'Animal',0x01,33,201),
 (1326,'Compile error - static variable must be initialized before use. ',0x01,32,201),
 (1327,'Compilation fails due to an error on line 4',0x01,36,201),
 (1328,'Compile error',0x01,37,201),
 (1329,'Compilation fails with an error at line 3',0x01,40,201),
 (1330,'oak',0x01,22,201),
 (1331,'To logically divide the document',0x01,16,201),
 (1332,'Using height and width',0x01,17,201),
 (1333,'li tag',0x01,14,201),
 (1334,'Both a and b above',0x01,13,201),
 (1335,'<SUP>',0x01,12,201),
 (1336,NULL,0x00,15,201),
 (1337,NULL,0x00,20,201),
 (1338,NULL,0x00,18,201),
 (1339,NULL,0x00,19,201),
 (1340,NULL,0x00,11,201),
 (1341,'border',0x01,8,201),
 (1342,'<strong>',0x01,1,201),
 (1343,'body {background-image:url(\'paper.gif\');}',0x01,10,201),
 (1344,'-id',0x01,2,201),
 (1345,'both a and b',0x01,6,201),
 (1346,'text-decoration',0x01,3,201),
 (1347,'p {color:red;text-align:center;}',0x01,7,201),
 (1348,'background-img',0x01,9,201),
 (1349,'clear',0x01,5,201),
 (1350,'word-space',0x01,4,201),
 (1351,'<SUP>',0x01,12,202),
 (1352,'font',0x01,15,202),
 (1353,NULL,0x00,13,202),
 (1354,NULL,0x00,19,202),
 (1355,NULL,0x00,20,202),
 (1356,NULL,0x00,16,202),
 (1357,NULL,0x00,11,202),
 (1358,NULL,0x00,18,202),
 (1359,NULL,0x00,14,202),
 (1360,NULL,0x00,17,202),
 (1361,'li tag',0x01,14,202),
 (1362,'<SUP>',0x01,12,202),
 (1363,'Line break',0x01,18,202),
 (1364,'face',0x01,15,202),
 (1365,'Using size attribute',0x01,17,202),
 (1366,'Used to separate cell walls from their contents.',0x01,13,202),
 (1367,'To logically divide the document',0x01,16,202),
 (1368,'<hr>',0x01,20,202),
 (1369,'Transfer files to and from an Internet Server',0x01,19,202),
 (1370,'textarea tag',0x01,11,202),
 (1371,'table-border',0x01,8,202),
 (1372,'<strong>',0x01,1,202),
 (1373,'word-spacing',0x01,4,202),
 (1374,'-id',0x01,2,202),
 (1375,'clear',0x01,5,202),
 (1376,'background-image',0x01,9,202),
 (1377,'text-decoration',0x01,3,202),
 (1378,'p (color:red;text-align:center;)',0x01,7,202),
 (1379,'both a and b',0x01,6,202),
 (1380,'body {background-image:url(\'paper.gif\')}',0x01,10,202),
 (1381,'both a and b',0x01,25,190),
 (1382,'comparable',0x01,29,190),
 (1383,'Runtime Exception',0x01,37,190),
 (1384,'java development kit',0x01,24,190),
 (1385,'Cat',0x01,33,190),
 (1386,'Static Binding',0x01,28,190),
 (1387,'Value-A Value-A',0x01,39,190),
 (1388,' Finally',0x01,30,190),
 (1389,'0 0 0',0x01,32,190),
 (1390,'oak',0x01,22,190),
 (1391,'Compilation fails due to an error on line 7\r\n',0x01,36,202),
 (1392,'java development kit',0x01,24,202),
 (1393,'0 false 0',0x01,32,202),
 (1394,'serializable',0x01,29,202),
 (1395,'Animal Cat',0x01,33,202),
 (1396,'Compile fail due to error on line no 8',0x01,31,202),
 (1397,'object oriented',0x01,23,202),
 (1398,'7 9',0x01,37,202),
 (1399,'Value-A Name-C',0x01,39,202),
 (1400,'.java',0x01,27,202),
 (1401,'Used to separate cell walls from their contents.',0x01,13,190),
 (1402,'<hr>',0x01,20,190),
 (1403,'<SUP>',0x01,12,190),
 (1404,'li tag',0x01,14,190),
 (1405,'Transfer files to and from an Internet Server',0x01,19,190),
 (1406,'Using height and width',0x01,17,190),
 (1407,'To logically divide the document',0x01,16,190),
 (1408,'font',0x01,15,190),
 (1409,'Line break',0x01,18,190),
 (1410,'textarea tag',0x01,11,190),
 (1411,'body {background-image:url(\'paper.gif\');}',0x01,10,190),
 (1412,NULL,0x00,7,190),
 (1413,NULL,0x00,6,190),
 (1414,NULL,0x00,8,190),
 (1415,NULL,0x00,5,190),
 (1416,NULL,0x00,4,190),
 (1417,NULL,0x00,2,190),
 (1418,NULL,0x00,1,190),
 (1419,NULL,0x00,9,190),
 (1420,NULL,0x00,3,190),
 (1421,'.java',0x01,27,205),
 (1422,'0 false 0',0x01,32,205),
 (1423,'both a and b',0x01,25,205),
 (1424,'7 9',0x01,37,205),
 (1425,'All of the above\r\n',0x01,34,205),
 (1426,'java development kit',0x01,24,205),
 (1427,'Sun',0x01,26,205),
 (1428,'Value-A Name-C',0x01,39,205),
 (1429,'Compile Error',0x01,33,205),
 (1430,'Compilation fails due to an error on line 4',0x01,36,205),
 (1431,'<SUP>',0x01,12,205),
 (1432,'face',0x01,15,205),
 (1433,'li tag',0x01,14,205),
 (1434,'Used to separate cell walls from their contents.',0x01,13,205),
 (1435,'<line direction=\"horizontal\">',0x01,20,205),
 (1436,'textarea tag',0x01,11,205),
 (1437,'Transfer files to and from an Internet Server',0x01,19,205),
 (1438,'To logically divide the document',0x01,16,205),
 (1439,'Using height and width',0x01,17,205),
 (1440,'Line break',0x01,18,205),
 (1441,'<strong>',0x01,1,205),
 (1442,'-id',0x01,2,205),
 (1443,'body {background-image:url(paper.gif);}',0x01,10,205),
 (1444,'border',0x01,8,205),
 (1445,'both a and b',0x01,6,205),
 (1446,'clear',0x01,5,205),
 (1447,'word-spacing',0x01,4,205),
 (1448,'p {color:red;text-align:center;}',0x01,7,205),
 (1449,'text-decoration',0x01,3,205),
 (1450,'background-image',0x01,9,205),
 (1451,'15\r\n',0x01,31,206),
 (1452,'true',0x01,40,206),
 (1453,'Both of the above',0x01,28,206),
 (1454,' Finally',0x01,30,206),
 (1455,'both a and b',0x01,25,206),
 (1456,'serializable',0x01,29,206),
 (1457,'object oriented',0x01,23,206),
 (1458,'0 false 0',0x01,32,206),
 (1459,'java development kit',0x01,24,206),
 (1460,'A a = new B();',0x01,34,206),
 (1461,'textarea tag',0x01,11,206),
 (1462,'li tag',0x01,14,206),
 (1463,'<SUP>',0x01,12,206),
 (1464,'Line break',0x01,18,206),
 (1465,'face',0x01,15,206),
 (1466,'Using height and width',0x01,17,206),
 (1467,'To logically divide the document',0x01,16,206),
 (1468,'Transfer files to and from an Internet Server',0x01,19,206),
 (1469,'<line direction=\"horizontal\">',0x01,20,206),
 (1470,'Used to separate cell walls from their contents.',0x01,13,206),
 (1471,'word-spacing',0x01,4,206),
 (1472,'both a and b',0x01,6,206),
 (1473,'-id',0x01,2,206),
 (1474,'background-image',0x01,9,206),
 (1475,'border',0x01,8,206),
 (1476,'<strong>',0x01,1,206),
 (1477,'text-decoration',0x01,3,206),
 (1478,'clear',0x01,5,206),
 (1479,'body {background-image:url(\'paper.gif\');}',0x01,10,206),
 (1480,'p {color:red;text-align:center;}',0x01,7,206),
 (1481,'both a and b',0x01,25,207),
 (1482,'Both of the above',0x01,28,207),
 (1483,'A a = new B();',0x01,34,207),
 (1484,'oak',0x01,22,207),
 (1485,'Value-A Name-C',0x01,39,207),
 (1486,'Compile Error',0x01,33,207),
 (1487,'0 false 0',0x01,32,207),
 (1488,'object oriented',0x01,23,207),
 (1489,'.java',0x01,27,207),
 (1490,' Finally',0x01,30,207),
 (1491,'textarea tag',0x01,11,207),
 (1492,'Transfer files to and from an Internet Server',0x01,19,207),
 (1493,'<line direction=\"horizontal\">',0x01,20,207),
 (1494,'Using height and width',0x01,17,207),
 (1495,'Line break',0x01,18,207),
 (1496,'To logically divide the document',0x01,16,207),
 (1497,'Used to separate cell walls from their contents.',0x01,13,207),
 (1498,'li tag',0x01,14,207),
 (1499,'face',0x01,15,207),
 (1500,'<SUP>',0x01,12,207),
 (1501,'word-spacing',0x01,4,207),
 (1502,'background-image',0x01,9,207),
 (1503,'text-decoration',0x01,3,207),
 (1504,'<strong>',0x01,1,207),
 (1505,'body {background-image:url(\'paper.gif\');}',0x01,10,207),
 (1506,'border',0x01,8,207),
 (1507,'-id',0x01,2,207),
 (1508,'both a and b',0x01,6,207),
 (1509,'clear',0x01,5,207),
 (1510,'p {color:red;text-align:center;}',0x01,7,207),
 (1511,'run-test',0x01,36,208),
 (1512,'A a = new B();',0x01,34,208),
 (1513,'oak',0x01,22,208),
 (1514,'7 9',0x01,37,208),
 (1515,'22',0x01,35,208),
 (1516,' Finally',0x01,30,208),
 (1517,'true',0x01,40,208),
 (1518,'java.util.ArrayList',0x01,38,208),
 (1519,'object oriented',0x01,23,208),
 (1520,'Both of the above',0x01,28,208),
 (1521,'To logically divide the document',0x01,16,208),
 (1522,'face',0x01,15,208),
 (1523,'<SUP>',0x01,12,208),
 (1524,'<line direction=\"horizontal\">',0x01,20,208),
 (1525,'Used to separate cell walls from their contents.',0x01,13,208),
 (1526,'Line break',0x01,18,208),
 (1527,'Using height and width',0x01,17,208),
 (1528,'li tag',0x01,14,208),
 (1529,'textarea tag',0x01,11,208),
 (1530,'Transfer files to and from an Internet Server',0x01,19,208),
 (1531,'-id',0x01,2,208),
 (1532,'text-decoration',0x01,3,208),
 (1533,'body {background-image:url(\'paper.gif\');}',0x01,10,208),
 (1534,'word-spacing',0x01,4,208),
 (1535,'p {color:red;text-align:center;}',0x01,7,208),
 (1536,'both a and b',0x01,6,208),
 (1537,'<strong>',0x01,1,208),
 (1538,'border',0x01,8,208),
 (1539,'background-image',0x01,9,208),
 (1540,'clear',0x01,5,208),
 (1541,'both a and b',0x01,25,209),
 (1542,'jdk',0x01,21,209),
 (1543,'0 false 0',0x01,32,209),
 (1544,'java development kit',0x01,24,209),
 (1545,'A a = new A(String s);',0x01,34,209),
 (1546,'Cat',0x01,33,209),
 (1547,'object oriented',0x01,23,209),
 (1548,'run-test run-test',0x01,36,209),
 (1549,'Runtime Exception',0x01,37,209),
 (1550,'oak',0x01,22,209),
 (1551,'textarea tag',0x01,11,209),
 (1552,'Line break',0x01,18,209),
 (1553,'face',0x01,15,209),
 (1554,'Both a and b above',0x01,13,209),
 (1555,'<SUP>',0x01,12,209),
 (1556,'To replace paragraphs. i.e. p tags',0x01,16,209),
 (1557,'Transfer files to and from an Internet Server',0x01,19,209),
 (1558,'<line direction=\"horizontal\">',0x01,20,209),
 (1559,'li tag',0x01,14,209),
 (1560,'Using height and width',0x01,17,209),
 (1561,'body {background-image:url(\'paper.gif\');}',0x01,10,209),
 (1562,'-id',0x01,2,209),
 (1563,'both a and b',0x01,6,209),
 (1564,'text-decoration',0x01,3,209),
 (1565,'border',0x01,8,209),
 (1566,'background-image',0x01,9,209),
 (1567,'float',0x01,5,209),
 (1568,'Both b and c',0x01,4,209),
 (1569,'<strong>',0x01,1,209),
 (1570,'p {color:red;text-align:center;}',0x01,7,209),
 (1571,'both a and b',0x01,25,203),
 (1572,'java.util.ArrayList',0x01,38,203),
 (1573,'Compile error',0x01,37,203),
 (1574,'oak',0x01,22,203),
 (1575,'Compilation fails with an error at line 4\r\n',0x01,40,203),
 (1576,'Value-A Name-C',0x01,39,203),
 (1577,'cloneable',0x01,29,203),
 (1578,'jdk',0x01,21,203),
 (1579,' Finally',0x01,30,203),
 (1580,'Compile error - static variable must be initialized before use. ',0x01,32,203),
 (1581,'<tr>',0x01,20,203),
 (1582,'<SUP>',0x01,12,203),
 (1583,'textarea tag',0x01,11,203),
 (1584,'To provide space between tables',0x01,16,203),
 (1585,'Using height and width',0x01,17,203),
 (1586,'Line break',0x01,18,203),
 (1587,'Both a and b above',0x01,13,203),
 (1588,NULL,0x00,14,203),
 (1589,NULL,0x00,19,203),
 (1590,NULL,0x00,15,203),
 (1591,'text-trans',0x01,3,203),
 (1592,'body {background-image:url(\'paper.gif\')};',0x01,10,203),
 (1593,'word-spacing',0x01,4,203),
 (1594,'background-img',0x01,9,203),
 (1595,'-id',0x01,2,203),
 (1596,'<strong>',0x01,1,203),
 (1597,'h2 {font-size:200px;}',0x01,6,203),
 (1598,'table-border',0x01,8,203),
 (1599,'clear',0x01,5,203),
 (1600,'p {color:red;text-align:center;}',0x01,7,203),
 (1601,'Compilation fails with an error at line 4\r\n',0x01,40,188),
 (1602,'None of the above',0x01,28,188),
 (1603,'java development kit',0x01,24,188),
 (1604,'22',0x01,35,188),
 (1605,'Sun',0x01,26,188),
 (1606,'jdk',0x01,21,188),
 (1607,'both a and b',0x01,25,188),
 (1608,'.java',0x01,27,188),
 (1609,NULL,0x00,36,188),
 (1610,NULL,0x00,39,188),
 (1611,'run-test',0x01,36,212),
 (1612,'Sun',0x01,26,212),
 (1613,'both a and b',0x01,25,212),
 (1614,'.java',0x01,27,212),
 (1615,'22',0x01,35,212),
 (1616,'oak',0x01,22,212),
 (1617,' Finally',0x01,30,212),
 (1618,'serializable',0x01,29,212),
 (1619,'Compile fail due to error on line no 9',0x01,31,212),
 (1620,NULL,0x00,37,212),
 (1621,'<hr>',0x01,20,212),
 (1622,'font',0x01,15,212),
 (1623,'Using height and width',0x01,17,212),
 (1624,'<SUB>',0x01,12,212),
 (1625,'Transfer files to and from an Internet Server',0x01,19,212),
 (1626,'To logically divide the document',0x01,16,212),
 (1627,'Line break',0x01,18,212),
 (1628,'textarea tag',0x01,11,212),
 (1629,'li tag',0x01,14,212),
 (1630,'Used to separate cell walls from their contents.',0x01,13,212),
 (1631,'-id',0x01,2,212),
 (1632,'clear',0x01,5,212),
 (1633,'border',0x01,8,212),
 (1634,'p {color:red;text-align:center;}',0x01,7,212),
 (1635,'<strong>',0x01,1,212),
 (1636,'text-decoration',0x01,3,212),
 (1637,'body {background-image:url(\'paper.gif\');}',0x01,10,212),
 (1638,'Both b and c',0x01,4,212),
 (1639,'background-image',0x01,9,212),
 (1640,'h2 {font-size:200px;}',0x01,6,212),
 (1641,'10',0x01,35,218),
 (1642,'Cat',0x01,33,218),
 (1643,'both a and b',0x01,25,218),
 (1644,'Compile error - static variable must be initialized before use. ',0x01,32,218),
 (1645,'Value-A Value-A',0x01,39,218),
 (1646,'Runtime Exception',0x01,37,218),
 (1647,' Finally',0x01,30,218),
 (1648,'serializable',0x01,29,218),
 (1649,'Java only',0x01,22,218),
 (1650,'run-test run-test',0x01,36,218),
 (1651,'Compile error',0x01,37,220),
 (1652,'0 false 0',0x01,32,220),
 (1653,'jdk',0x01,21,220),
 (1654,'50',0x01,35,220),
 (1655,'both a and b',0x01,25,220),
 (1656,'java development kit',0x01,24,220),
 (1657,'All of the above\r\n',0x01,34,220),
 (1658,'.class',0x01,27,220),
 (1659,'object oriented',0x01,23,220),
 (1660,'oak',0x01,22,220),
 (1661,'Both b and c',0x01,11,220),
 (1662,'ls tag',0x01,14,220),
 (1663,'<hr>',0x01,20,220),
 (1664,'To logically divide the document',0x01,16,220),
 (1665,'Transfer files to and from an Internet Server',0x01,19,220),
 (1666,'Using resize attribute',0x01,17,220),
 (1667,'face',0x01,15,220),
 (1668,'<SUB>',0x01,12,220),
 (1669,'Line break',0x01,18,220),
 (1670,NULL,0x00,13,220),
 (1671,'background-image',0x01,9,220),
 (1672,'word-spacing',0x01,4,220),
 (1673,'both a and b',0x01,6,220),
 (1674,'text',0x01,2,220),
 (1675,'<dar>',0x01,1,220),
 (1676,'body {background-image:url(\'paper.gif\')};',0x01,10,220),
 (1677,NULL,0x00,3,220),
 (1678,NULL,0x00,7,220),
 (1679,NULL,0x00,5,220),
 (1680,NULL,0x00,8,220),
 (1681,'Sun',0x01,26,221),
 (1682,'A a = new B();',0x01,34,221),
 (1683,'object oriented',0x01,23,221),
 (1684,'Static Binding',0x01,28,221),
 (1685,'false',0x01,40,221),
 (1686,'Name-B Name-C',0x01,39,221),
 (1687,'.java',0x01,27,221),
 (1688,'serializable',0x01,29,221),
 (1689,'oak',0x01,22,221),
 (1690,'both a and b',0x01,25,221),
 (1691,'<hr>',0x01,20,221),
 (1692,'<SUP>',0x01,12,221),
 (1693,'textarea tag',0x01,11,221),
 (1694,'Used to separate cell walls from their contents.',0x01,13,221),
 (1695,'li tag',0x01,14,221),
 (1696,'face',0x01,15,221),
 (1697,'To logically divide the document',0x01,16,221),
 (1698,'Using resize attribute',0x01,17,221),
 (1699,'Line break',0x01,18,221),
 (1700,'Transfer files to and from an Internet Server',0x01,19,221),
 (1701,'clear',0x01,5,221),
 (1702,'p {color:red;text-align:center;}',0x01,7,221),
 (1703,'both a and b',0x01,6,221),
 (1704,'background-image',0x01,9,221),
 (1705,'<black>',0x01,1,221),
 (1706,'text-decoration',0x01,3,221),
 (1707,'body {background-image:url(paper.gif);}',0x01,10,221),
 (1708,'-id',0x01,2,221),
 (1709,'border',0x01,8,221),
 (1710,'word-spacing',0x01,4,221),
 (1711,'serializable',0x01,29,224),
 (1712,'Sun',0x01,26,224),
 (1713,'15\r\n',0x01,31,224),
 (1714,'both a and b',0x01,25,224),
 (1715,'22',0x01,35,224),
 (1716,'Compilation fails due to an error on line 4',0x01,36,224),
 (1717,'7 9',0x01,37,224),
 (1718,'Static Binding',0x01,28,224),
 (1719,'true',0x01,40,224),
 (1720,'Name-B Name-C',0x01,39,224),
 (1721,NULL,0x00,14,224),
 (1722,NULL,0x00,19,224),
 (1723,NULL,0x00,12,224),
 (1724,NULL,0x00,20,224),
 (1725,NULL,0x00,13,224),
 (1726,NULL,0x00,17,224),
 (1727,NULL,0x00,16,224),
 (1728,NULL,0x00,11,224),
 (1729,NULL,0x00,15,224),
 (1730,NULL,0x00,18,224),
 (1731,'body {background-image:url(\'paper.gif\');}',0x01,10,224),
 (1732,'table-border',0x01,8,224),
 (1733,'<strong>',0x01,1,224),
 (1734,'-id',0x01,2,224),
 (1735,'word-spacing',0x01,4,224),
 (1736,'text-decoration',0x01,3,224),
 (1737,'h2 {font-size:200%;}',0x01,6,224),
 (1738,'float',0x01,5,224),
 (1739,'p {color:red;text-align:center;}',0x01,7,224),
 (1740,'background-image',0x01,9,224),
 (1741,'Cat',0x01,33,223),
 (1742,'None of the above',0x01,28,223),
 (1743,'A a = new A(String s);',0x01,34,223),
 (1744,' Finally',0x01,30,223),
 (1745,'Name-B Name-C',0x01,39,223),
 (1746,'7 9',0x01,37,223),
 (1747,'both a and b',0x01,25,223),
 (1748,'java development kit',0x01,24,223),
 (1749,'Oracle',0x01,26,223),
 (1750,'15\r\n',0x01,31,223),
 (1751,'<line>',0x01,20,223),
 (1752,'To logically divide the document',0x01,16,223),
 (1753,'Line break',0x01,18,223),
 (1754,'Used to set space between cells',0x01,13,223),
 (1755,'ls tag',0x01,14,223),
 (1756,'font',0x01,15,223),
 (1757,'Using height and width',0x01,17,223),
 (1758,'Transfer files to and from an Internet Server',0x01,19,223),
 (1759,'<B>',0x01,12,223),
 (1760,'Both b and c',0x01,11,223),
 (1761,'Compile Error',0x01,33,225),
 (1762,'Compile fail due to error on line no 9',0x01,31,225),
 (1763,'Runtime Exception',0x01,37,225),
 (1764,'run-test run-test',0x01,36,225),
 (1765,'java.util.ArrayList',0x01,38,225),
 (1766,'Sun',0x01,26,225),
 (1767,'A a = new B();',0x01,34,225),
 (1768,'oak',0x01,22,225),
 (1769,'object oriented',0x01,23,225),
 (1770,'Static Binding',0x01,28,225),
 (1771,'li tag',0x01,14,225),
 (1772,NULL,0x00,19,225),
 (1773,NULL,0x00,13,225),
 (1774,NULL,0x00,20,225),
 (1775,NULL,0x00,15,225),
 (1776,NULL,0x00,17,225),
 (1777,NULL,0x00,11,225),
 (1778,NULL,0x00,12,225),
 (1779,NULL,0x00,16,225),
 (1780,NULL,0x00,18,225),
 (1781,'border',0x01,8,223),
 (1782,'both a and b',0x01,6,223),
 (1783,'text-decoration',0x01,3,223),
 (1784,'-id',0x01,2,223),
 (1785,'<strong>',0x01,1,223),
 (1786,'body {background-image:url(paper.gif);}',0x01,10,223),
 (1787,'clear',0x01,5,223),
 (1788,'Both b and c',0x01,4,223),
 (1789,'p (color:red;text-align:center;)',0x01,7,223),
 (1790,'background-img',0x01,9,223),
 (1791,'Cat',0x01,33,219),
 (1792,'cloneable',0x01,29,219),
 (1793,'jdk',0x01,21,219),
 (1794,'Java only',0x01,22,219),
 (1795,'50',0x01,35,219),
 (1796,'0 false 0',0x01,32,219),
 (1797,'Runtime Exception',0x01,37,219),
 (1798,'object oriented',0x01,23,219),
 (1799,'both a and b',0x01,25,219),
 (1800,'A a = new B();',0x01,34,219),
 (1801,'body {background-image:url(\'paper.gif\');}',0x01,10,225),
 (1802,'text-decoration',0x01,3,225),
 (1803,'word-spacing',0x01,4,225),
 (1804,'background-image',0x01,9,225),
 (1805,'<strong>',0x01,1,225),
 (1806,'clear',0x01,5,225),
 (1807,'table-border',0x01,8,225),
 (1808,'h2 {font-size:200%;}',0x01,6,225),
 (1809,'-id',0x01,2,225),
 (1810,'p {color:red;text-align:center;}',0x01,7,225),
 (1811,'To logically divide the document',0x01,16,219),
 (1812,'<SUP>',0x01,12,219),
 (1813,'textarea tag',0x01,11,219),
 (1814,'li tag',0x01,14,219),
 (1815,'Using height and width',0x01,17,219),
 (1816,'font',0x01,15,219),
 (1817,'Used to separate cell walls from their contents.',0x01,13,219),
 (1818,'<hr>',0x01,20,219),
 (1819,'Line break',0x01,18,219),
 (1820,'Transfer files to and from an Internet Server',0x01,19,219),
 (1821,'background-image',0x01,9,219),
 (1822,'<strong>',0x01,1,219),
 (1823,'clear',0x01,5,219),
 (1824,'border',0x01,8,219),
 (1825,'body {background-image:url(\'paper.gif\');}',0x01,10,219),
 (1826,'-id',0x01,2,219),
 (1827,'text-decoration',0x01,3,219),
 (1828,'word-spacing',0x01,4,219),
 (1829,'both a and b',0x01,6,219),
 (1830,'p {color:red;text-align:center;}',0x01,7,219),
 (1831,'Compilation fails with an error at line 4',0x01,35,217),
 (1832,'Compile error - static variable must be initialized before use. ',0x01,32,217),
 (1833,'jdk',0x01,22,217),
 (1834,'interpretation',0x01,25,217),
 (1835,'serializable',0x01,29,217),
 (1836,'Compilation fails with an error at line 3',0x01,40,217),
 (1837,'Sun',0x01,26,217),
 (1838,'java development kit',0x01,24,217),
 (1839,'jdk',0x01,21,217),
 (1840,'object oriented',0x01,23,217),
 (1841,'Compilation fails with an error at line 4',0x01,35,217),
 (1842,'Compile error - static variable must be initialized before use. ',0x01,32,217),
 (1843,'jdk',0x01,22,217),
 (1844,'interpretation',0x01,25,217),
 (1845,'serializable',0x01,29,217),
 (1846,'Compilation fails with an error at line 3',0x01,40,217),
 (1847,'Sun',0x01,26,217),
 (1848,'java development kit',0x01,24,217),
 (1849,'jdk',0x01,21,217),
 (1850,'object oriented',0x01,23,217),
 (1851,'list tag',0x01,14,217),
 (1852,'Space',0x01,18,217),
 (1853,'Using resize attribute',0x01,17,217),
 (1854,'<hr>',0x01,20,217),
 (1855,'Transfer files to and from an Internet Server',0x01,19,217),
 (1856,'To logically divide the document',0x01,16,217),
 (1857,'<SUP>',0x01,12,217),
 (1858,'Used to separate cell walls from their contents.',0x01,13,217),
 (1859,'textarea tag',0x01,11,217),
 (1860,'font',0x01,15,217),
 (1861,'table-border',0x01,8,217),
 (1862,'body {background-image:url(\'paper.gif\')};',0x01,10,217),
 (1863,'h2 {font-size:200px;}',0x01,6,217),
 (1864,'<strong>',0x01,1,217),
 (1865,'p {color:red;text-align:center};',0x01,7,217),
 (1866,'text-trans',0x01,3,217),
 (1867,'clear',0x01,5,217),
 (1868,'-id',0x01,2,217),
 (1869,'space',0x01,4,217),
 (1870,'background-image',0x01,9,217),
 (1871,'jdk',0x01,21,229),
 (1872,'None of the above\r\n',0x01,37,229),
 (1873,'Cat',0x01,33,229),
 (1874,'15\r\n',0x01,31,229),
 (1875,' Finally',0x01,30,229),
 (1876,'Static Binding',0x01,28,229),
 (1877,'true',0x01,40,229),
 (1878,'Sun',0x01,26,229),
 (1879,'Value-A Value-A',0x01,39,229),
 (1880,'cloneable',0x01,29,229),
 (1881,'Transfer files to and from an Internet Server',0x01,19,229),
 (1882,'text tag',0x01,11,229),
 (1883,'To logically divide the document',0x01,16,229),
 (1884,'<SUP>',0x01,12,229),
 (1885,'Line break',0x01,18,229),
 (1886,'face',0x01,15,229),
 (1887,'li tag',0x01,14,229),
 (1888,'Using height and width',0x01,17,229),
 (1889,'<hr>',0x01,20,229),
 (1890,'Used to separate cell walls from their contents.',0x01,13,229),
 (1891,'h2 {font-size:200%;}',0x01,6,229),
 (1892,'word-spacing',0x01,4,229),
 (1893,'background-image',0x01,9,229),
 (1894,'body {background-image:url(\'paper.gif\');}',0x01,10,229),
 (1895,'border',0x01,8,229),
 (1896,'p {color:red;text-align:center;}',0x01,7,229),
 (1897,'<strong>',0x01,1,229),
 (1898,'clear',0x01,5,229),
 (1899,NULL,0x00,3,229),
 (1900,NULL,0x00,2,229),
 (1901,'Value-A Value-A',0x01,39,228),
 (1902,'run-test',0x01,36,228),
 (1903,'java.util.ArrayList',0x01,38,228),
 (1904,'Static Binding',0x01,28,228),
 (1905,'Cat',0x01,33,228),
 (1906,'7 9',0x01,37,228),
 (1907,'0 true 0',0x01,32,228),
 (1908,'.java',0x01,27,228),
 (1909,'false',0x01,40,228),
 (1910,'oak',0x01,22,228),
 (1911,'java development kit',0x01,24,231),
 (1912,'Value-A Value-A',0x01,39,231),
 (1913,'Cat',0x01,33,231),
 (1914,'Compilation',0x01,25,231),
 (1915,'cloneable',0x01,29,231),
 (1916,'oak',0x01,22,231),
 (1917,'A a = new A(String s);',0x01,34,231),
 (1918,'sdk',0x01,21,231),
 (1919,'.java',0x01,27,231),
 (1920,'java.util.HashSet',0x01,38,231),
 (1921,'text tag',0x01,11,231),
 (1922,'To provide space between tables',0x01,16,231),
 (1923,'Using resize attribute',0x01,17,231),
 (1924,'Used to provide width to a cell',0x01,13,231),
 (1925,'Line break',0x01,18,231),
 (1926,'font',0x01,15,231),
 (1927,'<SUP>',0x01,12,231),
 (1928,'<tr>',0x01,20,231),
 (1929,'Transfer files to and from an Internet Server',0x01,19,231),
 (1930,'li tag',0x01,14,231),
 (1931,'p {color:red;text-align:center};',0x01,7,231),
 (1932,'word-space',0x01,4,231),
 (1933,'cleared',0x01,5,231),
 (1934,'background-img',0x01,9,231),
 (1935,'text-transformation',0x01,3,231),
 (1936,'<strong>',0x01,1,231),
 (1937,'body {background-image:url(\'paper.gif\')}',0x01,10,231),
 (1938,'h2 {font-size:200;}',0x01,6,231),
 (1939,'-id',0x01,2,231),
 (1940,'table-border\r\ntbl-border',0x01,8,231),
 (1941,'A a = new B(5);',0x01,34,233),
 (1942,'Compilation fails with an error at line 3',0x01,40,233),
 (1943,'Java only',0x01,22,233),
 (1944,'Runtime Exception',0x01,37,233),
 (1945,'Sun',0x01,26,233),
 (1946,'Compile fail due to error on line no 9',0x01,31,233),
 (1947,'.class',0x01,27,233),
 (1948,'Compile error - static variable must be initialized before use. ',0x01,32,233),
 (1949,'java.util.HashSet',0x01,38,233),
 (1950,'Compilation',0x01,25,233),
 (1951,'Using height and width',0x01,17,233),
 (1952,'textarea tag',0x01,11,233),
 (1953,'<hr>',0x01,20,233),
 (1954,'<SUP>',0x01,12,233),
 (1955,'Transfer files to and from an Internet Server',0x01,19,233),
 (1956,'li tag',0x01,14,233),
 (1957,'Used to set space between cells',0x01,13,233),
 (1958,'fontname',0x01,15,233),
 (1959,'To logically divide the document',0x01,16,233),
 (1960,'Line break',0x01,18,233),
 (1961,'word-space',0x01,4,233),
 (1962,'clear',0x01,5,233),
 (1963,'h2 {font-size:200px;}',0x01,6,233),
 (1964,'border',0x01,8,233),
 (1965,'p {color:red;text-align:center;}',0x01,7,233),
 (1966,'-id',0x01,2,233),
 (1967,NULL,0x00,10,233),
 (1968,NULL,0x00,3,233),
 (1969,NULL,0x00,9,233),
 (1970,NULL,0x00,1,233),
 (1971,'Value-A Name-B',0x01,39,230),
 (1972,'Compile fail due to error on line no 9',0x01,31,230),
 (1973,'serializable',0x01,29,230),
 (1974,'java.util.HashSet',0x01,38,230),
 (1975,'.java',0x01,27,230),
 (1976,'All of the above\r\n',0x01,34,230),
 (1977,'jdk',0x01,21,230),
 (1978,'run-test',0x01,36,230),
 (1979,'oak',0x01,22,230),
 (1980,'22',0x01,35,230),
 (1981,'Line break',0x01,18,230),
 (1982,'textarea tag',0x01,11,230),
 (1983,'<SUP>',0x01,12,230),
 (1984,'<line direction=\"horizontal\">',0x01,20,230),
 (1985,'To logically divide the document',0x01,16,230),
 (1986,'face',0x01,15,230),
 (1987,'Using height and width',0x01,17,230),
 (1988,'Transfer files to and from an Internet Server',0x01,19,230),
 (1989,'Used to provide width to a cell',0x01,13,230),
 (1990,NULL,0x00,14,230),
 (1991,'cleared',0x01,5,230),
 (1992,'word-spacing',0x01,4,230),
 (1993,'-id',0x01,2,230),
 (1994,'border',0x01,8,230),
 (1995,'<strong>',0x01,1,230),
 (1996,'p {color:red;text-align:center}',0x01,7,230),
 (1997,'body {background-image:url(\'paper.gif\')}',0x01,10,230),
 (1998,'h2 {font-size:200px;}',0x01,6,230),
 (1999,'text-decoration',0x01,3,230),
 (2000,'background-image',0x01,9,230),
 (2001,'true',0x01,40,234),
 (2002,'Compilation fails with an error at line 4',0x01,35,234),
 (2003,'java.util.HashSet',0x01,38,234),
 (2004,'object oriented',0x01,23,234),
 (2005,'none of the above',0x01,29,234),
 (2006,'Compile Error',0x01,33,234),
 (2007,'Static Binding',0x01,28,234),
 (2008,'Compile fail due to error on line no 9',0x01,31,234),
 (2009,'java development kit',0x01,24,234),
 (2010,'Sun',0x01,26,234),
 (2011,'<line direction=\"horizontal\">',0x01,20,234),
 (2012,'Both a and b above',0x01,13,234),
 (2013,'Line break',0x01,18,234),
 (2014,'list tag',0x01,14,234),
 (2015,'textml tag',0x01,11,234),
 (2016,'To logically divide the paragraphs',0x01,16,234),
 (2017,'Using size attribute',0x01,17,234),
 (2018,'font',0x01,15,234),
 (2019,'Transfer files to and from an Internet Server',0x01,19,234),
 (2020,'<SUP>',0x01,12,234),
 (2021,'run-test run-test',0x01,36,235),
 (2022,'Compile fail due to error on line no 2',0x01,31,235),
 (2023,'java development kit',0x01,24,235),
 (2024,'object oriented',0x01,23,235),
 (2025,'0 false 0',0x01,32,235),
 (2026,NULL,0x00,37,235),
 (2027,'none of the above',0x01,29,235),
 (2028,' Finally',0x01,30,235),
 (2029,'A a = new B(5);',0x01,34,235),
 (2030,'jdk',0x01,21,235),
 (2031,'Runtime Exception',0x01,37,232),
 (2032,'jdk',0x01,21,232),
 (2033,' Finally',0x01,30,232),
 (2034,'Cat',0x01,33,232),
 (2035,'serializable',0x01,29,232),
 (2036,'50',0x01,35,232),
 (2037,'java development kit',0x01,24,232),
 (2038,'object oriented',0x01,23,232),
 (2039,'Sun',0x01,26,232),
 (2040,'.class',0x01,27,232),
 (2041,'Line break',0x01,18,232),
 (2042,'Using height and width',0x01,17,232),
 (2043,'face',0x01,15,232),
 (2044,'Used to set space between cells',0x01,13,232),
 (2045,'textarea tag',0x01,11,232),
 (2046,'To logically divide the paragraphs',0x01,16,232),
 (2047,'Transfer files to and from an Internet Server',0x01,19,232),
 (2048,'list tag',0x01,14,232),
 (2049,'<SUP>',0x01,12,232),
 (2050,'<hr>',0x01,20,232),
 (2051,NULL,0x00,10,232),
 (2052,NULL,0x00,3,232),
 (2053,NULL,0x00,2,232),
 (2054,NULL,0x00,7,232),
 (2055,NULL,0x00,4,232),
 (2056,NULL,0x00,9,232),
 (2057,NULL,0x00,6,232),
 (2058,NULL,0x00,5,232),
 (2059,NULL,0x00,8,232),
 (2060,NULL,0x00,1,232),
 (2061,'Using resize attribute',0x01,17,235),
 (2062,'To logically divide the paragraphs',0x01,16,235),
 (2063,'Used to separate cell walls from their contents.',0x01,13,235),
 (2064,'text tag',0x01,11,235),
 (2065,'<SUB>',0x01,12,235),
 (2066,'font',0x01,15,235),
 (2067,'Line break',0x01,18,235),
 (2068,'ls tag',0x01,14,235),
 (2069,'<line direction=\"horizontal\">',0x01,20,235),
 (2070,'Connecting to the internet',0x01,19,235),
 (2071,'Compile fail due to error on line no 8',0x01,31,238),
 (2072,'java.util.List',0x01,38,238),
 (2073,'procedural oriented',0x01,23,238),
 (2074,'A a = new B();',0x01,34,238),
 (2075,'Compilation fails with an error at line 4',0x01,35,238),
 (2076,' Finally',0x01,30,238),
 (2077,'java development kit',0x01,24,238),
 (2078,'Animal Cat',0x01,33,238),
 (2079,'Static Binding',0x01,28,238),
 (2080,'run-test',0x01,36,238),
 (2081,'ls tag',0x01,14,238),
 (2082,'Used to set space between cells',0x01,13,238),
 (2083,NULL,0x00,12,238),
 (2084,'<hr>',0x01,20,238),
 (2085,'textarea tag',0x01,11,238),
 (2086,'To logically divide the paragraphs',0x01,16,238),
 (2087,'Space',0x01,18,238),
 (2088,'Transfer files to and from an Internet Server',0x01,19,238),
 (2089,'font',0x01,15,238),
 (2090,'Using height and width',0x01,17,238),
 (2091,'p {color:red;text-align:center;}',0x01,7,238),
 (2092,'<strong>',0x01,1,238),
 (2093,'h2 {font-size:200px;}',0x01,6,238),
 (2094,'float',0x01,5,238),
 (2095,NULL,0x00,8,238),
 (2096,NULL,0x00,3,238),
 (2097,NULL,0x00,10,238),
 (2098,NULL,0x00,4,238),
 (2099,NULL,0x00,2,238),
 (2100,NULL,0x00,9,238),
 (2101,'7 9',0x01,37,239),
 (2102,'Sun',0x01,26,239),
 (2103,'java.util.ArrayList',0x01,38,239),
 (2104,'All of the above\r\n',0x01,34,239),
 (2105,'50',0x01,35,239),
 (2106,'.java',0x01,27,239),
 (2107,'Static Binding',0x01,28,239),
 (2108,'oak',0x01,22,239),
 (2109,'true',0x01,40,239),
 (2110,'Name-B Name-C',0x01,39,239),
 (2111,'To logically divide the document',0x01,16,239),
 (2112,'<SUP>',0x01,12,239),
 (2113,'Line break',0x01,18,239),
 (2114,'li tag',0x01,14,239),
 (2115,'Both b and c',0x01,11,239),
 (2116,'font',0x01,15,239),
 (2117,'Using height and width',0x01,17,239),
 (2118,'Connecting to the internet',0x01,19,239),
 (2119,'Used to set space between cells',0x01,13,239),
 (2120,'<hr>',0x01,20,239);
INSERT INTO `exam_mst_tbl` (`ID`,`ANSWER`,`IS_ANSWERED`,`QUESTION_ID`,`PERSIONAL_ID`) VALUES 
 (2121,'Transfer files to and from an Internet Server',0x01,19,240),
 (2122,'<hr>',0x01,20,240),
 (2123,'To logically divide the document',0x01,16,240),
 (2124,'textarea tag',0x01,11,240),
 (2125,'face',0x01,15,240),
 (2126,'Using height and width',0x01,17,240),
 (2127,'li tag',0x01,14,240),
 (2128,'Used to set space between cells',0x01,13,240),
 (2129,'Line break',0x01,18,240),
 (2130,'<SUP>',0x01,12,240),
 (2131,'background-image',0x01,9,240),
 (2132,'h2 {font-size:200px;}',0x01,6,240),
 (2133,'clear',0x01,5,240),
 (2134,'<strong>',0x01,1,240),
 (2135,'-id',0x01,2,240),
 (2136,'text-decoration',0x01,3,240),
 (2137,'p {color:red;text-align:center;}',0x01,7,240),
 (2138,'body {background-image:url(\'paper.gif\');}',0x01,10,240),
 (2139,'word-spacing',0x01,4,240),
 (2140,'border',0x01,8,240),
 (2141,'Compilation fails with an error at line 4',0x01,35,240),
 (2142,'true',0x01,40,240),
 (2143,'java.util.ArrayList',0x01,38,240),
 (2144,'jdk',0x01,21,240),
 (2145,'0 true 0',0x01,32,240),
 (2146,'Compile fail due to error on line no 9',0x01,31,240),
 (2147,'java development kit',0x01,24,240),
 (2148,'object oriented',0x01,23,240),
 (2149,NULL,0x00,37,240),
 (2150,NULL,0x00,39,240),
 (2151,'Compile fail due to error on line no 9',0x01,31,241),
 (2152,'none of the above',0x01,29,241),
 (2153,'Value-A Name-B',0x01,39,241),
 (2154,'java.util.ArrayList',0x01,38,241),
 (2155,'Compilation fails with an error at line 4',0x01,35,241),
 (2156,'true',0x01,40,241),
 (2157,'run-test',0x01,36,241),
 (2158,'object oriented',0x01,23,241),
 (2159,'Static Binding',0x01,28,241),
 (2160,' Finally',0x01,30,241),
 (2161,'java demo kit',0x01,24,20),
 (2162,'sdk',0x01,21,20),
 (2163,'run-test run-test',0x01,36,20),
 (2164,'Compilation fails',0x01,30,20),
 (2165,'.class',0x01,27,20),
 (2166,'interpretation',0x01,25,20),
 (2167,'procedural oriented',0x01,23,20),
 (2168,'Runtime Exception',0x01,37,20),
 (2169,'java.util.List',0x01,38,20),
 (2170,'Cat',0x01,33,20),
 (2171,'Compile error - static variable must be initialized before use. ',0x01,32,245),
 (2172,'object oriented',0x01,23,245),
 (2173,' Finally',0x01,30,245),
 (2174,'java.util.List',0x01,38,245),
 (2175,'jdk',0x01,21,245),
 (2176,'Sun',0x01,26,245),
 (2177,'Static Binding',0x01,28,245),
 (2178,'A a = new B();',0x01,34,245),
 (2179,'Compile fail due to error on line no 9',0x01,31,245),
 (2180,'Value-A Value-A',0x01,39,245),
 (2181,'textarea tag',0x01,11,245),
 (2182,'<SUP>',0x01,12,245),
 (2183,'Transfer files to and from an Internet Server',0x01,19,245),
 (2184,'fontname',0x01,15,245),
 (2185,'Using size attribute',0x01,17,245),
 (2186,'Paragraph break',0x01,18,245),
 (2187,'Used to separate cell walls from their contents.',0x01,13,245),
 (2188,'To logically divide the paragraphs',0x01,16,245),
 (2189,'li tag',0x01,14,245),
 (2190,'<hr>',0x01,20,245),
 (2191,'background-image',0x01,9,245),
 (2192,'<black>',0x01,1,245),
 (2193,'body {background-image:url(\'paper.gif\')}',0x01,10,245),
 (2194,'-id',0x01,2,245),
 (2195,'text-transformation',0x01,3,245),
 (2196,'Both b and c',0x01,4,245),
 (2197,'table-border',0x01,8,245),
 (2198,'clear',0x01,5,245),
 (2199,'h2 {font-size:200px;}',0x01,6,245),
 (2200,'p {color:red;text-align:center};',0x01,7,245),
 (2201,'Sun',0x01,26,246),
 (2202,'Static Binding',0x01,28,246),
 (2203,'Compilation fails with an error at line 4\r\n',0x01,40,246),
 (2204,'object oriented',0x01,23,246),
 (2205,'7 9',0x01,37,246),
 (2206,'Compile error - static variable must be initialized before use. ',0x01,32,246),
 (2207,'Compile fail due to error on line no 9',0x01,31,246),
 (2208,'none of these',0x01,25,246),
 (2209,'oak',0x01,22,246),
 (2210,'All of the above\r\n',0x01,34,246),
 (2211,'<tr>',0x01,20,246),
 (2212,'To logically divide the document',0x01,16,246),
 (2213,'<SUB>',0x01,12,246),
 (2214,'li tag',0x01,14,246),
 (2215,'Designing a website',0x01,19,246),
 (2216,'textarea tag',0x01,11,246),
 (2217,'Line break',0x01,18,246),
 (2218,'Used to separate cell walls from their contents.',0x01,13,246),
 (2219,'font',0x01,15,246),
 (2220,'Using height and width',0x01,17,246),
 (2221,'text-transformation',0x01,3,246),
 (2222,'body {background-image:url(\'paper.gif\')}',0x01,10,246),
 (2223,'border',0x01,8,246),
 (2224,'-id',0x01,2,246),
 (2225,'background-image',0x01,9,246),
 (2226,'word-spacing',0x01,4,246),
 (2227,'p {color:red;text-align:center}',0x01,7,246),
 (2228,'<strong>',0x01,1,246),
 (2229,'h2 {font-size:200px;}',0x01,6,246),
 (2230,'float',0x01,5,246),
 (2231,'Compilation',0x01,25,247),
 (2232,'Value-A Value-A',0x01,39,247),
 (2233,'22',0x01,35,247),
 (2234,'Static Binding',0x01,28,247),
 (2235,'Compilation fails',0x01,30,247),
 (2236,'Compile error - static variable must be initialized before use. ',0x01,32,247),
 (2237,'A a = new B();',0x01,34,247),
 (2238,'java development kit',0x01,24,247),
 (2239,'oak',0x01,22,247),
 (2240,'15\r\n',0x01,31,247),
 (2241,'Line break',0x01,18,247),
 (2242,'font',0x01,15,247),
 (2243,'Both a and b above',0x01,13,247),
 (2244,'textarea tag',0x01,11,247),
 (2245,'li tag',0x01,14,247),
 (2246,'<SUB>',0x01,12,247),
 (2247,'Using height and width',0x01,17,247),
 (2248,'<hr>',0x01,20,247),
 (2249,'To logically divide the paragraphs',0x01,16,247),
 (2250,'Transfer files to and from an Internet Server',0x01,19,247),
 (2251,'text-transformation',0x01,3,247),
 (2252,'-id',0x01,2,247),
 (2253,'<strong>',0x01,1,247),
 (2254,'background-image',0x01,9,247),
 (2255,'p {color:red;text-align:center};',0x01,7,247),
 (2256,'border',0x01,8,247),
 (2257,'body {background-image:url(paper.gif);}',0x01,10,247),
 (2258,'h2 {font-size:200px;}',0x01,6,247),
 (2259,'word-spacing',0x01,4,247),
 (2260,'cleared',0x01,5,247),
 (2261,'7 9',0x01,37,237),
 (2262,'Dynamic Binding',0x01,28,237),
 (2263,'Sun',0x01,26,237),
 (2264,'oak',0x01,22,237),
 (2265,'Name-B Name-C',0x01,39,237),
 (2266,'java.util.HashSet',0x01,38,237),
 (2267,'Compilation fails with an error at line 4',0x01,35,237),
 (2268,'Compile error - static variable must be initialized before use. ',0x01,32,237),
 (2269,' Finally',0x01,30,237),
 (2270,'Compilation',0x01,25,237),
 (2271,'textarea tag',0x01,11,237),
 (2272,'ol tag',0x01,14,237),
 (2273,'To logically divide the paragraphs',0x01,16,237),
 (2274,'Paragraph break',0x01,18,237),
 (2275,'Used to set space between cells',0x01,13,237),
 (2276,'Using height and width',0x01,17,237),
 (2277,'<P>',0x01,12,237),
 (2278,'font',0x01,15,237),
 (2279,'Transfer files to and from an Internet Server',0x01,19,237),
 (2280,'<line direction=\"horizontal\">',0x01,20,237),
 (2281,'background-img',0x01,9,237),
 (2282,'clear',0x01,5,237),
 (2283,'<strong>',0x01,1,237),
 (2284,'h2 {font-size:200%;}',0x01,6,237),
 (2285,'text-transformation',0x01,3,237),
 (2286,'p {color:red;text-align:center};',0x01,7,237),
 (2287,'-id',0x01,2,237),
 (2288,'body {background-image:url(\'paper.gif\')};',0x01,10,237),
 (2289,'table-border',0x01,8,237),
 (2290,'word-spacing',0x01,4,237),
 (2291,'Value-A Name-C',0x01,39,250),
 (2292,'jdk',0x01,21,250),
 (2293,'Oracle',0x01,26,250),
 (2294,'object oriented',0x01,23,250),
 (2295,'Compilation fails with an error at line 4',0x01,35,250),
 (2296,'both a and b',0x01,25,250),
 (2297,'All of the above\r\n',0x01,34,250),
 (2298,'oak',0x01,22,250),
 (2299,'serializable',0x01,29,250),
 (2300,'Compilation fails',0x01,30,250),
 (2301,'list tag',0x01,14,250),
 (2302,'Both a and b above',0x01,13,250),
 (2303,'font',0x01,15,250),
 (2304,'Transfer files to and from an Internet Server',0x01,19,250),
 (2305,NULL,0x00,11,250),
 (2306,NULL,0x00,12,250),
 (2307,NULL,0x00,16,250),
 (2308,NULL,0x00,20,250),
 (2309,NULL,0x00,17,250),
 (2310,NULL,0x00,18,250),
 (2311,'-id',0x01,2,250),
 (2312,'body {background-image:url(\'paper.gif\');}',0x01,10,250),
 (2313,'p {color:red;text-align:center};',0x01,7,250),
 (2314,'Both b and c',0x01,4,250),
 (2315,'border',0x01,8,250),
 (2316,'background-img',0x01,9,250),
 (2317,'both a and b',0x01,6,250),
 (2318,'<black>',0x01,1,250),
 (2319,'text-decoration',0x01,3,250),
 (2320,'both and b',0x01,5,250),
 (2321,'java.util.HashSet',0x01,38,211),
 (2322,'object oriented',0x01,23,211),
 (2323,'run-test',0x01,36,211),
 (2324,'Name-B Name-C',0x01,39,211),
 (2325,NULL,0x00,32,211),
 (2326,NULL,0x00,31,211),
 (2327,NULL,0x00,25,211),
 (2328,NULL,0x00,40,211),
 (2329,NULL,0x00,28,211),
 (2330,NULL,0x00,30,211),
 (2331,'Compilation fails due to an error on line 4',0x01,36,255),
 (2332,'The code runs with no output.l',0x01,30,255),
 (2333,'both a and b',0x01,25,255),
 (2334,'Value-A Value-A',0x01,39,255),
 (2335,'Compilation fails with an error at line 4',0x01,35,255),
 (2336,'Compile error - static variable must be initialized before use. ',0x01,32,255),
 (2337,'.java',0x01,27,255),
 (2338,'object oriented',0x01,23,255),
 (2339,'oak',0x01,22,255),
 (2340,'7 9',0x01,37,255),
 (2341,'Using height and width',0x01,17,255),
 (2342,NULL,0x00,19,255),
 (2343,NULL,0x00,12,255),
 (2344,NULL,0x00,13,255),
 (2345,NULL,0x00,14,255),
 (2346,NULL,0x00,15,255),
 (2347,NULL,0x00,16,255),
 (2348,NULL,0x00,20,255),
 (2349,NULL,0x00,11,255),
 (2350,NULL,0x00,18,255),
 (2351,'clear',0x01,5,255),
 (2352,'text-decoration',0x01,3,255),
 (2353,'both a and b',0x01,6,255),
 (2354,'word-spacing',0x01,4,255),
 (2355,'background-image',0x01,9,255),
 (2356,'-id',0x01,2,255),
 (2357,'<strong>',0x01,1,255),
 (2358,'p {color:red;text-align:center;}',0x01,7,255),
 (2359,'border',0x01,8,255),
 (2360,'body {background-image:url(\'paper.gif\');}',0x01,10,255),
 (2361,'clear',0x01,5,255),
 (2362,'text-decoration',0x01,3,255),
 (2363,'both a and b',0x01,6,255),
 (2364,'word-spacing',0x01,4,255),
 (2365,'background-image',0x01,9,255),
 (2366,'-id',0x01,2,255),
 (2367,'<strong>',0x01,1,255),
 (2368,'p {color:red;text-align:center;}',0x01,7,255),
 (2369,'border',0x01,8,255),
 (2370,'body {background-image:url(\'paper.gif\');}',0x01,10,255),
 (2371,'.java',0x01,27,254),
 (2372,'Sun',0x01,26,254),
 (2373,'java.util.ArrayList',0x01,38,254),
 (2374,'java development kit',0x01,24,254),
 (2375,'Compile error',0x01,37,254),
 (2376,'Value-A Value-A',0x01,39,254),
 (2377,'run-test run-test',0x01,36,254),
 (2378,'0 true 0',0x01,32,254),
 (2379,'Static Binding',0x01,28,254),
 (2380,'cloneable',0x01,29,254),
 (2381,NULL,0x00,12,254),
 (2382,'textarea tag',0x01,11,254),
 (2383,'To replace paragraphs. i.e. p tags',0x01,16,254),
 (2384,NULL,0x00,20,254),
 (2385,NULL,0x00,14,254),
 (2386,NULL,0x00,18,254),
 (2387,NULL,0x00,13,254),
 (2388,NULL,0x00,19,254),
 (2389,NULL,0x00,15,254),
 (2390,NULL,0x00,17,254),
 (2411,'table-border',0x01,8,254),
 (2412,'p {color:red;text-align:center;}',0x01,7,254),
 (2413,'background-image',0x01,9,254),
 (2414,'clear',0x01,5,254),
 (2415,'body {background-image:url(\'paper.gif\');}',0x01,10,254),
 (2416,'both a and b',0x01,6,254),
 (2417,'<strong>',0x01,1,254),
 (2418,'word-spacing',0x01,4,254),
 (2419,'text',0x01,2,254),
 (2420,'text-decoration',0x01,3,254),
 (2421,'Line break',0x01,18,211),
 (2422,'Transfer files to and from an Internet Server',0x01,19,211),
 (2423,'Both b and c',0x01,11,211),
 (2424,'<SUP>',0x01,12,211),
 (2425,'face',0x01,15,211),
 (2426,'ol tag',0x01,14,211),
 (2427,'Used to set space between cells',0x01,13,211),
 (2428,'Using height and width',0x01,17,211),
 (2429,'<hr>',0x01,20,211),
 (2430,'To logically divide the document',0x01,16,211),
 (2431,'table-border',0x01,8,211),
 (2432,'p {color:red;text-align:center}',0x01,7,211),
 (2433,'word-spacing',0x01,4,211),
 (2434,'text-deco',0x01,3,211),
 (2435,'-class',0x01,2,211),
 (2436,'h2 {font-size:200px;}',0x01,6,211),
 (2437,'<strong>',0x01,1,211),
 (2438,'cleared',0x01,5,211),
 (2439,'backg-img',0x01,9,211),
 (2440,'body {background-image:url(\'paper.gif\')};',0x01,10,211),
 (2441,'object oriented',0x01,23,258),
 (2442,'A a = new B();',0x01,34,258),
 (2443,'50',0x01,35,258),
 (2444,'serializable',0x01,29,258),
 (2445,'java.util.ArrayList',0x01,38,258),
 (2446,'Compilation fails with an error at line 4\r\n',0x01,40,258),
 (2447,'Runtime Exception',0x01,37,258),
 (2448,'Static Binding',0x01,28,258),
 (2449,'java development kit',0x01,24,258),
 (2450,'run-test',0x01,36,258),
 (2451,'li tag',0x01,14,258),
 (2452,NULL,0x00,12,258),
 (2453,NULL,0x00,18,258),
 (2454,NULL,0x00,20,258),
 (2455,NULL,0x00,11,258),
 (2456,NULL,0x00,19,258),
 (2457,NULL,0x00,16,258),
 (2458,NULL,0x00,13,258),
 (2459,NULL,0x00,15,258),
 (2460,NULL,0x00,17,258),
 (2461,'<line direction=\"horizontal\">',0x01,20,258),
 (2462,NULL,0x00,16,258),
 (2463,NULL,0x00,18,258),
 (2464,NULL,0x00,14,258),
 (2465,NULL,0x00,15,258),
 (2466,NULL,0x00,19,258),
 (2467,NULL,0x00,11,258),
 (2468,NULL,0x00,13,258),
 (2469,NULL,0x00,12,258),
 (2470,NULL,0x00,17,258),
 (2471,'Sun',0x01,26,261),
 (2472,'jdk',0x01,21,261),
 (2473,'15\r\n',0x01,31,261),
 (2474,'object oriented',0x01,23,261),
 (2475,'Compilation fails with an error at line 4\r\n',0x01,40,261),
 (2476,'java development kit',0x01,24,261),
 (2477,'Name-B Name-C',0x01,39,261),
 (2478,'Compile error',0x01,37,261),
 (2479,'.java',0x01,27,261),
 (2480,'Compilation fails due to an error on line 7\r\n',0x01,36,261),
 (2481,'Sun',0x01,26,261),
 (2482,'jdk',0x01,21,261),
 (2483,'15\r\n',0x01,31,261),
 (2484,'object oriented',0x01,23,261),
 (2485,'Compilation fails with an error at line 4\r\n',0x01,40,261),
 (2486,'java development kit',0x01,24,261),
 (2487,'Name-B Name-C',0x01,39,261),
 (2488,'Compile error',0x01,37,261),
 (2489,'.java',0x01,27,261),
 (2490,'Compilation fails due to an error on line 7\r\n',0x01,36,261),
 (2491,'Sun',0x01,26,261),
 (2492,'jdk',0x01,21,261),
 (2493,'15\r\n',0x01,31,261),
 (2494,'object oriented',0x01,23,261),
 (2495,'Compilation fails with an error at line 4\r\n',0x01,40,261),
 (2496,'java development kit',0x01,24,261),
 (2497,'Name-B Name-C',0x01,39,261),
 (2498,'Compile error',0x01,37,261),
 (2499,'.java',0x01,27,261),
 (2500,'Compilation fails due to an error on line 7\r\n',0x01,36,261),
 (2501,'Sun',0x01,26,261),
 (2502,'jdk',0x01,21,261),
 (2503,'15\r\n',0x01,31,261),
 (2504,'object oriented',0x01,23,261),
 (2505,'Compilation fails with an error at line 4\r\n',0x01,40,261),
 (2506,'java development kit',0x01,24,261),
 (2507,'Name-B Name-C',0x01,39,261),
 (2508,'Compile error',0x01,37,261),
 (2509,'.java',0x01,27,261),
 (2510,'Compilation fails due to an error on line 7\r\n',0x01,36,261),
 (2511,'To replace paragraphs. i.e. p tags',0x01,16,261),
 (2512,'<tr>',0x01,20,261),
 (2513,'<SUB>',0x01,12,261),
 (2514,'ol tag',0x01,14,261),
 (2515,'Line break',0x01,18,261),
 (2516,'Using height and width',0x01,17,261),
 (2517,'font',0x01,15,261),
 (2518,'Designing a website',0x01,19,261),
 (2519,'textarea tag',0x01,11,261),
 (2520,'Both a and b above',0x01,13,261),
 (2521,'both a and b',0x01,6,261),
 (2522,'Both b and c',0x01,4,261),
 (2523,'float',0x01,5,261),
 (2524,'csss',0x01,43,261),
 (2525,'<dar>',0x01,1,261),
 (2526,'table-border',0x01,8,261),
 (2527,'p {color:red;text-align:center;}',0x01,7,261),
 (2528,'-id',0x01,2,261),
 (2529,'background-image',0x01,9,261),
 (2530,'text-transformation',0x01,3,261),
 (2592,'A a = new A(String s);',0x01,34,253),
 (2593,'Runtime Exception',0x01,37,253),
 (2594,'Compilation fails',0x01,30,253),
 (2595,'jdk',0x01,21,253),
 (2596,'Compile fail due to error on line no 2',0x01,31,253),
 (2597,'java.util.List',0x01,38,253),
 (2598,'true',0x01,40,253),
 (2599,'0 false 0',0x01,32,253),
 (2600,'.java',0x01,27,253),
 (2601,'10',0x01,35,253),
 (2602,'<hr>',0x01,20,253),
 (2603,'Paragraph break',0x01,18,253),
 (2604,'Using resize attribute',0x01,17,253),
 (2605,'Used to set space between cells',0x01,13,253),
 (2606,'textml tag',0x01,11,253),
 (2607,'Connecting to the internet',0x01,19,253),
 (2608,'<SUB>',0x01,12,253),
 (2609,'To logically divide the document',0x01,16,253),
 (2610,'li tag',0x01,14,253),
 (2611,'fontname',0x01,15,253);
/*!40000 ALTER TABLE `exam_mst_tbl` ENABLE KEYS */;


--
-- Definition of table `exam_trn_tbl`
--

DROP TABLE IF EXISTS `exam_trn_tbl`;
CREATE TABLE `exam_trn_tbl` (
  `ID` bigint(20) NOT NULL AUTO_INCREMENT,
  `TECHNOLOGY` varchar(255) DEFAULT NULL,
  `TOTAL_MARKS` bigint(20) DEFAULT NULL,
  `PERSIONAL_ID` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`ID`),
  KEY `FKD2E7288FC4E0F66` (`PERSIONAL_ID`),
  CONSTRAINT `FKD2E7288FC4E0F66` FOREIGN KEY (`PERSIONAL_ID`) REFERENCES `user_mst_tbl` (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=333 DEFAULT CHARSET=utf8;

--
-- Dumping data for table `exam_trn_tbl`
--

/*!40000 ALTER TABLE `exam_trn_tbl` DISABLE KEYS */;
INSERT INTO `exam_trn_tbl` (`ID`,`TECHNOLOGY`,`TOTAL_MARKS`,`PERSIONAL_ID`) VALUES 
 (1,'JAVA',7,144),
 (33,'JAVA',7,145),
 (39,'HTML',3,129),
 (40,'JAVA',4,129),
 (41,'HTML',0,152),
 (42,'CSS',3,157),
 (43,'HTML',4,157),
 (44,'JAVA',8,157),
 (56,'JAVA',5,161),
 (57,'HTML',6,161),
 (58,'CSS',3,161),
 (60,'JAVA',5,164),
 (61,'HTML',0,164),
 (62,'JAVA',4,163),
 (63,'HTML',3,163),
 (64,'CSS',7,164),
 (66,'CSS',5,163),
 (67,'CSS',0,163),
 (68,'JAVA',7,165),
 (69,'HTML',0,165),
 (70,'CSS',6,165),
 (72,'JAVA',6,168),
 (73,'HTML',1,168),
 (74,'CSS',5,168),
 (77,'JAVA',3,169),
 (78,'HTML',4,169),
 (79,'CSS',1,169),
 (81,'JAVA',5,170),
 (84,'JAVA',8,167),
 (85,'HTML',9,170),
 (86,'HTML',9,167),
 (87,'CSS',9,170),
 (88,'CSS',7,167),
 (89,'JAVA',8,171),
 (90,'HTML',10,171),
 (91,'CSS',8,171),
 (93,'JAVA',7,172),
 (94,'HTML',0,172),
 (95,'CSS',2,172),
 (98,'JAVA',7,176),
 (102,'HTML',10,176),
 (103,'CSS',9,176),
 (104,'JAVA',3,179),
 (105,'JAVA',6,177),
 (106,'HTML',8,179),
 (107,'HTML',7,177),
 (108,'CSS',0,177),
 (110,'CSS',8,179),
 (111,'CSS',0,179),
 (112,'JAVA',5,182),
 (113,'HTML',3,182),
 (114,'CSS',3,182),
 (116,'JAVA',4,185),
 (117,'JAVA',0,185),
 (118,'JAVA',8,187),
 (119,'HTML',5,187),
 (120,'JAVA',5,181),
 (121,'CSS',7,187),
 (123,'HTML',5,181),
 (132,'CSS',2,181),
 (133,'CSS',0,187),
 (134,'JAVA',6,189),
 (135,'HTML',9,189),
 (136,'CSS',7,189),
 (138,'JAVA',2,191),
 (139,'JAVA',5,192),
 (140,'JAVA',7,193),
 (141,'JAVA',0,192),
 (142,'HTML',9,193),
 (143,'CSS',3,193),
 (144,'JAVA',10,195),
 (145,'JAVA',0,195),
 (146,'JAVA',6,194),
 (147,'JAVA',0,194),
 (148,'HTML',8,194),
 (149,'CSS',6,194),
 (150,'JAVA',0,194),
 (151,'JAVA',6,198),
 (152,'HTML',5,198),
 (153,'CSS',6,198),
 (154,'JAVA',4,199),
 (155,'JAVA',5,196),
 (156,'HTML',4,196),
 (157,'CSS',1,196),
 (158,'CSS',0,196),
 (159,'HTML',5,191),
 (160,'HTML',0,191),
 (161,'JAVA',6,200),
 (162,'CSS',7,191),
 (163,'HTML',5,200),
 (164,'HTML',0,200),
 (165,'CSS',2,200),
 (166,'JAVA',4,201),
 (167,'HTML',4,201),
 (168,'CSS',7,201),
 (169,'HTML',1,202),
 (170,'HTML',9,202),
 (171,'CSS',6,202),
 (172,'CSS',0,202),
 (173,'JAVA',5,190),
 (174,'JAVA',5,202),
 (175,'HTML',9,190),
 (176,'CSS',1,190),
 (177,'JAVA',6,205),
 (178,'CSS',0,190),
 (179,'HTML',9,205),
 (181,'CSS',0,190),
 (182,'CSS',8,205),
 (185,'JAVA',7,206),
 (186,'HTML',9,206),
 (187,'CSS',9,206),
 (189,'JAVA',7,207),
 (190,'CSS',0,206),
 (191,'HTML',9,207),
 (192,'CSS',9,207),
 (193,'CSS',0,206),
 (194,'JAVA',5,208),
 (195,'HTML',9,208),
 (196,'CSS',9,208),
 (197,'JAVA',8,209),
 (198,'HTML',7,209),
 (199,'CSS',7,209),
 (200,'JAVA',4,203),
 (201,'HTML',4,203),
 (202,'CSS',4,203),
 (203,'JAVA',5,188),
 (204,'JAVA',6,212),
 (205,'HTML',8,212),
 (206,'CSS',7,212),
 (207,'JAVA',4,218),
 (208,'JAVA',6,220),
 (209,'HTML',5,220),
 (210,'CSS',3,220),
 (211,'JAVA',8,221),
 (212,'JAVA',0,221),
 (213,'HTML',9,221),
 (214,'CSS',7,221),
 (215,'CSS',0,221),
 (216,'JAVA',5,224),
 (217,'HTML',0,224),
 (218,'CSS',6,224),
 (219,'JAVA',2,223),
 (220,'HTML',4,223),
 (221,'JAVA',10,225),
 (222,'HTML',1,225),
 (223,'CSS',5,223),
 (224,'CSS',0,223),
 (225,'CSS',0,223),
 (226,'JAVA',6,219),
 (227,'CSS',7,225),
 (228,'CSS',0,223),
 (229,'JAVA',0,225),
 (230,'HTML',9,219),
 (231,'JAVA',0,219),
 (232,'JAVA',0,225),
 (233,'CSS',9,219),
 (234,'JAVA',6,217),
 (235,'JAVA',6,217),
 (236,'HTML',6,217),
 (237,'CSS',3,217),
 (238,'JAVA',4,229),
 (239,'HTML',9,229),
 (240,'CSS',7,229),
 (241,'JAVA',4,228),
 (242,'CSS',0,229),
 (243,'JAVA',3,231),
 (244,'HTML',4,231),
 (245,'CSS',1,231),
 (246,'CSS',0,231),
 (247,'JAVA',3,233),
 (248,'HTML',8,233),
 (249,'CSS',3,233),
 (250,'CSS',0,233),
 (251,'JAVA',5,230),
 (252,'HTML',7,230),
 (253,'CSS',5,230),
 (254,'CSS',0,230),
 (255,'CSS',0,230),
 (256,'JAVA',8,234),
 (260,'JAVA',5,235),
 (261,'JAVA',6,232),
 (262,'JAVA',0,235),
 (263,'HTML',7,232),
 (264,'CSS',0,232),
 (265,'CSS',0,232),
 (266,'CSS',0,232),
 (267,'HTML',2,235),
 (268,'JAVA',4,238),
 (269,'HTML',4,238),
 (270,'CSS',2,238),
 (271,'CSS',0,238),
 (272,'JAVA',6,239),
 (273,'CSS',0,238),
 (274,'HTML',6,239),
 (275,'CSS',0,239),
 (276,'CSS',0,239),
 (277,'HTML',9,240),
 (278,'CSS',8,240),
 (279,'JAVA',7,240),
 (280,'JAVA',6,241),
 (281,'JAVA',0,241),
 (282,'JAVA',2,20),
 (283,'JAVA',6,245),
 (284,'HTML',6,245),
 (285,'CSS',2,245),
 (286,'JAVA',5,246),
 (287,'HTML',6,246),
 (288,'CSS',4,246),
 (289,'CSS',0,246),
 (290,'CSS',0,246),
 (291,'CSS',0,246),
 (292,'JAVA',4,247),
 (293,'HTML',6,247),
 (294,'CSS',4,247),
 (295,'JAVA',3,237),
 (296,'HTML',3,237),
 (297,'CSS',3,237),
 (298,'CSS',0,237),
 (299,'CSS',0,237),
 (300,'CSS',0,237),
 (301,'JAVA',6,250),
 (302,'HTML',1,250),
 (303,'CSS',4,250),
 (304,'JAVA',1,211),
 (305,'JAVA',5,255),
 (306,'HTML',1,255),
 (307,'CSS',9,255),
 (308,'CSS',9,255),
 (309,'JAVA',0,255),
 (310,'JAVA',6,254),
 (311,'JAVA',0,255),
 (312,'HTML',1,254),
 (315,'CSS',8,254),
 (316,'HTML',7,211),
 (317,'CSS',2,211),
 (318,'CSS',0,211),
 (319,'CSS',0,211),
 (320,'JAVA',7,258),
 (321,'HTML',1,258),
 (322,'HTML',0,258),
 (323,'JAVA',5,261),
 (324,'JAVA',5,261),
 (325,'JAVA',5,261),
 (326,'JAVA',5,261),
 (327,'HTML',3,261),
 (328,'CSS',4,261),
 (329,'JAVA',5,253),
 (330,'HTML',3,253),
 (331,'HTML',0,253),
 (332,'CSS',0,253);
/*!40000 ALTER TABLE `exam_trn_tbl` ENABLE KEYS */;


--
-- Definition of table `expendature_mst_tbl`
--

DROP TABLE IF EXISTS `expendature_mst_tbl`;
CREATE TABLE `expendature_mst_tbl` (
  `ID` bigint(20) NOT NULL AUTO_INCREMENT,
  `BILL_PATH` varchar(255) DEFAULT NULL,
  `DESCRIPTION` varchar(255) DEFAULT NULL,
  `PRICE` bigint(20) DEFAULT NULL,
  `PRODUCT_NAME` varchar(255) DEFAULT NULL,
  `PURCHASED_ON` datetime DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

--
-- Dumping data for table `expendature_mst_tbl`
--

/*!40000 ALTER TABLE `expendature_mst_tbl` DISABLE KEYS */;
INSERT INTO `expendature_mst_tbl` (`ID`,`BILL_PATH`,`DESCRIPTION`,`PRICE`,`PRODUCT_NAME`,`PURCHASED_ON`) VALUES 
 (1,'New Project 20170622 1026.sql','For Server Desktop',70,'Battory cells','2017-07-01 18:42:46'),
 (2,'111.jpg','water',80,'water','2017-07-27 17:12:33'),
 (3,NULL,'water',80,'water','2017-08-07 15:31:39'),
 (4,NULL,'water',80,'water','2017-08-07 15:34:12'),
 (5,NULL,'water',100,'water','2017-08-07 15:34:29'),
 (6,NULL,'water',200,'water','2017-08-07 15:34:42');
/*!40000 ALTER TABLE `expendature_mst_tbl` ENABLE KEYS */;


--
-- Definition of table `fileupload_mst_tbl`
--

DROP TABLE IF EXISTS `fileupload_mst_tbl`;
CREATE TABLE `fileupload_mst_tbl` (
  `ID` bigint(20) NOT NULL AUTO_INCREMENT,
  `IMAGE_URL` varchar(255) DEFAULT NULL,
  `RESUME_URL` varchar(255) DEFAULT NULL,
  `USER_ID` bigint(20) DEFAULT NULL,
  `VEDIO_URL` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `fileupload_mst_tbl`
--

/*!40000 ALTER TABLE `fileupload_mst_tbl` DISABLE KEYS */;
/*!40000 ALTER TABLE `fileupload_mst_tbl` ENABLE KEYS */;


--
-- Definition of table `institute_mst_tbl`
--

DROP TABLE IF EXISTS `institute_mst_tbl`;
CREATE TABLE `institute_mst_tbl` (
  `ID` bigint(20) NOT NULL AUTO_INCREMENT,
  `INSTITUTE_NAME` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=157 DEFAULT CHARSET=utf8;

--
-- Dumping data for table `institute_mst_tbl`
--

/*!40000 ALTER TABLE `institute_mst_tbl` DISABLE KEYS */;
INSERT INTO `institute_mst_tbl` (`ID`,`INSTITUTE_NAME`) VALUES 
 (1,'Priyadarshini College Of Engineering '),
 (2,'Audisankara College Of Engineering And Technology'),
 (3,'Sri Venkateswara University'),
 (5,'St.Joseph Public School'),
 (6,'Bapatla Polytechnic College'),
 (7,'Swarnandra College Of Engineering And Technology'),
 (8,'ADHIYAMAAN COLLEGE OF ENGINEERING'),
 (9,'VIVEKANANDA HIGH SCHOOL,  MALUR'),
 (10,'JSS COMPOSITE PU COLLEGE,  MALUR'),
 (11,'MVJ COLLEGE OF ENGINEERING, BANGALORE'),
 (12,'ZP High School,Marupur,podalakur.'),
 (13,'Vignan Juniour College,Podalakur.'),
 (14,'Sri Krishna Chaitanya Degree College, Nellore'),
 (19,'Shoolini university Himachal Pradesh'),
 (20,'School of Engineering and Technology (Jain University)'),
 (21,'Damodara Public school'),
 (22,'Sri chaitanya junior college'),
 (23,'KKR&KSR institute of technologies and sciences'),
 (24,'RGPV'),
 (25,'BVDUCOEPUNE'),
 (26,'BIET'),
 (27,'narasaraopet engineering college'),
 (28,'vasavi degree college'),
 (29,'srikrishna chaithanya jr college'),
 (30,'govt.high school'),
 (32,'VTU'),
 (33,'PES engineering College'),
 (34,'sarada high school'),
 (35,'sri chaitanya jr college'),
 (36,'AITS'),
 (38,'Vigna Bharathi Institue Of Technology,JNTUA'),
 (39,'Pune University'),
 (40,'Savitribai Phule Pune University'),
 (42,'Cambridge Institute of Technology'),
 (43,'master of computer applications'),
 (44,'z.p.h.school'),
 (46,'BENGAL INSTITUTE OF TECHNOLOGY'),
 (47,'GYAN BHARATI SCHOOL RANIGUNJ'),
 (48,'GYAN BHARATI SCHOOL'),
 (49,'Visvesvaraya Technological University'),
 (50,'Guru Nanak Dev University'),
 (51,'Sri Sharada Jyoti Public School'),
 (52,'Rao\'s Junior College'),
 (53,'AVR & SVR College of Engineering'),
 (54,'jawaharlalnehru technical university'),
 (55,'MSRIT'),
 (56,'PDA college of engineering'),
 (57,'Madanapalle institute of technology and science'),
 (59,'Assam University'),
 (60,'CBIT,Proddatur'),
 (61,'Hindu school'),
 (64,'V.B.U'),
 (66,'Technocrats  Institute of Technology & Science'),
 (67,'Ankorha College Daudnagar, Aurangabad, Bihar'),
 (68,'Srikalahasthiswara institute of technnology'),
 (69,'Gates Institution of technology/JNTUA'),
 (70,'A.P.R.School,Kodigenahalli'),
 (71,'GEC HAVERI'),
 (72,'Babu Banarasidas National Institute of technology and management'),
 (73,'Balwadi Samiti Burhar, Madhya Pradesh'),
 (74,'Balwadi Samiti Burhar, Madhya Pradesh'),
 (75,'Er.perumal Manimekalai college of Engineering'),
 (76,'Institute Of Technology & Management'),
 (77,'j.s.s madhepur'),
 (78,'j.s.s madhepur'),
 (80,'Swami Matric Higher Secondary School'),
 (81,'Swami Matric Higher Secondary School'),
 (84,'calicut university'),
 (85,'AP Bord'),
 (86,'LRG Naidu Junior College, Hindupur'),
 (87,'JNTUA'),
 (88,'LITTLE ANGELS EM SCHOOL'),
 (89,'KRISHNA CHAITANYA JUNIOR COLLEGE'),
 (90,'Gujarat Technological University'),
 (91,'Rajasthan Technical University'),
 (92,'Indiana University Bloomington'),
 (93,'HBSE'),
 (94,'HBSE'),
 (95,'KUK'),
 (96,'SKMV Collage,GNIIT'),
 (97,'RTU'),
 (98,'Lovely Professional University'),
 (99,'RGTU'),
 (100,'O.P Jindal School'),
 (101,'Chhattisgarh Swami Vivekanand Technical University'),
 (103,'Kingston Engineering college(Anna University)'),
 (104,'Ramaiah University of Applied Sciences'),
 (106,'Dr.Ait'),
 (108,'BASAVESHWAR ENGINEERING COLLEGE'),
 (109,'GOVT HIGH SCHOOL HULIKALLU'),
 (110,'SRI VENKATESWARA COLLEGE OF ENGINEERING AND TECHNOLOGY'),
 (111,'Priyadarsini vidya mandir'),
 (112,'Narayana junior college'),
 (113,'JNTU ANANTAPUR'),
 (114,'Sri Sai High School'),
 (115,'Gowthami junior College'),
 (116,'Prakasam Engineering College'),
 (117,'National Engineering college'),
 (118,'corbett english medium school'),
 (119,'smt.b.seetha polytechnic'),
 (120,'Swarnandhra Institute Of Engineering and Technology'),
 (121,'Mohan Secondary School'),
 (122,'NRI Acedamy'),
 (123,'Jawaharlal Nehru Technological University, Kakinada'),
 (124,'SRI INDU COLLEGE OF ENGINEERING AND TECHNOLOGY'),
 (125,'BuchepallyVenkayammaSubbaReddy Engineering College'),
 (126,'jawaharlal nehru technology university'),
 (127,'Annamacharya Institute of technology and Sciences'),
 (128,'Vishnu Institute Of Technology'),
 (129,'Aditya Junior College'),
 (130,'SBP SS High School'),
 (131,'Sabha junior college'),
 (132,'Vaishnavi Degree college'),
 (133,'AITS'),
 (134,'RCM(s.s.s) High School'),
 (135,'Bapatla Polytechnic College'),
 (136,'JNTUK'),
 (137,'Loyola Institute Of Technology and Management'),
 (138,'Narayana Junior College'),
 (139,'Sri Vidya High School'),
 (140,'Central Public School'),
 (141,'P.B.N College'),
 (142,'Narasaraopeta Engineering College'),
 (143,'Visvesvaraya Technological University Belagavi'),
 (144,'Visvesvaraya Technological University Belagavi'),
 (145,'GOVT SCHOOL'),
 (146,'ANNA UNIVERSITY'),
 (148,'aditya college of engineering & technology'),
 (150,''),
 (151,'JNTUK'),
 (152,'Sri chaitanya junior college'),
 (153,'Minerva E.M High School'),
 (154,'ZPHSchool'),
 (155,'Sri venkateswara jr.college'),
 (156,'Vikas college of engg&technology');
/*!40000 ALTER TABLE `institute_mst_tbl` ENABLE KEYS */;


--
-- Definition of table `instructor_mst_tbl`
--

DROP TABLE IF EXISTS `instructor_mst_tbl`;
CREATE TABLE `instructor_mst_tbl` (
  `ID` bigint(20) NOT NULL AUTO_INCREMENT,
  `COMMENTS` longtext,
  `CREATED_ON` datetime DEFAULT NULL,
  `EMAIL_ID` varchar(255) DEFAULT NULL,
  `MOBILE_NO` varchar(255) DEFAULT NULL,
  `NAME` varchar(255) DEFAULT NULL,
  `STATUS` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8;

--
-- Dumping data for table `instructor_mst_tbl`
--

/*!40000 ALTER TABLE `instructor_mst_tbl` DISABLE KEYS */;
INSERT INTO `instructor_mst_tbl` (`ID`,`COMMENTS`,`CREATED_ON`,`EMAIL_ID`,`MOBILE_NO`,`NAME`,`STATUS`) VALUES 
 (8,'Online test','2017-06-22 00:00:00','Surya4454@gmail.com','9676087686','Surya','ACTIVE'),
 (9,'Online test','2017-06-22 00:00:00','Annabathulasai@gmail.com','9397932999','Sainadh','ACTIVE'),
 (11,'Am looking for a job','2017-06-22 00:00:00','sindhu4sep94@gmail.com','9108702524','Sindhu Kumari','ACTIVE'),
 (12,'testing pc','2017-07-27 00:00:00','raja@gmail.com','9900990099','raja','ACTIVE');
/*!40000 ALTER TABLE `instructor_mst_tbl` ENABLE KEYS */;


--
-- Definition of table `interview_feedback_mst_tbl`
--

DROP TABLE IF EXISTS `interview_feedback_mst_tbl`;
CREATE TABLE `interview_feedback_mst_tbl` (
  `ID` bigint(20) NOT NULL AUTO_INCREMENT,
  `FEEDBACK_DESC` varchar(255) DEFAULT NULL,
  `TYPE` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8;

--
-- Dumping data for table `interview_feedback_mst_tbl`
--

/*!40000 ALTER TABLE `interview_feedback_mst_tbl` DISABLE KEYS */;
INSERT INTO `interview_feedback_mst_tbl` (`ID`,`FEEDBACK_DESC`,`TYPE`) VALUES 
 (1,'Good in communication','Communication'),
 (2,'Average in communication','Communication'),
 (3,'Excellent in communication','Communication'),
 (4,'Need improvement in communication','Communication'),
 (5,'Good in attitude','Attitude'),
 (6,'Average in attitude','Attitude'),
 (7,'Excellent in attitude','Attitude'),
 (8,'Need improvement in attitude','Attitude'),
 (9,'Good in logical','Logical'),
 (10,'Average in logical','Logical'),
 (11,'Excellent in logical','Logical'),
 (12,'Need improvement in logical','Logical'),
 (13,'Excellent in programming','Programming'),
 (14,'Good in programming','Programming'),
 (15,'Average in programming','Programming'),
 (16,'Need improvement in programming','Programming');
/*!40000 ALTER TABLE `interview_feedback_mst_tbl` ENABLE KEYS */;


--
-- Definition of table `interview_groups_candidates_tbl`
--

DROP TABLE IF EXISTS `interview_groups_candidates_tbl`;
CREATE TABLE `interview_groups_candidates_tbl` (
  `ID` bigint(20) NOT NULL AUTO_INCREMENT,
  `CANDIDATE_EMAIL_ID` varchar(255) DEFAULT NULL,
  `CANDIDATE_NAME` varchar(255) DEFAULT NULL,
  `CANDIDATE_PHONE_NUMBER` varchar(255) DEFAULT NULL,
  `INTERVIEW_GROUPS_ID` bigint(20) DEFAULT NULL,
  `USER_ID` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

--
-- Dumping data for table `interview_groups_candidates_tbl`
--

/*!40000 ALTER TABLE `interview_groups_candidates_tbl` DISABLE KEYS */;
INSERT INTO `interview_groups_candidates_tbl` (`ID`,`CANDIDATE_EMAIL_ID`,`CANDIDATE_NAME`,`CANDIDATE_PHONE_NUMBER`,`INTERVIEW_GROUPS_ID`,`USER_ID`) VALUES 
 (1,'vamsi3369@gmail.com','vamsi','9880577218',1,34),
 (2,'ram@gmail.com','ram','9074987283',1,NULL),
 (3,'vamsi3369@gmail.com','vamsi','9880577218',2,34),
 (4,'ram@gmail.com','ram','9074987283',2,NULL);
/*!40000 ALTER TABLE `interview_groups_candidates_tbl` ENABLE KEYS */;


--
-- Definition of table `interview_groups_mst_tbl`
--

DROP TABLE IF EXISTS `interview_groups_mst_tbl`;
CREATE TABLE `interview_groups_mst_tbl` (
  `ID` bigint(20) NOT NULL AUTO_INCREMENT,
  `GROUP_DESC` varchar(255) DEFAULT NULL,
  `GROUP_NAME` varchar(255) DEFAULT NULL,
  `HR_ID` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

--
-- Dumping data for table `interview_groups_mst_tbl`
--

/*!40000 ALTER TABLE `interview_groups_mst_tbl` DISABLE KEYS */;
INSERT INTO `interview_groups_mst_tbl` (`ID`,`GROUP_DESC`,`GROUP_NAME`,`HR_ID`) VALUES 
 (1,'groupdesc','Group1',273),
 (2,'desc','group1',274);
/*!40000 ALTER TABLE `interview_groups_mst_tbl` ENABLE KEYS */;


--
-- Definition of table `interview_results_tbl`
--

DROP TABLE IF EXISTS `interview_results_tbl`;
CREATE TABLE `interview_results_tbl` (
  `ID` bigint(20) NOT NULL AUTO_INCREMENT,
  `POINTS` int(11) DEFAULT NULL,
  `TOTAL_MARKS` bigint(20) DEFAULT NULL,
  `TOTAL_QUESTIONS` bigint(20) DEFAULT NULL,
  `CODING_TEST_ID` bigint(20) DEFAULT NULL,
  `ROUND_ID` bigint(20) DEFAULT NULL,
  `INTERVIEWS_ID` bigint(20) DEFAULT NULL,
  `USER_ID` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`ID`),
  KEY `FK_jwvwy6p6xusjtryhihl256e89` (`CODING_TEST_ID`),
  KEY `FK_dyetjjoxy60u56uuc1j6lkr26` (`ROUND_ID`),
  KEY `FK_h2kg94kin8swewrhh9jjt9y6q` (`INTERVIEWS_ID`),
  KEY `FK_3fla0swke0qgmifb4jwpflwjy` (`USER_ID`),
  CONSTRAINT `FK_3fla0swke0qgmifb4jwpflwjy` FOREIGN KEY (`USER_ID`) REFERENCES `user_mst_tbl` (`ID`),
  CONSTRAINT `FK_dyetjjoxy60u56uuc1j6lkr26` FOREIGN KEY (`ROUND_ID`) REFERENCES `rounds_mst_tbl` (`ID`),
  CONSTRAINT `FK_h2kg94kin8swewrhh9jjt9y6q` FOREIGN KEY (`INTERVIEWS_ID`) REFERENCES `interviews_mst_tbl` (`ID`),
  CONSTRAINT `FK_jwvwy6p6xusjtryhihl256e89` FOREIGN KEY (`CODING_TEST_ID`) REFERENCES `coding_test_qtn_tbl` (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;

--
-- Dumping data for table `interview_results_tbl`
--

/*!40000 ALTER TABLE `interview_results_tbl` DISABLE KEYS */;
/*!40000 ALTER TABLE `interview_results_tbl` ENABLE KEYS */;


--
-- Definition of table `interview_rounds_tbl`
--

DROP TABLE IF EXISTS `interview_rounds_tbl`;
CREATE TABLE `interview_rounds_tbl` (
  `ID` bigint(20) NOT NULL AUTO_INCREMENT,
  `INTERVIEWS_ID` bigint(20) DEFAULT NULL,
  `ROUNDS_ID` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`ID`),
  KEY `FK_sf3j6ijyvj3ei6p261j9u8xbg` (`INTERVIEWS_ID`),
  KEY `FK_ow6hraitb3mallanm7pnkrh92` (`ROUNDS_ID`),
  CONSTRAINT `FK_ow6hraitb3mallanm7pnkrh92` FOREIGN KEY (`ROUNDS_ID`) REFERENCES `rounds_mst_tbl` (`ID`),
  CONSTRAINT `FK_sf3j6ijyvj3ei6p261j9u8xbg` FOREIGN KEY (`INTERVIEWS_ID`) REFERENCES `interviews_mst_tbl` (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8;

--
-- Dumping data for table `interview_rounds_tbl`
--

/*!40000 ALTER TABLE `interview_rounds_tbl` DISABLE KEYS */;
/*!40000 ALTER TABLE `interview_rounds_tbl` ENABLE KEYS */;


--
-- Definition of table `interview_shortlisted_candidates_tbl`
--

DROP TABLE IF EXISTS `interview_shortlisted_candidates_tbl`;
CREATE TABLE `interview_shortlisted_candidates_tbl` (
  `ID` bigint(20) NOT NULL AUTO_INCREMENT,
  `JOB_INTERVIEW_ID` bigint(20) DEFAULT NULL,
  `USER_ID` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`ID`),
  KEY `FK_bhpnqsao5pc3qkara9cs66e3x` (`JOB_INTERVIEW_ID`),
  KEY `FK_wm5vmuledd9aobsstb4svlip` (`USER_ID`),
  CONSTRAINT `FK_wm5vmuledd9aobsstb4svlip` FOREIGN KEY (`USER_ID`) REFERENCES `user_mst_tbl` (`ID`),
  CONSTRAINT `FK_bhpnqsao5pc3qkara9cs66e3x` FOREIGN KEY (`JOB_INTERVIEW_ID`) REFERENCES `job_interview_mst_tbl` (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `interview_shortlisted_candidates_tbl`
--

/*!40000 ALTER TABLE `interview_shortlisted_candidates_tbl` DISABLE KEYS */;
/*!40000 ALTER TABLE `interview_shortlisted_candidates_tbl` ENABLE KEYS */;


--
-- Definition of table `interview_technology_tbl`
--

DROP TABLE IF EXISTS `interview_technology_tbl`;
CREATE TABLE `interview_technology_tbl` (
  `ID` bigint(20) NOT NULL AUTO_INCREMENT,
  `TECHNOLOGIES_ID` bigint(20) DEFAULT NULL,
  `INTERVIEWS_ID` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`ID`),
  KEY `FK_3q8v6sm6uwdakm18tc2fatp7h` (`TECHNOLOGIES_ID`),
  KEY `FK_il3p5vtp05yjcix4cjj4bclsi` (`INTERVIEWS_ID`),
  CONSTRAINT `FK_il3p5vtp05yjcix4cjj4bclsi` FOREIGN KEY (`INTERVIEWS_ID`) REFERENCES `interviews_mst_tbl` (`ID`),
  CONSTRAINT `FK_3q8v6sm6uwdakm18tc2fatp7h` FOREIGN KEY (`TECHNOLOGIES_ID`) REFERENCES `technologies_mst_tbl` (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8;

--
-- Dumping data for table `interview_technology_tbl`
--

/*!40000 ALTER TABLE `interview_technology_tbl` DISABLE KEYS */;
/*!40000 ALTER TABLE `interview_technology_tbl` ENABLE KEYS */;


--
-- Definition of table `interview_types_mst_tbl`
--

DROP TABLE IF EXISTS `interview_types_mst_tbl`;
CREATE TABLE `interview_types_mst_tbl` (
  `ID` bigint(20) NOT NULL AUTO_INCREMENT,
  `INTERVIEW_TYPE` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

--
-- Dumping data for table `interview_types_mst_tbl`
--

/*!40000 ALTER TABLE `interview_types_mst_tbl` DISABLE KEYS */;
INSERT INTO `interview_types_mst_tbl` (`ID`,`INTERVIEW_TYPE`) VALUES 
 (1,'PUBLIC INTERVIEW'),
 (2,'PRIVATE INTERVIEW'),
 (3,'MOCK INTERVIEW');
/*!40000 ALTER TABLE `interview_types_mst_tbl` ENABLE KEYS */;


--
-- Definition of table `interviews_assign_to_user_tbl`
--

DROP TABLE IF EXISTS `interviews_assign_to_user_tbl`;
CREATE TABLE `interviews_assign_to_user_tbl` (
  `ID` bigint(20) NOT NULL AUTO_INCREMENT,
  `INTERVIEWS_ID` bigint(20) DEFAULT NULL,
  `USER_ID` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`ID`),
  KEY `FK_gk7o2toksp3evcetyf4tmebb5` (`INTERVIEWS_ID`),
  KEY `FK_k29rs1g9f79fdq2jqjvrebtpk` (`USER_ID`),
  CONSTRAINT `FK_k29rs1g9f79fdq2jqjvrebtpk` FOREIGN KEY (`USER_ID`) REFERENCES `user_mst_tbl` (`ID`),
  CONSTRAINT `FK_gk7o2toksp3evcetyf4tmebb5` FOREIGN KEY (`INTERVIEWS_ID`) REFERENCES `interviews_mst_tbl` (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

--
-- Dumping data for table `interviews_assign_to_user_tbl`
--

/*!40000 ALTER TABLE `interviews_assign_to_user_tbl` DISABLE KEYS */;
/*!40000 ALTER TABLE `interviews_assign_to_user_tbl` ENABLE KEYS */;


--
-- Definition of table `interviews_assign_to_users_tbl`
--

DROP TABLE IF EXISTS `interviews_assign_to_users_tbl`;
CREATE TABLE `interviews_assign_to_users_tbl` (
  `ID` bigint(20) NOT NULL AUTO_INCREMENT,
  `INTERVIEWS_ID` bigint(20) DEFAULT NULL,
  `USER_ID` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`ID`),
  KEY `FK_83d5se65rm6ksxtppf9wuik7b` (`INTERVIEWS_ID`),
  KEY `FK_gio1w0foa4gh12ci9omq7ayv9` (`USER_ID`),
  CONSTRAINT `FK_gio1w0foa4gh12ci9omq7ayv9` FOREIGN KEY (`USER_ID`) REFERENCES `user_mst_tbl` (`ID`),
  CONSTRAINT `FK_83d5se65rm6ksxtppf9wuik7b` FOREIGN KEY (`INTERVIEWS_ID`) REFERENCES `interviews_mst_tbl` (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `interviews_assign_to_users_tbl`
--

/*!40000 ALTER TABLE `interviews_assign_to_users_tbl` DISABLE KEYS */;
/*!40000 ALTER TABLE `interviews_assign_to_users_tbl` ENABLE KEYS */;


--
-- Definition of table `interviews_mst_tbl`
--

DROP TABLE IF EXISTS `interviews_mst_tbl`;
CREATE TABLE `interviews_mst_tbl` (
  `ID` bigint(20) NOT NULL AUTO_INCREMENT,
  `DESCRIPTION` varchar(255) DEFAULT NULL,
  `END_DATE` datetime DEFAULT NULL,
  `START_DATE` datetime DEFAULT NULL,
  `TEST_NAME` varchar(255) DEFAULT NULL,
  `INTERVIEW_TYPE_ID` bigint(20) DEFAULT NULL,
  `JOB_INFO_ID` bigint(20) DEFAULT NULL,
  `USER_ID` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`ID`),
  KEY `FK_i76hag06mrtjxvji4mkgudtbl` (`INTERVIEW_TYPE_ID`),
  KEY `FK_2rr551tdr6siy7w4yfjrw5fqs` (`JOB_INFO_ID`),
  KEY `FK_a365koomssp5su65n2ccvd0ga` (`USER_ID`),
  CONSTRAINT `FK_a365koomssp5su65n2ccvd0ga` FOREIGN KEY (`USER_ID`) REFERENCES `user_mst_tbl` (`ID`),
  CONSTRAINT `FK_2rr551tdr6siy7w4yfjrw5fqs` FOREIGN KEY (`JOB_INFO_ID`) REFERENCES `job_info_mst` (`ID`),
  CONSTRAINT `FK_i76hag06mrtjxvji4mkgudtbl` FOREIGN KEY (`INTERVIEW_TYPE_ID`) REFERENCES `interview_types_mst_tbl` (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8;

--
-- Dumping data for table `interviews_mst_tbl`
--

/*!40000 ALTER TABLE `interviews_mst_tbl` DISABLE KEYS */;
/*!40000 ALTER TABLE `interviews_mst_tbl` ENABLE KEYS */;


--
-- Definition of table `interviews_round_question_tbl`
--

DROP TABLE IF EXISTS `interviews_round_question_tbl`;
CREATE TABLE `interviews_round_question_tbl` (
  `ID` bigint(20) NOT NULL AUTO_INCREMENT,
  `CODING_QUESTION_ID` bigint(20) DEFAULT NULL,
  `OBJECTIVE_QUESTION_ID` bigint(20) DEFAULT NULL,
  `ROUND_ID` bigint(20) DEFAULT NULL,
  `TASK_QUESTION_ID` bigint(20) DEFAULT NULL,
  `INTERVIEWS_ID` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`ID`),
  KEY `FK_5s6rvlqnj3tf9j1edha0uw2pc` (`CODING_QUESTION_ID`),
  KEY `FK_am01bng1qcv50vwhgxd8em6c1` (`OBJECTIVE_QUESTION_ID`),
  KEY `FK_9npyjelt7huq8bmbam0elbqjk` (`ROUND_ID`),
  KEY `FK_alksqirst1m72slibe3moo9dj` (`TASK_QUESTION_ID`),
  KEY `FK_7w786rugyyy9v5ue5y0awog4c` (`INTERVIEWS_ID`),
  CONSTRAINT `FK_7w786rugyyy9v5ue5y0awog4c` FOREIGN KEY (`INTERVIEWS_ID`) REFERENCES `interviews_mst_tbl` (`ID`),
  CONSTRAINT `FK_5s6rvlqnj3tf9j1edha0uw2pc` FOREIGN KEY (`CODING_QUESTION_ID`) REFERENCES `coding_test_qtn_tbl` (`ID`),
  CONSTRAINT `FK_9npyjelt7huq8bmbam0elbqjk` FOREIGN KEY (`ROUND_ID`) REFERENCES `rounds_mst_tbl` (`ID`),
  CONSTRAINT `FK_alksqirst1m72slibe3moo9dj` FOREIGN KEY (`TASK_QUESTION_ID`) REFERENCES `task_mst_tbl` (`ID`),
  CONSTRAINT `FK_am01bng1qcv50vwhgxd8em6c1` FOREIGN KEY (`OBJECTIVE_QUESTION_ID`) REFERENCES `objective_questions_tbl` (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=22 DEFAULT CHARSET=utf8;

--
-- Dumping data for table `interviews_round_question_tbl`
--

/*!40000 ALTER TABLE `interviews_round_question_tbl` DISABLE KEYS */;
/*!40000 ALTER TABLE `interviews_round_question_tbl` ENABLE KEYS */;


--
-- Definition of table `job_info_mst`
--

DROP TABLE IF EXISTS `job_info_mst`;
CREATE TABLE `job_info_mst` (
  `ID` bigint(20) NOT NULL AUTO_INCREMENT,
  `CLOSED_DATE` datetime DEFAULT NULL,
  `JOB_DESCRIPTION` varchar(255) DEFAULT NULL,
  `JOB_TITLE` varchar(255) DEFAULT NULL,
  `LOCATION` varchar(255) DEFAULT NULL,
  `POSTED_DATE` datetime DEFAULT NULL,
  `REQUIRED_SKILLS` varchar(255) DEFAULT NULL,
  `COMPANY_ID` bigint(20) DEFAULT NULL,
  `HR_ID` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`ID`),
  KEY `FK52DAAEBF7A01F8C2` (`COMPANY_ID`),
  KEY `FK52DAAEBF466A2439` (`HR_ID`),
  CONSTRAINT `FK52DAAEBF466A2439` FOREIGN KEY (`HR_ID`) REFERENCES `user_mst_tbl` (`ID`),
  CONSTRAINT `FK52DAAEBF7A01F8C2` FOREIGN KEY (`COMPANY_ID`) REFERENCES `company_mst_tbl` (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

--
-- Dumping data for table `job_info_mst`
--

/*!40000 ALTER TABLE `job_info_mst` DISABLE KEYS */;
INSERT INTO `job_info_mst` (`ID`,`CLOSED_DATE`,`JOB_DESCRIPTION`,`JOB_TITLE`,`LOCATION`,`POSTED_DATE`,`REQUIRED_SKILLS`,`COMPANY_ID`,`HR_ID`) VALUES 
 (1,'2017-07-29 15:34:33','pc testing','testing','bangalore','2017-07-29 15:34:33','java and c',1,264),
 (2,'2017-09-15 16:35:48','desc','Software developer','bangalore','2017-09-08 16:35:48','java',1,273);
/*!40000 ALTER TABLE `job_info_mst` ENABLE KEYS */;


--
-- Definition of table `job_interview_mst_tbl`
--

DROP TABLE IF EXISTS `job_interview_mst_tbl`;
CREATE TABLE `job_interview_mst_tbl` (
  `ID` bigint(20) NOT NULL AUTO_INCREMENT,
  `JOB_INFO_ID` bigint(20) DEFAULT NULL,
  `INTERVIEWS_ID` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`ID`),
  KEY `FK_sryjqfcplmsrcjxco9qosox2b` (`JOB_INFO_ID`),
  KEY `FK_1dtagh2h0s9cj7l20k5q8mhsm` (`INTERVIEWS_ID`),
  CONSTRAINT `FK_1dtagh2h0s9cj7l20k5q8mhsm` FOREIGN KEY (`INTERVIEWS_ID`) REFERENCES `interviews_mst_tbl` (`ID`),
  CONSTRAINT `FK_sryjqfcplmsrcjxco9qosox2b` FOREIGN KEY (`JOB_INFO_ID`) REFERENCES `job_info_mst` (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8;

--
-- Dumping data for table `job_interview_mst_tbl`
--

/*!40000 ALTER TABLE `job_interview_mst_tbl` DISABLE KEYS */;
/*!40000 ALTER TABLE `job_interview_mst_tbl` ENABLE KEYS */;


--
-- Definition of table `jobinfo_trn_tbl`
--

DROP TABLE IF EXISTS `jobinfo_trn_tbl`;
CREATE TABLE `jobinfo_trn_tbl` (
  `ID` bigint(20) NOT NULL AUTO_INCREMENT,
  `STUDENT_ID` bigint(20) DEFAULT NULL,
  `JOB_ID` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`ID`),
  KEY `FK80E3BE5B87B78090` (`JOB_ID`),
  CONSTRAINT `FK80E3BE5B87B78090` FOREIGN KEY (`JOB_ID`) REFERENCES `job_info_mst` (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

--
-- Dumping data for table `jobinfo_trn_tbl`
--

/*!40000 ALTER TABLE `jobinfo_trn_tbl` DISABLE KEYS */;
INSERT INTO `jobinfo_trn_tbl` (`ID`,`STUDENT_ID`,`JOB_ID`) VALUES 
 (1,34,2);
/*!40000 ALTER TABLE `jobinfo_trn_tbl` ENABLE KEYS */;


--
-- Definition of table `languages_mst_tbl`
--

DROP TABLE IF EXISTS `languages_mst_tbl`;
CREATE TABLE `languages_mst_tbl` (
  `ID` bigint(20) NOT NULL AUTO_INCREMENT,
  `LANGUAGE_NAME` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

--
-- Dumping data for table `languages_mst_tbl`
--

/*!40000 ALTER TABLE `languages_mst_tbl` DISABLE KEYS */;
INSERT INTO `languages_mst_tbl` (`ID`,`LANGUAGE_NAME`) VALUES 
 (1,'english'),
 (2,'hindi'),
 (3,'telugu'),
 (4,'kannada'),
 (5,'tamil');
/*!40000 ALTER TABLE `languages_mst_tbl` ENABLE KEYS */;


--
-- Definition of table `object_test_user_ans_tbl`
--

DROP TABLE IF EXISTS `object_test_user_ans_tbl`;
CREATE TABLE `object_test_user_ans_tbl` (
  `ID` bigint(20) NOT NULL AUTO_INCREMENT,
  `ANSWER` varchar(255) DEFAULT NULL,
  `IS_ANSWERED` bit(1) DEFAULT NULL,
  `QUESTION_ID` bigint(20) DEFAULT NULL,
  `PERSIONAL_ID` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`ID`),
  KEY `FK_43jil8epjxenrqdd69iqwknm3` (`QUESTION_ID`),
  KEY `FK_nlxdihb6vrseuypjqhcj23u8g` (`PERSIONAL_ID`),
  CONSTRAINT `FK_nlxdihb6vrseuypjqhcj23u8g` FOREIGN KEY (`PERSIONAL_ID`) REFERENCES `user_mst_tbl` (`ID`),
  CONSTRAINT `FK_43jil8epjxenrqdd69iqwknm3` FOREIGN KEY (`QUESTION_ID`) REFERENCES `objective_questions_tbl` (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=25 DEFAULT CHARSET=utf8;

--
-- Dumping data for table `object_test_user_ans_tbl`
--

/*!40000 ALTER TABLE `object_test_user_ans_tbl` DISABLE KEYS */;
INSERT INTO `object_test_user_ans_tbl` (`ID`,`ANSWER`,`IS_ANSWERED`,`QUESTION_ID`,`PERSIONAL_ID`) VALUES 
 (1,'textml tag',0x01,11,34),
 (2,'<SUP>',0x01,12,34),
 (3,'Both a and b above',0x01,13,34),
 (4,'textarea tag',0x01,11,275),
 (5,'<SUP>',0x01,12,275),
 (6,'Used to set space between cells',0x01,13,275),
 (7,'textarea tag',0x01,11,34),
 (8,'<SUP>',0x01,12,34),
 (9,'Used to set space between cells',0x01,13,34),
 (10,'ol tag',0x01,14,34),
 (11,'font',0x01,15,34),
 (12,'textml tag',0x01,11,34),
 (13,'<SUP>',0x01,12,34),
 (14,'Used to set space between cells',0x01,13,34),
 (15,'textarea tag',0x01,11,34),
 (16,'<SUB>',0x01,12,34),
 (17,'Used to provide width to a cell',0x01,13,34),
 (18,'ol tag',0x01,14,34),
 (19,'textml tag',0x01,11,275),
 (20,'<SUB>',0x01,12,275),
 (21,'Used to set space between cells',0x01,13,275),
 (22,'textarea tag',0x01,11,518),
 (23,'<SUP>',0x01,12,518),
 (24,'Both a and b above',0x01,13,518);
/*!40000 ALTER TABLE `object_test_user_ans_tbl` ENABLE KEYS */;


--
-- Definition of table `objective_question_answers_mst_tbl`
--

DROP TABLE IF EXISTS `objective_question_answers_mst_tbl`;
CREATE TABLE `objective_question_answers_mst_tbl` (
  `ID` bigint(20) NOT NULL AUTO_INCREMENT,
  `ANSWER` varchar(255) DEFAULT NULL,
  `QUESTION_ID` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8;

--
-- Dumping data for table `objective_question_answers_mst_tbl`
--

/*!40000 ALTER TABLE `objective_question_answers_mst_tbl` DISABLE KEYS */;
INSERT INTO `objective_question_answers_mst_tbl` (`ID`,`ANSWER`,`QUESTION_ID`) VALUES 
 (1,'<strong>',1),
 (2,'id',2),
 (3,'text-decoration',3),
 (4,'word-spacing',4),
 (5,'clear',5),
 (6,'both a and b',6),
 (7,'p {color:red;text-align:center;}',7),
 (8,'border',8),
 (9,'background-image',9),
 (10,'body {background-image:url(\'paper.gif\');}',10),
 (11,'textarea tag',11),
 (12,'<SUP>',12),
 (13,'Used to separate cell walls from their contents.',13),
 (14,'li tag',14),
 (15,'face',15),
 (16,'To logically divide the document',16),
 (17,'Using height and width',17),
 (18,'Line break',18),
 (19,'Transfer files to and from an Internet Server',19),
 (20,'<hr>',20);
/*!40000 ALTER TABLE `objective_question_answers_mst_tbl` ENABLE KEYS */;


--
-- Definition of table `objective_questions_tbl`
--

DROP TABLE IF EXISTS `objective_questions_tbl`;
CREATE TABLE `objective_questions_tbl` (
  `ID` bigint(20) NOT NULL AUTO_INCREMENT,
  `ANSWERS` varchar(255) DEFAULT NULL,
  `OPTIONS` varchar(255) DEFAULT NULL,
  `QUE_GROUP` varchar(255) DEFAULT NULL,
  `QUE_TYPE` varchar(255) DEFAULT NULL,
  `QUE_DESCRIPTION` varchar(255) DEFAULT NULL,
  `QUESTION_ID` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=30 DEFAULT CHARSET=utf8;

--
-- Dumping data for table `objective_questions_tbl`
--

/*!40000 ALTER TABLE `objective_questions_tbl` DISABLE KEYS */;
INSERT INTO `objective_questions_tbl` (`ID`,`ANSWERS`,`OPTIONS`,`QUE_GROUP`,`QUE_TYPE`,`QUE_DESCRIPTION`,`QUESTION_ID`) VALUES 
 (1,NULL,'<strong>@@<dar>@@<black>@@<emp>\r\n','CSS','choice','<b> tag makes the enclosed text bold. What is other tag to make text bold?','CSS001'),
 (2,NULL,'-id@@-class@@text@@bit','CSS','choice','The _____________ selector is used to specify a style for a single, unique element?','CSS002'),
 (3,NULL,'text-trans@@text-transformation@@text-decoration@@text-deco','CSS','choice','The ____________ property is mostly used to remove underlines from links?','CSS003'),
 (4,NULL,'space@@word-spacing@@word-space@@Both b and c','CSS','choice','___________ property can be used to Increase or decrease the space between words?','CSS004'),
 (5,NULL,'cleared@@clear@@float@@both and b','CSS','choice','The _____________ property specifies which sides of an element other floating elements are not allowed.?','CSS005'),
 (6,NULL,'h2 {font-size:200%;}@@h2 {font-size:200px;}@@both a and b@@h2 {font-size:200;}','CSS','choice','Which of the below is the correct way to set a font size?','CSS006'),
 (7,NULL,'p {color:red;text-align:center};@@p {color:red;text-align:center}@@p {color:red;text-align:center;}@@p (color:red;text-align:center;)','CSS','choice','Which of the following ways is correct to write a CSS?','CSS007'),
 (8,NULL,'tbl-border@@table-border\r\ntbl-border@@table-border@@tb-border@@border','CSS','choice','To specify table borders in CSS, ___________ property is used?','CSS008'),
 (9,NULL,'backg-img@@backg-image@@background-img@@background-image','CSS','choice',' ____________ property specifies an image to use as the background of an element?','CSS009'),
 (10,NULL,'body {background-image:url(paper.gif);}@@body {background-image:url(\'paper.gif\')};@@body {background-image:url(\'paper.gif\')}@@body {background-image:url(\'paper.gif\');}','CSS','choice','Which of the below is the correct way to set a background image?','CSS010'),
 (11,NULL,'textml tag@@text tag@@textarea tag@@Both b and c','HTML','choice',' Which of the following tags are used for a multi-line text input control?','HTML001'),
 (12,NULL,'<SUP>@@<SUB>@@<B>@@<P>','HTML','choice','Which HTML tag would be used to display power in expression (A+B)2 ?','HTML002'),
 (13,NULL,'Used to separate cell walls from their contents.@@Used to set space between cells@@Both a and b above@@Used to provide width to a cell','HTML','choice','What is cell padding?','HTML003'),
 (14,NULL,'list tag@@ls tag@@li tag@@ol tag','HTML','choice','Each list item in an ordered or unordered list has which tag?','HTML004'),
 (15,NULL,'fontname@@fn@@font@@face','HTML','choice','Which of the following attributes are used for a font name?','HTML005'),
 (16,NULL,'To replace paragraphs. i.e. p tags@@To logically divide the paragraphs@@To logically divide the document@@To provide space between tables','HTML','choice','What are <div> tags used for?','HTML006'),
 (17,NULL,'Using resize attribute@@Using height and width@@Using size attribute@@Using rs attribute','HTML','choice',' How can we resize the image?','HTML007'),
 (18,NULL,'Space@@Paragraph break@@Line break@@Word break','HTML','choice','What is the <br> tag for?','HTML008'),
 (19,NULL,'Designing a website@@Connecting to the internet@@Transfer files to and from an Internet Server@@None of the above','HTML','choice','What is the use of FTP Program?','HTML009'),
 (20,NULL,'<hr>@@<line>@@<line direction=\"horizontal\">@@<tr>','HTML','choice','Which tag inserts a line horizontally on your web page?','HTML010');
/*!40000 ALTER TABLE `objective_questions_tbl` ENABLE KEYS */;


--
-- Definition of table `objective_test_total_results_tbl`
--

DROP TABLE IF EXISTS `objective_test_total_results_tbl`;
CREATE TABLE `objective_test_total_results_tbl` (
  `ID` bigint(20) NOT NULL AUTO_INCREMENT,
  `TOTAL_MARKS` bigint(20) DEFAULT NULL,
  `TOTAL_QUESTIONS` bigint(20) DEFAULT NULL,
  `PERSIONAL_ID` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`ID`),
  KEY `FK_pk6hjgjuy5ym5rd6i02p895ck` (`PERSIONAL_ID`),
  CONSTRAINT `FK_pk6hjgjuy5ym5rd6i02p895ck` FOREIGN KEY (`PERSIONAL_ID`) REFERENCES `user_mst_tbl` (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `objective_test_total_results_tbl`
--

/*!40000 ALTER TABLE `objective_test_total_results_tbl` DISABLE KEYS */;
/*!40000 ALTER TABLE `objective_test_total_results_tbl` ENABLE KEYS */;


--
-- Definition of table `placements_info_tbl`
--

DROP TABLE IF EXISTS `placements_info_tbl`;
CREATE TABLE `placements_info_tbl` (
  `ID` bigint(20) NOT NULL AUTO_INCREMENT,
  `COURSE` varchar(255) DEFAULT NULL,
  `EMAIL_ID` varchar(255) DEFAULT NULL,
  `IMAGE_PATH` varchar(255) DEFAULT NULL,
  `COMPANY` varchar(255) DEFAULT NULL,
  `STUDENT_NAME` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=27 DEFAULT CHARSET=utf8;

--
-- Dumping data for table `placements_info_tbl`
--

/*!40000 ALTER TABLE `placements_info_tbl` DISABLE KEYS */;
INSERT INTO `placements_info_tbl` (`ID`,`COURSE`,`EMAIL_ID`,`IMAGE_PATH`,`COMPANY`,`STUDENT_NAME`) VALUES 
 (1,'UI','venkatasundeep.thota@gmail.com','resources/img/placementlogos/students/venkat sundeep thota.jpg','SAP','Sandeep Thota'),
 (2,'Java','tmkrishna15@gmail.com','resources/img/placementlogos/students/murali_t.jpg','IDrive Software India Pvt Ltd.','Murali Tammineedi'),
 (3,'Java','karnakarreddy26@gmail.com','resources/img/placementlogos/students/karnakarreddy.jpg','Accenture','Karnakar Reddy'),
 (4,'Java','vbalakishore@gmail.com','resources/img/placementlogos/students/Bala Krishore.jpg','Tech Mahindra','Bala Kishore'),
 (5,'C & C++',NULL,'resources/img/placementlogos/students/sivakumarvallu.jpg','Ruckus Wireless Inc.','Shiva Kumar vallu'),
 (6,'Java','balasudheer.velli@gmail.com','resources/img/placementlogos/students/sudheer_valli.jpg','Synchronoss','Bala Sudheer Velli'),
 (9,'Java','saiallaparthi@gmail.com','resources/img/placementlogos/students/sai_allapati.jpg','ClouddataTechnologies','Sail Allaparthi'),
 (12,'SQL,PL/SQL','ravi.kondru.kumar@gmail.com','resources/img/placementlogos/students/ravikumar_konduru.jpg','HCL','Ravi Kumar Konduru'),
 (13,'Java','javajakesh@gmail.com','resources/img/placementlogos/students/jakesh_n.jpg','PRACTO','Jakesh N'),
 (14,'Java','volatilevamshi@gmail.com','resources/img/placementlogos/students/vamshi_voore.jpg','Kitchensfood','Vamsi Voore'),
 (19,'UI','sivamallidi58@gmail.com','resources/img/placementlogos/students/siva_mallidi.jpg','Oracle','Siva M'),
 (20,'UI','mojjadaprasad71@gmail.com','resources/img/placementlogos/students/prasad_mojjoda.jpg','TechMahendra','Prasad Mojjada'),
 (21,'Java','tagorenaidu436@gmail.com','resources/img/placementlogos/students/tagur_naidu.jpg','Rilexions Cosulting Pvt Ltd','Tagore Naidu Gullipalli'),
 (22,'Java','vamsi.ece436@gmail.com','resources/img/placementlogos/students/vamshikrishna_mupparaju.jpg','Infosys','Vamsi Krishna Mupparaju'),
 (26,'UI',NULL,'resources/img/placementlogos/students/babulal_pc.jpg','TCS','Babulal');
/*!40000 ALTER TABLE `placements_info_tbl` ENABLE KEYS */;


--
-- Definition of table `pricing_plan_trn_tbl`
--

DROP TABLE IF EXISTS `pricing_plan_trn_tbl`;
CREATE TABLE `pricing_plan_trn_tbl` (
  `ID` bigint(20) NOT NULL AUTO_INCREMENT,
  `PURCHASE_DATE` datetime DEFAULT NULL,
  `PLAN_ID` bigint(20) DEFAULT NULL,
  `USER_ID` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`ID`),
  KEY `FK3406D7237B641D8` (`USER_ID`),
  KEY `FK3406D724814F56` (`PLAN_ID`),
  CONSTRAINT `FK3406D7237B641D8` FOREIGN KEY (`USER_ID`) REFERENCES `user_mst_tbl` (`ID`),
  CONSTRAINT `FK3406D724814F56` FOREIGN KEY (`PLAN_ID`) REFERENCES `pricing_planes_tbl` (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

--
-- Dumping data for table `pricing_plan_trn_tbl`
--

/*!40000 ALTER TABLE `pricing_plan_trn_tbl` DISABLE KEYS */;
INSERT INTO `pricing_plan_trn_tbl` (`ID`,`PURCHASE_DATE`,`PLAN_ID`,`USER_ID`) VALUES 
 (1,'2017-06-10 19:08:15',3,142),
 (2,'2017-07-29 15:42:08',1,264);
/*!40000 ALTER TABLE `pricing_plan_trn_tbl` ENABLE KEYS */;


--
-- Definition of table `pricing_planes_tbl`
--

DROP TABLE IF EXISTS `pricing_planes_tbl`;
CREATE TABLE `pricing_planes_tbl` (
  `ID` bigint(20) NOT NULL AUTO_INCREMENT,
  `AVAILABLE_PROFILES` varchar(255) DEFAULT NULL,
  `PLAN_AVAILABILITY` varchar(255) DEFAULT NULL,
  `PLAN_PRICE` float DEFAULT NULL,
  `PLAN_TYPE` varchar(255) DEFAULT NULL,
  `PLAN_VALIDITY` bigint(20) DEFAULT NULL,
  `STAFF_LOGIN` varchar(255) DEFAULT NULL,
  `TECH_SUPPORT` bit(1) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

--
-- Dumping data for table `pricing_planes_tbl`
--

/*!40000 ALTER TABLE `pricing_planes_tbl` DISABLE KEYS */;
INSERT INTO `pricing_planes_tbl` (`ID`,`AVAILABLE_PROFILES`,`PLAN_AVAILABILITY`,`PLAN_PRICE`,`PLAN_TYPE`,`PLAN_VALIDITY`,`STAFF_LOGIN`,`TECH_SUPPORT`) VALUES 
 (1,'10','Limited',0,'Startup Plan',1,'unlimited',0x01),
 (2,'200','Limited',500,'Aluminium',3,'500',0x01),
 (3,'unlimited','Unlimited',2000,'Gold',6,'1000',0x01);
/*!40000 ALTER TABLE `pricing_planes_tbl` ENABLE KEYS */;


--
-- Definition of table `project_domain_mst_tbl`
--

DROP TABLE IF EXISTS `project_domain_mst_tbl`;
CREATE TABLE `project_domain_mst_tbl` (
  `ID` bigint(20) NOT NULL AUTO_INCREMENT,
  `PROJECT_DOMAIN_NAME` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

--
-- Dumping data for table `project_domain_mst_tbl`
--

/*!40000 ALTER TABLE `project_domain_mst_tbl` DISABLE KEYS */;
INSERT INTO `project_domain_mst_tbl` (`ID`,`PROJECT_DOMAIN_NAME`) VALUES 
 (1,'HealthCare'),
 (2,'Banking'),
 (3,'AutoMobile');
/*!40000 ALTER TABLE `project_domain_mst_tbl` ENABLE KEYS */;


--
-- Definition of table `purchased_courses_tbl`
--

DROP TABLE IF EXISTS `purchased_courses_tbl`;
CREATE TABLE `purchased_courses_tbl` (
  `ID` bigint(20) NOT NULL AUTO_INCREMENT,
  `PURCHASED_COURSE_DETAILS` longtext,
  `USER_ID` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`ID`),
  KEY `FKB3BD43FB37B641D8` (`USER_ID`),
  CONSTRAINT `FKB3BD43FB37B641D8` FOREIGN KEY (`USER_ID`) REFERENCES `user_mst_tbl` (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `purchased_courses_tbl`
--

/*!40000 ALTER TABLE `purchased_courses_tbl` DISABLE KEYS */;
/*!40000 ALTER TABLE `purchased_courses_tbl` ENABLE KEYS */;


--
-- Definition of table `purchased_courses_trn_tbl`
--

DROP TABLE IF EXISTS `purchased_courses_trn_tbl`;
CREATE TABLE `purchased_courses_trn_tbl` (
  `ID` bigint(20) NOT NULL AUTO_INCREMENT,
  `PURCHASED_DATE` datetime DEFAULT NULL,
  `COURSE_ID` bigint(20) DEFAULT NULL,
  `USER_ID` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`ID`),
  KEY `FK_lm8oorh2iscc6bxbby0tfe8ih` (`COURSE_ID`),
  KEY `FK_dg3rf1nx37sg0rswe6moemqyl` (`USER_ID`),
  CONSTRAINT `FK_dg3rf1nx37sg0rswe6moemqyl` FOREIGN KEY (`USER_ID`) REFERENCES `user_mst_tbl` (`ID`),
  CONSTRAINT `FK_lm8oorh2iscc6bxbby0tfe8ih` FOREIGN KEY (`COURSE_ID`) REFERENCES `course_mst_tbl` (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=37 DEFAULT CHARSET=utf8;

--
-- Dumping data for table `purchased_courses_trn_tbl`
--

/*!40000 ALTER TABLE `purchased_courses_trn_tbl` DISABLE KEYS */;
INSERT INTO `purchased_courses_trn_tbl` (`ID`,`PURCHASED_DATE`,`COURSE_ID`,`USER_ID`) VALUES 
 (1,'2017-05-07 00:00:00',2,20),
 (2,'2017-05-07 00:00:00',14,20),
 (3,'2017-06-11 00:00:00',1,20),
 (4,'2017-06-20 00:00:00',6,153),
 (5,'2017-06-20 00:00:00',4,154),
 (6,'2017-06-26 00:00:00',11,177),
 (7,'2017-07-27 00:00:00',1,211),
 (8,'2017-07-27 00:00:00',5,34),
 (9,'2017-07-27 00:00:00',4,211),
 (10,'2017-07-27 00:00:00',5,211),
 (11,'2017-07-27 00:00:00',3,211),
 (12,'2017-07-27 00:00:00',6,211),
 (13,'2017-07-27 00:00:00',9,211),
 (14,'2017-07-27 00:00:00',6,211),
 (15,'2017-07-27 00:00:00',2,211),
 (16,'2017-07-27 00:00:00',1,253),
 (17,'2017-07-27 00:00:00',7,260),
 (18,'2017-07-27 00:00:00',9,260),
 (19,'2017-07-27 00:00:00',3,260),
 (20,'2017-07-27 00:00:00',2,260),
 (21,'2017-07-27 00:00:00',7,120),
 (22,'2017-07-27 00:00:00',7,151),
 (23,'2017-07-27 00:00:00',5,151),
 (24,'2017-07-29 00:00:00',9,253),
 (25,'2017-07-29 00:00:00',14,253),
 (26,'2017-07-29 00:00:00',10,253),
 (27,'2017-07-29 00:00:00',2,253),
 (28,'2017-08-03 00:00:00',6,260),
 (29,'2017-08-03 00:00:00',3,260),
 (30,'2017-08-03 00:00:00',2,120),
 (31,'2017-08-03 00:00:00',4,21),
 (32,'2017-08-03 00:00:00',5,10),
 (33,'2017-08-04 00:00:00',5,253),
 (34,'2017-08-07 00:00:00',1,262),
 (35,'2017-08-07 00:00:00',1,262),
 (36,'2017-08-07 00:00:00',6,200);
/*!40000 ALTER TABLE `purchased_courses_trn_tbl` ENABLE KEYS */;


--
-- Definition of table `question_mst_tbl`
--

DROP TABLE IF EXISTS `question_mst_tbl`;
CREATE TABLE `question_mst_tbl` (
  `ID` bigint(20) NOT NULL AUTO_INCREMENT,
  `ANSWERS` varchar(255) DEFAULT NULL,
  `OPTIONS` varchar(255) DEFAULT NULL,
  `QUE_GROUP` varchar(255) DEFAULT NULL,
  `QUE_TYPE` varchar(255) DEFAULT NULL,
  `QUE_DESCRIPTION` varchar(4000) DEFAULT NULL,
  `QUESTION_ID` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=44 DEFAULT CHARSET=utf8;

--
-- Dumping data for table `question_mst_tbl`
--

/*!40000 ALTER TABLE `question_mst_tbl` DISABLE KEYS */;
INSERT INTO `question_mst_tbl` (`ID`,`ANSWERS`,`OPTIONS`,`QUE_GROUP`,`QUE_TYPE`,`QUE_DESCRIPTION`,`QUESTION_ID`) VALUES 
 (1,NULL,'<strong>@@<dar>@@<black>@@<emp>\r\n','CSS','choice','<b> tag makes the enclosed text bold. What is other tag to make text bold?','CSS001'),
 (2,NULL,'-id@@-class@@text@@bit','CSS','choice','The _____________ selector is used to specify a style for a single, unique element?','CSS002'),
 (3,NULL,'text-trans@@text-transformation@@text-decoration@@text-deco','CSS','choice','The ____________ property is mostly used to remove underlines from links?','CSS003'),
 (4,NULL,'space@@word-spacing@@word-space@@Both b and c','CSS','choice','___________ property can be used to Increase or decrease the space between words?','CSS004'),
 (5,NULL,'cleared@@clear@@float@@both and b','CSS','choice','The _____________ property specifies which sides of an element other floating elements are not allowed.?','CSS005'),
 (6,NULL,'h2 {font-size:200%;}@@h2 {font-size:200px;}@@both a and b@@h2 {font-size:200;}','CSS','choice','Which of the below is the correct way to set a font size?','CSS006'),
 (7,NULL,'p {color:red;text-align:center};@@p {color:red;text-align:center}@@p {color:red;text-align:center;}@@p (color:red;text-align:center;)','CSS','choice','Which of the following ways is correct to write a CSS?','CSS007'),
 (8,NULL,'tbl-border@@table-border\r\ntbl-border@@table-border@@tb-border@@border','CSS','choice','To specify table borders in CSS, ___________ property is used?','CSS008'),
 (9,NULL,'backg-img@@backg-image@@background-img@@background-image','CSS','choice',' ____________ property specifies an image to use as the background of an element?','CSS009'),
 (10,NULL,'body {background-image:url(paper.gif);}@@body {background-image:url(\'paper.gif\')};@@body {background-image:url(\'paper.gif\')}@@body {background-image:url(\'paper.gif\');}','CSS','choice','Which of the below is the correct way to set a background image?','CSS010'),
 (11,NULL,'textml tag@@text tag@@textarea tag@@Both b and c','HTML','choice',' Which of the following tags are used for a multi-line text input control?','HTML001'),
 (12,NULL,'<SUP>@@<SUB>@@<B>@@<P>','HTML','choice','Which HTML tag would be used to display power in expression (A+B)2 ?','HTML002'),
 (13,NULL,'Used to separate cell walls from their contents.@@Used to set space between cells@@Both a and b above@@Used to provide width to a cell','HTML','choice','What is cell padding?','HTML003'),
 (14,NULL,'list tag@@ls tag@@li tag@@ol tag','HTML','choice','Each list item in an ordered or unordered list has which tag?','HTML004'),
 (15,NULL,'fontname@@fn@@font@@face','HTML','choice','Which of the following attributes are used for a font name?','HTML005'),
 (16,NULL,'To replace paragraphs. i.e. p tags@@To logically divide the paragraphs@@To logically divide the document@@To provide space between tables','HTML','choice','What are <div> tags used for?','HTML006'),
 (17,NULL,'Using resize attribute@@Using height and width@@Using size attribute@@Using rs attribute','HTML','choice',' How can we resize the image?','HTML007'),
 (18,NULL,'Space@@Paragraph break@@Line break@@Word break','HTML','choice','What is the <br> tag for?','HTML008'),
 (19,NULL,'Designing a website@@Connecting to the internet@@Transfer files to and from an Internet Server@@None of the above','HTML','choice','What is the use of FTP Program?','HTML009'),
 (20,NULL,'<hr>@@<line>@@<line direction=\"horizontal\">@@<tr>','HTML','choice','Which tag inserts a line horizontally on your web page?','HTML010'),
 (21,NULL,'jdk@@sdk@@dbk@@dbk','JAVA','choice','In order to run Java program, we need to install __________application program.?','JAVA001'),
 (22,NULL,'Java only@@apple@@jdk@@oak','JAVA','choice',' Previously java was known as ________.?','JAVA002'),
 (23,NULL,'object oriented@@procedural oriented@@system oriented@@platform oriented','JAVA','choice',' java is a _____________language.?','JAVA003'),
 (24,NULL,'java development kit@@java deployment kit@@java demo kit@@java distributed kit','JAVA','choice','What is JDK?','JAVA004'),
 (25,NULL,'Compilation@@interpretation@@both a and b@@none of these','JAVA','choice','Which of the following operation(s) is/are required to convert the java source code into output form.?','JAVA005'),
 (26,NULL,'Microsoft@@Oracle@@Sun@@Google','JAVA','choice','Java is developed by___________?','JAVA006'),
 (27,NULL,'.java@@.class@@.doc@@.txt','JAVA','choice','What is the extension of the java program?','JAVA007'),
 (28,NULL,'Static Binding@@Dynamic Binding@@Both of the above@@None of the above','JAVA','choice','Method Overloading is an example of','JAVA008'),
 (29,NULL,'serializable@@comparable@@cloneable@@none of the above','JAVA','choice','Which of the following is a marker interface?','JAVA009'),
 (30,NULL,' Finally@@Compilation fails@@The code runs with no output.l@@An exception is thrown at runtime.','JAVA','code','What will be the output of the program?@CODE_START@@JAVA@public class Foo \r\n{  \r\n    public static void main(String[] args) \r\n    {\r\n        try \r\n        { \r\n            return; \r\n        } \r\n        finally \r\n        {\r\n            System.out.println( \"Finally\" ); \r\n        } \r\n    } \r\n}\r\n@CODE_END@','JAVA010'),
 (31,NULL,'Compile fail due to error on line no 2@@Compile fail due to error on line no 9@@Compile fail due to error on line no 8@@15\r\n','JAVA','code','What is the output for the below code ?\r\n@CODE_START@@JAVA@public class A {\r\n	int add(int i, int j){\r\n		return i+j;\r\n	}\r\n}\r\n	\r\npublic class B extends A{\r\n	public static void main(String argv[]){\r\n	short s = 9;\r\n	System.out.println(add(s,6));\r\n	}\r\n}@CODE_END@\r\n','JAVA011'),
 (32,NULL,'0 false 0@@0 true 0@@0 0 0@@Compile error - static variable must be initialized before use. ','JAVA','code','What is the output for the below code ?\r\n@CODE_START@@JAVA@public class A {\r\n	int k;\r\n	boolean istrue;\r\n	static int p;\r\n	public void printValue() {\r\n		System.out.print(k);\r\n		System.out.print(istrue);\r\n		System.out.print(p);\r\n	}\r\n}\r\npublic class Test{\r\n	 public static void main(String argv[]){\r\n		 A a = new A();\r\n		 a.printValue();\r\n	 }\r\n}@CODE_END@\r\n','JAVA012'),
 (33,NULL,'Animal@@Cat@@Animal Cat@@Compile Error','JAVA','code','What is the output for the below code ?\r\n@CODE_START@@JAVA@package com;\r\nclass Animal {\r\n	 public void printName(){\r\n	 System.out.println(\"Animal\");\r\n	 }\r\n}\r\n\r\npackage exam;\r\nimport com.Animal;\r\npublic class Cat extends Animal {\r\n	 public void printName(){\r\n	 System.out.println(\"Cat\");\r\n	 }\r\n}\r\n\r\npackage exam;\r\nimport com.Animal;\r\npublic class Test {\r\n	public static void main(String[] args){\r\n	 Animal a = new Cat();\r\n	 a.printName();\r\n	}\r\n}@CODE_END@\r\n','JAVA013'),
 (34,NULL,'A a = new B();@@A a = new B(5);@@A a = new A(String s);@@All of the above\r\n','JAVA','code','Which of the below code can be insert at line 7 to make clean\r\ncompilation ?@CODE_START@@JAVA@\r\nclass A {\r\n	A(String s) {\r\n	}\r\n	A() {\r\n	}\r\n}\r\n1. class B extends A {\r\n2. 	B() { }\r\n3. 	B(String s) {\r\n4. 	super(s);\r\n5. 	}\r\n6. 	void test() {\r\n7. 		// insert code here\r\n8. 	}\r\n9. }\r\n@CODE_END@','JAVA014'),
 (35,NULL,'22@@50@@10@@Compilation fails with an error at line 4','JAVA','code','What is the output for the below code ?@CODE_START@@JAVA@\r\n1. public class Test {\r\n2.	 public static void main(String... args) {\r\n3.		 int x =5;\r\n4.		 x *= 3 + 7;\r\n5.		 System.out.println(x);\r\n6.	 }\r\n7. }@CODE_END@','JAVA015'),
 (36,NULL,'run-test run-test@@run-test@@Compilation fails due to an error on line 4@@Compilation fails due to an error on line 7\r\n','JAVA','code','What will happen when you attempt to compile and run the following code?@CODE_START@@JAVA@\r\n1. public class Test extends Thread{\r\n2. 	  public static void main(String argv[]){\r\n3.   	 Test t = new Test();\r\n4. 	 	 t.run();\r\n5. 	 	 t.start();\r\n6. 	  }\r\n7. 	  public void run(){\r\n8.   	 System.out.println(\"run-test\");\r\n9. 	  }\r\n10.}\r\n@CODE_END@\r\n','JAVA016'),
 (37,NULL,'Compile error@@Runtime Exception@@7 9@@None of the above\r\n','JAVA','code','What is the output for the bellow code?@CODE_START@@JAVA@\r\nimport java.util.Iterator;\r\nimport java.util.Set;\r\nimport java.util.TreeSet;\r\npublic class Test {\r\n	public static void main(String... args) {\r\n\r\n		Set s = new TreeSet();\r\n		s.add(\"7\");\r\n		s.add(9);\r\n		Iterator itr = s.iterator();\r\n		while (itr.hasNext())\r\n		System.out.print(itr.next() + \" \");\r\n	}\r\n}@CODE_END@','JAVA017'),
 (38,NULL,'java.util.ArrayList@@java.util.List@@java.util.HashSet@@java.util.Vector','JAVA','code','Which collection class grows or shrinks its size and provides indexed\r\naccess to its elements, but methods are not synchronized?\r','JAVA018'),
 (39,NULL,'Value-A Name-B@@Value-A Value-A@@Value-A Name-C@@Name-B Name-C','JAVA','code','What is the output for the below code ?@CODE_START@@JAVA@\r\npublic class A {\r\n	public void printValue(){\r\n	   System.out.println(\"Value-A\");\r\n	}\r\n}\r\npublic class B extends A{\r\n	public void printNameB(){\r\n	   System.out.println(\"Name-B\");\r\n	}\r\n}\r\npublic class C extends A{\r\n	public void printNameC(){\r\n	   System.out.println(\"Name-C\");\r\n	}\r\n}\r\npublic class Test{\r\n    public static void main (String[] args) {\r\n	   B b = new B();\r\n	   C c = new C();\r\n	   newPrint(b);\r\n	   newPrint(c);\r\n	}\r\n    public static void newPrint(A a){\r\n	   a.printValue();\r\n	 }\r\n}@CODE_END@\r\n','JAVA019'),
 (40,NULL,'true@@false@@Compilation fails with an error at line 3@@Compilation fails with an error at line 4\r\n','JAVA','code','What is the output for the below code ?@CODE_START@@JAVA@\r\n1. public class Test {\r\n2.    public static void main(String... args) {\r\n3.       int [] index = new int[5];\r\n4.       System.out.println(index instanceof Object);\r\n5.    }\r\n6. }\r\n@CODE_END@','JAVA020'),
 (41,'','','JAVA','choice','json to java\nwhy we use only json object in spring @requestbody','JAVA021'),
 (42,'','','JAVA','choice','json to java\nwhy we use only json object in spring @requestbody','JAVA022'),
 (43,'','csss@@html@@java@@html','CSS','choice','what is the use of css','CSS011');
/*!40000 ALTER TABLE `question_mst_tbl` ENABLE KEYS */;


--
-- Definition of table `quiz_trn_tbl`
--

DROP TABLE IF EXISTS `quiz_trn_tbl`;
CREATE TABLE `quiz_trn_tbl` (
  `ID` bigint(20) NOT NULL AUTO_INCREMENT,
  `ANSWERED` bigint(20) DEFAULT NULL,
  `CREATED_ON` datetime DEFAULT NULL,
  `QUESTIONS` bigint(20) DEFAULT NULL,
  `STATUS` varchar(255) DEFAULT NULL,
  `TECHNOLOGY` varchar(255) DEFAULT NULL,
  `TOPIC` varchar(255) DEFAULT NULL,
  `USER_ID` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=143 DEFAULT CHARSET=utf8;

--
-- Dumping data for table `quiz_trn_tbl`
--

/*!40000 ALTER TABLE `quiz_trn_tbl` DISABLE KEYS */;
INSERT INTO `quiz_trn_tbl` (`ID`,`ANSWERED`,`CREATED_ON`,`QUESTIONS`,`STATUS`,`TECHNOLOGY`,`TOPIC`,`USER_ID`) VALUES 
 (2,7,'2017-02-27 00:00:00',10,'ACTIVE','htmlTopics','Introduction To HTML',6),
 (3,7,'2017-02-27 00:00:00',10,'ACTIVE','htmlTopics','Introduction To HTML',6),
 (4,8,'2017-02-27 00:00:00',10,'ACTIVE','htmlTopics','Introduction To HTML',6),
 (5,8,'2017-02-27 00:00:00',10,'ACTIVE','htmlTopics','Introduction To HTML',6),
 (6,8,'2017-02-27 00:00:00',10,'ACTIVE','htmlTopics','Introduction To HTML',6),
 (7,9,'2017-02-27 00:00:00',10,'ACTIVE','htmlTopics','Introduction To HTML',6),
 (8,8,'2017-02-27 00:00:00',10,'ACTIVE','htmlTopics','Introduction To HTML',6),
 (9,9,'2017-02-27 00:00:00',10,'ACTIVE','htmlTopics','Introduction To HTML',6),
 (10,8,'2017-02-27 00:00:00',10,'ACTIVE','htmlTopics','Introduction To HTML',6),
 (11,8,'2017-02-27 00:00:00',10,'ACTIVE','htmlTopics','Introduction To HTML',6),
 (12,9,'2017-02-27 00:00:00',10,'ACTIVE','htmlTopics','Introduction To HTML',6),
 (13,8,'2017-02-27 00:00:00',10,'ACTIVE','htmlTopics','Introduction To HTML',6),
 (14,9,'2017-02-27 00:00:00',10,'ACTIVE','htmlTopics','Introduction To HTML',6),
 (15,8,'2017-02-27 00:00:00',10,'ACTIVE','htmlTopics','Introduction To HTML',6),
 (16,8,'2017-02-27 00:00:00',10,'ACTIVE','htmlTopics','Introduction To HTML',6),
 (17,8,'2017-02-27 00:00:00',10,'ACTIVE','htmlTopics','Introduction To HTML',6),
 (18,8,'2017-02-27 00:00:00',10,'ACTIVE','htmlTopics','Introduction To HTML',6),
 (19,9,'2017-02-27 00:00:00',10,'ACTIVE','htmlTopics','Introduction To HTML',6),
 (24,7,'2017-03-01 00:00:00',10,'ACTIVE','htmlTopics','Introduction To HTML',11),
 (25,6,'2017-03-01 00:00:00',10,'ACTIVE','htmlTopics','Introduction To HTML',11),
 (26,6,'2017-03-01 00:00:00',10,'ACTIVE','htmlTopics','Introduction To HTML',11),
 (27,7,'2017-03-01 00:00:00',10,'ACTIVE','htmlTopics','Introduction To HTML',11),
 (28,7,'2017-03-01 00:00:00',10,'ACTIVE','htmlTopics','Introduction To HTML',11),
 (29,8,'2017-03-01 00:00:00',10,'ACTIVE','htmlTopics','Introduction To HTML',11),
 (30,9,'2017-03-01 00:00:00',10,'ACTIVE','htmlTopics','Introduction To HTML',11),
 (31,10,'2017-03-01 00:00:00',10,'ACTIVE','htmlTopics','Introduction To HTML',11),
 (32,10,'2017-03-17 00:00:00',10,'ACTIVE','htmlTopics','Introduction To HTML',17),
 (33,8,'2017-03-17 00:00:00',8,'ACTIVE','htmlTopics','Elements',17),
 (34,16,'2017-03-17 00:00:00',21,'ACTIVE','htmlTopics','HTML Tags',17),
 (35,7,'2017-04-24 00:00:00',8,'ACTIVE','javaTopics','Java History',80),
 (36,7,'2017-04-24 00:00:00',8,'ACTIVE','javaTopics','Java History',80),
 (37,6,'2017-04-24 00:00:00',8,'ACTIVE','javaTopics','Java History',80),
 (38,7,'2017-04-24 00:00:00',8,'ACTIVE','javaTopics','Java History',80),
 (39,8,'2017-04-24 00:00:00',8,'ACTIVE','javaTopics','Java History',80),
 (40,4,'2017-05-02 00:00:00',10,'ACTIVE','javaTopics','Variables',35),
 (41,3,'2017-05-02 00:00:00',10,'ACTIVE','javaTopics','Datatypes',35),
 (42,8,'2017-05-24 00:00:00',15,'ACTIVE','cssTopics','Introduction To CSS',4),
 (43,8,'2017-05-30 00:00:00',10,'ACTIVE','htmlTopics','Introduction To HTML',1),
 (44,7,'2017-05-30 00:00:00',10,'ACTIVE','htmlTopics','Introduction To HTML',1),
 (45,9,'2017-05-30 00:00:00',10,'ACTIVE','htmlTopics','Introduction To HTML',1),
 (46,10,'2017-05-30 00:00:00',10,'ACTIVE','htmlTopics','Introduction To HTML',1),
 (47,2,'2017-06-05 00:00:00',2,'ACTIVE','cTopics','Introduction to C',129),
 (48,2,'2017-06-05 00:00:00',2,'ACTIVE','cTopics','Introduction to C',129),
 (49,3,'2017-06-08 00:00:00',10,'ACTIVE','javaTopics','Variables',131),
 (50,5,'2017-06-17 00:00:00',10,'ACTIVE','htmlTopics','Tables',20),
 (51,6,'2017-06-20 00:00:00',10,'ACTIVE','javaTopics','Variables',151),
 (52,3,'2017-06-20 00:00:00',10,'ACTIVE','javaTopics','Variables',151),
 (53,5,'2017-06-20 00:00:00',10,'ACTIVE','javaTopics','Variables',153),
 (54,4,'2017-06-21 00:00:00',12,'ACTIVE','servletsTopics','Introduction To Webapplications',153),
 (55,11,'2017-06-21 00:00:00',14,'ACTIVE','jsTopics','Events',163),
 (56,4,'2017-06-23 00:00:00',8,'ACTIVE','javaTopics','Java History',191),
 (57,3,'2017-06-23 00:00:00',8,'ACTIVE','javaTopics','Java History',191),
 (58,4,'2017-06-23 00:00:00',8,'ACTIVE','javaTopics','Java History',191),
 (59,1,'2017-06-26 00:00:00',2,'ACTIVE','cTopics','Introduction to C',177),
 (60,2,'2017-06-26 00:00:00',2,'ACTIVE','cTopics','Introduction to C',177),
 (61,5,'2017-06-26 00:00:00',8,'ACTIVE','javaTopics','Java History',177),
 (62,5,'2017-06-26 00:00:00',8,'ACTIVE','javaTopics','Java History',177),
 (63,5,'2017-06-26 00:00:00',8,'ACTIVE','javaTopics','Java History',177),
 (64,6,'2017-06-26 00:00:00',8,'ACTIVE','javaTopics','Java History',177),
 (65,6,'2017-06-26 00:00:00',8,'ACTIVE','javaTopics','Java History',177),
 (66,7,'2017-06-26 00:00:00',8,'ACTIVE','javaTopics','Java History',177),
 (67,6,'2017-06-26 00:00:00',8,'ACTIVE','javaTopics','Java History',177),
 (68,6,'2017-06-26 00:00:00',8,'ACTIVE','javaTopics','Java History',177),
 (69,7,'2017-06-26 00:00:00',8,'ACTIVE','javaTopics','Java History',177),
 (70,6,'2017-06-26 00:00:00',8,'ACTIVE','javaTopics','Java History',177),
 (71,7,'2017-06-26 00:00:00',8,'ACTIVE','javaTopics','Java History',177),
 (72,6,'2017-06-26 00:00:00',8,'ACTIVE','javaTopics','Java History',177),
 (73,7,'2017-06-26 00:00:00',8,'ACTIVE','javaTopics','Java History',177),
 (74,6,'2017-06-26 00:00:00',8,'ACTIVE','javaTopics','Java History',177),
 (75,6,'2017-06-26 00:00:00',8,'ACTIVE','javaTopics','Java History',177),
 (76,7,'2017-06-26 00:00:00',8,'ACTIVE','javaTopics','Java History',177),
 (77,6,'2017-06-26 00:00:00',8,'ACTIVE','javaTopics','Java History',177),
 (78,8,'2017-06-26 00:00:00',10,'ACTIVE','htmlTopics','Introduction To HTML',177),
 (79,7,'2017-06-26 00:00:00',10,'ACTIVE','htmlTopics','Introduction To HTML',177),
 (80,7,'2017-06-26 00:00:00',10,'ACTIVE','htmlTopics','Introduction To HTML',177),
 (81,7,'2017-06-26 00:00:00',10,'ACTIVE','htmlTopics','Introduction To HTML',177),
 (82,9,'2017-06-26 00:00:00',10,'ACTIVE','htmlTopics','Introduction To HTML',177),
 (83,9,'2017-06-26 00:00:00',10,'ACTIVE','htmlTopics','Introduction To HTML',177),
 (84,8,'2017-06-26 00:00:00',10,'ACTIVE','htmlTopics','Introduction To HTML',177),
 (85,4,'2017-07-20 00:00:00',8,'ACTIVE','javaTopics','Java History',246),
 (86,4,'2017-07-20 00:00:00',8,'ACTIVE','javaTopics','Java History',246),
 (87,4,'2017-07-20 00:00:00',8,'ACTIVE','javaTopics','Java History',246),
 (88,5,'2017-07-20 00:00:00',8,'ACTIVE','javaTopics','Java History',246),
 (89,6,'2017-07-20 00:00:00',8,'ACTIVE','javaTopics','Java History',246),
 (90,6,'2017-07-20 00:00:00',8,'ACTIVE','javaTopics','Java History',246),
 (91,6,'2017-07-20 00:00:00',8,'ACTIVE','javaTopics','Java History',246),
 (92,7,'2017-07-20 00:00:00',8,'ACTIVE','javaTopics','Java History',246),
 (93,7,'2017-07-20 00:00:00',8,'ACTIVE','javaTopics','Java History',246),
 (94,7,'2017-07-20 00:00:00',8,'ACTIVE','javaTopics','Java History',246),
 (95,7,'2017-07-20 00:00:00',8,'ACTIVE','javaTopics','Java History',246),
 (96,7,'2017-07-20 00:00:00',8,'ACTIVE','javaTopics','Java History',246),
 (97,8,'2017-07-20 00:00:00',8,'ACTIVE','javaTopics','Java History',246),
 (98,4,'2017-07-20 00:00:00',10,'ACTIVE','javaTopics','Variables',246),
 (99,5,'2017-07-20 00:00:00',10,'ACTIVE','javaTopics','Variables',246),
 (100,6,'2017-07-20 00:00:00',10,'ACTIVE','javaTopics','Variables',246),
 (101,5,'2017-07-20 00:00:00',10,'ACTIVE','javaTopics','Variables',246),
 (102,6,'2017-07-20 00:00:00',10,'ACTIVE','javaTopics','Variables',246),
 (103,7,'2017-07-20 00:00:00',10,'ACTIVE','javaTopics','Variables',246),
 (104,6,'2017-07-20 00:00:00',10,'ACTIVE','javaTopics','Variables',246),
 (105,7,'2017-07-20 00:00:00',10,'ACTIVE','javaTopics','Variables',246),
 (106,6,'2017-07-20 00:00:00',10,'ACTIVE','javaTopics','Variables',246),
 (107,6,'2017-07-20 00:00:00',10,'ACTIVE','javaTopics','Variables',246),
 (108,8,'2017-07-20 00:00:00',10,'ACTIVE','javaTopics','Variables',246),
 (109,8,'2017-07-20 00:00:00',10,'ACTIVE','javaTopics','Variables',246),
 (110,7,'2017-07-20 00:00:00',10,'ACTIVE','javaTopics','Variables',246),
 (111,7,'2017-07-20 00:00:00',10,'ACTIVE','javaTopics','Variables',246),
 (112,9,'2017-07-20 00:00:00',10,'ACTIVE','javaTopics','Variables',246),
 (113,8,'2017-07-20 00:00:00',10,'ACTIVE','javaTopics','Variables',246),
 (114,9,'2017-07-20 00:00:00',10,'ACTIVE','javaTopics','Variables',246),
 (115,10,'2017-07-20 00:00:00',10,'ACTIVE','javaTopics','Variables',246),
 (116,7,'2017-07-25 00:00:00',10,'ACTIVE','javaTopics','Variables',247),
 (117,7,'2017-07-25 00:00:00',10,'ACTIVE','javaTopics','Datatypes',247),
 (118,4,'2017-07-25 00:00:00',6,'ACTIVE','javaTopics','Operators',247),
 (119,1,'2017-07-25 00:00:00',2,'ACTIVE','javaTopics','Introduction to OOPS',247),
 (120,1,'2017-07-25 00:00:00',2,'ACTIVE','javaTopics','Introduction to OOPS',247),
 (121,1,'2017-07-25 00:00:00',2,'ACTIVE','javaTopics','Introduction to OOPS',247),
 (122,1,'2017-07-25 00:00:00',2,'ACTIVE','javaTopics','Introduction to OOPS',247),
 (123,2,'2017-07-25 00:00:00',2,'ACTIVE','javaTopics','Introduction to OOPS',247),
 (124,4,'2017-07-25 00:00:00',10,'ACTIVE','htmlTopics','Introduction To HTML',253),
 (125,5,'2017-07-25 00:00:00',10,'ACTIVE','htmlTopics','Introduction To HTML',253),
 (126,6,'2017-07-25 00:00:00',10,'ACTIVE','htmlTopics','Introduction To HTML',253),
 (127,7,'2017-07-25 00:00:00',10,'ACTIVE','htmlTopics','Introduction To HTML',253),
 (128,6,'2017-07-25 00:00:00',10,'ACTIVE','htmlTopics','Introduction To HTML',253),
 (129,6,'2017-07-25 00:00:00',10,'ACTIVE','htmlTopics','Introduction To HTML',253),
 (130,8,'2017-07-25 00:00:00',10,'ACTIVE','htmlTopics','Introduction To HTML',253),
 (131,7,'2017-07-25 00:00:00',10,'ACTIVE','htmlTopics','Introduction To HTML',253),
 (132,7,'2017-07-25 00:00:00',10,'ACTIVE','htmlTopics','Introduction To HTML',253),
 (133,9,'2017-07-25 00:00:00',10,'ACTIVE','htmlTopics','Introduction To HTML',253),
 (134,3,'2017-07-26 00:00:00',8,'ACTIVE','htmlTopics','Elements & Attributes',253),
 (135,4,'2017-07-26 00:00:00',8,'ACTIVE','htmlTopics','Paragraphs',253),
 (136,4,'2017-07-26 00:00:00',10,'ACTIVE','htmlTopics','Images',253),
 (137,3,'2017-07-26 00:00:00',11,'ACTIVE','htmlTopics','Anchor Tags',253),
 (138,7,'2017-07-26 00:00:00',10,'ACTIVE','htmlTopics','Lists',253),
 (139,4,'2017-07-26 00:00:00',10,'ACTIVE','htmlTopics','Tables',253),
 (140,6,'2017-07-27 00:00:00',15,'ACTIVE','cssTopics','Introduction To CSS',253),
 (141,2,'2017-07-27 00:00:00',5,'ACTIVE','cssTopics','Colors',253),
 (142,3,'2017-08-10 00:00:00',8,'ACTIVE','javaTopics','Java History',177);
/*!40000 ALTER TABLE `quiz_trn_tbl` ENABLE KEYS */;


--
-- Definition of table `referral_mst_tbl`
--

DROP TABLE IF EXISTS `referral_mst_tbl`;
CREATE TABLE `referral_mst_tbl` (
  `ID` bigint(20) NOT NULL AUTO_INCREMENT,
  `EMAIL_ID` varchar(255) DEFAULT NULL,
  `MOBILE_NO` varchar(255) DEFAULT NULL,
  `REFERRAL_NAME` varchar(255) DEFAULT NULL,
  `USER_ID` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`ID`),
  KEY `FKB39F54EB37B641D8` (`USER_ID`),
  CONSTRAINT `FKB39F54EB37B641D8` FOREIGN KEY (`USER_ID`) REFERENCES `user_mst_tbl` (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=77 DEFAULT CHARSET=utf8;

--
-- Dumping data for table `referral_mst_tbl`
--

/*!40000 ALTER TABLE `referral_mst_tbl` DISABLE KEYS */;
INSERT INTO `referral_mst_tbl` (`ID`,`EMAIL_ID`,`MOBILE_NO`,`REFERRAL_NAME`,`USER_ID`) VALUES 
 (1,'','','',14),
 (2,'kavyanimmalapudi@gmail.com','8499066145','kavya',14),
 (3,'kavyanimmalapudi@gmail.com','8499066145','kavya',14),
 (4,'kavyanimmalapudi@gmail.com','8499066145','kavya',14),
 (5,'kavyanimmalapudi@gmail.com','8499066145','kavya',14),
 (6,'kavyanimmalapudi@gmail.com','8499066145','kavya',14),
 (7,'yogithanagisetti@gmail.com','9032307868','N.Yogitha',164),
 (8,'','','',164),
 (9,'','','',164),
 (10,'anjana.bandigani@gmail.com','8197899615','Anjana',230),
 (11,'','','',230),
 (12,'','','',230),
 (13,'chitti445@gmil.com','8464949473','chittibabu',258),
 (14,'','','',258),
 (15,'','','',258),
 (16,'','','',258),
 (17,'','','',258),
 (18,'','','',258),
 (19,'','','',258),
 (20,'','','',258),
 (21,'','','',258),
 (22,'ngangadhar319@gmail.com','7893866243','gangadhar',211),
 (23,'','','',211),
 (24,'','','',211),
 (25,'','','',253),
 (26,'','','',253),
 (27,'','','',253),
 (28,'','','',253),
 (29,'','','',253),
 (30,'','','',253),
 (31,'gregerg','9766439869','ggrgg',253),
 (32,'','','',253),
 (33,'ayyappapalivela96@gmail.com','9573649496','sai',253),
 (34,'','','',253),
 (35,'','','',253),
 (36,'rretretret','4553535453','rtrttrt',253),
 (37,'','','',253),
 (38,'','','',253),
 (39,'potulaavinsh@gmail.com','9573649496','avinash',253),
 (40,'','','',253),
 (41,'','','',253),
 (42,'ghhgrtrg','ggfddhh','fgdghgh',253),
 (43,'','','',253),
 (44,'','','',253),
 (45,'ijfdosfoofko','09437897985','djfijdf',253),
 (46,'','','',253),
 (47,'','','',253),
 (48,'','','',253),
 (49,'','','',253),
 (50,'','','',253),
 (51,'','9573649496','sai',253),
 (52,'','','',253),
 (53,'sai','sai','sai',253),
 (54,'','','',253),
 (55,'','','',253),
 (56,'sai','sai','sai',253),
 (57,'','','',253),
 (58,'','','',253),
 (59,'','','sai',253),
 (60,'','','',253),
 (61,'','','',253),
 (62,'','','',253),
 (63,'','','',253),
 (64,'98978564',',HKJGKJGK','HKGHJ@gmail.com',253),
 (65,'','','',253),
 (66,'sai','sai','sai',253),
 (67,'','','',253),
 (68,'','','',253),
 (69,'','','',253),
 (70,'','sai','sai',253),
 (71,'','','',253),
 (72,'','','sai',253),
 (73,'','','',253),
 (74,'','','',253),
 (75,'','','',253),
 (76,'','','',253);
/*!40000 ALTER TABLE `referral_mst_tbl` ENABLE KEYS */;


--
-- Definition of table `role_mst_tbl`
--

DROP TABLE IF EXISTS `role_mst_tbl`;
CREATE TABLE `role_mst_tbl` (
  `ID` bigint(20) NOT NULL AUTO_INCREMENT,
  `ROLE_NAME` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;

--
-- Dumping data for table `role_mst_tbl`
--

/*!40000 ALTER TABLE `role_mst_tbl` DISABLE KEYS */;
INSERT INTO `role_mst_tbl` (`ID`,`ROLE_NAME`) VALUES 
 (1,'Anonymous'),
 (2,'Campus'),
 (3,'Intern'),
 (4,'ClassRoom'),
 (5,'Online'),
 (6,'Interview'),
 (7,'HR'),
 (8,'PO');
/*!40000 ALTER TABLE `role_mst_tbl` ENABLE KEYS */;


--
-- Definition of table `rounds_mst_tbl`
--

DROP TABLE IF EXISTS `rounds_mst_tbl`;
CREATE TABLE `rounds_mst_tbl` (
  `ID` bigint(20) NOT NULL AUTO_INCREMENT,
  `PATTERN_NAME` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

--
-- Dumping data for table `rounds_mst_tbl`
--

/*!40000 ALTER TABLE `rounds_mst_tbl` DISABLE KEYS */;
INSERT INTO `rounds_mst_tbl` (`ID`,`PATTERN_NAME`) VALUES 
 (1,'Quiz'),
 (2,'Coding'),
 (3,'Tasks');
/*!40000 ALTER TABLE `rounds_mst_tbl` ENABLE KEYS */;


--
-- Definition of table `selected_groups_for_interview_tbl`
--

DROP TABLE IF EXISTS `selected_groups_for_interview_tbl`;
CREATE TABLE `selected_groups_for_interview_tbl` (
  `ID` bigint(20) NOT NULL AUTO_INCREMENT,
  `INTERVIEW_ID` bigint(20) DEFAULT NULL,
  `INTERVIEW_GROUP_ID` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`ID`),
  KEY `FK_r149kpdojklrk8wkhfcnkmger` (`INTERVIEW_ID`),
  KEY `FK_1xkgsjgo8uc5eh33we61imnn4` (`INTERVIEW_GROUP_ID`),
  CONSTRAINT `FK_1xkgsjgo8uc5eh33we61imnn4` FOREIGN KEY (`INTERVIEW_GROUP_ID`) REFERENCES `interview_groups_mst_tbl` (`ID`),
  CONSTRAINT `FK_r149kpdojklrk8wkhfcnkmger` FOREIGN KEY (`INTERVIEW_ID`) REFERENCES `interviews_mst_tbl` (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

--
-- Dumping data for table `selected_groups_for_interview_tbl`
--

/*!40000 ALTER TABLE `selected_groups_for_interview_tbl` DISABLE KEYS */;
/*!40000 ALTER TABLE `selected_groups_for_interview_tbl` ENABLE KEYS */;


--
-- Definition of table `shortlisted_profile_tbl`
--

DROP TABLE IF EXISTS `shortlisted_profile_tbl`;
CREATE TABLE `shortlisted_profile_tbl` (
  `ID` bigint(20) NOT NULL AUTO_INCREMENT,
  `EMAIL_ID` varchar(255) DEFAULT NULL,
  `MESSAGE` varchar(255) DEFAULT NULL,
  `MOBILE_NO` varchar(255) DEFAULT NULL,
  `NAME` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `shortlisted_profile_tbl`
--

/*!40000 ALTER TABLE `shortlisted_profile_tbl` DISABLE KEYS */;
/*!40000 ALTER TABLE `shortlisted_profile_tbl` ENABLE KEYS */;


--
-- Definition of table `state_mst_tbl`
--

DROP TABLE IF EXISTS `state_mst_tbl`;
CREATE TABLE `state_mst_tbl` (
  `ID` bigint(20) NOT NULL AUTO_INCREMENT,
  `STATE_NAME` varchar(255) DEFAULT NULL,
  `COUNTRY_ID` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`ID`),
  KEY `FK_ah3uf2ech8chtggo7u9d5dhf0` (`COUNTRY_ID`),
  CONSTRAINT `FK_ah3uf2ech8chtggo7u9d5dhf0` FOREIGN KEY (`COUNTRY_ID`) REFERENCES `country_mst_tbl` (`Id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

--
-- Dumping data for table `state_mst_tbl`
--

/*!40000 ALTER TABLE `state_mst_tbl` DISABLE KEYS */;
INSERT INTO `state_mst_tbl` (`ID`,`STATE_NAME`,`COUNTRY_ID`) VALUES 
 (1,'Karnataka',1),
 (2,'Andrapradesh',1),
 (3,'Maharashtra',1);
/*!40000 ALTER TABLE `state_mst_tbl` ENABLE KEYS */;


--
-- Definition of table `subscriber_tbl`
--

DROP TABLE IF EXISTS `subscriber_tbl`;
CREATE TABLE `subscriber_tbl` (
  `ID` bigint(20) NOT NULL AUTO_INCREMENT,
  `SUBSCRIBER_EMAIL` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8;

--
-- Dumping data for table `subscriber_tbl`
--

/*!40000 ALTER TABLE `subscriber_tbl` DISABLE KEYS */;
INSERT INTO `subscriber_tbl` (`ID`,`SUBSCRIBER_EMAIL`) VALUES 
 (1,'chaitanya.rangam46@gmail.com'),
 (2,'gurramraghunath1995@gmail.com'),
 (3,'Kdhananjaygoud@gmail.com'),
 (4,'polawarsripad@gmail.com'),
 (5,'surya4454@gmail.com'),
 (6,'surya4454@gmail.com'),
 (7,'vinutash123@gmail.com'),
 (8,'shrishailgb123@gmail.com'),
 (9,'prasi0579@gmail.com'),
 (10,'muppanasettiraja@gmail.com'),
 (11,'ayyappapalivela96@gmail.com'),
 (12,'rajumalladi448@gmail.com'),
 (13,'ayyappapalivela96@gmail.com'),
 (14,'lhprsipewipew@gmail.com'),
 (15,'sfkjsdkjsdga@gmail.com');
/*!40000 ALTER TABLE `subscriber_tbl` ENABLE KEYS */;


--
-- Definition of table `support_info_tbl`
--

DROP TABLE IF EXISTS `support_info_tbl`;
CREATE TABLE `support_info_tbl` (
  `ID` bigint(20) NOT NULL AUTO_INCREMENT,
  `DESCRIPTION` varchar(255) DEFAULT NULL,
  `EMAIL_ID` varchar(255) DEFAULT NULL,
  `MOBILE_NO` varchar(255) DEFAULT NULL,
  `NAME` varchar(255) DEFAULT NULL,
  `REQUIRED_TECHNOLOGIES` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;

--
-- Dumping data for table `support_info_tbl`
--

/*!40000 ALTER TABLE `support_info_tbl` DISABLE KEYS */;
INSERT INTO `support_info_tbl` (`ID`,`DESCRIPTION`,`EMAIL_ID`,`MOBILE_NO`,`NAME`,`REQUIRED_TECHNOLOGIES`) VALUES 
 (5,NULL,'subbu53115@gmail.com','9959417894','Siva','Java'),
 (6,'I have 1.5 years of experience as a Network Engineer. I am looking to learn and grow in my career path. Kindly assist me for job opportunity with the above mentioned skill set.','ankurm891@gmail.com','7022811761','Ankur Mishra','C, C ++ , Java, HTML, SQL'),
 (8,NULL,'surya4454@gmail.com','9676087686','Surya Prakash','Java');
/*!40000 ALTER TABLE `support_info_tbl` ENABLE KEYS */;


--
-- Definition of table `task_assign_to_user_trn_tbl`
--

DROP TABLE IF EXISTS `task_assign_to_user_trn_tbl`;
CREATE TABLE `task_assign_to_user_trn_tbl` (
  `ID` bigint(20) NOT NULL AUTO_INCREMENT,
  `TASK_ID` bigint(20) DEFAULT NULL,
  `USER_ID` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`ID`),
  KEY `FK_he6b4vg1bx21ofreyhnew0rm6` (`TASK_ID`),
  KEY `FK_81kxnvscen6eqyx3y9nxxxq0i` (`USER_ID`),
  CONSTRAINT `FK_81kxnvscen6eqyx3y9nxxxq0i` FOREIGN KEY (`USER_ID`) REFERENCES `user_mst_tbl` (`ID`),
  CONSTRAINT `FK_he6b4vg1bx21ofreyhnew0rm6` FOREIGN KEY (`TASK_ID`) REFERENCES `task_mst_tbl` (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `task_assign_to_user_trn_tbl`
--

/*!40000 ALTER TABLE `task_assign_to_user_trn_tbl` DISABLE KEYS */;
/*!40000 ALTER TABLE `task_assign_to_user_trn_tbl` ENABLE KEYS */;


--
-- Definition of table `task_mst_tbl`
--

DROP TABLE IF EXISTS `task_mst_tbl`;
CREATE TABLE `task_mst_tbl` (
  `ID` bigint(20) NOT NULL AUTO_INCREMENT,
  `IMAGE_PATH` varchar(255) DEFAULT NULL,
  `OBJECTIVE` varchar(255) DEFAULT NULL,
  `QUESTION_DES` varchar(255) DEFAULT NULL,
  `QUESTION` varchar(255) DEFAULT NULL,
  `REFFERENCE_LINK` varchar(255) DEFAULT NULL,
  `SHORT_NAME` varchar(255) DEFAULT NULL,
  `TECHNOLOGY` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

--
-- Dumping data for table `task_mst_tbl`
--

/*!40000 ALTER TABLE `task_mst_tbl` DISABLE KEYS */;
INSERT INTO `task_mst_tbl` (`ID`,`IMAGE_PATH`,`OBJECTIVE`,`QUESTION_DES`,`QUESTION`,`REFFERENCE_LINK`,`SHORT_NAME`,`TECHNOLOGY`) VALUES 
 (3,'Datatables-1/png@@Datatables-2/png','As a developer i should be able to create any Data Table with proper look and feel.','In web design tables are a good way to organize data into a tabular form. When we want to show a list of data we use this. Please find below sample data tables to develop and upload after implentation done.','Creating Data Tables','htmlTopics','Tables','UI'),
 (4,'menu-1/png@@menu-2/jpg','As a developer i should be able to create Menus and Submenus with proper look and feel.','To classify and origanize the data in web application we use menus.Please find below sample menus to develop and upload after implentation done.','Creating Menus','htmlTopics','Menus','UI');
/*!40000 ALTER TABLE `task_mst_tbl` ENABLE KEYS */;


--
-- Definition of table `technologies_mst_tbl`
--

DROP TABLE IF EXISTS `technologies_mst_tbl`;
CREATE TABLE `technologies_mst_tbl` (
  `ID` bigint(20) NOT NULL AUTO_INCREMENT,
  `TECHNOLOGY_NAME` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;

--
-- Dumping data for table `technologies_mst_tbl`
--

/*!40000 ALTER TABLE `technologies_mst_tbl` DISABLE KEYS */;
INSERT INTO `technologies_mst_tbl` (`ID`,`TECHNOLOGY_NAME`) VALUES 
 (1,'JAVA'),
 (2,'HTML'),
 (3,'CSS'),
 (4,'script'),
 (5,'ANGULARJS'),
 (6,'JDBC'),
 (7,'SQL');
/*!40000 ALTER TABLE `technologies_mst_tbl` ENABLE KEYS */;


--
-- Definition of table `university_mst_tbl`
--

DROP TABLE IF EXISTS `university_mst_tbl`;
CREATE TABLE `university_mst_tbl` (
  `ID` bigint(20) NOT NULL AUTO_INCREMENT,
  `UNIVERSITY_NAME` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;

--
-- Dumping data for table `university_mst_tbl`
--

/*!40000 ALTER TABLE `university_mst_tbl` DISABLE KEYS */;
INSERT INTO `university_mst_tbl` (`ID`,`UNIVERSITY_NAME`) VALUES 
 (1,'SV university'),
 (2,'Anna university'),
 (3,'SRM university'),
 (4,'Bangalore University'),
 (5,'Jain University'),
 (6,'PES university'),
 (7,'Delhi university'),
 (8,'IIT'),
 (9,'Jain university'),
 (10,'JNTU');
/*!40000 ALTER TABLE `university_mst_tbl` ENABLE KEYS */;


--
-- Definition of table `uploaded_task_files_tbl`
--

DROP TABLE IF EXISTS `uploaded_task_files_tbl`;
CREATE TABLE `uploaded_task_files_tbl` (
  `ID` bigint(20) NOT NULL AUTO_INCREMENT,
  `FILE_NAME` varchar(255) DEFAULT NULL,
  `TASK_ID` bigint(20) DEFAULT NULL,
  `INTERVIEWS_ID` bigint(20) DEFAULT NULL,
  `USER_ID` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`ID`),
  KEY `FK_72j6wgak3mjgy9524767bghh0` (`TASK_ID`),
  KEY `FK_8s1e9uq683d82ou8tr794wkw6` (`INTERVIEWS_ID`),
  KEY `FK_b8bho2ieyxgev037kth29e87q` (`USER_ID`),
  CONSTRAINT `FK_b8bho2ieyxgev037kth29e87q` FOREIGN KEY (`USER_ID`) REFERENCES `user_mst_tbl` (`ID`),
  CONSTRAINT `FK_72j6wgak3mjgy9524767bghh0` FOREIGN KEY (`TASK_ID`) REFERENCES `task_mst_tbl` (`ID`),
  CONSTRAINT `FK_8s1e9uq683d82ou8tr794wkw6` FOREIGN KEY (`INTERVIEWS_ID`) REFERENCES `interviews_mst_tbl` (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `uploaded_task_files_tbl`
--

/*!40000 ALTER TABLE `uploaded_task_files_tbl` DISABLE KEYS */;
/*!40000 ALTER TABLE `uploaded_task_files_tbl` ENABLE KEYS */;


--
-- Definition of table `user_addresses_tbl`
--

DROP TABLE IF EXISTS `user_addresses_tbl`;
CREATE TABLE `user_addresses_tbl` (
  `ID` bigint(20) NOT NULL AUTO_INCREMENT,
  `ADDRESS` varchar(255) DEFAULT NULL,
  `PINCODE` varchar(255) DEFAULT NULL,
  `CITY_ID` bigint(20) DEFAULT NULL,
  `COUNTRY_ID` bigint(20) DEFAULT NULL,
  `STATE_ID` bigint(20) DEFAULT NULL,
  `USER_ID` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`ID`),
  KEY `FK_pfheikfowompeep3xps8oinhj` (`CITY_ID`),
  KEY `FK_sbcj9a4ekhi92t5jb8ewfrms1` (`COUNTRY_ID`),
  KEY `FK_df5ib42g11ar3kfcfkdc5m50a` (`STATE_ID`),
  KEY `FK_h7nyd95koyxw77ei710a2kmlg` (`USER_ID`),
  CONSTRAINT `FK_df5ib42g11ar3kfcfkdc5m50a` FOREIGN KEY (`STATE_ID`) REFERENCES `state_mst_tbl` (`ID`),
  CONSTRAINT `FK_h7nyd95koyxw77ei710a2kmlg` FOREIGN KEY (`USER_ID`) REFERENCES `user_mst_tbl` (`ID`),
  CONSTRAINT `FK_pfheikfowompeep3xps8oinhj` FOREIGN KEY (`CITY_ID`) REFERENCES `city_mst_tbl` (`ID`),
  CONSTRAINT `FK_sbcj9a4ekhi92t5jb8ewfrms1` FOREIGN KEY (`COUNTRY_ID`) REFERENCES `country_mst_tbl` (`Id`)
) ENGINE=InnoDB AUTO_INCREMENT=252 DEFAULT CHARSET=utf8;

--
-- Dumping data for table `user_addresses_tbl`
--

/*!40000 ALTER TABLE `user_addresses_tbl` DISABLE KEYS */;
INSERT INTO `user_addresses_tbl` (`ID`,`ADDRESS`,`PINCODE`,`CITY_ID`,`COUNTRY_ID`,`STATE_ID`,`USER_ID`) VALUES 
 (1,'','',NULL,NULL,NULL,1),
 (2,'#3,202,sriranga nilayam,19th main,tavarkare road,btm 1st stage,bangalore.','560068',NULL,NULL,NULL,2),
 (3,'near Maharastra Bank ATM, jayadava circle BTM 2nd stage','560076',NULL,NULL,NULL,6),
 (4,'','',NULL,NULL,NULL,8),
 (5,'','',NULL,NULL,NULL,9),
 (6,'','',NULL,NULL,NULL,10),
 (7,'','',NULL,NULL,NULL,11),
 (8,'','',NULL,NULL,NULL,12),
 (9,'','',NULL,NULL,NULL,13),
 (10,'','',NULL,NULL,NULL,14),
 (11,'CHURCH STREET, MURUGESHPALYA,\nOLD AIRPORT ROAD, BANGALORE\nPIN-560017','560017',NULL,NULL,NULL,16),
 (12,'1st Stage, \nBTM Layout, \nNear Gangotri Circle,','560068',NULL,NULL,NULL,17),
 (13,'','',NULL,NULL,NULL,19),
 (14,'dub','534112',NULL,NULL,NULL,20),
 (15,'','',NULL,NULL,NULL,21),
 (16,'Jai Bheema Nagar','560068',NULL,NULL,NULL,22),
 (17,'','',NULL,NULL,NULL,23),
 (18,'89,Maruthi Nilaya,opp.Milan Bakery,Btm layout,Bangalore','560001',NULL,NULL,NULL,24),
 (19,'','',NULL,NULL,NULL,25),
 (20,'','',NULL,NULL,NULL,26),
 (21,'','',NULL,NULL,NULL,27),
 (22,'','',NULL,NULL,NULL,29),
 (23,'110, 2nd floor, 8th main, VR layout, mathikere, Bangalore','560054',NULL,NULL,NULL,30),
 (24,'Ganesh PG Vibhutipura extension , Doddankundi','560037',NULL,NULL,NULL,31),
 (25,'Flat No. 97.2nd cross Ist stage 20th main BTM Bangalore.','560068',NULL,NULL,NULL,33),
 (26,'Krishna Reddy Building, Jaraganahalli , Beside HM apartment\nJP Nagar 6th phase, Kanakapura Road .','560078',3,1,2,34),
 (27,'#1,Ragavendra Complex, Maruthi nagar, Btm 1st stage,\nBanglore.','523212',NULL,NULL,NULL,35),
 (28,'sri sai ram ladies pg,near mahindrashoroom,multiplex oppt,munikollala,bangalore-37','560072',NULL,NULL,NULL,36),
 (29,'Marathaali Bangalore.\npin-560037','560037',NULL,NULL,NULL,37),
 (30,'107,swamy pg,ngr layout,roopena agrahara','560068',NULL,NULL,NULL,39),
 (31,'srinivas pg, 9th cross btm layout 1st stage , 16th main road Bangalore. 560029.','560029',NULL,NULL,NULL,40),
 (32,'marthahalli','560037',NULL,NULL,NULL,41),
 (33,'21/2,8th cr,anepalya adugodi post','560030',NULL,NULL,NULL,42),
 (34,'Somu k c/o puttegowda\nBabanna layout ,near Vegetable market,\nmallasandra\nBangalure','',NULL,NULL,NULL,43),
 (35,'','',NULL,NULL,NULL,44),
 (36,'','',NULL,NULL,NULL,45),
 (37,'Bangalore','5600038',NULL,NULL,NULL,47),
 (38,'madivala,bangalore-560068','560068',NULL,NULL,NULL,48),
 (39,'19th main road, 28th cross, 2nd block, Rajajinagar','560010',NULL,NULL,NULL,49),
 (40,'','',NULL,NULL,NULL,50),
 (41,'Friends PG rajajijnagar 2nd block 19th main,28th cross','560010',NULL,NULL,NULL,51),
 (42,'#53,BTM 2stage,tavarekere,near madhurama temple','560029',NULL,NULL,NULL,52),
 (43,'#42,saravati layout,1st cross,Bhattarthalli,Bangalore','560049',NULL,NULL,NULL,53),
 (44,'sri jp comforts pg for ladies,#7,near biryanio zone,maruthalli.','520038',NULL,NULL,NULL,54),
 (45,'sri jp comforts pg for ladies,#7,near biryanio zone,maruthalli.','520038',NULL,NULL,NULL,55),
 (46,'#19th,9th main,6th cross,R K Layout,1st stage ,padmanabhanagar','560060',NULL,NULL,NULL,56),
 (47,'Om Sai PG, Opposite to innovative multiplex, Mahindra Service Road, Marathahalli','53007',NULL,NULL,NULL,57),
 (48,'BTM 2ND STAGE #129 TRINITY BHAWAN 4TH FLOOR AMBEDKAR ROAD','560076',NULL,NULL,NULL,58),
 (49,'','',NULL,NULL,NULL,59),
 (50,'bangalore','56000068',NULL,NULL,NULL,60),
 (51,'vishnu balaji PG\nAswath nagar\nmarathahalli,Bangalore 560037','560037',NULL,NULL,NULL,63),
 (52,'','',NULL,NULL,NULL,64),
 (53,'btm 2nd stage,bangalore,karnataka','560076',NULL,NULL,NULL,65),
 (54,'','',NULL,NULL,NULL,66),
 (55,'','',NULL,NULL,NULL,67),
 (56,'','',NULL,NULL,NULL,68),
 (57,'Sri j.p ladies hostel,marthali','560001',NULL,NULL,NULL,69),
 (58,'BTM Layout\nBangalore','560068',NULL,NULL,NULL,70),
 (59,'','',NULL,NULL,NULL,71),
 (60,'star pg, \n13 cross, 29th main road\nbtm layout 1','560026',NULL,NULL,NULL,72),
 (61,'#9/3 NarayanaMurthi layout opp to kaveri complex near Shanimahathma temple  Road  anekal','562106',NULL,NULL,NULL,73),
 (62,'','560097',NULL,NULL,NULL,74),
 (63,'comfort pg for boys 27th main ejipura bangalore','585105',NULL,NULL,NULL,75),
 (64,'','',NULL,NULL,NULL,76),
 (65,'marathalli bridge, Bangalore','560001',NULL,NULL,NULL,77),
 (66,'Bommanahalli,Hosur Road','560068',NULL,NULL,NULL,78),
 (67,'','',NULL,NULL,NULL,79),
 (68,'sri jp comforts, vivekananda layout, maratahalli, bangalore.','',NULL,NULL,NULL,80),
 (69,'BTM mico layout\nKEB colony BTM 1 st stage','',NULL,NULL,NULL,81),
 (70,'Life Style pg ,near Gangotri Circle ,Maruthi nagar Main road,btm 1st stage','560029',NULL,NULL,NULL,82),
 (71,'','',NULL,NULL,NULL,83),
 (72,'KORMANGALA','',NULL,NULL,NULL,84),
 (73,'#14/2 byraweshwara nilaya near st.micheal school road','560013',NULL,NULL,NULL,85),
 (74,'Kormangala 4th block','560047',NULL,NULL,NULL,86),
 (75,'btm 1st satge, 9th main,redyys boys hostel ,bengalore','',NULL,NULL,NULL,87),
 (76,'bangalore/karnataka','',NULL,NULL,NULL,88),
 (77,'Sai ram pg hostel,Tawarkere road','',NULL,NULL,NULL,89),
 (78,'Rudrayya swamy s/o Siddayya swamy Matapathi vijayanagara','560040',NULL,NULL,NULL,90),
 (79,'Thavarekere Main Road, Chikkadugodi','560029',NULL,NULL,NULL,91),
 (80,'','',NULL,NULL,NULL,92),
 (81,'Sairam delux pg, BTM 2nd stage,near to maharaja departmental, NS Palya, Bangalore.','',NULL,NULL,NULL,93),
 (82,'','',NULL,NULL,NULL,94),
 (83,'9th cross maruthi nagar, madiwala , bangalore','',NULL,NULL,NULL,95),
 (84,'','',NULL,NULL,NULL,96),
 (85,'Rnsit College boys hostel 1\nchhansanndra bangalore','5600098',NULL,NULL,NULL,97),
 (86,'Shri Balaji PG, 17th main , BTM layout 2nd stage, 560076','560076',NULL,NULL,NULL,98),
 (87,'#171, BDA Layout, JP Nagar 8th phase, Bangalore 560076.','560076',NULL,NULL,NULL,99),
 (88,'#171, BDA Layout, JP Nagar 8th phase, Bangalore 560076.','560076',NULL,NULL,NULL,100),
 (89,'','',NULL,NULL,NULL,101),
 (90,'Sandhya PG Domlur, Bengaluru (Karnataka)','',NULL,NULL,NULL,102),
 (91,'Bangalore','560068',NULL,NULL,NULL,103),
 (92,'','',NULL,NULL,NULL,104),
 (93,'','',NULL,NULL,NULL,105),
 (94,'concorde tech turf,door no A004,SHIKARIPALAYA road,electronic city','560100',NULL,NULL,NULL,106),
 (95,'banasankari','560085',NULL,NULL,NULL,107),
 (96,'bangloar','560001',NULL,NULL,NULL,108),
 (97,'banglore','560001',NULL,NULL,NULL,109),
 (98,'','',NULL,NULL,NULL,110),
 (99,'','',NULL,NULL,NULL,111),
 (100,'Rammurthy nagara ,bngalore','560016',NULL,NULL,NULL,112),
 (101,'bangalore','',NULL,NULL,NULL,113),
 (102,'#92, Ravindra Bulding, 2nd Cross, Hosur Road, Banglore','560068',NULL,NULL,NULL,115),
 (103,'#92, Ravindra Bulding, 2nd Cross, Hosur Road, Banglore','560068',NULL,NULL,NULL,116),
 (104,'','',NULL,NULL,NULL,117),
 (105,'','',NULL,NULL,NULL,118),
 (106,'#429, 1st Floor,B.T.M. 2nd Stage,7th Cross, 7th Main. Bangalore 560078','560078',NULL,NULL,NULL,119),
 (107,'','',NULL,NULL,NULL,120),
 (108,'','',NULL,NULL,NULL,121),
 (109,'2nd stage ,btm latyout','560076',NULL,NULL,NULL,122),
 (110,'2nd stage ,btm latyout','560076',NULL,NULL,NULL,123),
 (111,'2nd stage ,btm latyout','560076',NULL,NULL,NULL,124),
 (112,'Punjabi PG\nH -16','560029',NULL,NULL,NULL,125),
 (113,'RT Nagar, HMT Layout,Bangalore,Karnataka-560032','560032',NULL,NULL,NULL,126),
 (114,'','',NULL,NULL,NULL,127),
 (115,'','',NULL,NULL,NULL,128),
 (116,'','',NULL,NULL,NULL,129),
 (117,'','',NULL,NULL,NULL,130),
 (118,'HN-13, 2nd Cross, KEB Road, Jai Bheem Nagar, BTM Stage 1','560068',NULL,NULL,NULL,132),
 (119,'17th D main,3rd Block ,4th stage,basaveshwar nagar,','560079',NULL,NULL,NULL,133),
 (120,'','',NULL,NULL,NULL,134),
 (121,'M.V.Rajupalem (vill),Karlapalem(m.d),Guntur(D.t),Ap-522111','522111',NULL,NULL,NULL,135),
 (122,'M.V.Rajupalem (vill),Karlapalem(m.d),Guntur(D.t),Ap-522111','522111',NULL,NULL,NULL,136),
 (123,'','',NULL,NULL,NULL,137),
 (124,'#32,Papaiah Street Mavalli,Bangalore 560004','560004',NULL,NULL,NULL,138),
 (125,'','',NULL,NULL,NULL,139),
 (126,'#135 4th main 6th cross lakshiminarayanpuram srirampuram bangalore','580021',NULL,NULL,NULL,140),
 (127,'1st main 3rd phase manjunath nagar','560026',NULL,NULL,NULL,141),
 (128,'','',NULL,NULL,NULL,142),
 (129,'#12, Giddamma Nilaya,Janbusavari Dinne,Jp nagar 8th phase,Bangalore-560076\nLandmark: opp to Jeevalaya church','560076',NULL,NULL,NULL,144),
 (130,'8TH LANE, SR NAGAR','500038',NULL,NULL,NULL,145),
 (131,'','',NULL,NULL,NULL,146),
 (132,'','',NULL,NULL,NULL,150),
 (133,'','',NULL,NULL,NULL,151),
 (134,'','',NULL,NULL,NULL,152),
 (135,'','',NULL,NULL,NULL,153),
 (136,'BTM LAYOUT','560068',NULL,NULL,NULL,154),
 (137,'302,Eternity Serene Apartment ,Kaveri Nagar,bommanahalli,Bangalorre','560068',NULL,NULL,NULL,155),
 (138,'','',NULL,NULL,NULL,156),
 (139,'','',NULL,NULL,NULL,157),
 (140,'','',NULL,NULL,NULL,160),
 (141,'','',NULL,NULL,NULL,161),
 (142,'','',NULL,NULL,NULL,162),
 (143,'balakampet','500016',NULL,NULL,NULL,163),
 (144,'','',NULL,NULL,NULL,164),
 (145,'','',NULL,NULL,NULL,165),
 (146,'','',NULL,NULL,NULL,166),
 (147,'Flat.no-102,Anjaiah nagar, Gachibowli,Hyderabad','500081',NULL,NULL,NULL,167),
 (148,'','',NULL,NULL,NULL,168),
 (149,'3-11-363 Shiva Ganga Colony, opp Kmineni lb nagar\nhyderabad near narayana school','500074',NULL,NULL,NULL,169),
 (150,'','',NULL,NULL,NULL,170),
 (151,'yousufguda,hyderabad','500045',NULL,NULL,NULL,171),
 (152,'','',NULL,NULL,NULL,172),
 (153,'','',NULL,NULL,NULL,173),
 (154,'','',NULL,NULL,NULL,174),
 (155,'','',NULL,NULL,NULL,176),
 (156,'','',NULL,NULL,NULL,177),
 (157,'','',NULL,NULL,NULL,179),
 (158,'','',NULL,NULL,NULL,180),
 (159,'','',NULL,NULL,NULL,181),
 (160,'','',NULL,NULL,NULL,182),
 (161,'','',NULL,NULL,NULL,184),
 (162,'','',NULL,NULL,NULL,185),
 (163,'','',NULL,NULL,NULL,186),
 (164,'','',NULL,NULL,NULL,187),
 (165,'','',NULL,NULL,NULL,188),
 (166,'','',NULL,NULL,NULL,189),
 (167,'','',NULL,NULL,NULL,190),
 (168,'','',NULL,NULL,NULL,191),
 (169,'','',NULL,NULL,NULL,192),
 (170,'','',NULL,NULL,NULL,193),
 (171,'','',NULL,NULL,NULL,194),
 (172,'','',NULL,NULL,NULL,195),
 (173,'','',NULL,NULL,NULL,196),
 (174,'','',NULL,NULL,NULL,197),
 (175,'Bapu Nagar,SR Nagar,Hyderabad.','',NULL,NULL,NULL,198),
 (176,'','',NULL,NULL,NULL,199),
 (177,'','',NULL,NULL,NULL,200),
 (178,'','',NULL,NULL,NULL,201),
 (179,'','',NULL,NULL,NULL,202),
 (180,'Vinayaka Boys Hostel , Bapu Nagar, SR Nagar , Hyderabad, Telagana','500038',NULL,NULL,NULL,203),
 (181,'','',NULL,NULL,NULL,204),
 (182,'','',NULL,NULL,NULL,205),
 (183,'Machavaram, Ponnur(md), Guntur(dt).','522315',NULL,NULL,NULL,206),
 (184,'','',NULL,NULL,NULL,207),
 (185,'','',NULL,NULL,NULL,208),
 (186,'Nea Umesh Chandra Statue, SR NAGAR','500038',NULL,NULL,NULL,209),
 (187,'','',NULL,NULL,NULL,210),
 (188,'BTM layout 1st stage,\nBangalore','560068',NULL,NULL,NULL,211),
 (189,'639 Nandana, Bhel Layout, extn layout, near panchamukhi palace rr nagar','560098',NULL,NULL,NULL,212),
 (190,'','',NULL,NULL,NULL,213),
 (191,'','',NULL,NULL,NULL,214),
 (192,'','',NULL,NULL,NULL,215),
 (193,'','',NULL,NULL,NULL,216),
 (194,'','',NULL,NULL,NULL,217),
 (195,'','',NULL,NULL,NULL,218),
 (196,'','',NULL,NULL,NULL,219),
 (197,'','',NULL,NULL,NULL,220),
 (198,'','',NULL,NULL,NULL,221),
 (199,'','',NULL,NULL,NULL,222),
 (200,'','',NULL,NULL,NULL,223),
 (201,'','',NULL,NULL,NULL,224),
 (202,'','',NULL,NULL,NULL,225),
 (203,'','',NULL,NULL,NULL,226),
 (204,'','',NULL,NULL,NULL,227),
 (205,'8-2-36, Pratap Nagar, Sri Nagar Colony Main Road','500082',NULL,NULL,NULL,228),
 (206,'','',NULL,NULL,NULL,229),
 (207,'Veena Baskar PG,\n34th cross 2nd Blobk Juganahalli Rajaji anagar','560010',NULL,NULL,NULL,230),
 (208,'','',NULL,NULL,NULL,231),
 (209,'','',NULL,NULL,NULL,232),
 (210,'','',NULL,NULL,NULL,233),
 (211,'','',NULL,NULL,NULL,234),
 (212,'','',NULL,NULL,NULL,235),
 (213,'','',NULL,NULL,NULL,236),
 (214,'old temple land hudco','635109',NULL,NULL,NULL,237),
 (215,'','',NULL,NULL,NULL,238),
 (216,'','',NULL,NULL,NULL,239),
 (217,'','',NULL,NULL,NULL,240),
 (218,'','',NULL,NULL,NULL,241),
 (219,'','',NULL,NULL,NULL,242),
 (220,'','',NULL,NULL,NULL,243),
 (221,'kjkj','',NULL,NULL,NULL,244),
 (222,'','',NULL,NULL,NULL,245),
 (223,'','',NULL,NULL,NULL,246),
 (224,'','',NULL,NULL,NULL,247),
 (225,'','',NULL,NULL,NULL,248),
 (226,'','',NULL,NULL,NULL,249),
 (227,'','',NULL,NULL,NULL,250),
 (228,'','',NULL,NULL,NULL,251),
 (229,'','',NULL,NULL,NULL,252),
 (230,'','',NULL,NULL,NULL,253),
 (231,'','',NULL,NULL,NULL,254),
 (232,'','',NULL,NULL,NULL,255),
 (233,'','',NULL,NULL,NULL,256),
 (234,'','',NULL,NULL,NULL,257),
 (235,'btm 1st stage,','560068.',NULL,NULL,NULL,258),
 (236,'','',NULL,NULL,NULL,259),
 (237,'','',NULL,NULL,NULL,260),
 (238,'','',NULL,NULL,NULL,261),
 (239,'','',NULL,NULL,NULL,262),
 (240,'','',NULL,NULL,NULL,263),
 (241,'','',NULL,NULL,NULL,264),
 (242,'','',NULL,NULL,NULL,265),
 (243,'','',NULL,NULL,NULL,266),
 (244,'','',NULL,NULL,NULL,267),
 (245,'','',NULL,NULL,NULL,268),
 (246,'','',NULL,NULL,NULL,269),
 (247,'','',NULL,NULL,NULL,270),
 (248,'','',NULL,NULL,NULL,271),
 (249,'','',NULL,NULL,NULL,272),
 (250,'Testing','560078',1,1,1,275),
 (251,'testing address','560068',2,1,1,518);
/*!40000 ALTER TABLE `user_addresses_tbl` ENABLE KEYS */;


--
-- Definition of table `user_basic_profileinfo_tbl`
--

DROP TABLE IF EXISTS `user_basic_profileinfo_tbl`;
CREATE TABLE `user_basic_profileinfo_tbl` (
  `ID` bigint(20) NOT NULL AUTO_INCREMENT,
  `DATE_OF_BIRTH` datetime DEFAULT NULL,
  `HIGHER_EDUCATION_LEVEL` varchar(255) DEFAULT NULL,
  `PROFILE_SUMMARY` varchar(255) DEFAULT NULL,
  `RESUME_PATH` varchar(255) DEFAULT NULL,
  `VEDIO_PATH` varchar(255) DEFAULT NULL,
  `USER_ID` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`ID`),
  KEY `FK_mwrhsqc5sr59j1833rthyi5lt` (`USER_ID`),
  CONSTRAINT `FK_mwrhsqc5sr59j1833rthyi5lt` FOREIGN KEY (`USER_ID`) REFERENCES `user_mst_tbl` (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=55 DEFAULT CHARSET=utf8;

--
-- Dumping data for table `user_basic_profileinfo_tbl`
--

/*!40000 ALTER TABLE `user_basic_profileinfo_tbl` DISABLE KEYS */;
INSERT INTO `user_basic_profileinfo_tbl` (`ID`,`DATE_OF_BIRTH`,`HIGHER_EDUCATION_LEVEL`,`PROFILE_SUMMARY`,`RESUME_PATH`,`VEDIO_PATH`,`USER_ID`) VALUES 
 (1,'1993-10-10 00:00:00',NULL,'My Name is Siva Kumar from Ananthapur of Andhrapradesh. I have graduated from SKD affliated to JNTU Ananthpur','sudhakar.docx',NULL,115),
 (3,'1991-03-06 00:00:00',NULL,NULL,NULL,NULL,121),
 (4,'1992-12-19 00:00:00',NULL,'Working as a Jr. Software Engineer in IDS Next Business Solution Pvt Ltd.',NULL,NULL,126),
 (5,'1996-06-07 00:00:00',NULL,NULL,'org resume.docx',NULL,128),
 (7,'1995-02-28 00:00:00',NULL,NULL,NULL,NULL,132),
 (8,'1993-12-22 00:00:00',NULL,NULL,NULL,NULL,133),
 (9,'1991-08-13 00:00:00',NULL,'Mtech Fresher graduated from Ramaiah University of Applied Sciences in 2016 looking for job in software development, web application development and mobile application development',NULL,NULL,138),
 (10,'1994-03-08 00:00:00',NULL,NULL,NULL,NULL,135),
 (11,'1992-08-25 00:00:00',NULL,'Chetan HS completed MCA at Dr.Ait college bangalore ....looking my carrer in IT industry.',NULL,NULL,140),
 (12,NULL,NULL,'llkjh;lkjhljhlkjhlkj',NULL,NULL,20),
 (13,'1993-06-10 00:00:00',NULL,NULL,NULL,NULL,144),
 (15,'1995-04-11 00:00:00',NULL,NULL,NULL,NULL,154),
 (16,NULL,NULL,NULL,NULL,NULL,129),
 (17,'1995-02-13 00:00:00',NULL,NULL,'sridhar-resume.pdf',NULL,157),
 (18,'1995-02-13 00:00:00',NULL,NULL,'sridhar-resume.pdf',NULL,157),
 (19,NULL,NULL,NULL,NULL,NULL,165),
 (20,'1994-05-30 00:00:00',NULL,NULL,NULL,NULL,184),
 (21,NULL,NULL,NULL,NULL,NULL,187),
 (22,NULL,NULL,NULL,NULL,NULL,187),
 (23,NULL,NULL,NULL,NULL,NULL,187),
 (24,'1996-08-29 00:00:00',NULL,NULL,NULL,NULL,181),
 (25,'1996-08-29 00:00:00',NULL,NULL,NULL,NULL,181),
 (26,'2017-06-27 00:00:00',NULL,NULL,NULL,NULL,195),
 (27,'1994-09-23 00:00:00',NULL,NULL,NULL,NULL,204),
 (28,'1994-09-23 00:00:00',NULL,NULL,NULL,NULL,204),
 (29,'1992-10-28 00:00:00',NULL,NULL,NULL,NULL,218),
 (30,NULL,NULL,'C,CORE JAVA,ADVANCE JAVA,BIG DATA',NULL,NULL,221),
 (31,'1991-09-22 00:00:00',NULL,'good knowledge on C programming and in embedded software','sai resume.doc',NULL,227),
 (32,'1995-08-17 00:00:00',NULL,'I completed my B.Tech in the stream of computer science and engineering.I am trained in Java Technologies Servlet, JSP, JDBC','Venkatesh Resume.pdf',NULL,228),
 (33,'1990-01-01 00:00:00',NULL,NULL,NULL,NULL,232),
 (34,'1990-01-01 00:00:00',NULL,NULL,NULL,NULL,232),
 (35,'1990-01-01 00:00:00',NULL,NULL,NULL,NULL,232),
 (36,'1996-06-08 00:00:00',NULL,'I am very responsible towards the work. I am interested towards IT sector.','bindu (2).pdf',NULL,206),
 (37,'1991-06-01 00:00:00',NULL,NULL,'Seema_Fresher_2016_Java_Course (1).pdf',NULL,230),
 (38,'1992-06-01 00:00:00',NULL,NULL,'KAVITHA_M.E_2015.docx',NULL,237),
 (39,'1992-01-01 00:00:00',NULL,NULL,'Shrishail Badrappagol-Resume.pdf',NULL,247),
 (40,'1970-01-01 00:00:00',NULL,'93039292','aaaa.html','aaaccc.htm',253),
 (41,'1996-01-03 00:00:00',NULL,NULL,NULL,NULL,255),
 (48,'1994-02-15 00:00:00',NULL,'software developer','Resume.docx','selfIntroductionVedio.mp4',34),
 (49,'1996-08-22 00:00:00',NULL,'Java fresher',NULL,NULL,211),
 (50,'1995-01-07 00:00:00',NULL,NULL,NULL,NULL,258),
 (51,'1995-07-26 00:00:00',NULL,'Am persuing a responsible and challenging career in the field of software,add value in my own way to the organisation with the help of my knowledge and skills and grow professionally.','mythily update profile1.docx',NULL,261),
 (52,'1991-11-19 00:00:00',NULL,NULL,'PHP_RESUME_YUVARAJ.docx',NULL,271),
 (53,'1994-02-15 00:00:00',NULL,'software developer','Resume.docx','selfIntroductionVedio.mp4',275),
 (54,'2017-09-06 00:00:00',NULL,'softwaredeveloper','Resume.docx','selfIntroductionVedio.mp4',518);
/*!40000 ALTER TABLE `user_basic_profileinfo_tbl` ENABLE KEYS */;


--
-- Definition of table `user_basic_skills_tbl`
--

DROP TABLE IF EXISTS `user_basic_skills_tbl`;
CREATE TABLE `user_basic_skills_tbl` (
  `ID` bigint(20) NOT NULL AUTO_INCREMENT,
  `ANALYTICAL_RATING` bigint(20) DEFAULT NULL,
  `COMMUNICATION_RATING` bigint(20) DEFAULT NULL,
  `USER_ID` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`ID`),
  KEY `FK_eercq162xl67yk8ppd9dnrk36` (`USER_ID`),
  CONSTRAINT `FK_eercq162xl67yk8ppd9dnrk36` FOREIGN KEY (`USER_ID`) REFERENCES `user_mst_tbl` (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=93 DEFAULT CHARSET=utf8;

--
-- Dumping data for table `user_basic_skills_tbl`
--

/*!40000 ALTER TABLE `user_basic_skills_tbl` DISABLE KEYS */;
INSERT INTO `user_basic_skills_tbl` (`ID`,`ANALYTICAL_RATING`,`COMMUNICATION_RATING`,`USER_ID`) VALUES 
 (1,0,0,33),
 (2,8,9,34),
 (3,0,0,35),
 (4,0,0,37),
 (5,0,0,36),
 (6,0,0,39),
 (7,0,0,40),
 (8,0,0,41),
 (9,0,0,42),
 (10,0,0,43),
 (11,0,0,30),
 (12,0,0,48),
 (13,0,0,49),
 (14,0,0,51),
 (15,0,0,50),
 (16,0,0,52),
 (17,0,0,55),
 (18,0,0,54),
 (19,0,0,57),
 (20,0,0,58),
 (21,0,0,60),
 (22,0,0,63),
 (23,0,0,65),
 (24,0,0,70),
 (25,0,0,73),
 (26,0,0,74),
 (27,0,0,75),
 (28,0,0,76),
 (29,0,0,77),
 (30,0,0,78),
 (31,0,0,24),
 (32,0,0,81),
 (33,0,0,82),
 (34,0,0,84),
 (35,0,0,85),
 (36,0,0,86),
 (37,0,0,88),
 (38,0,0,89),
 (39,0,0,90),
 (40,0,0,91),
 (41,0,0,93),
 (42,0,0,94),
 (43,0,0,96),
 (44,0,0,98),
 (45,0,0,99),
 (46,0,0,100),
 (47,0,0,103),
 (48,0,0,106),
 (49,0,0,108),
 (50,0,0,109),
 (51,0,0,112),
 (52,7,7,115),
 (53,7,8,116),
 (54,8,7,119),
 (55,7,7,121),
 (56,0,0,122),
 (57,0,0,123),
 (58,7,7,125),
 (59,0,0,124),
 (60,8,9,126),
 (61,0,0,132),
 (62,0,0,136),
 (63,0,0,138),
 (64,0,0,140),
 (65,0,6,135),
 (66,8,9,141),
 (67,0,0,144),
 (68,0,0,144),
 (69,7,8,145),
 (70,8,7,154),
 (71,7,7,129),
 (72,7,7,155),
 (73,8,7,163),
 (74,9,9,167),
 (75,8,6,169),
 (76,6,6,171),
 (77,9,8,177),
 (78,0,0,198),
 (79,9,7,209),
 (80,7,7,212),
 (81,8,8,203),
 (82,9,8,228),
 (83,5,6,206),
 (84,7,7,230),
 (85,0,3,14),
 (86,8,9,246),
 (87,8,8,237),
 (88,6,10,253),
 (89,3,3,244),
 (90,8,8,211),
 (91,8,6,258),
 (92,8,10,275);
/*!40000 ALTER TABLE `user_basic_skills_tbl` ENABLE KEYS */;


--
-- Definition of table `user_educations_tbl`
--

DROP TABLE IF EXISTS `user_educations_tbl`;
CREATE TABLE `user_educations_tbl` (
  `ID` bigint(20) NOT NULL AUTO_INCREMENT,
  `BRANCH_NAME` varchar(255) DEFAULT NULL,
  `EDUCATION_TYPE` varchar(255) DEFAULT NULL,
  `PERCENTAGE` float DEFAULT NULL,
  `YEAR_OF_PASSING` varchar(255) DEFAULT NULL,
  `USER_ID` bigint(20) DEFAULT NULL,
  `INSTITUTE_ID` bigint(20) DEFAULT NULL,
  `UNIVERSITY_ID` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`ID`),
  KEY `FK5759B23ED4819085` (`USER_ID`),
  KEY `FK5759B23EF9E024CB` (`UNIVERSITY_ID`),
  KEY `FK5759B23E26DD6FCF` (`INSTITUTE_ID`),
  CONSTRAINT `FK5759B23E26DD6FCF` FOREIGN KEY (`INSTITUTE_ID`) REFERENCES `institute_mst_tbl` (`ID`),
  CONSTRAINT `FK5759B23ED4819085` FOREIGN KEY (`USER_ID`) REFERENCES `user_mst_tbl` (`ID`),
  CONSTRAINT `FK5759B23EF9E024CB` FOREIGN KEY (`UNIVERSITY_ID`) REFERENCES `university_mst_tbl` (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=300 DEFAULT CHARSET=utf8;

--
-- Dumping data for table `user_educations_tbl`
--

/*!40000 ALTER TABLE `user_educations_tbl` DISABLE KEYS */;
INSERT INTO `user_educations_tbl` (`ID`,`BRANCH_NAME`,`EDUCATION_TYPE`,`PERCENTAGE`,`YEAR_OF_PASSING`,`USER_ID`,`INSTITUTE_ID`,`UNIVERSITY_ID`) VALUES 
 (144,'computer science and engineering.','Graduation',62,'2015',2,1,NULL),
 (145,'electrical and electronics engineering','Graduation',70,'2016',1,2,NULL),
 (146,'eee','Inter/PUC',78,'2013',1,3,NULL),
 (147,'','',0,'',8,150,NULL),
 (148,'','SSC',79,'2010',6,5,NULL),
 (149,'ECE','Inter/PUC',80,'2013',6,6,NULL),
 (150,'ECE','Graduation',64,'2013',6,7,NULL),
 (151,'BE-COMPUTER SCIENCE','Graduation',62,'2016',9,8,NULL),
 (152,'SCIENCE , SOCIAL, MATHEMATICS, ENGLISH, KANNADA,HINDI','SSC',76,'2010',16,9,NULL),
 (153,'PCMB','Inter/PUC',75,'2012',16,10,NULL),
 (154,'COMPUTER SCIENCE AND ENGINEERING','Graduation',66,'2016',16,11,NULL),
 (155,'ssc','SSC',70,'2005',17,12,NULL),
 (156,'MPC','Inter/PUC',73,'2007',17,13,NULL),
 (157,'B.Sc computers','Graduation',75,'2010',17,14,NULL),
 (158,'MCA','P.G',74,'2013',17,1,NULL),
 (159,'','',0,'',12,150,NULL),
 (160,'et','Inter/PUC',0,'e',19,150,NULL),
 (161,'ComputerScience','Graduation',65,'',22,150,NULL),
 (162,'Computer Science','PG',81,'2015',33,19,NULL),
 (163,'CSE','PG',70,'2016',34,11,4),
 (164,'','SSC',85,'2010',35,21,NULL),
 (165,'M.p.c','Inter/PUC',89,'2012',35,22,NULL),
 (166,'Computer Science and Engineering','Graduation',76,'2016',35,23,NULL),
 (167,'Information Technology','Graduation',5,'2015',37,24,NULL),
 (168,'IT','Graduation',65,'2015',39,25,NULL),
 (169,'CS','Graduation',72,'2016',40,26,NULL),
 (170,'mca','PG',79,'2016',41,27,NULL),
 (171,'bsc','Graduation',75,'2013',41,28,NULL),
 (172,'mpc','Inter/PUC',86,'2010',41,29,NULL),
 (173,'ssc','SSC',82,'2008',41,30,NULL),
 (174,'','Ph.D',0,'',41,150,NULL),
 (175,'computer science','Graduation',71,'2016',42,32,NULL),
 (176,'Computer Application','PG',80,'2016',43,33,NULL),
 (177,'','SSC',87,'2009',30,34,NULL),
 (178,'mpc','Inter/PUC',96,'2011',30,35,NULL),
 (179,'CSE','Graduation',78,'2015',30,36,NULL),
 (180,'','Inter/PUC',0,'',14,150,NULL),
 (181,'Electrical&Electronics Engineering','Graduation',74,'2016',48,38,NULL),
 (182,'CSE','Graduation',54,'2016',51,39,NULL),
 (183,'Computer Engineering','Graduation',53,'2016',49,40,NULL),
 (184,'MCA','PG',68,'2017',52,32,NULL),
 (185,'MCA','PG',78,'2017',53,42,NULL),
 (186,'mca','PG',71,'2015',55,43,NULL),
 (187,'','SSC',81,'2009',54,44,NULL),
 (188,'MCA','PG',68,'2015',56,32,NULL),
 (189,'INFORMATION TECHNOLOGY','Graduation',72,'2016',58,46,NULL),
 (190,'SCIENCE','SSC',61,'2009',58,47,NULL),
 (191,'SCIENCE','Inter/PUC',61,'2009',58,48,NULL),
 (192,'MCA','PG',64,'2015',63,49,NULL),
 (193,'B.Tech ECE','PG',65,'2016',65,50,NULL),
 (194,'Nandyal','SSC',83,'2010',70,51,NULL),
 (195,'Nandyal','Inter/PUC',87,'2012',70,52,NULL),
 (196,'Nandyal','Graduation',77,'2016',70,53,NULL),
 (197,'cse','Graduation',72,'2015',72,54,NULL),
 (198,'Computer SCience','Graduation',7,'2017',74,55,NULL),
 (199,'Electronics and Communication','Graduation',73,'2013',75,56,NULL),
 (200,'ece','Graduation',70,'2016',77,57,NULL),
 (201,'','SSC',0,'',78,150,NULL),
 (202,'Computer Science','Graduation',60,'2016',78,59,NULL),
 (203,'ECE','Graduation',71,'2016',24,60,NULL),
 (204,'','SSC',87,'2010',80,61,NULL),
 (205,'computer science','Graduation',61,'2015',81,32,NULL),
 (206,'EEE','Graduation',57,'2016',82,32,NULL),
 (207,'MCA','PG',81,'2016',84,64,NULL),
 (208,'CSE','Graduation',65,'2015',85,32,NULL),
 (209,'Computer Science & Engineering','Graduation',78,'2016',86,66,NULL),
 (210,'PCM','Inter/PUC',60,'2012',86,67,NULL),
 (211,'ECE','Graduation',63,'2016',87,68,NULL),
 (212,'Computer science engineering','Graduation',60,'2016',88,69,NULL),
 (213,'','SSC',83,'2010',89,70,NULL),
 (214,'E AND C','Graduation',62,'2016',90,71,NULL),
 (215,'electrical engg.','Graduation',68,'2016',91,72,NULL),
 (216,'All subject','SSC',64,'2004',93,73,NULL),
 (217,'Commerce','Inter/PUC',69,'2006',93,74,NULL),
 (218,'B.tech','Graduation',6,'2015',94,75,NULL),
 (219,'Computer Science','Graduation',67,'2016',98,76,NULL),
 (220,'','SSC',58,'2009',97,77,NULL),
 (221,'','SSC',58,'2009',97,78,NULL),
 (222,'Computer Science','Graduation',66,'2012',99,32,NULL),
 (223,'','SSC',69,'2006',103,80,NULL),
 (224,'Maths & Computer Science','Inter/PUC',69,'2009',103,81,NULL),
 (225,'information science','Graduation',58,'2016',108,32,NULL),
 (226,'','Graduation',76,'2015',112,32,NULL),
 (227,'information technology','Graduation',63,'2015',113,84,NULL),
 (228,'Maths','SSC',74,'2009',115,85,NULL),
 (229,'MPC','Inter/PUC',75,'2011',115,86,NULL),
 (230,'ECE','Graduation',67,'2015',115,87,NULL),
 (231,'SSC','SSC',85,'2010',116,88,NULL),
 (232,'MPC','Inter/PUC',93,'2012',116,89,NULL),
 (233,'Information Technology','Graduation',60,'2016',117,90,NULL),
 (234,'Computer Science','Graduation',56,'2016',119,91,NULL),
 (235,'Computer Science','PG',3,'2017',121,92,NULL),
 (236,'','SSC',78,'2011',122,93,NULL),
 (237,'NON-MEDICAL','Inter/PUC',74,'2013',122,94,NULL),
 (238,'BCA','Graduation',63,'2016',122,95,NULL),
 (239,'BA(political science)','Graduation',60,'2016',123,96,NULL),
 (240,'IT','Graduation',65,'2011',124,97,NULL),
 (241,'CSE','Graduation',61,'2014',125,98,NULL),
 (242,'CSE','Graduation',64,'2014',126,99,NULL),
 (243,'Raigarh','SSC',65,'2012',132,100,NULL),
 (244,'Durg','Graduation',66,'201',132,101,NULL),
 (245,'ECE','Graduation',55,'2015',133,32,NULL),
 (246,'ECE','Graduation',89,'2015',136,103,NULL),
 (247,'Computer Science and Networking','PG',55,'2016',138,104,NULL),
 (248,'Information Science','Graduation',65,'2013',138,32,NULL),
 (249,'MCA','PG',68,'2016',140,106,NULL),
 (250,'BSC (MECS)','Graduation',57,'2016',135,32,NULL),
 (251,'INFORMATION SCIENCE','Graduation',67,'2016',141,108,NULL),
 (252,'','SSC',79,'2009',144,109,NULL),
 (253,'EEE','Graduation',77,'2016',145,110,NULL),
 (254,'na','SSC',75,'2010',154,111,NULL),
 (255,'mpc','Inter/PUC',90,'2012',154,112,NULL),
 (256,'CSE','Graduation',61,'2016',154,113,NULL),
 (257,'Mathes','SSC',82,'2009',129,114,NULL),
 (258,'MPC','Inter/PUC',82,'2011',129,115,NULL),
 (259,'IT','Graduation',79,'2015',129,116,NULL),
 (260,'Mechanical Engineering college','Graduation',68,'2017',155,117,NULL),
 (261,'','SSC',81,'2010',163,118,NULL),
 (262,'ECE','Inter/PUC',84,'2013',163,119,NULL),
 (263,'ECE','Graduation',61,'2016',163,120,NULL),
 (264,'SSC','SSC',82,'2010',167,121,NULL),
 (265,'MPC','Inter/PUC',87,'2012',167,122,NULL),
 (266,'','Graduation',72,'2016',167,123,NULL),
 (267,'CIVIL ENGINEERING','Graduation',80,'2017',169,124,NULL),
 (268,'ECE','Graduation',84,'2016',171,125,NULL),
 (269,'cse','Graduation',67,'2017',177,126,NULL),
 (270,'CSE','Graduation',72,'2015',198,127,NULL),
 (271,'Electronics And Communication Engineering','Graduation',71,'2016',209,128,NULL),
 (272,'MPC','Inter/PUC',86,'2012',209,129,NULL),
 (273,'Pullampet','SSC',79,'2004',212,130,NULL),
 (274,'Pullampet','Inter/PUC',80,'2006',212,131,NULL),
 (275,'Rajampet','Graduation',79,'2009',212,132,NULL),
 (276,'Rajampet','PG',76,'2012',212,133,NULL),
 (277,'','SSC',69,'2010',203,134,NULL),
 (278,'CME','Inter/PUC',78,'2013',203,135,NULL),
 (279,'CSE','Graduation',70,'2016',203,136,NULL),
 (280,'Computer Science and Engineering','Graduation',67,'2016',228,137,NULL),
 (281,'','Inter/PUC',88,'2012',228,138,NULL),
 (282,'','SSC',83,'2010',228,139,NULL),
 (283,'','SSC',85,'2011',206,140,NULL),
 (284,'MCA','PG',68.3,'2017',247,141,NULL),
 (285,'MCA','PG',72.66,'2017',246,142,NULL),
 (286,'PCMB','Inter/PUC',61,'2009',237,143,NULL),
 (287,'COMPUTER SCIENCE','Graduation',74,'2013',237,144,NULL),
 (288,'COMPUTER SCIENCE','PG',78,'2015',237,145,NULL),
 (289,NULL,'Graduation',200,'2222',253,146,NULL),
 (290,'Inter/PUC',NULL,NULL,NULL,253,146,NULL),
 (291,'lkjlkjl','PG',10,'2012',244,148,NULL),
 (292,'ECE','Graduation',70,'2017',211,150,NULL),
 (293,'MPC','Inter/PUC',90,'2013',211,150,NULL),
 (294,NULL,'SSC',90,'2011',211,151,NULL),
 (295,'','SSC',87,'2010',258,154,NULL),
 (296,'MPC','Inter/PUC',83,'2012',258,155,NULL),
 (297,'ECE','Graduation',63,'2016',258,156,NULL),
 (298,'cse','Graduation',80,'2017',275,9,2),
 (299,'ECE','Inter/PUC',80,'2016',518,11,4);
/*!40000 ALTER TABLE `user_educations_tbl` ENABLE KEYS */;


--
-- Definition of table `user_employers_info_tbl`
--

DROP TABLE IF EXISTS `user_employers_info_tbl`;
CREATE TABLE `user_employers_info_tbl` (
  `ID` bigint(20) NOT NULL AUTO_INCREMENT,
  `DESIGNATION` varchar(255) DEFAULT NULL,
  `EMPLOYER` varchar(255) DEFAULT NULL,
  `EMPLOYER_STATUS` varchar(255) DEFAULT NULL,
  `JOB_PROFILE` varchar(255) DEFAULT NULL,
  `END_MONTH` varchar(255) DEFAULT NULL,
  `START_MONTH` varchar(255) DEFAULT NULL,
  `END_YEAR` varchar(255) DEFAULT NULL,
  `START_YEAR` varchar(255) DEFAULT NULL,
  `USER_ID` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`ID`),
  KEY `FK_hhy80abio6hcy8b0k2qp6matf` (`USER_ID`),
  CONSTRAINT `FK_hhy80abio6hcy8b0k2qp6matf` FOREIGN KEY (`USER_ID`) REFERENCES `user_mst_tbl` (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `user_employers_info_tbl`
--

/*!40000 ALTER TABLE `user_employers_info_tbl` DISABLE KEYS */;
/*!40000 ALTER TABLE `user_employers_info_tbl` ENABLE KEYS */;


--
-- Definition of table `user_experiance_tbl`
--

DROP TABLE IF EXISTS `user_experiance_tbl`;
CREATE TABLE `user_experiance_tbl` (
  `ID` bigint(20) NOT NULL AUTO_INCREMENT,
  `CURRENT_SALARY_IN_LAKHS` varchar(255) DEFAULT NULL,
  `CURRENT_SALARY_IN_THOUSANDS` varchar(255) DEFAULT NULL,
  `EXPECTED_SALARY_IN_LAKHS` varchar(255) DEFAULT NULL,
  `EXPECTED_SALARY_IN_THOUSANDS` varchar(255) DEFAULT NULL,
  `YEARS_OF_MONTHS` int(11) DEFAULT NULL,
  `YEARS_OF_EXPERIANCE` int(11) DEFAULT NULL,
  `USER_ID` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`ID`),
  KEY `FK_g4ur26mqjx416vkf67rm6f6e9` (`USER_ID`),
  CONSTRAINT `FK_g4ur26mqjx416vkf67rm6f6e9` FOREIGN KEY (`USER_ID`) REFERENCES `user_mst_tbl` (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=utf8;

--
-- Dumping data for table `user_experiance_tbl`
--

/*!40000 ALTER TABLE `user_experiance_tbl` DISABLE KEYS */;
INSERT INTO `user_experiance_tbl` (`ID`,`CURRENT_SALARY_IN_LAKHS`,`CURRENT_SALARY_IN_THOUSANDS`,`EXPECTED_SALARY_IN_LAKHS`,`EXPECTED_SALARY_IN_THOUSANDS`,`YEARS_OF_MONTHS`,`YEARS_OF_EXPERIANCE`,`USER_ID`) VALUES 
 (1,'1-2 LPA',NULL,'2-4 LPA',NULL,NULL,NULL,115),
 (2,NULL,NULL,NULL,NULL,NULL,NULL,116),
 (3,'8-10 LPA',NULL,'8-10 LPA',NULL,NULL,NULL,121),
 (4,'2-4 LPA',NULL,'18-20 LPA',NULL,NULL,NULL,123),
 (5,'2-4 LPA',NULL,'4-6 LPA',NULL,NULL,NULL,124),
 (6,'2-4 LPA',NULL,'2-4 LPA',NULL,NULL,NULL,125),
 (7,'2-4 LPA',NULL,'4-6 LPA',NULL,NULL,NULL,126),
 (8,'1-2 LPA',NULL,'2-4 LPA',NULL,NULL,NULL,133),
 (9,'4-6 LPA',NULL,NULL,NULL,NULL,NULL,136),
 (10,NULL,NULL,NULL,NULL,NULL,NULL,140),
 (11,'NA',NULL,'2-4 LPA',NULL,NULL,NULL,141),
 (12,NULL,NULL,NULL,NULL,NULL,NULL,171),
 (13,NULL,NULL,NULL,NULL,NULL,NULL,253),
 (14,NULL,NULL,NULL,NULL,NULL,NULL,244),
 (15,NULL,NULL,NULL,NULL,NULL,NULL,211),
 (16,NULL,NULL,NULL,NULL,NULL,NULL,258),
 (17,'2','20','5','30',0,1,275);
/*!40000 ALTER TABLE `user_experiance_tbl` ENABLE KEYS */;


--
-- Definition of table `user_interview_status_tbl`
--

DROP TABLE IF EXISTS `user_interview_status_tbl`;
CREATE TABLE `user_interview_status_tbl` (
  `ID` bigint(20) NOT NULL AUTO_INCREMENT,
  `ATTITUDE` bigint(20) DEFAULT NULL,
  `FTF_EXTRA_COMMENTS` varchar(255) DEFAULT NULL,
  `LOGICAL` bigint(20) DEFAULT NULL,
  `SYS_PROGRAMS_EXECUTED` bigint(20) DEFAULT NULL,
  `SYS_PROGRAMS_GIVEN` bigint(20) DEFAULT NULL,
  `sysRating` bigint(20) DEFAULT NULL,
  `TASK_RATING` bigint(20) DEFAULT NULL,
  `TASKS_COMPLETED` bigint(20) DEFAULT NULL,
  `TASKS_GIVEN` bigint(20) DEFAULT NULL,
  `TELE_COMMUNICATION` bigint(20) DEFAULT NULL,
  `TELE_EXTRA_COMMENTS` varchar(255) DEFAULT NULL,
  `TELE_PROGRAMMING` bigint(20) DEFAULT NULL,
  `USER_ID` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`ID`),
  KEY `FK_qryet30hwnyxkc7528vt9kbma` (`USER_ID`),
  CONSTRAINT `FK_qryet30hwnyxkc7528vt9kbma` FOREIGN KEY (`USER_ID`) REFERENCES `user_mst_tbl` (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `user_interview_status_tbl`
--

/*!40000 ALTER TABLE `user_interview_status_tbl` DISABLE KEYS */;
/*!40000 ALTER TABLE `user_interview_status_tbl` ENABLE KEYS */;


--
-- Definition of table `user_interview_tbl`
--

DROP TABLE IF EXISTS `user_interview_tbl`;
CREATE TABLE `user_interview_tbl` (
  `ID` bigint(20) NOT NULL AUTO_INCREMENT,
  `IS_EXAM_COMPLETED` bit(1) DEFAULT NULL,
  `INTERVIEW_DATE` datetime DEFAULT NULL,
  `INTERVIEW_TIMING` varchar(255) DEFAULT NULL,
  `RESHEDULE` bit(1) DEFAULT NULL,
  `USER_ID` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`ID`),
  KEY `FK_hhxyc1vgfwum6m80d1wnw84bj` (`USER_ID`),
  CONSTRAINT `FK_hhxyc1vgfwum6m80d1wnw84bj` FOREIGN KEY (`USER_ID`) REFERENCES `user_mst_tbl` (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `user_interview_tbl`
--

/*!40000 ALTER TABLE `user_interview_tbl` DISABLE KEYS */;
/*!40000 ALTER TABLE `user_interview_tbl` ENABLE KEYS */;


--
-- Definition of table `user_known_apps_tbl`
--

DROP TABLE IF EXISTS `user_known_apps_tbl`;
CREATE TABLE `user_known_apps_tbl` (
  `ID` bigint(20) NOT NULL AUTO_INCREMENT,
  `ACCOMLISHMENTS` longtext,
  `APPLICATIONS` longtext,
  `CREATED_ON` datetime DEFAULT NULL,
  `GAMES` longtext,
  `MOBILE_APPS` longtext,
  `STATUS` varchar(255) DEFAULT NULL,
  `STRENGTHS` longtext,
  `WEAKNESS` longtext,
  `USER_ID` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`ID`),
  KEY `FK_ifrlo6bd4t7gtgsob5nt2ymba` (`USER_ID`),
  CONSTRAINT `FK_ifrlo6bd4t7gtgsob5nt2ymba` FOREIGN KEY (`USER_ID`) REFERENCES `user_mst_tbl` (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `user_known_apps_tbl`
--

/*!40000 ALTER TABLE `user_known_apps_tbl` DISABLE KEYS */;
/*!40000 ALTER TABLE `user_known_apps_tbl` ENABLE KEYS */;


--
-- Definition of table `user_languages_trn_tbl`
--

DROP TABLE IF EXISTS `user_languages_trn_tbl`;
CREATE TABLE `user_languages_trn_tbl` (
  `ID` bigint(20) NOT NULL AUTO_INCREMENT,
  `LANGUAGE_ID` bigint(20) DEFAULT NULL,
  `USER_ID` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`ID`),
  KEY `FK_9xwg9vwc2n2ophjaarlivp90g` (`LANGUAGE_ID`),
  KEY `FK_qsv8lrqek37gd9feuxuu9cfny` (`USER_ID`),
  CONSTRAINT `FK_qsv8lrqek37gd9feuxuu9cfny` FOREIGN KEY (`USER_ID`) REFERENCES `user_mst_tbl` (`ID`),
  CONSTRAINT `FK_9xwg9vwc2n2ophjaarlivp90g` FOREIGN KEY (`LANGUAGE_ID`) REFERENCES `languages_mst_tbl` (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=137 DEFAULT CHARSET=utf8;

--
-- Dumping data for table `user_languages_trn_tbl`
--

/*!40000 ALTER TABLE `user_languages_trn_tbl` DISABLE KEYS */;
INSERT INTO `user_languages_trn_tbl` (`ID`,`LANGUAGE_ID`,`USER_ID`) VALUES 
 (1,1,115),
 (2,3,115),
 (3,4,115),
 (4,1,121),
 (5,2,121),
 (6,1,126),
 (7,2,126),
 (8,1,132),
 (9,2,132),
 (10,1,133),
 (11,2,133),
 (12,4,133),
 (13,1,138),
 (14,2,138),
 (15,4,138),
 (16,1,140),
 (17,2,140),
 (18,4,140),
 (19,1,144),
 (20,4,144),
 (21,1,154),
 (22,3,154),
 (23,1,157),
 (24,2,157),
 (25,3,157),
 (26,1,165),
 (27,3,165),
 (28,1,184),
 (29,2,184),
 (30,3,184),
 (31,1,187),
 (32,3,187),
 (33,1,204),
 (34,3,204),
 (35,1,221),
 (36,2,221),
 (37,3,221),
 (38,1,228),
 (40,3,228),
 (41,1,232),
 (42,2,232),
 (43,1,206),
 (44,3,206),
 (45,1,237),
 (46,2,237),
 (47,3,237),
 (48,4,237),
 (49,5,237),
 (50,1,247),
 (51,2,247),
 (53,4,247),
 (58,1,211),
 (59,2,211),
 (60,3,211),
 (61,1,258),
 (62,2,258),
 (63,1,261),
 (64,2,261),
 (92,1,34),
 (93,3,34),
 (95,1,275),
 (96,2,275),
 (135,4,518),
 (136,1,518);
/*!40000 ALTER TABLE `user_languages_trn_tbl` ENABLE KEYS */;


--
-- Definition of table `user_mst_tbl`
--

DROP TABLE IF EXISTS `user_mst_tbl`;
CREATE TABLE `user_mst_tbl` (
  `ID` bigint(20) NOT NULL AUTO_INCREMENT,
  `CREATED_ON` datetime DEFAULT NULL,
  `EMAILID` varchar(255) DEFAULT NULL,
  `VISIBILITY` bit(1) DEFAULT NULL,
  `MOBILENO` varchar(255) DEFAULT NULL,
  `PASSWORD` varchar(255) DEFAULT NULL,
  `STATUS` varchar(255) DEFAULT NULL,
  `USERNAME` varchar(255) DEFAULT NULL,
  `ROLE_ID` bigint(20) DEFAULT NULL,
  `IS_EXAM_COMPLETED` bit(1) DEFAULT NULL,
  PRIMARY KEY (`ID`),
  KEY `FKABC3B7192287F105` (`ROLE_ID`),
  CONSTRAINT `FKABC3B7192287F105` FOREIGN KEY (`ROLE_ID`) REFERENCES `role_mst_tbl` (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=520 DEFAULT CHARSET=utf8;

--
-- Dumping data for table `user_mst_tbl`
--

/*!40000 ALTER TABLE `user_mst_tbl` DISABLE KEYS */;
INSERT INTO `user_mst_tbl` (`ID`,`CREATED_ON`,`EMAILID`,`VISIBILITY`,`MOBILENO`,`PASSWORD`,`STATUS`,`USERNAME`,`ROLE_ID`,`IS_EXAM_COMPLETED`) VALUES 
 (1,'2017-02-25 00:00:00','vemulajeevankumarnaidu@gmail.com',0x00,'9505949022','ac85e19c5ad4c8a87b384b7f670db979','ACTIVE','vemula jeevan kumar',1,NULL),
 (2,'2017-02-25 00:00:00','pradeepvemula3@gmail.com',0x00,'8008055874','32b13192befed3908ff0e2470c0e2322','ACTIVE','pradeep vemula',1,NULL),
 (6,'2017-02-27 00:00:00','phani1695@gmail.com',0x00,'9986565469','ed1729a3c2418f3722353fea7746c67c','ACTIVE','phani',3,NULL),
 (8,'2017-02-27 00:00:00','manishsinha54a@gmail.com',0x00,'8904653070','f23c9a5dca7aef19a3db264c5c21a2f8','ACTIVE','MANISH KUMAR SONAL',1,NULL),
 (9,'2017-02-28 00:00:00','ajaykumar.aeri94@gmail.com',0x00,'9686571630','f1b10ec984e587d71e56de3a0634a670','ACTIVE','Ajaykumar',4,NULL),
 (10,'2017-02-28 00:00:00','hariprasanth89@gmail.com',0x00,'9686571631','8e27439d2efeed60e4bbebb16b9a225b','ACTIVE','hariprasanth',4,NULL),
 (11,'2017-02-28 00:00:00','saikiran.konduru15@gmail.com',0x00,'9092121112','cdefc0ca465cfe8a5e592c04ffcf475b','ACTIVE','sai kiran',4,NULL),
 (12,'2017-03-02 00:00:00','manikanta.viswa@gmail.com',0x00,'9676333347','9570295ee4558c18f70e8b96fd96e723','ACTIVE','Manikanta',1,NULL),
 (13,'2017-03-02 00:00:00','sudhakar1416.ece@gmail.com',0x00,'9676350410','6b2c3127fa2022564065de5d900ab29f','ACTIVE','Sudhakar',1,NULL),
 (14,'2017-03-02 00:00:00','codingkavya@gmail.com',0x00,'undefined','c3447e02a43dc64ece3438b087043761','ACTIVE','Nimmalapudi kavya',2,NULL),
 (16,'2017-03-06 00:00:00','karthikhr222@gmail.com',0x00,'7204755585','4a8c794cc39433bac99c1b7e3e4dbc14','ACTIVE','KARTHIK H R',1,NULL),
 (17,'2017-03-07 00:00:00','ashokwas48@gmail.com',0x00,'8867747577','e10adc3949ba59abbe56e057f20f883e','ACTIVE','Ashok Reddy',2,NULL),
 (19,'2017-03-16 00:00:00','chennaroy@gmail.com',0x00,'9844795637','7087de8ec0dd70f163107b0ac5b6fc33','ACTIVE','chenna',2,NULL),
 (20,'2017-03-18 00:00:00','codingkrishna@gmail.com',0x00,'8123870076','e10adc3949ba59abbe56e057f20f883e','ACTIVE','Hari',1,NULL),
 (21,'2017-03-19 00:00:00','varalakshmi130@gmail.com',0x00,'9035744582','9aeff8b3a2e81dac11a0501931835247','ACTIVE','varalakshmi',4,NULL),
 (22,'2017-03-23 00:00:00','samwathre@gmail.com',0x00,'9700177026','0187bc7c3173b1cb07e9a599346f9005','ACTIVE','Saurabh',6,NULL),
 (23,'2017-03-23 00:00:00','kvravikumar3225200@gmail.com',0x00,'9790815897','447378bc9ddc63b548906b64c9b2823b','ACTIVE','Venkata Ravi Kumar Kuruva',3,NULL),
 (24,'2017-03-23 00:00:00','suhasini.17reddy5@gmail.com',0x00,'8892599078','adcd381c90ab1dc8fa8b83b8b3939c76','ACTIVE','suhasini Ankireddypalle',6,NULL),
 (25,'2017-03-23 00:00:00','vadisasai@gmail.com',0x00,'8886414321','ee0e31c69272bac553484a76fa3e5a49','ACTIVE','saikrushnav',6,NULL),
 (26,'2017-03-23 00:00:00','ramakrishnamallula5@gmail.com',0x00,'9642480076','b0fb12bcb3a932020a70768676d115b4','ACTIVE','leelaramakrishna',6,NULL),
 (27,'2017-03-26 00:00:00','sudhakar.gaanugapeta@gmail.com',0x00,'9743499480','e10adc3949ba59abbe56e057f20f883e','ACTIVE','sudhakar',6,NULL),
 (29,'2017-03-27 00:00:00','prashanthkjmail@gmail.com',0x00,'9686696621','ff3eb58b758615e477e2c30ee33e14de','ACTIVE','PRASHANTH K J',3,NULL),
 (30,'2017-03-27 00:00:00','ptaruntej31@gmail.com',0x00,'9902612585','85d11ea34590a15bdf36d3915a24ac84','ACTIVE','tarunteja',6,NULL),
 (31,'2017-03-27 00:00:00','bikashkumar0510@gmail.com',0x00,'8084144609','291cfc449f9f0c149a4205056b3dd9e1','ACTIVE','Bikash Kumar',3,NULL),
 (33,'2017-03-27 00:00:00','parul.thakur51@gmail.com',0x00,'9513800954','f13b86afaa39a42706f0866cc52c6509','ACTIVE','parul thakur',6,NULL),
 (34,'2017-03-27 00:00:00','vamsi3369@gmail.com',0x01,'9880577218','e10adc3949ba59abbe56e057f20f883e','ACTIVE','Mure Vamsikrishna Reddy',6,NULL),
 (35,'2017-03-27 00:00:00','venkygogineni548@outlook.com',0x01,'8050500869','a7422b839e9917dfc479cf7a383f14a1','ACTIVE','venkatesh gogineni',6,NULL),
 (36,'2017-03-27 00:00:00','sairamyadasari22@gmail.com',0x00,'8971991649','995f4ed2d6ecd7639b4659b8c63612f0','ACTIVE','sai ramya dasari',6,NULL),
 (37,'2017-03-27 00:00:00','aamircontact3@gmail.com',0x00,'7259566246','36b3f61f850ddfb280bcbf524350f326','ACTIVE','Aamir Ahmad',7,NULL),
 (39,'2017-03-27 00:00:00','darpan008@gmail.com',0x00,'8956799701','8850681757f56e51e13741824f739f71','ACTIVE','darpan modi',6,NULL),
 (40,'2017-03-27 00:00:00','piyushshukla177@gmail.com',0x00,'9686410991','0e98c911e14a817d076de3d1bf61ca08','ACTIVE','Piyush Shukla',6,NULL),
 (41,'2017-03-27 00:00:00','bindumonika20@gmail.com',0x01,'8297507115','995663c7173ee3fc4af9d3c5f26a12c4','ACTIVE','Bindu Sakhamuri',3,NULL),
 (42,'2017-03-27 00:00:00','dineshksingh321@gmail.com',0x00,'9900261723','69b178b22c442e847eed9a8ee9a4b27d','ACTIVE','dinesh kumar singh',3,NULL),
 (43,'2017-03-27 00:00:00','kalpa.manasa@gmail.com',0x00,'8095876744','44cab140394ad97d7b596dbf7ea253d5','ACTIVE','sankalpa D   k',6,NULL),
 (44,'2017-03-27 00:00:00','taruntejaparuchuri@gmail.com',0x00,'7989303259','85d11ea34590a15bdf36d3915a24ac84','ACTIVE','tarun',6,NULL),
 (45,'2017-03-29 00:00:00','bhaskar.sabbella@gmail.com',0x00,'9482421336','a47150a2390f3f502d5521babb275e34','ACTIVE','Bhaskar',1,NULL),
 (47,'2017-04-02 00:00:00','serializesudhakar@gmail.com',0x00,'7411062329','5b42205d5e3ba676c4bd7fec959e203c','ACTIVE','sudhakar gaanugapeta',1,NULL),
 (48,'2017-04-02 00:00:00','aswini3.kota@gmail.com',0x00,'9986356242','106751344d6dcb24ccae07a574138d6b','ACTIVE','ASWINI KOTA',6,NULL),
 (49,'2017-04-02 00:00:00','ajinkyatamhane.cs@gmail.com',0x00,'9158730202','f6a2bad09cb48fb689f61496fa1ac056','ACTIVE','Ajinkya',6,NULL),
 (50,'2017-04-02 00:00:00','venkatesh0417@gmail.com',0x00,'9164757078','4de04266bdd87410de698cfc33c55d68','ACTIVE','B.Venkatesh',6,NULL),
 (51,'2017-04-02 00:00:00','babre.tanmay@gmail.com',0x00,'9545376909','31baa6b583cad5df51959b46811c8269','ACTIVE','Tanmay',3,NULL),
 (52,'2017-04-02 00:00:00','biswasb861@gmail.com',0x00,'7795038340','f2c267c37524e82269e93c043027e510','ACTIVE','pavitro bishvas',6,NULL),
 (53,'2017-04-02 00:00:00','mohddanishmzn@gmail.com',0x00,'8553540178','e10adc3949ba59abbe56e057f20f883e','ACTIVE','Mohd Danish',6,NULL),
 (54,'2017-04-02 00:00:00','kavithareddy9000@gmail.com',0x00,'8792193298','adb1d3e534aad37f0b2392f9086bc42b','ACTIVE','kavitha',3,NULL),
 (55,'2017-04-02 00:00:00','mamatha.gkl91@gmail.com',0x00,'8553695819','204e3e7e9d9ddf07a1b9e58201a46aab','ACTIVE','mamatha G',6,NULL),
 (56,'2017-04-02 00:00:00','ranju.anegundi772@gmail.com',0x00,'9538338837','9e9995036451bfb4836ad5b8d749ab16','ACTIVE','ranjita',6,NULL),
 (57,'2017-04-02 00:00:00','sundarmaniraju@gmail.com',0x00,'9492972193','2461b6e579632c5e0a0f01627f08ef59','ACTIVE','SUNDAR MANIRAJU',3,NULL),
 (58,'2017-04-02 00:00:00','enterinmanish@gmail.com',0x00,'9066416157','1b2fe33117ef3976965eba5e685d6576','ACTIVE','MANISH',6,NULL),
 (59,'2017-04-02 00:00:00','abhi.vj69@gmail.com',0x00,'8951846939','3a1b1af35d550a5ef50c5ab20306d4f3','ACTIVE','Abinash Thakur',6,NULL),
 (60,'2017-04-03 00:00:00','shanven69@gmail.com',0x00,'9663865866','103e837b62017008b75ac289e505c71a','ACTIVE','Shankarbabu',6,NULL),
 (63,'2017-04-08 00:00:00','girijeshkushwaha786@gmail.com',0x00,'9036469795','e3e0bf9a373a5c047589b64356675198','ACTIVE','Girijesh kushwaha',6,NULL),
 (64,'2017-04-08 00:00:00','Riturajhandique243@gmail.com',0x00,'8296133858','40be4e59b9a2a2b5dffb918c0e86b3d7','ACTIVE','Rituraj Handique',1,NULL),
 (65,'2017-04-14 00:00:00','sudeshkumar9320@gmail.com',0x00,'9015519048','bca9842dd4a1f9fcdcbbffff918fe5d3','ACTIVE','sudesh kumar',1,NULL),
 (66,'2017-04-14 00:00:00','deepak.choudhari.yes@gmail.com',0x00,'8839175381','a496df69c17a2689f91b0ad6251b179a','ACTIVE','Deepak Choudhari',6,NULL),
 (67,'2017-04-14 00:00:00','mrabhishek8359@gmail.com',0x00,'8359838129','ccad01b31bc04a5aa68bc8cbcd74a0e3','ACTIVE','Abhishek Jain',6,NULL),
 (68,'2017-04-14 00:00:00','snikhar2011@gmail.com',0x00,'7000369365','5d4d4d2d540f50825976a1de6599c946','ACTIVE','Sumit Nikhar',6,NULL),
 (69,'2017-04-15 00:00:00','radhapriyanka401@gmail.com',0x00,'9100655132','0aeff4f217756e92fe3216ab67dccd4b','ACTIVE','Radhapriyanka',6,NULL),
 (70,'2017-04-20 00:00:00','manasap432@gmail.com',0x00,'7026912915','4026492ea6666ecf032478b5f82d3e94','ACTIVE','Manasa Panyam',6,NULL),
 (71,'2017-04-20 00:00:00','s.sukanya006@gmail.com',0x00,'7026932367','ecede7e35f3eddabafeca35321c8dc38','ACTIVE','Sukanya Saareddy',6,NULL),
 (72,'2017-04-21 00:00:00','neha00sharma0@gmail.com',0x00,'7899743086','029c1b4683f90d67a5753388f1d5bb10','ACTIVE','sweety sharma',6,NULL),
 (73,'2017-04-21 00:00:00','lakshmipragna93@gmail.com',0x01,'9206103817','90a89ee97933fcce17a7331769eba110','ACTIVE','Lakshmi priya S',6,NULL),
 (74,'2017-04-22 00:00:00','poojajojo.krishnaiah@gmail.com',0x00,'7760591215','503a884b9c1962cd6446d397fa751920','ACTIVE','Pooja',6,NULL),
 (75,'2017-04-22 00:00:00','gautamrj9@gmail.com',0x00,'9448108791','125a77f1085bf9c374f91aee6912863c','ACTIVE','Gautam Raje',6,NULL),
 (76,'2017-04-22 00:00:00','jyothireddy.cse508@gmail.com',0x01,'8904911742','3371bdbb47225eeb9d73292f6f477992','ACTIVE','O.Jyothi',6,NULL),
 (77,'2017-04-22 00:00:00','rcrcrv95@gmail.com',0x00,'9620923042','1a28df9729731d3311ac13a320879586','ACTIVE','REDDY VASAVI',6,NULL),
 (78,'2017-04-22 00:00:00','bbswjt@gmail.com',0x00,'8473020790','7fe02a5b99ae24912ae28a03d8493095','ACTIVE','Biswajit Barman',6,NULL),
 (79,'2017-04-22 00:00:00','raziyapitpit@gmail.com',0x00,'8050238386','b45ba03491c97113a6037029e0d72a0e','ACTIVE','RAZIYA',6,NULL),
 (80,'2017-04-24 00:00:00','madhuri.teluguti123@gmail.com',0x00,'9100536255','e552b54294fb78b20af64c86565bf274','ACTIVE','Madhuri Teluguti',1,NULL),
 (81,'2017-04-29 00:00:00','sowjanya.palthady05@gmail.com',0x00,'9972108085','938bcf70fc2c9119ca4e299573c85ce7','ACTIVE','Sowjanya P',6,NULL),
 (82,'2017-04-29 00:00:00','kandraswathi@gmail.com',0x00,'9535135304','1e8ac106d0ec6ff6bd17e59cefc28e0b','ACTIVE','Swathi G N',6,NULL),
 (83,'2017-04-29 00:00:00','shwetaghatage4@gmail.com',0x00,'8431602110','1dede605b0a4732bd2e6648ce5c5dfac','ACTIVE','shweta',6,NULL),
 (84,'2017-04-29 00:00:00','me.akanksha09@gmail.com',0x01,'0930411036','30bafae5708a9e9a6daa58609b64eab0','ACTIVE','Akanksha Kumari',3,NULL),
 (85,'2017-04-29 00:00:00','rs21thur@gmail.com',0x00,'8880122743','055451e39bad2800bd48d0df585b4a55','ACTIVE','ritu sharma',6,NULL),
 (86,'2017-04-29 00:00:00','sarojbala.7.1995@gmail.com',0x00,'7019398052','2d717122ad139edf6d7178bd4a864c0c','ACTIVE','Saroj Bala',3,NULL),
 (87,'2017-04-29 00:00:00','anveshkumarnaidu402@gmail.com',0x00,'8801531511','4da2c99f487726b7cbb048e9a568db76','ACTIVE','Anvesh kumar',6,NULL),
 (88,'2017-04-29 00:00:00','benikilakshmireddy@gmail.com',0x00,'9642080517','12c6d81ece658b1791e04f1ce75a4878','ACTIVE','benikilakshmireddy',6,NULL),
 (89,'2017-04-29 00:00:00','harsharajasekhar46@gmail.com',0x00,'9066990086','94de8e93b3b90b647a944e7abcbcf9a1','ACTIVE','Harsha Rajasekhar',6,NULL),
 (90,'2017-04-29 00:00:00','rudrayyaswamy248@gmail.com',0x01,'9945062414','7bc7cff7479ba68b36cf99f5db58b1de','ACTIVE','Rudrayya swamy',6,NULL),
 (91,'2017-04-29 00:00:00','prakhartrivedi84@gmail.com',0x00,'8005318909','ea11c7516fba8af729a7e013bb7ee622','ACTIVE','prakhar trivedi',6,NULL),
 (92,'2017-05-13 00:00:00','siladityadatta@gmail.com',0x01,'7076977210','780bc6239c0824369060fa93b352dec4','ACTIVE','Siladitya Datta',1,NULL),
 (93,'2017-05-13 00:00:00','shiv8982@gmail.com',0x00,'8964937616','ff286e643fd83a16206c29ecbab6e70d','ACTIVE','Shivpal Lahare',3,NULL),
 (94,'2017-05-13 00:00:00','sabarish1610@gmail.com',0x00,'9092907574','279ef035c53d03f2f5ebbb8aa87b4cfb','ACTIVE','sabarish',3,NULL),
 (95,'2017-05-13 00:00:00','gauthamsundar93@gmail.com',0x00,'9538223626','4dae8b5ad09de148dd746a6ecbeb7ed4','ACTIVE','Gowtham  S',6,NULL),
 (96,'2017-05-13 00:00:00','jagadeeswari.racheti@gmail.com',0x00,'8884568566','9662620c6132052b7cfcbd6ae3b17c31','ACTIVE','R Jagadeeswari',6,NULL),
 (97,'2017-05-13 00:00:00','s.thakur432@gmail.com',0x00,'7411428218','ed218e06b885297d0750b65be5e4041e','ACTIVE','shubhankar Thakur',6,NULL),
 (98,'2017-05-13 00:00:00','shantanu.goyal26@gmail.com',0x01,'7974904942','bba20f3072befe94563825d40c9e06b9','ACTIVE','Shantanu Goyal',6,NULL),
 (99,'2017-05-13 00:00:00','sowmyarsowmyar@gmail.com',0x01,'9901860772','8aa6bca700f1dc7b5d1d261c3acc39c9','ACTIVE','Sowmya R',6,NULL),
 (100,'2017-05-13 00:00:00','manisha.avula@gmail.com',0x01,'7013848230','f9b60782768cbe0c7919947bc26ade64','ACTIVE','Manisha',6,NULL),
 (101,'2017-05-13 00:00:00','meena.idde@gmail.com',0x00,'9652742435','c4735e5a48672a0dd04817dc7fb261c0','ACTIVE','meenakshi idde',6,NULL),
 (102,'2017-05-13 00:00:00','ramkumaryadav793@gmail.com',0x00,'8861016235','e34cd110c1328e09e86641f12bac43e5','ACTIVE','Ram Kumar',3,NULL),
 (103,'2017-05-13 00:00:00','bprabhakaranece@gmail.com',0x00,'9738122204','afc2c56cac05fdb30c67f9b13455018a','ACTIVE','prabhakaran',3,NULL),
 (104,'2017-05-13 00:00:00','test.raj@gmail.com',0x00,'8879789787','123456','ACTIVE','sri ram',7,NULL),
 (105,'2017-05-15 00:00:00','sonubdas@gmail.com',0x00,'7403253250','b2f4a10b541289379895a02ca1216708','ACTIVE','sonu.b',1,NULL),
 (106,'2017-05-15 00:00:00','kishor8256@gmail.com',0x00,'8848913621','3121c694eb17eddffca4d937f8a1ebef','ACTIVE','kishor kumar',6,NULL),
 (107,'2017-05-16 00:00:00','sivaprasadmuddineni@gmail.com',0x00,'9642260049','d3a47884c65780c2a916fb432d6dbd18','ACTIVE','siva prasad m',6,NULL),
 (108,'2017-05-16 00:00:00','anitamalad6@gmail.com',0x00,'9008581421','ca012c0a96349e3fb73552c2be8621a7','ACTIVE','Anita S malad',6,NULL),
 (109,'2017-05-16 00:00:00','srividyaashok333@gmail.com',0x00,'8553898581','e73cd4afbc9c65af72ec8b26615a1973','ACTIVE','Srividya ashok',6,NULL),
 (110,'2017-05-16 00:00:00','venkycharanteja@gmail.com',0x00,'9550676719','4341c5a2eec330a83fedbef8374e1fc1','ACTIVE','venkatesh',4,NULL),
 (111,'2017-05-17 00:00:00','ranjithabj888@gmail.com',0x00,'7204550780','5cf3c23e8774896e4428e248c0399009','ACTIVE','Ranjitha BJ',4,NULL),
 (112,'2017-05-17 00:00:00','vidyamuddi2@gmail.com',0x00,'9902799396','a13ba50627f6da04d67914a0c9133ef7','ACTIVE','Vidya Muddi',6,NULL),
 (113,'2017-05-17 00:00:00','rahul2101992@gmail.com',0x00,'9497892948','2acb7811397a5c3bea8cba57b0388b79','ACTIVE','rahul c',6,NULL),
 (115,'2017-05-22 00:00:00','gsivak19@gmail.com',0x01,'9663667670','e10adc3949ba59abbe56e057f20f883e','ACTIVE','siva',1,NULL),
 (116,'2017-05-22 00:00:00','k.saikumarsingh@gmail.com',0x00,'8885805840','7a2d4794b0b51de6b1f73c1a68133ba8','ACTIVE','Sai Kumar Singh',1,NULL),
 (117,'2017-05-26 00:00:00','tank.vikram@gmail.com',0x01,'8000682718','46be2ab980c118395239a1c3a54a318c','ACTIVE','Vikram Tank',1,NULL),
 (118,'2017-05-28 00:00:00','bhaskar2222@gmail.com',0x00,'9482421337','e99a18c428cb38d5f260853678922e03','ACTIVE','TestHR',7,NULL),
 (119,'2017-05-29 00:00:00','dinesh777tyagi@gmail.com',0x01,'8107867457','21fb40e56bf413b62ee6d96face6f2b1','ACTIVE','Dinesh Chand',1,NULL),
 (120,'2017-05-31 00:00:00','venkymachavaram5543@gmail.com',0x00,'7013233426','4341c5a2eec330a83fedbef8374e1fc1','ACTIVE','venkatesh',4,NULL),
 (121,'2017-06-03 00:00:00','maaz.sayyid@gmail.com',0x01,'9980080983','fdc9c668c311209bec55552c75bc70f3','ACTIVE','Maaz Syed',1,NULL),
 (122,'2017-06-03 00:00:00','nitinrawa999@gmail.com',0x01,'9992766602','8c71eede42e38709e9e836021b0b9b9b','ACTIVE','Nitin',3,NULL),
 (123,'2017-06-03 00:00:00','pooja196sh@gmail.com',0x00,'9620612047','a178a9b9d31cbf3e311d9f496c8010e9','ACTIVE','pooja sharma',6,NULL),
 (124,'2017-06-03 00:00:00','kirti.sundriyal.s@gmail.com',0x00,'9611602152','c85792b0344eb0e354a59c35519455a2','ACTIVE','kirti',6,NULL),
 (125,'2017-06-03 00:00:00','avinashm720@gmail.com',0x00,'8867726960','e10adc3949ba59abbe56e057f20f883e','ACTIVE','Avinash Mishra',6,NULL),
 (126,'2017-06-03 00:00:00','cse.raj999@gmail.com',0x00,'8147704658','16f85293e920fd49eda6bf0df98bfd33','ACTIVE','Alok raj',6,NULL),
 (127,'2017-06-03 00:00:00','nunnahemanth06@gmail.com',0x00,'9666916393','1df8f6559b51e720f66d1bceb6620249','ACTIVE','nunna hemanth',1,NULL),
 (128,'2017-06-04 00:00:00','velidiaparna@gmail.com',0x00,'8500002535','d051df0e189dff4f6487d63d6edf9f69','ACTIVE','Velidi Aparna',1,NULL),
 (129,'2017-06-05 00:00:00','vattemsireesha@gmail.com',0x00,'9686070252','b37ec2f610ca0873a4922f380566c1ce','ACTIVE','SIREESHA',1,NULL),
 (130,'2017-06-07 00:00:00','saivinodhirala@gmail.com',0x00,'7285954910','e10adc3949ba59abbe56e057f20f883e','ACTIVE','sai vinod',1,NULL),
 (132,'2017-06-10 00:00:00','shadablaptop@gmail.com',0x00,'9406348216','2291062c7e0f7f69fb16540519ade56d','ACTIVE','Shadab Shamsi',3,NULL),
 (133,'2017-06-10 00:00:00','bharath.parishwad191@gmail.com',0x00,'8095017440','a1821f30114cc921206b52a41c1e4308','ACTIVE','Bharath Parishwad',6,NULL),
 (134,'2017-06-10 00:00:00','amitkumar25011993@gmail.com',0x00,'7026335761','2ef962f418d675d64942c7611a117e08','ACTIVE','Amit Kumar',2,NULL),
 (135,'2017-06-10 00:00:00','gopinadh979@gmail.com',0x00,'9642177792','f337b3a7c31bca001c4c32d4ecdb5568','ACTIVE','KARUMURI GOPI NADH',6,NULL),
 (136,'2017-06-10 00:00:00','sowmiyaa19@gmail.com',0x00,'9626121129','0be9718cb0a99e53a4bd7532e1bed16c','ACTIVE','Sowmiyaa C',2,NULL),
 (137,'2017-06-10 00:00:00','shobhanrs.n@gmail.com',0x00,'8971374813','73a1865dba072c46568d3204c8112e27','ACTIVE','shobha N',6,NULL),
 (138,'2017-06-10 00:00:00','abhilash.91@gmail.com',0x00,'9035892126','1b07b650cf5a747a71347e57a06b3ee9','ACTIVE','ABHILASH V R',6,NULL),
 (139,'2017-06-10 00:00:00','sahibakaur80000@gmail.com',0x00,'9303439998','74420fa1380ed8f922c825a43431269a','ACTIVE','Jaspreet Kaur Bhatia',6,NULL),
 (140,'2017-06-10 00:00:00','chetanpise.dwd11@gmail.com',0x00,'7795067960','dad339fa912cc2c0276b83ea7ff6cf8a','ACTIVE','chetan',1,NULL),
 (141,'2017-06-10 00:00:00','prashantjumanal1@gmail.com',0x00,'9740722703','84ef09f99682233cee0b8e73cd9128db','ACTIVE','PARASHURAM JUMANAL',1,NULL),
 (142,'2017-06-10 00:00:00','shruti.itagi9@gmail.com',0x00,'8971524503','93ce26f778c08c065075c5edbf4a4b32','ACTIVE','shruti',7,NULL),
 (144,'2017-06-12 00:00:00','abhishekashok93@gmail.com',0x01,'9738702686','800fdd917387e38c4fc744e58ba8b20c','ACTIVE','ABHISHEK M A',1,NULL),
 (145,'2017-06-15 00:00:00','karthikeyan4595@gmail.com',0x01,'9160247457','633ea6603b98bd4a733d4de154e90c4d','ACTIVE','R KARTHIKEYAN',1,NULL),
 (146,'2017-06-16 00:00:00','akhilcds235@gmal.com',0x00,'9550282434','7caeaba5a2048fe814e5c80f66d9d050','ACTIVE','AKHIL',1,NULL),
 (150,'2017-06-19 00:00:00','apparao.keerthi4@gmail.com',0x01,'7013456455','52c1ab66e71344bac4f74ddaab5c9f16','ACTIVE','Apparao',1,NULL),
 (151,'2017-06-20 00:00:00','saisivakumar03@gmail.com',0x01,'8095843937','3667da106f9c76c908d112c9c816c00e','ACTIVE','shiva kumar',4,NULL),
 (152,'2017-06-20 00:00:00','raga.lallu@gmail.com',0x01,'8801955687','433e9f75a647687387eb607c821c6fc8','ACTIVE','Raghavendra',1,NULL),
 (153,'2017-06-20 00:00:00','rishabhksahu28@gmail.com',0x01,'7071687467','9007fc6ea86802faf34cc98daff2574f','ACTIVE','rishabh kumar',4,NULL),
 (154,'2017-06-20 00:00:00','chaitanya.rangam46@gmail.com',0x01,'9964393408','09efddb8fbd9ab7c08d18255b5c6c8cf','ACTIVE','CHAITANYA RANGAM',4,NULL),
 (155,'2017-06-21 00:00:00','agnel4211@gmail.com',0x01,'9500539608','985f4c123dd74aeb5520ffdba9e2b86d','ACTIVE','AGNEL A',1,NULL),
 (156,'2017-06-21 00:00:00','reenasisodiya07@gmail.com',0x01,'9066813997','e31793c5a3a994a381a75d7fc3016bd4','ACTIVE','Reena Sisodiya',3,NULL),
 (157,'2017-06-21 00:00:00','siddhumudiraj405@gmail.com',0x01,'9700066213','2a626705e5dbd25105f5ed1d7ba74fc9','ACTIVE','sridhar',1,NULL),
 (160,'2017-06-21 00:00:00','ramesh.panduga95@gmail.comb',0x01,'9550631614','a3748ed901d4d06249cbc42fb55fcc93','ACTIVE','Ramesh Panduga',6,NULL),
 (161,'2017-06-21 00:00:00','jahnavidhupam@gmail.com',0x01,'8179023837','9c959eaed5af6b893f11755d84268225','ACTIVE','Jahnavi Dhupam',6,NULL),
 (162,'2017-06-21 00:00:00','durga.ravula25@gmil.com',0x01,'9652051450','f315aa12967cedf9d5cf544f3a73fa58','ACTIVE','ravula naga venkata durga',1,NULL),
 (163,'2017-06-21 00:00:00','alk.mani.k@gmail.com',0x01,'9573393356','a1cdcb4b091e3f7bb408132384dc05f0','ACTIVE','A.L.K.Mani Kumar',6,NULL),
 (164,'2017-06-21 00:00:00','sravaniavula406@gmail.com',0x01,'7794059578','9b97f6d83cb63f3950ce64d7b35db5d4','ACTIVE','Sravani.Avula',6,NULL),
 (165,'2017-06-21 00:00:00','rnvdurgadevi4@gmail.com',0x01,'9652051450','f315aa12967cedf9d5cf544f3a73fa58','ACTIVE','r.n.v.durga',1,NULL),
 (166,'2017-06-21 00:00:00','sanjusunkara@gmal.com',0x01,'7416781224','aa4e6176ffa5961c295c15ffab1d676d','ACTIVE','Lakshmi Raga Sandhya',1,NULL),
 (167,'2017-06-21 00:00:00','tarun.santu525@gmail.com',0x01,'9618552611','3fc0a7acf087f549ac2b266baf94b8b1','ACTIVE','Tarun',6,NULL),
 (168,'2017-06-21 00:00:00','chiru.kanakala@gmail.com',0x01,'9553227456','a6c4aa4445c40eb19c619cda5585df22','ACTIVE','k.chiranjeevi',1,NULL),
 (169,'2017-06-21 00:00:00','p.ramesh95@icloud.com',0x01,'9603630107','a3748ed901d4d06249cbc42fb55fcc93','ACTIVE','Ramesh Panduga',1,NULL),
 (170,'2017-06-21 00:00:00','veerendragandham@gmail.com',0x01,'8977752819','2f297ff70cedbc87816b2a5a46015314','ACTIVE','veerendra gandham',1,NULL),
 (171,'2017-06-21 00:00:00','venkatasravani430@gmail.com',0x01,'9603807069','6982ef6e9ac31c2506510dd6876db762','ACTIVE','Gurram Venkata Sravani',6,NULL),
 (172,'2017-06-21 00:00:00','satyanarayanadaadi@gmail.com',0x01,'9492654205','15c766f16e2ab25eb88cf993910a799b','ACTIVE','SATYANARAYANADAADI',6,NULL),
 (173,'2017-06-21 00:00:00','babby.andey@gmail.com',0x01,'9100212028','bcdaa8973a9542fea8771cc57838300f','ACTIVE','Andey naga venkata satyanarayana',6,NULL),
 (174,'2017-06-21 00:00:00','satyadaadi5@gmail.com',0x01,'8519969886','02df847f534ef2a1c7bf4433c7900ec3','ACTIVE','satyanarayanadaadi',1,NULL),
 (176,'2017-06-22 00:00:00','praveenkumarramisetti@gmail.com',0x01,'9989790272','977c0156d7403e2bebba75cdf5652678','ACTIVE','Praveen Kumar Ramisetti',6,NULL),
 (177,'2017-06-22 00:00:00','shashankharsh@rocketmail.com',0x01,'8106694859','10837d69bf7bc57d670466306a08045b','ACTIVE','Shashank Harsh',6,NULL),
 (179,'2017-06-22 00:00:00','rajarajeswari.chandu@gmail.com',0x01,'9505153690','58a515f931b4209188cb688fcb61e247','ACTIVE','Chandu.Raja Rajeswari',6,NULL),
 (180,'2017-06-22 00:00:00','kusumapriya48@gmal.com',0x01,'9642264479','e10adc3949ba59abbe56e057f20f883e','ACTIVE','kusuma priya',6,NULL),
 (181,'2017-06-22 00:00:00','kavyapuri29@gmail.com',0x01,'9885815111','8cb5d71953274b1590c1709d6a1055d7','ACTIVE','kavya puri',6,NULL),
 (182,'2017-06-22 00:00:00','sarvesh.bablu@gmail.com',0x00,'9948010414','f7cb650264820a6e35f937fd28328385','ACTIVE','VARRE SARVESWARARAO',6,NULL),
 (184,'2017-06-22 00:00:00','manoharthati00@gmail.com',0x01,'9666598222','9affaf7dd9563dfcd3d6e554b9162b8e','ACTIVE','Thati Manohar',1,NULL),
 (185,'2017-06-22 00:00:00','suresh.padam5@gmail.com',0x01,'8464891468','3e6a0966890c85a8ca932302ad6a2405','ACTIVE','suresh',1,NULL),
 (186,'2017-06-22 00:00:00','priyamadireddy533@gmail.com',0x01,'9000977971','977c0156d7403e2bebba75cdf5652678','ACTIVE','kusuma priya',1,NULL),
 (187,'2017-06-22 00:00:00','kusumapriyamadireddy@gmail.com',0x01,'9642264479','977c0156d7403e2bebba75cdf5652678','ACTIVE','kusumapriya',1,NULL),
 (188,'2017-06-22 00:00:00','ansadhk45@gmail.com',0x01,'7097492961','c164a1ceea111721aecf527b81091597','ACTIVE','Ansadh',1,NULL),
 (189,'2017-06-23 00:00:00','yogithanagisetti@gmail.com',0x01,'9032307868','a631ab215bbc902942f2cef316951e36','ACTIVE','Yogitha',1,NULL),
 (190,'2017-06-23 00:00:00','harpreet.er90@gmail.com',0x01,'7986142094','6325c976e08346e8de6ad46a6e42f3d7','ACTIVE','harpreet',1,NULL),
 (191,'2017-06-23 00:00:00','vasundarachinthas@gmail.com',0x01,'7416256269','4aa6eced572d791636ae3e66a6edd9e7','ACTIVE','c.vasundara',1,NULL),
 (192,'2017-06-23 00:00:00','annabathulasai@gmail.com',0x01,'9397932999','289792ef2874c869d7ef03f2ad75b273','ACTIVE','sainadh',1,NULL),
 (193,'2017-06-23 00:00:00','sanju.honey95@gmail.com',0x01,'8330981740','f29124946949419104ad52395acdf2ed','ACTIVE','Sanju Rakonde',1,NULL),
 (194,'2017-06-23 00:00:00','tbharathkumar509@gmail.com',0x01,'8309828080','57f2f9902b649b08d355db258b3925db','ACTIVE','Bharath',6,NULL),
 (195,'2017-06-23 00:00:00','sainadh4455@gmail.com',0x01,'9182991398','289792ef2874c869d7ef03f2ad75b273','ACTIVE','sainadh',1,NULL),
 (196,'2017-06-23 00:00:00','k.avishek33@yahoo.com',0x01,'8985870284','6558e3f0babb1725131cf4cb032f209b','ACTIVE','AVISHEK KOTINA',6,NULL),
 (197,'2017-06-23 00:00:00','nadendla.siddhartha@gmail.com',0x01,'9491974177','8de6c68022de7f07bdc4265401ef6378','ACTIVE','nadendla siddhartha',1,NULL),
 (198,'2017-06-23 00:00:00','sravankumar96428@gmail.com',0x01,'8790405964','9fef676dcb91846d5487274c7f309c6d','ACTIVE','sravan',1,NULL),
 (199,'2017-06-23 00:00:00','pullareddy970@gmail.com',0x01,'8106533184','81f871b254762acfa97c2f3a51421b63','ACTIVE','pullareddy',1,NULL),
 (200,'2017-06-23 00:00:00','saiteja.aavula@gmail.com',0x01,'9553854842','518049c197b8a804806b198c8182e828','ACTIVE','sai aavula',4,NULL),
 (201,'2017-06-23 00:00:00','vamshiyadav6@gmail.com',0x01,'8977625425','16bde43c411a5b8beebe6798a261ad23','ACTIVE','VamshiYadav',6,NULL),
 (202,'2017-06-23 00:00:00','chandrikabode3@gmail.com',0x01,'9705597659','ec36e9ea569747847a9a01e3b577af24','ACTIVE','CHANDRIKA BODE',1,NULL),
 (203,'2017-06-23 00:00:00','gujjarlapudi.pradeep@gmail.com',0x01,'9666953589','0deaa0f11a3525577b39c4f46dbb5218','ACTIVE','Gujjarlapudi Pradeep',1,NULL),
 (204,'2017-06-23 00:00:00','jlakshmiprasad0@gmail.com',0x01,'9705399257','56fd37a517175d6580217dbecc715f8c','ACTIVE','Jami Lakshmi prasad',1,NULL),
 (205,'2017-06-23 00:00:00','pushpa.venna@gmail.com',0x01,'9490560528','1a16711d3f5492d026771ba8c64fe1ea','ACTIVE','venna pushpa',1,NULL),
 (206,'2017-06-23 00:00:00','himabindu806@gmail.com',0x01,'7382768843','a0eee11e27d8fcebf40b5f4d159e228e','ACTIVE','Avula Hima Bindu',1,NULL),
 (207,'2017-06-23 00:00:00','badilakshmi21@gmail.com',0x01,'7330940781','02eb02c881d7698294bf0eb273fbc54c','ACTIVE','Boddu Aadhi Lakshmi',1,NULL),
 (208,'2017-06-23 00:00:00','sivaece449@gmail.com',0x01,'9182292902','1eb51cf46dbaebdb0943817fec2d2eed','ACTIVE','Pendyala Sowjanya',1,NULL),
 (209,'2017-06-24 00:00:00','damodarsunil5@gmail.com',0x01,'9010267672','e496f6652caaa04fd8a7b8fbc13f8688','ACTIVE','Damodar',1,NULL),
 (210,'2017-06-24 00:00:00','satyaoduri999@gmail.com',0x01,'9100090141','5caac49fb122685bbd62e16847ef7a4f','ACTIVE','Divya naga satya',2,NULL),
 (211,'2017-06-24 00:00:00','muppanasettiraja@gmail.com',0x01,'9492444346','c60177110bef2f283fbef887ff36232a','ACTIVE','Raja',2,NULL),
 (212,'2017-06-25 00:00:00','prashuaits2009@gmail.com',0x01,'7661889807','203be16c89c01f96e6a09e353994115d','ACTIVE','Prasanthi',1,NULL),
 (213,'2017-06-25 00:00:00','kolasani.chandra@gmail.com',0x01,'7996322341','7c407491f4860a78e466dd03f592775e','ACTIVE','kolasani venkata PradeepChandra',1,NULL),
 (214,'2017-06-25 00:00:00','teegapuram.vindhya@gmail.com',0x01,'8790369065','5518a6e591c6b9209a14df11ff441ce2','ACTIVE','vindhya reddy',1,NULL),
 (215,'2017-06-25 00:00:00','Akhil.golconda@gmail.com',0x01,'9642642465','0eaa5436a62be3af31953242ab3ab9e8','ACTIVE','Akhil Golkonda',1,NULL),
 (216,'2017-06-25 00:00:00','samanthulasai@gmail.com',0x01,'9553866977','348f88ca98688788797decc9e49d8fb2','ACTIVE','Sai Sriinivas',6,NULL),
 (217,'2017-06-25 00:00:00','kravikumar2295@gmail.com',0x01,'9542943679','4b03b1b5052dce0ddca72c9e5e70b68c','ACTIVE','ravikumar',1,NULL),
 (218,'2017-06-25 00:00:00','yashmandavia03@gmail.com',0x01,'9326146898','7c8e55017047da98280ffc423fadcf90','ACTIVE','YASH',1,NULL),
 (219,'2017-06-25 00:00:00','hemant0328@gmail.com',0x01,'8464868507','211b4687237699800df95baf98524352','ACTIVE','Ginni Hema Sundara Rao',1,NULL),
 (220,'2017-06-25 00:00:00','devarakondalenin@gmail.com',0x01,'9542782523','2edb57010329dcf29eccdd0a7a375ed9','ACTIVE','lenin babu.devarakonda',1,NULL),
 (221,'2017-06-25 00:00:00','supriyadara1@gmail.com',0x01,'9177521922','261571e1b27ab97fdc35bae9dd4df322','ACTIVE','supriya dara',1,NULL),
 (222,'2017-06-25 00:00:00','pnmkreddy21@gmail.com',0x01,'9177551794','c5cba074acf24cee6f7719ed29da1767','ACTIVE','manikantareddy',6,NULL),
 (223,'2017-06-25 00:00:00','udaychowdary619@gmail.com',0x01,'8464847195','b364ba7b5ea86d2d1fe752668879106f','ACTIVE','UdayKumar.N',1,NULL),
 (224,'2017-06-25 00:00:00','sekharch377@gmail.com',0x01,'7799110785','7802c0c8bd8f5daacedd69c0a096ea6a','ACTIVE','CHEEPURUPALLI POORNA SEKHAR',1,NULL),
 (225,'2017-06-25 00:00:00','sekharch377@yahoo.com',0x01,'7799110785','7802c0c8bd8f5daacedd69c0a096ea6a','ACTIVE','poorna sekhar',1,NULL),
 (226,'2017-06-28 00:00:00','srichallamalla935@gmail.com',0x01,'9491250363','abdad2eef6cc6ca1812a3e09dc835e0f','ACTIVE','ch sridevi',1,NULL),
 (227,'2017-06-28 00:00:00','saikrishnakhumbam@gmail.com',0x01,'9032263513','d8e16f3a83f761f665d58755d0088223','ACTIVE','sai krishna',1,NULL),
 (228,'2017-06-29 00:00:00','brmvenkatesh.yendluri@gmail.com',0x01,'8688988424','1dc301b173ab9e46cea2c7b66704b5c1','ACTIVE','Yendluri Bulli Rama Manikanta Venkatesh',1,NULL),
 (229,'2017-06-29 00:00:00','kiranmvijay@yahoo.in',0x01,'8892918055','afcd245e9971075eede4b80e8e8448b1','ACTIVE','Kiran M Vijay',1,NULL),
 (230,'2017-06-29 00:00:00','seema.yaladagi156@gmail.com',0x01,'9845214968','7fdb9098e6e9408f6cbab27ec8e55041','ACTIVE','Seema Yaladagi',1,NULL),
 (231,'2017-06-29 00:00:00','lipsamuni20@gmail.com',0x01,'9538815028','c436015a7f0b7cbd7eced6246da66bd9','ACTIVE','Lipsa Muni',1,NULL),
 (232,'2017-06-29 00:00:00','msahu1190@gmail.com',0x01,'8884632085','05182929a802f6a749dde2e82fc5a314','ACTIVE','madhusmita sahu',1,NULL),
 (233,'2017-06-29 00:00:00','kanakareddy244@gmail.com',0x01,'8147700995','219490259e6f8cd5b9d8a98fe695b80d','ACTIVE','yamini',6,NULL),
 (234,'2017-06-30 00:00:00','bony.ghotlu@gmail.com',0x01,'9113223780','1ce4e501ba5db53970e10fef8c6e0df6','ACTIVE','Sandhya Kishore',1,NULL),
 (235,'2017-06-30 00:00:00','jahan.nusrat.itworld@gmail.com',0x01,'7003592591','66c1a8afc7bf21fbff83da634331cb8c','ACTIVE','Nusrat Jahan',1,NULL),
 (236,'2017-06-30 00:00:00','subir.prasad18@gmail.com',0x01,'9830602583','741fda233088870d5acc1608554ded8f','ACTIVE','Subir Kumar Prasad',1,NULL),
 (237,'2017-06-30 00:00:00','kavithau1792@gmail.com',0x01,'9487024379','98413e147241b45008ad0fcd1562ab09','ACTIVE','kavitha',1,NULL),
 (238,'2017-06-30 00:00:00','meghana.pyati@gmail.com',0x01,'8050119835','cf2adae9d144dc5a2fa7f641a65915b8','ACTIVE','Meghana.G',1,NULL),
 (239,'2017-06-30 00:00:00','gayatrimitaighar@gmail.com',0x01,'7795450881','540825e67440261d96e973ffeee82e4d','ACTIVE','Gayatri M',1,NULL),
 (240,'2017-06-30 00:00:00','nirmalchitlangi@gmail.com',0x01,'9666006787','cb7e7561dd88302876d38f656ee14d15','ACTIVE','Nirmal chitlangi',1,NULL),
 (241,'2017-06-30 00:00:00','tamalikaroy.1990.it@gmail.com',0x01,'8017409054','0ff737328f78499eec52856d5b35952b','ACTIVE','TAMALIKA ROY',1,NULL),
 (242,'2017-07-01 00:00:00','suryapriya20dec@gmail.com',0x01,'8838426254','a115ebb7f8129da0af526aa7c720f2e2','ACTIVE','Surya Priya',1,NULL),
 (243,'2017-07-03 00:00:00','pranavchandrawat5@gmail.com',0x01,'7619116155','1b9e34a1a20992d16204d678a02b4ab3','ACTIVE','pranavpal singh chandrawat',1,NULL),
 (244,'2017-07-03 00:00:00','nekkala.appaji@gmail.com',0x01,'9986687239','e10adc3949ba59abbe56e057f20f883e','ACTIVE','appaji',3,NULL),
 (245,'2017-07-05 00:00:00','jyothsnagudivada@gmail.com',0x01,'9738667177','2492c1cf43c84517ddc186e95176d332','ACTIVE','jyothsna gudivada',1,NULL),
 (246,'2017-07-06 00:00:00','vinutash123@gmail.com',0x01,'7795516959','30a5c2dabc9107a4e299a62fb41f96d6','ACTIVE','Vinuta Hosakeri',1,NULL),
 (247,'2017-07-06 00:00:00','shrishailgb123@gmail.com',0x01,'9538337222','3baef0f86b7133d780733f37b036aac1','ACTIVE','Shrishail G B',1,NULL),
 (248,'2017-07-08 00:00:00','palavanish920@gmail.com',0x01,'8004553885','ff5ed846cf278cee8752d23f8cb57eed','ACTIVE','Avanish Pal',1,NULL),
 (249,'2017-07-11 00:00:00','sunilkumarf4u@gmail.com',0x01,'7995239009','5060d8d8b8172fb497d811b8bc9c2e00','ACTIVE','sunil',1,NULL),
 (250,'2017-07-17 00:00:00','shaikzeelani7@gmail.com',0x01,'7770234542','2f74127b47f31c52c58bfd9978e9319e','ACTIVE','Zeelani Basha',1,NULL),
 (251,'2017-07-17 00:00:00','prasi0579@gmail.com',0x01,'7893646264','9942546a03bdace4108d55f0a23e0676','ACTIVE','prasanth kumar',1,NULL),
 (252,'2017-07-18 00:00:00','sarathballa143@gmail.com',0x01,'9441376223','8847aec3e13a4491505af090f3be0621','ACTIVE','Balla s m pavan sarath kumar',1,NULL),
 (253,'2017-07-24 00:00:00','ayyappapalivela96@gmail.com',0x00,'9573649496','f19ac15600db4457ce81dda20106779e','ACTIVE','venkata sai ayyappa',1,NULL),
 (254,'2017-07-26 00:00:00','srinivassangu02@gmail.com',0x01,'9603657166','2bcd4b9e31e7b55aacfb47af2c5ceb79','ACTIVE','srinivasa reddy sangu',1,NULL),
 (255,'2017-07-26 00:00:00','veerendra.vb@gmail.com',0x01,'9030661115','d593100ed5d2976b399ff93bf38df2e6','ACTIVE','veerendra babu velpuri',1,NULL),
 (256,'2017-07-26 00:00:00','snehalatha.reddy1231@gmail.com',0x01,'8978997025','0f8b0e419b17f4001f9b346efddf58e6','PENDING','c snehalatha',1,NULL),
 (257,'2017-07-26 00:00:00','devarintilavanya321@gmail.com',0x01,'9885689991','e89abf261b0c87086fad89af2da204c5','ACTIVE','lavanya.d',1,NULL),
 (258,'2017-07-27 00:00:00','rajumalladi448@gmail.com',0x01,'9542902321','e16aae6dbba2d870a45078af84cf9708','ACTIVE','Narasimharaju Malladi',7,NULL),
 (259,'2017-07-27 00:00:00','rajamuppanasetti@gmail.com',0x01,'7981849341','c60177110bef2f283fbef887ff36232a','ACTIVE','Raja',6,NULL),
 (260,'2017-07-27 00:00:00','muppanasetti@gmail.com',0x01,'8899889988','c60177110bef2f283fbef887ff36232a','ACTIVE','Raja',4,NULL),
 (261,'2017-07-28 00:00:00','mythily437@gmail.com',0x01,'9206705782','9e2113428f83d8ff1524b45c0041b92b','ACTIVE','Mythily G',1,NULL),
 (262,'2017-07-28 00:00:00','upendrareddy221@gmail.com',0x01,'8096624070','e89abf261b0c87086fad89af2da204c5','ACTIVE','CHINTALA UPENDRA REDDY',4,NULL),
 (263,'2017-07-28 00:00:00','pritikumari30193@gmail.com',0x01,'8871300520','c8334c8a355d216e4aad1d4b9ee07207','ACTIVE','priti kumari',1,NULL),
 (264,'2017-07-29 00:00:00','venkatsai9573@gmail.com',0x01,'7901264649','f19ac15600db4457ce81dda20106779e','ACTIVE','venkat sai',7,NULL),
 (265,'2017-07-29 00:00:00','vicky.polisetty@gmail.com',0x01,'9505600702','83fd2fb736b56c3b559e3ae60780ecdd','PENDING','Polisetty Raghu Vikas',1,NULL),
 (266,'2017-08-05 00:00:00','wwdsdsadas@gmail.com',0x01,'1234567890','585a32b10bf63cc329536ed8dbcb006a','ACTIVE','sai',5,NULL),
 (267,'2017-08-05 00:00:00','ppppppppppp@gmail.com',0x01,'0000000000','ef22cbee172258880fd316cb2b0cd2ed','ACTIVE','venkat sai',5,NULL),
 (268,'2017-08-06 00:00:00','dileep3535@gmail.com',0x01,'9573032525','17bfa5f315443bec45dc798773da02be','PENDING','dileepkumar',1,NULL),
 (269,'2017-08-07 00:00:00','lkjhgf@gmail.com',0x01,'9573649496','ef22cbee172258880fd316cb2b0cd2ed','PENDING','sai',7,NULL),
 (270,'2017-08-07 00:00:00','weytre@gmail.com',0x01,'0987654321','3805248410673a8be6aa4807e61fb5ae','PENDING','werty',7,NULL),
 (271,'2017-08-07 00:00:00','yuviyashu@gmail.com',0x01,'9900513394','77f16e97af291e6049dfd17a7a30c37b','ACTIVE','Yuvaraj K',1,NULL),
 (272,'2017-08-15 00:00:00','poornimaprasanna.j@gmail.com',0x01,'8277336371','6fd546d7a48f5bbd1698afea904dc61f','PENDING','poornima',1,NULL),
 (273,'2017-08-08 00:00:00','vamsivirtual@gmail.com',0x01,'8310202598','e10adc3949ba59abbe56e057f20f883e','ACTIVE','vamsihr',7,NULL),
 (274,'2017-08-08 00:00:00','vamsipo@gmail.com',0x00,'9888488828','e10adc3949ba59abbe56e057f20f883e','ACTIVE','vamsipo',8,NULL),
 (275,'2017-08-08 00:00:00','vamsicampus@gmail.com',0x00,'9876238762','e10adc3949ba59abbe56e057f20f883e','ACTIVE','vamsicampus',2,NULL),
 (518,'2017-09-14 00:00:00','sudhakar1415@gmail.com',0x01,'9868923643','e10adc3949ba59abbe56e057f20f883e','ACTIVE','sudhakar',6,NULL);
/*!40000 ALTER TABLE `user_mst_tbl` ENABLE KEYS */;


--
-- Definition of table `user_projects_tbl`
--

DROP TABLE IF EXISTS `user_projects_tbl`;
CREATE TABLE `user_projects_tbl` (
  `ID` bigint(20) NOT NULL AUTO_INCREMENT,
  `PROJECT_DESC` varchar(255) DEFAULT NULL,
  `END_START` datetime DEFAULT NULL,
  `TITLE` varchar(255) DEFAULT NULL,
  `RESPONSIBILITIES` varchar(255) DEFAULT NULL,
  `START_DATE` datetime DEFAULT NULL,
  `PROJECT_DOMAIN_ID` bigint(20) DEFAULT NULL,
  `USER_ID` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`ID`),
  KEY `FK_4nidb90uac72iea3ijb86hfw3` (`PROJECT_DOMAIN_ID`),
  KEY `FK_du2ya4tvpmb2yo4lufsp05fkd` (`USER_ID`),
  CONSTRAINT `FK_du2ya4tvpmb2yo4lufsp05fkd` FOREIGN KEY (`USER_ID`) REFERENCES `user_mst_tbl` (`ID`),
  CONSTRAINT `FK_4nidb90uac72iea3ijb86hfw3` FOREIGN KEY (`PROJECT_DOMAIN_ID`) REFERENCES `project_domain_mst_tbl` (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

--
-- Dumping data for table `user_projects_tbl`
--

/*!40000 ALTER TABLE `user_projects_tbl` DISABLE KEYS */;
INSERT INTO `user_projects_tbl` (`ID`,`PROJECT_DESC`,`END_START`,`TITLE`,`RESPONSIBILITIES`,`START_DATE`,`PROJECT_DOMAIN_ID`,`USER_ID`) VALUES 
 (1,'projecdesc','2017-09-30 00:00:00','p1','software developer','2017-08-30 00:00:00',1,275);
/*!40000 ALTER TABLE `user_projects_tbl` ENABLE KEYS */;


--
-- Definition of table `user_social_info_tbl`
--

DROP TABLE IF EXISTS `user_social_info_tbl`;
CREATE TABLE `user_social_info_tbl` (
  `ID` bigint(20) NOT NULL AUTO_INCREMENT,
  `FACEBOOK_ID` varchar(255) DEFAULT NULL,
  `SKYPE_ID` varchar(255) DEFAULT NULL,
  `TWITTER_ID` varchar(255) DEFAULT NULL,
  `WHATSAPP_NO` varchar(255) DEFAULT NULL,
  `USER_ID` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`ID`),
  KEY `FKA9C1BCCBD4819085` (`USER_ID`),
  CONSTRAINT `FKA9C1BCCBD4819085` FOREIGN KEY (`USER_ID`) REFERENCES `user_mst_tbl` (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=267 DEFAULT CHARSET=utf8;

--
-- Dumping data for table `user_social_info_tbl`
--

/*!40000 ALTER TABLE `user_social_info_tbl` DISABLE KEYS */;
INSERT INTO `user_social_info_tbl` (`ID`,`FACEBOOK_ID`,`SKYPE_ID`,`TWITTER_ID`,`WHATSAPP_NO`,`USER_ID`) VALUES 
 (1,NULL,NULL,NULL,NULL,116),
 (2,NULL,NULL,NULL,NULL,116),
 (3,'https://www.facebook.com/dinesh810tyagi/','dinesh777tyagi@gmail.com','https://twitter.com/TyagiChotu/',NULL,119),
 (4,NULL,NULL,NULL,NULL,1),
 (5,NULL,NULL,NULL,NULL,121),
 (6,NULL,NULL,NULL,'9992766602',122),
 (7,'pooja.lakshyaleader@outlook.com',NULL,NULL,'8294578257',123),
 (8,'alok.raj.71','araynt.raj999',NULL,'8147704658',126),
 (9,NULL,NULL,NULL,'9406348216',132),
 (10,'Bharath Parishwad',NULL,NULL,'8095017440',133),
 (11,NULL,NULL,NULL,'9626121129',136),
 (12,NULL,NULL,NULL,NULL,138),
 (13,'gopinadh979@gmail.com',NULL,NULL,'9642177792',135),
 (14,NULL,NULL,NULL,NULL,140),
 (15,NULL,NULL,NULL,NULL,140),
 (16,NULL,NULL,NULL,NULL,140),
 (17,'chetan HS',NULL,NULL,NULL,140),
 (18,'prashant jumanal',NULL,NULL,'9740722703',141),
 (19,'turuvekere abhi ashok',NULL,NULL,'9738702686',144),
 (22,'alk.mani.k@gmail.com',NULL,NULL,'9573393356',163),
 (23,NULL,NULL,NULL,'9030169752',167),
 (24,'RAMESH PANDUGA','9550631614',NULL,'9550631614',169),
 (25,'venkatasravani',NULL,NULL,NULL,171),
 (26,'https://www.facebook.com/shashank.harsh.1',NULL,'https://twitter.com/shashank_harsh','8106694859',177),
 (27,NULL,NULL,NULL,'9010267672',209),
 (28,NULL,NULL,NULL,NULL,212),
 (29,'gujjarlapudi.pradeep@gmail.com','gujjarlapudi.pradeep@gmail.com','gujjarlapudi.pradeep@gmail.com','9666953589',203),
 (30,'bulli.chowdary.5@facebook.com','8688988424',NULL,'8688988424',228),
 (31,'Hima Bindu Avula',NULL,NULL,NULL,226),
 (32,'seema.yaladagi156@g,mail.com','seemayaladagi','seema.yaladagi156@g,mail.com','9845214968',230),
 (33,'shrishailgb@gmail.com',NULL,NULL,'9538337222',247),
 (34,'vinutahosakeri@gmail.com',NULL,NULL,'7795516959',246),
 (35,'sai ayyappa',NULL,NULL,NULL,253),
 (36,'vamsi@facebook.com',NULL,NULL,'919880577218',34),
 (37,'Raja Muppanasetti','Raja Muppanasetti','Raja Muppanasetti','9492444346',211),
 (38,'raju malladi',NULL,NULL,'9542902321',258),
 (266,'facebook.com',NULL,NULL,'9880577218',275);
/*!40000 ALTER TABLE `user_social_info_tbl` ENABLE KEYS */;


--
-- Definition of table `user_submitted_tasks_tbl`
--

DROP TABLE IF EXISTS `user_submitted_tasks_tbl`;
CREATE TABLE `user_submitted_tasks_tbl` (
  `ID` bigint(20) NOT NULL AUTO_INCREMENT,
  `FILENAME` varchar(255) DEFAULT NULL,
  `USER_ID` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`ID`),
  KEY `FK_mwtsuxuj6qmqt35qffawnelxm` (`USER_ID`),
  CONSTRAINT `FK_mwtsuxuj6qmqt35qffawnelxm` FOREIGN KEY (`USER_ID`) REFERENCES `user_mst_tbl` (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `user_submitted_tasks_tbl`
--

/*!40000 ALTER TABLE `user_submitted_tasks_tbl` DISABLE KEYS */;
/*!40000 ALTER TABLE `user_submitted_tasks_tbl` ENABLE KEYS */;


--
-- Definition of table `user_tech_skills_trn_tbl`
--

DROP TABLE IF EXISTS `user_tech_skills_trn_tbl`;
CREATE TABLE `user_tech_skills_trn_tbl` (
  `ID` bigint(20) NOT NULL AUTO_INCREMENT,
  `TECH_SKILL_ID` bigint(20) DEFAULT NULL,
  `USER_ID` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`ID`),
  KEY `FK_tqas8h84pmrkblltyiek6d0o3` (`TECH_SKILL_ID`),
  KEY `FK_p8e9q90lm2e82n69uamkoyi1j` (`USER_ID`),
  CONSTRAINT `FK_p8e9q90lm2e82n69uamkoyi1j` FOREIGN KEY (`USER_ID`) REFERENCES `user_mst_tbl` (`ID`),
  CONSTRAINT `FK_tqas8h84pmrkblltyiek6d0o3` FOREIGN KEY (`TECH_SKILL_ID`) REFERENCES `technologies_mst_tbl` (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=324 DEFAULT CHARSET=utf8;

--
-- Dumping data for table `user_tech_skills_trn_tbl`
--

/*!40000 ALTER TABLE `user_tech_skills_trn_tbl` DISABLE KEYS */;
INSERT INTO `user_tech_skills_trn_tbl` (`ID`,`TECH_SKILL_ID`,`USER_ID`) VALUES 
 (1,1,33),
 (11,1,35),
 (12,2,35),
 (13,3,35),
 (14,5,35),
 (15,4,35),
 (16,1,37),
 (17,1,36),
 (18,2,36),
 (19,5,36),
 (20,3,36),
 (21,1,39),
 (22,1,40),
 (23,2,40),
 (24,3,40),
 (25,7,40),
 (26,2,41),
 (27,3,41),
 (28,5,41),
 (29,1,42),
 (30,5,42),
 (31,2,42),
 (32,3,42),
 (33,1,43),
 (34,5,43),
 (35,2,43),
 (36,3,43),
 (37,1,30),
 (38,2,30),
 (39,3,30),
 (40,4,30),
 (41,1,48),
 (42,2,48),
 (43,3,48),
 (44,5,48),
 (45,1,49),
 (46,1,51),
 (47,5,51),
 (48,2,51),
 (49,2,50),
 (50,5,50),
 (51,4,50),
 (52,2,52),
 (53,3,52),
 (54,5,52),
 (55,1,52),
 (56,1,55),
 (57,1,54),
 (58,1,57),
 (59,1,58),
 (60,2,58),
 (61,3,58),
 (62,4,60),
 (63,1,60),
 (64,1,63),
 (65,1,63),
 (66,6,63),
 (67,2,63),
 (68,1,63),
 (69,1,63),
 (70,1,63),
 (71,1,65),
 (72,2,65),
 (73,1,70),
 (74,1,73),
 (75,2,73),
 (76,3,73),
 (77,1,74),
 (78,1,75),
 (79,1,75),
 (80,1,75),
 (81,5,75),
 (82,5,75),
 (83,5,75),
 (84,5,75),
 (85,5,75),
 (86,1,76),
 (87,1,76),
 (88,7,76),
 (89,7,77),
 (90,1,78),
 (91,2,78),
 (92,3,78),
 (93,5,78),
 (94,1,24),
 (95,2,24),
 (96,3,24),
 (97,7,24),
 (98,2,81),
 (99,3,81),
 (100,5,81),
 (101,4,81),
 (102,2,82),
 (103,1,82),
 (104,1,84),
 (105,1,85),
 (106,2,85),
 (107,3,85),
 (108,2,86),
 (109,3,86),
 (110,5,86),
 (111,1,88),
 (112,1,89),
 (113,1,90),
 (114,3,90),
 (115,2,90),
 (116,1,91),
 (117,5,91),
 (118,2,91),
 (119,1,93),
 (120,1,94),
 (121,1,96),
 (122,1,96),
 (123,1,98),
 (124,1,99),
 (125,1,99),
 (126,1,103),
 (127,1,103),
 (128,1,103),
 (129,1,103),
 (130,1,103),
 (131,1,103),
 (132,1,103),
 (133,1,106),
 (134,1,106),
 (135,1,106),
 (136,5,106),
 (137,1,108),
 (138,2,108),
 (139,2,109),
 (140,3,109),
 (141,1,109),
 (142,1,112),
 (143,1,115),
 (144,1,116),
 (145,3,116),
 (146,2,116),
 (147,5,116),
 (148,1,119),
 (149,2,119),
 (150,3,119),
 (151,5,119),
 (152,1,121),
 (153,1,122),
 (154,4,123),
 (155,2,123),
 (156,3,123),
 (157,1,125),
 (158,1,124),
 (159,1,124),
 (160,1,124),
 (161,1,124),
 (162,1,126),
 (163,5,126),
 (164,1,132),
 (165,2,132),
 (166,5,132),
 (167,3,132),
 (168,1,136),
 (169,2,136),
 (170,5,136),
 (171,1,138),
 (172,1,140),
 (173,2,140),
 (174,3,140),
 (175,5,140),
 (176,5,135),
 (177,5,141),
 (178,1,144),
 (179,1,144),
 (180,1,145),
 (181,2,154),
 (182,3,154),
 (183,5,154),
 (184,4,154),
 (185,4,154),
 (186,4,129),
 (187,1,129),
 (188,1,155),
 (189,2,155),
 (190,1,155),
 (191,1,163),
 (192,2,163),
 (193,3,163),
 (194,5,163),
 (195,5,163),
 (196,7,163),
 (197,7,167),
 (198,1,167),
 (199,2,167),
 (200,5,167),
 (201,5,167),
 (202,5,167),
 (203,7,167),
 (204,1,169),
 (205,2,169),
 (206,2,169),
 (207,3,169),
 (208,3,169),
 (209,1,171),
 (210,1,171),
 (211,1,171),
 (212,2,171),
 (213,3,171),
 (214,5,171),
 (215,7,171),
 (216,1,177),
 (217,1,177),
 (218,7,177),
 (219,7,198),
 (220,1,209),
 (221,1,209),
 (222,2,209),
 (223,3,209),
 (224,5,209),
 (225,7,209),
 (226,1,212),
 (227,1,212),
 (228,1,203),
 (229,1,203),
 (230,2,203),
 (231,5,203),
 (232,3,203),
 (233,7,203),
 (234,1,228),
 (235,1,228),
 (236,7,228),
 (237,7,206),
 (238,1,230),
 (239,1,230),
 (240,1,230),
 (241,1,230),
 (242,7,230),
 (243,2,230),
 (244,3,230),
 (245,5,230),
 (246,5,14),
 (247,5,246),
 (248,1,237),
 (249,2,237),
 (250,2,237),
 (251,3,253),
 (252,2,253),
 (253,2,244),
 (254,3,244),
 (255,1,211),
 (256,1,211),
 (257,2,211),
 (258,3,211),
 (259,7,211),
 (260,7,211),
 (261,7,211),
 (262,7,211),
 (263,1,258),
 (264,1,258),
 (265,1,258),
 (284,1,34),
 (287,1,275),
 (322,2,518),
 (323,1,518);
/*!40000 ALTER TABLE `user_tech_skills_trn_tbl` ENABLE KEYS */;




/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;

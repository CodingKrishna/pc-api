-- MySQL Administrator dump 1.4
--
-- ------------------------------------------------------
-- Server version	5.0.86-community-nt


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;


--
-- Create schema pioneercoders
--

CREATE DATABASE IF NOT EXISTS pioneercoders;
USE pioneercoders;

--
-- Definition of table `batch_timing_trn_tbl`
--

DROP TABLE IF EXISTS `batch_timing_trn_tbl`;
CREATE TABLE `batch_timing_trn_tbl` (
  `ID` bigint(20) NOT NULL auto_increment,
  `DESCRIPTION` varchar(255) default NULL,
  `IMGPATH` varchar(255) default NULL,
  `BATCH_START_DATE` datetime default NULL,
  `TIMINGS` varchar(255) default NULL,
  `TRAINER_NAME` varchar(255) default NULL,
  `COURSE_ID` bigint(20) default NULL,
  PRIMARY KEY  (`ID`),
  KEY `FK4A68015F708C98F5` (`COURSE_ID`),
  CONSTRAINT `FK4A68015F708C98F5` FOREIGN KEY (`COURSE_ID`) REFERENCES `course_mst_tbl` (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `batch_timing_trn_tbl`
--

/*!40000 ALTER TABLE `batch_timing_trn_tbl` DISABLE KEYS */;
/*!40000 ALTER TABLE `batch_timing_trn_tbl` ENABLE KEYS */;


--
-- Definition of table `city_mst_tbl`
--

DROP TABLE IF EXISTS `city_mst_tbl`;
CREATE TABLE `city_mst_tbl` (
  `ID` bigint(20) NOT NULL auto_increment,
  `CITY_NAME` varchar(255) default NULL,
  `COUNTRY_ID` bigint(20) default NULL,
  `STATE_ID` bigint(20) default NULL,
  PRIMARY KEY  (`ID`),
  KEY `FKAE83C4B91C9DE3EF` (`COUNTRY_ID`),
  KEY `FK_rfk9tcvrtabneayyn8gdqqmjp` (`STATE_ID`),
  CONSTRAINT `FKAE83C4B91C9DE3EF` FOREIGN KEY (`COUNTRY_ID`) REFERENCES `country_mst_tbl` (`Id`),
  CONSTRAINT `FK_rfk9tcvrtabneayyn8gdqqmjp` FOREIGN KEY (`STATE_ID`) REFERENCES `state_mst_tbl` (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `city_mst_tbl`
--

/*!40000 ALTER TABLE `city_mst_tbl` DISABLE KEYS */;
/*!40000 ALTER TABLE `city_mst_tbl` ENABLE KEYS */;


--
-- Definition of table `coding_test_qtn_assign_to_user_trn_bl`
--

DROP TABLE IF EXISTS `coding_test_qtn_assign_to_user_trn_bl`;
CREATE TABLE `coding_test_qtn_assign_to_user_trn_bl` (
  `ID` bigint(20) NOT NULL auto_increment,
  `QUESTION_ID` bigint(20) default NULL,
  `USER_ID` bigint(20) default NULL,
  PRIMARY KEY  (`ID`),
  KEY `FKCFDDD52DD4819085` (`USER_ID`),
  KEY `FKCFDDD52D4F6B14AA` (`QUESTION_ID`),
  CONSTRAINT `FKCFDDD52D4F6B14AA` FOREIGN KEY (`QUESTION_ID`) REFERENCES `coding_test_qtn_tbl` (`ID`),
  CONSTRAINT `FKCFDDD52DD4819085` FOREIGN KEY (`USER_ID`) REFERENCES `user_mst_tbl` (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `coding_test_qtn_assign_to_user_trn_bl`
--

/*!40000 ALTER TABLE `coding_test_qtn_assign_to_user_trn_bl` DISABLE KEYS */;
INSERT INTO `coding_test_qtn_assign_to_user_trn_bl` (`ID`,`QUESTION_ID`,`USER_ID`) VALUES 
 (1,1,1),
 (2,2,1);
/*!40000 ALTER TABLE `coding_test_qtn_assign_to_user_trn_bl` ENABLE KEYS */;


--
-- Definition of table `coding_test_qtn_tbl`
--

DROP TABLE IF EXISTS `coding_test_qtn_tbl`;
CREATE TABLE `coding_test_qtn_tbl` (
  `ID` bigint(20) NOT NULL auto_increment,
  `IMG_PATH` varchar(255) default NULL,
  `LANGUAGE` varchar(255) default NULL,
  `POINTS` bigint(20) default NULL,
  `QUESTION_DESC` varchar(255) default NULL,
  `SAMPLE_CODE` varchar(255) default NULL,
  `TEST_CASES` varchar(255) default NULL,
  PRIMARY KEY  (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `coding_test_qtn_tbl`
--

/*!40000 ALTER TABLE `coding_test_qtn_tbl` DISABLE KEYS */;
INSERT INTO `coding_test_qtn_tbl` (`ID`,`IMG_PATH`,`LANGUAGE`,`POINTS`,`QUESTION_DESC`,`SAMPLE_CODE`,`TEST_CASES`) VALUES 
 (1,NULL,'JAVA',NULL,'Write the programm for String reversal ?','class MyFirstJavaProgram {\r\n		 public static void main(String[] args){ \r\n			System.out.println(\"Hello World\");\r\n			}\r\n		}','[{\"input\":\"pioneercoders\",\"output\":\"sredocreenoip\"},{\"input\":\"coding\",\"output\":\"gnidoc\"}]'),
 (2,NULL,'JAVA',NULL,'Write the programm for hellow world?','class MyFirstJavaProgram {\r\n		 public static void main(String[] args){ \r\n			System.out.println(\"Hello World\");\r\n			}\r\n		}','[{\"input\":\"\",\"output\":\"\"}]'),
 (3,NULL,NULL,NULL,'Write the code for finding the given number is prime or not?',NULL,'[{\"input\":\"3\",\"output\":\"prime number\"},{\"input\":\"6\",\"output\":\"not a prime number\"}]');
/*!40000 ALTER TABLE `coding_test_qtn_tbl` ENABLE KEYS */;


--
-- Definition of table `codingtest_results_mst_tbl`
--

DROP TABLE IF EXISTS `codingtest_results_mst_tbl`;
CREATE TABLE `codingtest_results_mst_tbl` (
  `ID` bigint(20) NOT NULL auto_increment,
  `POINTS` bigint(20) default NULL,
  `QUESTION_ID` bigint(20) default NULL,
  `USER_ID` bigint(20) default NULL,
  PRIMARY KEY  (`ID`),
  KEY `FK32480D01D4819085` (`USER_ID`),
  KEY `FK32480D014F6B14AA` (`QUESTION_ID`),
  CONSTRAINT `FK32480D014F6B14AA` FOREIGN KEY (`QUESTION_ID`) REFERENCES `coding_test_qtn_tbl` (`ID`),
  CONSTRAINT `FK32480D01D4819085` FOREIGN KEY (`USER_ID`) REFERENCES `user_mst_tbl` (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

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
  `ID` bigint(20) NOT NULL auto_increment,
  `COMPANY_NAME` varchar(255) default NULL,
  `URL_PATH` varchar(255) default NULL,
  `EMAIL_ID` varchar(255) default NULL,
  `LOGO` varchar(255) default NULL,
  `PHONE_NO` varchar(255) default NULL,
  PRIMARY KEY  (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `company_mst_tbl`
--

/*!40000 ALTER TABLE `company_mst_tbl` DISABLE KEYS */;
INSERT INTO `company_mst_tbl` (`ID`,`COMPANY_NAME`,`URL_PATH`,`EMAIL_ID`,`LOGO`,`PHONE_NO`) VALUES 
 (1,'Triecoders Pvt limited','www.triecoders.com','triecoders@gmail.com','Triecoders Pvt limited.undefined','1234567891');
/*!40000 ALTER TABLE `company_mst_tbl` ENABLE KEYS */;


--
-- Definition of table `contactus_mst_tbl`
--

DROP TABLE IF EXISTS `contactus_mst_tbl`;
CREATE TABLE `contactus_mst_tbl` (
  `ID` bigint(20) NOT NULL auto_increment,
  `COMMENTS` longtext,
  `CREATED_ON` datetime default NULL,
  `EMAIL_ID` varchar(255) default NULL,
  `MOBILE_NO` varchar(255) default NULL,
  `NAME` varchar(255) default NULL,
  `STATUS` varchar(255) default NULL,
  PRIMARY KEY  (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `contactus_mst_tbl`
--

/*!40000 ALTER TABLE `contactus_mst_tbl` DISABLE KEYS */;
/*!40000 ALTER TABLE `contactus_mst_tbl` ENABLE KEYS */;


--
-- Definition of table `country_mst_tbl`
--

DROP TABLE IF EXISTS `country_mst_tbl`;
CREATE TABLE `country_mst_tbl` (
  `Id` bigint(20) NOT NULL auto_increment,
  `COUNTRY_NAME` varchar(255) default NULL,
  PRIMARY KEY  (`Id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `country_mst_tbl`
--

/*!40000 ALTER TABLE `country_mst_tbl` DISABLE KEYS */;
/*!40000 ALTER TABLE `country_mst_tbl` ENABLE KEYS */;


--
-- Definition of table `course_mst_tbl`
--

DROP TABLE IF EXISTS `course_mst_tbl`;
CREATE TABLE `course_mst_tbl` (
  `ID` bigint(20) NOT NULL auto_increment,
  `CATEGORY` varchar(255) default NULL,
  `COURSE_DURATION` varchar(255) default NULL,
  `COURSE_NAME` varchar(255) default NULL,
  `COURSE_START_DATE` datetime default NULL,
  `DESC_PATH` varchar(255) default NULL,
  `IMAGE_PATH` varchar(255) default NULL,
  `IS_FEATURED_COURSE` bit(1) default NULL,
  `PRICE` float default NULL,
  `SHORT_DESC` longtext,
  `SORT_INDEX` int(11) default NULL,
  `STATUS` varchar(255) default NULL,
  PRIMARY KEY  (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `course_mst_tbl`
--

/*!40000 ALTER TABLE `course_mst_tbl` DISABLE KEYS */;
/*!40000 ALTER TABLE `course_mst_tbl` ENABLE KEYS */;


--
-- Definition of table `courses_payments_trn_tbl`
--

DROP TABLE IF EXISTS `courses_payments_trn_tbl`;
CREATE TABLE `courses_payments_trn_tbl` (
  `ID` bigint(20) NOT NULL auto_increment,
  `CREATED_ON` datetime default NULL,
  `PAID_AMOUNT` float default NULL,
  `RECEIVED_BY` varchar(255) default NULL,
  `USER_ID` bigint(20) default NULL,
  PRIMARY KEY  (`ID`),
  KEY `FKCE6DB744D4819085` (`USER_ID`),
  CONSTRAINT `FKCE6DB744D4819085` FOREIGN KEY (`USER_ID`) REFERENCES `user_mst_tbl` (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `courses_payments_trn_tbl`
--

/*!40000 ALTER TABLE `courses_payments_trn_tbl` DISABLE KEYS */;
/*!40000 ALTER TABLE `courses_payments_trn_tbl` ENABLE KEYS */;


--
-- Definition of table `eventparticipants_trn_tbl`
--

DROP TABLE IF EXISTS `eventparticipants_trn_tbl`;
CREATE TABLE `eventparticipants_trn_tbl` (
  `ID` bigint(20) NOT NULL auto_increment,
  `EVENT_ID` bigint(20) default NULL,
  `USER_ID` bigint(20) default NULL,
  PRIMARY KEY  (`ID`),
  KEY `FK32A178AA209E5856` (`EVENT_ID`),
  KEY `FK32A178AAD4819085` (`USER_ID`),
  CONSTRAINT `FK32A178AA209E5856` FOREIGN KEY (`EVENT_ID`) REFERENCES `events_tbl` (`ID`),
  CONSTRAINT `FK32A178AAD4819085` FOREIGN KEY (`USER_ID`) REFERENCES `user_mst_tbl` (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `eventparticipants_trn_tbl`
--

/*!40000 ALTER TABLE `eventparticipants_trn_tbl` DISABLE KEYS */;
/*!40000 ALTER TABLE `eventparticipants_trn_tbl` ENABLE KEYS */;


--
-- Definition of table `events_tbl`
--

DROP TABLE IF EXISTS `events_tbl`;
CREATE TABLE `events_tbl` (
  `ID` bigint(20) NOT NULL auto_increment,
  `EVENT_DATE` datetime default NULL,
  `EVENT_DESCRIPTION` varchar(255) default NULL,
  `EVENT_NAME` varchar(255) default NULL,
  `ORGANISED_BY` varchar(255) default NULL,
  `IMAGE_PATH` varchar(255) default NULL,
  PRIMARY KEY  (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `events_tbl`
--

/*!40000 ALTER TABLE `events_tbl` DISABLE KEYS */;
/*!40000 ALTER TABLE `events_tbl` ENABLE KEYS */;


--
-- Definition of table `expendature_mst_tbl`
--

DROP TABLE IF EXISTS `expendature_mst_tbl`;
CREATE TABLE `expendature_mst_tbl` (
  `ID` bigint(20) NOT NULL auto_increment,
  `BILL_PATH` varchar(255) default NULL,
  `PURCHASED_ON` datetime default NULL,
  `DESCRIPTION` varchar(255) default NULL,
  `PRICE` double default NULL,
  `PRODUCT_NAME` varchar(255) default NULL,
  PRIMARY KEY  (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `expendature_mst_tbl`
--

/*!40000 ALTER TABLE `expendature_mst_tbl` DISABLE KEYS */;
/*!40000 ALTER TABLE `expendature_mst_tbl` ENABLE KEYS */;


--
-- Definition of table `institute_mst_tbl`
--

DROP TABLE IF EXISTS `institute_mst_tbl`;
CREATE TABLE `institute_mst_tbl` (
  `ID` bigint(20) NOT NULL auto_increment,
  `INSTITUTE_NAME` varchar(255) default NULL,
  `COLLEGE_PHONENO` varchar(255) default NULL,
  `COLLEGE_DESCRIPTION` varchar(255) default NULL,
  `COLLEGE_START_DATE` datetime default NULL,
  `PO_ID` bigint(20) default NULL,
  `UNIVERSITY_ID` bigint(20) default NULL,
  PRIMARY KEY  (`ID`),
  KEY `FK_9n9cu7jqdm0u786u0390ljffc` (`PO_ID`),
  KEY `FK_89ipu5ghmatq6yl924fkqmii` (`UNIVERSITY_ID`),
  CONSTRAINT `FK_89ipu5ghmatq6yl924fkqmii` FOREIGN KEY (`UNIVERSITY_ID`) REFERENCES `university_mst_tbl` (`ID`),
  CONSTRAINT `FK_9n9cu7jqdm0u786u0390ljffc` FOREIGN KEY (`PO_ID`) REFERENCES `user_mst_tbl` (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `institute_mst_tbl`
--

/*!40000 ALTER TABLE `institute_mst_tbl` DISABLE KEYS */;
/*!40000 ALTER TABLE `institute_mst_tbl` ENABLE KEYS */;


--
-- Definition of table `instructor_mst_tbl`
--

DROP TABLE IF EXISTS `instructor_mst_tbl`;
CREATE TABLE `instructor_mst_tbl` (
  `ID` bigint(20) NOT NULL auto_increment,
  `COMMENTS` longtext,
  `CREATED_ON` datetime default NULL,
  `EMAIL_ID` varchar(255) default NULL,
  `MOBILE_NO` varchar(255) default NULL,
  `NAME` varchar(255) default NULL,
  `STATUS` varchar(255) default NULL,
  PRIMARY KEY  (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `instructor_mst_tbl`
--

/*!40000 ALTER TABLE `instructor_mst_tbl` DISABLE KEYS */;
/*!40000 ALTER TABLE `instructor_mst_tbl` ENABLE KEYS */;


--
-- Definition of table `interview_feedback_mst_tbl`
--

DROP TABLE IF EXISTS `interview_feedback_mst_tbl`;
CREATE TABLE `interview_feedback_mst_tbl` (
  `ID` bigint(20) NOT NULL auto_increment,
  `FEEDBACK_DESC` varchar(255) default NULL,
  `TYPE` varchar(255) default NULL,
  PRIMARY KEY  (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `interview_feedback_mst_tbl`
--

/*!40000 ALTER TABLE `interview_feedback_mst_tbl` DISABLE KEYS */;
/*!40000 ALTER TABLE `interview_feedback_mst_tbl` ENABLE KEYS */;


--
-- Definition of table `interview_groups_candidates_tbl`
--

DROP TABLE IF EXISTS `interview_groups_candidates_tbl`;
CREATE TABLE `interview_groups_candidates_tbl` (
  `ID` bigint(20) NOT NULL auto_increment,
  `CANDIDATE_EMAIL_ID` varchar(255) default NULL,
  `CANDIDATE_NAME` varchar(255) default NULL,
  `CANDIDATE_PHONE_NUMBER` varchar(255) default NULL,
  `INTERVIEW_GROUPS_ID` bigint(20) default NULL,
  `USER_ID` bigint(20) default NULL,
  PRIMARY KEY  (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `interview_groups_candidates_tbl`
--

/*!40000 ALTER TABLE `interview_groups_candidates_tbl` DISABLE KEYS */;
/*!40000 ALTER TABLE `interview_groups_candidates_tbl` ENABLE KEYS */;


--
-- Definition of table `interview_groups_mst_tbl`
--

DROP TABLE IF EXISTS `interview_groups_mst_tbl`;
CREATE TABLE `interview_groups_mst_tbl` (
  `ID` bigint(20) NOT NULL auto_increment,
  `GROUP_DESC` varchar(255) default NULL,
  `GROUP_NAME` varchar(255) default NULL,
  `HR_ID` bigint(20) default NULL,
  PRIMARY KEY  (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `interview_groups_mst_tbl`
--

/*!40000 ALTER TABLE `interview_groups_mst_tbl` DISABLE KEYS */;
INSERT INTO `interview_groups_mst_tbl` (`ID`,`GROUP_DESC`,`GROUP_NAME`,`HR_ID`) VALUES 
 (2,'TestGroup Description','TestGroup',3);
/*!40000 ALTER TABLE `interview_groups_mst_tbl` ENABLE KEYS */;


--
-- Definition of table `interview_groups_tbl`
--

DROP TABLE IF EXISTS `interview_groups_tbl`;
CREATE TABLE `interview_groups_tbl` (
  `ID` bigint(20) NOT NULL auto_increment,
  `GROUP_DESC` varchar(255) default NULL,
  `GROUP_NAME` varchar(255) default NULL,
  `HR_ID` bigint(20) default NULL,
  PRIMARY KEY  (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `interview_groups_tbl`
--

/*!40000 ALTER TABLE `interview_groups_tbl` DISABLE KEYS */;
/*!40000 ALTER TABLE `interview_groups_tbl` ENABLE KEYS */;


--
-- Definition of table `interview_results_tbl`
--

DROP TABLE IF EXISTS `interview_results_tbl`;
CREATE TABLE `interview_results_tbl` (
  `ID` bigint(20) NOT NULL auto_increment,
  `POINTS` int(11) default NULL,
  `TOTAL_MARKS` bigint(20) default NULL,
  `TOTAL_QUESTIONS` bigint(20) default NULL,
  `CODING_TEST_ID` bigint(20) default NULL,
  `ROUND_ID` bigint(20) default NULL,
  `INTERVIEWS_ID` bigint(20) default NULL,
  `USER_ID` bigint(20) default NULL,
  PRIMARY KEY  (`ID`),
  KEY `FK_jwvwy6p6xusjtryhihl256e89` (`CODING_TEST_ID`),
  KEY `FK_dyetjjoxy60u56uuc1j6lkr26` (`ROUND_ID`),
  KEY `FK_h2kg94kin8swewrhh9jjt9y6q` (`INTERVIEWS_ID`),
  KEY `FK_3fla0swke0qgmifb4jwpflwjy` (`USER_ID`),
  CONSTRAINT `FK_3fla0swke0qgmifb4jwpflwjy` FOREIGN KEY (`USER_ID`) REFERENCES `user_mst_tbl` (`ID`),
  CONSTRAINT `FK_dyetjjoxy60u56uuc1j6lkr26` FOREIGN KEY (`ROUND_ID`) REFERENCES `rounds_mst_tbl` (`ID`),
  CONSTRAINT `FK_h2kg94kin8swewrhh9jjt9y6q` FOREIGN KEY (`INTERVIEWS_ID`) REFERENCES `interviews_mst_tbl` (`ID`),
  CONSTRAINT `FK_jwvwy6p6xusjtryhihl256e89` FOREIGN KEY (`CODING_TEST_ID`) REFERENCES `coding_test_qtn_tbl` (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

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
  `ID` bigint(20) NOT NULL auto_increment,
  `INTERVIEWS_ID` bigint(20) default NULL,
  `ROUNDS_ID` bigint(20) default NULL,
  PRIMARY KEY  (`ID`),
  KEY `FK_sf3j6ijyvj3ei6p261j9u8xbg` (`INTERVIEWS_ID`),
  KEY `FK_ow6hraitb3mallanm7pnkrh92` (`ROUNDS_ID`),
  CONSTRAINT `FK_ow6hraitb3mallanm7pnkrh92` FOREIGN KEY (`ROUNDS_ID`) REFERENCES `rounds_mst_tbl` (`ID`),
  CONSTRAINT `FK_sf3j6ijyvj3ei6p261j9u8xbg` FOREIGN KEY (`INTERVIEWS_ID`) REFERENCES `interviews_mst_tbl` (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=56 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `interview_rounds_tbl`
--

/*!40000 ALTER TABLE `interview_rounds_tbl` DISABLE KEYS */;
INSERT INTO `interview_rounds_tbl` (`ID`,`INTERVIEWS_ID`,`ROUNDS_ID`) VALUES 
 (51,26,1),
 (52,26,2),
 (53,27,1),
 (54,27,2),
 (55,27,3);
/*!40000 ALTER TABLE `interview_rounds_tbl` ENABLE KEYS */;


--
-- Definition of table `interview_shortlisted_candidates_tbl`
--

DROP TABLE IF EXISTS `interview_shortlisted_candidates_tbl`;
CREATE TABLE `interview_shortlisted_candidates_tbl` (
  `ID` bigint(20) NOT NULL auto_increment,
  `JOB_INTERVIEW_ID` bigint(20) default NULL,
  `USER_ID` bigint(20) default NULL,
  PRIMARY KEY  (`ID`),
  KEY `FK_bhpnqsao5pc3qkara9cs66e3x` (`JOB_INTERVIEW_ID`),
  KEY `FK_wm5vmuledd9aobsstb4svlip` (`USER_ID`),
  CONSTRAINT `FK_bhpnqsao5pc3qkara9cs66e3x` FOREIGN KEY (`JOB_INTERVIEW_ID`) REFERENCES `job_interview_mst_tbl` (`ID`),
  CONSTRAINT `FK_wm5vmuledd9aobsstb4svlip` FOREIGN KEY (`USER_ID`) REFERENCES `user_mst_tbl` (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

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
  `ID` bigint(20) NOT NULL auto_increment,
  `TECHNOLOGIES_ID` bigint(20) default NULL,
  `INTERVIEWS_ID` bigint(20) default NULL,
  PRIMARY KEY  (`ID`),
  KEY `FK_3q8v6sm6uwdakm18tc2fatp7h` (`TECHNOLOGIES_ID`),
  KEY `FK_il3p5vtp05yjcix4cjj4bclsi` (`INTERVIEWS_ID`),
  CONSTRAINT `FK_3q8v6sm6uwdakm18tc2fatp7h` FOREIGN KEY (`TECHNOLOGIES_ID`) REFERENCES `technologies_mst_tbl` (`ID`),
  CONSTRAINT `FK_il3p5vtp05yjcix4cjj4bclsi` FOREIGN KEY (`INTERVIEWS_ID`) REFERENCES `interviews_mst_tbl` (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=79 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `interview_technology_tbl`
--

/*!40000 ALTER TABLE `interview_technology_tbl` DISABLE KEYS */;
INSERT INTO `interview_technology_tbl` (`ID`,`TECHNOLOGIES_ID`,`INTERVIEWS_ID`) VALUES 
 (76,1,26),
 (77,2,26),
 (78,1,27);
/*!40000 ALTER TABLE `interview_technology_tbl` ENABLE KEYS */;


--
-- Definition of table `interview_types_mst_tbl`
--

DROP TABLE IF EXISTS `interview_types_mst_tbl`;
CREATE TABLE `interview_types_mst_tbl` (
  `ID` bigint(20) NOT NULL auto_increment,
  `INTERVIEW_TYPE` varchar(255) default NULL,
  PRIMARY KEY  (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `interview_types_mst_tbl`
--

/*!40000 ALTER TABLE `interview_types_mst_tbl` DISABLE KEYS */;
INSERT INTO `interview_types_mst_tbl` (`ID`,`INTERVIEW_TYPE`) VALUES 
 (1,'public'),
 (2,'private '),
 (3,'mock');
/*!40000 ALTER TABLE `interview_types_mst_tbl` ENABLE KEYS */;


--
-- Definition of table `interviews_assign_to_user_tbl`
--

DROP TABLE IF EXISTS `interviews_assign_to_user_tbl`;
CREATE TABLE `interviews_assign_to_user_tbl` (
  `ID` bigint(20) NOT NULL auto_increment,
  `INTERVIEWS_ID` bigint(20) default NULL,
  `USER_ID` bigint(20) default NULL,
  PRIMARY KEY  (`ID`),
  KEY `FK_gk7o2toksp3evcetyf4tmebb5` (`INTERVIEWS_ID`),
  KEY `FK_k29rs1g9f79fdq2jqjvrebtpk` (`USER_ID`),
  CONSTRAINT `FK_gk7o2toksp3evcetyf4tmebb5` FOREIGN KEY (`INTERVIEWS_ID`) REFERENCES `interviews_mst_tbl` (`ID`),
  CONSTRAINT `FK_k29rs1g9f79fdq2jqjvrebtpk` FOREIGN KEY (`USER_ID`) REFERENCES `user_mst_tbl` (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

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
  `ID` bigint(20) NOT NULL auto_increment,
  `INTERVIEWS_ID` bigint(20) default NULL,
  `USER_ID` bigint(20) default NULL,
  PRIMARY KEY  (`ID`),
  KEY `FK_83d5se65rm6ksxtppf9wuik7b` (`INTERVIEWS_ID`),
  KEY `FK_gio1w0foa4gh12ci9omq7ayv9` (`USER_ID`),
  CONSTRAINT `FK_83d5se65rm6ksxtppf9wuik7b` FOREIGN KEY (`INTERVIEWS_ID`) REFERENCES `interviews_mst_tbl` (`ID`),
  CONSTRAINT `FK_gio1w0foa4gh12ci9omq7ayv9` FOREIGN KEY (`USER_ID`) REFERENCES `user_mst_tbl` (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

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
  `ID` bigint(20) NOT NULL auto_increment,
  `DESCRIPTION` varchar(255) default NULL,
  `END_DATE` datetime default NULL,
  `START_DATE` datetime default NULL,
  `TEST_NAME` varchar(255) default NULL,
  `INTERVIEW_TYPE_ID` bigint(20) default NULL,
  `JOB_INFO_ID` bigint(20) default NULL,
  `USER_ID` bigint(20) default NULL,
  PRIMARY KEY  (`ID`),
  KEY `FK_i76hag06mrtjxvji4mkgudtbl` (`INTERVIEW_TYPE_ID`),
  KEY `FK_2rr551tdr6siy7w4yfjrw5fqs` (`JOB_INFO_ID`),
  KEY `FK_a365koomssp5su65n2ccvd0ga` (`USER_ID`),
  CONSTRAINT `FK_2rr551tdr6siy7w4yfjrw5fqs` FOREIGN KEY (`JOB_INFO_ID`) REFERENCES `job_info_mst` (`ID`),
  CONSTRAINT `FK_a365koomssp5su65n2ccvd0ga` FOREIGN KEY (`USER_ID`) REFERENCES `user_mst_tbl` (`ID`),
  CONSTRAINT `FK_i76hag06mrtjxvji4mkgudtbl` FOREIGN KEY (`INTERVIEW_TYPE_ID`) REFERENCES `interview_types_mst_tbl` (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=28 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `interviews_mst_tbl`
--

/*!40000 ALTER TABLE `interviews_mst_tbl` DISABLE KEYS */;
INSERT INTO `interviews_mst_tbl` (`ID`,`DESCRIPTION`,`END_DATE`,`START_DATE`,`TEST_NAME`,`INTERVIEW_TYPE_ID`,`JOB_INFO_ID`,`USER_ID`) VALUES 
 (26,'Test1 description','2017-12-14 00:00:00','2017-12-03 00:00:00','Test1',1,1,2),
 (27,'hgjv','2020-01-24 00:00:00','2020-01-07 00:00:00','tesghv',NULL,1,2);
/*!40000 ALTER TABLE `interviews_mst_tbl` ENABLE KEYS */;


--
-- Definition of table `interviews_round_question_tbl`
--

DROP TABLE IF EXISTS `interviews_round_question_tbl`;
CREATE TABLE `interviews_round_question_tbl` (
  `ID` bigint(20) NOT NULL auto_increment,
  `CODING_QUESTION_ID` bigint(20) default NULL,
  `OBJECTIVE_QUESTION_ID` bigint(20) default NULL,
  `ROUND_ID` bigint(20) default NULL,
  `TASK_QUESTION_ID` bigint(20) default NULL,
  `INTERVIEWS_ID` bigint(20) default NULL,
  PRIMARY KEY  (`ID`),
  KEY `FK_5s6rvlqnj3tf9j1edha0uw2pc` (`CODING_QUESTION_ID`),
  KEY `FK_am01bng1qcv50vwhgxd8em6c1` (`OBJECTIVE_QUESTION_ID`),
  KEY `FK_9npyjelt7huq8bmbam0elbqjk` (`ROUND_ID`),
  KEY `FK_alksqirst1m72slibe3moo9dj` (`TASK_QUESTION_ID`),
  KEY `FK_7w786rugyyy9v5ue5y0awog4c` (`INTERVIEWS_ID`),
  CONSTRAINT `FK_5s6rvlqnj3tf9j1edha0uw2pc` FOREIGN KEY (`CODING_QUESTION_ID`) REFERENCES `coding_test_qtn_tbl` (`ID`),
  CONSTRAINT `FK_7w786rugyyy9v5ue5y0awog4c` FOREIGN KEY (`INTERVIEWS_ID`) REFERENCES `interviews_mst_tbl` (`ID`),
  CONSTRAINT `FK_9npyjelt7huq8bmbam0elbqjk` FOREIGN KEY (`ROUND_ID`) REFERENCES `rounds_mst_tbl` (`ID`),
  CONSTRAINT `FK_alksqirst1m72slibe3moo9dj` FOREIGN KEY (`TASK_QUESTION_ID`) REFERENCES `task_mst_tbl` (`ID`),
  CONSTRAINT `FK_am01bng1qcv50vwhgxd8em6c1` FOREIGN KEY (`OBJECTIVE_QUESTION_ID`) REFERENCES `objective_questions_tbls` (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `interviews_round_question_tbl`
--

/*!40000 ALTER TABLE `interviews_round_question_tbl` DISABLE KEYS */;
INSERT INTO `interviews_round_question_tbl` (`ID`,`CODING_QUESTION_ID`,`OBJECTIVE_QUESTION_ID`,`ROUND_ID`,`TASK_QUESTION_ID`,`INTERVIEWS_ID`) VALUES 
 (1,1,NULL,2,NULL,26),
 (2,2,NULL,2,NULL,26),
 (6,3,NULL,2,NULL,26),
 (7,1,NULL,2,NULL,27),
 (8,2,NULL,2,NULL,27);
/*!40000 ALTER TABLE `interviews_round_question_tbl` ENABLE KEYS */;


--
-- Definition of table `job_info_mst`
--

DROP TABLE IF EXISTS `job_info_mst`;
CREATE TABLE `job_info_mst` (
  `ID` bigint(20) NOT NULL auto_increment,
  `CLOSED_DATE` datetime default NULL,
  `JOB_DESCRIPTION` varchar(255) default NULL,
  `JOB_TITLE` varchar(255) default NULL,
  `LOCATION` varchar(255) default NULL,
  `POSTED_DATE` datetime default NULL,
  `REQUIRED_SKILLS` varchar(255) default NULL,
  `COMPANY_ID` bigint(20) default NULL,
  `HR_ID` bigint(20) default NULL,
  PRIMARY KEY  (`ID`),
  KEY `FK52DAAEBFEA5A0B4` (`COMPANY_ID`),
  KEY `FK52DAAEBFE33572E6` (`HR_ID`),
  CONSTRAINT `FK52DAAEBFE33572E6` FOREIGN KEY (`HR_ID`) REFERENCES `user_mst_tbl` (`ID`),
  CONSTRAINT `FK52DAAEBFEA5A0B4` FOREIGN KEY (`COMPANY_ID`) REFERENCES `company_mst_tbl` (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `job_info_mst`
--

/*!40000 ALTER TABLE `job_info_mst` DISABLE KEYS */;
INSERT INTO `job_info_mst` (`ID`,`CLOSED_DATE`,`JOB_DESCRIPTION`,`JOB_TITLE`,`LOCATION`,`POSTED_DATE`,`REQUIRED_SKILLS`,`COMPANY_ID`,`HR_ID`) VALUES 
 (1,'2017-12-02 22:22:05','Fresher and Experienced also','Java Jobe','Bangalore','2017-12-02 22:22:05','Java,Spring and Hibernate',1,2);
/*!40000 ALTER TABLE `job_info_mst` ENABLE KEYS */;


--
-- Definition of table `job_interview_mst_tbl`
--

DROP TABLE IF EXISTS `job_interview_mst_tbl`;
CREATE TABLE `job_interview_mst_tbl` (
  `ID` bigint(20) NOT NULL auto_increment,
  `JOB_INFO_ID` bigint(20) default NULL,
  `TEST_ID` bigint(20) default NULL,
  `INTERVIEWS_ID` bigint(20) default NULL,
  PRIMARY KEY  (`ID`),
  KEY `FK_sryjqfcplmsrcjxco9qosox2b` (`JOB_INFO_ID`),
  KEY `FK_cxxvsr6tw08p8dw495b7r3isi` (`TEST_ID`),
  KEY `FK_1dtagh2h0s9cj7l20k5q8mhsm` (`INTERVIEWS_ID`),
  CONSTRAINT `FK_1dtagh2h0s9cj7l20k5q8mhsm` FOREIGN KEY (`INTERVIEWS_ID`) REFERENCES `interviews_mst_tbl` (`ID`),
  CONSTRAINT `FK_cxxvsr6tw08p8dw495b7r3isi` FOREIGN KEY (`TEST_ID`) REFERENCES `test_mst_tbl` (`ID`),
  CONSTRAINT `FK_sryjqfcplmsrcjxco9qosox2b` FOREIGN KEY (`JOB_INFO_ID`) REFERENCES `job_info_mst` (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `job_interview_mst_tbl`
--

/*!40000 ALTER TABLE `job_interview_mst_tbl` DISABLE KEYS */;
INSERT INTO `job_interview_mst_tbl` (`ID`,`JOB_INFO_ID`,`TEST_ID`,`INTERVIEWS_ID`) VALUES 
 (1,1,NULL,26),
 (2,1,NULL,27);
/*!40000 ALTER TABLE `job_interview_mst_tbl` ENABLE KEYS */;


--
-- Definition of table `jobinfo_trn_tbl`
--

DROP TABLE IF EXISTS `jobinfo_trn_tbl`;
CREATE TABLE `jobinfo_trn_tbl` (
  `ID` bigint(20) NOT NULL auto_increment,
  `STUDENT_ID` bigint(20) default NULL,
  `JOB_ID` bigint(20) default NULL,
  PRIMARY KEY  (`ID`),
  KEY `FK80E3BE5B1C5B2882` (`JOB_ID`),
  CONSTRAINT `FK80E3BE5B1C5B2882` FOREIGN KEY (`JOB_ID`) REFERENCES `job_info_mst` (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `jobinfo_trn_tbl`
--

/*!40000 ALTER TABLE `jobinfo_trn_tbl` DISABLE KEYS */;
/*!40000 ALTER TABLE `jobinfo_trn_tbl` ENABLE KEYS */;


--
-- Definition of table `languages_mst_tbl`
--

DROP TABLE IF EXISTS `languages_mst_tbl`;
CREATE TABLE `languages_mst_tbl` (
  `ID` bigint(20) NOT NULL auto_increment,
  `LANGUAGE_NAME` varchar(255) default NULL,
  PRIMARY KEY  (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `languages_mst_tbl`
--

/*!40000 ALTER TABLE `languages_mst_tbl` DISABLE KEYS */;
/*!40000 ALTER TABLE `languages_mst_tbl` ENABLE KEYS */;


--
-- Definition of table `object_test_user_ans_tbl`
--

DROP TABLE IF EXISTS `object_test_user_ans_tbl`;
CREATE TABLE `object_test_user_ans_tbl` (
  `ID` bigint(20) NOT NULL auto_increment,
  `ANSWER` varchar(255) default NULL,
  `IS_ANSWERED` bit(1) default NULL,
  `QUESTION_ID` bigint(20) default NULL,
  `PERSIONAL_ID` bigint(20) default NULL,
  PRIMARY KEY  (`ID`),
  KEY `FKFAE61AFEA9195E13` (`PERSIONAL_ID`),
  KEY `FKFAE61AFED6BC9FAC` (`QUESTION_ID`),
  CONSTRAINT `FKFAE61AFEA9195E13` FOREIGN KEY (`PERSIONAL_ID`) REFERENCES `user_mst_tbl` (`ID`),
  CONSTRAINT `FKFAE61AFED6BC9FAC` FOREIGN KEY (`QUESTION_ID`) REFERENCES `objective_questions_tbls` (`ID`),
  CONSTRAINT `FK_43jil8epjxenrqdd69iqwknm3` FOREIGN KEY (`QUESTION_ID`) REFERENCES `objective_questions_tbl` (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `object_test_user_ans_tbl`
--

/*!40000 ALTER TABLE `object_test_user_ans_tbl` DISABLE KEYS */;
/*!40000 ALTER TABLE `object_test_user_ans_tbl` ENABLE KEYS */;


--
-- Definition of table `objective_question_answers_mst_tbl`
--

DROP TABLE IF EXISTS `objective_question_answers_mst_tbl`;
CREATE TABLE `objective_question_answers_mst_tbl` (
  `ID` bigint(20) NOT NULL auto_increment,
  `ANSWER` varchar(255) default NULL,
  `QUESTION_ID` bigint(20) default NULL,
  PRIMARY KEY  (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `objective_question_answers_mst_tbl`
--

/*!40000 ALTER TABLE `objective_question_answers_mst_tbl` DISABLE KEYS */;
INSERT INTO `objective_question_answers_mst_tbl` (`ID`,`ANSWER`,`QUESTION_ID`) VALUES 
 (1,'array is collection of homogenou data',2),
 (2,'kjlkjjl jlkjlkj lkjlkj',3),
 (3,'kjk jkj kjkj kjk',4);
/*!40000 ALTER TABLE `objective_question_answers_mst_tbl` ENABLE KEYS */;


--
-- Definition of table `objective_questions_tbl`
--

DROP TABLE IF EXISTS `objective_questions_tbl`;
CREATE TABLE `objective_questions_tbl` (
  `ID` bigint(20) NOT NULL auto_increment,
  `ANSWERS` varchar(255) default NULL,
  `OPTIONS` varchar(255) default NULL,
  `QUE_GROUP` varchar(255) default NULL,
  `QUE_TYPE` varchar(255) default NULL,
  `QUE_DESCRIPTION` varchar(255) default NULL,
  `QUESTION_ID` varchar(255) default NULL,
  PRIMARY KEY  (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `objective_questions_tbl`
--

/*!40000 ALTER TABLE `objective_questions_tbl` DISABLE KEYS */;
INSERT INTO `objective_questions_tbl` (`ID`,`ANSWERS`,`OPTIONS`,`QUE_GROUP`,`QUE_TYPE`,`QUE_DESCRIPTION`,`QUESTION_ID`) VALUES 
 (1,NULL,'<strong>@@<dar>@@<black>@@<emp>\r\n','CSS','choice','<b> tag makes the enclosed text bold. What is other tag to make text bold?','CSS0'),
 (3,'','kjlkjjl jlkjlkj lkjlkj@@kjhkjhkjh ckjhkjhkjh@@kjhkjhkj hkjhkjhkjhkjh jkhkjh@@iuiuiyiu iuyi uyiuyiuy iuy@@ytrytryt ytryt rytrytry try','CSS','choice','hjkhj jhkjhkhkjhkjh hjjhk hkjhkjhkjh kjkj?','CSS1'),
 (4,'','kjk jkj kjkj kjk@@djjfhr   r  r@@wwsws www@@utjfhtu@@rjke','CSS','choice','kljk lkjlkj lkjlkjl kjlkjlk jlkjlk j?','CSS2');
/*!40000 ALTER TABLE `objective_questions_tbl` ENABLE KEYS */;


--
-- Definition of table `objective_questions_tbls`
--

DROP TABLE IF EXISTS `objective_questions_tbls`;
CREATE TABLE `objective_questions_tbls` (
  `ID` bigint(20) NOT NULL auto_increment,
  `ANSWERS` varchar(255) default NULL,
  `OPTIONS` varchar(255) default NULL,
  `QUE_GROUP` varchar(255) default NULL,
  `QUE_TYPE` varchar(255) default NULL,
  `QUE_DESCRIPTION` varchar(255) default NULL,
  `QUESTION_ID` int(10) unsigned default NULL,
  PRIMARY KEY  (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `objective_questions_tbls`
--

/*!40000 ALTER TABLE `objective_questions_tbls` DISABLE KEYS */;
/*!40000 ALTER TABLE `objective_questions_tbls` ENABLE KEYS */;


--
-- Definition of table `objective_test_total_results_tbl`
--

DROP TABLE IF EXISTS `objective_test_total_results_tbl`;
CREATE TABLE `objective_test_total_results_tbl` (
  `ID` bigint(20) NOT NULL auto_increment,
  `TOTAL_MARKS` bigint(20) default NULL,
  `TOTAL_QUESTIONS` bigint(20) default NULL,
  `PERSIONAL_ID` bigint(20) default NULL,
  PRIMARY KEY  (`ID`),
  KEY `FK81F376D3A9195E13` (`PERSIONAL_ID`),
  CONSTRAINT `FK81F376D3A9195E13` FOREIGN KEY (`PERSIONAL_ID`) REFERENCES `user_mst_tbl` (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

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
  `ID` bigint(20) NOT NULL auto_increment,
  `COURSE` varchar(255) default NULL,
  `EMAIL_ID` varchar(255) default NULL,
  `IMAGE_PATH` varchar(255) default NULL,
  `COMPANY` varchar(255) default NULL,
  `STUDENT_NAME` varchar(255) default NULL,
  PRIMARY KEY  (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `placements_info_tbl`
--

/*!40000 ALTER TABLE `placements_info_tbl` DISABLE KEYS */;
/*!40000 ALTER TABLE `placements_info_tbl` ENABLE KEYS */;


--
-- Definition of table `pricing_plan_trn_tbl`
--

DROP TABLE IF EXISTS `pricing_plan_trn_tbl`;
CREATE TABLE `pricing_plan_trn_tbl` (
  `ID` bigint(20) NOT NULL auto_increment,
  `PURCHASE_DATE` datetime default NULL,
  `PLAN_ID` bigint(20) default NULL,
  `USER_ID` bigint(20) default NULL,
  PRIMARY KEY  (`ID`),
  KEY `FK3406D72852FB9C8` (`PLAN_ID`),
  KEY `FK3406D72D4819085` (`USER_ID`),
  CONSTRAINT `FK3406D72852FB9C8` FOREIGN KEY (`PLAN_ID`) REFERENCES `pricing_planes_tbl` (`ID`),
  CONSTRAINT `FK3406D72D4819085` FOREIGN KEY (`USER_ID`) REFERENCES `user_mst_tbl` (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `pricing_plan_trn_tbl`
--

/*!40000 ALTER TABLE `pricing_plan_trn_tbl` DISABLE KEYS */;
/*!40000 ALTER TABLE `pricing_plan_trn_tbl` ENABLE KEYS */;


--
-- Definition of table `pricing_planes_tbl`
--

DROP TABLE IF EXISTS `pricing_planes_tbl`;
CREATE TABLE `pricing_planes_tbl` (
  `ID` bigint(20) NOT NULL auto_increment,
  `AVAILABLE_PROFILES` varchar(255) default NULL,
  `PLAN_AVAILABILITY` varchar(255) default NULL,
  `PLAN_PRICE` float default NULL,
  `PLAN_TYPE` varchar(255) default NULL,
  `PLAN_VALIDITY` bigint(20) default NULL,
  `STAFF_LOGIN` varchar(255) default NULL,
  `TECH_SUPPORT` bit(1) default NULL,
  PRIMARY KEY  (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `pricing_planes_tbl`
--

/*!40000 ALTER TABLE `pricing_planes_tbl` DISABLE KEYS */;
/*!40000 ALTER TABLE `pricing_planes_tbl` ENABLE KEYS */;


--
-- Definition of table `project_domain_mst_tbl`
--

DROP TABLE IF EXISTS `project_domain_mst_tbl`;
CREATE TABLE `project_domain_mst_tbl` (
  `ID` bigint(20) NOT NULL auto_increment,
  `PROJECT_DOMAIN_NAME` varchar(255) default NULL,
  PRIMARY KEY  (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `project_domain_mst_tbl`
--

/*!40000 ALTER TABLE `project_domain_mst_tbl` DISABLE KEYS */;
/*!40000 ALTER TABLE `project_domain_mst_tbl` ENABLE KEYS */;


--
-- Definition of table `purchased_courses_trn_tbl`
--

DROP TABLE IF EXISTS `purchased_courses_trn_tbl`;
CREATE TABLE `purchased_courses_trn_tbl` (
  `ID` bigint(20) NOT NULL auto_increment,
  `PURCHASED_DATE` datetime default NULL,
  `COURSE_ID` bigint(20) default NULL,
  `USER_ID` bigint(20) default NULL,
  PRIMARY KEY  (`ID`),
  KEY `FK66CB766CD4819085` (`USER_ID`),
  KEY `FK66CB766C708C98F5` (`COURSE_ID`),
  CONSTRAINT `FK66CB766C708C98F5` FOREIGN KEY (`COURSE_ID`) REFERENCES `course_mst_tbl` (`ID`),
  CONSTRAINT `FK66CB766CD4819085` FOREIGN KEY (`USER_ID`) REFERENCES `user_mst_tbl` (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `purchased_courses_trn_tbl`
--

/*!40000 ALTER TABLE `purchased_courses_trn_tbl` DISABLE KEYS */;
/*!40000 ALTER TABLE `purchased_courses_trn_tbl` ENABLE KEYS */;


--
-- Definition of table `quiz_trn_tbl`
--

DROP TABLE IF EXISTS `quiz_trn_tbl`;
CREATE TABLE `quiz_trn_tbl` (
  `ID` bigint(20) NOT NULL auto_increment,
  `ANSWERED` bigint(20) default NULL,
  `CREATED_ON` datetime default NULL,
  `QUESTIONS` bigint(20) default NULL,
  `STATUS` varchar(255) default NULL,
  `TECHNOLOGY` varchar(255) default NULL,
  `TOPIC` varchar(255) default NULL,
  `USER_ID` bigint(20) default NULL,
  PRIMARY KEY  (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `quiz_trn_tbl`
--

/*!40000 ALTER TABLE `quiz_trn_tbl` DISABLE KEYS */;
/*!40000 ALTER TABLE `quiz_trn_tbl` ENABLE KEYS */;


--
-- Definition of table `referral_mst_tbl`
--

DROP TABLE IF EXISTS `referral_mst_tbl`;
CREATE TABLE `referral_mst_tbl` (
  `ID` bigint(20) NOT NULL auto_increment,
  `EMAIL_ID` varchar(255) default NULL,
  `MOBILE_NO` varchar(255) default NULL,
  `REFERRAL_NAME` varchar(255) default NULL,
  `USER_ID` bigint(20) default NULL,
  PRIMARY KEY  (`ID`),
  KEY `FKB39F54EBD4819085` (`USER_ID`),
  CONSTRAINT `FKB39F54EBD4819085` FOREIGN KEY (`USER_ID`) REFERENCES `user_mst_tbl` (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `referral_mst_tbl`
--

/*!40000 ALTER TABLE `referral_mst_tbl` DISABLE KEYS */;
/*!40000 ALTER TABLE `referral_mst_tbl` ENABLE KEYS */;


--
-- Definition of table `role_mst_tbl`
--

DROP TABLE IF EXISTS `role_mst_tbl`;
CREATE TABLE `role_mst_tbl` (
  `ID` bigint(20) NOT NULL auto_increment,
  `ROLE_NAME` varchar(255) default NULL,
  PRIMARY KEY  (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `role_mst_tbl`
--

/*!40000 ALTER TABLE `role_mst_tbl` DISABLE KEYS */;
INSERT INTO `role_mst_tbl` (`ID`,`ROLE_NAME`) VALUES 
 (1,'Anonymous'),
 (2,'Campus'),
 (3,'Intern'),
 (4,'class room'),
 (5,'online user'),
 (6,'Interview'),
 (7,'HR'),
 (8,'PO');
/*!40000 ALTER TABLE `role_mst_tbl` ENABLE KEYS */;


--
-- Definition of table `rounds_mst_tbl`
--

DROP TABLE IF EXISTS `rounds_mst_tbl`;
CREATE TABLE `rounds_mst_tbl` (
  `ID` bigint(20) NOT NULL auto_increment,
  `PATTERN_NAME` varchar(255) default NULL,
  PRIMARY KEY  (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;

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
  `ID` bigint(20) NOT NULL auto_increment,
  `INTERVIEW_ID` bigint(20) default NULL,
  `INTERVIEW_GROUP_ID` bigint(20) default NULL,
  PRIMARY KEY  (`ID`),
  KEY `FK_r149kpdojklrk8wkhfcnkmger` (`INTERVIEW_ID`),
  KEY `FK_1xkgsjgo8uc5eh33we61imnn4` (`INTERVIEW_GROUP_ID`),
  CONSTRAINT `FK_1xkgsjgo8uc5eh33we61imnn4` FOREIGN KEY (`INTERVIEW_GROUP_ID`) REFERENCES `interview_groups_mst_tbl` (`ID`),
  CONSTRAINT `FK_r149kpdojklrk8wkhfcnkmger` FOREIGN KEY (`INTERVIEW_ID`) REFERENCES `interviews_mst_tbl` (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

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
  `ID` bigint(20) NOT NULL auto_increment,
  `EMAIL_ID` varchar(255) default NULL,
  `MESSAGE` varchar(255) default NULL,
  `MOBILE_NO` varchar(255) default NULL,
  `NAME` varchar(255) default NULL,
  PRIMARY KEY  (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

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
  `ID` bigint(20) NOT NULL auto_increment,
  `STATE_NAME` varchar(255) default NULL,
  `COUNTRY_ID` bigint(20) default NULL,
  PRIMARY KEY  (`ID`),
  KEY `FK_ah3uf2ech8chtggo7u9d5dhf0` (`COUNTRY_ID`),
  CONSTRAINT `FK_ah3uf2ech8chtggo7u9d5dhf0` FOREIGN KEY (`COUNTRY_ID`) REFERENCES `country_mst_tbl` (`Id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `state_mst_tbl`
--

/*!40000 ALTER TABLE `state_mst_tbl` DISABLE KEYS */;
/*!40000 ALTER TABLE `state_mst_tbl` ENABLE KEYS */;


--
-- Definition of table `subscriber_tbl`
--

DROP TABLE IF EXISTS `subscriber_tbl`;
CREATE TABLE `subscriber_tbl` (
  `ID` bigint(20) NOT NULL auto_increment,
  `SUBSCRIBER_EMAIL` varchar(255) default NULL,
  PRIMARY KEY  (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `subscriber_tbl`
--

/*!40000 ALTER TABLE `subscriber_tbl` DISABLE KEYS */;
/*!40000 ALTER TABLE `subscriber_tbl` ENABLE KEYS */;


--
-- Definition of table `support_info_tbl`
--

DROP TABLE IF EXISTS `support_info_tbl`;
CREATE TABLE `support_info_tbl` (
  `ID` bigint(20) NOT NULL auto_increment,
  `DESCRIPTION` varchar(255) default NULL,
  `EMAIL_ID` varchar(255) default NULL,
  `MOBILE_NO` varchar(255) default NULL,
  `NAME` varchar(255) default NULL,
  `REQUIRED_TECHNOLOGIES` varchar(255) default NULL,
  PRIMARY KEY  (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `support_info_tbl`
--

/*!40000 ALTER TABLE `support_info_tbl` DISABLE KEYS */;
/*!40000 ALTER TABLE `support_info_tbl` ENABLE KEYS */;


--
-- Definition of table `task_assign_to_user_trn_tbl`
--

DROP TABLE IF EXISTS `task_assign_to_user_trn_tbl`;
CREATE TABLE `task_assign_to_user_trn_tbl` (
  `ID` bigint(20) NOT NULL auto_increment,
  `TASK_ID` bigint(20) default NULL,
  `USER_ID` bigint(20) default NULL,
  PRIMARY KEY  (`ID`),
  KEY `FKAED94829D4819085` (`USER_ID`),
  KEY `FKAED94829CA603FC2` (`TASK_ID`),
  CONSTRAINT `FKAED94829CA603FC2` FOREIGN KEY (`TASK_ID`) REFERENCES `task_mst_tbl` (`ID`),
  CONSTRAINT `FKAED94829D4819085` FOREIGN KEY (`USER_ID`) REFERENCES `user_mst_tbl` (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

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
  `ID` bigint(20) NOT NULL auto_increment,
  `IMAGE_PATH` varchar(255) default NULL,
  `OBJECTIVE` varchar(255) default NULL,
  `QUESTION_DES` varchar(255) default NULL,
  `QUESTION` varchar(255) default NULL,
  `REFFERENCE_LINK` varchar(255) default NULL,
  `SHORT_NAME` varchar(255) default NULL,
  `TECHNOLOGY` varchar(255) default NULL,
  PRIMARY KEY  (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `task_mst_tbl`
--

/*!40000 ALTER TABLE `task_mst_tbl` DISABLE KEYS */;
/*!40000 ALTER TABLE `task_mst_tbl` ENABLE KEYS */;


--
-- Definition of table `technologies_mst_tbl`
--

DROP TABLE IF EXISTS `technologies_mst_tbl`;
CREATE TABLE `technologies_mst_tbl` (
  `ID` bigint(20) NOT NULL auto_increment,
  `TECHNOLOGY_NAME` varchar(255) default NULL,
  PRIMARY KEY  (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `technologies_mst_tbl`
--

/*!40000 ALTER TABLE `technologies_mst_tbl` DISABLE KEYS */;
INSERT INTO `technologies_mst_tbl` (`ID`,`TECHNOLOGY_NAME`) VALUES 
 (1,'JAVA'),
 (2,'HTML'),
 (3,'CSS');
/*!40000 ALTER TABLE `technologies_mst_tbl` ENABLE KEYS */;


--
-- Definition of table `test_assign_to_users_tbl`
--

DROP TABLE IF EXISTS `test_assign_to_users_tbl`;
CREATE TABLE `test_assign_to_users_tbl` (
  `ID` bigint(20) NOT NULL auto_increment,
  `TEST_ID` bigint(20) default NULL,
  `USER_ID` bigint(20) default NULL,
  PRIMARY KEY  (`ID`),
  KEY `FK_kk046nhnyrvmklyy8kjxfjj4` (`TEST_ID`),
  KEY `FK_2thsptdgwpxrnh1uo9p3re5nf` (`USER_ID`),
  CONSTRAINT `FK_2thsptdgwpxrnh1uo9p3re5nf` FOREIGN KEY (`USER_ID`) REFERENCES `user_mst_tbl` (`ID`),
  CONSTRAINT `FK_kk046nhnyrvmklyy8kjxfjj4` FOREIGN KEY (`TEST_ID`) REFERENCES `test_mst_tbl` (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `test_assign_to_users_tbl`
--

/*!40000 ALTER TABLE `test_assign_to_users_tbl` DISABLE KEYS */;
/*!40000 ALTER TABLE `test_assign_to_users_tbl` ENABLE KEYS */;


--
-- Definition of table `test_mst_tbl`
--

DROP TABLE IF EXISTS `test_mst_tbl`;
CREATE TABLE `test_mst_tbl` (
  `ID` bigint(20) NOT NULL auto_increment,
  `DESCRIPTION` varchar(255) default NULL,
  `END_DATE` datetime default NULL,
  `START_DATE` datetime default NULL,
  `TEST_NAME` varchar(255) default NULL,
  `UNIVERSAL_TEST` bit(1) default NULL,
  `USER_ID` bigint(20) default NULL,
  `JOB_INFO_ID` bigint(20) default NULL,
  PRIMARY KEY  (`ID`),
  KEY `FK_97xdasu18efy05x8316h4mgf6` (`USER_ID`),
  KEY `FK_frnajxygfvdeoh9s25kvj9x67` (`JOB_INFO_ID`),
  CONSTRAINT `FK_97xdasu18efy05x8316h4mgf6` FOREIGN KEY (`USER_ID`) REFERENCES `user_mst_tbl` (`ID`),
  CONSTRAINT `FK_frnajxygfvdeoh9s25kvj9x67` FOREIGN KEY (`JOB_INFO_ID`) REFERENCES `job_info_mst` (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `test_mst_tbl`
--

/*!40000 ALTER TABLE `test_mst_tbl` DISABLE KEYS */;
/*!40000 ALTER TABLE `test_mst_tbl` ENABLE KEYS */;


--
-- Definition of table `test_results_tbl`
--

DROP TABLE IF EXISTS `test_results_tbl`;
CREATE TABLE `test_results_tbl` (
  `ID` bigint(20) NOT NULL auto_increment,
  `TOTAL_MARKS` varchar(255) default NULL,
  `TEST_ID` bigint(20) default NULL,
  `TEST_PATTERN_ID` bigint(20) default NULL,
  `USER_ID` bigint(20) default NULL,
  `TOTAL_QUESTIONS` bigint(20) default NULL,
  `ROUND_ID` bigint(20) default NULL,
  PRIMARY KEY  (`ID`),
  KEY `FK_rui33ap6l84jyi1ll3nai8fk9` (`TEST_ID`),
  KEY `FK_pm5c6k32jembuvww9yjcawhkr` (`TEST_PATTERN_ID`),
  KEY `FK_34mtt3nvs4od12pfkf0cg1hqk` (`USER_ID`),
  KEY `FK_p2nmejyv0924dgrprcft92vtq` (`ROUND_ID`),
  CONSTRAINT `FK_34mtt3nvs4od12pfkf0cg1hqk` FOREIGN KEY (`USER_ID`) REFERENCES `user_mst_tbl` (`ID`),
  CONSTRAINT `FK_p2nmejyv0924dgrprcft92vtq` FOREIGN KEY (`ROUND_ID`) REFERENCES `rounds_mst_tbl` (`ID`),
  CONSTRAINT `FK_pm5c6k32jembuvww9yjcawhkr` FOREIGN KEY (`TEST_PATTERN_ID`) REFERENCES `test_rounds_tbl` (`ID`),
  CONSTRAINT `FK_rui33ap6l84jyi1ll3nai8fk9` FOREIGN KEY (`TEST_ID`) REFERENCES `test_mst_tbl` (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `test_results_tbl`
--

/*!40000 ALTER TABLE `test_results_tbl` DISABLE KEYS */;
/*!40000 ALTER TABLE `test_results_tbl` ENABLE KEYS */;


--
-- Definition of table `test_round_question_tbl`
--

DROP TABLE IF EXISTS `test_round_question_tbl`;
CREATE TABLE `test_round_question_tbl` (
  `ID` bigint(20) NOT NULL auto_increment,
  `OBJECTIVE_QUESTION_ID` bigint(20) default NULL,
  `ROUND_ID` bigint(20) default NULL,
  `TEST_ID` bigint(20) default NULL,
  `CODING_QUESTION_ID` bigint(20) default NULL,
  `TASK_QUESTION_ID` bigint(20) default NULL,
  PRIMARY KEY  (`ID`),
  KEY `FK_rogqr3ctvrfehkqykwbukjxaa` (`OBJECTIVE_QUESTION_ID`),
  KEY `FK_358uc70oss9afa3aqi4te6ch9` (`ROUND_ID`),
  KEY `FK_k7tvjfxfbj05e1c426ic3uabg` (`TEST_ID`),
  KEY `FK_9dj4b458fcl0hoblqm50fks8e` (`CODING_QUESTION_ID`),
  KEY `FK_9w25off4ls48rcfbdgv2hgjtl` (`TASK_QUESTION_ID`),
  CONSTRAINT `FK_358uc70oss9afa3aqi4te6ch9` FOREIGN KEY (`ROUND_ID`) REFERENCES `rounds_mst_tbl` (`ID`),
  CONSTRAINT `FK_9dj4b458fcl0hoblqm50fks8e` FOREIGN KEY (`CODING_QUESTION_ID`) REFERENCES `coding_test_qtn_tbl` (`ID`),
  CONSTRAINT `FK_9w25off4ls48rcfbdgv2hgjtl` FOREIGN KEY (`TASK_QUESTION_ID`) REFERENCES `task_mst_tbl` (`ID`),
  CONSTRAINT `FK_k7tvjfxfbj05e1c426ic3uabg` FOREIGN KEY (`TEST_ID`) REFERENCES `test_mst_tbl` (`ID`),
  CONSTRAINT `FK_rogqr3ctvrfehkqykwbukjxaa` FOREIGN KEY (`OBJECTIVE_QUESTION_ID`) REFERENCES `objective_questions_tbls` (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `test_round_question_tbl`
--

/*!40000 ALTER TABLE `test_round_question_tbl` DISABLE KEYS */;
/*!40000 ALTER TABLE `test_round_question_tbl` ENABLE KEYS */;


--
-- Definition of table `test_rounds_tbl`
--

DROP TABLE IF EXISTS `test_rounds_tbl`;
CREATE TABLE `test_rounds_tbl` (
  `ID` bigint(20) NOT NULL auto_increment,
  `TEST_ID` bigint(20) default NULL,
  `ROUNDS_ID` bigint(20) default NULL,
  PRIMARY KEY  (`ID`),
  KEY `FK_raksm5ei7ju8pxhh3o1armm22` (`TEST_ID`),
  KEY `FK_lrddkys89we1wb6x553rapu04` (`ROUNDS_ID`),
  CONSTRAINT `FK_lrddkys89we1wb6x553rapu04` FOREIGN KEY (`ROUNDS_ID`) REFERENCES `rounds_mst_tbl` (`ID`),
  CONSTRAINT `FK_raksm5ei7ju8pxhh3o1armm22` FOREIGN KEY (`TEST_ID`) REFERENCES `test_mst_tbl` (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `test_rounds_tbl`
--

/*!40000 ALTER TABLE `test_rounds_tbl` DISABLE KEYS */;
/*!40000 ALTER TABLE `test_rounds_tbl` ENABLE KEYS */;


--
-- Definition of table `test_technology_trn_tbl`
--

DROP TABLE IF EXISTS `test_technology_trn_tbl`;
CREATE TABLE `test_technology_trn_tbl` (
  `ID` bigint(20) NOT NULL auto_increment,
  `TECHNOLOGIES_ID` bigint(20) default NULL,
  `TEST_ID` bigint(20) default NULL,
  PRIMARY KEY  (`ID`),
  KEY `FK_dfw9cgrpcd4r545k30f42go8x` (`TECHNOLOGIES_ID`),
  KEY `FK_j5wgckcx43t88wdbkstjjptjc` (`TEST_ID`),
  CONSTRAINT `FK_dfw9cgrpcd4r545k30f42go8x` FOREIGN KEY (`TECHNOLOGIES_ID`) REFERENCES `technologies_mst_tbl` (`ID`),
  CONSTRAINT `FK_j5wgckcx43t88wdbkstjjptjc` FOREIGN KEY (`TEST_ID`) REFERENCES `test_mst_tbl` (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `test_technology_trn_tbl`
--

/*!40000 ALTER TABLE `test_technology_trn_tbl` DISABLE KEYS */;
/*!40000 ALTER TABLE `test_technology_trn_tbl` ENABLE KEYS */;


--
-- Definition of table `university_mst_tbl`
--

DROP TABLE IF EXISTS `university_mst_tbl`;
CREATE TABLE `university_mst_tbl` (
  `ID` bigint(20) NOT NULL auto_increment,
  `UNIVERSITY_NAME` varchar(255) default NULL,
  PRIMARY KEY  (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `university_mst_tbl`
--

/*!40000 ALTER TABLE `university_mst_tbl` DISABLE KEYS */;
/*!40000 ALTER TABLE `university_mst_tbl` ENABLE KEYS */;


--
-- Definition of table `uploaded_task_files_tbl`
--

DROP TABLE IF EXISTS `uploaded_task_files_tbl`;
CREATE TABLE `uploaded_task_files_tbl` (
  `ID` bigint(20) NOT NULL auto_increment,
  `FILE_NAME` varchar(255) default NULL,
  `TASK_ID` bigint(20) default NULL,
  `TEST_ID` bigint(20) default NULL,
  `USER_ID` bigint(20) default NULL,
  `INTERVIEWS_ID` bigint(20) default NULL,
  PRIMARY KEY  (`ID`),
  KEY `FK_72j6wgak3mjgy9524767bghh0` (`TASK_ID`),
  KEY `FK_cy2wlj8f3akcya9iu3rq6jh3m` (`TEST_ID`),
  KEY `FK_b8bho2ieyxgev037kth29e87q` (`USER_ID`),
  KEY `FK_8s1e9uq683d82ou8tr794wkw6` (`INTERVIEWS_ID`),
  CONSTRAINT `FK_72j6wgak3mjgy9524767bghh0` FOREIGN KEY (`TASK_ID`) REFERENCES `task_mst_tbl` (`ID`),
  CONSTRAINT `FK_8s1e9uq683d82ou8tr794wkw6` FOREIGN KEY (`INTERVIEWS_ID`) REFERENCES `interviews_mst_tbl` (`ID`),
  CONSTRAINT `FK_b8bho2ieyxgev037kth29e87q` FOREIGN KEY (`USER_ID`) REFERENCES `user_mst_tbl` (`ID`),
  CONSTRAINT `FK_cy2wlj8f3akcya9iu3rq6jh3m` FOREIGN KEY (`TEST_ID`) REFERENCES `test_mst_tbl` (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

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
  `ID` bigint(20) NOT NULL auto_increment,
  `ADDRESS` varchar(255) default NULL,
  `PINCODE` varchar(255) default NULL,
  `CITY_ID` bigint(20) default NULL,
  `COUNTRY_ID` bigint(20) default NULL,
  `USER_ID` bigint(20) default NULL,
  `STATE_ID` bigint(20) default NULL,
  PRIMARY KEY  (`ID`),
  KEY `FKD90D882DD4819085` (`USER_ID`),
  KEY `FKD90D882D1C9DE3EF` (`COUNTRY_ID`),
  KEY `FKD90D882D5A70546B` (`CITY_ID`),
  KEY `FK_df5ib42g11ar3kfcfkdc5m50a` (`STATE_ID`),
  CONSTRAINT `FKD90D882D1C9DE3EF` FOREIGN KEY (`COUNTRY_ID`) REFERENCES `country_mst_tbl` (`Id`),
  CONSTRAINT `FKD90D882D5A70546B` FOREIGN KEY (`CITY_ID`) REFERENCES `city_mst_tbl` (`ID`),
  CONSTRAINT `FKD90D882DD4819085` FOREIGN KEY (`USER_ID`) REFERENCES `user_mst_tbl` (`ID`),
  CONSTRAINT `FK_df5ib42g11ar3kfcfkdc5m50a` FOREIGN KEY (`STATE_ID`) REFERENCES `state_mst_tbl` (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `user_addresses_tbl`
--

/*!40000 ALTER TABLE `user_addresses_tbl` DISABLE KEYS */;
/*!40000 ALTER TABLE `user_addresses_tbl` ENABLE KEYS */;


--
-- Definition of table `user_basic_profileinfo_tbl`
--

DROP TABLE IF EXISTS `user_basic_profileinfo_tbl`;
CREATE TABLE `user_basic_profileinfo_tbl` (
  `ID` bigint(20) NOT NULL auto_increment,
  `DATE_OF_BIRTH` datetime default NULL,
  `HIGHER_EDUCATION_LEVEL` varchar(255) default NULL,
  `LANGUAGES_KNOWN` varchar(255) default NULL,
  `PROFILE_SUMMARY` varchar(255) default NULL,
  `RESUME_PATH` varchar(255) default NULL,
  `VEDIO_PATH` varchar(255) default NULL,
  `USER_ID` bigint(20) default NULL,
  PRIMARY KEY  (`ID`),
  KEY `FK282E9DD1D4819085` (`USER_ID`),
  CONSTRAINT `FK282E9DD1D4819085` FOREIGN KEY (`USER_ID`) REFERENCES `user_mst_tbl` (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `user_basic_profileinfo_tbl`
--

/*!40000 ALTER TABLE `user_basic_profileinfo_tbl` DISABLE KEYS */;
/*!40000 ALTER TABLE `user_basic_profileinfo_tbl` ENABLE KEYS */;


--
-- Definition of table `user_basic_skills_tbl`
--

DROP TABLE IF EXISTS `user_basic_skills_tbl`;
CREATE TABLE `user_basic_skills_tbl` (
  `ID` bigint(20) NOT NULL auto_increment,
  `ANALYTICAL_RATING` bigint(20) default NULL,
  `COMMUNICATION_RATING` bigint(20) default NULL,
  `USER_ID` bigint(20) default NULL,
  PRIMARY KEY  (`ID`),
  KEY `FKB7A05CE6D4819085` (`USER_ID`),
  CONSTRAINT `FKB7A05CE6D4819085` FOREIGN KEY (`USER_ID`) REFERENCES `user_mst_tbl` (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `user_basic_skills_tbl`
--

/*!40000 ALTER TABLE `user_basic_skills_tbl` DISABLE KEYS */;
/*!40000 ALTER TABLE `user_basic_skills_tbl` ENABLE KEYS */;


--
-- Definition of table `user_basicinfo_mst_tbl`
--

DROP TABLE IF EXISTS `user_basicinfo_mst_tbl`;
CREATE TABLE `user_basicinfo_mst_tbl` (
  `ID` bigint(20) NOT NULL auto_increment,
  `DATE_OF_BIRTH` datetime default NULL,
  `HIGHER_EDUCATION_LEVEL` varchar(255) default NULL,
  `LANGUAGES_KNOWN` varchar(255) default NULL,
  `PROFILE_SUMMARY` varchar(255) default NULL,
  `RESUME_PATH` varchar(255) default NULL,
  `VEDIO_PATH` varchar(255) default NULL,
  `TOTAL_EXPERIANCE` float default NULL,
  `USER_ID` bigint(20) default NULL,
  PRIMARY KEY  (`ID`),
  KEY `FK44A534B6D4819085` (`USER_ID`),
  CONSTRAINT `FK44A534B6D4819085` FOREIGN KEY (`USER_ID`) REFERENCES `user_mst_tbl` (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `user_basicinfo_mst_tbl`
--

/*!40000 ALTER TABLE `user_basicinfo_mst_tbl` DISABLE KEYS */;
/*!40000 ALTER TABLE `user_basicinfo_mst_tbl` ENABLE KEYS */;


--
-- Definition of table `user_educations_tbl`
--

DROP TABLE IF EXISTS `user_educations_tbl`;
CREATE TABLE `user_educations_tbl` (
  `ID` bigint(20) NOT NULL auto_increment,
  `BRANCH_NAME` varchar(255) default NULL,
  `EDUCATION_TYPE` varchar(255) default NULL,
  `INSTITUTE_NAME` varchar(255) default NULL,
  `PERCENTAGE` float default NULL,
  `UNIVERSITY_NAME` varchar(255) default NULL,
  `YEAR_OF_PASSING` varchar(255) default NULL,
  `USER_ID` bigint(20) default NULL,
  `INSTITUTE_ID` bigint(20) default NULL,
  `UNIVERSITY_ID` bigint(20) default NULL,
  PRIMARY KEY  (`ID`),
  KEY `FK5759B23ED4819085` (`USER_ID`),
  KEY `FK5759B23EF9E024CB` (`UNIVERSITY_ID`),
  KEY `FK5759B23E26DD6FCF` (`INSTITUTE_ID`),
  CONSTRAINT `FK5759B23E26DD6FCF` FOREIGN KEY (`INSTITUTE_ID`) REFERENCES `institute_mst_tbl` (`ID`),
  CONSTRAINT `FK5759B23ED4819085` FOREIGN KEY (`USER_ID`) REFERENCES `user_mst_tbl` (`ID`),
  CONSTRAINT `FK5759B23EF9E024CB` FOREIGN KEY (`UNIVERSITY_ID`) REFERENCES `university_mst_tbl` (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `user_educations_tbl`
--

/*!40000 ALTER TABLE `user_educations_tbl` DISABLE KEYS */;
/*!40000 ALTER TABLE `user_educations_tbl` ENABLE KEYS */;


--
-- Definition of table `user_employers_info_tbl`
--

DROP TABLE IF EXISTS `user_employers_info_tbl`;
CREATE TABLE `user_employers_info_tbl` (
  `ID` bigint(20) NOT NULL auto_increment,
  `DESIGNATION` varchar(255) default NULL,
  `EMPLOYER` varchar(255) default NULL,
  `EMPLOYER_STATUS` varchar(255) default NULL,
  `PROFILE` varchar(255) default NULL,
  `END_MONTH` varchar(255) default NULL,
  `START_MONTH` varchar(255) default NULL,
  `END_YEAR` varchar(255) default NULL,
  `START_YEAR` varchar(255) default NULL,
  `USER_ID` bigint(20) default NULL,
  `JOB_PROFILE` varchar(255) default NULL,
  PRIMARY KEY  (`ID`),
  KEY `FK14AFC0E8D4819085` (`USER_ID`),
  CONSTRAINT `FK14AFC0E8D4819085` FOREIGN KEY (`USER_ID`) REFERENCES `user_mst_tbl` (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

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
  `ID` bigint(20) NOT NULL auto_increment,
  `CURRENT_SALARY` varchar(255) default NULL,
  `EXPECTED_SALARY` varchar(255) default NULL,
  `YEARS_OF_MONTHS` int(11) default NULL,
  `YEARS_OF_EXPERIANCE` int(11) default NULL,
  `USER_ID` bigint(20) default NULL,
  `CURRENT_SALARY_IN_LAKHS` varchar(255) default NULL,
  `CURRENT_SALARY_IN_THOUSANDS` varchar(255) default NULL,
  `EXPECTED_SALARY_IN_LAKHS` varchar(255) default NULL,
  `EXPECTED_SALARY_IN_THOUSANDS` varchar(255) default NULL,
  PRIMARY KEY  (`ID`),
  KEY `FK4F5CE2E1D4819085` (`USER_ID`),
  CONSTRAINT `FK4F5CE2E1D4819085` FOREIGN KEY (`USER_ID`) REFERENCES `user_mst_tbl` (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `user_experiance_tbl`
--

/*!40000 ALTER TABLE `user_experiance_tbl` DISABLE KEYS */;
/*!40000 ALTER TABLE `user_experiance_tbl` ENABLE KEYS */;


--
-- Definition of table `user_interview_status_tbl`
--

DROP TABLE IF EXISTS `user_interview_status_tbl`;
CREATE TABLE `user_interview_status_tbl` (
  `ID` bigint(20) NOT NULL auto_increment,
  `ATTITUDE` bigint(20) default NULL,
  `FTF_EXTRA_COMMENTS` varchar(255) default NULL,
  `LOGICAL` bigint(20) default NULL,
  `SYS_PROGRAMS_EXECUTED` bigint(20) default NULL,
  `SYS_PROGRAMS_GIVEN` bigint(20) default NULL,
  `sysRating` bigint(20) default NULL,
  `TASK_RATING` bigint(20) default NULL,
  `TASKS_COMPLETED` bigint(20) default NULL,
  `TASKS_GIVEN` bigint(20) default NULL,
  `TELE_COMMUNICATION` bigint(20) default NULL,
  `TELE_EXTRA_COMMENTS` varchar(255) default NULL,
  `TELE_PROGRAMMING` bigint(20) default NULL,
  `USER_ID` bigint(20) default NULL,
  PRIMARY KEY  (`ID`),
  KEY `FK3D5EBB63D4819085` (`USER_ID`),
  CONSTRAINT `FK3D5EBB63D4819085` FOREIGN KEY (`USER_ID`) REFERENCES `user_mst_tbl` (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

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
  `ID` bigint(20) NOT NULL auto_increment,
  `IS_EXAM_COMPLETED` bit(1) default NULL,
  `INTERVIEW_DATE` datetime default NULL,
  `INTERVIEW_TIMING` varchar(255) default NULL,
  `RESHEDULE` bit(1) default NULL,
  `USER_ID` bigint(20) default NULL,
  PRIMARY KEY  (`ID`),
  KEY `FK2EFDD68CD4819085` (`USER_ID`),
  CONSTRAINT `FK2EFDD68CD4819085` FOREIGN KEY (`USER_ID`) REFERENCES `user_mst_tbl` (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

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
  `ID` bigint(20) NOT NULL auto_increment,
  `ACCOMLISHMENTS` longtext,
  `APPLICATIONS` longtext,
  `CREATED_ON` datetime default NULL,
  `GAMES` longtext,
  `MOBILE_APPS` longtext,
  `STATUS` varchar(255) default NULL,
  `STRENGTHS` longtext,
  `WEAKNESS` longtext,
  `USER_ID` bigint(20) default NULL,
  PRIMARY KEY  (`ID`),
  KEY `FK9EC2ECE1D4819085` (`USER_ID`),
  CONSTRAINT `FK9EC2ECE1D4819085` FOREIGN KEY (`USER_ID`) REFERENCES `user_mst_tbl` (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

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
  `ID` bigint(20) NOT NULL auto_increment,
  `LANGUAGE_ID` bigint(20) default NULL,
  `USER_ID` bigint(20) default NULL,
  PRIMARY KEY  (`ID`),
  KEY `FK_9xwg9vwc2n2ophjaarlivp90g` (`LANGUAGE_ID`),
  KEY `FK_qsv8lrqek37gd9feuxuu9cfny` (`USER_ID`),
  CONSTRAINT `FK_9xwg9vwc2n2ophjaarlivp90g` FOREIGN KEY (`LANGUAGE_ID`) REFERENCES `languages_mst_tbl` (`ID`),
  CONSTRAINT `FK_qsv8lrqek37gd9feuxuu9cfny` FOREIGN KEY (`USER_ID`) REFERENCES `user_mst_tbl` (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `user_languages_trn_tbl`
--

/*!40000 ALTER TABLE `user_languages_trn_tbl` DISABLE KEYS */;
/*!40000 ALTER TABLE `user_languages_trn_tbl` ENABLE KEYS */;


--
-- Definition of table `user_mst_tbl`
--

DROP TABLE IF EXISTS `user_mst_tbl`;
CREATE TABLE `user_mst_tbl` (
  `ID` bigint(20) NOT NULL auto_increment,
  `CREATED_ON` datetime default NULL,
  `EMAILID` varchar(255) default NULL,
  `VISIBILITY` bit(1) default NULL,
  `MOBILENO` varchar(255) default NULL,
  `PASSWORD` varchar(255) default NULL,
  `STATUS` varchar(255) default NULL,
  `USERNAME` varchar(255) default NULL,
  `ROLE_ID` bigint(20) default NULL,
  `IS_EXAM_COMPLETED` bit(1) default NULL,
  PRIMARY KEY  (`ID`),
  KEY `FKABC3B7192287F105` (`ROLE_ID`),
  CONSTRAINT `FKABC3B7192287F105` FOREIGN KEY (`ROLE_ID`) REFERENCES `role_mst_tbl` (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `user_mst_tbl`
--

/*!40000 ALTER TABLE `user_mst_tbl` DISABLE KEYS */;
INSERT INTO `user_mst_tbl` (`ID`,`CREATED_ON`,`EMAILID`,`VISIBILITY`,`MOBILENO`,`PASSWORD`,`STATUS`,`USERNAME`,`ROLE_ID`,`IS_EXAM_COMPLETED`) VALUES 
 (1,'2017-08-06 00:00:00','user1@gmail.com',0x01,'1234567890','e10adc3949ba59abbe56e057f20f883e','ACTIVE','user1',6,NULL),
 (2,'2017-08-06 00:00:00','hr@gmail.com',0x00,'1234567891','e10adc3949ba59abbe56e057f20f883e','ACTIVE','hr',7,NULL),
 (3,'2017-08-06 00:00:00','po@gmail.com',NULL,'1234567892','e10adc3949ba59abbe56e057f20f883e','ACTIVE','po',8,NULL),
 (11,'2017-12-03 00:00:00','nekkala.appaji@gmail.com',0x01,'9986687238','e10adc3949ba59abbe56e057f20f883e','ACTIVE','po1',8,NULL),
 (12,'2017-12-03 00:00:00','user2@gmail.com',0x00,'1245656789','e10adc3949ba59abbe56e057f20f883e','ACTIVE','user2',6,NULL),
 (13,'2017-12-13 00:00:00','phani1694@gmail.com',0x01,'8977147129','ed1729a3c2418f3722353fea7746c67c','PENDING','phani',1,NULL),
 (14,'2017-12-13 00:00:00','velidiaparna@gmail.com',0x01,'8500002629','e10adc3949ba59abbe56e057f20f883e','PENDING','aparna',1,NULL),
 (15,'2019-09-08 00:00:00','codingkrishna@gmail.com',0x01,'8123870076','e10adc3949ba59abbe56e057f20f883e','ACTIVE','Krishna',1,NULL);
/*!40000 ALTER TABLE `user_mst_tbl` ENABLE KEYS */;


--
-- Definition of table `user_projects_tbl`
--

DROP TABLE IF EXISTS `user_projects_tbl`;
CREATE TABLE `user_projects_tbl` (
  `ID` bigint(20) NOT NULL auto_increment,
  `PROJECT_DESC` varchar(255) default NULL,
  `END_START` datetime default NULL,
  `TITLE` varchar(255) default NULL,
  `RESPONSIBILITIES` varchar(255) default NULL,
  `START_DATE` datetime default NULL,
  `USER_ID` bigint(20) default NULL,
  `PROJECT_DOMAIN_ID` bigint(20) default NULL,
  PRIMARY KEY  (`ID`),
  KEY `FKF62E7A6DD4819085` (`USER_ID`),
  KEY `FK_4nidb90uac72iea3ijb86hfw3` (`PROJECT_DOMAIN_ID`),
  CONSTRAINT `FKF62E7A6DD4819085` FOREIGN KEY (`USER_ID`) REFERENCES `user_mst_tbl` (`ID`),
  CONSTRAINT `FK_4nidb90uac72iea3ijb86hfw3` FOREIGN KEY (`PROJECT_DOMAIN_ID`) REFERENCES `project_domain_mst_tbl` (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `user_projects_tbl`
--

/*!40000 ALTER TABLE `user_projects_tbl` DISABLE KEYS */;
/*!40000 ALTER TABLE `user_projects_tbl` ENABLE KEYS */;


--
-- Definition of table `user_search_view`
--

DROP TABLE IF EXISTS `user_search_view`;
CREATE TABLE `user_search_view` (
  `USER_ID` bigint(20) NOT NULL auto_increment,
  `ADDRESS` varchar(255) default NULL,
  `CITY_ID` bigint(20) default NULL,
  `EMAILID` varchar(255) default NULL,
  `MOBILENO` varchar(255) default NULL,
  `ROLE_ID` bigint(20) default NULL,
  `USERNAME` varchar(255) default NULL,
  `YEARS_OF_EXPERIANCE` int(11) default NULL,
  PRIMARY KEY  (`USER_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `user_search_view`
--

/*!40000 ALTER TABLE `user_search_view` DISABLE KEYS */;
/*!40000 ALTER TABLE `user_search_view` ENABLE KEYS */;


--
-- Definition of table `user_social_info_tbl`
--

DROP TABLE IF EXISTS `user_social_info_tbl`;
CREATE TABLE `user_social_info_tbl` (
  `ID` bigint(20) NOT NULL auto_increment,
  `FACEBOOK_ID` varchar(255) default NULL,
  `SKYPE_ID` varchar(255) default NULL,
  `TWITTER_ID` varchar(255) default NULL,
  `WHATSAPP_NO` varchar(255) default NULL,
  `USER_ID` bigint(20) default NULL,
  PRIMARY KEY  (`ID`),
  KEY `FKA9C1BCCBD4819085` (`USER_ID`),
  CONSTRAINT `FKA9C1BCCBD4819085` FOREIGN KEY (`USER_ID`) REFERENCES `user_mst_tbl` (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `user_social_info_tbl`
--

/*!40000 ALTER TABLE `user_social_info_tbl` DISABLE KEYS */;
/*!40000 ALTER TABLE `user_social_info_tbl` ENABLE KEYS */;


--
-- Definition of table `user_submitted_tasks_tbl`
--

DROP TABLE IF EXISTS `user_submitted_tasks_tbl`;
CREATE TABLE `user_submitted_tasks_tbl` (
  `ID` bigint(20) NOT NULL auto_increment,
  `FILENAME` varchar(255) default NULL,
  `USER_ID` bigint(20) default NULL,
  PRIMARY KEY  (`ID`),
  KEY `FK77A83ED5D4819085` (`USER_ID`),
  CONSTRAINT `FK77A83ED5D4819085` FOREIGN KEY (`USER_ID`) REFERENCES `user_mst_tbl` (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

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
  `ID` bigint(20) NOT NULL auto_increment,
  `TECH_SKILL_ID` bigint(20) default NULL,
  `USER_ID` bigint(20) default NULL,
  PRIMARY KEY  (`ID`),
  KEY `FK282BB007E44A5007` (`TECH_SKILL_ID`),
  KEY `FK282BB007D4819085` (`USER_ID`),
  CONSTRAINT `FK282BB007D4819085` FOREIGN KEY (`USER_ID`) REFERENCES `user_mst_tbl` (`ID`),
  CONSTRAINT `FK282BB007E44A5007` FOREIGN KEY (`TECH_SKILL_ID`) REFERENCES `technologies_mst_tbl` (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `user_tech_skills_trn_tbl`
--

/*!40000 ALTER TABLE `user_tech_skills_trn_tbl` DISABLE KEYS */;
/*!40000 ALTER TABLE `user_tech_skills_trn_tbl` ENABLE KEYS */;




/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;

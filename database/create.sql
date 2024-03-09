-- MySQL dump 10.13  Distrib 8.0.33, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: quality_control_login_evaluation
-- ------------------------------------------------------
-- Server version	8.0.34

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `blood_transfusion_ratio`
--

DROP TABLE IF EXISTS `blood_transfusion_ratio`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `blood_transfusion_ratio` (
  `office_name` varchar(20) NOT NULL,
  `a_type_suspension_red` decimal(10,2) DEFAULT NULL,
  `a_type_plasma` decimal(10,2) DEFAULT NULL,
  `b_type_suspension_red` decimal(10,2) DEFAULT NULL,
  `b_type_plasma` decimal(10,2) DEFAULT NULL,
  `o_type_suspension_red` decimal(10,2) DEFAULT NULL,
  `o_type_plasma` decimal(10,2) DEFAULT NULL,
  `ab_type_suspension_red` decimal(10,2) DEFAULT NULL,
  `ab_type_plasma` decimal(10,2) DEFAULT NULL,
  `wash_rbc` decimal(10,2) DEFAULT NULL,
  `thaw_rbc` decimal(10,2) DEFAULT NULL,
  `full_blood` decimal(10,2) DEFAULT NULL,
  `apheresis_platelets` decimal(10,2) DEFAULT NULL,
  `cryoprecipitate` decimal(10,2) DEFAULT NULL,
  `component_blood_ratio` varchar(20) DEFAULT NULL,
  `user_time` date NOT NULL,
  `suspension_red_sum` decimal(10,2) GENERATED ALWAYS AS ((((`a_type_suspension_red` + `b_type_suspension_red`) + `o_type_suspension_red`) + `ab_type_suspension_red`)) VIRTUAL,
  `plasma_sum` decimal(10,2) GENERATED ALWAYS AS ((((`a_type_plasma` + `b_type_plasma`) + `o_type_plasma`) + `ab_type_plasma`)) VIRTUAL,
  PRIMARY KEY (`office_name`,`user_time`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `blood_transfusion_ratio`
--

LOCK TABLES `blood_transfusion_ratio` WRITE;
/*!40000 ALTER TABLE `blood_transfusion_ratio` DISABLE KEYS */;
/*!40000 ALTER TABLE `blood_transfusion_ratio` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `blood_transfusion_related_records`
--

DROP TABLE IF EXISTS `blood_transfusion_related_records`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `blood_transfusion_related_records` (
  `office_name` varchar(20) NOT NULL,
  `patient_name` varchar(20) NOT NULL,
  `zhuguan_doctor_name` varchar(20) NOT NULL,
  `patient_id` bigint DEFAULT NULL,
  `admission_number` bigint DEFAULT NULL,
  `major_defect` text,
  `points_deducted` decimal(10,2) DEFAULT NULL,
  `user_time` date NOT NULL,
  PRIMARY KEY (`office_name`,`patient_name`,`zhuguan_doctor_name`,`user_time`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `blood_transfusion_related_records`
--

LOCK TABLES `blood_transfusion_related_records` WRITE;
/*!40000 ALTER TABLE `blood_transfusion_related_records` DISABLE KEYS */;
/*!40000 ALTER TABLE `blood_transfusion_related_records` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `bonus_points_project`
--

DROP TABLE IF EXISTS `bonus_points_project`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `bonus_points_project` (
  `office_name` varchar(20) NOT NULL,
  `bonus_points` double DEFAULT NULL,
  `bonus_reason` text,
  `user_time` date NOT NULL,
  PRIMARY KEY (`office_name`,`user_time`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `bonus_points_project`
--

LOCK TABLES `bonus_points_project` WRITE;
/*!40000 ALTER TABLE `bonus_points_project` DISABLE KEYS */;
/*!40000 ALTER TABLE `bonus_points_project` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `clinical_pathway`
--

DROP TABLE IF EXISTS `clinical_pathway`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `clinical_pathway` (
  `office_name` varchar(20) NOT NULL,
  `invasive_disease_species` varchar(50) NOT NULL,
  `number_of_entrants` bigint DEFAULT NULL,
  `num_of_finish` bigint DEFAULT NULL,
  `num_of_exits` bigint DEFAULT NULL,
  `num_of_variants` bigint DEFAULT NULL,
  `death_number` bigint DEFAULT NULL,
  `no_enter_num` bigint DEFAULT NULL,
  `user_time` date NOT NULL,
  PRIMARY KEY (`office_name`,`user_time`,`invasive_disease_species`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `clinical_pathway`
--

LOCK TABLES `clinical_pathway` WRITE;
/*!40000 ALTER TABLE `clinical_pathway` DISABLE KEYS */;
/*!40000 ALTER TABLE `clinical_pathway` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `death_case_discussion_system`
--

DROP TABLE IF EXISTS `death_case_discussion_system`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `death_case_discussion_system` (
  `office_name` varchar(20) NOT NULL,
  `points_deducted` decimal(10,2) DEFAULT NULL,
  `has_case_death` enum('是','否') DEFAULT NULL,
  `has_record` enum('是','否') DEFAULT NULL,
  `participation` enum('无欠缺','欠缺护士','欠缺医师') DEFAULT NULL,
  `signed_title` enum('是','否') DEFAULT NULL,
  `participation_signed` enum('是','否') DEFAULT NULL,
  `speech_order` enum('是','否') DEFAULT NULL,
  `paste` enum('是','否') DEFAULT NULL,
  `discussion_opinions` enum('是','否') DEFAULT NULL,
  `host_signed` enum('是','否') DEFAULT NULL,
  `recorder_signed` enum('是','否') DEFAULT NULL,
  `death_diagnosis` enum('是','否') DEFAULT NULL,
  `sum_experience` enum('是','否') DEFAULT NULL,
  `scrawled_signature` enum('是','否') DEFAULT NULL,
  `user_time` date NOT NULL,
  PRIMARY KEY (`office_name`,`user_time`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `death_case_discussion_system`
--

LOCK TABLES `death_case_discussion_system` WRITE;
/*!40000 ALTER TABLE `death_case_discussion_system` DISABLE KEYS */;
/*!40000 ALTER TABLE `death_case_discussion_system` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `diameter_calculation`
--

DROP TABLE IF EXISTS `diameter_calculation`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `diameter_calculation` (
  `office_name` varchar(20) NOT NULL,
  `user_time` date NOT NULL,
  `actual_diameter` bigint DEFAULT NULL,
  `completed_cases_num` bigint DEFAULT NULL,
  `unentered_diameter` bigint DEFAULT NULL,
  `completion_rate` decimal(10,4) DEFAULT NULL,
  `enrollment_rate` decimal(10,4) DEFAULT NULL,
  `entry_rate` decimal(10,4) DEFAULT NULL,
  `points_deducted` int DEFAULT NULL,
  PRIMARY KEY (`office_name`,`user_time`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `diameter_calculation`
--

LOCK TABLES `diameter_calculation` WRITE;
/*!40000 ALTER TABLE `diameter_calculation` DISABLE KEYS */;
/*!40000 ALTER TABLE `diameter_calculation` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `difficult_case_discussion_system`
--

DROP TABLE IF EXISTS `difficult_case_discussion_system`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `difficult_case_discussion_system` (
  `office_name` varchar(20) NOT NULL,
  `points_deducted` decimal(10,2) DEFAULT NULL,
  `difficult_discussion` enum('是','否') DEFAULT NULL,
  `unplanned_reoperation` enum('是','否','无非计划手术') DEFAULT NULL,
  `postoperative_com` enum('是','否','无术后并发症') DEFAULT NULL,
  `medical_record_type` text,
  `participation` enum('欠缺医师','欠缺护士','无欠缺') DEFAULT NULL,
  `signed_title` enum('是','否') DEFAULT NULL,
  `participation_signed` enum('是','否') DEFAULT NULL,
  `speech_order` enum('是','否') DEFAULT NULL,
  `paste` enum('是','否') DEFAULT NULL,
  `discussion_opinions` enum('是','否') DEFAULT NULL,
  `host_signed` enum('是','否') DEFAULT NULL,
  `recorder_signed` enum('是','否') DEFAULT NULL,
  `death_diagnosis` enum('是','否') DEFAULT NULL,
  `solution` enum('是','否') DEFAULT NULL,
  `scrawled_signature` enum('是','否') DEFAULT NULL,
  `user_time` date NOT NULL,
  PRIMARY KEY (`office_name`,`user_time`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `difficult_case_discussion_system`
--

LOCK TABLES `difficult_case_discussion_system` WRITE;
/*!40000 ALTER TABLE `difficult_case_discussion_system` DISABLE KEYS */;
/*!40000 ALTER TABLE `difficult_case_discussion_system` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `discharged_patients`
--

DROP TABLE IF EXISTS `discharged_patients`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `discharged_patients` (
  `office_name` varchar(20) NOT NULL,
  `month_discharged_patients` bigint DEFAULT NULL,
  `user_time` date NOT NULL,
  PRIMARY KEY (`office_name`,`user_time`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `discharged_patients`
--

LOCK TABLES `discharged_patients` WRITE;
/*!40000 ALTER TABLE `discharged_patients` DISABLE KEYS */;
/*!40000 ALTER TABLE `discharged_patients` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `doctor_patient_relationship`
--

DROP TABLE IF EXISTS `doctor_patient_relationship`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `doctor_patient_relationship` (
  `id` int NOT NULL AUTO_INCREMENT,
  `assessment_items` varchar(100) DEFAULT NULL,
  `office_name` varchar(20) DEFAULT NULL,
  `assessee` varchar(20) DEFAULT NULL,
  `patient_name_num` varchar(100) DEFAULT NULL,
  `quality_control_details` text,
  `assessment_results` text,
  `points_deducted` decimal(10,2) DEFAULT NULL,
  `user_time` date DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `doctor_patient_relationship`
--

LOCK TABLES `doctor_patient_relationship` WRITE;
/*!40000 ALTER TABLE `doctor_patient_relationship` DISABLE KEYS */;
/*!40000 ALTER TABLE `doctor_patient_relationship` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `emergency_medical_records`
--

DROP TABLE IF EXISTS `emergency_medical_records`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `emergency_medical_records` (
  `office_name` varchar(20) DEFAULT NULL,
  `records_type` varchar(20) DEFAULT NULL,
  `doctor_name` varchar(20) DEFAULT NULL,
  `outpatient_number` varchar(20) DEFAULT NULL,
  `summary` text,
  `medical_records_score` decimal(10,2) DEFAULT NULL,
  `missing_medical_records_score` decimal(10,2) DEFAULT NULL,
  `chief_complaint_without_time_score` decimal(10,2) DEFAULT NULL,
  `replicates_chief_complaint_score` decimal(10,2) DEFAULT NULL,
  `chief_complaint_inconsistency_score` decimal(10,2) DEFAULT NULL,
  `no_significant_symptoms_or_signs_score` decimal(10,2) DEFAULT NULL,
  `no_physical_signs_score` decimal(10,2) DEFAULT NULL,
  `dispute_score` decimal(10,2) DEFAULT NULL,
  `user_time` date DEFAULT NULL,
  `total_deduction_points` decimal(10,2) GENERATED ALWAYS AS ((((((((`medical_records_score` + `missing_medical_records_score`) + `chief_complaint_without_time_score`) + `replicates_chief_complaint_score`) + `chief_complaint_inconsistency_score`) + `no_significant_symptoms_or_signs_score`) + `no_physical_signs_score`) + `dispute_score`)) VIRTUAL,
  `id` int NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `emergency_medical_records`
--

LOCK TABLES `emergency_medical_records` WRITE;
/*!40000 ALTER TABLE `emergency_medical_records` DISABLE KEYS */;
/*!40000 ALTER TABLE `emergency_medical_records` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `extended_hospital_stay_management`
--

DROP TABLE IF EXISTS `extended_hospital_stay_management`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `extended_hospital_stay_management` (
  `office_name` varchar(255) DEFAULT NULL,
  `doctor_name` varchar(255) DEFAULT NULL,
  `admission_number` bigint DEFAULT NULL,
  `patient_name` varchar(255) DEFAULT NULL,
  `reporting_time_node` datetime DEFAULT NULL,
  `reporting_time` datetime DEFAULT NULL,
  `stage_summary` enum('有','无') DEFAULT NULL,
  `director_rounds` enum('是','否') DEFAULT NULL,
  `office_discuss` enum('是','否') DEFAULT NULL,
  `discuss` enum('是','否') DEFAULT NULL,
  `transfer_office` enum('是','否') DEFAULT NULL,
  `extended_hospital_stay_reason` text,
  `medical_record_defects` varchar(255) DEFAULT NULL,
  `user_time` date DEFAULT NULL,
  `report_type` varchar(20) DEFAULT NULL,
  `points_deducted` decimal(10,2) DEFAULT NULL,
  `id` int NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `extended_hospital_stay_management`
--

LOCK TABLES `extended_hospital_stay_management` WRITE;
/*!40000 ALTER TABLE `extended_hospital_stay_management` DISABLE KEYS */;
/*!40000 ALTER TABLE `extended_hospital_stay_management` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `final_medical_record`
--

DROP TABLE IF EXISTS `final_medical_record`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `final_medical_record` (
  `office_name` varchar(20) DEFAULT NULL,
  `doctor_name` varchar(20) DEFAULT NULL,
  `director_name` varchar(20) DEFAULT NULL,
  `patient_id` bigint DEFAULT NULL,
  `grade_b_medical_record` enum('有','无') DEFAULT NULL,
  `grade_b_medical_record_doctor_fine` bigint DEFAULT NULL,
  `grade_b_medical_record_director_fine` bigint DEFAULT NULL,
  `grade_c_medical_record` enum('有','无') DEFAULT NULL,
  `grade_c_medical_record_doctor_fine` bigint DEFAULT NULL,
  `grade_c_medical_record_director_fine` bigint DEFAULT NULL,
  `fine_reason` text,
  `user_time` date DEFAULT NULL,
  `id` int NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `final_medical_record`
--

LOCK TABLES `final_medical_record` WRITE;
/*!40000 ALTER TABLE `final_medical_record` DISABLE KEYS */;
/*!40000 ALTER TABLE `final_medical_record` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `medical_exam_application_form`
--

DROP TABLE IF EXISTS `medical_exam_application_form`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `medical_exam_application_form` (
  `office_name` varchar(20) NOT NULL,
  `medical_exam_number` bigint unsigned DEFAULT NULL,
  `unqualified_cases_number` bigint unsigned DEFAULT NULL,
  `fail_reason` text,
  `user_time` date NOT NULL,
  `failure_rate` decimal(10,4) GENERATED ALWAYS AS ((case when (`medical_exam_number` = 0) then 0 else (`unqualified_cases_number` / `medical_exam_number`) end)) VIRTUAL,
  `pass_rate` decimal(10,4) GENERATED ALWAYS AS ((1 - `failure_rate`)) VIRTUAL,
  `points_deducted` decimal(10,2) GENERATED ALWAYS AS ((case when (`failure_rate` > 0.05) then (0.5 * `unqualified_cases_number`) else 0 end)) VIRTUAL,
  PRIMARY KEY (`office_name`,`user_time`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `medical_exam_application_form`
--

LOCK TABLES `medical_exam_application_form` WRITE;
/*!40000 ALTER TABLE `medical_exam_application_form` DISABLE KEYS */;
/*!40000 ALTER TABLE `medical_exam_application_form` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `medical_exam_application_form_fail`
--

DROP TABLE IF EXISTS `medical_exam_application_form_fail`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `medical_exam_application_form_fail` (
  `patient_name` varchar(20) NOT NULL,
  `office_name` varchar(20) DEFAULT NULL,
  `doctor_name` varchar(20) NOT NULL,
  `reception_time` date NOT NULL,
  `application_form_specification` enum('是','否') DEFAULT NULL,
  `doctor_advice` enum('有','无') DEFAULT NULL,
  `specimen_fixation_time` enum('是','否') DEFAULT NULL,
  `add_sample_fixation_solution` enum('是','否') DEFAULT NULL,
  `user_time` date DEFAULT NULL,
  PRIMARY KEY (`patient_name`,`doctor_name`,`reception_time`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `medical_exam_application_form_fail`
--

LOCK TABLES `medical_exam_application_form_fail` WRITE;
/*!40000 ALTER TABLE `medical_exam_application_form_fail` DISABLE KEYS */;
/*!40000 ALTER TABLE `medical_exam_application_form_fail` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `medical_records_section`
--

DROP TABLE IF EXISTS `medical_records_section`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `medical_records_section` (
  `office_name` varchar(20) NOT NULL,
  `medical_record_page_score` decimal(8,2) DEFAULT NULL,
  `user_time` date NOT NULL,
  PRIMARY KEY (`office_name`,`user_time`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `medical_records_section`
--

LOCK TABLES `medical_records_section` WRITE;
/*!40000 ALTER TABLE `medical_records_section` DISABLE KEYS */;
/*!40000 ALTER TABLE `medical_records_section` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `medical_services_section`
--

DROP TABLE IF EXISTS `medical_services_section`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `medical_services_section` (
  `office_name` varchar(20) NOT NULL,
  `med_tech_service_capabilities` double DEFAULT NULL,
  `prescriptive_tasks` double DEFAULT NULL,
  `continuous_improvement_metrics` double DEFAULT NULL,
  `user_time` date NOT NULL,
  PRIMARY KEY (`office_name`,`user_time`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `medical_services_section`
--

LOCK TABLES `medical_services_section` WRITE;
/*!40000 ALTER TABLE `medical_services_section` DISABLE KEYS */;
/*!40000 ALTER TABLE `medical_services_section` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `mq_management_team_office`
--

DROP TABLE IF EXISTS `mq_management_team_office`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `mq_management_team_office` (
  `office_name` varchar(20) NOT NULL,
  `meeting_time` date DEFAULT NULL,
  `qc_data_upload_time` date DEFAULT NULL,
  `user_administrative_tools` enum('是','否') DEFAULT NULL,
  `continuous_improvement_effect` enum('是','否') DEFAULT NULL,
  `content_complete` enum('是','否') DEFAULT NULL,
  `daily_management_activities` text,
  `sum_defects_month` text,
  `correctiveaction_this_month` text,
  `rectification_defects_last_month` text,
  `points_deducted` decimal(10,2) unsigned DEFAULT NULL,
  `user_time` date NOT NULL,
  PRIMARY KEY (`office_name`,`user_time`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `mq_management_team_office`
--

LOCK TABLES `mq_management_team_office` WRITE;
/*!40000 ALTER TABLE `mq_management_team_office` DISABLE KEYS */;
/*!40000 ALTER TABLE `mq_management_team_office` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `obstetric_special`
--

DROP TABLE IF EXISTS `obstetric_special`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `obstetric_special` (
  `office_name` varchar(20) DEFAULT NULL,
  `exclusive_breastfeeding` decimal(6,4) DEFAULT NULL,
  `abnormal_cesarean` decimal(6,4) DEFAULT NULL,
  `cesarean` decimal(6,4) DEFAULT NULL,
  `complications_of_vaginal_delivery` decimal(6,4) DEFAULT NULL,
  `user_time` date DEFAULT NULL,
  `id` int NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `obstetric_special`
--

LOCK TABLES `obstetric_special` WRITE;
/*!40000 ALTER TABLE `obstetric_special` DISABLE KEYS */;
/*!40000 ALTER TABLE `obstetric_special` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `office_list`
--

DROP TABLE IF EXISTS `office_list`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `office_list` (
  `office_name` varchar(20) NOT NULL,
  PRIMARY KEY (`office_name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `office_list`
--

LOCK TABLES `office_list` WRITE;
/*!40000 ALTER TABLE `office_list` DISABLE KEYS */;
INSERT INTO `office_list` VALUES ('中医科'),('乳腺甲状腺外科'),('产一科'),('产二科'),('产前诊断室'),('产科'),('儿科'),('儿童保健科'),('全科医学科'),('内分泌科'),('内镜室'),('口腔科'),('呼吸与危重症医学科'),('妇科'),('康复科'),('心功能室'),('心血管内科'),('急诊科'),('感染性疾病科'),('放射科'),('新生儿科'),('普外儿外肛肠科'),('检验科'),('泌尿外科'),('消化内科'),('烧伤整形美容皮肤外科'),('生殖健康与不孕不育科'),('疼痛科'),('病理科'),('皮肤科'),('眼耳鼻喉科'),('神经内科'),('神经外科'),('老年医学科'),('肝胆胰外科'),('肾病内科'),('胸外科'),('营养科'),('血液风湿免疫肿瘤科'),('超声科'),('输血科'),('重症医学科'),('骨科'),('麻醉科');
/*!40000 ALTER TABLE `office_list` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `outpatient_emergency_attendance_assessment`
--

DROP TABLE IF EXISTS `outpatient_emergency_attendance_assessment`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `outpatient_emergency_attendance_assessment` (
  `id` int NOT NULL AUTO_INCREMENT,
  `office_name` varchar(20) NOT NULL,
  `doctor_name` varchar(20) DEFAULT NULL,
  `outpatient_emergency_attendance` text,
  `points_deducted` decimal(10,2) unsigned DEFAULT NULL,
  `user_time` date NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `outpatient_emergency_attendance_assessment`
--

LOCK TABLES `outpatient_emergency_attendance_assessment` WRITE;
/*!40000 ALTER TABLE `outpatient_emergency_attendance_assessment` DISABLE KEYS */;
/*!40000 ALTER TABLE `outpatient_emergency_attendance_assessment` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `outpatient_medical_records`
--

DROP TABLE IF EXISTS `outpatient_medical_records`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `outpatient_medical_records` (
  `id` int NOT NULL AUTO_INCREMENT,
  `office_name` varchar(20) DEFAULT NULL,
  `doctor_name` varchar(20) DEFAULT NULL,
  `outpatient_number` varchar(20) DEFAULT NULL,
  `summary` text,
  `medical_records_score` decimal(10,2) DEFAULT NULL,
  `chief_complaint_without_time_score` decimal(10,2) DEFAULT NULL,
  `replicates_chief_complaint_score` decimal(10,2) DEFAULT NULL,
  `physical_signs_diagnosis_score` decimal(10,2) DEFAULT NULL,
  `no_significant_vital_signs_score` decimal(10,2) DEFAULT NULL,
  `no_physical_signs_score` decimal(10,2) DEFAULT NULL,
  `dispute_score` decimal(10,2) DEFAULT NULL,
  `user_time` date DEFAULT NULL,
  `total_deduction_points` decimal(10,2) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `outpatient_medical_records`
--

LOCK TABLES `outpatient_medical_records` WRITE;
/*!40000 ALTER TABLE `outpatient_medical_records` DISABLE KEYS */;
/*!40000 ALTER TABLE `outpatient_medical_records` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ph_ph_id`
--

DROP TABLE IF EXISTS `ph_ph_id`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `ph_ph_id` (
  `office_name` varchar(20) NOT NULL,
  `ward_health_education` text,
  `death_monitoring_work` text,
  `vaccines_and_cold_chain` text,
  `foodborne_disease_monitoring` text,
  `infectious_disease_reporting` text,
  `maternal_child_work` text,
  `public_health_check` text,
  `user_time` date NOT NULL,
  PRIMARY KEY (`office_name`,`user_time`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ph_ph_id`
--

LOCK TABLES `ph_ph_id` WRITE;
/*!40000 ALTER TABLE `ph_ph_id` DISABLE KEYS */;
/*!40000 ALTER TABLE `ph_ph_id` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `postoperative_complications`
--

DROP TABLE IF EXISTS `postoperative_complications`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `postoperative_complications` (
  `id` int NOT NULL AUTO_INCREMENT,
  `patient_name` varchar(20) DEFAULT NULL,
  `admission_number` bigint DEFAULT NULL,
  `patient_id` bigint DEFAULT NULL,
  `discharge_office` varchar(20) DEFAULT NULL,
  `discharge_date` datetime DEFAULT NULL,
  `departure_method` text,
  `disease_code` text,
  `suborder` text,
  `disease_name` text,
  `admission_condition` text,
  `disease_serial_number` text,
  `operation_code` text,
  `operation` text,
  `operation_date` date DEFAULT NULL,
  `selective` text,
  `complications_description` text,
  `user_time` date DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `postoperative_complications`
--

LOCK TABLES `postoperative_complications` WRITE;
/*!40000 ALTER TABLE `postoperative_complications` DISABLE KEYS */;
/*!40000 ALTER TABLE `postoperative_complications` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `qc_form_feedback_score`
--

DROP TABLE IF EXISTS `qc_form_feedback_score`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `qc_form_feedback_score` (
  `office_name` varchar(20) DEFAULT NULL,
  `user_time` date DEFAULT NULL,
  `final_score` decimal(6,2) DEFAULT NULL,
  `id` int NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`id`),
  UNIQUE KEY `office_name` (`office_name`,`user_time`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `qc_form_feedback_score`
--

LOCK TABLES `qc_form_feedback_score` WRITE;
/*!40000 ALTER TABLE `qc_form_feedback_score` DISABLE KEYS */;
/*!40000 ALTER TABLE `qc_form_feedback_score` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `qc_form_final_appeal`
--

DROP TABLE IF EXISTS `qc_form_final_appeal`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `qc_form_final_appeal` (
  `office_name` varchar(20) DEFAULT NULL,
  `user_time` date DEFAULT NULL,
  `final_appeal` text,
  `id` int NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`id`),
  UNIQUE KEY `office_name` (`office_name`,`user_time`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `qc_form_final_appeal`
--

LOCK TABLES `qc_form_final_appeal` WRITE;
/*!40000 ALTER TABLE `qc_form_final_appeal` DISABLE KEYS */;
/*!40000 ALTER TABLE `qc_form_final_appeal` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `qc_form_score`
--

DROP TABLE IF EXISTS `qc_form_score`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `qc_form_score` (
  `office_name` varchar(20) NOT NULL,
  `office_score` decimal(10,2) DEFAULT NULL,
  PRIMARY KEY (`office_name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `qc_form_score`
--

LOCK TABLES `qc_form_score` WRITE;
/*!40000 ALTER TABLE `qc_form_score` DISABLE KEYS */;
INSERT INTO `qc_form_score` VALUES ('乳腺甲状腺外科',30.00),('产一科',25.00),('产二科',25.00),('儿科',37.00),('全科医学科',33.00),('内分泌科',33.00),('呼吸与危重症医学科',33.00),('妇科',30.00),('心血管内科',26.00),('急诊科',34.00),('新生儿科',37.00),('普外儿外肛肠科',30.00),('泌尿外科',30.00),('消化内科',33.00),('烧伤整形美容皮肤外科',30.00),('眼耳鼻喉科',30.00),('神经内科',26.00),('神经外科',30.00),('老年医学科',33.00),('肝胆胰外科',30.00),('肾病内科',33.00),('胸外科',30.00),('血液风湿免疫肿瘤科',33.00),('重症医学科',28.00),('骨科',30.00);
/*!40000 ALTER TABLE `qc_form_score` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `qc_form_special_score`
--

DROP TABLE IF EXISTS `qc_form_special_score`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `qc_form_special_score` (
  `office_name` varchar(20) NOT NULL,
  `office_score` decimal(10,2) DEFAULT NULL,
  PRIMARY KEY (`office_name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `qc_form_special_score`
--

LOCK TABLES `qc_form_special_score` WRITE;
/*!40000 ALTER TABLE `qc_form_special_score` DISABLE KEYS */;
/*!40000 ALTER TABLE `qc_form_special_score` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `qc_rectification_situation`
--

DROP TABLE IF EXISTS `qc_rectification_situation`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `qc_rectification_situation` (
  `office_name` varchar(20) NOT NULL,
  `user_time` date NOT NULL,
  `rectification_situation` text,
  PRIMARY KEY (`office_name`,`user_time`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `qc_rectification_situation`
--

LOCK TABLES `qc_rectification_situation` WRITE;
/*!40000 ALTER TABLE `qc_rectification_situation` DISABLE KEYS */;
/*!40000 ALTER TABLE `qc_rectification_situation` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `rational_administration_drug`
--

DROP TABLE IF EXISTS `rational_administration_drug`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `rational_administration_drug` (
  `id` int NOT NULL AUTO_INCREMENT,
  `assessment_items` varchar(20) DEFAULT NULL,
  `project_name` varchar(100) DEFAULT NULL,
  `office_name` varchar(20) DEFAULT NULL,
  `person_responsible` varchar(100) DEFAULT NULL,
  `admission_outpatient_num` varchar(200) DEFAULT NULL,
  `quality_control_details` text,
  `assessment_results` text,
  `appeal` text,
  `user_time` date DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `rational_administration_drug`
--

LOCK TABLES `rational_administration_drug` WRITE;
/*!40000 ALTER TABLE `rational_administration_drug` DISABLE KEYS */;
/*!40000 ALTER TABLE `rational_administration_drug` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `rectification_measures`
--

DROP TABLE IF EXISTS `rectification_measures`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `rectification_measures` (
  `office_name` varchar(20) NOT NULL,
  `user_time` date NOT NULL,
  `measure` text,
  PRIMARY KEY (`office_name`,`user_time`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `rectification_measures`
--

LOCK TABLES `rectification_measures` WRITE;
/*!40000 ALTER TABLE `rectification_measures` DISABLE KEYS */;
/*!40000 ALTER TABLE `rectification_measures` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `role`
--

DROP TABLE IF EXISTS `role`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `role` (
  `role_id` int NOT NULL,
  `role_name` varchar(255) DEFAULT NULL,
  `role_password` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`role_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `role`
--

LOCK TABLES `role` WRITE;
/*!40000 ALTER TABLE `role` DISABLE KEYS */;
INSERT INTO `role` VALUES (1302310873,'唐静','superadmin');
/*!40000 ALTER TABLE `role` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `shift_handover_system`
--

DROP TABLE IF EXISTS `shift_handover_system`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `shift_handover_system` (
  `office_name` varchar(20) NOT NULL,
  `points_deducted` decimal(10,2) DEFAULT NULL,
  `eyebrow_column` text,
  `shift_content` text,
  `succession_content` text,
  `bedside_handover` text,
  `shift_doctor_sign` text,
  `success_doctor_sign` text,
  `user_time` date NOT NULL,
  PRIMARY KEY (`office_name`,`user_time`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `shift_handover_system`
--

LOCK TABLES `shift_handover_system` WRITE;
/*!40000 ALTER TABLE `shift_handover_system` DISABLE KEYS */;
/*!40000 ALTER TABLE `shift_handover_system` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `single_disease`
--

DROP TABLE IF EXISTS `single_disease`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `single_disease` (
  `office_name` varchar(20) NOT NULL,
  `reporting_rate` decimal(10,4) DEFAULT NULL,
  `user_time` date NOT NULL,
  `points_deducted` decimal(10,2) DEFAULT NULL,
  PRIMARY KEY (`office_name`,`user_time`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `single_disease`
--

LOCK TABLES `single_disease` WRITE;
/*!40000 ALTER TABLE `single_disease` DISABLE KEYS */;
/*!40000 ALTER TABLE `single_disease` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `special_inspection_project`
--

DROP TABLE IF EXISTS `special_inspection_project`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `special_inspection_project` (
  `office_name` varchar(20) NOT NULL,
  `doctor_name` varchar(20) DEFAULT NULL,
  `admission_number` bigint DEFAULT NULL,
  `key_inspections_this_month` text,
  `rectification_status_issues_last_month` text,
  `user_time` date NOT NULL,
  `id` int NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `special_inspection_project`
--

LOCK TABLES `special_inspection_project` WRITE;
/*!40000 ALTER TABLE `special_inspection_project` DISABLE KEYS */;
/*!40000 ALTER TABLE `special_inspection_project` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `timeliness_of_writing`
--

DROP TABLE IF EXISTS `timeliness_of_writing`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `timeliness_of_writing` (
  `admission_number` bigint DEFAULT NULL,
  `office_name` varchar(20) DEFAULT NULL,
  `doctor_name` varchar(20) DEFAULT NULL,
  `project_name` text,
  `qc_result` text,
  `user_time` date DEFAULT NULL,
  `id` int NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `timeliness_of_writing`
--

LOCK TABLES `timeliness_of_writing` WRITE;
/*!40000 ALTER TABLE `timeliness_of_writing` DISABLE KEYS */;
/*!40000 ALTER TABLE `timeliness_of_writing` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `unplanned_reoperation`
--

DROP TABLE IF EXISTS `unplanned_reoperation`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `unplanned_reoperation` (
  `office_name` varchar(20) DEFAULT NULL,
  `admission_number` bigint DEFAULT NULL,
  `patient_name` varchar(20) DEFAULT NULL,
  `admission_time` datetime DEFAULT NULL,
  `gender` enum('男','女') DEFAULT NULL,
  `patient_age` bigint DEFAULT NULL,
  `first_surgery_time` datetime DEFAULT NULL,
  `second_surgery_time` datetime DEFAULT NULL,
  `first_chief_surgeon` text,
  `second_chief_surgeon` text,
  `second_surgeon_reason` text,
  `report_type` enum('未上报','延迟上报','正常上报') DEFAULT NULL,
  `director_rounds` enum('是','否') DEFAULT NULL,
  `discuss` enum('有','无') DEFAULT NULL,
  `user_time` date DEFAULT NULL,
  `points_deducted` decimal(12,2) DEFAULT NULL,
  `id` int NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `unplanned_reoperation`
--

LOCK TABLES `unplanned_reoperation` WRITE;
/*!40000 ALTER TABLE `unplanned_reoperation` DISABLE KEYS */;
/*!40000 ALTER TABLE `unplanned_reoperation` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user` (
  `user_id` int NOT NULL,
  `username` varchar(50) NOT NULL,
  `password` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`user_id`),
  UNIQUE KEY `user_username_uindex` (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (1,'陈玺','159'),(2,'蒋倩','jq3636');
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `vte_prevention_control_indicators`
--

DROP TABLE IF EXISTS `vte_prevention_control_indicators`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `vte_prevention_control_indicators` (
  `office_name` varchar(20) DEFAULT NULL,
  `vte_risk_assessment_rate` decimal(12,4) DEFAULT NULL,
  `vte_bleeding_risk_assessment_rate` decimal(12,4) DEFAULT NULL,
  `vte_prevention_rate` decimal(12,4) DEFAULT NULL,
  `user_time` date DEFAULT NULL,
  `points_deducted` decimal(12,2) DEFAULT NULL,
  `created_at` timestamp NULL DEFAULT NULL,
  `updated_at` timestamp NULL DEFAULT NULL,
  `id` int NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `vte_prevention_control_indicators`
--

LOCK TABLES `vte_prevention_control_indicators` WRITE;
/*!40000 ALTER TABLE `vte_prevention_control_indicators` DISABLE KEYS */;
/*!40000 ALTER TABLE `vte_prevention_control_indicators` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2024-02-13 16:04:57

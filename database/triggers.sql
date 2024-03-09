-- MySQL dump 10.13  Distrib 8.0.34, for Win64 (x86_64)
--
-- Host: localhost    Database: quality_control_login_evaluation
-- ------------------------------------------------------
-- Server version	8.0.34
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
/*!50003 CREATE*/ /*!50017 DEFINER=`root`@`localhost`*/ /*!50003 TRIGGER `update_diameter_calculation` AFTER INSERT ON `clinical_pathway` FOR EACH ROW BEGIN
    -- First, delete old data for the inserted office_name and user_time
    DELETE FROM diameter_calculation WHERE office_name = NEW.office_name AND user_time = NEW.user_time;

    -- Then, insert new calculated data
    INSERT INTO diameter_calculation (office_name, user_time, actual_diameter, completed_cases_num, unentered_diameter, completion_rate, enrollment_rate, entry_rate)
    SELECT 
        cp.office_name,
        cp.user_time,
        SUM(cp.number_of_entrants),
        SUM(cp.num_of_finish),
        SUM(cp.no_enter_num),
        IF(SUM(cp.number_of_entrants) = 0, 0, SUM(cp.num_of_finish)/SUM(cp.number_of_entrants)),
        IF(SUM(cp.number_of_entrants) + SUM(cp.no_enter_num) = 0, 0, SUM(cp.number_of_entrants)/(SUM(cp.number_of_entrants) + SUM(cp.no_enter_num))),
        SUM(cp.number_of_entrants)/dp.month_discharged_patients
    FROM 
        clinical_pathway cp 
    INNER JOIN
        discharged_patients dp ON cp.office_name = dp.office_name AND cp.user_time = dp.user_time
    WHERE 
        cp.office_name = NEW.office_name AND cp.user_time = NEW.user_time
    GROUP BY 
        cp.office_name, cp.user_time;
        
END */;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
/*!50003 CREATE*/ /*!50017 DEFINER=`root`@`localhost`*/ /*!50003 TRIGGER `diameter_points_deducted` BEFORE INSERT ON `diameter_calculation` FOR EACH ROW BEGIN
    SET NEW.points_deducted = 
        (CASE WHEN NEW.enrollment_rate < 0.9 THEN 2 ELSE 0 END) +
        (CASE WHEN NEW.entry_rate < 0.5 THEN 3 ELSE 0 END) +
        (CASE WHEN NEW.completion_rate < 0.7 THEN 2 ELSE 0 END);
END */;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
/*!50003 CREATE*/ /*!50017 DEFINER=`root`@`localhost`*/ /*!50003 TRIGGER `update_report_type_and_points_deducted` BEFORE INSERT ON `extended_hospital_stay_management` FOR EACH ROW BEGIN
   IF NEW.reporting_time IS NULL THEN
      SET NEW.report_type = '未上报';
      SET NEW.points_deducted = 1;
   ELSEIF TIMESTAMPDIFF(HOUR, NEW.reporting_time_node, NEW.reporting_time) >= 48 THEN
      SET NEW.report_type = '延迟上报';
      SET NEW.points_deducted = 0.5;
   ELSE
      SET NEW.report_type = '正常上报';
      SET NEW.points_deducted = 0;
   END IF;

   IF NEW.office_discuss = '否' THEN
      SET NEW.points_deducted = NEW.points_deducted + 1;
   END IF;
   
   IF NEW.director_rounds = '否' THEN
      SET NEW.points_deducted = NEW.points_deducted + 1;
   END IF;
END */;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
/*!50003 CREATE*/ /*!50017 DEFINER=`root`@`localhost`*/ /*!50003 TRIGGER `calculate_total_deduction_points` BEFORE INSERT ON `outpatient_medical_records` FOR EACH ROW BEGIN
  SET NEW.total_deduction_points = COALESCE(NEW.medical_records_score, 0) +
                                   COALESCE(NEW.chief_complaint_without_time_score, 0) +
                                   COALESCE(NEW.replicates_chief_complaint_score, 0) +
                                   COALESCE(NEW.physical_signs_diagnosis_score, 0) +
                                   COALESCE(NEW.no_significant_vital_signs_score, 0) +
                                   COALESCE(NEW.no_physical_signs_score, 0) +
                                   COALESCE(NEW.dispute_score, 0);
END */;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
/*!50003 CREATE*/ /*!50017 DEFINER=`root`@`localhost`*/ /*!50003 TRIGGER `update_points_deducted` BEFORE INSERT ON `single_disease` FOR EACH ROW BEGIN
    IF NEW.reporting_rate < 100 THEN
        SET NEW.points_deducted = 2;
    END IF;
END */;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
/*!50003 CREATE*/ /*!50017 DEFINER=`root`@`localhost`*/ /*!50003 TRIGGER `unplanned_points_deducted` BEFORE INSERT ON `unplanned_reoperation` FOR EACH ROW BEGIN
    DECLARE v_score DECIMAL(4, 2);

    SET v_score = 0;

    IF NEW.report_type = '未上报' THEN
        SET v_score = v_score + 1;
    ELSEIF NEW.report_type = '延迟上报' THEN
        SET v_score = v_score + 0.5;
    END IF;

    IF NEW.director_rounds = '否' THEN
        SET v_score = v_score + 1;
    END IF;

    IF NEW.discuss = '无' THEN
        SET v_score = v_score + 1;
    END IF;

    SET NEW.points_deducted = v_score;
END */;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
/*!50003 CREATE*/ /*!50017 DEFINER=`root`@`localhost`*/ /*!50003 TRIGGER `vte_points_deducted` BEFORE INSERT ON `vte_prevention_control_indicators` FOR EACH ROW BEGIN
    DECLARE v_score INT;

    SET v_score = 0;

    IF NEW.vte_bleeding_risk_assessment_rate < 60 THEN
        SET v_score = v_score + 2;
    END IF;

    IF NEW.vte_prevention_rate < 80 THEN
        SET v_score = v_score + 1;
    END IF;

    SET NEW.points_deducted = v_score;
END */;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2024-02-27 22:44:33

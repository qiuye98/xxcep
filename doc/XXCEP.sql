/*
 Navicat Premium Data Transfer

 Source Server         : MySql-server
 Source Server Type    : MySQL
 Source Server Version : 50724
 Source Host           : localhost:3306
 Source Schema         : xxcep

 Target Server Type    : MySQL
 Target Server Version : 50724
 File Encoding         : 65001

 Date: 26/06/2019 16:08:31
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for anwser_exam_student
-- ----------------------------
DROP TABLE IF EXISTS `anwser_exam_student`;
CREATE TABLE `anwser_exam_student`  (
  `question_id` int(11) NOT NULL,
  `score_exam_student_relation_id` int(11) NOT NULL,
  `anwser_student` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL,
  PRIMARY KEY (`question_id`, `score_exam_student_relation_id`) USING BTREE,
  INDEX `fk_anwser_exam_student_score_exam_student_relation_1`(`score_exam_student_relation_id`) USING BTREE,
  CONSTRAINT `fk_anwser_exam_student_question_1` FOREIGN KEY (`question_id`) REFERENCES `question` (`question_id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `fk_anwser_exam_student_score_exam_student_relation_1` FOREIGN KEY (`score_exam_student_relation_id`) REFERENCES `score_exam_student_relation` (`score_exam_student_relation_id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_bin ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for anwser_homework_student
-- ----------------------------
DROP TABLE IF EXISTS `anwser_homework_student`;
CREATE TABLE `anwser_homework_student`  (
  `question_id` int(11) NOT NULL,
  `score_homework_student_relation_id` int(11) NOT NULL,
  `anwser_student` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL,
  PRIMARY KEY (`question_id`, `score_homework_student_relation_id`) USING BTREE,
  INDEX `fk_anwser_homework_student_score_homework_student_relation_1`(`score_homework_student_relation_id`) USING BTREE,
  CONSTRAINT `fk_anwser_homework_student_anwser_homework_student_1` FOREIGN KEY (`question_id`) REFERENCES `question` (`question_id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `fk_anwser_homework_student_score_homework_student_relation_1` FOREIGN KEY (`score_homework_student_relation_id`) REFERENCES `score_homework_student_relation` (`score_homework_student_relation_id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_bin ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for classical_point
-- ----------------------------
DROP TABLE IF EXISTS `classical_point`;
CREATE TABLE `classical_point`  (
  `classical_point_id` int(11) NOT NULL,
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL,
  `file` longblob NULL,
  PRIMARY KEY (`classical_point_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_bin ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for courseware
-- ----------------------------
DROP TABLE IF EXISTS `courseware`;
CREATE TABLE `courseware`  (
  `course_id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(20) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL,
  `courseware_path` varchar(128) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL,
  PRIMARY KEY (`course_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 10 CHARACTER SET = utf8 COLLATE = utf8_bin ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of courseware
-- ----------------------------
INSERT INTO `courseware` VALUES (1, '杰哥语录.docx', 'savedFile/courseware/杰哥语录.docx');
INSERT INTO `courseware` VALUES (2, '工具安装记录.txt', 'savedFile/courseware/工具安装记录.txt');
INSERT INTO `courseware` VALUES (3, 'test.txt', 'savedFile/courseware/test.txt');

-- ----------------------------
-- Table structure for dialogue
-- ----------------------------
DROP TABLE IF EXISTS `dialogue`;
CREATE TABLE `dialogue`  (
  `dialogue_id` int(11) NOT NULL,
  `start_date` datetime(0) NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP(0),
  PRIMARY KEY (`dialogue_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_bin ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for exam
-- ----------------------------
DROP TABLE IF EXISTS `exam`;
CREATE TABLE `exam`  (
  `exam_id` int(11) NOT NULL,
  `begin_date` datetime(0) NOT NULL ON UPDATE CURRENT_TIMESTAMP(0),
  `end_date` datetime(0) NOT NULL ON UPDATE CURRENT_TIMESTAMP(0),
  `exam_name` varchar(20) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL,
  PRIMARY KEY (`exam_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_bin ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for exam_question_relation
-- ----------------------------
DROP TABLE IF EXISTS `exam_question_relation`;
CREATE TABLE `exam_question_relation`  (
  `exam_id` int(11) NOT NULL,
  `question_id` int(11) NOT NULL,
  PRIMARY KEY (`exam_id`, `question_id`) USING BTREE,
  INDEX `fk_exam_question_relation_question_1`(`question_id`) USING BTREE,
  CONSTRAINT `fk_exam_question_relation_exam_1` FOREIGN KEY (`exam_id`) REFERENCES `exam` (`exam_id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `fk_exam_question_relation_question_1` FOREIGN KEY (`question_id`) REFERENCES `question` (`question_id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_bin ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for homework
-- ----------------------------
DROP TABLE IF EXISTS `homework`;
CREATE TABLE `homework`  (
  `homework_id` int(11) NOT NULL,
  `begin_date` datetime(0) NOT NULL ON UPDATE CURRENT_TIMESTAMP(0),
  `end_date` datetime(0) NOT NULL ON UPDATE CURRENT_TIMESTAMP(0),
  `homeword_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL,
  PRIMARY KEY (`homework_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_bin ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for homework_question_relation
-- ----------------------------
DROP TABLE IF EXISTS `homework_question_relation`;
CREATE TABLE `homework_question_relation`  (
  `homework_id` int(11) NOT NULL,
  `question_id` int(11) NOT NULL,
  PRIMARY KEY (`homework_id`, `question_id`) USING BTREE,
  INDEX `fk_homework_question_relation_question_1`(`question_id`) USING BTREE,
  CONSTRAINT `fk_homework_question_relation_homework_1` FOREIGN KEY (`homework_id`) REFERENCES `homework` (`homework_id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `fk_homework_question_relation_question_1` FOREIGN KEY (`question_id`) REFERENCES `question` (`question_id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_bin ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for message
-- ----------------------------
DROP TABLE IF EXISTS `message`;
CREATE TABLE `message`  (
  `message_id` int(11) NOT NULL,
  `send_date` datetime(0) NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP(0),
  `content` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL,
  `dialogue_id` int(11) NULL DEFAULT NULL,
  PRIMARY KEY (`message_id`) USING BTREE,
  INDEX `fk_message_dialogue_1`(`dialogue_id`) USING BTREE,
  CONSTRAINT `fk_message_dialogue_1` FOREIGN KEY (`dialogue_id`) REFERENCES `dialogue` (`dialogue_id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_bin ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for question
-- ----------------------------
DROP TABLE IF EXISTS `question`;
CREATE TABLE `question`  (
  `question_id` int(11) NOT NULL,
  `anwser_standart` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL,
  `question_describe` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL,
  PRIMARY KEY (`question_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_bin ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for score_exam_student_relation
-- ----------------------------
DROP TABLE IF EXISTS `score_exam_student_relation`;
CREATE TABLE `score_exam_student_relation`  (
  `student_id` int(11) NOT NULL,
  `exam_id` int(11) NOT NULL,
  `score_exam_student_relation_id` int(11) NOT NULL AUTO_INCREMENT,
  `score` int(3) NULL DEFAULT NULL,
  PRIMARY KEY (`student_id`, `exam_id`) USING BTREE,
  UNIQUE INDEX `score_exam_student_relation_id`(`score_exam_student_relation_id`) USING BTREE,
  INDEX `fk_score_exam_student_relation_exam_1`(`exam_id`) USING BTREE,
  CONSTRAINT `fk_score_exam_student_relation_exam_1` FOREIGN KEY (`exam_id`) REFERENCES `exam` (`exam_id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `fk_score_exam_student_relation_student_1` FOREIGN KEY (`student_id`) REFERENCES `student` (`student_id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_bin ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for score_homework_student_relation
-- ----------------------------
DROP TABLE IF EXISTS `score_homework_student_relation`;
CREATE TABLE `score_homework_student_relation`  (
  `student_id` int(11) NOT NULL,
  `homework_id` int(11) NOT NULL,
  `score_homework_student_relation_id` int(11) NOT NULL AUTO_INCREMENT,
  `score` int(3) NULL DEFAULT NULL,
  PRIMARY KEY (`student_id`, `homework_id`) USING BTREE,
  UNIQUE INDEX `score_homework_student_relation_id`(`score_homework_student_relation_id`) USING BTREE,
  INDEX `fk_score_homework_student_relation_homework_1`(`homework_id`) USING BTREE,
  CONSTRAINT `fk_score_homework_student_relation_homework_1` FOREIGN KEY (`homework_id`) REFERENCES `homework` (`homework_id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `fk_score_homework_student_relation_student_1` FOREIGN KEY (`student_id`) REFERENCES `student` (`student_id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_bin ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for student
-- ----------------------------
DROP TABLE IF EXISTS `student`;
CREATE TABLE `student`  (
  `student_id` int(11) NOT NULL,
  `score` int(3) NULL DEFAULT NULL,
  PRIMARY KEY (`student_id`) USING BTREE,
  CONSTRAINT `fk_student_user_1` FOREIGN KEY (`student_id`) REFERENCES `user` (`user_id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_bin ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of student
-- ----------------------------
INSERT INTO `student` VALUES (3, NULL);
INSERT INTO `student` VALUES (4, NULL);
INSERT INTO `student` VALUES (5, NULL);

-- ----------------------------
-- Table structure for teacher
-- ----------------------------
DROP TABLE IF EXISTS `teacher`;
CREATE TABLE `teacher`  (
  `teacher_id` int(11) NOT NULL,
  PRIMARY KEY (`teacher_id`) USING BTREE,
  CONSTRAINT `fk_teacher_user_1` FOREIGN KEY (`teacher_id`) REFERENCES `user` (`user_id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_bin ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of teacher
-- ----------------------------
INSERT INTO `teacher` VALUES (1);
INSERT INTO `teacher` VALUES (2);

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `user_id` int(11) NOT NULL,
  `account` varchar(18) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL,
  `password` varchar(18) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL,
  `name` varchar(24) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL,
  `sex` varchar(4) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL,
  PRIMARY KEY (`user_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_bin ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES (1, 'teacher1', '123', '刘老师', '男');
INSERT INTO `user` VALUES (2, 'teacher2', '123', '华老师', '女');
INSERT INTO `user` VALUES (3, '16203117', '123', '吴佳祥', '男');
INSERT INTO `user` VALUES (4, '16203111', '123', '金根友', '男');
INSERT INTO `user` VALUES (5, '16203130', '123', '谷伟帅', '男');

-- ----------------------------
-- Table structure for user_dialogue_relation
-- ----------------------------
DROP TABLE IF EXISTS `user_dialogue_relation`;
CREATE TABLE `user_dialogue_relation`  (
  `user_id` int(11) NOT NULL,
  `dialogue_id` int(11) NOT NULL,
  PRIMARY KEY (`user_id`, `dialogue_id`) USING BTREE,
  INDEX `fk_user_dialogue_relation_dialogue_1`(`dialogue_id`) USING BTREE,
  CONSTRAINT `fk_user_dialogue_relation_dialogue_1` FOREIGN KEY (`dialogue_id`) REFERENCES `dialogue` (`dialogue_id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `fk_user_dialogue_relation_user_1` FOREIGN KEY (`user_id`) REFERENCES `user` (`user_id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_bin ROW_FORMAT = Dynamic;

SET FOREIGN_KEY_CHECKS = 1;

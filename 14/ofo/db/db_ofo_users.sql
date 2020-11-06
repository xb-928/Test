/*
 Navicat MySQL Data Transfer

 Source Server         : root
 Source Server Type    : MySQL
 Source Server Version : 80021
 Source Host           : localhost:3306
 Source Schema         : db_ofo_users

 Target Server Type    : MySQL
 Target Server Version : 80021
 File Encoding         : 65001

 Date: 22/10/2020 14:30:14
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for ofo_users
-- ----------------------------
DROP TABLE IF EXISTS `ofo_users`;
CREATE TABLE `ofo_users`  (
  `ofo_user_id` int NOT NULL AUTO_INCREMENT,
  `ofo_user_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `ofo_user_balance` float(10, 2) NOT NULL,
  `ofo_user_mileage` float(10, 2) NOT NULL,
  PRIMARY KEY (`ofo_user_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 20 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of ofo_users
-- ----------------------------
INSERT INTO `ofo_users` VALUES (11, '杨过啊', 22.22, 22.33);
INSERT INTO `ofo_users` VALUES (13, '王健林', 1000.10, 222.22);
INSERT INTO `ofo_users` VALUES (17, '杨过', 222.22, 9999.22);
INSERT INTO `ofo_users` VALUES (18, '111', 111.00, 111.00);
INSERT INTO `ofo_users` VALUES (19, '啊啊', 111.00, 111.00);

SET FOREIGN_KEY_CHECKS = 1;

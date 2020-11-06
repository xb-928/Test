/*
Navicat MySQL Data Transfer

Source Server         : xb
Source Server Version : 50530
Source Host           : localhost:3306
Source Database       : db_ofo_users

Target Server Type    : MYSQL
Target Server Version : 50530
File Encoding         : 65001

Date: 2020-10-20 23:11:22
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for ofo_users
-- ----------------------------
DROP TABLE IF EXISTS `ofo_users`;
CREATE TABLE `ofo_users` (
  `ofo_users_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '序号',
  `ofo_users_name` varchar(255) CHARACTER SET utf8 NOT NULL COMMENT '姓名',
  `ofo_users_balance` float(20,2) NOT NULL COMMENT '账户余额（元）',
  `ofo_users_mileage` float(20,2) NOT NULL COMMENT '骑行里程（KM）',
  PRIMARY KEY (`ofo_users_id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of ofo_users
-- ----------------------------
INSERT INTO `ofo_users` VALUES ('1', '丘处机', '120.00', '50.00');
INSERT INTO `ofo_users` VALUES ('2', '范冰冰', '500.50', '10004.00');
INSERT INTO `ofo_users` VALUES ('3', '李冰冰', '300.50', '32.54');
INSERT INTO `ofo_users` VALUES ('4', '周杰伦', '235.50', '12.67');
INSERT INTO `ofo_users` VALUES ('5', '杜小月', '324.50', '67.00');
INSERT INTO `ofo_users` VALUES ('6', '邓紫棋', '129.50', '5.67');
INSERT INTO `ofo_users` VALUES ('7', '李易峰', '345.50', '300.00');
INSERT INTO `ofo_users` VALUES ('8', '刘诗诗', '432.50', '500.87');
INSERT INTO `ofo_users` VALUES ('9', '周星驰', '50.50', '433.32');
INSERT INTO `ofo_users` VALUES ('10', '唐嫣', '987.50', '456.76');

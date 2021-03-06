/*
Navicat MySQL Data Transfer

Source Server         : local
Source Server Version : 50626
Source Host           : localhost:3306
Source Database       : wang

Target Server Type    : MYSQL
Target Server Version : 50626
File Encoding         : 65001

Date: 2015-09-30 23:17:17
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for tb_user
-- ----------------------------
DROP TABLE IF EXISTS `tb_user`;
CREATE TABLE `tb_user` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `login_name` varchar(255) DEFAULT NULL,
  `login_password` varchar(255) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `real_name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_user
-- ----------------------------
INSERT INTO `tb_user` VALUES ('1', 'test', 'wang', 'duanxian04@126.com', 'wxl');
INSERT INTO `tb_user` VALUES ('2', 'wang', 'ddd', 'ddd', 'adkl');
INSERT INTO `tb_user` VALUES ('5', null, null, null, '?');
INSERT INTO `tb_user` VALUES ('6', null, null, null, ' ');
INSERT INTO `tb_user` VALUES ('7', null, null, null, '王旭龙');
INSERT INTO `tb_user` VALUES ('8', null, null, null, '王旭龙');
INSERT INTO `tb_user` VALUES ('9', null, null, null, '王12旭龙');
INSERT INTO `tb_user` VALUES ('10', '发布泪', null, null, 'hibernate');

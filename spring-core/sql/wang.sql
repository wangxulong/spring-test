/*
Navicat MySQL Data Transfer

Source Server         : local
Source Server Version : 50626
Source Host           : localhost:3306
Source Database       : wang

Target Server Type    : MYSQL
Target Server Version : 50626
File Encoding         : 65001

Date: 2015-10-23 18:00:10
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for sys_app
-- ----------------------------
DROP TABLE IF EXISTS `sys_app`;
CREATE TABLE `sys_app` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `app_code` varchar(255) DEFAULT NULL,
  `app_name` varchar(255) DEFAULT NULL,
  `app_desc` varchar(255) DEFAULT NULL,
  `show_in_menu` tinyint(4) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_app
-- ----------------------------

-- ----------------------------
-- Table structure for sys_org
-- ----------------------------
DROP TABLE IF EXISTS `sys_org`;
CREATE TABLE `sys_org` (
  `id` bigint(20) NOT NULL,
  `name` varchar(255) DEFAULT NULL,
  `order_num` int(255) DEFAULT NULL,
  `parent_id` bigint(20) DEFAULT NULL,
  `parent_ids` varchar(255) DEFAULT NULL,
  `available` tinyint(4) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_org
-- ----------------------------

-- ----------------------------
-- Table structure for sys_resource
-- ----------------------------
DROP TABLE IF EXISTS `sys_resource`;
CREATE TABLE `sys_resource` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `type` varchar(255) DEFAULT NULL,
  `order_num` int(11) DEFAULT NULL,
  `parent_id` bigint(20) DEFAULT NULL,
  `parent_ids` varchar(255) DEFAULT NULL,
  `resource_code` varchar(255) DEFAULT NULL,
  `available` tinyint(4) DEFAULT NULL,
  `icon` varchar(255) DEFAULT NULL,
  `url` varchar(255) DEFAULT NULL,
  `script` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_resource
-- ----------------------------
INSERT INTO `sys_resource` VALUES ('1', '系统管理', '0', '1', '0', '0', '', '1', null, null, null);
INSERT INTO `sys_resource` VALUES ('2', '用户管理', '1', '1', '1', '1', '', '1', null, '/sys/user/index', null);
INSERT INTO `sys_resource` VALUES ('3', '角色管理', '1', '2', '1', '1', '', '1', null, '/sys/role/index', null);
INSERT INTO `sys_resource` VALUES ('4', '资源管理', '1', '3', '1', '1', '', '1', null, '/sys/res/index', null);
INSERT INTO `sys_resource` VALUES ('5', '添加系统账号', '2', '1', '2', '1-2', 'sysUser:add', '1', null, null, null);
INSERT INTO `sys_resource` VALUES ('10', '删除用户', '2', null, '2', '1-2', 'sysUser:delete', '1', null, null, null);
INSERT INTO `sys_resource` VALUES ('11', '添加角色', '2', null, '3', '1-3', 'sysRole:add', '1', null, null, null);
INSERT INTO `sys_resource` VALUES ('12', '删除角色', '2', null, '3', '1-3', 'sysRole:delete', '1', null, null, null);
INSERT INTO `sys_resource` VALUES ('13', '测试菜单', '1', null, '1', '0-1', 'test', '1', null, null, null);
INSERT INTO `sys_resource` VALUES ('14', '分配角色', '2', '3', '2', '1-2', 'sysUser:allotRole', '1', null, null, null);
INSERT INTO `sys_resource` VALUES ('15', '修改系统账号', '2', '1', '2', '1-2', 'sysUser:edit', '1', null, null, null);
INSERT INTO `sys_resource` VALUES ('16', '分配资源', '2', '1', '3', '1-3', 'sysRole:allotRes', '1', null, null, null);
INSERT INTO `sys_resource` VALUES ('17', '修改角色', '2', '1', '3', '1-3', 'sysRole:edit', '1', null, null, null);

-- ----------------------------
-- Table structure for sys_role
-- ----------------------------
DROP TABLE IF EXISTS `sys_role`;
CREATE TABLE `sys_role` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `role_name` varchar(255) DEFAULT NULL,
  `role_desc` varchar(255) DEFAULT NULL,
  `role_code` varchar(255) DEFAULT NULL,
  `resource_ids` varchar(255) DEFAULT NULL,
  `available` tinyint(4) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_role
-- ----------------------------
INSERT INTO `sys_role` VALUES ('1', '超级管理员', '不能删除', 'admin', '1,2,5,10,14,15,3,11,12,16,17,4,13', '1');
INSERT INTO `sys_role` VALUES ('2', '普通用户', '就是一般用户角色', 'user', '1,2,5,3,11,9', '1');
INSERT INTO `sys_role` VALUES ('3', '顾客', '有限制的访问', 'customer', null, '1');
INSERT INTO `sys_role` VALUES ('4', 'ddd', 'ddd', 'ddd', '1,3,16', '1');

-- ----------------------------
-- Table structure for sys_user
-- ----------------------------
DROP TABLE IF EXISTS `sys_user`;
CREATE TABLE `sys_user` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `user_name` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `salt` varchar(255) DEFAULT NULL,
  `role_ids` varchar(255) DEFAULT NULL,
  `locked` tinyint(4) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_user
-- ----------------------------
INSERT INTO `sys_user` VALUES ('1', 'admin', 'ee0f01d962a9c7189c727f3a4cecbace', 'aa6cc0cc67e847db28cc173a7a03b977', '1', null);
INSERT INTO `sys_user` VALUES ('2', 'wang', '6937baa8c31c644cc7809ecbd60391c9', '104ea7372d18cd96b72df4cc06870643', '2', null);
INSERT INTO `sys_user` VALUES ('4', '123', '6a4926e272992e6caa8f63d36bf8389e', 'ac5fb3d8734d65169fe189a6515e2d6b', '2', null);
INSERT INTO `sys_user` VALUES ('5', 'ddd', '486ed2e9ca784bee0ef1273c24b8f739', 'ce2018fb46b1673d32899d157e4494f2', '4', null);

-- ----------------------------
-- Table structure for tb_acl
-- ----------------------------
DROP TABLE IF EXISTS `tb_acl`;
CREATE TABLE `tb_acl` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `principal_type` varchar(255) DEFAULT NULL,
  `principal_value` varchar(255) DEFAULT NULL,
  `resource_type` varchar(255) DEFAULT NULL,
  `resource_valaue` varchar(255) DEFAULT NULL,
  `acl_status` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_acl
-- ----------------------------

-- ----------------------------
-- Table structure for tb_button
-- ----------------------------
DROP TABLE IF EXISTS `tb_button`;
CREATE TABLE `tb_button` (
  `id` bigint(20) NOT NULL,
  `btn_name` varchar(255) DEFAULT NULL,
  `btn_icon` varchar(255) DEFAULT NULL,
  `btn_code` varchar(255) DEFAULT NULL,
  `menu_id` bigint(20) DEFAULT NULL,
  `menu_code` varchar(255) DEFAULT NULL,
  `btn_script` varchar(255) DEFAULT NULL,
  `init_status` varchar(255) DEFAULT NULL,
  `seq_no` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_button
-- ----------------------------

-- ----------------------------
-- Table structure for tb_menu
-- ----------------------------
DROP TABLE IF EXISTS `tb_menu`;
CREATE TABLE `tb_menu` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `menu_no` bigint(20) DEFAULT NULL,
  `app_code` varchar(255) DEFAULT NULL,
  `menu_order` int(255) DEFAULT NULL,
  `menu_name` varchar(255) DEFAULT NULL,
  `menu_url` varchar(255) DEFAULT NULL,
  `menu_icon` varchar(255) DEFAULT NULL,
  `visible` varchar(255) DEFAULT NULL,
  `leaf` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_menu
-- ----------------------------

-- ----------------------------
-- Table structure for tb_role
-- ----------------------------
DROP TABLE IF EXISTS `tb_role`;
CREATE TABLE `tb_role` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `role_name` varchar(255) DEFAULT NULL,
  `role_code` varchar(255) DEFAULT NULL,
  `role_desc` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_role
-- ----------------------------
INSERT INTO `tb_role` VALUES ('1', 'admin', 'admin', '超级管理员');
INSERT INTO `tb_role` VALUES ('2', 'user', 'user', '普通用户');
INSERT INTO `tb_role` VALUES ('3', 'anno', 'anno', '匿名用户');

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

-- ----------------------------
-- Table structure for tb_user_role
-- ----------------------------
DROP TABLE IF EXISTS `tb_user_role`;
CREATE TABLE `tb_user_role` (
  `id` bigint(255) NOT NULL AUTO_INCREMENT,
  `role_id` bigint(20) NOT NULL,
  `user_id` bigint(20) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_user_role
-- ----------------------------

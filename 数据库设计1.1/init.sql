/*
Navicat MySQL Data Transfer

Source Server         : xiebiqi
Source Server Version : 50720
Source Host           : localhost:3306
Source Database       : manage

Target Server Type    : MYSQL
Target Server Version : 50720
File Encoding         : 65001

Date: 2018-07-25 23:40:17
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for permission
-- ----------------------------
DROP TABLE IF EXISTS `permission`;
CREATE TABLE `permission` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) DEFAULT NULL COMMENT '权限名称',
  `url` varchar(100) NOT NULL COMMENT '请求路径',
  `permission` varchar(150) NOT NULL COMMENT '角色编码',
  `status` tinyint(1) DEFAULT '1',
  `created` datetime DEFAULT CURRENT_TIMESTAMP,
  `createdby` int(11) DEFAULT NULL,
  `updated` datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `updatedby` int(11) DEFAULT '0',
  `remark` varchar(50) DEFAULT '',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8 COMMENT='权限表';

-- ----------------------------
-- Records of permission
-- ----------------------------
INSERT INTO `permission` VALUES ('1', '查询', '/user/list', 'user:list', '1', '2018-07-25 23:32:50', '1', '2018-07-25 23:36:24', '0', '');
INSERT INTO `permission` VALUES ('2', '修改', '/user/update', 'user:update', '1', '2018-07-25 23:33:26', '1', '2018-07-25 23:36:53', '0', '');
INSERT INTO `permission` VALUES ('3', '保存', '/user/save', 'user:save', '1', '2018-07-25 23:34:59', null, '2018-07-25 23:35:41', '0', '');
INSERT INTO `permission` VALUES ('4', '查询数量', '/user/countUser', 'user:countUser', '1', '2018-07-25 23:37:48', null, '2018-07-25 23:37:48', '0', '');

-- ----------------------------
-- Table structure for role
-- ----------------------------
DROP TABLE IF EXISTS `role`;
CREATE TABLE `role` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `role_name` varchar(100) NOT NULL COMMENT '角色名称',
  `role_code` varchar(150) NOT NULL COMMENT '角色编码',
  `status` tinyint(1) DEFAULT '1',
  `created` datetime DEFAULT CURRENT_TIMESTAMP,
  `createdby` int(11) DEFAULT NULL,
  `updated` datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `updatedby` int(11) DEFAULT NULL,
  `remark` varchar(50) DEFAULT '',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COMMENT='角色表';

-- ----------------------------
-- Records of role
-- ----------------------------
INSERT INTO `role` VALUES ('1', '超级管理员', 'SuperUser', '1', '2018-07-25 23:31:06', '1', '2018-07-25 23:31:06', '1', '');
INSERT INTO `role` VALUES ('2', '用户', 'user', '1', '2018-07-25 23:31:22', '1', '2018-07-25 23:31:22', '1', '');

-- ----------------------------
-- Table structure for role_to_permission
-- ----------------------------
DROP TABLE IF EXISTS `role_to_permission`;
CREATE TABLE `role_to_permission` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `permission_id` varchar(100) NOT NULL COMMENT '权限id',
  `role_id` varchar(150) NOT NULL COMMENT '角色id',
  `status` tinyint(1) DEFAULT '1',
  `created` datetime DEFAULT CURRENT_TIMESTAMP,
  `createdby` int(11) DEFAULT NULL,
  `updated` datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `updatedby` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8 COMMENT='角色与权限表';

-- ----------------------------
-- Records of role_to_permission
-- ----------------------------
INSERT INTO `role_to_permission` VALUES ('1', '1', '1', '1', '2018-07-25 23:38:06', null, '2018-07-25 23:38:06', null);
INSERT INTO `role_to_permission` VALUES ('2', '2', '1', '1', '2018-07-25 23:38:12', null, '2018-07-25 23:38:12', null);
INSERT INTO `role_to_permission` VALUES ('3', '3', '1', '1', '2018-07-25 23:38:23', null, '2018-07-25 23:38:23', null);
INSERT INTO `role_to_permission` VALUES ('4', '4', '1', '1', '2018-07-25 23:38:29', null, '2018-07-25 23:38:29', null);
INSERT INTO `role_to_permission` VALUES ('5', '1', '2', '1', '2018-07-25 23:38:38', null, '2018-07-25 23:38:38', null);

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(100) NOT NULL,
  `password` varchar(150) NOT NULL,
  `phone` varchar(20) DEFAULT NULL,
  `sex` tinyint(1) DEFAULT NULL,
  `created` datetime DEFAULT NULL,
  `createby` int(11) DEFAULT NULL,
  `updated` datetime DEFAULT NULL,
  `updateby` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=29 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('1', 'SuperUser', 'SuperUser', 'SuperUser', '0', '2018-07-25 23:10:59', '0', '2018-07-25 23:11:05', '0');
INSERT INTO `user` VALUES ('2', 'David', '123456', '15959178758', '0', '2018-07-25 23:30:33', '0', null, '0');
INSERT INTO `user` VALUES ('3', 'Harden', '123456', '12312341234', '1', '2018-06-10 18:38:23', '0', '2018-06-10 18:38:26', '0');

-- ----------------------------
-- Table structure for user_to_role
-- ----------------------------
DROP TABLE IF EXISTS `user_to_role`;
CREATE TABLE `user_to_role` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` varchar(100) NOT NULL,
  `role_id` varchar(150) NOT NULL,
  `status` tinyint(1) DEFAULT '1',
  `created` datetime DEFAULT CURRENT_TIMESTAMP,
  `createdby` int(11) DEFAULT NULL,
  `updated` datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `updatedby` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COMMENT='用户角色表';

-- ----------------------------
-- Records of user_to_role
-- ----------------------------
INSERT INTO `user_to_role` VALUES ('1', '1', '1', '1', '2018-07-25 23:31:37', '1', '2018-07-25 23:31:37', '1');
INSERT INTO `user_to_role` VALUES ('2', '2', '2', '1', '2018-07-25 23:31:47', '1', '2018-07-25 23:31:47', '1');
INSERT INTO `user_to_role` VALUES ('3', '3', '2', '1', '2018-07-25 23:31:56', '1', '2018-07-25 23:31:56', '1');

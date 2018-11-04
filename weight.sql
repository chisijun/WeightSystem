/*
Navicat MySQL Data Transfer

Source Server         : local-192.168.1.100
Source Server Version : 50628
Source Host           : 192.168.1.100:3306
Source Database       : weight

Target Server Type    : MYSQL
Target Server Version : 50628
File Encoding         : 65001

Date: 2018-11-04 17:16:29
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for wt_file
-- ----------------------------
DROP TABLE IF EXISTS `wt_file`;
CREATE TABLE `wt_file` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '文件Id',
  `name` varchar(64) DEFAULT NULL COMMENT '文件名称',
  `path` varchar(128) DEFAULT NULL COMMENT '文件路径',
  `desc` varchar(128) DEFAULT NULL COMMENT '文件描述',
  `typeId` int(11) DEFAULT NULL COMMENT '文件类型Id',
  `valid` int(1) DEFAULT '1' COMMENT '该条记录是否有效，默认有效',
  `createTime` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '记录创建的时间',
  `modifyTime` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '默认获取系统当前时间',
  `modifier` bigint(20) DEFAULT '1',
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of wt_file
-- ----------------------------
INSERT INTO `wt_file` VALUES ('1', '20181104144200810.pdf', 'upload/doc/20181104144200810.pdf', '文件描述', '4', '1', '2018-11-04 14:39:43', '2018-11-04 14:39:43', '1');
INSERT INTO `wt_file` VALUES ('2', '20181104165827035.rar', 'upload/doc/20181104165827035.rar', '文件描述', '4', '1', '2018-11-04 16:56:09', '2018-11-04 16:56:09', '1');
INSERT INTO `wt_file` VALUES ('3', '20181104171002949.pdf', 'upload/doc/20181104171002949.pdf', '文件描述', '4', '1', '2018-11-04 17:07:45', '2018-11-04 17:07:45', '1');

-- ----------------------------
-- Table structure for wt_file_type
-- ----------------------------
DROP TABLE IF EXISTS `wt_file_type`;
CREATE TABLE `wt_file_type` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '文件类型Id',
  `name` varchar(32) DEFAULT NULL COMMENT '文件类型名称',
  `path` varchar(32) DEFAULT NULL COMMENT '文件类型前缀路径',
  `valid` int(1) DEFAULT '1' COMMENT '该条记录是否有效，默认有效',
  `createTime` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '记录创建的时间',
  `modifyTime` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '默认获取系统当前时间',
  `modifier` bigint(20) DEFAULT '1',
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of wt_file_type
-- ----------------------------
INSERT INTO `wt_file_type` VALUES ('1', '图片', 'upload/pic', '1', '2018-11-04 10:07:54', '2018-11-04 10:07:54', '1');
INSERT INTO `wt_file_type` VALUES ('2', '音频', 'upload/audio', '1', '2018-11-04 10:07:58', '2018-11-04 10:07:58', '1');
INSERT INTO `wt_file_type` VALUES ('3', '视频', 'upload/video', '1', '2018-11-04 10:08:08', '2018-11-04 10:08:08', '1');
INSERT INTO `wt_file_type` VALUES ('4', '文档', 'upload/doc', '1', '2018-11-04 10:08:14', '2018-11-04 10:08:14', '1');
INSERT INTO `wt_file_type` VALUES ('5', '可执行程序', 'upload/exe', '1', '2018-11-04 10:08:24', '2018-11-04 10:08:24', '1');

-- ----------------------------
-- Table structure for wt_record
-- ----------------------------
DROP TABLE IF EXISTS `wt_record`;
CREATE TABLE `wt_record` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '记录Id',
  `weight` float(5,2) DEFAULT '0.00' COMMENT '体重',
  `bmi` float(5,2) DEFAULT '0.00' COMMENT 'bmi值',
  `time` varchar(22) NOT NULL COMMENT '体重测量时间',
  `valid` int(1) DEFAULT '1' COMMENT '该条记录是否有效，默认有效',
  `createTime` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '心率上传的时间',
  `modifyTime` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '默认获取系统当前时间',
  `modifier` bigint(20) DEFAULT '1',
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of wt_record
-- ----------------------------
INSERT INTO `wt_record` VALUES ('1', '96.47', '0.00', '2018-10-09 22:00:00', '1', '2018-10-12 11:56:49', '2018-10-12 11:56:49', '1');
INSERT INTO `wt_record` VALUES ('2', '96.47', '0.00', '2018-10-09 22:00:00', '1', '2018-10-12 11:58:15', '2018-10-12 11:58:15', '1');
INSERT INTO `wt_record` VALUES ('3', '96.47', '0.00', '2018-10-09 22:00:00', '1', '2018-10-12 13:35:32', '2018-10-12 13:35:32', '1');
INSERT INTO `wt_record` VALUES ('4', '96.47', '0.00', '2018-10-09 22:00:00', '1', '2018-10-12 13:37:31', '2018-10-12 13:37:31', '1');
INSERT INTO `wt_record` VALUES ('5', '96.47', '32.23', '2018-10-09 22:00:00', '1', '2018-10-12 13:46:37', '2018-10-12 13:46:37', '1');
INSERT INTO `wt_record` VALUES ('6', '96.47', '32.23', '2018-10-09 22:00:00', '1', '2018-10-12 13:48:38', '2018-10-12 13:48:38', '1');
INSERT INTO `wt_record` VALUES ('7', '98.00', '32.74', '2018-10-11 10:12:12', '1', '2018-10-12 13:52:05', '2018-10-12 13:52:05', '1');
INSERT INTO `wt_record` VALUES ('8', '96.47', '32.23', '2018-10-09 22:00:00', '1', '2018-10-12 15:00:54', '2018-10-12 15:00:54', '1');

/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50720
Source Host           : localhost:3306
Source Database       : vote

Target Server Type    : MYSQL
Target Server Version : 50720
File Encoding         : 65001

Date: 2018-06-13 17:40:37
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for vote_info
-- ----------------------------
DROP TABLE IF EXISTS `vote_info`;
CREATE TABLE `vote_info` (
  `id` varchar(32) NOT NULL,
  `create_user` varchar(128) DEFAULT NULL,
  `create_time` varchar(16) DEFAULT NULL,
  `vote_type` int(11) DEFAULT NULL,
  `vote_topic` varchar(128) DEFAULT NULL,
  `vote_description` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

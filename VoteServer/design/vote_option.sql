/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50720
Source Host           : localhost:3306
Source Database       : vote

Target Server Type    : MYSQL
Target Server Version : 50720
File Encoding         : 65001

Date: 2018-06-15 16:40:57
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for vote_option
-- ----------------------------
DROP TABLE IF EXISTS `vote_option`;
CREATE TABLE `vote_option` (
  `id` varchar(32) NOT NULL,
  `vote_option` varchar(255) DEFAULT NULL,
  `vote_id` varchar(32) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

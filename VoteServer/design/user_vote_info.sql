/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50720
Source Host           : localhost:3306
Source Database       : vote

Target Server Type    : MYSQL
Target Server Version : 50720
File Encoding         : 65001

Date: 2018-06-19 16:49:15
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for user_vote_info
-- ----------------------------
DROP TABLE IF EXISTS `user_vote_info`;
CREATE TABLE `user_vote_info` (
  `id` varchar(32) NOT NULL,
  `vote_id` varchar(32) DEFAULT NULL,
  `vote_time` varchar(32) DEFAULT NULL,
  `vote_topic` varchar(128) DEFAULT NULL,
  `vote_description` varchar(255) DEFAULT NULL,
  `user_id` varchar(32) DEFAULT NULL,
  `dead_line` varchar(32) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

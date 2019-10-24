create database onlineqa;
user onlineqa;

-- ----------------------------
-- Table structure for `answers`
-- ----------------------------
DROP TABLE IF EXISTS `answers`;
CREATE TABLE `answers` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `ansContent` varchar(255) NOT NULL,
  `ansDate` datetime NOT NULL,
  `qid` bigint(20) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `qa` (`qid`),
  CONSTRAINT `qa` FOREIGN KEY (`qid`) REFERENCES `questions` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of answers
-- ----------------------------
INSERT INTO `answers` VALUES ('1', '我也不知道为什么', '2019-10-17 20:33:23', '1');
INSERT INTO `answers` VALUES ('2', '啥子为什么，谁知道是什么鬼玩意', '2019-10-15 20:33:52', '2');
INSERT INTO `answers` VALUES ('3', '那你这样很欠扁知道不', '2019-10-30 20:34:16', '3');
INSERT INTO `answers` VALUES ('4', '1111', '2019-10-20 20:35:00', '1');
INSERT INTO `answers` VALUES ('5', '2222', '2019-10-14 20:35:09', '1');
INSERT INTO `answers` VALUES ('6', '3333', '2019-10-11 20:35:18', '1');
INSERT INTO `answers` VALUES ('10', '高峰', '2019-10-24 09:58:32', '4');
INSERT INTO `answers` VALUES ('11', '高峰', '2019-10-24 10:04:09', '4');

-- ----------------------------
-- Table structure for `questions`
-- ----------------------------
DROP TABLE IF EXISTS `questions`;
CREATE TABLE `questions` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `title` varchar(255) NOT NULL,
  `detailDesc` varchar(255) DEFAULT NULL,
  `answerCount` int(11) NOT NULL,
  `lastModified` datetime NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of questions
-- ----------------------------
INSERT INTO `questions` VALUES ('1', '为什么打打电脑', '今天我打火机发', '0', '2019-10-09 20:32:02');
INSERT INTO `questions` VALUES ('2', '为什么我这么帅', '我一直发现自己', '2', '2019-10-08 20:32:09');
INSERT INTO `questions` VALUES ('3', '谁知道这是怎么回事', '一直困扰我的问题', '5', '2019-10-19 20:33:04');
INSERT INTO `questions` VALUES ('4', 'tell me why', 'why why 为什么呢', '2', '2019-10-23 21:57:06');

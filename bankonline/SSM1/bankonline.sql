create database bankonline;
user bankonline;

-- ----------------------------
-- Table structure for `account`
-- ----------------------------
DROP TABLE IF EXISTS `account`;
CREATE TABLE `account` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `cardNo` varchar(16) NOT NULL,
  `password` varchar(6) NOT NULL,
  `balance` decimal(11,2) NOT NULL,
  `status` int(1) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `cardNo` (`cardNo`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of account
-- ----------------------------
INSERT INTO `account` VALUES ('1', '1234567891234567', '123123', '98.25', '1');
INSERT INTO `account` VALUES ('2', '1234567897654321', '123123', '904.25', '1');
INSERT INTO `account` VALUES ('3', '1234567891231234', '123123', '22.25', '0');

-- ----------------------------
-- Table structure for `transactionrecord`
-- ----------------------------
DROP TABLE IF EXISTS `transactionrecord`;
CREATE TABLE `transactionrecord` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `cardNo` varchar(16) NOT NULL,
  `transactionDate` datetime NOT NULL,
  `transactionAmount` decimal(11,2) NOT NULL,
  `balance` decimal(11,2) NOT NULL,
  `transactionType` varchar(255) NOT NULL,
  `remark` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `cardandtran` (`cardNo`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of transactionrecord
-- ----------------------------
INSERT INTO `transactionrecord` VALUES ('1', '1234567891234567', '2019-10-10 20:30:07', '10.00', '90.25', '存款', '又存了一笔钱');
INSERT INTO `transactionrecord` VALUES ('2', '1234567897654321', '2019-10-01 20:31:54', '120.35', '880.25', '取款', '又花钱了');
INSERT INTO `transactionrecord` VALUES ('3', '1234567891234567', '2019-10-22 20:34:26', '20.00', '110.25', '存款', '又又又存钱了');
INSERT INTO `transactionrecord` VALUES ('4', '1234567891231234', '2019-10-04 20:35:37', '1000.00', '22.25', '取款', '消费大款');
INSERT INTO `transactionrecord` VALUES ('5', '1234567897654321', '2019-10-23 14:13:12', '12.00', '98.25', '转账', '我想谁转账');

create database edocmanagement;
user edocmanagement;

-- ----------------------------
-- Table structure for `edoc_category`
-- ----------------------------
DROP TABLE IF EXISTS `edoc_category`;
CREATE TABLE `edoc_category` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of edoc_category
-- ----------------------------
INSERT INTO `edoc_category` VALUES ('1', '教学');
INSERT INTO `edoc_category` VALUES ('2', 'Java');
INSERT INTO `edoc_category` VALUES ('3', 'SSM');

-- ----------------------------
-- Table structure for `edoc_entry`
-- ----------------------------
DROP TABLE IF EXISTS `edoc_entry`;
CREATE TABLE `edoc_entry` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `category_id` int(11) NOT NULL,
  `title` varchar(255) NOT NULL,
  `summary` varchar(255) DEFAULT NULL,
  `upload_user` varchar(255) DEFAULT NULL,
  `createdate` datetime NOT NULL,
  PRIMARY KEY (`id`),
  KEY `cate` (`category_id`),
  CONSTRAINT `cate` FOREIGN KEY (`category_id`) REFERENCES `edoc_category` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of edoc_entry
-- ----------------------------
INSERT INTO `edoc_entry` VALUES ('2', '2', 'java', '发生大科技看看', '但是', '2019-10-11 00:00:00');
INSERT INTO `edoc_entry` VALUES ('3', '3', 'SSM框架', '付哈剪短发接口和法鸡', '废单', '2019-09-03 16:13:00');
INSERT INTO `edoc_entry` VALUES ('4', '1', '教学', '的法律发病数法神发生是 ', '集合', '2019-10-17 00:00:00');

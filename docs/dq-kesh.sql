/*
Navicat MySQL Data Transfer

Source Server         : tqy
Source Server Version : 50716
Source Host           : localhost:3306
Source Database       : dq-kesh

Target Server Type    : MYSQL
Target Server Version : 50716
File Encoding         : 65001

Date: 2017-12-19 18:02:01
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for sys_admin
-- ----------------------------
DROP TABLE IF EXISTS `sys_admin`;
CREATE TABLE `sys_admin` (
  `adminId` int(11) NOT NULL AUTO_INCREMENT,
  `adminAccount` varchar(20) NOT NULL,
  `adminPwd` varchar(255) NOT NULL,
  `adminName` varchar(255) NOT NULL,
  `adminLastLoginTime` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`adminId`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_admin
-- ----------------------------
INSERT INTO `sys_admin` VALUES ('1', 'admin', '123456', '汤启友', '2017-12-05 13:58:14');

-- ----------------------------
-- Table structure for sys_announcement
-- ----------------------------
DROP TABLE IF EXISTS `sys_announcement`;
CREATE TABLE `sys_announcement` (
  `annId` int(11) NOT NULL AUTO_INCREMENT,
  `annTitle` varchar(50) NOT NULL,
  `annContent` text NOT NULL,
  `annTime` datetime NOT NULL ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`annId`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_announcement
-- ----------------------------
INSERT INTO `sys_announcement` VALUES ('1', '十九大召开准备召开', '10月18日，党的十九大将在北京举行。', '2017-10-16 21:45:13');
INSERT INTO `sys_announcement` VALUES ('2', '十八届三中全会成功召开', '10月13日，党的十八届三中全会顺利召开，此次会议确定的十九大召开时间以及公开处理了以XXX为首的严肃违反党章的省部级人员。', '2017-10-16 21:47:13');
INSERT INTO `sys_announcement` VALUES ('3', '北京首条中低速磁悬浮列车今年底开通试运营', '具有中国自主知识产权，北京首条中低速磁浮交通线路S1线正在进行三个月的试运行，将于今年年底开通试运营，预计全年客运量达5685万人次。', '2017-10-16 21:50:04');
INSERT INTO `sys_announcement` VALUES ('4', '全国玉米高产记录再刷新', '据中国农业科学院16日消息，日前农业部玉米专家指导组、全国玉米栽培学组专家对中国农科院作物科学研究所在新疆的玉米密植高产全程机械化示范田进行实测验收。结果显示，示范田玉米最高亩产达到1517.11公斤，刷新了全国玉米高产纪录。', '2017-10-16 21:50:42');
INSERT INTO `sys_announcement` VALUES ('5', '台风“卡努”影响减弱，琼州海峡复航', '16日凌晨3时25分，今年第20号台风“卡努”在广东湛江徐闻县新寮镇登陆，登陆时中心附近最大风力10级。当天上午6时前后，台风“卡努”经琼州海峡进入北部湾海面。', '2017-10-16 21:51:24');
INSERT INTO `sys_announcement` VALUES ('6', '中国数字经济诸多核心技术已达国际先进水平', '\"2017年度（第七届）中国管理·全球论坛暨金蝶用户大会”15日至16日在上海举行，中国工信部信息化和软件服务业司司长谢少锋在论坛上表示，在国家政策的引导和支持下，中国数字经济发展迅猛，已取得显著成效。', '2017-10-16 21:52:43');

-- ----------------------------
-- Table structure for sys_code
-- ----------------------------
DROP TABLE IF EXISTS `sys_code`;
CREATE TABLE `sys_code` (
  `codeId` int(11) NOT NULL,
  `codeType` varchar(30) DEFAULT NULL,
  `codeValue` int(11) DEFAULT NULL,
  `codeName` varchar(30) DEFAULT NULL,
  `codeDesc` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`codeId`),
  KEY `code_value` (`codeValue`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_code
-- ----------------------------
INSERT INTO `sys_code` VALUES ('1', 'pic_type', '101', '日平均最高气温', '日平均最高气温');
INSERT INTO `sys_code` VALUES ('2', 'pic_type', '102', '24小时降水(20-20时)', '24小时降水(20-20时)');
INSERT INTO `sys_code` VALUES ('3', 'pic_type', '103', '相对湿度', '相对湿度');
INSERT INTO `sys_code` VALUES ('4', 'pic_type', '104', '风云二号气象卫星云图', '风云二号气象卫星云图');
INSERT INTO `sys_code` VALUES ('5', 'pic_type', '105', '雷达拼图', '雷达拼图');
INSERT INTO `sys_code` VALUES ('6', 'pic_type', '106', '地面气压', '地面气压');
INSERT INTO `sys_code` VALUES ('7', 'college_type', '10', '校外人员', '<result column=\"qq\" jdbcType=\"VARCHAR\" property=\"qq\"/>');
INSERT INTO `sys_code` VALUES ('8', 'college_type', '11', '大气科学学学院', '大气科学学学院');
INSERT INTO `sys_code` VALUES ('9', 'college_type', '12', '电子工程学院', '电子工程学院');
INSERT INTO `sys_code` VALUES ('10', 'college_type', '13', '网路空间安全学院', '网路空间安全学院');
INSERT INTO `sys_code` VALUES ('11', 'college_type', '14', '资源环境学院', '资源环境学院');
INSERT INTO `sys_code` VALUES ('12', 'college_type', '15', '控制工程学院', '控制工程学院');
INSERT INTO `sys_code` VALUES ('13', 'college_type', '16', '应用数学学院', '应用数学学院');
INSERT INTO `sys_code` VALUES ('14', 'college_type', '17', '通信工程学院', '通信工程学院');
INSERT INTO `sys_code` VALUES ('15', 'college_type', '18', '软件工程学院', '软件工程学院');
INSERT INTO `sys_code` VALUES ('16', 'college_type', '19', '计算机学院', '计算机学院');
INSERT INTO `sys_code` VALUES ('17', 'college_type', '20', '光电技术学院', '光电技术学院');
INSERT INTO `sys_code` VALUES ('19', 'college_type', '21', '管理学院', '管理学院');
INSERT INTO `sys_code` VALUES ('20', 'college_type', '22', '物流学院', '物流学院');
INSERT INTO `sys_code` VALUES ('21', 'college_type', '23', '商学院', '商学院');
INSERT INTO `sys_code` VALUES ('22', 'college_type', '24', '统计学院', '统计学院');
INSERT INTO `sys_code` VALUES ('23', 'college_type', '25', '文化艺术学院', '文化艺术学院');
INSERT INTO `sys_code` VALUES ('24', 'college_type', '26', '外国语学院', '外国语学院');
INSERT INTO `sys_code` VALUES ('25', 'college_type', '27', '马克思主义学院', '马克思主义学院');
INSERT INTO `sys_code` VALUES ('26', 'college_type', '28', '电子实验中心', '电子实验中心');
INSERT INTO `sys_code` VALUES ('27', 'college_type', '29', '计算中心', '计算中心');
INSERT INTO `sys_code` VALUES ('28', 'college_type', '30', '体育部', '体育部');
INSERT INTO `sys_code` VALUES ('30', 'status_type', '3', '老师', '老师');
INSERT INTO `sys_code` VALUES ('31', 'status_type', '4', '学生', '学生');
INSERT INTO `sys_code` VALUES ('32', 'status_type', '5', '其他', '其他');
INSERT INTO `sys_code` VALUES ('33', 'gender', '1', '男', '男');
INSERT INTO `sys_code` VALUES ('34', 'gender', '2', '女', '女');
INSERT INTO `sys_code` VALUES ('35', 'isResponsed', '50', '已回复', '已回复');
INSERT INTO `sys_code` VALUES ('36', 'isResponsed', '51', '未回复', '未回复');

-- ----------------------------
-- Table structure for sys_leaveword
-- ----------------------------
DROP TABLE IF EXISTS `sys_leaveword`;
CREATE TABLE `sys_leaveword` (
  `leaveId` int(11) NOT NULL AUTO_INCREMENT,
  `leaveTitle` varchar(255) DEFAULT NULL,
  `leaveContent` text,
  `leaveTime` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  `leaveUserId` int(11) DEFAULT NULL,
  `isResponsed` int(11) DEFAULT NULL,
  PRIMARY KEY (`leaveId`),
  KEY `fk_leaveUser_userId` (`leaveUserId`),
  CONSTRAINT `fk_leaveUser_userId` FOREIGN KEY (`leaveUserId`) REFERENCES `sys_user` (`userId`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=81 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_leaveword
-- ----------------------------
INSERT INTO `sys_leaveword` VALUES ('3', 'update', 'update', '2017-11-14 02:56:26', '2', '51');
INSERT INTO `sys_leaveword` VALUES ('4', 'hghh', 'hgf', '2017-10-31 23:51:55', '3', '51');
INSERT INTO `sys_leaveword` VALUES ('6', 'aaa', 'bbb', '2017-10-31 23:51:57', '2', '50');
INSERT INTO `sys_leaveword` VALUES ('57', 'update2', 'update2', '2017-11-13 00:53:00', '3', '51');
INSERT INTO `sys_leaveword` VALUES ('58', 'update2', 'update2', '2017-11-01 13:00:09', '3', '50');
INSERT INTO `sys_leaveword` VALUES ('62', 'bbb', 'xxx', '2017-11-14 18:15:36', '1', '51');
INSERT INTO `sys_leaveword` VALUES ('63', 'ccc', 'xxx', '2017-11-14 18:15:37', '1', '50');
INSERT INTO `sys_leaveword` VALUES ('64', 'ddd', 'xxx', '2017-11-14 18:15:39', '1', '50');
INSERT INTO `sys_leaveword` VALUES ('65', 'eee', 'xxx', '2017-11-14 18:15:43', '1', '51');
INSERT INTO `sys_leaveword` VALUES ('67', 'aaa', 'fff', '2017-11-14 18:38:22', '2', '50');
INSERT INTO `sys_leaveword` VALUES ('68', 'DAD', 'SADSADX', '2017-11-27 23:30:14', '1', '51');
INSERT INTO `sys_leaveword` VALUES ('70', 'dsad', 'fdsfhm', '2017-11-28 00:33:06', '1', '51');
INSERT INTO `sys_leaveword` VALUES ('71', 'ff', 'dad', '2017-11-27 23:37:54', '1', '51');
INSERT INTO `sys_leaveword` VALUES ('72', 'ddda', 'dads', '2017-12-05 01:56:41', '1', '50');
INSERT INTO `sys_leaveword` VALUES ('77', 'aa', 'a', '2017-11-28 01:15:37', '1', '51');
INSERT INTO `sys_leaveword` VALUES ('78', 'aa', 'xx', '2017-11-28 01:16:00', '1', '51');
INSERT INTO `sys_leaveword` VALUES ('79', '132', 'xxx', '2017-11-28 01:16:26', '1', '51');
INSERT INTO `sys_leaveword` VALUES ('80', 'a1', 'dsad', '2017-12-05 01:12:23', '1', '51');

-- ----------------------------
-- Table structure for sys_picture
-- ----------------------------
DROP TABLE IF EXISTS `sys_picture`;
CREATE TABLE `sys_picture` (
  `picId` int(11) NOT NULL AUTO_INCREMENT,
  `picName` varchar(100) DEFAULT NULL,
  `picType` int(11) DEFAULT NULL,
  `year` int(4) DEFAULT NULL,
  `month` int(2) DEFAULT NULL,
  `day` int(2) DEFAULT NULL,
  `creatTime` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  `url` varchar(255) DEFAULT NULL,
  `des` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`picId`),
  KEY `fk_picType_codeValue` (`picType`),
  CONSTRAINT `fk_picType_codeValue` FOREIGN KEY (`picType`) REFERENCES `sys_code` (`codeValue`) ON DELETE SET NULL ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=340 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_picture
-- ----------------------------
INSERT INTO `sys_picture` VALUES ('1', '20171001101.png', '101', '2017', '10', '1', '2017-10-23 13:20:35', '../img/101/20171001101.png', '暂无');
INSERT INTO `sys_picture` VALUES ('2', '20171002101.png', '101', '2017', '10', '2', '2017-10-23 13:20:38', '../img/101/20171002101.png', '暂无');
INSERT INTO `sys_picture` VALUES ('3', '20171003101.png', '101', '2017', '10', '3', '2017-10-23 13:20:41', '../img/101/20171003101.png', '暂无');
INSERT INTO `sys_picture` VALUES ('4', '20171004101.png', '101', '2017', '10', '4', '2017-10-23 13:20:44', '../img/101/20171004101.png', '暂无');
INSERT INTO `sys_picture` VALUES ('5', '20171005101.png', '101', '2017', '10', '5', '2017-10-23 13:20:46', '../img/101/20171005101.png', '暂无');
INSERT INTO `sys_picture` VALUES ('6', '20171006101.png', '101', '2017', '10', '6', '2017-10-16 23:10:26', '../img/101/20171006101.png', '暂无');
INSERT INTO `sys_picture` VALUES ('7', '20171007101.png', '101', '2017', '10', '7', '2017-10-23 13:20:48', '../img/101/20171007101.png', '暂无');
INSERT INTO `sys_picture` VALUES ('8', '20171008101.png', '101', '2017', '10', '8', '2017-10-23 13:20:49', '../img/101/20171008101.png', '暂无');
INSERT INTO `sys_picture` VALUES ('9', '20171009101.png', '101', '2017', '10', '9', '2017-10-23 13:20:50', '../img/101/20171009101.png', '暂无');
INSERT INTO `sys_picture` VALUES ('10', '20171010101.png', '101', '2017', '10', '10', '2017-10-23 13:20:51', '../img/101/20171010101.png', '暂无');
INSERT INTO `sys_picture` VALUES ('11', '20171011101.png', '101', '2017', '10', '11', '2017-10-23 13:20:53', '../img/101/20171011101.png', '暂无');
INSERT INTO `sys_picture` VALUES ('12', '20171012101.png', '101', '2017', '10', '12', '2017-10-23 13:20:54', '../img/101/20171012101.png', '暂无');
INSERT INTO `sys_picture` VALUES ('13', '20171013101.png', '101', '2017', '10', '13', '2017-10-16 23:10:26', '../img/101/20171013101.png', '暂无');
INSERT INTO `sys_picture` VALUES ('14', '20171014101.png', '101', '2017', '10', '14', '2017-10-23 13:20:56', '../img/101/20171014101.png', '暂无');
INSERT INTO `sys_picture` VALUES ('15', '20171015101.png', '101', '2017', '10', '15', '2017-10-23 13:20:57', '../img/101/20171015101.png', '暂无');
INSERT INTO `sys_picture` VALUES ('16', '20171016101.png', '101', '2017', '10', '16', '2017-10-23 13:20:58', '../img/101/20171016101.png', '暂无');
INSERT INTO `sys_picture` VALUES ('17', '20171017101.png', '101', '2017', '10', '17', '2017-10-23 13:20:59', '../img/101/20171017101.png', '暂无');
INSERT INTO `sys_picture` VALUES ('18', '20171018101.png', '101', '2017', '10', '18', '2017-10-23 13:21:01', '../img/101/20171018101.png', '暂无');
INSERT INTO `sys_picture` VALUES ('19', '20171019101.png', '101', '2017', '10', '19', '2017-10-23 13:21:02', '../img/101/20171019101.png', '暂无');
INSERT INTO `sys_picture` VALUES ('20', '20171020101.png', '101', '2017', '10', '20', '2017-10-23 13:21:04', '../img/101/20171020101.png', '暂无');
INSERT INTO `sys_picture` VALUES ('21', '20171021101.png', '101', '2017', '10', '21', '2017-10-16 23:10:26', '../img/101/20171021101.png', '暂无');
INSERT INTO `sys_picture` VALUES ('22', '20171022101.png', '101', '2017', '10', '22', '2017-10-23 13:21:07', '../img/101/20171022101.png', '暂无');
INSERT INTO `sys_picture` VALUES ('24', '20171001102.png', '102', '2017', '10', '1', '2017-10-16 23:05:19', '../img/102/20171001102.png', '暂无');
INSERT INTO `sys_picture` VALUES ('25', '20171002102.png', '102', '2017', '10', '2', '2017-10-16 23:05:23', '../img/102/20171002102.png', '暂无');
INSERT INTO `sys_picture` VALUES ('26', '20171003102.png', '102', '2017', '10', '3', '2017-10-16 23:05:28', '../img/102/20171003102.png', '暂无');
INSERT INTO `sys_picture` VALUES ('27', '20171004102.png', '102', '2017', '10', '4', '2017-10-16 23:05:31', '../img/102/20171004102.png', '暂无');
INSERT INTO `sys_picture` VALUES ('28', '20171005102.png', '102', '2017', '10', '5', '2017-10-16 23:05:35', '../img/102/20171005102.png', '暂无');
INSERT INTO `sys_picture` VALUES ('29', '20171006102.png', '102', '2017', '10', '6', '2017-10-16 23:10:26', '../img/102/20171006102.png', '暂无');
INSERT INTO `sys_picture` VALUES ('30', '20171007102.png', '102', '2017', '10', '7', '2017-10-16 23:10:30', '../img/102/20171007102.png', '暂无');
INSERT INTO `sys_picture` VALUES ('31', '20171008102.png', '102', '2017', '10', '8', '2017-10-16 23:05:19', '../img/102/20171008102.png', '暂无');
INSERT INTO `sys_picture` VALUES ('32', '20171009102.png', '102', '2017', '10', '9', '2017-10-16 23:05:23', '../img/102/20171009102.png', '暂无');
INSERT INTO `sys_picture` VALUES ('33', '20171010102.png', '102', '2017', '10', '10', '2017-10-16 23:05:28', '../img/102/20171010102.png', '暂无');
INSERT INTO `sys_picture` VALUES ('34', '20171011102.png', '102', '2017', '10', '11', '2017-10-16 23:05:31', '../img/102/20171011102.png', '暂无');
INSERT INTO `sys_picture` VALUES ('35', '20171012102.png', '102', '2017', '10', '12', '2017-10-16 23:05:35', '../img/102/20171012102.png', '暂无');
INSERT INTO `sys_picture` VALUES ('36', '20171013102.png', '102', '2017', '10', '13', '2017-10-16 23:10:26', '../img/102/20171013102.png', '暂无');
INSERT INTO `sys_picture` VALUES ('37', '20171014102.png', '102', '2017', '10', '14', '2017-10-16 23:10:30', '../img/102/20171014102.png', '暂无');
INSERT INTO `sys_picture` VALUES ('38', '20171015102.png', '102', '2017', '10', '15', '2017-10-16 23:10:30', '../img/102/20171015102.png', '暂无');
INSERT INTO `sys_picture` VALUES ('39', '20171016102.png', '102', '2017', '10', '16', '2017-10-16 23:05:19', '../img/102/20171016102.png', '暂无');
INSERT INTO `sys_picture` VALUES ('40', '20171017102.png', '102', '2017', '10', '17', '2017-10-16 23:05:23', '../img/102/20171017102.png', '暂无');
INSERT INTO `sys_picture` VALUES ('41', '20171018102.png', '102', '2017', '10', '18', '2017-10-16 23:05:28', '../img/102/20171018102.png', '暂无');
INSERT INTO `sys_picture` VALUES ('42', '20171019102.png', '102', '2017', '10', '19', '2017-10-16 23:05:31', '../img/102/20171019102.png', '暂无');
INSERT INTO `sys_picture` VALUES ('43', '20171020102.png', '102', '2017', '10', '20', '2017-10-16 23:05:35', '../img/102/20171020102.png', '暂无');
INSERT INTO `sys_picture` VALUES ('44', '20171021102.png', '102', '2017', '10', '21', '2017-10-16 23:10:26', '../img/102/20171021102.png', '暂无');
INSERT INTO `sys_picture` VALUES ('45', '20171022102.png', '102', '2017', '10', '22', '2017-10-16 23:10:30', '../img/102/20171022102.png', '暂无');
INSERT INTO `sys_picture` VALUES ('47', '20171001103.png', '103', '2017', '10', '1', '2017-10-16 23:05:19', '../img/103/20171001103.png', '暂无');
INSERT INTO `sys_picture` VALUES ('48', '20171002103.png', '103', '2017', '10', '2', '2017-10-16 23:05:23', '../img/103/20171002103.png', '暂无');
INSERT INTO `sys_picture` VALUES ('49', '20171003103.png', '103', '2017', '10', '3', '2017-10-16 23:05:28', '../img/103/20171003103.png', '暂无');
INSERT INTO `sys_picture` VALUES ('50', '20171004103.png', '103', '2017', '10', '4', '2017-10-16 23:05:31', '../img/103/20171004103.png', '暂无');
INSERT INTO `sys_picture` VALUES ('51', '20171005103.png', '103', '2017', '10', '5', '2017-10-16 23:05:35', '../img/103/20171005103.png', '暂无');
INSERT INTO `sys_picture` VALUES ('52', '20171006103.png', '103', '2017', '10', '6', '2017-10-16 23:10:26', '../img/103/20171006103.png', '暂无');
INSERT INTO `sys_picture` VALUES ('53', '20171007103.png', '103', '2017', '10', '7', '2017-10-16 23:10:30', '../img/103/20171007103.png', '暂无');
INSERT INTO `sys_picture` VALUES ('54', '20171008103.png', '103', '2017', '10', '8', '2017-10-16 23:05:19', '../img/103/20171008103.png', '暂无');
INSERT INTO `sys_picture` VALUES ('55', '20171009103.png', '103', '2017', '10', '9', '2017-10-16 23:05:23', '../img/103/20171009103.png', '暂无');
INSERT INTO `sys_picture` VALUES ('56', '20171010103.png', '103', '2017', '10', '10', '2017-10-16 23:05:28', '../img/103/20171010103.png', '暂无');
INSERT INTO `sys_picture` VALUES ('57', '20171011103.png', '103', '2017', '10', '11', '2017-10-16 23:05:31', '../img/103/20171011103.png', '暂无');
INSERT INTO `sys_picture` VALUES ('58', '20171012103.png', '103', '2017', '10', '12', '2017-10-16 23:05:35', '../img/103/20171012103.png', '暂无');
INSERT INTO `sys_picture` VALUES ('59', '20171013103.png', '103', '2017', '10', '13', '2017-10-16 23:10:26', '../img/103/20171013103.png', '暂无');
INSERT INTO `sys_picture` VALUES ('60', '20171014103.png', '103', '2017', '10', '14', '2017-10-16 23:10:30', '../img/103/20171014103.png', '暂无');
INSERT INTO `sys_picture` VALUES ('61', '20171015103.png', '103', '2017', '10', '15', '2017-10-16 23:10:30', '../img/103/20171015103.png', '暂无');
INSERT INTO `sys_picture` VALUES ('62', '20171016103.png', '103', '2017', '10', '16', '2017-10-16 23:05:19', '../img/103/20171016103.png', '暂无');
INSERT INTO `sys_picture` VALUES ('63', '20171017103.png', '103', '2017', '10', '17', '2017-10-16 23:05:23', '../img/103/20171017103.png', '暂无');
INSERT INTO `sys_picture` VALUES ('64', '20171018103.png', '103', '2017', '10', '18', '2017-10-16 23:05:28', '../img/103/20171018103.png', '暂无');
INSERT INTO `sys_picture` VALUES ('65', '20171019103.png', '103', '2017', '10', '19', '2017-10-16 23:05:31', '../img/103/20171019103.png', '暂无');
INSERT INTO `sys_picture` VALUES ('66', '20171020103.png', '103', '2017', '10', '20', '2017-10-16 23:05:35', '../img/103/20171020103.png', '暂无');
INSERT INTO `sys_picture` VALUES ('67', '20171021103.png', '103', '2017', '10', '21', '2017-10-16 23:10:26', '../img/103/20171021103.png', '暂无');
INSERT INTO `sys_picture` VALUES ('68', '20171022103.png', '103', '2017', '10', '22', '2017-10-16 23:10:30', '../img/103/20171022103.png', '暂无');
INSERT INTO `sys_picture` VALUES ('69', '20171023103.png', '103', '2017', '10', '23', '2017-10-16 23:10:30', '../img/103/20171023103.png', '暂无');
INSERT INTO `sys_picture` VALUES ('70', '20171001104.jpg', '104', '2017', '10', '1', '2017-10-23 13:37:56', '../img/104/20171001104.jpg', '暂无');
INSERT INTO `sys_picture` VALUES ('71', '20171002104.jpg', '104', '2017', '10', '2', '2017-10-16 23:05:23', '../img/104/20171002104.jpg', '暂无');
INSERT INTO `sys_picture` VALUES ('72', '20171003104.jpg', '104', '2017', '10', '3', '2017-10-16 23:05:28', '../img/104/20171003104.jpg', '暂无');
INSERT INTO `sys_picture` VALUES ('73', '20171004104.jpg', '104', '2017', '10', '4', '2017-10-16 23:05:31', '../img/104/20171004104.jpg', '暂无');
INSERT INTO `sys_picture` VALUES ('74', '20171005104.jpg', '104', '2017', '10', '5', '2017-10-16 23:05:35', '../img/104/20171005104.jpg', '暂无');
INSERT INTO `sys_picture` VALUES ('75', '20171006104.jpg', '104', '2017', '10', '6', '2017-10-16 23:10:26', '../img/104/20171006104.jpg', '暂无');
INSERT INTO `sys_picture` VALUES ('76', '20171007104.jpg', '104', '2017', '10', '7', '2017-10-16 23:10:30', '../img/104/20171007104.jpg', '暂无');
INSERT INTO `sys_picture` VALUES ('77', '20171008104.jpg', '104', '2017', '10', '8', '2017-10-16 23:05:19', '../img/104/20171008104.jpg', '暂无');
INSERT INTO `sys_picture` VALUES ('78', '20171009104.jpg', '104', '2017', '10', '9', '2017-10-16 23:05:23', '../img/104/20171009104.jpg', '暂无');
INSERT INTO `sys_picture` VALUES ('79', '20171010104.jpg', '104', '2017', '10', '10', '2017-10-16 23:05:28', '../img/104/20171010104.jpg', '暂无');
INSERT INTO `sys_picture` VALUES ('80', '20171011104.jpg', '104', '2017', '10', '11', '2017-10-16 23:05:31', '../img/104/20171011104.jpg', '暂无');
INSERT INTO `sys_picture` VALUES ('81', '20171012104.jpg', '104', '2017', '10', '12', '2017-10-16 23:05:35', '../img/104/20171012104.jpg', '暂无');
INSERT INTO `sys_picture` VALUES ('82', '20171013104.jpg', '104', '2017', '10', '13', '2017-10-16 23:10:26', '../img/104/20171013104.jpg', '暂无');
INSERT INTO `sys_picture` VALUES ('83', '20171014104.jpg', '104', '2017', '10', '14', '2017-10-16 23:10:30', '../img/104/20171014104.jpg', '暂无');
INSERT INTO `sys_picture` VALUES ('84', '20171015104.jpg', '104', '2017', '10', '15', '2017-10-16 23:10:30', '../img/104/20171015104.jpg', '暂无');
INSERT INTO `sys_picture` VALUES ('85', '20171016104.jpg', '104', '2017', '10', '16', '2017-10-16 23:05:19', '../img/104/20171016104.jpg', '暂无');
INSERT INTO `sys_picture` VALUES ('86', '20171017104.jpg', '104', '2017', '10', '17', '2017-10-16 23:05:23', '../img/104/20171017104.jpg', '暂无');
INSERT INTO `sys_picture` VALUES ('87', '20171018104.jpg', '104', '2017', '10', '18', '2017-10-16 23:05:28', '../img/104/20171018104.jpg', '暂无');
INSERT INTO `sys_picture` VALUES ('88', '20171019104.jpg', '104', '2017', '10', '19', '2017-10-16 23:05:31', '../img/104/20171019104.jpg', '暂无');
INSERT INTO `sys_picture` VALUES ('89', '20171020104.jpg', '104', '2017', '10', '20', '2017-10-16 23:05:35', '../img/104/20171020104.jpg', '暂无');
INSERT INTO `sys_picture` VALUES ('90', '20171021104.jpg', '104', '2017', '10', '21', '2017-10-16 23:10:26', '../img/104/20171021104.jpg', '暂无');
INSERT INTO `sys_picture` VALUES ('91', '20171022104.jpg', '104', '2017', '10', '22', '2017-10-16 23:10:30', '../img/104/20171022104.jpg', '暂无');
INSERT INTO `sys_picture` VALUES ('92', '20171023104.jpg', '104', '2017', '10', '23', '2017-10-16 23:10:30', '../img/104/20171023104.jpg', '暂无');
INSERT INTO `sys_picture` VALUES ('93', '20171001105.png', '105', '2017', '10', '1', '2017-10-23 13:47:17', '../img/105/20171001105.jpg', '暂无');
INSERT INTO `sys_picture` VALUES ('94', '20171002105.png', '105', '2017', '10', '2', '2017-10-16 23:05:23', '../img/105/20171002105.png', '暂无');
INSERT INTO `sys_picture` VALUES ('95', '20171003105.png', '105', '2017', '10', '3', '2017-10-16 23:05:28', '../img/105/20171003105.png', '暂无');
INSERT INTO `sys_picture` VALUES ('96', '20171004105.png', '105', '2017', '10', '4', '2017-10-16 23:05:31', '../img/105/20171004105.png', '暂无');
INSERT INTO `sys_picture` VALUES ('97', '20171005105.png', '105', '2017', '10', '5', '2017-10-16 23:05:35', '../img/105/20171005105.png', '暂无');
INSERT INTO `sys_picture` VALUES ('98', '20171006105.png', '105', '2017', '10', '6', '2017-10-16 23:10:26', '../img/105/20171006105.png', '暂无');
INSERT INTO `sys_picture` VALUES ('99', '20171007105.png', '105', '2017', '10', '7', '2017-10-16 23:10:30', '../img/105/20171007105.png', '暂无');
INSERT INTO `sys_picture` VALUES ('100', '20171008105.png', '105', '2017', '10', '8', '2017-10-16 23:05:19', '../img/105/20171008105.png', '暂无');
INSERT INTO `sys_picture` VALUES ('101', '20171009105.png', '105', '2017', '10', '9', '2017-10-16 23:05:23', '../img/105/20171009105.png', '暂无');
INSERT INTO `sys_picture` VALUES ('102', '20171010105.png', '105', '2017', '10', '10', '2017-10-16 23:05:28', '../img/105/20171010105.png', '暂无');
INSERT INTO `sys_picture` VALUES ('103', '20171011105.png', '105', '2017', '10', '11', '2017-10-16 23:05:31', '../img/105/20171011105.png', '暂无');
INSERT INTO `sys_picture` VALUES ('104', '20171012105.png', '105', '2017', '10', '12', '2017-10-16 23:05:35', '../img/105/20171012105.png', '暂无');
INSERT INTO `sys_picture` VALUES ('105', '20171013105.png', '105', '2017', '10', '13', '2017-10-16 23:10:26', '../img/105/20171013105.png', '暂无');
INSERT INTO `sys_picture` VALUES ('106', '20171014105.png', '105', '2017', '10', '14', '2017-10-16 23:10:30', '../img/105/20171014105.png', '暂无');
INSERT INTO `sys_picture` VALUES ('107', '20171015105.png', '105', '2017', '10', '15', '2017-10-16 23:10:30', '../img/105/20171015105.png', '暂无');
INSERT INTO `sys_picture` VALUES ('108', '20171016105.png', '105', '2017', '10', '16', '2017-10-16 23:05:19', '../img/105/20171016105.png', '暂无');
INSERT INTO `sys_picture` VALUES ('109', '20171017105.png', '105', '2017', '10', '17', '2017-10-16 23:05:23', '../img/105/20171017105.png', '暂无');
INSERT INTO `sys_picture` VALUES ('110', '20171018105.png', '105', '2017', '10', '18', '2017-10-16 23:05:28', '../img/105/20171018105.png', '暂无');
INSERT INTO `sys_picture` VALUES ('111', '20171019105.png', '105', '2017', '10', '19', '2017-10-16 23:05:31', '../img/105/20171019105.png', '暂无');
INSERT INTO `sys_picture` VALUES ('112', '20171020105.png', '105', '2017', '10', '20', '2017-10-16 23:05:35', '../img/105/20171020105.png', '暂无');
INSERT INTO `sys_picture` VALUES ('113', '20171021105.png', '105', '2017', '10', '21', '2017-10-16 23:10:26', '../img/105/20171021105.png', '暂无');
INSERT INTO `sys_picture` VALUES ('114', '20171022105.png', '105', '2017', '10', '22', '2017-10-16 23:10:30', '../img/105/20171022105.png', '暂无');
INSERT INTO `sys_picture` VALUES ('115', '20171023105.png', '105', '2017', '10', '23', '2017-10-16 23:10:30', '../img/105/20171023105.png', '暂无');
INSERT INTO `sys_picture` VALUES ('116', '20171001106.jpg', '106', '2017', '10', '1', '2017-10-23 13:59:13', '../img/106/20171001106.jpg', '暂无');
INSERT INTO `sys_picture` VALUES ('117', '20171002106.jpg', '106', '2017', '10', '2', '2017-10-16 23:05:23', '../img/106/20171002106.jpg', '暂无');
INSERT INTO `sys_picture` VALUES ('118', '20171003106.jpg', '106', '2017', '10', '3', '2017-10-16 23:05:28', '../img/106/20171003106.jpg', '暂无');
INSERT INTO `sys_picture` VALUES ('119', '20171004106.jpg', '106', '2017', '10', '4', '2017-10-16 23:05:31', '../img/106/20171004106.jpg', '暂无');
INSERT INTO `sys_picture` VALUES ('120', '20171005106.jpg', '106', '2017', '10', '5', '2017-10-16 23:05:35', '../img/106/20171005106.jpg', '暂无');
INSERT INTO `sys_picture` VALUES ('121', '20171006106.jpg', '106', '2017', '10', '6', '2017-10-16 23:10:26', '../img/106/20171006106.jpg', '暂无');
INSERT INTO `sys_picture` VALUES ('122', '20171007106.jpg', '106', '2017', '10', '7', '2017-10-16 23:10:30', '../img/106/20171007106.jpg', '暂无');
INSERT INTO `sys_picture` VALUES ('123', '20171008106.jpg', '106', '2017', '10', '8', '2017-10-16 23:05:19', '../img/106/20171008106.jpg', '暂无');
INSERT INTO `sys_picture` VALUES ('124', '20171009106.jpg', '106', '2017', '10', '9', '2017-10-16 23:05:23', '../img/106/20171009106.jpg', '暂无');
INSERT INTO `sys_picture` VALUES ('125', '20171010106.jpg', '106', '2017', '10', '10', '2017-10-16 23:05:28', '../img/106/20171010106.jpg', '暂无');
INSERT INTO `sys_picture` VALUES ('126', '20171011106.jpg', '106', '2017', '10', '11', '2017-10-16 23:05:31', '../img/106/20171011106.jpg', '暂无');
INSERT INTO `sys_picture` VALUES ('127', '20171012106.jpg', '106', '2017', '10', '12', '2017-10-16 23:05:35', '../img/106/20171012106.jpg', '暂无');
INSERT INTO `sys_picture` VALUES ('128', '20171013106.jpg', '106', '2017', '10', '13', '2017-10-16 23:10:26', '../img/106/20171013106.jpg', '暂无');
INSERT INTO `sys_picture` VALUES ('129', '20171014106.jpg', '106', '2017', '10', '14', '2017-10-16 23:10:30', '../img/106/20171014106.jpg', '暂无');
INSERT INTO `sys_picture` VALUES ('130', '20171015106.jpg', '106', '2017', '10', '15', '2017-10-16 23:10:30', '../img/106/20171015106.jpg', '暂无');
INSERT INTO `sys_picture` VALUES ('131', '20171016106.jpg', '106', '2017', '10', '16', '2017-10-16 23:05:19', '../img/106/20171016106.jpg', '暂无');
INSERT INTO `sys_picture` VALUES ('132', '20171017106.jpg', '106', '2017', '10', '17', '2017-10-16 23:05:23', '../img/106/20171017106.jpg', '暂无');
INSERT INTO `sys_picture` VALUES ('133', '20171018106.jpg', '106', '2017', '10', '18', '2017-10-16 23:05:28', '../img/106/20171018106.jpg', '暂无');
INSERT INTO `sys_picture` VALUES ('134', '20171019106.jpg', '106', '2017', '10', '19', '2017-10-16 23:05:31', '../img/106/20171019106.jpg', '暂无');
INSERT INTO `sys_picture` VALUES ('135', '20171020106.jpg', '106', '2017', '10', '20', '2017-10-16 23:05:35', '../img/106/20171020106.jpg', '暂无');
INSERT INTO `sys_picture` VALUES ('136', '20171021106.jpg', '106', '2017', '10', '21', '2017-10-16 23:10:26', '../img/106/20171021106.jpg', '暂无');
INSERT INTO `sys_picture` VALUES ('137', '20171022106.jpg', '106', '2017', '10', '22', '2017-10-16 23:10:30', '../img/106/20171022106.jpg', '暂无');
INSERT INTO `sys_picture` VALUES ('138', '20171023106.jpg', '106', '2017', '10', '23', '2017-10-16 23:10:30', '../img/106/20171023106.jpg', '暂无');
INSERT INTO `sys_picture` VALUES ('139', '20171023101.png', '101', '2017', '10', '23', '2017-10-23 13:20:35', '../img/101/20171023101.png', '暂无');
INSERT INTO `sys_picture` VALUES ('140', '20171024101.png', '101', '2017', '10', '24', '2017-10-23 13:20:38', '../img/101/20171024101.png', '暂无');
INSERT INTO `sys_picture` VALUES ('141', '20171025101.png', '101', '2017', '10', '25', '2017-10-23 13:20:41', '../img/101/20171025101.png', '暂无');
INSERT INTO `sys_picture` VALUES ('142', '20171026101.png', '101', '2017', '10', '26', '2017-10-23 13:20:44', '../img/101/20171026101.png', '暂无');
INSERT INTO `sys_picture` VALUES ('143', '20171027101.png', '101', '2017', '10', '27', '2017-10-23 13:20:46', '../img/101/20171027101.png', '暂无');
INSERT INTO `sys_picture` VALUES ('144', '20171028101.png', '101', '2017', '10', '28', '2017-10-16 23:10:26', '../img/101/20171028101.png', '暂无');
INSERT INTO `sys_picture` VALUES ('145', '20171029101.png', '101', '2017', '10', '29', '2017-10-23 13:20:48', '../img/101/20171029101.png', '暂无');
INSERT INTO `sys_picture` VALUES ('146', '20171030101.png', '101', '2017', '10', '30', '2017-10-23 13:20:49', '../img/101/20171030101.png', '暂无');
INSERT INTO `sys_picture` VALUES ('147', '20171101101.png', '101', '2017', '11', '1', '2017-10-23 13:20:50', '../img/101/20171101101.png', '暂无');
INSERT INTO `sys_picture` VALUES ('148', '20171102101.png', '101', '2017', '11', '2', '2017-10-23 13:20:51', '../img/101/20171102101.png', '暂无');
INSERT INTO `sys_picture` VALUES ('149', '20171103101.png', '101', '2017', '11', '3', '2017-10-23 13:20:53', '../img/101/20171103101.png', '暂无');
INSERT INTO `sys_picture` VALUES ('150', '20171104101.png', '101', '2017', '11', '4', '2017-10-23 13:20:54', '../img/101/20171104101.png', '暂无');
INSERT INTO `sys_picture` VALUES ('151', '20171105101.png', '101', '2017', '11', '5', '2017-10-16 23:10:26', '../img/101/20171105101.png', '暂无');
INSERT INTO `sys_picture` VALUES ('152', '20171108101.png', '101', '2017', '11', '8', '2017-10-23 13:20:56', '../img/101/20171108101.png', '暂无');
INSERT INTO `sys_picture` VALUES ('153', '20171107101.png', '101', '2017', '11', '7', '2017-10-23 13:20:57', '../img/101/20171107101.png', '暂无');
INSERT INTO `sys_picture` VALUES ('154', '20171109101.png', '101', '2017', '11', '9', '2017-10-23 13:20:58', '../img/101/20171109101.png', '暂无');
INSERT INTO `sys_picture` VALUES ('155', '20171110101.png', '101', '2017', '11', '10', '2017-10-23 13:20:59', '../img/101/20171110101.png', '暂无');
INSERT INTO `sys_picture` VALUES ('156', '20171111101.png', '101', '2017', '11', '11', '2017-10-23 13:21:01', '../img/101/20171111101.png', '暂无');
INSERT INTO `sys_picture` VALUES ('157', '20171112101.png', '101', '2017', '11', '12', '2017-10-23 13:21:02', '../img/101/20171112101.png', '暂无');
INSERT INTO `sys_picture` VALUES ('158', '20171113101.png', '101', '2017', '11', '13', '2017-10-23 13:21:04', '../img/101/20171113101.png', '暂无');
INSERT INTO `sys_picture` VALUES ('159', '20171114101.png', '101', '2017', '11', '14', '2017-10-16 23:10:26', '../img/101/20171114101.png', '暂无');
INSERT INTO `sys_picture` VALUES ('160', '20171115101.png', '101', '2017', '11', '15', '2017-10-23 13:21:07', '../img/101/20171115101.png', '暂无');
INSERT INTO `sys_picture` VALUES ('161', '20171116101.png', '101', '2017', '11', '16', '2017-10-16 23:05:19', '../img/101/20171116101.png', '暂无');
INSERT INTO `sys_picture` VALUES ('162', '20171117101.png', '101', '2017', '11', '17', '2017-10-16 23:05:23', '../img/101/20171117101.png', '暂无');
INSERT INTO `sys_picture` VALUES ('163', '20171118101.png', '101', '2017', '11', '18', '2017-10-16 23:05:28', '../img/101/20171118101.png', '暂无');
INSERT INTO `sys_picture` VALUES ('164', '20171119101.png', '101', '2017', '11', '19', '2017-10-16 23:05:31', '../img/101/20171119101.png', '暂无');
INSERT INTO `sys_picture` VALUES ('165', '20171120101.png', '101', '2017', '11', '20', '2017-10-16 23:05:35', '../img/101/20171120101.png', '暂无');
INSERT INTO `sys_picture` VALUES ('166', '20171121101.png', '101', '2017', '11', '21', '2017-10-16 23:10:26', '../img/101/20171121101.png', '暂无');
INSERT INTO `sys_picture` VALUES ('167', '20171122101.png', '101', '2017', '11', '22', '2017-10-16 23:10:30', '../img/101/20171122101.png', '暂无');
INSERT INTO `sys_picture` VALUES ('168', '20171123101.png', '101', '2017', '11', '23', '2017-10-16 23:05:19', '../img/101/20171123101.png', '暂无');
INSERT INTO `sys_picture` VALUES ('169', '20171124101.png', '101', '2017', '11', '24', '2017-10-16 23:05:23', '../img/101/20171124101.png', '暂无');
INSERT INTO `sys_picture` VALUES ('170', '20171125101.png', '101', '2017', '11', '25', '2017-10-16 23:05:28', '../img/101/20171125101.png', '暂无');
INSERT INTO `sys_picture` VALUES ('171', '20171126101.png', '101', '2017', '11', '26', '2017-10-16 23:05:31', '../img/101/20171126101.png', '暂无');
INSERT INTO `sys_picture` VALUES ('172', '20171127101.png', '101', '2017', '11', '27', '2017-10-16 23:05:35', '../img/101/20171127101.png', '暂无');
INSERT INTO `sys_picture` VALUES ('173', '20171023102.png', '102', '2017', '10', '23', '2017-11-28 15:47:04', '../img/102/20171023102.png', '暂无');
INSERT INTO `sys_picture` VALUES ('174', '20171024102.png', '102', '2017', '10', '24', '2017-11-28 15:47:07', '../img/102/20171024102.png', '暂无');
INSERT INTO `sys_picture` VALUES ('175', '20171025102.png', '102', '2017', '10', '25', '2017-11-28 15:47:09', '../img/102/20171025102.png', '暂无');
INSERT INTO `sys_picture` VALUES ('176', '20171026102.png', '102', '2017', '10', '26', '2017-11-28 15:47:12', '../img/102/20171026102.png', '暂无');
INSERT INTO `sys_picture` VALUES ('177', '20171027102.png', '102', '2017', '10', '27', '2017-11-28 15:47:15', '../img/102/20171027102.png', '暂无');
INSERT INTO `sys_picture` VALUES ('178', '20171028102.png', '102', '2017', '10', '28', '2017-11-28 15:47:18', '../img/102/20171028102.png', '暂无');
INSERT INTO `sys_picture` VALUES ('179', '20171029102.png', '102', '2017', '10', '29', '2017-11-28 15:47:21', '../img/102/20171029102.png', '暂无');
INSERT INTO `sys_picture` VALUES ('180', '20171030102.png', '102', '2017', '10', '30', '2017-11-28 15:47:22', '../img/102/20171030102.png', '暂无');
INSERT INTO `sys_picture` VALUES ('181', '20171101102.png', '102', '2017', '11', '1', '2017-11-28 15:47:26', '../img/102/20171101102.png', '暂无');
INSERT INTO `sys_picture` VALUES ('182', '20171102102.png', '102', '2017', '11', '2', '2017-11-28 15:47:30', '../img/102/20171102102.png', '暂无');
INSERT INTO `sys_picture` VALUES ('183', '20171103102.png', '102', '2017', '11', '3', '2017-11-28 15:47:39', '../img/102/20171103102.png', '暂无');
INSERT INTO `sys_picture` VALUES ('184', '20171104102.png', '102', '2017', '11', '4', '2017-11-28 15:47:41', '../img/102/20171104102.png', '暂无');
INSERT INTO `sys_picture` VALUES ('185', '20171105102.png', '102', '2017', '11', '5', '2017-11-28 15:47:44', '../img/102/20171105102.png', '暂无');
INSERT INTO `sys_picture` VALUES ('186', '20171107102.png', '102', '2017', '11', '7', '2017-11-28 15:47:46', '../img/102/20171107102.png', '暂无');
INSERT INTO `sys_picture` VALUES ('187', '20171108102.png', '102', '2017', '11', '8', '2017-11-28 15:47:48', '../img/102/20171108102.png', '暂无');
INSERT INTO `sys_picture` VALUES ('188', '20171109102.png', '102', '2017', '11', '9', '2017-11-28 15:47:52', '../img/102/20171109102.png', '暂无');
INSERT INTO `sys_picture` VALUES ('189', '20171110102.png', '102', '2017', '11', '10', '2017-11-28 15:47:54', '../img/102/20171110102.png', '暂无');
INSERT INTO `sys_picture` VALUES ('190', '20171111102.png', '102', '2017', '11', '11', '2017-11-28 15:47:59', '../img/102/20171111102.png', '暂无');
INSERT INTO `sys_picture` VALUES ('191', '20171112102.png', '102', '2017', '11', '12', '2017-11-28 15:48:03', '../img/102/20171112102.png', '暂无');
INSERT INTO `sys_picture` VALUES ('192', '20171113102.png', '102', '2017', '11', '13', '2017-11-28 15:48:05', '../img/102/20171113102.png', '暂无');
INSERT INTO `sys_picture` VALUES ('193', '20171114102.png', '102', '2017', '11', '14', '2017-11-28 15:48:07', '../img/102/20171114102.png', '暂无');
INSERT INTO `sys_picture` VALUES ('194', '20171115102.png', '102', '2017', '11', '15', '2017-11-28 15:48:10', '../img/102/20171115102.png', '暂无');
INSERT INTO `sys_picture` VALUES ('195', '20171116102.png', '102', '2017', '11', '16', '2017-11-28 15:44:15', '../img/102/20171116102.png', '暂无');
INSERT INTO `sys_picture` VALUES ('196', '20171117102.png', '102', '2017', '11', '17', '2017-11-28 15:44:21', '../img/102/20171117102.png', '暂无');
INSERT INTO `sys_picture` VALUES ('197', '20171118102.png', '102', '2017', '11', '18', '2017-11-28 15:44:26', '../img/102/20171118102.png', '暂无');
INSERT INTO `sys_picture` VALUES ('198', '20171119102.png', '102', '2017', '11', '19', '2017-11-28 15:44:32', '../img/102/20171119102.png', '暂无');
INSERT INTO `sys_picture` VALUES ('199', '20171120102.png', '102', '2017', '11', '20', '2017-11-28 15:44:37', '../img/102/20171120102.png', '暂无');
INSERT INTO `sys_picture` VALUES ('200', '20171121102.png', '102', '2017', '11', '21', '2017-11-28 15:44:41', '../img/102/20171121102.png', '暂无');
INSERT INTO `sys_picture` VALUES ('201', '20171122102.png', '102', '2017', '11', '22', '2017-11-28 15:44:47', '../img/102/20171122102.png', '暂无');
INSERT INTO `sys_picture` VALUES ('202', '20171123102.png', '102', '2017', '11', '23', '2017-11-28 15:44:52', '../img/102/20171123102.png', '暂无');
INSERT INTO `sys_picture` VALUES ('203', '20171124102.png', '102', '2017', '11', '24', '2017-11-28 15:44:57', '../img/102/20171124102.png', '暂无');
INSERT INTO `sys_picture` VALUES ('204', '20171125102.png', '102', '2017', '11', '25', '2017-11-28 15:45:45', '../img/102/20171125102.png', '暂无');
INSERT INTO `sys_picture` VALUES ('205', '20171126102.png', '102', '2017', '11', '26', '2017-10-23 13:20:35', '../img/102/20171126102.png', '暂无');
INSERT INTO `sys_picture` VALUES ('206', '20171127102.png', '102', '2017', '11', '27', '2017-10-23 13:20:35', '../img/102/20171127102.png', '暂无');
INSERT INTO `sys_picture` VALUES ('207', '20171026103.png', '103', '2017', '10', '26', '2017-10-23 13:20:44', '../img/103/20171026103.png', '暂无');
INSERT INTO `sys_picture` VALUES ('208', '20171027103.png', '103', '2017', '10', '27', '2017-10-23 13:20:46', '../img/103/20171027103.png', '暂无');
INSERT INTO `sys_picture` VALUES ('209', '20171028103.png', '103', '2017', '10', '28', '2017-10-16 23:10:26', '../img/103/20171028103.png', '暂无');
INSERT INTO `sys_picture` VALUES ('210', '20171029103.png', '103', '2017', '10', '29', '2017-10-23 13:20:48', '../img/103/20171029103.png', '暂无');
INSERT INTO `sys_picture` VALUES ('211', '20171030103.png', '103', '2017', '10', '30', '2017-10-23 13:20:49', '../img/103/20171030103.png', '暂无');
INSERT INTO `sys_picture` VALUES ('212', '20171101103.png', '103', '2017', '11', '1', '2017-10-23 13:20:50', '../img/103/20171101103.png', '暂无');
INSERT INTO `sys_picture` VALUES ('213', '20171102103.png', '103', '2017', '11', '2', '2017-10-23 13:20:51', '../img/103/20171102103.png', '暂无');
INSERT INTO `sys_picture` VALUES ('214', '20171103103.png', '103', '2017', '11', '3', '2017-10-23 13:20:53', '../img/103/20171103103.png', '暂无');
INSERT INTO `sys_picture` VALUES ('215', '20171104103.png', '103', '2017', '11', '4', '2017-10-23 13:20:54', '../img/103/20171104103.png', '暂无');
INSERT INTO `sys_picture` VALUES ('216', '20171105103.png', '103', '2017', '11', '5', '2017-10-16 23:10:26', '../img/103/20171105103.png', '暂无');
INSERT INTO `sys_picture` VALUES ('217', '20171106103.png', '103', '2017', '11', '6', '2017-10-23 13:20:56', '../img/103/20171106103.png', '暂无');
INSERT INTO `sys_picture` VALUES ('218', '20171108103.png', '103', '2017', '11', '8', '2017-10-23 13:20:57', '../img/103/20171108103.png', '暂无');
INSERT INTO `sys_picture` VALUES ('219', '20171109103.png', '103', '2017', '11', '9', '2017-10-23 13:20:58', '../img/103/20171109103.png', '暂无');
INSERT INTO `sys_picture` VALUES ('220', '20171110103.png', '103', '2017', '11', '10', '2017-10-23 13:20:59', '../img/103/20171110103.png', '暂无');
INSERT INTO `sys_picture` VALUES ('221', '20171111103.png', '103', '2017', '11', '11', '2017-10-23 13:21:01', '../img/103/20171111103.png', '暂无');
INSERT INTO `sys_picture` VALUES ('222', '20171112103.png', '103', '2017', '11', '12', '2017-10-23 13:21:02', '../img/103/20171112103.png', '暂无');
INSERT INTO `sys_picture` VALUES ('223', '20171113103.png', '103', '2017', '11', '13', '2017-10-23 13:21:04', '../img/103/20171113103.png', '暂无');
INSERT INTO `sys_picture` VALUES ('224', '20171114103.png', '103', '2017', '11', '14', '2017-10-16 23:10:26', '../img/103/20171114103.png', '暂无');
INSERT INTO `sys_picture` VALUES ('225', '20171115103.png', '103', '2017', '11', '15', '2017-10-23 13:21:07', '../img/103/20171115103.png', '暂无');
INSERT INTO `sys_picture` VALUES ('226', '20171116103.png', '103', '2017', '11', '16', '2017-10-16 23:05:19', '../img/103/20171116103.png', '暂无');
INSERT INTO `sys_picture` VALUES ('227', '20171117103.png', '103', '2017', '11', '17', '2017-10-16 23:05:23', '../img/103/20171117103.png', '暂无');
INSERT INTO `sys_picture` VALUES ('228', '20171118103.png', '103', '2017', '11', '18', '2017-10-16 23:05:28', '../img/103/20171118103.png', '暂无');
INSERT INTO `sys_picture` VALUES ('229', '20171119103.png', '103', '2017', '11', '19', '2017-10-16 23:05:31', '../img/103/20171119103.png', '暂无');
INSERT INTO `sys_picture` VALUES ('230', '20171120103.png', '103', '2017', '11', '20', '2017-10-16 23:05:35', '../img/103/20171120103.png', '暂无');
INSERT INTO `sys_picture` VALUES ('231', '20171121103.png', '103', '2017', '11', '21', '2017-10-16 23:10:26', '../img/103/20171121103.png', '暂无');
INSERT INTO `sys_picture` VALUES ('232', '20171122103.png', '103', '2017', '11', '22', '2017-10-16 23:10:30', '../img/103/20171122103.png', '暂无');
INSERT INTO `sys_picture` VALUES ('233', '20171123103.png', '103', '2017', '11', '23', '2017-10-16 23:05:19', '../img/103/20171123103.png', '暂无');
INSERT INTO `sys_picture` VALUES ('234', '20171124103.png', '103', '2017', '11', '24', '2017-10-16 23:05:23', '../img/103/20171124103.png', '暂无');
INSERT INTO `sys_picture` VALUES ('235', '20171125103.png', '103', '2017', '11', '25', '2017-10-16 23:05:28', '../img/103/20171125103.png', '暂无');
INSERT INTO `sys_picture` VALUES ('236', '20171126103.png', '103', '2017', '11', '26', '2017-10-16 23:05:31', '../img/103/20171126103.png', '暂无');
INSERT INTO `sys_picture` VALUES ('237', '20171127103.png', '103', '2017', '11', '27', '2017-10-16 23:05:35', '../img/103/20171127103.png', '暂无');
INSERT INTO `sys_picture` VALUES ('238', '20171024103.png', '103', '2017', '10', '24', '2017-10-23 13:20:38', '../img/103/20171024103.png', '暂无');
INSERT INTO `sys_picture` VALUES ('239', '20171025103.png', '103', '2017', '10', '25', '2017-10-23 13:20:41', '../img/103/20171025103.png', '暂无');
INSERT INTO `sys_picture` VALUES ('240', '20171024104.png', '104', '2017', '10', '24', '2017-10-23 13:20:38', '../img/104/20171024104.png', '暂无');
INSERT INTO `sys_picture` VALUES ('241', '20171025104.png', '104', '2017', '10', '25', '2017-10-23 13:20:41', '../img/104/20171025104.png', '暂无');
INSERT INTO `sys_picture` VALUES ('242', '20171026104.png', '104', '2017', '10', '26', '2017-10-23 13:20:44', '../img/104/20171026104.png', '暂无');
INSERT INTO `sys_picture` VALUES ('243', '20171027104.png', '104', '2017', '10', '27', '2017-10-23 13:20:46', '../img/104/20171027104.png', '暂无');
INSERT INTO `sys_picture` VALUES ('244', '20171028104.png', '104', '2017', '10', '28', '2017-10-16 23:10:26', '../img/104/20171028104.png', '暂无');
INSERT INTO `sys_picture` VALUES ('245', '20171029104.png', '104', '2017', '10', '29', '2017-10-23 13:20:48', '../img/104/20171029104.png', '暂无');
INSERT INTO `sys_picture` VALUES ('246', '20171031104.png', '104', '2017', '10', '31', '2017-10-23 13:20:48', '../img/104/20171031104.png', '暂无');
INSERT INTO `sys_picture` VALUES ('247', '20171030104.png', '104', '2017', '10', '30', '2017-10-23 13:20:49', '../img/104/20171030104.png', '暂无');
INSERT INTO `sys_picture` VALUES ('248', '20171101104.png', '104', '2017', '11', '1', '2017-10-23 13:20:50', '../img/104/20171101104.png', '暂无');
INSERT INTO `sys_picture` VALUES ('249', '20171102104.png', '104', '2017', '11', '2', '2017-10-23 13:20:51', '../img/104/20171102104.png', '暂无');
INSERT INTO `sys_picture` VALUES ('250', '20171103104.png', '104', '2017', '11', '3', '2017-10-23 13:20:53', '../img/104/20171103104.png', '暂无');
INSERT INTO `sys_picture` VALUES ('251', '20171104104.png', '104', '2017', '11', '4', '2017-10-23 13:20:54', '../img/104/20171104104.png', '暂无');
INSERT INTO `sys_picture` VALUES ('252', '20171105104.png', '104', '2017', '11', '5', '2017-10-16 23:10:26', '../img/104/20171105104.png', '暂无');
INSERT INTO `sys_picture` VALUES ('253', '20171106104.png', '104', '2017', '11', '6', '2017-10-23 13:20:56', '../img/104/20171106104.png', '暂无');
INSERT INTO `sys_picture` VALUES ('254', '20171108104.png', '104', '2017', '11', '8', '2017-10-23 13:20:57', '../img/104/20171108104.png', '暂无');
INSERT INTO `sys_picture` VALUES ('255', '20171109104.png', '104', '2017', '11', '9', '2017-10-23 13:20:58', '../img/104/20171109104.png', '暂无');
INSERT INTO `sys_picture` VALUES ('256', '20171110104.png', '104', '2017', '11', '10', '2017-10-23 13:20:59', '../img/104/20171110104.png', '暂无');
INSERT INTO `sys_picture` VALUES ('257', '20171111104.png', '104', '2017', '11', '11', '2017-10-23 13:21:01', '../img/104/20171111104.png', '暂无');
INSERT INTO `sys_picture` VALUES ('258', '20171107104.png', '104', '2017', '11', '7', '2017-10-23 13:21:02', '../img/104/20171107104.png', '暂无');
INSERT INTO `sys_picture` VALUES ('259', '20171113104.png', '104', '2017', '11', '13', '2017-10-23 13:21:04', '../img/104/20171113104.png', '暂无');
INSERT INTO `sys_picture` VALUES ('260', '20171114104.png', '104', '2017', '11', '14', '2017-10-16 23:10:26', '../img/104/20171114104.png', '暂无');
INSERT INTO `sys_picture` VALUES ('261', '20171115104.png', '104', '2017', '11', '15', '2017-10-23 13:21:07', '../img/104/20171115104.png', '暂无');
INSERT INTO `sys_picture` VALUES ('262', '20171116104.png', '104', '2017', '11', '16', '2017-10-16 23:05:19', '../img/104/20171116104.png', '暂无');
INSERT INTO `sys_picture` VALUES ('263', '20171117104.png', '104', '2017', '11', '17', '2017-10-16 23:05:23', '../img/104/20171117104.png', '暂无');
INSERT INTO `sys_picture` VALUES ('264', '20171118104.png', '104', '2017', '11', '18', '2017-10-16 23:05:28', '../img/104/20171118104.png', '暂无');
INSERT INTO `sys_picture` VALUES ('265', '20171119104.png', '104', '2017', '11', '19', '2017-10-16 23:05:31', '../img/104/20171119104.png', '暂无');
INSERT INTO `sys_picture` VALUES ('266', '20171120104.png', '104', '2017', '11', '20', '2017-10-16 23:05:35', '../img/104/20171120104.png', '暂无');
INSERT INTO `sys_picture` VALUES ('267', '20171121104.png', '104', '2017', '11', '21', '2017-10-16 23:10:26', '../img/104/20171121104.png', '暂无');
INSERT INTO `sys_picture` VALUES ('268', '20171122104.png', '104', '2017', '11', '22', '2017-10-16 23:10:30', '../img/104/20171122104.png', '暂无');
INSERT INTO `sys_picture` VALUES ('269', '20171123104.png', '104', '2017', '11', '23', '2017-10-16 23:05:19', '../img/104/20171123104.png', '暂无');
INSERT INTO `sys_picture` VALUES ('270', '20171124104.png', '104', '2017', '11', '24', '2017-10-16 23:05:23', '../img/104/20171124104.png', '暂无');
INSERT INTO `sys_picture` VALUES ('271', '20171125104.png', '104', '2017', '11', '25', '2017-10-16 23:05:28', '../img/104/20171125104.png', '暂无');
INSERT INTO `sys_picture` VALUES ('272', '20171126104.png', '104', '2017', '11', '26', '2017-10-16 23:05:31', '../img/104/20171126104.png', '暂无');
INSERT INTO `sys_picture` VALUES ('273', '20171127104.png', '104', '2017', '11', '27', '2017-10-16 23:05:35', '../img/104/20171127104.png', '暂无');
INSERT INTO `sys_picture` VALUES ('274', '20171024106.jpg', '106', '2017', '10', '24', '2017-10-23 13:20:38', '../img/106/20171024106.jpg', '暂无');
INSERT INTO `sys_picture` VALUES ('275', '20171025106.jpg', '106', '2017', '10', '25', '2017-10-23 13:20:41', '../img/106/20171025106.jpg', '暂无');
INSERT INTO `sys_picture` VALUES ('276', '20171026106.jpg', '106', '2017', '10', '26', '2017-10-23 13:20:44', '../img/106/20171026106.jpg', '暂无');
INSERT INTO `sys_picture` VALUES ('277', '20171027106.jpg', '106', '2017', '10', '27', '2017-10-23 13:20:46', '../img/106/20171027106.jpg', '暂无');
INSERT INTO `sys_picture` VALUES ('278', '20171028106.jpg', '106', '2017', '10', '28', '2017-10-16 23:10:26', '../img/106/20171028106.jpg', '暂无');
INSERT INTO `sys_picture` VALUES ('279', '20171029106.jpg', '106', '2017', '10', '29', '2017-10-23 13:20:48', '../img/106/20171029106.jpg', '暂无');
INSERT INTO `sys_picture` VALUES ('280', '20171031106.jpg', '106', '2017', '10', '31', '2017-10-23 13:20:48', '../img/106/20171031106.jpg', '暂无');
INSERT INTO `sys_picture` VALUES ('281', '20171030106.jpg', '106', '2017', '10', '30', '2017-10-23 13:20:49', '../img/106/20171030106.jpg', '暂无');
INSERT INTO `sys_picture` VALUES ('282', '20171101106.jpg', '106', '2017', '11', '1', '2017-10-23 13:20:50', '../img/106/20171101106.jpg', '暂无');
INSERT INTO `sys_picture` VALUES ('283', '20171102106.jpg', '106', '2017', '11', '2', '2017-10-23 13:20:51', '../img/106/20171102106.jpg', '暂无');
INSERT INTO `sys_picture` VALUES ('284', '20171103106.jpg', '106', '2017', '11', '3', '2017-10-23 13:20:53', '../img/106/20171103106.jpg', '暂无');
INSERT INTO `sys_picture` VALUES ('285', '20171104106.jpg', '106', '2017', '11', '4', '2017-10-23 13:20:54', '../img/106/20171104106.jpg', '暂无');
INSERT INTO `sys_picture` VALUES ('286', '20171105106.jpg', '106', '2017', '11', '5', '2017-10-16 23:10:26', '../img/106/20171105106.jpg', '暂无');
INSERT INTO `sys_picture` VALUES ('287', '20171106106.jpg', '106', '2017', '11', '6', '2017-10-23 13:20:56', '../img/106/20171106106.jpg', '暂无');
INSERT INTO `sys_picture` VALUES ('288', '20171107106.jpg', '106', '2017', '11', '7', '2017-10-23 13:20:56', '../img/106/20171107106.jpg', '暂无');
INSERT INTO `sys_picture` VALUES ('289', '20171108106.jpg', '106', '2017', '11', '8', '2017-10-23 13:20:57', '../img/106/20171108106.jpg', '暂无');
INSERT INTO `sys_picture` VALUES ('290', '20171109106.jpg', '106', '2017', '11', '9', '2017-10-23 13:20:58', '../img/106/20171109106.jpg', '暂无');
INSERT INTO `sys_picture` VALUES ('291', '20171110106.jpg', '106', '2017', '11', '10', '2017-10-23 13:20:59', '../img/106/20171110106.jpg', '暂无');
INSERT INTO `sys_picture` VALUES ('292', '20171111106.jpg', '106', '2017', '11', '11', '2017-10-23 13:21:01', '../img/106/20171111106.jpg', '暂无');
INSERT INTO `sys_picture` VALUES ('293', '20171112106.jpg', '106', '2017', '11', '12', '2017-10-23 13:21:02', '../img/106/20171112106.jpg', '暂无');
INSERT INTO `sys_picture` VALUES ('294', '20171113106.jpg', '106', '2017', '11', '13', '2017-10-23 13:21:04', '../img/106/20171113106.jpg', '暂无');
INSERT INTO `sys_picture` VALUES ('295', '20171114106.jpg', '106', '2017', '11', '14', '2017-10-16 23:10:26', '../img/106/20171114106.jpg', '暂无');
INSERT INTO `sys_picture` VALUES ('296', '20171115106.jpg', '106', '2017', '11', '15', '2017-10-23 13:21:07', '../img/106/20171115106.jpg', '暂无');
INSERT INTO `sys_picture` VALUES ('297', '20171116106.jpg', '106', '2017', '11', '16', '2017-10-16 23:05:19', '../img/106/20171116106.jpg', '暂无');
INSERT INTO `sys_picture` VALUES ('298', '20171117106.jpg', '106', '2017', '11', '17', '2017-10-16 23:05:23', '../img/106/20171117106.jpg', '暂无');
INSERT INTO `sys_picture` VALUES ('299', '20171118106.jpg', '106', '2017', '11', '18', '2017-10-16 23:05:28', '../img/106/20171118106.jpg', '暂无');
INSERT INTO `sys_picture` VALUES ('300', '20171119106.jpg', '106', '2017', '11', '19', '2017-10-16 23:05:31', '../img/106/20171119106.jpg', '暂无');
INSERT INTO `sys_picture` VALUES ('301', '20171120106.jpg', '106', '2017', '11', '20', '2017-10-16 23:05:35', '../img/106/20171120106.jpg', '暂无');
INSERT INTO `sys_picture` VALUES ('302', '20171121106.jpg', '106', '2017', '11', '21', '2017-10-16 23:10:26', '../img/106/20171121106.jpg', '暂无');
INSERT INTO `sys_picture` VALUES ('303', '20171122106.jpg', '106', '2017', '11', '22', '2017-10-16 23:10:30', '../img/106/20171122106.jpg', '暂无');
INSERT INTO `sys_picture` VALUES ('304', '20171123106.jpg', '106', '2017', '11', '23', '2017-10-16 23:05:19', '../img/106/20171123106.jpg', '暂无');
INSERT INTO `sys_picture` VALUES ('306', '20171125106.jpg', '106', '2017', '11', '25', '2017-10-16 23:05:28', '../img/106/20171125106.jpg', '暂无');
INSERT INTO `sys_picture` VALUES ('307', '20171126106.jpg', '106', '2017', '11', '26', '2017-10-16 23:05:31', '../img/106/20171126106.jpg', '暂无');
INSERT INTO `sys_picture` VALUES ('308', '20171127106.jpg', '106', '2017', '11', '27', '2017-10-16 23:05:35', '../img/106/20171127106.jpg', '暂无');
INSERT INTO `sys_picture` VALUES ('309', '20171128101.png', '101', '2017', '11', '28', '2017-10-16 23:05:19', '../img/101/20171128101.png', '暂无');
INSERT INTO `sys_picture` VALUES ('310', '20171129101.png', '101', '2017', '11', '29', '2017-10-16 23:05:28', '../img/101/20171129101.png', '暂无');
INSERT INTO `sys_picture` VALUES ('311', '20171201101.png', '101', '2017', '12', '1', '2017-10-16 23:05:31', '../img/101/20171201101.png', '暂无');
INSERT INTO `sys_picture` VALUES ('312', '20171202101.png', '101', '2017', '12', '2', '2017-10-16 23:05:35', '../img/101/20171202101.png', '暂无');
INSERT INTO `sys_picture` VALUES ('313', '20171203101.png', '101', '2017', '12', '3', '2017-10-16 23:05:35', '../img/101/20171203101.png', '暂无');
INSERT INTO `sys_picture` VALUES ('314', '20171128102.png', '102', '2017', '11', '28', '2017-10-16 23:05:19', '../img/102/20171128102.png', '暂无');
INSERT INTO `sys_picture` VALUES ('315', '20171129102.png', '102', '2017', '11', '29', '2017-10-16 23:05:28', '../img/102/20171129102.png', '暂无');
INSERT INTO `sys_picture` VALUES ('316', '20171201102.png', '102', '2017', '12', '1', '2017-10-16 23:05:31', '../img/102/20171201102.png', '暂无');
INSERT INTO `sys_picture` VALUES ('317', '20171202102.png', '102', '2017', '12', '2', '2017-10-16 23:05:35', '../img/102/20171202102.png', '暂无');
INSERT INTO `sys_picture` VALUES ('318', '20171203102.png', '102', '2017', '12', '3', '2017-10-16 23:05:35', '../img/102/20171203102.png', '暂无');
INSERT INTO `sys_picture` VALUES ('319', '20171128103.png', '103', '2017', '11', '28', '2017-10-16 23:05:19', '../img/103/20171128103.png', '暂无');
INSERT INTO `sys_picture` VALUES ('320', '20171129103.png', '103', '2017', '11', '29', '2017-10-16 23:05:28', '../img/103/20171129103.png', '暂无');
INSERT INTO `sys_picture` VALUES ('321', '20171130103.png', '103', '2017', '11', '30', '2017-10-16 23:05:31', '../img/103/20171130103.png', '暂无');
INSERT INTO `sys_picture` VALUES ('322', '20171201103.png', '103', '2017', '12', '1', '2017-10-16 23:05:35', '../img/103/20171201103.png', '暂无');
INSERT INTO `sys_picture` VALUES ('323', '20171202103.png', '103', '2017', '12', '2', '2017-10-16 23:05:35', '../img/103/20171202103.png', '暂无');
INSERT INTO `sys_picture` VALUES ('324', '20171203103.png', '103', '2017', '12', '3', '2017-10-16 23:05:35', '../img/103/20171203103.png', '暂无');
INSERT INTO `sys_picture` VALUES ('325', '20171128104.png', '104', '2017', '11', '28', '2017-10-16 23:05:19', '../img/104/20171128104.png', '暂无');
INSERT INTO `sys_picture` VALUES ('326', '20171129104.png', '104', '2017', '11', '29', '2017-10-16 23:05:28', '../img/104/20171129104.png', '暂无');
INSERT INTO `sys_picture` VALUES ('327', '20171130104.png', '104', '2017', '11', '30', '2017-10-16 23:05:31', '../img/104/20171130104.png', '暂无');
INSERT INTO `sys_picture` VALUES ('328', '20171201104.png', '104', '2017', '12', '1', '2017-10-16 23:05:35', '../img/104/20171201104.png', '暂无');
INSERT INTO `sys_picture` VALUES ('329', '20171202104.png', '104', '2017', '12', '2', '2017-10-16 23:05:35', '../img/104/20171202104.png', '暂无');
INSERT INTO `sys_picture` VALUES ('330', '20171203104.png', '104', '2017', '12', '3', '2017-10-16 23:05:35', '../img/104/20171203104.png', '暂无');
INSERT INTO `sys_picture` VALUES ('331', '20171128106.jpg', '106', '2017', '11', '28', '2017-10-16 23:05:19', '../img/106/20171128106.jpg', '暂无');
INSERT INTO `sys_picture` VALUES ('332', '20171129106.jpg', '106', '2017', '11', '29', '2017-10-16 23:05:28', '../img/106/20171129106.jpg', '暂无');
INSERT INTO `sys_picture` VALUES ('333', '20171130106.jpg', '106', '2017', '11', '30', '2017-10-16 23:05:31', '../img/106/20171130106.jpg', '暂无');
INSERT INTO `sys_picture` VALUES ('334', '20171201106.jpg', '106', '2017', '12', '1', '2017-10-16 23:05:35', '../img/106/20171201106.jpg', '暂无');
INSERT INTO `sys_picture` VALUES ('335', '20171202106.jpg', '106', '2017', '12', '2', '2017-10-16 23:05:35', '../img/106/20171202106.jpg', '暂无');
INSERT INTO `sys_picture` VALUES ('336', '20171203106.jpg', '106', '2017', '12', '3', '2017-10-16 23:05:35', '../img/106/20171203106.jpg', '暂无');
INSERT INTO `sys_picture` VALUES ('337', '20171204106.jpg', '106', '2017', '12', '4', '2017-10-16 23:05:35', '../img/106/20171204106.jpg', '暂无');
INSERT INTO `sys_picture` VALUES ('338', '20171204104.png', '104', '2017', '12', '4', '2017-12-05 01:14:55', '../img/104/20171204104.png', '暂无');
INSERT INTO `sys_picture` VALUES ('339', '20171204103.png', '103', '2017', '12', '4', '2017-12-05 01:15:01', '../img/103/20171204103.png', '暂无');

-- ----------------------------
-- Table structure for sys_response
-- ----------------------------
DROP TABLE IF EXISTS `sys_response`;
CREATE TABLE `sys_response` (
  `responseId` int(11) NOT NULL AUTO_INCREMENT,
  `responseContent` text,
  `responseTime` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  `responseLeaveId` int(11) DEFAULT NULL,
  PRIMARY KEY (`responseId`),
  KEY `fk_response_leave` (`responseLeaveId`),
  CONSTRAINT `fk_response_leave` FOREIGN KEY (`responseLeaveId`) REFERENCES `sys_leaveword` (`leaveId`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=67 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_response
-- ----------------------------
INSERT INTO `sys_response` VALUES ('3', 'bbb', '2017-10-31 19:52:37', '3');
INSERT INTO `sys_response` VALUES ('63', '111', '2017-11-14 18:12:00', '4');
INSERT INTO `sys_response` VALUES ('64', 'test1', '2017-11-14 18:11:57', '3');
INSERT INTO `sys_response` VALUES ('66', '<p>111</p>', '2017-12-05 01:56:41', '72');

-- ----------------------------
-- Table structure for sys_user
-- ----------------------------
DROP TABLE IF EXISTS `sys_user`;
CREATE TABLE `sys_user` (
  `userId` int(11) NOT NULL AUTO_INCREMENT,
  `userAccount` varchar(40) NOT NULL,
  `userPwd` varchar(40) NOT NULL,
  `userLastLoginTime` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  `userName` varchar(30) DEFAULT NULL,
  `gender` int(1) DEFAULT NULL,
  `age` int(3) DEFAULT NULL,
  `qq` varchar(12) DEFAULT NULL,
  `tel` varchar(11) DEFAULT NULL,
  `college` int(11) DEFAULT NULL COMMENT '所属学院',
  `status` int(11) DEFAULT NULL COMMENT '用户身份',
  `email` varchar(100) DEFAULT NULL,
  `userHead` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`userId`)
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_user
-- ----------------------------
INSERT INTO `sys_user` VALUES ('1', 'demo', '123456', '2017-12-05 13:57:27', '汤启友', '2', '10', '185075580', '13982036138', '18', '3', '185075580@qq.com', '../img/head/2.png');
INSERT INTO `sys_user` VALUES ('2', 'aaa', 'df', '2017-11-14 17:06:15', '友友', '2', '21', '185075580', '13982036138', '19', '4', '185075580@qq.com', '../img/head/default.jpg');
INSERT INTO `sys_user` VALUES ('3', 'test', '111', '2017-11-14 02:37:27', 'userName', '1', '11', '185075580', '13082036138', '15', '3', '185075580@qq.com', '../img/head/default.jpg');
INSERT INTO `sys_user` VALUES ('4', 'account', 'update', '2017-11-14 02:32:39', 'userName', '1', '11', '185075580', '13082036138', '15', '3', '185075580@qq.com', '../img/head/default.jpg');
INSERT INTO `sys_user` VALUES ('5', 'user', '123', '2017-11-12 22:47:51', '孙七', '2', '22', '185075580', '13082036138', '13', '5', '185075580@qq.com', '../img/head/default.jpg');
INSERT INTO `sys_user` VALUES ('6', 'demo', '111', '2017-11-14 02:50:45', '赵六', '2', '33', '185075580', '13082036138', '14', '4', '185075580@qq.com', '../img/head/default.jpg');
INSERT INTO `sys_user` VALUES ('7', 'account', 'pwd', '2017-11-13 21:39:13', '张三', '1', '11', '185075580', '13082036138', '16', '4', '185075580@qq.com', '../img/head/default.jpg');
INSERT INTO `sys_user` VALUES ('9', 'account', 'pwd', '2017-11-14 01:38:56', '李四', '2', '11', '185075580', '13082036138', '16', '3', '185075580@qq.com', '../img/head/default.jpg');
INSERT INTO `sys_user` VALUES ('11', 'accounat', 'pwd', '2017-12-05 01:55:43', 'userName111', '1', '11', '185075580', '13082036138', '29', '3', '185075580@qq.com', '../img/head/default.jpg');
INSERT INTO `sys_user` VALUES ('12', 'demo1', '654321', '2017-11-14 18:37:39', '汤启友', '1', '11', '185075580', '13082036138', '24', '4', '185075580@qq.com', '../img/head/default.jpg');
INSERT INTO `sys_user` VALUES ('13', 'demo1', '123456', '2017-11-27 11:18:43', 'aa', '2', '11', '185075580', '13982036138', '11', '4', '321@qq.com', '../img/head/default.jpg');
INSERT INTO `sys_user` VALUES ('14', 'demo11', '123456', '2017-11-27 11:27:11', 'xxx', '2', '11', '111111', '13982036138', '10', '4', '185075580@qq.com', '../img/head/default.jpg');
INSERT INTO `sys_user` VALUES ('15', 'demo333', '123456', '2017-11-28 10:05:50', 'xxx', '1', '11', '18507580', '13982036138', '11', '3', '185075580@qq.com', '../img/head/default.jpg');
INSERT INTO `sys_user` VALUES ('16', '111', '123456', '2017-12-05 02:05:14', 'aaa', '2', '11', '1421321321', '13982036138', '28', '3', '12321@qq.com', '../img/head/default.jpg');
SET FOREIGN_KEY_CHECKS=1;

/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 80015
Source Host           : localhost:3306
Source Database       : buyshop

Target Server Type    : MYSQL
Target Server Version : 80015
File Encoding         : 65001

Date: 2019-12-01 19:52:01
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `admin`
-- ----------------------------
DROP TABLE IF EXISTS `admin`;
CREATE TABLE `admin` (
  `adminPkid` int(11) NOT NULL AUTO_INCREMENT,
  `adminName` varchar(255) NOT NULL,
  `adminPass` int(11) NOT NULL,
  PRIMARY KEY (`adminPkid`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of admin
-- ----------------------------
INSERT INTO `admin` VALUES ('1', '小谭', '8888');
INSERT INTO `admin` VALUES ('2', '小胡', '8888');
INSERT INTO `admin` VALUES ('3', '惠惠', '8888');
INSERT INTO `admin` VALUES ('4', '君君', '8888');

-- ----------------------------
-- Table structure for `catalog`
-- ----------------------------
DROP TABLE IF EXISTS `catalog`;
CREATE TABLE `catalog` (
  `catalogId` int(11) NOT NULL AUTO_INCREMENT,
  `sex` varchar(255) DEFAULT NULL,
  `catalogTypeOne` varchar(255) NOT NULL,
  `catalogTypeTwo` varchar(255) NOT NULL,
  PRIMARY KEY (`catalogId`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of catalog
-- ----------------------------
INSERT INTO `catalog` VALUES ('1', '女', '衣服', '夏款');
INSERT INTO `catalog` VALUES ('2', '女', '衣服', '秋款');
INSERT INTO `catalog` VALUES ('3', '男', '衣服', '夏款');
INSERT INTO `catalog` VALUES ('4', '男', '衣服', '秋款');

-- ----------------------------
-- Table structure for `color`
-- ----------------------------
DROP TABLE IF EXISTS `color`;
CREATE TABLE `color` (
  `colorPkid` int(11) NOT NULL AUTO_INCREMENT,
  `colorType` varchar(255) NOT NULL,
  PRIMARY KEY (`colorPkid`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of color
-- ----------------------------
INSERT INTO `color` VALUES ('1', '米白色');
INSERT INTO `color` VALUES ('2', '黑色');
INSERT INTO `color` VALUES ('3', '卡其色');
INSERT INTO `color` VALUES ('4', '红色');

-- ----------------------------
-- Table structure for `comment`
-- ----------------------------
DROP TABLE IF EXISTS `comment`;
CREATE TABLE `comment` (
  `commentPkid` int(11) NOT NULL AUTO_INCREMENT,
  `proPkid` int(11) NOT NULL,
  `commentDes` text CHARACTER SET utf8 COLLATE utf8_bin NOT NULL,
  `userPkid` int(11) NOT NULL,
  `commentTime` datetime NOT NULL,
  PRIMARY KEY (`commentPkid`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of comment
-- ----------------------------
INSERT INTO `comment` VALUES ('1', '1', 0xE5BE88E5AE8CE7BE8EEFBC8CE5B7B2E7BB8FE68EA8E88D90E7BB99E69C8BE58F8BE4BA86EFBC8CE5A4A7E5AEB6E58FAFE4BBA5E694BEE5BF83E8B4ADE4B9B0EFBC8CE5BE88E88892E98082, '1', '2019-11-11 11:13:07');
INSERT INTO `comment` VALUES ('2', '1', 0xE68891E8A789E5BE97E8A1A3E69C8DE69D90E8B4A8E99D9EE5B8B8E5A5BDEFBC8CE7A9BFE79D80E4B99FE88892E69C8DEFBC8CE5A5BDE5A5BD, '2', '2019-11-21 15:01:21');
INSERT INTO `comment` VALUES ('3', '1', 0xE58FAFE4BBA5E58FAFE4BBA5, '3', '2019-11-07 10:45:47');
INSERT INTO `comment` VALUES ('4', '2', 0xE4B88DE99499EFBC81, '1', '2019-11-01 13:32:49');
INSERT INTO `comment` VALUES ('10', '2', 0x676F6F64EFBC81EFBC81EFBC81, '1', '2019-11-01 14:11:48');
INSERT INTO `comment` VALUES ('11', '3', 0xE5BE88E5A5BDE79A84E5BE88E5A5BD, '1', '2019-11-01 14:27:52');
INSERT INTO `comment` VALUES ('12', '2', 0xE5BE88E5A5BDEFBC81, '15', '2019-11-01 15:17:56');
INSERT INTO `comment` VALUES ('13', '12', 0xE59388E59388E59388E59388, '15', '2019-11-01 15:18:18');

-- ----------------------------
-- Table structure for `img`
-- ----------------------------
DROP TABLE IF EXISTS `img`;
CREATE TABLE `img` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `imgUrl` varchar(255) NOT NULL,
  `proId` int(11) NOT NULL,
  `type` int(11) NOT NULL DEFAULT '1',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of img
-- ----------------------------
INSERT INTO `img` VALUES ('1', 'pic1.jpg', '1', '1');
INSERT INTO `img` VALUES ('2', '7.jpg', '2', '1');
INSERT INTO `img` VALUES ('3', '8.jpg', '3', '1');
INSERT INTO `img` VALUES ('4', '9.jpg', '5', '1');
INSERT INTO `img` VALUES ('5', '11.jpg', '6', '1');
INSERT INTO `img` VALUES ('6', '10.jpg', '7', '1');
INSERT INTO `img` VALUES ('7', 'pic2.jpg', '8', '1');
INSERT INTO `img` VALUES ('8', 'pic1.jpg', '9', '1');
INSERT INTO `img` VALUES ('9', 'pic6.jpg', '10', '1');
INSERT INTO `img` VALUES ('10', 'pic5.jpg', '11', '1');
INSERT INTO `img` VALUES ('11', 'pic3.jpg', '12', '1');
INSERT INTO `img` VALUES ('12', 'pic4.jpg', '13', '1');
INSERT INTO `img` VALUES ('13', 's1.jpg', '14', '1');
INSERT INTO `img` VALUES ('14', 's3.jpg', '15', '1');

-- ----------------------------
-- Table structure for `ordercondition`
-- ----------------------------
DROP TABLE IF EXISTS `ordercondition`;
CREATE TABLE `ordercondition` (
  `orderConditionPkid` int(11) NOT NULL AUTO_INCREMENT,
  `conditionType` varchar(10) NOT NULL,
  PRIMARY KEY (`orderConditionPkid`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of ordercondition
-- ----------------------------
INSERT INTO `ordercondition` VALUES ('1', '订单正在处理');
INSERT INTO `ordercondition` VALUES ('2', '已发货');

-- ----------------------------
-- Table structure for `orderlist`
-- ----------------------------
DROP TABLE IF EXISTS `orderlist`;
CREATE TABLE `orderlist` (
  `orderPkid` int(11) NOT NULL AUTO_INCREMENT,
  `warehouseId` int(11) NOT NULL,
  `proNum` int(11) NOT NULL DEFAULT '1',
  `receivePkid` int(11) NOT NULL,
  `orderConditionPkid` int(11) NOT NULL,
  `orderTime` datetime NOT NULL,
  `commentPkid` int(11) NOT NULL DEFAULT '0',
  PRIMARY KEY (`orderPkid`)
) ENGINE=InnoDB AUTO_INCREMENT=69 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of orderlist
-- ----------------------------
INSERT INTO `orderlist` VALUES ('59', '6', '1', '18', '2', '2019-12-01 10:15:24', '1');
INSERT INTO `orderlist` VALUES ('60', '13', '1', '18', '2', '2019-12-01 10:15:24', '0');
INSERT INTO `orderlist` VALUES ('61', '7', '2', '7', '2', '2019-12-01 10:52:44', '0');
INSERT INTO `orderlist` VALUES ('62', '3', '1', '19', '1', '2019-12-01 11:45:18', '0');
INSERT INTO `orderlist` VALUES ('63', '7', '1', '20', '1', '2019-12-01 12:28:01', '0');
INSERT INTO `orderlist` VALUES ('64', '27', '1', '21', '1', '2019-12-01 14:26:40', '0');
INSERT INTO `orderlist` VALUES ('65', '5', '4', '22', '1', '2019-12-01 15:15:24', '0');
INSERT INTO `orderlist` VALUES ('66', '3', '2', '22', '1', '2019-12-01 15:15:24', '0');
INSERT INTO `orderlist` VALUES ('67', '6', '1', '23', '2', '2019-12-01 15:16:28', '0');
INSERT INTO `orderlist` VALUES ('68', '27', '1', '23', '2', '2019-12-01 15:16:28', '0');

-- ----------------------------
-- Table structure for `prodes`
-- ----------------------------
DROP TABLE IF EXISTS `prodes`;
CREATE TABLE `prodes` (
  `proDesPkid` int(11) NOT NULL AUTO_INCREMENT,
  `proDes` varchar(255) NOT NULL,
  PRIMARY KEY (`proDesPkid`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of prodes
-- ----------------------------
INSERT INTO `prodes` VALUES ('1', '服装版型：修身；风格：通勤；款式：套头；组合方式：单件；衣长：常规款；');
INSERT INTO `prodes` VALUES ('2', '厚薄: 常规；风格: 通勤；通勤: 复古；袖长: 长袖；组合形式: 单件；服装版型: 直筒；上市年份季节: 2019年冬季；');

-- ----------------------------
-- Table structure for `product`
-- ----------------------------
DROP TABLE IF EXISTS `product`;
CREATE TABLE `product` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `catalogId` int(11) DEFAULT NULL,
  `proName` varchar(255) NOT NULL,
  `price` double NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of product
-- ----------------------------
INSERT INTO `product` VALUES ('1', '2', '2019新款100%羊绒衫高领套头菱形麦穗绞花打底宽松秋冬针织毛衣女', '180');
INSERT INTO `product` VALUES ('2', '3', '男士短袖T恤打底衫 2019潮牌夏装 男装半袖男上衣', '115');
INSERT INTO `product` VALUES ('3', '1', '长袖T恤简约修身韩版纯色上衣大码女装打底衫', '89');
INSERT INTO `product` VALUES ('4', '1', '气质小翻领纯羊绒衫套头针织减龄显瘦毛衣女秋冬打底新款春天女装', '125');
INSERT INTO `product` VALUES ('5', '3', '男士上班族衬衫', '89');
INSERT INTO `product` VALUES ('6', '4', '秋季加绒加厚保暖衬衫男长袖韩版潮流休闲寸牛仔衬衣男士秋装上衣', '138');
INSERT INTO `product` VALUES ('7', '3', '男士长袖衬衫商务职业免烫修身秋季短袖正装衬衣韩版衬衫男', '89');
INSERT INTO `product` VALUES ('8', '3', ' 男士长袖T恤 秋季V领上衣 修身衣服纯色打底衫男装棉体恤', '125');
INSERT INTO `product` VALUES ('9', '1', '上衣女2019夏季薄款修身t恤短袖V领黑色打底针织衫女半袖', '79');
INSERT INTO `product` VALUES ('10', '1', '短袖雪纺衫女2019春夏新款遮肚子显瘦上衣木耳边衬衫拼接雪纺小衫', '135');
INSERT INTO `product` VALUES ('11', '4', '男士格子衬衫', '99');
INSERT INTO `product` VALUES ('12', '1', '女士背心吊带裙子', '169');
INSERT INTO `product` VALUES ('13', '3', '平纹衬衫套装高端商务白领工作服正装公司工装', '79');
INSERT INTO `product` VALUES ('14', '1', '女棉麻2019春装新款V领中长款薄衬衫宽松显瘦度假港风上衣', '119');
INSERT INTO `product` VALUES ('15', '1', '夏季新款网纱上衣女气质显瘦圆领短袖印花T恤女小衫花色外穿小衫', '149');

-- ----------------------------
-- Table structure for `receive`
-- ----------------------------
DROP TABLE IF EXISTS `receive`;
CREATE TABLE `receive` (
  `receivePkid` int(11) NOT NULL AUTO_INCREMENT,
  `userPkid` int(11) NOT NULL,
  `sheng` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `shi` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `qu` varchar(255) DEFAULT NULL,
  `userAddress` text NOT NULL,
  `userPhone` char(11) NOT NULL,
  PRIMARY KEY (`receivePkid`)
) ENGINE=InnoDB AUTO_INCREMENT=24 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of receive
-- ----------------------------
INSERT INTO `receive` VALUES ('7', '1', '湖南省', '长沙市', '芙蓉区', '农大路一号', '13737375656');
INSERT INTO `receive` VALUES ('9', '10', '湖南省', '长沙市', '芙蓉区', '农大路一号', '13737375656');
INSERT INTO `receive` VALUES ('10', '10', '山西', '晋中', '平遥县', '啊实打实', '13737375656');
INSERT INTO `receive` VALUES ('11', '12', '北京', '东城区', '', '农大路一号', '13737375656');
INSERT INTO `receive` VALUES ('12', '13', '湖南省', '长沙市', '芙蓉区', '农大路一号', '13737375656');
INSERT INTO `receive` VALUES ('13', '1', '北京', '西城区', '', '农大路一号', '13737375656');
INSERT INTO `receive` VALUES ('14', '1', '湖南省', '长沙市', '芙蓉区', '星星', '13737375656');
INSERT INTO `receive` VALUES ('15', '1', '内蒙古', '包头', '东河区', '杀手', '13737375656');
INSERT INTO `receive` VALUES ('16', '1', '吉林', '辽源', '龙山区', '农大路一号', '13737375656');
INSERT INTO `receive` VALUES ('17', '1', '山东', '枣庄', '滕州市', '农大路一号', '13737375656');
INSERT INTO `receive` VALUES ('18', '1', '河北', '秦皇岛', '海港区', '农大路一号', '13737375656');
INSERT INTO `receive` VALUES ('19', '1', '山西', '晋城', '沁水县', '农大路一号', '13737375656');
INSERT INTO `receive` VALUES ('20', '1', '广东', '清远', '连山壮族瑶族自治县', '星星', '15115479521');
INSERT INTO `receive` VALUES ('21', '1', '山西', '太原', '尖草坪区', '农大路一号', '13737375656');
INSERT INTO `receive` VALUES ('22', '15', '河北', '邯郸', '丛台区', '星星', '15115479255');
INSERT INTO `receive` VALUES ('23', '15', '山西', '阳泉', '盂县', '杀手', '13511657885');

-- ----------------------------
-- Table structure for `shopcar`
-- ----------------------------
DROP TABLE IF EXISTS `shopcar`;
CREATE TABLE `shopcar` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `userId` int(11) NOT NULL,
  `num` int(11) NOT NULL DEFAULT '0',
  `warehouseId` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=81 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of shopcar
-- ----------------------------

-- ----------------------------
-- Table structure for `size`
-- ----------------------------
DROP TABLE IF EXISTS `size`;
CREATE TABLE `size` (
  `sizePkid` int(11) NOT NULL AUTO_INCREMENT,
  `sizeType` varchar(255) NOT NULL,
  PRIMARY KEY (`sizePkid`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of size
-- ----------------------------
INSERT INTO `size` VALUES ('1', 'S');
INSERT INTO `size` VALUES ('2', 'M');
INSERT INTO `size` VALUES ('3', 'L');
INSERT INTO `size` VALUES ('4', 'XL');

-- ----------------------------
-- Table structure for `user`
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `userName` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL,
  `email` varchar(255) NOT NULL,
  `money` double NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('1', 'duan', '123', '13@qq.com', '119');
INSERT INTO `user` VALUES ('10', 'zhangsan', '123', '132@qq.com', '545');
INSERT INTO `user` VALUES ('11', 'asd', 'asd', 'vluenf30651@chacuo.net', '0');
INSERT INTO `user` VALUES ('12', '哈哈', '123456', '1529820334@qq.com', '765');
INSERT INTO `user` VALUES ('13', 'zzz', 'zxc', '135329641@qq.com', '10');
INSERT INTO `user` VALUES ('14', 'asdsd', '123', '1353296471@qq.com', '0');
INSERT INTO `user` VALUES ('15', 'zhangsan', '123', '767816260@qq.com', '178');

-- ----------------------------
-- Table structure for `warehouse`
-- ----------------------------
DROP TABLE IF EXISTS `warehouse`;
CREATE TABLE `warehouse` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `proId` int(11) NOT NULL,
  `sizeId` int(11) DEFAULT NULL,
  `colorId` int(11) NOT NULL,
  `num` int(11) NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=35 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of warehouse
-- ----------------------------
INSERT INTO `warehouse` VALUES ('1', '1', '1', '1', '9');
INSERT INTO `warehouse` VALUES ('2', '2', '1', '2', '4');
INSERT INTO `warehouse` VALUES ('3', '3', '1', '3', '18');
INSERT INTO `warehouse` VALUES ('4', '1', '2', '1', '10');
INSERT INTO `warehouse` VALUES ('5', '2', '1', '1', '2');
INSERT INTO `warehouse` VALUES ('6', '2', '2', '1', '21');
INSERT INTO `warehouse` VALUES ('7', '3', '2', '3', '5');
INSERT INTO `warehouse` VALUES ('8', '3', '1', '2', '20');
INSERT INTO `warehouse` VALUES ('9', '4', '1', '1', '5');
INSERT INTO `warehouse` VALUES ('10', '4', '2', '1', '12');
INSERT INTO `warehouse` VALUES ('11', '5', '1', '2', '7');
INSERT INTO `warehouse` VALUES ('12', '5', '2', '3', '8');
INSERT INTO `warehouse` VALUES ('13', '2', '1', '3', '13');
INSERT INTO `warehouse` VALUES ('14', '6', '2', '2', '3');
INSERT INTO `warehouse` VALUES ('15', '6', '1', '1', '12');
INSERT INTO `warehouse` VALUES ('16', '7', '1', '2', '4');
INSERT INTO `warehouse` VALUES ('17', '8', '4', '1', '5');
INSERT INTO `warehouse` VALUES ('18', '8', '4', '2', '15');
INSERT INTO `warehouse` VALUES ('19', '9', '4', '1', '7');
INSERT INTO `warehouse` VALUES ('20', '9', '4', '2', '5');
INSERT INTO `warehouse` VALUES ('21', '10', '4', '1', '6');
INSERT INTO `warehouse` VALUES ('22', '10', '4', '2', '10');
INSERT INTO `warehouse` VALUES ('23', '11', '4', '1', '9');
INSERT INTO `warehouse` VALUES ('24', '11', '4', '3', '5');
INSERT INTO `warehouse` VALUES ('25', '15', '4', '2', '3');
INSERT INTO `warehouse` VALUES ('26', '12', '1', '2', '6');
INSERT INTO `warehouse` VALUES ('27', '12', '1', '1', '2');
INSERT INTO `warehouse` VALUES ('28', '13', '2', '1', '4');
INSERT INTO `warehouse` VALUES ('29', '13', '2', '1', '11');
INSERT INTO `warehouse` VALUES ('30', '14', '1', '1', '13');
INSERT INTO `warehouse` VALUES ('31', '14', '1', '2', '2');
INSERT INTO `warehouse` VALUES ('32', '14', '2', '1', '2');
INSERT INTO `warehouse` VALUES ('33', '7', '2', '1', '4');
INSERT INTO `warehouse` VALUES ('34', '15', '4', '1', '2');

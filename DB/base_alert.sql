/*
 Navicat Premium Data Transfer

 Source Server         : localhost_3306
 Source Server Type    : MySQL
 Source Server Version : 80029
 Source Host           : localhost:3306
 Source Schema         : chest

 Target Server Type    : MySQL
 Target Server Version : 80029
 File Encoding         : 65001

 Date: 23/02/2023 11:10:27
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for base_alert
-- ----------------------------
DROP TABLE IF EXISTS `base_alert`;
CREATE TABLE `base_alert`  (
  `id` bigint NOT NULL COMMENT '主键',
  `box_code` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_zh_0900_as_cs NULL DEFAULT NULL COMMENT '钥匙柜编号',
  `box_name` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_zh_0900_as_cs NULL DEFAULT NULL COMMENT '钥匙柜名称',
  `key_code` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_zh_0900_as_cs NULL DEFAULT NULL COMMENT '钥匙编号',
  `key_name` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_zh_0900_as_cs NULL DEFAULT NULL COMMENT '钥匙名称',
  `type` tinyint NULL DEFAULT NULL COMMENT '告警类型',
  `alert_time` datetime NULL DEFAULT NULL COMMENT '告警时间',
  `status` tinyint NULL DEFAULT NULL COMMENT '处理状态1已处理2未处理',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_zh_0900_as_cs COMMENT = '告警信息' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of base_alert
-- ----------------------------
INSERT INTO `base_alert` VALUES (748734986831527936, '1', '1', '0', '0', 2, '2023-02-23 10:45:32', 2);

SET FOREIGN_KEY_CHECKS = 1;

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

 Date: 23/02/2023 11:10:20
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for base_box
-- ----------------------------
DROP TABLE IF EXISTS `base_box`;
CREATE TABLE `base_box`  (
  `box_id` bigint NOT NULL COMMENT '柜子主键',
  `name` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_zh_0900_as_cs NULL DEFAULT NULL COMMENT '名称',
  `code` smallint NULL DEFAULT NULL COMMENT '编号',
  `key_count` int NULL DEFAULT NULL COMMENT '钥匙数量',
  `status` tinyint NULL DEFAULT NULL COMMENT '状态',
  `location` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_zh_0900_as_cs NULL DEFAULT NULL COMMENT '位置信息',
  `remark` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '备注',
  `ter_id` bigint NOT NULL COMMENT '终端主键',
  `ter_code` smallint NULL DEFAULT NULL COMMENT '终端编号',
  PRIMARY KEY (`box_id`) USING BTREE,
  UNIQUE INDEX `box_id_index`(`box_id` ASC) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_zh_0900_as_cs COMMENT = '钥匙柜' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of base_box
-- ----------------------------
INSERT INTO `base_box` VALUES (531646483640881152, '1', 1, 50, NULL, NULL, NULL, 475091061505527808, 2);

SET FOREIGN_KEY_CHECKS = 1;

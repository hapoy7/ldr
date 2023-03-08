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

 Date: 23/02/2023 11:10:06
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for base_operation
-- ----------------------------
DROP TABLE IF EXISTS `base_operation`;
CREATE TABLE `base_operation`  (
  `id` bigint NOT NULL COMMENT '主键',
  `user_number` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_zh_0900_as_cs NULL DEFAULT NULL COMMENT '用户编号',
  `user_name` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_zh_0900_as_cs NULL DEFAULT NULL COMMENT '用户名',
  `opt_time` datetime NULL DEFAULT NULL COMMENT '操作时间',
  `box_code` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_zh_0900_as_cs NULL DEFAULT NULL COMMENT '钥匙柜编号',
  `box_name` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_zh_0900_as_cs NULL DEFAULT NULL COMMENT '钥匙柜名称',
  `key_code` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_zh_0900_as_cs NULL DEFAULT NULL COMMENT '钥匙编号',
  `key_name` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_zh_0900_as_cs NULL DEFAULT NULL COMMENT '钥匙名称',
  `type` tinyint NULL DEFAULT NULL COMMENT '操作类型',
  `user_id` bigint NOT NULL COMMENT '用户id',
  `box_id` bigint NOT NULL COMMENT '钥匙柜id',
  `key_id` bigint NOT NULL COMMENT '钥匙id',
  `status` tinyint(1) NULL DEFAULT NULL COMMENT '处理状态',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_zh_0900_as_cs COMMENT = '操作日志' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of base_operation
-- ----------------------------
INSERT INTO `base_operation` VALUES (748734855595950080, '1074', '赵六', '2023-02-23 10:45:00', '1', '1', '2', '2', 1, 479342929731653774, 531646483640881152, 531646666512535552, 2);
INSERT INTO `base_operation` VALUES (748734986688921600, '0', '还钥匙', '2023-02-23 10:45:32', '1', '1', '2', '2', 2, 0, 531646483640881152, 531646666512535552, 2);

SET FOREIGN_KEY_CHECKS = 1;

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

 Date: 23/02/2023 11:09:59
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for base_permission
-- ----------------------------
DROP TABLE IF EXISTS `base_permission`;
CREATE TABLE `base_permission`  (
  `id` bigint NOT NULL COMMENT '主键',
  `user_id` bigint NOT NULL COMMENT '用户主键',
  `key_id` bigint NOT NULL COMMENT '钥匙主键',
  `use_time` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_zh_0900_as_cs NULL DEFAULT NULL COMMENT '使用时间',
  `is_apply` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_zh_0900_as_cs NULL DEFAULT NULL,
  `is_temp` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_zh_0900_as_cs NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_zh_0900_as_cs COMMENT = '授权表' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of base_permission
-- ----------------------------
INSERT INTO `base_permission` VALUES (548930026834235392, 479342929731653772, 531646666051162112, '02 23 2023 12:00AM - 02 23 2023 12:00AM', 'true', 'false');
INSERT INTO `base_permission` VALUES (548930091854336000, 479342929731653772, 531646666512535552, '02 23 2023 12:00AM - 02 24 2023 12:00AM', 'false', 'true');
INSERT INTO `base_permission` VALUES (548930091854336001, 479342929731653774, 531646666512535552, '02 23 2023 12:00AM - 02 24 2023 12:00AM', 'false', 'true');

SET FOREIGN_KEY_CHECKS = 1;

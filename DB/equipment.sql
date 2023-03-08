/*
 Navicat Premium Data Transfer

 Source Server         : 192.168.1.30
 Source Server Type    : MySQL
 Source Server Version : 80031
 Source Host           : 192.168.1.30:3306
 Source Schema         : equipment

 Target Server Type    : MySQL
 Target Server Version : 80031
 File Encoding         : 65001

 Date: 17/02/2023 18:27:51
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for base_attachment
-- ----------------------------
DROP TABLE IF EXISTS `base_attachment`;
CREATE TABLE `base_attachment`  (
  `id` bigint NOT NULL COMMENT '主键',
  `table_name` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_zh_0900_as_cs NULL DEFAULT NULL COMMENT '表名',
  `table_id` bigint NULL DEFAULT NULL COMMENT '表记录主键',
  `attachment_url` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_zh_0900_as_cs NULL DEFAULT NULL COMMENT '附件',
  `order_number` tinyint NULL DEFAULT NULL COMMENT '顺序号',
  `create_time` datetime NULL DEFAULT NULL COMMENT '创建时间',
  `create_by` bigint NULL DEFAULT NULL COMMENT '创建人ID',
  `update_time` datetime NULL DEFAULT NULL COMMENT '修改时间',
  `update_by` bigint NULL DEFAULT NULL COMMENT '修改人ID',
  `dr` tinyint NOT NULL COMMENT '删除标记',
  `remark` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_zh_0900_as_cs COMMENT = '附件' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of base_attachment
-- ----------------------------

-- ----------------------------
-- Table structure for equ_alert
-- ----------------------------
DROP TABLE IF EXISTS `equ_alert`;
CREATE TABLE `equ_alert`  (
  `id` bigint NOT NULL COMMENT '主键',
  `device_id` bigint NULL DEFAULT NULL COMMENT '设备主键',
  `alert_type` tinyint NULL DEFAULT NULL COMMENT '告警类型',
  `device_name` varchar(80) CHARACTER SET utf8mb4 COLLATE utf8mb4_zh_0900_as_cs NULL DEFAULT NULL COMMENT '设备名称',
  `device_type` tinyint NULL DEFAULT NULL COMMENT '设备类型',
  `alert_time` datetime NULL DEFAULT NULL COMMENT '告警时间',
  `create_time` datetime NULL DEFAULT NULL COMMENT '创建时间',
  `create_by` bigint NULL DEFAULT NULL COMMENT '创建人ID',
  `update_time` datetime NULL DEFAULT NULL COMMENT '修改时间',
  `update_by` bigint NULL DEFAULT NULL COMMENT '修改人ID',
  `dr` tinyint NOT NULL COMMENT '删除标记',
  `remark` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `FK_Reference_3`(`device_id` ASC) USING BTREE,
  CONSTRAINT `FK_Reference_3` FOREIGN KEY (`device_id`) REFERENCES `equ_device` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_zh_0900_as_cs COMMENT = '设备告警记录' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of equ_alert
-- ----------------------------
INSERT INTO `equ_alert` VALUES (1, 1, 1, '内燃叉车', 1, '2023-02-16 14:21:22', '2023-02-16 14:21:27', 10000, NULL, NULL, 0, '测试数据');

-- ----------------------------
-- Table structure for equ_device
-- ----------------------------
DROP TABLE IF EXISTS `equ_device`;
CREATE TABLE `equ_device`  (
  `id` bigint NOT NULL COMMENT '主键',
  `device_type_id` bigint NULL DEFAULT NULL COMMENT '设备类型主键',
  `segment_id` bigint NULL DEFAULT NULL COMMENT '所属车辆段主键',
  `line_id` bigint NULL DEFAULT NULL COMMENT '所属线路主键',
  `name` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_zh_0900_as_cs NULL DEFAULT NULL COMMENT '名称',
  `status` tinyint NULL DEFAULT NULL COMMENT '状态',
  `code` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_zh_0900_as_cs NULL DEFAULT NULL COMMENT '编号',
  `gz_code` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_zh_0900_as_cs NULL DEFAULT NULL COMMENT '固资编号',
  `sn_label` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_zh_0900_as_cs NULL DEFAULT NULL COMMENT '标签编码',
  `make_time` date NULL DEFAULT NULL COMMENT '制造日期',
  `start_time` datetime NULL DEFAULT NULL COMMENT '启用日期',
  `create_time` datetime NULL DEFAULT NULL COMMENT '创建时间',
  `create_by` bigint NULL DEFAULT NULL COMMENT '创建人ID',
  `update_time` datetime NULL DEFAULT NULL COMMENT '修改时间',
  `update_by` bigint NULL DEFAULT NULL COMMENT '修改人ID',
  `dr` tinyint NOT NULL COMMENT '删除标记',
  `remark` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `FK_Reference_1`(`device_type_id` ASC) USING BTREE,
  CONSTRAINT `FK_Reference_1` FOREIGN KEY (`device_type_id`) REFERENCES `equ_type` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_zh_0900_as_cs COMMENT = '设备' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of equ_device
-- ----------------------------
INSERT INTO `equ_device` VALUES (1, 1, 1, 1, '内燃叉车', 1, '1', '1', '1', '2022-07-01', '2023-02-16 14:22:39', '2023-02-16 14:22:42', 10000, NULL, NULL, 0, '测试数据');

-- ----------------------------
-- Table structure for equ_plan
-- ----------------------------
DROP TABLE IF EXISTS `equ_plan`;
CREATE TABLE `equ_plan`  (
  `id` bigint NOT NULL COMMENT '主键',
  `device_rules_id` bigint NULL DEFAULT NULL COMMENT '规程主键',
  `device_id` bigint NULL DEFAULT NULL COMMENT '设备主键',
  `name` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_zh_0900_as_cs NULL DEFAULT NULL COMMENT '名称',
  `status` tinyint NULL DEFAULT NULL COMMENT '状态',
  `dev_year` date NULL DEFAULT NULL COMMENT '保养年度',
  `start_time` date NULL DEFAULT NULL COMMENT '开始日期',
  `end_time` date NULL DEFAULT NULL COMMENT '结束日期',
  `rules_type_text` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_zh_0900_as_cs NULL DEFAULT NULL COMMENT '规程类型',
  `type_number` tinyint NULL DEFAULT NULL COMMENT '季月周编号',
  `strategy_status` tinyint NULL DEFAULT NULL COMMENT '提醒状态',
  `create_time` datetime NULL DEFAULT NULL COMMENT '创建时间',
  `create_by` bigint NULL DEFAULT NULL COMMENT '创建人ID',
  `update_time` datetime NULL DEFAULT NULL COMMENT '修改时间',
  `update_by` bigint NULL DEFAULT NULL COMMENT '修改人ID',
  `dr` tinyint NOT NULL COMMENT '删除标记',
  `remark` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `FK_Reference_15`(`device_rules_id` ASC) USING BTREE,
  INDEX `FK_Reference_29`(`device_id` ASC) USING BTREE,
  CONSTRAINT `FK_Reference_15` FOREIGN KEY (`device_rules_id`) REFERENCES `equ_rules` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `FK_Reference_29` FOREIGN KEY (`device_id`) REFERENCES `equ_device` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_zh_0900_as_cs COMMENT = '设备维保计划' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of equ_plan
-- ----------------------------
INSERT INTO `equ_plan` VALUES (1, 1, 1, '拍照', 0, '2023-02-16', '2023-01-01', '2023-02-16', '1', 1, 1, '2023-02-16 14:25:34', 1000, NULL, NULL, 0, '测试数据');

-- ----------------------------
-- Table structure for equ_repair
-- ----------------------------
DROP TABLE IF EXISTS `equ_repair`;
CREATE TABLE `equ_repair`  (
  `id` bigint NOT NULL COMMENT '主键',
  `device_id` bigint NULL DEFAULT NULL COMMENT '设备主键',
  `fix_user_id` bigint NULL DEFAULT NULL COMMENT '维修人id',
  `fix_time` datetime NULL DEFAULT NULL COMMENT '送修时间',
  `status` tinyint NULL DEFAULT NULL COMMENT '维修状态',
  `report_time` datetime NULL DEFAULT NULL COMMENT '故障时间',
  `fix_days` int NULL DEFAULT NULL COMMENT '送修时长',
  `fix_farctory` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_zh_0900_as_cs NULL DEFAULT NULL COMMENT '维保厂家',
  `quality_user_id` bigint NULL DEFAULT NULL COMMENT '质检人id',
  `quality_time` datetime NULL DEFAULT NULL COMMENT '质检时间',
  `create_time` datetime NULL DEFAULT NULL COMMENT '创建时间',
  `create_by` bigint NULL DEFAULT NULL COMMENT '创建人ID',
  `update_time` datetime NULL DEFAULT NULL COMMENT '修改时间',
  `update_by` bigint NULL DEFAULT NULL COMMENT '修改人ID',
  `dr` tinyint NOT NULL COMMENT '删除标记',
  `remark` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `FK_Reference_4`(`device_id` ASC) USING BTREE,
  CONSTRAINT `FK_Reference_4` FOREIGN KEY (`device_id`) REFERENCES `equ_device` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_zh_0900_as_cs COMMENT = '设备维修记录' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of equ_repair
-- ----------------------------
INSERT INTO `equ_repair` VALUES (1, 1, 1, '2023-02-16 14:28:35', 1, '2023-02-16 14:27:39', 3, '1', 10000, '2023-02-16 14:28:06', '2023-02-16 14:28:08', 10000, NULL, NULL, 0, '测试数据');

-- ----------------------------
-- Table structure for equ_rules
-- ----------------------------
DROP TABLE IF EXISTS `equ_rules`;
CREATE TABLE `equ_rules`  (
  `id` bigint NOT NULL COMMENT '主键',
  `equ_type_id` bigint NULL DEFAULT NULL COMMENT '设备类型主键',
  `rule_type_id` bigint NULL DEFAULT NULL COMMENT '规程类型主键',
  `name` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_zh_0900_as_cs NULL DEFAULT NULL COMMENT '名称',
  `status` tinyint NULL DEFAULT NULL COMMENT '状态',
  `create_time` datetime NULL DEFAULT NULL COMMENT '创建时间',
  `create_by` bigint NULL DEFAULT NULL COMMENT '创建人主键',
  `update_time` datetime NULL DEFAULT NULL COMMENT '修改时间',
  `update_by` bigint NULL DEFAULT NULL COMMENT '修改人ID',
  `dr` tinyint NOT NULL COMMENT '删除标记',
  `remark` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `FK_Reference_21`(`rule_type_id` ASC) USING BTREE,
  INDEX `FK_Reference_7`(`equ_type_id` ASC) USING BTREE,
  CONSTRAINT `FK_Reference_21` FOREIGN KEY (`rule_type_id`) REFERENCES `rule_type` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `FK_Reference_7` FOREIGN KEY (`equ_type_id`) REFERENCES `equ_type` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_zh_0900_as_cs COMMENT = '设备规程' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of equ_rules
-- ----------------------------
INSERT INTO `equ_rules` VALUES (1, 1029, 1, '周检', 1, '2023-02-16 14:26:26', 10000, NULL, NULL, 0, '测试数据');

-- ----------------------------
-- Table structure for equ_rules_item
-- ----------------------------
DROP TABLE IF EXISTS `equ_rules_item`;
CREATE TABLE `equ_rules_item`  (
  `id` bigint NOT NULL COMMENT '主键',
  `equ_rules_id` bigint NULL DEFAULT NULL COMMENT '规程主键',
  `rule_define_id` bigint NULL DEFAULT NULL COMMENT '规程定义主键',
  `content` varchar(500) CHARACTER SET utf8mb4 COLLATE utf8mb4_zh_0900_as_cs NULL DEFAULT NULL COMMENT '维保内容',
  `type` tinyint NULL DEFAULT NULL COMMENT '分类',
  `create_time` datetime NULL DEFAULT NULL COMMENT '创建时间',
  `create_by` bigint NULL DEFAULT NULL COMMENT '创建人ID',
  `update_time` datetime NULL DEFAULT NULL COMMENT '修改时间',
  `update_by` bigint NULL DEFAULT NULL COMMENT '修改人ID',
  `dr` tinyint NOT NULL COMMENT '删除标记',
  `remark` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `FK_Reference_23`(`equ_rules_id` ASC) USING BTREE,
  INDEX `FK_Reference_26`(`rule_define_id` ASC) USING BTREE,
  CONSTRAINT `FK_Reference_23` FOREIGN KEY (`equ_rules_id`) REFERENCES `equ_rules` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `FK_Reference_26` FOREIGN KEY (`rule_define_id`) REFERENCES `rule_define` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_zh_0900_as_cs COMMENT = '设备规程条目' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of equ_rules_item
-- ----------------------------
INSERT INTO `equ_rules_item` VALUES (1, 1, 1, '1', 1, '2023-02-16 14:28:50', 10000, NULL, NULL, 0, '测试数据');

-- ----------------------------
-- Table structure for equ_type
-- ----------------------------
DROP TABLE IF EXISTS `equ_type`;
CREATE TABLE `equ_type`  (
  `id` bigint NOT NULL COMMENT '主键',
  `name` varchar(80) CHARACTER SET utf8mb4 COLLATE utf8mb4_zh_0900_as_cs NULL DEFAULT NULL COMMENT '名称',
  `code` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_zh_0900_as_cs NULL DEFAULT NULL COMMENT '编码',
  `factory` tinyint NULL DEFAULT NULL COMMENT '生产厂商',
  `parent_id` bigint NULL DEFAULT NULL COMMENT '上级主键',
  `leaf` tinyint NULL DEFAULT NULL COMMENT '是否叶子',
  `create_time` datetime NULL DEFAULT NULL COMMENT '创建时间',
  `create_by` bigint NULL DEFAULT NULL COMMENT '创建人ID',
  `update_time` datetime NULL DEFAULT NULL COMMENT '修改时间',
  `update_by` bigint NULL DEFAULT NULL COMMENT '修改人ID',
  `dr` tinyint NOT NULL COMMENT '删除标记',
  `remark` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_zh_0900_as_cs COMMENT = '设备分类' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of equ_type
-- ----------------------------
INSERT INTO `equ_type` VALUES (1, '设备', '1', 1, 0, 0, '2023-02-16 14:23:38', 10000, NULL, NULL, 0, '测试数据');
INSERT INTO `equ_type` VALUES (100, '起重机', NULL, NULL, 0, 0, NULL, NULL, NULL, NULL, 0, NULL);
INSERT INTO `equ_type` VALUES (200, '系统', NULL, NULL, 0, 0, NULL, NULL, NULL, NULL, 0, NULL);
INSERT INTO `equ_type` VALUES (300, '其它设备', NULL, NULL, 0, 0, NULL, NULL, NULL, NULL, 0, NULL);
INSERT INTO `equ_type` VALUES (1000, '电动单梁桥式起重机', NULL, NULL, 100, 0, NULL, NULL, NULL, NULL, 0, NULL);
INSERT INTO `equ_type` VALUES (1003, '电动双梁桥式起重机', NULL, NULL, 100, 0, NULL, NULL, NULL, NULL, 0, NULL);
INSERT INTO `equ_type` VALUES (1004, '电动单梁悬挂式起重机', NULL, NULL, 100, 0, NULL, NULL, NULL, NULL, 0, NULL);
INSERT INTO `equ_type` VALUES (1008, '轮对尺寸动态检测系统', NULL, NULL, 200, 0, NULL, NULL, NULL, NULL, 0, NULL);
INSERT INTO `equ_type` VALUES (1009, '平轮在线检测系统', NULL, NULL, 200, 0, NULL, NULL, NULL, NULL, 0, NULL);
INSERT INTO `equ_type` VALUES (1010, '受电弓动态检测系统', NULL, NULL, 200, 0, NULL, NULL, NULL, NULL, 0, NULL);
INSERT INTO `equ_type` VALUES (1011, '动态图像综合检测系统', NULL, NULL, 200, 0, NULL, NULL, NULL, NULL, 0, NULL);
INSERT INTO `equ_type` VALUES (1012, '全自动电动库门', NULL, NULL, 200, 0, NULL, NULL, NULL, NULL, 0, NULL);
INSERT INTO `equ_type` VALUES (1013, '数控不落轮对车床', NULL, NULL, 200, 0, NULL, NULL, NULL, NULL, 0, NULL);
INSERT INTO `equ_type` VALUES (1014, '中央吸尘系统', NULL, NULL, 300, 0, NULL, NULL, NULL, NULL, 0, NULL);
INSERT INTO `equ_type` VALUES (1015, '自动化立体仓储设备', NULL, NULL, 300, 0, NULL, NULL, NULL, NULL, 0, NULL);
INSERT INTO `equ_type` VALUES (1016, '固定式架车机', NULL, NULL, 300, 0, NULL, NULL, NULL, NULL, 0, NULL);
INSERT INTO `equ_type` VALUES (1017, '移动式架车机', NULL, NULL, 300, 0, NULL, NULL, NULL, NULL, 0, NULL);
INSERT INTO `equ_type` VALUES (1018, '列车自动清洗机', NULL, NULL, 300, 0, NULL, NULL, NULL, NULL, 0, NULL);
INSERT INTO `equ_type` VALUES (1019, '数控车轮车床', NULL, NULL, 300, 0, NULL, NULL, NULL, NULL, 0, NULL);
INSERT INTO `equ_type` VALUES (1020, '转向架静载试验台', NULL, NULL, 300, 0, NULL, NULL, NULL, NULL, 0, NULL);
INSERT INTO `equ_type` VALUES (1021, '上体称重设备', NULL, NULL, 300, 0, NULL, NULL, NULL, NULL, 0, NULL);
INSERT INTO `equ_type` VALUES (1022, '移动式称重', NULL, NULL, 300, 0, NULL, NULL, NULL, NULL, 0, NULL);
INSERT INTO `equ_type` VALUES (1023, '便携式车轮检测仪', NULL, NULL, 300, 0, NULL, NULL, NULL, NULL, 0, NULL);
INSERT INTO `equ_type` VALUES (1024, '便携式电机综合检测设备', NULL, NULL, 300, 0, NULL, NULL, NULL, NULL, 0, NULL);
INSERT INTO `equ_type` VALUES (1025, '移动式实心轴相控阵探伤机', NULL, NULL, 300, 0, NULL, NULL, NULL, NULL, 0, NULL);
INSERT INTO `equ_type` VALUES (1026, '自动恒流恒压充放电机', NULL, NULL, 300, 0, NULL, NULL, NULL, NULL, 0, NULL);
INSERT INTO `equ_type` VALUES (1027, '车底设备拆装设备', NULL, NULL, 300, 0, NULL, NULL, NULL, NULL, 0, NULL);
INSERT INTO `equ_type` VALUES (1028, '公铁两用车', NULL, NULL, 300, 0, NULL, NULL, NULL, NULL, 0, NULL);
INSERT INTO `equ_type` VALUES (1029, 'CXTS5t-12.5m-9m', NULL, NULL, 1000, 1, NULL, NULL, NULL, NULL, 0, NULL);
INSERT INTO `equ_type` VALUES (1030, 'CXTS5t-15m-9m', NULL, NULL, 1000, 1, NULL, NULL, NULL, NULL, 0, NULL);
INSERT INTO `equ_type` VALUES (1031, 'CXTS5t-16.5m-9m', NULL, NULL, 1000, 1, NULL, NULL, NULL, NULL, 0, NULL);
INSERT INTO `equ_type` VALUES (1032, 'CXTD10t-14.7m-9m', NULL, NULL, 1003, 1, NULL, NULL, NULL, NULL, 0, NULL);
INSERT INTO `equ_type` VALUES (1033, 'CXTU3t-8m-9m', NULL, NULL, 1004, 1, NULL, NULL, NULL, NULL, 0, NULL);
INSERT INTO `equ_type` VALUES (1034, 'CXTD20t-16.3m-10m', NULL, NULL, 1003, 1, NULL, NULL, NULL, NULL, 0, NULL);
INSERT INTO `equ_type` VALUES (1035, 'CXTD10t-16.3m-10m', NULL, NULL, 1003, 1, NULL, NULL, NULL, NULL, 0, NULL);
INSERT INTO `equ_type` VALUES (1036, 'CXTS5t-10.3m-9m', NULL, NULL, 1000, 1, NULL, NULL, NULL, NULL, 0, NULL);
INSERT INTO `equ_type` VALUES (1037, 'HTK-WD16', NULL, NULL, 1008, 1, NULL, NULL, NULL, NULL, 0, NULL);
INSERT INTO `equ_type` VALUES (1038, 'HTK-95P', NULL, NULL, 1009, 1, NULL, NULL, NULL, NULL, 0, NULL);
INSERT INTO `equ_type` VALUES (1039, 'PSDG', NULL, NULL, 1010, 1, NULL, NULL, NULL, NULL, 0, NULL);
INSERT INTO `equ_type` VALUES (1040, 'PSFIDS', NULL, NULL, 1011, 1, NULL, NULL, NULL, NULL, 0, NULL);
INSERT INTO `equ_type` VALUES (1041, '4.2*5.4/5.7', NULL, NULL, 1012, 1, NULL, NULL, NULL, NULL, 0, NULL);
INSERT INTO `equ_type` VALUES (1042, 'TUP650SH', NULL, NULL, 1013, 1, NULL, NULL, NULL, NULL, 0, NULL);
INSERT INTO `equ_type` VALUES (1043, '非标', NULL, NULL, 1014, 1, NULL, NULL, NULL, NULL, 0, NULL);
INSERT INTO `equ_type` VALUES (1044, '非标', NULL, NULL, 1015, 1, NULL, NULL, NULL, NULL, 0, NULL);
INSERT INTO `equ_type` VALUES (1045, '非标', NULL, NULL, 1016, 1, NULL, NULL, NULL, NULL, 0, NULL);
INSERT INTO `equ_type` VALUES (1046, '非标', NULL, NULL, 1017, 1, NULL, NULL, NULL, NULL, 0, NULL);
INSERT INTO `equ_type` VALUES (1047, '非标', NULL, NULL, 1018, 1, NULL, NULL, NULL, NULL, 0, NULL);
INSERT INTO `equ_type` VALUES (1048, 'TUU1250', NULL, NULL, 1019, 1, NULL, NULL, NULL, NULL, 0, NULL);
INSERT INTO `equ_type` VALUES (1049, 'HT30', NULL, NULL, 1020, 1, NULL, NULL, NULL, NULL, 0, NULL);
INSERT INTO `equ_type` VALUES (1050, 'ELAS-m', NULL, NULL, 1021, 1, NULL, NULL, NULL, NULL, 0, NULL);
INSERT INTO `equ_type` VALUES (1051, 'LARS-m', NULL, NULL, 1022, 1, NULL, NULL, NULL, NULL, 0, NULL);
INSERT INTO `equ_type` VALUES (1052, 'CALIPRI C42', NULL, NULL, 1023, 1, NULL, NULL, NULL, NULL, 0, NULL);
INSERT INTO `equ_type` VALUES (1053, 'TM-CE5000', NULL, NULL, 1024, 1, NULL, NULL, NULL, NULL, 0, NULL);
INSERT INTO `equ_type` VALUES (1054, 'LZM', NULL, NULL, 1025, 1, NULL, NULL, NULL, NULL, 0, NULL);
INSERT INTO `equ_type` VALUES (1055, 'WMCF-3D', NULL, NULL, 1026, 1, NULL, NULL, NULL, NULL, 0, NULL);
INSERT INTO `equ_type` VALUES (1056, 'QZJZC3', NULL, NULL, 1027, 1, NULL, NULL, NULL, NULL, 0, NULL);
INSERT INTO `equ_type` VALUES (1057, 'RTT-2000', NULL, NULL, 1028, 1, NULL, NULL, NULL, NULL, 0, NULL);

-- ----------------------------
-- Table structure for equ_use
-- ----------------------------
DROP TABLE IF EXISTS `equ_use`;
CREATE TABLE `equ_use`  (
  `id` bigint NOT NULL COMMENT '主键',
  `device_id` bigint NULL DEFAULT NULL COMMENT '设备主键',
  `duration` float NULL DEFAULT NULL COMMENT '使用时长',
  `start_time` datetime NULL DEFAULT NULL COMMENT '开始时间',
  `operator_id` bigint NULL DEFAULT NULL COMMENT '操作人',
  `approver_id` bigint NULL DEFAULT NULL COMMENT '审批人',
  `use_area` tinyint NULL DEFAULT NULL COMMENT '使用区域',
  `back_description` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_zh_0900_as_cs NULL DEFAULT NULL COMMENT '归还说明',
  `back_time` datetime NULL DEFAULT NULL COMMENT '归还时间',
  `back_area` tinyint NULL DEFAULT NULL COMMENT '归还区域',
  `use_description` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_zh_0900_as_cs NULL DEFAULT NULL COMMENT '使用说明',
  `create_time` datetime NULL DEFAULT NULL COMMENT '创建时间',
  `create_by` bigint NULL DEFAULT NULL COMMENT '创建人ID',
  `update_time` datetime NULL DEFAULT NULL COMMENT '修改时间',
  `update_by` bigint NULL DEFAULT NULL COMMENT '修改人ID',
  `dr` tinyint NOT NULL COMMENT '删除标记',
  `remark` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `FK_Reference_16`(`device_id` ASC) USING BTREE,
  CONSTRAINT `FK_Reference_16` FOREIGN KEY (`device_id`) REFERENCES `equ_device` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_zh_0900_as_cs COMMENT = '设备使用记录' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of equ_use
-- ----------------------------
INSERT INTO `equ_use` VALUES (1, 1, 100, '2022-11-01 14:32:22', 10000, 10000, 1, '完璧归还', '2023-02-16 14:32:56', 1, '使用说明', '2023-02-16 14:33:16', 10000, NULL, NULL, 0, '测试数据');

-- ----------------------------
-- Table structure for order_record
-- ----------------------------
DROP TABLE IF EXISTS `order_record`;
CREATE TABLE `order_record`  (
  `id` bigint NOT NULL COMMENT '主键',
  `device_plan_id` bigint NULL DEFAULT NULL COMMENT '计划主键',
  `code` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_zh_0900_as_cs NULL DEFAULT NULL COMMENT '工单编号',
  `order_type` tinyint NULL DEFAULT NULL COMMENT '工单类型',
  `name` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_zh_0900_as_cs NULL DEFAULT NULL COMMENT '工单名称',
  `dev_type` tinyint NULL DEFAULT NULL COMMENT '保养类型',
  `status` tinyint NULL DEFAULT NULL COMMENT '状态',
  `create_time` datetime NULL DEFAULT NULL COMMENT '创建时间',
  `create_by` bigint NULL DEFAULT NULL COMMENT '创建人ID',
  `update_time` datetime NULL DEFAULT NULL COMMENT '修改时间',
  `update_by` bigint NULL DEFAULT NULL COMMENT '修改人ID',
  `dr` tinyint NOT NULL COMMENT '删除标记',
  `remark` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `FK_Reference_13`(`device_plan_id` ASC) USING BTREE,
  CONSTRAINT `FK_Reference_13` FOREIGN KEY (`device_plan_id`) REFERENCES `equ_plan` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_zh_0900_as_cs COMMENT = '工单记录' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of order_record
-- ----------------------------
INSERT INTO `order_record` VALUES (1, 1, '1', 1, '工单-001', 1, 1, '2023-02-16 14:31:53', 10000, NULL, NULL, 0, '测试数据');

-- ----------------------------
-- Table structure for order_record_detail
-- ----------------------------
DROP TABLE IF EXISTS `order_record_detail`;
CREATE TABLE `order_record_detail`  (
  `id` bigint NOT NULL COMMENT '主键',
  `rules_item_id` bigint NULL DEFAULT NULL COMMENT '规程内容主键',
  `order_record_id` bigint NULL DEFAULT NULL COMMENT '工单记录主键',
  `data_type` tinyint NULL DEFAULT NULL COMMENT '数据类型',
  `field_value` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_zh_0900_as_cs NULL DEFAULT NULL COMMENT '字段值',
  `create_time` datetime NULL DEFAULT NULL COMMENT '创建时间',
  `create_by` bigint NULL DEFAULT NULL COMMENT '创建人ID',
  `update_time` datetime NULL DEFAULT NULL COMMENT '修改时间',
  `update_by` bigint NULL DEFAULT NULL COMMENT '修改人ID',
  `dr` tinyint NOT NULL COMMENT '删除标记',
  `remark` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `FK_Reference_27`(`rules_item_id` ASC) USING BTREE,
  INDEX `FK_Reference_28`(`order_record_id` ASC) USING BTREE,
  CONSTRAINT `FK_Reference_27` FOREIGN KEY (`rules_item_id`) REFERENCES `equ_rules_item` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `FK_Reference_28` FOREIGN KEY (`order_record_id`) REFERENCES `order_record` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_zh_0900_as_cs COMMENT = '工单记录明细' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of order_record_detail
-- ----------------------------
INSERT INTO `order_record_detail` VALUES (1, 1, 1, 1, '1', '2023-02-16 14:31:14', 10000, NULL, NULL, 0, '测试数据');

-- ----------------------------
-- Table structure for rule_define
-- ----------------------------
DROP TABLE IF EXISTS `rule_define`;
CREATE TABLE `rule_define`  (
  `id` bigint NOT NULL COMMENT '主键',
  `type_id` bigint NULL DEFAULT NULL COMMENT '设备分类主键',
  `content` varchar(500) CHARACTER SET utf8mb4 COLLATE utf8mb4_zh_0900_as_cs NULL DEFAULT NULL COMMENT '维保内容',
  `type` tinyint NULL DEFAULT NULL COMMENT '分类',
  `create_time` datetime NULL DEFAULT NULL COMMENT '创建时间',
  `create_by` bigint NULL DEFAULT NULL COMMENT '创建人ID',
  `update_time` datetime NULL DEFAULT NULL COMMENT '修改时间',
  `update_by` bigint NULL DEFAULT NULL COMMENT '修改人ID',
  `dr` tinyint NOT NULL COMMENT '删除标记',
  `remark` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `FK_Reference_22`(`type_id` ASC) USING BTREE,
  CONSTRAINT `FK_Reference_22` FOREIGN KEY (`type_id`) REFERENCES `equ_type` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_zh_0900_as_cs COMMENT = '规程定义' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of rule_define
-- ----------------------------
INSERT INTO `rule_define` VALUES (1, 1029, '1', 1, '2023-02-16 14:29:22', 10000, NULL, NULL, 0, '测试数据');
INSERT INTO `rule_define` VALUES (746322654226546688, 1029, '1', 1, '2023-02-16 18:59:47', NULL, NULL, NULL, 0, '1');
INSERT INTO `rule_define` VALUES (746326883880140800, 1029, '21312321', 2, '2023-02-16 19:16:35', NULL, NULL, NULL, 0, '213123213');
INSERT INTO `rule_define` VALUES (746327005540122624, 1029, '1111', 3, '2023-02-16 19:17:04', NULL, NULL, NULL, 0, '1111');
INSERT INTO `rule_define` VALUES (746330278259064832, NULL, '33', 33, '2023-02-16 19:30:04', NULL, NULL, NULL, 0, '33');
INSERT INTO `rule_define` VALUES (746330599035240448, 1029, '44', 44, '2023-02-16 19:31:21', NULL, NULL, NULL, 0, '44');
INSERT INTO `rule_define` VALUES (746330823438893056, 1029, '55', 55, '2023-02-16 19:32:14', NULL, NULL, NULL, 0, '55');

-- ----------------------------
-- Table structure for rule_detail_define
-- ----------------------------
DROP TABLE IF EXISTS `rule_detail_define`;
CREATE TABLE `rule_detail_define`  (
  `id` bigint NOT NULL COMMENT '主键',
  `rule_define_id` bigint NULL DEFAULT NULL COMMENT '规程主键',
  `content` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_zh_0900_as_cs NULL DEFAULT NULL COMMENT '故障内容',
  `create_time` datetime NULL DEFAULT NULL COMMENT '创建时间',
  `create_by` bigint NULL DEFAULT NULL COMMENT '创建人ID',
  `update_time` datetime NULL DEFAULT NULL COMMENT '修改时间',
  `update_by` bigint NULL DEFAULT NULL COMMENT '修改人ID',
  `dr` tinyint NOT NULL COMMENT '删除标记',
  `remark` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `FK_Reference_18`(`rule_define_id` ASC) USING BTREE,
  CONSTRAINT `FK_Reference_18` FOREIGN KEY (`rule_define_id`) REFERENCES `rule_define` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_zh_0900_as_cs COMMENT = '规程明细定义' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of rule_detail_define
-- ----------------------------
INSERT INTO `rule_detail_define` VALUES (1, 1, '划痕', '2023-02-16 14:30:01', 10000, NULL, NULL, 0, '测试数据');
INSERT INTO `rule_detail_define` VALUES (746337346051375104, 1, '11', '2023-02-16 19:58:10', NULL, NULL, NULL, 0, '11');
INSERT INTO `rule_detail_define` VALUES (746337370814545920, 1, '11', '2023-02-16 19:58:15', NULL, NULL, NULL, 0, '11');
INSERT INTO `rule_detail_define` VALUES (746337405920870400, 746322654226546688, '22', '2023-02-16 19:58:24', NULL, '2023-02-16 19:58:46', NULL, 0, '22');
INSERT INTO `rule_detail_define` VALUES (746337428096155648, 746322654226546688, '111', '2023-02-16 19:58:29', NULL, NULL, NULL, 0, '111');

-- ----------------------------
-- Table structure for rule_notify_strategy
-- ----------------------------
DROP TABLE IF EXISTS `rule_notify_strategy`;
CREATE TABLE `rule_notify_strategy`  (
  `id` bigint NOT NULL COMMENT '主键',
  `rule_type_id` bigint NULL DEFAULT NULL COMMENT '规程类型主键',
  `remind_time` datetime NULL DEFAULT NULL COMMENT '提前时间',
  `delay_time` datetime NULL DEFAULT NULL COMMENT '延后时间',
  `interval_time` float NULL DEFAULT NULL COMMENT '时间间隔',
  `create_time` datetime NULL DEFAULT NULL COMMENT '创建时间',
  `create_by` bigint NULL DEFAULT NULL COMMENT '创建人ID',
  `update_time` datetime NULL DEFAULT NULL COMMENT '修改时间',
  `update_by` bigint NULL DEFAULT NULL COMMENT '修改人ID',
  `dr` tinyint NOT NULL COMMENT '删除标记',
  `remark` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `FK_Reference_30`(`rule_type_id` ASC) USING BTREE,
  CONSTRAINT `FK_Reference_30` FOREIGN KEY (`rule_type_id`) REFERENCES `rule_type` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_zh_0900_as_cs COMMENT = '规程提醒策略' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of rule_notify_strategy
-- ----------------------------
INSERT INTO `rule_notify_strategy` VALUES (1, 1, '2022-12-01 14:30:21', '2023-02-16 14:30:27', 100, '2023-02-16 14:30:40', 10000, NULL, NULL, 0, '测试数据');

-- ----------------------------
-- Table structure for rule_type
-- ----------------------------
DROP TABLE IF EXISTS `rule_type`;
CREATE TABLE `rule_type`  (
  `id` bigint NOT NULL COMMENT '主键',
  `dict_item_id` bigint NULL DEFAULT NULL COMMENT '类型编码',
  `dict_item_text` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_zh_0900_as_cs NULL DEFAULT NULL COMMENT '类型名称',
  `create_time` datetime NULL DEFAULT NULL COMMENT '创建时间',
  `create_by` bigint NULL DEFAULT NULL COMMENT '创建人ID',
  `update_time` datetime NULL DEFAULT NULL COMMENT '修改时间',
  `update_by` bigint NULL DEFAULT NULL COMMENT '修改人ID',
  `dr` tinyint NOT NULL COMMENT '删除标记',
  `remark` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_zh_0900_as_cs COMMENT = '规程类型' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of rule_type
-- ----------------------------
INSERT INTO `rule_type` VALUES (1, 1, '1', '2023-02-16 14:27:03', 10000, NULL, NULL, 0, '测试数据');

SET FOREIGN_KEY_CHECKS = 1;

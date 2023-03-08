create table `sys_table_ref` (
  `id` bigint not null comment '主键',
  `main_table` varchar(63) default null comment '主表表名',
  `main_info` varchar(63) default null comment '主表描述',
  `sub_table` varchar(63) default null comment '子表表名',
  `sub_info` varchar(63) default null comment '子表描述',
  `ref_id` varchar(63) default null comment '引表外键名称',
  `del_flag` varchar(63) character set utf8mb4 collate utf8mb4_0900_ai_ci default null comment '删除标记字段名',
  `create_time` datetime default null comment '创建时间',
  `create_by` bigint default null comment '创建人id',
  `update_time` datetime default null comment '修改时间',
  `update_by` bigint default null comment '修改人id',
  `dr` tinyint default null comment '删除标记',
  primary key (`id`)
) comment='表引用关系';

-- ----------------------------
-- Records of sys_table_ref
-- ----------------------------
INSERT INTO `sys_table_ref` VALUES ('1', 'sys_role', '角色', 'sys_role_user', '角色用户关联表', 'roleId', 'dr', null, null, null, null, '0');
INSERT INTO `sys_table_ref` VALUES ('2', 'sys_role', '角色', 'sys_role_dept', '角色部门关联表', 'roleId', 'dr', null, null, null, null, '0');

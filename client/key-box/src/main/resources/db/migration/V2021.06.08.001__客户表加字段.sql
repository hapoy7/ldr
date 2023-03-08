drop table if exists `base_customer`;
create table `base_customer` (
  `id` bigint unsigned not null comment '主键',
  `user_name` varchar(200) not null comment '用户名',
  `password` varchar(2000) not null comment '密码',
  `wechat` varchar(200) default null comment '微信号',
  `address` varchar(200) default null comment '地址',
  `avatar` varchar(200) default null comment '头像',
  `remark` varchar(200) default null comment '备注',
  `tel` char(11) default null comment '电话号',
  `level_id` int default null comment '会员等级',
  `create_time` datetime default null comment '创建时间',
  `create_by` bigint default null comment '创建人id',
  `update_time` datetime default null comment '修改时间',
  `update_by` bigint default null comment '修改人id',
  `dr` tinyint default null comment '删除标记',
  primary key (`id`)
) comment='客户信息';

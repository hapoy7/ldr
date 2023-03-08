package com.ldr.manage.sys.role;

import org.springframework.stereotype.Repository;

import com.ldr.common.base.BaseDao;

/**
 * @类说明 【角色】数据访问层
 * @author 高振中
 * @date 2021-02-20 11:34:58
 **/
@Repository
public class RoleDao extends BaseDao<Role> {
	RoleDao() { checkTableRef = true; /*启用删除时外键检查*/ }
}
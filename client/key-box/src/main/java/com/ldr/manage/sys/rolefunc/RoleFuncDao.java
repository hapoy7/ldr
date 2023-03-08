package com.ldr.manage.sys.rolefunc;

import java.util.List;
import org.springframework.stereotype.Repository;

import com.ldr.common.base.BaseDao;

/**
 * @类说明 【角色功能关联】数据访问层
 * @author 高振中
 * @date 2021-02-20 11:34:58
 **/
@Repository
public class RoleFuncDao extends BaseDao<RoleFunc> {
	/**
	 * @方法说明 当前用户分配的菜单ids
	 */
	public List<Long> funcIds(Long userId) {
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT DISTINCT rf.func_id FROM sys_role_user ru ");
		sql.append("JOIN sys_role_func rf ON ru.role_id = rf.role_id ");
		sql.append("WHERE ru.user_id =?");
		return listSingle(sql.toString(), Long.class, userId);
	}

	/**
	 * @方法说明 【角色功能关联】列表
	 */
	public List<RoleFunc> list(Long roleId) {
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT t.role_func_id,t.role_id,t.func_id FROM sys_role_func t ");
		sql.append("JOIN sys_func f ON t.func_id = f.func_id ");
		sql.append("WHERE f.leaf=1 AND t.role_id = ?");
		return list(sql.toString(), RoleFunc.class, roleId);
	}
}
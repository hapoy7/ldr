package com.ldr.manage.sys.rolefunc;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ldr.common.tools.JSONTools;

import lombok.extern.slf4j.Slf4j;

/**
 * @类说明 【角色功能关联】业务逻辑层
 * @author 高振中
 * @date 2021-02-20 11:34:58
 **/
@Service
@Slf4j
public class RoleFuncService {
	@Autowired
	private RoleFuncDao roleFuncDao; // 注入【角色功能关联】数据访问层

	/**
	 * @方法说明 当前用户分配的菜单ids
	 */
	public List<Long> funcIds(Long userId) {
		return roleFuncDao.funcIds(userId);
	}

	/**
	 * @方法说明 【角色功能关联】列表
	 */
	public List<RoleFunc> list(Long roleId) {
		return roleFuncDao.list(roleId);
	}

	/**
	 * @方法说明 【角色功能关联】批量插入
	 */
	public void insertBatch(List<RoleFunc> list, Long roleId) {
		roleFuncDao.delete(RoleFuncCond.builder().roleId(roleId).build());
		List<RoleFunc> roles = roleFuncDao.saveBatch(list);
		log.debug(JSONTools.toString(roles));
	}
}
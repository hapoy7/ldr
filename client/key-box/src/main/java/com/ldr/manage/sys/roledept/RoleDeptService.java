package com.ldr.manage.sys.roledept;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * @类说明 【角色部门关联】业务逻辑层
 * @author 高振中
 * @date 2022-10-10 11:34:58
 **/
@Service
public class RoleDeptService {

	@Autowired
	private RoleDeptDao roleDeptDao; // 注入【角色部门关联】数据访问层

	/**
	 * @方法说明 【角色部门关联】列表
	 */
	public List<RoleDept> list(Long roleId) {
		return roleDeptDao.list(RoleDeptCond.builder().roleId(roleId).build());
	}

	/**
	 * @方法说明 【角色部门关联】批量插入
	 */
	public void insertBatch(@RequestBody List<RoleDept> list, Long roleId) {
		roleDeptDao.delete(RoleDeptCond.builder().roleId(roleId).build());
		roleDeptDao.saveBatch(list);
	}
}
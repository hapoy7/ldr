package com.ldr.manage.base.basepermission;

import com.ldr.common.base.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
/**
 * @类说明 【授权表】业务逻辑层
 * @author 杨来富
 * @date 2022-11-01 09:30:18
 **/
//@Slf4j
@Service
public class BasePermissionService {

	@Autowired
	private BasePermissionDao basePermissionDao; // 注入【授权表】数据访问层

	/**
	 * @方法说明 【授权表】新增并反回主键
	 */
	// @Transactional
	public Long save(BasePermission basePermission) {
		return basePermissionDao.save(basePermission).getId();
	}

	/**
	 * @方法说明 【授权表】删除
	 */
	public int delete(Object[] ids) {
		return basePermissionDao.delete(ids);
	}

	/**
	 * @方法说明 【授权表】修改
	 */
	public int update(BasePermission basePermission) {
		return basePermissionDao.update(basePermission);
	}

	/**
	 * @方法说明 【授权表】分页列表
	 */
	public Page<BasePermission> page(BasePermissionCond cond) {
		return basePermissionDao.page(cond);
	}

	/**
	 * @方法说明 【授权表】列表
	 */
	public List<BasePermission> list(BasePermissionCond cond) {
		return basePermissionDao.list(cond);
	}

	/**
	 * @方法说明 【授权表】按主键查
	 */
	public BasePermission findById(Long id) {
		return basePermissionDao.findById(id);
	}

	/**
	 * @方法说明 【授权表】个数
	 */
	public int count(BasePermissionCond cond) {
		return basePermissionDao.count(cond);
	}
	/**
	 * @方法说明 【授权表】批量保存与更新
	 */
	public void saveBatch(List<BasePermission> basePermissions) {
		basePermissionDao.saveBatch(basePermissions);
	}	
}
package com.ldr.manage.sys.dept;

import org.springframework.stereotype.Repository;

import com.ldr.common.base.BaseDao;

/**
 * 【组织机构】数据访问层
 * @author 高振中
 * @date 2021-04-13 00:30:04
 **/
//@Slf4j
@Repository
public class DeptDao extends BaseDao<Dept> {

	/**
	 * 【组织机构】修改上级结点叶子状态
	 */
	public void updateLeaf(Long id, Integer leaf) {
		String sql = "UPDATE sys_dept SET leaf=? WHERE id=?";
		update(sql, leaf, id);
	}
}
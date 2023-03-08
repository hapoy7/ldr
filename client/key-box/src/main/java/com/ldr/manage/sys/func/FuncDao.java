package com.ldr.manage.sys.func;

import org.springframework.stereotype.Repository;

import com.ldr.common.base.BaseDao;

/**
 * @类说明 【功能菜单】数据访问层
 * @author 高振中
 * @date 2020-11-10 23:19:07
 **/
@Repository
public class FuncDao extends BaseDao<Func> {
	/**
	 * @方法说明 【功能菜单】修改上级结点叶子状态
	 */
	public int updateLeaf(Long id, int leaf) {
		String sql = "UPDATE sys_func SET leaf=? WHERE func_id=? ";
		return update(sql, leaf, id);
	}

}
package com.ldr.manage.sys.dept;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * 【组织机构】业务逻辑层
 * @author 高振中
 * @date 2021-05-15 23:45:47
 **/
@Service
public class DeptService {

	@Autowired
	private DeptDao deptDao; // 注入【组织机构】数据访问层

	/**
	 * 【组织机构】树
	 */
	public List<Dept> tree() {
		List<Dept> depts = deptDao.list(DeptCond.builder().build().setOrders("id"));// 查询所有记录
		Map<Long, Dept> treeMap = new HashMap<>();
		List<Dept> treeList = new ArrayList<>();
		depts.forEach(dept -> {
			treeMap.put(dept.getId(), dept);
			if (dept.getParentId() == 0)
				treeList.add(dept);
			else
				treeMap.get(dept.getParentId()).getChildren().add(dept);
		});
		return treeList;
	}

	/**
	 * 【组织机构】新增
	 */
	@Transactional
	public Long save(Dept dept) {
		dept.setLeaf(Byte.valueOf("1"));
		if (!dept.getParentId().equals(0L))
			deptDao.updateLeaf(dept.getParentId(), 1);
		return deptDao.save(dept).getId();
	}

	/**
	 * 【组织机构】删除
	 */
	@Transactional
	public void delete(Dept dept) {
		deptDao.delete(dept.getId());
		int count = deptDao.count(DeptCond.builder().parentId(dept.getParentId()).build());
		if (count == 0)
			deptDao.updateLeaf(dept.getParentId(), 0);
	}

	/**
	 * 【组织机构】修改
	 */
	public int update(Dept dept) {
		return deptDao.update(dept);
	}

	/**
	 * 【组织机构】列表
	 */
	public List<Dept> list(DeptCond cond) {
		return deptDao.list(cond);
	}

	/**
	 * 【组织机构】个数
	 */
	public int count(DeptCond cond) {
		return deptDao.count(cond);
	}
}
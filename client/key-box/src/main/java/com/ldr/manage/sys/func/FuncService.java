package com.ldr.manage.sys.func;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @类说明 【功能菜单】业务逻辑层
 * @author 高振中
 * @date 2020-11-10 23:19:07
 **/
@Service
public class FuncService {

	@Autowired
	private FuncDao funcDao; // 注入【功能菜单】数据访问层

	/**
	 * @方法说明 【功能菜单】新增
	 */
	public Long save(Func func) {
		if (!func.getParentId().equals(0L))
			funcDao.updateLeaf(func.getParentId(), 0);
		return funcDao.save(func).getFuncId();
	}

	/**
	 * @方法说明 【功能菜单】删除
	 */
	public void delete(Func func) {
		funcDao.delete(func.getFuncId());
		int count = funcDao.count(FuncCond.builder().parentId(func.getParentId()).build());
		if (count == 0)
			funcDao.updateLeaf(func.getParentId(), 1);
	}

	/**
	 * @方法说明 【功能菜单】树
	 */
	public List<Func> tree(Object[] ids) {

		List<Func> functions = funcDao.list(FuncCond.builder().ids(ids).type(Byte.valueOf("1")).build().setOrders("func_id"));
		Map<Long, Func> treeMap = new HashMap<>();
		List<Func> treeList = new ArrayList<>();

		functions.forEach(func -> {
			treeMap.put(func.getFuncId(), func);
			if (func.getParentId() == 0L) // 将根结点放入新的list
				treeList.add(func);
			else // 将非根结点放入对应上级结点的children集合中
				treeMap.get(func.getParentId()).getChildren().add(func);
		});

		return treeList;
	}

	/**
	 * @方法说明 【功能菜单】更新
	 */
	public int update(Func func) {
		return funcDao.update(func);
	}

	/**
	 * @方法说明 【功能菜单】列表
	 */
	public List<Func> list(FuncCond cond) {
		return funcDao.list(cond);
	}

	/**
	 * @方法说明 【功能菜单】个数
	 */
	public int count(FuncCond cond) {
		return funcDao.count(cond);
	}
}
package com.ldr.manage.sys.dictitem;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @类说明 【字典项】业务逻辑层
 * @author 高振中
 * @date 2021-02-20 22:25:34
 **/
@Service
public class DictItemService {

	@Autowired
	private DictItemDao dictItemDao; // 注入【字典项】数据访问层

	/**
	 * @方法说明 【字典项】新增
	 */
	public Long save(DictItem dictItem) {
		return dictItemDao.save(dictItem).getDictId();
	}

	/**
	 * @方法说明 【字典项】删除
	 */
	public int delete(Object[] ids) {
		return dictItemDao.delete(ids);
	}

	/**
	 * @方法说明 【字典项】修改新
	 */
	public int update(DictItem dictItem) {
		return dictItemDao.update(dictItem);
	}

	/**
	 * @方法说明 【字典项】全部
	 */
	public Map<String, List<DictVO>> dicts() {
		return dictItemDao.listDicts().stream().collect(Collectors.groupingBy(i -> i.getCode()));
	}

	/**
	 * @方法说明 【字典项】列表
	 */
	public List<DictItem> list(DictItemCond cond) {
		cond.setOrders("id DESC");
		return dictItemDao.list(cond);
	}

	/**
	 * @方法说明 【字典项】个数
	 */
	public int count(DictItemCond cond) {
		return dictItemDao.count(cond);
	}
}
package com.ldr.manage.sys.dict;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ldr.common.base.Page;

/**
 * @类说明 【枚举字典】业务逻辑层
 * @author 高振中
 * @date 2020-12-19 21:18:17
 **/
@Service
public class DictService {

	@Autowired
	private DictDao dictDao; // 注入【字典】数据访问层

	/**
	 * @方法说明 新增【枚举字典】
	 */
	public Long save(Dict dict) {
		return dictDao.save(dict).getId();
	}

	/**
	 * @方法说明 删除【枚举字典】
	 */
	public int delete(Object[] ids) {
		return dictDao.delete(ids);
	}

	/**
	 * @方法说明 更新【枚举字典】
	 */
	public int update(Dict dict) {
		return dictDao.update(dict);
	}

	/**
	 * @方法说明 【枚举字典】分页列表
	 */
	public Page<Dict> page(DictCond cond) {
		return dictDao.page(cond);
	}

	/**
	 * @方法说明 【枚举字典】个数
	 */
	public int count(DictCond cond) {
		return dictDao.count(cond);
	}
}
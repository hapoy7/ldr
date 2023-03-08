package com.ldr.manage.sys.dictitem;

import java.util.List;
import org.springframework.stereotype.Repository;

import com.ldr.common.base.BaseDao;

/**
 * @类说明 【字典项】数据访问层
 * @author 高振中
 * @date 2021-02-20 22:25:34
 **/
@Repository
public class DictItemDao extends BaseDao<DictItem> {

	/**
	 * @方法说明 【字典项】全部列表
	 */
	public List<DictVO> listDicts() {
		String sql = "SELECT d.code,t.text,t.value FROM sys_dict_item t JOIN sys_dict d ON d.id=t.dict_id ORDER BY d.code";
		return list(true,sql, DictVO.class);
	}

}
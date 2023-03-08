package com.ldr.manage.base.basekey;

import org.springframework.stereotype.Repository;

import com.ldr.common.base.BaseDao;
import com.ldr.common.base.Page;

/**
 * @类说明 【钥匙】数据访问层
 * @author 高振中
 * @date 2022-09-20 10:37:01
 **/
//@Slf4j
@Repository
public class BaseKeyDao extends BaseDao<BaseKey> {
	/**
	 * @方法说明 【钥匙】分页列表
	 */
	public Page<BaseKey> page(BaseKeyCond cond) {
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT t.id,t.name,t.number,t.box_id,t.box_number,t.status,t.remark,t.solt,t.rfid,t.key_group,");
		sql.append("t.create_time,t.create_by,t.update_time,t.update_by,t.dr,b.name box_name");
		sql.append(" FROM base_key t");
		sql.append(" JOIN base_box b ON t.box_id=b.id");
		sql.append(cond.where());
		return page(sql.toString(), cond, BaseKey.class);
	}
}
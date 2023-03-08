package com.ldr.manage.sys.log;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ldr.common.base.Page;

/**
 * @类说明 【系统日志】业务逻辑层
 * @author 高振中
 * @date 2021-03-12 12:57:38
 **/
@Service
public class LogService {

	@Autowired
	private LogDao logDao; // 注入【系统日志】数据访问层

	/**
	 * @方法说明 【系统日志】删除
	 */
	public int delete(Object[] ids) {
		return logDao.delete(ids);
	}

	/**
	 * @方法说明 【系统日志】分页列表
	 */
	public Page<Log> page(LogCond cond) {
		cond.setOrders("id DESC");
		return logDao.page(cond);
	}

}
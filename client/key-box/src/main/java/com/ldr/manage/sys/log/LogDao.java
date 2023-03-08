package com.ldr.manage.sys.log;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Repository;

import com.ldr.common.base.BaseDao;
import com.ldr.common.base.key.IdGenerator;

/**
 * @类说明 【系统日志】数据访问层
 * @author 高振中
 * @date 2021-03-12 12:57:38
 **/
@Repository
public class LogDao extends BaseDao<Log> {
	@Autowired
	private IdGenerator idGenerator;

	/**
	 * @方法说明 【系统日志】新增
	 */
	@Async
	public Integer insert(Log vo) {
		String sql = "INSERT INTO sys_log (id,title,user_id,user_name,ip,method,url,request_type,params,operate_time,result) VALUES (?,?,?,?,?,?,?,?,?,?,?)";
		Object[] param = { idGenerator.create(), vo.getTitle(), vo.getUserId(), vo.getUserName(), vo.getIp(), vo.getMethod(), vo.getUrl(), vo.getRequestType(), vo.getParams(), LocalDateTime.now(),
				vo.getResult() };
		return update(sql, param);
	}

}
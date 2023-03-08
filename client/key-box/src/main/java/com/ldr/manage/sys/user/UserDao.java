package com.ldr.manage.sys.user;

import java.util.List;
import org.springframework.stereotype.Repository;

import com.ldr.common.base.BaseDao;
import com.ldr.common.base.Page;

/**
 * @类说明 【用户】数据访问层
 * @author 高振中
 * @date 2020-11-17 01:42:03
 **/
@Repository
public class UserDao extends BaseDao<User> {

	/**
	 * @方法说明 【用户】分页列表
	 */
	public Page<User> page(UserCond cond) {
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT t.user_id,t.dept_id,t.name,t.password,t.login_name,t.avatar,t.phone,t.gender,t.status,");
		sql.append("t.number,t.card_no,t.group_name,t.fingerprint_count,t.face_info,t.type,t.start_time,t.end_time,");
		sql.append("t.create_time,t.update_time,t.remark,t.dr,d.name dept_name ");
		sql.append("FROM sys_user t LEFT JOIN sys_dept d ON t.dept_id=d.id ");
		sql.append("WHERE t.dr=0");
		sql.append(cond.and());
		return page(sql.toString(), cond, User.class);
	}

	/**
	 * @方法说明 【用户】列表
	 */
	public List<User> list(UserCond cond) {
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT t.user_id,t.dept_id,t.name,t.password,t.login_name,t.avatar,t.phone,t.gender,t.status,t.create_time,t.update_time,t.remark,t.dr,d.name dept_name ");
		sql.append("FROM sys_user t LEFT JOIN sys_dept d ON t.dept_id=d.id ");
		sql.append("WHERE t.dr=0");
		sql.append(cond.and());
		return list(sql.toString(), cond, User.class);
	}

}
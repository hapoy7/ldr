package com.ldr.manage.sys.parameter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ldr.common.base.Page;

/**
 * @类说明 【系统参数】业务逻辑层
 * @author 高振中
 * @date 2021-04-10 22:54:52
 **/
@Service
public class ParameterService {

	@Autowired
	private ParameterDao parameterDao; // 注入【系统参数】数据访问层

	/**
	 * @方法说明 【系统参数】新增并反回主键
	 */
	public Long save(Parameter parameter) {
		return parameterDao.save(parameter).getId();
	}

	/**
	 * @方法说明 【系统参数】删除
	 */
	public int delete(Object[] ids) {
		return parameterDao.delete(ids);
	}

	/**
	 * @方法说明 【系统参数】修改
	 */
	public int update(Parameter parameter) {
		return parameterDao.update(parameter);
	}

	/**
	 * @方法说明 【系统参数】分页列表
	 */
	public Page<Parameter> page(ParameterCond cond) {
		return parameterDao.page(cond);
	}

	/**
	 * @方法说明 【系统参数】个数
	 */
	public int count(ParameterCond cond) {
		return parameterDao.count(cond);
	}

}
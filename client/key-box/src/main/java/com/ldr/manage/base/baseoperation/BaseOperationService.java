package com.ldr.manage.base.baseoperation;

import com.ldr.common.base.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
/**
 * @类说明 【操作日志】业务逻辑层
 * @author 高振中
 * @date 2022-09-20 10:37:01
 **/
//@Slf4j
@Service
public class BaseOperationService {

	@Autowired
	private BaseOperationDao baseOperationDao; // 注入【操作日志】数据访问层

	/**
	 * @方法说明 【操作日志】新增并反回主键
	 */
	// @Transactional
	public Long save(BaseOperation baseOperation) {
		baseOperation.setOptTime(LocalDateTime.now());
		return baseOperationDao.save(baseOperation).getId();
	}

	/**
	 * @方法说明 【操作日志】删除
	 */
	public int delete(Object[] ids) {
		return baseOperationDao.delete(ids);
	}

	/**
	 * @方法说明 【操作日志】修改
	 */
	public int update(BaseOperation baseOperation) {
		return baseOperationDao.update(baseOperation);
	}

	/**
	 * @方法说明 【操作日志】分页列表
	 */
	public Page<BaseOperation> page(BaseOperationCond cond) {
		return baseOperationDao.page(cond);
	}

	/**
	 * @方法说明 【操作日志】列表
	 */
	public List<BaseOperation> list(BaseOperationCond cond) {
		return baseOperationDao.list(cond);
	}

	/**
	 * @方法说明 【操作日志】按主键查
	 */
	public BaseOperation findById(Long id) {
		return baseOperationDao.findById(id);
	}

	/**
	 * @方法说明 【操作日志】个数
	 */
	public int count(BaseOperationCond cond) {
		return baseOperationDao.count(cond);
	}
	/**
	 * @方法说明 【操作日志】批量保存与更新
	 */
	public void saveBatch(List<BaseOperation> baseOperations) {
		baseOperationDao.saveBatch(baseOperations);
	}	
}
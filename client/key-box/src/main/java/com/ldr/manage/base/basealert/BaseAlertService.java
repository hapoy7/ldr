package com.ldr.manage.base.basealert;

import java.time.LocalDateTime;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ldr.common.base.Page;
/**
 * @类说明 【告警信息】业务逻辑层
 * @author 高振中
 * @date 2022-09-20 17:45:04
 **/
//@Slf4j
@Service
public class BaseAlertService {

	@Autowired
	private BaseAlertDao baseAlertDao; // 注入【告警信息】数据访问层

	/**
	 * @方法说明 【告警信息】新增并反回主键
	 */
	// @Transactional
	public Long save(BaseAlert baseAlert) {
		baseAlert.setAlertTime(LocalDateTime.now());
		return baseAlertDao.save(baseAlert).getId();
	}

	/**
	 * @方法说明 【告警信息】删除
	 */
	public int delete(Object[] ids) {
		return baseAlertDao.delete(ids);
	}

	/**
	 * @方法说明 【告警信息】修改
	 */
	public int update(BaseAlert baseAlert) {
		baseAlert.setAlertTime(LocalDateTime.now());
		return baseAlertDao.update(baseAlert);
	}

	/**
	 * @方法说明 【告警信息】分页列表
	 */
	public Page<BaseAlert> page(BaseAlertCond cond) {
		return baseAlertDao.page(cond);
	}

	/**
	 * @方法说明 【告警信息】列表
	 */
	public List<BaseAlert> list(BaseAlertCond cond) {
		return baseAlertDao.list(cond);
	}

	/**
	 * @方法说明 【告警信息】按主键查
	 */
	public BaseAlert findById(Long id) {
		return baseAlertDao.findById(id);
	}

	/**
	 * @方法说明 【告警信息】个数
	 */
	public int count(BaseAlertCond cond) {
		return baseAlertDao.count(cond);
	}
	/**
	 * @方法说明 【告警信息】批量保存与更新
	 */
	public void saveBatch(List<BaseAlert> baseAlerts) {
		baseAlertDao.saveBatch(baseAlerts);
	}	
}
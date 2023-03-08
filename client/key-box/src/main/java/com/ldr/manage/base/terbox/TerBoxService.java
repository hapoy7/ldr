package com.ldr.manage.base.terbox;

import com.ldr.manage.base.basebox.BaseBox;
import com.ldr.manage.base.basebox.BaseBoxCond;
import com.ldr.manage.base.basebox.BaseBoxDao;
import com.ldr.manage.base.terbox.vo.Auth;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
/**
 * @类说明 【终端钥匙柜关联】业务逻辑层
 * @author 杨来富
 * @date 2022-11-04 10:10:22
 **/
//@Slf4j
@Service
public class TerBoxService {

	@Autowired
	private TerBoxDao terBoxDao; // 注入【终端钥匙柜关联】数据访问层
	
	@Autowired
	private BaseBoxDao boxDao;

	/**
	 * @方法说明 【用户列表与授权信息】
	 */
	public Auth auth(TerBoxCond cond) {
		List<TerBox> boxes = terBoxDao.list(TerBoxCond.builder().terId(cond.getTerId()).build());
		List<BaseBox> list = boxDao.list(BaseBoxCond.builder().name(cond.getBoxName()).number(cond.getBoxNumber()).build());
		return Auth.builder().boxList(list).ids(boxes.stream().map(i -> i.getBoxId()).toList()).build();
	}

	/**
	 * @方法说明 【角色用户关联】批量插入
	 */
	public void insertBatch(List<Long> boxIds, Long terId) {
		terBoxDao.delete(TerBoxCond.builder().terId(terId).build());
		terBoxDao.saveBatch(boxIds.stream().map(b -> new TerBox(b, terId)).toList());
	}
}
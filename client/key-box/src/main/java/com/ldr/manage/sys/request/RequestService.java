package com.ldr.manage.sys.request;

import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import com.google.common.collect.Lists;

/**
 * @类说明 【请求时长统计】业务逻辑层
 * @author 高振中
 * @date 2021-02-20 14:02:55
 **/
@Service
public class RequestService {

	@Autowired
	private RequestDao requestDao; // 注入【请求时长统计】数据访问层

	private static final ConcurrentHashMap<String, Request> tempMap = new ConcurrentHashMap<>();

	/**
	 * @方法说明 请求进临时map
	 */
	public void add(Request request) {
		String key = request.getAppName() + "_" + request.getPath();
		Request old = getOld(request, key);
		// 计算方法
		request.setSumMilliSecond(old.getSumMilliSecond() + request.getCurrentMilliSecond());
		request.setMaxMilliSecond(Math.max(request.getCurrentMilliSecond(), old.getMaxMilliSecond()));
		request.setMinMilliSecond(Math.min(request.getCurrentMilliSecond(), old.getMinMilliSecond()));
		request.setSumCount(old.getSumCount() + 1);
		request.setAvgMilliSecond((float) request.getSumMilliSecond() / request.getSumCount());
		tempMap.put(key, request);
	}

	/**
	 * @方法说明 取前一次的值
	 */

	private Request getOld(Request request, String key) {
		Request old = tempMap.get(key);
		if (old != null)
			return old;
		RequestCond requestCond = RequestCond.builder().pathEq(request.getPath()).appNameEq(request.getAppName()).build();
		List<Request> list = requestDao.list(requestCond);
		if (!list.isEmpty()) // 数据库中存在的情况
			return list.get(0);
		return Request.builder().appName(request.getAppName()).path(request.getPath()).build();
	}

	/**
	 * @方法说明 每隔10秒入库一次-可调整
	 */
	@Async
	@Scheduled(fixedDelay = 10000)
	public void saveToDB() {
		if (!tempMap.isEmpty())
			Lists.partition(tempMap.values().stream().collect(Collectors.toList()), 100).forEach(i -> requestDao.replaceBatch(i));
	}

	/**
	 * @方法说明 【请求时长统计】列表
	 */
	public List<Request> list(RequestCond cond) {
		cond.setOrders("path");
		return requestDao.list(cond);
	}

	/**
	 * @方法说明 【请求时长统计】删除
	 */
	public int delete(Object[] ids) {
		return requestDao.delete(ids);
	}
}
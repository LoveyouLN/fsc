package com.org.fsc.ssh.order.dao.impl;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.org.fsc.ssh.order.dao.OrderDao;

@Repository("orderDao")
public class OrderDaoImpl implements OrderDao{
	
	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;

	/**
	 * 查询所有订单
	 * fsc
	 * @return
	 * 2017年12月6日上午9:06:52
	 */
	@Override
	public List<?> selAllOrder() {
		return sqlSessionTemplate.selectList("OrderMapper.selAllOrder");
	}

	/**
	 * 查询未被接单的订单
	 * fsc
	 * @return
	 * 2017年12月6日下午5:48:02
	 */
	@Override
	public List<?> selUnansweredOrder() {
		return sqlSessionTemplate.selectList("OrderMapper.selUnansweredOrder");
	}

	/**
	 * 查询所有被删除的订单
	 * fsc
	 * @return
	 * 2017年12月7日上午10:14:43
	 */
	@Override
	public List<?> selAllISDelOrder() {
		return sqlSessionTemplate.selectList("OrderMapper.selAllISDelOrder");
	}

	/**
	 * 新增一个订单
	 * fsc
	 * @param object
	 * @return
	 * 2017年12月8日下午3:12:06
	 */
	@Override
	public int addOneOrder(Object object) {
		return sqlSessionTemplate.insert("OrderMapper.addOneOrder", object);
	}

	/**
	 * 后台模糊查询所有订单
	 * fsc
	 * @param object
	 * @return
	 * 2017年12月10日下午5:16:41
	 */
	@Override
	public List<?> selAllOrderInfo(Object object) {
		return sqlSessionTemplate.selectList("OrderMapper.selAllOrderInfo", object);
	}

	/**
	 * 删除一个订单通过id
	 * fsc
	 * @param orderid
	 * @return
	 * 2017年12月11日下午4:35:04
	 */
	@Override
	public int delOneOrderById(String orderid) {
		return sqlSessionTemplate.update("OrderMapper.delOneOrderById", orderid);
	}

	/**
	 * 结账
	 * fsc
	 * @param orderid
	 * @return
	 * 2017年12月11日下午5:00:57
	 */
	@Override
	public int overOneOrderById(Map<String,String> map) {
		return sqlSessionTemplate.update("OrderMapper.overOneOrderById", map);
	}

	/**
	 * 恢复一个订单通过id
	 * fsc
	 * @param orderid
	 * @return
	 * 2017年12月11日下午5:45:18
	 */
	@Override
	public int recoveryOneOrderById(String orderid) {
		return sqlSessionTemplate.update("OrderMapper.recoveryOneOrderById", orderid);
	}

	/**
	 * 查询我的接单
	 * fsc
	 * @param userid
	 * @return
	 * 2017年12月13日上午8:49:43
	 */
	@Override
	public List<?> selMyOrder(String userid) {
		return sqlSessionTemplate.selectList("OrderMapper.selMyOrder", userid);
	}

	/**
	 * 接桌
	 * fsc
	 * @return
	 * 2017年12月13日上午9:31:23
	 */
	@Override
	public int jiezhuo(Object object) {
		return sqlSessionTemplate.update("OrderMapper.jiezhuo", object);
	}

}

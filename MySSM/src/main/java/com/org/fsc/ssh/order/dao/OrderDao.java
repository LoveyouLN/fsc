package com.org.fsc.ssh.order.dao;

import java.util.List;
import java.util.Map;

public interface OrderDao {

	// 查询订单
	List<?> selAllOrder();

	//查询未被接单的订单
	List<?> selUnansweredOrder();

	//查询所有被删除的订单
	List<?> selAllISDelOrder();

	//新增一个订单
	int addOneOrder(Object object);

	//后台模糊查询所有订单
	List<?> selAllOrderInfo(Object object);

	//删除一个订单通过id
	int delOneOrderById(String orderid);

	//恢复一个订单通过id
	int recoveryOneOrderById(String orderid);

	//结账
	int overOneOrderById(Map<String,String> map);

	//查询我的接单
	List<?> selMyOrder(String userid);

	//接桌
	int jiezhuo(Object object);

}

package com.org.fsc.ssh.order.service;

import java.util.Map;

public interface OrderService {

	// 查询订单
	String selAllOrUnanswerOrAnswerOrder(String yes,String no,String isdel,String del,Map<String,String> isPageMap,String selMyOrder);
	
	//新增一个订单
	String addOneOrder(String newOrder);
	
	//后台模糊查询所有订单
	String selAllOrderInfo(Map<String,String> object);
	
	//恢复或删除一个订单通过id
	String delOrRecoveryOneOrderById(String orderid,String recovery,String del);
	
	//结账
	String overOneOrderById(String orderid);
	
	//查询我的接单
	String selMyOrder(String userid);
	
	//接桌
	String jiezhuo(Map<String,String> map);
	

}

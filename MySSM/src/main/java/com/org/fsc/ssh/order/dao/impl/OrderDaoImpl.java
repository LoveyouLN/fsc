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
	 * ��ѯ���ж���
	 * fsc
	 * @return
	 * 2017��12��6������9:06:52
	 */
	@Override
	public List<?> selAllOrder() {
		return sqlSessionTemplate.selectList("OrderMapper.selAllOrder");
	}

	/**
	 * ��ѯδ���ӵ��Ķ���
	 * fsc
	 * @return
	 * 2017��12��6������5:48:02
	 */
	@Override
	public List<?> selUnansweredOrder() {
		return sqlSessionTemplate.selectList("OrderMapper.selUnansweredOrder");
	}

	/**
	 * ��ѯ���б�ɾ���Ķ���
	 * fsc
	 * @return
	 * 2017��12��7������10:14:43
	 */
	@Override
	public List<?> selAllISDelOrder() {
		return sqlSessionTemplate.selectList("OrderMapper.selAllISDelOrder");
	}

	/**
	 * ����һ������
	 * fsc
	 * @param object
	 * @return
	 * 2017��12��8������3:12:06
	 */
	@Override
	public int addOneOrder(Object object) {
		return sqlSessionTemplate.insert("OrderMapper.addOneOrder", object);
	}

	/**
	 * ��̨ģ����ѯ���ж���
	 * fsc
	 * @param object
	 * @return
	 * 2017��12��10������5:16:41
	 */
	@Override
	public List<?> selAllOrderInfo(Object object) {
		return sqlSessionTemplate.selectList("OrderMapper.selAllOrderInfo", object);
	}

	/**
	 * ɾ��һ������ͨ��id
	 * fsc
	 * @param orderid
	 * @return
	 * 2017��12��11������4:35:04
	 */
	@Override
	public int delOneOrderById(String orderid) {
		return sqlSessionTemplate.update("OrderMapper.delOneOrderById", orderid);
	}

	/**
	 * ����
	 * fsc
	 * @param orderid
	 * @return
	 * 2017��12��11������5:00:57
	 */
	@Override
	public int overOneOrderById(Map<String,String> map) {
		return sqlSessionTemplate.update("OrderMapper.overOneOrderById", map);
	}

	/**
	 * �ָ�һ������ͨ��id
	 * fsc
	 * @param orderid
	 * @return
	 * 2017��12��11������5:45:18
	 */
	@Override
	public int recoveryOneOrderById(String orderid) {
		return sqlSessionTemplate.update("OrderMapper.recoveryOneOrderById", orderid);
	}

	/**
	 * ��ѯ�ҵĽӵ�
	 * fsc
	 * @param userid
	 * @return
	 * 2017��12��13������8:49:43
	 */
	@Override
	public List<?> selMyOrder(String userid) {
		return sqlSessionTemplate.selectList("OrderMapper.selMyOrder", userid);
	}

	/**
	 * ����
	 * fsc
	 * @return
	 * 2017��12��13������9:31:23
	 */
	@Override
	public int jiezhuo(Object object) {
		return sqlSessionTemplate.update("OrderMapper.jiezhuo", object);
	}

}

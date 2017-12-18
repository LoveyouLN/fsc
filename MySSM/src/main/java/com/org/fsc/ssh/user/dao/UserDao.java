package com.org.fsc.ssh.user.dao;

import java.util.List;
import java.util.Map;

import com.org.fsc.ssh.bean.Page;
import com.org.fsc.ssh.bean.User;

public interface UserDao {
	//�����¼
	List<?> handleUser(User user);

	//��ѯһ����ɫͨ��name
	List<?> selOneUserByName(User user);

	//��ѯ�����û�
	List<?> selAllUser(Map<String,String> map);

	//����һ���û�
	int addOneUser(Object object);

	//�޸�һ���û�
	int updOneUser(Object object);

	//ɾ��һ���û�
	int delOneUser(Object object);

	//��ѯһ���û�����ݸ���id 
	List<?> selOneUserById(String userid);

	//����һ���û���ɫ
	int addOneUserRole(Map<String,String> map);

	//�޸�һ���û���ɫ
	int updOneUserRole(Map<String,String> map);

	//��ѯ����δɾ���û�������
	List<?> selAllUserCount();

	//��ѯ�������
	List<?> selAllRole();
	
	//excel
	List<?> ouputExcel();

}

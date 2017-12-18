package com.org.fsc.ssh.user.service;

import java.util.Map;

import com.org.fsc.ssh.bean.Page;
import com.org.fsc.ssh.bean.User;

public interface UserService {
	
	//�����¼
	String handleUser(User user);
	
	//��ѯ�����û�
    String selAllUser(Map<String,String> map);
    
    //��ѯһ���û�����ݸ���id 
  	String selOneUserById(String userid);
  	
  	//����һ���û�
  	String addOneUser(Map<String,String> map);
  	
  	//�޸�һ���û�
  	String updOneUser(Map<String,String> map);
  	//�߼�ɾ��һ����Ա
  	String delOneUser(User user);
  	
  	//��ѯ�������
  	String selAllRole();
}

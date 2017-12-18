package com.org.fsc.ssh.food.service;

import java.util.Map;

public interface FoodService {

	//��ѯ����ʳ��
	String getAllFood();

	//��ѯ����ʳ������
	String selAllFoodType();

	//��ѯ����ʳ�����͸���ʳ������
	String selAllFoodByFoodType(String foodid);

	//����һ��ʳ��
	String addOneFood(String map);

	//ɾ���ָ�һ��ʳ��
	String delOrRecoverOneFood(String map);

	//�߼�ɾ��һ��ʳ��
	String delOneFood(String map);

	//����ʳ��id��ѯ���ʳ��
	String selManyFoodById(String arr);
	
	//��̨ģ����ѯ����ʳ�ﲢ��ҳ
	String getAllFoodInfo(Map<String,String> map);
	
	//��ѯһ��ʳ��ͨ��id
	String selOneFoodById(String foodid);

}

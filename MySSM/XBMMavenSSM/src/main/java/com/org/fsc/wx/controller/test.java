package com.org.fsc.wx.controller;

public class test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		animals animals=new animals();
		animals.Cat cat=animals.new Cat();
		System.out.println("�۾�����:"+cat.eyes);
		System.out.println("ͷ����:"+cat.head);
		System.out.println("�첲����:"+cat.leg);
		System.out.println("������:"+cat.tui);
		cat.desc();
		cat.run();
		cat.eyes=2;
		cat.head=1;
		cat.leg=2;
		cat.tui=4;
		System.out.println("�۾�����:"+cat.eyes);
		System.out.println("ͷ����:"+cat.head);
		System.out.println("�첲����:"+cat.leg);
		System.out.println("������:"+cat.tui);
		cat.desc();
		cat.run();
	}

}

package com.org.fsc.wx.controller;

import java.io.File;
import java.io.IOException;

import jxl.Workbook;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;
import jxl.write.biff.RowsExceededException;
import sun.rmi.runtime.Log;

public class rwst {

	public void getInfo(){
		String location="";
		StackTraceElement[] stacks = Thread.currentThread().getStackTrace(); 
		location = "������"+stacks[2].getClassName() + "\n��������" + stacks[2].getMethodName()
				+ "\n�ļ�����" + stacks[2].getFileName() + "\n�кţ�"
				+ stacks[2].getLineNumber() + "";
		System.out.println(location);
		for (int i = 0; i < stacks.length; i++) {
			System.out.println(stacks[i]);
		}
	}

//	public static void main(String[] args) throws IOException, RowsExceededException, WriteException {
//		String filename="d://book.xls";
//		File file=new File(filename);
//		if (!file.exists()) {
//			if(file.createNewFile()) {
//
//			}else{
//				System.out.println("�����ļ�ʧ��");
//			};
//		}
//		Label labelId=new Label(0,0,"���(id)");//��ʾ��
//		Label labelName=new Label(1,0,"����(name)");
//		Label labelSex=new Label(2,0,"�Ա�(sex)");
//		Label labelNum=new Label(3,0,"нˮ(num)");
//		WritableWorkbook wrtw=Workbook.createWorkbook(file);
//		WritableSheet wtsh=wrtw.createSheet("My Test 1", 0);
//		wtsh.addCell(labelId);
//		wtsh.addCell(labelName);
//		wtsh.addCell(labelSex);
//		wtsh.addCell(labelNum);
//		
//		wrtw.write();
//		wrtw.close();
//	}
	static void test() throws InterruptedException {
		System.out.println("��Ҫ˯��5����!");
		Thread.sleep(5000);
		System.out.println("��˯���ˣ���������.");
		test();
	}
	public static void main(String[] args) throws InterruptedException {
		test();
	}

}
class inaa extends ina {
	
	inaa(int b) {
		super(b);
		// TODO Auto-generated constructor stub
	}

public static void main(String[] args) {
	inaa inaa=new inaa(5);
	System.out.println(inaa.a);
}

}
class ina {
	int a=0;
	ina(int b){
		a=b;
	}

}

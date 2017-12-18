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
		location = "类名："+stacks[2].getClassName() + "\n函数名：" + stacks[2].getMethodName()
				+ "\n文件名：" + stacks[2].getFileName() + "\n行号："
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
//				System.out.println("创建文件失败");
//			};
//		}
//		Label labelId=new Label(0,0,"编号(id)");//表示第
//		Label labelName=new Label(1,0,"姓名(name)");
//		Label labelSex=new Label(2,0,"性别(sex)");
//		Label labelNum=new Label(3,0,"薪水(num)");
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
		System.out.println("我要睡觉5秒钟!");
		Thread.sleep(5000);
		System.out.println("我睡醒了，继续工作.");
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

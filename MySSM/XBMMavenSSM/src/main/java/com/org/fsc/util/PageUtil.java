package com.org.fsc.util;
public class PageUtil {

	/**
	 * 渲染大厨页面
	 * fsc
	 * @param page
	 * @param arg0 JSONArray类型的
	 * @return
	 * 2017年12月2日下午8:57:58
	 */
	public static String makePage(int currentPage,String arg0,int allPage) {
		StringBuffer sb=new StringBuffer();
		sb.append("<div style=\"width:100%; height: 10%;background-color: whilt;\" align=\"center\"></div>");
		sb.append("<div style=\"width:100%; height: 10%; background-color: red;\" align=\"center\">热菜:</div>");
		sb.append("<div style=\"width:100%; height: 10%; background-color: green;\" align=\"center\">凉菜:</div>");
		sb.append("<div style=\"width:100%; height: 10%; background-color: orange;\" align=\"center\">冷饮:</div>");
		sb.append("<div style=\"width:100%; height: 10%; background-color: blue;\" align=\"center\">汤类:</div>");
		sb.append("<div style=\"width:100%; height: 10%; background-color: yellow;\" align=\"center\">主食:</div>");
		sb.append("<div style=\"width:100%; height: 10%;\" align=\"center\"><input style=\"width: 40%;height: 100%\" type=\"button\" value=\"上一页\" /><input style=\"width: 40%;height: 100%\" type=\"button\" value=\"下一页\" /></div>");
		return sb.toString();
	}

}

package com.org.fsc.ssh.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.org.fsc.ssh.common.CommonController;

@Controller
@RequestMapping("/Order")
public class OrderController extends CommonController{
	
	/**
	 * ��ѯ���ж���
	 * fsc
	 * @return
	 * 2017��12��6������12:00:52
	 */
	@RequestMapping(value="/selAllOrder",produces="text/html;charset=UTF-8")
	@ResponseBody
	public String selAllOrder() {
		return orderService.selAllOrUnanswerOrAnswerOrder(null,null,null,null,null,null);
	}
	
	/**
	 * ��̨ģ����ѯ���ж���
	 * fsc
	 * @param request
	 * @return
	 * 2017��12��10������5:27:12
	 */
	@RequestMapping(value="/selAllOrderInfo",produces="text/html;charset=UTF-8")
	@ResponseBody
	public String selAllOrderInfo(HttpServletRequest request) {
		String page=request.getParameter("page");
		String limit=request.getParameter("limit");
		String orderid=request.getParameter("orderid");
		String tableid=request.getParameter("tableid");
		String statu=request.getParameter("statu");
		String money=request.getParameter("money");
		Map<String,String> map=new HashMap<String,String>();
		map.put("page", page);
		map.put("limit", limit);
		map.put("torderid", orderid);
		map.put("tableid", tableid);
		map.put("statu", statu);
		map.put("allmoney", money);
		return orderService.selAllOrUnanswerOrAnswerOrder(null, null, null, null, map,null);
	}
	
	/**
	 * ��ѯδ���ӵ��Ķ���
	 * fsc
	 * @return
	 * 2017��12��6������5:36:26
	 */
	@RequestMapping(value="/selUnansweredOrder",produces="text/html;charset=UTF-8")
	@ResponseBody
	public String selUnansweredOrder() {
		//����jsonarray
		//return orderService.selAllOrUnanswerOrAnswerOrder(null,"no",null,null);
		//����jsonObject
		String str=orderService.selAllOrUnanswerOrAnswerOrder(null,"no",null,null,null,null);
		JSONArray jsar=JSONArray.parseArray(str);
		Map<String,Object> map =new HashMap<String,Object>();
		map.put("code", 0);
		map.put("msg", ",");
		map.put("count", jsar.size());
		map.put("data", jsar);
		String jsob=JSONObject.toJSONString(map);
		return jsob;
	}
	
	/**
	 * ��ѯ�ѱ��ӵ��Ķ���
	 * fsc
	 * @return
	 * 2017��12��6������5:36:26
	 */
	@RequestMapping(value="/selAnsweredOrder",produces="text/html;charset=UTF-8")
	@ResponseBody
	public String selAnsweredOrder() {
		String str=orderService.selAllOrUnanswerOrAnswerOrder("yes",null,null,null,null,null);
		JSONArray jsar=JSONArray.parseArray(str);
		Map<String,Object> map =new HashMap<String,Object>();
		map.put("code", 0);
		map.put("msg", ",");
		map.put("count", jsar.size());
		map.put("data", jsar);
		String jsob=JSONObject.toJSONString(map);
		return jsob;
	}
	
	/**
	 * ��ѯ�ѱ�ɾ���Ķ���
	 * fsc
	 * @return
	 * 2017��12��6������5:36:26
	 */
	@RequestMapping(value="/selDelOrder",produces="text/html;charset=UTF-8")
	@ResponseBody
	public String selDeldOrder() {
		return orderService.selAllOrUnanswerOrAnswerOrder(null,null,null,"del",null,null);
	}
	
	/**
	 * ��ѯ�����Ķ���
	 * fsc
	 * @return
	 * 2017��12��6������5:36:26
	 */
	@RequestMapping(value="/selIsDelOrder",produces="text/html;charset=UTF-8")
	@ResponseBody
	public String selIsDeldOrder() {
		return orderService.selAllOrUnanswerOrAnswerOrder(null,null,"isdel",null,null,null);
	}
	
	/**
	 * ����һ������
	 * fsc
	 * @param request
	 * @return
	 * 2017��12��10������5:08:33
	 */
	@RequestMapping(value="/addOneOrder",produces="text/html;charset=UTF-8")
	@ResponseBody
	public String addOneOrder(HttpServletRequest request) {
		String foodname=request.getParameter("foodname");
		String tableid=request.getParameter("tableid");
		String allmoney=request.getParameter("allmoney");
		Map<String,String> map=new HashMap<String,String>();
		map.put("foodname", foodname);
		map.put("tableid", tableid);
		map.put("allmoney", allmoney);
		String staMap=JSONObject.toJSONString(map);
		return orderService.addOneOrder(staMap);
	}
	
	/**
	 * ɾ��һ������ͨ��id
	 * fsc
	 * @param request
	 * @return
	 * 2017��12��11������4:39:39
	 */
	@RequestMapping(value="/delOneOrderById",produces="text/html;charset=UTF-8")
	@ResponseBody
	public String delOneOrderById(HttpServletRequest request) {
		String orderid=request.getParameter("id");
		return orderService.delOrRecoveryOneOrderById(orderid,null,"yes");
	}
	
	/**
	 * �ָ���ɾ��һ������ͨ��id
	 * fsc
	 * @param request
	 * @return
	 * 2017��12��11������4:39:39
	 */
	@RequestMapping(value="/recoveryOneOrderById",produces="text/html;charset=UTF-8")
	@ResponseBody
	public String recoveryOneOrderById(HttpServletRequest request) {
		String orderid=request.getParameter("id");
		return orderService.delOrRecoveryOneOrderById(orderid,"yes",null);
	}
	
	/**
	 * ����һ������
	 * fsc
	 * @param request
	 * @return
	 * 2017��12��11������5:39:28
	 */
	@RequestMapping(value="/overOneOrderById",produces="text/html;charset=UTF-8")
	@ResponseBody
	public String overOneOrderById(HttpServletRequest request) {
		String orderid=request.getParameter("id");
		return orderService.overOneOrderById(orderid);
	}
	
	/**
	 * ��ѯ�ҵĽӵ�
	 * fsc
	 * @param request
	 * @return
	 * 2017��12��13������8:59:28
	 */
	@RequestMapping(value="/selMyOrder",produces="text/html;charset=UTF-8")
	@ResponseBody
	public String selMyOrder(HttpServletRequest request) {
		String userid=request.getParameter("userid");
		return orderService.selAllOrUnanswerOrAnswerOrder(null,null,null,null,null,userid);
	
	}
	
	/**
	 * ����
	 * fsc
	 * @param request
	 * @return
	 * 2017��12��13������9:29:51
	 */
	@RequestMapping(value="/jiezhuo",produces="text/html;charset=UTF-8")
	@ResponseBody
	public String jiezhuo(HttpServletRequest request) {
		String orderid=request.getParameter("orderid");
		String chref=request.getParameter("chref");
		Map<String,String> inputMap=new HashMap<String,String>();
		inputMap.put("torderid", orderid);
		inputMap.put("chref", chref);
		return orderService.jiezhuo(inputMap);
	
	}
}

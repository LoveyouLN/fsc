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
	 * 查询所有订单
	 * fsc
	 * @return
	 * 2017年12月6日下午12:00:52
	 */
	@RequestMapping(value="/selAllOrder",produces="text/html;charset=UTF-8")
	@ResponseBody
	public String selAllOrder() {
		return orderService.selAllOrUnanswerOrAnswerOrder(null,null,null,null,null,null);
	}
	
	/**
	 * 后台模糊查询所有订单
	 * fsc
	 * @param request
	 * @return
	 * 2017年12月10日下午5:27:12
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
	 * 查询未被接单的订单
	 * fsc
	 * @return
	 * 2017年12月6日下午5:36:26
	 */
	@RequestMapping(value="/selUnansweredOrder",produces="text/html;charset=UTF-8")
	@ResponseBody
	public String selUnansweredOrder() {
		//返回jsonarray
		//return orderService.selAllOrUnanswerOrAnswerOrder(null,"no",null,null);
		//返回jsonObject
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
	 * 查询已被接单的订单
	 * fsc
	 * @return
	 * 2017年12月6日下午5:36:26
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
	 * 查询已被删除的订单
	 * fsc
	 * @return
	 * 2017年12月6日下午5:36:26
	 */
	@RequestMapping(value="/selDelOrder",produces="text/html;charset=UTF-8")
	@ResponseBody
	public String selDeldOrder() {
		return orderService.selAllOrUnanswerOrAnswerOrder(null,null,null,"del",null,null);
	}
	
	/**
	 * 查询正常的订单
	 * fsc
	 * @return
	 * 2017年12月6日下午5:36:26
	 */
	@RequestMapping(value="/selIsDelOrder",produces="text/html;charset=UTF-8")
	@ResponseBody
	public String selIsDeldOrder() {
		return orderService.selAllOrUnanswerOrAnswerOrder(null,null,"isdel",null,null,null);
	}
	
	/**
	 * 新增一个订单
	 * fsc
	 * @param request
	 * @return
	 * 2017年12月10日下午5:08:33
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
	 * 删除一个订单通过id
	 * fsc
	 * @param request
	 * @return
	 * 2017年12月11日下午4:39:39
	 */
	@RequestMapping(value="/delOneOrderById",produces="text/html;charset=UTF-8")
	@ResponseBody
	public String delOneOrderById(HttpServletRequest request) {
		String orderid=request.getParameter("id");
		return orderService.delOrRecoveryOneOrderById(orderid,null,"yes");
	}
	
	/**
	 * 恢复或删除一个订单通过id
	 * fsc
	 * @param request
	 * @return
	 * 2017年12月11日下午4:39:39
	 */
	@RequestMapping(value="/recoveryOneOrderById",produces="text/html;charset=UTF-8")
	@ResponseBody
	public String recoveryOneOrderById(HttpServletRequest request) {
		String orderid=request.getParameter("id");
		return orderService.delOrRecoveryOneOrderById(orderid,"yes",null);
	}
	
	/**
	 * 结账一个订单
	 * fsc
	 * @param request
	 * @return
	 * 2017年12月11日下午5:39:28
	 */
	@RequestMapping(value="/overOneOrderById",produces="text/html;charset=UTF-8")
	@ResponseBody
	public String overOneOrderById(HttpServletRequest request) {
		String orderid=request.getParameter("id");
		return orderService.overOneOrderById(orderid);
	}
	
	/**
	 * 查询我的接单
	 * fsc
	 * @param request
	 * @return
	 * 2017年12月13日上午8:59:28
	 */
	@RequestMapping(value="/selMyOrder",produces="text/html;charset=UTF-8")
	@ResponseBody
	public String selMyOrder(HttpServletRequest request) {
		String userid=request.getParameter("userid");
		return orderService.selAllOrUnanswerOrAnswerOrder(null,null,null,null,null,userid);
	
	}
	
	/**
	 * 接桌
	 * fsc
	 * @param request
	 * @return
	 * 2017年12月13日上午9:29:51
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

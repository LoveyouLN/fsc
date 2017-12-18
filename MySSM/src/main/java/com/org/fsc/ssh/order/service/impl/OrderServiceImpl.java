package com.org.fsc.ssh.order.service.impl;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.org.fsc.ssh.food.dao.FoodDao;
import com.org.fsc.ssh.order.dao.OrderDao;
import com.org.fsc.ssh.order.service.OrderService;
import com.org.fsc.ssh.user.dao.UserDao;

@Service("orderService")
public class OrderServiceImpl implements OrderService {
	@Autowired
	private OrderDao orderDao;

	//需要查询食物信息
	@Autowired
	private FoodDao foodDao;

	//需要查询大厨真实名字
	@Autowired
	private UserDao userDao;

	/**
	 * 后台查询所有订单,未被接单,已被接单
	 * fsc
	 * @return
	 * 2017年12月6日上午9:10:06
	 */
	@Override
	public String selAllOrUnanswerOrAnswerOrder(String yes,String no,String isdel,String del,Map<String,String> isPageMap,String selMyOrder) {
		List<?> resultList=null;
		if(isPageMap!=null) {
			resultList=orderDao.selAllOrderInfo(isPageMap);
		}else if(selMyOrder!=null){
			resultList=orderDao.selMyOrder(selMyOrder);
		}else {
			resultList=orderDao.selAllOrder();
		}
		//储存未被接单的单子
		List<Map<String,Object>> listUnansweredOrder=new ArrayList<Map<String,Object>>();
		//储存已被接单的单子
		List<Map<String,Object>> listansweredOrder=new ArrayList<Map<String,Object>>();
		//储存未被删除的单子
		List<Map<String,Object>> listIsdelOrder=new ArrayList<Map<String,Object>>();
		//储存被删除的单子
		List<Map<String,Object>> listDelOrder=new ArrayList<Map<String,Object>>();
		//循环修改该数据规格
		for (int i = 0; i < resultList.size(); i++) {
			Map<String,Object> map=(Map<String, Object>) resultList.get(i);
			//先拿到footlist这个字段
			String foodlist=(String) map.get("FOODLIST");
			//截取这个字段
			String[] strArr=foodlist.trim().split(",");
			//声明一个map放菜id跟次数Map<String,String> map {"foodid","foodcount"}  还有一个功能:存储比较过的id
			Map<String,String> foodidAndfoodcount=new HashMap<String,String>();
			//这里声明一个list为了去重并转换成array[],
			List<String> listString=new ArrayList<String>();
			//去重foodid 
			for (int j = 0; j < strArr.length; j++) {
				//如果该id存储过了,就进行下次循环，直到找到没被存储过的
				if(foodidAndfoodcount.get(strArr[j])!=null) {
					continue;
				}else {
					//把foodid去重放到该list中
					listString.add(strArr[j]);
					//该菜被点的次数，如果进到这，则最低该菜有有一个，所以count初始值为1
					Integer count=1;
					for (int j1 = 0; j1 < strArr.length; j1++) {
						if(j==j1) {
							continue;
						}else {
							if(strArr[j].equals(strArr[j1])) {
								count++;
							}
						}
					}
					foodidAndfoodcount.put(strArr[j], count.toString());
				}
			}
			//测试
			String[] strss=listString.toArray(new String[listString.size()]);
			//根据食物id查询多个食物
			List<?> foodNameAndPrice=foodDao.selManyFoodById(strss);
			//定义一个sb拼接想要的String
			StringBuffer sb=new StringBuffer();
			//循环拼接自己想要的FOODLIST字段String
			for (int j = 0; j < foodNameAndPrice.size(); j++) {
				//获取第(j+1)个数据
				Map<String,String> foodNameAndPriceMap=(Map<String, String>) foodNameAndPrice.get(j);
				//获取第(j+1)个数据foodid
				String MYFOODID=foodNameAndPriceMap.get("MYFOODID");
				sb.append(foodNameAndPriceMap.get("MYFOODNAME")+"(X "+foodidAndfoodcount.get(MYFOODID)+")"+" ");
			}
			//再去除这个字段
			map.remove("FOODLIST");
			//再添加这个字段
			map.put("FOODLIST", sb.toString());
			//拿到大厨id
			String chrefid=(String) map.get("CHREF");
			if(chrefid!=null) {
				//去除大厨字段
				map.remove("CHREF");
				//查询大厨真实姓名通过chrefid
				List<?> listChref=userDao.selOneUserById(chrefid);
				//只有一个id，只会查询出来一个信息
				Map<String,String> mapChref=(Map<String, String>) listChref.get(0);
				//添加大厨字段
				map.put("CHREF", mapChref.get("USERREALNAME"));
				listansweredOrder.add(map);
			}else {
				map.put("CHREF", "null");
				listUnansweredOrder.add(map);
			}
			if("1".equals(map.get("ISDEL"))) {
				listDelOrder.add(map);
			}
			if("0".equals(map.get("ISDEL"))) {
				listIsdelOrder.add(map);
			}
		}

		if(yes!=null) {
			//返回已被接单的订单
			String resultJsar=JSONArray.toJSONString(listansweredOrder);
			return resultJsar;
		}else if(no!=null) {
			//返回未被接单的订单
			String resultJsar=JSONArray.toJSONString(listUnansweredOrder);
			return resultJsar;
		}else if(isdel!=null) {
			//返回未被删除的订单
			String resultJsar=JSONArray.toJSONString(listIsdelOrder);
			return resultJsar;
		}else if(del!=null) {
			//返回被删除的订单
			String resultJsar=JSONArray.toJSONString(listDelOrder);
			return resultJsar;
		}else if(selMyOrder!=null){
			//返回所有订单
			//layui需要数据
			Map<String,Object> resultMap=new HashMap<>();
			resultMap.put("code", 0);
			resultMap.put("msg", "");
			resultMap.put("count", resultList.size());
			resultMap.put("data", resultList);
			String resultJsar=JSONObject.toJSONString(resultMap);
			return resultJsar;
		}else {
			//返回所有订单
			//layui需要数据
			Map<String,Object> resultMap=new HashMap<>();
			resultMap.put("code", 0);
			resultMap.put("msg", "");
			resultMap.put("count", resultList.size());
			resultMap.put("data", resultList);
			String resultJsar=JSONObject.toJSONString(resultMap);
			return resultJsar;
		}


	}

	/**
	 * 后台模糊分页查询所有订单
	 * fsc
	 * @return
	 * 2017年12月10日下午5:14:09
	 */
	public String selAllOrderInfo(Map<String,String> object) {
		List<?> resultList=orderDao.selAllOrderInfo(object);

		return null;
	}

	/**
	 * 新增一个订单
	 * fsc
	 * @param newOrder
	 * @return
	 * 2017年12月8日下午3:13:18
	 */
	@Override
	public String addOneOrder(String inJSON) {
		//储存食物名和次数
		Map<String,String> map=new HashMap<String,String>();
		//转换成json
		JSONObject jsob=JSONObject.parseObject(inJSON);
		//拿到foodname
		String newOrder=jsob.getString("foodname");
		//拿到tableid
		String tableid=jsob.getString("tableid");
		//拿到allmoney
		String allmoney=jsob.getString("allmoney");
		//如果订单为空,返回错误代码
		if(newOrder==null) {
			map.put("Code", "500");
			return JSONObject.toJSONString(map);
		}else {
			//分割后分成一条一条的String[]
			String[] strArr=newOrder.split("\n");
			for (int i = 0; i < strArr.length; i++) {
				String sta=strArr[i];
				//截取菜名字
				String foodName=sta.substring(0,sta.indexOf("("));
				//截取菜数量
				String foodCount=sta.substring(sta.indexOf("X")+1);
				map.put(foodName, foodCount);
			}
			Set<String> set=map.keySet();
			String[] strArr2=new String[set.size()];
			int temp=0;
			Iterator<String> iterator=set.iterator();
			while (iterator.hasNext()) {
				strArr2[temp]=iterator.next();
				temp++;
			}
			//订单里的菜
			String foodIdTemp=null;
			List<?> resultFoodList=foodDao.selManyFoodByName(strArr2);
			for (int i = 0; i < resultFoodList.size(); i++) {
				Map<String,String> resultFoodListMap=(Map<String, String>) resultFoodList.get(i);
				String countTemp=map.get(resultFoodListMap.get("MYFOODNAME"));
				for (int j = 0; j < Integer.parseInt(countTemp); j++) {
					foodIdTemp+=resultFoodListMap.get("MYFOODID")+",";
				}
			}
			//新增一个订单
			Map<String,String> addOneOrderMap=new HashMap<String,String>();
			//订单id
			SimpleDateFormat sm=new SimpleDateFormat("YYYYMMddHHmmss");
			String tempFoodId="";
			tempFoodId=tempFoodId+sm.format(new Date());
			SimpleDateFormat sms=new SimpleDateFormat("YYYY-MM-dd HH:mm:ss");
			String tordertime=tempFoodId+sms.format(new Date());
			Random r=new Random(9);
			for (int j = 0; j < 4; j++) {
				tempFoodId=tempFoodId+r.nextInt();
			}
			addOneOrderMap.put("torderid", tempFoodId);
			addOneOrderMap.put("tableid", tableid);
			addOneOrderMap.put("foodlist", foodIdTemp);
			addOneOrderMap.put("tordertime", tordertime);
			addOneOrderMap.put("allmoney", allmoney);
			addOneOrderMap.put("isdel", "0");
			addOneOrderMap.put("chref", null);
			addOneOrderMap.put("ispay", "未结账");
			if(orderDao.addOneOrder(addOneOrderMap)==1) {
				Map<String,String> resultMap=new HashMap<String,String>();
				resultMap.put("Code", "200");
				return JSONObject.toJSONString(resultMap);
			}else{
				Map<String,String> resultMap=new HashMap<String,String>();
				resultMap.put("Code", "500");
				return JSONObject.toJSONString(resultMap);
			}

		}
	}

	/**
	 * 恢复或删除一个订单通过id
	 * fsc
	 * @param orderid
	 * @return
	 * 2017年12月11日下午4:34:20
	 */
	@Override
	public String delOrRecoveryOneOrderById(String orderid,String recovery,String del) {
		Map<String,String> resultMap=new HashMap<String,String>();
		if(recovery!=null) {
			if(orderDao.recoveryOneOrderById(orderid)==1) {
				resultMap.put("Code", "200");
			}else {
				resultMap.put("Code", "500");
			}
		}
		if(del!=null) {
			if(orderDao.delOneOrderById(orderid)==1) {
				resultMap.put("Code", "200");
			}else {
				resultMap.put("Code", "500");
			}
		}
		
		return JSONObject.toJSONString(resultMap);
	}

	/**
	 * 结账
	 * fsc
	 * @param orderid
	 * @return
	 * 2017年12月11日下午5:00:24
	 */
	@Override
	public String overOneOrderById(String orderid) {
		Map<String,String> resultMap=new HashMap<String,String>();
		Map<String,String> map=new HashMap<String,String>();
		map.put("ispay", "已结账");
		map.put("torderid", orderid);
		if(orderDao.overOneOrderById(map)==1) {
			resultMap.put("Code", "200");
		}else {
			resultMap.put("Code", "500");
		}
		return JSONObject.toJSONString(resultMap);
	}

	/**
	 * 查询我的接单
	 * fsc
	 * @param userid
	 * @return
	 * 2017年12月13日上午8:49:07
	 */
	@Override
	public String selMyOrder(String userid) {
		List<?> list=orderDao.selMyOrder(userid);
		//返回所有订单
		//layui需要数据
		Map<String,Object> resultMap=new HashMap<>();
		resultMap.put("code", 0);
		resultMap.put("msg", "");
		resultMap.put("count", list.size());
		resultMap.put("data", list);
		String resultJsar=JSONObject.toJSONString(resultMap);
		return resultJsar;
	}

	/**
	 * 接桌
	 * fsc
	 * @return
	 * 2017年12月13日上午9:30:57
	 */
	@Override
	public String jiezhuo(Map<String,String> map) {
		Map<String,Object> resultMap=new HashMap<>();
		if(orderDao.jiezhuo(map)==1) {
			resultMap.put("Code", "200");
		}else{
			resultMap.put("Code", "500");
		};
		String resultJSOB=JSONObject.toJSONString(resultMap);
		return resultJSOB;
	}
}

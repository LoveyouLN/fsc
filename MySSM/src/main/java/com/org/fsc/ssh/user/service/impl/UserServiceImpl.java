package com.org.fsc.ssh.user.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.MDC;
import org.apache.log4j.NDC;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.org.fsc.ssh.bean.Page;
import com.org.fsc.ssh.bean.User;
import com.org.fsc.ssh.user.dao.UserDao;
import com.org.fsc.ssh.user.service.UserService;

@Service("loginService")
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDao userDao;

	/**
	 * 返回一个jsonobject数据类型
	 * fsc
	 * @param user
	 * @return
	 * 2017年12月3日下午6:15:33
	 */
	@Override
	public String handleUser(User user) {
		String jsarResult=null;
		List<?> list=userDao.handleUser(user);
		if(list.size()==1) {
			//jsarResult=JSONObject.toJSONString(list);
			Map<String,String> map=(Map<String, String>) list.get(0);
			NDC.push(user.getUsername());
			map.put("Code", "200");
			jsarResult=JSONObject.toJSONString(map);
		}else {
			Map<String,String> map=new HashMap<String,String>();
			map.put("Code", "500");
			jsarResult=JSONObject.toJSONString(map);
		}
		return jsarResult;
	}

	/**
	 * 分页查询用户
	 * fsc
	 * @param page
	 * @return
	 * 2017年12月4日下午4:52:22
	 */
	@Override
	public String selAllUser(Map<String,String> map) {
		List<?> list=userDao.selAllUser(map);
		//layui需要数据
		Map<String,Object> resultMap=new HashMap<>();
		Map<String,Object> allCountMap=(Map)userDao.selAllUserCount().get(0);
		resultMap.put("code", 0);
		resultMap.put("msg", "");
		resultMap.put("count", allCountMap.get("COUNT(*)"));
		resultMap.put("data", list);
		String jsob=JSONObject.toJSONString(resultMap);
		return jsob;
	}

	/**
	 * 查询一个用户的身份根据id 
	 * fsc
	 * @param userid
	 * @return
	 * 2017年12月6日下午12:07:12
	 */
	@Override
	public String selOneUserById(String userid) {
		List<?> list=userDao.selOneUserById(userid);
		String jstr=JSONObject.toJSONString(list.get(0));
		return jstr;
	}

	/**
	 * 新增一个用户
	 * fsc
	 * @param user
	 * @return
	 * 2017年12月9日下午12:51:23
	 */
	@Override
	public String addOneUser(Map<String,String> map) {
		//储存插入正确正确代码
		Map<String,String> resultMap=new HashMap<String,String>(); 
		//查询是否存在这个用户
		User checkuser=new User();
		checkuser.setUsername(map.get("username"));
		if(userDao.selOneUserByName(checkuser).size()>0) {
			resultMap.put("Code", "500");
			return JSONObject.toJSONString(resultMap);
		}else {
			int theNewUserResult=userDao.addOneUser(map);
			if(theNewUserResult>0) {
				User user=new User();
				user.setUsername(map.get("username"));
				List<?> list=userDao.selOneUserByName(user);
				Map<String,String> resultNewUserMap=(Map)list.get(0);
				//给该用户赋予角色
				Map<String,String> newUserRoleMap=new HashMap<String,String>();
				newUserRoleMap.put("tuserroleid", "");
				newUserRoleMap.put("roleid", map.get("roleid"));
				newUserRoleMap.put("userid", resultNewUserMap.get("USERID"));
				if(userDao.addOneUserRole(newUserRoleMap)==1) {
					resultMap.put("Code", "200");
				}else {
					resultMap.put("Code", "500");
				}
			}else{
				resultMap.put("Code", "500");
			};
			return JSONObject.toJSONString(resultMap);
		}

		
	}

	/**
	 * 修改一个用户
	 * fsc
	 * @param user
	 * @return
	 * 2017年12月9日下午2:44:05
	 */
	@Override
	public String updOneUser(Map<String,String> map) {
		User user=new User();
		user.setUserid(map.get("userid"));
		user.setUsername(map.get("username"));
		user.setUserpsw(map.get("userpsw"));
		user.setUserrealname(map.get("userrealname"));
		user.setUseraddress(map.get("useraddress"));
		user.setIsdel("0");
		//储存插入正确正确代码
		Map<String,String> resultMap=new HashMap<String,String>();
		if(userDao.updOneUser(user)==1) {
			//修改一个用户身份
			Map<String,String> roleMap=new HashMap<String,String>();
			roleMap.put("roleid", map.get("roleid"));
			roleMap.put("userid", map.get("userid"));
			if(userDao.updOneUserRole(roleMap)>1) {
				resultMap.put("Code", "500");
			}else{
				resultMap.put("Code", "200");
			};
		}else{
			resultMap.put("Code", "500");
		};
		return JSONObject.toJSONString(resultMap);
	}

	/**
	 * 逻辑删除一个店员
	 * fsc
	 * @param user
	 * @return
	 * 2017年12月9日下午3:00:31
	 */
	@Override
	public String delOneUser(User user) {
		//储存插入正确正确代码
		Map<String,String> resultMap=new HashMap<String,String>();
		if(userDao.delOneUser(user)==1) {
			resultMap.put("Code", "200");
		}else{
			resultMap.put("Code", "500");
		};
		return JSONObject.toJSONString(resultMap);
	}

	/**
	 * 查询所有身份
	 * fsc
	 * @return
	 * 2017年12月9日下午7:06:01
	 */
	@Override
	public String selAllRole() {
		List<?> list=userDao.selAllRole();
		String jsar=JSONArray.toJSONString(list);
		return jsar;
	}

}

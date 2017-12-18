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
	 * ����һ��jsonobject��������
	 * fsc
	 * @param user
	 * @return
	 * 2017��12��3������6:15:33
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
	 * ��ҳ��ѯ�û�
	 * fsc
	 * @param page
	 * @return
	 * 2017��12��4������4:52:22
	 */
	@Override
	public String selAllUser(Map<String,String> map) {
		List<?> list=userDao.selAllUser(map);
		//layui��Ҫ����
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
	 * ��ѯһ���û�����ݸ���id 
	 * fsc
	 * @param userid
	 * @return
	 * 2017��12��6������12:07:12
	 */
	@Override
	public String selOneUserById(String userid) {
		List<?> list=userDao.selOneUserById(userid);
		String jstr=JSONObject.toJSONString(list.get(0));
		return jstr;
	}

	/**
	 * ����һ���û�
	 * fsc
	 * @param user
	 * @return
	 * 2017��12��9������12:51:23
	 */
	@Override
	public String addOneUser(Map<String,String> map) {
		//���������ȷ��ȷ����
		Map<String,String> resultMap=new HashMap<String,String>(); 
		//��ѯ�Ƿ��������û�
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
				//�����û������ɫ
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
	 * �޸�һ���û�
	 * fsc
	 * @param user
	 * @return
	 * 2017��12��9������2:44:05
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
		//���������ȷ��ȷ����
		Map<String,String> resultMap=new HashMap<String,String>();
		if(userDao.updOneUser(user)==1) {
			//�޸�һ���û����
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
	 * �߼�ɾ��һ����Ա
	 * fsc
	 * @param user
	 * @return
	 * 2017��12��9������3:00:31
	 */
	@Override
	public String delOneUser(User user) {
		//���������ȷ��ȷ����
		Map<String,String> resultMap=new HashMap<String,String>();
		if(userDao.delOneUser(user)==1) {
			resultMap.put("Code", "200");
		}else{
			resultMap.put("Code", "500");
		};
		return JSONObject.toJSONString(resultMap);
	}

	/**
	 * ��ѯ�������
	 * fsc
	 * @return
	 * 2017��12��9������7:06:01
	 */
	@Override
	public String selAllRole() {
		List<?> list=userDao.selAllRole();
		String jsar=JSONArray.toJSONString(list);
		return jsar;
	}

}

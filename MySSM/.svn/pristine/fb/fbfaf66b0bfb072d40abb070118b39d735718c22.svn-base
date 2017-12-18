package com.org.fsc.ssh.user.service;

import java.util.Map;

import com.org.fsc.ssh.bean.Page;
import com.org.fsc.ssh.bean.User;

public interface UserService {
	
	//处理登录
	String handleUser(User user);
	
	//查询所有用户
    String selAllUser(Map<String,String> map);
    
    //查询一个用户的身份根据id 
  	String selOneUserById(String userid);
  	
  	//新增一个用户
  	String addOneUser(Map<String,String> map);
  	
  	//修改一个用户
  	String updOneUser(Map<String,String> map);
  	//逻辑删除一个店员
  	String delOneUser(User user);
  	
  	//查询所有身份
  	String selAllRole();
}

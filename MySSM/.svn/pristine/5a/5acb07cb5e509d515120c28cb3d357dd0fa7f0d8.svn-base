package com.org.fsc.ssh.controller;

import java.io.File;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.bind.annotation.XmlList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;
import com.org.fsc.ssh.bean.User;
import com.org.fsc.ssh.common.CommonController;
import com.org.fsc.ssh.user.dao.UserDao;

import jxl.Workbook;
import jxl.format.UnderlineStyle;
import jxl.write.Colour;
import jxl.write.Label;
import jxl.write.WritableCellFormat;
import jxl.write.WritableFont;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;


@Controller
@RequestMapping("/User")
public class UserController extends CommonController {

	/**
	 * 登陆接口,正确返回jsonobject形势String代码1,错误返回jsonobject形势错误代码0
	 * fsc
	 * @param user
	 * @return
	 * 2017年12月3日下午6:16:05
	 */
	@RequestMapping(value="/handleLogin",produces="text/html;charset=UTF-8")
	@ResponseBody
	public String handleLogin(User user) {
		//		System.out.println("进入了该controller");
		//		UsernamePasswordToken token =new UsernamePasswordToken(user.getUsername(),user.getUserpsw());
		//		 Subject currentUser = SecurityUtils.getSubject();  
		//         if (!currentUser.isAuthenticated()){
		//             //使用shiro来验证  
		//             token.setRememberMe(true);  
		//             currentUser.login(token);//验证角色和权限  
		//         } 
		return userService.handleUser(user);
	}

	//	@RequestMapping(value="/handleLogin",produces="text/html;charset=UTF-8",method=RequestMethod.GET)
	//	public String handleLogin() {
	//		return "/login.jsp";
	//	}
	//	
	/**
	 * 后台分页查询所有人员
	 * fsc
	 * @param request
	 * @return
	 * 2017年12月9日下午12:47:11
	 */
	@RequestMapping(value="/selAllUser",produces="text/html;charset=UTF-8")
	@ResponseBody
	public String selAllUser(HttpServletRequest request) {
		String page=request.getParameter("page");
		String limit=request.getParameter("limit");
		String id=request.getParameter("id");
		String name=request.getParameter("name");
		String psw=request.getParameter("psw");
		String realname=request.getParameter("realname");
		Map<String,String> map=new HashMap<String,String>();
		map.put("page", page);
		map.put("limit", limit);
		map.put("id", "%"+id+"%");
		map.put("name", "%"+name+"%");
		map.put("psw", "%"+psw+"%");
		map.put("realname", "%"+realname+"%");
		return userService.selAllUser(map);
	}

	/**
	 * 新增一个店员
	 * fsc
	 * @return
	 * 2017年12月9日下午1:14:07
	 */
	@RequestMapping(value="/addOneUser",produces="text/html;charset=UTF-8")
	@ResponseBody
	public String addOneUser(User user,String roleid) {
		//新增用户默认都是未删除
		user.setIsdel("0");
		String userjsob=JSONObject.toJSONString(user);
		Map<String,String> map=(Map<String, String>) JSONObject.parse(userjsob);
		map.put("roleid", roleid);
		return userService.addOneUser(map);
	}

	/**
	 * 修改一个店员信息
	 * fsc
	 * @param user
	 * @return
	 * 2017年12月9日下午2:59:12
	 */
	@RequestMapping(value="/addOrUpdOneUser",produces="text/html;charset=UTF-8")
	@ResponseBody
	public String updOneUser(User user,String roleid) {
		String tempJson=JSONObject.toJSONString(user);
		if(user.getUserid()==null || user.getUserid()=="") {
			Map<String,String> map=(Map<String, String>) JSONObject.parse(tempJson);
			map.put("roleid", roleid);
			//新增用户默认都是未删除
			map.put("isdel", "0");
			return userService.addOneUser(map);
		}else {
			Map<String,String> map=(Map<String, String>) JSONObject.parse(tempJson);
			map.put("roleid", roleid);
			return userService.updOneUser(map);
		}
	}

	/**
	 * 逻辑删除一个店员
	 * fs
	 * @param user
	 * @return
	 * 2017年12月9日下午2:59:46
	 */
	@RequestMapping(value="/delOneUser",produces="text/html;charset=UTF-8")
	@ResponseBody
	public String delOneUser(User user) {
		return userService.delOneUser(user);
	}

	/**
	 * 查询所有身份
	 * fsc
	 * @return
	 * 2017年12月9日下午7:05:45
	 */
	@RequestMapping(value="/selAllRole",produces="text/html;charset=UTF-8")
	@ResponseBody
	public String selAllRole() {
		return userService.selAllRole();
	}

	/**
	 * 查询一个用户通过id
	 * fsc
	 * @param userid
	 * @return
	 * 2017年12月9日下午10:32:13
	 */
	@RequestMapping(value="/selOneUserById",produces="text/html;charset=UTF-8")
	@ResponseBody
	public String selOneUserById(String userid) {
		return userService.selOneUserById(userid);
	}

	@RequestMapping(value="/outputExcel",produces="text/html;charset=UTF-8")
	@ResponseBody
	public String outputExcel(HttpServletResponse response) throws Exception {
		List<?> list=userdao.ouputExcel();
		OutputStream os = response.getOutputStream();// 取得输出流   
		response.reset();// 清空输出流   
		response.setHeader("Content-disposition", "attachment; filename=userinfo.xls");// 设定输出文件头   
		response.setContentType("application/msexcel");// 定义输出类型 
		Label labelId=new Label(0,0,"编号(id)");//表示第
		Label labelName=new Label(1,0,"帐号(name)");
		Label labelPsw=new Label(2,0,"密码(sex)");
		Label labelUrealname=new Label(3,0,"真实姓名(num)");
		Label labelIsdel=new Label(4,0,"是否被删除(num)");
//		String filename="d://userinfo.xls";
//		File file=new File(filename);
//		if (!file.exists()) {
//			if(file.createNewFile()) {
//
//			}else{
//				System.out.println("创建文件失败");
//			};
//		}
		WritableWorkbook wrtw=Workbook.createWorkbook(os);
		WritableSheet wtsh=wrtw.createSheet("My Test 1", 0);
		wtsh.addCell(labelId);
		wtsh.addCell(labelName);
		wtsh.addCell(labelPsw);
		wtsh.addCell(labelUrealname);
		wtsh.addCell(labelIsdel);
		for(int i=0;i<list.size();i++){   
			Map<String,String> map=(Map<String, String>) list.get(i);
			int a=0;
			wtsh.addCell(new Label(a, i+1, map.get("USERID")));   
			wtsh.addCell(new Label(a+1, i+1, map.get("USERNAME"))); 
			wtsh.addCell(new Label(a+2, i+1, map.get("USERPSW")));
			wtsh.addCell(new Label(a+3, i+1, map.get("USERREALNAME")));
			wtsh.addCell(new Label(a+4, i+1, map.get("ISDEL")));
		}           
		// 主体内容生成结束           
		wrtw.write(); // 写入文件   
		wrtw.close();  
		os.close(); // 关闭流
		return null; 
	}
	@Autowired
	private UserDao userdao;
}

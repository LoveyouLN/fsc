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
	 * ��½�ӿ�,��ȷ����jsonobject����String����1,���󷵻�jsonobject���ƴ������0
	 * fsc
	 * @param user
	 * @return
	 * 2017��12��3������6:16:05
	 */
	@RequestMapping(value="/handleLogin",produces="text/html;charset=UTF-8")
	@ResponseBody
	public String handleLogin(User user) {
		//		System.out.println("�����˸�controller");
		//		UsernamePasswordToken token =new UsernamePasswordToken(user.getUsername(),user.getUserpsw());
		//		 Subject currentUser = SecurityUtils.getSubject();  
		//         if (!currentUser.isAuthenticated()){
		//             //ʹ��shiro����֤  
		//             token.setRememberMe(true);  
		//             currentUser.login(token);//��֤��ɫ��Ȩ��  
		//         } 
		return userService.handleUser(user);
	}

	//	@RequestMapping(value="/handleLogin",produces="text/html;charset=UTF-8",method=RequestMethod.GET)
	//	public String handleLogin() {
	//		return "/login.jsp";
	//	}
	//	
	/**
	 * ��̨��ҳ��ѯ������Ա
	 * fsc
	 * @param request
	 * @return
	 * 2017��12��9������12:47:11
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
	 * ����һ����Ա
	 * fsc
	 * @return
	 * 2017��12��9������1:14:07
	 */
	@RequestMapping(value="/addOneUser",produces="text/html;charset=UTF-8")
	@ResponseBody
	public String addOneUser(User user,String roleid) {
		//�����û�Ĭ�϶���δɾ��
		user.setIsdel("0");
		String userjsob=JSONObject.toJSONString(user);
		Map<String,String> map=(Map<String, String>) JSONObject.parse(userjsob);
		map.put("roleid", roleid);
		return userService.addOneUser(map);
	}

	/**
	 * �޸�һ����Ա��Ϣ
	 * fsc
	 * @param user
	 * @return
	 * 2017��12��9������2:59:12
	 */
	@RequestMapping(value="/addOrUpdOneUser",produces="text/html;charset=UTF-8")
	@ResponseBody
	public String updOneUser(User user,String roleid) {
		String tempJson=JSONObject.toJSONString(user);
		if(user.getUserid()==null || user.getUserid()=="") {
			Map<String,String> map=(Map<String, String>) JSONObject.parse(tempJson);
			map.put("roleid", roleid);
			//�����û�Ĭ�϶���δɾ��
			map.put("isdel", "0");
			return userService.addOneUser(map);
		}else {
			Map<String,String> map=(Map<String, String>) JSONObject.parse(tempJson);
			map.put("roleid", roleid);
			return userService.updOneUser(map);
		}
	}

	/**
	 * �߼�ɾ��һ����Ա
	 * fs
	 * @param user
	 * @return
	 * 2017��12��9������2:59:46
	 */
	@RequestMapping(value="/delOneUser",produces="text/html;charset=UTF-8")
	@ResponseBody
	public String delOneUser(User user) {
		return userService.delOneUser(user);
	}

	/**
	 * ��ѯ�������
	 * fsc
	 * @return
	 * 2017��12��9������7:05:45
	 */
	@RequestMapping(value="/selAllRole",produces="text/html;charset=UTF-8")
	@ResponseBody
	public String selAllRole() {
		return userService.selAllRole();
	}

	/**
	 * ��ѯһ���û�ͨ��id
	 * fsc
	 * @param userid
	 * @return
	 * 2017��12��9������10:32:13
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
		OutputStream os = response.getOutputStream();// ȡ�������   
		response.reset();// ��������   
		response.setHeader("Content-disposition", "attachment; filename=userinfo.xls");// �趨����ļ�ͷ   
		response.setContentType("application/msexcel");// ����������� 
		Label labelId=new Label(0,0,"���(id)");//��ʾ��
		Label labelName=new Label(1,0,"�ʺ�(name)");
		Label labelPsw=new Label(2,0,"����(sex)");
		Label labelUrealname=new Label(3,0,"��ʵ����(num)");
		Label labelIsdel=new Label(4,0,"�Ƿ�ɾ��(num)");
//		String filename="d://userinfo.xls";
//		File file=new File(filename);
//		if (!file.exists()) {
//			if(file.createNewFile()) {
//
//			}else{
//				System.out.println("�����ļ�ʧ��");
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
		// �����������ɽ���           
		wrtw.write(); // д���ļ�   
		wrtw.close();  
		os.close(); // �ر���
		return null; 
	}
	@Autowired
	private UserDao userdao;
}

package com.org.fsc.ssh.controller;

import java.io.File;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.log4j.MDC;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;
import com.org.fsc.ssh.common.CommonController;

@Controller
@RequestMapping("/Food")
public class FoodController extends CommonController {

	/**
	 * 查询所有食物[{"id":"","name":"","list":[{list1}{list2}]}]
	 * fsc
	 * @return
	 * 2017年12月5日下午3:39:50
	 */
	@RequestMapping(value="/getAllFood",produces="text/html;charset=UTF-8")
	@ResponseBody
	public String getAllFood() {
		MDC.put("method", "getAllFood");
		return foodService.getAllFood();
	}

	/**
	 * 后台模糊查询所有食物并分页
	 * fsc
	 * @return
	 * 2017年12月12日上午10:31:21
	 */
	@RequestMapping(value="/getAllFoodInfo",produces="text/html;charset=UTF-8")
	@ResponseBody
	public String getAllFoodInfo(HttpServletRequest request) {
		Map<String,String> inputMap=new HashMap<String,String>();
		String page=request.getParameter("page");
		String limit=request.getParameter("limit");
		String foodid=request.getParameter("foodid");
		String foodname=request.getParameter("foodname");
		String price=request.getParameter("price");
		String statu=request.getParameter("statu");
		inputMap.put("page", page);
		inputMap.put("limit", limit);
		inputMap.put("myfoodid", "%"+foodid+"%");
		inputMap.put("myfoodname", "%"+foodname+"%");
		inputMap.put("price", "%"+price+"%");
		if(statu==null) {
			inputMap.put("isdel", "%"+statu+"%");
		}else {
			if(statu!=null & statu.equals("正常")) {
				inputMap.put("isdel", "%"+0+"%");
			}else if(statu!=null &  statu.equals("已删除")) {
				inputMap.put("isdel", "%"+1+"%");
			}else{
				inputMap.put("isdel", "%"+statu+"%");
			}
		}
		return foodService.getAllFoodInfo(inputMap);
	}


	/**
	 * 新增一个食物
	 * fsc
	 * @param map
	 * @return
	 * 2017年12月5日下午4:09:59
	 */
	@RequestMapping(value="/addOneFood",produces="text/html;charset=UTF-8")
	@ResponseBody
	public String addOneFood(HttpServletRequest request,HttpServletResponse response) {
		//从item_upload.jsp中拿取数据，因为上传页的编码格式跟一般的不同，使用的是enctype="multipart/form-data"  
		//form提交采用multipart/form-data,无法采用req.getParameter()取得数据  
		String foodid = request.getParameter("foodid"); 
		String price = request.getParameter("price");
		/********************************使用 FileUpload 组件解析表单********************/  

		//DiskFileItemFactory：创建 FileItem 对象的工厂，在这个工厂类中可以配置内存缓冲区大小和存放临时文件的目录。  
		DiskFileItemFactory factory = new DiskFileItemFactory();  
		// maximum size that will be stored in memory 超过这个大小 将临时存到磁盘
		factory.setSizeThreshold(4096);  
		// the location for saving data that is larger than getSizeThreshold() 将保存到这里 
		//在接收上传文件数据时，会将内容保存到内存缓存区中，如果文件内容超过了 DiskFileItemFactory 指定的缓冲区的大小，  
		//那么文件将被保存到磁盘上，存储为 DiskFileItemFactory 指定目录中的临时文件。  
		factory.setRepository(new File("d://aaa"));  



		//等文件数据都接收完毕后，ServletUpload再从文件中将数据写入到上传文件目录下的文件中    
		ServletFileUpload upload = new ServletFileUpload(factory);  
		// maximum size before a FileUploadException will be thrown  
		//upload.setSizeMax(1000000 * 20); 
		//设置上传单个文件的大小的最大值，目前是设置为1024*1024字节，也就是1MB
		upload.setFileSizeMax(1024*1024*10);
		//设置上传文件总量的最大值，最大值=同时上传的多个文件的大小的最大值的和，目前设置为10MB
		upload.setSizeMax(1024*1024*30);

		//监听文件上传进度	
		//        upload.setProgressListener(new ProgressListener(){
		//            public void update(long pBytesRead, long pContentLength, int arg2) {
		//                System.out.println("文件大小为：" + pContentLength + ",当前已处理：" + pBytesRead);
		//            }
		//        });
		//解决上传文件名的中文乱码
		upload.setHeaderEncoding("UTF-8");

		/*******************************解析表单传递过来的数据，返回List集合数据-类型:FileItem***********/  

		try {  
			//ServletFileUpload：负责处理上传的文件数据，并将每部分的数据封装成一到 FileItem 对象中。  
			List fileItems = upload.parseRequest(request);  
			String itemNo = "";  
			Iterator<FileItem> iterator = fileItems.iterator();
			while ( iterator.hasNext()) {  
				//获得序列中的下一个元素  
				FileItem item =iterator.next();  
				//判断是文件还是文本信息  
				//是普通的表单输入域  
				if(item.isFormField()) {  
					if ("itemNo".equals(item.getFieldName())) {  
						itemNo = item.getString();  
					}  
				}  
				//是文件
				if (!item.isFormField()) {                    
					//上传文件的名称和完整路径  
					String fileName = item.getName();  
					long size = item.getSize();  
					//判断是否选择了文件  
					if ((fileName == null || fileName.equals("")) && size == 0) {  
						//如果为选择文件 ，跳出当前循环，进入下一次循环
						continue;  
					}  
					//截取字符串 如：C:\WINDOWS\Debug\PASSWD.LOG  
					fileName = fileName.substring(fileName.lastIndexOf("\\") + 1, fileName.length());  

					// 保存文件在服务器的物理磁盘中：第一个参数是：完整路径（不包括文件名）第二个参数是：文件名称     
					//item.write(file);  
					//修改文件名和物料名一致，且强行修改了文件扩展名为gif  
					//item.write(new File(uploadPath, itemNo + ".gif"));  
					//将文件保存到目录下，不修改文件名  
					File file=new File("", fileName);
					item.write(file);  
					//将图片文件名写入打数据库                    
					//itemManager.uploadItemImage(itemNo, fileName);  
				}  
			}  
			response.getWriter().write("500"); 
		} catch (Exception e) {  
			e.printStackTrace();  
			System.out.println("上传失败");
		}    


		return foodService.addOneFood("");
	}

	/**
	 * 删除恢复一个食物
	 * fsc
	 * @param map
	 * @return
	 * 2017年12月5日下午4:10:12
	 */
	@RequestMapping(value="/delOrRecoverOneFood",produces="text/html;charset=UTF-8")
	@ResponseBody
	public String delOrRecoverOneFood(HttpServletRequest request) {
		String foodid=request.getParameter("foodid");
		String isdel=request.getParameter("isdel");
		Map<String,String> map=new HashMap<String,String>();
		map.put("myfoodid", foodid);
		map.put("isdel", isdel);
		return foodService.delOrRecoverOneFood(JSONObject.toJSONString(map));
	}

	/**
	 * 逻辑删除一个食物
	 * fsc
	 * @param map
	 * @return
	 * 2017年12月5日下午4:10:23
	 */
	@RequestMapping(value="/delOneFood",produces="text/html;charset=UTF-8")
	@ResponseBody
	public String delOneFood(String map) {
		return foodService.delOneFood(map);
	}

	/**
	 * 查询一个食物通过id
	 * fsc
	 * @param map
	 * @return
	 * 2017年12月12日下午3:56:56
	 */
	@RequestMapping(value="/selOneFoodById",produces="text/html;charset=UTF-8")
	@ResponseBody
	public String selOneFoodById(String foodid) {
		return foodService.selOneFoodById(foodid);
	}

}

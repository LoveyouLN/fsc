package com.org.fsc.interceptor;



import java.util.Enumeration;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.MDC;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class MyInterceptor extends HandlerInterceptorAdapter {
	private final Logger log = LoggerFactory.getLogger(HandlerInterceptorAdapter.class);
	/** 
     * 在业务处理器处理请求执行完成后,生成视图之前执行的动作    
     * 可在modelAndView中加入数据，比如当前时间 
     */ 
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("--------------请求执行完成后，生成视图之前-----------------");
			//super.postHandle(request, response, handler, modelAndView);
	}
	
	 /**  
     * 在业务处理器处理请求之前被调用  
     * 如果返回false  
     *     从当前的拦截器往回执行所有拦截器的afterCompletion(),再退出拦截器链 
     * 如果返回true  
     *    执行下一个拦截器,直到所有的拦截器都执行完毕  
     *    再执行被拦截的Controller  
     *    然后进入拦截器链,  
     *    从最后一个拦截器往回执行所有的postHandle()  
     *    接着再从最后一个拦截器往回执行所有的afterCompletion()  
     */ 
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		// TODO Auto-generated method stub
		//提交方式
		String getMethod=request.getMethod();
		//获取request字符编码
		String getCharacterEncoding=request.getCharacterEncoding();
		//获取cookies
		Cookie[] getCookies=request.getCookies();
		//获取uri后面包含的查询字符串
		String getQueryString=request.getQueryString();
		//以枚举类型返回所有参数名称
		Enumeration<String> getParameterNames=request.getParameterNames();
		//以字符数组类型返回所有指定name的参数值 request.getParameterValues("");
		//以java.util.Map类型所有参数值 request.getParameterMap();
		//返回使用的协议版本(例如HTTP/1.1)
		String getProtocol=request.getProtocol();
		//返回用户的ip地址
		String getRemoteAddr=request.getRemoteAddr();
		//返回用户的主机名称
		String getRemoteHost=request.getRemoteHost();
		//获取端口号
		int getLocalPort=request.getLocalPort();
		//获取用户主机端口
		int getRemotePort=request.getRemotePort();
		//获取用户端的sessionId
		String getRequestedSessionId=request.getRequestedSessionId();
		//获取请求的uri,不包括查询字符串
		String getRequestURI=request.getRequestURI();
		//返回请求的全部URL,包括协议、服务器名字和端口、请求的URL，但不包括请求的查询字符串
		StringBuffer getRequestURL=request.getRequestURL();
		//返回登陆用户的名称
		String getRemoteUser=request.getRemoteUser();
		//返回指定name的标题头 request.getHeader("");
		//以枚举类型返回所有标题头 request.getHeaderNames();以枚举类型返回所有指定name的标题头 request.getHeaders("");
		//以整数类型返回所有指定name的标题头 request.getIntHeader("");以日期类型返回指定name的标题头 request.getDateHeader("");
		//用法等同于equals但是忽略大小写
    	if ("GET".equalsIgnoreCase(request.getMethod())) {  System.out.println("我是GET访问"); }  
		 System.err.println("提交的方式:"+getMethod);
		 System.err.println("获取request字符编码:"+getCharacterEncoding);
		// log.info("获取cookies:"+getCookies.toString());
		 System.err.println("获取uri后面包含的查询字符串:"+getQueryString);
		 System.err.println("以枚举类型返回所有参数名称:"+getParameterNames.toString());
		 System.err.println("返回使用的协议版本(例如HTTP/1.1):"+getProtocol);
		 System.err.println("返回用户的ip地址:"+getRemoteAddr);
		 System.err.println("返回用户的主机名称:"+getRemoteHost);
		 System.err.println("获取用户端的sessionId:"+getRequestedSessionId);
		 System.err.println("获取请求的uri,不包括查询字符串:"+getRequestURI);
		 System.err.println("返回请求的全部URL,包括协议、服务器名字和端口、请求的URL，但不包括请求的查询字符串:"+getRequestURL.toString());
		 System.err.println("返回登陆用户的名称:"+getRemoteUser);
//		return super.preHandle(request, response, handler);
		 request.setCharacterEncoding("UTF-8");
		 MDC.put("ip", getRemoteAddr);
		return true;
	}
	
	 /**  
     * 在DispatcherServlet完全处理完请求后被调用,可用于清理资源等   
     *   
     * 当有拦截器抛出异常时,会从当前拦截器往回执行所有的拦截器的afterCompletion()  
     */ 
	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		// TODO Auto-generated method stub
		//super.afterCompletion(request, response, handler, ex);
		System.out.println("--------------完全处理请求后----------------------");
	}
	

}

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
     * ��ҵ��������������ִ����ɺ�,������ͼ֮ǰִ�еĶ���    
     * ����modelAndView�м������ݣ����統ǰʱ�� 
     */ 
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("--------------����ִ����ɺ�������ͼ֮ǰ-----------------");
			//super.postHandle(request, response, handler, modelAndView);
	}
	
	 /**  
     * ��ҵ��������������֮ǰ������  
     * �������false  
     *     �ӵ�ǰ������������ִ��������������afterCompletion(),���˳��������� 
     * �������true  
     *    ִ����һ��������,ֱ�����е���������ִ�����  
     *    ��ִ�б����ص�Controller  
     *    Ȼ�������������,  
     *    �����һ������������ִ�����е�postHandle()  
     *    �����ٴ����һ������������ִ�����е�afterCompletion()  
     */ 
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		// TODO Auto-generated method stub
		//�ύ��ʽ
		String getMethod=request.getMethod();
		//��ȡrequest�ַ�����
		String getCharacterEncoding=request.getCharacterEncoding();
		//��ȡcookies
		Cookie[] getCookies=request.getCookies();
		//��ȡuri��������Ĳ�ѯ�ַ���
		String getQueryString=request.getQueryString();
		//��ö�����ͷ������в�������
		Enumeration<String> getParameterNames=request.getParameterNames();
		//���ַ��������ͷ�������ָ��name�Ĳ���ֵ request.getParameterValues("");
		//��java.util.Map�������в���ֵ request.getParameterMap();
		//����ʹ�õ�Э��汾(����HTTP/1.1)
		String getProtocol=request.getProtocol();
		//�����û���ip��ַ
		String getRemoteAddr=request.getRemoteAddr();
		//�����û�����������
		String getRemoteHost=request.getRemoteHost();
		//��ȡ�˿ں�
		int getLocalPort=request.getLocalPort();
		//��ȡ�û������˿�
		int getRemotePort=request.getRemotePort();
		//��ȡ�û��˵�sessionId
		String getRequestedSessionId=request.getRequestedSessionId();
		//��ȡ�����uri,��������ѯ�ַ���
		String getRequestURI=request.getRequestURI();
		//���������ȫ��URL,����Э�顢���������ֺͶ˿ڡ������URL��������������Ĳ�ѯ�ַ���
		StringBuffer getRequestURL=request.getRequestURL();
		//���ص�½�û�������
		String getRemoteUser=request.getRemoteUser();
		//����ָ��name�ı���ͷ request.getHeader("");
		//��ö�����ͷ������б���ͷ request.getHeaderNames();��ö�����ͷ�������ָ��name�ı���ͷ request.getHeaders("");
		//���������ͷ�������ָ��name�ı���ͷ request.getIntHeader("");���������ͷ���ָ��name�ı���ͷ request.getDateHeader("");
		//�÷���ͬ��equals���Ǻ��Դ�Сд
    	if ("GET".equalsIgnoreCase(request.getMethod())) {  System.out.println("����GET����"); }  
		 System.err.println("�ύ�ķ�ʽ:"+getMethod);
		 System.err.println("��ȡrequest�ַ�����:"+getCharacterEncoding);
		// log.info("��ȡcookies:"+getCookies.toString());
		 System.err.println("��ȡuri��������Ĳ�ѯ�ַ���:"+getQueryString);
		 System.err.println("��ö�����ͷ������в�������:"+getParameterNames.toString());
		 System.err.println("����ʹ�õ�Э��汾(����HTTP/1.1):"+getProtocol);
		 System.err.println("�����û���ip��ַ:"+getRemoteAddr);
		 System.err.println("�����û�����������:"+getRemoteHost);
		 System.err.println("��ȡ�û��˵�sessionId:"+getRequestedSessionId);
		 System.err.println("��ȡ�����uri,��������ѯ�ַ���:"+getRequestURI);
		 System.err.println("���������ȫ��URL,����Э�顢���������ֺͶ˿ڡ������URL��������������Ĳ�ѯ�ַ���:"+getRequestURL.toString());
		 System.err.println("���ص�½�û�������:"+getRemoteUser);
//		return super.preHandle(request, response, handler);
		 request.setCharacterEncoding("UTF-8");
		 MDC.put("ip", getRemoteAddr);
		return true;
	}
	
	 /**  
     * ��DispatcherServlet��ȫ����������󱻵���,������������Դ��   
     *   
     * �����������׳��쳣ʱ,��ӵ�ǰ����������ִ�����е���������afterCompletion()  
     */ 
	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		// TODO Auto-generated method stub
		//super.afterCompletion(request, response, handler, ex);
		System.out.println("--------------��ȫ���������----------------------");
	}
	

}

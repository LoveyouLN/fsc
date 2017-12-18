package com.org.fsc.interceptor;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;
import javax.servlet.http.HttpSession;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

@Aspect
@Component
public class MyLog4jInterceptor {
	public int aaaaaaaa;
	private final Logger logger=LoggerFactory.getLogger(this.getClass());
	//什么人
	private String username=null;
	//开始时间
	private String beginTime=null;
	//执行时间
	private String exeTime=null;
	//结束时间
	private String endTime=null;
	//执行的方法名
	private String exeMethodName=null;
	//传入的参数
	private Map<?,?> inparameter=null;
	//返回的结果
	private Map<String,Object> returnResult=null;
	//获取请求的地址
	private String pleaseurl=null;


	/**
	 * 方法执行前执行
	 * fsc
	 * @param joinPoint
	 * 2017年12月6日下午2:05:16
	 */
	@Before("execution(* com.org.fsc..*.*(..))")
	public void beforeMethod(JoinPoint joinPoint) {
		SimpleDateFormat sm=new SimpleDateFormat("YYYY-MM-dd HH:mm:ss");
		beginTime=sm.format(new Date());
		ServletRequestAttributes servletRequestAttributes=(ServletRequestAttributes) RequestContextHolder.currentRequestAttributes();
		HttpSession session=servletRequestAttributes.getRequest().getSession();
		//username=(String) session.getAttribute("");
		logger.info("方法开始时间:"+beginTime+"-执行的方法名:"+joinPoint.getTarget().getClass().getName());
	}

	/**
	 * 环绕执行
	 * fsc
	 * @param pjp
	 * @return
	 * 2017年12月6日下午2:06:06
	 * @throws Throwable 
	 */
	@Around("execution(* com.org.fsc..*.*(..))")
	public Object aroundMethod(ProceedingJoinPoint pjp) throws Throwable {
		/**
		 * 从org.springframework.web.context.request.RequestContextHolder
		 * 拿到RequestAttributes,强转成ServletRequestAttributes,再获得HttpServletRequest
		 */
//		RequestAttributes ra=RequestContextHolder.getRequestAttributes();
//		ServletRequestAttributes sra=(ServletRequestAttributes) ra;
//		HttpServletRequest request=sra.getRequest();
//		inparameter=request.getParameterMap();
//		pleaseurl=request.getRequestURI();
		Object result=pjp.proceed();
//		returnResult = new HashMap<String, Object>();
//		returnResult.put("result", result);
//		StackTraceElement targetStackTraceElement =(new Exception()).getStackTrace()[1];
//		logger.info("执行的方法名:"+targetStackTraceElement.getMethodName());
//		logger.info("执行的类名:"+targetStackTraceElement.getClassName());
//		logger.info("执行的文件名:"+targetStackTraceElement.getFileName());
//		logger.info("执行的第几行方法名:"+targetStackTraceElement.getLineNumber());
		return result;
	}

	/**
	 * 方法执行后执行
	 * fsc
	 * @param joinPoint
	 * 2017年12月6日下午2:06:11
	 */
	@After("execution(* com.org.fsc..*.*(..))")
	public void afterMethod(JoinPoint joinPoint) {
		SimpleDateFormat sm=new SimpleDateFormat("YYYY-MM-dd HH:mm:ss");
		endTime=sm.format(new Date());
		logger.info("方法结束时间:"+endTime+"-共耗时:"+(beginTime.hashCode()-endTime.hashCode()));
	}
	
	public static void main(String[] args) {
		String a="2017-12-14 14:14:44";
		System.out.println(a.hashCode());
	}

}

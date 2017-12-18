package com.org.fsc.interceptor;

import java.sql.Connection;
import java.util.Properties;

import org.apache.ibatis.executor.statement.PreparedStatementHandler;
import org.apache.ibatis.executor.statement.RoutingStatementHandler;
import org.apache.ibatis.executor.statement.StatementHandler;
import org.apache.ibatis.mapping.BoundSql;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.plugin.Intercepts;
import org.apache.ibatis.plugin.Invocation;
import org.apache.ibatis.plugin.Plugin;
import org.apache.ibatis.plugin.Signature;

import com.org.fsc.util.ReflectHelper;

@Intercepts({@Signature(type=StatementHandler.class,method="prepare",args={Connection.class})})
public class MyBatiesInterceptor implements Interceptor{

	private String dialog;
	@Override
	public Object intercept(Invocation arg0) throws Throwable {
		System.out.println("--------------------------intercept----------------------------------");
		RoutingStatementHandler target=(RoutingStatementHandler) arg0.getTarget();
		//反射获得RoutingStatementHandler target里属性名为delegate的PreparedStatementHandler  BaseStatementHandler
		PreparedStatementHandler delegate=(PreparedStatementHandler) ReflectHelper.getFieldValue(target, "delegate");
		//反射获得PreparedStatementHandler里属性名为boundSql的BoundSql
		// 这里为什么反射不到BoundSql boundSql=(BoundSql) ReflectHelper.getFieldValue(delegate, "boundSql");
		//反射获得BoundSql boundSql里属性名为sql的String
		BoundSql boundSql=delegate.getBoundSql();
		String beforeSql=ReflectHelper.getFieldValue(boundSql, "sql").toString();
		System.err.println("这里是mybaties插件~~~拦截执行的sql语句为："+beforeSql);
		return arg0.proceed();
	}

	@Override
	public Object plugin(Object arg0) {
		System.out.println("--------------------------plugin----------------------------------");
		
		return Plugin.wrap(arg0, this);
	}

	@Override
	public void setProperties(Properties arg0) {
		//System.out.println("第一次dialog:"+dialog);
		dialog=arg0.getProperty("dialect");
		//System.out.println("第二次dialog:"+dialog);
	}
	
	/**
	 *判断是否使用分页
	 * Administrator
	 * @param arg0
	 * @param object
	 * @param fieldName
	 * @return
	 * @throws SecurityException
	 * @throws IllegalArgumentException
	 * @throws NoSuchFieldException
	 * @throws IllegalAccessException
	 * 2017年11月21日
	 * 下午12:06:20
	 */
	public boolean isContines(String arg0,Object object,String fieldName) throws SecurityException, IllegalArgumentException, NoSuchFieldException, IllegalAccessException {
		MappedStatement mappedStatement=(MappedStatement) ReflectHelper.getFieldValue(object, fieldName);
		if(mappedStatement.getId().toString().contains(arg0)) {
			return true;
		}else {
			return false;
		}
	} 

}

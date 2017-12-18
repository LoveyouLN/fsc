package com.org.fsc.interceptor;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.Subject;

public class MyShiroInterceptor extends AuthorizingRealm{

	/**
	 * ��Ȩ
	 * fsc
	 * @param arg0
	 * @return
	 * 2017��12��6������3:53:43
	 */
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection arg0) {
		// TODO Auto-generated method stub
		String a=null;
		System.out.println("�ҽ�����doGetAuthorizationInfo");
		Subject currentUser = SecurityUtils.getSubject();
		UsernamePasswordToken token = new UsernamePasswordToken("zhang", "123");  
		currentUser.login(token);
		return null;
	}

	/**
	 * ��֤
	 * fsc
	 * @param arg0
	 * @return
	 * @throws AuthenticationException
	 * 2017��12��6������3:53:23
	 */
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken arg0) throws AuthenticationException {
		System.out.println("�ҽ�����doGetAuthenticationInfo+++");
		return null;
	}

}

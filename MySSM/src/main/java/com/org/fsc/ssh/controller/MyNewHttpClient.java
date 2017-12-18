package com.org.fsc.ssh.controller;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

public class MyNewHttpClient {
	//这里不知道写什么好
	private static MyNewHttpClient myNewHttpClient;


	/**
	 * 把构造方法设置为私有的，外界不能通过new得到该类
	 */
	private MyNewHttpClient() {

	}

	/**
	 * 一个简单的单例模式，保证程序只有一个MyNewHttpClient
	 * fsc
	 * @return
	 * 2017年12月15日上午10:55:21
	 */
	public static MyNewHttpClient getInstance() {
		if(myNewHttpClient==null) {
			return new MyNewHttpClient();
		}else {
			return myNewHttpClient;
		}
	}

	/**
	 * Httpclient模拟get请求
	 * fsc
	 * @param url
	 * @param headMap
	 * @return
	 * 2017年12月15日上午11:03:41
	 */
	public String get(String url,Map<String, String> headMap) {
		String result="";
		try {
			//创建一个能被关闭的httpclient
			CloseableHttpClient httpclient = HttpClients.createDefault();
			//创建一个httpGet，模拟get访问
			HttpGet httpGet=new HttpGet(url);
			//设置该get的head
			setGetHead(httpGet, headMap);
			//执行该get访问，并用可关闭的HttpResponse接收
			CloseableHttpResponse response =httpclient.execute(httpGet);
			try {
				System.out.println("响应状态:"+response.getStatusLine());
				//用HttpEntity接收返回的实体
				HttpEntity httpEntity=response.getEntity();
				/**
				 * 自己写的toString不用了，跟抄源代码差不多
				 * getResponseString(httpEntity);
				 */
				result=EntityUtils.toString(httpEntity);
				/**
				 * 下面这个方法是帮我们关闭该实体流,不使用它，我们手动关闭它,把源码拿出来
				 */
				//EntityUtils.consume(httpEntity);
				if (httpEntity != null) {
					InputStream inputStream=httpEntity.getContent();
					if (httpEntity.isStreaming()) {
						final InputStream instream = httpEntity.getContent();
						if (instream != null) {
							instream.close();
						}
					}
				}
			}finally {
				response.close();
			}	
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}

	/**
	 * 设置HttpGet的head
	 * fsc
	 * @param httpGet
	 * @param headMap
	 * 2017年12月15日上午11:08:41
	 */
	private void setGetHead(HttpGet httpGet,Map<String, String> headMap) {
		if(headMap!=null && headMap.size()>0) {
			Set<String> keySet=headMap.keySet();
			for (String key : keySet) {
				httpGet.addHeader(key,headMap.get(key));
			}
		}
	} 
	
	
	public String post(String url,Map<String, String> headMap,Map<String, String> paramMap) {
		String result=null;
		try {
			//创建一个能被关闭的httpclient
			CloseableHttpClient httpclient = HttpClients.createDefault();
			//创建一个httpPost，模拟post访问
			HttpPost httpPost=new HttpPost(url);
			//设置post头
			setPostHead(httpPost,headMap);
			//设置post参数
			setPostParams(httpPost,paramMap);
			//执行该post访问，并用可关闭的HttpResponse接收
			CloseableHttpResponse response=httpclient.execute(httpPost);
			//用HttpEntity接收返回的实体
			HttpEntity httpEntity = response.getEntity();
			if (httpEntity != null) {
				InputStream inputStream=httpEntity.getContent();
				if (httpEntity.isStreaming()) {
					final InputStream instream = httpEntity.getContent();
					if (instream != null) {
						instream.close();
					}
				}
			}
			try {
				System.out.println("响应状态:"+response.getStatusLine());
				
				result=EntityUtils.toString(httpEntity);
				/**
				 * 下面这个方法是帮我们关闭该实体流,不使用它，我们手动关闭它,把源码拿出来
				 */
				//EntityUtils.consume(httpEntity);
				if (httpEntity != null) {
					InputStream inputStream=httpEntity.getContent();
					if (httpEntity.isStreaming()) {
						final InputStream instream = httpEntity.getContent();
						if (instream != null) {
							instream.close();
						}
					}
				}
			}finally {
				response.close();
			}
		} catch (Exception e) {
			// TODO: handle exception
		}//创建一个能被关闭的httpclient
		return result;
	}
	
	/**
	 * 设置post头
	 * fsc
	 * @param entity
	 * @param headMap
	 * 2017年12月15日下午1:49:16
	 */
	private void setPostHead(HttpPost httpPost,Map<String, String> headMap) {
		//判断传入参数是否为空
		if(httpPost!=null && headMap.size()>0) {
			//用map的KeySet方法取map的Key
			Set<String> set=headMap.keySet();
			//循环添加httpPost头
			for (String key : set) {
				httpPost.addHeader(key,headMap.get(key));
			}
		}
	}
	
	private void setPostParams(HttpPost httpPost,Map<String, String> paramMap) {
		//判断传入参数是否为空
		if(httpPost!=null && paramMap!=null && paramMap.size()>0) {
			List<NameValuePair> listNameValuePair = new ArrayList<NameValuePair>(); 
		}
	}

	/**
	 * 将返回结果转成String
	 * fsc
	 * @param entity
	 * @return
	 * 2017年12月15日下午1:21:34
	 */
	private String getResponseString(HttpEntity entity) {
		if(entity==null) {
			return null;
		}else {
			try {
				//用流得到实体内容
				InputStream is = entity.getContent();
				//创建一个StringBuffer容器
				StringBuffer sb=new StringBuffer();
				//创建一个字节组，初始大小为4096
				byte[] b = new byte[4096]; 
				int r=0;
				while ( ( r = is.read(b) ) > 0 ) {  
					sb.append(new String(b, 0, r, "UTF-8"));  
				}  
				return sb.toString(); 
			} catch (UnsupportedOperationException | IOException e) {
				e.printStackTrace();
			}
			return null;
		}

	}

}

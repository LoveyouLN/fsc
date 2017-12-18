package com.org.fsc.ssh.controller;

import java.io.IOException;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArraySet;

import javax.websocket.CloseReason;
import javax.websocket.OnClose;
import javax.websocket.OnError;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;

@ServerEndpoint("/MyWebSocket")
public class WebSocket {
	//静态变量，用来记录当前在线连接数。应该把它设计成线程安全的。  
    private static int onlineCount = 0;  
	private Session session;
    //concurrent包的线程安全Set，用来存放每个客户端对应的MyWebSocket对象。若要实现服务端与单一客户端通信的话，可以使用Map来存放，其中Key可以为用户标识  
    private static CopyOnWriteArraySet<WebSocket> webSocketSet = new CopyOnWriteArraySet<WebSocket>();  
	public WebSocket() {
		System.out.println("运行了构造函数");
	}
	
	//连接打开时执行
	@OnOpen
	public void OnOpen(Session session) {
		System.out.println("MyWebSocket打开");
		this.session=session;
		webSocketSet.add(this);
		addOnlineCount();
		 System.out.println("有新连接加入！当前在线人数为" + getOnlineCount());  
	}
	
	//收到消息时执行
	@OnMessage
	public String OnMessage(String message, Session session) {
		System.out.println("MyWebSocket收到消息:"+message);
		for (int i = 0; i < 5; i++) {
			return i+"";
		}
		return null;
	}

	
	 /**  
     * 连接关闭调用的方法  
     */  
    @OnClose  
    public void onClose(){  
        webSocketSet.remove(this);  //从set中删除  
        subOnlineCount();           //在线数减1      
        System.out.println("有一连接关闭！当前在线人数为" + getOnlineCount());  
    }  
	
	//连接错误时执行
	@OnError
	public void OnError(Throwable t) {
		t.printStackTrace();
	}
	
	/**
	 * 后台向前台推送文本消息
	 * fsc
	 * @param sendText
	 * 2017年12月3日下午3:45:02
	 */
	public  void sendMessage(String sendText) {
		try {
			Iterator<WebSocket> interator=webSocketSet.iterator();
			while(interator.hasNext()) {
				interator.next().session.getBasicRemote().sendText(sendText);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	public static synchronized int getOnlineCount() {  
        return onlineCount;  
    }  
   
    public static synchronized void addOnlineCount() {  
        WebSocket.onlineCount++;  
    }  
       
    public static synchronized void subOnlineCount() {  
        WebSocket.onlineCount--;  
    } 

}

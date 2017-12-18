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
	//��̬������������¼��ǰ������������Ӧ�ð�����Ƴ��̰߳�ȫ�ġ�  
    private static int onlineCount = 0;  
	private Session session;
    //concurrent�����̰߳�ȫSet���������ÿ���ͻ��˶�Ӧ��MyWebSocket������Ҫʵ�ַ�����뵥һ�ͻ���ͨ�ŵĻ�������ʹ��Map����ţ�����Key����Ϊ�û���ʶ  
    private static CopyOnWriteArraySet<WebSocket> webSocketSet = new CopyOnWriteArraySet<WebSocket>();  
	public WebSocket() {
		System.out.println("�����˹��캯��");
	}
	
	//���Ӵ�ʱִ��
	@OnOpen
	public void OnOpen(Session session) {
		System.out.println("MyWebSocket��");
		this.session=session;
		webSocketSet.add(this);
		addOnlineCount();
		 System.out.println("�������Ӽ��룡��ǰ��������Ϊ" + getOnlineCount());  
	}
	
	//�յ���Ϣʱִ��
	@OnMessage
	public String OnMessage(String message, Session session) {
		System.out.println("MyWebSocket�յ���Ϣ:"+message);
		for (int i = 0; i < 5; i++) {
			return i+"";
		}
		return null;
	}

	
	 /**  
     * ���ӹرյ��õķ���  
     */  
    @OnClose  
    public void onClose(){  
        webSocketSet.remove(this);  //��set��ɾ��  
        subOnlineCount();           //��������1      
        System.out.println("��һ���ӹرգ���ǰ��������Ϊ" + getOnlineCount());  
    }  
	
	//���Ӵ���ʱִ��
	@OnError
	public void OnError(Throwable t) {
		t.printStackTrace();
	}
	
	/**
	 * ��̨��ǰ̨�����ı���Ϣ
	 * fsc
	 * @param sendText
	 * 2017��12��3������3:45:02
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

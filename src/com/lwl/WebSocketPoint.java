package com.lwl;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.logging.Logger;

import javax.websocket.CloseReason;
import javax.websocket.EndpointConfig;
import javax.websocket.OnClose;
import javax.websocket.OnError;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.PongMessage;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;

import com.alibaba.fastjson.JSON;
import com.dyuproject.protostuff.ProtostuffIOUtil;
import com.dyuproject.protostuff.runtime.RuntimeSchema;

@ServerEndpoint(value = "/test")
public class WebSocketPoint {

	public static RuntimeSchema<UserInfo>  userInfoSchema = RuntimeSchema.createFrom(UserInfo.class);

	private static ConcurrentHashMap<String, Session> sessionMap = new ConcurrentHashMap<String, Session>();

	@OnOpen
	public void onOpen(Session session, EndpointConfig config) {

		sessionMap.put(session.getId(), session);
		System.out.println("onOpen 当前websocket连接数是: " + sessionMap.size());
		
	}

	@OnMessage
	public void onMessage(ByteBuffer msg, Session session) {
		System.out.println(msg.array().length);
		
		UserInfo userinfo = userInfoSchema.newMessage();
		ProtostuffIOUtil.mergeFrom(msg.array(), userinfo, userInfoSchema);
		
		System.out.println("hahaha "+JSON.toJSONString(userinfo));
	}
	
	@OnMessage
	public void onMessage(String msg, Session session) {
		System.out.println("onMessage wsSessionID " + session.getId() + " Server端接收 " + msg);
		
		System.out.println("onMessage String "+msg);
	}

	@OnMessage
	public void onPongMessage(PongMessage pong) {
		Logger.getLogger("lwl").info("-----pong----");
	}

	/**
	 * 向所有的websocket客户端发送消息
	 * 
	 * @param msg
	 */
	public void sendToMana(String msg) {
		Set<Entry<String, Session>> set = sessionMap.entrySet();
		try {
			for (Entry<String, Session> entry : set) {
				entry.getValue().getBasicRemote().sendText(msg);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@OnClose
	public void onClose(Session session, CloseReason reason) {
		Logger.getLogger("lwl").info("wsSession id " + session.getId() + " onClose 方法被执行了" + reason);
		sessionMap.remove(session.getId());
	}

	@OnError
	public void onError(Throwable error, Session session) {
		Logger.getLogger("lwl").info("" + error);
		error.printStackTrace();
	}

}

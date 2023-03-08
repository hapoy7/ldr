package com.gzz.websocket;

import org.springframework.stereotype.Component;

import javax.websocket.*;
import javax.websocket.server.ServerEndpoint;
import java.util.concurrent.CopyOnWriteArraySet;

/**
 * @author https://www.jianshu.com/u/3bd57d5f1074
 * @date 2022-05-26 14:50:00
 */
@ServerEndpoint(value = "/gzz/websocket")
@Component
public class KafkaWebSocket {
    /**
     * 静态变量，用来记录当前在线连接数。应该把它设计成线程安全的。
     */
    private static int onlineCount = 0;
    /**
     * concurrent包的线程安全Set，用来存放每个客户端对应的CumWebSocket对象。
     */
    private static CopyOnWriteArraySet<KafkaWebSocket> webSocketSet = new CopyOnWriteArraySet<KafkaWebSocket>();
    /**
     * 与某个客户端的连接会话，需要通过它来给客户端发送数据
     */
    private Session session;

    /**
     * 连接建立成功调用的方法
     */
    @OnOpen
    public void onOpen(Session session) {
        this.session = session;
        webSocketSet.add(this);// 加入set中
        addOnlineCount();// 添加在线人数
        System.out.println("新连接接入。当前在线人数为：" + getOnlineCount());
    }

    /**
     * 连接关闭调用的方法
     */
    @OnClose
    public void onClose() {
        webSocketSet.remove(this);// 从set中删除
        subOnlineCount(); // 在线数减1
        System.out.println("有连接关闭。当前在线人数为：" + getOnlineCount());
    }

    /**
     * 收到客户端消息后调用
     */
    @OnMessage
    public void onMessage(String message, Session session) {
        System.out.println("客户端发送的消息：" + message);
    }

    /**
     * 暴露给外部的群发
     */
    public static void sendInfo(String message) {
        sendAll(message);
    }

    /**
     * 群发
     */
    private static void sendAll(String message) {
        webSocketSet.forEach(item -> item.sendMessage(message));
    }

    /**
     * 发生错误时调用
     */
    @OnError
    public void onError(Session session, Throwable error) {
        System.out.println("----websocket-------有异常啦");
        error.printStackTrace();
    }

    /**
     * 减少在线人数
     */
    private void subOnlineCount() {
        KafkaWebSocket.onlineCount--;
    }

    /**
     * 添加在线人数
     */
    private void addOnlineCount() {
        KafkaWebSocket.onlineCount++;
    }

    /**
     * 当前在线人数
     */
    public static synchronized int getOnlineCount() {
        return onlineCount;
    }

    /**
     * 发送信息
     */
    public void sendMessage(String message) {
        // 获取session远程基本连接发送文本消息
//		this.session.getBasicRemote().sendText(message);
        this.session.getAsyncRemote().sendText(message);
    }
}

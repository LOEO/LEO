package com.leo.listener;

import com.leo.model.User;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionBindingListener;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by LT on 14-7-17.
 */
public class OnlineUserBoundingListener implements HttpSessionBindingListener {
    private User user;

    public OnlineUserBoundingListener(){
    }

    public OnlineUserBoundingListener(User user){
        this.user = user;
    }

    public void valueBound(HttpSessionBindingEvent httpSessionBindingEvent) {
        HttpSession session = httpSessionBindingEvent.getSession();
        ServletContext application = session.getServletContext();
        session.setAttribute("curUserName",user.getUsername());
        session.setAttribute("curUser",user);
        // 把用户名放入在线列表
        Map<String,User> onlineUsers = (Map<String, User>) application.getAttribute("users");
        // 第一次使用前，需要初始化
        if (onlineUsers == null) {
            onlineUsers = new HashMap<String, User>();
            application.setAttribute("users", onlineUsers);
        }
        if (!onlineUsers.containsKey(user.getUsername())) {
            onlineUsers.put(user.getUsername(), user);
        }
        application.setAttribute("onlineUsers",onlineUsers.size());
    }

    public void valueUnbound(HttpSessionBindingEvent httpSessionBindingEvent) {
        HttpSession session = httpSessionBindingEvent.getSession();
        ServletContext application = session.getServletContext();
        HashMap<String,User> onlineUsers = (HashMap<String, User>) application.getAttribute("users");
        onlineUsers.remove(this.user.getUsername());
        application.setAttribute("onlineUsers",onlineUsers.size());
    }
}

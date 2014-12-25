package com.leo.listener;

import com.leo.model.User;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionBindingListener;
import java.util.ArrayList;
import java.util.List;

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
    @Override
    public void valueBound(HttpSessionBindingEvent httpSessionBindingEvent) {
        HttpSession session = httpSessionBindingEvent.getSession();
        ServletContext application = session.getServletContext();
        boolean isLogin = false;
        // 把用户名放入在线列表
        List<User> onlineUserList = (List<User>) application.getAttribute("users");
        // 第一次使用前，需要初始化
        if (onlineUserList == null) {
            onlineUserList = new ArrayList<User>();
            application.setAttribute("users", onlineUserList);
        }
        for(User user:onlineUserList){
            if(user.getUsername().equals(this.user.getUsername())){
                isLogin = true;
            }
        }
        if(!isLogin){
            onlineUserList.add(this.user);
            application.setAttribute("userCount",onlineUserList.size());
        }

    }

    @Override
    public void valueUnbound(HttpSessionBindingEvent httpSessionBindingEvent) {
        HttpSession session = httpSessionBindingEvent.getSession();
        ServletContext application = session.getServletContext();
        List onlineUserList = (List) application.getAttribute("users");
        onlineUserList.remove(this.user);
        application.setAttribute("userCount",onlineUserList.size());
    }
}

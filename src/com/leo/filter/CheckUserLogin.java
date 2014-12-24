package com.leo.filter;

import org.springframework.http.HttpRequest;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

/**
 * Created by LT on 2014/12/20.
 */
public class CheckUserLogin implements Filter {
    private List<String> exclude;
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest hReq = (HttpServletRequest)servletRequest;
        HttpServletResponse hRes = (HttpServletResponse)servletResponse;
        HttpSession session = hReq.getSession();
        if(session.getAttribute("curUserName") == null){
            String uri = hReq.getRequestURI();
            System.out.println(uri);
            boolean flag = false;
            for(String s:exclude){
                if(s.contains("*")){
                    if(uri.contains(s.replace("*",""))){
                        flag = true;
                        filterChain.doFilter(servletRequest,servletResponse);
                        break;
                    }
                }else if(uri.equals(s)){
                    flag = true;
                    filterChain.doFilter(servletRequest,servletResponse);
                    break;
                }
            }
            if(!flag)
                hRes.sendRedirect(hReq.getContextPath() + "/pages/login.jsp");
        }else{
            filterChain.doFilter(servletRequest,servletResponse);
        }
    }

    @Override
    public void destroy() {

    }

    public void setExclude(List exclude) {
        this.exclude = exclude;
    }
}

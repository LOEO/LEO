<%@ page import="java.util.ArrayList" %>
<%--
  Created by IntelliJ IDEA.
  User: LT
  Date: 14-3-20
  Time: 下午7:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    System.out.println(request.getContextPath());
    session.invalidate();
    response.sendRedirect(request.getContextPath() + "/jsp/Login.jsp");
%>

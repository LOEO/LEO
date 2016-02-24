<%@ page import="com.leo.model.SysUser" %>
<%--
  Created by IntelliJ IDEA.
  User: LT
  Date: 2015-04-06
  Time: 3:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    pageContext.setAttribute("ctx",request.getContextPath());
    SysUser sysUser = (SysUser) session.getAttribute("curUser");
%>
<html>
<head>
    <title>LEO权限管理系统</title>
    <base href="${ctx}/">
    <link rel="stylesheet" href="rs/ext4.2/resources/ext-theme-classic/ext-theme-classic-all.css"/>
    <%--<link rel="stylesheet" href="rs/ext4.2/resources/ext-theme-neptune/ext-theme-neptune-all.css"/>--%>
    <link rel="stylesheet" href="rs/ext4.2/resources/css/icon.css"/>
    <link rel="stylesheet" href="pages/css/app.css"/>
    <script type="text/javascript" src="rs/ext4.2/ext-all-dev.js"></script>
    <script type="text/javascript"src="rs/ext4.2/ext-locale-zh_CN.js"></script>
    <script type="text/javascript" src="pages/app/app.js"></script>
    <script type="text/javascript">
        var LEO = LEO || {};
        LEO.curUserNickName = '${curUser.nickname}';
        LEO.online =${onlineUsers};
        LEO.curUserName = '<%=sysUser.getUsername()%>';
    </script>
</head>
<body>
</body>
</html>

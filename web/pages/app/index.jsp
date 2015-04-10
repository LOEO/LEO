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
%>
<html>
<head>
    <title>LEO权限管理系统</title>
    <base href="${ctx}/">
    <link rel="stylesheet" href="rs/ext4.2/resources/ext-theme-classic/ext-theme-classic-all.css"/>
    <link rel="stylesheet" href="rs/ext4.2/resources/css/icon.css"/>
    <script type="text/javascript" src="rs/ext4.2/ext-all-dev.js"></script>
    <script type="text/javascript"src="rs/ext4.2/ext-locale-zh_CN.js"></script>
    <script type="text/javascript" src="pages/app/app.js"></script>
    <style>
        .menu-list {
            padding: 0 3px 0 3px;
        }

        .menu-list-item {
            margin-top: 3px;
            padding-left: 20px;
            font-size: 11px;
            line-height: 20px;
            cursor: pointer;
            background: url(images/rss.gif) no-repeat 0 2px;
            border: 1px solid #fff;
        }
        .menu-list .x-item-selected {
            font-weight: bold;
            color: #15428B;
            background-color: #DFE8F6;
            border: 1px dotted #A3BAE9;
        }

        .menu-list-item-hover {
            background-color: #eee;
        }
    </style>
</head>
<body>

</body>
</html>

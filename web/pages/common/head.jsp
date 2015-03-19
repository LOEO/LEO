<%--
  Created by IntelliJ IDEA.
  User: LT
  Date: 14-3-20
  Time: 下午7:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
  pageContext.setAttribute("ctx",request.getContextPath());
%>
<meta name="description" content="Static &amp; Dynamic Tables" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<link href="${ctx}/rs/ace/assets/css/bootstrap.min.css" rel="stylesheet" />
<link rel="stylesheet" href="${ctx}/rs/ace/assets/css/font-awesome.min.css" />

<!--[if IE 7]>
<link rel="stylesheet" href="${ctx}/rs/ace/assets/css/font-awesome-ie7.min.css" />
<![endif]-->

<!-- page specific plugin styles -->

<link rel="stylesheet" href="${ctx}/rs/ace/assets/css/jquery-ui-1.10.3.custom.min.css" />
<link rel="stylesheet" href="${ctx}/rs/ace/assets/css/jquery.gritter.css" />
<link rel="stylesheet" href="${ctx}/rs/ace/assets/css/select2.css" />
<link rel="stylesheet" href="${ctx}/rs/ace/assets/css/bootstrap-editable.css" />

<!-- fonts -->

<%--<link rel="stylesheet" href="http://fonts.googleapis.com/css?family=Open+Sans:400,300" />--%>

<!-- ace styles -->

<link rel="stylesheet" href="${ctx}/rs/ace/assets/css/ace.min.css" />
<link rel="stylesheet" href="${ctx}/rs/ace/assets/css/ace-rtl.min.css" />
<link rel="stylesheet" href="${ctx}/rs/ace/assets/css/ace-skins.min.css" />
<!--[if lte IE 8]>
<link rel="stylesheet" href="${ctx}/rs/ace/assets/css/ace-ie.min.css" />
<![endif]-->

<!-- inline styles related to this page -->

<!-- ace settings handler -->

<script src="${ctx}/rs/ace/assets/js/ace-extra.min.js"></script>

<!-- HTML5 shim and Respond.js IE8 support of HTML5 elements and media queries -->

<script src="${ctx}/rs/ace/assets/js/html5shiv.js"></script>
<script src="${ctx}/rs/ace/assets/js/respond.min.js"></script>

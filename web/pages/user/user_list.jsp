<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.Map" %>
<%--
  Created by IntelliJ IDEA.
  User: LT
  Date: 14-4-2
  Time: 下午6:22
  To change this template use File | Settings | File Templates.
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>


<%@include file="../common/start.jsp"%>
<div class="page-content">
    <!-- PAGE CONTENT BEGINS -->
    <div class="table-responsive">
        <table id="sample-table-1" class="table table-striped table-bordered table-hover">
            <thead>
            <tr>
                <th class="center">
                    <label>
                        <input type="checkbox" class="ace" />
                        <span class="lbl"></span>
                    </label>
                </th>
                <th>用户名</th>
                <th class="hidden-480">姓名</th>
                <th>邮箱</th>


                <th>
                    <i class="icon-time bigger-110 hidden-480"></i>
                    出生日期
                </th>
                <th class="hidden-480">性别</th>

                <th>状态</th>
                <th>操作</th>
            </tr>
            </thead>

            <tbody>
            <c:forEach var="user" items="${userlist}">
                <tr>
                    <td class="center">
                        <label>
                            <input type="checkbox" class="ace" />
                            <span class="lbl"></span>
                        </label>
                    </td>

                    <td>
                        <a href="#">${user.username}</a>
                    </td>
                    <td>${user.nickname}</td>
                    <td>${user.email}</td>
                    <td class="hidden-480"><fmt:formatDate value="${user.birthday}" pattern="yyyy-MM-dd"/><%--<fmt:formatDate value="${user.birthDate}"></fmt:formatDate>--%></td>
                    <td>${user.sex}</td>

                    <td class="hidden-480">
                        <span class="label label-sm label-warning">OK</span>
                    </td>

                    <td>
                        <div class="visible-md visible-lg hidden-sm hidden-xs btn-group">
                            <button class="btn btn-xs btn-success">
                                <i class="icon-ok bigger-120"></i>
                            </button>

                            <button class="btn btn-xs btn-info">
                                <i class="icon-edit bigger-120"></i>
                            </button>

                            <button class="btn btn-xs btn-danger">
                                <i class="icon-trash bigger-120"></i>
                            </button>

                            <button class="btn btn-xs btn-warning">
                                <i class="icon-flag bigger-120"></i>
                            </button>
                        </div>

                        <div class="visible-xs visible-sm hidden-md hidden-lg">
                            <div class="inline position-relative">
                                <button class="btn btn-minier btn-primary dropdown-toggle" data-toggle="dropdown">
                                    <i class="icon-cog icon-only bigger-110"></i>
                                </button>

                                <ul class="dropdown-menu dropdown-only-icon dropdown-yellow pull-right dropdown-caret dropdown-close">
                                    <li>
                                        <a href="#" class="tooltip-info" data-rel="tooltip" title="View">
																				<span class="blue">
																					<i class="icon-zoom-in bigger-120"></i>
																				</span>
                                        </a>
                                    </li>

                                    <li>
                                        <a href="#" class="tooltip-success" data-rel="tooltip" title="Edit">
																				<span class="green">
																					<i class="icon-edit bigger-120"></i>
																				</span>
                                        </a>
                                    </li>

                                    <li>
                                        <a href="#" class="tooltip-error" data-rel="tooltip" title="Delete">
																				<span class="red">
																					<i class="icon-trash bigger-120"></i>
																				</span>
                                        </a>
                                    </li>
                                </ul>
                            </div>
                        </div>
                    </td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div><!-- /.table-responsive -->

</div><!-- /.page-content -->
<%@include file="../common/end.jsp"%>
<script>
    $('table th input:checkbox').on('click' , function(){
        var that = this;
        $(this).closest('table').find('tr > td:first-child input:checkbox')
                .each(function(){
                    this.checked = that.checked;
                    $(this).closest('tr').toggleClass('selected');
                });

    });

</script>
<%--
  Created by IntelliJ IDEA.
  User: LT
  Date: 14-3-20
  Time: 下午7:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <%@include file="common/head.jsp" %>
    <title>用户登录</title>
</head>
<body class="login-layout">
<div class="main-container">
<div class="main-content">
<div class="row">
<div class="col-sm-10 col-sm-offset-1">
<div class="login-container">
<div class="center">
    <h1>
        <i class="icon-leaf green"></i>
        <span class="red">LEO</span>
        <span class="white">Application</span>
    </h1>
    <h4 class="blue">&copy; LT</h4>
</div>

<div class="space-6"></div>

<div class="position-relative">
    <div id="login-box" class="login-box visible widget-box no-border">
        <div class="widget-body">
            <div class="widget-main">
                <h4 class="header blue lighter bigger">
                    <i class="icon-coffee green"></i>
                    请输入您的信息

                </h4>
                <h5 class="msg" color="red">${error}</h5>
                <div class="space-6"></div>

                <form action="${ctx}/user/login.do" method="post">
                    <fieldset>
                        <label class="block clearfix">
														<span class="block input-icon input-icon-right">
															<input type="text" class="form-control"
                                                                   placeholder="用户名" name="username" required="required"/>
															<i class="icon-user"></i>
														</span>
                        </label>

                        <label class="block clearfix">
														<span class="block input-icon input-icon-right">
															<input type="password" class="form-control"
                                                                   placeholder="密码"  name="password" required="required"/>
															<i class="icon-lock"></i>
														</span>
                        </label>

                        <div class="space"></div>

                        <div class="clearfix">
                            <label class="inline">
                                <input type="checkbox" class="ace"/>
                                <span class="lbl"> 记住密码</span>
                            </label>

                            <button type="submit" class="width-35 pull-right btn btn-sm btn-primary">
                                <i class="icon-key"></i>
                                登录
                            </button>
                        </div>

                        <div class="space-4"></div>
                    </fieldset>
                </form>

                <div class="social-or-login center">
                    <span class="bigger-110">Or Login Using</span>
                </div>

                <div class="social-login center">
                    <a class="btn btn-primary">
                        <i class="icon-facebook"></i>
                    </a>

                    <a class="btn btn-info">
                        <i class="icon-twitter"></i>
                    </a>

                    <a class="btn btn-danger">
                        <i class="icon-google-plus"></i>
                    </a>
                </div>
            </div>
            <!-- /widget-main -->

            <div class="toolbar clearfix">
                <div>
                    <a href="#" onclick="show_box('forgot-box'); return false;" class="forgot-password-link">
                        <i class="icon-arrow-left"></i>
                        忘记密码
                    </a>
                </div>

                <div>
                    <a href="#" onclick="show_box('signup-box'); return false;" class="user-signup-link">
                        我要注册
                        <i class="icon-arrow-right"></i>
                    </a>
                </div>
            </div>
        </div>
        <!-- /widget-body -->
    </div>
    <!-- /login-box -->

    <div id="forgot-box" class="forgot-box widget-box no-border">
        <div class="widget-body">
            <div class="widget-main">
                <h4 class="header red lighter bigger">
                    <i class="icon-key"></i>
                    找回密码
                </h4>

                <div class="space-6"></div>
                <p>
                    请输入你的邮箱：
                </p>

                <form>
                    <fieldset>
                        <label class="block clearfix">
														<span class="block input-icon input-icon-right">
															<input type="email" class="form-control"
                                                                   placeholder="邮箱"/>
															<i class="icon-envelope"></i>
														</span>
                        </label>

                        <div class="clearfix">
                            <button type="button" class="width-35 pull-right btn btn-sm btn-danger">
                                <i class="icon-lightbulb"></i>
                                确定
                            </button>
                        </div>
                    </fieldset>
                </form>
            </div>
            <!-- /widget-main -->

            <div class="toolbar center">
                <a href="#" onclick="show_box('login-box'); return false;" class="back-to-login-link">
                    返回登录
                    <i class="icon-arrow-right"></i>
                </a>
            </div>
        </div>
        <!-- /widget-body -->
    </div>
    <!-- /forgot-box -->

    <div id="signup-box" class="signup-box widget-box no-border">
        <div class="widget-body">
            <div class="widget-main">
                <h4 class="header green lighter bigger">
                    <i class="icon-group blue"></i>
                    注册新用户
                </h4>

                <div class="space-6"></div>
                <p> 输入你的信息开始注册: </p>

                <form action="${ctx}/user/register.do">
                    <fieldset>
                        <label class="block clearfix">
														<span class="block input-icon input-icon-right">
															<input type="email" class="form-control"
                                                                   placeholder="邮箱" name="email" required="required" />
															<i class="icon-envelope"></i>
														</span>
                        </label>

                        <label class="block clearfix">
														<span class="block input-icon input-icon-right">
															<input type="text" class="form-control"
                                                                   placeholder="用户名" name="username"  required="required"/>
															<i class="icon-user"></i>
														</span>
                        </label>

                        <label class="block clearfix">
														<span class="block input-icon input-icon-right">
															<input type="password" class="form-control"
                                                                   placeholder="密码" name="password" required="required"/>
															<i class="icon-lock"></i>
														</span>
                        </label>

                        <label class="block clearfix">
														<span class="block input-icon input-icon-right">
															<input type="password" class="form-control" name="password1"
                                                                   placeholder="确认密码" required="required"/>
															<i class="icon-retweet"></i>
														</span>
                        </label>

                        <label class="block">
                            <input type="checkbox" class="ace" required="required"/>
														<span class="lbl">
															同意
															<a href="#">用户协议</a>
														</span>
                        </label>

                        <div class="space-24"></div>

                        <div class="clearfix">
                            <button type="reset" class="width-30 pull-left btn btn-sm">
                                <i class="icon-refresh"></i>
                                重置
                            </button>

                            <button type="submit" class="width-65 pull-right btn btn-sm btn-success">
                                注册
                                <i class="icon-arrow-right icon-on-right"></i>
                            </button>
                        </div>
                    </fieldset>
                </form>
            </div>

            <div class="toolbar center">
                <a href="#" onclick="show_box('login-box'); return false;" class="back-to-login-link">
                    <i class="icon-arrow-left"></i>
                    返回登录
                </a>
            </div>
        </div>
        <!-- /widget-body -->
    </div>
    <!-- /signup-box -->
</div>
<!-- /position-relative -->
</div>
</div>
<!-- /.col -->
</div>
<!-- /.row -->
</div>
</div>

<script src="${ctx}/rs/jquery/jquery.min.js"></script>


<script type="text/javascript">

    if($(".msg").html() == "1"){
        $(".msg").html("用户名或密码错误！");
    }
    function show_box(id) {
        jQuery('.widget-box.visible').removeClass('visible');
        jQuery('#' + id).addClass('visible');
    }
</script>
</body>
</html>

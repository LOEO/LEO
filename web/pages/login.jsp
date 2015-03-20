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
    <style>

    </style>
</head>
<body>
    <div id="loginBox"></div>
<div id="reigsterBox"></div>
<script>
    Ext.onReady(function(){
        var loginForm = Ext.define('Leo.form.Login', {
            extend:"Ext.form.Panel",
            frame:true,
            url: '${ctx}/userAjax/login.do',
            width: 320,
            bodyPadding: 10,
            title:"登录",
            defaultType: 'textfield',
            defaults: {
                anchor: '100%'
            },
            fieldDefaults: {
                labelAlign: 'center',
                labelWidth: 80
            },
            items: [
                {
                    allowBlank: false,
                    blankText:"请输入用户名",
                    fieldLabel: '用户名',
                    name: 'username',
                    emptyText: '用户名'
                },
                {
                    allowBlank: false,
                    blankText:"请输入密码",
                    fieldLabel: '密 码',
                    name: 'password',
                    emptyText: '密 码',
                    inputType: 'password'
                },
                {
                    xtype:'checkbox',
                    fieldLabel: '记住密码',
                    name: 'remember'
                }
            ],

            buttons: [
                {
                    text:'注册',
                    handler:function(){
                        registerWin.show();
                    }
                },
                { text:'登录',
                    handler: function() {
                        var form = this.up('form').getForm();
                        if (form.isValid()) {
                            var myMask = new Ext.LoadMask(document.body, {msg:"正在登录..."});
                            myMask.show();
                            form.submit({
                                success: function(form, action) {
                                    myMask.hide();
                                    window.location = "${ctx}/index.do"
                                },
                                failure: function(form, action) {
                                    myMask.hide();
                                    if(action.result){
                                        Ext.Msg.alert('提示', action.result.msg);
                                    }else{
                                        Ext.Msg.alert('提示', "服务器连接失败!");
                                    }
                                }
                            });
                        }
                    }
                }
            ]
        });

        Ext.apply(Ext.form.VTypes,{
            password:function(val,field){
                debugger;
                if(field.confirmTo){
                    var password = Ext.get(field.confirmTo);
                    alert(password.getVal());
                    return (val==password.getValue());
                }
                return true;
            }
        });

        var registerForm = Ext.define("Leo.form.register",{
            extend:"Ext.form.Panel",
            bodyBorder:false,
            bodyPadding: 10,
            autoScroll:true,
            width: 355,
            fieldDefaults: {
                labelAlign: 'right',
                labelWidth: 70
            },
            initComponent: function() {
                this.items = [{
                    xtype: 'fieldset',
                    title: '用户信息',
                    defaultType: 'textfield',
                    defaults: {
                        anchor: '100%'
                    },
                    items: [
                        {
                            allowBlank:false,
                            fieldLabel: '用户名',
                            name: 'username',
                            emptyText: '用户名',
                            blankText:"请输入用户名！",
                            minLength:6,
                            minLength:"不能小于6位"
                        },
                        {
                            allowBlank:false,
                            fieldLabel: '密码',
                            id:"pass",
                            name: 'password',
                            emptyText: '密码',
                            inputType: 'password',
                            blankText:"请输入密码！",
                            minLength:6,
                            minLength:"不能小于6位"
                        },
                        {
                            allowBlank:false,
                            fieldLabel: '确认密码',
                            name: 'password1',
                            emptyText: '确认密码',
                            inputType: 'password',
                            blankText:"请确认密码！",
                            minLength:6,
                            minLength:"不能小于6位",
                            vtype:"password",
                            vtypeText:"两次输入的密码不一致！",
                            confirmTo:"pass"
                        }
                    ]
                },
                    {
                        xtype: 'fieldset',
                        title: '联系信息',
                        defaultType: 'textfield',
                        defaults: {
                            anchor: '100%'
                        },
                        items: [{
                            fieldLabel: '昵称',
                            emptyText: '昵称',
                            name: 'first'
                        },
                            {
                                fieldLabel: '姓名',
                                emptyText: '姓名',
                                name: 'last'
                            },
                            {
                                fieldLabel: '公司',
                                emptyText: '公司',
                                name: 'company'
                            },
                            {
                                fieldLabel: '邮箱',
                                emptyText: '邮箱',
                                name: 'email',
                                vtype: 'email'
                            },
                            {
                                xtype: 'datefield',
                                fieldLabel: '生日',
                                name: 'dob',
                                allowBlank: false,
                                maxValue: new Date()
                            }]
                    }];

                this.callParent();
            },
            buttons: [{
                text: '注册',
                disabled: true,
                formBind: true
            }]
        });

        var registerWin = Ext.create('Ext.window.Window', {
            title:"用户注册",
            height: 425,
            width: 400,
            closeAction:"hide",
            layout: 'fit',
            frame:true,
            modal:true,
            items: [Ext.create("Leo.form.register")]
        });

        Ext.create("Ext.container.Viewport",{
            style : "background-image:url(${ctx}/rs/imgs/bg.jpg);background-repeat: no-repeat;filter:'progid:DXImageTransform.Microsoft.AlphaImageLoader(sizingMethod=\"scale\")';-moz-background-size:100% 100%;background-size:100% 100%;",
            layout: {
                type: "vbox",
                align: "center",
                pack: "center"
            },
            items:[
                    Ext.create("Leo.form.Login")
            ]
        });
    });
</script>
</body>
</html>

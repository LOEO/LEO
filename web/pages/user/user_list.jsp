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
<%@include file="../common/head.jsp" %>
<script>
    Ext.onReady(function () {
        Ext.define("Leo.model.User", {
            extend: "Ext.data.Model",
            fields: [
                {name: "id", type: "int"},
                {name: "username", type: "string"},
                {name: "password", type: "string"},
                {name: "nickname", type: "string"},
                {name: "age", type: "int"},
                {name: "birthday", type: "string"},
                {name: "sex", type: "string"},
                {name: "avatar", type: "string"},
                {name: "email", type: "string"},
                {name: "phone", type: "string"}
            ],
            proxy: {
                type: "ajax",
                reader: "json"
            }
        });
        var store = Ext.create("Ext.data.Store", {
            autoLoad:true,
            model: "Leo.model.User",
            proxy: {
                type: "ajax",
                url: "${ctx}/userAjax/user_list.do"
            }
        });

        var grid = Ext.create('Ext.grid.Panel', {
            fit: true,
            fix: true,
            store: store,
            columnLines: true,
            columns: [
                {text: "序号", width: 50, xtype: "rownumberer", align: "center"},
                {text: "用户名", flex: 1, dataIndex: 'username', sortable: true, align: "center"},
                {text: "姓名", flex: 1, dataIndex: 'nickname', sortable: true, align: "center"},
                {text: "年龄", width: 125, dataIndex: 'age', sortable: true, align: "center"},
                {text: "性别", width: 125, dataIndex: 'sex', sortable: true, align: "center"},
                {text: "生日", width: 125, dataIndex: 'birthday', sortable: true, align: "center"},
                {text: "邮箱", width: 125, dataIndex: 'email', sortable: true, align: "center"},
                {text: "电话", width: 125, dataIndex: 'phone', sortable: true, align: "center"}
            ],
            bbar: {
                xtype: 'pagingtoolbar',
                pageSize: 10,
                store: store,
                displayInfo: true,
                displayMsg: '显示 {0} - {1} 条,共 {2} 条'
            },
            tbar: [
                {
                    xtype: "button", text: "添加", iconCls: "Applicationadd",
                    handler: function () {
                        var win = openWin("添加", function () {
                            grid.getStore().reload();
                        });
                    }
                },
                {xtype: "button", text: "修改", iconCls: "Applicationedit"}
            ]
        });

        Ext.create("Ext.container.Viewport", {
            items: [grid]
        });

        var openWin = function (title, callback) {
            debugger;
            var win = Ext.create('Ext.window.Window', {
                title: title,
                height: 425,
                width: 400,
                layout: 'fit',
                modal: true,
                iconCls: 'Applicationviewdetail',
                items: [{
                    xtype: "userform",
                    saveCallback: function () {
                        win.close();
                        callback();
                    }
                }
                ]
            }).show();
            return win;
        }

        Ext.apply(Ext.form.VTypes, {
            password: function (val, field) {
                debugger;
                if (field.confirmTo) {
                    var password = Ext.getCmp(field.confirmTo);
                    return (val == password.getValue());
                }
                return true;
            }
        });
        var isExist = true;
        Ext.define("Leo.form.User", {
            xtype: "userform",
            extend: "Ext.form.Panel",
            bodyBorder: false,
            bodyPadding: 10,
            border: false,
            autoScroll: true,
            fit: true,
            frame: true,
            fieldDefaults: {
                labelAlign: 'right',
                labelWidth: 70
            },
            initComponent: function () {
                this.items = [{
                    xtype: 'fieldset',
                    title: '帐户信息',
                    defaultType: 'textfield',
                    defaults: {
                        anchor: '100%'
                    },
                    items: [
                        {
                            allowBlank: false,
                            fieldLabel: '用户名',
                            name: 'username',
                            emptyText: '用户名',
                            blankText: "请输入用户名！",
                            minLength: 6,
                            minLengthText: "不能小于6位",
                            validator:function(thisText){
                                var me = this;
                                if(thisText.length >=6 ){
                                    Ext.Ajax.request({
                                        url:'${ctx}/userAjax/check_user_exist.do',
                                        method:'post',
                                        params:{
                                            username:thisText
                                        },
                                        success:function(res){
                                            var data = Ext.decode(res.responseText);
                                            if(data.exist)
                                                me.markInvalid('用户名已被使用');
                                            else
                                                isExist = true;
                                        },
                                        failure:function(){
                                            isExist = "用户名已存在！";
                                        }
                                    })
                                }
                                return isExist;
                            }
                        },
                        {
                            allowBlank: false,
                            fieldLabel: '密码',
                            id: "pass",
                            name: 'password',
                            emptyText: '密码',
                            inputType: 'password',
                            blankText: "请输入密码！",
                            minLength: 6,
                            minLengthText: "不能小于6位"
                        },
                        {
                            allowBlank: false,
                            fieldLabel: '确认密码',
                            name: 'password1',
                            emptyText: '确认密码',
                            inputType: 'password',
                            blankText: "请确认密码！",
                            minLength: 6,
                            minLength: "不能小于6位",
                            vtype: "password",
                            vtypeText: "两次输入的密码不一致！",
                            confirmTo: "pass"
                        }
                    ]
                },
                    {
                        xtype: 'fieldset',
                        title: '基本信息',
                        defaultType: 'textfield',
                        defaults: {
                            anchor: '100%'
                        },
                        items: [{
                            fieldLabel: '姓名',
                            emptyText: '姓名',
                            name: 'nickname',
                            allowBlank: false,
                            blankText: "请输入姓名！"
                        }, {
                            xtype: 'combobox',
                            fieldLabel: '性别',
                            emptyText: '请选择...',
                            name: 'sex',
                            editable: false,
                            store: new Ext.data.Store({
                                mode: "local",
                                fields: [{name: 'sex', type: 'string'}],
                                data: [
                                    {sex: '保密'},
                                    {sex: '男'},
                                    {sex: '女'}
                                ]
                            }),
                            value:"保密",
                            displayField: "sex",
                            valueField: "sex"
                        },
                            {
                                fieldLabel: '电话',
                                emptyText: '电话',
                                name: 'phone'
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
                                name: 'birthday',
                                format: 'Y-m-d',
                                editable: false,
                                allowBlank: false,
                                maxValue: new Date()
                            }]
                    }];
                this.callParent();
            },
            url: "${ctx}/userAjax/user_add.do"
            , buttons: [{
                text: '保存',
                disabled: true,
                formBind: true,
                handler: function () {
                    var formPanel = this.up('form');
                    var form = formPanel.getForm();
                    if (form.isValid()) {
                        var myMask = new Ext.LoadMask(document.body, {msg: "正在保存..."});
                        myMask.show();
                        form.submit({

                            success: function (form, action) {
                                myMask.hide();
                                formPanel.saveCallback();
                            },
                            failure: function (form, action) {
                                myMask.hide();
                                if (action.result) {
                                    Ext.Msg.alert('提示', action.result.msg);
                                } else {
                                    Ext.Msg.alert('提示', "服务器连接失败!");
                                }
                            }
                        });
                    }
                }
            }]
        });
    });

</script>
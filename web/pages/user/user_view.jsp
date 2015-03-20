<%--
  Created by IntelliJ IDEA.
  User: LT
  Date: 14-4-2
  Time: 下午6:22
  To change this template use File | Settings | File Templates.
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<form id="form"></form>
<script>

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


    Ext.create("Ext.form.Panel", {
        renderTo: Ext.getElementById("form"),
        bodyBorder: false,
        bodyPadding: 10,
        border: false,
        autoScroll: true,
        fit: true,
        frame:true,
        fieldDefaults: {
            labelAlign: 'right',
            labelWidth: 70
        },
        items: [{
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
                    minLengthText: "不能小于6位"
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
                    fieldLabel: '性别',
                    emptyText: '性别',
                    name: 'sex',
                    vtype: 'phone'
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
                        allowBlank: false,
                        maxValue: new Date()
                    }]
            }]
        ,
        buttons: [{
            text: '保存',
            disabled: true,
            formBind: true
        }]
    });
</script>
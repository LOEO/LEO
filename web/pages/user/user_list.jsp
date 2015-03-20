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
<%@include file="../common/head.jsp"%>
<script>
    Ext.onReady(function(){
        Ext.define("Leo.model.User",{
            extend:"Ext.data.Model",
            fields:[
                {name:"id",type:"int"},
                {name:"username",type:"string"},
                {name:"password",type:"string"},
                {name:"nickname",type:"string"},
                {name:"age",type:"int"},
                {name:"birthday",type:"string"},
                {name:"sex",type:"string"},
                {name:"avatar",type:"string"},
                {name:"email",type:"string"},
                {name:"phone",type:"string"}
            ],
            proxy:{
                type:"ajax",
                reader:"json"
            }
        });
        var store = Ext.create("Ext.data.Store",{
            model:"Leo.model.User",
            proxy:{
                type:"ajax",
                url:"${ctx}/userAjax/user_list.do"
            }
        });

        var grid = Ext.create('Ext.grid.Panel', {
            fit:true,
            fix:true,
            store: store,
            columnLines:true,
            columns: [
                {text:"序号",width:50,xtype:"rownumberer",align:"center"},
                {text: "用户名", flex: 1, dataIndex: 'username', sortable: true,align:"center"},
                {text: "姓名", flex: 1, dataIndex: 'nickname', sortable: true,align:"center"},
                {text: "年龄", width: 125, dataIndex: 'age', sortable: true,align:"center"},
                {text: "性别", width: 125, dataIndex: 'sex', sortable: true,align:"center"},
                {text: "生日", width: 125, dataIndex: 'birthday', sortable: true,align:"center"},
                {text: "邮箱", width: 125, dataIndex: 'email', sortable: true,align:"center"},
                {text: "电话", width: 125, dataIndex: 'phone', sortable: true,align:"center"}
            ],
            bbar: {
                xtype: 'pagingtoolbar',
                pageSize: 10,
                store: store,
                displayInfo: true,
                displayMsg : '显示 {0} - {1} 条,共 {2} 条'
            },
            tbar:[
                {xtype:"button",text:"查看",iconCls: "Applicationviewdetail",handler:function(){openWin("查看");}},
                {xtype:"button",text:"添加",iconCls: "Applicationadd"},
                {xtype:"button",text:"修改",iconCls: "Applicationedit"}
            ]
        });

        Ext.create("Ext.container.Viewport",{
            items:[grid]
        });
        store.load();
        var openWin = function(title,url){
            debugger;
            var win = Ext.create('Ext.window.Window', {
                title:title,
                height: 425,
                width: 400,
                layout: 'fit',
                modal:true,
                iconCls:'Applicationviewdetail',
                loader:{
                    url:"${ctx}/user/user_view.do",
                    autoLoad: true,
                    scripts: true
                }
            }).show();
        }
    });

</script>
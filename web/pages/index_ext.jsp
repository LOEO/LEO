<%--
  Created by IntelliJ IDEA.
  User: LT
  Date: 14-4-2
  Time: 下午6:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="common/head-ext.jsp" %>
<body>
<script>
    Ext.onReady(function () {
        Ext.create("Ext.Viewport", {
            layout: {
                type: 'border'
            },
            defaults: {
                split: true
            },
            items: [{
                region: 'north',
                splitterResize: false,
                height: 40
            }, {
                region: 'west',
                collapsible: true,
                title: '菜单',
                split: true,
                width: '20%',
                minWidth: 100,
                stateId: 'westRegion',
                stateful: true,
                bodyPadding: 0,
                xtype: "menu-accordion"
            }, {
                region: 'center',
                minHeight: 80,
                xtype: 'tabpanel',
                id: 'mainCenter',
                items: [{
                    title: '主页',
                    html: "<iframe frameborder='0' width='100%' height='100%' src='http://www.baidu.com'></iframe>"
                }]
            }, {
                region: 'east',
                collapsible: true,
                floatable: true,
                split: true,
                width: 200,
                minWidth: 120,
                minHeight: 140,
                title: 'East',
                layout: {
                    type: 'vbox',
                    padding: 5,
                    align: 'stretch'
                }
            }]
        });
    });
    Ext.define("Leo.menu.MainMenu", {
        extend: "Ext.panel.Panel",
        xtype: 'menu-accordion',
        themes: {
            classic: {
                colWidth: 75
            },
            neptune: {
                colWidth: 90
            }
        },

        layout: 'accordion',
        defaults: {
            bodyPadding: 0,
            margin: 1
        },
        initComponent: function () {
            Ext.apply(this, {
                fit: true,
                items: [
                    {
                        title: '系统设置',
                        items: [
                            {
                                xtype: "menu-tree"
                            }
                        ]
                    }, {
                        title: '系统设置',
                        html: 'Empty'
                    }, {
                        title: '系统设置',
                        html: 'Empty'
                    }, {
                        title: '系统设置',
                        html: 'Empty'
                    }]
            });
            this.callParent();
        }
    });
    Ext.define("Leo.menu.MenuTree", {
        extend: 'Ext.tree.Panel',
        border: false,
        xtype: 'menu-tree',
        rootVisible: false,
        lines: false,
        fit: true,
        initComponent: function () {
            Ext.apply(this, {
                store: new Ext.data.TreeStore({
                    model: "Leo.model.MainMenu",
                    root: {
                        text: "root",
                        expandable: false,
                        children: [
                            {
                                text: "用户管理",
                                expandable: false,
                                url:"${ctx}/user/user_list.do"
                            },
                            {
                                text: "组织架构",
                                expandable: false
                            },
                            {
                                text: "角色管理",
                                expandable: false
                            },
                            {
                                text: "权限管理",
                                expandable: false
                            },
                            {
                                text: "菜单管理",
                                expandable: false
                            }
                        ]
                    }
                }),
                listeners: {
                    itemclick: function (node, record, item, index, e, eOpts) {
                        debugger;
                        Ext.getCmp("mainCenter").add({
                            closable: true,
                            title: record.data.text,
                            html: "<iframe frameborder='0' width='100%' height='100%' src='"+record.data.url+"'></iframe>"
                        }).show();
                    }
                }
            });
            this.callParent();
        }
    });
    Ext.define("Leo.model.MainMenu", {
        extend: "Ext.data.Model",
        fields: [
            {name: 'id', type: 'string'},
            {name: 'pid', type: 'string'},
            {name: 'text', type: 'string'},
            {name: 'url', type: 'string'}
        ]
    });
    var store = Ext.create("Ext.data.Store", {
        model: "Leo.model.MainMenu",
        data: [
            {
                id: "1",
                pid: "1",
                name: "test1",
                text: "123"
            },
            {
                id: "2",
                pid: "2",
                name: "test2"
            },
            {
                id: "3",
                pid: "3",
                name: "test3"
            }
        ],
        root: {
            text: 'Ext JS',
            id: 'src',
            expanded: true
        }
    });
    debugger;
</script>
</body>

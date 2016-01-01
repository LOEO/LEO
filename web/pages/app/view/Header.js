/**
 * Created by LT on 2015/11/4 0004.
 */
Ext.define('Leo.view.Header',{
    extend:'Ext.Container',
    alias:'widget.appheader',
    height:40,
    style:{
        background:'-webkit-gradient(linear,left top,left bottom,from(#074e7c),to(#095f93))'
    },
    layout:'hbox',
    items:[
        {
            xtype:'container',
            html:'<h2 class="title">权限管理系统<h2/>',
            flex: 2
        },{
            xtype:'container',
            flex: 2,
            layout:{
                type:'vbox',
                align: 'right',
                padding:"20 5 0 0"
            },
            items:[
                {
                    xtype:'container',
                    layout:'hbox',
                    items:[
                        {
                            xtype:'container',
                            margin:'0 10',
                            html:"<b class='color-white'>在线用户：</b><b class='color-green' id='online'></b>&nbsp;<b class='color-white'>当前用户：</b><b class='color-green' id='curUser'>123123</b>"
                        },{
                            xtype: 'button',
                            iconCls:'Doorout',
                            text:'注销',
                            href:"pages/logout.jsp",
                            hrefTarget:"_self"
                        }
                    ]
                }
            ]
        }
    ],

});
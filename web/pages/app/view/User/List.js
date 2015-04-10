/**
 * Created by LT on 2015-04-06.
 */
Ext.define('Leo.view.user.List',{
    extend:'Ext.grid.Panel',
    alias:'widget.userlist',
    fit: true,
    fix: true,
    columnLines: true,
    initComponent:function(){
        Ext.apply(this,{
            store:"User",
            columns: [
                {text:'id',dataIndex:'id',hidden:true},
                {text: '序号', width: 50, xtype: 'rownumberer', align: 'center'},
                {text: '用户名', flex: 1, dataIndex: 'username', sortable: true, align: 'center'},
                {text: '姓名', flex: 1, dataIndex: 'nickname', sortable: true, align: 'center'},
                {text: '年龄', width: 125, dataIndex: 'age', sortable: true, align: 'center'},
                {text: '性别', width: 125, dataIndex: 'sex', sortable: true, align: 'center'},
                {text: '生日', width: 125, dataIndex: 'birthday', sortable: true, align: 'center'},
                {text: '邮箱', width: 125, dataIndex: 'email', sortable: true, align: 'center'},
                {text: '电话', width: 125, dataIndex: 'phone', sortable: true, align: 'center'}
            ],
            bbar: {
                xtype: 'pagingtoolbar',
                store:'User',
                pageSize: 10,
                displayInfo: true,
                displayMsg: '显示 {0} - {1} 条,共 {2} 条'
            },
            tbar: [
                {
                    xtype: 'button', action:'add',text: '添加', iconCls: 'Applicationadd'
                },
                {xtype: 'button', action:'update',text: '修改', iconCls: 'Applicationedit'},
                {xtype: 'button', action:'delete',text: '删除', iconCls: 'Applicationdelete'}
            ]
        })
        this.callParent(arguments);
    }

})
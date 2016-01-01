/**
 * Created by LT on 2015-04-06.
 */
Ext.define('Leo.view.user.OrgUser',{
    extend:'Leo.view.user.List',
    alias:'widget.orguser',
    fit: true,
    fix: true,
    columnLines: true,
    store:"OrgUser",
    bbar: {
        xtype: 'pagingtoolbar',
        store:'OrgUser',
        displayInfo: true,
        displayMsg: '显示 {0} - {1} 条,共 {2} 条'
    },
    tbar: [
        {
            xtype: 'button', action:'add',text: '添加', iconCls: 'Applicationadd'
        },
        {xtype: 'button', action:'delete',text: '删除', iconCls: 'Applicationdelete'}
    ],
    initComponent:function(){
        Ext.apply(this,{

        })
        this.callParent(arguments);
        this.store.load();
    }

})
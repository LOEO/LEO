/**
 * Created by LT on 2015/12/13 0013.
 */
Ext.define('Leo.view.role.List',{
    extend:'Ext.grid.Panel',
    alias:'widget.rolelist',
    fit: true,
    fix: true,
    columnLines: true,
    store:"Role",
    columns: [
        {text:'id',dataIndex:'id',hidden:true},
        {text: '序号', width: 50, xtype: 'rownumberer', align: 'center'},
        {text: '角色名', width: 100, dataIndex: 'name', sortable: true, align: 'center'},
        {text: '描述', flex: 1, dataIndex: 'descp', sortable: true, align: 'center'}
    ],
    bbar: {
        xtype: 'pagingtoolbar',
        store:'Role',
        displayInfo: true,
        displayMsg: '显示 {0} - {1} 条,共 {2} 条'
    },
    tbar: [
        {
            xtype: 'button', action:'add',text: '添加', iconCls: 'Applicationadd'
        },
        '-',
        {xtype: 'button', action:'edit',text: '修改', iconCls: 'Applicationedit'},
        '-',
        {xtype: 'button', action:'delete',text: '删除', iconCls: 'Applicationdelete'}
    ],
    initComponent:function(){
        Ext.apply(this,{

        })
        this.callParent(arguments);
        this.store.load();
    }

})
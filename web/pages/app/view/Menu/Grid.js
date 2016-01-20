/**
 * Created by LT on 2015-04-06.
 */
Ext.define('Leo.view.menu.Grid',{
    extend:'Ext.grid.Panel',
    alias:'widget.menugrid',
    fit: true,
    columnLines: true,
    initComponent:function(){
        Ext.apply(this,{
            store:"Menu",
            columns: [
                {text:'id',dataIndex:'id',hidden:true},
                {text: '序号', width: 50, xtype: 'rownumberer', align: 'center'},
                {text: '名称', flex: 1, dataIndex: 'name', sortable: true, align: 'center'},
                {text: '图标', flex: 1, dataIndex: 'icon', sortable: true, align: 'center'},
                {text: '链接', flex: 1, dataIndex: 'url', sortable: true, align: 'center'},
                {text: '父菜单', width: 125, dataIndex: 'pid', sortable: true, align: 'center'},
                {text: '是否显示', width: 125, dataIndex: 'isVisible', sortable: true, align: 'center'},
                {text: '是否叶子节点', width: 125, dataIndex: 'isLeaf', sortable: true, align: 'center'},
                {text: '排序', width: 125, dataIndex: 'ord', sortable: true, align: 'center'}
            ],
            bbar: {
                xtype: 'pagingtoolbar',
                store:'User',
                displayInfo: true,
                displayMsg: '显示 {0} - {1} 条,共 {2} 条'
            },
            tbar: [
                {
                    xtype: 'button', action:'add',text: '添加', iconCls: 'Applicationadd'
                },
                '-',
                {xtype: 'button', action:'update',text: '修改', iconCls: 'Applicationedit'},
                '-',
                {xtype: 'button', action:'delete',text: '删除', iconCls: 'Applicationdelete'}
            ]
        })
        this.callParent(arguments);
        this.store.load();
    }

})
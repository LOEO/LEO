Ext.define('Leo.view.org.Tree', {
    extend: 'Ext.tree.Panel',
    alias: 'widget.orgtree',
    useArrows: true,
    width: 200,
    height: 300,
    rootVisible: true,
    displayField: "name",
    initComponent: function () {
        Ext.apply(this, {
            store: 'Org',
            tbar: [{
                text: '添加',
                iconCls: 'Applicationadd',
                action: 'add'
            },
                '-',
                {
                text: '编辑',
                iconCls: 'Applicationedit',
                action: 'edit'
            },'-'
            , {
                text: '删除',
                iconCls: 'Applicationdelete',
                action: 'delete'
            }]
        });
        this.callParent();
        this.store.load();
    }
})
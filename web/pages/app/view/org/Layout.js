/**
 * Created by LT on 2015-04-19.
 */
Ext.define('Leo.view.org.Layout',{
    extend:"Ext.panel.Panel",
    alias:'widget.orglayout',
    fit:true,
    layout:'border',
    initComponent:function(){
        this.items=[
           /* {
                region: 'west',
                xtype:'orgtree',
                width:210,
                collapsible: false
            },*/{
                region:'center',
                xtype:'orgtree',
            }
        ];
        this.callParent(arguments);
    }
});
/**
 * Created by LT on 2015-04-06.
 */
Ext.define("Leo.view.menu.List", {
    extend: 'Ext.panel.Panel',
    border: false,
    alias: 'widget.menulist',
    rootVisible: false,
    lines: false,
    fit: true,
    initComponent: function () {
        debugger;
        Ext.apply(this, {
            items: [{
                xtype: 'dataview',
                trackOver: true,
                store: this.store,
                cls: 'menu-list',
                itemSelector: '.menu-list-item',
                overItemCls: 'menu-list-item-hover',
                tpl: '<tpl for="."><div class="menu-list-item User">{text}</div></tpl>'
            }]
        });
        this.callParent(arguments);
    }
});
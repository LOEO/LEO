/**
 * Created by LT on 2015-04-06.
 */
Ext.define('Leo.view.Viewport',{
    extend:'Ext.container.Viewport',
    requires:['Leo.view.menu.Accordion','Leo.view.menu.List','Leo.view.MainTab','Leo.view.Header'],
    layout:'border',
    renderTo:"content",
    items:[{
        region: 'north',
        splitterResize: false,
        height: 40,
        xtype:"appheader"
    },{
        collapsible: true,
        title: '菜单',
        split: true,
        width: 200,
        stateId: 'westRegion',
        stateful: true,
        bodyPadding: 0,
        xtype:'accordionmenu',
        region:'west'
    },{
        region: 'center',
        minHeight: 80,
        xtype: 'maintab'
    }/*,{
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
    }*/]
});
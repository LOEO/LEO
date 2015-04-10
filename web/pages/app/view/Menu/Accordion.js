/**
 * Created by LT on 2015-04-06.
 */
Ext.define('Leo.view.menu.Accordion', {
    extend: 'Ext.panel.Panel',
    alias: 'widget.accordionmenu',
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
        margin: 0
    },
    initComponent: function () {

        Ext.apply(this, {
            fit: true,
            items: [
                {
                    title: '系统设置',
                    items: [
                        {
                            xtype: 'menulist'
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
        this.callParent(arguments);
    }
});
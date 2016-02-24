/**
 * Created by LT on 2015-04-06.
 */
Ext.define('Leo.view.menu.Form', {
    extend: 'Ext.window.Window',
    alias: 'widget.menuform',
    title: '菜单信息',
    autoShow: true,
    resizable: false,
    modal: true,
    initComponent: function () {
        this.items = [
            {
                xtype: 'form',
                bodyBorder: false,
                bodyPadding: '10 10 0 10',
                border: false,
                autoScroll: true,
                fit: true,
                fieldDefaults: {
                    labelAlign: 'right',
                    labelWidth: 90
                },
                items: [{
                    xtype: 'hiddenfield',
                    name: 'id'
                }, {
                    xtype: 'hiddenfield',
                    name: 'pid'
                },
                    {
                        xtype: 'fieldset',
                        title: '菜单信息',
                        defaultType: 'textfield',
                        itemId: 'accountInfo',
                        defaults: {
                            anchor: '100%'
                        },
                        items: [
                            {
                                allowBlank: false,
                                fieldLabel: '名称',
                                name: 'name',
                                itemId: "name",
                                emptyText: '菜单名称',
                                blankText: '请输入菜单名称！'
                            },
                            {
                                allowBlank: false,
                                fieldLabel: '链接',
                                name: 'url',
                                itemId: "url",
                                emptyText: '菜单链接',
                                blankText: '请输入菜单链接！'
                            },
                            {
                                allowBlank: false,
                                fieldLabel: '父菜单',
                                name: 'pid',
                                itemId: "pid",
                                emptyText: '父菜单',
                                blankText: '请输入菜单链接！'
                            },
                            {
                                allowBlank: false,
                                fieldLabel: '图标',
                                name: 'icon',
                                itemId: "icon",
                                emptyText: '图标',
                                blankText: '图标！'
                            },
                            {
                                xtype: 'radiogroup',
                                fieldLabel: '是否显示',
                                defaults: {
                                    name: 'isVisible',
                                    margin: '0 15 0 0'
                                },
                                items: [{
                                    inputValue: '1',
                                    boxLabel: '是',
                                    checked: true
                                }, {
                                    inputValue: '0',
                                    boxLabel: '否'
                                }]
                            },
                            {
                                xtype: 'radiogroup',
                                fieldLabel: '是否叶子节点',
                                autoFlex:true,
                                defaults: {
                                    name: 'isLeaf',
                                    margin: '0 15 0 0'
                                },
                                items: [{
                                    inputValue: '1',
                                    boxLabel: '是',
                                    checked: true
                                }, {
                                    inputValue: '0',
                                    boxLabel: '否'
                                }]
                            },
                            {
                                xtype:'numberfield',
                                allowBlank: false,
                                fieldLabel: '排序',
                                name: 'ord',
                                itemId: "ord",
                                emptyText: '排序',
                                blankText: '排序！',
                                value:0
                            }
                        ]
                    }
                ]
            }
        ];
        this.buttons = [
            {
                text: '保存',
                action: 'save'
            }, {
                text: '取消',
                scope: this,
                handler: this.close
            }
        ];
        this.callParent(arguments);
    }
});
/**
 * Created by LT on 2015/11/22 0022.
 */
Ext.define('Leo.view.role.Form', {
    extend: 'Ext.window.Window',
    alias: 'widget.roleform',
    title: '角色信息',
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
                url: "/roleAjax/role_save.do",
                fit: true,
                fieldDefaults: {
                    labelAlign: 'right',
                    labelWidth: 70
                },
                items: [{
                    xtype: 'hiddenfield',
                    name: 'id'
                },{
                        xtype: 'fieldset',
                        title: '角色信息',
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
                                emptyText: '角色名称',
                                blankText: '请输入角色名称！',
                            },
                            {
                                xtype: 'textareafield',
                                allowBlank: true,
                                grow: true,
                                fieldLabel: '描述',
                                name: 'descp',
                                itemId: "descp",
                                emptyText: '描述'
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
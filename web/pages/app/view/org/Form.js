/**
 * Created by LT on 2015-04-06.
 */
Ext.define('Leo.view.org.Form', {
    extend:'Ext.window.Window',
    alias:'widget.orgform',
    title:'组织信息',
    autoShow:true,
    resizable:false,
    modal:true,
    initComponent: function () {
        this.items=[
            {
                xtype:'form',
                bodyBorder: false,
                bodyPadding: '10 10 0 10',
                border: false,
                autoScroll: true,
                fit: true,
                fieldDefaults: {
                    labelAlign: 'right',
                    labelWidth: 70
                },
                items:[{
                    xtype: 'hiddenfield',
                    name: 'id'
                },{
                    xtype: 'hiddenfield',
                    name: 'pid'
                },
                    {
                        xtype: 'fieldset',
                        title: '组织信息',
                        defaultType: 'textfield',
                        itemId:'accountInfo',
                        defaults: {
                            anchor: '100%'
                        },
                        items: [
                            {
                                allowBlank: false,
                                fieldLabel: '名称',
                                name: 'name',
                                itemId:"name",
                                emptyText: '组织名称',
                                blankText: '请输入组织名称！',
                            },
                            {
                                xtype : 'textareafield',
                                allowBlank: true,
                                grow      : true,
                                fieldLabel: '描述',
                                name: 'descp',
                                itemId:"descp",
                                emptyText: '描述'
                            }
                        ]
                    }
                ]
            }
        ];
        this.buttons=[
            {
                text:'保存',
                action:'save'
            },{
                text:'取消',
                scope:this,
                handler:this.close
            }
        ];
        this.callParent(arguments);
    }
});
/**
 * Created by LT on 2015/11/22 0022.
 */
Ext.define('Leo.view.user.ChangePassWin', {
    extend:'Ext.window.Window',
    alias:'widget.changepasswin',
    title:'修改密码',
    autoShow:true,
    resizable:false,
    modal:true,
    initComponent: function () {
        Ext.apply(Ext.form.VTypes, {
            password: function (val, field) {
                debugger;
                if (field.confirmTo) {
                    var password = Ext.getCmp(field.confirmTo);
                    return (val == password.getValue());
                }
                return true;
            }
        });
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
                },
                    {
                        xtype: 'fieldset',
                        title: '帐户信息',
                        defaultType: 'textfield',
                        itemId:'accountInfo',
                        defaults: {
                            anchor: '100%'
                        },
                        items: [
                            {
                                allowBlank: false,
                                readOnly:true,
                                fieldLabel: '用户名',
                                name: 'username',
                                itemId:"username",
                                blankText: '请输入用户名！',
                            }
                            ,
                            {
                                allowBlank: false,
                                fieldLabel: '原密码',
                                name: 'password',
                                itemId:"password",
                                emptyText: '原密码',
                                inputType: 'password',
                                blankText: '请输入密码！'
                            },
                            {
                                allowBlank: false,
                                fieldLabel: '新密码',
                                name: 'newPassword',
                                itemId:"newPassword",
                                emptyText: '新密码',
                                inputType: 'password',
                                blankText: '请输入密码！',
                                minLength: 6,
                                minLengthText: '不能小于6位',
                                id:'pass'
                            },
                            {
                                allowBlank: false,
                                fieldLabel: '确认密码',
                                name: 'password1',
                                itemId:"password1",
                                emptyText: '确认密码',
                                inputType: 'password',
                                blankText: '请确认密码！',
                                minLength: 6,
                                minLength: '不能小于6位',
                                vtype: 'password',
                                vtypeText: '两次输入的密码不一致！',
                                confirmTo: 'pass'
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
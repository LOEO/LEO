/**
 * Created by LT on 2015-04-06.
 */
Ext.define('Leo.view.user.Form', {
    extend:'Ext.window.Window',
    alias:'widget.userform',
    title:'用户信息',
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
                                fieldLabel: '用户名',
                                name: 'username',
                                itemId:"username",
                                emptyText: '用户名',
                                blankText: '请输入用户名！',
                                minLength: 6,
                                minLengthText: '不能小于6位',
                                validator:function(thisText){
                                    var me = this;
                                    me.isExist = true;
                                    if(thisText.length >=6 ){
                                        Ext.Ajax.request({
                                            url:'/userAjax/check_user_exist.do',
                                            method:'post',
                                            params:{
                                                username:thisText
                                            },
                                            success:function(res){
                                                var data = Ext.decode(res.responseText);
                                                if(data.exist)
                                                    me.markInvalid('用户名已被使用');
                                                else
                                                    me.isExist = true;
                                            },
                                            failure:function(){
                                                me.isExist = '用户名已存在！';
                                            }
                                        })
                                    }
                                    return me.isExist;
                                }
                            },
                            {
                                allowBlank: false,
                                fieldLabel: '密码',
                                name: 'password',
                                itemId:"password",
                                emptyText: '密码',
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
                    },
                    {
                        xtype: 'fieldset',
                        title: '基本信息',
                        defaultType: 'textfield',
                        itemId:'baseInfo',
                        defaults: {
                            anchor: '100%'
                        },
                        items: [{
                            fieldLabel: '姓名',
                            emptyText: '姓名',
                            name: 'nickname',
                            allowBlank: false,
                            blankText: '请输入姓名！'
                        }, {
                            xtype: 'combobox',
                            fieldLabel: '性别',
                            emptyText: '请选择...',
                            name: 'sex',
                            editable: false,
                            store: new Ext.data.Store({
                                mode: 'local',
                                fields: [{name: 'sex', type: 'string'}],
                                data: [
                                    {sex: '保密'},
                                    {sex: '男'},
                                    {sex: '女'}
                                ]
                            }),
                            value:'保密',
                            displayField: 'sex',
                            valueField: 'sex'
                        },
                            {
                                fieldLabel: '电话',
                                emptyText: '电话',
                                name: 'phone'
                            },
                            {
                                fieldLabel: '邮箱',
                                emptyText: '邮箱',
                                name: 'email',
                                vtype: 'email'
                            },
                            {
                                xtype: 'datefield',
                                fieldLabel: '生日',
                                name: 'birthday',
                                format: 'Y-m-d',
                                editable: false,
                                allowBlank: false,
                                maxValue: new Date()
                            }]
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
    }/*,
    url: '${ctx}/userAjax/user_add.do'
    , buttons: [{
        text: '保存',
        disabled: true,
        formBind: true,
        handler: function () {
            var formPanel = this.up('form');
            var form = formPanel.getForm();
            if (form.isValid()) {
                var myMask = new Ext.LoadMask(document.body, {msg: '正在保存...'});
                myMask.show();
                form.submit({

                    success: function (form, action) {
                        myMask.hide();
                        formPanel.saveCallback();
                    },
                    failure: function (form, action) {
                        myMask.hide();
                        if (action.result) {
                            Ext.Msg.alert('提示', action.result.msg);
                        } else {
                            Ext.Msg.alert('提示', '服务器连接失败!');
                        }
                    }
                });
            }
        }
    }]*/
});
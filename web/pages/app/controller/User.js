/**
 * Created by LT on 2015-04-06.
 */
Ext.define('Leo.controller.User',{
    extend:'Ext.app.Controller',
    stores:['User'],
    models:['User'],
    views:['user.List','user.Form'],
    refs:[
        {ref:'userlist',selector:'userlist'},
        {ref:"userform",selector:'userform'}
    ],
    init:function(){
        this.control({
            'userlist button[action=add]':{
                click:this.addUser
            },
            'userlist button[action=update]':{
                click:this.updateUser
            },
            'userlist button[action=delete]':{
                click:this.deleteUser
            },
            'userform button[action=save]':{
                click:this.saveUser
            }
        });
    },
    addUser:function(){
        var view = Ext.widget('userform');
        view.setTitle('添加用户');
        view.down('form').getForm().url = '/userAjax/user_add.do';
    },
    updateUser:function(){
        var list = this.getUserlist(),
        selectionModel = list.getSelectionModel();
        if(selectionModel.hasSelection()){
            var view = Ext.widget('userform'),
                form = view.down('form'),
                record = selectionModel.getLastSelected(),
                items = form.items.get('accountInfo');
            items.removeAll();
            items.add([
                {
                    fieldLabel: '用户名',
                    name: 'username',
                    itemId:"username",
                    readOnly:true
                },{
                    allowBlank: false,
                    fieldLabel: '密码',
                    name: 'password',
                    itemId:"password",
                    emptyText: '密码',
                    inputType: 'password',
                    blankText: '请输入密码！',
                    minLength: 6,
                    minLengthText: '不能小于6位'
                }
            ]);
            view.setTitle('编辑用户');
            form.getForm().url = '/userAjax/user_update.do';
            form.loadRecord(record);
            items.get("username").clearInvalid();
        }else{
            Ext.Msg.alert('提示', '请选择一个用户！!');
        }
    },
    saveUser:function(){
        var form = this.getUserform().down('form'),
            me = this;
        if(form.getForm().isValid()){
            var myMask = new Ext.LoadMask(document.body, {msg: '正在保存...'});
            myMask.show();
            form.submit({
                success: function (form, action) {
                    myMask.hide();
                    me.getUserlist().getSelectionModel().deselectAll();
                    me.getUserlist().getStore().reload();
                    me.getUserform().close();
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
    },
    deleteUser:function(){
        var list = this.getRolelist(),
            me = this,
            selectionModel = list.getSelectionModel();
        if(selectionModel.hasSelection()){
            Ext.Msg.confirm('提示','您确定要删除吗？',function(btn){
                if(btn == 'yes'){
                    var record = selectionModel.getLastSelected();
                    Ext.Ajax.request({
                        url:'/userAjax/user_delete.do',
                        method:'post',
                        params:{
                            id:record.get('id')
                        },
                        success:function(res){
                            Ext.Msg.alert('提示', '删除成功！');
                            me.getRoleStore().remove(record);
                            me.getRolelist().getStore().reload();
                        },
                        failure:function(){
                            Ext.Msg.alert('提示', '删除失败！');
                        }
                    })
                }
            });

        }else{
            Ext.Msg.alert('提示', '请选择一个用户！!');
        }
    }
});
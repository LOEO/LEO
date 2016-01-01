/**
 * Created by LT on 2015-04-06.
 */
Ext.define('Leo.controller.Main',{
    extend:'Ext.app.Controller',
    views:['user.ChangePassWin'],
    refs:[
        {ref:"changepasswin",selector:"changepasswin"}
    ],
    init:function(){
        this.control({
            'changepasswin button[action=save]':{
                click: this.savePass
            }
        });
    },
    onLaunch:function(){
        var curUserDom = Ext.getDom("curUser");
        curUserDom.innerText = LEO.curUserNickName;
        curUserDom.onclick = this.openChangePassWin;
        Ext.getDom("online").innerText = LEO.online;
    },
    openChangePassWin:function() {
        var view = Ext.widget('changepasswin'),
            form = view.down('form');
            form.loadRecord(new Leo.model.User({username:LEO.curUserName}));
    },
    savePass:function() {
        var form = this.getChangepasswin().down('form').getForm(),
            me = this;
        if(form.isValid()){
            form.url = '/userAjax/change_password.do';
            var myMask = new Ext.LoadMask(document.body, {msg: '正在保存...'});
            myMask.show();
            form.submit({
                success: function (form, action) {
                    myMask.hide();
                    me.getChangepasswin().close();
                    Ext.Msg.alert('提示', action.result.msg);
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
});
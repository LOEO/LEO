/**
 * Created by LT on 2015-04-11.
 */
Ext.define('Leo.lib.UserNameValidator',{
    singleton:true,
    url:'/userAjax/check_user_exist.do',
    validate:function(thisText){
        var me = this;
        if(thisText.length >=6 ){
            Ext.Ajax.request({
                url:this.url,
                method:'post',
                params:{
                    username:thisText
                },
                success:function(res){
                    var data = Ext.decode(res.responseText);
                    if(data.exist)
                        me.markInvalid('用户名已被使用');
                    else
                        isExist = true;
                },
                failure:function(){
                    isExist = '用户名已存在！';
                }
            })
        }
        return isExist;
    }
});
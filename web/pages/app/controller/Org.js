/**
 * Created by LT on 2015-04-12.
 */
Ext.define('Leo.controller.Org',{
    extend:'Ext.app.Controller',
    models:['Org','User'],
    stores:['Org'],
    views:['org.Layout','org.Tree','org.Form','user.OrgUser'],
    refs:[
        {ref:'orgtree',selector:'orgtree'},
        {ref:'orgform',selector:'orgform'},
        {ref:'orguser',selector:'orguser'}
    ],
    init:function(){
        debugger;
        this.control({
            'orgtree button[action=add]':{
                'click':this.addNode
            },
            'orgtree button[action=delete]':{
                'click':this.deleteNode
            },
            'orgtree button[action=edit]':{
                'click':this.editNode
            },
            'orgform button[action=save]':{
                'click':this.save
            },
            'orguser button[action=addUser]':{
                click:this.addUser
            },
        });
    },
    addNode:function(){
        var selectionModel = this.getOrgtree().getSelectionModel();
        if(selectionModel.hasSelection()){
            var view = Ext.widget('orgform'),
                form = view.down('form').getForm();
            view.setTitle('添加组织');
            form.url =  '/orgAjax/org_add.do';
            form.loadRecord(new Leo.model.Org({
                pid:selectionModel.getLastSelected().get("id")
            }));
        }else{
            Ext.Msg.alert('提示', '请选择父级组织！');
        }
        //view.down('form').getForm().url = '/userAjax/user_add.do';
    },
    editNode:function(){
        var selectionModel = this.getOrgtree().getSelectionModel();
        if(selectionModel.hasSelection()){
            var record = selectionModel.getLastSelected();
            if(record.get("id") == "0"){
                Ext.Msg.alert('提示', '此节点不能编辑！');
                return;
            }
            var view = Ext.widget('orgform'),
                form = view.down('form').getForm();
            view.setTitle('编辑组织');
            form.url =  '/orgAjax/org_edit.do';
            form.loadRecord(selectionModel.getLastSelected());
        }else{
            Ext.Msg.alert('提示', '请选择一个组织！');
        }
    },
    deleteNode:function(){
        var selectionModel = this.getOrgtree().getSelectionModel(),
             me = this;
        if(selectionModel.hasSelection()){
            Ext.Msg.confirm('提示','您确定要删除吗？',function(btn){
                if(btn == 'yes'){
                    var record = selectionModel.getLastSelected();
                    if(record.get("leaf")){
                        Ext.Ajax.request({
                            url:'/orgAjax/org_delete.do',
                            method:'post',
                            params:{
                                id:record.get('id'),
                                pid:record.get("pid")
                            },
                            success:function(res){
                                Ext.Msg.alert('提示', '删除成功！');
                                me.getOrgtree().getStore().load();
                            },
                            failure:function(){
                                Ext.Msg.alert('提示', '删除失败！');
                            }
                        })
                    }else{
                        Ext.Msg.alert('提示', '选择的组织下有子组织不能删除！');
                    }
                }
            });
        }else{
            Ext.Msg.alert('提示', '请选择要删除的组织！');
        }
    },
    save:function(){
        var form = this.getOrgform().down('form'),
            me = this;
        if(form.getForm().isValid()){
            var myMask = new Ext.LoadMask(document.body, {msg: '正在保存...'});
            myMask.show();
            form.submit({
                success: function (form, action) {
                    myMask.hide();
                    me.getOrgtree().getStore().load();
                    me.getOrgform().close();
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
    addUser:function(){
        alert("add");
    }
});
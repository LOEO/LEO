/**
 * Created by LT on 2015/12/13 0013.
 */
Ext.define('Leo.controller.Menu', {
    extend: 'Ext.app.Controller',
    models: ['Menu'],
    stores: ['Menu'],
    views: ['menu.Grid'],
    refs: [
        {ref: 'menugrid', selector: 'menugrid'}
    ],
    init: function () {
        this.control({
            'rolelist button[action=add]': {
                'click': this.addRole
            },
            'rolelist button[action=delete]': {
                'click': this.deleteRole
            },
            'rolelist button[action=edit]': {
                'click': this.editRole
            },
            'roleform button[action=save]': {
                'click': this.save
            }
        });
    },
    addRole: function () {
        var view = Ext.widget('roleform');
        view.setTitle('添加角色');
    },
    editRole: function () {
        var list = this.getRolelist(),
            selectionModel = list.getSelectionModel();
        if (selectionModel.hasSelection()) {
            var view = Ext.widget('roleform'),
                form = view.down('form'),
                record = selectionModel.getLastSelected();
            view.setTitle('编辑用户');
            form.loadRecord(record);
        }
    },
    deleteRole: function () {
        var selectionModel = this.getRolelist().getSelectionModel(),
            me = this;
        if (selectionModel.hasSelection()) {
            Ext.Msg.confirm('提示', '您确定要删除吗？', function (btn) {
                if (btn == 'yes') {
                    var record = selectionModel.getLastSelected();
                    Ext.Ajax.request({
                        url: '/roleAjax/role_del.do',
                        method: 'post',
                        params: {
                            id: record.get('id'),
                            pid: record.get("pid")
                        },
                        success: function (res) {
                            Ext.Msg.alert('提示', '删除成功！');
                            me.getRolelist().getStore().load();
                        },
                        failure: function () {
                            Ext.Msg.alert('提示', '删除失败！');
                        }
                    });
                }
            });
        } else {
            Ext.Msg.alert('提示', '请选择要删除的组织！');
        }
    },
    save: function () {
        var form = this.getRoleform().down('form'),
            me = this;
        if (form.getForm().isValid()) {
            var myMask = new Ext.LoadMask(document.body, {msg: '正在保存...'});
            myMask.show();
            form.submit({
                success: function (form, action) {
                    myMask.hide();
                    me.getRolelist().getSelectionModel().deselectAll();
                    me.getRolelist().getStore().reload();
                    me.getRoleform().close();
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
    addUser: function () {
        alert("add");
    }
});
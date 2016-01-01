/**
    * Created by LT on 2015-04-06 15:37
    */
Ext.define('Leo.store.OrgUser', {
    extend:'Ext.data.Store',
    model: 'Leo.model.User',
    pageSize: 20,
    proxy: {
        type: 'ajax',
        url: 'orgAjax/user_list.do',
        reader: {
            type: 'json',
            root: 'rows',
            totalProperty: 'total'
        }
    }
});
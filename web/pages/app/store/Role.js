/**
* Created by LT on 2015/11/22 0022 .15:36
*/
Ext.define('Leo.store.Role', {
    extend:'Ext.data.Store',
    model: 'Leo.model.Role',
    pageSize: 20,
    proxy: {
        type: 'ajax',
        url: 'roleAjax/role_list.do',
        reader: {
            type: 'json',
            root: 'rows',
            totalProperty: 'total'
        }
    }
});
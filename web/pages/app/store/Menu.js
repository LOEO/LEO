/**
* Created by LT on 2015/11/22 0022 .15:36
*/
Ext.define('Leo.store.Menu', {
    extend:'Ext.data.Store',
    model: 'Leo.model.Menu',
    pageSize: 20,
    proxy: {
        type: 'ajax',
        url: 'menuAjax/menu_list.do',
        reader: {
            type: 'json',
            root: 'rows',
            totalProperty: 'total'
        }
    }
});
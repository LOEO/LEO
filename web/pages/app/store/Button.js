/**
* Created by LT on 2015/11/22 0022 .15:36
*/
Ext.define('Leo.store.Button', {
    extend:'Ext.data.Store',
    model: 'Leo.model.Button',
    pageSize: 20,
    proxy: {
        type: 'ajax',
        url: 'buttonAjax/button_list.do',
        reader: {
            type: 'json',
            root: 'rows',
            totalProperty: 'total'
        }
    }
});
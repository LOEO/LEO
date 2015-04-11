/**
 * Created by LT on 2015-04-06.
 */
Ext.define('Leo.store.User', {
    extend:'Ext.data.Store',
    model: 'Leo.model.User',
    pageSize: 16,
    proxy: {
        type: 'ajax',
        url: 'userAjax/user_list.do',
        reader: {
            type: 'json',
            root: 'rows',
            totalProperty: 'total'
        }
    }
});
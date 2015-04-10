/**
 * Created by LT on 2015-04-06.
 */
Ext.define('Leo.store.User', {
    extend:'Ext.data.Store',
    model: 'Leo.model.User',
    autoLoad:true,
    pageSize: 10,
    proxy: {
        type: 'ajax',
        url: 'userAjax/user_list.do'
    }
});
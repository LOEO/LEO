/**
 * Created by LT on 2015-04-06.
 */
Ext.define('Leo.store.User', {
    extend:'Ext.data.Store',
    model: 'Leo.model.User',
    pageSize: 20,
    proxy: {
        type: 'ajax',
        url: 'userAjax/user_list.do',
/*        api:{
            create:'/userAjax/user_add.do',
            read:'userAjax/user_list.do',
            update:'userAjax/user_delete.do',
            destroy:'/userAjax/user_delete.do'
        },*/
        reader: {
            type: 'json',
            root: 'rows',
            totalProperty: 'total'
        }
    }
});
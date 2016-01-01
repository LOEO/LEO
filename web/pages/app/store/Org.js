/**
 * Created by LT on 2015-04-06.
 */
Ext.define('Leo.store.Org', {
    extend:'Ext.data.TreeStore',
    model: 'Leo.model.Org',
    root:{
        name:"组织架构",
        id:0
    },
    proxy: {
        type: 'ajax',
        url: 'orgAjax/org_list.do',
    }
});
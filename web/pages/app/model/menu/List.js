/**
 * Created by LT on 2015-04-06.
 */
Ext.define('Leo.model.menu.List', {
    extend: 'Ext.data.Model',
    fields: [
        {name: 'id', type: 'string'},
        {name: 'pid', type: 'string'},
        {name: 'text', type: 'string'},
        {name: 'ctrl', type: 'string'},
        {name:'view',type:'string'}
    ]
});
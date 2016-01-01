/**
 * Created by LT on 2015-04-12.
 */
Ext.define('Leo.model.Org',{
    extend:'Ext.data.Model',
    fields:[
        {name:'id',type:'int'},
        {name:'name',type:'string'},
        {name:'pid',type:'int'},
        {name:'descp',type:'string'}
    ]
});
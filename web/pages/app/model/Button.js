/**
 * Created by LT on 2015/11/22 0022.
 */
Ext.define('Leo.model.Button',{
    extend:'Ext.data.Model',
    fields:[
        {name:'id',type:'int'},
        {name:'name',type:'string'},
        {name:'class',type:'string'},
        {name:'icon',type:'string'},
        {name:'script',type:'string'},
        {name:'menuId',type:'int'},
        {name:'ord',type:'int'},
        {name:'status',type:'string'}
    ]
});
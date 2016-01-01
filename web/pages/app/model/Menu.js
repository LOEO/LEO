/**
 * Created by LT on 2015/11/22 0022.
 */
Ext.define('Leo.model.Menu',{
    extend:'Ext.data.Model',
    fields:[
        {name:'id',type:'int'},
        {name:'name',type:'string'},
        {name:'icon',type:'string'},
        {name:'url',type:'string'},
        {name:'pid',type:'int'},
        {name:'isVisible',type:'int'},
        {name:'isLeaf',type:'int'},
        {name:'ord',type:'int'}
    ]
});
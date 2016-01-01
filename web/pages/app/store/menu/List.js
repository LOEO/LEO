/**
 * Created by LT on 2015-04-06.
 */
Ext.define('Leo.store.menu.List',{
    extend:'Ext.data.Store',
    model:'Leo.model.menu.List',
    data:[
        {
            id:'0',
            text: '用户管理',
            ctrl:'User',
            view:"userlist"
        },
        {
            id:'1',
            text: '组织架构',
            ctrl:'Org',
            view:"orglayout"
        },
        {
            id:'2',
            text: '角色管理',
            ctrl:'User',
            view:"rolelist"
        },
        {
            id:'3',
            text: '权限管理',
            ctrl:'User',
            view:"userlist"
        },
        {
            id:'4',
            text: '菜单管理',
            ctrl:'User',
            view:"userlist"
        }
    ]
});
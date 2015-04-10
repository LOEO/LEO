/**
 * Created by LT on 2015-04-06.
 */
Ext.define('Leo.controller.Menu',{
    extend:'Ext.app.Controller',
    stores:['menu.List','User'],
    models:['menu.List','User'],
    requires: [
        'Leo.store.menu.List',
        'Leo.view.user.List'
    ],
    refs:[
        {ref:'menuList',selector:'menulist'},
        {ref:'menuData',selector:'menulist dataview'},
        {ref:'mainTab',selector:'maintab'}
    ],
    init:function(){
        this.control({
            'menulist dataview':{
                itemclick: this.openPage
            }
        });
    },
    onLaunch: function() {
        var dataview = this.getMenuData(),
            store = this.getMenuListStore();

        dataview.bindStore(store);
        dataview.getSelectionModel();//.select(store.getAt(0));
    },
    openPage:function(selModel, menu){
        debugger;
        var tab = this.getMainTab(),
            tabItem = tab.getComponent(menu.get('id'));
        if(tabItem){
            tabItem.show();
        }else{
            tab.add(
                {
                    closable: true,
                    xtype:menu.get('view'),
                    itemId:menu.get('id'),
                    title:menu.get('text')
                }
            ).show();
            this.getController(menu.get('ctrl'));
        }
    }
});
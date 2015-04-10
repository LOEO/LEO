/**
 * Created by LT on 2015-04-06.
 */
Ext.define('Leo.model.User', {
    extend: 'Ext.data.Model',
    fields: [
        {name: 'id', type: 'int'},
        {name: 'username', type: 'string'},
        {name: 'password', type: 'string'},
        {name: 'nickname', type: 'string'},
        {name: 'age', type: 'int'},
        {name: 'birthday', type: 'string'},
        {name: 'sex', type: 'string'},
        {name: 'avatar', type: 'string'},
        {name: 'email', type: 'string'},
        {name: 'phone', type: 'string'}
    ],
    proxy: {
        type: 'ajax',
        reader: 'json'
    }
});
/**
 * Created by LT on 2015-04-06.
 */
Ext.define('Leo.store.menu.Accordion',{
    extend:'Ext.data.Store',
    model:'Leo.model.Menu',
    data: [
        {
            id: '1',
            pid: '1',
            name: 'test1',
            text: '123'
        },
        {
            id: '2',
            pid: '2',
            name: 'test2'
        },
        {
            id: '3',
            pid: '3',
            name: 'test3'
        }
    ],
    root: {
        text: 'Ext JS',
        id: 'src',
        expanded: true
    }
});
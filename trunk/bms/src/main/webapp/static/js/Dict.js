Ext.define('Bms.Dict', {
	extend : 'Ext.panel.Panel',
	alias: ['widget.dict_manage'],
	layout : 'fit',
	items : [{
		xtype : 'grid',
		store : Ext.create('Ext.data.Store', {
		    storeId:'simpsonsStore',
		    fields:['name', 'email', 'phone'],
		    data:{'items':[
		        { 'name': 'Lisa',  "email":"lisa@simpsons.com",  "phone":"555-111-1224"  },
		        { 'name': 'Bart',  "email":"bart@simpsons.com",  "phone":"555-222-1234" },
		        { 'name': 'Homer', "email":"home@simpsons.com",  "phone":"555-222-1244"  },
		        { 'name': 'Marge', "email":"marge@simpsons.com", "phone":"555-222-1254"  }
		    ]},
		    proxy: {
		        type: 'memory',
		        reader: {
		            type: 'json',
		            root: 'items'
		        }
		    }
		}),
		columns: [
		   { text: '类别',  dataIndex: 'name' },
           { text: 'Email', dataIndex: 'email', flex: 1 },
           { text: 'Phone', dataIndex: 'phone' }
        ],
        bbar : [{
        	text : 'Add'
        }]
	}]
});
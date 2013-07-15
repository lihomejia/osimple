Ext.define('Bms.Book', {
	extend : 'Ext.panel.Panel',
	alias: ['widget.book_manage'],
	layout : 'fit',
	items : [{
		xtype : 'grid',
		store : Ext.create('Ext.data.Store', {
		    storeId:'simpsonsStore',
		    fields:['name', 'author', 'price', 'category', 'reader', 'status'],
		    data:{'items':[
		        { 
		        	name : 'aaa',
		        	author : '(美)埃克尔 著,陈昊鹏 译　译者：陈昊鹏 译', 
		        	price : "108",  
		        	category : "计算机科学丛书", 
		        	reader : '', 
		        	status :'空闲'  
		        }
		       
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
		   { text: '图书名称',  dataIndex: 'name' },
           { text: '作者', dataIndex: 'author', flex: 1 },
           { text: '定价', dataIndex: 'price' },
           { text: '所属分类', dataIndex: 'category' },
           { text: '当前读者', dataIndex: 'reader' },
           { text: '当前状态', dataIndex: 'status' }
        ],
        bbar : [{
        	text : 'Add'
        }]
	}]
});
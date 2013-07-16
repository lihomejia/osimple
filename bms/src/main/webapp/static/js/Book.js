Ext.define('Bms.Book', {
	extend : 'Ext.panel.Panel',
	alias: ['widget.book_manage'],
	layout : 'fit',
	items : [{
		xtype : 'grid',
		store : Ext.create('Ext.data.Store', {
			autoLoad : true,
		    storeId:'simpsonsStore',
		    fields:['id', 'bookName', 'author', 'press', 'publicationDate', 'categoryId'],
		    proxy: {
		    	type: 'ajax',
		        url: window.basePath + 'book/bookList/findList',
		    }
		}),
		columns: [
		   { text: '图书名称',  dataIndex: 'bookName' },
           { text: '作者', dataIndex: 'author', flex: 1 },
           { text: '所属分类', dataIndex: 'categoryId' }
        ]
	}]
});
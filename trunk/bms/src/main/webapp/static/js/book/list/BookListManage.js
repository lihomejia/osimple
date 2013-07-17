Ext.define('Bms.book.list.BookListManage', {
	extend : 'Ext.container.Container',
	
	initComponent : function() {
		var me = this;
		
		var store = Ext.create('Ext.data.Store', {
			autoLoad : true,
		    fields:['id', 'bookName', 'author', 'press', 'publicationDate', 'categoryId'],
		    proxy: {
		    	type: 'ajax',
		        url: Base.calUrl('book/bookList/findList')
		    }
		});
		
		Ext.apply(me, {
			layout : 'fit',
			items : [{
				xtype : 'grid',
				store : store,
				columns: [
				   { text: '图书名称',  dataIndex: 'bookName', flex: 1 },
		           { text: '作者', dataIndex: 'author', flex: 1 },
		           { text: '所属分类', dataIndex: 'categoryId' }
		        ]
			}]
		});
		
		me.callParent();
	}
});
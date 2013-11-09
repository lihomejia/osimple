Ext.define('Bms.resource.DictType', {
	extend : 'Ext.container.Container',
	
	addTabToTop : function() {
		alert(1);
	},
	
	initComponent : function() {
		var me = this;
		
		var store = Ext.create('Ext.data.Store', {
			autoLoad : true,
		    fields:['type', 'desc'],
		    proxy: {
		    	type: 'ajax',
		        url: Base.calUrl('resource/dictType/list')
		    }
		});
		
		Ext.apply(me, {
			layout : 'fit',
			items : [{
				xtype : 'grid',
				store : store,
				columns: [{ 
					text: '字典代码',  
					dataIndex: 'type', 
					flex: 1,
					xtype: 'component',
				    autoEl: {
				        tag: 'a',
				        href: 'http://www.example.com/',
				        html: 'Example.com'
				    }

				}, { 
					text: '描述', 
					dataIndex: 'desc', 
					flex: 2
				}]
			}]
		});
		
		me.callParent();
	}
});
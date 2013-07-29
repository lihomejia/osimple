Ext.define('Ess.demo.list.DemoGrid', {
	extend: 'Ext.grid.Panel',
	requires : ['Norming.components.SearchField'],
	initComponent: function(){
		var me = this;
		var store = [];
		var searchPanel = Ext.create('Ext.panel.Panel', {
			itemId: 'searchPanel',
			width : 340,
			height : 135,
			bodyPadding : '5 3 3 3',
			layout : 'column',
			floating: true,
		    defaults : {
		    	xtype : 'textfield',
		    	border : false,
		    	enableKeyEvents: true,
		    	columnWidth : 1,
		    	labelWidth : 150,
		    	labelSeparator: '',
		    	labelAlign: 'lift',
		    	selectOnFocus : true,
		    	labelPad : 10,
		    	margin : '0 5 10 0'
		    },
		    items : [{
		    	itemId : 'subEmp',
		    	fieldLabel : 'subEmp'
		    },{
		    	itemId : 'docDesc',
		    	fieldLabel : 'docDesc'
		    },{
		    	itemId : 'docId',
		    	fieldLabel : 'docId'
		    }]
		});
		Ext.apply(me, {
			dockedItems: [{
				xtype: 'toolbar',
		        dock: 'top',
		        border : '1 1 1 0',
				height: 51,
				items: [{
					text : 'Button1',
					isButton: false,
					itemId : 'Button1',
					border: false,
					overCls : 'nor-btn-over',
					cls: 'x-nor-btn',
					pressedCls: 'nor-btn-pressed',
					margin: '0 0 0 5'
				},{
					text : 'Button2',
					isButton: false,
					itemId : 'Button2',
					border: false,
					overCls : 'nor-btn-over',
					cls: 'x-nor-btn',
					pressedCls: 'nor-btn-pressed',
					margin: '0 10 0 15'
				},{
					xtype: 'searchfield',
					selectOnFocus : true,
			        searchPanel: searchPanel,
			        flex : 1,
			        itemId:'searchField',
			        margin : '0 15 0 5'
				}]
			},{
				xtype: 'toolbar',
		        dock: 'bottom',
		        layout: {
		        	pack: 'center'
		        },
				items : [{
					xtype: 'pagingtoolbar',
					text: 'Search',
					border : false,
					store :store,
				    displayInfo: true,
				    itemId : 'toDoListGridBbar',
				    displayMsg: '{0} - {1} of {2}'
				}]
			}],
			enableColumnHide : false,
			store : store,
			selModel: {
				selType: 'checkboxmodel'
			},
			multiSelect: true,
			stateful : true,
			columns : [{
				header : 'docId',
				headerId : 'docId',
				width : 200,
		        dataIndex: 'docId',
				sortable : true,
				menuDisabled: true,
				renderer : function(value){
					return '<a href="javascript:void(0);" onclick="return false;" style="color:'+linkColor+';">'+value+'</a>';
				}
			},{
				header : 'docDesc',
				headerId : 'docDesc',
				width : 300,
		        dataIndex: 'docDesc',
				sortable : true,
				menuDisabled: true
			},{
				header: 'subDate',
				headerId : 'subDate',
				width : 200,
		        dataIndex: 'subDate',
				sortable : true,
				menuDisabled: true
			},{
				header: 'subEmp',
				headerId : 'docEmp',
				width : 200,
		        dataIndex: 'docEmp',
				sortable : true,
				menuDisabled: true
			}]
		});
		me.callParent(arguments);
	}
});
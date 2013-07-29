Ext.define('Ess.demo.list.DemoPanel', {
	extend: 'Ext.panel.Panel',
	bodyStyle : 'border-width : 1 0 1 1',
	
	constructor : function(config) {
		var me = this;
//		me.win = cfg.win;
		Ext.apply(me, config || {});
		me.callParent([config]);
	},
	
	initComponent: function() {
		var me = this,
			donut = false;
		Ext.apply(me, {
			tbar: {
				border: '1 0 1 1',
				items:[{
					iconCls: 'icon-cog',
					scale: 'large',
					border: 0,
					itemId: 'cogBtn'
				},{
					xtype: 'component',
					html: '<span style="color:#727171;font-size:17px;font-weight:bold;">'+ 'DemoList'+'</span>',
					margin: '0'
				},'->',{
					iconCls : 'icon-home2',
					tooltip : 'home',
					width: 36,
					frame: false,
					border: 0,
					itemId : 'backBtn',
					scale : 'large',
					margin: '0 15 0 0',
					listeners : {
						click : function() {
							me.win.hide();
						}
					}
				}]
			},
			layout: 'border',
			items: [{
				xtype: 'container',
				region: 'center',
				itemId : 'tabContainer',
				overflowX : 'auto',
				overflowY : 'auto',
				layout: 'anchor',
				defaults : {
					xtype : 'tab',
					closable : false,
					border: false,
					anchor : '100%',
					margin : 2,
					textAlign : 'left',
					height : 40,
					allowDepress: false,
					enableToggle: true,
					toggleGroup: 'todolisttab'
				},
				items : [{
					text : 'allBtn',
					itemId : 'all'
				},{
					text : 'timesheetBtn',
					itemId : 'timesheet'
				},{
					text : 'expenseReportBtn',
					itemId : 'expenseReport'
				},{
					text : 'overtimeBtn',
					itemId : 'overtime'
				},{
					text : 'cashAdvanceBtn',
					itemId : 'cashAdvance'
				},{
					text : 'leaveBtn',
					itemId : 'leave'
				}]
			}]
		});
		me.callParent(arguments);
	}
});
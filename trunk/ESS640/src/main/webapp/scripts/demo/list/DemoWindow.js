Ext.define('Ess.demo.list.DemoWindow', {
	extend: 'Ext.window.Window',
	requires: ['Ess.demo.list.DemoPanel',
				'Ess.demo.list.DemoGrid'],
	initComponent: function(){
		var me = this;
		Ext.apply(me, {
		    border: false,
			layout: 'border',
			items: [Ext.create('Ess.demo.list.DemoPanel', {
				split: true,
				region: 'west',
				width: 320,
				win : me
			}),{
				region: 'center',
				layout: 'fit',
				items: Ext.create('Ess.demo.list.DemoGrid', {
					itemId : 'demoGrid'
				})
			}]
		});
		me.callParent(arguments);
	}
});
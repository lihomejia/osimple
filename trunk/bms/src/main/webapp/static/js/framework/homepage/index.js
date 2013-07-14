Ext.QuickTips.init();

var mainTabs;

Ext.onReady(function() {
	mainTabs = Ext.create('Ext.tab.Panel', {
	    region:'center', 
	    activeTab:0,
	    id:'mainTabs',
	    enableTabScroll:true,
	    height:550,
	    border:false,
	    frame:true,
	    items:[{
	          title:'欢迎使用'
	     }]
	 });
	
	
	Ext.create('Ext.container.Viewport', {
		layout : 'border',
		defaults : {
			collapsible : true,
			split : true
		},
		items : [{
			region : 'north',
			height : 36,
			title : '图书管理系统 V1.0',
			collapsible:false,
            layout : 'fit'
		}, {
			title : 'Menus',
			id : 'accordion-panel',
			layout : 'border',
			region : 'west',
			margins : '2 0 5 5',
			width : 200,
			minSize : 200,
			maxSize : 250,
			bodyStyle : 'background-color:#DFE8F6',
			defaults : {
				border : false
			},
			items : [{
				layout : 'accordion',
				region : 'center',
				items : [{
					title : '导航菜单',
					iconCls : 'icon-nav',
					border : false,
					items : [{
						xtype : 'treepanel',
						border : false,
						rootVisible : true,
						autoScroll : true,
						loader : {
							url : window.basePath + 'static/js/framework/homepage/menu.json',
					        autoLoad: true
						}
					}]
				}]
			}]
		}, {
			id : 'content-panel',
			collapsible : false,
			header : false,
			region : 'center',
			layout : 'card',
			margins : '2 5 5 0',
			activeItem : 0,
			border : false,
			items : [mainTabs]
		}]
	});
});

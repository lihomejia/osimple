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
			collapsible:true,
			collapseMode: 'mini',
			hideCollapseTool: true,
            items : {
            	xtype : 'toolbar',
            	items : [{
                	text : '退出'
                }]
            } 
		}, {
			title : '导航菜单',
			id : 'menus-panel',
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
				region : 'center',
				items : [{
					xtype : 'treepanel',
					border : false,
					rootVisible : false,
					autoScroll : true,
					store : Ext.create('Ext.data.TreeStore', {
						proxy : {
							type : 'ajax',
							url : window.basePath + 'static/js/framework/homepage/menu.json'
						}
					})
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

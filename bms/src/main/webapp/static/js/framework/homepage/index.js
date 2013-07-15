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
	          title:'欢迎使用',
	          contentEl : 'welcome'
	     }, {
	    	 title : 'DO',
	    	 closable : true
	     }]
	 });
	
	Ext.getDom('welcome').style.visibility = 'visible';
	Ext.create('Ext.container.Viewport', {
		layout : 'border',
		defaults : {
			collapsible : true,
			split : true
		},
		items : [{
			xtype : 'panel',
			layout : 'fit',
			region : 'north',
			height : 51,
			collapsible:false,
			collapseMode: 'mini',
			hideCollapseTool: true,
            tbar : {
            	height : 51,
            	xtype : 'toolbar',
            	style : {
            		background: '#157FCC'
            	},
            	items : ['->', {
                    text : '帮助',
                    scale: 'large',
                    iconCls : 'icon_help'
                }, {
                    text : '退出',
                    scale: 'large',
                    iconCls : 'icon_logoff'
                }]
            }
            
		}, {
			title : '导航菜单',
			id : 'menus-panel',
			layout : 'fit',
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

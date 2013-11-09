Ext.Loader.setPath('Bms', Base.calUrl('static/js'));

var Homepage = {};

Ext.onReady(function() {
	var mainTabs = Ext.create('Ext.tab.Panel', {
	    activeTab:0,
	    id:'mainTabs',
	    enableTabScroll:true,
	    items:[{
	          title:'欢迎使用',
	          contentEl : 'welcome'
	     }]
	 });
	 
	Homepage.addTab = function(cfg) {
		cfg = cfg || {};
		var id = cfg.id || Ext.id();
		var cls = cfg.cls;
		var tab = mainTabs.queryById(id);
		if (!tab) {
			var items = [];
			if (cls) {
				//Ext.require(cls);
				items = Ext.create(cls);
			}
			tab = mainTabs.add(Ext.applyIf(cfg, {
				id : id,
		    	closable : true,
		    	layout : 'fit',
		    	items : items
			}));
		}
		mainTabs.setActiveTab(tab);
	}
	
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
            	items : [{
            		xtype : 'image',
            		src : Base.calUrl('static/images/logo.png')
            	}, '->', {
                    text : '帮助',
                    scale: 'large',
                    iconCls : 'icon_help',
                    handler : function() {
                    	Ext.Msg.show({
                		    title: '关于本系统',
                		    icon: Ext.window.MessageBox.INFO,
                		    msg: '本系统采用目前较为流行的技术实现,<br>前台使用了ExtJs技术,所以实现了跨浏览器<br>'
                		    	+ '主要技术: Spring MVC 3.2.3 + ExtJs4.2.1<br>'
								+ '数&nbsp;&nbsp;据&nbsp;&nbsp;库: MySQL5',
                		    width: 300
                    	});
                    }
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
						url : Base.calUrl('static/js/framework/homepage/menu.json')
					}
				}),
				listeners : {
					'itemclick' : function(_this, record, item, index, e, eOpts) {
						var id = record.get('id');
						var cls = record.get('cls');
						if (Ext.isEmpty(id)) return;
						
						Homepage.addTab({
							id : id,
							title : record.get('text'),
							cls : cls
						});
					}
				}
			}]
		}, {
			id : 'content-panel',
			collapsible : false,
			region : 'center',
			layout : 'fit',
			margins : '2 5 5 0',
			border : false,
			items : mainTabs
		}]
	});
});

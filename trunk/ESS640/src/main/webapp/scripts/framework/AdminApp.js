Ext.define('MyDesktop.AdminApp', {
    extend: 'Ext.ux.desktop.App',

    requires: [
        'Ext.window.MessageBox',
        'Ext.ux.desktop.ShortcutModel',
        'MyDesktop.Settings'
    ],

    init: function() {
        // custom logic before getXYZ methods get called...

        this.callParent();

    },
    
    
    
    /**
     * 桌面弹出框.
     * 桌面快捷菜单、开始菜单 等 均使用该方法.
     * @param {} item
     * @return {}
     */
	showWindow : function(item) {
		var me = this,
			desktop = me.getDesktop(),
			id = item.itemId;
		/**从桌面管理window的容器中取得指定ID的window框 */	
	    var win = desktop.getWindow(id);
	    var exists = true;
		
		if (!win) {
			exists = false;
			/** 计算窗口的大小，如果用户指定的大小超过屏幕的最大值，则使用屏幕最大值 */
			var xwidth = parseInt(item.xwidth) ||  800,
				yheight = parseInt(item.yheight) || 500;
			xwidth = xwidth > document.body.clientWidth ? document.body.clientWidth : xwidth;
			yheight = yheight > document.body.clientHeight ? document.body.clientHeight - 15 : yheight;
			
			/** 拷贝传过来的所有参数 */
			var def = Ext.apply({}, item || {});
			
			var cfg = {
				id : id
			};
			win = desktop.createWindow(Ext.apply(def, cfg), item.cls);
		}else{
			Ext.apply(win,item);
		}
		
		win.show();
		if (true) {
			var wbody = Ext.getCmp(win.id);
			Ext.getBody().unmask();
			//wbody.body.mask(rs.loading, 'x-mask-loading');
		}
		return win;
    },
    
    showChildWindow : function(item) {
		var me = this,
			desktop = me.getDesktop(),
			id = item.itemId;
		/**从桌面管理window的容器中取得指定ID的window框 */	
	    var win = desktop.getChildWindow(id);
		
		if (!win) {
			/** 计算窗口的大小，如果用户指定的大小超过屏幕的最大值，则使用屏幕最大值 */
			var xwidth = parseInt(item.xwidth) ||  800,
				yheight = parseInt(item.yheight) || 500;
			xwidth = xwidth > document.body.clientWidth ? document.body.clientWidth : xwidth;
			yheight = yheight > document.body.clientHeight ? document.body.clientHeight - 15 : yheight;
			
			/** 拷贝传过来的所有参数 */
			var def = Ext.apply({}, item || {});
			
			var cfg = {
				id : id
			};
			win = desktop.createChildWindow(Ext.apply(def, cfg), item.cls);
		}else{
			Ext.apply(win,item);
		}
		
		win.show();
		return win;
    },

    getDesktopConfig: function () {
        var me = this, ret = me.callParent();
        
        return Ext.apply(ret, {
            // cls: 'ux-desktop-black',

            contextMenuItems: [
                //{ text: rs.changesetting, handler: me.onSettings, scope: me }
            ],
            
            msgcuts : Ext.create('Ext.data.Store', {
                model: 'Ext.ux.desktop.ShortcutModel',
                data: [
                    {id: 'user', text: 'Administrator'}
                ]
            }),

            shortcuts: Ext.create('Ext.data.Store', {
                model: 'Ext.ux.desktop.ShortcutModel',
                proxy: {
			         type: 'ajax',
			         url: JN.calUrl('framework/homepage/queryShortcuts'),
			         reader: {
			             type: 'json',
			             root: 'shortcuts'
			         }
			     },
			     autoLoad: true,
			     listeners : {
			     	load : function(_this, records, successful, eOpts) {
			     		Ext.Array.each(records, function(record){
			     			if (record.get('itemId') == 'calendar') {
			     				me.getDesktop().setMenuAccessable(record.get('accessable'));
			     			}
			     		});
			     		me.getDesktop().initShortcut();
			     	}
			     }
            }),

            wallpaper: 'core/images/framework/wallpapers/desktop.jpg',
            wallpaperStretch: true
        });
    },

    onLogout: function () {
        Ext.Msg.confirm('注销', '您确认要注销吗?', function(btn) {
        	if (btn === 'yes') {
        		window.location.href = JN.calUrl('framework/logout');
        	}
        });
        
    },
    
    onShowDesktop : function() {
		var me = this;
		var desktop = me.desktop;
		var showDesktop = desktop.showDesktop;
		if (showDesktop) {
			desktop.showDesktop = false;
		} else {
			desktop.showDesktop = true;
		}
    	desktop.windows.each(function(win) {
            if (showDesktop) {
            	if (!win.minimized) {
            		win.manualmin = true;
            		desktop.minimizeWindow(win);
            	}
            } else {
            	if (win.manualmin) {
            		win.manualmin = false;
            		desktop.restoreWindow(win);
            	}
            }
    	});
    }
});

/*
 * Ext JS Library 4.0
 * Copyright(c) 2006-2011 Sencha Inc.
 * licensing@sencha.com
 * http://www.sencha.com/license
 */

/**
 * @class Ext.ux.desktop.Desktop
 * @extends Ext.panel.Panel
 * <p>This class manages the wallpaper, shortcuts and taskbar.</p>
 */
Ext.define('Ext.ux.desktop.Desktop', {
    extend: 'Ext.panel.Panel',
    
    alias: 'widget.desktop',

    uses: [
        'Ext.util.MixedCollection',
        'Ext.menu.Menu',
        'Ext.view.View', // dataview
        'Ext.window.Window',

        'Ext.ux.desktop.Wallpaper'
    ],

    activeWindowCls: 'ux-desktop-active-win',
    inactiveWindowCls: 'ux-desktop-inactive-win',
    lastActiveWindow: null,

    border: false,
    html: '&#160;',
    layout: 'fit',

    xTickSize: 1,
    yTickSize: 1,

    app: null,

    /**
     * @cfg {Array|Store} shortcuts
     * The items to add to the DataView. This can be a {@link Ext.data.Store Store} or a
     * simple array. Items should minimally provide the fields in the
     * {@link Ext.ux.desktop.ShorcutModel ShortcutModel}.
     */
    shortcuts: null,
    
    menuAccessable: false,

    /**
     * @cfg {String} shortcutItemSelector
     * This property is passed to the DataView for the desktop to select shortcut items.
     * If the {@link #shortcutTpl} is modified, this will probably need to be modified as
     * well.
     */
    shortcutItemSelector: 'div.ux-desktop-shortcut',

    /**
     * @cfg {String} shortcutTpl
     * This XTemplate is used to render items in the DataView. If this is changed, the
     * {@link shortcutItemSelect} will probably also need to changed.
     */
    shortcutTpl: [
        '<tpl for=".">',
        	'{%var disabled = values.accessable ? "" : "-disabled",' +
        	' 	   disabledCursor = values.accessable && values.cls ? "" : "ux-desktop-shortcut-cursor-disabled",' +
        	'	   isSingleDay = new Date().getDate() < 10 ? "-single" : "-double";%}',
            '<div title = "{tips}" class="ux-desktop-shortcut {deskicon}{[disabled]} {[disabledCursor]}"  id="{itemId}-shortcut">',
	                '<div class="ux-desktop-shortcut-icon">',
		            	'<tpl if="this.isReminder(itemId,accessable)">',
		                    '<div id="app-reminder" style="display: none;">',
					            '<div id="app-reminder-body">&#160;</div>',
					        '</div>',
		                '</tpl>',
		                '<tpl if="this.isTodolist(itemId,accessable)">',
		                    '<div id="app-todolist" style="display: none;">',
					            '<div id="app-todolist-body">&#160;</div>',
					        '</div>',
		                '</tpl>',
		                '<tpl if="this.isCalendar(itemId)">',
		                    '<div id="app-shortcut-calendar">',
					            '<div id="shortcut-calendar-body" class="shortcut-calendar-body-text{[isSingleDay]}{[disabled]}"></div>',
					        '</div>',
		                '</tpl>',
	                '</div>',
                '<span class="ux-desktop-shortcut-text">{text}</span>',
            '</div>',
        '</tpl>',
        '<div class="x-clear"></div>', {
        	isReminder: function(itemId, accessable){
        		return itemId == 'reminder' && accessable;
        	},
        	isCalendar: function(itemId) {
        		return itemId == 'calendar';
        	},
        	isTodolist: function(itemId, accessable) {
        		return itemId == 'todolist' && accessable;
        	}
        	
        }
    ],


    windowMenu: null,

    initComponent: function () {
        var me = this;

        me.windows = new Ext.util.MixedCollection();
        
        me.childWindows = new Ext.util.MixedCollection();

        me.items = [
//            { xtype: 'wallpaper', id: me.id+'_wallpaper' },
            me.createDataView()
        ];
        
        me.callParent();
    },
    
    //------------------------------------------------------
    // Overrideable configuration creation methods

    createDataView: function () {
        var me = this;
        return {
        	layout : 'border',
	        items : [{ 
	        	xtype: 'wallpaper', 
	        	id: me.id+'_wallpaper', 
	        	stretch : me.wallpaperStretch, 
	        	wallpaper : me.wallpaper
	        }, {
	        	region : 'north',
	        	xtype : 'dataview',
	        	height : 50,
	        	overItemCls: 'x-view-over',
	            trackOver: true,
	            itemSelector: 'div.ux-desktop-tools',
	            store: me.msgcuts,
	            style: {
	                position: 'absolute',
	                padding : 10
	            },
	            tpl: new Ext.XTemplate([
			        '<tpl for=".">',
			            '<div class="ux-desktop-tools" id="{id}-tools">',
			                '<div class="ux-desktop-tools-text">{text}</div>',
			            '</div>',
			        '</tpl>',
			        '<div class="x-clear"></div>'
			    ]),
			    listeners : {
			    	resize : me.initToolsItem,
			    	viewready : me.initToolsItem,
			    	itemmouseenter : me.onToolsItemClick,
	            	scope : me
			    }
	        }, {
	        	region : 'center',
	        	id : 'ux-desktop-view',
	            xtype: 'dataview',
	            overItemCls: 'x-view-over',
	            trackOver: true,
	            itemSelector: me.shortcutItemSelector,
	            store: me.shortcuts,
	            style: {
	                position: 'absolute'
	            },
	            tpl: new Ext.XTemplate(me.shortcutTpl),
	            listeners : {
	            	resize : me.initShortcut,
	            	itemclick : me.onShortcutItemClick,
	            	scope : me
	            }
	        }]
        };
    },

    //------------------------------------------------------
    // Event handler methods

    onToolsItemClick: function(_this, record, item, index, e, eOpts){
    	var me = this;
		var backColor = "#ffffff";
		var itemEl = Ext.fly(item);
		/** 取得当前文本的实际宽度 */
		var textW = itemEl.getTextWidth();
		var menuW = 180;
		var menuX = itemEl.getX() - (menuW - textW) / 2;
    	Ext.create('Ext.menu.Menu', {
    		width : menuW,
    		border: 0,
    		style: {
			    borderColor: backColor,
			    borderStyle: 'solid'
			},
    		bodyStyle: 'background:'+backColor,
    		plain:true,
			defaults: {
				activeCls: 'x-menuitem-active',
				plain: true,
				cls: 'x-menuitem-unchecked',
	            margin:'6 10 6 15'
			},
	        items : [{
	        	text : '功能菜单1'
	        }, {
	        	text : '功能菜单2'
	        }, {
            	cls:'x-menu-item-separator',
            	margin: '1 10 0 15'
	        }, {
                text : '注销',
                handler: me.onLogout,
                scope: me
            }]
		}).showAt(menuX, item.offsetHeight+5);
    },
	
	menuCheckedBeforeRender: function(_this){
		if (_this.checked) {
			_this.text = '<img src="core/images/components/checked.png" style="height:12px;width:12px;"/>&nbsp;&nbsp;' + _this.text;
		} else {
			_this.text = '&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;' + _this.text;
		}
	},
    onShortcutItemClick: function (dataView, record) {
    	if (!record.get('cls')) return;
    	if (!record.get('accessable')) return;
		var me = this;
		var wbody = Ext.getBody();
			wbody.mask('加载中', 'x-mask-loading');
		Ext.Function.defer(function(){
		    me.app.showWindow(record.data)
		}, 10);
    },
    
    initToolsItem : function() {
    	var bodyWidth = Ext.getBody().getWidth();
		var w = bodyWidth;
		var items = Ext.query(".ux-desktop-tools");
		
		for (var i = items.length - 1; i >= 0; i--) {
			var _el = Ext.fly(items[i]);
			/** 取得当前文本的实际宽度 */
			var _w = _el.getTextWidth() + 1;
			/**  */
			w = w - _w;
			
			/** 背景实际宽度 */
			var _backW = bodyWidth * 0.19;
			/** 让文本在背景中居中 */
			var marginR = (_backW - _w) / 2;
			/** 当文本比背景宽时，保证正常显示 */
			//if (marginR < 1) marginR = 1; 
			
			_el.setX(w - marginR);
		}
    },
       
    initShortcut : function() {
		var items = Ext.query(".ux-desktop-shortcut");
		var ic = items.length; //Item Count
		if (ic == 0) return;
		
    	var bw = Ext.getBody().getWidth();
    	var bh = Ext.getBody().getHeight();
    	
    	
    	var marginX = bw / 1300 * 5;
    	var marginY = bh / 130;
    	
    	
    	var cn = 6,//Column Number
    		rn = 4,//Row Number
    		rc = [6,6,4,3],
    		iw = 128,//Item Width
    		ih = 116,//Item Height
    		imt = marginY,//Item Top Margin
    		imr = marginX,//Item Right Margin
    		imb = marginY,//Item Bottom Margin
    		iml = marginX//Item Left Margin
    	;
    	
    	var w = iw + iml + imr
    		h = ih + imt + imb;
    	/** Until */
    	while (bw < w * cn && cn > 1) cn--;
		
    	/** Count Rows */
    	rn = parseInt((ic - 1) / cn) + 1;
		
		var bx = (bw - w * cn) / 2;
		var by = (bh - h * rn) / 2;
		if (by < 50) by = 50;
		
		var r = 0,
			c = 0,
			x, y;
		for (var i = 0; i < ic; i++) {
			if (c > 0 && c % rc[r] == 0) {
				r++;
				c = 0;
			}
			x = bx + c * w;
			y = by + r * h;
			Ext.fly(items[i]).setXY([x, y]);
			c++;
		}
		
		this.resizeWindow(bw, bh);
    },
    
    resizeWindow: function(width, height) {
    	var me = this;
    	me.windows.each(function(win) {
    		win.setHeight(height);
    		win.setWidth(width);
        });
    },

    onLogout: function(){
	    Ext.Msg.confirm('注销', '您确认要注销吗?', function(btn) {
	    	if (btn === 'yes') {
	    		window.location.href = JN.calUrl('framework/logout');
	    	}
		});
    },	

    //------------------------------------------------------
    // Dynamic (re)configuration methods

    getWallpaper: function () {
        return this.wallpaper.wallpaper;
    },

    setWallpaper: function (wallpaper, stretch) {
        this.wallpaper.setWallpaper(wallpaper, stretch);
        return this;
    },

    //------------------------------------------------------
    // Window management methods

    createWindow: function(config, cls) {
        var me = this, win, cfg = Ext.applyIf(config || {}, {
                stateful: false,
                isWindow: true,
                constrainHeader: false,
                minimizable: false,
                maximizable: false,
                draggable: false,
                closeAction: 'hide',
		    	closable: false,
		    	width: Ext.getBody().getWidth(),
		    	height: Ext.getBody().getHeight()
            });

        cls = cls || 'Ext.window.Window';
        win = me.add(Ext.create(cls, cfg));

        me.windows.add(win);

        win.on({
            boxready: function () {
                if (win.resizer) {
                    win.resizer.widthIncrement = me.xTickSize;
                    win.resizer.heightIncrement = me.yTickSize;
                }
            },
            single: true
        });
        
        win.on({
        	hide: function() {
        		
        	}
        });
        
        return win;
    },
    
    createChildWindow: function(config, cls) {
        var me = this, win, cfg = Ext.applyIf(config || {}, {
                isWindow: true,
                minimizable: false,
                maximizable: false,
                closeAction: 'hide'
            });
        cls = cls || 'Ext.window.Window';
        win = me.add(Ext.create(cls, cfg));

        me.childWindows.add(win);
		return win;
    },

    getDesktopZIndexManager: function () {
        var windows = this.windows;
        // TODO - there has to be a better way to get this...
        return (windows.getCount() && windows.getAt(0).zIndexManager) || null;
    },

    getWindow: function(id) {
        return this.windows.get(id);
    },
    
    getChildWindow: function(id) {
    	return this.childWindows.get(id);
    },

    minimizeWindow: function(win) {
        win.minimized = true;
        win.hide();
    },

    restoreWindow: function (win) {
        if (win.isVisible()) {
            win.restore();
            win.toFront();
        } else {
            win.show();
        }
        return win;
    },
    
    setMenuAccessable : function(menuAccessable) {
    	this.menuAccessable = menuAccessable;
    },
    getMenuAccessable : function() {
    	return this.menuAccessable;
    }
});

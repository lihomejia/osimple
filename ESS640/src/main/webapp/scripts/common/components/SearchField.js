Ext.define('Norming.components.SearchField',{
	extend: 'Ext.form.field.Picker',
	alias: 'widget.searchfield',
	width: 150,
//	fieldStyle:'height:28px;',
	searchPanel: undefined,
	trigger1Cls: Ext.baseCSSPrefix + 'form-clear-trigger',
    trigger2Cls: Ext.baseCSSPrefix + 'form-search-trigger',
    emptyText: "Search",
    enableKeyEvents: true,
    matchFieldWidth: false,
    pickerAlign: 'tr-br?',
	initComponent: function(){
		var me = this;
		me.callParent();
	},
	onTrigger1Click : function(){
        var me = this;
        me.triggerCell.item(0).setDisplayed(false);
        me.setValue('');
        me.updateLayout();
    },
	createPicker: function() {
		var me = this;
		return me.searchPanel;
	},
	afterRender: function(){
        var me = this;
        me.callParent();
		me.triggerCell.item(0).setDisplayed(false);
    },
    collapseIf: function(e) {
        var me = this;

        if (!me.isDestroyed && !e.within(me.bodyEl, false, true) && !e.within(me.picker.el, false, true) && !me.isEventWithinPickerLoadMask(e)) {
        	if(me.searchPanel){
       			var isInPicker = false;
        		me.searchPanel.items.each(function(item){
        			if(item.picker && e.within(item.picker.el,false,true)){
						isInPicker = true;
        			}
        			if(item.items){
	        			item.items.each(function(item){
		        			if(item.picker && e.within(item.picker.el,false,true)){
								isInPicker = true;
		        			}
	        			});
        			}
				});
				if(!isInPicker){
	  				me.collapse();
				}
        	}
        }
    },
    mimicBlur: function(e){
		var me = this,
            picker = me.picker;
        if (e.within(me.inputEl, false, true)) {
        	me.collapse();
        }
    },
	listeners: {
    	change: function(a) {
            a.triggerCell.item(0).setDisplayed(!(a.getValue().length === 0));
        }
    }
});
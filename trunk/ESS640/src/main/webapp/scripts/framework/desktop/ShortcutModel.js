/**
 * @class Ext.ux.desktop.ShortcutModel
 * @extends Ext.data.Model
 * This model defines the minimal set of fields for desktop shortcuts.
 */
Ext.define('Ext.ux.desktop.ShortcutModel', {
    extend: 'Ext.data.Model',
    fields: [
       { name: 'itemId' },
       { name: 'text' },
       { name: 'iconCls' },
       { name: 'deskicon' },
       { name: 'cls' },
       { name: 'xwidth' },
       { name: 'yheight' },
       { name: 'resizable' },
       { name: 'maximizable' },
       { name: 'accessable'},
       { name: 'tips'}
    ]
});

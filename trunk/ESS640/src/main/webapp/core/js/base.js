JN = {
	basePath : function() {
		var bases = document.getElementsByTagName('BASE');
		return bases.length == 0 ? '' : bases[0].href;
	}(),	
		
	calUrl : function(url) {
		if (!this.basePath) return url;
		return this.basePath + url;
	}	
}
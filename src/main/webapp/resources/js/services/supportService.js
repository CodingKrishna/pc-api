app.service("supportService",function($q,$http,$log){
	var self=this;
	self.saveSupport=saveSupport;
	self.getSupportsList=getSupportsList;
	function saveSupport(support){
		var defer=$q.defer();
		var config={
				url:"user/addsupport",
				method:"POST",
				data:support
		};
		$http(config).then(function(res){
			defer.resolve(res.data);
		},function(error){
			defer.reject(error);
		});
		return defer.promise;
 	}
	
	function getSupportsList(){
		var defer=$q.defer();
		$http.get('user/supportslist').then(function(res){
			if(!res.isSuccess){
				defer.resolve(res.data.response);
			}else{
				defer.reject(res.data);
			}
		},function(error){
			defer.reject(error);
		});
		return defer.promise;
	}
	
});
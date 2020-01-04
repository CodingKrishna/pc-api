angular.module("pcModule").service("referralService",function($q,$http,$log){
	var self=this;
	self.saveReferInfo=saveReferInfo;
	
	function saveReferInfo(Obj){
		var defer=$q.defer();
		var config={
				url:"user/addreferrals",
				method: "POST",
				data:Obj
		};
		$http(config).then(function(res){
			defer.resolve(res.data);
		},function(error){
			defer.reject(error);
		});
		return defer.promise;
	}
});
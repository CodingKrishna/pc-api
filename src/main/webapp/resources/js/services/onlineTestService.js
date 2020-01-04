angular.module("pcModule").service("onlineTestService",function($q,$http,$log){
	var self=this;
	self.getPaperByTech=getPaperByTech;
	
	function getPaperByTech(Obj){
		var defer=$q.defer();
		var config={
				url:"exam/examquestions?userId="+Obj,
				method: "GET",
		};
		$http(config).then(function(res){
			defer.resolve(res.data);
		},function(error){
			defer.reject(error);
		});
		return defer.promise;
	}
	
});
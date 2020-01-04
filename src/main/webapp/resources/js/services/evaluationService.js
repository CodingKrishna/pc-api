angular.module("pcModule").service("evaluationService",function($q,$http,$log){
	var self=this;
	self.saveEvalutionInfo=saveEvalutionInfo;
	
	function saveEvalutionInfo(totalObj){
		var defer=$q.defer();
		var config={
				url:"user/addevaluation",
				method: "POST",
				data:totalObj
		};
		$http(config).then(function(res){
			defer.resolve(res.data);
		},function(error){
			defer.reject(error);
		});
		return defer.promise;
	}
});
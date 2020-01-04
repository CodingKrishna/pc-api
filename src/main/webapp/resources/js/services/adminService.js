angular.module("pcModule").service("adminService",function($q,$http,$log){
	var self=this;
	self.submitCodingTestQtn = submitCodingTestQtn;
	self.getAllCodingTestQstns = getAllCodingTestQstns;
	self.getUsersByFeedBackGoodOrExcellent = getUsersByFeedBackGoodOrExcellent;
	
	function submitCodingTestQtn(obj){
		var defer=$q.defer();
		var config={
				url:"codingtest/createquestion",
				method: "POST",
				data:obj
		};
		$http(config).then(function(res){
			defer.resolve(res.data);
		},function(error){
			defer.reject(error);
		});
		return defer.promise;
	}
	function getAllCodingTestQstns(){
		var defer=$q.defer();
		var config={
				url:"codingtest/questionslist",
				method: "POST",
				data:obj
		};
		$http(config).then(function(res){
			defer.resolve(res.data);
		},function(error){
			defer.reject(error);
		});
		return defer.promise;
	}
	
	function getUsersByFeedBackGoodOrExcellent(){
		var defer=$q.defer();
		var config={
				url:"feedback/usersbyfeedback",
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
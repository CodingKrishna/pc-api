angular.module("pcModule").service("instructorService",function($q,$http,$log){
	var self=this;
	self.saveInstructorInfo=saveInstructorInfo;
	self.getInstructorsList=getInstructorsList;
	function saveInstructorInfo(instructor){
		var defer=$q.defer();
		var config={
				url:"instructor/add",
				method: "POST",
				data:instructor
		};
		$http(config).then(function(res){
			defer.resolve(res.data);
		},function(error){
			defer.reject(error);
		});
		return defer.promise;
	}
	
	function getInstructorsList(){
		var defer=$q.defer();
		$http.get('instructor/list').then(function(res){
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

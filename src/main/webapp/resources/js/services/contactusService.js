angular.module("pcModule").service("contactusService",function($q,$http,$log){
	var self=this;
	self.saveContactUs=saveContactUs;
	self.getcontactUsList=getcontactUsList;
	function saveContactUs(contactus){
		var defer=$q.defer();
		var config={
				url:"contactus/add",
				method: "POST",
				data:contactus
		};
		$http(config).then(function(res){
			defer.resolve(res.data);
		},function(error){
			defer.reject(error);
		});
		return defer.promise;
	}
	
	function getcontactUsList(){
		var defer=$q.defer();
		$http.get('contactus/list').then(function(res){
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

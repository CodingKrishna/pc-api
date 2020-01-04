angular.module("pcModule").service('hrCommonService',function($http,$log,$q){
	var self = this;
	self.hrRegistration = hrRegistration;
	self.doLogin = doLogin;
	self.getLogHrInfo = getLogHrInfo;
	self.setLogHrInfo = setLogHrInfo;
	self.purchasePlan = purchasePlan;
	self.getPlanDetails = getPlanDetails;
	
	function hrRegistration(hrInfoObj) {
		var defer = $q.defer();
		$http.post('user/add',hrInfoObj).then(function(res){
			if(res.data.isSuccess) {
				defer.resolve({res:res.data.response});
			} else {
				defer.reject ({res:res.data.response});
			}
		}); 
		return defer.promise;
	};
	
	function doLogin(obj) {
    	var defer = $q.defer();
    	var config={
			url:"auth/verify",
			method: "POST",
			data:obj
		};
    	$http(config).then(function(res) {
    		if (res.data.isSuccess) {
    			defer.resolve(res.data.response);
    		} else {
    			defer.reject(res.data);
    		}
    	}, function(error) {
    		defer.reject(error);
    	});
    	return defer.promise;
    }
	
	function getLogHrInfo(userType){
		var defer = $q.defer();
		if(typeof(Storage) !== "undefined") {
	        if (JSON.parse(sessionStorage.getItem(userType))) {
	            defer.resolve(JSON.parse(sessionStorage.getItem(userType)));
	        } else {
	        	defer.reject("error");
	        }
		}else{
			defer.reject("error");
		}
		return defer.promise;
	}
	
	function setLogHrInfo(userType,user){
		var defer = $q.defer();
		if(typeof(Storage) !== "undefined") {
			sessionStorage.setItem(userType,JSON.stringify(user));
			defer.resolve(JSON.parse(sessionStorage.getItem(userType)));
		}else{
			defer.reject("error");
		}
		return defer.promise;
	}
	function getPlanDetails() {
    	var defer = $q.defer();
    	var config={
			url:"user/getpricingplans",
			method: "GET",
		};
    	$http(config).then(function(res) {
    		if (res.data.isSuccess) {
    			defer.resolve(res.data.response);
    		} else {
    			defer.reject(res.data);
    		}
    	}, function(error) {
    		defer.reject(error);
    	});
    	return defer.promise;
    }
	
	function purchasePlan(obj) {
    	var defer = $q.defer();
    	var config={
			url:"user/addpricingtrnplan",
			method: "POST",
			data:obj
		};
    	$http(config).then(function(res) {
    		if (res.data.isSuccess) {
    			defer.resolve(res.data.response);
    		} else {
    			defer.reject(res.data);
    		}
    	}, function(error) {
    		defer.reject(error);
    	});
    	return defer.promise;
    }
});
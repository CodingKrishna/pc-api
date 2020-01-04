angular.module("pcModule").service("commonService",function($q, $http, $log){
	
	var self = this;
	self.getTemplate = getTemplate;
	self.getCaseSheetTemplate=getCaseSheetTemplate;
	self.getInternTaskTemplate=getInternTaskTemplate;
	self.getLogUserInfo = getLogUserInfo;
	self.setLogUserInfo = setLogUserInfo;
	self.doLogin = doLogin;
	self.getUserCompleteData = getUserCompleteData;
	self.uploadTaskFile = uploadTaskFile;
	self.uploadCaseStudiesFile = uploadCaseStudiesFile;
	
	function getUserCompleteData(userId) {
		var defer = $q.defer();
		$http.get('user/completedata?userId=' + userId).then(function(res) {
			if(res.data.isSuccess) {
				defer.resolve(res.data.response);
			}else {
				defer.reject(res.data);
			}
		}, function(error) {
			$log.error("Error occured while fetching user complete data with ID: " + userId, error);
			defer.reject(error);
		});
		return defer.promise;
	}

	function getTemplate(obj,fileType) {
    	var defer = $q.defer();
    	var config={
    			url:"tutorials/gettemplate/"+_GET_URL(obj,fileType),
    			method: "GET",
    		    headers: {
    		        "Content-Type": "text/plain",
    		        "Accept": "text/plain"
    		    }
    		};
    	$http(config).then(function(res) {
    		defer.resolve(res.data);
    	}, function(error) {
    		defer.reject(error);
    	});
    	return defer.promise;
    }
	
	function getCaseSheetTemplate(language){
		var defer = $q.defer();
		var config={
			url:"casestudy/template/"+language,
			method: "GET",
		    headers: {
		        "Content-Type": "text/plain",
		        "Accept": "text/plain"
		    }
		};
		
		$http(config).then(function(res) {
    		defer.resolve(res.data);
    	}, function(error) {
    		defer.reject(error);
    	});
		
		return defer.promise;
		
	};
	
	function getInternTaskTemplate(language){
		var defer=$q.defer();
		var config={
			url:"interntask/template/"+language,
			method:"GET",
			headers:{
				"Content-Type":"text/plain",
				"Accept":"text/plain"
			}
		};
		$http(config).then(function(res){
			defer.resolve(res.data);
		},function(error){
			defer.reject(error);
		});
		return defer.promise;
	};
	
	
	function doLogin(obj) {
    	var defer = $q.defer();
    	var config={
			url:"login/user",
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
	
	function getLogUserInfo(userType){
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
	
	function setLogUserInfo(userType,user){
		var defer = $q.defer();
		if(typeof(Storage) !== "undefined") {
			sessionStorage.setItem(userType,JSON.stringify(user));
			defer.resolve(JSON.parse(sessionStorage.getItem(userType)));
		}else{
			defer.reject("error");
		}
		return defer.promise;
	}
	
	function uploadTaskFile(file, name, folderName) {
		var defer = $q.defer();
		
		var fd = new FormData();
		fd.append('file', file);
		fd.append('name', name);
		fd.append('folderName', folderName);
		/*console.log(fd);*/
		$http.post("interntask/uploadtask", fd, {
			transformRequest: angular.identity,
			headers: {'Content-Type': undefined}
		}).then(function(res) {
			/*console.info(res.data);*/
			if(res.data.isSuccess) {
				defer.resolve(res.data.response);
			} else {
				defer.reject(res.data);
			}
		}, function(error) {
			/*console.error(error);*/
			defer.reject(error);
		});
		return defer.promise;
	}
	
	function uploadCaseStudiesFile(file, name, folderName) {
		var defer = $q.defer();
		
		var fd = new FormData();
		fd.append('file', file);
		fd.append('name', name);
		fd.append('folderName', folderName);
		/*console.log(fd);*/
		$http.post("campus/uploadtask", fd, {
			transformRequest: angular.identity,
			headers: {'Content-Type': undefined}
		}).then(function(res) {
			/*console.info(res.data);*/
			if(res.data.isSuccess) {
				defer.resolve(res.data.response);
			} else {
				defer.reject(res.data);
			}
		}, function(error) {
			/*console.error(error);*/
			defer.reject(error);
		});
		return defer.promise;
	}
	
	
});
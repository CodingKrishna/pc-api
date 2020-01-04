angular.module("pcModule").service("profileService",function($q, $http, $log){
	var self=this;
	
	self.updateUser = updateUser;
	self.saveEducationInfo = saveEducationInfo;
	self.saveProjectInfo = saveProjectInfo;
	self.saveskillsetInfo = saveskillsetInfo;
	self.getUserCompleteData = getUserCompleteData;
	self.updateTotalExp = updateTotalExp;
	
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
	
	
	function updateUser(user){
		var defer=$q.defer();
		$http.post('user/updateuser', user).then(function(res){
			if(res.data.isSuccess) {
				defer.resolve(res.data.response);
			} else {
				defer.reject(res.data);
			}
		},function(error){ 
			defer.reject(error);
		});
		return defer.promise;
	}
	
	function saveEducationInfo(educationObj) {
		var defer = $q.defer();
		
		var url = (educationObj.id) ? 'user/updateeducation' : 'user/addeducation';
		$http.post(url, educationObj).then(function(res) {
			if(res.data.isSuccess) {
				defer.resolve(res.data.response);
			} else {
				defer.reject(res.data);
			}
		},function(error){
			defer.reject(error);
		});
		
		return defer.promise;
	}
	function saveProjectInfo(projectObj) {
		var defer = $q.defer();
		var url = (projectObj.id) ? 'user/updateproject' : 'user/addproject';
		$http.post(url, projectObj).then(function(res) {
			if(res.data.isSuccess) {
				defer.resolve(res.data.response);
			} else {
				defer.reject(res.data);
			}
		},function(error){
			defer.reject(error);
		});
		return defer.promise;
	}
	
	function saveskillsetInfo(skillsetObj){
		var defer=$q.defer();
		var url = (skillsetObj.id) ? 'user/updateskillset':'user/addskillset';
		$http.post(url,skillsetObj).then(function(res){
			if(res.data.isSuccess) {
				defer.resolve(res.data.response);
			} else {
				defer.reject(res.data);
			}
		},function(error){
			defer.reject(error);
		});
		return defer.promise;
	}
	
	function updateTotalExp(req){
		var defer=$q.defer();
		var url = (req.id) ? 'user/updateexperianceinfo':'user/addexperianceinfo';
		$http.post(url,req).then(function(res){
			if(res.data.isSuccess) {
				defer.resolve(res.data.response);
			} else {
				defer.reject(res.data);
			}
		},function(error){
			defer.reject(error);
		});
		return defer.promise;
	}
});

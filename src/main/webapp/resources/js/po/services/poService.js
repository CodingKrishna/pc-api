app.service('poService',function($q,$http){
	var self = this;
	self.getCandidatesProfiles = getCandidatesProfiles;
	
	function getCandidatesProfiles() {
		var defer = $q.defer();
		$http.get('user/userlistbyvisibility').then(function(res){
			if(res.data.isSuccess) {
				defer.resolve({res:res.data.response});
			} else {
				defer.reject({res:res.data.response});
			}
		});
		return defer.promise;
	};
});
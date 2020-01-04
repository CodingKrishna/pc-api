app.service('studentDetailsService',function($q,$http){
	var self = this;
	self.sendEmail = sendEmail;
	self.sendSms = sendSms;

	function sendEmail(obj) {
		var defer = $q.defer();
		$http.post('user/sendmail',obj).then(function(res){
			if(res.data.isSuccess) {
				defer.resolve({res:res.data.response});
			} else {
				defer.reject({res:res.data.response});
			}
			
		});
		return defer.promise;
	}
	function sendSms(obj) {
		var defer = $q.defer();
		$http.post('user/sendsms',obj).then(function(res){
			if(res.data.isSuccess) {
				defer.resolve({res:res.data.response});
			} else {
				defer.reject({res:res.data.response});
			}
			
		});
		return defer.promise;
	}
});
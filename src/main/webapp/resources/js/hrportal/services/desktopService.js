angular.module("pcModule").service('desktopService',function($q,$http){
	var self = this;
	self.postAJob = postAJob;
	self.getJobsListByHrId = getJobsListByHrId;
	self.saveCompanyInfo =  saveCompanyInfo;
	self.saveTestInfo =  saveTestInfo;
	self.getAllTests = getAllTests;
	self.getQuestionsForUsers = getQuestionsForUsers;
	self.getAllCompaniesList = getAllCompaniesList;
	self.getAllTestList = getAllTestList;
	self.getQuestions = getQuestions;
	self.assigningQuestions = assigningQuestions;
	self.getTechnologiesList = getTechnologiesList;
	self.getRoundsList = getRoundsList;
	self.shortListCandidate = shortListCandidate;
	self.viewShortListedCandidates = viewShortListedCandidates;
	self.getstudentsDataByIds = getstudentsDataByIds;
	self.getPurchasedPlanDetailsByHrId = getPurchasedPlanDetailsByHrId;
	self.uploadLogo = uploadLogo;
	function postAJob(jobObj) {
		var defer = $q.defer();
		$http.post('job/createjob',jobObj).then(function(res){
		if(res.data.isSuccess){
			defer.resolve({res:res.data.response});
		}else {
			defer.reject({res:res.data.response});
		}
	}),function(error){
		console.log(error);	
		};
		return defer.promise;
	}
	
	function getJobsListByHrId(hrId) {
		var defer = $q.defer();
		$http.get('job/getjobs?hrId='+hrId).then(function(res){
		if(res.data.isSuccess){
			defer.resolve(res.data.response);
		}else {
			defer.reject(res.data.response);
		}
	}),function(error){
		console.log(error);	
		};
		return defer.promise;
	}
	
	function saveCompanyInfo(company) {
		var defer = $q.defer();
		$http.post('job/createcompany',company).then(function(res){
		if(res.data.isSuccess){
			defer.resolve(res.data.response);
		}else {
			defer.reject(res.data.response);
		}
	}),function(error){
		console.log(error);	
		};
		return defer.promise;
	}

	function getAllCompaniesList() {
		var defer = $q.defer();
		$http.get('job/getcompanies').then(function(res){
		if(res.data.isSuccess){
			defer.resolve({res:res.data.response});
		}else {
			defer.reject({res:res.data.response});
		}
	}),function(error){
		console.log(error);	
		};
		return defer.promise;
	}
	

	function  getCandidatesProfiles() {
		var defer = $q.defer();
		$http.get('job/getcompanies').then(function(res){
		if(res.data.isSuccess){
			defer.resolve({res:res.data.response});
		}else {
			defer.reject({res:res.data.response});
		}
	}),function(error){
		console.log(error);	
		};
		return defer.promise;
	}
	function shortListCandidate(obj) {
		var defer = $q.defer();
		$http.post('job/createjobtrn',obj).then(function(res){
			if(res.data.isSuccess){
			defer.resolve({res:res.data.response});
		}else {
			defer.reject({res:res.data.response});
		}
	}),function(error){
		console.log(error);	
		};
	return defer.promise;
		
	}

	function 	viewShortListedCandidates(jobId) {
		var defer = $q.defer();
		$http.get('job/getstudentsbyjobid?jobId='+jobId).then(function(res){
			if(res.data.isSuccess){
			defer.resolve(res.data.response);
		}else {
			defer.reject(res.data.response);
		}
	}),function(error){
		console.log(error);	
		};
	return defer.promise;
		
	}
	function 	getstudentsDataByIds(idsList) {
		var defer = $q.defer();
		$http.post('user/userslistbyuserids',idsList).then(function(res){
			if(res.data.isSuccess){
			defer.resolve(res.data.response);
		}else {
			defer.reject(res.data.response);
		}
			
	}),function(error){
		console.log(error);	
		};
	return defer.promise;
		
	}
	function getPurchasedPlanDetailsByHrId(hrId) {
		var defer = $q.defer();
		$http.get('user/getpricingplansbyhrid?hrId='+hrId).then(function(res){
			if(res.data.isSuccess){
			defer.resolve(res.data.response);
		}else {
			defer.reject(res.data.response);
		}
	}),function(error){
		console.log(error);	
		};
	return defer.promise;
		
	}
	
	function uploadLogo(file, name) {
		var defer = $q.defer();
		var fd = new FormData();
		fd.append('file', file);
		fd.append('name', name);
		/*console.log(fd);*/
		$http.post("job/uploadcompanyimg", fd, {
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
	
	
	function saveTestInfo(test) {
		var defer = $q.defer();
		$http.post('test/createtest',test).then(function(res){
		if(res.data.isSuccess){
			defer.resolve(res.data.response);
		}else {
			defer.reject(res.data.response);
		}
	}),function(error){
		console.log(error);	
		};
		return defer.promise;
	}
	
	function getAllTestList(id) {
		var defer = $q.defer();
		$http.get('test/gettestlist?userId=' + id).then(function(res){
		if(res.data.isSuccess){
			defer.resolve({res:res.data.response});
		}else {
			defer.reject({res:res.data.response});
		}
	}),function(error){
		console.log(error);	
		};
		return defer.promise;
	}
	
	function getTechnologiesList() {
		var defer = $q.defer();
		$http.get('user/technologieslist').then(function(res){
		if(res.data.isSuccess){
			defer.resolve({res:res.data.response});
		}else {
			defer.reject({res:res.data.response});
		}
	}),function(error){
		console.log(error);	
		};
		return defer.promise;
	}
	
	function getRoundsList() {
		var defer = $q.defer();
		$http.get('test/getrounds').then(function(res){
		if(res.data.isSuccess){
			defer.resolve({res:res.data.response});
		}else {
			defer.reject({res:res.data.response});
		}
	}),function(error){
		console.log(error);	
		};
		return defer.promise;
	}
	
	function getQuestions(req) {
		var defer = $q.defer();
		$http.post('test/getquestionsbytechandrounds',req).then(function(res){
		if(res.data.isSuccess){
			defer.resolve({res:res.data.response});
		}else {
			defer.reject({res:res.data.response});
		}
	}),function(error){
		console.log(error);	
		};
		return defer.promise;
	}
	
	function assigningQuestions(testRoundQuestions){
		var defer = $q.defer();
		$http.post('test/saveQuestions',testRoundQuestions).then(function(res) {
			defer.resolve(res);
		}, function(error) {
			defer.reject(error);
		});
		return defer.promise;
	}
	
	function getAllTests(userId) {
		var defer = $q.defer();
		$http.get('test/getalltests?userId='+userId).then(function(res){
		if(res.data.isSuccess){
			defer.resolve({res:res.data.response});
		}else {
			defer.reject({res:res.data.response});
		}
	}),function(error){
		console.log(error);	
		};
		return defer.promise;
	}
	
	function getQuestionsForUsers(testId,round){
		var defer = $q.defer();
		$http.post('test/getquestionsforusers?testId='+testId+'&round='+round).then(function(res) {
			defer.resolve(res);
		}, function(error) {
			defer.reject(error);
		});
		return defer.promise;
	}
	
});

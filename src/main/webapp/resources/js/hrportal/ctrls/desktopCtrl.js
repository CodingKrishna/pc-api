app.controller('desktopCtrl',function($scope,$timeout,desktopService,commonService,$rootScope){
	$scope.init = function(){
		var curDate = new Date();
		$scope.form = {};
		$scope.company = {};
		$scope.job = {postedDate:curDate,closedDate:curDate};
		$scope.job.company = {};
		$scope.job.user = {};
		$scope.checkLogin();
		$scope.getAllCompaniesList();
		$scope.getJobsListByHrId();
	};
	// slides to login form  from registration form
	$scope.slideToJobs  = function() {
		$scope.showCandidates = 'slide-page-right';
	};
	
	// slides to registration  from login form
	$scope.slideToShortListedCandidates= function() {
		$scope.showCandidates = 'slide-page-left';
	};
	$scope.checkLogin=function(){
		commonService.getLogUserInfo('userInfo').then(function(res){
			$scope.loggedInUser = res;
		},function(err){
			$scope.loggedInUser = null;
			$scope.changeState('home');
		});
	};
	$scope.postAJob =function(){
		$scope.job.user.id = $scope.loggedInUser.id;
		desktopService.postAJob($scope.job).then(function(res){
			if(res) {
				$scope.job = {};
				$scope.job.user = {};
				$scope.job.company = {};
				$scope.jobsList.push(res.res);
				$scope.jobSucMsg = "Job Posted Successfully";
				$scope.disableButton = true;
				$timeout(function(){
					$scope.jobSucMsg = undefined;
					$scope.disableButton = false;
					$scope.toggleBoolean('showPopup');
				},3000);
			}else{
				$scope.jobSucMsg = "Job is not Posted";
			}
		});
	};
	
	/*$rootScope.$on('postJob',function(event){
		$scope.postAJob();
	});*/
	
	$scope.getJobsListByHrId =function(){
		$scope.list = true;
		desktopService.getJobsListByHrId($scope.loggedInUser.id).then(function(res){
			if(res) {
				$scope.jobsList = res;
			}else{
				$scope.msg = "Jobs list is not available";
			}
		});
	};
	
	$scope.getAllCompaniesList =function(){
		desktopService.getAllCompaniesList().then(function(res){
			if(res) {
				$scope.companiesList = res.res;
				
			}else{
				$scope.msg = "Companies List is not available";
			}
		});
	};
	
	// toggle function to toggle the views
	$scope.toggleBoolean = function(prop) {
		$scope[prop]= !$scope[prop];
	};
	$scope.viewShortListedCandidates = function(job) {
		
		desktopService.viewShortListedCandidates(job.id).then(function(res){
			if(res) {
				$scope.shortListedCandidates = res;
				console.log($scope.shortListedCandidates);
				var studentsIdsList = [];
				for(var i=0;i<$scope.shortListedCandidates.length;i++) {
					studentsIdsList.push($scope.shortListedCandidates[i].studentId);
				}
				$scope.getstudentsDataByIds(studentsIdsList);
				$scope.slideToShortListedCandidates();
			}
		});
	};
	
	$scope.getstudentsDataByIds = function(studentsIdsList){
		desktopService.getstudentsDataByIds(studentsIdsList).then(function(res){
			if(res) {
				$scope.studentsListByJobId = res;
			}
		});
	}
	$scope.init();
});
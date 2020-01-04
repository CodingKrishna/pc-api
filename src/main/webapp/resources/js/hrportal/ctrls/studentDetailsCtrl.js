app.controller('studentDetailsCtrl',function($scope,studentDetailsService,$rootScope,desktopService,commonService){
	$scope.init = function(){
		$scope.studentInfo = {};
		$scope.student = {};
		$scope.form = {};
		$scope.coursesBgColors =["bg-color-1","bg-color-2","bg-color-3","bg-color-4"];
		$scope.candidateProfile = JSON.parse(sessionStorage.getItem('profile'));
		if($scope.candidateProfile.userBasicInfo){
			if($scope.candidateProfile.userBasicInfo.languages) {
				$scope.candidateProfile.userBasicInfo.languages = JSON.parse($scope.candidateProfile.userBasicInfo.languages);
			}
			$scope.userAge = new Date().getFullYear()-new Date($scope.candidateProfile.userBasicInfo.dob).getFullYear();
		}
		if($scope.candidateProfile.work) {
			for(var i=0;i<$scope.candidateProfile.work.workExp.length;i++) {
				if($scope.candidateProfile.work.workExp[i].employerstatus == 'Current Employer') {
					$scope.currentEmployer = $scope.candidateProfile.work.workExp[i];
				}
			}
		}
		$scope.studentInfo.name = angular.copy($scope.candidateProfile.user.userName);
		$scope.studentInfo.emailId = angular.copy($scope.candidateProfile.user.emailId);
		$scope.student.name = angular.copy($scope.candidateProfile.user.userName);
		$scope.student.mobileNo = angular.copy($scope.candidateProfile.user.mobileNo);
		$scope.checkLogin();
	};
	$scope.checkLogin=function(){
		commonService.getLogUserInfo('userInfo').then(function(res){
			$scope.loggedInUser = res;
		},function(err){
			$scope.loggedInUser = null;
			$scope.changeState('home');
		});
	};
	$scope.sendEmail = function() {
		studentDetailsService.sendEmail($scope.studentInfo).then(function(res){
			if(res) {
				$scope.mailSuccessMsg = "Mail Sent Successfully";
				$scope.studentInfo = {};
				$scope.form.emailForm.$setPristine();
			}
		});
	};
	
	$scope.sendSms = function() {
		studentDetailsService.sendSms($scope.student).then(function(res){
			if(res) {
				$scope.smsSuccessMsg = "SMS Sent Successfully";
				$scope.student ={};
				$scope.form.smsForm.$setPristine();
			}
		});
	};
	$scope.shortList = function() {
		$scope.getJobsListByHrId();
		$scope.toggleBoolean('showPopup');
	};
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
	$scope.shortListCandidate = function(job) {
		desktopService.viewShortListedCandidates(job.id).then(function(res){
			if(res){
				var studentsList = res;
				if(studentsList.length) {
					for(var i=0;i<studentsList.length;i++) {
						if(studentsList[i].studentId == $scope.candidateProfile.user.id) {
							return alert("You have already shortlisted this candidate for job "+ job.jobTitle);
						}
					};
					var shortListedObj = {};
					shortListedObj.job = {};
					shortListedObj.job.id = job.id;
					shortListedObj.studentId = $scope.candidateProfile.user.id;
					desktopService.shortListCandidate(shortListedObj).then(function(res){
						if(res) {
							
							$scope.toggleBoolean('showPopup'); 
						}
					});
				} else {
					var shortListedObj = {};
					shortListedObj.job = {};
					shortListedObj.job.id = job.id;
					shortListedObj.studentId = $scope.candidateProfile.user.id;
					desktopService.shortListCandidate(shortListedObj).then(function(res){
						if(res) {
							
							$scope.toggleBoolean('showPopup'); 
						}
					});
				}
			}
			
		});
	
		};
	// toggle function to toggle the views
	$scope.toggleBoolean = function(prop) {
		$scope[prop]= !$scope[prop];
	};
	$scope.init();
});
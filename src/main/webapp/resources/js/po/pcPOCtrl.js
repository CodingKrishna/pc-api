var app=angular.module("pcModule");
app.controller("pcPOCtrl",function($scope,$http,$location,hrCommonService,md5,$timeout,$state,desktopService,poService,$rootScope){
	
	$scope.init = function () {
		$scope.form = {};
		$scope.list = false;
		$scope.job = {};
		$scope.jobsList =[];
		$scope.getCandidatesProfiles();
	};
	// checks weather user is logged in or not
	$scope.checkLogin=function(){
		commonService.getLogUserInfo('userInfo').then(function(res){
			$scope.loggedInUser = res;
		},function(err){
			$scope.loggedInUser = null;
			$scope.changeState('home');
		});
	};
	$scope.candidatesProfilesList = [];
	$scope.getCandidatesProfiles = function() {
		poService.getCandidatesProfiles().then(function(res){
			if(res) {
				$scope.candidatesProfilesList = res.res;
				for(var i=0;i<$scope.candidatesProfilesList.length;i++) {
					if($scope.candidatesProfilesList[i].education!=null){
						$scope.candidatesProfilesList[i].education.educationInfo = res.res[i].education.educationInfo;
					}
					if($scope.candidatesProfilesList[i].project!=null) {
						$scope.candidatesProfilesList[i].project.projectInfo = res.res[i].project.projectInfo;
					}
					if($scope.candidatesProfilesList[i].social!=null) {
						$scope.candidatesProfilesList[i].social.socialInfo = res.res[i].social.socialInfo;
					}
					if($scope.candidatesProfilesList[i].work!=null) {
						$scope.candidatesProfilesList[i].work.workExp = res.res[i].work.workExp;
					}
					if($scope.candidatesProfilesList[i].skillset !=null) {
						$scope.candidatesProfilesList[i].skillset.skills = res.res[i].skillset.skills;
					}
					if($scope.candidatesProfilesList[i].user.address!=null) {
						$scope.candidatesProfilesList[i].user.address = res.res[i].user.address;
					}
				}
			}
		});
	};
	$scope.changeState = function(stateRef, params) {
		$state.go(stateRef, params);
	};
	// toggle function to toggle the views
	$scope.toggleBoolean = function(prop) {
		$scope[prop]= !$scope[prop];
	};
	
	$scope.navToRegistration = function() {
		$rootScope.$broadcast('doLogin');
	};
	$scope.init();  
});

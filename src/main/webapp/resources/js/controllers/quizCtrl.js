var app = angular.module('pcModule');
app.controller('quizCtrl',function($scope,$http,$timeout,$stateParams,commonService,userService){
	$scope.init = function() {
		$scope.colors =["color-1","color-2","color-3","color-4"];
		$scope.getLogUserInfo();
	};
	$scope.getLogUserInfo=function(){
		commonService.getLogUserInfo('userInfo').then(function(res){
			$scope.loggedInUser = res;
			$scope.getQuizResultsByUserId();
			$scope.getOnlineExamResultsByUserId();
		},function(err){
			$scope.changeState('home');
		});
	};
	
	$scope.getOnlineExamResultsByUserId = function() {
		userService.getOnlineExamResultsByUserId($scope.loggedInUser.id).then(function(res){
		if(res.isSuccess) {
			$scope.onlineExaResultList = res.response;
			}
		});
	};
	
	$scope.getQuizResultsByUserId = function() {
		userService.getQuizResultsByUserId($scope.loggedInUser.id).then(function(res){
		if(res.isSuccess) {
			$scope.quizResultList = res.response;
			}
		});
	};
	
	$scope.init();
});
var app = angular.module('pcModule');
app.controller('referralCtrl',function($scope,referralService,commonService,$timeout){
	$scope.init = function(){
		$scope.successMsg = undefined;
		commonService.getLogUserInfo('userInfo').then(function(res) {
			if(res) {
				$scope.loggedInUser = res;
				$scope.defReferObj = {referralName:"",emailId:"",mobileNo:"",user:{id:$scope.loggedInUser.id}};
				$scope.refferalData = [angular.copy($scope.defReferObj),angular.copy($scope.defReferObj),angular.copy($scope.defReferObj)];
			}
		}, function(error) {
			console.error(error);
		});
	};
	// invite friends
	$scope.saveReferral = function(){
		referralService.saveReferInfo($scope.refferalData).then(function(res) {
		if(res) {
			$scope.successMsg="Thank you for refering valid details with us";
			$scope.refferalData = [angular.copy($scope.defReferObj),angular.copy($scope.defReferObj),angular.copy($scope.defReferObj)];
		}
		$timeout(function(){
			 $scope.successMsg = undefined;
		 }, 10000);
		$scope.refer ={};	
	}, function(error) {
		console.error(error);
		});
	};
	
	$scope.addFriend= function(){
			var obj = angular.copy($scope.defReferObj);	
			$scope.refferalData.push(obj);
	};
	
	$scope.removeReferPanel = function(index) {
		$scope.refferalData.splice(index,1);
	};
	$scope.init();
	
});
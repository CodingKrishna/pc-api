var adminApp = angular.module('pcAdminModule');

adminApp.controller('dashboardCtrl', function($scope, $state, $rootScope,$timeout,$window,commonService,userService){
	$scope.checkLogin=function(){
		commonService.getLogUserInfo('adminInfo').then(function(res){
		},function(err){
			$state.go('login');
		});
	};
	$scope.checkLogin();
	//$window.location.reload();
});
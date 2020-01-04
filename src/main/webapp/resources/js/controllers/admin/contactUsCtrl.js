var app = angular.module('pcAdminModule');
app.controller('contactUsCtrl', function($scope,$http,contactusService) {
	$scope.init=function(){
		$scope.getcontactUsList();
	};
	
	$scope.getcontactUsList=function(){
		contactusService.getcontactUsList().then(function (res){
			$scope.contactUsList=res;
		},function(error){
			console.error(error);
		});
	};
	$scope.init();
	
});
var app = angular.module('pcAdminModule');
app.controller('supportsList', function($scope,$http,supportService) {
	$scope.init=function(){
		$scope.getSupportsList();
	};
	
	$scope.getSupportsList=function(){
		supportService.getSupportsList().then(function (res){
			$scope.supportsList=res;
		},function(error){
			console.error(error);
		});
	};
	$scope.init();
});
var app = angular.module('pcAdminModule');
app.controller('instructorsCtrl', function($scope,$http,instructorService) {
	$scope.init=function(){
		$scope.getInstructorsList();
	};
	
	$scope.getInstructorsList=function(){
		instructorService.getInstructorsList().then(function (res){
			$scope.instructorsList=res;
		},function(error){
			console.error(error);
		});
	};
	$scope.init();
});
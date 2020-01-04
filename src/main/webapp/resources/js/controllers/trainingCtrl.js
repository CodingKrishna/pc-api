var app = angular.module('pcModule');
app.controller('trainingCtrl',function($scope, $http) {
	$scope.coursesBgColors =["bg-color-1","bg-color-2","bg-color-3","bg-color-4"];
	$scope.init = function() {
		$scope.coursesList = [];
		$scope.contentLoader=false;
		$scope.getCourses();
		$scope.currentCourse = 'all'; 
	};
	$scope.getCourses = function() {
		$http.get('course/courselist').success(function(res){
			if(res.isSuccess) {
				$scope.coursesList = res.response;
			}
		});
	};
		
	$scope.toggleChange = function(course){
		$scope.currentCourse = course;
	};
	$scope.init();
});


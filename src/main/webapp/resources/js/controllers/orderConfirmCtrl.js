angular.module('pcModule').controller('orderConfirmCtrl',function($scope, commonService,$http, $stateParams, $timeout,$state,eventService) {
	// getting the courses from session storage which are added to cart
	 $scope.purchasedCoursesList=[]; 
	 $scope.orderTotals=0;
	 $scope.init = function() {
		 $scope.loggedInUser ={};
			commonService.getLogUserInfo('userInfo').then(function(res) {
				$scope.loggedInUser = res;
				$scope.getPurchasedCoursesById($scope.loggedInUser.id);
			}, function(error) {
				console.error(error);
			});
	 };
	 // retrieves total purchased courses
	 $scope.getPurchasedCoursesById = function(userId){
		 eventService.getPurchasedCoursesById(userId).then(function(res){
				if(res && res.length) {
					$scope.purchasedCoursesList = res;
					for(var i=0;i<$scope.purchasedCoursesList.length;i++) {
						$scope.orderTotals = $scope.orderTotals+$scope.purchasedCoursesList[i].courseId.price;
					}
				}
				
			});
		
	};
	$scope.init();
});

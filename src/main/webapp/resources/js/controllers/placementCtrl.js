app.controller('placementCtrl',function($scope,$http,$timeout,commonService,$rootScope){
	$scope.$expanded=undefined;
	$scope.jobOpenings = [
	                      {"companyName":"Trie Coders Pvt Ltd","skills":"Java, J2EE, Spring & Hibernate","imgPath":"URL","designation":"Java Developer","interviewLocation":"Bangalore","eligibility":"B.Tech","LastDateToApply":"15-07-2017","experience":"fresher"},
	                      {"companyName":"Trie Coders Pvt Ltd","skills":"HTML5/CSS3, JS and AngularJS","imgPath":"URL","designation":"UI Developer","interviewLocation":"Bangalore","eligibility":"B.Tech","LastDateToApply":"15-07-2017","experience":"fresher"},
	                      {"companyName":"Trie Coders Pvt Ltd","skills":"Good Communication skill & Ability to handle resource","imgPath":"URL","designation":"HR","interviewLocation":"Bangalore","eligibility":"MBA","LastDateToApply":"15-07-2017","experience":"fresher"},
	                      {"companyName":"Trie Coders Pvt Ltd","skills":"Good Communication & Marketing skills","imgPath":"URL","designation":"Marketing","interviewLocation":"Bangalore","eligibility":"MBA","LastDateToApply":"15-07-2017","experience":"fresher"},
	                      ];
	
	$scope.getAllPlacedStudentsList = function() {
		$http.get('user/placementslist').then(function(res){
			if(res.data.isSuccess) {
				$scope.placedStudents = res.data.response;
		}
		});
	};
	
	commonService.getLogUserInfo('userInfo').then(function(res) {
		$scope.loggedInUser = res;
	}, function(error) {
		console.error(error);
	});
	$scope.toggleRowExpansion = function(index) {
		$scope.$expanded= (index == $scope.$expanded) ? undefined : index;
	};
	
	$scope.applyJob = function() {
		if($scope.loggedInUser){
		}else {
			 $rootScope.$broadcast('doLogin');
			};
	};

	
	
	$scope.getAllPlacedStudentsList();
	
	
});
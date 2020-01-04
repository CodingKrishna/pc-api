var app = angular.module('pcAdminModule');
app.controller('paymentsListCtrl', function($scope,$http,$timeout) {
	$scope.init=function(){
		$scope.purchasedCourses ={};
		$scope.newPay = {};
		$scope.getUsersByRole();
		$scope.getCourses();
	};
	$scope.getCourses = function() {
		$http.get('course/courselist').success(function(res){
			if(res.isSuccess) {
				$scope.coursesList = res.response;
			}
		});
	};
	// toggle function to toggle the views
	$scope.toggleBoolean = function(prop) {
		$scope[prop]= !$scope[prop];
	};
	$scope.selectCourses = function(user){
		$scope.purchasedCourses.user = user.user;
		$scope.toggleBoolean('showCoursePurchaseForm');
	};
	$scope.getUsersByRole = function() {
		$http.get("user/getuserslistbyrole").success(function(res) {
			if (res) {
				$scope.usersList = res.response;
				for(var j=0;j<$scope.usersList.length;j++){
					$scope.usersList[j].totalAmount = 0;
					if($scope.usersList[j].purchaseCourseDto.length){
						for(var i=0;i<$scope.usersList[j].purchaseCourseDto.length;i++) {
							$scope.usersList[j].purchaseCourseDto[i].purchasedCourseDetails = JSON.parse($scope.usersList[j].purchaseCourseDto[i].purchasedCourseDetails);
							for(var k=0;k<$scope.usersList[j].purchaseCourseDto[i].purchasedCourseDetails.length;k++){
								$scope.usersList[j].totalAmount =$scope.usersList[j].totalAmount+$scope.usersList[j].purchaseCourseDto[i].purchasedCourseDetails[k].price
							};
						}
					};
				};
			};
		});
	};
	$scope.viewPurchasedCourses = function(cousesDetails) {
	$scope.coursesDetails = cousesDetails.purchaseCourseDto
		$scope.toggleBoolean('viewCourses');
	};
	$scope.makePayment = function(user){
		$scope.newPay.user = user.user;
		$scope.toggleBoolean('showPaymentForm');
	};
	$scope.submitPayment = function(){
		var req = {};
		req = $scope.newPay;
		$http.post('payments/add',req).then(function(res){
			if(res.data.isSuccess) {
				$scope.toggleBoolean('showPaymentForm');
				$scope.successMsg = "Successfully Payed";
				$timeout(function(){
					$scope.successMsg = undefined;
				},3000);
			}
		});
	};
	$scope.purchaseCourses = function(){
		var req = {};
		req = angular.copy($scope.purchasedCourses);
		req.purchasedCourseDetails = angular.toJson(req.purchasedCourseDetails);
		$http.post('course/addpurchaseddetails',req).then(function(res){
			if(res.data.isSuccess) {
				$scope.toggleBoolean('showCoursePurchaseForm');
				$scope.successMsg = "Successfully submitted";
				$timeout(function(){
					$scope.successMsg = undefined;
				},3000);
			}
		});
		console.log($scope.purchaseCourse);
	};
	$scope.viewPaymentsByUserId = function(user,index){
		$scope.toggleRowExpansion(index);
		$http.post('payments/byuserid?userid='+user.user.id).then(function(res){
			if(res.data.isSuccess){
				$scope.paymentsList = res.data.response;
				console.log($scope.paymentsList);
			}
		});
		
	};
	$scope.toggleRowExpansion = function(index) {
		$scope.$expanded= (index == $scope.$expanded) ? undefined : index;
	};
	$scope.init();
});
angular.module('pcModule').controller('cartCtrl',function($scope, commonService,$http, $stateParams, $timeout,$state, $rootScope,eventService) {
	$scope.cartCourses =[];
	$scope.purchasedCoursesList = [];
	$scope.orderTotals = 0;
	$scope.status = false;
	$scope.infoMsg = undefined;
    // init function
	$scope.init = function(courseId) {
		$scope.getCourseInfo(courseId);
		$scope.loggedInUser ={};
		commonService.getLogUserInfo('userInfo').then(function(res) {
			$scope.loggedInUser = res;
			
		}, function(error) {
			console.error(error);
		});
	};
	
	// function to toggle the popup
	$scope.toggleBoolean = function(prop) {
		$scope[prop]= !$scope[prop];
	};
	
	// getting the courses from session storage if present
	 if(sessionStorage.length) {
		 var keys = Object.keys(sessionStorage);
		 for(var i=0;i<keys.length;i++) {
			 if(keys[i]!='userInfo' && keys[i]!='TawkWindowName' && keys[i]!='profile')
				 {
					 $scope.cartCourses.push(JSON.parse(sessionStorage.getItem(keys[i])));
					 $scope.orderTotals = $scope.orderTotals +$scope.cartCourses[i].price;
				 }
		 }
	 }
	 /* retrieves courses purchased by the user previously*/
	 $scope.getPurchasedCoursesById = function(){
		 eventService.getPurchasedCoursesById(JSON.parse(sessionStorage.getItem('userInfo')).id).then(function(res){
				if(res && res.length) {
					for(var i=0;i<res.length;i++) {
						$scope.purchasedCoursesList[i] = JSON.parse(res[i].purchasedCourseDetails);
					}
					
					$scope.status = true;
					$scope.proceedTOCheckOut();
				}
			});
	};
	 // getting course info and adding to the card if not exist in the cart
	$scope.getCourseInfo = function(courseId) {
		for(i=0;i< $scope.cartCourses.length;i++) {
			if($scope.cartCourses[i].id == courseId) {
				alert($stateParams.courseName+" is already exist in the cart");
				 $state.go('carthome');
			}
		}
		$http.get('course/courseinfo/' + courseId).success(function(res){
			if(res.isSuccess) {
				var course = res.response;
					delete course.descTemplate;
					if(sessionStorage) {
						 sessionStorage.setItem(course.courseName,JSON.stringify(course));
					 }
					 $scope.cartCourses.push(course);
					 $scope.orderTotals = $scope.orderTotals+course.price;
			}
		});
	};
	 //checks weather user logged in or not
	$scope.proceedTOCheckOut = function() {
		if(sessionStorage.getItem('userInfo') ){
			if($scope.status) {
				for(var i=0;i<$scope.cartCourses.length;i++) {
						for(var k=0;k<$scope.purchasedCoursesList.length;k++){
							for(var m=0;m<$scope.purchasedCoursesList[k].length;m++){
								if($scope.purchasedCoursesList[k][m].id ==  $scope.cartCourses[i].id ) {			
									$scope.infoMsg = "You have already purchased the "+$scope.cartCourses[i].courseName;
									$scope.toggleBoolean('showPopup');
									return;
								}
							}
						}
				}
			}
			for(var n=0;n<$scope.cartCourses.length;n++){
				var purchasedCoursesObj = {};
				purchasedCoursesObj.user={};
				purchasedCoursesObj.courseId = {};
				purchasedCoursesObj.courseId.id = $scope.cartCourses[n].id;
				purchasedCoursesObj.user.id=JSON.parse(sessionStorage.getItem('userInfo')).id;
				$http.post('course/addpurchaseddetails',purchasedCoursesObj).then(function(res){
					if(res.data.isSuccess) {
						var keys = Object.keys(sessionStorage);
						for(var i=0;i<keys.length;i++) {
						 if(keys[i]!='userInfo' && keys[i]!='TawkWindowName')
							 {
								 sessionStorage.removeItem(keys[i]);
							 }
				 		}
						$state.go('orderconfirm');
					}
				});
			}
					}else {
			 $rootScope.loginRedirectPage = 'courseCart'
			 $rootScope.$broadcast('doLogin');
		};
	};
	if($stateParams.courseId) {
		$scope.init($stateParams.courseId);
	}
	//removes the course from cart
	$scope.removeCourse = function(index) {
		$scope.orderTotals = $scope.orderTotals-$scope.cartCourses[index].price;
		sessionStorage.removeItem($scope.cartCourses[index].courseName);
		$scope.cartCourses.splice(index,1);
	};
	// listener 
	$rootScope.$on('gotocart',function(){
		$scope.getPurchasedCoursesById();
	});
});

var app = angular.module('pcModule');
app.controller('userCtrl', function($scope, $log,$http, commonService,$timeout, userService,eventService) {
	
	$scope.init = function (){
		$scope.loggedInUser ={};
		$scope.purchasedCoursesList = [];
		// fetches user object from session storage if the user is logged in
		commonService.getLogUserInfo('userInfo').then(function(res) {
			$scope.loggedInUser = res;
			$scope.getPurchasedCoursesById($scope.loggedInUser.id);
			 $scope.getUserCompleteData();
			$scope.getAllEventsByUserId($scope.loggedInUser.id);
			$scope.folderPath = $scope.loggedInUser.id+"-"+$scope.loggedInUser.userName;
		}, function(error) {
			console.error(error);
		});
		
		$('.widget-pages li>ul').parent().addClass('has-child');
		$('.widget-pages li>a').on( 'click', function(e) {
		  e.stopPropagation();
		});
		$('body').on('click', '.widget-pages li', function(e) {
		  e.stopPropagation();

		  if( $(this).children('ul').length ) {
		    $(this).children('ul').slideToggle(500);   
		    $(this).toggleClass('active');
		    $(this).children('ul').toggleClass('active');
		  } 
		});
		var widget_hover = $('.widget-navigation a');

		jQuery(widget_hover).each(function (){
		  $(this).mouseout(function(e) {
		    $(this).parent().removeClass('hover');
		  });
		  $(this).mousemove(function(e) {
		    $(this).parent().addClass('hover');
		  });
		});
	};
	
	// Retrieves user purchased(opted) courses
	 $scope.getPurchasedCoursesById = function(userId){
			$http.get('course/purchasedcourses?userId='+userId).then(function(res){
				if(res.data.isSuccess && res.data.response.length) {
					$scope.purchasedCoursesList = res.data.response;
					for(var i=0;i<res.data.response.length;i++) {
						$scope.purchasedCoursesList[i].purchasedOn = new Date(angular.copy($scope.purchasedCoursesList[i].purchasedOn));
						var purDate = angular.copy($scope.purchasedCoursesList[i].purchasedOn);
						$scope.purchasedCoursesList[i].validity = purDate.setMonth(purDate.getMonth() + 6);
					}
				}
			});
	 };
	 
	 // used for updating users visibility settings
	 $scope.updateUserVisisbility = function(){
	userService.updateUserVisisbility(JSON.parse($scope.visibility),$scope.loggedInUser.id).then(function(res) {	
		if(res){
				$scope.visibility = res.isVisible;
				$scope.toggleBoolean('showPopup');
			} 
		}, function(error) {
				console.error(error);
			});
	 };
	 
	 //Handler for Retrieving users visibility 
	 $scope.getUserCompleteData = function(){
		 commonService.getUserCompleteData($scope.loggedInUser.id).then(function(res){
			if(res.user) {
				 $scope.visibility = res.user.isVisible;
			}
		 });
	 };
	 $scope.getAllEventsByUserId = function(userId) {
			eventService.getAllEventsByUserId(userId).then(function(res){
				if(res) {
					$scope.bookedEventsList  = res;
				}
			});
		};
	$scope.changePhoto = function(changeFormName) {
		$scope.profilePicChangeForm = changeFormName;
	};
	
	$scope.uploadProfilePic = function(picString) {
		$scope.serviceLoading = true;
		if ($scope.profilePicChangeForm === 'upload') {
			var file = $('#profilePicFileInput')[0].files[0];
			fileToBase64(file).then(function(picSring) {
				userService.uploadProfilePic(picSring, $scope.loggedInUser.id,$scope.loggedInUser.userName);
				$scope.changePhoto();
				$scope.serviceLoading = false;
				window.location.reload();
			});
		} else if (picString) {
			userService.uploadProfilePic(picString, $scope.loggedInUser.id,$scope.loggedInUser.userName);
			$scope.changePhoto();
			$scope.serviceLoading = false;
			window.location.reload();
		}
	};
	
	$scope.closePopup = function(){
		$scope.toggleAddPopup('showResults');
		$scope.testSuccessMsg = undefined;
	};
	function timeIsUp (){
		$scope.examSubmit();
	};
	$scope.examSubmit = function() {
		$scope.testQuestions.user.id = $scope.loggedInUser.id;
		$scope.testQuestions.technology = $scope.technology;
		console.log($scope.exam);
		var req=angular.copy($scope.testQuestions);
		for(var i=0;i<req.length;i++){
			delete req.objectQuestions[i].index;
		}
		req.totalQuestions = $scope.testQuestions.length;
		$http.post("exam/submit",req).success(function(res) {
			if (res.isSuccess) {
				$scope.exam.objectQuestions =[];
				$scope.testSuccessMsg = res.response;
				$scope.toggleAddPopup('showResults');
				$scope.getQuizResultsByUserId();
			}
		});
	};

	$scope.getQuestionsForUsers =function(testId){
		$scope.testQuestions = [];
		userService.getQuestionsForUsers(testId).then(function(res){
			if(res) {
				$scope.testQuestions =res.data.response;
				for(var i=0;i<$scope.testQuestions.length;i++){
					$scope.testQuestions[i].index = i;
				}
				$scope.current = $scope.testQuestions[0];
				$timeout(Prism.highlightAll, 0);
				$(function(){  
					$("#ms_timer_one").countdowntimer({
						minutes : $scope.testQuestions.length*1,
		                seconds : 00,
		                size : "size_md",
		                tickInterval:1,
		                timeUp:timeIsUp
					});
				});
				
			}else{
				$scope.msg = "No Test Questions Available..";
			}
		});
	};
	
	
	
	 $scope.init();
});
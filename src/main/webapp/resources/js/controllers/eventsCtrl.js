app.controller("eventsCtrl",function($scope,$http,$rootScope,commonService,eventService,$timeout){
	// init method
	$scope.init = function() {
		$scope.status = false;
		
		$scope.getAllEvents();
		commonService.getLogUserInfo('userInfo').then(function(res) {
			$scope.loggedInUser = res;
			$scope.getAllEventsByUserId();
		}, function(error) {
			console.error(error);
		});
	};
	// function to toggle the popup
	$scope.toggleBoolean = function(prop) {
		$scope[prop]= !$scope[prop];
	};
	// retrieves all events which are going to conduct
	$scope.getAllEvents = function(){
		eventService.getAllEvents().then(function(res){
			if(res) {
				$scope.eventsList = res;
			}
		});
	};
	// retrieves previously booked events by the user
	$scope.getAllEventsByUserId = function(){
		eventService.getAllEventsByUserId($scope.loggedInUser.id).then(function(res){
			if(res) {
				$scope.previouslyBookedEventsList = res;
				if($scope.status == true) {
					$scope.bookEvents($rootScope.eventDetails);
				}
			}
		});
	};
	// method for saving events
	$scope.bookEvents = function(event) {
		// checks if the if events is previously booked or not 
		if($scope.previouslyBookedEventsList) {
			for(var i=0;i<$scope.previouslyBookedEventsList.length;i++) {
				if($scope.previouslyBookedEventsList[i].event.id == event.id) {
					$scope.eventAlertMsg =event.eventName;
					$scope.toggleBoolean('showPopup');
					return;
				};
			}
		}
		// this method is for saving event. saves the event if and only if used logged in.
		if($scope.loggedInUser){
				var bookingEventObj = {user:{},event:{}};
				bookingEventObj.event.id = event.id;
				bookingEventObj.user.id = $scope.loggedInUser.id;
				eventService.bookEvents(bookingEventObj).then(function(res){
					if(res){
						console.log(res);
						$scope.changeState('eventbooking');
					}
				});
			}else {
				$rootScope.eventDetails = event;
				$rootScope.loginRedirectPage = 'eventBook';
				 $rootScope.$broadcast('doLogin');			// if the user not logged in redirect to login page		
				};
	};
	//listener
	$rootScope.$on('$goToEvents',function(){
		$scope.status = true;
		$scope.getAllEventsByUserId();
	});
	$scope.init();
});
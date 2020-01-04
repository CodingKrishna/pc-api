app.controller('eventBookingCtrl',function($scope,$http,$log,commonService,eventService){
	
	commonService.getLogUserInfo('userInfo').then(function(res) {
		$scope.loggedInUser = res;
	}, function(error) {
		console.error(error);
	});
	
	$scope.getAllEventsByUserId = function() {
		if(sessionStorage.getItem('userInfo')){
			eventService.getAllEventsByUserId($scope.loggedInUser.id).then(function(res){
				$scope.bookedEventsList = res[res.length-1];
			});
		}
	};
	$scope.getAllEventsByUserId();
});
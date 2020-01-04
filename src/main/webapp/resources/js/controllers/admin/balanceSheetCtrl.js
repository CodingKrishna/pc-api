var app = angular.module('pcAdminModule');
app.controller('balanceSheetCtrl', function($scope,$http,$timeout,userService) {
	$scope.init=function(){
		$scope.totalPurchases = [];
		$scope.endDate = new Date();
		$scope.TotalIncomings = 0;
		$scope.TotalOutGoings = 0;
	};
	
	$scope.getTotalPurchases = function(){
		$http.get('payments/totalpaymentsbydates?startDate='+dateToStr($scope.startDate)+'&endDate='+dateToStr($scope.endDate)).then(function(res){
			if(res.data.isSuccess) {
				$scope.totalPurchases = res.data.response.expendatures;
				for(var i=0;i<res.data.response.purchases.length;i++){
					$scope.totalPurchases.push(res.data.response.purchases[i]);
				}
				
				for(var j=0;j<$scope.totalPurchases.length;j++){
					if($scope.TotalIncomings+$scope.totalPurchases[j].paidAmount){
						$scope.TotalIncomings = $scope.TotalIncomings+$scope.totalPurchases[j].paidAmount;
					}if($scope.totalPurchases[j].price){
						$scope.TotalOutGoings = $scope.TotalOutGoings+$scope.totalPurchases[j].price;
					}
				}
				
				
			}
			
			
			if(!$scope.totalPurchases.length){
				$scope.successMsg = "No records are found";
			}
		});
	};
	
	$scope.courseInfo = function(user,index){
		$scope.toggleRowExpansion(index);
		$http.get('course/purchasedcourses?userId='+user.id).then(function(res){
			if(res.data.isSuccess){
				$scope.coursesList = res.data.response;
				for(var i=0;i<res.data.response.length;i++){
					$scope.coursesList[i].purchasedCourseDetails =JSON.parse($scope.coursesList[i].purchasedCourseDetails);
				}
				console.log($scope.coursesList);
			}
		});
		
	};
	
	$scope.toggleRowExpansion = function(index) {
		$scope.$expanded= (index == $scope.$expanded) ? undefined : index;
	};
	
	
	/*Calendar Start*/
	$scope.showWeeks= false;
	$scope.inlineOptions = {
		customClass: getDayClass,
		minDate: new Date() ,
		showWeeks: false
	};

	$scope.dateOptions = {
		// dateDisabled: disabled,
		formatYear: 'yy',
		maxDate: new Date(2040, 11, 31),
		minDate: new Date(),
		startingDay: 1
	};

	// Disable weekend selection
	function disabled(data) {
		var date = data.date,
		mode = data.mode;
		return mode === 'day' && (date.getDay() === 0 || date.getDay() === 6);
	}

	$scope.toggleMin = function() {
		$scope.inlineOptions.minDate = $scope.inlineOptions.minDate ? null : new Date();
		$scope.dateOptions.minDate = $scope.inlineOptions.minDate;
	};

	$scope.toggleMin();

	$scope.openCalendar = function(calenderParameter) {
		$scope[calenderParameter] = {opened: true};
	};

	$scope.setDate = function(year, month, day) {
		$scope.dt = new Date(year, month, day);
	};
	  $scope.calendarPanel = {
	    opened: false
	  };
	  function getDayClass(data) {
	    var date = data.date,
	      mode = data.mode;
	    if (mode === 'day') {
	      var dayToCheck = new Date(date).setHours(0,0,0,0);

	      for (var i = 0; i < $scope.events.length; i++) {
	        var currentDay = new Date($scope.events[i].date).setHours(0,0,0,0);

	        if (dayToCheck === currentDay) {
	          return $scope.events[i].status;
	        }
	      }
	    }

	    return '';
	  }
	  /*Calendar End*/
	  
	$scope.init();
});
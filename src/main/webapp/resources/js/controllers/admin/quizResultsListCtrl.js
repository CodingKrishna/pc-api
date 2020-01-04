var app = angular.module('pcAdminModule');
app.controller('quizResultsList', function($scope,$http,supportService,Excel,$timeout) {
	$scope.init=function(){
		$scope.resultList = [];
		$scope.newResultsList = [];
		$scope.examResults();
	};
	
	$scope.examResults = function() {
		$http.get("exam/getexamtotalinfo").success(function(res) {
			if (res) {
				$scope.resultList = res.response;
				for(var i=0;i<$scope.resultList.length;i++){  
					var newResObj = $scope.getUserObj($scope.resultList[i].user.id);
					if(newResObj){
						var findRes = newResObj.obj;
						var marksRes = findRes.marks.search('technology',$scope.resultList[i].technology);
						if(!marksRes){
							var marks = {
									technology:$scope.resultList[i].technology,
									totalMarks:$scope.resultList[i].totalMarks,
							};
							findRes.marks.push(marks);
							$scope.newResultsList[newResObj.index] = findRes;
						}
					}else{
						var obj = {user : $scope.resultList[i].user};
						obj.marks= [{
									 technology:$scope.resultList[i].technology,
									 totalMarks:$scope.resultList[i].totalMarks,
									 }
									];
						$scope.newResultsList.push(obj);
					}
				}
			}
		});
	};
	$scope.getUserObj = function(userId){
		var res=undefined;
		for(var i = 0;i<$scope.newResultsList.length;i++){
			if($scope.newResultsList[i].user.id == userId){
				res = {"index":i,"obj":$scope.newResultsList[i]};
			}
		}
		return res;
	};
	 $scope.exportToExcel=function(tableId){ // ex: '#my-table'
         var exportHref=Excel.tableToExcel(tableId,'WireWorkbenchDataExport');
         $timeout(function(){location.href=exportHref;},100); // trigger download
     };

/*	Calendar Start
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
	  Calendar End*/
	  
	$scope.init();
});
var app = angular.module('pcModule');
app.controller('userDashboardCtrl',function($scope,$http,commonService,userService){
	$scope.init = function() {
		$scope.getLogUserInfo();
		$scope.quizResultList=[];
	};
	$scope.getLogUserInfo=function(){
		commonService.getLogUserInfo('userInfo').then(function(res){
			$scope.loggedInUser = res;
			$scope.getQuizResultsByUserId();
		},function(err){
			$scope.changeState('home');
		});
	};
	$scope.getQuizResultsByUserId = function() {
		userService.getQuizResultsByUserId($scope.loggedInUser.id).then(function(res){
			if(res.isSuccess) {
				$scope.quizResultList =res.response; 
				var technologies =$scope.quizResultList.map(function(obj) {
					return obj.technology;
				});
				var filterdTechs = [];
				for(var i=0; i<technologies.length; i++) {
					if(filterdTechs.indexOf(technologies[i]) === -1) {
						filterdTechs.push(technologies[i]);
					}
				}
				console.log(filterdTechs);

				$scope.quizresult = {};
				for(var i=0; i<filterdTechs.length; i++) {
					totalMarks = 0;
					scoredMarks = 0;
					for(var j=0; j<$scope.quizResultList.length; j++) {
						if(filterdTechs[i] === $scope.quizResultList[j].technology) {
							totalMarks = totalMarks + $scope.quizResultList[j].questions;
							scoredMarks = scoredMarks +$scope.quizResultList[j].answered;
						}
					}
					$scope.quizresult[filterdTechs[i]] = {
						total: totalMarks,
						scored: scoredMarks
					};
				}
			}
		});
	};
	/*$scope.quizList = ["HTML Quiz","CSS Quiz","Javascript","AngularJS"];*/
	$scope.bgColors = ["bg-color-1","bg-color-2","bg-color-3","bg-color-4"];
	
	$scope.init();
});
angular.module('pcModule').controller('onlineTestCtrl', function($scope, onlineTestService,$timeout,$interval,commonService,$http,$rootScope) {
	$scope.init = function() {
		$scope.exam = {questsList:[]};
		$scope.exam.user={};
		$scope.testsuccessMsg = undefined;
		$scope.IsCompleted = false;
		$scope.formLoader=false;
		$scope.getLogUserInfo();
	};
	
	$scope.getLogUserInfo = function(){
		commonService.getLogUserInfo("userInfo").then(function(res){
			if(res){
				$scope.loggedInUser = res;
				$scope.getQuizResultsByUserId();
				$scope.IsCompleted  = $scope.loggedInUser.examCompleted;
			}
		});
	};
	
	function timeIsUp (){
		$scope.examSubmit();
	};
	
	$scope.getExamQuestions = function(){
	/*if(data!=undefined){
		$scope.technology = data;
	}*/
	onlineTestService.getPaperByTech($scope.loggedInUser.id).then(function(res) {
	if(res) {
			$scope.exam.questsList = res.response.questsList;
			for(var i=0;i<$scope.exam.questsList.length;i++){
				$scope.exam.questsList[i].index = i;
			}
			$scope.current = $scope.exam.questsList[0];
			$timeout(Prism.highlightAll, 0);
			$(function(){
				$("#ms_timer_one").countdowntimer({
					minutes : $scope.exam.questsList.length*1,
	                seconds : 00,
	                size : "size_md",
	                tickInterval:1,
	                timeUp:timeIsUp
				});
			});
		}
		$scope.refer ={};	
		}, function(error) {
			console.error(error);
			});
		
	};
	
	$scope.toggleAddPopup = function(param) {
		$scope[param] = !$scope[param];
	};
	$scope.examSubmit = function() {
		$scope.exam.user.id = $scope.loggedInUser.id;
		$scope.exam.technology = $scope.technology;
		console.log($scope.exam);
		var req=angular.copy($scope.exam);
		for(var i=0;i<req.questsList.length;i++){
			delete req.questsList[i].index;
		}
		req.totalQuestions = $scope.exam.questsList.length;
		$http.post("exam/submit",req).success(function(res) {
			if (res.isSuccess) {
				$scope.exam.questsList =[];
				$scope.testSuccessMsg = res.response;
				$scope.toggleAddPopup('showResults');
				$scope.getQuizResultsByUserId();
			}
		});
	};
	
	$scope.closePopup = function(){
		$scope.toggleAddPopup('showResults');
		$scope.testSuccessMsg = undefined;
	};
	$scope.getQuizResultsByUserId = function() {
		$http.get("exam/examresultsbyprofileid?profileId="+$scope.loggedInUser.id).success(function(res) {
			if (res.isSuccess) {
				console.log(res.response);
				$scope.quizResultsList  = res.response;
				if($scope.quizResultsList.length){
					$scope.IsCompleted = true;
				}
			}
		});
	};
	
    $scope.next = function(){
        if($scope.current.index!=undefined) {
        	var i = $scope.getIndex($scope.current.index, 1);
            $scope.current = $scope.exam.questsList[i];
            $timeout(Prism.highlightAll, 0);
        }
    },
    $scope.previous = function(){
    	if($scope.current.index!=undefined) {
        var i = $scope.getIndex($scope.current.index, -1);
        $scope.current = $scope.exam.questsList[i];
    	}
    };
    $scope.getIndex = function(currentIndex, shift){
        var len = $scope.exam.questsList.length;
        return (((currentIndex + shift) + len) % len);
    };
	$scope.init();
});
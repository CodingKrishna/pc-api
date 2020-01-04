angular.module('pcModule').controller('myTestsCtrl', function($scope, commonService,$http) {
	/*$scope.init = function() {
		jdoodle();
	};
	$scope.init();*/
	$scope.showQues = true;
	$scope.showEdiQuestion = false;
	 commonService.getLogUserInfo('userInfo').then(function(res){
		 if(res) {
			 $scope.loggedInUser = res;
			 $scope.getAssignedQuestionsListByUserId($scope.loggedInUser.id);
		 }
	 });
	 
	// slides to login form  from registration form
	$scope.slideToCoding = function() {
		$scope.shwowQuestions = 'slide-page-right';
	};
	
	// slides to registration  from login form
	$scope.slideToQuestions = function() {
		$scope.shwowQuestions = 'slide-page-left';
	};
	$scope.showEditor = function(question,index){
		$scope.showEdiQuestion = true;
		$scope.showQues = false;
		$scope.questionInfo = question;
		$scope.questionInfo.testCases = JSON.parse($scope.questionInfo.question.testCases); 
	//	$scope.questionInfo.code = "public class MyProgramm { public static void main(String[] args){/* write your code here*/ } }"
		$scope.index=index;
		$scope.slideToQuestions();
		
	};
	$scope.showQuesList= function(question){
		document.getElementsByTagName("code")[0].innerHTML= $scope.questionInfo.question.sampleCode;
		$scope.showEdiQuestion = false;
		$scope.showQues = true;
		$scope.questions[$scope.index] = $scope.questionInfo;
		$scope.slideToCoding();
		delete $scope.results.output;
		
	};
	$scope.submitCode = function(code,languageId){
		$scope.questions[$scope.index] = $scope.questionInfo;
		var codeEvaluationReq = {};
		codeEvaluationReq.languageId = languageId;
		codeEvaluationReq.code = document.getElementsByTagName("code")[0].innerHTML;
		console.log(codeEvaluationReq.code);
		codeEvaluationReq.testCases = $scope.questionInfo.testCases;
		$scope.exicuteCode(codeEvaluationReq);
		
	};
	
	$scope.runCode = function(code,languageId){ 
		$scope.questions[$scope.index] = $scope.questionInfo;
		var codeEvaluationReq = {};
		codeEvaluationReq.languageId = languageId;
		codeEvaluationReq.code = document.getElementsByTagName("code")[0].innerHTML;
		console.log(codeEvaluationReq.code);
		if($scope.questionInfo.inputs){
			codeEvaluationReq.inputs = $scope.questionInfo.inputs.split(' ');
			var finalInputs = [];
			console.log(codeEvaluationReq.inputs);
			for(var i=0;i<codeEvaluationReq.inputs.length;i++){
				if(i%2==1){
					finalInputs.push("\n");
				}else{
					finalInputs.push(codeEvaluationReq.inputs[i]);
				}
			}
			finalInputs.push(codeEvaluationReq.inputs[codeEvaluationReq.inputs.length-1]);
			codeEvaluationReq.inputs = finalInputs;
			
		}
		codeEvaluationReq.testCases = null;
		$scope.exicuteCode(codeEvaluationReq);
	};
	
	$scope.exicuteCode = function(codeEvaluationReq){
		$http.post('evaluvator/executecode',codeEvaluationReq).then(function(res){
			if(res){
				$scope.results = res.data;
				var pointsGained = 0;
				if($scope.results.testCases!=null){
					for(var i=0;i<$scope.results.testCases.length;i++){
						if($scope.results.testCases[i].result == "Passed"){
							pointsGained = pointsGained+10/($scope.results.testCases.length);
						}
					}
				}
				console.log(pointsGained);
				if($scope.questionInfo.testCases){
					var codingResult = {"codingTestQstn":{},"user":{}};
					codingResult.points = pointsGained;
					codingResult.codingTestQstn.id = $scope.questionInfo.question.id;
					codingResult.user.id = $scope.loggedInUser.id;
					$http.post('codingtest/createcodingresult',codingResult).then(function(res){
						if(res){
							console.log(res);
						}
					});
				}
				
				if($scope.results.output){
					var arrayData =  $scope.results.output.split("@@");
					var finalResult = "";
					for(var i=0;i<arrayData.length;i++){
						finalResult = finalResult.concat(arrayData[i]).concat("</br>");
					}
					$scope.results.output = finalResult; 
				}
			};
		});
		
	};
	
	$scope.getAssignedQuestionsListByUserId = function(userId){
		$http.get('codingtest/questionslistbyuserid?userId='+userId).then(function(res){
			if(res){
				$scope.questions = res.data.response;
			};
		});
		
	};
	
	$scope.clearAll = function(){
		$scope.results = {};
	};
});
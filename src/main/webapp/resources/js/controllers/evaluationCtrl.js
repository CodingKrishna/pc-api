angular.module('pcModule').controller('evaluationCtrl',function($scope,$http, commonService,evaluationService) {
	$scope.init=function(){
		$scope.selectedStrengths=[];
		$scope.userEvaluation = {};
		$scope.strengths=['Programming Skills','Analytical Skills','Presentation Skills','Reading and Comprehension Skills','Others'];
		$scope.accomList = [{standard : 'IX',desc:''},
						  {standard : 'X',desc:''},
						  {standard : 'XI',desc:''},
						  {standard : 'XII',desc:''},
						  {standard : 'GRAD',desc:''}];
		$scope.defAddUrl={appUrls:""};
		$scope.defAddMobileApps={mobileApp:""};
		$scope.defGamesObj={game:""};

		$scope.getLogUserInfo();
	};
	//Handler for application Urls
	$scope.addAppUrls=function(){
		if($scope.userEvaluation.applications.length<10) {
				$scope.userEvaluation.applications.push(angular.copy($scope.defAddUrl));
		}
	};
	//Handler for mobile apps
	$scope.addMobileAppNames=function(){
		if($scope.userEvaluation.mobileApps.length<10) {
			$scope.userEvaluation.mobileApps.push(angular.copy($scope.defAddMobileApps));
		}
	};
	
	//handler for games
	$scope.AddGameNames=function(){
		if($scope.userEvaluation.games.length<10)
		$scope.userEvaluation.games.push(angular.copy($scope.defGamesObj));
	};
	// Retrieves logged in User Details
	$scope.getLogUserInfo=function(){
		commonService.getLogUserInfo('userInfo').then(function(res){
			$scope.loggedInUser = res;
			$scope.getUserEvaluationDetails();
		},function(err){
			$scope.changeState('home');
		});
		
	};
	
	// method for saving user evaluation 
	$scope.saveEvalutionInfo=function(){
				$scope.userEvaluation.userId = $scope.loggedInUser.id,
				$scope.userEvaluation.applications = angular.toJson($scope.userEvaluation.applications),
				$scope.userEvaluation.mobileApps = angular.toJson($scope.userEvaluation.mobileApps),
				$scope.userEvaluation.games = angular.toJson($scope.userEvaluation.games);
				$scope.userEvaluation.accomplishments = angular.toJson($scope.userEvaluation.accomplishments);
		var strengthArr = [];
		for(var i=0;i<$scope.strengths.length;i++){
			if($scope.selectedStrengths[i]){
				strengthArr.push($scope.strengths[i]);
			}
		}
		
		// join stringifies the array
		$scope.userEvaluation.strengths=strengthArr.join(',');
		evaluationService.saveEvalutionInfo($scope.userEvaluation).then(function(res){
			if(res.isSuccess){
				$scope.evaluationFormMessage='Success';
				$scope.userEvaluation=res.response;
				$scope.transformUserEval();
			}else{
				$scope.evaluationFormMessage="Failed";
			}		
		});
	};
	
	// getting user evaluation details
	$scope.getUserEvaluationDetails=function(){
		$http.get("user/getevaluationinfo?userId="+$scope.loggedInUser.id).success(function(res){
			if(res.isSuccess){
				if(res.response){
						$scope.userEvaluation=res.response;
						$scope.transformUserEval();
				} 
			} else {
				$scope.userEvaluation.applications = [angular.copy($scope.defAddUrl)];
				$scope.userEvaluation.mobileApps=[angular.copy($scope.defAddMobileApps)];
				$scope.userEvaluation.games = [angular.copy($scope.defGamesObj)];
				$scope.userEvaluation.weakness = '';
				$scope.userEvaluation.accomplishments = $scope.accomList;
				$scope.userEvaluation.strengths = $scope.strengths;
			}
			
		});
	};
	//parsing user evaluation details using JSON.parse method
	$scope.transformUserEval = function(){
		$scope.userEvaluation.applications = JSON.parse($scope.userEvaluation.applications);
		$scope.userEvaluation.mobileApps = JSON.parse($scope.userEvaluation.mobileApps);
		$scope.userEvaluation.games = JSON.parse($scope.userEvaluation.games);
		$scope.userEvaluation.strengths = $scope.userEvaluation.strengths.split(',');
		$scope.userEvaluation.weakness = $scope.userEvaluation.weakness;
		$scope.userEvaluation.accomplishments = JSON.parse($scope.userEvaluation.accomplishments);
	};
	$scope.init();
});

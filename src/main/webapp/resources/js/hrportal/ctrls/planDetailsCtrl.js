app.controller('planDetailsCtrl',function($scope,hrCommonService,desktopService,commonService) {
	$scope.init = function() {
		$scope.pricingBgColors =["bg-color-1","bg-color-2","bg-color-3"];
		$scope.getPlanDetails();
		$scope.checkLogin();
		$scope.getPurchasedPlanDetailsByHrId();
	};
	$scope.getPlanDetails = function(){
		hrCommonService.getPlanDetails().then(function(res){
			if(res) {
				$scope.pricingPlanList = res;
			}
		});
	};
	$scope.purchasedPlan = {};
	$scope.checkLogin=function(){
		commonService.getLogUserInfo('userInfo').then(function(res){
			$scope.loggedInUser = res;
		},function(err){
			$scope.loggedInUser = null;
			$scope.changeState('home');
		});
	};
	/*purchase Plan*/
	$scope.purchasePlan = function(plan) {
		if($scope.loggedInUser) {
			desktopService.getPurchasedPlanDetailsByHrId($scope.loggedInUser.id).then(function(res){
				if(res) {
					
					if(res.id){
						return alert("You have already purchased the plan.");
					}
					var planObj = {};
					planObj.user = {};
					planObj.plan = {};
					planObj.user.id = $scope.loggedInUser.id;
					planObj.plan.id = plan.id;
					hrCommonService.purchasePlan(planObj).then(function(res){
						if(res){
							$scope.purchasedPlan = res;
							$scope.changeState('confirmPurchase');
						}
					});
				}
			});
		
		}
	};
	$scope.getPurchasedPlanDetailsByHrId = function() {
		desktopService.getPurchasedPlanDetailsByHrId($scope.loggedInUser.id).then(function(res){
			if(res) {
				$scope.purchasedPlan = res;
			}
		});
	};
	$scope.init();
});
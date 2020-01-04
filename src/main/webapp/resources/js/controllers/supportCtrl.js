app.controller('supportCtrl',function($scope,supportService,$http, $timeout) {
	$scope.form={};
	$scope.supportFormMessage= undefined;
	$scope.saveSupport=function(){
		var support=angular.copy($scope.support);
		supportService.saveSupport(support).then(function(res){
			if(res.isSuccess){
				$scope.supportFormMessage="Your details Saved Successfully";
				$scope.support={};
				$scope.form.supportForm.$setPristine();
				$timeout(function(){
					$scope.supportFormMessage=undefined;
				},4000);
			}else{
				$scope.supportFormMessage="FAILED";
			}
		},function(err){
			$scope.supportFormMessage="FAILED";	
		});
	};
});
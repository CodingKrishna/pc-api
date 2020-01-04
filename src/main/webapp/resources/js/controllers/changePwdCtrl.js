angular.module("pcModule").controller('changePwdCtrl',['$scope','$http','$timeout',function($scope,$http,$timeout){
		$scope.showpopup=false;
		$scope.formLoader = undefined;
		$scope.sendMail = function(){
			$scope.formLoader = true;
			$http.get('user/forgetpassword?emailId='+$scope.emailId).then(function(res){
				if(res){
					$scope.msg = res.data.response;
					$scope.formLoader = false;
					 $scope.toggleBoolean('showpopup');
				}
			});
		}
		$scope.closePopup = function(){
			window.top.close();
		}
		// toggle function to toggle the views
		$scope.toggleBoolean = function(prop) {
			$scope[prop]= !$scope[prop];
			
		};
		
	}]);
var app=angular.module('generatePwdApp',['angular-md5']);
	app.controller('generatePwdCtrl',['$scope','$http','md5','$location','$timeout',function($scope,$http,md5,$location,$timeout){
		$scope.changePassword = function(){
			if($scope.changePwd.newPassword != $scope.changePwd.confirmPassword){
				return alert("Passwords are not matched");
			}
			delete $scope.changePwd.confirmPassword;
			var req = {};
			req.emailId = new URL(window.location.href).searchParams.get('emailId');
			req.password = md5.createHash($scope.changePwd.newPassword);
			$scope.formLoader = true;
			$http.post('../user/updatepassword',req).then(function(res){
				if(res){
					if(res.data.response==1){
						/* replace while deployment http://www.pioneercoders.com */
						$scope.formLoader = false;
						$scope.infoMsg = "password is updated successfully";
						 $scope.toggleBoolean('showpopup');
					}else{
						$scope.formLoader = false;
						$scope.infoMsg = "password is not updated try after some time";
					}
					$scope.changePasswordForm.$setPristine();
					$scope.changePwd = undefined;
				}else{
					$scope.formLoader = false;
					$scope.infoMsg = "password is not updated try after some time";
				}
			});
		};
		$scope.closePopup = function(){
			location.replace("http://www.pioneercoders.com");
		};
		$scope.toggleBoolean = function(prop) {
			$scope[prop]= !$scope[prop];
			
		};
	}]);
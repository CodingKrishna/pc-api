app.controller('companyCtrl',function($scope,desktopService,$timeout){
	$scope.disableButton = false;
	$scope.saveCompanyInfo =function(){
		if($scope.selectedFile){
			var type = $scope.selectedFile.type.split('/')[1];
		}
		$scope.company.logo = ($scope.company.companyName).concat('.').concat(type);
		desktopService.saveCompanyInfo($scope.company).then(function(res){
			if(res) {
				$scope.uploadCompanyLogo($scope.company.companyName);
				//$scope.companiesList.push(res);
				$scope.getAllCompaniesList();
				$scope.company = {};
				$scope.companySucMsg = "Company Added Successfully";
				$scope.disableButton = true;
				$timeout(function(){
					$scope.companySucMsg = undefined;
					$scope.disableButton = false;
					$scope.toggleBoolean('showPopup');
					
				},3000);
			}else{
				$scope.companySucMsg = "Error While Saving Company Details";
			}
		});
	};
	
	$scope.getAllCompaniesList =function(){
		desktopService.getAllCompaniesList().then(function(res){
			if(res) {
				$scope.companiesList =res.res;
				
			}else{
				$scope.msg = "No Companies Available..";
			}
		});
	};
	
	// toggle function to toggle the views
	$scope.toggleBoolean = function(prop) {
		$scope[prop]= !$scope[prop];
	};
	
	$scope.selectUpload =function(selectedFile,event){
		$scope.selectedFile = selectedFile;
		if($scope.selectedFile){
			$scope.infoMsg = "uploaded Successfully";
		}else {
			$scope.infoMsg = "Please Choose the File first";
		}
	};
	$scope.togglePopup = function(prop) {
		$scope[prop]= !$scope[prop];
	};
	$scope.uploadCompanyLogo = function (name) {
		if(!$scope.uploadingFile) {
			if($scope.selectedFile) {
				$scope.uploadingFile = "Uploading logo successfully " + $scope.selectedFile.name;
				desktopService.uploadLogo($scope.selectedFile,name).then(function() {
					$scope.togglePopup('$infoMsg');
					$scope.infoMsg = 'Uploaded Successfully';
					$scope.uploadingFile = null;
					$scope.selectedFile = null;
				}, function(error) {
					$scope.uploadingFile = null;
					/*console.error(error);*/
					$scope.infoMsg = 'Upload failed, Please try again';
					$scope.togglePopup('$infoMsg');
				});
			} else {
				$scope.togglePopup('$infoMsg');
				$scope.infoMsg = 'No File selected';
				window.setTimeout(function() {
					$scope.uploadingFile = null;
				}, 100);
			}
		}
		/*console.log(selectedFile, projectName, event);*/
	};
	
	$scope.getAllCompaniesList();
});
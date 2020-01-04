var app = angular.module('pcAdminModule');
app.controller('expendatureListCtrl', function($scope,$http,$timeout,userService) {
	$scope.init=function(){
		$scope.exp={};	
		$scope.expendaturesList = [];
		$scope.getAllExpendature();
	};
	
	// toggle function to toggle the views
	$scope.toggleBoolean = function(prop) {
		$scope[prop]= !$scope[prop];
	};
	
	$scope.showExpForm = function(){
		$scope.toggleBoolean('expForm');
	};
	
	$scope.addExpendature = function(){
		$scope.exp.billPath = $scope.selectedFileBill.name;
		$http.post('expendature/addexpendature',$scope.exp).then(function(res){
			if(res.data.isSuccess) {
				$scope.uploadBill();
				$scope.expendaturesList.push($scope.exp);
				$scope.toggleBoolean('expForm');
				$scope.successMsg = "Successfully Added";
				$timeout(function(){
					$scope.successMsg = undefined;
				},3000);
			}
		});
	};
	
	$scope.getAllExpendature= function() {
		$http.get('expendature/expendatureslist').success(function(res){
			if(res.isSuccess) {
				if(res.response!=null){
					$scope.expendaturesList = res.response;
				}else{
					$scope.msg = "No data is Available.";
				}
			}
		});
	};
	
	$scope.selectUpload =function(selectedFile,path,event){
		$scope.selectedFile = selectedFile;
		var list = $scope.selectedFile.name.split(".");
		var fileExt = list[list.length-1];
		if($scope.selectedFile){
			$scope.infoMsg = "uploaded Successfully";
		}else {
			$scope.infoMsg = "Please Choose the File first";
		}
	};
	
	$scope.selectUploadBill =function(selectedFileBill,path,event){
		$scope.selectedFileBill = selectedFileBill;
		if($scope.selectedFileBill){
			$scope.infoMsg = "uploaded Successfully";
		}else {
			$scope.infoMsg = "Please Choose the File first";
		}
	};
	
	$scope.uploadBill= function () {
		if(!$scope.uploadingFile) {
			$scope.uploadingFile = "Uploading Bill successfully " + $scope.selectedFileBill.name;
			if($scope.selectedFileBill) {
				userService.uploadBill($scope.selectedFileBill,$scope.selectedFileBill.name).then(function() {
					$scope.toggleBoolean('$infoMsg');
					$scope.infoMsg = 'Uploaded Successfully';
					$scope.uploadingFile = null;
					$scope.selectedFileBill = null;
				}, function(error) {
					$scope.uploadingFile = null;
					/*console.error(error);*/
					$scope.infoMsg = 'Upload failed, Please try again';
					$scope.toggleBoolean('$infoMsg');
				});
			} else {
				$scope.togglePopup('$infoMsg');
				$scope.infoMsg = 'No File selected';
				window.setTimeout(function() {
					$scope.uploadingFile = null;
				}, 100);
			}
		}
	};
	
	
	$scope.init();
});
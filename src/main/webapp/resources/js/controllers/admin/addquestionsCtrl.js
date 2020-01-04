var app = angular.module('pcAdminModule');
app.controller('addquestionsCtrl', function($scope,$http,$timeout,adminService,userService) {
	var defObj= {"option":""};
	var defCodingTestQstnObj= {"input":"","output":""};
	$scope.init=function(){
		$scope.techologyList = ["JAVA","CSS","HTML"];
		$scope.quesTypeList = ["choice","code"];
		$scope.optionData = [angular.copy(defObj)];
		$scope.question = {"options":[]};
		
		$scope.codingTestQtn = {testCases:[angular.copy(defCodingTestQstnObj)]};
		$scope.taskTechologyList = ["JAVA","UI","J2EE"];
		$scope.form = {};
		
	};
	
	$scope.addInput = function(text){
		if(text=='option'){
			$scope.optionData.push(angular.copy(defObj));
		}else {
			$scope.codingTestQtn.testCases.push(angular.copy(defCodingTestQstnObj));
		}
	};

	$scope.removeOption= function(index,text) {
		if(text=='option'){
			$scope.optionData.splice(index,1);
		}else {
			$scope.codingTestQtn.testCases.splice(index,1)
		}
	};
	
	$scope.addQuestions = function(){
		for(var j=0;j<$scope.optionData.length;j++){
			$scope.question.options[j] = $scope.optionData[j].option;
		}
		console.log($scope.question.options);
		$http.post('exam/create',$scope.question).then(function(res){
			if(res.data.isSuccess) {
				$scope.question = undefined;
				$scope.successMsg = "Successfully Added";
				$scope.toggleBoolean('showPopup');
			}
		});
	};
	// toggle function to toggle the views
	$scope.toggleBoolean = function(prop) {
		$scope[prop]= !$scope[prop];
	};
	/*add coding questions*/
	$scope.submitCodingTestQtn = function(){
		var req = angular.copy($scope.codingTestQtn);
		req.testCases = angular.toJson(req.testCases);
		adminService.submitCodingTestQtn(req).then(function(res){
			if(res.isSuccess) {
				$scope.successMsg = "Successfully Added";
				$scope.toggleBoolean('showPopup');
				$scope.codingTestQtn ={};
				$scope.codingTestQtn.testCases= [];
				$scope.codingTestQtn.testCases.push(angular.copy(defCodingTestQstnObj));
				$scope.form.codingQtnForm.$setPristine();
			}
		});
	};
	
	
	$scope.addTask = function(){
		var imageActualPath = $scope.selectedFileImage.name.split('.');
		$scope.task.imagePath = imageActualPath[0]+"/"+imageActualPath[1];
		$http.post('interntask/add',$scope.task).then(function(res){
			if(res.data.isSuccess) {
				$scope.uploadImage();
				$scope.successMsg = "Successfully Added";
				$scope.task = undefined;
				$scope.form.addTaskForm.$setPristine();
				$timeout(function(){
					$scope.successMsg = undefined;
				},3000);
			};
		});
	};
	
	$scope.selectUploadImage =function(selectedFileImage,path,event){
		$scope.selectedFileImage = selectedFileImage;
		if($scope.selectedFileImage){
			$scope.infoMsg = "uploaded Successfully";
		}else {
			$scope.infoMsg = "Please Choose the File first";
		}
	};
	
	$scope.uploadImage= function () {
		if(!$scope.uploadingFile) {
			$scope.uploadingFile = "Uploading Image successfully " + $scope.selectedFileImage.name;
			if($scope.selectedFileImage) {
				userService.uploadImage($scope.selectedFileImage,$scope.selectedFileImage.name).then(function() {
					$scope.infoMsg = 'Uploaded Successfully';
					$scope.uploadingFile = null;
					$scope.selectedFileImage = null;
				}, function(error) {
					$scope.uploadingFile = null;
					console.error(error);
					$scope.infoMsg = 'Upload failed, Please try again';
					$scope.toggleBoolean('$infoMsg');
				});
			} else {
				$scope.infoMsg = 'No File selected';
				window.setTimeout(function() {
					$scope.uploadingFile = null;
				}, 100);
			}
		}
	};
	
	$scope.init();
});
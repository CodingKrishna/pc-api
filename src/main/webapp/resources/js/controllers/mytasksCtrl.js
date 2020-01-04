angular.module('pcModule').controller('mytasksCtrl', function($scope, commonService,$http) {
	$scope.init = function() {
		$scope.myTasksTemplates = {};
		$scope.getInternTaskTemplate('UI');
		$scope.getLogUserInfo();
	};
	
	$scope.getLogUserInfo = function(){
		commonService.getLogUserInfo("userInfo").then(function(res){
			if(res){
				$scope.loggedInUser = res;
				$scope.getInternTasksListByUserId($scope.loggedInUser.id);
				//$scope.getQuizResultsByUserId();
				
			}
		});
	};

	$scope.getInternTaskTemplate = function(language) {
		$http.get('interntask/list?technology='+language).success(function(res){
			if(res.isSuccess) {
				if(res.response!=null){
					$scope.myTasksTemplates[language] = res.response;
					for(var i=0;i<$scope.myTasksTemplates[language].length;i++){
						$scope.myTasksTemplates[language][i].images = [];
						if($scope.myTasksTemplates[language][i].imagePath!=undefined){
							var images = $scope.myTasksTemplates[language][i].imagePath.split('@@');
							for(var j=0;j<images.length;j++){
								$scope.myTasksTemplates[language][i].images.push(images[j]);
							}
						}
					}
				}else{
					$scope.msg = "No data is Available.";
				}
			}
		});
	};
	
	$scope.getInternTasksListByUserId = function(id){
		$scope.internTask = {};
		$http.get('interntask/interntaskslistbyuserid?userId='+id).success(function(res){
			if(res.isSuccess) {
				if(res.response){
					for(var i=0;i<res.response.length;i++){
						res.response[i].images = [];
						if(res.response[i].imagePath!=undefined){
							var images = res.response[i].imagePath.split('@@');
							for(var j=0;j<images.length;j++){
								res.response[i].images.push(images[j]);
							}
						}
					}
					res.response.forEach(function(task) {
						if (!$scope.internTask[task.technology]) {
							$scope.internTask[task.technology] = [];
					    }
						$scope.internTask[task.technology].push(task);
					});
					
					
				}else{
					$scope.msg = "No tasks are assigned";
				}
			}
		});
	};
	
	$scope.uploadMyTaskFile = function (selectedFile, projectName, event) {
		/*Save the filePath in db*/
		$scope.obj = {};
		$scope.obj.user  = {};
		$scope.obj.fileName = projectName+"."+selectedFile.name.split('.')[1];
		$scope.obj.user.id = $scope.loggedInUser.id;
		$http.post('interntask/addinternfiles',$scope.obj).success(function(res){
			if(res.isSuccess) {
				if(!$scope.uploadingFile) {
					$scope.uploadingFile = "Uploading File for Task: " + projectName;
					if(selectedFile) {
						commonService.uploadTaskFile(selectedFile, projectName,$scope.loggedInUser.id+'-'+$scope.loggedInUser.userName).then(function() {
							$scope.togglePopup('$infoMsg');
							$scope.infoMsg = 'Uploaded Successfully';
							$scope.uploadingFile = null;
							selectedFile = null;
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
			}
		});
		
		/*console.log(selectedFile, projectName, event);*/
	};
	
	$scope.togglePopup = function(name) {
		$scope.openedPopup = (name) ? (($scope.openedPopup === name) ? null : name) : null;  
	};
	
	$scope.init();
	
});

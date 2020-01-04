
angular.module('pcModule').controller('casesheetCtrl',function($scope,$http, commonService) {
	$scope.init=function(){
		$scope.caseStudiesTemplates = {};
		$scope.getCaseSheetTemplate('html');
		$scope.getCaseSheetTemplate('css');
		$scope.getCaseSheetTemplate('js');
		$scope.getCaseSheetTemplate('programming');
	};
	$scope.getCaseSheetTemplate=function(language){
		commonService.getCaseSheetTemplate(language).then(function(template) {
			$scope.caseStudiesTemplates[language] = template;
		}, function(error) {
			console.error(error);
		});
	};
	
	$scope.uploadMyTaskFile = function (selectedFile, projectName, event) {
		if(!$scope.uploadingFile) {
			$scope.uploadingFile = "Uploading File for Task: " + projectName;
			if(selectedFile) {
				commonService.uploadCaseStudiesFile(selectedFile, projectName,$scope.user.id+'-'+$scope.user.userName).then(function() {
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
		/*console.log(selectedFile, projectName, event);*/
	};
	
	$scope.togglePopup = function(name) {
		$scope.openedPopup = (name) ? (($scope.openedPopup === name) ? null : name) : null;  
	};
	
	commonService.getLogUserInfo('userInfo').then(function(res) {
		$scope.init(res);
		$scope.user=res;
	}, function(error) {
		console.error(error);
	});
	
	/*$scope.onFileSelect = function(ele) {
		$scope.selectedFile = ele.files[0];
		var fd = new FormData();
		fd.append('file', $scope.selectedFile);
		console.log(fd);
		$http.post("upload", fd, {
			transformRequest: angular.identity,
			headers: {'Content-Type': undefined}
		}).success(function(res) {
			console.info(res);
			$scope.response = res.response;
        }).error(function(error) {
        	console.error(error);
        });
	};*/
	$scope.init();
});

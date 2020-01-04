var adminApp = angular.module('pcAdminModule');
adminApp.controller('usersCtrl', function($scope, $http, $state, $rootScope, $timeout, commonService, userService, adminService,desktopService,studentDetailsService) {
	
	$scope.dateObj = {};
	$scope.sms = {"data":""};
	$scope.ratingList = [{id:1,value:"Excellent"},{id:2,value:"Good"},{id:3,value:"Average"},{id:3,value:"Need Improvment"}];
	$scope.selectedRating = {};
	$scope.selectAll = {};
	$scope.usersList = {"Pending":[],"Active":[],"InterviewReshedule":[],"Outsourcing":[]};
	$scope.smsToUsers = {mobileNo:[],emailIds:[]};
	$scope.smsToUser = {filePath:""};
	$scope.filesList = [{id:1,purpose:"Internship",filePath:"InternRegister"},{id:2,purpose:"Interview",filePath:"InternRegister"},{id:3,purpose:"Training",filePath:"InternRegister"}];
	$scope.totalSkillsList = [];
	$scope.communicationSkillsList = [];
	$scope.programmingSkillsList = [];
	$scope.attitudeCommentsList = [];
	$scope.logicalSkillsList = [];
	$scope.stuIntStatus = {};
	$scope.currentPanel = 'facetoface';
	$scope.internTask = {};
	$scope.task = {};
	
	var defObj= {"option":""};
	var defCodingTestQstnObj= {"input":"","output":""};
	
	$scope.codingTestQtn = {testCases:[angular.copy(defCodingTestQstnObj)]};
	$scope.taskTechologyList = ["JAVA","UI","J2EE"];
	$scope.form = {};
	$scope.languagesList = ["C","JAVA"];

	/*complete user Profile */
	$scope.studentInfo = {};
	$scope.student = {};
	$scope.form = {};
	$scope.coursesBgColors =["bg-color-1","bg-color-2","bg-color-3","bg-color-4"];
	//$scope.candidateProfile = JSON.parse(sessionStorage.getItem('profile'));
	
	/*complete user Profile End*/
	
	$scope.getRolesList = function() {
		userService.getAllRoles().then(function(res) {
			$scope.rolesList = res;
			$scope.rolesList.forEach(function(role) {
				if(role!=null){
					$scope.usersList[role.roleName] = [];
					$scope.selectAll[role.roleName] = false;
				}
			});
			$scope.getUsersList();
		}, function(error) {
			console.error(error);
		});
	};	
	$scope.getUsersList = function() {
		userService.getUsersList('all').then(function(res) {
			res.forEach(function(user) {
				if(user.status == 'PENDING'){
					$scope.usersList.Pending.push(user);
				}else{
					if(user.role!=null){
						$scope.usersList[user.role.roleName].push(user);
						if(user.reShedule!=null){
							$scope.usersList.InterviewReshedule.push(user);
						}
					}
				}
				if(user!=null){
					$scope.usersList.Active.push(user);
				}
			});
		}, function(error) {
			console.error(error);
		});
		
		adminService.getUsersByFeedBackGoodOrExcellent().then(function(res){
			if(res.isSuccess) {
				$scope.usersList.Outsourcing = res.response;
			}
		});
		
		
	};
	
	$scope.updateSelected = function(listType, allChanged) {
		if(allChanged) {
			angular.forEach($scope.usersList[listType], function(user) {
				user.selected = $scope.selectAll[listType];
			});
		} else {
			var selectedCount = $scope.getSelectedUsers(listType).length;
			$scope.selectAll[listType] = selectedCount === $scope.usersList[listType].length;

		}
	};
	
	$scope.getSelectedUsers = function(listType){
		var selectedUsers = [];
		angular.forEach($scope.usersList[listType], function(user) {
			if(user.selected) {
				selectedUsers.push(user);
			}
		});
		return selectedUsers;
	};
	
	$scope.getSelectUser = function(user){
		var selectedUser = [];
		if(user!=null) {
			selectedUser.push(user);
		}
		return selectedUser;
	};
	
	$scope.openApprovePopup = function(users) {
		// if object user is changed as array;
		if(!users.length) {
			$scope.aboutToApproveUsers = [$scope.aboutToApproveUsers];
		} else {
			$scope.aboutToApproveUsers = users;
		}
		$scope.togglePopup('$approveUser');
	};
	
	$scope.sendMessagesToAllUsers = function(users){
		if(!users.length) {
			$scope.bulkMessages = [$scope.bulkMessages];
		} else {
			$scope.bulkMessages = users;   
			for(var i=0;i<users.length;i++){
				$scope.smsToUsers.mobileNo.push(users[i].mobileNo);
				$scope.smsToUsers.emailIds.push(users[i].emailId);
			}
		}
		$scope.togglePopup('$bulkMessages');
	};
	
	$scope.sendSMSToAll = function(key){
		if(key == 'sms'){
			$scope.smsToUsers.emailIds = undefined;
		}if(key == 'mail'){
			$scope.smsToUsers.mobileNo = undefined;
		}
		userService.sendSMSToAllUsers($scope.smsToUsers).then(function(res) {
		}, function(error) {
			console.error(error);
		});
	};

	$scope.activateUsers = function(selectedRole) {
		var userIds = $scope.aboutToApproveUsers.map(function(user) {
			return user.id;
		});
		userService.updateStatusAndRoleForUsers(userIds, selectedRole, "ACTIVE").then(function() {
			$scope.getRolesList();
		}, function(error) {
			console.error(error);
		});
		$scope.togglePopup();
	};
	
	$scope.togglePopup = function(popupName) {
		$scope.showPopup = popupName;
	};

	$scope.updateStatus = function(obj, status) {
		obj.status = status;
		userService.updateUserStatus(obj).then(function(res) {
			if (res.isSuccess) {
				$scope.updateStatusMsg = "Success";
				$scope.toggleBoolean('showPopup');
			} else {
				$scope.updateStatusMsg = "Failed";
			}
		}, function(err) {
			$scope.updateStatusMsg = "Failed";
		});
	};

	$scope.toggleRejectPopup =function(users){
		// if object user is changed as array;
		if(!users.length) {
			$scope.aboutToApproveUsers = [$scope.aboutToApproveUsers];
		} else {
			$scope.aboutToApproveUsers = users;
		}
		$scope.togglePopup('$rejectUser');
	};
	
	$scope.rejectUsers = function(selectedRole) {
		var userIds = $scope.aboutToApproveUsers.map(function(user) {
			return user.id;
		});
		userService.updateStatusAndRoleForUsers(userIds, selectedRole, "REJECT").then(function() {
			$scope.getUsersList();
		}, function(error) {
			console.error(error);
		});
	};
	
	$scope.toggleSmsPopup =function(users){
		//if object user is changed as array;
		$scope.user = users;
		if(!users.length) {
			$scope.aboutToApproveUsers = [$scope.aboutToApproveUsers];
		} else {
			$scope.aboutToApproveUsers = users;
		}
		$scope.togglePopup('$smsUser');
	};
	
	$scope.	updateInterviewStatus =function(users,sliderName){
		// if object user is changed as array;
		$scope.user = users;
		$scope.getUserCompleteData($scope.user.id);
		if(!users.length) {
			$scope.aboutToApproveUsers = [$scope.aboutToApproveUsers];
		} else {
			$scope.aboutToApproveUsers = users;
		}
		$scope.getInterviewDetailsByUserId($scope.user.id);
		$scope.getOnlineExamResultsByUserId($scope.user.id);
		$scope.currentPanel = sliderName;
		$scope.shwowQuestions = 'slide-page-left';
	};
	
	$scope.sendSmsUserToUser = function() {
		userService.sendSMSToUser($scope.sms.data,$scope.user.mobileNo).then(function(res) {
			if(res){
				if(res.data.response!=null){
					if(res.data.response.length>20){
						$scope.errorMsg = "Msg is not sent because of insufficient messages";
						$timeout(function(){
							$scope.errorMsg=undefined;	
							$scope.togglePopup();
						},6000);
						
					}else{
						$scope.successMsg = "Msg is sent successfully";
						$timeout(function(){
							$scope.successMsg=undefined;	
							$scope.togglePopup();
						},6000);
					}
					
				}else{
					$scope.errorMsg = "Msg is not sent because of n/w";
					$scope.togglePopup();
					$timeout(function(){
						$scope.errorMsg=undefined;	
						$scope.togglePopup();
					},6000);
				}
			} 
		}, function(error) {
				console.error(error);
			});
	};
	
	$scope.toggleMailPopup =function(users){
		//if object user is changed as array;
		$scope.user = users;
		if(!users.length) {
			$scope.aboutToApproveUsers = [$scope.aboutToApproveUsers];
		} else {
			$scope.aboutToApproveUsers = users;
		}
		$scope.togglePopup('$mailUser');
	};
	
	$scope.sendMailToUser = function(){
		userService.sendMailToUser($scope.user.emailId,$scope.smsToUser.filePath).then(function(res) {
			if(res){
				console.log(res);
			} 
		}, function(error) {
				console.error(error);
			});
	};
	
	$scope.updateInterviewStatusDetails = function(){
		userService.updateInterviewDetails($scope.user.id,$scope.obj.interviewStatus,$scope.obj.reShedule,$scope.obj.interviewDate,$scope.obj.interviewTiming).then(function(res) {
			if(res){
				$scope.successMsg = "Successfully Updated";
				$timeout(function(){
					$scope.successMsg = undefined;
				},4000);
			} 
		}, function(error) {
				console.error(error);
			});
	};
	
	//Handler for Retrieving users visibility 
	 $scope.getUserCompleteData = function(id){
		 $scope.obj = {};
		 commonService.getUserCompleteData(id).then(function(res){
			if(res.user) {
				console.log(res.user);
				$scope.obj.interviewStatus = res.user.interviewStatus;
				if(res.user.reShedule == true){
					$scope.obj.reShedule = "true";
					
				}
				if(res.user.interviewDate){
					var a = Number( res.user.interviewDate);
					var date = new Date(a);
					$scope.obj.interviewDate = date;
				}else{
					$scope.obj.interviewDate = new Date();
				}
				$scope.obj.interviewTiming = res.user.interviewTiming;
			}
		 });
	 };
	
	$scope.toggleBoolean = function(state) {
		$scope[state] = !$scope[state];
	};
	
	$scope.changePanel = function(currentStatusPanel){
		$scope.currentStatusPanel = currentStatusPanel;
	};
	
	$scope.getOnlineExamResultsByUserId = function(userId) {
		userService.getOnlineExamResultsByUserId(userId).then(function(res){
		if(res.isSuccess) {
			$scope.onlineExaResultList = res.response;
			console.log($scope.onlineExaResultList);
			}
		});
	};
	
	$scope.getTotalSkillsList = function(){
		userService.getTotalSkillsList().then(function(res){
			if(res.data.isSuccess){
				$scope.totalSkillsList= res.data.response;
			}
			if($scope.totalSkillsList){
				for(var i =0;i<$scope.totalSkillsList.length;i++){
					if($scope.totalSkillsList[i].type=='Communication'){
						$scope.communicationSkillsList.push($scope.totalSkillsList[i]);
					}if($scope.totalSkillsList[i].type=='Attitude'){
						$scope.attitudeCommentsList.push($scope.totalSkillsList[i]);
					}if($scope.totalSkillsList[i].type=='Logical'){
						$scope.logicalSkillsList.push($scope.totalSkillsList[i]);
					}if($scope.totalSkillsList[i].type=='Programming'){
						$scope.programmingSkillsList.push($scope.totalSkillsList[i]);
					}
				}
			}
		});
	};
	
	$scope.saveOrUpdateStuFeedBack = function(){
		$scope.stuIntStatus.user = {};
		$scope.stuIntStatus.user.id = $scope.user.id;
		userService.saveOrUpdateStudentFeedBack($scope.stuIntStatus).then(function(res){
			if(res.data.isSuccess){
				$scope.successMsg = "Details are updated...";
				$timeout(function(){
					$scope.successMsg = undefined;
				},2000);
			}else{
				$scope.errorMsg = "Details not updated";
				$timeout(function(){
					$scope.errorMsg = undefined;
				},2000);
			}
		});
		window.location.reload(true);
	};
	
	$scope.getInterviewDetailsByUserId = function(id){
		userService.getFeedBackDetailsByUserId(id).then(function(res){
			if(res.data.isSuccess){
				if(res.data.response){
					$scope.stuIntStatus = res.data.response;
				}else{
					$scope.stuIntStatus = undefined;
				}
			}
		});
	};
	
	$scope.getAllQuestions = function(){
		userService.getAllQuestions().then(function(res){
			if(res.data.isSuccess){
				$scope.codingQuestionsList = res.data.response;		
			}
		});
	};
	
	$scope.assignCodingTest = function(user,sliderName){
		$scope.getAllQuestions();
		$scope.codingQstns = {"user":{id:user.id}};
		$scope.currentPanel = sliderName;
		$scope.shwowQuestions = 'slide-page-left';
	};
	
	$scope.assignCoddingQstns = function(){
		$scope.codingQstns.selected = [];
		for(var i=0;i<$scope.codingQuestionsList.length;i++){
			if($scope.codingQuestionsList[i].selected==true){
				$scope.codingQstns.selected.push($scope.codingQuestionsList[i].id);
			}
		}
		userService.assingCodingTesyQuestionToUsers($scope.codingQstns.user.id,$scope.codingQstns.selected).then(function(res){
			if(res.data.isSuccess){
				if(res.data.response>0){
					$scope.successMsg = "Questions Assigned Successfully..";
					$timeout(function(){
						$scope.successMsg=undefined;
					},2000);
				}else{
					$scope.errorMsg = "Error occured while Assinging Questions.";
					$timeout(function(){
						$scope.errorMsg = undefined;
					},2000);
				}
			}
		});
	};
	
	$scope.getAllTechnologies = function(){
		userService.getAllTechnologiesList().then(function(res){
			if(res.data.isSuccess){
				$scope.technologiesList = res.data.response;		
			}
		});
	};
	
	$scope.assignTechnologyToUser = function(user,sliderName){
		$scope.getAllTechnologies();
		$scope.technologies = {"user":{id:user.id}};
		$scope.shwowQuestions = 'slide-page-left';
		$scope.currentPanel = sliderName;
	};
	
	$scope.assigningTechonologies = function(){
		$scope.technologies.selected = [];
		for(var i=0;i<$scope.technologiesList.length;i++){
			if($scope.technologiesList[i].selected==true){
				$scope.technologies.selected.push($scope.technologiesList[i].id);
			}
		}
		userService.assinginTechnologiesToUsers($scope.technologies.user.id,$scope.technologies.selected).then(function(res){
			if(res.data.isSuccess){
				if(res.data.response>0){
					$scope.successMsg = "Technology Assigned Successfully..";
					$timeout(function(){
						$scope.successMsg = undefined;
					},2000);
				}else{
					$scope.errorMsg = "Error occured while Assinging Technology.";
					$timeout(function(){
						$scope.errorMsg = undefined;
					},2000);
				}
			}
		});
	};
	
	$scope.assigningTasksToUser =function(users,sliderName){
		// if object user is changed as array;
		$scope.user = users;
		userService.getAllInternTasksList().then(function(res){
			if(res.data.isSuccess){
				if(res.data.response){
					res.data.response.forEach(function(task) {
						if (!$scope.internTask[task.technology]) {
							$scope.internTask[task.technology] = [];
					    }
						$scope.internTask[task.technology].push(task);
					});
				}else{
					$scope.msg = undefined;
				}
			}
		});
	//	$scope.togglePopup('$assingTasksToUser');
		$scope.intrTasks = {"user":{id:$scope.user.id}};
		$scope.shwowQuestions = 'slide-page-left';
		$scope.currentPanel = sliderName;
		
	};
	
	$scope.assigningTasks = function(data){
		$scope.intrTasks.selected = [];
		for(var i=0;i<$scope.internTask[data].length;i++){
			if($scope.internTask[data][i].selected==true){
				$scope.intrTasks.selected.push($scope.internTask[data][i].id);
			}
		}
		userService.assigningTasksToUsers($scope.intrTasks.user.id,$scope.intrTasks.selected).then(function(res){
			if(res.data.isSuccess){
				if(res.data.response>0){
					$scope.successMsg = "Tasks Assined Successfully..";
					$scope.intrTasks = undefined;
				}else{
					$scope.errorMsg = "Error occured while Assinging Tasks.";
					$scope.intrTasks= undefined;
				}
				$timeout(function(){
					$scope.successMsg = undefined;
					$scope.errorMsg = undefined;
				},2000);
			}
		});
	};
	
	// slides to login form  from registration form
	$scope.slideToCoding = function() {
		$scope.internTask = {};
		$scope.shwowQuestions = 'slide-page-right';
		
	};
	
	// slides to registration  from login form
	$scope.slideToQuestions = function() {
		$scope.shwowQuestions = 'slide-page-left';
	};
	
	//Add Task Functionality..
	$scope.addQuestionPopup = function(){
		$scope.toggleBoolean('openQuestionsPopup');
	};
	
	$scope.addTask = function(){
		var imageActualPath = $scope.selectedFileImage.name.split('.');
		$scope.task.imagePath = imageActualPath[0]+"/"+imageActualPath[1];
		$http.post('interntask/add',$scope.task).then(function(res){
			if(res.data.isSuccess) {
				$scope.uploadImage();
				$scope.internTask[res.data.response.technology].push(res.data.response);
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

	$scope.addProgramingQuestion = function(){
		$scope.toggleBoolean('openProgramngQuestionsPopup');
	};
	
	//add programming questions functionality...

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
			$scope.codingTestQtn.testCases.splice(index,1);
		}
	};
	
	$scope.submitCodingTestQtn = function(){
		var req = angular.copy($scope.codingTestQtn);
		req.testCases = angular.toJson(req.testCases);
		adminService.submitCodingTestQtn(req).then(function(res){
			if(res.isSuccess) {
				$scope.successMsg = "Successfully Added";
				$scope.codingQuestionsList.push(res.response);
				$timeout(function(){
					$scope.successMsg = undefined;
				},3000);
				$scope.codingTestQtn ={};
				$scope.codingTestQtn.testCases= [];
				$scope.codingTestQtn.testCases.push(angular.copy(defCodingTestQstnObj));
				$scope.form.codingQtnForm.$setPristine();
			}
		});
	};
	
	$scope.toggleInterviewReshedulePopup =function(users){
		//if object user is changed as array;
		$scope.user = users;
		if(!users.length) {
			$scope.aboutToApproveUsers = [$scope.aboutToApproveUsers];
		} else {
			$scope.aboutToApproveUsers = users;
		}
		$scope.togglePopup('$interviewReshedule');
		
		$scope.data = $scope.getUserCompleteData($scope.user.id);
		
	};
	
/*	// toggle function to toggle the views
	$scope.toggleBoolean = function() {
		$scope.togglePopup();
	};*/
	
	$scope.showUserProfile = function(user,sliderName){
		$scope.shwowQuestions = 'slide-page-left';
		$scope.currentPanel = sliderName;
		userService.getUserData(user.id).then(function(res) {
			$scope.candidateProfile = res;
			
		});	
		if($scope.candidateProfile.userBasicInfo){
			if($scope.candidateProfile.userBasicInfo.languages) {
				$scope.candidateProfile.userBasicInfo.languages = JSON.parse($scope.candidateProfile.userBasicInfo.languages);
			}
			$scope.userAge = new Date().getFullYear()-new Date($scope.candidateProfile.userBasicInfo.dob).getFullYear();
		}
		if($scope.candidateProfile.work) {
			for(var i=0;i<$scope.candidateProfile.work.workExp.length;i++) {
				if($scope.candidateProfile.work.workExp[i].employerstatus == 'Current Employer') {
					$scope.currentEmployer = $scope.candidateProfile.work.workExp[i];
				}
			}
		}
		$scope.studentInfo.name = angular.copy($scope.candidateProfile.user.userName);
		$scope.studentInfo.emailId = angular.copy($scope.candidateProfile.user.emailId);
		$scope.student.name = angular.copy($scope.candidateProfile.user.userName);
		$scope.student.mobileNo = angular.copy($scope.candidateProfile.user.mobileNo);
		$scope.checkLogin();
	};
	
	/*complete user profile */
	$scope.checkLogin=function(){
		commonService.getLogUserInfo('userInfo').then(function(res){
			$scope.loggedInUser = res;
		},function(err){
			$scope.loggedInUser = null;
			$scope.changeState('home');
		});
	};
	$scope.sendEmail = function() {
		studentDetailsService.sendEmail($scope.studentInfo).then(function(res){
			if(res) {
				$scope.mailSuccessMsg = "Mail Sent Successfully";
				$scope.studentInfo = {};
				$scope.form.emailForm.$setPristine();
			}
		});
	};
	
	$scope.sendSms = function() {
		studentDetailsService.sendSms($scope.student).then(function(res){
			if(res) {
				$scope.smsSuccessMsg = "SMS Sent Successfully";
				$scope.student ={};
				$scope.form.smsForm.$setPristine();
			}
		});
	};
	$scope.shortList = function() {
		$scope.getJobsListByHrId();
		$scope.toggleBoolean('showPopup');
	};
	$scope.getJobsListByHrId =function(){
		$scope.list = true;
		desktopService.getJobsListByHrId($scope.loggedInUser.id).then(function(res){
			if(res) {
				$scope.jobsList = res;
			}else{
				$scope.msg = "Jobs list is not available";
			}
		});
	};
	$scope.shortListCandidate = function(job) {
		desktopService.viewShortListedCandidates(job.id).then(function(res){
			if(res){
				var studentsList = res;
				if(studentsList.length) {
					for(var i=0;i<studentsList.length;i++) {
						if(studentsList[i].studentId == $scope.candidateProfile.user.id) {
							return alert("You have already shortlisted this candidate for job "+ job.jobTitle);
						}
					};
					var shortListedObj = {};
					shortListedObj.job = {};
					shortListedObj.job.id = job.id;
					shortListedObj.studentId = $scope.candidateProfile.user.id;
					desktopService.shortListCandidate(shortListedObj).then(function(res){
						if(res) {
							
							$scope.toggleBoolean('showPopup'); 
						}
					});
				} else {
					var shortListedObj = {};
					shortListedObj.job = {};
					shortListedObj.job.id = job.id;
					shortListedObj.studentId = $scope.candidateProfile.user.id;
					desktopService.shortListCandidate(shortListedObj).then(function(res){
						if(res) {
							
							$scope.toggleBoolean('showPopup'); 
						}
					});
				}
			}
			
		});
	
		};
	/*complete user profile */
		
	/*download task functionality*/
		
	$scope.downLoadCompletedTasks =function(users,sliderName){
		$scope.user = users;
		userService.downLoadUploadedTasksByUserId($scope.user.id).then(function(res){
			if(res.data.isSuccess){
				if(res.data.response){
					$scope.filesList = res.data.response;
					for(var i=0;i<$scope.filesList.length;i++){
						var filePath = $scope.filesList[i].fileName.split('.')[0];
						var fileExtention = $scope.filesList[i].fileName.split('.')[1];
						$scope.filesList[i].filePath = filePath;
						$scope.filesList[i].extension = fileExtention;
					}
				}else{
					$scope.msg = undefined;
				}
			}
		});
		$scope.shwowQuestions = 'slide-page-left';
		$scope.currentPanel = sliderName;
	};
	
	/*download task functionality*/
		
	$scope.getRolesList();
	$scope.getTotalSkillsList();
});
angular.module("pcModule").service("userService",function($q, $http, $log, $filter){
	var self = this;
	self.registerUser = registerUser;
	self.getUsersList = getUsersList;
	self.updateUserStatus = updateUserStatus;
	self.getQuizResultsByUserId = getQuizResultsByUserId;
	self.getOnlineExamResultsByUserId = getOnlineExamResultsByUserId;
	self.getAllRoles = getAllRoles;
	self.updateStatusAndRoleForUsers = updateStatusAndRoleForUsers;
	self.updateUserVisisbility = updateUserVisisbility;
	self.getUserData = getUserData;
	self.getQuestionsForUsers = getQuestionsForUsers;
	self.updateUserAddress = updateUserAddress;
	self.updateEdcuationDetails = updateEdcuationDetails;
	self.deleteEducationDetails = deleteEducationDetails;
	self.updateProjectDetails =  updateProjectDetails;
	self.deleteProject = deleteProject;
	self.updateSkillsetDetails = updateSkillsetDetails;
	self.uploadProfilePic = uploadProfilePic;
	self.updateInterviewDetails = updateInterviewDetails;
	self.sendSMSToUser = sendSMSToUser;
	self.sendSMSToAllUsers = sendSMSToAllUsers; 
	self.sendMailToUser = sendMailToUser;
	self.updateSocialInfo = updateSocialInfo;
	self.getYears = getYears;
	self.updateWorkExp = updateWorkExp;
	self.deleteWorkExp = deleteWorkExp;
	self.updateUserBasicInfo = updateUserBasicInfo; 
	self.uploadResume = uploadResume;
	self.updateMobileNo =  updateMobileNo;
	self.uploadVedio = uploadVedio;
	self.updateTotalExp = updateTotalExp;
	self.uploadBill = uploadBill;
	self.uploadImage = uploadImage;
	self.getTotalSkillsList = getTotalSkillsList;
	self.saveOrUpdateStudentFeedBack = saveOrUpdateStudentFeedBack;
	self.getFeedBackDetailsByUserId = getFeedBackDetailsByUserId; 
	self.getAllQuestions = getAllQuestions;
	self.assingCodingTesyQuestionToUsers = assingCodingTesyQuestionToUsers;
	self.getAllTechnologiesList = getAllTechnologiesList;
	self.assinginTechnologiesToUsers = assinginTechnologiesToUsers;
	self.getAllInternTasksList = getAllInternTasksList;
	self.assigningTasksToUsers = assigningTasksToUsers;
	self.downLoadUploadedTasksByUserId = downLoadUploadedTasksByUserId;
	self.getTechList = getTechList;
	self.getLanguagesList = getLanguagesList;
	
	function registerUser(obj) {
    	var defer = $q.defer();
    	var config={
    			url:"user/add",
    			method: "POST",
    		    data:obj
    		};
    	$http(config).then(function(res) {
    		defer.resolve(res.data);
    	}, function(error) {
    		defer.reject(error);
    	});
    	return defer.promise;
    }
	function getUsersList(status) {
		var url = "user/getuser?list=true&status="+status;
		status = status || null;
    	var defer = $q.defer();
    	$http.get(url).then(function(res) {
    		if(res.data.isSuccess) {
    			defer.resolve(res.data.response);
    		} else {
    			defer.reject(res.data);
    		}
    	}, function(error) {
    		defer.reject(error);
    	});
    	return defer.promise;
    }
	
	function updateUserStatus(obj) {
    	var defer = $q.defer();
    	var config={
    			url:"user/updatestatus",
    			method: "POST",
    			data:obj
    		};
    	$http(config).then(function(res) {
    		defer.resolve(res.data);
    	}, function(error) {
    		defer.reject(error);
    	});
    	return defer.promise;
    }
	function getOnlineExamResultsByUserId(id) {
		var defer = $q.defer();
		var config = {
				url:"exam/examresultsbyprofileid?profileId="+id,
				method:"GET",
				data:id
		};
		$http(config).then(function(res){
			defer.resolve(res.data);
		}, function(error){
			defer.reject(error);
		});
		return defer.promise;
	}
	
	function getQuizResultsByUserId(id) {
		var defer = $q.defer();
		var config = {
				url:"user/quizlist?userId="+id,
				method:"GET",
				data:id
		};
		$http(config).then(function(res){
			defer.resolve(res.data);
		}, function(error){
			defer.reject(error);
		});
		return defer.promise;
	}
	
	function getAllRoles() {
		var defer = $q.defer();
		$http.get('user/roles').then(function(res) {
			if(!res.isSucess) {
				defer.resolve(res.data.response);
			} else {
				defer.reject(res.data);
			}
		}, function(error) {
			defer.reject(error);
		});
		return defer.promise;
	}
	
	function updateStatusAndRoleForUsers(userIds, selectedRole, status, interviewDate,interviewTiming) {
		var defer = $q.defer();
		if(interviewDate!=null){
			var newDate= interviewDate.getFullYear()+"-"+(interviewDate.getMonth()+1)+"-"+interviewDate.getDate();
		}
		var url = 'user/updatestatusandrole';
		$http.post(url, {
			userIds: userIds,
			selectedRole: selectedRole*1,
			status: status
		}).then(function(res) {
			if(res.data.isSuccess) {
				defer.resolve(res.data.response);
			} else {
				defer.reject(res.data.response);
			}
		}, function(error) {
			defer.reject(error);
		});
		return defer.promise;
	}
	
	
	
	function rejectUsers() {
		
	}
	
	function _transformUsersList(list) {
		var users = {};
		users.pending = $filter('filter')(list, {status: 'PENDING'});
		users.active = $filter('filter')(list, {status: 'ACTIVE'});
		users.all = JSON.parse(JSON.stringify(list));
		return users;
	}
	
	function updateUserVisisbility(isVisible,userId){
		var defer = $q.defer();
		$http.get('user/updateuserisvisible?isVisible='+isVisible+'&userId='+userId).then(function(res){
			if(res.data.isSuccess){
				defer.resolve(res.data.response);
			}else{
				defer.reject(res.data.response);
			}
		},function(error){
			defer.reject(error);
		});
		return defer.promise;
	}
	function getUserData(userId) {
		var defer = $q.defer();
		$http.get('user/completedata?userId=' + userId).then(function(response) {
			var res = response.data;
			if (res.isSuccess) {
				defer.resolve(res.response);
			} else {
				defer.reject(res);
			}
		}, function(error) {
			defer.reject(error);
		});
		return defer.promise;
	}
	
	function updateUserAddress(req) {
		var defer = $q.defer();
		$http.post('user/updateaddress', req).then(function(response) {
			// if falls in 200 category 
			var res = response.data;
			if (res.isSuccess) {
				defer.resolve(res);
			} else {
				// if falls in 200 category but isSuccess fails
				defer.reject(res);
			}
			
		}, function(error) {
			// if falls in 400 and 500 category 
			defer.reject(error);
		});
		return defer.promise;
	}
	
	function updateEdcuationDetails(req){
		var defer = $q.defer();
		var url = 'user/addeducation';
		$http.post(url, req).then(function(response) {
			var res = response.data;
			if (res.isSuccess) {
				defer.resolve(res.response);
			} else {
				defer.reject(res);
			}
		}, function(error) {
			defer.reject(error);
		});
		return defer.promise;
	}
	
	function deleteEducationDetails(userId,type){
		var defer = $q.defer();
		var url = 'user/deleteeducation?userId='+userId+'&eduType='+type;
		$http.get(url).then(function(response) {
			var res = response.data;
			if (res.isSuccess) {
				defer.resolve(res.response);
			} else {
				defer.reject(res);
			}
		}, function(error) {
			defer.reject(error);
		});
		return defer.promise;
	}
	
	function updateProjectDetails(req){
		var defer = $q.defer();
		var url = (req.id) ? 'user/updateproject' : 'user/addproject';
		req.projectInfo = JSON.stringify(req.projectInfo);
		
		$http.post(url, req).then(function(response) {
			var res = response.data;
			if (res.isSuccess) {
				defer.resolve(res.response);
			} else {
				defer.reject(res);
			}
		}, function(error) {
			defer.reject(error);
		});
		return defer.promise;
	}
	
	function deleteProject(userId,projectName){
		var defer = $q.defer();
		var url = 'user/deleteproject?userId='+userId+'&projectName='+projectName;
		$http.get(url).then(function(response) {
			var res = response.data;
			if (res.isSuccess) {
				defer.resolve(res.response);
			} else {
				defer.reject(res);
			}
		}, function(error) {
			defer.reject(error);
		});
		return defer.promise;
	}
	
	function updateSkillsetDetails(req){
		var defer = $q.defer();
		$http.post('user/addskills', req).then(function(response) {
			var res = response.data;
			if (res.isSuccess) {
				defer.resolve(res.response);
			} else {
				defer.reject(res);
			}
		}, function(error) {
			defer.reject(error);
		});
		return defer.promise;
	}
	
	function updateSocialInfo(req){
		var defer = $q.defer();
		var url = (req.id) ? 'user/updatesocialinfo' : 'user/addsocialinfo';
		$http.post(url, req).then(function(response) {
			var res = response.data;
			if (res.isSuccess) {
				defer.resolve(res.response);
			} else {
				defer.reject(res);
			}
		}, function(error) {
			defer.reject(error);
		});
		return defer.promise;
	}
	
	function updateWorkExp(req){
		var defer = $q.defer();
		var url = 'user/addemployerinfo';
		$http.post(url, req).then(function(response) {
			var res = response.data;
			if (res.isSuccess) {
				defer.resolve(res.response);
			} else {
				defer.reject(res);
			}
		}, function(error) {
			defer.reject(error);
		});
		return defer.promise;
	}
	
	function deleteWorkExp(userId,type){
		var defer = $q.defer();
		var url = 'user/deleteemployerinfo?userId='+userId+'&empType='+type;
		$http.get(url).then(function(response) {
			var res = response.data;
			if (res.isSuccess) {
				defer.resolve(res.response);
			} else {
				defer.reject(res);
			}
		}, function(error) {
			defer.reject(error);
		});
		return defer.promise;
	}
	
	function updateTotalExp(req){
		var defer = $q.defer();
		var url = (req.id) ? 'user/updateexperianceinfo' : 'user/addexperianceinfo';
		$http.post(url, req).then(function(response) {
			var res = response.data;
			if (res.isSuccess) {
				defer.resolve(res.response);
			} else {
				defer.reject(res);
			}
		}, function(error) {
			defer.reject(error);
		});
		return defer.promise;
	}
	function updateInterviewDetails(id,data,reShedule,interviewDate,interviewTiming){
		var defer = $q.defer();
		if(interviewDate!=null){
			var newDate= interviewDate.getFullYear()+"-"+(interviewDate.getMonth()+1)+"-"+interviewDate.getDate();
		}
		$http.get('user/updateinterviewstatus?interviewStatus='+data+'&userId='+id+'&reShedule='+reShedule+'&interviewDate='+newDate+'&interviewTiming='+interviewTiming).then(function(res){
			if(res.data.isSuccess){
				defer.resolve(res.data.response);
			}else{
				defer.reject(res.data.response);
			}
		},function(error){
			defer.reject(error);
		});
		return defer.promise;
	}
	
	function uploadProfilePic(picString, userId,userName) {
		var defer = $q.defer();
		$http.post('user/uploadprofilepic?userId=' + userId + '&userName=' + userName, picString).then(function(res) {
			defer.resolve(res);
		}, function(error) {
			defer.reject(error);
		});
		return defer.promise;
	}
	
	function sendSMSToUser(data,mobileNo){
		var defer = $q.defer();
		$http.get('user/sms?smsData='+data+'&mobileNo='+mobileNo).then(function(res) {
			defer.resolve(res);
		}, function(error) {
			defer.reject(error);
		});
		return defer.promise;
	}
	
	function sendMailToUser(emailId,filePath){
		var defer = $q.defer();
		$http.get('user/mail?emailId='+emailId+'&&filePath='+filePath).then(function(res) {
			defer.resolve(res);
		}, function(error) {
			defer.reject(error);
		});
		return defer.promise;
	}
	
	function getYears(startYear) {
        var currentYear = new Date().getFullYear(), years = [];
        startYear = startYear || 1980;

        while ( startYear <= currentYear ) {
                years.push(startYear++);
        } 

        return years;
	};
	
	function updateUserBasicInfo(obj) {
    	var defer = $q.defer();
    	var config={
    			url:'user/addbasicinfo',
    			method: "POST",
    		    data:obj
    		};
    	$http(config).then(function(res) {
    		defer.resolve(res.data);
    	}, function(error) {
    		defer.reject(error);
    	});
    	return defer.promise;
    }
	
	function uploadResume(file, name,folderName) {
		var defer = $q.defer();
		var fd = new FormData();
		fd.append('file', file);
		fd.append('name', name);
		fd.append('folderName',folderName);
		/*console.log(fd);*/
		$http.post("user/uploadresume", fd, {
			transformRequest: angular.identity,
			headers: {'Content-Type': undefined}
		}).then(function(res) {
			/*console.info(res.data);*/
			if(res.data.isSuccess) {
				defer.resolve(res.data.response);
			} else {
				defer.reject(res.data);
			}
		},function(error) {
			defer.reject(error);
		});
		return defer.promise;
	}
	
	function uploadVedio(file, name,folderName) {
		var defer = $q.defer();
		var fd = new FormData();
		fd.append('file', file);
		fd.append('name', name);
		fd.append('folderName',folderName);
		/*console.log(fd);*/
		$http.post("user/uploadvedio", fd, {
			transformRequest: angular.identity,
			headers: {'Content-Type': undefined}
		}).then(function(res) {
			/*console.info(res.data);*/
			if(res.data.isSuccess) {
				defer.resolve(res.data.response);
			} else {
				defer.reject(res.data);
			}
		},function(error) {
			defer.reject(error);
		});
		return defer.promise;
	}
	
	function sendSMSToAllUsers(data){
		var defer = $q.defer();
		$http.post("user/smstousers",data).then(function(res) {
			defer.resolve(res);
		}, function(error) {
			defer.reject(error);
		});
		return defer.promise;
	}
	function 	updateMobileNo(userId,mobileNo){
		var defer = $q.defer();
		$http.get("user/updatemobileno?mobileNo="+mobileNo+'&userId='+userId).then(function(res) {
			defer.resolve(res);
		}, function(error) {
			defer.reject(error);
		});
		return defer.promise;
	}
	
	function uploadBill(file, name) {
		var defer = $q.defer();
		var fd = new FormData();
		fd.append('file', file);
		fd.append('name', name);
		/*console.log(fd);*/
		$http.post("user/uploadbill", fd, {
			transformRequest: angular.identity,
			headers: {'Content-Type': undefined}
		}).then(function(res) {
			/*console.info(res.data);*/
			if(res.data.isSuccess) {
				defer.resolve(res.data.response);
			} else {
				defer.reject(res.data);
			}
		},function(error) {
			defer.reject(error);
		});
		return defer.promise;
	}
	
	function uploadImage(file, name) {
		var defer = $q.defer();
		var fd = new FormData();
		fd.append('file', file);
		fd.append('name', name);
		/*console.log(fd);*/
		$http.post("interntask/uploadimage", fd, {
			transformRequest: angular.identity,
			headers: {'Content-Type': undefined}
		}).then(function(res) {
			/*console.info(res.data);*/
			if(res.data.isSuccess) {
				defer.resolve(res.data.response);
			} else {
				defer.reject(res.data);
			}
		},function(error) {
			defer.reject(error);
		});
		return defer.promise;
	}
	
	function getTotalSkillsList(){
		var defer = $q.defer();
		$http.get('feedback/list').then(function(res) {
			defer.resolve(res);
		}, function(error) {
			defer.reject(error);
		});
		return defer.promise;
	}
	
	function saveOrUpdateStudentFeedBack(obj){
		var defer = $q.defer();
		$http.post('feedback/savestudentfeedback',obj).then(function(res) {
			defer.resolve(res);
		}, function(error) {
			defer.reject(error);
		});
		return defer.promise;
	}
	
	function getFeedBackDetailsByUserId(userId){
		var defer = $q.defer();
		$http.get('feedback/getfeedbackdetailsbyid?userId='+userId).then(function(res) {
			defer.resolve(res);
		}, function(error) {
			defer.reject(error);
		});
		return defer.promise;
	}
	function getAllQuestions(){
		var defer = $q.defer();
		$http.get('codingtest/questionslist').then(function(res) {
			defer.resolve(res);
		}, function(error) {
			defer.reject(error);
		});
		return defer.promise;
	}
	
	function assingCodingTesyQuestionToUsers(userId,questionIds){
		var defer = $q.defer();
		$http.get('codingtest/assignquestouser?userId='+userId+'&questIdsList='+questionIds).then(function(res) {
			defer.resolve(res);
		}, function(error) {
			defer.reject(error);
		});
		return defer.promise;
	}
	
	function getAllTechnologiesList(){
		var defer = $q.defer();
		$http.get('exam/technologieslist').then(function(res) {
			defer.resolve(res);
		}, function(error) {
			defer.reject(error);
		});
		return defer.promise;
	}

	function assinginTechnologiesToUsers(userId,technologiesList){
		var defer = $q.defer();
		$http.get('exam/assingtechtousers?userId='+userId+'&technologiesList='+technologiesList).then(function(res) {
			defer.resolve(res);
		}, function(error) {
			defer.reject(error);
		});
		return defer.promise;
	}
	
	function getAllInternTasksList(){
		var defer = $q.defer();
		$http.get('interntask/interntaskslist').then(function(res) {
			defer.resolve(res);
		}, function(error) {
			defer.reject(error);
		});
		return defer.promise;
	}
	
	function assigningTasksToUsers(userId,taskIdsList){
		var defer = $q.defer();
		$http.get('interntask/assingtaskstousers?userId='+userId+'&taskIdsList='+taskIdsList).then(function(res) {
			defer.resolve(res);
		}, function(error) {
			defer.reject(error);
		});
		return defer.promise;
	}
	
	function downLoadUploadedTasksByUserId(userId){
		var defer = $q.defer();
		$http.get('interntask/uploadedfilesbyuserid?userId='+userId).then(function(res) {
			defer.resolve(res);
		}, function(error) {
			defer.reject(error);
		});
		return defer.promise;
	}
	
	function getTechList(){
		var defer = $q.defer();
		var url = 'user/technologieslist';
		$http.get(url).then(function(response) {
			var res = response.data;
			if (res.isSuccess) {
				defer.resolve(res.response);
			} else {
				defer.reject(res);
			}
		}, function(error) {
			defer.reject(error);
		});
		return defer.promise;
	}
	
	function getLanguagesList(){
		var defer = $q.defer();
		var url = 'user/languageslist';
		$http.get(url).then(function(response) {
			var res = response.data;
			if (res.isSuccess) {
				defer.resolve(res.response);
			} else {
				defer.reject(res);
			}
		}, function(error) {
			defer.reject(error);
		});
		return defer.promise;
	}
	
	function getQuestionsForUsers(testId){
		var defer = $q.defer();
		$http.post('test/getquestionsforusers?testId='+testId).then(function(res) {
			defer.resolve(res);
		}, function(error) {
			defer.reject(error);
		});
		return defer.promise;
	}
	
	
});
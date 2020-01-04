angular.module('pcModule').controller('profileCtrl', function($scope, $log, $http, userService,commonService,$timeout) {
	$scope.init = function() {
		$scope.AllLanguages = [];
		$scope.skillsList = [];
		$scope.languagesList = [];
		$scope.months = ['January', 'February', 'March', 'April', 'May', 'June', 'July', 'August', 'September', 'October', 'November', 'December'];
		$scope.salaryList = ["0","1","2","3","4","5","6","7","8","9","10","11","12","13","14","15","16","17","18","19","20","20+"];
		$scope.salaryListInThousands = ["0","10","20","30","40","50","60","70","80","90"];
		$scope.yearsOfExperience = ["0","1","2","3","4","5","6","7","8","9","10","11","12","13","14","15","16","17","18","19","20"];
		$scope.monthsOfExperience = ["0","1","2","3","4","5","6","7","8","9","10","11","12"];
		$scope.years = userService.getYears(1970);
		$scope.employerStatus =[
		                         {id:"1", "status":"Current Employer"},
		                         {id:"2", "status":"Previous Employer"},
		                         {id:"3", "status":"Other Employer"},
		                         ];
		$scope.addSuccessMsg=undefined;
		$scope.eduSuccessMsg=undefined;
		$scope.projectSuccessMsg=undefined;
		$scope.skillsetSuccessMsg=undefined;
		$scope.socialSuccessMsg = undefined;
		$scope.workExpSuccessMsg = undefined;
		$scope.showPopup = undefined;
		$scope.selectedFile = {};
		$scope.selectedVedioFile = {};
		$scope.getCitiesList();
		$scope.getStatesList();
		$scope.getCountriesList();
		$scope.getUniversitiesList();
		$scope.getInstituteList();
		$scope.getProjectDomainList();
		$scope.technologiesList = [];
		
		 commonService.getLogUserInfo('userInfo').then(function(res){
			 if(res) {
				 $scope.loggedInUser = res;
				userService.getUserData($scope.loggedInUser.id).then(function(res) {
					$scope.completeProfile = res;
					if($scope.completeProfile.user.mobileNo) {
						$scope.formEdit.isMobileEdited = false;
					}
					if($scope.completeProfile.user.address == null) {
						$scope.formEdit.isAddressEdited = true;
					}else{
						$scope.completeProfile.address = res.address;
					}
					
					// condition for formEdit to address section
					
					if($scope.completeProfile.education.length==0) {
						$scope.formEdit.isEducationEdited = true;
						$scope.completeProfile.education = [];
						$scope.addEduInfoPanel();
					}else{
						$scope.completeProfile.education = res.education;
					}
					// condition for formEdit to education section
					
					if($scope.completeProfile.project.length == 0) {
						$scope.formEdit.isProjectEdited = true;
						$scope.completeProfile.project = [];
						$scope.addProjectPanel();
					}else{
						$scope.completeProfile.project = res.project.map(function(p) {
							p.startDate = new Date(p.startDate);
							p.endDate = new Date(p.endDate);
							return p;
						});
					}
					
					if($scope.completeProfile.skill == null) {
						$scope.formEdit.isSkillsetEdited = true;
						$scope.completeProfile.skill = {
						        skills : []
						};
					}else{
						$scope.skillsList= res.skill.techskills.map(function(skill){
							return {"id":skill.technology.id,name:skill.technology.name};
						});
						
						$scope.completeProfile.skill.basicSkills = res.skill.basicSkills;
						$scope.formEdit.isSkillsetEdited = true;
					}
					if($scope.completeProfile.social == null) {
						$scope.formEdit.isSocialInfoEdited = true;
						$scope.completeProfile.social = {};
					}
					if($scope.completeProfile.employersInfo.length == 0) {
						$scope.formEdit.isWorkExpEdited = true;
						$scope.completeProfile.employersInfo = [];
						$scope.addWorkExpPanel();
					}else{
						$scope.completeProfile.employersInfo = res.employersInfo;
					}
					
					if($scope.completeProfile.userExperianceInfo == null) {
						$scope.formEdit.isTotalWorkExpEdited = true;
						$scope.completeProfile.totalWorkExpInfo= {
								curentSalaryInLakhs:$scope.salaryList[0],
								curentSalaryInThousands:$scope.salaryList[0],
								expectedSalaryInLakhs:$scope.salaryList[0],
								expectedSalaryInThousands:$scope.salaryList[0],
								yearsOfExperiance:$scope.yearsOfExperience[0],
								monthsOfExperiace:$scope.monthsOfExperience[0]
						}
					}else{
						$scope.formEdit.isTotalWorkExpEdited = false;
					}
					if($scope.completeProfile.userBasicInfo == null) {
						$scope.formEdit.isBasicInfoEdited = true;
						$scope.completeProfile.userBasicInfo= {};
					}else {
						if($scope.completeProfile.userBasicInfo){
							var dob = new Date();
							var currentYear = new Date().getFullYear();
							var userBirthYear = new Date($scope.completeProfile.userBasicInfo.dob).getFullYear();
							$scope.completeProfile.userBasicInfo.dob = new Date($scope.completeProfile.userBasicInfo.dob);
							$scope.userAge = currentYear-userBirthYear;
							if($scope.completeProfile.userBasicInfo.resumePath){
								$scope.selectedFile.name = $scope.completeProfile.userBasicInfo.resumePath;
								$scope.folderPath = $scope.completeProfile.user.id+"-"+$scope.completeProfile.user.userName;
								$scope.filePath = $scope.completeProfile.userBasicInfo.resumePath.split('.')[0];
								$scope.fileType = $scope.completeProfile.userBasicInfo.resumePath.split('.')[1];
							}
							if($scope.completeProfile.userBasicInfo.selfIntroVideoPath){
								$scope.selectedVedioFile.name = $scope.completeProfile.userBasicInfo.selfIntroVideoPath;
								$scope.videoPath = $scope.completeProfile.userBasicInfo.selfIntroVideoPath;
								$scope.selfIntoVideoPath = $scope.getVideoPath();
							}
							$scope.userLanguagesList = $scope.completeProfile.languages;
							$scope.userUpdatedSkillList = $scope.completeProfile.skill.techskills;
							$scope.userUpdatedResumePath = $scope.completeProfile.userBasicInfo.resumePath;
							$scope.userUpdatedVideoPath = $scope.completeProfile.userBasicInfo.selfIntroVideoPath;
							$scope.languagesList = $scope.completeProfile.languages.map(function(language){
								return language.language;
							});
							
						//	$scope.completeProfile.userBasicInfo.languages = JSON.parse(res.userBasicInfo.languages);

						}
					}
				});	
			 }
			 
		 });
		 $scope.resumeContent = undefined; 
		 
	};
	$scope.getVideoPath = function(){
		return 'user/selfintroductionvedio?vedioPath='+$scope.completeProfile.userBasicInfo.selfIntroVideoPath+'&folderPath='+$scope.loggedInUser.id+"-"+$scope.loggedInUser.userName;
	};
	
	$scope.getCitiesList = function() {
		$http.get('user/getcitylist').success(function(res){
			if(res.isSuccess) {
				$scope.cityList = res.response;
			}
		});
	};
	
	$scope.getStatesList = function(){
		$http.get('user/getstatelist').success(function(res){
			if(res.isSuccess){
				$scope.stateList = res.response;
			}
		});
	};
	
	$scope.getCountriesList = function(){
		$http.get('user/getcountrylist').success(function(res){
			if(res.isSuccess){
				$scope.countryList = res.response;
			}
		});
	};
	$scope.getUniversitiesList = function(){
		$http.get('user/getuniversitylist').success(function(res){
			if(res.isSuccess){
				$scope.universityList = res.response;
			}
		});
	};
	$scope.getInstituteList = function(){
		$http.get('user/getinstitutelist').success(function(res){
			if(res.isSuccess){
				$scope.instituteList = res.response;
			}
		});
	};
	$scope.getProjectDomainList = function(){
		$http.get('user/getprojectdomainlist').success(function(res){
			if(res.isSuccess){
				$scope.projectDomainList = res.response;
			}
		});
	};
	$scope.formEdit = {};    //form object
	$scope.updateMobileNo = function() {
		userService.updateMobileNo($scope.loggedInUser.id,$scope.completeProfile.user.mobileNo).then(function(res){
			if(res){
				$scope.successMsg = "saved Successfully";
				$scope.toggleView('isMobileEdited','formEdit');
			}
		});
	};
	$scope.defaultEduObj={educationType:'SSC',branch:'',yearOfPassing:'',percentage:''}; // empty educational info object
	$scope.defaultProObj = {};
	$scope.defaultWorkObj = {};
	
	
	$scope.eduTypes = ["SSC", "Inter/PUC", "Graduation", "PG", "Ph.D", "Test"];
	$scope.eduTypestwo = ["SSC", "Inter/PUC", "Graduation", "PG", "Ph.D", "Test"];
	
	$scope.education = {	
		educationone :{
			educationtype:"",
			schoolUniversity:"",
			branch:"",
			yearofpassing:"",
			percentage:"",
		},
		educationtwo :{
			educationtype:"",
			schoolUniversity:"",
			branch:"",
			yearofpassing:"",
			percentage:"",
		}
	};
	
	$scope.project = {	
			projectone :{
				name:"",
				description:"",
				startdate:"",
				enddate:"",
				responsibilities:"",
			},
			projectonetwo :{
				educationtype:"",
				schoolUniversity:"",
				branch:"",
				yearofpassing:"",
				percentage:"",
			}
		};
	$scope.countries = ["Afghanistan","Albania","Algeria","Andorra","Angola","Anguilla","Antigua &amp; Barbuda","Argentina","Armenia","Aruba","Australia","Austria","Azerbaijan","Bahamas"
	            		,"Bahrain","Bangladesh","Barbados","Belarus","Belgium","Belize","Benin","Bermuda","Bhutan","Bolivia","Bosnia &amp; Herzegovina","Botswana","Brazil","British Virgin Islands"
	            		,"Brunei","Bulgaria","Burkina Faso","Burundi","Cambodia","Cameroon","Canada","Cape Verde","Cayman Islands","Chad","Chile","China","Colombia","Congo","Cook Islands","Costa Rica"
	            		,"Cote D Ivoire","Croatia","Cruise Ship","Cuba","Cyprus","Czech Republic","Denmark","Djibouti","Dominica","Dominican Republic","Ecuador","Egypt","El Salvador","Equatorial Guinea"
	            		,"Estonia","Ethiopia","Falkland Islands","Faroe Islands","Fiji","Finland","France","French Polynesia","French West Indies","Gabon","Gambia","Georgia","Germany","Ghana"
	            		,"Gibraltar","Greece","Greenland","Grenada","Guam","Guatemala","Guernsey","Guinea","Guinea Bissau","Guyana","Haiti","Honduras","Hong Kong","Hungary","Iceland","India"
	            		,"Indonesia","Iran","Iraq","Ireland","Isle of Man","Israel","Italy","Jamaica","Japan","Jersey","Jordan","Kazakhstan","Kenya","Kuwait","Kyrgyz Republic","Laos","Latvia"
	            		,"Lebanon","Lesotho","Liberia","Libya","Liechtenstein","Lithuania","Luxembourg","Macau","Macedonia","Madagascar","Malawi","Malaysia","Maldives","Mali","Malta","Mauritania"
	            		,"Mauritius","Mexico","Moldova","Monaco","Mongolia","Montenegro","Montserrat","Morocco","Mozambique","Namibia","Nepal","Netherlands","Netherlands Antilles","New Caledonia"
	            		,"New Zealand","Nicaragua","Niger","Nigeria","Norway","Oman","Pakistan","Palestine","Panama","Papua New Guinea","Paraguay","Peru","Philippines","Poland","Portugal"
	            		,"Puerto Rico","Qatar","Reunion","Romania","Russia","Rwanda","Saint Pierre &amp; Miquelon","Samoa","San Marino","Satellite","Saudi Arabia","Senegal","Serbia","Seychelles"
	            		,"Sierra Leone","Singapore","Slovakia","Slovenia","South Africa","South Korea","Spain","Sri Lanka","St Kitts &amp; Nevis","St Lucia","St Vincent","St. Lucia","Sudan"
	            		,"Suriname","Swaziland","Sweden","Switzerland","Syria","Taiwan","Tajikistan","Tanzania","Thailand","Timor L'Este","Togo","Tonga","Trinidad &amp; Tobago","Tunisia"
	            		,"Turkey","Turkmenistan","Turks &amp; Caicos","Uganda","Ukraine","United Arab Emirates","United Kingdom","United States","United States Minor Outlying Islands","Uruguay","Uzbekistan","Venezuela","Vietnam","Virgin Islands (US)"
	            		,"Yemen","Zambia","Zimbabwe"];
	$scope.loadTags = function(query) {
		return $scope.technologiesList;
	};
	$scope.langList = [];
	$scope.loadLanguages = function(query) {
		return $scope.AllLanguages;
		/*return $http.get('resources/json/languages.json');*/
	};
	
	$scope.saveAddress = function() {
		$scope.completeProfile.address.user = {};
		$scope.completeProfile.address.user.id = $scope.completeProfile.user.id;
		/*$scope.completeProfile.address.city.id;*/
		userService.updateUserAddress($scope.completeProfile.address).then(function(res) {
			$scope.toggleView('isAddressEdited','formEdit' );
			$scope.addSuccessMsg=true;
			$scope.completeProfile.address = res.response;
			$timeout(function(){
				$scope.addSuccessMsg=undefined;	
			},6000);
		});		
	};
	
	$scope.updateEducation = function(){
		var req = {
				education : $scope.completeProfile.education,
		};
		for(var i=0;i<req.education.length;i++){
			req.education[i].user = {};
			req.education[i].user.id = $scope.completeProfile.user.id;
		}
		
		userService.updateEdcuationDetails(req).then(function(res){	
			if(res){
				_parseEducationInfo(res.education);
			}
		});
	};
	
	$scope.updateProject = function(){
		var req = {
				project : $scope.completeProfile.project
		};
		for(var i=0;i<req.project.length;i++){
			req.project[i].user = {};
			req.project[i].user.id = $scope.completeProfile.user.id;
			req.project[i].startDate = req.project[i].startDate.getTime();
			req.project[i].endDate = req.project[i].endDate.getTime();
		}
		userService.updateProjectDetails(req).then(function(res){	
			if(res){
				 _parseProjectInfo(res.project); // converting string to objects 
			}
		});
	};
	
	$scope.submitskillset = function() {
		var req = {
	
			skill : {techskills : [],basicSkills:{}}
				
		};
		for(var i=0;i<$scope.skillsList.length;i++){
			req.skill.techskills[i] = {user:{},technology:{}};
			req.skill.techskills[i].user.id = $scope.completeProfile.user.id;
			req.skill.techskills[i].technology.id = $scope.skillsList[i].id;
		}
		
		if($scope.completeProfile.skill.basicSkills){
			req.skill.basicSkills.commRating = $scope.completeProfile.skill.basicSkills.commRating;
			req.skill.basicSkills.analyticalRating = $scope.completeProfile.skill.basicSkills.analyticalRating;
		}
		req.skill.basicSkills.user = {};
		req.skill.basicSkills.user.id = $scope.completeProfile.user.id;
		
		userService.updateSkillsetDetails(req).then(function(res) {
			if(res) {
				_parseSkillsetInfo(res);
			}
			
		});		
	};
	
	$scope.updateSocialInfo = function(){
		$scope.completeProfile.social.user = {};
		$scope.completeProfile.social.user.id = $scope.completeProfile.user.id; // db user id creation for save data and edit data from user side
		userService.updateSocialInfo($scope.completeProfile.social).then(function(res){	
			if(res){
				 _parseSocialInfo(res); // converting string to objects 
			}
		});
	};
	
	$scope.updateWorkExp = function(){
    var req = {
    		employersInfo :$scope.completeProfile.employersInfo
	};
		
		for(var i=0;i<req.employersInfo.length;i++){
			req.employersInfo[i].user = {};
			req.employersInfo[i].user.id = $scope.completeProfile.user.id;
		}
		userService.updateWorkExp(req).then(function(res){	
			if(res){
				 _parseWorkExp(res.employersInfo); // converting string to objects 
			}
		});
	};
	$scope.updateTotalExp = function(){
		var req = angular.copy($scope.completeProfile.userExperianceInfo);
		req.user = {};
		req.user.id = $scope.loggedInUser.id;
		userService.updateTotalExp(req).then(function(res){	
			if(res){
				 _parseTotalWorkExp(res); // converting string to objects 
			}
		});
	};
	$scope.updateUserBasicInfo = function(){
		var req = {
				userBasicProfile:{},
				techskills:[]
			};
		req.userBasicProfile = $scope.completeProfile.userBasicInfo;
		req.userBasicProfile.languages = [];
		for(var j=0;j<$scope.languagesList.length;j++){
			req.userBasicProfile.languages[j] = {language:{},user:{}};
			req.userBasicProfile.languages[j].language.id = $scope.languagesList[j].id;
			req.userBasicProfile.languages[j].user.id = $scope.completeProfile.user.id;
		}
		for(var i=0;i<$scope.skillsList.length;i++){
			req.techskills[i] = {user:{},technology:{}};
			req.techskills[i].user.id = $scope.completeProfile.user.id;
			req.techskills[i].technology.id = $scope.skillsList[i].id;
		}
		req.userBasicProfile.user = {};
		req.userBasicProfile.user.id=  $scope.completeProfile.user.id;
		
		$scope.addSuccessMsg=true;
		$timeout(function(){
			$scope.addSuccessMsg=undefined;	
		},6000);
		if(!angular.equals($scope.selectedFile, {})) {
			req.userBasicProfile.resumePath = "Resume"+"."+$scope.selectedFile.name.split('.')[1];
			$scope.userUpdatedResumePath = req.userBasicProfile.resumePath;
		}
		if(!angular.equals($scope.selectedVedioFile,{})){
			req.userBasicProfile.selfIntroVideoPath = "selfIntroductionVedio"+"."+$scope.selectedVedioFile.name.split('.')[1];
			$scope.userUpdatedVideoPath = req.userBasicProfile.selfIntroVideoPath;
		}
		userService.updateUserBasicInfo(req).then(function(res){	
			if(res){
				$scope.languagesList = res.response.languages.map(function(language){
					return language.language;
				});
				
				var dob = new Date();
				var currentYear = new Date().getFullYear();
				var userBirthYear = new Date(res.response.userBasicInfo.dob).getFullYear();
				$scope.completeProfile.userBasicInfo.dob = new Date(res.response.userBasicInfo.dob);
				$scope.completeProfile.userBasicInfo.profileSummary = $scope.completeProfile.userBasicInfo.profileSummary;
					
				$scope.userLanguagesList = Array.from(res.response.languages);
				$scope.userUpdatedSkillList = Array.from(res.response.skill.techskills);
				if(!angular.equals($scope.selectedFile, {})){
					$scope.uploadResume();
				} 
				if(!angular.equals($scope.selectedVedioFile, {})){
					$scope.uploadVedio();
				}
				_parseBasicInfo(res.response.userBasicInfo);
				userService.getUserData($scope.loggedInUser.id);
				$scope.toggleView('formEdit','isBasicInfoEdited');
			}
		});
		
	};
	// to toggle edit and read only forms
	$scope.toggleView = function(state,parentObj) {
		if(parentObj==undefined) {
			$scope[state] = !$scope[state];
		} else {
			$scope[parentObj][state] = !$scope[parentObj][state];
		}
	
	};
	function _parseBasicInfo(basicInfo) {
		if(isEmpty(basicInfo)) {
			$scope.formEdit.isBasicInfoEdited= true ;
			}
		 else {
			$scope.completeProfile.userBasicInfo = basicInfo;
			//$scope.completeProfile.userBasicInfo.languages =JSON.parse(basicInfo.languages); 
			$scope.completeProfile.userBasicInfo.dob = new Date($scope.completeProfile.userBasicInfo.dob);
			$scope.formEdit.isBasicInfoEdited= false ;
		};
		$scope.workExpSuccessMsg=true;
		$timeout(function(){
			$scope.workExpSuccessMsg=undefined;	
		},6000);

	} 
	
	function _parseWorkExp(work) {
		if(isEmpty(work)) {
			$scope.formEdit.isWorkExpEdited= true ;
			$scope.completeProfile.work = [];
		} else {
			$scope.completeProfile.work =work; 
			$scope.formEdit.isWorkExpEdited= false ;
		};
		$scope.workExpSuccessMsg=true;
		$timeout(function(){
			$scope.workExpSuccessMsg=undefined;	
		},6000);

	}
	function _parseTotalWorkExp(work) {
		if(isEmpty(work)) {
			$scope.formEdit.isTotalWorkExpEdited= true ;
			$scope.completeProfile.totalWorkExpInfo = angular.copy({
				userId: $scope.loggedInUser.id,
			});
		} else {
			$scope.completeProfile.totalWorkExpInfo = work;
			$scope.formEdit.isTotalWorkExpEdited= false ;
		};
		$scope.TotalExpSuccessMsg=true;
		$timeout(function(){
			$scope.TotalExpSuccessMsg=undefined;	
		},6000);

	}
	function _parseSocialInfo(social) {
		if(isEmpty(social)) {
			$scope.formEdit.isSocialInfoEdited = true;
			$scope.completeProfile.social = angular.copy({
				userId: $scope.loggedInUser.id
			});
		} else {
			$scope.completeProfile.social = social;
			$scope.completeProfile.social = social; 
			$scope.formEdit.isSocialInfoEdited= false ;
		};
		$scope.socialSuccessMsg=true;
		$timeout(function(){
			$scope.socialSuccessMsg=undefined;	
		},6000);

	}
	
	function _parseProjectInfo(project) {
		if(isEmpty(project)) {
			$scope.formEdit.isProjectEdited = true;
			$scope.completeProfile.project = [];
			$scope.addProjectInfoPanel();
		} else {
			$scope.completeProfile.project =project; 
			$scope.formEdit.isProjectEdited = false ;
		};
		$scope.projectSuccessMsg=true;
		$timeout(function(){
			$scope.projectSuccessMsg=undefined;	
		},6000);

	}
	
	function _parseEducationInfo(education){
		if(isEmpty(education)){
			$scope.formEdit.isEducationEdited = true;
			$scope.completeProfile.education= [];
			$scope.addEduInfoPanel();
		}else{
			$scope.completeProfile.education=education;
			$scope.formEdit.isEducationEdited = false;
		}
		$scope.eduSuccessMsg=true;
		$timeout(function(){
			$scope.eduSuccessMsg=undefined;	
		},6000);
	}
	function _parseSkillsetInfo(skillset) {
		if(isEmpty(skillset) || isEmpty(skillset.skills)) {
			$scope.formEdit.isSkillsetEdited = true;
			$scope.completeProfile.skill = angular.copy({
				userId: $scope.loggedInUser.id,
				skills:[]
			});
		} else {
			$scope.completeProfile.skill = skillset;
			$scope.completeProfile.skill.skills = $scope.completeProfile.skill.skills.map(function(skill){
				return {"text":skill};
			});
			
		//	$scope.completeProfile.skill.skills = res.skill.skills;
		//	$scope.completeProfile.skill.skills = JSON.parse(skillset.skills); 
			/*for( var i=0;i<$scope.loadTags.length;i++) {
				for(var j=0;j<$scope.completeProfile.skill.skills.length;j++) {
					if($scope.loadTags[i] == $scope.completeProfile.skill.skills[j]){
						$scope.loadTags.splice(i,1);
					}
				}
			}*/
			$scope.formEdit.isSkillsetEdited = false;
		};
		$scope.skillsetSuccessMsg=true;
		$timeout(function(){
			$scope.skillsetSuccessMsg=undefined;	
		},6000);
	}
	$scope.getTechListData = function() {
		userService.getTechList().then(function(res){	
			if(res){
				$scope.technologiesList = res;
			}
		});
	};
	
	$scope.getLanguagesListData = function() {
		userService.getLanguagesList().then(function(res){	
			if(res){
				$scope.AllLanguages = res;
			}
		});
	};

	$scope.getTechListData();
	
	$scope.getLanguagesListData();
	
	$scope.loadTags();
		 
	$scope.printAddress = function() {
		$log.info($scope.address);
		$log.info($scope.project);
		$log.info($scope.projectone);
		$log.info($scope.projecttwo);
		$log.info($scope.skillset);		
	};
	$scope.removeEducation = function(index,obj) {
		if(obj.instituteName){
			userService.deleteEducationDetails(obj.user.id,obj.educationType).then(function(res){	
				if(res){
				}
			});
		}
		$scope.completeProfile.education.splice(index,1);
	};
	// Remove Project
	$scope.removeProject = function(index,obj) {
		if(obj.projectTitle){
			userService.deleteProject(obj.user.id,obj.projectTitle).then(function(res){	
				if(res){
				}
			});
		}
		$scope.completeProfile.project.splice(index,1);
	};
	$scope.removeWorkExp = function(index,obj) {
		if(obj.employerStatus){
			userService.deleteWorkExp(obj.user.id,obj.employerStatus).then(function(res){	
				if(res){
				}
			});
		}
		$scope.completeProfile.employersInfo.splice(index,1);
	};
	

	// toggle function to toggle the views
	$scope.toggleBoolean = function(prop) {
		$scope[prop]= !$scope[prop];
	};
	
	
	$scope.addEduInfoPanel = function(){
		if($scope.completeProfile.education.length<5){
			var obj = angular.copy($scope.defaultEduObj);
			if($scope.completeProfile.education.length==1){
				obj.educationType="Inter/PUC";
			}else if($scope.completeProfile.education.length==2){
				obj.educationType="Graduation";
			}else if($scope.completeProfile.education.length==3){
				obj.educationType="P.G";
			}else if($scope.completeProfile.education.length==4){
				obj.educationType="Ph.D";
			}
			$scope.completeProfile.education.push(obj);
		};
	};  //add panel for Education
	
	$scope.addProjectPanel = function(){
		if($scope.completeProfile.project.length<5){
			var obj = angular.copy($scope.defaultProObj);	
			$scope.completeProfile.project.push(obj);
		};
	};
	$scope.addWorkExpPanel = function(){
		if($scope.completeProfile.employersInfo.length<4){
			var obj = angular.copy($scope.defaultWorkObj);	
			$scope.completeProfile.employersInfo.push(obj);
		};
	};
	
	$scope.selectUpload =function(selectedFile,path,event){
		$scope.selectedFile = selectedFile;
		var list = $scope.selectedFile.name.split(".");
		var fileExt = list[list.length-1];
		if(fileExt!='pdf' && fileExt!='doc' && fileExt!='docx') {
			$scope.fileFormatMsg = 'Please upload .pdf or .doc or .docx files only';
			 $scope.toggleBoolean('showPopup');
			 return;
		}
		if($scope.selectedFile){
			$scope.infoMsg = "uploaded Successfully";
		}else {
			$scope.infoMsg = "Please Choose the File first";
		}
	};
	

	$scope.selectVedioUpload=function(selectedVedioFile){
		$scope.selectedVedioFile = selectedVedioFile;
		var list = $scope.selectedVedioFile.name.split(".");
		var fileExt = list[list.length-1];
		if(fileExt!='avi' && fileExt!='flv' && fileExt!='mp4' && fileExt!='mov' && fileExt!='wmv') {
			$scope.fileFormatMsg = 'Please upload Video Files only like mp4 or avi';
			 $scope.toggleBoolean('showPopup');
			 return;
		}
		if($scope.selectedVedioFile){
			$scope.videoInfoMsg = "Video Uploaded Successfully";
		}else {
			$scope.infoMsg = "Please Choose the File first";
		}
	};
	
	$scope.uploadResume = function () {
		if(!$scope.uploadingFile) {
			$scope.uploadingFile = "Uploading Resume successfully " + $scope.selectedFile.name;
			if($scope.selectedFile) {
				userService.uploadResume($scope.selectedFile, "Resume"+"."+$scope.selectedFile.name.split('.')[1], $scope.loggedInUser.id+'-'+$scope.loggedInUser.userName).then(function() {
					$scope.toggleBoolean('$infoMsg');
					$scope.infoMsg = 'Uploaded Successfully';
					$scope.uploadingFile = null;
					$scope.selectedFile = null;
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
	
	$scope.uploadVedio = function () {
		if(!$scope.uploadingVedioFile) {
			$scope.uploadingVedioFile = "Uploading Vedio successfully " + $scope.selectedVedioFile.name;
			if($scope.selectedVedioFile) {
				userService.uploadVedio($scope.selectedVedioFile, "selfIntroductionVedio"+"."+$scope.selectedVedioFile.name.split('.')[1] , $scope.loggedInUser.id+"-"+$scope.loggedInUser.userName).then(function() {
					$scope.toggleBoolean('$infoMsg');
					$scope.videoInfoMsg = 'Video Uploaded Successfully';
					$scope.uploadingVedioFile = null;
					$scope.selectedVedioFile = null;
				}, function(error) {
					$scope.uploadingVedioFile = null;
					/*console.error(error);*/
					$scope.videoInfoMsg  = 'Upload failed, Please try again';
					$scope.toggleBoolean('$infoMsg');
				});
			} else {
				$scope.togglePopup('$infoMsg');
				$scope.infoMsg = 'No File selected';
				window.setTimeout(function() {
					$scope.uploadingVedioFile = null;
				}, 100);
			}
		}
	};
	// toggle function to toggle the views
	$scope.toggleBoolean = function(prop) {
		$scope[prop]= !$scope[prop];
	};
	
	$scope.showResume = function(){
		$scope.toggleBoolean('showCoursePurchaseForm');
		$scope.resumePath = 'user/getresume?resumePath='+$scope.completeProfile.userBasicInfo.resumePath+'&folderPath='+$scope.loggedInUser.id+"-"+$scope.loggedInUser.userName;
	};
	
	/*Calendar Start*/
	$scope.showWeeks= false;
	$scope.inlineOptions = {
		customClass: getDayClass,
		minDate: new Date() ,
		showWeeks: false
	};

	$scope.dateOptions = {
		// dateDisabled: disabled,
		formatYear: 'yy',
		maxDate: new Date(2040, 11, 31),
		minDate: new Date(),
		startingDay: 1
	};

	// Disable weekend selection
	function disabled(data) {
		var date = data.date,
		mode = data.mode;
		return mode === 'day' && (date.getDay() === 0 || date.getDay() === 6);
	}

	$scope.toggleMin = function() {
		$scope.inlineOptions.minDate = $scope.inlineOptions.minDate ? null : new Date();
		$scope.dateOptions.minDate = $scope.inlineOptions.minDate;
	};

	$scope.toggleMin();

	$scope.openCalendar = function(calenderParameter) {
		$scope[calenderParameter] = {opened: true};
	};

	$scope.setDate = function(year, month, day) {
		$scope.dt = new Date(year, month, day);
	};
	  $scope.calendarPanel = {
	    opened: false
	  };


	  function getDayClass(data) {
	    var date = data.date,
	      mode = data.mode;
	    if (mode === 'day') {
	      var dayToCheck = new Date(date).setHours(0,0,0,0);

	      for (var i = 0; i < $scope.events.length; i++) {
	        var currentDay = new Date($scope.events[i].date).setHours(0,0,0,0);

	        if (dayToCheck === currentDay) {
	          return $scope.events[i].status;
	        }
	      }
	    }

	    return '';
	  }
	  /*Calendar End*/

	$scope.init();
}).filter("trustUrl", ['$sce', function ($sce) {
    return function (recordingUrl) {
        return $sce.trustAsResourceUrl(recordingUrl);
    };
}]);

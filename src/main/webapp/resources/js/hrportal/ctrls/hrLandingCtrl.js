var app = angular.module('pcModule').controller('hrLandingCtrl',function($scope,$http,hrService,$stateParams,$timeout,$state, $rootScope,hrCommonService,desktopService,commonService){
	$scope.students =[{"name":"sudhakar","designation":"UI Developer","currentCountry":"India","currentState":"Karnataka","currentCity":"Bangalore","currentCompany":"TrieCoders","exp":"5 months+.","skills":["HTML","CSS","JavaScript","AngularJs","Python","C","Java","Hibernate","Spring"],"noticePeriod":"30 Days","imgPath":"/resources/img/user.png"},{"name":"Chenna","designation":"UI/UX Developer","currentCountry":"India","currentState":"Karnataka","currentCity":"Bangalore","currentCompany":"Infosys","exp":"8+ yrs.","skills":["HTML","CSS","JavaScript","AngularJs","Adobe PhotoShop","corelDraw","Bootstrap","Foundation","jQuery","Ajile Methodoly","Font Icon Creation","Adobe Illustrator"],"noticePeriod":"30 Days","imgPath":"/resources/img/user.png"},{"name":"Appaji","designation":"Backend & UI Developer","currentCountry":"India","currentState":"Karnataka","currentCity":"Bangalore","currentCompany":"TrieCoders","exp":"5 months+.","skills":["HTML","CSS","JavaScript","AngularJs","C","Java","Hibernate","Spring"],"noticePeriod":"30 Days","imgPath":"/resources/img/user.png"},{"name":"Satish","designation":"Tester & UI Developer","currentCountry":"India","currentState":"Karnataka","currentCity":"Bangalore","currentCompany":"TrieCoders","exp":"5 months+.","skills":["HTML","CSS","JavaScript","AngularJs","C","Selenium Testing"],"noticePeriod":"30 Days","imgPath":"/resources/img/user.png"}]
	$scope.init = function() {
		$scope.checkLogin();
		$scope.getCandidatesProfiles ();
		$scope.searchdetails = {};
		$scope.usercompletedata = {};
		$scope.cityList();
		$scope.userProfiles = [];
		$scope.UserSearch = {};
		$scope.technologiesList();
		$scope.techarray = [];
		$scope.searchdetails.cityinfo = {};
		$scope.searchdetails.cityinfo.id = 0;
		$scope.exp = [{"yearsOfExperiance":"0","name":"fresher"},{"yearsOfExperiance":"1","name":"oneyear"},{"yearsOfExperiance":"2","name":"twoyears"},{"yearsOfExperiance":"3","name":"threeyears"}];
		 $scope.min=0;
		 $scope.max=0;
	};
	$scope.candidatesProfilesList = [];
	$scope.getCandidatesProfiles = function() {
		hrService.getCandidatesProfiles().then(function(res){
			if(res) {
				$scope.candidatesProfilesList = res.res;
				for(var i=0;i<$scope.candidatesProfilesList.length;i++) {
					if($scope.candidatesProfilesList[i].education!=null){
						$scope.candidatesProfilesList[i].education.educationInfo = JSON.parse(res.res[i].education.educationInfo);
					}
					if($scope.candidatesProfilesList[i].project!=null) {
						$scope.candidatesProfilesList[i].project.projectInfo = JSON.parse(res.res[i].project.projectInfo);
					}
					if($scope.candidatesProfilesList[i].social!=null) {
						$scope.candidatesProfilesList[i].social.socialInfo = JSON.parse(res.res[i].social.socialInfo);
					}
					if($scope.candidatesProfilesList[i].work!=null) {
						$scope.candidatesProfilesList[i].work.workExp = JSON.parse(res.res[i].work.workExp);
					}
					if($scope.candidatesProfilesList[i].skillset !=null) {
						$scope.candidatesProfilesList[i].skillset.skills = JSON.parse(res.res[i].skillset.skills);
					}
					if($scope.candidatesProfilesList[i].user.address!=null) {
						$scope.candidatesProfilesList[i].user.address = JSON.parse(res.res[i].user.address);
					}
				}
			}
		});
	};
	$scope.checkLogin=function(){
		commonService.getLogUserInfo('userInfo').then(function(res){
			$scope.loggedInUser = res;
		},function(err){
			$scope.loggedInUser = null;
			$scope.changeState('home');
		});
	};
	
	$scope.technologiesList = function() {
	$http.get("user/technologieslist").success(function(res) {
			if (res.isSuccess) {
				$scope.techList = {};
				$scope.techList = res.response;
			}
		});
	};
	
	$scope.cityList = function() {
		$http.get("user/getcitylist").success(function(res) {
				if (res.isSuccess) {
					$scope.cityList = {};
					$scope.cityList = res.response;
				}
			});
		};
	
/*		$scope.$watch("min","max", function(){
			
		});
		*/
		$scope.backtousers = function() {
			$scope.showtests = 'slide-page-right';
		};
		
		$scope.viewdetails = function() {
			$scope.showtests = 'slide-page-left';
		};
		
	$scope.userlistbysearch = function() {
		$scope.UserSearch.address = {};
		$scope.UserSearch.address.city = {};
		$scope.UserSearch.tech = [];
		$scope.finaltechList = [];
		$scope.finalexpList = [];
		$scope.UserSearch.address.city.id = $scope.searchdetails.cityinfo.id;
		var req = [];
		req = angular.copy($scope.techList)
		for(var i=0;i<req.length;i++){
			if(req[i].selected==true){
				delete req[i].selected;
				delete req[i].$$hashKey;
				$scope.finaltechList.push(req[i]);
			}
		}
		$scope.UserSearch.expmax = $scope.max;
		$scope.UserSearch.expmin = $scope.min;
		$scope.UserSearch.tech = Array.from($scope.finaltechList);
		delete $scope.UserSearch.address.city.$$hashKey;
		$http.post("user/getuserslistbysearchpreference",$scope.UserSearch).success(function(res) {
				if (res.isSuccess) {
					$scope.userProfiles = res.response;
				}
			});
		};
		$scope.visSlider = {
		    options: {
		      floor: 0,
		      ceil: 10,
		      step: 1,
		      onEnd: function() {
	                 $scope.userlistbysearch();
	            }
		    }
		  };
		
		$scope.getusercompleteviewdetails = function(userId){
			$http.get("user/completedata?userId="+userId).success(function(res){
				if(res.isSuccess){
					$scope.completeProfile = res.response;
					$scope.viewdetails();
				}
			});
			
		};
	
	$scope.viewDetails = function(candidateProfile) {
		sessionStorage.setItem('profile',JSON.stringify(candidateProfile));
		$scope.changeState('studentdetails');
	};
	
	$scope.init();
});
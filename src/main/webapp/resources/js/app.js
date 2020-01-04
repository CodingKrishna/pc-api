var app = angular.module('pcModule',['ui.router','rzModule', 'camera', 'ngSanitize', 'ngMessages','angular-md5', 'ngTagsInput', 'angular-carousel','ui.bootstrap','ngMaterial', 'ui.ace','datatables']);

app.controller('pcCtrl', function($scope, $filter, $state, $http, $rootScope,$timeout,commonService,userService,contactusService,instructorService,md5) {
	
	$scope.init = function() {
		$scope.getCourses();
		$scope.checkLogin();
		$scope.subscribe = {};
		$scope.form = {};
		$scope.role = {"id":1};
		$scope.duration = 10000;
		$scope.showReg = true;
		/*$scope.loadingApp = true;
		angular.element(document).ready(function () {
			$scope.loadingApp = false;
		});*/
		$rootScope.loginRedirectPage =  'desktop';
		$scope.hideMenu = undefined;
		$scope.showMenu = undefined;
		
		$scope.messageBundle={};
		$scope.getMessageBundle();
	};
	
	
	$scope.toggleNav = function(index) {
		if(!$scope.showMenu){
			$scope.showMenu = index;
		}else {
			$scope.showMenu = undefined;
		}
	};
	$scope.hideSubMenu = function() {
		$scope.subMenu = false;
	};
	// variables declaration and initialization
	$scope.regFormMessage = undefined;
	$scope.logFormMessage = undefined;
	$scope.contactUsFormMessage = undefined;
	$scope.instructorFormMessage = undefined;
	$scope.formLoader = undefined;
	$scope.showMenu = undefined;
	$scope.coursesList=[];
	$scope.bgColors = ["bg-card-color-1","bg-card-color-2","bg-card-color-3","bg-card-color-4","bg-card-color-5"];
	$scope.coursesBgColors =["bg-color-1","bg-color-2","bg-color-3","bg-color-4"];
	$scope.form={
		regForm:{},
		contactUsForm:{},
		instructorFrom:{}
	};

	$scope.student = {};
	$scope.tutorialMenu = angular.copy(TUTORIAL_MENU_DATA);
	
	$scope.changeState = function(stateRef, params) {
		$state.go(stateRef, params);
		$scope.hideMenu = true;
		if(params!=undefined){
			$scope.selectedTopic = params.technologyKey;
		}
	};
	
	// toggle function to toggle the views
	$scope.toggleBoolean = function(prop) {
		$scope[prop]= !$scope[prop];
	};
	
	// to open the login form
	$scope.openLogin = function(){
		$scope.formLoader = undefined;
		$scope.showLogin = undefined;
		$scope.loginForm.$setPristine();
		$scope.form.regForm.$setPristine();
		$scope.form.registration.$setPristine();
		$scope.regFormMessage = undefined;
		$scope.logFormMessage = undefined;
		$scope.student = {};
		$scope.toggleBoolean('showpopup');
	};
	$scope.openRegistraion = function(text) {
		if(text=='hr'){
			$scope.role.id=7;
		}else{
			$scope.role.id=1;
		}
		$scope.toggleBoolean('openReg');
	};
	// slides to login form  from registration form
	$scope.slideToLogin = function() {
		$scope.showLogin = 'slide-page-right';
	};
	
	// slides to registration  from login form
	$scope.slideToRegistration = function() {
		$scope.showLogin = 'slide-page-left';
	};
	
	// checks weather user is logged in or not
	$scope.checkLogin=function(){
		commonService.getLogUserInfo('userInfo').then(function(res){
			$scope.loggedInUser = res;
			$scope.folderPath = $scope.loggedInUser.id+"-"+$scope.loggedInUser.userName;
		},function(err){
			$scope.loggedInUser = null;
			$scope.changeState('home');
		});
	};
	
	// method for user registration
	$scope.registerUser=function(){
		$scope.regFormMessage = undefined;
		if($scope.student.confirmPassword !== $scope.student.password){
			$scope.loggedInUser=false;
			$scope.regFormMessage="Passwords not Matched";
			$timeout(function(){
				$scope.regFormMessage=undefined;
			},4000);
			return;
		}
		var obj = angular.copy($scope.student);
		obj.password = md5.createHash($scope.student.password);
		delete obj.confirmPassword;
		$scope.formLoader=true;
		userService.registerUser(obj).then(function(res){
			if(res.isSuccess){
				$scope.userEmailId = res.response.emailId; 
				$scope.formLoader=false;
				$scope.regFormMessage="SUCCESS";
				$scope.student={};
				$scope.form.regForm.$setPristine();
				$timeout(function(){
					$scope.showpopup=false;
					$scope.regFormMessage=undefined;
					$scope.slideToLogin();
				},100000);
			}else{
				$scope.formLoader = false;
				$scope.regFormMessage=res.response;
				$timeout(function(){
					$scope.regFormMessage=undefined;
				},6000);
			}
		},function(err){
			$scope.regFormMessage="FAILED";
		});
	};
	
	// method user login
	$scope.doLogin=function(){
		$scope.logFormMessage=undefined;
		var loginObj=angular.copy($scope.login);
		loginObj.password = md5.createHash($scope.login.password);
		commonService.doLogin(loginObj).then(function(res){
			commonService.setLogUserInfo('userInfo',res).then(function(res){
				$scope.loggedInUser = res;
				$scope.logFormMessage="SUCCESS";
				if($rootScope.loginRedirectPage == 'eventBook'){
					$rootScope.$broadcast('$goToEvents');
				} else if ($rootScope.loginRedirectPage =='courseCart'){
					$rootScope.$broadcast('gotocart');
				}else if(res.role.id==7){
					$scope.changeState('hrlanding');
				}else if(res.role.id==8){
					$scope.changeState('po.studentGroups');
				}else{
					$scope.changeState('user.profile');
				}
				$rootScope.loginRedirectPage = 'desktop';
				$scope.showpopup=false;
			},function(err){
				$scope.loggedInUser = null;
				$scope.logFormMessage="Invalid Credentials";
				$rootScope.loginRedirectPage = 'desktop';
				$timeout(function(){
					$scope.logFormMessage=undefined;
				},4000);
			});
		},function(err){
			$scope.loggedInUser = null;
			$scope.logFormMessage="Invalid Credentials";
			/*$timeout(function(){
				$scope.logFormMessage=undefined;
			},4000);*/
		});
	};
	
	// method for logout
	$scope.logout=function(){
		if(typeof(Storage) !== "undefined") {
			sessionStorage.removeItem('userInfo');
			$scope.loggedInUser = null;
			$scope.login = {};
			$scope.logFormMessage = undefined;
			$scope.loginForm.$setPristine();
			$scope.changeState('home');
		}
	};
	

	// saves contact us information
	$scope.saveContactUs=function(){
		$scope.contactUsFormMessage = undefined;
		
		var contactus=angular.copy($scope.contactus);
		contactusService.saveContactUs(contactus).then(function(res){
			$scope.formLoader=false;
			if(res.isSuccess){
				$scope.contactUsFormMessage="SUCCESS";
				$scope.contactus={};
				$scope.form.contactUsForm.$setPristine();
				$timeout(function(){
					$scope.contactUsFormMessage=undefined;
				},6000);
			}else{
				$scope.contactUsFormMessage="FAILED";
			}
		},function(err){
			$scope.contactUsFormMessage="FAILED";	
		});
	};
	
	// saves instructor information
	$scope.saveInstructorInfo=function(){
		$scope.instructorFormMessage = undefined;
		var instructor=angular.copy($scope.instructor);
		instructorService.saveInstructorInfo(instructor).then(function(res){
			if(res.isSuccess){
				$scope.instructorFormMessage="SUCCESS";
				$scope.instructor={};
				$scope.form.instructorForm.$setPristine();
				$timeout(function(){
					$scope.instructorFormMessage=undefined;
				},6000);
			}else{
				$scope.instructorFormMessage="FAILED";
			}
		},function(err){
			$scope.formLoader=false;
			$scope.instructorFormMessage="FAILED";	
		});
	};
	
	// retrieves all courses
	$scope.getCourses = function() {
		$http.get('course/courselist').success(function(res){
			if(res.isSuccess) {
				$scope.coursesList = $filter('filter')(res.response, {isFeaturedCourse: true});
				$scope.groupedCourses = {};
				res.response.map(function(course) {
					if(!$scope.groupedCourses[course.category]) {
						$scope.groupedCourses[course.category] = [];
					}
					$scope.groupedCourses[course.category].push(course);
				});
				res.response;
			 }
		 });
	};
	
	// redirects cart page to the login page if the user did not logged in
	$rootScope.$on('doLogin',function(event){
		$scope.openLogin();
		
	});
	/**/
	/* open search */
	/**/
	open_search();
	function open_search(){
	  $(".search-open").on( 'click', function(e){
	    $(".header-top-panel form").toggleClass("open"); 
	    e.stopPropagation();
	  });
	}

	$scope.saveSubscribeEmail = function(email){
		$http.get('user/subscribe?subscriberEmail='+email).then(function(res){
			if(res.data.isSuccess){
				$scope.subscribe.subscriberEmail = undefined;
				$scope.form.subscribe.$setPristine();
				$scope.subscribeSuccessMsg = "Successfully Subscribed.";
				$timeout(function(){
					$scope.subscribeSuccessMsg =undefined;
				},5000);
			}
		});
	};
	
	$scope.getMessageBundle = function(){
		$http.get('messageBundle').then(function(res){
			if(res.data.isSuccess){
				$scope.messageBundle = res.data;
				console.log($scope.messageBundle['lbl.page']);
			}
		});
	};
	
	$scope.init();
});

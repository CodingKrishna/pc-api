angular.module("pcModule").config(function($stateProvider, $urlRouterProvider) {
	$stateProvider
	.state('home', {
		url: '/home',
		controller: 'landingCtrl',
		templateUrl: 'views/home/landing.html'
    }).state('sendmail', {
		url: '/sendmail',
		controller: 'changePwdCtrl',
		templateUrl: 'views/user/checkeEmailIdPage.html'
    })
    .state('tutorials', {
		url: '/tutorials/:technologyKey',
		params : {
			technologyKey: 'cTopics'
		},
		controller: 'tutorialsCtrl',
		templateUrl: 'views/tutorials/tutorials.html'
    })
    .state('tutorialsconcept', {
		url: '/tutorials/:technologyKey/:conceptKey',
		controller: 'tutorialsCtrl',
		templateUrl: 'views/tutorials/tutorials.html'
    })
    .state('courseshome', {
		url: '/courses',
		controller: 'trainingCtrl',
		templateUrl: 'views/training/training.html'
    })
    .state('courses', {
		url: '/courses/:courseId/:courseName',
		params: {
			courseId: null,
			courseName: null
		},
		reloadOnSearch: true,
		controller: 'trainingDetailsCtrl',
		templateUrl: 'views/training/trainingDetails.html'
    })
    .state('placement', {
		url: '/placement',
		controller: 'placementCtrl',
		templateUrl: 'views/placement/placements.html'
    })
    .state('support', {
		url: '/support',
		controller: 'supportCtrl',
		templateUrl: 'views/support/supportPage.html'
    })
    .state('user', {
		url: '/user',
		controller:'userCtrl',
		templateUrl: 'views/user/user.html'
    })
    .state('user.dashboard', {
		url: '/dashboard',
		parent: 'user',
		templateUrl: 'views/user/dashboard.html',
		controller: 'userDashboardCtrl',
    })
    .state('user.userTest',{
		url:'/userTest',
		parent:'user',
		templateUrl:'views/user/userTest.html',
		controller:'assignmentCtrl'
	})
    .state('user.profile', {
		url: '/profile',
		parent: 'user',
		controller: 'profileCtrl',
		templateUrl: 'views/user/profile.html'
    })
     .state('user.viewprofile', {
		url: '/viewprofile',
		parent: 'user',
		controller: 'profileCtrl',
		templateUrl: 'views/user/view-profile.html'
    })
    .state('user.mytasks', {
		url: '/mytasks',
		parent: 'user',
		controller: 'mytasksCtrl',
		templateUrl: 'views/user/mytasks.html'
    })
    .state('user.casestudies', {
		url: '/casestudies',
		parent: 'user',
		controller: 'casesheetCtrl',
		templateUrl: 'views/user/casesheet.html'
    })
    .state('user.evaluation', {
		url: '/evaluation',
		parent: 'user',
		controller: 'evaluationCtrl',
		templateUrl: 'views/user/evaluation.html'
    })
     .state('user.optedcourses', {
		url: '/optedcourses',
		parent: 'user',
		templateUrl: 'views/user/purchasedcoursestemplate.html'
    })
	.state('user.quiz', {
		url: '/quiz',
		parent: 'user',
		controller: 'quizCtrl',
		templateUrl: 'views/user/quiz.html'
    }).state('user.onlineTestResults', {
		url: '/onlineTestResults',
		parent: 'user',
		controller: 'assignmentCtrl',
		templateUrl: 'views/user/onlineTestResults.html'
    }).state('user.test', {
		url: '/quiz',
		parent: 'user',
		controller: 'quizCtrl',
		templateUrl: 'views/user/online-test.html'
    }).state('cart', {
		url: '/cart/:courseId/:courseName',
		controller: 'cartCtrl',
		templateUrl: 'views/cart/cart.html'
    }).state('carthome', {
		url: '/carthome',
		controller: 'cartCtrl',
		templateUrl: 'views/cart/cart.html'
    }).state('events', {
		url: '/events',
		controller: 'eventsCtrl',
		templateUrl: 'views/events/event.html'
    }).state('orderconfirm', {
		url: '/orderconfirm',
		controller: 'orderConfirmCtrl',
		templateUrl: 'views/cart/orderconfirm.html'
    }).state('placements', {
		url: '/placements',
		controller: 'placementCtrl',
		templateUrl: 'views/placement/placements.html'
    })   .state('user.referral', {
		url: '/referral',
		parent: 'user',
		controller: 'referralCtrl',
		templateUrl: 'views/user/referral.html'
    }).state('user.visibility', {
		url: '/visibility',
		parent: 'user',
		controller:'userCtrl',
		templateUrl: 'views/user/profileVisibility.html'
    }).state('eventbooking', {
		url: '/eventbooking',
		controller:'eventBookingCtrl',
		templateUrl: 'views/events/eventbooking.html'
    }).state('user.bookedevents', {
		url: '/bookedevents',
		parent: 'user',
		controller:'userCtrl',
		templateUrl: 'views/user/bookedevents.html'
    }).state('user.mytests', {
		url: '/mytests',
		controller:'myTestsCtrl',
		parent: 'user',
		templateUrl: 'views/user/mytests.html'
    }).state('user.testfromhr', {
		url: '/testfromhr',
		controller:'userCtrl',
		parent: 'user',
		templateUrl: 'views/user/testfromhr.html'
    }).state('user.onlineTest', {
		url: '/onlineTest',
		controller:'onlineTestCtrl',
		parent: 'user',
		templateUrl: 'views/user/onlineTest.html'
   }).state('hrhome', {
		url: '/hrhome',
		controller:'pcHrCtrl',
		templateUrl: 'views/hrportal/hr-home.html'
   }).state('pohome', {
		url: '/pohome',
		controller:'pcPOCtrl',
		templateUrl: 'views/po/po-info.html'
   }).state('hrlanding', {
		url: '/hrlanding',
		controller:'hrLandingCtrl',
		templateUrl: 'views/hrportal/hrlanding.html'
   }).state('hr',{
		url:'/hr',
		templateUrl:'views/hrportal/desktop/hr.html',
		controller:'hrCtrl'
	}).state('hr.desktop',{
		url:'/desktop',
		parent:'hr',
		templateUrl:'views/hrportal/desktop/desktop.html',
		controller:'desktopCtrl'
	}).state('hr.profile',{
		url:'/profile',
		parent:'hr',
		templateUrl:'views/hrportal/desktop/hrprofile.html',
		controller:'hrProfileCtrl'
	}).state('hr.company',{
		url:'/compnay',
		parent:'hr',
		templateUrl:'views/hrportal/desktop/company.html',
		controller:'companyCtrl'
	}).state('hr.exam',{
		url:'/exam',
		parent:'hr',
		templateUrl:'views/hrportal/desktop/exam.html',
		controller:'assignmentCtrl'
	}).state('hr.groups',{
		url:'/groups',
		parent:'hr',
		templateUrl:'views/hrportal/desktop/groups.html',
		controller:'assignmentCtrl'
	}).state('hr.examResults',{
		url:'/examResults',
		parent:'hr',
		templateUrl:'views/hrportal/desktop/examResults.html',
		controller:'assignmentCtrl'
	}).state('hr.plandetails',{
		url:'/plandetails',
		parent:'hr',
		templateUrl:'views/hrportal/desktop/plandetails.html',
		controller:'planDetailsCtrl'
	}).state('hr.plans',{
		url:'/plans',
		parent:'hr',
		templateUrl:'views/hrportal/desktop/plans.html',
		controller:'planDetailsCtrl'
	}).state('hr.confirmPurchase',{
		url:'/confirmPurchase',
		templateUrl:'views/hrportal/confirmPurchase.html',
		controller:'planDetailsCtrl'
	}).state('studentdetails',{
		url:'/studentdetails',
		templateUrl:'views/hrportal/studentdetails.html',
		controller:'studentDetailsCtrl'
	}).state('po.studentExam',{
		url:'/studentExam',
		templateUrl:'views/po/studentExam.html',
		controller:'poStudentCtrl'
	}).state('po.studentExamResults',{
		url:'/studentExamResults',
		templateUrl:'views/po/studentExamResults.html',
		controller:'poStudentCtrl'
	}).state('po.studentGroups',{
		url:'/studentGroups',
		templateUrl:'views/po/studentGroups.html',
		controller:'poStudentCtrl'
	}).state('po',{
		url:'/po-home',
		templateUrl:'views/po/po-home.html',
		controller:'poCtrl'
	}).state('po.profile',{
		url:'/poProfile',
		templateUrl:'views/po/poProfile.html',
		controller:'poCtrl'
	}).state('po.college',{
		url:'/pocollege',
		templateUrl:'views/po/po-college.html',
		controller:'poStudentCtrl'
	});
	$urlRouterProvider.otherwise('/home');
});	
angular.module('pcModule').run(function($rootScope, $state) {
	$rootScope.$on('$stateChangeStart',function(event, toState, toParams, fromState, fromParams){ 
	    document.body.scrollTop=0;
	    if(toState && (toState.name === 'user' || toState.parent === 'user')) {
		    if(!sessionStorage.getItem('userInfo')) {
		    	event.preventDefault();
	    		$state.go('home');
		    }
	    }
	});
});
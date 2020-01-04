angular.module("pcAdminModule").config(function($stateProvider, $urlRouterProvider) {
	$stateProvider
	.state('login', {
		url: '/login',
		templateUrl: 'views/admin/login.html'
    })
	.state('dashboard', {
		url: '/dashboard',
		controller:'dashboardCtrl',
		templateUrl: 'views/admin/dashboard.html'
    })
    .state('users', {
		url: '/users',
		controller:'usersCtrl',
		templateUrl: 'views/admin/users.html'
    })
    .state('instructors', {
		url: '/instructors',
		controller:'instructorsCtrl',
		templateUrl: 'views/admin/instructors.html'
    })
    .state('contactus', {
		url: '/contactus',
		controller:'contactUsCtrl',
		templateUrl: 'views/admin/contacts.html'
    })
    .state('supports', {
		url: '/supports',
		controller:'supportsList',
		templateUrl: 'views/admin/supportsList.html'
    }).state('quizresults', {
		url: '/quizresults',
		controller:'quizResultsList',
		templateUrl: 'views/admin/quizResultsPage.html'
    }).state('payments', {
		url: '/payments',
		controller:'paymentsListCtrl',
		templateUrl: 'views/admin/PaymentsPage.html'
    }).state('expendature', {
		url: '/expendature',
		controller:'expendatureListCtrl',
		templateUrl: 'views/admin/ExpendaturePage.html'
    }).state('balancesheet', {
		url: '/balancesheet',
		controller:'balanceSheetCtrl',
		templateUrl: 'views/admin/BalanceSheet.html'
    }).state('addquestions', {
		url: '/addquestions',
		controller:'addquestionsCtrl',
		templateUrl: 'views/admin/AddQuestionsPage.html'
    }).state('oursourcing', {
		url: '/oursourcing',
		controller:'usersCtrl',
		templateUrl: 'views/admin/OutSourcing.html'
    }).state('interviewUsers', {
		url: '/interviewUsers',
		controller:'usersCtrl',
		templateUrl: 'views/admin/interviewUsers.html'
    }).state('internUsers', {
		url: '/internUsers',
		controller:'usersCtrl',
		templateUrl: 'views/admin/internUsers.html'
    }).state('campusUsers', {
		url: '/campusUsers',
		controller:'usersCtrl',
		templateUrl: 'views/admin/campusUsers.html'
    }).state('trainingUsers', {
		url: '/trainingUsers',
		controller:'usersCtrl',
		templateUrl: 'views/admin/trainingUsers.html'
    });
	
	$urlRouterProvider.otherwise('/dashboard');
});	
angular.module('pcAdminModule').run(function($rootScope){
	$rootScope.$on('$stateChangeStart',function(event, toState, toParams, fromState, fromParams){ 
		    document.body.scrollTop=0;
		});
});
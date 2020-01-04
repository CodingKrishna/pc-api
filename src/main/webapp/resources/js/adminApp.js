var adminApp = angular.module('pcAdminModule',['ui.router', 'datatables', 'ngSanitize', 'ngMessages','pcModule']);

adminApp.controller('pcAdminCtrl', function($scope, $state, $rootScope,$timeout,$window,commonService,userService){
	$scope.login = {};
	$scope.checkLogin=function(){
		commonService.getLogUserInfo('adminInfo').then(function(res){
			$scope.isAdminLoggedIn=true;
		},function(err){
			$scope.isAdminLoggedIn=false;
			$state.go('login');
		});
	};
	
	$scope.doLogin=function(){
		$scope.logFormMessage=undefined;
		$scope.formLoader=true;
		commonService.doLogin($scope.login).then(function(res){
			if (res.role === null) {
				commonService.setLogUserInfo('adminInfo',res).then(function(res){
					$scope.isAdminLoggedIn=true;
					$scope.formLoader=false;
					$scope.login={};
					$state.go('dashboard');
				});
			} else{
				$scope.isAdminLoggedIn=false;
				$scope.logFormMessage="FAILED";
				$scope.formLoader=false;
			}
		},function(err){
			$scope.isAdminLoggedIn=false;
			$scope.logFormMessage="FAILED";
			$scope.formLoader=false;
		});
	};
	$scope.logout=function(){
		if(typeof(Storage) !== "undefined") {
			sessionStorage.removeItem('adminInfo');
			$scope.isAdminLoggedIn=false;
			$state.go('login');
		}
	};
	
	$('.widget-pages li>ul').parent().addClass('has-child');
	$('.widget-pages li>a').on( 'click', function(e) {
	  e.stopPropagation();
	});
	$('body').on('click', '.widget-pages li', function(e) {
	  e.stopPropagation();

	  if( $(this).children('ul').length ) {
	    $(this).children('ul').slideToggle(500);   
	    $(this).toggleClass('active');
	    $(this).children('ul').toggleClass('active');
	  } 
	});
	var widget_hover = $('.widget-navigation a');

	jQuery(widget_hover).each(function (){
	  $(this).mouseout(function(e) {
	    $(this).parent().removeClass('hover');
	  });
	  $(this).mousemove(function(e) {
	    $(this).parent().addClass('hover');
	  });
	});
	
	$scope.checkLogin();
});

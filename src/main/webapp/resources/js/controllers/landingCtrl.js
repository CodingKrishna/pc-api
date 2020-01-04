var app = angular.module('pcModule');
app.controller('landingCtrl', function($scope, $interval, $timeout) {
	
	var landingPanels = ['#landing-panel-1', '#landing-panel-2', '#landing-panel-3'];
	$interval(function() {
		$(landingPanels[0]).removeClass('fadeIn').addClass('fadeOut');
		$timeout(function() {
			landingPanels.forEach(function(id, index) {
				$(id).css('zIndex', 0);
			});
			$(landingPanels[1]).removeClass('fadeOut').addClass('fadeIn').css('zIndex', 1);
			var temp = landingPanels.splice(0, 1)[0];
			landingPanels.push(temp);
		}, 1000);
	}, 8000);
	
	options = {
		useEasing : false,
		useGrouping : false,
		separator : ',',
		decimal : '.'
	};
	
	$scope.slides = [{
		id: 1,
		label: 'slide #1',
		img: 'resources/img/home/slider1.png',
		color: '#DDD',
		// odd: (i % 2 === 0)
	}, {
		id: 2,
		label: 'slide #2',
		img: 'resources/img/home/slider2.png',
		color: '#AAA',
		// odd: (i % 2 === 0)
	}, {
		id: 3,
		label: 'slide #3',
		img: 'resources/img/home/slider3.png',
		color: '#888',
		// odd: (i % 2 === 0)
	}];
	
	angular.element(document).ready(function () {
		$('.carousel-demo').ready(function() {
			$('.carousel-demo').height($('.carousel-demo').find('img').height());
		});
		$timeout(function() {
			$('.carousel-demo').height($('.carousel-demo').find('img').height());
		}, 500);
	});
	
	/*var counts = {
		course: new CountUp("courseCount", 0, 15, 0, 1, options),
		student: new CountUp("studentsCount", 0, 150, 0, 3, options),
		lesson: new CountUp("lessonsCount", 0, 54, 0, 2, options),
		events: new CountUp("eventsCount", 0, 250, 0, 4, options)
	};
	
	var started = false;
	document.body.onscroll = function(evnet) {
		if(!started && document.body.scrollTop > 800) {
			started = true;
			counts.course.start();
			counts.student.start();
			counts.lesson.start();
			counts.events.start();
		}
	};*/

});
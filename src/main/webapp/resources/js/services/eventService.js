app.service('eventService',function($q,$http){
	var self = this;
	self.bookEvents = bookEvents;
	self.getAllEventsByUserId = getAllEventsByUserId;
	self.getAllEvents = getAllEvents;
	self.getPurchasedCoursesById = getPurchasedCoursesById;
	/*Retrives All events*/
	function getAllEvents() {
		var defer = $q.defer();
		$http.get('event/eventslist').then(function(res) {
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
	/* Handler for booking an event*/
	function bookEvents(eventObj) {
		var defer = $q.defer();
		$http.post('event/eventpaticipant',eventObj).then(function(res) {
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
	/*Retrieves user booked events*/
	function getAllEventsByUserId(userId) {
		var defer = $q.defer();
		$http.get('event/eventparticipantsbyuserid?userId='+userId).then(function(res) {
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
	
	function getPurchasedCoursesById(userId) {
		var defer = $q.defer();
		$http.get('course/purchasedcourses?userId='+userId).then(function(res) {
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

});
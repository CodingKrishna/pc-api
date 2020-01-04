angular
		.module('pcModule')
		.controller(
				'trainingDetailsCtrl',
				function($scope, $http, $stateParams, $timeout, $state,
						commonService) {
					$scope.upComingBatchTimings = [];
					$scope.showAddToCart = undefined;
					$scope.init = function(courseId) {
						$scope.getCourseInfo(courseId);
						$scope.getBatchTimingsById(courseId);
						commonService.getLogUserInfo('userInfo').then(
								function(res) {
									$scope.loggedInUser = res;

								}, function(error) {
									console.error(error);
								});

					};
					$scope.getBatchTimingsById = function(courseId) {
						$http
								.get('course/batchdetails?courseId=' + courseId)
								.success(
										function(res) {
											if (res.isSuccess) {
												$scope.upComingBatchTimings = res.response;
											}
										});
					};
					$scope.reviews = [
							{
								author : "Raman. J",
								reviewdOn : new Date(2017, 1, 1, 11, 24, 25),
								rating : 4.5,
								reviewComment : "I have attended a few other courses and this was by far the best. Bhaskar is a great instructor. I will request him again next time."
							},
							{
								author : "Pavani",
								reviewdOn : new Date(2017, 1, 3, 15, 33, 43),
								rating : 5,
								reviewComment : "great teacher, great class. You could tell he genuinely cared about making the material interesting and comprehensible to everyone. Great attitude about teaching, highly recommended"
							} ];
					// retrieves course info by course Id
					$scope.getCourseInfo = function(courseId) {
						$http.get('course/courseinfo/' + courseId).success(
								function(res) {
									if (res.isSuccess) {
										$scope.course = res.response;
									}
								});
					};

					if ($stateParams.courseId) {
						$scope.init($stateParams.courseId);
					} else {
						$state.go('courseshome');
					}
					// Retrieves all the courses by user id
					$scope.getPurchasedCoursesById = function(userId) {
						$http
								.get('course/purchasedcourses?userId=' + userId)
								.then(
										function(res) {
											if (res.data.isSuccess
													&& res.data.response.length) {
												$scope.purchasedCoursesList = res.data.response;
												for (var i = 0; i < $scope.purchasedCoursesList.length; i++) {
													var courses = JSON
															.parse($scope.purchasedCoursesList[i].purchasedCourseDetails);
													for (var j = 0; j < courses.length; j++) {
														if (courses[j].id == parseInt($stateParams.courseId)) {
															$scope.showAddToCart = !$scope.showAddToCart;
														}
													}

												}
											}

										});

					};
					if ($scope.loggedInUser) {
						$scope.getPurchasedCoursesById($scope.loggedInUser.id);

					}
				});

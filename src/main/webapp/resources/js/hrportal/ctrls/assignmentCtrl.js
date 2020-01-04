angular.module('pcModule').controller('assignmentCtrl',function($scope,commonService,desktopService,$timeout,$interval,$rootScope,$http){
	$scope.disableButton = false;
	$scope.questionsList ={};
	$scope.testRoundQuestions={};
	$scope.selectedjob = {};
	$scope.selectedFile = {};
	$scope.restrictOnlineTest = {};
	$scope.mailCandidate = {};
	$scope.activateIfBackButton = {};
	$scope.shortlistedCandidates = {};
	$scope.allTests = [];
	$scope.allassignedpublicinterviews=[];
	$scope.restrictedtest = {};
	$scope.restrictedtestbydates = {};
	$scope.interviewCandidates = {};
	$scope.allInterviewGroups = {};
	$scope.SelectedGroupsForInterviewByTestId = [];
	$scope.groupCandidates = {};
	$scope.savedInterviewGroup = {};
	$scope.tasksList = [];
	$scope.taskList = [];
	$scope.codingQuestionsList = [];
	$scope.showQues = true;
	$scope.finalalltests = [];
	$scope.finaltestlist = [];
	var compileBoxLanguages={"c_cpp":7, "java":8};
	$scope.init = function(){
		{
			commonService.getLogUserInfo('userInfo').then(function(res){
				if(res){
					$scope.loggedInUser = res;
					if(res.role.id == 6 || res.role.id == 2){
						$scope.getAllTests();
					}
					if(res.role.id == 7){
						$scope.getPrivateTestList();
					}
					$scope.getRoundsList();
					$scope.getTechnologiesList();
					$scope.getInterviewTypesList();
					$scope.getQuizResultsByUserId();
					$scope.getAllInterviewGroups();
					$scope.getJobsbyHrId();
					
				}
			},function(err){
				$scope.loggedInUser = null;
			});
	};
	};
	$scope.saveTestInfo =function(){
	/*	if($scope.selectedFile){
			var type = $scope.selectedFile.type.split('/')[1];
		}*/
	//	var test = {};
		$scope.test.user = {};
		$scope.test.user.id = $scope.loggedInUser.id;
		desktopService.saveTestInfo($scope.test).then(function(res){
			if(res) {
	
				//$scope.companiesList.push(res);
				$scope.selectedjob.test = res;
				$scope.selectedjob.job = res.jobInfo;
				$scope.finaltestlist.push(res);
				$scope.saveJobTest();
				$scope.test = {};
				$scope.testSucMsg = "Test Added Successfully";
				$scope.disableButton = true;
				$timeout(function(){
					$scope.testSucMsg = undefined;
					$scope.disableButton = false;
					$scope.toggleBoolean('showPopup');
					
				},1000);
				
			}else{
				$scope.companySucMsg = "Error While Saving Test Details";
			}
		});
	};
	
	$scope.loadTechnologies = function(query) {
		return $scope.technologiesList;
	};
	$scope.loadRounds = function(query) {
		return $scope.roundsList;
	};
	
	$scope.getTechnologiesList =function(){
		desktopService.getTechnologiesList().then(function(res){
			if(res) {
				$scope.technologiesList =res.res;
				
			}else{
				$scope.msg = "No Technologies Available..";
			}
		});
	};
	
	$scope.getRoundsList =function(){
		desktopService.getRoundsList().then(function(res){
			if(res) {
				$scope.roundsList =res.res;
				
			}else{
				$scope.msg = "No Test Rounds Available..";
			}
		});
	};
	
	$scope.getPrivateTestList = function() {
		$http.get("test/getprivatetestlist?userId="+$scope.loggedInUser.id).success(function(res) {
			if (res.isSuccess) {
				$scope.PrivateTestList  = res.response;
				$scope.getAllTestList();
			}
		});
	};
	
	$scope.getAllTestList =function(){
		desktopService.getAllTestList($scope.loggedInUser.id).then(function(res){
			if(res) {
				$scope.testList =res.res;
				for(var i=0;i<$scope.PrivateTestList.length;i++){
					$scope.testList.push($scope.PrivateTestList[i]);
				}
				if($scope.finaltestlist.length == 0){
					$scope.finaltestlist = Array.from($scope.testList);
				}
				
				
			}else{
				$scope.msg = "No Tests Available..";
			}
		});
	};
	
	$scope.getQuestions =function(tech,rounds,selectedrounds,selectedtest){
		$scope.groupdisplay = "false";
		$scope.questiondisplay = "true";
		var req = {};
		req.technologies=[];
		req.round=[];
		$scope.selectedrounds = selectedrounds;
		$scope.selectedtest = selectedtest;
		for(var i=0;i<tech.length;i++){
			req.technologies[i] =tech[i].technologies;
		}
		$scope.currentPanel = selectedrounds.patternName;
		req.round.push(selectedrounds);
		desktopService.getQuestionsForUsers($scope.selectedtest.id,$scope.currentPanel).then(function(res){
			$scope.alreadyassignedquestions = res.data.response;
				desktopService.getQuestions(req).then(function(res){
					if(res) {
						
						for(var i=0;i<$scope.alreadyassignedquestions.length;i++){
							for(var k=0;k<res.res.length;k++){
								if($scope.alreadyassignedquestions[i].id == res.res[k].id){
									res.res[k].selected = true;
								}
							}
						}
						$scope.questionsList ={};
						if(req.round[0].patternName == 'Quiz'){
							res.res.forEach(function(task) {
								if (!$scope.questionsList[task.quesGroup]) {
									$scope.questionsList[task.quesGroup] = [];
								}
								$scope.questionsList[task.quesGroup].push(task);
							});
						}else if(req.round[0].patternName == 'Tasks'){
							$scope.tasksList = res.res;
						}else if(req.round[0].patternName == 'Coding'){
							$scope.codingQuestionsList = res.res;
						}
						
							
						}else{
						$scope.msg = "No Questions Available..";
					}
				});
		});
				
			};
	// toggle function to toggle the views
	$scope.toggleBoolean = function(prop) {
		$scope[prop]= !$scope[prop];
	};
	$scope.togglePopup = function(prop) {
		$scope[prop]= !$scope[prop];
	};
	
	/*Calender End*/
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
	  $scope.slideToTest = function() {
			$scope.showtests = 'slide-page-right';
			if($scope.loggedInUser.role.id == 6 || $scope.loggedInUser.role.id == 2){
				if($scope.activateIfBackButton == true){
					$scope.examSubmit();
				}
			}
			
			
		};
		
		$scope.slideToQuestions = function() {
			$scope.showtests = 'slide-page-left';
		};
		
		
		$scope.assigningQuestions= function(data){
			var finalQuestionsList = [];
			var finalTaskList = [];
			var finalCodingQuestionsList = [];
			if($scope.questionsList[data]){
				for(var i=0;i<$scope.questionsList[data].length;i++){
					if($scope.questionsList[data][i].selected==true){
						delete $scope.questionsList[data][i].selected;
						finalQuestionsList.push($scope.questionsList[data][i]);
					}
				}
				$scope.testRoundQuestions.objectQuestions = finalQuestionsList;
			}
			
			for(var j=0;j<$scope.tasksList.length;j++){
				if($scope.tasksList[j].selected==true){
					delete $scope.tasksList[j].selected;
					finalTaskList.push($scope.tasksList[j]);
				}
			}
			
			for(var j=0;j<$scope.codingQuestionsList.length;j++){
				if($scope.codingQuestionsList[j].selected==true){
					delete $scope.codingQuestionsList[j].selected;
					finalCodingQuestionsList.push($scope.codingQuestionsList[j]);
				}
			}
			
			$scope.testRoundQuestions.rounds = $scope.selectedrounds;
			$scope.testRoundQuestions.taskQuestions = finalTaskList;
			$scope.testRoundQuestions.codingTestQuestions = finalCodingQuestionsList;
			$scope.testRoundQuestions.test = $scope.selectedtest;
			desktopService.assigningQuestions($scope.testRoundQuestions).then(function(res){
				if(res.data.isSuccess){
					$scope.testRoundQuestions.objectQuestions = [];
					if(res.data.response>0){
						$scope.successMsg = "Questions Assined Successfully..";
						$scope.intrTasks = undefined;
					}else{
						$scope.errorMsg = "Error occured while Assinging Questions.";
						$scope.intrTasks= undefined;
					}
					$timeout(function(){
						$scope.successMsg = undefined;
						$scope.errorMsg = undefined;
					},1000);
				}
			});
		};
		
		function timeIsUp (){
		/*	if($scope.stopexambytimer = true){*/
				$scope.examSubmit();
			/*	$scope.stopexambytimer = false;
			}*/
		};
		
		$scope.getAllTests =function(){
			desktopService.getAllTests($scope.loggedInUser.id).then(function(res){
				if(res) {
					$scope.allassignedpublicinterviews =res.res;
					$scope.getinterviewassigntousersbyuserid();
					
				}else{
					$scope.msg = "No Tests Available..";
				}
			});
		};
		
		$scope.getinterviewassigntousersbyuserid = function() {
			$scope.allTests = Array.from($scope.allassignedpublicinterviews);
			if($scope.loggedInUser.role.id == 2){
				$scope.finalalltests = Array.from($scope.allTests);
			}
			if($scope.loggedInUser.role.id == 6){
				$http.get("test/getinterviewassigntousersbyuserid?userId="+$scope.loggedInUser.id).success(function(res) {
					if (res) {
							$scope.interviewAssignedToUserList  = res.response;
							if($scope.finalalltests == 0){
								for(var i=0;i<$scope.interviewAssignedToUserList.length;i++){
									$scope.allTests.push($scope.interviewAssignedToUserList[i].test);
								}
								$scope.finalalltests = Array.from($scope.allTests);
							}
						
					}else{
						$scope.msg = "no tests";
					}
				});
			}
		};
		
		$scope.restrictUsersOnlineTest = function() {
			$http.post("test/restrictusersonlinetest",$scope.restrictOnlineTest).success(function(res) {
				if (res.isSuccess) {
					$scope.restrictedtest.result  = res.response;
					$scope.showtests = 'slide-page-left';
					$scope.checkpopup = true;
					if($scope.restrictedtest.result == 0 && $scope.restrictedtestbydates.result == 1){
						desktopService.getQuestionsForUsers($scope.restrictOnlineTest.test.id,$scope.currentPanel).then(function(res){
							$scope.activateIfBackButton = true;
							if($scope.currentPanel == 'Quiz'){
							if(res) {
								$scope.testQuestions =res.data.response;
								for(var i=0;i<$scope.testQuestions.length;i++){
									$scope.testQuestions[i].index = i;
								}
								$scope.current = $scope.testQuestions[0];
								$timeout(Prism.highlightAll, 0);
								$scope.stopexambytimer = true;
								$(function(){  
									$("#ms_timer_one").countdowntimer({
										minutes : $scope.testQuestions.length*1,
										seconds : 00,
										size : "size_md",
										tickInterval:1,
										timeUp:timeIsUp
									});
								});
								
							}else{
								$scope.msg = "No Test Questions Available..";
							}
							
						}if($scope.currentPanel == 'Coding'){
							if(res){
								$scope.codingQstnsList =res.data.response;
							}else{
								$scope.msg = "No Programms are Available..";
							}
						}if($scope.currentPanel == 'Tasks'){
							if(res.data.response){
								for(var i=0;i<res.data.response.length;i++){
									res.data.response[i].images = [];
									if(res.data.response[i].imagePath!=undefined){
										var images = res.data.response[i].imagePath.split('@@');
										for(var j=0;j<images.length;j++){
											res.data.response[i].images.push(images[j]);
										}
									}
								}
								$scope.tasksList =res.data.response;
							}else{
								$scope.msg = "No Tasks are Available..";
							}
						}
					});
					}else{
						$scope.IsCompleted = true;
					}

					
				}
			});
		};
		
		$scope.restrictUsersOnlineTestByDates = function() {
			var fromDate = new Date($scope.exam.test.startDate);
			var endDate = new Date($scope.exam.test.endDate);
			var year = fromDate.getFullYear();
			var month = fromDate.getMonth()+1;
			var date = fromDate.getDate();
			var finalfromDate = year+"-"+ month +"-"+date;
			var toyear = endDate.getFullYear();
			var tomonth = endDate.getMonth()+1;
			var todate = endDate.getDate();
			var finaltoDate = toyear+"-"+ tomonth +"-"+todate;
			$http.get("test/restrictusersonlinetestbydates?fromDate="+finalfromDate+"&toDate="
																		+finaltoDate+"&testId="+$scope.exam.test.id).success(function(res) {
				if (res.isSuccess) {
					$scope.restrictedtestbydates.result  = res.response;
					$scope.restrictUsersOnlineTest();
				}
			});
		};
		
		$scope.getQuestionsForUsers =function(testId,round,test){
			if(testId){
				$scope.maintainTestId = testId;
			}if(round){
				$scope.roundId = round;
			}if(test){
				$scope.testId = test;
			}
			$scope.testQuestions = [];
			$scope.exam = {};
			$scope.exam.testRounds={};
			$scope.exam.test={};
			$scope.exam.rounds = $scope.roundId.testRounds;
			$scope.exam.test = $scope.testId ;
			$scope.currentPanel = $scope.roundId.testRounds.patternName;
			$scope.restrictOnlineTest.test = {};
			$scope.restrictOnlineTest.rounds = {};
			$scope.restrictOnlineTest.user = {};
				$scope.restrictOnlineTest.test.id = $scope.maintainTestId;
				$scope.restrictOnlineTest.rounds.id = $scope.roundId.testRounds.id;
				$scope.restrictOnlineTest.user.id = $scope.loggedInUser.id;
				$scope.restrictUsersOnlineTestByDates();
			};
			
		 $scope.next = function(){
		        if($scope.current.index!=undefined) {
		        	var i = $scope.getIndex($scope.current.index, 1);
		            $scope.current = $scope.testQuestions[i];
		            $timeout(Prism.highlightAll, 0);
		        }
		    };
		    $scope.previous = function(){
		    	if($scope.current.index!=undefined) {
		        var i = $scope.getIndex($scope.current.index, -1);
		        $scope.current = $scope.testQuestions[i];
		    	}
		    };
		    $scope.getIndex = function(currentIndex, shift){
		        var len = $scope.testQuestions.length;
		        return (((currentIndex + shift) + len) % len);
		    };
		    
		    $scope.examSubmit = function() {
		    	$scope.exam.user = {};
		    	$scope.exam.questsList = {};
				$scope.exam.user.id = $scope.loggedInUser.id;
				$scope.exam.questsList = $scope.testQuestions;
				console.log($scope.exam);
				var req=angular.copy($scope.exam);
				for(var i=0;i<req.questsList.length;i++){
					delete req.questsList[i].index;
					
				}
				req.totalQuestions = $scope.exam.questsList.length;
				$scope.totalTestQuestions = req.totalQuestions;
				delete req.testRounds;
				$http.post("test/submitexam",req).success(function(res) {
					if (res.isSuccess) {
						$scope.activateIfBackButton = false;
						$scope.testQuestions =[];
						$scope.testSuccessMsg = res.response;
						/*$http.post("test/restrictusersonlinetest",$scope.restrictOnlineTest).success(function(res) {
							if (res.isSuccess) {
								$scope.restrictedtest.result  = res.response;
								if($scope.restrictedtest.result  == 0){*/
							if($scope.checkpopup == true){
								$scope.toggleAddPopup('showResults');
								$scope.checkpopup == false;
							}
						/*		}
							}
						});*/
						$scope.IsCompleted = true;
						$scope.getQuizResultsByUserId();
					}
				});
			};
			
			$scope.checkif = function() {
				$http.get("test/gettestresultsforuser?userId="+$scope.loggedInUser.id).success(function(res) {
					if (res.isSuccess) {
						console.log(res.response);
						$scope.quizResultsList  = res.response;
					}
				});
			};
			
			$scope.closePopup = function(){
				$scope.toggleAddPopup('showResults');
				$scope.testSuccessMsg = undefined;
			};
			$scope.getQuizResultsByUserId = function() {
				$http.get("test/gettestresultsforuser?userId="+$scope.loggedInUser.id).success(function(res) {
					if (res.isSuccess) {
						console.log(res.response);
						$scope.quizResultsList  = res.response;
					}
				});
			};
			
			$scope.showEditor = function(question,index){
				$scope.showEdiQuestion = true;
				$scope.showQues = false;
				$scope.questionInfo = question;
				if(typeof $scope.questionInfo.testCases === 'string'){
					$scope.questionInfo.testCases = JSON.parse($scope.questionInfo.testCases); 
				}
			//	$scope.questionInfo.code = "public class MyProgramm { public static void main(String[] args){/* write your code here*/ } }"
				$scope.index=index;
				$scope.slideToQuestions();
				 
				var editor = ace.edit('codeEditor1');
			    editor.setValue( $scope.questionInfo.sampleCode);
			};
			
			$scope.showQuesList= function(question){
				$scope.showEdiQuestion = false;
				$scope.showQues = true;
			};
			
			$scope.toggleAddPopup = function(param) {
				$scope[param] = !$scope[param];
			};
			
			$scope.uploadMyTaskFile = function (selectedFile, projectName, event,task) {
				/*Save the filePath in db*/
				$scope.obj = {};
				$scope.obj.user  = {};
				$scope.obj.test = {};
				$scope.obj.test.id = $scope.exam.test.id;
				$scope.obj.task = {};
				$scope.obj.task.id = task.id;
				$scope.obj.fileName = projectName+"."+selectedFile.name.split('.')[1];
				$scope.obj.user.id = $scope.loggedInUser.id;
				$http.post('interntask/adduploadedtasksfiles',$scope.obj).success(function(res){
					if(res.isSuccess) {
						if(!$scope.uploadingFile) {
							$scope.uploadingFile = "Uploading File for Task assinged By HR: " + projectName;
							if(selectedFile) {
								commonService.uploadTaskFile(selectedFile, projectName,$scope.loggedInUser.id+'-'+$scope.loggedInUser.userName).then(function() {
									$scope.togglePopup('$infoMsg');
									$scope.infoMsg = 'Uploaded Successfully';
									$scope.uploadingFile = null;
									selectedFile = null;
								}, function(error) {
									$scope.uploadingFile = null;
									/*console.error(error);*/
									$scope.infoMsg = 'Upload failed, Please try again';
									$scope.togglePopup('$infoMsg');
								});
							} else {
								$scope.togglePopup('$infoMsg');
								$scope.infoMsg = 'No File selected';
								window.setTimeout(function() {
									$scope.uploadingFile = null;
								}, 100);
							}
						}
					}
				});
				
				/*console.log(selectedFile, projectName, event);*/
			};
			
			/*$scope.runCode = function(aceId,preview,language){
				var editor = ace.edit(aceId);
			    var code = editor.getValue();
				$scope.codingQstnsList[$scope.index] = $scope.questionInfo;
				var codeEvaluationReq = {};
				codeEvaluationReq.language = language;
				codeEvaluationReq.code =  code;
				console.log(codeEvaluationReq.code);
				if($scope.questionInfo.inputs){
					codeEvaluationReq.inputs = $scope.questionInfo.inputs.split(' ');
					var finalInputs = [];
					console.log(codeEvaluationReq.inputs);
					for(var i=0;i<codeEvaluationReq.inputs.length;i++){
						if(i%2==1){
							finalInputs.push("\n");
						}else{
							finalInputs.push(codeEvaluationReq.inputs[i]);
						}
					}
					finalInputs.push(codeEvaluationReq.inputs[codeEvaluationReq.inputs.length-1]);
					codeEvaluationReq.inputs = finalInputs;
					
				}
				codeEvaluationReq.testCases = null;
				$scope.exicuteCode(codeEvaluationReq);
				
			};*/
			
			$scope.compileAndRunCode = function(aceId,previewId,language){
				  var editor = ace.edit(aceId);
			      var code = editor.getValue();
			      var codeEvaluationReq = {};
				  codeEvaluationReq.language = compileBoxLanguages[language];
				  codeEvaluationReq.code = code;
				  codeEvaluationReq.stdin="";
				  console.log(codeEvaluationReq.code);
				   
				   $http.post('http://106.51.33.145:10547/compile',codeEvaluationReq).then(function(res){
						if(res.data){
							if(previewId){
					        	var doc = document.getElementById(previewId).contentWindow.document; 
						        if(res.data.errors.length>0){
						        	doc.write(res.data.errors);
					        	}else {
					        		doc.write(res.data.output);
					        	}
						        doc.close();
					        }
						}
					});
				   
				   if(previewId){
			        	var doc = document.getElementById(previewId).contentWindow.document;  
			        	doc.write('Please wait for results, code is executing..');
			        	doc.close();
			       }
				   
			   };
			
			$scope.exicuteCode = function(codeEvaluationReq){
				$http.post('evaluvator/executecode',codeEvaluationReq).then(function(res){
					if(res){
						$scope.results = res.data;
						var pointsGained = 0;
						var countValue = 0;
						if($scope.results.testCases!=null){
							for(var i=0;i<$scope.results.testCases.length;i++){
								if($scope.results.testCases[i].result == "Passed"){
									countValue++;
								}
							}
							
							pointsGained = (10/$scope.results.testCases.length)*countValue;
						}
						console.log(pointsGained);
						if($scope.questionInfo.inputs){
							
						}else{
							var codingResult = {"codingTestQstn":{},"user":{},"test":{},"rounds":{}};
							codingResult.points = pointsGained;
							codingResult.codingTestQstn.id = $scope.questionInfo.id;
							codingResult.user.id = $scope.loggedInUser.id;
							codingResult.rounds.id = $scope.exam.rounds.id;
							codingResult.test.id = $scope.exam.test.id;
							
							$http.post('test/submitexam',codingResult).then(function(res){
								if(res){
									console.log(res);
								}
							});
						}
						
						if($scope.results.output){
							var arrayData =  $scope.results.output.split("@@");
							var finalResult = "";
							for(var i=0;i<arrayData.length;i++){
								finalResult = finalResult.concat(arrayData[i]).concat("</br>");
							}
							$scope.results.output = finalResult; 
						}
					};
				});
				
			};
			
			$scope.submitCode = function(aceId,preview,language){
				var editor = ace.edit(aceId);
			    var code = editor.getValue();
				$scope.codingQstnsList[$scope.index] = $scope.questionInfo;
				var codeEvaluationReq = {};
				codeEvaluationReq.language = language;
				codeEvaluationReq.code = code;
				console.log(codeEvaluationReq.code);
				codeEvaluationReq.testCases = $scope.questionInfo.testCases;
				$scope.exicuteCode(codeEvaluationReq);
				
			};
			
			$scope.togglePopup = function(name) {
				$scope.openedPopup = (name) ? (($scope.openedPopup === name) ? null : name) : null;  
			};
		
			//	$scope.next();
			//	$scope.previous();
			//	$scope.getIndex(currentIndex, shift);
				$scope.init();
				$scope.loadTechnologies();
				$scope.loadRounds();
			$scope.getQuizResultsByTestId = function(testId,jobInfo) {
				$scope.shortlistedCandidates.job = jobInfo;
				$http.get("test/gettestresultsforhr?testId="+testId).success(function(res) {
					if (res.isSuccess) {
						console.log(res.response);
						$scope.examResultsList  = res.response;
					}
				});
			};
			
			$scope.getJobsbyHrId = function() {
				$http.get("job/getjobs?hrId="+$scope.loggedInUser.id).success(function(res) {
					if (res.isSuccess) {
						console.log(res.response);
						$scope.jobsList  = res.response;
					}
				});
			};
			
			$scope.saveJobTest = function() {
				$http.post("test/savejobinterview",$scope.selectedjob).success(function(res) {
					if (res.isSuccess) {
						console.log(res.response);
						$scope.quizResultsList  = res.response;
					}
				});
			};
			
			$scope.getJobInterviewByTestId = function(testId) {
				$http.get("test/getjobinterviewbytestid?testId="+testId).success(function(res) {
					if (res.isSuccess) {
						console.log(res.response);
						$scope.jobinterview  = res.response;
					}
				});
			};
			
			/*$scope.saveShortlistedCandidates = function(studentId) {
				$scope.shortlistedCandidates.studentId = studentId;
				$http.post("job/createjobtrn",$scope.shortlistedCandidates).success(function(res) {
					if (res.isSuccess) {
						console.log(res.response);
						$scope.jobinterview  = res.response;
					}
				});
			};*/
			
			$scope.saveInterviewGroups = function() {
				$scope.groupCandidates.hrId = $scope.loggedInUser.id;
				delete $scope.groupCandidates.uploadCandidatesPath;
				$http.post("test/saveinterviewgroups",$scope.groupCandidates).success(function(res) {
					if (res.isSuccess) {
						console.log(res.response);
						$scope.savedInterviewGroup  = res.response;
						$scope.saveGroupsCandidates();
						$scope.getAllInterviewGroups();
						$scope.groupSucMsg = "Group Added Successfully";
						$scope.savedInterviewGroup = {};
					}
				});
			};
			
			$scope.selectUpload =function(selectedFile,path,event){
				$scope.selectedFile = selectedFile;
				var list = $scope.selectedFile.name.split(".");
				var fileExt = list[list.length-1];
				if(fileExt!='xlsx') {
					$scope.fileFormatMsg = 'Please upload .xlsx files only';
					 $scope.toggleBoolean('showPopup');
					 return;
				}
				if($scope.selectedFile){
					$scope.infoMsg = "uploaded Successfully";
				}else {
					$scope.infoMsg = "Please Choose the File first";
				}
			};
			
			$scope.saveGroupsCandidates = function() {
				var fd = new FormData();
				fd.append('file', $scope.selectedFile);
				fd.append('groupId', $scope.savedInterviewGroup.id);
				
				
				$http.post("test/uploadcandidatesinexcel",fd, {
					transformRequest: angular.identity,
					headers: {'Content-Type': undefined}
				}).success(function(res) {
					if (res.isSuccess) {
						console.log(res.response);
						$scope.savedInterviewGroup  = res.response;
					}
				});
			};
			
			$scope.getAllInterviewGroups = function(testId) {
				$http.post("test/getallinterviewgroups?loginId="+$scope.loggedInUser.id).success(function(res) {
					if (res.isSuccess) {
						for(var s=0;s<res.response.length;s++){
							res.response[s].selected = false;
						}
						if($scope.SelectedGroupsForInterviewByTestId.length > 0){
							for(var i=0;i<$scope.SelectedGroupsForInterviewByTestId.length;i++){
								for(k=0;k<res.response.length;k++){
										if($scope.SelectedGroupsForInterviewByTestId[i].singleInterviewGroup.id == res.response[k].id){
											res.response[k].selected = true;
										}
								}
							}
						}
						$scope.allInterviewGroups  = res.response;
					}
				});
			};
			
			$scope.getCandidatesByGroupId = function(groupId) {
				$http.get("test/getcandidatesbygroupid?groupId="+groupId).success(function(res) {
					if (res.isSuccess) {
						console.log(res.response);
						$scope.interviewCandidates  = res.response;
					}
				});
			};
			
			$scope.sendMail = function(candidate) {
				$scope.mailCandidate = candidate;
				$http.get("test/sendmail?Email="+$scope.mailCandidate.candidateEmail+
						"&userName="+$scope.mailCandidate.candidateName+
						"&phoneNumber="+$scope.mailCandidate.candidatePhoneNumber).success(function(res) {
					if (res.isSuccess) {
						$scope.mailSentSuccessfully = {};
						$scope.mailSentSuccessfully.id = candidate.id;
						$scope.mailSentSuccessfully.msg = "sent successfully";
					}
				});
			};
			
			
			$scope.saveShortlistedCandidates = function(studentId) {
				$scope.shortlistedCandidates.studentId = studentId;
				$scope.checkIfCandidateShortlisted();
				
				
			};
			
			$scope.checkIfCandidateShortlisted = function(studentId) {
				$http.get("job/getjobinfotrnbystudentid?studentId="+$scope.shortlistedCandidates.studentId+"&jobId="+$scope.shortlistedCandidates.job.id).success(function(res) {
					if (res.isSuccess) {
						$scope.checkShortlisted = {};
						console.log(res.response);
						$scope.checkShortlisted  = res.response;
						if($scope.checkShortlisted == 0){
							$http.post("job/createjobtrn",$scope.shortlistedCandidates).success(function(res) {
								if (res.isSuccess) {
									console.log(res.response);
									$scope.jobinterview  = res.response;
									$scope.shorlistedmsg = {};
									$scope.shorlistedmsg.id = studentId;
									$scope.shorlistedcandidatemsg.msg = {};
									$scope.shorlistedmsg.msg = "shortlisted";
								}
							});
						}else{
							$scope.shorlistedcandidatemsg = {};
							$scope.shorlistedcandidatemsg.id = studentId;
							$scope.shorlistedmsg.msg = {};
							$scope.shorlistedcandidatemsg.msg = "Already shortlisted";
						}
					}
				});
			};
			
			$scope.clearAll = function(){
				$scope.results = {};
			};
			
			$scope.getInterviewTypesList = function() {
				$http.get("test/getinterviewtypeslist").success(function(res) {
					if (res.isSuccess) {
						$scope.interviewTypes  = res.response;
					}
				});
			};
			
			
			
			$scope.saveSelectedGroupsForInterview = function(data) {
				$scope.selectedGroupsForInterview = {};
				$scope.selectedGroupsForInterview.interview = {};
				$scope.selectedGroupsForInterview.interviewGroups = [];
					$scope.selectedGroupsForInterview.interview.id = $scope.selectedTest.id;
					for(var i = 0;i<data.length;i++){
						if(data[i].selected == true){
							delete data[i].selected;
							$scope.selectedGroupsForInterview.interviewGroups.push(data[i]);
						}
					}
				$http.post("test/saveSelectedGroupsForInterview",$scope.selectedGroupsForInterview).success(function(res) {
					if (res.isSuccess) {
						$scope.savedgroupsuccessfully = true;
						$scope.savedgroupsuccess = "success";
						console.log(res.response);
					}else{
						$scope.groupsavingfailed = true;
						$scope.groupsavingfail = "failed";
					}
				});
			};
			
			$scope.getSelectedGroupsForInterviewByTestId = function() {
				$http.get("test/getSelectedGroupsForInterviewByTestId?interviewId="+$scope.selectedTest.id).success(function(res) {
					if (res.isSuccess) {
						$scope.SelectedGroupsForInterviewByTestId  = res.response;
						$scope.groupdisplay = "true";
						$scope.questiondisplay = "false";
						$scope.getAllInterviewGroups();
					}
				});
			};
			$scope.gettest = function(test) {
				$scope.selectedTest = test;
				$scope.getSelectedGroupsForInterviewByTestId();
			};
			
			
			
	$scope.init();
	$scope.loadTechnologies();
	$scope.loadRounds();
	
});
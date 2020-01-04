var app = angular.module('pcModule');
app.controller('tutorialsCtrl',function($scope,$http,$timeout,$stateParams,commonService){
	var topics = TOPICS_DATA;
	var compileBoxLanguages={"c_cpp":7, "java":8};
	
	$scope.init=function(){
		$scope.introModel = undefined;
		$scope.currentTopic={};
		$scope.contentLoader=false;
		$scope.currentTechnology = $stateParams.technologyKey;
		$scope.changeTechnology($stateParams.technologyKey);
		$timeout(Prism.highlightAll, 0);
		$scope.currentDate = new Date();
		$scope.result = "Run to get the Output...";
	};

	$scope.changeTechnology=function(technologyKey){
		$scope.currentTopics = topics[technologyKey];
		var topic = $scope.currentTopics[0];
		if($scope.currentTopics.length) {
			if($stateParams.conceptKey) {
				$scope.currentTopics.forEach(function(t) {
					topic = (t.topicName === $stateParams.conceptKey) ? t: topic;
				});
			}
			$scope.selectTopic(topic);
		}
	};
	$scope.selectTopic = function(currentModuleName) {
		document.body.scrollTop = '0';
		$scope.currentTopic = currentModuleName;
		$scope.getTemplate(currentModuleName);
		$('.tabs [data-tabs-id]')[0].click();
	};
	
	$scope.getTemplate = function(obj) {
		$scope.contentData=undefined;
		$scope.programsData=undefined;
		$scope.quizData=undefined;
		$scope.toggleBoolean('contentLoader');
		commonService.getTemplate(obj,'content').then(function(res){
			$scope.contentData=res;
			$scope.toggleBoolean('contentLoader');
			$timeout(Prism.highlightAll,20);
		}).then(function(res){
			commonService.getTemplate(obj,'programs').then(function(res){
				$scope.programsData=res;
				$timeout(Prism.highlightAll,20);
			});
			commonService.getTemplate(obj,'quiz').then(function(res){
				$scope.quizData=res;
				$timeout(Prism.highlightAll,20);
			});
		});
		window.scrollTo(0, 0);
	};
	
	
	/**  store quiz info if user is logged in. 
	 * 1) loop through all the quiz questions ans and compare with act answers in quiz html pages. 
	 * 2) prepare quiz details object and send to service using saveQuizResults() API to store.
	 */
	$scope.submitQuiz = function(){
		$scope.quizErrorMsg= undefined;
		$scope.quizSuccessMsg = undefined;
		$scope.quizObj.marks =0;
		for(var i=0; i<$scope.quizObj.actAnswers.length; i++) {
			if(!$scope.quizObj.selAnswers[i]) {
				$scope.quizErrorMsg="You missed question # "+(i+1);
				$scope.toggleBoolean('showPopup');
				return;
			}
			if($scope.quizObj.selAnswers[i] == $scope.quizObj.actAnswers[i]){
				$scope.quizObj.marks++;
			}
		}
		$scope.quizSuccessMsg = 'You scored :: ' + $scope.quizObj.marks +' out of ' + $scope.quizObj.actAnswers.length ;
		$scope.toggleBoolean('showPopup');
		// store quiz results in db.
		if($scope.loggedInUser && $scope.loggedInUser.id) {
			var quizInfoObj = {
				userId:$scope.loggedInUser.id,
				technology:$stateParams.technologyKey,
				topic:$scope.currentTopic.topicName,
				questions:$scope.quizObj.actAnswers.length,
				answered:$scope.quizObj.marks,
			};
			$http.post("user/addquiz",quizInfoObj).then(function(res){
				if(res.isSuccess) {
					
				}
			});
		};
	};
	
	
	$scope.tryYourSelf = function(btnId,topic){
		var model=$('#'+btnId).prev('pre')[0].innerText;
		if(topic == 'js'){
				var el = document.createElement( 'div' );
				el.innerHTML = model;
				var scriptElements = el.getElementsByTagName('script');
				$scope.javascript = scriptElements[0].innerHTML;	
				$scope.html=model.replace(/<script[^>]*>([\s\S]+?)<\/script>/gi,'');
		}else if(topic == 'css'){
			var el = document.createElement( 'div' );
			el.innerHTML = model;
			var styleElements = el.getElementsByTagName('style');
			$scope.css = styleElements[0].innerHTML;	
			$scope.html=model.replace(/<style[^>]*>([\s\S]+?)<\/style>/gi,'');
	}else{
			$scope.html = model;
		}
		$scope.toggleBoolean('showEditor');
	};
	
	$scope.tryJavaYourSelf = function(btnId,topic){
		var model=$('#'+btnId).prev('pre')[0].innerText;
		$scope.java= model;
		console.log($scope.java);
		$scope.toggleBoolean('showEditor');
	};
	
	$scope.toggleBoolean=function(state){
		$scope[state] = !$scope[state];
	};
	
	/**
	 * Ace editor for html code to run...
	 */
	 $scope.htmlcssjsContentOnLoaded = function(_editor,previewId) {
		  /*_editor.setOptions({
	        showGutter: true,
	        //maxLines: Infinity,
	        minLines: 1,
    		maxLines: 20,
	        //maxLines: 15,
	        showPrintMargin: false,
	        fontsize: '18px'
	      });*/
		 
		 // Editor part
	        var _session = _editor.getSession();
	        var _renderer = _editor.renderer;

	        // Options
	        //_editor.setReadOnly(true);
	        //_session.setUndoManager(new ace.UndoManager());
	        //_renderer.setShowGutter(true);

	        // Events
	        // _editor.on("changeSession", function(){
	        //   var aceDocumentValue = _session.getDocument().getValue();
	        //   var doc = document.getElementById("preview").contentWindow.document;  
	        //   doc.write(aceDocumentValue);
	        //   doc.close();
	          
	        //  });
	        
	        //_editor.gotoLine(1,0);
	        //_editor.focus();
	        
	        _session.on("change", function(){
	        	if(previewId){
	        		var aceDocumentValue = _session.getDocument().getValue();
	        		var doc = document.getElementById(previewId).contentWindow.document; 
	        		doc.write(aceDocumentValue);
	        		doc.close();
	        	}

	         });

	        if(previewId){
	        	var aceDocumentValue = _session.getDocument().getValue();
	        	var doc = document.getElementById(previewId).contentWindow.document;  
	        	doc.write(aceDocumentValue);
	        	doc.close();
	        	
	        }
	};
	 
	/**
	 * Run code in Ace- editor..
	 */
	 $scope.runCode = function(aceId,previewId,language) {
	      var editor = ace.edit(aceId);
	      var code = editor.getValue();
	      var codeEvaluationReq = {};
		  codeEvaluationReq.language = language;
		  codeEvaluationReq.code = code;
		  console.log(codeEvaluationReq.code);
		  $scope.result = 'code is executing wait for results..';
	      $http.post('evaluvator/executetrycode',codeEvaluationReq).then(function(res){
				if(res.data){
					if(res.data.compilationErrors){
						var arrayData =  res.data.compilationErrors.split("@@");
						var finalResult = "";
						for(var i=0;i<arrayData.length;i++){
							finalResult = finalResult.concat(arrayData[i]).concat("</br>");
						}
						
						$scope.result  = finalResult;
					}else if(res.data.output){
						var arrayData =  res.data.output.split("@@");
						var finalResult = "";
						for(var i=0;i<arrayData.length;i++){
							finalResult = finalResult.concat(arrayData[i]).concat("</br>");
						}
						
						$scope.result  = finalResult;
					}
					
					if(previewId){
			        	var doc = document.getElementById(previewId).contentWindow.document;  
			        	doc.write($scope.result);
			        	doc.close();
			        }
					
				};
			});
	      
	      if(previewId){
	        	var doc = document.getElementById(previewId).contentWindow.document;  
	        	doc.write($scope.result);
	        	doc.close();
	      }
	      
	    };
	    
	    /**
	     * this api used to compile and run the code.
	     */
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
	   
	   
	    
	$scope.init();
});
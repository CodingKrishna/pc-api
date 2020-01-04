angular.module('pcModule').directive('pcAccordion', function($compile, $timeout) {
	return {
		restrict: 'AE',
		controller: function($scope) {
			$scope.openItem = $scope.openItem || 0;
			$scope.height = [];
			$scope.zero = {
				height: 0
			};
			$scope.toggle = function(i) {
				$scope.openItem = $scope.openItem === i ? null : i;
			};
		},
		link: function(scope, el, attrs) {
			var itemSelector = 'accordion-item', titleSelector = 'accordion-item>accordion-title';
			// $timeout(function() {
				var items = el[0].querySelectorAll(itemSelector);
				for (var i in items) {
					if (angular.isObject(items[i])) {
						var title = items[i].querySelectorAll(titleSelector)[0];
						angular.element(items[i]).addClass('item').attr({'ng-class': '{\'open\':openItem == ' + i + '}'});
						angular.element(title).addClass('title').attr('ng-click', 'toggle(' + i + ')');
					}
				}
				$compile(angular.element(el).contents())(scope);
			// });
		}
	};
});

angular.module('pcModule').directive('options', function() {
	var defAnswers = ['a', 'b', 'c', 'd', 'e', 'f', 'g', 'h'];
	return {
		restrict: 'E',
		scope: {
			values: '@',
			id: '@',
			bindModel: '='
		},
		template:'	<div class="radio" ng-repeat="value in options track by $index">' +
				'		<input  type="radio" ng-attr-id="{{id}}radio{{$index}}" ng-model="bindModel[id]" value="{{qanswers[$index]}}" ng-attr-name="{{id}}">' +
				'		<label ng-attr-for="{{id}}radio{{$index}}" >{{value}}</label>' +
				'	</div>',
		link: function(scope, ele, attrs) {
			scope.options = JSON.parse(scope.values).values;
			scope.qanswers = [];
			for(var i=0; i<scope.options.length; i++) {
				scope.qanswers.push(defAnswers[i]);
			}
		}
	};
});

angular.module('pcModule').directive('htmlTemplate', function($compile, $parse) {
	return {
		restrict: 'E',
		link: function(scope, element, attr) {
			scope.$watch(attr.content, function() {
				element.html($parse(attr.content)(scope));
				$compile(element.contents())(scope);
			}, true);
		}
	};
});

angular.module('pcModule').directive('inputContainer', function($timeout) {
	return {
        restrict: 'A',
        link: function(scope, ele, attrs) {
            var element = ele[0];
            var input = $(element).find('input[type="text"], input[type="number"], input[type="search"], textarea');

            function _checkInputValue() {
                if ($(input).val() == '' || $(input).val() == null || $(input).val() == undefined) {
                    $(element).removeClass('has-value');
                } else {
                    $(element).addClass('has-value');
                }
            }
            $(element).addClass('input-container');
            $timeout(_checkInputValue, 50);
            $(input).focus(function() {
                $(element).addClass('has-focus');
            }).blur(function() {
                _checkInputValue();
                $(element).removeClass('has-focus');
            });
        }
    };
});

angular.module('pcModule').directive('flip', function() {
	return {
		restrict: 'E',
		transclude: {
			front: 'flipFront',
		    back: 'flipBack'
		},
		scope: {
			isFlipped: '='
		},
		template:	'<div class="flip-content" ng-class="{\'flipped\':isFlipped}">' +
					'	<div class="face front">' + 
					'		<div ng-transclude="front"></div>' +
					'	</div>' +
					'	<div class="face back">' +
					'		<div ng-transclude="back"></div>' +
					'	</div>' +
					'</div>',
		link: function(scope, element, attr) {
			var ele = angular.element(element[0]);
			var height = ele[0].querySelector('flip-front').firstElementChild.offsetHeight || 50;
			window.setTimeout(function() {
				ele[0].querySelector('.flip-content').style.height = height + 'px';
			}, 10);
		}
	};
});

angular.module('pcModule').directive('addressForm', function() {
	return {
		restrict: 'E',
		templateUrl: 'views/directives/user/address-form-template.html',
		scope: {
			addressModel: '=',
			editable: '=',
			types: '='
		},
		controller: function($scope) {
			$scope.$watch(function(editable) {
				$scope.flipped = !$scope.editable;
			});
		}
	};
});

// Education Form Directive
angular.module('pcModule').directive('educationForm',function(){
		return {
			restrict: 'E',
			templateUrl:'views/directives/user/education-form-template.html',
			scope: {
				types: '=',
				educationModel: '=',
				editable: '='
			},
			controller: function($scope){
				$scope.educationModel = $scope.educationModel || {};
				$scope.$watch(function(editable) {
					$scope.flipped = !$scope.editable;
				});
			}
		};
});

//Project Form Directive
angular.module('pcModule').directive('projectForm',function(){
		return {
			restrict: 'E',
			templateUrl:'views/directives/user/project-form-template.html',
			scope: {
				types: '=',
				projectModel: '=',
				editable: '='
			},
			controller: function($scope){
				$scope.projectModel = $scope.projectModel || {};
				$scope.$watch(function(editable) {
					$scope.flipped = !$scope.editable;
				});
			}
		};
});


// skillset directive
angular.module('pcModule').directive('skillsetDirective',function(){
	return {
		restrict: 'E',
		templateUrl:'views/directives/user/skillset-template.html',
		scope: {
			skillsetOptionsList: '=',
			selectedList: '=',
			isExpanded: '='
		},
		
		controller: function($scope){
			$scope.selectSkill = function(skill,index){
				$scope.selectedList.push(skill);
				$scope.skillsetOptionsList.splice(index,1);
				
			};
		$scope.removeSkill = function(skill,index) {
			$scope.selectedList.splice(index,1);
			$scope.skillsetOptionsList.push(skill);
		};
		}
	};
});

app.directive('tcFileInput', function() {
    return {
        restrict: 'E',
        transclude: true,
        require: '?ngModel',
        scope: {
            label: '@',
            ngModel: '=',
            required: '@',
            placeholder: '@'
        },
        template:   '<label class="tc-input-container has-value">' +
                    '   <span class="tc-label-text">{{label}}</span>' +
                    '   <div class="tc-input"><div class="p-t-10"><i class="fa fa-paperclip"></i> {{fileDisplayName || placeholder}}</div></div>' +
                    '   <input class="ng-hide" type="file" ' +
                    '</label>',/*multiple="true">*/
        link: function(scope, ele, attrs, ngModel) {
            if (!ngModel) return;
            scope.label = scope.label || 'Choose a file';
            scope.$watch('ngModel', function(file) {
                if(scope.required) {
                    ngModel.$setValidity('required', file && file.name ? true : false);
                }
                if(file) {
                    scope.fileDisplayName = file.name;
                } else {
                    scope.fileDisplayName = null;
                }
            });
            var fileInput = angular.element(ele).children().children()[2];
            angular.element(fileInput).on('change', function() {
                if(fileInput.files) {
                    ngModel.$setViewValue(fileInput.files[0]);
                    ngModel.$setDirty(true);
                    ngModel.$setTouched(true);

                    scope.$applyAsync();

                    if(scope.onChange) {
                        scope.onChange({'$file': fileInput.files[0]});
                    }
                }
            });
        }
    };
});
app.directive("question", function() {
	return {
		restrict: 'E',
		scope: {
			questionObj: '=',
			questionNo: '@',
		},
		template:'<div>'
			+ '<div ng-if="questionObj.quesType == \'choice\'"><b>{{questionObj.index+1}} </b><b ng-bind="questionObj.questionDesc"></b></div>'
			+ '<div ng-if="questionObj.quesType == \'code\'"><b>{{questionObj.index+1}}. </b><b><html-template content="questionObj.questionDesc"></html-template></b></div>'
			+ '<label class="exam-question width-100" ng-repeat="opt in questionObj.options track by $index">' 
			+ '<input ng-attr-name="{{questionObj.id}}"  ng-class="{\'checked\': questionObj.ans === opt }" class="option-input radio" ng-model="questionObj.ans" type="radio" value="{{opt}}"'
			+ ' &emsp;<span>{{$index+1}}.'
			+ '<span>{{opt.trim()}}</span>'
			+ '</span>'
			+ '</label>'
			+'</br>'
			+ '</div>',
		controller: function($scope,$timeout,$sce) {
			console.log($scope.questionObj);
			$timeout(Prism.highlightAll, 0);
			
			
		}
	};
});
// export table to excel
app.factory('Excel',function($window){
    var uri='data:application/vnd.ms-excel;base64,',
        template='<html xmlns:o="urn:schemas-microsoft-com:office:office" xmlns:x="urn:schemas-microsoft-com:office:excel" xmlns="http://www.w3.org/TR/REC-html40"><head><!--[if gte mso 9]><xml><x:ExcelWorkbook><x:ExcelWorksheets><x:ExcelWorksheet><x:Name>{worksheet}</x:Name><x:WorksheetOptions><x:DisplayGridlines/></x:WorksheetOptions></x:ExcelWorksheet></x:ExcelWorksheets></x:ExcelWorkbook></xml><![endif]--></head><body><table>{table}</table></body></html>',
        base64=function(s){return $window.btoa(unescape(encodeURIComponent(s)));},
        format=function(s,c){return s.replace(/{(\w+)}/g,function(m,p){return c[p];})};
    return {
        tableToExcel:function(tableId,worksheetName){
            var table=$(tableId),
                ctx={worksheet:worksheetName,table:table.html()},
                href=uri+base64(format(template,ctx));
            return href;
        }
    };
});

app.directive('bindContent', function() {
	  return {
	    require: 'ngModel',
	    link: function ($scope, $element, $attrs, ngModelCtrl) {
	      ngModelCtrl.$setViewValue($element.text());
	    }
	  }
	})
	
var SAMPLE_FILE_TEMPLATE	= '../common/gettemplate/c/introduction_tutorial?subdir1=content&subdir2=1-Introduction';
var SAMPLE_IMAGE_PATH		= '/common/getimage/JAVA/pclogo2/png';
var C_TOPICS =	[
	               {topicName:'Introduction to C',directory: 'C',subDir:'1-Introduction',content:'introduction_tutorial',programs:'introduction_programs',quiz:'introduction_quiz'},
	               {topicName:'Editor',directory: 'C',subDir:'2-Editor',content:'editor_tutorial',programs:'editor_programs'},
	               {topicName:'DataTypes',directory: 'C',subDir:'3-DataTypes',content:'datatypes_tutorial',programs:'datatypes_programs'},
	               {topicName:'Operators',directory: 'C',subDir:'4-Operators',content:'operators_tutorial',programs:'operators_programs'},
	               {topicName:'Control Statements',directory: 'C',subDir:'5-Control Statements',content:'control_statements_tutorial',programs:'control_statements_programs'},
	               {topicName:'Loops',directory: 'C',subDir:'6-Loops',content:'loops_tutorial',programs:'loops_programs'},
	               {topicName:'Arrays',directory: 'C',subDir:'7-Arrays',content:'arrays_tutorial',programs:'arrays_programs'},
	               {topicName:'Functions',directory: 'C',subDir:'8-Functions',content:'functions_tutorial',programs:'functions_programs'},
	               {topicName:'Recursive Fuctions',directory: 'C',subDir:'9-Recursive Functions',content:'recursive_functions_tutorial',programs:'recurssive_functions_programs'},
	               {topicName:'Standard Library Functions',directory: 'C',subDir:'10-StandardLibraryFunctions',content:'standard_lib_functions_tutorial',programs:'standard_library_functions_programs'},
	               {topicName:'Structures',directory: 'C',subDir:'11-Structures',content:'structures_tutorial',programs:'structures_programs'},
	               {topicName:'Structures Arrays',directory: 'C',subDir:'12-Structures-Array',content:'structures_array_tutorial',programs:'structures_array_programs'},
	               {topicName:'Pointers-1',directory: 'C',subDir:'13-Pointers-1',content:'pointers_tutorial',programs:'pointers1_programs'},
	               {topicName:'Pointers-2',directory: 'C',subDir:'14-Pointers-2',content:'pointers2_tutorial',programs:'pointers2_programs'},
	               {topicName:'Dynamic Memory allocation',directory: 'C',subDir:'15-Dynamic Memory allocation',content:'dynamicmemoryallocation_tutorial',programs:'dynamic_memory_allocation_programs'},
	               {topicName:'Call By Value And Reference',directory: 'C',subDir:'16-CallByValueAndReference',content:'callbyvalueandreference_tutorial',programs:'callbyvalue_programs'},
	               {topicName:'Files',directory: 'C',subDir:'17-Files',content:'files_tutorial',programs:'files_programs'},
	               {topicName:'Unions',directory: 'C',subDir:'18-Unions',content:'unions_tutorial',programs:'unions_programs'},
	               {topicName:'Interview Questions',directory: 'C',subDir:'19-Interview Questions',content:'interview_questions'},
	               {topicName:'Programs',directory: 'C',subDir:'20-Programs',content:'Programs'},
	              	                
                ];

var PROGRAMMING = [
                 	{topicName:'Java Programs',directory: 'programs',subDir:'Java Programs',content:'Java-Programs'}
                 ];

var JAVA_TOPICS = [
	                 {topicName:'Java History',directory: 'JAVA',subDir:'CoreJava\\1-HistoryOfJava',content:'historyOfJava_tutorial',programs:'historyOfJava_programs',quiz:'historyOfJava_quiz'},
	                 {topicName:'Introduction',directory: 'JAVA',subDir:'CoreJava\\2-Introduction',content:'IntroductiontoJava_tutorial',programs:'IntroductiontoJava_programs',quiz:'IntroductiontoJava_quiz'},
	                 {topicName:'Java features',directory: 'JAVA',subDir:'CoreJava\\3-Java features',content:'javaFeatures_tutorial',programs:'javaFeatures_programs',quiz:'javaFeatures_quiz'},
	                 {topicName:'Java Environment setup',directory: 'JAVA',subDir:'CoreJava\\4-Java Environment Setup',content:'javaEnvironmentSetup_tutorial',programs:'javaEnvironmentSetup_programs',},/*quiz:'javaEnvironmentSetup_quiz'*/
	                 {topicName:'Hello world program',directory: 'JAVA',subDir:'CoreJava\\5-Hello World Program',content:'helloWorldProgram_tutorial',programs:'helloWorldProgram_programs',quiz:'helloWorldProgram_quiz'},
	                 {topicName:'Variables',directory: 'JAVA',subDir:'CoreJava\\6-Variables',content:'variables_tutorial',programs:'variables_programs',quiz:'variables_quiz'},
	                 {topicName:'Datatypes',directory: 'JAVA',subDir:'CoreJava\\7-DataTypes',content:'datatypes_tutorial',programs:'datatypes_programs',quiz:'datatypes_quiz'},
	                 {topicName:'Operators',directory: 'JAVA',subDir:'CoreJava\\8-Operators',content:'operators_tutorial',programs:'operators_programs',quiz:'operators_quiz'},
	                 {topicName:'Expressions',directory: 'JAVA',subDir:'CoreJava\\12-Expressions',content:'expressions_tutorial',programs:'expressions_programs',quiz:'expressions_quiz'},
	                 {topicName:'Statements',directory: 'JAVA',subDir:'CoreJava\\9-Statements',content:'statements_tutorial',programs:'statements_programs',quiz:'statements_quiz'},
	                 {topicName:'Loops',directory: 'JAVA',subDir:'CoreJava\\10-Loops',content:'loops_tutorial',programs:'loops_programs',quiz:'loops_quiz'},
	                 {topicName:'Methods',directory: 'JAVA',subDir:'CoreJava\\11-Methods',content:'methods_tutorial',programs:'methods_programs',quiz:'methods_quiz'},
	                 {topicName:'Arrays',directory: 'JAVA',subDir:'CoreJava\\13-Arrays',content:'arrays_tutorial',programs:'arrays_programs',quiz:'arrays_quiz'},
	                 {topicName:'Introduction to OOPS',directory: 'JAVA',subDir:'CoreJava\\14-IntroductiontoOOPS',content:'introductiontoOOPS_tutorial',programs:'introductiontoOOPS_programs',quiz:'introductiontoOOPS_quiz'},
	                 {topicName:'Class Object',directory: 'JAVA',subDir:'CoreJava\\15-ClassObject',content:'classObject_tutorial',programs:'classObject_programs',quiz:'classObject_quiz'},
	                 {topicName:'Abstraction Encapsulation',directory: 'JAVA',subDir:'CoreJava\\16-AbstractionEncapsulation',content:'abstractionEncapsulation_tutorial',programs:'abstractionEncapsulation_programs',quiz:'abstractionEncapsulation_quiz'},
	                 {topicName:'Constructors',directory: 'JAVA',subDir:'CoreJava\\17-Constructors',content:'constructor_tutorial',programs:'constructor_programs',quiz:'constructor_quiz'},
	                 {topicName:'This keyword',directory: 'JAVA',subDir:'CoreJava\\18-This keyword',content:'thisKeyword_tutorial',programs:'thisKeyword_programs',quiz:'thisKeyword_quiz'},
	                 {topicName:'Method Overloading',directory: 'JAVA',subDir:'CoreJava\\24-MethodOverloading',content:'methodOverloading_tutorial',programs:'methodOverloading_programs',quiz:'methodOverloading_quiz'},
	                 {topicName:'Static keyword',directory: 'JAVA',subDir:'CoreJava\\20-Static keywords',content:'static_tutorial',programs:'static_programs',quiz:'static_quiz'},
	                 {topicName:'Final keyword',directory: 'JAVA',subDir:'CoreJava\\21-Final keyword',content:'finalKeyword_tutorial',programs:'finalKeyword_programs',quiz:'finalKeyword_quiz'},
	                 {topicName:'Inheritance',directory: 'JAVA',subDir:'CoreJava\\26-Inheritance',content:'inheritance_tutorial',programs:'inheritance_programs',quiz:'inheritance_quiz'},
	                 {topicName:'Super keyword',directory: 'JAVA',subDir:'CoreJava\\19-Super keyword',content:'superKeyword_tutorial',programs:'superKeyword_programs',quiz:'superKeyword_quiz'},
	                 {topicName:'Method Overriding',directory: 'JAVA',subDir:'CoreJava\\23-Overriding',content:'overriding_tutorial',programs:'overriding_programs',quiz:'methodOverriding_quiz'},
	                 {topicName:'Polymorphism',directory: 'JAVA',subDir:'CoreJava\\25-Polymorphism',content:'polymorphism_tutorial',programs:'polymorphism_programs',quiz:'polymorphism_quiz'},
	                 {topicName:'Interface',directory: 'JAVA',subDir:'CoreJava\\22-Interface',content:'interface_tutorial',programs:'interface_programs',quiz:'interface_quiz'},
	                 {topicName:'Abstract class',directory: 'JAVA',subDir:'CoreJava\\27-Abstractclass',content:'abstractClass_tutorial',programs:'abstractClass_programs',quiz:'abstractClass_quiz'},
	                 {topicName:'Access Modifiers',directory: 'JAVA',subDir:'CoreJava\\28-Access modifiers',content:'accessModifiers_tutorial',programs:'accessModifiers_programs',quiz:'accessModifiers_quiz'},
	                 /*{topicName:'Control Statements',directory: 'JAVA',subDir:'CoreJava\\29-Control statements',content:'controlStatements_tutorial',programs:'controlStatements_programs',quiz:'controlStatements_quiz'},*/
	                 {topicName:'Exception Handling',directory: 'JAVA',subDir:'CoreJava\\30-ExceptionHandling',content:'exceptionHandling_tutorial',programs:'exceptionHandling_programs',quiz:'exceptionHandling_quiz'},
	                 {topicName:'TryCatch',directory: 'JAVA',subDir:'CoreJava\\31-TryCatch',content:'tryCatch_tutorial',programs:'tryCatch_programs',quiz:'tryCatch_quiz'},
	                 {topicName:'Finally',directory: 'JAVA',subDir:'CoreJava\\32-Finally',content:'finally_tutorial',programs:'finally_programs',quiz:'finally_quiz'},
	                 {topicName:'Throw',directory: 'JAVA',subDir:'CoreJava\\33-Throw',content:'throw_tutorial',programs:'throw_programs',quiz:'throw_quiz'},
	                 {topicName:'Throws',directory: 'JAVA',subDir:'CoreJava\\34-Throws',content:'throws_tutorial',programs:'throws_programs',quiz:'throws_quiz'},
	                 {topicName:'Packages',directory: 'JAVA',subDir:'CoreJava\\35-Packages',content:'packages_tutorial',programs:'packages_programs',quiz:'packages_quiz'},
	                 {topicName:'Files',directory: 'JAVA',subDir:'CoreJava\\36-Files',content:'files_tutorial',programs:'files_programs',quiz:'files_quiz'},
	                 {topicName:'Strings',directory: 'JAVA',subDir:'CoreJava\\37-Strings',content:'strings_tutorial',programs:'strings_programs',quiz:'strings_quiz'},
	                 {topicName:'Multithreading',directory: 'JAVA',subDir:'CoreJava\\38-Multithreading',content:'multithreading_tutorial',programs:'multithreading_programs',quiz:'multithreading_quiz'},
	                 {topicName:'Multithreading Advanced',directory: 'JAVA',subDir:'CoreJava\\39-Multhithreadingadvanced',content:'multithreadingAdvanced_tutorial',programs:'multithreadingAdvanced_programs',},/*quiz:'multithreadingAdvanced_quiz'*/
	                 {topicName:'Collection',directory: 'JAVA',subDir:'CoreJava\\40-Collections',content:'collections_tutorial',programs:'collections_programs',quiz:'collections_quiz'},
	                 {topicName:'Collection Advanced',directory: 'JAVA',subDir:'CoreJava\\41-collectionsadvanced',content:'collectionsAdvanced_tutorial',programs:'collectionsAdvanced_programs',},/*quiz:'collectionsAdvanced_quiz'*/
	                 {topicName:'Generics',directory: 'JAVA',subDir:'CoreJava\\42-Generics',content:'generics_tutorial',programs:'generics_programs',quiz:'generics_quiz'},
	                 {topicName:'Annotations',directory: 'JAVA',subDir:'CoreJava\\43-Annotations',content:'annotations_tutorial',programs:'annotations_programs',quiz:'annotations_quiz'},
	                 {topicName:'JVM Internals',directory: 'JAVA',subDir:'CoreJava\\44-JVM internals',content:'jvmInternals_tutorial',programs:'jvmInternals_programs',quiz:'jvmInternals_quiz'},
	                 {topicName:'JAVA Packages',directory: 'JAVA',subDir:'CoreJava\\45-Java packages',content:'java packages',programs:'',quiz:'javapackages_quiz'},
	                 {topicName:'Interview Questions',directory: 'JAVA',subDir:'CoreJava\\46-InterviewQuestions',content:'interviewQuestions',programs:'',quiz:'interview-quiz'},
	                 {topicName:'Exercise Programs',directory: 'JAVA',subDir:'CoreJava\\47-Exercises',content:'exercises_tutorial',programs:'exercise_programs',}
	                 
                ];

var HTML_TOPICS=[
	         		{topicName:'Introduction To HTML',directory: 'HTML',subDir:'1-Introductiontohtml',content:'Introductiontohtml_tutorial',programs:'Introductiontohtml_programs',quiz:'Introductiontohtml_quiz'},
	         		{topicName:'Elements & Attributes',directory: 'HTML',subDir:'2-Elements',content:'elements_tutorial',programs:'elements_programs',quiz:'elements_quiz'},
	         		{topicName:'Headings ',directory: 'HTML',subDir:'17-Headings',content:'headings_tutorial',programs:'headings_programs',quiz:'headings_quiz'},
	         		{topicName:'Paragraphs',directory:'HTML',subDir:'6-Paragraphs',content:'paragraphs_tutorial',programs:'paragraphs_programs',quiz:'paragraphs_quiz'},
	         		{topicName:'Images',directory:'HTML',subDir:'12-Images',content:'images_tutorial',programs:'images_programs',quiz:'images_quiz'},
	         		{topicName:'Anchor Tags',directory:'HTML',subDir:'11-Anchor',content:'anchortag_tutorial',programs:'anchortag_programs',quiz:'anchortag_quiz'},
	         		{topicName:'Lists',directory:'HTML',subDir:'10-Lists',content:'lists_tutorial',programs:'lists_programs',quiz:'lists_quiz'},
	         		{topicName:'Tables',directory:'HTML',subDir:'8-Tables',content:'tables_tutorial',programs:'tables_programs',quiz:'tables_quiz'},
	         		{topicName:'Div',directory:'HTML',subDir:'9-Div',content:'div_tutorial',programs:'div_programs',quiz:'div_quiz'},
	         		{topicName:'Span',directory:'HTML',subDir:'7-Span',content:'span_tutorial',programs:'span_programs',quiz:'span_quiz'},
	         		{topicName:'Forms',directory:'HTML',subDir:'14-Forms',content:'forms_tutorial',programs:'forms_programs',quiz:'forms_quiz'},
	         		{topicName:'HTML Tags',directory: 'HTML',subDir:'3-HTMLTags',content:'htmltags_tutorial',programs:'htmltags_programs',quiz:'htmltags_quiz'},
	         		//{topicName:'Attributes',directory:'HTML',subDir:'4-Attributes',content:'htmlattributes_tutorial',programs:'htmlattributes_programs',quiz:'htmlattributes_quiz'},
	         		{topicName:'HTML page Layouts',directory:'HTML',subDir:'13-HTMLpageLayout',content:'htmlpagelayout_tutorial',programs:'htmlpagelayout_programs',quiz:'htmlpagelayout_quiz'},
	         		{topicName:'iframes',directory:'HTML',subDir:'5-iframes',content:'iframes_tutorial',programs:'iframes_programs',quiz:'iframes_quiz'},
	         		{topicName:'HTML5 Tags',directory: 'HTML',subDir:'17-html5tags',content:'html5_tutorial',programs:'html5_programs',quiz:'html5_quiz'},
	         		{topicName:'Exercises',directory:'HTML',subDir:'15-Exercises',content:'Examples'},
	         		{topicName:'Interview Questions',directory:'HTML',subDir:'16-InterviewQuestions',content:'interviewQuestions'}
	         		
	         ];
var CSS_TOPICS=[
	                {topicName:'Introduction To CSS',directory: 'CSS',subDir:'1-IntroductionToCSS',content:'introductionToCss_tutorial',programs:'IntroductionToCss_programs',quiz:'introductionToCss_quiz'},
	                {topicName:'CSS-Linking',directory: 'CSS',subDir:'24-cssLinking',content:'cssLinking_tutorial',programs:'cssLinking_programs',quiz:'cssLinking_quiz'},
	                {topicName:'Selectors',directory: 'CSS',subDir:'25-Selectors',content:'selectors_tutorial',programs:'selectors_programs',quiz:'selectors_quiz'},
	                {topicName:'Colors',directory: 'CSS',subDir:'2-Colors',content:'colors_tutorial',programs:'colors_programs',quiz:'colors_quiz'},
	                {topicName:'Fonts',directory: 'CSS',subDir:'11-Fonts',content:'fonts_tutorial',programs:'fonts_programs',quiz:'fonts_quiz'},
	                {topicName:'Text Alignments',directory: 'CSS',subDir:'10-Text',content:'text_tutorial',programs:'text_programs',quiz:'text_quiz'},
	                {topicName:'Overflow',directory: 'CSS',subDir:'20-Overflow',content:'overflow_tutorial',programs:'overflow_programs',quiz:'overflow_quiz'},
	                {topicName:'BoxModel & Borders',directory: 'CSS',subDir:'8-BoxModel',content:'boxModel_tutorial',programs:'boxmodel_programs',quiz:'boxModel_quiz'},
	                {topicName:'Outline',directory: 'CSS',subDir:'9-Outline',content:'outline_tutorial',programs:'outline_programs',quiz:'outline_quiz'},
	                {topicName:'HeightWidth',directory: 'CSS',subDir:'7-HeightWidth',content:'heightWidth_tutorial',programs:'heightwidth_programs',quiz:'heightWidth_quiz'},
	                {topicName:'Backgrounds',directory: 'CSS',subDir:'3-Backgrounds',content:'backgrounds_tutorial',programs:'backgrounds_programs',quiz:'backgrounds_quiz'},
	                {topicName:'Links & pseudo class',directory: 'CSS',subDir:'13-Links',content:'links_tutorial',programs:'links_programs',quiz:'links_quiz'},
	                {topicName:'Lists',directory: 'CSS',subDir:'14-Lists',content:'lists_tutorial',programs:'lists_programs',quiz:'lists_quiz'},
	                {topicName:'Tables',directory: 'CSS',subDir:'15-Tables',content:'tables_tutorial',programs:'tabels_programs',quiz:'tables_quiz'},
	                {topicName:'float',directory: 'CSS',subDir:'21-float',content:'float_tutorial',programs:'float_programs',quiz:'float_quiz'},
	                {topicName:'Position',directory: 'CSS',subDir:'19-Position',content:'position_tutorial',programs:'position_programs',quiz:'position_quiz'},
	                {topicName:'Display',directory: 'CSS',subDir:'17-Display',content:'display_tutorial',programs:'display_programs',quiz:'display_quiz'},
	                {topicName:'Opacity',directory: 'CSS',subDir:'16-Opacity',content:'opacity_tutorial',programs:'opacity_programs',quiz:'opacity_quiz'},
	                {topicName:'Boxshadow',directory: 'CSS',subDir:'26-boxshadow',content:'boxshadow_tutorial',programs:'boxshadow_programs',quiz:'boxshadow_quiz'},
	                {topicName:'Z-Index',directory: 'CSS',subDir:'27-Zindex',content:'zindex_tutorial',programs:'zindex_programs',quiz:'zindex_quiz'},
	                {topicName:'Custom Fonts',directory: 'CSS',subDir:'28-customfonts',content:'customfonts_tutorial',programs:'customfonts_programs',quiz:'customfonts_quiz'},
	                {topicName:'Animations',directory: 'CSS',subDir:'29-animations',content:'animations_tutorial',programs:'animations_programs',quiz:'animations_quiz'},
	                {topicName:'Flex',directory: 'CSS',subDir:'30-flex',content:'flex_tutorial',programs:'flex_programs',quiz:'flex_quiz'},
	               {topicName:'Media Queries',directory: 'CSS',subDir:'31-mediaqueries',content:'mediaqueries_tutorial',programs:'mediaqueries_programs',quiz:'mediaqueries_quiz'},
	                //{topicName:'Borders',directory: 'CSS',subDir:'4-Borders',content:'borders_tutorial',programs:'borders_programs',quiz:'borders_quiz'},
	                //{topicName:'Margins',directory: 'CSS',subDir:'5-Margins',content:'margins_tutorial',programs:'margins_programs',quiz:'margins_quiz'},
	                //{topicName:'Padding',directory: 'CSS',subDir:'6-Padding',content:'padding_tutorial',programs:'paddings_programs',quiz:'padding_quiz'},
	                //{topicName:'Icons',directory: 'CSS',subDir:'12-Icons',content:'icons_tutorial',programs:'icons_programs',quiz:'icons_quiz'},
	               // {topicName:'Max width',directory: 'CSS',subDir:'18-Max width',content:'maxWidth_tutorial',programs:'maxWidth_programs',quiz:'maxWidth_quiz'},
	                {topicName:'Exercises',directory:'CSS',subDir:'22-Exercises',content:'Examples'},
	                {topicName:'Interview Questions',directory: 'CSS',subDir:'23-InterviewQuestions',content:'interviewQuestions',programs:'float_programs',quiz:'float_quiz'},
               ];
var JS_TOPICS=[
	               {topicName:'Introduction',directory: 'JS',subDir:'1-IntroductionToJavascript',content:'introductionToJavascript_tutorial',programs:'introductionToJavascript_programs',quiz:'introductionToJavascript_quiz'},
	               {topicName:'JS Includes',directory: 'JS',subDir:'16-Jsincluds',content:'jsIncludes_tutorial',quiz:'jsIncludes_quiz'},
	               {topicName:'Variables',directory: 'JS',subDir:'2-Variables',content:'variables_tutorial',programs:'variables_programs',quiz:'variables_quiz'},
	               {topicName:'Datatypes',directory: 'JS',subDir:'3-Datatypes',content:'datatypes_tutorial',programs:'datatypes_programs',quiz:'datatypes_quiz'},
	               {topicName:'Operators',directory: 'JS',subDir:'4-Operators',content:'operators_tutorial',programs:'operators_programs',quiz:'operators_quiz'},
	               {topicName:'Statements',directory: 'JS',subDir:'5-Statements',content:'statements_tutorial',programs:'statements_programs',quiz:'statements_quiz'},
	               {topicName:'Loops',directory: 'JS',subDir:'6-Loops',content:'loops_tutorial',programs:"loops_programs",quiz:'loops_quiz'},
	               {topicName:'Functions',directory: 'JS',subDir:'7-Functions',content:'functions_tutorial',quiz:'functions_quiz'},
	               {topicName:'Function Types',directory: 'JS',subDir:'20-FunctionsTypes',content:'functions_type_tutorial',quiz:'functions_type_quiz'},
	               {topicName:'Arrays',directory: 'JS',subDir:'8-Arrays',content:'arrays_tutorial',quiz:'arrays_quiz'},
	               {topicName:'Scope',directory: 'JS',subDir:'21-scopes',content:'scope_tutorial',quiz:'scope_quiz'},
	               {topicName:'Events',directory: 'JS',subDir:'17-Events',content:'events_tutorial',quiz:'events_quiz'},
	               {topicName:'Objects',directory: 'JS',subDir:'9-Objects',content:'objects_tutorial',quiz:'objects_quiz'},
	               {topicName:'String Object ',directory: 'JS',subDir:'10-Strings',content:'strings_tutorial',quiz:'string_quiz'},
	               {topicName:'Date Object',directory: 'JS',subDir:'11-Dates',content:'dates_tutorial',quiz:'date_quiz'},
	               {topicName:'DOM',directory: 'JS',subDir:'12-DOM',content:'dom_tutorial',quiz:'dom_quiz'},
	               {topicName:'DOM-CSS',directory: 'JS',subDir:'19-DOM-CSS',content:'domcss_tutorial',quiz:'Domcss_quiz'},
	               {topicName:'Validations',directory: 'JS',subDir:'18-Validations',content:'validations_tutorial',quiz:'Validations_quiz'},
	               {topicName:'Regular Expressions',directory: 'JS',subDir:'13-regularExpressions',content:'regularExpressions	',quiz:'regularExpressions_quiz'},
	               {topicName:'Exercises',directory:'JS',subDir:'14-Exercises',content:'Examples',programs:'jsBasic_programs'},
	               {topicName:'Basic Programs',directory: 'JS',subDir:'22-BasicPrograms',content:'jsBasicPrograms_tutorials',quiz:'basicPrograms_quiz'},
	               {topicName:'Interview Questions',directory: 'JS',subDir:'15-InterviewQuestions',content:'interviewQuestions',quiz:''}
               ];

var ADVANCED_JS_TOPICS=[
               {topicName:'Introduction',directory: 'ADVANCED_JS',subDir:'1-introduction',content:'introductionToAdvancedJS_tutorial',programs:'introductionToReactJS_programs',quiz:'introductionToAdvancedJs_quiz'},
               {topicName:'Scope',directory: 'ADVANCED_JS',subDir:'2-scopes',content:'scopes_tutorial',programs:'introductionToReactJS_programs',quiz:'scope_quiz'},
               {topicName:'Prototyping',directory: 'ADVANCED_JS',subDir:'3-prototyping',content:'prototyping_tutorial',programs:'introductionToReactJS_programs',quiz:'protoTyping_quiz'},
               {topicName:'Introduction to OOPs',directory: 'ADVANCED_JS',subDir:'4-oops',content:'oops_introductoin_tutorial',programs:'introductionToReactJS_programs',quiz:''},
               {topicName:'Class',directory: 'ADVANCED_JS',subDir:'5-class',content:'class_tutorial',programs:'introductionToReactJS_programs',quiz:''},
               {topicName:'Inheritance',directory: 'ADVANCED_JS',subDir:'6-inheritance',content:'inheritance_tutorial',programs:'introductionToReactJS_programs',quiz:''},
               {topicName:'Static',directory: 'ADVANCED_JS',subDir:'7-static',content:'static_tutorial',programs:'introductionToReactJS_programs',quiz:''},
               {topicName:'Function Expression',directory: 'ADVANCED_JS',subDir:'8-function-expression',content:'function-expression-tutorial',programs:'introductionToReactJS_programs',quiz:''},
               {topicName:'Function Grouping',directory: 'ADVANCED_JS',subDir:'9-function-grouping',content:'function-grouping-tutorial',programs:'introductionToReactJS_programs',quiz:''},
               {topicName:'Callback Functions',directory: 'ADVANCED_JS',subDir:'10-callback-functions',content:'callback-functions-tutorial',programs:'introductionToReactJS_programs',quiz:''},
               {topicName:'Closure',directory: 'ADVANCED_JS',subDir:'11-closure',content:'closure-tutorial',programs:'introductionToReactJS_programs',quiz:''},
               {topicName:'Arrow Functions',directory: 'ADVANCED_JS',subDir:'12-arrow-functions',content:'arrow-functions-tutorial',programs:'introductionToReactJS_programs',quiz:''},
               {topicName:'Promise Functions',directory: 'ADVANCED_JS',subDir:'13-promise-functions',content:'promise-functions-tutorial',programs:'introductionToReactJS_programs',quiz:''},
               
               {topicName:'JSON',directory: 'ADVANCED_JS',subDir:'14-JSON',content:'json-tutorials',programs:'json-programs',quiz:''},
               {topicName:'XHR',directory: 'ADVANCED_JS',subDir:'15-XHR',content:'XHR-tutorial',programs:'introductionToReactJS_programs',quiz:'introductionToReactJS_quiz'},
               {topicName:'Errors and Exceptions',directory: 'ADVANCED_JS',subDir:'16-errors-exceptions',content:'errors-exceptions-tutorial',programs:'introductionToReactJS_programs',quiz:''},
               {topicName:'Regular Expression',directory: 'ADVANCED_JS',subDir:'17-regular-expression',content:'regular-expression-tutorial',programs:'introductionToReactJS_programs',quiz:''},
               ];

var REACT_JS_TOPICS=[
                        {topicName:'Introduction',directory: 'REACTJS',subDir:'1-IntroductionToReactJS',content:'introductionToReactJS_tutorial',programs:'introductionToReactJS_programs',quiz:''},
                        
                        ];

var ANGULARJS_TOPICS =[
                       {topicName:'Introduction to Angular',directory: 'ANGULARJS',subDir:'introductionToAngular',content:'introduction_tutorial'},
                       {topicName:'Environment Setup',directory: 'ANGULARJS',subDir:'envSetup',content:'envSetup_tutorial'},
                       {topicName:'Angular MVC',directory: 'ANGULARJS',subDir:'angularmvc',content:'angularmvc_tutorial'},
                       {topicName:'Angular Directives',directory: 'ANGULARJS',subDir:'directives',content:'directives_tutorial'},
                       {topicName:'Angular Controllers',directory: 'ANGULARJS',subDir:'AngularControllers',content:'angular_controllers'},
                       {topicName:'$scope & $rootScope',directory: 'ANGULARJS',subDir:'angularscopes',content:'angularscopes_tutorial'},
                       {topicName:'ng-repeat',directory: 'ANGULARJS',subDir:'ngrepeat',content:'ng-repeat_tutorial'},
                       {topicName:'Angular Forms',directory: 'ANGULARJS',subDir:'angularforms',content:'angularforms_tutorial'},
                       {topicName:'Angular Form Validations',directory: 'ANGULARJS',subDir:'angular form validations',content:'formvalidations_tutorial'},
                       {topicName:'Dependency Injection',directory: 'ANGULARJS',subDir:'dependency injection',content:'di_tutorial'},
                       {topicName:'Angular Filters',directory: 'ANGULARJS',subDir:'angular Filters',content:'angularfilters_tutorial'},
                       {topicName:'Angular Services',directory: 'ANGULARJS',subDir:'built-in services',content:'builtinservices_tutorial'},
                       {topicName:'Service and Factory',directory: 'ANGULARJS',subDir:'service and factory',content:'serviceandfactory_tutorial'},
                       {topicName:'Custom Directives',directory: 'ANGULARJS',subDir:'Custom Directives',content:'customdirectives_tutorial'},
                       {topicName:'Custom Filters',directory: 'ANGULARJS',subDir:'Custom Filters',content:'customfilters_tutorial'},
                       {topicName:'$http Service',directory: 'ANGULARJS',subDir:'http service',content:'httpservice_tutorial'},
                       {topicName:'AngularJs Projects',directory: 'ANGULARJS',subDir:'Exercises',content:'Examples'},
                       {topicName:'Inerview Questions',directory: 'ANGULARJS',subDir:'interviewQuestions',content:'interviewQuestions'},
                       ];
var NODEJS_TOPICS = [
                     {topicName:'Introduction',directory: 'NODEJS',subDir:'1-introductionToNode',content:'introduction-tutorial',quiz:'introduction_quiz'},
                     {topicName:'Environment Setup',directory: 'NODEJS',subDir:'2-environmentSetup',content:'environmentsetup-tutorial',quiz:'environmentsetup_quiz'},
                     {topicName:'HelloWorld Example',directory: 'NODEJS',subDir:'3-HelloWorld',content:'helloworld-tutorial',quiz:'helloworld_quiz'},
                     {topicName:'Basic Programms',directory: 'NODEJS',subDir:'10-Programms',content:'nodeProgramms_tutorial',quiz:'nodeProgramms_quiz'},
                     {topicName:'Node REPL',directory: 'NODEJS',subDir:'4-Node REPL',content:'nodeREPL-tutorial',quiz:'nodeREPL_quiz'},
                     {topicName:'Node Modules',directory: 'NODEJS',subDir:'5-Node Modules',content:'nodeModule-tutorial',quiz:'nodeModules_quiz'},
                     {topicName:'FS Module',directory: 'NODEJS',subDir:'7-fs Module',content:'fsModule-tutorial',quiz:'httpModule_quiz'},
                     {topicName:'Client/Server Architecture',directory: 'NODEJS',subDir:'12-client-server-architecture',content:'client-server-architecture-tutorial',quiz:'nodeModules_quiz'},
                     {topicName:'HTTP Module',directory: 'NODEJS',subDir:'6-HTTP Module',content:'httpModule-tutorial',quiz:'httpModule_quiz'},
                     {topicName:'Ways to Request Server Data',directory: 'NODEJS',subDir:'11-ways-to-request-server',content:'ways-to-request-serverdata-tutorial',quiz:'nodeModules_quiz'},
                     {topicName:'url Module',directory: 'NODEJS',subDir:'8-URL Module',content:'urlModule-tutorial',quiz:'httpModule_quiz'},
                     {topicName:'NPM Module',directory: 'NODEJS',subDir:'9-NPM Module',content:'npmModule-tutorial',quiz:'httpModule_quiz'},
                ];
var UICOMPONENTS_TOPICS=[ 
                         {topicName:'CSS Layouts',directory: 'UICOMPONENTS',subDir:'layouts',content:'css-layouts'},
                        /* {topicName:'UI Components',directory: 'UICOMPONENTS',subDir:'Exercises',content:'Examples'},*/
                         /*{topicName:'Components',directory: 'UICOMPONENTS',subDir:'components',content:'components'},*/
                         {topicName:'Buttons',directory: 'UICOMPONENTS',subDir:'2-Buttons',content:'buttons'},
                         {topicName:'Tabs',directory: 'UICOMPONENTS',subDir:'3-Tabs',content:'tabs'},
                         {topicName:'Badges',directory: 'UICOMPONENTS',subDir:'4-Badges',content:'badges'},
                         {topicName:'Loaders',directory: 'UICOMPONENTS',subDir:'5-Loaders',content:'loaders'},
                         {topicName:'Pop over',directory: 'UICOMPONENTS',subDir:'6-Popover',content:'popover'},
                         {topicName:'Progress Bars',directory: 'UICOMPONENTS',subDir:'7-Progress Bars',content:'progressbars'},
                         {topicName:'Accordian',directory: 'UICOMPONENTS',subDir:'8-Accordian',content:'accordian'},
                         {topicName:'Corousel',directory: 'UICOMPONENTS',subDir:'9-Corousel',content:'corousel'},
                         {topicName:'Pagination',directory: 'UICOMPONENTS',subDir:'10-Pagination',content:'pagination'},
                         {topicName:'Bread Crumbs',directory: 'UICOMPONENTS',subDir:'11-breadcrumbs',content:'breadcrumbs'},
                         {topicName:'Navbars',directory: 'UICOMPONENTS',subDir:'12-Navbars',content:'navbars'},
                         {topicName:'Cards',directory: 'UICOMPONENTS',subDir:'13-Cards',content:'cards'},
                         {topicName:'Panels',directory: 'UICOMPONENTS',subDir:'14-Panels',content:'panels'},
                         {topicName:'Toasters',directory: 'UICOMPONENTS',subDir:'15-Toasters',content:'toaster'},
                         {topicName:'Model Popup',directory: 'UICOMPONENTS',subDir:'16-Model Popup',content:'modelpopup'},
                         {topicName:'Color Palettes',directory: 'UICOMPONENTS',subDir:'17-Color Pallete',content:'colorpallette'},
                         ];

/*var J2EE_TOPICS=[
	                 {topicName:'IntroductionToJDBC',directory: 'J2EE',subDir:'Jdbc\\1-IntroductiontoJDBC',content:'Introductiontojdbc_tutorial',programs:'Introductiontojdbc_programs',quiz:'Introductiontojdbc_quiz'},
	                 {topicName:'IntroductiontoRDBMS',directory: 'J2EE',subDir:'Jdbc\\2-IntroductiontoRDBMS',content:'IntroductiontoRDBMS_tutorial',programs:'IntroductiontoRDBMS_programms',quiz:'IntroductiontoRDBMS_quiz'},
	                 {topicName:'BasicSQLQueries',directory: 'J2EE',subDir:'Jdbc\\3-BasicSQLQueries',content:'BasicSQLQueries_tutorial',programs:'BasicSQLQueries_programs',quiz:'BasicSQLQueries_quiz'},
	                 {topicName:'JDBCdrivers',directory: 'J2EE',subDir:'Jdbc\\4-JDBCdrivers',content:'jdbc_drivers_tutorial',programs:'jdbc_drivers_programs',quiz:'jdbcdrivers_quiz'},
	                 {topicName:'DBConnectivitySteps',directory: 'J2EE',subDir:'Jdbc\\5-DBConnectivitySteps',content:'DBConnectivity_tutorial',programs:'historyOfJava_programs',quiz:''},
	                 {topicName:'ConnectionInterface',directory: 'J2EE',subDir:'Jdbc\\6-ConnectionInterface',content:'Connection_interface_tutorial',programs:'historyOfJava_programs',quiz:'Connectioninterface_quiz'},
	                 {topicName:'StatementsInterfaces',directory: 'J2EE',subDir:'Jdbc\\7-StatementsInterfaces',content:'Statements_Interface_tutorial',programs:'historyOfJava_programs',quiz:'Statementsinterface_quiz'},
	                 {topicName:'ResultSetInterface',directory: 'J2EE',subDir:'Jdbc\\8-ResultSetInterface',content:'Resultsetinterface_tutorial',programs:'historyOfJava_programs',quiz:''},
	                 {topicName:'ResultSetMataData',directory: 'J2EE',subDir:'Jdbc\\9-ResultSetMataData',content:'Resultsetmatadata_tutorial',programs:'historyOfJava_programs',quiz:'Resultsetmatadata_quiz'},
	                 {topicName:'DatabaseMetaData',directory: 'J2EE',subDir:'Jdbc\\10-DatabaseMetaData',content:'Databasemetadata_tutorial',programs:'historyOfJava_programs',quiz:''},
	                 {topicName:'ConnectionPooling',directory: 'J2EE',subDir:'Jdbc\\11-ConnectionPooling',content:'Introductiontojdbc_tutorial',programs:'historyOfJava_programs',quiz:'Connectionpooling_quiz'},
	                 {topicName:'RowSet',directory: 'J2EE',subDir:'Jdbc\\12-RowSet',content:'Rowset_tutorial',programs:'historyOfJava_programs',quiz:'Rowset_quiz'},
	                 {topicName:'TransactionManagement',directory: 'J2EE',subDir:'Jdbc\\13-TransactionManagement',content:'Transcation_management_tutorail',programs:'historyOfJava_programs',quiz:''},
	                 {topicName:'BatchProcessing',directory: 'J2EE',subDir:'Jdbc\\14-BatchProcessing',content:'Batchprocessing_tutorail',programs:'historyOfJava_programs',quiz:''},
	                 {topicName:'Introductiontowebapplications',directory: 'J2EE',subDir:'Servlets\\1-Introductiontowebapplications',content:'1-Introductiontowebapplications_tutorial',programs:'historyOfJava_programs',quiz:'1-Introductiontowebapplications_quiz'},
	                 {topicName:'Introduction to servlets',directory: 'J2EE',subDir:'Servlets\\2-Introduction to servlets',content:'Introductiontoservlets_tutorial',programs:'historyOfJava_programs',quiz:'Introductiontoservlets_quiz'},
	                 {topicName:'ServletRequestInterface',directory: 'J2EE',subDir:'Servlets\\3-ServletRequestInterface',content:'Servlet_request_interface_tutorial',programs:'historyOfJava_programs',quiz:'ServletRequestInterface_quiz'},
	                 {topicName:'ServletResponseInterface',directory: 'J2EE',subDir:'Servlets\\4-ServletResponseInterface',content:'Servletresponseinterface_tutorial',programs:'historyOfJava_programs',quiz:'ServletResponseInterface_quiz'},
	                 {topicName:'Servletconfig',directory: 'J2EE',subDir:'Servlets\\5-Servletconfig',content:'Servletconfig_tutorial',programs:'historyOfJava_programs',quiz:'Servletconfig_quiz'},
	                 {topicName:'Servletcontext',directory: 'J2EE',subDir:'Servlets\\6-Servletcontext',content:'Servletcontext_tutorial',programs:'historyOfJava_programs',quiz:'Servletcontext_quiz'},
	                 {topicName:'RequestDispatcher',directory: 'J2EE',subDir:'Servlets\\7-RequestDispatcher',content:'Requestdispatcher_tutorial',programs:'historyOfJava_programs',quiz:''},
	                 {topicName:'SessionTrackingTechniques',directory: 'J2EE',subDir:'Servlets\\8-SessionTrackingTechniques',content:'Sessiontrackingtechniques_tutorial',programs:'historyOfJava_programs',quiz:''},
	                 {topicName:'Filters',directory: 'J2EE',subDir:'Servlets\\9-Filters',content:'Filters_tutorial',programs:'historyOfJava_programs',quiz:''},
	                 {topicName:'ServletListeners',directory: 'J2EE',subDir:'Servlets\\10-ServletListeners',content:'Servletlisteners_tutorial',programs:'historyOfJava_programs',quiz:''},
	                 {topicName:'IntroductiontoJSP',directory: 'J2EE',subDir:'Servlets\\11-IntroductiontoJSP',content:'Introductiontojsp_tutorial',programs:'historyOfJava_programs',quiz:'IntroductiontoJsp_quiz'},
	                 {topicName:'ScriptletsExpressions',directory: 'J2EE',subDir:'Servlets\\12-ScriptletsExpressions',content:'Scriptletsexpressions_tutorial',programs:'historyOfJava_programs',quiz:''},
	                 {topicName:'ImplicitObjects',directory: 'J2EE',subDir:'Servlets\\13-ImplicitObjects',content:'Implicitobjects_turorial',programs:'historyOfJava_programs',quiz:''},
	                 {topicName:'Taglibs',directory: 'J2EE',subDir:'Servlets\\14-Taglibs',content:'Taglibs_tutorial',programs:'historyOfJava_programs',quiz:''},
	                 {topicName:'Ajax+Servlet',directory: 'J2EE',subDir:'Servlets\\15-Ajax+Servlet',content:'1-Introductiontowebapplications_tutorial',programs:'historyOfJava_programs',quiz:''},
	                 {topicName:'Interview Questions',directory: 'J2EE',subDir:'Servlets\\16-InterviewQuestions',content:'interviewQuestions',programs:'interviewQuestions',quiz:''},
	                 {topicName:'Documentation',directory: 'J2EE',subDir:'Servlets\\17-Documentation',content:'Documentation'},
                 ];*/

var JDBC_TOPICS = [
                     {topicName:'Introduction To JDBC',directory: 'J2EE',subDir:'Jdbc\\1-IntroductiontoJDBC',content:'Introductiontojdbc_tutorial',programs:'Introductiontojdbc_programs',quiz:'Introductiontojdbc_quiz'},
	                 {topicName:'Introduction To RDBMS',directory: 'J2EE',subDir:'Jdbc\\2-IntroductiontoRDBMS',content:'IntroductiontoRDBMS_tutorial',programs:'IntroductiontoRDBMS_programms',quiz:'IntroductiontoRDBMS_quiz'},
	                 {topicName:'Basic SQL Queries',directory: 'J2EE',subDir:'Jdbc\\3-BasicSQLQueries',content:'BasicSQLQueries_tutorial',programs:'BasicSQLQueries_programs',quiz:'BasicSQLQueries_quiz'},
	                 {topicName:'JDBC Drivers',directory: 'J2EE',subDir:'Jdbc\\4-JDBCdrivers',content:'jdbc_drivers_tutorial',programs:'jdbc_drivers_programs',quiz:'jdbcdrivers_quiz'},
	                 {topicName:'DB Connectivity',directory: 'J2EE',subDir:'Jdbc\\5-DBConnectivitySteps',content:'DBConnectivity_tutorial',programs:'historyOfJava_programs',quiz:'dbconnectivity_quiz'},
	                 {topicName:'Connection Interface',directory: 'J2EE',subDir:'Jdbc\\6-ConnectionInterface',content:'Connection_interface_tutorial',programs:'historyOfJava_programs',quiz:'Connectioninterface_quiz'},
	                 {topicName:'Statements Interfaces',directory: 'J2EE',subDir:'Jdbc\\7-StatementsInterfaces',content:'Statements_Interface_tutorial',programs:'historyOfJava_programs',quiz:'Statementsinterface_quiz'},
	                 {topicName:'ResultSet Interface',directory: 'J2EE',subDir:'Jdbc\\8-ResultSetInterface',content:'Resultsetinterface_tutorial',programs:'historyOfJava_programs',quiz:'Resultsetinterface_quiz'},
	                 {topicName:'ResultSet MataData',directory: 'J2EE',subDir:'Jdbc\\9-ResultSetMataData',content:'Resultsetmatadata_tutorial',programs:'historyOfJava_programs',quiz:'Resultsetmatadata_quiz'},
	                 {topicName:'Database MetaData',directory: 'J2EE',subDir:'Jdbc\\10-DatabaseMetaData',content:'Databasemetadata_tutorial',programs:'historyOfJava_programs',quiz:'Databasemetadata_quiz'},
	                // {topicName:'Connection Pooling',directory: 'J2EE',subDir:'Jdbc\\11-ConnectionPooling',content:'Introductiontojdbc_tutorial',programs:'historyOfJava_programs',quiz:'Connectionpooling_quiz'},
	                 {topicName:'RowSet',directory: 'J2EE',subDir:'Jdbc\\12-RowSet',content:'Rowset_tutorial',programs:'historyOfJava_programs',quiz:'Rowset_quiz'},
	                 {topicName:'Transaction Management',directory: 'J2EE',subDir:'Jdbc\\13-TransactionManagement',content:'Transcation_management_tutorail',programs:'historyOfJava_programs',quiz:'Transaction_management_quiz'},
	                 {topicName:'Batch Processing',directory: 'J2EE',subDir:'Jdbc\\14-BatchProcessing',content:'Batchprocessing_tutorail',programs:'historyOfJava_programs',quiz:'Batchprocessing_quiz'},
	                 {topicName:'DB CURD OPERATIONS',directory: 'J2EE',subDir:'Jdbc\\15-DbCurdOperations',content:'dbCurdOperations_tutorial',programs:'',},
                  ];

var SERVLETS_TOPICS = [
                     {topicName:'Introduction To Webapplications',directory: 'J2EE',subDir:'Servlets\\1-Introductiontowebapplications',content:'1-Introductiontowebapplications_tutorial',programs:'historyOfJava_programs',quiz:'1-Introductiontowebapplications_quiz'},
  	                 {topicName:'Introduction To Servlets',directory: 'J2EE',subDir:'Servlets\\2-Introduction to servlets',content:'Introductiontoservlets_tutorial',programs:'historyOfJava_programs',quiz:'Introductiontoservlets_quiz'},
  	                 {topicName:'ServletRequest Interface',directory: 'J2EE',subDir:'Servlets\\3-ServletRequestInterface',content:'Servlet_request_interface_tutorial',programs:'historyOfJava_programs',quiz:'ServletRequestInterface_quiz'},
  	                 {topicName:'ServletResponse Interface',directory: 'J2EE',subDir:'Servlets\\4-ServletResponseInterface',content:'Servletresponseinterface_tutorial',programs:'historyOfJava_programs',},/*quiz:'ServletResponseInterface_quiz'*/
  	                 {topicName:'Servlet Config',directory: 'J2EE',subDir:'Servlets\\5-Servletconfig',content:'Servletconfig_tutorial',programs:'historyOfJava_programs',},/*quiz:'Servletconfig_quiz'*/
  	                 {topicName:'Servlet Context',directory: 'J2EE',subDir:'Servlets\\6-Servletcontext',content:'Servletcontext_tutorial',programs:'historyOfJava_programs',},/*quiz:'Servletcontext_quiz'*/
  	                 {topicName:'Request Dispatcher',directory: 'J2EE',subDir:'Servlets\\7-RequestDispatcher',content:'Requestdispatcher_tutorial',programs:'historyOfJava_programs',},
  	                 {topicName:'Session Tracking Techniques',directory: 'J2EE',subDir:'Servlets\\8-SessionTrackingTechniques',content:'Sessiontrackingtechniques_tutorial',programs:'historyOfJava_programs',},
  	                 {topicName:'Filters',directory: 'J2EE',subDir:'Servlets\\9-Filters',content:'Filters_tutorial',programs:'historyOfJava_programs',},
  	                 {topicName:'Servlet Listeners',directory: 'J2EE',subDir:'Servlets\\10-ServletListeners',content:'Servletlisteners_tutorial',programs:'historyOfJava_programs',},
                   ];

var JSP_TOPICS = [
                  	 {topicName:'Introduction To JSP',directory: 'J2EE',subDir:'Servlets\\11-IntroductiontoJSP',content:'Introductiontojsp_tutorial',programs:'historyOfJava_programs',},/*quiz:'IntroductiontoJsp_quiz'*/
	                 {topicName:'Scriptlets Expressions',directory: 'J2EE',subDir:'Servlets\\12-ScriptletsExpressions',content:'Scriptletsexpressions_tutorial',programs:'historyOfJava_programs',},
	                 {topicName:'Implicit Objects',directory: 'J2EE',subDir:'Servlets\\13-ImplicitObjects',content:'Implicitobjects_turorial',programs:'historyOfJava_programs',},
	                 {topicName:'Taglibs',directory: 'J2EE',subDir:'Servlets\\14-Taglibs',content:'Taglibs_tutorial',programs:'historyOfJava_programs',},
	                 {topicName:'Ajax+Servlet',directory: 'J2EE',subDir:'Servlets\\15-Ajax+Servlet',content:'1-Introductiontowebapplications_tutorial',programs:'historyOfJava_programs',},
	                 {topicName:'Interview Questions',directory: 'J2EE',subDir:'Servlets\\16-InterviewQuestions',content:'interviewQuestions',programs:'interviewQuestions',},
	                 {topicName:'Books',directory: 'J2EE',subDir:'Servlets\\17-Documentation',content:'Books'},
                  ];
var SPRING_TOPICS=[
               		{topicName:'Introduction To Spring',directory: 'SPRING',subDir:'1-IntroductiontoSpring',content:'introductiontospring',},/*quiz:"introductiontospring_test"*/
               		{topicName:'Spring Architecture',directory: 'SPRING',subDir:'2-Spring Architecture',content:'spring_architecture',},
               		{topicName:'Dependency Injection',directory: 'SPRING',subDir:'3-Dependency Injection',content:'dependency_injection',},/*quiz:"dependencyinjection_test"*/
               		{topicName:'Setter Injection',directory: 'SPRING',subDir:'4-Setter Injection',content:'setter_injection',},
               		{topicName:'Constructor Injection',directory: 'SPRING',subDir:'5-Constructor Injection',content:'constructor_injection',},
               		{topicName:'Collection Injection',directory: 'SPRING',subDir:'6-Collection Injection',content:'collection_injection',},/*quiz:"collectioninjection_test"*/
               		{topicName:'Autowire',directory: 'SPRING',subDir:'7-Autowire',content:'autowire_tutorial',},/*quiz:"autowire_test"*/
               		{topicName:'ApplicationContext',directory: 'SPRING',subDir:'8-ApplicationContext',content:'application_context_tutorial',},/*quiz:"applicationcontext_test"*/
               		{topicName:'InnerBeansAliases',directory: 'SPRING',subDir:'9-InnerBeansAliases',content:'innerbeans_Aliases_tutorial',},/*quiz:"innerbeans_Aliases_test"*/
               		{topicName:'BeanScopes',directory: 'SPRING',subDir:'10-BeanScopes',content:'beanscopes_tutorial',},/*quiz:"beanscopes_test"*/
               		{topicName:'BeanLifecycle',directory: 'SPRING',subDir:'11-BeanLifecycle',content:'bean_lifecycle_tutorial',},
               		{topicName:'Bean Definition Inheritance',directory: 'SPRING',subDir:'12-Beandefinitioninheritance',content:'beandefinitioninheritance_tutorial',},
               		{topicName:'Interview Questions',directory: 'SPRING',subDir:'13-InterviewQuestions',content:'interviewQuestions',}
                   		
                   ];
var HIBERNATE_TOPICS=[
		                 {topicName:'Introduction To Hibernate',directory: 'HIBERNATE',subDir:'1-IntroductiontoHibernate',content:'introductiontohibernate',},/*quiz:"introductiontohibernate_test"*/
		                 {topicName:'Hibernate Architecture',directory: 'HIBERNATE',subDir:'2-Hibernate Architecture',content:'hibernate_architecture',},/*quiz:"hibernatearchitecture_test"*/
		                 {topicName:'ORM',directory: 'HIBERNATE',subDir:'3-ORM',content:'orm',},/*quiz:"orm_test"*/
		                 //  {topicName:'CURDoperationusingHB',directory: 'HIBERNATE',subDir:'4-CURDoperationusingHB',content:'introductiontohibernate',quiz:"Idgenerators_test"},
		                 {topicName:'Id-Generators',directory: 'HIBERNATE',subDir:'5-Id-Generators',content:'id_generators',},
		                 {topicName:'Value-types',directory: 'HIBERNATE',subDir:'6-Value-types',content:'value_types',},
		                 //{topicName:'Composite-Type',directory: 'HIBERNATE',subDir:'7-Composite-Type',content:'introductiontohibernate',quiz:""},
		                 {topicName:'Collection-type',directory: 'HIBERNATE',subDir:'8-Collection-type',content:'collectiontype_tutorial',},
		                 {topicName:'Implementing inheritance',directory: 'HIBERNATE',subDir:'9-Implementing inheritance',content:'implementing_inheritance',},/*quiz:"implementinginheritance_test"*/
		                 {topicName:'Relationships',directory: 'HIBERNATE',subDir:'10-Relationships',content:'relationships',},/*quiz:"relationships_test"*/
		                 {topicName:'One-to-one And One-to-many',directory: 'HIBERNATE',subDir:'11-One-to-oneOne-to-many',content:'onetoone_onetomany',},
		                 //{topicName:'Cascade-Types',directory: 'HIBERNATE',subDir:'12-Cascade-Types',content:'introductiontohibernate',quiz:""},
		                 {topicName:'Many-to-oneandMany-to-Many',directory: 'HIBERNATE',subDir:'13-Many-to-oneandMany-to-Many',content:'manytooneandmanytomany',},
		                 {topicName:'HQL',directory: 'HIBERNATE',subDir:'14-HQL',content:'hql',},/*quiz:"hql_test"*/
		                 {topicName:'NamedQueries',directory: 'HIBERNATE',subDir:'15-NamedQueries',content:'namedqueries',},
		                 {topicName:'Criteria',directory: 'HIBERNATE',subDir:'16-Criteria',content:'criteria',},
		                 {topicName:'Caching',directory: 'HIBERNATE',subDir:'17-Caching',content:'caching',},/*quiz:"caching_test"*/
		                 {topicName:'NativeSQL',directory: 'HIBERNATE',subDir:'18-NativeSQL',content:'nativesql',},
		                 {topicName:'Interview Questions',directory: 'HIBERNATE',subDir:'19-InterviewQuestions',content:'interviewQuestions',},
                 ];

var ANDROID_TOPICS=[
                    	{topicName:'Introduction To Android',directory: 'ANDROID',subDir:'1-IntroductionTOAndroid',content:'introductionToAndroid_tutorial'}
                    ];
var IOS_TOPICS=[
                    {topicName:'Introduction To Ios',directory: 'IOS',subDir:'1-IntroductionTOIos',content:'introductionToIos_tutorial'}
                ];

var SQL_TOPICS=[
					{topicName:'Introduction To DBMS',directory: 'DATABASE',subDir:'SQL\\1-Introduction to SQL',content:'introductionToAndroid_tutorial',programs:'',quiz:''},
];

var PLSQL_TOPICS = [
                {topicName:'Introduction To PLSQL',directory: 'DATABASE',subDir:'PL-AND-SQL\\1-Introduction to PLSQL',content:'introductionToAndroid_tutorial',programs:'',quiz:''},
                    ];

var DBA_TOPICS=[
                {topicName:'Introduction To Ios',directory: 'IOS',subDir:'1-IntroductionTOIos',content:'introductionToIos_tutorial'}
                   ];

var ECLIPSE_TOPICS=[
                    
                    {topicName:'Introduction To Eclipse',directory: 'ECLIPSE',subDir:'1-IntroductionTOEclipse',content:'introductionToEclipse_tutorial'}
                  
                    ];
var MAVEN_TOPICS=[
                  
                  {topicName:'Introduction To Maven',directory: 'MAVEN',subDir:'1-IntroductionTOMaven',content:'introductionToMaven_tutorial'}
                 
                  ];
var ANT_TOPICS=[
                
                {topicName:'Introduction To Ant',directory: 'ANT',subDir:'1-IntroductionTOAnt',content:'introductionToAnt_tutorial'}
              
                ];

var PYTHON_TOPICS=[
                
                {topicName:'Introduction To Python',directory: 'PYTHON',subDir:'1-IntroductionToPython',content:'introductionToPython_tutorial'}
              
                ];

var PROGRAMS_TOPICS=[
                {topicName:'Basic',directory: 'PROGRAMS',subDir:'0-basic',content:'basic-programs-tutorial',programs:'basic-programs',quiz:'basic-programs-quiz'},
                {topicName:'Loops',directory: 'PROGRAMS',subDir:'1-loops',content:'loops-programs-tutorial',programs:'loops-programs',quiz:'loops-programs-quiz'},
                {topicName:'String',directory: 'PROGRAMS',subDir:'2-string',content:'strings-programs-tutorial',programs:'strings-programs',quiz:'loops-programs-quiz'},
                {topicName:'Arrays',directory: 'PROGRAMS',subDir:'3-arrays',content:'arrays-programs-tutorial',programs:'arrays-programs',quiz:'loops-programs-quiz'},
                {topicName:'Functions',directory: 'PROGRAMS',subDir:'4-functions',content:'functions-programs-tutorial',programs:'functions-programs',quiz:'loops-programs-quiz'},
                {topicName:'Math',directory: 'PROGRAMS',subDir:'5-math',content:'math-programs-tutorial',programs:'math-programs',quiz:'math-programs-quiz'},
                {topicName:'Files',directory: 'PROGRAMS',subDir:'6-files',content:'files-programs-tutorial',programs:'files-programs',quiz:'files-programs-quiz'},
                {topicName:'Data Structures',directory: 'PROGRAMS',subDir:'7-data-structures',content:'data-structures-programs-tutorial',programs:'data-structures-programs',quiz:'files-programs-quiz'},
                {topicName:'Algorithms',directory: 'PROGRAMS',subDir:'8-algorithms',content:'algorithms-programs-tutorial',programs:'data-structures-programs',quiz:'files-programs-quiz'},
                {topicName:'Interview Programs',directory: 'PROGRAMS',subDir:'9-interview-programs',content:'interview-programs-tutorial',programs:'data-structures-programs',quiz:'files-programs-quiz'},
                ];

var COMPUTER_MATHS_TOPICS=[
                     {topicName:'Numbers',directory: 'COMPUTER_MATHS',subDir:'0-numbers',content:'numbers-tutorial',programs:'basic-programs',quiz:'basic-programs-quiz'},
                     {topicName:'Functions',directory: 'COMPUTER_MATHS',subDir:'1-functions',content:'functions-tutorial',programs:'data-structures-programs',quiz:'files-programs-quiz'},
                     {topicName:'Series',directory: 'COMPUTER_MATHS',subDir:'2-series',content:'series-tutorial',programs:'basic-programs',quiz:'basic-programs-quiz'},
                     {topicName:'Set',directory: 'COMPUTER_MATHS',subDir:'3-set',content:'set-tutorial',programs:'basic-programs',quiz:'basic-programs-quiz'},
                     {topicName:'Matrix',directory: 'COMPUTER_MATHS',subDir:'4-matrix',content:'matrix-tutorial',programs:'basic-programs',quiz:'basic-programs-quiz'},
                     {topicName:'Permutation',directory: 'COMPUTER_MATHS',subDir:'5-permutation',content:'permutation-tutorial',programs:'basic-programs',quiz:'basic-programs-quiz'},
                     {topicName:'Combination',directory: 'COMPUTER_MATHS',subDir:'6-combination',content:'combination-tutorial',programs:'basic-programs',quiz:'basic-programs-quiz'},
                     {topicName:'Logarithm',directory: 'COMPUTER_MATHS',subDir:'6-combination',content:'combination-tutorial',programs:'basic-programs',quiz:'basic-programs-quiz'},
                     ];

var APTITUDE_REASONING_TOPICS=[
                            {topicName:'Number Series',directory: 'APTITUDE_REASONING',subDir:'0-number-series',content:'number-series-tutorial',programs:'basic-programs',quiz:'basic-programs-quiz'},
                            {topicName:'Time and Distance',directory: 'APTITUDE_REASONING',subDir:'1-time-and-distance',content:'time-and-distance-tutorial',programs:'data-structures-programs',quiz:'files-programs-quiz'},
                            {topicName:'Time and Work',directory: 'APTITUDE_REASONING',subDir:'2-time-and-work',content:'time-and-work-tutorial',programs:'data-structures-programs',quiz:'files-programs-quiz'},
                            {topicName:'Percentage',directory: 'APTITUDE_REASONING',subDir:'3-percentage',content:'percentage-tutorial',programs:'data-structures-programs',quiz:'files-programs-quiz'},
                            {topicName:'Problems on Ages',directory: 'APTITUDE_REASONING',subDir:'4-problems-on-ages',content:'problems-on-ages-tutorial',programs:'data-structures-programs',quiz:'files-programs-quiz'},
                            {topicName:'Problems on Trains',directory: 'APTITUDE_REASONING',subDir:'5-problems-on-trains',content:'problems-on-trains-tutorial',programs:'data-structures-programs',quiz:'files-programs-quiz'},
                            {topicName:'Simple Interest',directory: 'APTITUDE_REASONING',subDir:'6-simple-interest',content:'simple-interest-tutorial',programs:'data-structures-programs',quiz:'files-programs-quiz'},
                            {topicName:'Profit and Loss',directory: 'APTITUDE_REASONING',subDir:'7-profit-and-loss',content:'profit-and-loss-tutorial',programs:'data-structures-programs',quiz:'files-programs-quiz'},
                            {topicName:'Clock',directory: 'APTITUDE_REASONING',subDir:'8-clock',content:'clock-tutorial',programs:'data-structures-programs',quiz:'files-programs-quiz'},
                            {topicName:'Ratio and Proportion',directory: 'APTITUDE_REASONING',subDir:'9-ratio-and-proportion',content:'ratio-and-proportion-tutorial',programs:'data-structures-programs',quiz:'files-programs-quiz'},
                            ];

var TOPICS_DATA = {
	'cTopics': C_TOPICS,
	'javaTopics': JAVA_TOPICS,
	'programsTopics': PROGRAMS_TOPICS,
	
	'htmlTopics': HTML_TOPICS,
	'cssTopics': CSS_TOPICS,
	'jsTopics': JS_TOPICS,
	'adJsTopics': ADVANCED_JS_TOPICS,
	'angularjsTopics':ANGULARJS_TOPICS,
	'reactJsTopics':REACT_JS_TOPICS,
	'nodejsTopics':NODEJS_TOPICS,
	'uicomponentsTopics':UICOMPONENTS_TOPICS,
	
	
	'jdbcTopics': JDBC_TOPICS,
	'servletsTopics':SERVLETS_TOPICS,
	'jspTopics':JSP_TOPICS,
	'springTopics': SPRING_TOPICS,
	'hibernateTopics': HIBERNATE_TOPICS,
	
	'androidTopics': ANDROID_TOPICS,
	'iosTopics':IOS_TOPICS,
	
	'sqlTopics':SQL_TOPICS,
	'plsqlTopics':PLSQL_TOPICS,
	'dbaTopics':DBA_TOPICS,
	
	'pythonTopics':PYTHON_TOPICS,
	
	
	'eclipseTopics': ECLIPSE_TOPICS,
	'mavenTopics': MAVEN_TOPICS,
	'antTopics': ANT_TOPICS,
	
	'computerMathsTopics':COMPUTER_MATHS_TOPICS,
	'aptitudeReasoning':APTITUDE_REASONING_TOPICS
	
};

var TUTORIAL_MENU_DATA = {
	UI: [{
		title: 'HTML/HTML5',
		ref: 'htmlTopics'
	},{
		title: 'CSS/CSS3',
		ref: 'cssTopics'
	},{
		title: 'JavaScript',
		ref: 'jsTopics'
	},{
		title: 'Advanced JS',
		ref: 'adJsTopics'
	},{
		title:'UI Components',
		ref: 'uicomponentsTopics'	
	}],
	
	"JS FRAMEWORKS": [{
		title: 'Angular JS',
		ref: 'angularjsTopics'
	},{
		title: 'React JS',
		ref: 'reactJsTopics'
	}
	],
	
	PROGRAMMING: [{
		title: 'C',
		ref: 'cTopics'
	}, {
		title: 'Java',
		ref: 'javaTopics'
	}, {
		title: 'NodeJS',
		ref: 'nodejsTopics'
	},/*{
		title: 'Python',
		ref: 'pythonTopics'
	},*/{
		title: 'PROGRAMS',
		ref: 'programsTopics'
	}],
	FRAMEWORKS: [{
		title: 'JDBC',
		ref: 'jdbcTopics'
	},{
		title: 'SERVLETS',
		ref: 'servletsTopics'
	},{
		title: 'JSP',
		ref: 'jspTopics'
	},{
		title: 'Spring',
		ref: 'springTopics'
	}, {
		title: 'Hibernate',
		ref: 'hibernateTopics'
	}],
	/*MOBILE: [{
		title: 'Android',
		ref: 'androidTopics'
	}, {
		title: 'IOS',
		ref: 'iosTopics'
	}],*/
	DATABASE: [{
		title: 'SQL',
		ref: 'sqlTopics'
	}, {
		title: 'PLSQL',
		ref: 'plsqlTopics'
	},/* {
		title: 'DBA',
		ref: 'dbaTopics'
	}*/],
	/*TOOLS: [{
		title: 'Eclipse',
		ref: 'eclipseTopics'
	}, {
		title: 'Maven',
		ref: 'mavenTopics'
	}, {
		title: 'Ant',
		ref: 'antTopics'
	}]*/
	GENERAL: [{
	title: 'Computer Maths',
	ref: 'computerMathsTopics'
	}, {
		title: 'Aptitude & Reasoning',
		ref: 'aptitudeReasoning'
	}]
	
};

function _GET_URL(pathObj,fileType) {
	var path = pathObj.directory+"\\"+pathObj[fileType];
	var subDir = "?";
	if(pathObj.subDir){
		if(fileType=='content'){
			subDir +=("subdir="+fileType+"\\"+pathObj.subDir);
		}else{
			subDir +=("subdir="+fileType);
		}
	}
	return path+subDir;
}
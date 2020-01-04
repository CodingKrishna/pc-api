$(document).ready(function(){

  // Publish output from HTMl, CSS, and JS textareas in the iframe below
  window.runCodeFun =  function runCode(){
    (document.getElementById("preview").contentWindow.document).write(
      html.value+"<style>"+css.value+"<\/style><script>"+js.value+"<\/script>"
    );
    (document.getElementById("preview").contentWindow.document).close();
  };
  
  // Pressing the Tab key inserts 2 spaces instead of shifting focus
  $("textarea").keydown(function(event){
    if(event.keyCode === 9){
      var start = this.selectionStart;
      var end = this.selectionEnd;
      var $this = $(this);
      var value = $this.val();
      $this.val(value.substring(0, start)+"  "+value.substring(end));
      this.selectionStart = this.selectionEnd = start+1;
      event.preventDefault();
    }
  });

  // Store contents of textarea in sessionStorage
  $("textarea").keydown(function(){
      sessionStorage[$(this).attr("id")] = $(this).val();
  });
  $("#html").html(sessionStorage["html"]);
  $("#css").html(sessionStorage["css"]);
  $("#js").html(sessionStorage["js"]);
  function init() {
    if (sessionStorage["html"]) {
        $("#html").val(sessionStorage["html"]);
      }
    if (sessionStorage["css"]) {
        $("#css").val(sessionStorage["css"]);
      }  
    if (sessionStorage["js"]) {
        $("#js").val(sessionStorage["js"]);
      }
  };

// Clear textareas with button
/*  $(".clearLink").click(clearAll);*/


});
function outputFun(){
	window.runCodeFun();
}

function runCode(id){
	var codeEvaluationReq = {};
	codeEvaluationReq.languageId = id;
	codeEvaluationReq.code = java.value;
	
	if(inputs.value){
		var inputsArray = inputs.value.split(' ');
	}
	
	var finalInputs = [];
	for(var i=0;i<inputsArray.length;i++){
		if(i%2==1){
			finalInputs.push("\n");
		}else{
			finalInputs.push(inputsArray[i]);
		}
	}
	finalInputs.push(inputsArray[inputsArray.length-1]);
	codeEvaluationReq.inputs = finalInputs;
	$.ajax({
	      url: "evaluvator/executetrycode",
	      type: 'POST',
	      contentType: 'application/json',
	      data: JSON.stringify(codeEvaluationReq),
	      success: function(result) {
	    	  var resultData = "";
				if(result.compilationStatus == 'Success' && result.runStatus == 'Success' ){
					var arrayData =  result.output.split("@@");
					var finalResult = "";
					for(var i=0;i<arrayData.length;i++){
						finalResult = finalResult.concat(arrayData[i]).concat("<br>");
					}
					
					resultData = finalResult;
				}else if(result.compilationStatus == 'Failed' ){
					resultData = result.compilationErrors;
				}else if (result.compilationStatus == 'Failed'){
					resultData = result.runtimeErrors;
				}
				(document.getElementById("preview").contentWindow.document).write(resultData);
			    (document.getElementById("preview").contentWindow.document).close();
	      }
	});
	
}

function clearAll(){
    document.getElementById("html").value = "";
    document.getElementById("css").value = "";
    document.getElementById("js").value = "";
    /*$('#preview').empty();*/

    sessionStorage.clear();
 }
package org.pioneercoders.web.controllers.codeevaluator;

import java.io.IOException;

import java.util.ArrayList;
import java.util.List;

import org.pioneercoders.dto.evaluation.codingtest.CodeEvalRequestDto;
import org.pioneercoders.dto.evaluation.codingtest.CodeEvaluvationRespDto;
import org.pioneercoders.services.codeevaluvator.ICodeEvalutor;
import org.pioneercoders.services.codeevaluvator.Impl.CPPCodeEvalutor;
import org.pioneercoders.services.codeevaluvator.Impl.JavaCodeEvaluator;
import org.pioneercoders.services.codeevaluvator.Impl.NodeCodeEvaluator;
import org.pioneercoders.utils.FileReadUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(value = "evaluvator")
public class CodeEvaluatorController {
	
	String onlineCompilerPath = new FileReadUtil().getProperty("ONLINE_COMPILER_CODE");

	@RequestMapping(value = "executecode",method = RequestMethod.POST)
	public @ResponseBody CodeEvalRequestDto compileCode(@RequestBody CodeEvalRequestDto codeEvalRequestDto) throws IOException {
		
		if (codeEvalRequestDto.getLanguage().equalsIgnoreCase("JAVA")) {
			String[] stringArray = codeEvalRequestDto.getCode().split(" ");
			String fileName = null;
			String runResult = "";
			for(int i=0;i<stringArray.length;i++){
				if(stringArray[i].equals("class")){
					fileName = stringArray[i+1]+".java";
				}
			}
			FileReadUtil.writeDataToFile(onlineCompilerPath + fileName, codeEvalRequestDto.getCode());
			ICodeEvalutor evaluvator = new JavaCodeEvaluator();
			String result = evaluvator.compile(onlineCompilerPath, fileName);

			codeEvalRequestDto.setOutput(result);
			System.out.println("if result is success or failed"+result);
			String className = fileName.replace(".java", "");
			if(codeEvalRequestDto.getInputs()!=null){
				runResult = evaluvator.run(onlineCompilerPath, className, codeEvalRequestDto.getInputs());
				codeEvalRequestDto.setOutput(runResult);
			}else if(codeEvalRequestDto.getTestCases() != null && codeEvalRequestDto.getTestCases().size() > 0){
				for(int i=0;i<codeEvalRequestDto.getTestCases().size();i++){   
					List<String> finalInputs = new ArrayList();
					String[]  inputsArray =  codeEvalRequestDto.getTestCases().get(i).get("input").split(" ");
					
					for(int j=0;j<inputsArray.length;j++){
						if(j%2==1){
							finalInputs.add("\n");
						}else{
							finalInputs.add(inputsArray[j]);
						}
					}
					finalInputs.add(inputsArray[inputsArray.length-1]);
					System.out.println(finalInputs);
					
					runResult = evaluvator.run(onlineCompilerPath, className, finalInputs);
					String[] runResultArray = runResult.split("@@");
					if(runResultArray[0].equals(codeEvalRequestDto.getTestCases().get(i).get("output"))){
						codeEvalRequestDto.getTestCases().get(i).put("result", "Passed");
					}else{
						codeEvalRequestDto.getTestCases().get(i).put("result", "Failed");
					}
				}
				
			}
			
		}else if (codeEvalRequestDto.getLanguage().equalsIgnoreCase("C")) {
			String[] stringArray = codeEvalRequestDto.getCode().split(" ");
			String fileName = "test.c";
			String runResult = "";
			/*for(int i=0;i<stringArray.length;i++){
				if(stringArray[i].equals("class")){
					fileName = stringArray[i+1]+".java";
				}
			}*/
			FileReadUtil.writeDataToFile(onlineCompilerPath + fileName, codeEvalRequestDto.getCode());
			ICodeEvalutor evaluvator = new CPPCodeEvalutor();
			String result = evaluvator.compile(onlineCompilerPath, fileName);

			codeEvalRequestDto.setOutput(result);
			System.out.println("if result is success or failed"+result);
			String className = fileName.replace(".c", "");
			if(codeEvalRequestDto.getInputs()!=null){
				runResult = evaluvator.run(onlineCompilerPath, className, codeEvalRequestDto.getInputs());
				codeEvalRequestDto.setOutput(runResult);
			}else if(codeEvalRequestDto.getTestCases()!=null && codeEvalRequestDto.getTestCases().size()>0){
				for(int i=0;i<codeEvalRequestDto.getTestCases().size();i++){   
					List<String> finalInputs = new ArrayList();
					String[]  inputsArray =  codeEvalRequestDto.getTestCases().get(i).get("input").split(" ");
					
					for(int j=0;j<inputsArray.length;j++){
						if(j%2==1){
							finalInputs.add("\n");
						}else{
							finalInputs.add(inputsArray[j]);
						}
					}
					finalInputs.add(inputsArray[inputsArray.length-1]);
					System.out.println(finalInputs);
					
					runResult = evaluvator.run(onlineCompilerPath, className, finalInputs);
					String[] runResultArray = runResult.split("@@");
					if(runResultArray[0].equals(codeEvalRequestDto.getTestCases().get(i).get("output"))){
						codeEvalRequestDto.getTestCases().get(i).put("result", "Passed");
					}else{
						codeEvalRequestDto.getTestCases().get(i).put("result", "Failed");
					}
				}
				
			}
			
		}
		return codeEvalRequestDto;
	}
	
	@RequestMapping(value = "executetrycode",method = RequestMethod.POST)
	public @ResponseBody CodeEvaluvationRespDto compileTryCode(@RequestBody CodeEvalRequestDto codeEvalRequestDto) throws IOException {
		CodeEvaluvationRespDto response = new CodeEvaluvationRespDto();
		if (codeEvalRequestDto.getLanguage().equalsIgnoreCase("JAVA")) {
			String[] stringArray = codeEvalRequestDto.getCode().split(" ");
			String fileName = null;
			String runResult = "";
			for(int i=0;i<stringArray.length;i++){
				if(stringArray[i].equals("class")){
					fileName = stringArray[i+1]+".java";
				}
			}
			/*if(fileName.contains("{")){
				fileName.replace(oldChar, newChar)
			}*/
			FileReadUtil.writeDataToFile(onlineCompilerPath + fileName, codeEvalRequestDto.getCode());
			ICodeEvalutor evaluvator = new JavaCodeEvaluator();
			String result = evaluvator.compile(onlineCompilerPath, fileName);

			String className = fileName.replace(".java", "");
			
			if(codeEvalRequestDto.getInputs()!=null){
				runResult = evaluvator.run(onlineCompilerPath, className, codeEvalRequestDto.getInputs());
				codeEvalRequestDto.setOutput(runResult);
			}else{
				runResult = evaluvator.run(onlineCompilerPath, className, null);
			}
			
			if (result.length() > 0) {
				response.setCompilationStatus("Failed");
				response.setCompilationErrors(result);
			} else {
				response.setCompilationStatus("Success");
				if (runResult.contains("Could not find")) {
					response.setRunStatus("Failed");
					response.setRuntimeErrors(runResult);
				} else {
					response.setRunStatus("Success");
					response.setOutput(runResult);
				}
			}
		}else if(codeEvalRequestDto.getLanguage().equalsIgnoreCase("NODE")){
			String fileName = "test.js";
			FileReadUtil.writeDataToFile(onlineCompilerPath + fileName, codeEvalRequestDto.getCode());
			ICodeEvalutor evaluvator = new NodeCodeEvaluator();
			String result = evaluvator.run(onlineCompilerPath, fileName,null);
				if (result.contains("SyntaxError")) {
					response.setRunStatus("Failed");
					response.setRuntimeErrors(result);
				} else {
					response.setRunStatus("Success");
					response.setOutput(result);
				}
			}
		return response;
	}
}

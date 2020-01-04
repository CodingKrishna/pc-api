package org.pioneercoders.services.codeevaluvator.Impl;

import java.util.ArrayList;
import java.util.List;

import org.pioneercoders.utils.Commands;

public class JavaCodeEvaluator extends  AbstractCodeEvalutor {
	
	@Override
	public String compile(String dirPath,String codeFilePath) throws IllegalArgumentException {
		//System.out.println("Compiling the program ...");
		List<String> commands = new ArrayList<String>();
		commands.add(Commands.JAVAC_COMMAND);
		commands.add(codeFilePath);
		String outPut = executeCommand(dirPath,commands,null);
		System.out.println(outPut);
		return outPut;
	}


	@Override
	public String run(String dirPath, String executableFilePath,List<String> inputs) throws IllegalArgumentException {
		//System.out.println("Executing the program ...");
		List<String> commands = new ArrayList<String>();
	  /*inputs.add("hai");
		inputs.add("hellow");*/
		commands.add(Commands.JAVA_RUN_COMMAND);
		commands.add(executableFilePath);
		
		String outPut = executeCommand(dirPath, commands,inputs);
		
		System.out.println("runtime out put data....."+outPut);
	    //System.out.println("Program finished!");
		return outPut;
	}
}


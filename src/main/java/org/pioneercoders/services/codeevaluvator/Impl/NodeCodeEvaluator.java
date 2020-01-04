package org.pioneercoders.services.codeevaluvator.Impl;

import java.util.ArrayList;
import java.util.List;

import org.pioneercoders.utils.Commands;

public class NodeCodeEvaluator extends AbstractCodeEvalutor{

	@Override
	public String compile(String dirPath, String codeFilePath)
			throws IllegalArgumentException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String run(String dirPath, String executableFilePath,
			List<String> inputs) throws IllegalArgumentException {
			List<String> commands = new ArrayList<String>();
		  /*inputs.add("hai");
			inputs.add("hellow");*/
			commands.add(Commands.NODE_RUN_COMMAND);
			commands.add(executableFilePath);
			
			String outPut = executeCommand(dirPath, commands,inputs);
		return outPut;
	}

}

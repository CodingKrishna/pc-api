package org.pioneercoders.services.codeevaluvator.Impl;

import java.util.ArrayList;
import java.util.List;

import org.pioneercoders.utils.Commands;

public class CPPCodeEvalutor extends AbstractCodeEvalutor {

	@Override
	public String compile(String dirPath, String codeFilePath) throws IllegalArgumentException {

		// System.out.println("Compiling the program ...");
		List<String> commands = new ArrayList<String>();
		commands.add(Commands.C_COMMAND);
		commands.add(Commands.C_COMMAND_OUT + codeFilePath.replace(".c", ""));
		commands.add(codeFilePath);
		String outPut = executeCommand(dirPath, commands, null);
		// System.out.println("Program successfully compiled!\n");
		return outPut;

	}

	@Override
	public String run(String dirPath, String executableFilePath, List<String> inputs) throws IllegalArgumentException {
		// System.out.println("Executing the program ...");
		List<String> commands = new ArrayList<String>();
		commands.add(Commands.C_RUN_COMMAND);
		//commands.add(Commands.SLASH_C_COMMAND);
		commands.add(executableFilePath);
		
		String outPut = executeCommand(dirPath, commands, inputs);
		// System.out.println("Program finished!");
		return outPut;
	}

}

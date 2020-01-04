package org.pioneercoders.services.codeevaluvator;

import java.util.List;

public interface ICodeEvalutor {

	 /**
     * Compiles a program.
     * 
     * @throws IllegalArgumentException
     */
	public String compile(String dirPath, String codeFilePath) throws IllegalArgumentException;
	
	/**
     * Runs a program.
     * 
     * @throws IllegalArgumentException
     */
	public String run(String dirPath, String executableFilePath, List<String> inputs) throws IllegalArgumentException;
		
}

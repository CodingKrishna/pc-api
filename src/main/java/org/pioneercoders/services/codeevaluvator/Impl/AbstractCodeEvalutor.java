package org.pioneercoders.services.codeevaluvator.Impl;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.util.List;

import org.pioneercoders.services.codeevaluvator.ICodeEvalutor;

public abstract class  AbstractCodeEvalutor implements ICodeEvalutor{
	
	/**
     * Matches any .java file.
     */
	public String executeCommand(String dirPath, List<String> commands,List<String> inputs) {
        String outPut = null;
        Process process;
		try {
			ProcessBuilder pb = new ProcessBuilder(commands);
			pb.directory(new File(dirPath));
			process = pb.start();
			if(inputs !=null && inputs.size() >0){
				runWithInputs(inputs, process);
			}
			int errCode = process.waitFor();
			if(errCode == 0){
				outPut = output(process.getInputStream());
			}else{
				outPut = output(process.getErrorStream());
			}
		} catch (IOException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return outPut; 
	}

	public void runWithInputs(List<String> inputs, Process process) throws IOException {
		OutputStream stdin = process.getOutputStream(); 
		BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(stdin));
		
		for(String input : inputs){
			 writer.write(input);
			 writer.flush();
		}         
		writer.close();
	}
	
    public static String output(InputStream in) throws IOException {  
    	StringBuffer outputVal= new StringBuffer();
        BufferedReader reader = new BufferedReader(new InputStreamReader(in));

        for (String line = reader.readLine(); line != null; line = reader.readLine()) {
        	outputVal.append(line).append("@@");
        }
        return outputVal.toString();
    }


}

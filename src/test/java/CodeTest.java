import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;


public class CodeTest {


	public static void main(String[] args) throws IOException {
		//String onlineCompilerPath = new FileReadUtil().getProperty("ONLINE_COMPILER_CODE");
		/*String fileName = "test.js";
		FileReadUtil.writeDataToFile(onlineCompilerPath + fileName, "console.log('Hellow World');console.log('Welcome TO node JS');");
		ICodeEvalutor evaluvator = new NodeCodeEvaluator();
		String result = evaluvator.run(onlineCompilerPath, fileName,null);
		System.out.println(result);*/
		
		ProcessBuilder processBuilder = new ProcessBuilder("C:/Program Files (x86)/Dev-Cpp/MinGW64/bin/gcc", "-o" + "test",  "F:/PC/test.c");
		processBuilder.directory(new File("F:/PC/"));
		Process proc = processBuilder.start();
		BufferedReader in = new BufferedReader(new InputStreamReader(proc.getInputStream())); 
		System.out.println(in.readLine());
		System.out.println("Compled");
		
		String[] command = {"CMD", "/C", "F:/PC/test.exe"};
		ProcessBuilder processBuilder1 = new ProcessBuilder(command);
		processBuilder1.directory(new File("F:/PC/"));
		Process proc1 = processBuilder1.start();
		BufferedReader in1 = new BufferedReader(new InputStreamReader(proc1.getInputStream())); 
		System.out.println(in1.readLine());
		System.out.println("Runing ..");
		
		
		/*ProcessBuilder processBuilder =
			    new ProcessBuilder("C:/Program Files (x86)/Dev-Cpp/MinGW64/bin/gcc", "-o test","test.c"); // source in working dir
			processBuilder.directory(new File("G:/PC/code/")); // or whatever
			Process proc = processBuilder.start();*/
	}

}

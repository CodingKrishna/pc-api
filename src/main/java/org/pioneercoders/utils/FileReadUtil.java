package org.pioneercoders.utils;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Properties;

public class FileReadUtil {
	
private String FILE_NAME;
	
	public FileReadUtil() {
		this.FILE_NAME = "app.properties";
	}
	
	public String getProperty(String key) {
		String result = "";
		InputStream inputStream = null;
		try {
			Properties prop = new Properties();
			String propFileName = this.FILE_NAME;

			inputStream = getClass().getClassLoader().getResourceAsStream(
					propFileName);

			if (inputStream != null) {
				prop.load(inputStream);
			} else {
				throw new FileNotFoundException("property file '" + propFileName + "' not found in the classpath");
			}
			result = prop.getProperty(key);

		} catch (Exception e) {
			System.out.println("Exception: " + e);
		} finally {
			try {
				inputStream.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return result;
	}
	//Template Read
	public static String getFileContent(String filePath, String contentType) throws IOException {
		return updateAcronymsInFile(new String(Files.readAllBytes(Paths.get(filePath))), contentType);
	}
	
	/**
	 * @param fileContent
	 * @return code HTML tags replaced as per the UI
	 * @throws IOException
	 */
	public static String updateAcronymsInFile(String fileContent, String contentType) throws IOException {
		if(fileContent!=null){
			while(fileContent.contains(Constants.CODE_START)) {
				int startIndex = fileContent.indexOf(Constants.CODE_START);
				int endIndex = fileContent.indexOf(Constants.CODE_END) + (Constants.CODE_END.length());
				if(startIndex != -1 && endIndex != -1) {
					char[] codeContent = new char[endIndex - startIndex];
					fileContent.getChars(startIndex, endIndex, codeContent, 0);
					String codeContentString = new String(codeContent);
					for(int i=0; i<Constants.CODE_TYPES.length; i++) {
						int index = codeContentString.indexOf(Constants.CODE_TYPES[i]);
						if (index != -1) {
							codeContentString = codeContentString.replace("<", "&lt;");
							codeContentString = codeContentString.replace(">", "&gt;");
							codeContentString = codeContentString.replace(Constants.CODE_TYPES[i], "");
							codeContentString = codeContentString.replace(Constants.CODE_START, getStartTemplateByType(Constants.CODE_TYPES[i].replace("@", "")));
							codeContentString = codeContentString.replace(Constants.CODE_END, "</code></pre>");
						}
					}
					fileContent = fileContent.replace(new String(codeContent), codeContentString).trim();
				}
			};
			if(fileContent.contains(Constants.IMG_START)) {
				String baseUrl = null;
				if(contentType.equals("tutorial")) {
					baseUrl = Constants.IMG_BASE_URL;
				} else if(contentType.equals("course")) {
					baseUrl = Constants.COURSE_IMG_BASE_URL;
				} else if (contentType.equals("caseStudy")) {
					baseUrl = Constants.CASE_STUDIES_IMG_BASE_URL;
				} else if (contentType.equals("internTask")) {
					baseUrl = Constants.INTERN_IMAGE_BASE_URL;
				}
				
				fileContent = fileContent.replace(Constants.IMG_START, "<img class='tutorial-img' src='" + baseUrl);
				fileContent = fileContent.replace(Constants.IMG_END, "' />");
			}
			
			if(fileContent.contains(Constants.PROJECT_START)) {
				fileContent = fileContent.replace(Constants.PROJECT_START, "<a class='cws-button border-radius bt-color-3' target='_blank' href='" + Constants.PROJECT_DOWNLOAD_BASE_URL);
				fileContent = fileContent.replace(Constants.PROJECT_END, "'>" + " Download </a>");
			}
			
			if(fileContent.contains(Constants.DOCUMENT_START)) {
				fileContent = fileContent.replace(Constants.DOCUMENT_START, "<a class='cws-button border-radius bt-color-3' target='_blank' href='" + Constants.DOCUMENT_DOWNLOAD_BASE_URL);
				fileContent = fileContent.replace(Constants.DOCUMENT_END, "'>" + " Download </a>");
			}
			
			if(fileContent.contains(Constants.CASESTUDY_START)) {
				fileContent = fileContent.replace(Constants.CASESTUDY_START, "<a class='cws-button border-radius bt-color-3' target='_blank' href='" + Constants.CASESTUDIES_DOWNLOAD_BASE_URL);
				fileContent = fileContent.replace(Constants.CASESTUDY_END, "'>" + " Download </a>");
			}
			
			if(fileContent.contains(Constants.INTERN_START)) {
				fileContent = fileContent.replace(Constants.INTERN_START, "<a class='cws-button border-radius bt-color-3' target='_blank' href='" + Constants.INTERN_DOWNLOAD_BASE_URL);
				fileContent = fileContent.replace(Constants.INTERN_END, "'>" + " Download </a>");
			}
		}
		return fileContent;
	}
	
	/** 
	 * @param type defines codeType
	 * @return returns UI class based on inutType
	 */
	private static String getStartTemplateByType(String type) {
		String codeClass = Constants.CODE_TYPE_UI_CLASS_MAP.get(type);
		return "<pre class='" + codeClass + "'>" + "<code class='" + codeClass + "'>";
	}
	
	public static void writeDataToFile(String fileName , String content) throws IOException{
		 //FileOutputStream fout = null;
		 File file;
		 Writer fop=null;
		 BufferedWriter fout=null;
		try {
			file = new File(fileName);
			// if file doesnt exists, then create it
			if(file.exists()){
				file.delete();
			}
			if (!file.exists()) {
				file.createNewFile();
			}
			
			//fout = new FileOutputStream(file);
			
			fop = new OutputStreamWriter(
                   new FileOutputStream(file), "UTF-8");
			fout = new BufferedWriter(fop);
          
			String content1 =  content.replace("{", "{@@");
		    String content2 =  content1.replace("}", "}@@");
			String content3 =  content2.replace(";", ";@@");
			
			if(content3.contains("/*")){
				int startIndex = content3.indexOf("/*");
	    		int endIndex = content3.indexOf("*/");
	    		content3 = content3.replace(content3.substring(startIndex, endIndex+2), "");
			}
	        String[] contentArray = content3.split("@@");
	        for(int i=0;i<contentArray.length;i++){
	        	/*byte[] contentInBytes = null;
	        	// get the content in bytes
				contentInBytes = contentArray[i].getBytes();*/
	        	fout.write(contentArray[i]);
				fout.newLine();
				fout.flush();
		      
	        }
	        fout.close();
			System.out.println("Done");
	
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (fout != null) {
					fout.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
}
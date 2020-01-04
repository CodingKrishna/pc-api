
package org.pioneercoders.utils;

import java.util.Date;

import org.pioneercoders.utils.DateParser;

import java.util.HashMap;
import java.util.Map;

public class Constants {

	public static final String[] CODE_TYPES = {"@JAVA@", "@C@", "@HTML@", "@SERVLETS@", "@HIBERNATE@" , "@JS@"};
	public static final String CODE_START = "@CODE_START@";
	public static final String CODE_END = "@CODE_END@";
	public static final String JAVA_CODE_TYPE = "@";
	
	public static final Map<String, String> CODE_TYPE_UI_CLASS_MAP = new HashMap<String,String>();
	static{
		CODE_TYPE_UI_CLASS_MAP.put("JAVA", "language-java");
		CODE_TYPE_UI_CLASS_MAP.put("C", "language-c");
		CODE_TYPE_UI_CLASS_MAP.put("HTML", "language-html");
		CODE_TYPE_UI_CLASS_MAP.put("JS", "language-js");
		CODE_TYPE_UI_CLASS_MAP.put("HIBERNATE", "language-hibernate");
		CODE_TYPE_UI_CLASS_MAP.put("SERVLETS", "language-servlets");
	}
	
	public static final String IMG_START = "@IMG_START@";
	public static final String IMG_END = "@IMG_END@";
	public static final String IMG_BASE_URL = "tutorials/getimage/";
	public static final String COURSE_IMG_BASE_URL = "course/getimage/";
	public static final String CASE_STUDIES_IMG_BASE_URL = "casestudy/getimage/";
	public static final String INTERN_IMAGE_BASE_URL = "interntask/getimage/";
	public static final String PROJECT_START = "@PROJECT_START@";
	public static final String PROJECT_END = "@PROJECT_END@";
	public static final String DOCUMENT_START= "@DOCUMENT_START@";
	public static final String DOCUMENT_END = "@DOCUMENT_END@";
	public static final String CASESTUDY_START= "@CASESTUDY_START@";
	public static final String CASESTUDY_END = "@CASESTUDY_END@";
	public static final String INTERN_START= "@INTERN_START@";
	public static final String INTERN_END = "@INTERN_END@";
	
	public static final String PROJECT_DOWNLOAD_BASE_URL = "project/download/";
	public static final String DOCUMENT_DOWNLOAD_BASE_URL = "project/downloaddocu/";
	public static final String CASESTUDIES_DOWNLOAD_BASE_URL = "campus/downloadcasestudies/";
	public static final String INTERN_DOWNLOAD_BASE_URL = "interntask/downloadintertask/";
	
	
	public static final String STATUS_ACTIVE="ACTIVE";
	public static final String STATUS_DEACTIVE="DEACTIVE";
	public static final String STATUS_PENDING="PENDING";
	public static final String NO_COURSE_DESCRIPTION="NO DESCRIPTION AVAILABLE";
	
	public static final Long FOR_INTERVIEW=6l;
	public static final String SUBJECT_FOR_INTERVIEW="INTERVIEW";
	public static final String INTERVIEW_FILE="Interview.html";
	
	public static final String GROUP_HTML="HTML";
	
	public static final String GROUP_CSS="CSS";
	
	public static final String GROUP_JAVA="JAVA";
	
	public static final String QUES_TYPE_BLANCK="BLANCK";
	
	public static final String QUES_TYPE_CHOICE="CHOICE";
	
	public static Date CREATED_ON() {
		return DateParser.removeTimeFromDate(new Date());
	}
	
	public static String updateContent(String finalString,Boolean editable){
		while(finalString.contains(Constants.CODE_START)) {
			int startIndex = finalString.indexOf(Constants.CODE_START);
			int endIndex = finalString.indexOf(Constants.CODE_END) + (Constants.CODE_END.length());
			if(startIndex != -1 && endIndex != -1) {
				char[] codeContent = new char[endIndex - startIndex];
				finalString.getChars(startIndex, endIndex, codeContent, 0);
				String codeContentString = new String(codeContent);
				for(int i=0; i<Constants.CODE_TYPES.length; i++) {
					int index = codeContentString.indexOf(Constants.CODE_TYPES[i]);
					if (index != -1) {
						codeContentString = codeContentString.replace("<", "&lt;");
						codeContentString = codeContentString.replace(">", "&gt;");
						codeContentString = codeContentString.replace(Constants.CODE_TYPES[i], "");
						if(editable!=true){
							codeContentString = codeContentString.replace(Constants.CODE_START, "<pre class='" +
								Constants.CODE_TYPE_UI_CLASS_MAP.get(Constants.CODE_TYPES[i].replace("@", "")) + "'>" +
								"<code class='" + Constants.CODE_TYPE_UI_CLASS_MAP.get(Constants.CODE_TYPES[i].replace("@", "")) + "'>");
						}else{
							codeContentString = codeContentString.replace(Constants.CODE_START, "<pre class='" +
									Constants.CODE_TYPE_UI_CLASS_MAP.get(Constants.CODE_TYPES[i].replace("@", "")) + "'>" +
									"<code contenteditable='"+editable+"' style='outline:none' class='" + Constants.CODE_TYPE_UI_CLASS_MAP.get(Constants.CODE_TYPES[i].replace("@", "")) + "'>");
						}
						codeContentString = codeContentString.replace(Constants.CODE_END, "</code></pre>");
					}
				}
				finalString = finalString.replace(new String(codeContent), codeContentString).trim();
			}
		}
		return finalString;
	}
}
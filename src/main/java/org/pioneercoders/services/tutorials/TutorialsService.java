package org.pioneercoders.services.tutorials;

import javax.servlet.http.HttpServletResponse;

public interface TutorialsService {

	public String getFileByPath(String directory, String fileName, String subdir);

	public void getImage(HttpServletResponse response, String fileName, String directory, String format);

	public String getFileDataByPath(String directory, String fileName,
			String subdir);

	public void getVedioFileByPath(HttpServletResponse response,String directory, String fileName);
}

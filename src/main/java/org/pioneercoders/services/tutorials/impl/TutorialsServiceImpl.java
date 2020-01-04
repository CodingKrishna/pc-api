package org.pioneercoders.services.tutorials.impl;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.IOUtils;
import org.pioneercoders.services.tutorials.TutorialsService;
import org.pioneercoders.utils.AppConfig;
import org.pioneercoders.utils.FileReadUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(propagation = Propagation.REQUIRED)
public class TutorialsServiceImpl implements TutorialsService{
	
	@Autowired
	AppConfig appConfig;
	
	//String errorFile = new FileReadUtil().getProperty("ERROR_DIRECTORY");
	
	@Override
	public String getFileByPath(String directory, String fileName, String subdir) {
		
		String output = null;
		try {
			String filePath = directory;
			if (subdir != null) {
				filePath += ("\\" + subdir);
			}
			filePath = appConfig.getTutorialDirectory() + "\\" + filePath+ "\\" + fileName + ".html";
			
			output = FileReadUtil.getFileContent(filePath, "tutorial");
		} catch (IOException e) {
			e.printStackTrace();
			/*try {
				output = FileReadUtil.getFileContent(errorFile.concat("Coming2.png"), "errorFile");
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}*/
		}
		return output;
	}
	@Override
	public void getImage(HttpServletResponse response,String fileName, String directory, String format) {
		try {
			File f = new File((appConfig.getTutorialDirectory() + "\\" + directory + "\\images\\"),
					(fileName + "." + format));

			InputStream in = new FileInputStream(f);
			OutputStream os = response.getOutputStream();
			os.write(IOUtils.toByteArray(in));
			in.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	@Override
	public String getFileDataByPath(String directory, String fileName,
			String subdir) {
		String output = null;
		try {
			String filePath = directory;
			if (subdir != null) {
				filePath += ("\\" + subdir);
			}
			output = FileReadUtil.getFileContent(appConfig.getLecturerHomeDirectory() + "\\" + filePath
					+ "\\" + fileName + ".html", "tutorial");
		} catch (IOException e) {
			e.printStackTrace();
		}
		return output;
	}
	@Override
	public void getVedioFileByPath(HttpServletResponse response,String directory, String fileName) {
		try {
			File f = new File((appConfig.getTutorialDirectory() + "\\" + directory + "\\VEDIOS\\"),
					(fileName + ".mp4"));

			InputStream in = new FileInputStream(f);
			OutputStream os = response.getOutputStream();
			os.write(IOUtils.toByteArray(in));
			in.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
}

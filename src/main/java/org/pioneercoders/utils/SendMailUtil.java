package org.pioneercoders.utils;

import java.util.Properties;

import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

public class SendMailUtil {

	public int sendMail(String Recipient_mail_id, String subject, String htmlText) {
		try {
			String Email_Id = new FileReadUtil().getProperty("MAIL_FROMADDRESS");
			String password = new FileReadUtil().getProperty("MAIL_PASSWORD");
			String host_name = new FileReadUtil().getProperty("MAIL_HOSTNAME");
			String port = new FileReadUtil().getProperty("MAIL_PORT");
			Properties props = System.getProperties();
			
			props.put("mail.smtp.host", host_name);
			props.put("mail.smtp.user", Email_Id);
			props.put("mail.smtp.password", password);
			props.put("mail.smtp.port", port);
			props.put("mail.smtp.auth", "true");

			props.setProperty("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
			props.setProperty("mail.smtp.socketFactory.fallback", "false");
			props.setProperty("mail.smtp.socketFactory.port", port);
			props.put("mail.smtp.startssl.enable", "false");

			Session session = Session.getDefaultInstance(props);
			MimeMessage message = new MimeMessage(session);

			try {
				// Set email data
				message.setFrom(new InternetAddress(Email_Id));
				message.addRecipient(Message.RecipientType.TO, new InternetAddress(Recipient_mail_id));
				message.setSubject(subject);
				MimeMultipart multipart = new MimeMultipart();
				BodyPart messageBodyPart = new MimeBodyPart();

				// HTML mail content
				messageBodyPart.setContent(htmlText, "text/html");
				multipart.addBodyPart(messageBodyPart);
				message.setContent(multipart);

				// Connect to smtp server and send Email
				Transport transport = session.getTransport("smtp");
				transport.connect(host_name, Email_Id, password);
				transport.sendMessage(message, message.getAllRecipients());
				transport.close();
			} catch (MessagingException ex) {
				ex.printStackTrace();
				return 0;
			} catch (Exception ae) {
				ae.printStackTrace();
				return 0;
			}
		} catch (Exception exception) {
			exception.printStackTrace();
			return 0;
		}
		
		return 1;
	}
/*
	private String readContentFromFile(String fileName, String activateBaseUrl, Long id, Date interviewDate) {
		StringBuffer contents = new StringBuffer();
		String url =null;
		if(id!=null){
			String encodedId = new BASE64Encoder().encodeBuffer(id.toString().getBytes());
			url = "<a href=\"" + activateBaseUrl + "?id="+encodedId+"\">"+"click</a>";
		}
		try {
			// use buffering, reading one line at a time
			BufferedReader reader = new BufferedReader(new FileReader(fileName));
			try {
				String line = null;
				while ((line = reader.readLine()) != null) {
					contents.append(line);
					contents.append(System.getProperty("line.separator"));
				}
				String acronym = "@ACTIVATION_LINK@";
				String interviewacronym = "@INTERVIEWDATE@";
				if(contents.indexOf(acronym)>-1){
					contents = contents.replace(contents.indexOf(acronym), contents.indexOf(acronym) + acronym.length(), url);
				}else if(contents.indexOf(interviewacronym)>-1){
					contents = contents.replace(contents.indexOf(interviewacronym), contents.indexOf(interviewacronym) + interviewacronym.length(), interviewDate.toString());
				}
			} finally {
				reader.close();
			}
		} catch (IOException ex) {
			ex.printStackTrace();
		}
		return contents.toString();
	}*/
	
	
	
	/*this is the information of host
	#MAIL_FROMADDRESS = vamsi3369@gmail.com
	#MAIL_PASSWORD = vamsikrishna3369
	#MAIL_HOSTNAME = smtp.gmail.com
	#MAIL_PORT = 465*/
}
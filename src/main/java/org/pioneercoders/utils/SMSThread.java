package org.pioneercoders.utils;

public class SMSThread implements Runnable{
	
	String message = null;
	String mobileNo = null;
	
	public SMSThread(String message, String mobileNo){
		this.message = message;
		this.mobileNo = mobileNo;
	}
	

	@Override
	public void run() {
		WebServiceHttpClient.sendSMSThroughGet(message, mobileNo);
	}

}

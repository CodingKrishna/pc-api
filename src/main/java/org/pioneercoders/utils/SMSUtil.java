package org.pioneercoders.utils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SMSUtil {
	
	public static final String MOBILE_KEY = "mobileNo";
	public static final String MESSAGE_KEY = "message";
	public static final String[] ACRONYMS = {"@POINEER_CODERS_MOBILE@", "@INTERVIEW_DATE@", "@ADDRESS@" };

	public static String sendSMS(String message, String mobileNo) {
		return WebServiceHttpClient.sendSMSThroughGet(message, mobileNo);
	}
	
	public static List<Map<String, String>> sendSMS(List<Map<String, String>> messageAndMobileNumbers) {
		List<Map<String, String>> result = new ArrayList<Map<String, String>>();
		for(Map<String, String> messageAndMobileNo : messageAndMobileNumbers) {
			String message = messageAndMobileNo.get(MESSAGE_KEY);
			String mobileNo = messageAndMobileNo.get(MOBILE_KEY);
			messageAndMobileNo.put("deliveryId", sendSMS(message, mobileNo));
			result.add(messageAndMobileNo);
		}
		return result;
	}
	
	public static List<Map<String, String>> sendSMS(List<String> mobileNumbers, String message) {
		List<Map<String, String>> result = new ArrayList<Map<String, String>>();
		for(String mobileNo : mobileNumbers) {
			Map<String, String> sentItem = new HashMap<String, String>();
			sentItem.put(MOBILE_KEY, mobileNo);
			sentItem.put(MESSAGE_KEY, message);
			// newly added code
			SMSThread smsThread = new SMSThread(message.toString(), mobileNo);
			Thread smsth = new Thread(smsThread);
			smsth.start();
			
			//sentItem.put("deliveryId", sendSMS(message, mobileNo));
			result.add(sentItem);
		}
		return result;
	}
	
	public static void main(String[] args) {
		/*String[] data = {"9505949022","8008055874","8985244023","9986565469","8904653070","9686571630","9686571631","9092121112","9676333347","9676350410","8888888888","7204755585","8867747577","9986687238","9844795637","4884848885","9035744582","9700177026","9790815897","8892599078","8886414321","9642480076","9743499480","7989618819","9686696621","9902612585","8084144609","9513800954","9880577218","8050500869","8971991649","7259566246","8956799701","9686410991","8297507115","9900261723","8095876744","7989303259","9482421336","8971524503","7411062329","9986356242","9158730202","9164757078","9545376909","7795038340","8553540178","8792193298","8553695819","9538338837","9492972193","9066416157","8951846939","9663865866","7204550780"};
		List<String> li = new ArrayList<String>();
		for(int i=0;i<data.length;i++){
			li.add(data[i]);
		}
		
		sendSMS(li, "Pioneer Coders IT Academy- Wish You Be Accompanied With Auspiciousness & Blessings Of Ram Navami.! www.pioneercoders.com");
		//sendSMS("Pioneer Coders IT Academy- Wish You Be Accompanied With Auspiciousness & Blessings Of Ram Navami.! www.pioneercoders.com", "9482421336");
*/		
		sendSMS("From pioneercoders You have an Interview on 29-07-2017(9.30am). Address : #97, 1st Floor, 20th Main, BTM 1st Stage Near Indane Gas Agency, Bangalore-560068.","9206705782");
		System.out.println("data is sended succesfully");
	}
}

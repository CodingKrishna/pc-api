package org.pioneercoders.utils;

import java.io.IOException;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

public class Test {
	
	public static void main(String[] args) throws IOException {
		
		String encodedBytes = new BASE64Encoder().encodeBuffer("nekkala.appaji@gmail.com".getBytes());
		
		byte[] finalData2 = new BASE64Decoder().decodeBuffer(encodedBytes);
		System.out.println(new String(finalData2));
	}
}

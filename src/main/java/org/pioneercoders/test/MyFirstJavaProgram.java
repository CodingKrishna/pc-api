package org.pioneercoders.test;

import java.util.Scanner;

import org.pioneercoders.utils.AppConfig;
import org.springframework.beans.factory.annotation.Autowired;

public class MyFirstJavaProgram {

	@Autowired
	static AppConfig appConfig;
	
	public static void main(String[] args) {


		
		Scanner sc = new Scanner(System.in);

		String a = sc.next();

		String b = sc.next();

		String c = add(a, b);

		System.out.println(c);
	
	}

	public static String add(String a, String b) {

		String c = a + b;
		System.out.println("*********************************"+appConfig.getRegistrationEmailTemplate());      
		System.out.println(c);
		return c;

	}

}
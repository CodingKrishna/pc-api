package org.pioneercoders.services.common.impl;

import java.util.Date;

import org.pioneercoders.utils.DateParser;

public class Test {

	public static void main(String[] args) {
		System.out.println(new Date().toString());
		System.out.println(DateParser.dateToString(new Date()));
	}
}

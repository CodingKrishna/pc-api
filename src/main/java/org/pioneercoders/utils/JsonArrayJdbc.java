package org.pioneercoders.utils;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import org.json.JSONArray;
import org.json.JSONObject;

public class JsonArrayJdbc {
	public static void main(String[] args) {
		try {
	        Connection con = DriverManager.getConnection( "jdbc:mysql://localhost:3306/pioneercoderslive_backup","root","root");
	        Connection con1 = DriverManager.getConnection( "jdbc:mysql://localhost:3306/pioneercoders_production","root","root");

	       String sql = "INSERT INTO purchased_courses_trn_tbl("+"PURCHASED_DATE,"+"COURSE_ID,"+"USER_ID)"+ "VALUES(?,?,?)";

	        Statement statement = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);

	        PreparedStatement pstmt = con1.prepareStatement(sql);

	        ResultSet rs = statement.executeQuery("SELECT * from pioneercoderslive_backup.purchased_courses_trn_tbl");
	        while (rs.next()) {
	        	
	        	String s1=rs.getString(2); 
	        	
	        	JSONArray jsonarray = new JSONArray(s1);
	        	
	        
	        	for (int i = 0; i < jsonarray.length(); i++) {
	        		
	        		Long nm3 = rs.getLong(3);
	        		
	        		Date date = rs.getDate(4);
		        	
	        	    JSONObject jsonobject = jsonarray.getJSONObject(i);
	        	    System.out.println(jsonobject.getString("courseName"));
	        	   
	        	    	Long id = jsonobject.getLong("id");
	        	    	
						pstmt.setLong(2, id);
						
						pstmt.setDate(1, date);
					
					pstmt.setLong(3, nm3);
					
					System.out.println(nm3);
					pstmt.executeUpdate();
				
	        	}
	        	
	        	
	        }
		}
		catch(Exception ex){
			ex.printStackTrace();
		}
	}
}

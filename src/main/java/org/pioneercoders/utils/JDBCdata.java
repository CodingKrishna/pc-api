package org.pioneercoders.utils;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCdata{
	
	public static void main(String[] args) {
		try {
	        Connection con = DriverManager.getConnection( "jdbc:mysql://localhost:3306/pioneercoderslive_backup","root","root");
	        Connection con1 = DriverManager.getConnection( "jdbc:mysql://localhost:3306/pioneercoders_production","root","root");

	        String sql = "INSERT INTO user_basic_skills_tbl("+"ANALYTICAL_RATING,"+"COMMUNICATION_RATING,"+"USER_ID)"+ "VALUES(?,?,?)";

	        Statement statement = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);

	        PreparedStatement pstmt = con1.prepareStatement(sql);

	        ResultSet rs = statement.executeQuery("SELECT * from pioneercoderslive_backup.skillset_mst_tbl where id > 10");
	        while (rs.next()) {
	        	
	       	 Long user = rs.getLong(3);
	        	 Long nm2 = rs.getLong(4);
	        	
	        	 Long nm3 = rs.getLong(5);


	            pstmt.setLong(1, nm2);
	            
	            pstmt.setLong(2, nm3);
	            pstmt.setLong(3, user);



	            pstmt.executeUpdate();
	        }
	    } catch (SQLException e) {
	        System.out.println("could not get JDBC connection: " +e);
	    } 
	}
	
}

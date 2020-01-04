package org.pioneercoders.utils;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Iterator;
import java.util.Map;

import org.json.JSONObject;

import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JSontesting {
	public static void main(String[] args) {
		try {
	        Connection con = DriverManager.getConnection( "jdbc:mysql://localhost:3306/pioneercoderslive_backup","root","root");
	        Connection con1 = DriverManager.getConnection( "jdbc:mysql://localhost:3306/pioneercoders_production","root","root");

	       String sql = "INSERT INTO user_addresses_tbl("+"ADDRESS,"+"PINCODE,"+"USER_ID)"+ "VALUES(?,?,?)";

	        Statement statement = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);

	        PreparedStatement pstmt = con1.prepareStatement(sql);

	        ResultSet rs = statement.executeQuery("SELECT * from pioneercoderslive_backup.user_mst_tbl");
	        while (rs.next()) {
	        	
	        	String s1=rs.getString(2); 
	        	
	        	JsonFactory factory = new JsonFactory();

	            ObjectMapper mapper = new ObjectMapper(factory);
	            JsonNode rootNode = null;
				try {
					rootNode = mapper.readTree(s1);
				} catch (JsonProcessingException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}  
	            Long nm1 = rs.getLong(1);
	        	System.out.println(nm1.toString());

	            Iterator<Map.Entry<String,JsonNode>> fieldsIterator = rootNode.fields();
	            while (fieldsIterator.hasNext()) {
	            	

	                Map.Entry<String,JsonNode> field = fieldsIterator.next();
	                if(field.getKey() == "present"){
	                	
			        	System.out.println(field.getValue().get("address"));
	                //	JSONObject jObject  = new JSONObject(field.getValue());
						if(field.getValue().get("address").isNull() == false){
							String edutype =  field.getValue().get("address").textValue();
							pstmt.setString(1, edutype);
						}else{
							String edutype = "";
							pstmt.setString(1, edutype);
						}
						if(field.getValue().get("pincode").isNull() == false){
							String branch =  field.getValue().get("pincode").textValue();
							pstmt.setString(2, branch);
						}else{
							String branch = "";
							pstmt.setString(2, branch);
						}
						
	                }
	                
	            }
	            pstmt.setLong(3, nm1);
				
				pstmt.executeUpdate();
	            
	        }
		}catch(SQLException e){
			e.printStackTrace();
			
		}
		
	}

}

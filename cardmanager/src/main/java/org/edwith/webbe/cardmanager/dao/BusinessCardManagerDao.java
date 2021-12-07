package org.edwith.webbe.cardmanager.dao;

import org.edwith.webbe.cardmanager.dto.BusinessCard;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class BusinessCardManagerDao {
	private static String dburl = "jdbc:mysql://192.168.219.107:3306/connectdb?serverTimezone=Asia/Seoul&useSSL=false";			
	private static String dbuser = "connectuser";
	private static String dbpasswd = "1111";
	
    public List<BusinessCard> searchBusinessCard(String keyword){
    	
    	List<BusinessCard> list = new ArrayList<>();
    	
    	try {
    		Class.forName(  "com.mysql.cj.jdbc.Driver"  );
    	} catch (ClassNotFoundException e) {
    		e.printStackTrace();
    	}
    	
    	String sql = "SELECT name, phone_number, company_name, create_date FROM businesscard WHERE name LIKE ?";
    	// 통상 쿼리문에서는 WHERE name LIKE '홍%'으로 쓰지만 여기서는 quote를 모두 없앤다.
    	// Otherwise an error occurs
    	try (
    			Connection conn = DriverManager.getConnection(dburl, dbuser, dbpasswd);
    			PreparedStatement ps = conn.prepareStatement(sql);
		) {
    		ps.setString(1, keyword);
    		try (ResultSet rs = ps.executeQuery()) {
    			
    			while( rs.next() ) {
    				String name = rs.getString(1);
    				String phone = rs.getString(2);
    				String companyName = rs.getString(3);
    				java.util.Date createDate = rs.getDate(4);
    				
    				BusinessCard bs = new BusinessCard(name, phone, companyName);
    				bs.setCreateDate(createDate);
    				list.add(bs);   				
    			}
    			
    		} catch (Exception e) {
    			e.printStackTrace();
    		}
    	} catch (Exception e) {
    		e.printStackTrace();
    	}
    	
    	
    	return list;
    }

    public BusinessCard addBusinessCard(BusinessCard businessCard){   	
    	int insertCount = 0;
    	try {
    		Class.forName(  "com.mysql.cj.jdbc.Driver"  );
    	} catch (ClassNotFoundException e) {
    		e.printStackTrace();
    	}
    	
    	String sql = "INSERT INTO businesscard(name, phone_number, company_name, create_date) VALUES (?, ?, ?, ?)";
    	
    	try (
    			Connection conn = DriverManager.getConnection(dburl, dbuser, dbpasswd);
    			PreparedStatement ps = conn.prepareStatement(sql);
		) {
    		ps.setString(1, businessCard.getName());
    		ps.setString(2, businessCard.getPhone());
    		ps.setString(3, businessCard.getCompanyName());
    		java.sql.Timestamp sqlDate = new java.sql.Timestamp(businessCard.getCreateDate().getTime());
    		ps.setTimestamp(4, sqlDate );
    		
			insertCount = ps.executeUpdate();
 
    	} catch (Exception e) {
    		e.printStackTrace();
    		System.out.println(insertCount + ":  Record Insertion FAILED");
    		return null;
    	} 
    	
    	System.out.println(insertCount + ":  Record Insertion was Successful :\n   " + businessCard.toString());
    	return businessCard;
    }
}

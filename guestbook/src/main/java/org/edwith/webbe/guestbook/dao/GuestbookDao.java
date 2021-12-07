package org.edwith.webbe.guestbook.dao;

import org.edwith.webbe.guestbook.dto.Guestbook;
import org.edwith.webbe.guestbook.util.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class GuestbookDao {
	
    public List<Guestbook> getGuestbooks(){
        List<Guestbook> list = new ArrayList<>();

        try {
        	Class.forName(  "com.mysql.jdbc.Driver"  );
        } catch (ClassNotFoundException e) {
        	e.printStackTrace();
        }
        
        String sql = "SELECT id, name, content, regdate FROM guestbook order by regdate DESC";
        try (
        	Connection conn = DBUtil.getConnection();
        	PreparedStatement ps = conn.prepareStatement(sql);
		) {
        	try (ResultSet rs = ps.executeQuery()) {
        		while(rs.next() ) {
        			Long id = rs.getLong("id");
        			String name = rs.getString("name");
        			String content = rs.getString("content");
        			Date regdate = rs.getTimestamp(4);
        			Guestbook gs = new Guestbook(id, name, content, regdate);
        			System.out.println(gs.toString());
        			list.add(gs);        			
        		}
        	} catch (Exception e) {
        		e.printStackTrace();
        	}
        } catch (Exception e) {
        	e.printStackTrace();
        }

        return list;
    }

    public void addGuestbook(Guestbook guestbook){
    	int insertCount = 0;
        
    	try {
    		Class.forName(  "com.mysql.jdbc.Driver"  );
    	} catch (ClassNotFoundException e) {
    		e.printStackTrace();
    	}
    	
    	String sql = "INSERT INTO guestbook(name, content, regdate) VALUES(?, ?, ?)";
    	try (
			Connection conn = DBUtil.getConnection();
    		PreparedStatement ps = conn.prepareStatement(sql);
		) {
    		ps.setString(1, guestbook.getName());
    		ps.setString(2, guestbook.getContent());
    		java.sql.Timestamp sqlDate = new java.sql.Timestamp(guestbook.getRegdate().getTime());
    		ps.setTimestamp(3, sqlDate);
    		
    		insertCount = ps.executeUpdate();
    		
    	} catch (Exception e) {
    		e.printStackTrace();
    		System.out.println(insertCount + " : Guestbook upload Failed");
    		System.out.println(guestbook.toString());
    		return;
    	}
    	System.out.println(insertCount + " : Guestbook upload Success");
    	System.out.println(guestbook.toString());
    }
}

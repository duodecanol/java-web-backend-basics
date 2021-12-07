package cardmanager;

import org.edwith.webbe.cardmanager.dto.BusinessCard;
import org.edwith.webbe.cardmanager.dao.BusinessCardManagerDao;
import java.util.List;
import java.util.ArrayList;
import java.util.Date;

public class DaoTest {
	public static void main(String[] args) {
		searchTest("홍%");
		
		
//		addTest();
		
		
//		Date myDate = new Date();
//		System.out.println(myDate);
//		System.out.println(myDate.getTime());
//		
//		java.sql.Timestamp sqlTS = new java.sql.Timestamp(myDate.getTime());
//		System.out.println(sqlTS);
		

	}
	
	static void searchTest(String keyword) {
		BusinessCardManagerDao dao = new BusinessCardManagerDao();
		
		List<BusinessCard> list = new ArrayList<>();
		
		list = dao.searchBusinessCard(keyword);
		
		for (BusinessCard card : list) {
			System.out.println(card);
		}
	}
	
	static void addTest() {
		BusinessCardManagerDao dao = new BusinessCardManagerDao();
//		BusinessCard bc = new BusinessCard("William Tell", "060-5488-1355", "Apple Inc.");
		BusinessCard bc = new BusinessCard("국민용", "070-6655-1835", "대지건설");
		BusinessCard newBc =  dao.addBusinessCard(bc);		
//		System.out.println(newBc.toString());				
	}
}

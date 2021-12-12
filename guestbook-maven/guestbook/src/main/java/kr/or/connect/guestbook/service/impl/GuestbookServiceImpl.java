package kr.or.connect.guestbook.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import kr.or.connect.guestbook.dao.GuestbookDao;
import kr.or.connect.guestbook.dao.LogDao;
import kr.or.connect.guestbook.dto.Guestbook;
import kr.or.connect.guestbook.dto.Log;
import kr.or.connect.guestbook.service.GuestbookService;

@Service
public class GuestbookServiceImpl implements GuestbookService {
	@Autowired
	GuestbookDao guestbookDao;
	@Autowired
	LogDao logDao;

	@Override
	@Transactional(readOnly = false)
	public Guestbook addGuestbook(Guestbook guestbook, String ip) {
		guestbook.setRegdate(new Date());
		Long id = guestbookDao.insert(guestbook);

		guestbook.setId(id); // DB에 입력하면서 auto-increment된 id를 가져온다
		
		// transaction rollback이 일어나는 조건 생성
//		if (true)
//			throw new RuntimeException("Test Exception ");
		
		Log log = new Log();
		log.setIp(ip);
		log.setMethod("insert");
		log.setRegdate(new Date());
		
		logDao.insert(log);
				
		return guestbook;
	}

	@Override
	@Transactional(readOnly = false)
	public int deleteGuestbook(Long id, String ip) {
		int deleteCount = guestbookDao.deleteById(id);
		
		Log log = new Log();		
		log.setMethod("delete");
		log.setIp(ip);
		log.setRegdate(new Date());
		
		logDao.insert(log);
		
		return deleteCount;
	}

	@Override
	public int getCount() {
		return guestbookDao.selectCount();
	}

	@Override
	@Transactional(readOnly = true)
	public List<Guestbook> getGuestbooks(Integer start) {
		List<Guestbook> listGuestBook = guestbookDao.selectAll(start, GuestbookService.LIMIT);
		return listGuestBook;
	}

}

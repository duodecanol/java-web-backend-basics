package kr.or.connect.guestbook.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import kr.or.connect.guestbook.dto.Guestbook;
import kr.or.connect.guestbook.service.GuestbookService;

@Controller
public class GuestbookController {
	@Autowired
	GuestbookService guestbookService;

	@GetMapping(path = "/list")
	public String list(@RequestParam(name = "start", required = false, defaultValue = "0") int start, 
			ModelMap model,
			@CookieValue(value = "count", defaultValue = "0", required = true) String value, // Cookie Handler Annot
			HttpServletRequest request, HttpServletResponse response) {

		try {
			int i = Integer.parseInt(value); // 찾은 경우 기존 값에 ++
			value = Integer.toString(++i);
		} catch (Exception ex) {
			value = "1"; // Exception 발생시 count: 1로 초기화
		}

		Cookie cookie = new Cookie("count", value);
		cookie.setMaxAge(60 * 60 * 24 * 7); // 7일간 쿠키 유지
		cookie.setPath("/"); // '/' 경로 이하에 모두 적용
		response.addCookie(cookie);
		
		// 방명록 목록 구하기
		List<Guestbook> list = guestbookService.getGuestbooks(start);

		// 전체 페이지수 구하기
		int count = guestbookService.getCount();
		int pageCount = count / GuestbookService.LIMIT;
		if (count % GuestbookService.LIMIT > 0)
			pageCount++;

		/*
		 * 페이지 수만큼 start의 값을 리스트로 저장 예를 들면, 페이지 수가 3이면 0, 5, 10 list?start=0 ,
		 * list?start=5 , list?start=10 처럼 링크가 걸린다.
		 */
		List<Integer> pageStartList = new ArrayList<Integer>();
		for (int i = 0; i < pageCount; i++) {
			pageStartList.add(i * GuestbookService.LIMIT);
		}

		model.addAttribute("list", list);
		model.addAttribute("count", count);
		model.addAttribute("pageStartList", pageStartList);
		model.addAttribute("cookieCount", value); // JSP에게 전달하기 위해 쿠키 값을 model에 담아 전송

		return "list";
	}

	@PostMapping(path = "/write")
	public String write(@ModelAttribute Guestbook guestbook, HttpServletRequest request) {
		String clientIp = request.getRemoteAddr();
		System.out.println("Client IP: " + clientIp);
		guestbookService.addGuestbook(guestbook, clientIp);
		return "redirect:list";
	}
}

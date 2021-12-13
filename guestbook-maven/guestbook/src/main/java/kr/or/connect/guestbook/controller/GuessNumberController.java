package kr.or.connect.guestbook.controller;

import java.util.Enumeration;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.HttpRequestHandler;
import org.springframework.web.bind.annotation.GetMapping;

/*
 * 실습코드

		/guess로 요청을 하면 컴퓨터가 1부터 100 사이의 임의의 값 중의 하나를 맞춰보라는 메시지가 출력합니다.
		해당 값은 세션에 저장합니다.
		사용자는 1부터 100 사이의 값을 입력합니다.
		입력한 값이 세션 값보다 작으면, 입력한 값이 작다고 출력합니다.
		입력한 값이 세션 값보다 크면, 입력한 값이 크다고 출력합니다.
		입력한 값이 세션 값과 같다면 몇 번째에 맞췄다고 출력합니다.
 * */
@Controller
public class GuessNumberController {

	@GetMapping(path = "/guess")
	public String guessNumber(HttpServletRequest request, HttpServletResponse response, HttpSession session) {
		
		System.out.println(session.getId());
		System.out.println(session.isNew());
		System.out.println(session.getCreationTime());
		System.out.println(session.getLastAccessedTime());
		Enumeration<String> attributeNames = session.getAttributeNames();
		while( attributeNames.hasMoreElements()) {
			System.out.println("     " + attributeNames.nextElement().toString());
		}
		System.out.println();
		int guess = (int) session.getAttribute("guess");
		System.out.println(guess);
		session.setAttribute("guess", ++guess);
		
		
		return "guess";
	}
}

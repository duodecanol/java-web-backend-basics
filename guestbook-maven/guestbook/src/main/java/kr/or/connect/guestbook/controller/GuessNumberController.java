package kr.or.connect.guestbook.controller;

import java.util.Enumeration;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.HttpRequestHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

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
	public String guessNumber(@RequestParam(name = "number", required = false) Integer number, HttpSession session,
			ModelMap model) {

		String message = null;

		if (number == null) {
			session.setAttribute("count", 0);
			session.setAttribute("randomNumber", (int) (Math.random() * 100) + 1);
			message = "내가 생각한 숫자를 맞춰보시요.";
		} else {
			int count = (Integer)session.getAttribute("count");
			int randomNumber = (Integer)session.getAttribute("randomNumber");
			
			if (number < randomNumber) {
				message = "입력한 값은 내가 생각하고 있는 숫자보다 작습니다.";
				session.setAttribute("count", ++count);
			} else if (number > randomNumber) {
				message = "입력한 값은 내가 생각하고 있는 숫자보다 큽니다.";
				session.setAttribute("count", ++count);
			} else {
				message = "정답입니다~~ " + ++count + "번째에 맞췄습니다. 내가 생각한 숫자는 " + number + "입니다." ;
				session.removeAttribute("count");
				session.removeAttribute("randomNumber");
			}
		}
		
		Enumeration<String> attributeNames = session.getAttributeNames();
		while( attributeNames.hasMoreElements()) {
			System.out.println("     " + attributeNames.nextElement().toString());
		}
		System.out.println(session.getAttribute("count"));
		System.out.println(session.getAttribute("randomNumber"));
		model.addAttribute("message", message);
		return "guess";
	}
}

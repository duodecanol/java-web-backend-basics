package org.edwith.webbe.guestbook.servlet;

import org.edwith.webbe.guestbook.dao.GuestbookDao;
import org.edwith.webbe.guestbook.dto.Guestbook;
import org.edwith.webbe.guestbook.servlet.GuestbookListServlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/guestbooks/write")
public class GuestbookWriteServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
	public GuestbookWriteServlet() {
		super();
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.sendRedirect("/guestbook/guestbooks");
		// redirect 오류나는 문제 server의 path 수정.
		// https://shinye0213.tistory.com/336
		// https://october-east-sea.tistory.com/160
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	request.setCharacterEncoding("UTF-8"); // 안해주면 문자가 깨짐
        String name = request.getParameter("name");
        String content = request.getParameter("content");
        
        Guestbook bs = new Guestbook(name, content);
        GuestbookDao dao = new GuestbookDao();
        dao.addGuestbook(bs);
        doGet(request, response);
    }

}

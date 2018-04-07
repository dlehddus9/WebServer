package session.exam;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.catalina.servlet4preview.http.HttpServletRequest;

@WebServlet("/SessionLogout")
public class SessionLogout extends HttpServlet{
	
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws
	ServletException, IOException {
		HttpSession session = req.getSession();
		session.invalidate();
		
		resp.setContentType("text/html;charset=utf-8");
		PrintWriter out = resp.getWriter();
		out.print("로그아웃 하셨습니다.");
		out.print("<p><a href='SessionLoginForm'> 로그인 화면 가기</a></p>");
		out.close();
		
	}

}

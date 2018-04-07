package session.exam;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/SessionLoginForm")
public class SessionLoginForm  extends HttpServlet{
	
	
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws
	ServletException, IOException {
		resp.setContentType("text/html;charset=utf-8");
		PrintWriter out = resp.getWriter();
		
		out.print("<html><head><title>세션 로그인폼</title></head><body>");
		out.print("<form action='SessionLoginProcess' method='post'>");
		out.print("아이디 : <input type='text' name='id' size='20'><br>");
		out.print("패스워드 : <input type='password' name='pw' size='20'><br>");
		out.print("<input type='submit' value='로그인'></form></body></html>");
		out.close();
		
	}

}

package session.exam;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/SessionLoginCheck")
public class SessionLoginCheck extends HttpServlet {
	
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws 
	ServletException, IOException {
		HttpSession session = req.getSession();
		String id= (String)session.getAttribute("ID");
		boolean login =(id ==null) ? false : true;
		
		resp.setContentType("text/html;charset=utf-8");
		PrintWriter out = resp.getWriter();
		
		if(login) {
			out.print(id +"로 로그인 하셨습니다.<br>");
			out.print("세션 ID : "+ session.getId());
			out.print("<p><a href = 'SessionLoginForm'> 로그인 화면 가기</a>" );
		}
		out.close();
	}
	
}

package session.exam;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/SessionLoginProcess")
public class SessionLoginProcess extends HttpServlet {
	
	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws
	ServletException, IOException {
		HttpSession session = req.getSession();
		
		String storedId = "abc";
		String storedPw = "1234";
		
		String id = req.getParameter("id");
		String pw =req.getParameter("pw");
		
		resp.setContentType("text/html;charset=utf-8");
		PrintWriter out = resp.getWriter();
		
		if(storedId.equals(id) && storedPw.equals(pw)) {
			session.setAttribute("ID", id);
			out.print("�α��ο� �����ϼ̽��ϴ�.<br>");
			out.print("���� ID : "+session.getId());
		}else {
			out.print("<script>alert('�α��ο� �����߽��ϴ�.'); history.go(-1);</script>");
		}
		out.print("<p><a href='SessionLoginCheck'> �α��� üũ�غ���</a></p>");
		out.close();
	}

}

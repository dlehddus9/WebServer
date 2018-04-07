package product.session.exam;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/SelProduct")
public class SelProduct extends HttpServlet {

	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		req.setCharacterEncoding("utf-8");
		
		HttpSession session = req.getSession();
		String sessionUserName = (String)session.getAttribute("username");
		String reqUserName = req.getParameter("username");
		if(session.isNew())
			session.setAttribute("username", reqUserName);
		else
			session.setAttribute("username", sessionUserName);
		
		resp.setContentType("text/html;charset=utf-8");
		PrintWriter out = resp.getWriter();
		
		out.print("<body><center><h2>��ǰ ����</h2><hr>");
		out.print(session.getAttribute("username") + "���� �α����� �����Դϴ�.");
		out.print("<a href='ProductLogout'>�α׾ƿ�</a>");
		out.print("<hr><form action='AddProduct' method='post'>");
		out.print("<select name='product'><option>���</option><option>��</option>");
		out.print("<option>���ξ���</option><option>�ڸ�</option><option>����</option></select>");
		out.print("<input type='submit' value='�߰�'></form>");
		out.print("<a href='ProductCheckOut'> ���</a>");
		out.close();
	}

	
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		doPost(req, resp);
	}

}

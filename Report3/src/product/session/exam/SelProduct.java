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
		
		out.print("<body><center><h2>상품 선택</h2><hr>");
		out.print(session.getAttribute("username") + "님이 로그인한 상태입니다.");
		out.print("<a href='ProductLogout'>로그아웃</a>");
		out.print("<hr><form action='AddProduct' method='post'>");
		out.print("<select name='product'><option>사과</option><option>귤</option>");
		out.print("<option>파인애플</option><option>자몽</option><option>레몬</option></select>");
		out.print("<input type='submit' value='추가'></form>");
		out.print("<a href='ProductCheckOut'> 계산</a>");
		out.close();
	}

	
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		doPost(req, resp);
	}

}

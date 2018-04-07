package product.session.exam;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/ProductLogin")
public class ProductLogin extends HttpServlet {
	

	
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	resp.setContentType("text/html;charset=utf-8");
	PrintWriter out = resp.getWriter();
	
	out.print("<center><h2>로그인</h2>");
	out.print("<form action='SelProduct' method='post'>");
	out.print("<input type='text' name='username'>");
	out.print("<input type='submit' value='로그인'></form></center>");
	out.close();
	}

}

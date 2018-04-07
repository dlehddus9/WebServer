package product.session.exam;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class ProductCheckOut
 */
@WebServlet("/ProductCheckOut")
public class ProductCheckOut extends HttpServlet {
	
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = req.getSession(false);
		
		resp.setContentType("text/html;charset=utf-8");
		PrintWriter out = resp.getWriter();
		
		ArrayList<String> list = (ArrayList)session.getAttribute("productList");
		if(list==null) {
			out.print("<center>선택한 상품이 없습니다!!");
		}
		else {
			for(String productName : list) {
				out.print(productName + "<br>");
			}
		}
		session.removeAttribute("productList");
		out.print("<a href='SelProduct'>쇼핑계속하기</a></center>");
		out.close();
		}

}

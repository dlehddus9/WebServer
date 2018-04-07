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
 * Servlet implementation class AddProduct
 */
@WebServlet("/AddProduct")
public class AddProduct extends HttpServlet {
	

	
	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		req.setCharacterEncoding("utf-8");
		resp.setContentType("text/html;charset=utf-8");
		PrintWriter out = resp.getWriter();
		
		HttpSession session = req.getSession();
		String productName = req.getParameter("product");
		ArrayList<String> list = (ArrayList)session.getAttribute("productList");
		
		if(list ==null) {
			list = new ArrayList<String>();
		}
		list.add(productName);
		session.setAttribute("productList", list);
		
		out.print("<script>alert('" + productName + "이(가) 추가되었스니다!!')");
		out.print("history.go(-1);</script>");
	}

}

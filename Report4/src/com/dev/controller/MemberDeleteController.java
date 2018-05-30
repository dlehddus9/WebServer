package com.dev.controller;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

import com.dev.service.MemberService;

public class MemberDeleteController implements Controller {
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		///parameter 추출
		String id = request.getParameter("id");
		
		//service 객체의 메서드 호출
		MemberService service = MemberService.getInstance();
		service.memberDelete(id);
		
		//output view 페이지로 이동
		HttpUtil.forward(request, response, "/result/memberDeleteOutput.jsp");
	}

}

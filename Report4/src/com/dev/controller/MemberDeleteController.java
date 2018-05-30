package com.dev.controller;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

import com.dev.service.MemberService;

public class MemberDeleteController implements Controller {
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		///parameter ����
		String id = request.getParameter("id");
		
		//service ��ü�� �޼��� ȣ��
		MemberService service = MemberService.getInstance();
		service.memberDelete(id);
		
		//output view �������� �̵�
		HttpUtil.forward(request, response, "/result/memberDeleteOutput.jsp");
	}

}

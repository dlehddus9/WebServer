<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ page import="java.sql.*" %>

<% request.setCharacterEncoding("utf-8"); %>

<%
	String id = request.getParameter("id");
	String passwd = request.getParameter("passwd");
	String name = request.getParameter("name");
	Timestamp register = new Timestamp(System.currentTimeMillis());
	
	Connection conn=null;
	PreparedStatement pstmt=null;
	String str="";
	
	try{
		String jdbcUrl = "jdbc:oracle:thin:@localhost:1521:xe";
		String dbId="scott";
		String dbPass="tiger";
		
		Class.forName("oracle.jdbc.driver.OracleDriver");
		conn=DriverManager.getConnection(jdbcUrl,dbId,dbPass);
		
		String sql = "insert into members values (?,?,?,?)";
		pstmt = conn.prepareStatement(sql);
		pstmt.setString(1,id);
		pstmt.setString(2,passwd);
		pstmt.setString(3,name);
		pstmt.setTimestamp(4,register);
		pstmt.executeUpdate();
		
		str= "member 테이블에 새로운 레코드를 추가 했습니다.";
	
	}catch(Exception e) {
		e.printStackTrace();
		str="member 테이블에 새로운 레코드를 추가에 실패했습니다.";
	}finally {
		if(pstmt !=null)
			try{pstmt.close();}catch(SQLException sqle){}
		if(conn !=null)
			try{conn.close();}catch(SQLException sqle){}
	}
	response.sendRedirect("MemberList.jsp");
%>


<html>
<head>
<title>레코드 추가</title>
</head>
<body>
	<%=str %>

</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ page import="java.sql.*"%>

<html>
<head>
<title>레코드 표시</title>
</head>
<body>
	<h2>member 테이블의 레코드 표시 </h2>
	<table border="1">
	<tr>
		<td width="100">아이디</td>
		<td width="100">패스워드</td>
		<td width="100">이름</td>
		<td width="250">가입일자</td>
	</tr>
<%
Connection conn=null;
PreparedStatement pstmt = null;
ResultSet rs =null;
String pid = request.getParameter("id");

try {
	String jdbcUrl ="jdbc:oracle:thin:@localhost:1521:xe";
	String dbId="scott";
	String dbPass="tiger";
	
	Class.forName("oracle.jdbc.driver.OracleDriver");
	conn=DriverManager.getConnection(jdbcUrl,dbId,dbPass);
	
	String sql = "select * from members where id=?";
	pstmt = conn.prepareStatement(sql);
	pstmt.setString(1,pid);
	rs=pstmt.executeQuery();
	
	if(rs.next()) {
		String id = rs.getString("id");
		String passwd = rs.getString("passwd");
		String name= rs.getString("name");
		Timestamp register = rs.getTimestamp("reg_date");
%>
		<tr>
			<td width="100"><%=id%></td>
			<td width="100"><%=passwd%></td>
			<td width="100"><%=name%></td>
			<td width="250"><%=register.toString()%></td>
		</tr>
<% }
}catch(Exception e) {
	e.printStackTrace();
}finally{
	if(rs !=null)
		try{rs.close();}catch(SQLException sqle){}
	if(pstmt !=null)
		try{pstmt.close();}catch(SQLException sqle){}
	if(conn !=null)
		try{conn.close();}catch(SQLException sqle){}
	}
%>

	</table>
	<br>
	<a href="MemberUpdateForm.jsp?id=<%=pid%>">레코드수정</a>
	<a href="MemberDeleteForm.jsp?id=<%=pid%>">레코드삭제</a>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.sql.*"%>
<html>
<head>
<title>레코드 삭제</title>
</head>
<body>
	<h2> member 테이블의 레코드 삭제 </h2>
	
<% 
	Connection conn=null;
	PreparedStatement pstmt=null;
	ResultSet rs =null;
	String pid = request.getParameter("id");
	
	try {
		Connection conn=null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String pid = request.getParameter("id");
		
		try{
			String jdbcUrl ="jdbc:oracle:thin:@localhost:1521:xe";
			String dbId="scott";
			String dbPass="tiger";
			
			Class.forName("oracle.jdbc.driver.OralceDriver");
			conn=DriverManager.getConnection(jdbcUrl, dbId,dbPass);
			
			String sql ="select * from members where id=?";
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1,pid);
			rs=pstmt.executeQuery();
			
			if(rs.next()) {
				String id = rs.getString("id");
	%>
			<form method="post" action="MemberDeletePro.jsp">
				아이디:<input type="text" name="id" value="<%=id %>" maxlength="50"> <br>
				패스워드 : <input type="password" name="passwd" maxlength="16"> <br>
				<input type="submit" value="입력 완료">
				
			</form>
		<%  
		}
			
			else {
				out.println("아이디가 틀립니다.");
				}
		}
		catch(Exception e)
				{
				e.printStackTrace();
				}
		finally{
			if(rs != null)
				try{rs.close();}catch(SQLException sqle){}
			if(pstmt !=null)
				try{pstmt.close();}catch(SQLException sqle){}
			if(conn != null)
				try{conn.close();}catch(SQLExcetpion sqle){}
		}
	%>

</body>
</html>
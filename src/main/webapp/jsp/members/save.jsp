<%@ page import="hello.servlet.domain.member.Member" %>
<%@ page import="hello.servlet.domain.member.MemberRepository" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    MemberRepository memberRepository = MemberRepository.getInstance();
    //request, response는 그냥 사용가능 ( jsp는 서블릿으로 변환되서 사용되기 때문 )
    String username = request.getParameter("username");
    int age = Integer.parseInt(request.getParameter("age"));
    Member member = new Member(username, age);

    memberRepository.save(member);
%>
<html>
<head>
    <title>Title</title>
</head>
<body>
    성공!
<ul>
    <li>id=<%=member.getId()%></li>
    <li>name=<%=member.getUsername()%></li>
    <li>age=<%=member.getAge()%></li>
</ul>
    <a href="index.html">메인</a>
</body>
</html>

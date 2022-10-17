<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: Admint
  Date: 17/10/2022
  Time: 10:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<form:form modelAttribute="MailBox" action="/mailbox/create" method="post">
    <table>
        <tr>
            languages :
                <form:select path="languages">
                    <form:option  value="Anh">Anh</form:option>
                    <form:option  value="Trung Quoc">Trung</form:option>
                    <form:option  value="Viet Nam">Viet</form:option>
                </form:select>
       </tr>
        <tr>
            <td>page</td>
            <td>
                <form:select path="page">
                    <form:option  value="10">10</form:option>
                    <form:option  value="20">20</form:option>
                    <form:option  value="30">30</form:option>
                    <form:option  value="40">40</form:option>
                    <form:option  value="50">50</form:option>
                    <form:option  value="60">60</form:option>
                </form:select>
            </td>
        </tr>
        <tr>
            <td>spams</td>
            <td>
                <form:radiobutton path="spams" value="1" label="True"></form:radiobutton>
                <form:radiobutton path="spams" value="0" label="Fsle"></form:radiobutton>
            </td>
        </tr>
        <tr>
            <td>
                signature
            </td>
            <td>
                <form:textarea path="signature"/>
            </td>
        </tr>
        <tr>
            <td colspan="2">
                <button type="submit">Create</button>
            </td>
        </tr>
    </table>
</form:form>
</body>
</html>

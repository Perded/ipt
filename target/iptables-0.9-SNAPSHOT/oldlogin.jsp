<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
<head>
    <title>Login</title>
</head>
<body>
<div style="text-align: center;">
    <s:if test="hasActionErrors()">
        <div>
            <s:actionerror/>
        </div>
    </s:if>
    <s:form action="login">
        <s:textfield name="userName" label="Логин"/>
        <s:textfield name="password" type="password" label="Пароль"/>
        <s:submit value="Вход" />
    </s:form>
</div>

</body>
</html>
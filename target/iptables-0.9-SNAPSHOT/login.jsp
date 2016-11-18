<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
<head>
    <link rel="stylesheet" type="text/css" href="CSS/style.css" media="all">
    <title>Авторизация пользователя</title>
</head>
<body>
<div class="login">
    <form method="post" action="login">
    <table align="center" cellspacing="0" cellpadding="0">
        <tr style="height:60px; background: #3F8FD2">
            <td style="font-weight: bold; color: white; font-size: 20px;">
                Авторизация
            </td>
        </tr>
        <tr>
            <td align="right" style="padding: 30px 25px 0px 25px;">
                Логин  <input style="padding-left: 5px; height: 25px; color:gray;" type="text" name="userName" label="Логин"/>
            </td>
        </tr>
        <tr>
            <td align="right" style="padding: 10px 25px 0px 25px;">
                Пароль <input style="padding-left: 5px; height: 25px;  color:gray;" name="password" type="password" label="Пароль"/>
            </td>
        </tr>
        <tr>
            <td align="right" style="padding: 10px 25px 30px 25px;">
                <input style="width: 90px; height: 30px;" type="submit" value="Вход" />
            </td>
        </tr>
    <tr>
        <td>
            <s:if test="hasActionErrors()">
                <div style="color:darkred;">
                    <s:actionerror/>
                </div>
            </s:if>
        </td>
    </tr>

    </table>
    </form>
</div>

</div>
</body>
</html>

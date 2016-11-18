<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<div class="edittable">
    <div class="title">Редактирование данных пользователя</div>
    <form method="get" action="saveuser">
        <input type="hidden" name="id" value="<s:property value="id"/> "/>
        <table align="center" cellpadding="0" cellspacing="0">
            <tr>
                <th colspan="2">
                    <input type="submit" value="Сохранить" onclick="checkPasswd(event); return false;"/>
                    <input type="button" value="Отмена" onclick="history.back()"/>
                    <div id="error" style="color: red"></div>
                </th>
            </tr>
            <tr class="even">
                <td>ФИО</td>
                <td>
                    <input style="height:30px" size="50" type="text" name="fio"
                           value="<s:property value="fio"/> "/>
                </td>
            </tr>
            <tr>
                <td>Должность</td>
                <td>
                    <input id="position" style="height:30px" size="50" type="text" name="position"
                           value="<s:property value="position"/>"/>
                </td>
            </tr>
            <tr class="even">
                <td>Подразделение</td>
                <td>
                    <input id="department" style="height:30px" size="50" type="text" name="department"
                           value="<s:property value="department"/>"/>
                </td>
            </tr>
            <tr>
                <td>Логин</td>
                <td>
                    <input style="height:30px" size="20" type="text" name="userName"
                           value="<s:property value="userName"/>"/>
                </td>
            </tr>
            <tr class="even">
                <td>Пароль</td>
                <td>
                    <input id="passwd" style="height:30px" size="20" type="password" name="password"
                           value="<s:property value="password"/>"/>
                </td>
            </tr>
            <tr>
                <td>Повторить пароль</td>
                <td>
                    <input id="confrm" style="height:30px" size="20" type="password" name="confirm"
                           value="<s:property value="password"/>"/>
                </td>
            </tr>
            <tr>
                <th colspan="2">
                    <input type="submit" value="Сохранить"/>
                    <input type="button" value="Отмена" onclick="history.back()"/>
                </th>
            </tr>
        </table>
    </form>
</div>

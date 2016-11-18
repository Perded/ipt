<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<div class="edittable">
    <div class="title">Новый пользователь</div>
    <form method="get" action="savenewuser">
        <table align="center" cellpadding="0" cellspacing="0">
            <tr>
                <th colspan="2">
                    <input type="submit" value="Сохранить"/>
                    <input type="button" value="Отмена" onclick="history.back()"/>
                </th>
            </tr>
            <tr class="even">
                <td>ФИО</td>
                <td>
                    <input style="height:30px" size="50" type="text" name="fio"
                           value=""/>
                </td>
            </tr>
            <tr>
                <td>Должность</td>
                <td>
                    <input style="height:30px" size="50" type="text" name="position"
                           value=""/>
                </td>
            </tr>
            <tr class="even">
                <td>Подразделение</td>
                <td>
                    <input style="height:30px" size="50" type="text" name="department"
                           value=""/>
                </td>
            </tr>
            <tr>
                <td>Логин</td>
                <td>
                    <input style="height:30px" size="20" type="text" name="userName"
                           value=""/>
                </td>
            </tr>
            <tr class="even">
                <td>Пароль</td>
                <td>
                    <input style="height:30px" size="20" type="password" name="password"
                           value=""/>
                </td>
            </tr>
            <tr>
                <td>Повторить пароль</td>
                <td>
                    <input style="height:30px" size="20" type="password" name="confirm"
                           value=""/>
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

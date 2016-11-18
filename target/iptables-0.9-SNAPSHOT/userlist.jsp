<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<div class="viewtable">
    <div class="title">Управление учетными записями пользователей</div>
    <form action="newuser">
        <table align="center" cellspacing="0" cellpadding="0">
            <tr>
                <th  colspan="4">
                    <input type="button" value="Назад" onclick="location.href='index'"/>
                    <input type="submit" value="Добавить" title="Добавить пользователя"/>
                </th>
            </tr>
            <tr style="height:40px; font-weight: bold; color: white; background: #3F8FD2" >
                <td width="30px" align="center"><b>№</b></td>
                <td width="170px" align="center"><b>Функции</b></td>
                <td width="120px" align="center"><b>Логин</b></td>
                <td width="550px" align="center"><b>ФИО</b></td>
                <td width="550px" align="center"><b>Должность</b></td>
                <td width="550px" align="center"><b>Подразделение</b></td>
            </tr>
            <s:iterator value="allUsers" status="rowstatus">
            <tr class="<s:if test="#rowstatus.odd == true ">odd</s:if><s:else>even</s:else>">
                <td class="even"><s:property value="#rowstatus.count"/></td>
                <td align="center">
                    <a href="edituser?id=<s:property value="id"/>" title="Редактировать профиль"><img height="33" width="33" src="images/edit.png"/></a>
                    <a href="permitions?id=<s:property value="id"/>" title="Полномочия пользователя"><img height="33" width="33" src="images/permit.png"/></a>
                    <a href="removeuser?id=<s:property value="id"/>" title="Удалить пользователя" onclick="return confirm('Удалить этого пользователя?')"><img height="33" width="33"src="images/delete.png"/></a>
                </td>
                <td>
                    <s:property value="userName"/>
                </td>
                <td>
                    <s:property value="fio"/>
                </td>
                <td>
                    <s:property value="position"/>
                </td>
                <td>
                    <s:property value="department"/>
                </td>
            </tr>
            </s:iterator>
            <tr>
                <th  colspan="4">
                    <input type="button" value="Назад" onclick="location.href='index'"/>
                    <input type="submit" value="Добавить" />
                </th>
            </tr>
        </table>
    </form>
</div>


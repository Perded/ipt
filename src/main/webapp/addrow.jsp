<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<div class="edittable">
    <div class="title">Новая запись</div>
    <form method="get" action="addrow">
        <input type="hidden" name="tableId" value="<s:property value="tableId"/>"/>
        <table align="center" cellpadding="0" cellspacing="0">
            <tr>
                <th colspan="2">
                    <input type="submit" value="Сохранить"/>
                    <input type="button" value="Отмена" onclick="history.back()"/>
                </th>
            </tr>
            <tr class="even">
                <td>Станция</td>
                <td>
                    <input style="height:30px" size="50" type="text" name="station"/>
                </td>
            </tr>
            <tr>
                <td>Дислокация</td>
                <td>
                    <input style="height:30px" size="50" type="text" name="place"/>
                </td>
            </tr>
            <tr class="even">
                <td>Номер в коммутац. панели</td>
                <td>
                    <input style="height:30px" size="50" type="text" name="panel"/>
                </td>
            </tr>
            <tr>
                <td>Номер порта коммутатора</td>
                <td>
                    <input style="height:30px" size="50" type="text" name="port"/>
                </td>
            </tr>
            <tr class="even">
                <td>IP адрес</td>
                <td>
                    <input style="height:30px" size="50" type="text" name="ip"/>
                </td>
            </tr>
            <tr>
                <td>Имя компьютера</td>
                <td>
                    <input style="height:30px" size="50" type="text" name="cname"/>
                </td>
            </tr>
            <tr class="even">
                <td>Тип</td>
                <td>
                    <input style="height:30px" size="50" type="text" name="type"/>
                </td>
            </tr>
            <tr>
                <td>Отдел пользователя</td>
                <td>
                    <input style="height:30px" size="50" type="text" name="department"/>
                </td>
            </tr>
            <tr class="even">
                <td>ФИО пользователя</td>
                <td>
                    <input style="height:30px" size="50" type="text" name="fio"/>
                </td>
            </tr>
            <tr>
                <td>Должность пользователя</td>
                <td>
                    <input style="height:30px" size="50" type="text" name="position"/>
                </td>
            </tr>
            <tr class="even">
                <td>Телефон на рабочем месте</td>
                <td>
                    <input style="height:30px" size="50" type="text" name="phone"/>
                </td>
            </tr>
            <tr>
                <td>Login в домене</td>
                <td>
                    <input style="height:30px" size="50" type="text" name="login1"/>
                </td>
            </tr>
            <tr class="even">
                <td>Login интернет</td>
                <td>
                    <input style="height:30px" size="50" type="text" name="login2"/>
                </td>
            </tr>
            <tr>
                <td>Login почта интернет</td>
                <td>
                    <input style="height:30px" size="50" type="text" name="login3"/>
                </td>
            </tr>
            <tr class="even">
                <td>Примечание1</td>
                <td>
                    <input style="height:30px" size="50" type="text" name="description"/>
                </td>
            </tr>
            <tr>
                <td>Примечание2</td>
                <td>
                    <input style="height:30px" size="50" type="text" name="description1"/>
                </td>
            </tr>
            <tr class="even">
                <td>Примечание3</td>
                <td>
                    <input style="height:30px" size="50" type="text" name="description2"/>
                </td>
            </tr>
            <tr>
                <td>Примечание4</td>
                <td>
                    <input style="height:30px" size="50" type="text" name="description3"/>
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

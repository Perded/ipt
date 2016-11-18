<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<div class="edittable">
    <div class="title">Редактирование данных</div>
    <form method="get" action="save">
        <input type="hidden" name="tableId" value="<s:property value="tableId"/> "/>
        <input type="hidden" name="rowId" value="<s:property value="rowId"/> "/>
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
                        <input style="height:30px" size="50" type="text" name="station"
                               value="<s:property value="row[11]"/>"/>
                    </td>
                </tr>
            <tr>
                <td>Дислокация</td>
                <td>
                    <input style="height:30px" size="50" type="text" name="place"
                           value="<s:property value="row[12]"/>"/>
                </td>
            </tr>
            <tr class="even">
                <td>Номер в коммутац. панели</td>
                <td>
                    <input style="height:30px" size="50" type="text" name="panel"
                           value="<s:property value="row[0]"/>"/>
                </td>
            </tr>
            <tr>
                <td>Номер порта коммутатора</td>
                <td>
                    <input style="height:30px" size="50" type="text" name="port"
                           value="<s:property value="row[1]"/>"/>
                </td>
            </tr>
            <tr class="even">
                <td>IP адрес</td>
                <td>
                    <input style="height:30px" size="50" type="text" name="ip"
                           value="<s:property value="row[2]"/>"/>
                </td>
            </tr>
            <tr>
                <td>Имя компьютера</td>
                <td>
                    <input style="height:30px" size="50" type="text" name="cname"
                           value="<s:property value="row[3]"/>"/>
                </td>
            </tr>
            <tr class="even">
                <td>Тип</td>
                <td>
                    <input style="height:30px" size="50" type="text" name="type"
                           value="<s:property value="row[16]"/>"/>
                </td>
            </tr>
            <tr>
                <td>Отдел пользователя</td>
                <td>
                    <input style="height:30px" size="50" type="text" name="department"
                           value="<s:property value="row[4]"/>"/>
                </td>
            </tr>
            <tr class="even">
                <td>ФИО пользователя</td>
                <td>
                    <input style="height:30px" size="50" type="text" name="fio"
                           value="<s:property value="row[5]"/>"/>
                </td>
            </tr>
            <tr>
                <td>Должность пользователя</td>
                <td>
                    <input style="height:30px" size="50" type="text" name="position"
                           value="<s:property value="row[6]"/>"/>
                </td>
            </tr>
            <tr class="even">
                <td>Телефон на рабочем месте</td>
                <td>
                    <input style="height:30px" size="50" type="text" name="phone"
                           value="<s:property value="row[7]"/>"/>
                </td>
            </tr>
            <tr>
                <td>Login в домене</td>
                <td>
                    <input style="height:30px" size="50" type="text" name="login1"
                           value="<s:property value="row[13]"/>"/>
                </td>
            </tr>
            <tr class="even">
                <td>Login интернет</td>
                <td>
                    <input style="height:30px" size="50" type="text" name="login2"
                           value="<s:property value="row[14]"/>"/>
                </td>
            </tr>
            <tr>
                <td>Login почта интернет</td>
                <td>
                    <input style="height:30px" size="50" type="text" name="login3"
                           value="<s:property value="row[15]"/>"/>
                </td>
            </tr>
            <tr class="even">
                <td>Примечание1</td>
                <td>
                    <input style="height:30px" size="50" type="text" name="description"
                           value="<s:property value="row[8]"/>"/>
                </td>
            </tr>
            <tr>
                <td>Примечание2</td>
                <td>
                    <input style="height:30px" size="50" type="text" name="description1"
                           value="<s:property value="row[10]"/>"/>
                </td>
            </tr>
            <tr class="even">
                <td>Примечание3</td>
                <td>
                    <input style="height:30px" size="50" type="text" name="description2"
                           value="<s:property value="row[17]"/>"/>
                </td>
            </tr>
            <tr>
                <td>Примечание4</td>
                <td>
                    <input style="height:30px" size="50" type="text" name="description3"
                           value="<s:property value="row[18]"/>"/>
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

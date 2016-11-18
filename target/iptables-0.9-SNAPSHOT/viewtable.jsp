<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>

<div class="viewtable">
    <div class="title"> Просмотр таблицы</div>
    <form action="newrow">
        <input type="hidden" name="tableId" value="<s:property value="id"/>"/>
        <table align="center" cellspacing="0" cellpadding="0">
            <tr>
                <th  colspan="7">
                        <input type="button" value="Назад" onclick="location.href='index'"/>
                        <input type="submit" value="Добавить" />
                        <input type="button" value="Скрыть/Показать" onclick="hide()" LANGUAGE="JAVASCRIPT" />
                </th>
            </tr>
            <tr style="height:40px; font-weight: bold; color: white; background: #3F8FD2">
                <td align="center">№ </td>
                <td width="150px" align="center">Функции</td>
                <td style="display: none" align="center">Станция</td>
                <td style="display: none" align="center">Дислокация</td>
                <td style="display: none" align="center">№ в панели</td>
                <td style="display: none" align="center">№ порта</td>
                <td align="center">IP-адрес</td>
                <td align="center">Имя компьютера</td>
                <td style="display: none" align="center">Тип</td>
                <td align="center">Отдел пользователя</td>
                <td width="200px" align="center">ФИО</td>
                <td align="center">Должность</td>
                <td align="center">Телефон</td>
                <td align="center">Login в домене</td>
                <td style="display: none" align="center">Login интернет</td>
                <td style="display: none" align="center">Login почта интернет</td>
                <td align="center">Примечание1</td>
                <td style="display: none" align="center">Примечание2</td>
                <td style="display: none" align="center">Примечание3</td>
                <td style="display: none" align="center">Примечание4</td>
            </tr>
    <s:iterator value="rows" status="rowstatus">
            <tr class="<s:if test="#rowstatus.odd == true ">odd</s:if><s:else>even</s:else>">
                <td class="even"><s:property value="#rowstatus.count"/></td>
                <td align="center">
                    <div style="width:150px;">
                    <a href="edit?rowId=<s:property value="rowId"/>&tableId=<s:property value="id"/>"><img height="33" width="33" src="images/edit.png"/></a>
                    <a href="delete?rowId=<s:property value="rowId"/>&tableId=<s:property value="id"/>" onclick="return confirm('Удалить эту запись?')"><img height="33" width="33" src="images/delete.png"/></a>
                    </div>
                </td>
                <td style="display: none">
                    <s:property value="station"/>
                </td>
                <td style="display: none">
                    <s:property value="place"/>
                </td>
                <td style="display: none">
                    <s:property value="panel"/>
                </td>
                <td style="display: none">
                    <s:property value="port"/>
                </td>
                <td>
                    <s:property value="ip"/>
                </td>
                <td>
                    <s:property value="cname"/>
                </td>
                <td style="display: none" >
                    <s:property value="type"/>
                </td>
                <td>
                    <s:property value="department"/>
                </td>
                <td>
                    <s:property value="fio"/>
                </td>
                <td>
                    <s:property value="position"/>
                </td>
                <td>
                    <s:property value="phone"/>
                </td>
                <td>
                    <s:property value="login1"/>
                </td>
                <td style="display: none">
                    <s:property value="login2"/>
                </td>
                <td style="display: none">
                    <s:property value="login3"/>
                </td>
                <td>
                    <s:property value="description"/>
                </td>
                <td style="display: none">
                    <s:property value="description1"/>
                </td>
                <td style="display: none">
                    <s:property value="description2"/>
                </td>
                <td style="display: none">
                    <s:property value="description3"/>
                </td>
            </tr>
    </s:iterator>
            <tr >
                <th colspan="4">
                    <input type="button" value="Назад" onclick="location.href='index'"/>
                    <input type="submit" value="Добавить" />
                </th>
            </tr>
        </table>
    </form>
</div>

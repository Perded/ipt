<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<form method="get" action="search">
    <div class="viewtable">
        <div class="title">Поиск совпадений</div>
        <table style="width: 500px" align="center" cellspacing="0" cellpadding="0">
            <tr>
                <td align="center" style="padding: 25px">
                    <input style="height:33px;" width="100px"  type="text" name="searchContent"/>
                    <input type="submit" value="Найти"/>
                </td>
            </tr>
        </table>
    </div>
    <div class="viewtable">
        <table align="center" cellspacing="0" cellpadding="0">
            <tr style="height:40px; font-weight: bold; color: white; background: #3F8FD2">
                <td align="center">№ </td>
                <td align="center">Таблица</td>
                <td align="center">Станция</td>
                <td align="center">Дислокация</td>
                <td align="center">IP-адрес</td>
                <td align="center">Имя компьютера</td>
                <td align="center">ФИО</td>
                <td align="center">Должность</td>
                <td align="center">Телефон</td>
            </tr>
            <s:iterator value="results" status="rowstatus">
                <tr class="<s:if test="#rowstatus.odd == true ">odd</s:if><s:else>even</s:else>">
                    <td class="even"><s:property value="#rowstatus.count"/></td>
                    <td align="center">
                        <a href="view?id=<s:property value="tableId"/>"><img height="33" width="33" src="images/view.png"/></a>
                    </td>
                    <td>
                        <s:property value="station"/>
                    </td>
                    <td>
                        <s:property value="place"/>
                    </td>
                    <td>
                        <s:property value="ip"/>
                    </td>
                    <td>
                        <s:property value="cname"/>
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
                </tr>
            </s:iterator>
            <div>
                <s:property value="noFind"/>
            </div>
        </table>

    </div>
</form>

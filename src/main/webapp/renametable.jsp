<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<div class="edittable">
    <div class="title">Новое имя таблицы</div>
    <form method="get" action="savetablename">
        <input type="hidden" name="tableId" value="<s:property value="tableId"/>"/>
        <table align="center" cellpadding="0" cellspacing="0">
            <tr>
                <td align="center"><b>Имя таблицы</b><br/>
                    <input style="height:30px" size="50" type="text" name="name" value="<s:property value="name"/>"/>
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

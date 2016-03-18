<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
<head>
    <title>Редактирование</title>
</head>
<body>
        <div id="edittable">
            <div class="title">Редактирование данных</div>
            <form method="get" action="save">
                <input type="hidden" name="id" value="1"/>
            <table align="center" cellpadding="0" cellspacing="0">
                <tr>
                    <th colspan="2">
                        <input type="submit" value="Сохранить"/>
                        <input type="button" value="Отмена" onclick="history.back()"/>
                    </th>
                </tr>
            <% int i=1; %>
            <s:iterator value="allCells">
                <% if (i % 2 != 0) {%>
                    <tr class="even">
                <%} else {%>
                    <tr>
                <%}%>
                        <td width="100px">-</td>
                        <td>
                            <input style="height:30px" size="50" type="text" name="field<%=i%>"
                                value="<s:property/>"/>
                        </td>
                    </tr>
                <%++i;%>
            </s:iterator>
                <tr>
                    <th colspan="2">
                        <input type="submit" value="Сохранить"/>
                        <input type="button" value="Отмена" onclick="history.back()"/>
                    </th>
                </tr>
            </table>
        </form>
</div>
</body>
</html>

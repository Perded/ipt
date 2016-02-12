<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<table cellSpacing=0 cellPadding=0 width="100%" border="2">
    <tr>
        <td align="center" width="30px"> № </td>
        <td align="center">Наименование таблицы</td>
        <td align="center" width="100px">Функции</td>
    </tr>
    <s:iterator begin="1" end="3">
    <tr>
        <td>wer</td>
        <td>werwerw</td>
        <td width="100px">
            <a href="/index.jsp">Edit</a>
            <a href="/index.jsp">neEdin</a>
            <a href="/index.jsp">uEdin</a>
            <a href="/index.jsp">deledin</a>
        </td>
    </tr>
    </s:iterator>
</table>

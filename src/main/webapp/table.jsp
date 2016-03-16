<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>

<div id="viewtable">
    <div class="title"> <s:property value="name"/></div>
<table align="center" cellspacing="0" cellpadding="0">
    <tr>
        <th colspan="2">
            <input type="button" value="Назад" onclick="history.back()"/>
        </th>
    </tr>
    <% int i=1; %>
    <s:iterator value="lstTable">
    <% if (i % 2 != 0) {%>
    <tr class="even">
        <%} else {%>
        <tr>
        <%}%>
        <td><a href="/edit?id=<%=i%>&tableId=<s:property value="idTable"/>">Edit</a></td>
        <% int j=1; %>
        <s:iterator value="row">
            <% if (j % 2 != 0) {%>
            <td class="even">
                        <%} else {%>
            <td>
            <%}%>
            <s:property/></td>
            <%++j;%>
        </s:iterator>
    </tr>
        <%++i;%>
</s:iterator>
    <tr>
        <th colspan="2">
            <input type="button" value="Назад" onclick="history.back()"/>
        </th>
    </tr>
</table>
</div>
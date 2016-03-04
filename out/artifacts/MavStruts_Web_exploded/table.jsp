<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<b><s:property value="name"/></b>
<table align="center" cellSpacing=5 cellPadding=0 width="95%" border="3">
    <% int i=1; %>
    <s:iterator value="lstTable">
    <tr>
        <td><a href="/edit?id=<%=i%>">Edit</a></td>
        <s:iterator value="row">
            <td><s:property/></td>
        </s:iterator>
    </tr>
        <%++i;%>
</s:iterator>
</table>

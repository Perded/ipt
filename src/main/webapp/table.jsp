<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<table align="center" cellSpacing=5 cellPadding=0  border="3">
    <s:iterator value="lstTable">
    <tr>
        <s:iterator value="row">
        <td><s:property/></td>
        </s:iterator>
    </tr>
</s:iterator>
</table>

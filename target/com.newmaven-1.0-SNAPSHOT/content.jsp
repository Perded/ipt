<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<table align="center" cellSpacing=0 cellPadding=0 width="700px" border="3">
    <tr>
        <td width="30px"> № </td>
        <td>Наименование таблицы</td>
        <td width="100px">Функция</td>
    </tr>
    <s:iterator value="tables">
        <tr>
            <td align="center">
                <s:property value="id"/>
            </td>
            <td align="left">
              <a href="/view?idTable=<s:property value="id"/>&name=<s:property value="name"/>"><s:property value="name"/></a>
            </td>
            <td align="left">
                dfgsdfsefsdf
            </td>
        </tr>
    </s:iterator>
</table>

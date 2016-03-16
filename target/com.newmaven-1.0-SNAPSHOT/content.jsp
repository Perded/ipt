<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<div class="main">
<table cellspacing="0">
    <tr>
            <td width="30px" align="center"><b>№</b></td>
            <td width="550px" align="left"><b>Наименование таблицы</b></td>
            <td width="120px" align="center"><b>Функция</b></td>
    </tr>
    <s:iterator value="tables">
        <tr>
            <td align="center" nowrap>
                <s:property value="id"/>
            </td>
            <td align="left" nowrap>
              <a href="/view?idTable=<s:property value="id"/>&name=<s:property value="name"/>"><s:property value="name"/></a>
            </td>
            <td align="center" nowrap>
                <a href=""><img src="images/view.png"/></a>
                <a href=""><img src="images/config.png"/></a>
                <a href=""><img src="images/delete.png"/></a>
            </td>
        </tr>
    </s:iterator>
</table>
</div>
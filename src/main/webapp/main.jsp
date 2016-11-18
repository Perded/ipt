<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<div class="viewtable">
    <s:if test="hasActionErrors()">
        <div>
            <s:actionerror/>
        </div>
    </s:if>
    <div class="title">Список таблиц</div>
    <form action="newtable">
    <table align="center" cellspacing="0" cellpadding="0">
        <tr >
            <th colspan="2">
                <input type="submit" value="Добавить" />
            </th>
        </tr>
        <tr style="height:40px; font-weight: bold; color: white; background: #3F8FD2" >
            <td width="30px" align="center"><b>№</b></td>
            <td width="120px" align="center"><b>Функции</b></td>
            <td width="550px" align="left"><b>Наименование таблицы</b></td>
        </tr>
        <s:iterator value="tables" status="rowstatus">
            <tr class="<s:if test="#rowstatus.odd == true ">odd</s:if><s:else>even</s:else>">
                <td class="even"><s:property value="#rowstatus.count"/></td>
                <td align="center">
                    <a href="view?id=<s:property value="id"/>"><img height="33" width="33" src="images/view.png"/></a>
                    <a href="renametable?tableId=<s:property value="id"/>&name=<s:property value="name"/>"><img height="33" width="33" src="images/edit.png"/></a>
                    <a href="export?id=<s:property value="id"/>"><img height="33" width="33" src="images/xls.png"/></a>
                    <a href="deletetable?tableId=<s:property value="id"/>&userId=<s:property value="userId"/>" onclick="return confirm('Вы действительно хотите удалить таблицу?')"><img height="33" width="33" src="images/delete.png"/></a>
                </td>
                <td align="left"><a href="view?id=<s:property value="id"/>"><s:property value="name"/></a>
            </td>
            </tr>
        </s:iterator>
        <tr>
            <th  colspan="2">
                <input type="submit" value="Добавить" />
            </th>
        </tr>
    </table>
    </form>
</div>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<div class="edittable">
    <div class="title">Изменение полномочий пользователя</div>
    <form method="post" action="savePermitions">
        <input type="hidden" name="id" value="<s:property value="id"/>"/>
        <table align="center" cellpadding="0" cellspacing="0">
            <tr>
                <th colspan="2">
                    <input type="submit" value="Сохранить"/>
                    <input type="button" value="Отмена" onclick="history.back()"/>
                </th>
            </tr>
            <tr>
                <td style="border: solid 0px lightgray; text-align: center">
                    <b>Глобальные разрешения</b>
                    <table style="border: solid 1px lightgray;" align="center" cellpadding="0" cellspacing="0">
                        <tr style="font-weight: bold">
                            <td>Функция</td>
                            <td align="center">
                                Разрешить
                            </td>
                        </tr>
                        <tr class="even">
                            <td>Просмотр таблиц</td>
                            <td align="center">
                                <input type="checkbox" name="viewTable"
                                        <s:if test="%{mainPermitions.viewTable == true}">
                                            checked
                                        </s:if>
                                />
                            </td>
                        </tr>
                        <tr>
                            <td>Редактирование таблиц</td>
                            <td align="center">
                                <input type="checkbox" name="editTable"
                                        <s:if test="%{mainPermitions.editTable == true}">
                                            checked
                                        </s:if>
                                />
                            </td>
                        </tr>
                        <tr class="even">
                            <td>Добавление таблиц</td>
                            <td align="center">
                                <input type="checkbox" name="addTable"
                                        <s:if test="%{mainPermitions.addTable == true}">
                                            checked
                                        </s:if>
                                />
                            </td>
                        </tr>
                        <tr>
                            <td>Удаление таблиц</td>
                            <td align="center">
                                <input type="checkbox" name="removeTable"
                                        <s:if test="%{mainPermitions.removeTable == true}">
                                            checked
                                        </s:if>
                                />
                            </td>
                        </tr>
                        <tr class="even">
                            <td>Управление пользователями</td>
                            <td align="center">
                                <input type="checkbox" name="editUsers"
                                        <s:if test="%{mainPermitions.runsUsers == true}">
                                            checked
                                        </s:if>
                                />
                            </td>
                        </tr>

                    </table>
                <br/>
                    <b>Разрешения на таблицы</b>
                    <table style="border: solid 1px lightgray;" align="center" cellpadding="0" cellspacing="0">
                        <tr style="font-weight: bold">
                            <td>
                                Имя таблицы
                            </td>
                            <td align="center">
                                Deny
                            </td>
                            <td align="center">
                                Read
                            </td>
                            <td align="center">
                                Write
                            </td>
                            <td align="center">
                                Full
                            </td>
                        </tr>
                        <s:iterator  value="tablesWithPermitions" status="rowstatus">
                            <tr class="<s:if test="#rowstatus.odd == true ">odd</s:if><s:else>even</s:else>">
                            <td><s:property value="key.name"/></td>
                            <td align="center">
                                <input type="radio" name="p<s:property value="key.id"/>" value="0"
                                        <s:if test="%{value == 0}">
                                            checked
                                        </s:if>
                                />
                            </td>
                            <td align="center">
                                <input type="radio" name="p<s:property value="key.id"/>" value="1"
                                        <s:if test="%{value == 1}">
                                            checked
                                        </s:if>
                                />
                            </td>
                            <td align="center">
                                <input type="radio" name="p<s:property value="key.id"/>" value="2"
                                        <s:if test="%{value == 2}">
                                            checked
                                        </s:if>
                                />
                            </td>
                            <td align="center">
                                <input type="radio" name="p<s:property value="key.id"/>" value="3"
                                        <s:if test="%{value == 3}">
                                            checked
                                        </s:if>
                                />
                            </td>
                        </tr>
                        </s:iterator>
                    </table>
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

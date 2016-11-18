<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<div class="edittable">
    <div class="title">Добавить таблицу</div>
    <form method="POST" enctype="multipart/form-data" action="savenewtable">
        <table align="center" cellpadding="0" cellspacing="0">
            <tr>
                <td>Имя таблицы<br/>
                    <input style="height:30px" size="50" type="text" name="name"/>
                </td>
            </tr>
            <tr>
                <td>Для загрузки выберите файл Excel(<a style="color: #043C6B" href="example.xls">example.xls</a>)<br/>
                    <input style="height:30px" size="50" type="file" name="fileUpload" value="Обзор"/>
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

<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    // redirect to view table
    response.sendRedirect("view?id=" + request.getParameter("tableId"));
%>

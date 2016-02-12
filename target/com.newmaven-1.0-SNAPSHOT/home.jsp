<%@ page contentType="text/html; charset=UTF-8" %>
<%@taglib uri="http://struts.apache.org/tags-tiles" prefix="tiles" %>
<jsp:include page="/loginCheck.jsp" />


<tiles:insert page="template1.jsp" flush="true">
    <tiles:put name="title" value="Главная" />
    <tiles:put name="header" value="header.jsp" />
    <tiles:put name="menu" value="menu.jsp" />
    <tiles:put name="content" value="content.jsp" />
    <tiles:put name="footer" value="footer.jsp" />
</tiles:insert>



<%@ page contentType="text/html; charset=UTF-8" %>
<%@taglib uri="http://struts.apache.org/tags-tiles" prefix="tiles" %>
<jsp:include page="loginCheck.jsp" />


<tiles:insert page="template.jsp" flush="true">
    <tiles:put name="title" value="Новый пользователь" />
    <tiles:put name="header" value="header.jsp" />
    <tiles:put name="content" value="newuser.jsp" />
    <tiles:put name="footer" value="footer.jsp" />
</tiles:insert>



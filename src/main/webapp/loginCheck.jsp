<%@ taglib prefix="ww" uri="/struts-tags" %>
<ww:if test="#session.login != 'true'">
    <jsp:forward page="/login.jsp" />
</ww:if>


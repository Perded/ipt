<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<s:if test="hasActionErrors()">
    <div>
        <s:actionerror/>
    </div>
</s:if>
<script type="text/javascript">
    function func() {
       // window.location.href = "/index.jsp"
        history.back();
    }
    setTimeout(func, 2000);
</script>

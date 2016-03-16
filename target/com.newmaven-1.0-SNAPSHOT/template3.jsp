<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib uri="http://struts.apache.org/tags-tiles" prefix="tiles" %>
<jsp:include page="/loginCheck.jsp" />

<html>
<head>
    <link rel="stylesheet" type="text/css" href="CSS/style2.css" media="all">
    <title><tiles:getAsString name="title" ignore="true" /></title>
</head>
<body>


<div class="wrapper">
    <div class="header"><tiles:insert attribute="header"/></div>
    <div class="content"><tiles:insert attribute="content"/> </div>

    <div class="helpFooter"></div>
</div>
<div class="footer"><tiles:insert attribute="footer"/> </div>

</body>
</html>



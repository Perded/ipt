<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib uri="http://struts.apache.org/tags-tiles" prefix="tiles" %>
<jsp:include page="loginCheck.jsp" />

<html>
<head>
    <link rel="stylesheet" type="text/css" href="CSS/style.css" media="all"/>
    <!--[if gte IE 8]><![if !IE]><![endif]-->
    <script type="text/javascript" src="js/functions.js"></script>
    <!--[if gte IE 8]><![endif]><![endif]-->
    <!--[if lte IE 8]>
    <link href="CSS/style2.css" rel="stylesheet" type="text/css" />
    <script type="text/javascript" src="js/ie/functions.js"></script>
    <![endif]-->

    <title><tiles:getAsString name="title" ignore="true" /></title>
</head>
<body>


<div class="wrapper">
    <div class="header"><tiles:insert attribute="header"/></div>
    <div class="content">

        <tiles:insert attribute="content"/>
    </div>

    <div class="helpFooter"></div>
</div>
<div class="footer"><tiles:insert attribute="footer"/> </div>


</body>

</html>



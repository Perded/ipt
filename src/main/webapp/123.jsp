<%@ taglib prefix="s" uri="/struts-tags" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Title</title>
</head>
<body>
 <s:iterator value="parameters">
     <table>
         <tr>
             <td>
                 <s:property/>
             </td>
         </tr>
     </table>
 </s:iterator>
</body>
</html>

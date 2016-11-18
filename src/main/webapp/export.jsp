<%@ page import="java.io.OutputStream" %>
<%@ page import="org.apache.poi.hssf.usermodel.HSSFWorkbook" %>
<%@ page import="org.apache.poi.ss.usermodel.Sheet" %>
<%@ page import="org.apache.poi.ss.usermodel.Row" %>
<%@ page import="org.apache.poi.ss.usermodel.Cell" %>
<%@ page import="java.util.Map" %>
<%@ page import="com.opensymphony.xwork2.ActionContext" %>
<%@ page import="rzd.oao.zrw.rcs2.Controllers.DataAccess" %>
<%@ page import="rzd.oao.zrw.rcs2.Models.MainPermition" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Export</title>
</head>
<body>
 <%

     Map sess = ActionContext.getContext().getSession();
     System.out.println(sess.get("userid"));
     if (!sess.isEmpty()) {
         int userId = (Integer) sess.get("userid");
         String tableId = request.getParameter("id");
         System.out.println(tableId);
         int permition = DataAccess.getPermition(userId, Integer.parseInt(tableId));
         MainPermition mainPermition = DataAccess.getMainPermitions(userId);
         if (mainPermition.isEditTable() || mainPermition.isRemoveTable() || mainPermition.isViewTable() || permition > 0) {
             response.setContentType("application/vnd.ms-excel");
             response.setHeader("Content-Disposition", "attachment; filename=iptable.xls");
             HSSFWorkbook book = new HSSFWorkbook();
             Sheet sheet = book.createSheet();
             Row row = sheet.createRow(0);
             Cell cell = row.createCell(0);
             cell.setCellValue("Hellow");
             book.write(response.getOutputStream());
             book.close();
         }
     }

 %>
</body>
</html>

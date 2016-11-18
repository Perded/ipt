package rzd.oao.zrw.rcs2.Controllers;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import rzd.oao.zrw.rcs2.Models.ArmData;
import rzd.oao.zrw.rcs2.Models.MainPermition;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

/**
 * Created by KuzmichevVB on 15.06.2016.
 */
//@WebServlet(name = "/servlet")
public class ExportXLSServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        if (session.getAttribute("login") != null ) {
            int userId = (Integer) session.getAttribute("userid");
            String tableId = request.getParameter("id");
            System.out.println(tableId);
            int permition = DataAccess.getPermition(userId, Integer.parseInt(tableId));
            MainPermition mainPermition = DataAccess.getMainPermitions(userId);
            if (mainPermition.isEditTable() || mainPermition.isRemoveTable() || mainPermition.isViewTable() || permition > 0) {
                response.setContentType("application/vnd.ms-excel");
                response.setHeader("Content-Disposition", "attachment; filename=iptable.xls");
                HSSFWorkbook book = new HSSFWorkbook();
                Sheet sheet = book.createSheet();
                List<ArmData> arms = DataAccess.listIpTable(tableId);
//                    Row row = sheet.createRow(0);
//                    Cell cell = row.createCell(0);
//                    cell.setCellValue("Hellow");
                Row row = sheet.createRow(0);
                row.createCell(0).setCellValue("Станция");
                row.createCell(0).setCellValue("Станция");
                row.createCell(1).setCellValue("Дислокация");
                row.createCell(2).setCellValue("№ в панели");
                row.createCell(3).setCellValue("№ порта");
                row.createCell(4).setCellValue("IP-адрес");
                row.createCell(5).setCellValue("Имя компьютера");
                row.createCell(6).setCellValue("Тип");
                row.createCell(7).setCellValue("Отдел пользователя");
                row.createCell(8).setCellValue("ФИО");
                row.createCell(9).setCellValue("Должность");
                row.createCell(10).setCellValue("Телефон");
                row.createCell(11).setCellValue("Login в домене");
                row.createCell(12).setCellValue("Login интернет");
                row.createCell(13).setCellValue("Login почта интернет");
                row.createCell(14).setCellValue("Примечание1");
                row.createCell(15).setCellValue("Примечание2");
                row.createCell(16).setCellValue("Примечание3");
                row.createCell(17).setCellValue("Примечание4");
                int i = 1;
                Row rows;
                for (ArmData arm: arms) {
                rows = sheet.createRow(i);
                rows.createCell(0).setCellValue(arm.getStation());
                rows.createCell(1).setCellValue(arm.getPlace());
                rows.createCell(2).setCellValue(arm.getPanel());
                rows.createCell(3).setCellValue(arm.getPort());
                rows.createCell(4).setCellValue(arm.getIp());
                rows.createCell(5).setCellValue(arm.getCname());
                rows.createCell(6).setCellValue(arm.getType());
                rows.createCell(7).setCellValue(arm.getDepartment());
                rows.createCell(8).setCellValue(arm.getFio());
                rows.createCell(9).setCellValue(arm.getPosition());
                rows.createCell(10).setCellValue(arm.getPhone());
                rows.createCell(11).setCellValue(arm.getLogin1());
                rows.createCell(12).setCellValue(arm.getLogin2());
                rows.createCell(13).setCellValue(arm.getLogin3());
                rows.createCell(14).setCellValue(arm.getDescription());
                rows.createCell(15).setCellValue(arm.getDescription1());
                rows.createCell(16).setCellValue(arm.getDescription2());
                rows.createCell(17).setCellValue(arm.getDescription3());
                    i++;
                }
                book.write(response.getOutputStream());
                book.close();
            }else {
                response.sendRedirect("index.jsp");
            }
        }
    }
}

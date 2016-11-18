package rzd.oao.zrw.rcs2.Controllers;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import rzd.oao.zrw.rcs2.Models.ArmData;
import rzd.oao.zrw.rcs2.Models.Table;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 * Created by KuzmichevVB on 22.04.2016.
 */
public class SaveNewTableAction extends ActionSupport {
    private File fileUpload;
    private String fileUploadContentType;
    private String fileUploadFileName;
    private String name;

    public File getFileUpload() {
        return fileUpload;
    }

    public void setFileUpload(File fileUpload) {
        this.fileUpload = fileUpload;
    }

    public String getFileUploadContentType() {
        return fileUploadContentType;
    }

    public void setFileUploadContentType(String fileUploadContentType) {
        this.fileUploadContentType = fileUploadContentType;
    }

    public String getFileUploadFileName() {
        return fileUploadFileName;
    }

    public void setFileUploadFileName(String fileUploadFileName) {
        this.fileUploadFileName = fileUploadFileName;
    }

    public List<Table> getTables() {
        return tables;
    }

    public void setTables(List<Table> tables) {
        this.tables = tables;
    }

    List<Table> tables = new ArrayList<Table>();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public String execute(){
        Map session = ActionContext.getContext().getSession();
        if (!session.isEmpty()) {
            int userId = (Integer) session.get("userid");
            DataAccess.addNewTable(getName());
            tables = DataAccess.listNamesOfTables();
            int idOFCreatedTable;

            if (fileUpload != null) {
                idOFCreatedTable = DataAccess.idTable(getName());
                List<ArmData> tableFromXLS = new ArrayList<ArmData>();
                try {
                    HSSFWorkbook book = new HSSFWorkbook(new FileInputStream(fileUpload));
                    Sheet sheet = book.getSheetAt(0);
                    Iterator<Row> it = sheet.iterator();
                    if (it.hasNext()) it.next();
                    while (it.hasNext()) {
                        List<String> cellsForArmData = new ArrayList<String>();
                        Row row = it.next();
                        Iterator<Cell> cells = row.iterator();
                        String preparedCell;
                        while (cells.hasNext()) {
                            Cell cell = cells.next();
                            int cellType = cell.getCellType();
                            if (cellType == 0) {
                                preparedCell = ("" + cell.getNumericCellValue());
                                if (preparedCell.substring(preparedCell.length() - 2, preparedCell.length()).equals(".0"))
                                    preparedCell = preparedCell.substring(0, preparedCell.length() - 2);
                                cellsForArmData.add(preparedCell);
                            } else  {
                                cellsForArmData.add(cell.getStringCellValue());
                            }

                        }
                        tableFromXLS.add(new ArmData(0, cellsForArmData.get(0), cellsForArmData.get(1), cellsForArmData.get(2),
                                cellsForArmData.get(3), cellsForArmData.get(4), cellsForArmData.get(5), cellsForArmData.get(6),
                                cellsForArmData.get(7), cellsForArmData.get(8), cellsForArmData.get(9), cellsForArmData.get(10),
                                cellsForArmData.get(11), cellsForArmData.get(12), cellsForArmData.get(13), cellsForArmData.get(14),
                                cellsForArmData.get(15), cellsForArmData.get(16), cellsForArmData.get(17), idOFCreatedTable));
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
                DataAccess.addAllRows(tableFromXLS);
                DataAccess.addPermition(userId, idOFCreatedTable);
            }
        }
        return SUCCESS;
    }

}

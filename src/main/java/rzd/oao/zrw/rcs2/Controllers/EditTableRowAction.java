package rzd.oao.zrw.rcs2.Controllers;

import com.opensymphony.xwork2.ActionSupport;
import rzd.oao.zrw.rcs2.DataAccess;

import java.util.List;

/**
 * Created by KuzmichevVB on 14.03.2016.
 */
public class EditTableRowAction extends ActionSupport{
    List<String> allCells;
    int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    String tableId;

    public String getTableId() {
        return tableId;
    }

    public void setTableId(String tableId) {
        this.tableId = tableId;
    }



    public List<String> getAllCells() {
        return allCells;
    }

    public void setAllCells(List<String> allCells) {
        this.allCells = allCells;
    }

    public String execute(){
        allCells = DataAccess.viewTable(tableId).get(getId()-1).getRow();
        return SUCCESS;

    }
}

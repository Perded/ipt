package rzd.oao.zrw.rcs2.Controllers;

import com.opensymphony.xwork2.ActionSupport;
import rzd.oao.zrw.rcs2.DataAccess;
import rzd.oao.zrw.rcs2.Models.Table;
import rzd.oao.zrw.rcs2.Models.Tables;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by KuzmichevVB on 24.02.2016.
 */
public class ListTableAction extends ActionSupport {
    private String tblName;
    private String idTable;
    private String name;

    public String getTblName() {
        return tblName;
    }

    public void setTblName(String tblName) {
        this.tblName = tblName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    List<Table> lstTable = new ArrayList<Table>();

    public List<Table> getLstTable() {
        return lstTable;
    }

    public void setLstTable(List<Table> lstTable) {
        this.lstTable = lstTable;
    }

    public String getIdTable() {
        return idTable;
    }

    public void setIdTable(String idTable) {
        this.idTable = idTable;
    }


    public String execute() {
        lstTable = DataAccess.viewTable(getIdTable());
        List<Tables> lst = DataAccess.listNamesOFTables();
        tblName = lst.get(Integer.parseInt(getIdTable())-1).getName();
        return SUCCESS;
    }


}

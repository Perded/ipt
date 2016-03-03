package rzd.oao.zrw.rcs2;

import com.opensymphony.xwork2.ActionSupport;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by KuzmichevVB on 24.02.2016.
 */
public class ListTableAction extends ActionSupport {
    private String idTable;
    private String name;

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
        return SUCCESS;
    }


}

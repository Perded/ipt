package rzd.oao.zrw.rcs2.Controllers;

import com.opensymphony.xwork2.ActionSupport;

/**
 * Created by KuzmichevVB on 22.04.2016.
 */
public class SaveNameTableAction extends ActionSupport {
    private String name;
    private int tableId;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getTableId() {
        return tableId;
    }

    public void setTableId(int tableId) {
        this.tableId = tableId;
    }

    public String execute(){
        DataAccess.savenewtablename(getTableId(),getName());
        return SUCCESS;
    }
}

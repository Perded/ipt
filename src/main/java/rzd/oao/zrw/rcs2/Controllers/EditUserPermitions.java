package rzd.oao.zrw.rcs2.Controllers;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import rzd.oao.zrw.rcs2.Models.MainPermition;
import rzd.oao.zrw.rcs2.Models.Table;
import rzd.oao.zrw.rcs2.Models.TablePermition;

import java.util.*;

/**
 * Created by KuzmichevVB on 16.05.2016.
 */
public class EditUserPermitions extends ActionSupport {
    private int id;
    private Map<Table,Integer> tablesWithPermitions = new LinkedHashMap<Table, Integer>();
    private MainPermition mainPermitions;
    private List<TablePermition> tablePermitions;
    private List<Table> tables;

    public MainPermition getMainPermitions() {
        return mainPermitions;
    }

    public void setMainPermitions(MainPermition mainPermitions) {
        this.mainPermitions = mainPermitions;
    }

    public Map<Table, Integer> getTablesWithPermitions() {
        return tablesWithPermitions;
    }

    public void setTablesWithPermitions(Map<Table, Integer> tablesWithPermitions) {
        this.tablesWithPermitions = tablesWithPermitions;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String execute(){
        tables = DataAccess.listNamesOfTables();
        tablePermitions = DataAccess.getPermitions(getId());
        for (Table table: tables){
            int perm = 0;
            for (TablePermition permition: tablePermitions){
                if (Integer.parseInt(table.getId()) == permition.getTableId()) perm = permition.getPermit();
            }
            tablesWithPermitions.put(table,perm);
        }
        mainPermitions = DataAccess.getMainPermitions(getId());
        return SUCCESS;
    }
    public void validate() {
        Map session = ActionContext.getContext().getSession();
        if (!session.isEmpty()) {
            int userId = (Integer) session.get("userid");
            MainPermition mainPermition = DataAccess.getMainPermitions(userId);
            if (mainPermition.isRunsUsers()) {
            } else addActionError("(Access denied) Доступ запрещен. Переадресация...");
        }
    }

}

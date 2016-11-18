package rzd.oao.zrw.rcs2.Controllers;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import rzd.oao.zrw.rcs2.Models.MainPermition;

import java.util.Map;

/**
 * Created by KuzmichevVB on 11.05.2016.
 */
public class ListUserPermitions extends ActionSupport {
    private int id;
    private int tableid;
    private String tableName;
    private int permition;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getTableid() {
        return tableid;
    }

    public void setTableid(int tableid) {
        this.tableid = tableid;
    }

    public String getTableName() {
        return tableName;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName;
    }

    public int getPermition() {
        return permition;
    }

    public void setPermition(int permition) {
        this.permition = permition;
    }
    public String execute(){
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

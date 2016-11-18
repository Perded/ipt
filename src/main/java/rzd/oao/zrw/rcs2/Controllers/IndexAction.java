package rzd.oao.zrw.rcs2.Controllers;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import rzd.oao.zrw.rcs2.Models.Table;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by KuzmichevVB on 22.04.2016.
 */
public class IndexAction extends ActionSupport {
    private int userId;

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    private List<Table> tables = new ArrayList<Table>();

    public List<Table> getTables() {
        return tables;
    }

    public void setTables(List<Table> tables) {
        this.tables = tables;
    }

    public String execute(){
        tables = DataAccess.listNamesOfTables();
        Map session = ActionContext.getContext().getSession();
        if (!session.isEmpty()) {
            setUserId((Integer) session.get("userid"));
        }
        return SUCCESS;
    }
}

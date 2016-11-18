package rzd.oao.zrw.rcs2.Controllers;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import rzd.oao.zrw.rcs2.Models.MainPermition;

import java.util.Map;

/**
 * Created by KuzmichevVB on 19.04.2016.
 */
public class EditNewRowAction extends ActionSupport {
    private int tableId;

    public int getTableId() {
        return tableId;
    }

    public void setTableId(int tableId) {
        this.tableId = tableId;
    }

    public String execute(){
        return SUCCESS;
    }
    public void validate() {
        Map session = ActionContext.getContext().getSession();
        if (!session.isEmpty()) {
            int userId = (Integer) session.get("userid");
            int permition = DataAccess.getPermition(userId, getTableId());
            MainPermition mainPermition = DataAccess.getMainPermitions(userId);
            if (mainPermition.isEditTable() || mainPermition.isRemoveTable() || permition > 1) {
            } else addActionError("(Access denied) Доступ запрещен. Переадресация...");
        }
    }

}

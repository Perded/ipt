package rzd.oao.zrw.rcs2.Controllers;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import rzd.oao.zrw.rcs2.Models.ArmData;
import rzd.oao.zrw.rcs2.Models.MainPermition;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by KuzmichevVB on 01.04.2016.
 */
public class ViewTableAction extends ActionSupport{
    private String id;
    List<ArmData> rows;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public List<ArmData> getRows() {
        return rows;
    }

    public void setRows(ArrayList<ArmData> rows) {
        this.rows = rows;
    }

    public String execute(){
        rows = DataAccess.listIpTable(getId());
        return SUCCESS;
    }
    public void validate() {
        Map session = ActionContext.getContext().getSession();
        if (!session.isEmpty()) {
            int userId = (Integer) session.get("userid");
            int permition = DataAccess.getPermition(userId, Integer.parseInt(getId()));
            MainPermition mainPermition = DataAccess.getMainPermitions(userId);
            //if (mainPermition != null)
            if (mainPermition.isEditTable() || mainPermition.isRemoveTable() || mainPermition.isViewTable()
                    || permition > 0) {
            } else addActionError("(Access denied) Доступ запрещен. Переадресация...");
        }
    }
}

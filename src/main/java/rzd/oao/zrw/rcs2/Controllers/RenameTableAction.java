package rzd.oao.zrw.rcs2.Controllers;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.log4j.Logger;
import rzd.oao.zrw.rcs2.Models.MainPermition;

import java.util.Map;

/**
 * Created by KuzmichevVB on 22.04.2016.
 */
public class RenameTableAction extends ActionSupport {
    private static final Logger log = Logger.getLogger(RenameTableAction.class.getName());
    private String name;
    private int tableId;

    public int getTableId() {
        return tableId;
    }

    public void setTableId(int tableId) {
        this.tableId = tableId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String execute(){
        return SUCCESS;
    }

    public void validate(){
        Map session = ActionContext.getContext().getSession();
        if (!session.isEmpty()) {
            int userId = (Integer) session.get("userid");
            int permition = DataAccess.getPermition(userId, getTableId());
            MainPermition mainPermition = DataAccess.getMainPermitions(userId);
            if (mainPermition.isEditTable() || mainPermition.isRemoveTable() || permition >= 2) {
            } else {
                addActionError("(Access denied) Доступ запрещен. Переадресация...");
                log.info("Недостаточно полномочий для редактирования таблицы(" + getTableId() + ").");
            }
        }
    }

}

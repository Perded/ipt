package rzd.oao.zrw.rcs2.Controllers;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.log4j.Logger;
import rzd.oao.zrw.rcs2.Models.MainPermition;

import java.util.Map;

/**
 * Created by KuzmichevVB on 19.04.2016.
 */
public class DeleteAction extends ActionSupport {
    private static final Logger log = Logger.getLogger(DeleteAction.class.getName());
    private int rowId;
    private int tableId;

    public int getTableId() {
        return tableId;
    }

    public void setTableId(int tableId) {
        this.tableId = tableId;
    }

    public int getRowId() {
        return rowId;
    }

    public void setRowId(int rowId) {
        this.rowId = rowId;
    }

    public String execute(){
        log.info("удаление записи(" + getRowId() + ").");
        DataAccess.deleteRow(getRowId());
        log.info("Запись удалена(" + getRowId() + ").");
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

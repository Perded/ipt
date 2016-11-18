package rzd.oao.zrw.rcs2.Controllers;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.log4j.Logger;

import java.util.List;
import java.util.Map;

/**
 * Created by KuzmichevVB on 15.04.2016.
 */
public class EditAction extends ActionSupport{
    private static final Logger log = Logger.getLogger(EditAction.class.getName());
    private List<String> row;
    private int rowId;
    private int tableId;

    public List<String> getRow() {
        return row;
    }

    public void setRow(List<String> row) {
        this.row = row;
    }

    public int getRowId() {
        return rowId;
    }

    public void setRowId(int rowId) {
        this.rowId = rowId;
    }

    public int getTableId() {
        return tableId;
    }

    public void setTableId(int tableId) {
        this.tableId = tableId;
    }

    public String execute(){
        row = DataAccess.listRow(rowId);
        log.info("Редактирование таблицы(" + getTableId() + ").");
        return SUCCESS;
    }
    public void validate(){
        Map session = ActionContext.getContext().getSession();
        if (!session.isEmpty()) {
            int userId = (Integer) session.get("userid");
            int permition = DataAccess.getPermition(userId, getTableId());
            if (permition >= 2) {
            } else {
                addActionError("(Access denied) Доступ запрещен. Переадресация...");
                log.info("Недостаточно полномочий для редактирования таблицы(" + getTableId() + ").");
            }
        }
    }

}

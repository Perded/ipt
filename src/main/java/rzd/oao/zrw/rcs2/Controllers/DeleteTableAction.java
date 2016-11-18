package rzd.oao.zrw.rcs2.Controllers;

import com.opensymphony.xwork2.ActionSupport;
import org.apache.log4j.Logger;
import rzd.oao.zrw.rcs2.Models.MainPermition;

/**
 * Created by KuzmichevVB on 26.04.2016.
 */
public class DeleteTableAction extends ActionSupport{
    private static final Logger log = Logger.getLogger(DeleteTableAction.class.getName());
    private int userId;
    private int tableId;

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getTableId() {
        return tableId;
    }

    public void setTableId(int tableId) {
        this.tableId = tableId;
    }

    public String execute(){
        return SUCCESS;
    }
    public void validate(){
        log.info("Удаление таблицы(" + getTableId() + ").");
        int permition = DataAccess.getPermition(getUserId(), getTableId());
        MainPermition mainPermition = DataAccess.getMainPermitions(getUserId());
        if (mainPermition != null) {
            if (mainPermition.isRemoveTable() || permition == 3) {
                DataAccess.deleteTable(getTableId());
                log.info("Удалена таблица(" + getTableId() + ").");
                DataAccess.deletePermition(getUserId(), getTableId());
            }
        }
/*        if (mainPermition != null && mainPermition.isRemoveTable()) {
            DataAccess.deleteTable(getTableId());
            log.info("Удалена таблица(" + getTableId() + ").");
        }else if (permition == 3){
            DataAccess.deleteTable(getTableId());
            log.info("Удалена таблица(" + getTableId() + ").");
        }*/
        else{
            addActionError("(Access denied) Доступ запрещен. Переадресация...");
            log.info("Недостаточно прав для удаления таблицы(" + getTableId() + ").");

        }
    }
}

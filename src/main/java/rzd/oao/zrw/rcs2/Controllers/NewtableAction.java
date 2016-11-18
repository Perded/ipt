package rzd.oao.zrw.rcs2.Controllers;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import rzd.oao.zrw.rcs2.Models.MainPermition;

import java.util.Map;

/**
 * Created by KuzmichevVB on 22.04.2016.
 */
public class NewtableAction extends ActionSupport {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String execute(){
        return SUCCESS;
    }
    public void validate() {
        Map session = ActionContext.getContext().getSession();
        if (!session.isEmpty()) {
            int userId = (Integer) session.get("userid");
            MainPermition mainPermition = DataAccess.getMainPermitions(userId);
            if (mainPermition.isAddTable()) {
            } else addActionError("(Access denied) Доступ запрещен. Переадресация...");
        }
    }

}

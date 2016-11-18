package rzd.oao.zrw.rcs2.Controllers;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import rzd.oao.zrw.rcs2.Models.MainPermition;
import rzd.oao.zrw.rcs2.Models.User;

import java.util.List;
import java.util.Map;

/**
 * Created by KuzmichevVB on 28.04.2016.
 */
public class ListUsersAction extends ActionSupport {
    private List<User> allUsers;

    public List<User> getAllUsers() {
        return allUsers;
    }

    public void setAllUsers(List<User> allUsers) {
        this.allUsers = allUsers;
    }

    public String execute(){
        allUsers = DataAccess.listUsers();
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

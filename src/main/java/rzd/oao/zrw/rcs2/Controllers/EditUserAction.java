package rzd.oao.zrw.rcs2.Controllers;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import rzd.oao.zrw.rcs2.Models.MainPermition;
import rzd.oao.zrw.rcs2.Models.User;

import java.util.Map;

/**
 * Created by KuzmichevVB on 10.05.2016.
 */
public class EditUserAction extends ActionSupport {
    private int id;
    private String userName;
    private String password;
    private String fio;
    private String position;
    private String department;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFio() {
        return fio;
    }

    public void setFio(String fio) {
        this.fio = fio;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String execute(){
        User fieldsUser;
        fieldsUser = DataAccess.listUserForId(getId());
        setUserName(fieldsUser.getUserName());
        setPassword(fieldsUser.getPassword());
        setFio(fieldsUser.getFio());
        setPosition(fieldsUser.getPosition());
        setDepartment(fieldsUser.getDepartment());
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

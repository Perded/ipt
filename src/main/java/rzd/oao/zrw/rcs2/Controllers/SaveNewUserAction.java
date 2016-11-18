package rzd.oao.zrw.rcs2.Controllers;

import com.opensymphony.xwork2.ActionSupport;

/**
 * Created by KuzmichevVB on 10.05.2016.
 */
public class SaveNewUserAction extends ActionSupport {
    private int userId;
    private String userName;
    private String password;
    private String confirm;
    private String fio;
    private String position;
    private String department;

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
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

    public String getConfirm() {
        return confirm;
    }

    public void setConfirm(String confirm) {
        this.confirm = confirm;
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
        boolean saved;
        saved = DataAccess.addUser(getUserName(), getPassword(), getFio(), getPosition(), getDepartment());
        setUserId(DataAccess.getUserId(getUserName()));
       // System.out.println(getUserId());
        DataAccess.addMainPermitions(getUserId());
        return SUCCESS;
    }
}

package rzd.oao.zrw.rcs2.Controllers;

import com.opensymphony.xwork2.ActionSupport;

/**
 * Created by KuzmichevVB on 11.05.2016.
 */
public class SaveUserAction extends ActionSupport {
    private int id;
    private String userName;
    private String password;
    private String confirm;
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
        DataAccess.saveUser(getId(), getUserName(), getPassword(), getFio(), getPosition(), getDepartment());
        return SUCCESS;
    }
    public void validate(){
        if (fio.length() > 50 || position.length() > 50 || department.length() > 50 ||
            password.length() > 15 || confirm.length() > 15 ){
            addActionError("Превышена максимальная длина строки ввода.");
        }else if (password.equals(confirm)) {
        } else addActionError("Пароли не совпадают.");
    }
}

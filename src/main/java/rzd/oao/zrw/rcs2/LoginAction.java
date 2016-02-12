package rzd.oao.zrw.rcs2;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import java.util.Date;
import java.util.Map;

public class LoginAction extends ActionSupport{
    private String userName;
    private String password;

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

    public String execute() {
        //if ("Admin".equals(getUserName()) || "1234".equals(getPassword())) {
        DatabaseConnector connector = new DatabaseConnector();
        connector.connect();
        if (connector.checkUser(getUserName(), getPassword())){
            Map session = ActionContext.getContext().getSession();
            session.put("login","true");
            session.put("context", new Date());
            return SUCCESS;
        }else {
              return INPUT;
        }
    }
    public void validate() {
//        if ("Admin".equals(getUserName()) || "1234".equals(getPassword())){
//        }else addActionError("Incorrect Login or Password");
        DatabaseConnector connector = new DatabaseConnector();
        connector.connect();
        if (connector.checkUser(getUserName(), getPassword())){

        }else{
            addActionError("Неверный логин или пароль");
        }

    }

}

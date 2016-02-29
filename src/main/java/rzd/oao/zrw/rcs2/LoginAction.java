package rzd.oao.zrw.rcs2;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * Created by KuzmichevVB on 16.02.2016.
 */
public class LoginAction extends ActionSupport {
    private String userName;
    private String password;
    List<Tables> tables = new ArrayList<Tables>();

    public List<Tables> getTables() {
        return tables;
    }

    public void setTables(List<Tables> tables) {
        this.tables = tables;
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


    public String execute() {
        tables = DataAccess.listNamesOFTables();
        return SUCCESS;
    }
    public void validate() {
        if (DataAccess.checkUser(getUserName(), getPassword())){
            Map session = ActionContext.getContext().getSession();
            session.put("login","true");
            session.put("context", new Date());
        }else{
            addActionError("Неверный логин или пароль");
        }
    }

}

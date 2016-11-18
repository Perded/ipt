package rzd.oao.zrw.rcs2.Controllers;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.log4j.Logger;
import rzd.oao.zrw.rcs2.Models.Table;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * Created by KuzmichevVB on 16.02.2016.
 */
public class LoginAction extends ActionSupport {
    private static final Logger log = Logger.getLogger(LoginAction.class.getName());
    private int userId;
    private String userName;
    private String password;
    private Map<Integer,Integer> permitions;

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public Map<Integer, Integer> getPermitions() {
        return permitions;
    }

    public void setPermitions(Map<Integer, Integer> permitions) {
        this.permitions = permitions;
    }

    public void setTables(List<Table> tables) {
        this.tables = tables;
    }

    List<Table> tables = new ArrayList<Table>();

    public List<Table> getTables() {
        return tables;
    }

    public void setTables(ArrayList<Table> tables) {
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
        tables = DataAccess.listNamesOfTables();
        return SUCCESS;

    }
    public void validate() {
        setUserId(DataAccess.getUserId(getUserName()));
        if (DataAccess.checkUser(getUserName(), getPassword())){
            Map session = ActionContext.getContext().getSession();
            permitions = DataAccess.listPermitions(DataAccess.getUserId(getUserName()));
            session.put("login","true");
            session.put("context", new Date());
            session.put("userid", getUserId());

            log.info("Пользователь " + getUserName() + " успешно авторизован.");
        }else{
            addActionError("Неверный логин или пароль");
            log.error("Неверный логин или пароль (" + getUserName() + ").");
        }
    }

}

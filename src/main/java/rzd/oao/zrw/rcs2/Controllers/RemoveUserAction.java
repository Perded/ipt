package rzd.oao.zrw.rcs2.Controllers;

import com.opensymphony.xwork2.ActionSupport;

/**
 * Created by KuzmichevVB on 06.05.2016.
 */
public class RemoveUserAction extends ActionSupport {
    private int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    public String execute(){
        if (getId() != 5)
        DataAccess.removeUser(getId());
        return SUCCESS;
    }
}

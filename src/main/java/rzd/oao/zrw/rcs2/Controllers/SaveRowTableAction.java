package rzd.oao.zrw.rcs2.Controllers;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import java.util.List;
import java.util.Map;

/**
 * Created by KuzmichevVB on 17.03.2016.
 */
public class SaveRowTableAction extends ActionSupport{
    private List<String> row;
    private String id;
    private String[] parameters;

    public String[] getParameters() {
        return parameters;
    }

    public void setParameters(String[] parameters) {
        this.parameters = parameters;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public List<String> getRow() {
        return row;
    }

    public void setRow(List<String> row) {
        this.row = row;
    }


    public String execute(){
       /*  Getting request params from ActionContext, sort it and put it into  *
        *  the array                                                           */
        Map<String,Object> stack = ActionContext.getContext().getParameters();
        String[] params = new String[stack.entrySet().size()-1];
        int i = stack.entrySet().size()-2;
        for(Map.Entry pare: stack.entrySet()){
            params[i] = ((String[]) pare.getValue())[0];
            if("id".equals(pare.getKey())) {
                setId(((String[]) pare.getValue())[0]);
            }else {
                params[i] = ((String[]) pare.getValue())[0];
                --i;
            }
        }
        setParameters(params);
        return SUCCESS;
    }
}

package rzd.oao.zrw.rcs2.Controllers;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import rzd.oao.zrw.rcs2.Models.ArmData;
import rzd.oao.zrw.rcs2.Models.MainPermition;

import java.util.List;
import java.util.Map;

/**
 * Created by KuzmichevVB on 10.06.2016.
 */
public class SearchAction extends ActionSupport {
    private String searchContent;
    private List<ArmData> results;
    private List<String> tableNames;
    private String noFind;

    public List<String> getTableNames() {
        return tableNames;
    }

    public void setTableNames(List<String> tableNames) {
        this.tableNames = tableNames;
    }

    public String getNoFind() {
        return noFind;
    }

    public void setNoFind(String noFind) {
        this.noFind = noFind;
    }

    public List<ArmData> getResults() {
        return results;
    }

    public void setResults(List<ArmData> results) {
        this.results = results;
    }

    public String getSearchContent() {
        return searchContent;
    }

    public void setSearchContent(String searchContent) {
        this.searchContent = searchContent;
    }

    public String execute(){
        if (searchContent != null){

            try {
                Map session = ActionContext.getContext().getSession();
                if (!session.isEmpty()) {
                    int userId = (Integer) session.get("userid");
                    MainPermition mainPermition = DataAccess.getMainPermitions(userId);
                    System.out.println(mainPermition.getUserId());
                    System.out.println(userId);
                    if (mainPermition.isViewTable() || mainPermition.isEditTable() || mainPermition.isRemoveTable()) results = DataAccess.searchWholeContent(getSearchContent());
                    else results = DataAccess.searchContent(getSearchContent(), userId);
                    if (results.size() != 0){
                        setNoFind("Результат поиска: " + results.size() + " (100 макс.)");
                    }
                    else setNoFind("Результат поиска: " + results.size());
                }
            }catch (Exception e){
            }

        }
        return SUCCESS;
    }

}

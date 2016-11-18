package rzd.oao.zrw.rcs2.Models;

/**
 * Created by KuzmichevVB on 16.05.2016.
 */
public class TablePermition {
    private int userId;
    private int tableId;
    private String tableName;
    private int permit;

    public TablePermition(int userId, int tableId, String tableName, int permit) {
        this.userId = userId;
        this.tableId = tableId;
        this.tableName = tableName;
        this.permit = permit;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getTableId() {
        return tableId;
    }

    public void setTableId(int tableId) {
        this.tableId = tableId;
    }

    public String getTableName() {
        return tableName;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName;
    }

    public int getPermit() {
        return permit;
    }

    public void setPermit(int permit) {
        this.permit = permit;
    }
}

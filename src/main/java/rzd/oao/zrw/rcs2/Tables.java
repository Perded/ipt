package rzd.oao.zrw.rcs2;

public class Tables {
    private String id;
    private String name;
    private String tableName;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTableName() {
        return tableName;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName;
    }

    public Tables(String id, String name, String tableName) {
        this.id = id;
        this.name = name;
        this.tableName = tableName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}

package rzd.oao.zrw.rcs2;

import java.util.List;

/**
 * Created by KuzmichevVB on 19.02.2016.
 */
public class Table {
    private List<String> row;

    public List<String> getRow() {
        return row;
    }

    public void setRow(List<String> row) {
        this.row = row;
    }

    public Table(List<String> row) {
        this.row = row;
    }
}

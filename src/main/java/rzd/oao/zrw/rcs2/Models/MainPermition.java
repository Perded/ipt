package rzd.oao.zrw.rcs2.Models;

/**
 * Created by KuzmichevVB on 20.05.2016.
 */
public class MainPermition {
    private int userId;
    private boolean addTable;
    private boolean removeTable;
    private boolean runsUsers;
    private boolean viewTable;
    private boolean editTable;

    public MainPermition(int userId, boolean addTable, boolean removeTable, boolean runsUsers, boolean viewTable, boolean editTable) {
        this.userId = userId;
        this.addTable = addTable;
        this.removeTable = removeTable;
        this.runsUsers = runsUsers;
        this.viewTable = viewTable;
        this.editTable = editTable;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public boolean isAddTable() {
        return addTable;
    }

    public void setAddTable(boolean addTable) {
        this.addTable = addTable;
    }

    public boolean isRemoveTable() {
        return removeTable;
    }

    public void setRemoveTable(boolean removeTable) {
        this.removeTable = removeTable;
    }

    public boolean isRunsUsers() {
        return runsUsers;
    }

    public void setRunsUsers(boolean runsUsers) {
        this.runsUsers = runsUsers;
    }

    public boolean isViewTable() {
        return viewTable;
    }

    public void setViewTable(boolean viewTable) {
        this.viewTable = viewTable;
    }

    public boolean isEditTable() {
        return editTable;
    }

    public void setEditTable(boolean editTable) {
        this.editTable = editTable;
    }
}


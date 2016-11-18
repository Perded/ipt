package rzd.oao.zrw.rcs2.Models;

/**
 * Created by KuzmichevVB on 28.04.2016.
 */
public class User {
    private int id;
    private String userName;
    private String password;
    private String fio;
    private String position;
    private String department;

    public User(int id, String userName, String password, String fio, String position, String department) {
        this.id = id;
        this.userName = userName;
        this.password = password;
        this.fio = fio;
        this.position = position;
        this.department = department;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public String getFio() {
        return fio;
    }

    public void setFio(String fio) {
        this.fio = fio;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }
}

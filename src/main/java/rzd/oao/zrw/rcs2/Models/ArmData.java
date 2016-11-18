package rzd.oao.zrw.rcs2.Models;

/**
 * Created by KuzmichevVB on 01.04.2016.
 */
public class ArmData {
    private int rowId;
    private String station;
    private String place;
    private String panel;
    private String port;
    private String ip;
    private String cname;
    private String type;
    private String department;
    private String fio;
    private String position;
    private String phone;
    private String login1;
    private String login2;
    private String login3;
    private String description;
    private String description1;
    private String description2;
    private String description3;
    private int tableId;

    public ArmData() {

    }

    public ArmData(int rowId, String station, String place, String panel, String port, String ip, String cname, String type, String department, String fio, String position, String phone, String login1, String login2, String login3, String description, String description1, String description2, String description3, int tableId) {
        this.rowId = rowId;
        this.station = station;
        this.place = place;
        this.panel = panel;
        this.port = port;
        this.ip = ip;
        this.cname = cname;
        this.type = type;
        this.department = department;
        this.fio = fio;
        this.position = position;
        this.phone = phone;
        this.login1 = login1;
        this.login2 = login2;
        this.login3 = login3;
        this.description = description;
        this.description1 = description1;
        this.description2 = description2;
        this.description3 = description3;
        this.tableId = tableId;
    }

    public int getRowId() {
        return rowId;
    }

    public void setRowId(int rowId) {
        this.rowId = rowId;
    }

    public String getStation() {
        return station;
    }

    public void setStation(String station) {
        this.station = station;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public String getPanel() {
        return panel;
    }

    public void setPanel(String panel) {
        this.panel = panel;
    }

    public String getPort() {
        return port;
    }

    public void setPort(String port) {
        this.port = port;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
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

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getLogin1() {
        return login1;
    }

    public void setLogin1(String login1) {
        this.login1 = login1;
    }

    public String getLogin2() {
        return login2;
    }

    public void setLogin2(String login2) {
        this.login2 = login2;
    }

    public String getLogin3() {
        return login3;
    }

    public void setLogin3(String login3) {
        this.login3 = login3;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDescription1() {
        return description1;
    }

    public void setDescription1(String description1) {
        this.description1 = description1;
    }

    public String getDescription2() {
        return description2;
    }

    public void setDescription2(String description2) {
        this.description2 = description2;
    }

    public String getDescription3() {
        return description3;
    }

    public void setDescription3(String description3) {
        this.description3 = description3;
    }

    public int getTableId() {
        return tableId;
    }

    public void setTableId(int tableId) {
        this.tableId = tableId;
    }
}

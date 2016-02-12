package rzd.oao.zrw.rcs2;

/**
 * Created by KuzmichevVB on 10.02.2016.
 */
public class User {
    private String login;
    private String password;


    public User(String login, String password) {
        this.login = login;
        this.password = password;
    }

    public boolean checkUser(){
        return true;
    }
}

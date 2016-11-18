package rzd.oao.zrw.rcs2.Controllers;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by KuzmichevVB on 24.05.2016.
 */

public class SavePermitionsServlet extends HttpServlet {
    private int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Map<String, String> params = request.getParameterMap();
        Map<Integer, Integer> permitions = new HashMap<Integer, Integer>();
        Map<String, Integer> mainPermitions = new HashMap<String, Integer>();

        for (Map.Entry pare: params.entrySet()){
            if (pare.getKey().equals("id")) setId(Integer.parseInt(request.getParameter((String) pare.getKey())));
            else if (((String)pare.getKey()).substring(0,1).equals("p")) permitions.put(Integer.parseInt(((String) pare.getKey()).substring(1)), Integer.parseInt(request.getParameter((String) pare.getKey())));
            else mainPermitions.put((String) pare.getKey(),1);
        }
        DataAccess.setPermitions(getId(), permitions, mainPermitions);
//        System.out.println(getId());
//        for (Map.Entry pare: permitions.entrySet()){
//            System.out.println(pare.getKey() + " " + pare.getValue());
//        }
//        for (Map.Entry pare: mainPermitions.entrySet()){
//            System.out.println(pare.getKey() + " " + pare.getValue());
//        }
        response.sendRedirect("saveuser.jsp");
    }

}

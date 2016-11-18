package rzd.oao.zrw.rcs2.Controllers;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Created by KuzmichevVB on 31.05.2016.
 */
@WebServlet(name = "LogoutServlet")
public class LogoutServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession newsession = request.getSession(false);
        if (newsession != null)
        {
            newsession.invalidate();

        }

        response.sendRedirect("/login.jsp");
    }
}

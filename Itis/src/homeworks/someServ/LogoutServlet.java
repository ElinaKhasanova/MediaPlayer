package someServ;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

public class LogoutServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();

        HttpSession session = req.getSession(false);

        if (session != null){
            String s = (String)session.getAttribute("email");
            out.print("This is profile " + s);
        }
        else {
            out.print("LOG IN, PLEASE :)))");
            req.getRequestDispatcher("state.html").forward(req, resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        resp.setContentType("text/html");
//        PrintWriter out = resp.getWriter();

//        session.invalidate();
//        out.print("Bye!");
//        out.close();
//        req.setAttribute("out", "Bye!");

        HttpSession session = req.getSession();
        session.invalidate();
        req.getRequestDispatcher("/WEB-INF/welcome.jsp").forward(req, resp);
    }
}

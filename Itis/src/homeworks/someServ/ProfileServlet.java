package someServ;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class ProfileServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();

        req.getRequestDispatcher("state.html").forward(req, resp);

//        HttpSession session = req.getSession(false);
//
//        if (session != null){
//            String email = req.getParameter("email");
//            out.print("This is profile" + email);
//        }
//        else {
//            out.print("LOG IN, PLEASE :)))");
//            req.getRequestDispatcher("state.html").forward(req, resp);
//        }
        out.close();

    }
}

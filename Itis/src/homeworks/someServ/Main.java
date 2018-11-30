package someServ;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class Main extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher view = req.getRequestDispatcher("index.jsp");
        view.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String email = req.getParameter("email");

        resp.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = resp.getWriter()) {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet</title>");
            out.println("</head>");
            out.println("<body>");
            if (email != null && validate(email)) {
                out.println("<h1>Data is valide</h1>");
                System.out.println("jshfsfknmd,fm");
            } else {
                out.println("<h1>Data is not valide</h1>");
                System.out.println("11111");
            }
            out.println("</body>");
            out.println("</html>");
        }
    }

    boolean validate(String email) {
        String pattern = "^[0-9a-zA-Z]+@[a-z]+\\.+[ru|com]";
        return email.matches(pattern);
    }
}

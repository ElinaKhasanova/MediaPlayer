package servlets;

import entities.User;
import services.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    private UserService userService;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/WEB-INF/jsp/signIn.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String login = req.getParameter("u");
        String password = req.getParameter("p");
        try{
            User user = userService.signIn(login, password);
            HttpSession session = req.getSession();
            session.setAttribute("user", user);
            resp.sendRedirect(getServletContext().getContextPath()+"/main");
        }
        catch (IllegalArgumentException e){
            req.setAttribute("message", e.getMessage());
        }
    }
}

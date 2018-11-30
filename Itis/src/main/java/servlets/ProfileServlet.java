package servlets;

import entities.User;
import services.UserService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.time.LocalDate;

public class ProfileServlet extends HttpServlet {

    UserService userService;
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/WEB-INF/jsp/profile.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String first_name = req.getParameter("first_name");
        String last_name = req.getParameter("last_name");
        String login = req.getParameter("login");
        String password = req.getParameter("password");
        LocalDate date = LocalDate.parse(req.getParameter("date"));
        HttpSession session = req.getSession();
        User user = (User) session.getAttribute("user");

        userService.update(first_name, last_name,login,password, date, user.getId());
    }
}

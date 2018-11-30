package servlets;

import com.opencsv.CSVWriter;
import entities.User;
import lombok.SneakyThrows;
import repozitories.UserRepoImpl;
import services.UserService;
import services.UserServiceImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.Date;

@WebServlet("/registration")
public class RegistrationServlet extends HttpServlet {

    private UserService userService;

    @Override
    public void init(ServletConfig config) throws ServletException {
        ServletContext context = config.getServletContext();
        userService = (UserService)context.getAttribute("userService");
    }


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/WEB-INF/jsp/registration.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String first_name = req.getParameter("first_name");
        String last_name = req.getParameter("last_name");
        String login = req.getParameter("login");
        String password = req.getParameter("password");
        String password_rep = req.getParameter("pas_check");
        String[] date = req.getParameter("date").split("-");
        LocalDate localDate = LocalDate.of(Integer.valueOf(date[0]), Integer.valueOf(date[1]), Integer.valueOf(date[2]));

        userService.signUp(first_name,last_name, login, password, localDate);
        resp.sendRedirect(getServletContext().getContextPath() + "/login");
    }
}

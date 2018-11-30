package someServ;

import dateTime.Time;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class TimeTagServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/WEB-INF/eventDateTime.jsp");
        resp.setCharacterEncoding("utf-8");
        requestDispatcher.forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String inputDate = req.getParameter("date");
        req.setAttribute("date_input", inputDate);

        Time time = new Time(inputDate);
        time.calculatePastTime();

        req.setAttribute("answer", time.pastTimeToString());
        req.setAttribute("dt", inputDate);
        req.getRequestDispatcher("/WEB-INF/eventDateTime.jsp").forward(req, resp);
    }
}

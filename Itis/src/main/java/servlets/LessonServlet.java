package servlets;


import entities.User;
import org.json.simple.JSONObject;
import services.LessonService;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/timetable")
public class LessonServlet extends HttpServlet {

    private LessonService lessonService;

    @Override
    public void init(ServletConfig config) throws ServletException {
        ServletContext context = config.getServletContext();
        lessonService = (LessonService)context.getAttribute("lessonService");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        User user = (User) req.getSession().getAttribute("user");
        req.setAttribute("user", user);
        if(user != null){
            req.setAttribute("lessons", lessonService.getAllLessons());
            req.getRequestDispatcher("/WEB-INF/jsp/lesson.jsp").forward(req,resp);
        }
        else{
            resp.setStatus(403);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        User user = (User) req.getSession().getAttribute("user");
        Long lessonId = Long.valueOf(req.getParameter("lessonId"));
        lessonService.saveLessonOfUser(user, lessonId);

        JSONObject json = new JSONObject();
        resp.setContentType("application/json");
        resp.getWriter().write(json.toJSONString());
    }
}

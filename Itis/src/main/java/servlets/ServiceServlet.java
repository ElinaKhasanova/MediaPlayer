package servlets;


import services.ServiceService;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet("/services")
public class ServiceServlet extends HttpServlet {

    private ServiceService serviceService;

    @Override
    public void init(ServletConfig config) throws ServletException {
        ServletContext  context = config.getServletContext();
        serviceService = (ServiceService)context.getAttribute("serviceService");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/WEB-INF/jsp/services.jsp").forward(req, resp);
    }
}

package context;

import lombok.SneakyThrows;
import repozitories.LessonRepoImpl;
import repozitories.ServiceRepoImpl;
import services.LessonService;
import services.LessonServiceImpl;
import services.ServiceService;
import services.ServiceServiceImpl;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import java.sql.Connection;
import java.sql.DriverManager;

public class ServiceServiceListener implements ServletContextListener {
    private static final String USERNAME = "root";
    private static final String PASSWORD = "zx99";
    private static final String URL = "jdbc:mysql://localhost:3306/semester?useSSL=false&allowPublicKeyRetrieval=true&useTimezone=true&serverTimezone=GMT";

    @Override
    @SneakyThrows
    public void contextInitialized(ServletContextEvent sce) {
        Class.forName("com.mysql.jdbc.Driver");
        Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);

        ServiceRepoImpl serviceRepo = new ServiceRepoImpl(connection);
        ServiceService serviceService = new ServiceServiceImpl(serviceRepo);
        ServletContext context = sce.getServletContext();
        context.setAttribute("serviceService", serviceService);
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {

    }
}

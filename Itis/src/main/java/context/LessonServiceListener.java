package context;

import lombok.SneakyThrows;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import repozitories.LessonRepoImpl;
import repozitories.UserRepoImpl;
import services.LessonService;
import services.LessonServiceImpl;
import services.UserService;
import services.UserServiceImpl;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import java.sql.Connection;
import java.sql.DriverManager;

public class LessonServiceListener implements ServletContextListener {
    private static final String USERNAME = "root";
    private static final String PASSWORD = "zx99";
    private static final String URL = "jdbc:mysql://localhost:3306/semester?useSSL=false&allowPublicKeyRetrieval=true&useTimezone=true&serverTimezone=GMT";

    @Override
    @SneakyThrows
    public void contextInitialized(ServletContextEvent sce) {
        Class.forName("com.mysql.jdbc.Driver");
        Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);

        LessonRepoImpl lessonRepo = new LessonRepoImpl(connection);
        LessonService lessonService = new LessonServiceImpl(lessonRepo);
        ServletContext context = sce.getServletContext();
        context.setAttribute("lessonService", lessonService);
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {

    }
}

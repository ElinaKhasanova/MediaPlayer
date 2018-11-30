//package someServ;
//
//import objects.User;
//import objects.UserForm;
//import repo.UserRepoImpl;
//import repo.UserService;
//
//import javax.servlet.ServletException;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import java.io.IOException;
//import java.sql.Connection;
//import java.sql.DriverManager;
//
//public class SignUpServlet extends HttpServlet {
//    private UserService userService;
//    @Override
//    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        req.getRequestDispatcher("repo.jsp").forward(req, resp);    }
//
//    @Override
//    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//
////        String name = req.getParameter("name");
////        String date = req.getParameter("date");
////        String age = req.getParameter("age");
////        User u = new User();
////        UserForm userForm = new UserForm()
////        u.setLogin(login);
////        Connection c = DriverManager.getConnection("");//put to repo, not servlet
////        UserRepoImpl userRepo = new UserRepoImpl(c);
////        userRepo.add(u);
////
////        userService.signUp();
//    }
//}

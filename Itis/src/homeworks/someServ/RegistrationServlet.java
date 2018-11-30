//
//import com.opencsv.CSVWriter;
//
//import javax.servlet.RequestDispatcher;
//import javax.servlet.ServletException;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import java.io.FileWriter;
//import java.io.IOException;
//
//public class RegistrationServlet extends HttpServlet {
//    @Override
//    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        RequestDispatcher requestDispatcher = req.getRequestDispatcher("registration.jsp");
//        requestDispatcher.forward(req, resp);
//    }
//
//    @Override
//    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        String email = req.getParameter("email");
//        String password = req.getParameter("password");
//        String password_rep = req.getParameter("password_rep");
//        String country = req.getParameter("country");
//        String gender = req.getParameter("gender");
//        String date_birth = req.getParameter("date");
//        String subscribe = req.getParameter("subscribe");
//        String consent = req.getParameter("consent");
//
//        boolean valid = true;
//        valid = valid && valideEmail(email, req);
//        valid = valid && validePassword(password, req) && valideRepPassword(password, password_rep, req);
//        valid = valid && valideConsent(consent, req);
//
//        if (valid){
//            String csv = "C:\\Users\\Elina\\Documents\\database.txt";
//            FileWriter fw = new FileWriter(csv, true);
//            CSVWriter csvWriter = new CSVWriter(fw);
//            String [] database = new String[]{email, password, password_rep, country.equals("") ? "null" : country,
//                    gender, date_birth.equals("") ? "null" : date_birth, subscribe.equals("") ? "false" : "true",
//                    consent};
//            csvWriter.writeNext(database);
//            csvWriter.close();
//
//            req.getRequestDispatcher("answer.jsp").forward(req,resp);
//
//        } else{
//            req.setAttribute("email", email);
//            req.setAttribute("country", country);
//            req.setAttribute("gender", gender);
//            req.setAttribute("date_birth", date_birth);
//            req.setAttribute("subscribe", subscribe);
//            req.setAttribute("consent", consent);
//
//            req.getRequestDispatcher("registration.jsp").forward(req,resp);
//
//        }
//
//    }
//
//    private boolean valideEmail(String email, HttpServletRequest request){
//        String pattern = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@" +
//                "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
//        if (!(email.matches(pattern))){
//            System.out.println("email is not valide");
//            request.setAttribute("email_error", "Некорректный email");
//            return false;
//        }
//        return true;
//    }
//
//    private boolean validePassword(String password, HttpServletRequest request){
//        if (password.length() < 5){
//            System.out.println("password is not valide");
//            request.setAttribute("pass_error", "Длина пароля меньше 5 символов");
//            return false;
//        }
//        return true;
//    }
//
//    private boolean valideRepPassword(String passOne, String passTwo, HttpServletRequest request){
//        if (!(passOne.equals(passTwo))){
//            System.out.println("RepPassword is not valide");
//            request.setAttribute("pass_rep_error", "Пароли не совпадают");
//            return false;
//        }
//        return true;
//    }
//
//    private boolean valideConsent(String consent, HttpServletRequest request){
//        if (consent == null){
//            System.out.println("Consent");
//            request.setAttribute("consent_error", "Вы должны принять соглашение");
//            return false;
//        }
//        return true;
//    }
//
//
//}

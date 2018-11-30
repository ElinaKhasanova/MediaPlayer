package someServ;

import com.opencsv.CSVReader;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.FileReader;
import java.io.IOException;

public class LoginServletCk extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


        Cookie login = null;
        Cookie loginCode = null;

        Cookie[] cookies = req.getCookies();
        for (Cookie cookie : cookies) {
            if (cookie.getName().equals("user")) login = cookie;
            if (cookie.getName().equals("userCode")) loginCode = cookie;
        }

        if (codeLogin(login.getValue()).equals(loginCode.getValue())){
            req.setAttribute("login", login.getValue());
            req.getRequestDispatcher("in.jsp").forward(req, resp);
        }
        else {
            req.getRequestDispatcher("autorization.jsp").forward(req, resp);
        }
    }


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String[] nextLine;
        String[] data;

        String email = req.getParameter("email_auto");
        String password = req.getParameter("password_auto");

        String csv = "C:\\Users\\Elina\\Documents\\database.txt";
        CSVReader csvReader = new CSVReader(new FileReader(csv));

        while ((nextLine = csvReader.readNext()) != null) {
            data = nextLine;

            if (email.equals(data[0]) && password.equals(data[1])){
                Cookie loginCookie = new Cookie("user", email);
                Cookie loginCodeCookie = new Cookie("userCode", codeLogin(email));

                resp.addCookie(loginCookie);
                resp.addCookie(loginCodeCookie);

                req.setAttribute("login", email);
                req.getRequestDispatcher("in.jsp").forward(req,resp);
            } else {
                req.setAttribute("email_auto_req", email);
            }
        }
        req.getRequestDispatcher("report.tag").forward(req, resp);
        csvReader.close();
    }

    private String codeLogin(String login) {
        login = login.concat("12345");
        return login;
    }
}
